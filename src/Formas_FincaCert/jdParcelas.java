/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_FincaCert;

import Formas_Personas.jdFormularioParcelas;
import Metodos_Configuraciones.metodosDatosBasicos;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos Valdez
 */
public class jdParcelas extends javax.swing.JDialog {

    /**
     * Creates new form jdParcelas
     */
    String idPersona, tipoPersona,Idioma;
    Connection cn;
    metodosDatosBasicos mdb;
    jdFormularioParcelas jdF;
    DefaultTableModel modelo;

    public jdParcelas(java.awt.Frame parent, boolean modal, Connection c, String idPersona, String Idioma,String tipoPersona) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        cn = c;

        mdb = new metodosDatosBasicos(c,Idioma);
        modelo = (DefaultTableModel) tablaParcelas.getModel();
        this.idPersona = idPersona;
        this.tipoPersona = tipoPersona;
        //JOptionPane.showMessageDialog(null,"Tipo = "+tipoPersona);
        rellenarDatos();
        llenarTabla();
    }

    public void rellenarDatos() {

        if (tipoPersona.equals("Fisica")) {

            String[] datos = mdb.cargarDatosFormularioPersonas("SELECT concat(nombre,' ',apellidopaterno,' ', apellidomaterno) as nombre,"
                    + "identificacionfiscal, registrodepoblacion, direccion, telefono, telefonomovil from personaf where id=" + idPersona, 6).split("¬");
            lblNombre.setText(datos[0]);
            lblRFC.setText(datos[1]);
            lblCURP.setText(datos[2]);
            lblDireccion.setText(datos[3]);
            lblTelFijo.setText(datos[4]);
            lblTelMov.setText(datos[5]);

            lblClave.setText(mdb.devuelveUnDato("select clave_productor from productor where id_persona=" + idPersona + " and tipoPersona=1"));
            //System.out.println("CLAVE DE PRODUCTOR=" + mdb.devuelveUnDato("select clave_productor from productor where id_persona=" + idPersona));

        } else if (tipoPersona.equals("Moral")) {

            String[] datos = mdb.cargarDatosFormularioPersonas("SELECT razonsocial, "
                    + "identificacionfiscal, nombrecorto, direccion, telefono, email from personam where id=" + idPersona, 6).split("¬");

            jLabel16.setText("Nombre Corto");
            jLabel19.setText("Email");

            lblNombre.setText(datos[0]);
            lblRFC.setText(datos[1]);
            lblCURP.setText(datos[2]);
            lblDireccion.setText(datos[3]);
            lblTelFijo.setText(datos[4]);
            lblTelMov.setText(datos[5]);

            lblClave.setText(mdb.devuelveUnDato("select clave_productor from productor where id_persona=" + idPersona + " and tipoPersona=2"));
            //System.out.println(mdb.devuelveUnDato("select clave_productor from productor where id_persona="+idPersona));
        } else {
            JOptionPane.showMessageDialog(null, "Error, seleccione productor");
        }
    }

    public void llenarTabla() {
        limpiar(tablaParcelas);

        if (tipoPersona.equals("Fisica")) {
            mdb.cargarInformacion2(modelo, 8, "SELECT s.razonsocial, p.nombre, \n"
                    + "    p.clave_parcela,\n"
                    + " 	clave_certificacion, \n"
                    + "    l.descripcion,    altura,\n"
                    + "    AREA,\n"
                    + "    numCafetos\n"
                    + "FROM\n"
                    + "    parcelas p\n"
                    + "INNER JOIN personam s ON\n"
                    + "    (p.id_sociedad = s.id)\n"
                    + "INNER JOIN localidad l ON\n"
                    + "    (p.id_localidad=l.id)WHERE\n"
                    + "    id_persona =" + idPersona + " and tipoPersona=1  \n"
                    + "GROUP BY clave_parcela ASC");
        } else if (tipoPersona.equals("Moral")) {
            mdb.cargarInformacion2(modelo, 8, "SELECT s.razonsocial, p.nombre, \n"
                    + "    p.clave_parcela,\n"
                    + " 	clave_certificacion, \n"
                    + "    l.descripcion,    altura,\n"
                    + "    AREA,\n"
                    + "    numCafetos\n"
                    + "FROM\n"
                    + "    parcelas p\n"
                    + "INNER JOIN personam s ON\n"
                    + "    (p.id_sociedad = s.id)\n"
                    + "INNER JOIN localidad l ON\n"
                    + "    (p.id_localidad=l.id)WHERE\n"
                    + "    id_persona =" + idPersona + " and tipoPersona=2  \n"
                    + "GROUP BY clave_parcela ASC");

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
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblClave = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblRFC = new javax.swing.JLabel();
        lblCURP = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblTelFijo = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblTelMov = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaParcelas = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1148, 655));
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Productor"));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Nombre");

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNombre.setText("jLabel14");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Clave de Productor");

        lblClave.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblClave.setText("jLabel15");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("RFC");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("CURP");

        lblRFC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblRFC.setText("jLabel14");

        lblCURP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCURP.setText("jLabel14");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Dirección");

        lblDireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDireccion.setText("jLabel14");

        lblTelFijo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTelFijo.setText("jLabel14");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Telefono Fijo");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Telefono Movil");

        lblTelMov.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTelMov.setText("jLabel14");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(lblClave))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(lblNombre))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRFC)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(lblCURP))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(lblDireccion))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(lblTelFijo))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(lblTelMov))
                .addContainerGap(307, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTelMov))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jLabel18)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblTelFijo))
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jLabel17)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblDireccion))
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jLabel16)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblCURP))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(lblRFC)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblClave))))
        );

        tablaParcelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Sociedad", "Nombre", "Clave Parcela", "Certificado", "Localidad", "Altura", "Area (HA)", "Numero de Cafetos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaParcelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaParcelasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaParcelas);

        jButton2.setText("Nuevo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Desactivar");

        jButton4.setText("Editar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setText("Refrescar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (tipoPersona.equals("Fisica")) {
            tipoPersona = "1";
        } else if (tipoPersona.equals("Moral")) {
            tipoPersona = "2";
        }

        /*JOptionPane.showMessageDialog(null,"Tipo de Persona = "+tipoPersona+" \n"
                + " "+ mdb.devuelveId("select id from parcelas where clave_parcela='" + clave_parcela + "'"));
        */
        jdF = new jdFormularioParcelas(null, true, idPersona, tipoPersona, "",Idioma, cn);
        jdF.setVisible(true);
        
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (clave_parcela.equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione Una Parcela");
        } else {
            if (tipoPersona.equals("Fisica")) {
                tipoPersona = "1";
            } else if (tipoPersona.equals("Moral")) {
                tipoPersona = "2";
            }

            clave_parcela = mdb.devuelveId(
                    "select id from parcelas where clave_parcela = '" + clave_parcela + "' ");

            jdF = new jdFormularioParcelas(null, true, idPersona, tipoPersona, clave_parcela,Idioma, cn);
            jdF.setVisible(true);
            clave_parcela = "";
            tablaParcelas.clearSelection();
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    String clave_parcela = "";
    private void tablaParcelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaParcelasMouseClicked
        // TODO add your handling code here:
        clave_parcela = tablaParcelas.getValueAt(tablaParcelas.getSelectedRow(), 2) + "";

        if (evt.getClickCount() == 2) {

            if (clave_parcela.equals("")) {
                JOptionPane.showMessageDialog(null, "Seleccione Una Parcela");
            } else {
                if (tipoPersona.equals("Fisica")) {
                    tipoPersona = "1";
                } else if (tipoPersona.equals("Moral")) {
                    tipoPersona = "2";
                }

                clave_parcela = mdb.devuelveId(
                        "select id from parcelas where clave_parcela = '" + clave_parcela + "' ");

                jdF = new jdFormularioParcelas(null, true, idPersona, tipoPersona, clave_parcela,Idioma, cn);

                jdF.setVisible(true);
                clave_parcela = "";
                tablaParcelas.clearSelection();
            }
        }
    }//GEN-LAST:event_tablaParcelasMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        llenarTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(jdParcelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdParcelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdParcelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdParcelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
 /*        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdParcelas dialog = new jdParcelas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCURP;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRFC;
    private javax.swing.JLabel lblTelFijo;
    private javax.swing.JLabel lblTelMov;
    private javax.swing.JTable tablaParcelas;
    // End of variables declaration//GEN-END:variables
}
