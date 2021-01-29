/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_BeneficioHumedo;

import Metodos_Configuraciones.metodosBeneficioHumedo;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cronos
 */
public class jdFragmentacion extends javax.swing.JDialog {

    /**
     * Creates new form jdFragmentacion
     */
    String sacos, kilos, idSubLote, idBeneficio, forma, estado, origenLlamada, origenLote, fechaEntradaSub,cert;
    DefaultTableModel modelo;
    Connection cn;
    metodosBeneficioHumedo mbh;
    jpLotesConfirmados jp;

    public jdFragmentacion(java.awt.Frame parent, boolean modal,
            String idSubLote, String kilos, String forma, String estado,
            String idBeneficio, String origenLlamada, String origenLote, 
            String fechaEntradaSub, String cert,Connection cn) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        this.cn = cn;
        this.idSubLote = idSubLote;
        this.sacos = sacos;
        this.kilos = kilos;
        this.idBeneficio = idBeneficio;
        this.forma = forma;
        this.estado = estado;
        this.cert=cert;
        this.origenLlamada = origenLlamada;
        this.origenLote = origenLote;
        this.fechaEntradaSub = fechaEntradaSub;

        mbh = new metodosBeneficioHumedo(cn);
        modelo = (DefaultTableModel) jTable1.getModel();

        jLabel2.setText(idSubLote);
        jLabel7.setText(kilos);
        jLabel10.setText(forma);
        jLabel11.setText(estado);
        jLabel3.setText(origenLote);
        jLabel15.setText(cert);
    }
    int num = 0;

    public String crearIdSubLote() {
        //Fecha de Creacion de Nuevo SubLote
        //Date date = new Date();
        //String fechaActual = new SimpleDateFormat("yyyy-MM-dd").format(date);

        //Variables Nuevo Sub.
        String idNuevoSubLote = "";
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
            nuevoConsecutivo = Integer.parseInt(idNuevoSubLote) + 1 + num;
        }

        idNuevoSubLote = "SLot-" + idBeneficio + "-Div-" + nuevoConsecutivo;

        return idNuevoSubLote;
    }

    public void guardarOrigenConfirmados() {
        try {
            Date date = new Date();
            String fechaActual = new SimpleDateFormat("yyyy-MM-dd").format(date);
            String tipo;

            /*   if (jLabel2.getText().contains("SLot")) {
                tipo = "SubLoteAuto";
            } else {
                tipo = "SubLoteNormal";
            }*/
            // JOptionPane.showMessageDialog(null, tipo);
            for (int i = 0; i < jTable1.getRowCount(); i++) {

                if (mbh.insertarBoleta("insert into sublotesconfirmados values("
                        + "null, '" + jLabel3.getText() + "', '" + jTable1.getValueAt(i, 0) + "', '" + idBeneficio + "',"
                        + "'" + fechaActual + "', '" + jLabel10.getText() + "', '"+jLabel15.getText()+"', '" + jLabel11.getText() + "',"
                        + " '" + jTable1.getValueAt(i, 1) + "','1' )")) {

                } else {
                    JOptionPane.showMessageDialog(null, "Error Fragmentando SubLote");
                }
            }

            mbh.insertarBoleta("insert into historialsublotes values('" + jLabel3.getText() + "', '" + jLabel2.getText() + "', "
                    + "'" + jLabel10.getText() + "', '" + jLabel11.getText() + "', " + jLabel7.getText() + ",'" + fechaEntradaSub + "','Division','1'  ) ");

            mbh.actualizarBoleta("update sublotesconfirmados set estatus='0' "
                    + "where idSubLote='" + jLabel2.getText() + "'");


            /* if (tipo.equals("SubLoteAuto")) {*/
 /*   } else if (tipo.equals("SubLoteNormal")) {

                mbh.actualizarBoleta("update boletaentradabh set estatus='0' "
                        + "where idLote='" + jLabel2.getText() + "' ");

            }*/
            jp.llenarTabla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void guardarOrigenEnProceso() {
        try {
            Date date = new Date();
            String fechaActual = new SimpleDateFormat("yyyy-MM-dd").format(date);
            String tipo;

            if (jLabel2.getText().contains("SLot")) {
                tipo = "SubLoteAuto";
            } else {
                tipo = "SubLoteNormal";
            }
            // JOptionPane.showMessageDialog(null, tipo);

            for (int i = 0; i < jTable1.getRowCount(); i++) {

                if (mbh.insertarBoleta("insert into sublotesconfirmados values("
                        + "null, '" + jLabel2.getText() + "', '" + jTable1.getValueAt(i, 0) + "', '" + idBeneficio + "',"
                        + "'" + fechaActual + "', '" + jLabel10.getText() + "', '" + jLabel11.getText() + "',"
                        + " '" + jTable1.getValueAt(i, 1) + "','1' )")) {

                } else {
                    JOptionPane.showMessageDialog(null, "Error Fragmentando SubLote");
                }
            }

            if (tipo.equals("SubLoteAuto")) {

                mbh.actualizarBoleta("update sublotesconfirmados set estatus='0' "
                        + "where idSubLote='" + jLabel2.getText() + "'");

            } else if (tipo.equals("SubLoteNormal")) {

                mbh.actualizarBoleta("update boletaentradabh set estatus='0' "
                        + "where idLote='" + jLabel2.getText() + "' ");

            }
            jp.llenarTabla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void guardarOrigenSecos() {

    }

    public void sumar() {
        double total = 0;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            total = Double.parseDouble(jTable1.getValueAt(i, 1) + "") + total;
        }
        total = Double.parseDouble(jLabel7.getText()) - total;
        kgDisponibles.setText(total + "");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        kgDisponibles = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dividir SubLote");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idSubLote", "Kilos"
            }
        ));
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("IdSubLote");

        jLabel2.setText("-");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Kilos");

        jLabel7.setText("-");

        jLabel5.setText("Capturar Fragmentos");

        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cerrar");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Forma");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Estado");

        jLabel10.setText("-");

        jLabel11.setText("-");

        jLabel12.setText("Fragmento");

        jTextField1.setText("1");
        jTextField1.setEnabled(false);

        jLabel14.setText("Kilos");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Kilos Disponibles");

        kgDisponibles.setText("-");

        jLabel3.setText("jLabel3");
        jLabel3.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Certificacion");

        jLabel15.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(94, 531, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kgDisponibles)
                            .addComponent(jLabel13))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(kgDisponibles)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton3))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText(Integer.parseInt(jTextField1.getText()) + 1 + "");
        //validarTotales();
        modelo.addRow(new Object[]{crearIdSubLote(), jTextField3.getText()});
        jTextField3.setText("");
        num = num + 1;
        sumar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
        /*   try {
            int sacosRestantes = Integer.parseInt(sacos);// - Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
            int kilosRestantes = Integer.parseInt(kilos);// - Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());

            int sacosFrag = 0;
            double kilosFrag = 0;
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                
                sacosFrag = sacosFrag + Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                kilosFrag = kilosFrag + Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
                
            }
            
            if (sacosFrag >=) {
                
            }
            
        } catch (Exception e) {
            
        }*/
    }//GEN-LAST:event_jTable1KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        switch (origenLlamada) {
            case "EnProceso":
                guardarOrigenEnProceso();
                break;
            case "Confirmados":
                guardarOrigenConfirmados();
                break;
            case "Secos":
                guardarOrigenSecos();
                break;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jdFragmentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdFragmentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdFragmentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdFragmentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
 /*  java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
                jdFragmentacion dialog = new jdFragmentacion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel kgDisponibles;
    // End of variables declaration//GEN-END:variables
}
