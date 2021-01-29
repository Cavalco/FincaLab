/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_Configuraciones_FincaCert;
import Idioma.Propiedades;
import Metodos_Configuraciones.metodosDatosBasicos;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos Valdez
 */
public class jpDiseñoPlantacion extends javax.swing.JPanel {

    /**
     * Creates new form jpVariedadCafe
     */
    Connection cn;
    metodosDatosBasicos mdb;
    DefaultTableModel modelo;
    jdDiseñoPlantacion jdD;
    Propiedades idioma;
    String Idioma;

    public jpDiseñoPlantacion(Connection c, String Idioma) {
        initComponents();

        cn = c;
        this.Idioma = Idioma;
        mdb = new metodosDatosBasicos(cn, "");
        modelo = (DefaultTableModel) tablaDiseño.getModel();
        
        idioma = new Propiedades(Idioma);

        jButton2.setText(idioma.getProperty("Nuevo"));
        jButton3.setText(idioma.getProperty("Editar"));
        jButton4.setText(idioma.getProperty("Desactivar"));
        jButton5.setText(idioma.getProperty("Cerrar"));        
        jLabel10.setText(idioma.getProperty("Situacion"));
        jLabel6.setText(idioma.getProperty("DisenoDePlantacion"));

        tablaDiseño.getColumnModel().getColumn(0).setHeaderValue(idioma.getProperty("DisenoDePlantacion"));
        tablaDiseño.getColumnModel().getColumn(1).setHeaderValue(idioma.getProperty("Situacion"));

        comboSituacionDiseño.addItem(idioma.getProperty("Activos"));
        comboSituacionDiseño.addItem(idioma.getProperty("Inactivos"));
        comboSituacionDiseño.addItem(idioma.getProperty("Todos"));
        

        busqueda();
    }

    public void busqueda() {
        String tipoB = "";
        String situacion = "";
        situacion = comboSituacionDiseño.getSelectedIndex() + "";

        if (situacion.equals("1")) {
            situacion = "2";
        } else if (situacion.equals("0")) {
            situacion = "1";
        } else {
            situacion = "3";
        }
/*
        situacion = comboSituacionDiseño.getSelectedItem() + "";

        if (situacion.equals("Inactivo")) {
            situacion = "2";
        } else if (situacion.equals("Activo")) {
            situacion = "1";
        }
*/
        if (txtBusquedaDiseño.getText().length() > 0) {
            tipoB = "AND d.descripcion like '" + txtBusquedaDiseño.getText() + "%'";
        }

        String sql;
        if (situacion.equals("3")) {
            sql = "SELECT d.descripcion, s.descripcion "
                    + "from diseñoplantacion d "
                    + "inner join situacion s on (d.id_situacion = s.id) "
                    + "where d.ID_Situacion <> 3 " + tipoB;
        } else {
            sql = "SELECT d.descripcion, s.descripcion "
                    + "from diseñoplantacion d "
                    + "inner join situacion s on (d.id_situacion = s.id) "
                    + "where d.ID_SItuacion=" + situacion + " " + tipoB;
        }
        //System.out.println(sql);
        limpiar(tablaDiseño);
        mdb.cargarInformacion2(modelo, 2, sql);
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

        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtBusquedaDiseño = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDiseño = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        comboSituacionDiseño = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setPreferredSize(new java.awt.Dimension(830, 570));

        jLabel6.setText("Diseño Plantacion");

        txtBusquedaDiseño.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaDiseñoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtBusquedaDiseño, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusquedaDiseño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaDiseño.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Diseño Plantacion", "Situacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDiseño.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDiseñoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaDiseño);
        if (tablaDiseño.getColumnModel().getColumnCount() > 0) {
            tablaDiseño.getColumnModel().getColumn(0).setResizable(false);
            tablaDiseño.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel10.setText("Situacion");

        comboSituacionDiseño.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboSituacionDiseñoItemStateChanged(evt);
            }
        });
        comboSituacionDiseño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSituacionDiseñoActionPerformed(evt);
            }
        });

        jButton2.setText("Nuevo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Editar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Desactivar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Cerrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboSituacionDiseño, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(comboSituacionDiseño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaDiseñoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaDiseñoKeyReleased
        // TODO add your handling code here:
        busqueda();
    }//GEN-LAST:event_txtBusquedaDiseñoKeyReleased

    String variedad = "", situacion = "";
    private void tablaDiseñoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDiseñoMouseClicked
        // TODO add your handling code here:
        try {
            variedad = tablaDiseño.getValueAt(tablaDiseño.getSelectedRow(), 0) + "";  //pais
            situacion = tablaDiseño.getValueAt(tablaDiseño.getSelectedRow(), 1) + "";

            if (evt.getClickCount() == 2) {
                if (situacion.equals("Activo")) {
                    jdD = new jdDiseñoPlantacion(null, true, "2", variedad, Idioma, cn);
                    jdD.jpD = this;
                    jdD.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Dato Inactivo");
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tablaDiseñoMouseClicked
    String estatus = "2";
    private void comboSituacionDiseñoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboSituacionDiseñoItemStateChanged
        // TODO add your handling code here:
        if (comboSituacionDiseño.getSelectedItem().equals("Inactivo")) {
            estatus = "1";
            jButton4.setText("Activar");
        } else {
            estatus = "2";
            jButton4.setText("Desactivar");
        }
        busqueda();
    }//GEN-LAST:event_comboSituacionDiseñoItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jdD = new jdDiseñoPlantacion(null, true, "1", variedad, Idioma, cn);
        jdD.jpD = this;
        jdD.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (situacion.equals("")) {
            JOptionPane.showMessageDialog(null, idioma.getProperty("SeleccionRegistro"));
        } else {
            jdD = new jdDiseñoPlantacion(null, true, "2", variedad,  Idioma, cn);
            jdD.jpD = this;
            jdD.setVisible(true);
        }
/*        if (situacion.equals("Activo")) {
            jdD = new jdDiseñoPlantacion(null, true, "2", variedad, Idioma, cn);
            jdD.jpD = this;
            jdD.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Dato Inactivo");
        }*/
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (comboSituacionDiseño.getSelectedIndex() == 0) {
            mdb.actualizarBasicos("UPDATE diseñoplantacion SET ID_Situacion=2 where descripcion='" + variedad + "'");
        } else if (comboSituacionDiseño.getSelectedIndex() == 1) {
            mdb.actualizarBasicos("UPDATE diseñoplantacion SET ID_Situacion=1 where descripcion='" + variedad + "'");
        }
        busqueda();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.removeAll();
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void comboSituacionDiseñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSituacionDiseñoActionPerformed
        // TODO add your handling code here:
        if (comboSituacionDiseño.getSelectedItem().equals(idioma.getProperty("Inactivos"))) {
            jButton4.setText(idioma.getProperty("Activar"));
            jButton4.setEnabled(true);
        } else if (comboSituacionDiseño.getSelectedItem().equals(idioma.getProperty("Activos"))) {
            jButton4.setText(idioma.getProperty("Desactivar"));
            jButton4.setEnabled(true);
        } else {
            jButton4.setEnabled(false);
        }
        busqueda();
    }//GEN-LAST:event_comboSituacionDiseñoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboSituacionDiseño;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaDiseño;
    private javax.swing.JTextField txtBusquedaDiseño;
    // End of variables declaration//GEN-END:variables
}
