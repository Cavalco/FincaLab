/*                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_Almacen;
import Idioma.Propiedades;
import Metodos_Configuraciones.metodosAlmacen;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Developer
 */

public class jpSubLotesActivosAlmacen extends javax.swing.JPanel {

    /**
     * Creates new form jpSubLotesActivosAlmacen
     */
    Connection cn;
    metodosAlmacen mal;
    DefaultTableModel modelo;
    String idSubLote = "", tipo = "", idAlmacen;
    //jdBoletaEntradaBH jdBBH;
    Propiedades idioma;
    String Idioma;

    public jpSubLotesActivosAlmacen(String idAlmacen, String Idioma, Connection cn) {
        initComponents();
        
        this.cn = cn;
        mal = new metodosAlmacen(cn);
        modelo = (DefaultTableModel) jTable1.getModel();
        this.idAlmacen = idAlmacen;
        this.Idioma = Idioma;
        
        idioma = new  Propiedades(Idioma);
        
        jTable1.getColumnModel().getColumn(0).setHeaderValue(idioma.getProperty("IdSubLote"));
        jTable1.getColumnModel().getColumn(1).setHeaderValue(idioma.getProperty("Fecha"));
        jTable1.getColumnModel().getColumn(2).setHeaderValue(idioma.getProperty("FormaDeCafe"));
        jTable1.getColumnModel().getColumn(3).setHeaderValue(idioma.getProperty("EstadoDeCafe"));
        jTable1.getColumnModel().getColumn(4).setHeaderValue(idioma.getProperty("SacosTotales"));
        jTable1.getColumnModel().getColumn(5).setHeaderValue(idioma.getProperty("KilosTotales"));
        jTable1.getColumnModel().getColumn(6).setHeaderValue(idioma.getProperty("Seleccione"));
             
        jButton2.setText(idioma.getProperty("Dividir"));
        jButton3.setText(idioma.getProperty("Mezclar"));
        //jButton1.setText(idioma.getProperty("Exportar"));
        jButton1.setText(idioma.getProperty("Enviar"));
        
        
        // hasta que se tenga la tabla de donde se tomara 
        // la información para llenar la rejilla 
        // llenarTabla(); 
             
        
    }
    
     public void llenarTabla() {
        limpiar(jTable1);

        mal.cargarInformacion(modelo, 6, "select idSublote, fechaCreacion, formaCafe, estadoCafe, ' ', kgTotales "
                + "from sublotesconfirmados where estatus='1' and idBeneficio='" + idAlmacen + "' group by idSublote");

        mal.cargarInformacion(modelo, 6, "SELECT\n"
                + "    be.idLote,\n"
                + "    be.fechaEntrada,\n"
                + "    c.formaCafe,\n"
                + "    be.estadoCafe,\n"
                + "    be.costalesRecibidos,\n"
                + "    be.kgRecibidos\n"
                + "FROM\n"
                + "    boletaentradabh be\n"
                + "LEFT JOIN cortesdeldia c ON\n"
                + "    (be.idLote = c.idLote)\n"
                + "LEFT JOIN beneficioshumedos bh ON\n"
                + "    (bh.id = be.idBeneficio)\n"
                + "WHERE\n"
                + "    be.estatus = 1 AND bh.nombre = '" + idAlmacen + "'"
                + "group by be.idLote");
    }
   
    public void mezclarSubLotes() {
        String idNuevoSubLote = "", subLotes = "";
        int nuevoConsecutivo;
        String ultimoIdSubLote[] = mal.devuelveUnDato("SELECT\n"
                + "    idSublote\n"
                + "FROM\n"
                + "    sublotesconfirmados\n"
                + "ORDER BY\n"
                + "    id\n"
                + "DESC\n"
                + "LIMIT 1").split("-");
        idNuevoSubLote = ultimoIdSubLote[5];
        if (idNuevoSubLote.equals("") || idNuevoSubLote.equals(" ")) {
            nuevoConsecutivo = 0;
        } else {
            nuevoConsecutivo = Integer.parseInt(idNuevoSubLote) + 1;
        }

        Date date = new Date();
        String fechaActual = new SimpleDateFormat("yyyy-MM-dd").format(date);
        float total = 0;
        idNuevoSubLote = "SLot-" + idAlmacen + "-Mix-" + nuevoConsecutivo;

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            String valor = jTable1.getValueAt(i, 6) + "";
            if (valor.equals("true")) {
                total = Float.parseFloat(jTable1.getValueAt(i, 5) + "") + total;
                subLotes += jTable1.getValueAt(i, 0) + "\n";
            }
        }

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Mezclar Sublotes:\n" + subLotes + " ¿Deseas Continuar?",
                "Warning", dialogButton);

        if (dialogResult == JOptionPane.YES_OPTION) {
            //JOptionPane.showMessageDialog(null, "Total Kilos: " + total);
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                String valor = jTable1.getValueAt(i, 6) + "";
                if (valor.equals("true")) {
                    if (mal.insertarEnCiclo("insert into sublotesconfirmados values("
                            + "null, '" + jTable1.getValueAt(i, 0) + "', '" + idNuevoSubLote + "', '" + idAlmacen + "', "
                            + "'" + fechaActual + "', '" + jTable1.getValueAt(i, 2) + "', '" + jTable1.getValueAt(i, 3) + "', '', '" + total + "','1' )")) {

                        if (jTable1.getValueAt(i, 0).toString().contains("SLot")) {
                            mal.actualizarBoleta("update sublotesconfirmados set estatus='0' where idSubLote='" + jTable1.getValueAt(i, 0) + "'");
                        } else {
                            mal.actualizarBoleta("update boletaentradabh set estatus='0' where idLote='" + jTable1.getValueAt(i, 0) + "'");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Error Almacenando SubLotes Automaticos");
                    }
                }
            }
            llenarTabla();
        } else if (dialogResult == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Cancelado");
        }

    }

    private void limpiar(JTable tabla) {
        while (tabla.getRowCount() > 0) {
            ((DefaultTableModel) tabla.getModel()).removeRow(0);
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Procesos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Lote", "Fecha Entrada", "Forma de Café", "Estado de Café", "Sacos Totales", "Kg Totales", "Selección"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Fragmentar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Mezclar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (!idSubLote.equals("")) {
  //          jdAsignarProceso jd = new jdAsignarProceso(null, true, idalmacen, idSubLote, tipo, Idioma, cn);
  //          jd.jp = this;
  //          jd.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un Lote");

        }
    }//GEN-LAST:event_jButton1ActionPerformed
    String sacos, kilos, forma, estado;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        idSubLote = jTable1.getValueAt(jTable1.getSelectedRow(), 0) + "";
        forma = jTable1.getValueAt(jTable1.getSelectedRow(), 2) + "";
        estado = jTable1.getValueAt(jTable1.getSelectedRow(), 3) + "";
        sacos = jTable1.getValueAt(jTable1.getSelectedRow(), 4) + "";
        kilos = jTable1.getValueAt(jTable1.getSelectedRow(), 5) + "";

        if (!jTable1.getValueAt(jTable1.getSelectedRow(), 4).equals(" ")) {
            tipo = "Lote";
            //JOptionPane.showMessageDialog(null,tipo);
        } else {
            tipo = "SubLote";
            //JOptionPane.showMessageDialog(null,tipo);           
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    //    jdFragmentacion jdF = new jdFragmentacion(null, false, idSubLote, sacos, kilos, forma, estado, idAlmacen, cn);
    //    jdF.jp = this;
    //    jdF.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        mezclarSubLotes();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
