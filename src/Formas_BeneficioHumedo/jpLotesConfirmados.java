/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_BeneficioHumedo;

import Metodos_Configuraciones.metodosBeneficioHumedo;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class jpLotesConfirmados extends javax.swing.JPanel {

    /**
     * Creates new form jpCortesConfirmados
     */
    Connection cn;
    metodosBeneficioHumedo mbh;
    DefaultTableModel modelo;
    String Idioma, idLote = "", tipo = "", idBeneficio;
    jdBoletaEntradaBH jdBBH;

    public jpLotesConfirmados(String idBeneficio, String Idioma, Connection cn) {
        initComponents();

        this.cn = cn;
        this.Idioma = Idioma;
        mbh = new metodosBeneficioHumedo(cn);
        modelo = (DefaultTableModel) jTable1.getModel();

        this.idBeneficio = idBeneficio;

        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        jTable1.getColumnModel().getColumn(5).setCellRenderer(tcr);
        jTable1.getColumnModel().getColumn(6).setCellRenderer(tcr);

        llenarTabla();
    }

    public void llenarTabla() {
        limpiar(jTable1);

        //CHECAR LO DE AGREGAR EL BENEFICIO EN LA TABLA SUBLOTESCONFIRMADOS
        mbh.cargarInformacion(modelo, 7, "select "
                + "idSubLote, "
                + "idLoteOrigen, "
                + "fechaCreacion, "
                + "certificacion, "
                + "formacafe, "
                + "estadoCafe, "
                + "kgTotales\n"
                + "FROM sublotesconfirmados "
                + "WHERE\n"
                + "    estatus = 1 and idBeneficio='" + idBeneficio + "' \n"
                + "GROUP BY\n"
                + "    idSublote");

        /* mbh.cargarInformacion(modelo, 8, "SELECT\n"
                + "    s.idSublote,\n"
                + "    s.idLoteOrigen,\n"
                + "    s.fechaCreacion,\n"
                + "    c.certificacion,\n"
                + "    s.formaCafe,\n"
                + "    s.estadoCafe,\n"
                + "    ' ',\n"
                + "    FORMAT(SUM(s.kgTotales),2)\n"
                + "FROM\n"
                + "    sublotesconfirmados s\n"
                + "LEFT JOIN cortesdeldia c ON\n"
                + "    (s.idLoteOrigen = c.idLote)\n"
                + "WHERE\n"
                + "    s.estatus = 1 AND s.idBeneficio = '" + idBeneficio + "'\n"
                + "GROUP BY\n"
                + "    idSublote");*/

 /* mbh.cargarInformacion(modelo, 8, "SELECT\n"
                + "    be.idLote,\n"
                + "    be.idBoleta,\n"
                + "    be.fechaEntrada,\n"
                + "    c.certificacion,\n"
                + "    c.formaCafe,\n"
                + "    be.estadoCafe,\n"
                + "    FORMAT(SUM(be.costalesRecibidos),2),\n"
                + "    FORMAT(SUM(be.kgRecibidos),2)\n"
                + "FROM\n"
                + "    boletaentradabh be\n"
                + "LEFT JOIN cortesdeldia c ON\n"
                + "    (be.idLote = c.idLote)\n"
                + "LEFT JOIN beneficioshumedos bh ON\n"
                + "    (bh.nombre = be.idBeneficio)\n"
                + "WHERE\n"
                + "    be.estatus = 1 AND bh.nombre = '" + idBeneficio + "'"
                + "group by be.idLote");*/
        cambiarMesLetra(jTable1);
    }

    public void mezclarSubLotes() {

        if (validarMezcla()) {

            JOptionPane.showMessageDialog(null, "Validando..");
            String idNuevoSubLote = "", subLotes = "";
            int nuevoConsecutivo;
            String ultimoIdSubLote[] = mbh.devuelveUnDato("SELECT\n"
                    + "    idSublote\n"
                    + "FROM\n"
                    + "    sublotesconfirmados\n"
                    + "ORDER BY\n"
                    + "    id\n"
                    + "DESC\n"
                    + "LIMIT 1").split("-");
            //idNuevoSubLote = ultimoIdSubLote[5];
            idNuevoSubLote = mbh.devuelveUnDato("SELECT COUNT(id) FROM sublotesconfirmados");
            if (idNuevoSubLote.equals("") || idNuevoSubLote.equals(" ")) {
                nuevoConsecutivo = 0;
            } else {
                nuevoConsecutivo = Integer.parseInt(idNuevoSubLote) + 1;
            }

            Date date = new Date();
            String fechaActual = new SimpleDateFormat("yyyy-MM-dd").format(date);
            float total = 0;
            idNuevoSubLote = "SLot-" + idBeneficio + "-Mix-" + nuevoConsecutivo;

            for (int i = 0; i < jTable1.getRowCount(); i++) {
                String valor = jTable1.getValueAt(i, 7) + "";
                if (valor.equals("true")) {
                    total = Float.parseFloat(jTable1.getValueAt(i, 6) + "") + total;
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
                    String valor = jTable1.getValueAt(i, 7) + "";
                    if (valor.equals("true")) {

                        if (mbh.insertarEnCiclo("insert into sublotesconfirmados values("
                                + "null, '" + jTable1.getValueAt(i, 1) + "', '" + idNuevoSubLote + "', '" + idBeneficio + "', "
                                + "'" + fechaActual + "', '" + jTable1.getValueAt(i, 3) + "', '" + jTable1.getValueAt(i, 4) + "', '', '" + total + "','1' )")) {

                            mbh.insertarBoleta("insert into historialsublotes values('" + jTable1.getValueAt(i, 1) + "', '" + jTable1.getValueAt(i, 0) + "', "
                                    + "'" + jTable1.getValueAt(i, 4) + "', '" + jTable1.getValueAt(i, 5) + "', " + jTable1.getValueAt(i, 6) + ",'" + fechaActual + "','Mezcla', '1'  ) ");

                            if (jTable1.getValueAt(i, 0).toString().contains("SLot")) {
                                mbh.actualizarBoleta("update sublotesconfirmados set estatus='0' where idSubLote='" + jTable1.getValueAt(i, 0) + "'");
                            } else {
                                mbh.actualizarBoleta("update sublotesconfirmados set estatus='0' where idSubLote='" + jTable1.getValueAt(i, 0) + "'");
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
        } else {
            JOptionPane.showMessageDialog(null, "Mezcla No Permitida");
        }

        JOptionPane.showMessageDialog(null, "Validé");
    }

    public void cambiarMesLetra(JTable tabla) {
        for (int i = 0; i < tabla.getRowCount(); i++) {

            String fecha = tabla.getValueAt(i, 2) + "";

            String[] fecha2 = fecha.split("-");

            String año = fecha2[0];
            String mes = fecha2[1];
            String dia = fecha2[2];

            switch (mes) {
                case "01":
                    mes = "Ene";
                    break;
                case "02":
                    mes = "Feb";
                    break;
                case "03":
                    mes = "Mar";
                    break;
                case "04":
                    mes = "Abr";
                    break;
                case "05":
                    mes = "May";
                    break;
                case "06":
                    mes = "Jun";
                    break;
                case "07":
                    mes = "Jul";
                    break;
                case "08":
                    mes = "Ago";
                    break;
                case "09":
                    mes = "Sep";
                    break;
                case "10":
                    mes = "Oct";
                    break;
                case "11":
                    mes = "Nov";
                    break;
                case "12":
                    mes = "Dic";
                    break;
                default:
                    mes = "Invalid month";
                    break;
            }
            fecha = año + "-" + mes + "-" + dia;
            tabla.setValueAt(fecha, i, 2);
        }
    }

    public Boolean validarMezcla() {
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            String valor = jTable1.getValueAt(i, 0) + "";

            String boleano = jTable1.getValueAt(i, 6) + "";
            if (boleano.equals("true")) {
                if (!valor.contains("Frg")) {
                    return false;
                }
            }
        }
        return true;
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

        menuLotesConfirmados = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jMenuItem1.setText("Abrir Boleta");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuLotesConfirmados.add(jMenuItem1);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Procesos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Lote", "Origen", "Fecha Entrada", "Certificacion", "Forma de Café", "Estado de Café", "Kg Totales", "Selección"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setComponentPopupMenu(menuLotesConfirmados);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(7).setMinWidth(35);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(35);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(35);
        }

        jButton2.setText("Dividir");
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
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
        if (!idLote.equals("")) {
            jdAsignarProceso jd = new jdAsignarProceso(null, true, idBeneficio, idLote, tipo, cert, Idioma, cn);
            //jd.jp = this;
            jd.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un Lote");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    String sacos, kilos, forma, estado, origenLote, fechaEntradaSub, cert;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        idLote = jTable1.getValueAt(jTable1.getSelectedRow(), 0) + "";
        origenLote = jTable1.getValueAt(jTable1.getSelectedRow(), 1) + "";
        forma = jTable1.getValueAt(jTable1.getSelectedRow(), 4) + "";
        estado = jTable1.getValueAt(jTable1.getSelectedRow(), 5) + "";
        kilos = jTable1.getValueAt(jTable1.getSelectedRow(), 6) + "";
        cert = jTable1.getValueAt(jTable1.getSelectedRow(), 3) + "";
        fechaEntradaSub = jTable1.getValueAt(jTable1.getSelectedRow(), 2) + "";

        if (idLote.contains("SLot")) {
            tipo = "SubLote";
            //JOptionPane.showMessageDialog(null,tipo);
        } else {
            tipo = "Lote";
            //JOptionPane.showMessageDialog(null,tipo);
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        String idBoleta = mbh.devuelveUnDato("select idBoleta from boletaentradabh where idLote='" + idLote + "'");
        String idSociedad = mbh.devuelveUnDato("Select idSociedad from beneficioshumedos where nombre='" + idBeneficio + "'");

        String tipo = jTable1.getValueAt(jTable1.getSelectedRow(), 0) + "";
        if (tipo.contains("SLot")) {
            idBoleta = mbh.devuelveUnDato("SELECT\n"
                    + "    b.idBoleta\n"
                    + "FROM\n"
                    + "    boletaentradabh b\n"
                    + "LEFT JOIN sublotesconfirmados s on (s.idLoteOrigen=b.idLote)\n"
                    + "WHERE\n"
                    + "    s.idLoteOrigen = '" + origenLote + "'");
        }

        if (!idBoleta.equals("")) {
            try {
                jdBBH = new jdBoletaEntradaBH(null, true, idBoleta, idSociedad, idBeneficio, "Existente", "", Idioma, cn);
                jdBBH.setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(jpLotesConfirmados.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione Boleta");
        }
        idBoleta = "";
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jdFragmentacion jdF = new jdFragmentacion(null, false, idLote, kilos, forma, estado, idBeneficio, "Confirmados", origenLote, fechaEntradaSub, cert, cn);
        jdF.jp = this;
        jdF.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        mezclarSubLotes();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPopupMenu menuLotesConfirmados;
    // End of variables declaration//GEN-END:variables
}
