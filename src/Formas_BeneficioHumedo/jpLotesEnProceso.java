/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_BeneficioHumedo;

import Formas_BeneficioHumedov2.jdMaquinariaRuta;
import Metodos_Configuraciones.metodosBeneficioHumedo;
import Metodos_Configuraciones.metodosDatosBasicos;
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
public class jpLotesEnProceso extends javax.swing.JPanel {

    /**
     * Creates new form jpCortesRecibidos
     */
    Connection cn;
    metodosBeneficioHumedo mbh;
    DefaultTableModel modelo;
    String idSociedad, idBeneficio, sociedad;

    public jpLotesEnProceso(String idBeneficio, String Idioma, Connection cn) {
        initComponents();

        this.cn = cn;
        this.idBeneficio = idBeneficio;
        mbh = new metodosBeneficioHumedo(cn);
        modelo = (DefaultTableModel) jTable1.getModel();
        jMenuItem1.setText("Asignar Secado");

        idSociedad = mbh.devuelveUnDato("Select idSociedad from beneficioshumedos where nombre='" + idBeneficio + "'");
        //sociedad = mbh.devuelveUnDato("select nombrecorto from personam where id="+idSociedad);
        //idBeneficio = mbh.devuelveUnDato("select id from beneficioshumedos where nombre='" + beneficio + "'");

        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        jTable1.getColumnModel().getColumn(7).setCellRenderer(tcr);

        llenarTabla();
    }

    /*
    
    
    SELECT l.idLote, p.NombreCorto, l.fecha, c.certificacion, c.formaCafe. be.estadoCafe
from lotesprocesosecado l
inner join cortesdeldia c on(l.idLote=c.idLote)
inner join personam p on (p.ID=c.id)
inner join boletaentradabh be
     */
    public void llenarTabla() {
        limpiar(jTable1);
        mbh.cargarInformacionColumna1B(modelo, 9, "SELECT\n"
                + "    l.idSubLote,\n"
                + "    c.sociedad,\n"
                + "    l.fecha,\n"
                + "    c.certificacion,\n"
                + "    c.formaCafe,\n"
                + "    b.estadoCafe,\n"
                + "    p.Descripcion,\n"
                + "    l.kilosEntrantes,\n"
                + "    l.lugarSecado\n"
                + "FROM\n"
                + "    lotesprocesosecado l\n"
                + "LEFT JOIN cortesdeldia c ON\n"
                + "    (l.idLoteOrigen = c.idLote)\n"
                + "LEFT JOIN rutabeneficiohumedo r ON\n"
                + "    (l.idRuta = r.id)\n"
                + "LEFT JOIN procesocafe p ON\n"
                + "    (r.idProceso = p.ID)\n"
                + "LEFT JOIN boletaentradabh b ON\n"
                + "    (l.idLoteOrigen = b.idLote)\n"
                + "WHERE\n"
                + "    l.estatus = 1  AND l.idBeneficio = '" + idBeneficio + "' "
                + " group by l.idSubLote order by l.fecha asc");
        cambiarMesLetra(jTable1);
    }

    public void mezclarSubLotes() {

        if (validarMezcla()) {

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
            idNuevoSubLote = ultimoIdSubLote[5];
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

                        if (mbh.insertarEnCiclo("insert into sublotesconfirmados values("
                                + "null, '" + jTable1.getValueAt(i, 0) + "', '" + idNuevoSubLote + "', '" + idBeneficio + "', "
                                + "'" + fechaActual + "', '" + jTable1.getValueAt(i, 2) + "', '" + jTable1.getValueAt(i, 3) + "', '', '" + total + "','1' )")) {

                            if (jTable1.getValueAt(i, 0).toString().contains("SLot")) {
                                mbh.actualizarBoleta("update sublotesconfirmados set estatus='0' where idSubLote='" + jTable1.getValueAt(i, 0) + "'");
                            } else {
                                mbh.actualizarBoleta("update boletaentradabh set estatus='0' where idLote='" + jTable1.getValueAt(i, 0) + "'");
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Lote", "Sociedad", "Fecha", "Certificacion", "Forma Café Entrada", "Estado Café", "Proceso Café", "Kilos Entrantes", "Metodo Secado", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton3.setText("Confirmar Secado");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cerrar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setText("Humedad Y Temperatura");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Historial");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setText("Dividir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Mezclar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5)
                        .addComponent(jButton6))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton4)
                        .addComponent(jButton1)
                        .addComponent(jButton2)))
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        /*     jdBoletaEntradaBH jdBBH;
        try {
            if (!idBoleta.equals("")) {
                jdBBH = new jdBoletaEntradaBH(null, true, idBoleta, idSociedad, idBeneficio, "Nuevo", cn);
                jdBBH.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione Boleta");
            }
        } catch (ParseException ex) {
            Logger.getLogger(jpLotesEnProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
        idBoleta = "";*/
    }//GEN-LAST:event_jButton4ActionPerformed
    String idSubLote = "", kilos = "", forma = "", estado = "", certificacion = "", proceso, metodo, comunidad;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        idSubLote = jTable1.getValueAt(jTable1.getSelectedRow(), 0) + "";
        kilos = jTable1.getValueAt(jTable1.getSelectedRow(), 7) + "";
        forma = jTable1.getValueAt(jTable1.getSelectedRow(), 4) + "";
        estado = jTable1.getValueAt(jTable1.getSelectedRow(), 5) + "";
        certificacion = jTable1.getValueAt(jTable1.getSelectedRow(), 3) + "";
        proceso = jTable1.getValueAt(jTable1.getSelectedRow(), 6) + "";
        metodo = jTable1.getValueAt(jTable1.getSelectedRow(), 8) + "";
        sociedad = jTable1.getValueAt(jTable1.getSelectedRow(), 1) + "";
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //Boton para confirmar que ya se secó el lote
/*        jdMuestra jd = new jdMuestra(null, true, idSubLote, certificacion, proceso, metodo, idBeneficio, sociedad,forma, cn);
        jd.jp = this;
        jd.setVisible(true);*/
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        jdTipoSecado jdTS = new jdTipoSecado(null, true, idSubLote, idSociedad, cn);
        jdTS.jp = this;
        jdTS.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
//        jdFragmentacion jdF = new jdFragmentacion(null, false, idSubLote, kilos, forma, estado, idBeneficio, "EnProceso", cn);
        //jdF.jp = this;
        //      jdF.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        mezclarSubLotes();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (idSubLote.equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccionar SubLote");
        } else {
            jdTemperatura jdT = new jdTemperatura(null, true, idSubLote, "", cn);
            jdT.setVisible(true);
            idSubLote = "";
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jdMaquinariaRuta jdM = new jdMaquinariaRuta(null, true);
        jdM.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
