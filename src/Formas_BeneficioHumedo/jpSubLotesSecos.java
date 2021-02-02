/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_BeneficioHumedo;

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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class jpSubLotesSecos extends javax.swing.JPanel {

    /**
     * Creates new form jpCortesRecibidos
     */
    Connection cn;
    metodosBeneficioHumedo mbh;
    DefaultTableModel modelo, modelo2,modelo3;
    String beneficio, idSociedad, idBeneficio;

    public jpSubLotesSecos(String beneficio, String Idioma, Connection cn) {
        initComponents();

        this.cn = cn;
        this.beneficio = beneficio;
        mbh = new metodosBeneficioHumedo(cn);
        modelo = (DefaultTableModel) jTable1.getModel();
        modelo2 = (DefaultTableModel) jTable2.getModel();
//        modelo3 = (DefaultTableModel) jTable3.getModel();

        idSociedad = mbh.devuelveUnDato("Select idSociedad from beneficioshumedos where nombre='" + beneficio + "'");
        //idBeneficio = mbh.devuelveUnDato("select id from beneficioshumedos where nombre='" + beneficio + "'");
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
        limpiar(jTable2);
//        limpiar(jTable3);
        mbh.cargarInformacionColumna1B(modelo, 11, "SELECT\n"
                + "  idSubLote,\n"
                + "   sociedad,\n"
                + "    fechaSecado,\n"
                + "    humedadFinal,\n"
                + "    temperaturaFinal,\n"
                + "    certificacion,\n"
                + "    formaSalida,\n"
                + "    procesoCafe, metodoSecado,\n"
                + "    sacosFinales,\n"
                + "    kilosFinales\n"
                + "FROM\n"
                + "    sublotessecos\n"
                + "WHERE\n"
                + "    estatus = 1");

   /*     mbh.cargarInformacionColumna1B(modelo3, 18, "SELECT\n"
                + "    s.idSubLote,\n"
                + "    b.idBoleta,\n"
                + "    b.fechaEntrada,\n"
                + "    s.sociedad,\n"
                + "    re.nombrecorto,\n"
                + "    s.certificacion,\n"
                 + "    s.sacosFinales,\n"
                + "    s.kilosFinales,\n"
               + "    s.fechaSecado,\n"
                + "    s.metodoSecado,\n"
                + "    s.humedadFinal,\n"
                + "    s.temperaturaFinal,\n"
                + "    s.formaSalida,\n"
                + "    s.procesoCafe,\n"
                + "    v.Responsable, s.kgMuestra, s.fechaMuestra, s.tomadaPor\n"
                + "FROM\n"
                + "    sublotessecos s\n"
                + "LEFT JOIN boletaentradabh b ON\n"
                + "    (b.idLote = s.idLoteOrigen)\n"
                + "LEFT JOIN boletasalidareceptor r ON\n"
                + "    (r.idBoleta = b.idBoleta)\n"
                + "LEFT JOIN vehiculo v ON\n"
                + "    (v.ID = r.idTransporte)\n"
                + "LEFT JOIN recepciones re ON\n"
                + "    (re.idRecepcion = r.idRecepcion)\n"
                + "WHERE\n"
                + "    s.estatus = 1");*/

        cambiarMesLetra(jTable1);
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

    public void mezclarSubLotes() {
        String idNuevoSubLote = "", subLotes = "";
        String consecutivo = mbh.devuelveUnDato("SELECT count(id) FROM sublotesconfirmados");
        Date date = new Date();
        String fechaActual = new SimpleDateFormat("yyyy-MM-dd").format(date);
        float total = 0;
        idNuevoSubLote = "SLot-" + idBeneficio + "-Mix-" + consecutivo;

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
                    if (mbh.insertarBoleta("insert into sublotesconfirmados values("
                            + "null, '" + jTable1.getValueAt(i, 0) + "', '" + idNuevoSubLote + "', "
                            + "'" + fechaActual + "', '" + jTable1.getValueAt(i, 2) + "', '" + jTable1.getValueAt(i, 3) + "', '" + total + "','1' )")) {
                    } else {
                        JOptionPane.showMessageDialog(null, "Error Almacenando SubLotes Automaticos");
                    }
                }
            }
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jMenuItem1.setText("Abrir Boleta");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Historial");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem2);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Lote", "Sociedad", "Fecha Secado", "Humedad Final", "Temperatura Final", "Certificacion", "Forma Café", "Proceso Café", "Metodo Secado", "Sacos Finales", "Kilos Finales"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setComponentPopupMenu(jPopupMenu2);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton3.setText("Enviar");
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

        jButton2.setText("Mezclar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Fragmentar");

        jButton5.setText("Tomar Muestra");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No. Boleta", "Fecha de Envio", "Sociedad", "Vehiculo", "Placas", "Responsable", "Folio Manual", "Fecha Boleta Manual"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable2.setComponentPopupMenu(jPopupMenu1);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jLabel1.setText("SubLotes Secos");

        jLabel2.setText("Información Adicional");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton5))
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
    String idSubLote = "", certificacion = "", proceso = "", metodo = "", sociedad = "", fechaS="", sacosFinales="",kgFinales="",formaCafe="";
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        idSubLote = jTable1.getValueAt(jTable1.getSelectedRow(), 0) + "";
        sociedad = jTable1.getValueAt(jTable1.getSelectedRow(), 1) + "";
        fechaS = jTable1.getValueAt(jTable1.getSelectedRow(), 2) + "";
        certificacion = jTable1.getValueAt(jTable1.getSelectedRow(), 5) + "";
        formaCafe = jTable1.getValueAt(jTable1.getSelectedRow(), 6) + "";
        proceso = jTable1.getValueAt(jTable1.getSelectedRow(), 7) + "";
        metodo = jTable1.getValueAt(jTable1.getSelectedRow(), 8) + "";
        sacosFinales = jTable1.getValueAt(jTable1.getSelectedRow(), 9) + "";
        kgFinales = jTable1.getValueAt(jTable1.getSelectedRow(), 10) + "";
        

        if (idSubLote.contains("SLot")) {
            idSubLote = mbh.devuelveUnDato("select idLoteOrigen from sublotesconfirmados where idSublote='" + idSubLote + "' ");
        }

        limpiar(jTable2);
        mbh.cargarInformacionColumna1B(modelo2, 8, "SELECT\n"
                + "    b.idBoleta,\n"
                + "    b.fecha,\n"
                + "    pm.NombreCorto,\n"
                + "    v.Nombre,\n"
                + "    v.Placas,\n"
                + "    v.Responsable,\n"
                + "    b.idBoletaManual,\n"
                + "    b.fechaBoletaManual\n"
                + "FROM\n"
                + "    boletasalidareceptor b\n"
                + "LEFT JOIN vehiculo v ON\n"
                + "    (b.idTransporte = v.ID)\n"
                + "LEFT JOIN personam pm ON\n"
                + "    (b.idSociedad=pm.ID) "
                + "WHERE b.idLote='" + idSubLote + "' ");
        // + "where b.destino='" + idBeneficio + "' and b.estatus" + estatusBoleta + " and tipoLugar='B' group by b.idBoleta order by b.id  ");

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null,"Envio Exitoso");
        
        JOptionPane.showMessageDialog(null,"Ruta No Encontrada");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        mezclarSubLotes();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        jdMuestraIndividual jd = new jdMuestraIndividual(null, true, idSubLote, certificacion, proceso, metodo, beneficio, sociedad, fechaS, sacosFinales, kgFinales, formaCafe, cn);
        jd.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        //idBoleta = jTable1.getValueAt(jTable1.getSelectedRow(), 0) + "";
    }//GEN-LAST:event_jTable2MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
         String idBoleta = mbh.devuelveUnDato("select idBoleta from boletaentradabh where idLote='" + idSubLote + "'");
        

        if (!idBoleta.equals("")) {
            try {
                jdBoletaEntradaBH jdBBH = new jdBoletaEntradaBH(null, true, idBoleta, idSociedad, idBeneficio, "Existente", "", "Idioma", cn);
                jdBBH.setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(jpLotesConfirmados.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione Boleta");
        }
        idBoleta = "";
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        jdHistorialLote hl = new jdHistorialLote(null, true,idSubLote,cn);
        hl.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
