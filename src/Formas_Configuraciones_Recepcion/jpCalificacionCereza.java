/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_Configuraciones_Recepcion;

import Idioma.Propiedades;
import Formas_Configuraciones_DatosBasicos.*;
import Metodos_Configuraciones.metodosDatosBasicos;
import com.placeholder.PlaceHolder;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos Valdez
 */
public class jpCalificacionCereza extends javax.swing.JPanel {

    /**
     * Creates new form jpCCocalidad
     */
    metodosDatosBasicos mdb;
    DefaultTableModel modelo;
    Connection cn;
    jdCalificacionCereza jdCC;
    Propiedades idioma;
    String Idioma;

    public jpCalificacionCereza(Connection c, String Idioma) {
        initComponents();

        cn = c;
        mdb = new metodosDatosBasicos(cn, "");
        modelo = (DefaultTableModel) tablaCalSeco.getModel();
        this.Idioma = Idioma;

        idioma = new Propiedades(Idioma);
        jButton5.setText(idioma.getProperty("Cerrar"));
        jButton2.setText(idioma.getProperty("Nuevo"));
        jButton3.setText(idioma.getProperty("Editar"));
        jButton4.setText(idioma.getProperty("Desactivar"));
        jLabel10.setText(idioma.getProperty("Situacion"));
        /*jLabel6.setText(idioma.getProperty("Clave"));
        jLabel7.setText(idioma.getProperty("Descripcion"));
        jLabel8.setText(idioma.getProperty("Minima"));
        jLabel9.setText(idioma.getProperty("Maxima"));*/

        tablaCalSeco.getColumnModel().getColumn(0).setHeaderValue(idioma.getProperty("Clave"));
        tablaCalSeco.getColumnModel().getColumn(1).setHeaderValue(idioma.getProperty("Descripcion"));
        tablaCalSeco.getColumnModel().getColumn(2).setHeaderValue(idioma.getProperty("Minima"));
        tablaCalSeco.getColumnModel().getColumn(3).setHeaderValue(idioma.getProperty("Maxima"));
        // tablaCalSeco.getColumnModel().getColumn(4).setHeaderValue(idioma.getProperty("Situacion"));

        comboSituacion.addItem(idioma.getProperty("Activos"));
        comboSituacion.addItem(idioma.getProperty("Inactivos"));
        comboSituacion.addItem(idioma.getProperty("Todos"));

        PlaceHolder holder = new PlaceHolder(txtClave, idioma.getProperty("Clave"));
        PlaceHolder holder2 = new PlaceHolder(txtDesc, idioma.getProperty("Descripcion"));
        PlaceHolder holder3 = new PlaceHolder(txtMinima, idioma.getProperty("Minima"));
        PlaceHolder holder4 = new PlaceHolder(txtMaxima, idioma.getProperty("Maxima"));
        
        busqueda();
    }

    public void busqueda() {
        String tipo1 = "";
        String tipo2 = "";
        String tipo3 = "";
        String tipo4 = "";
        String situacion = "";
        situacion = comboSituacion.getSelectedIndex() + "";

        if (situacion.equals("1")) {
            situacion = "2";
        } else if (situacion.equals("0")) {
            situacion = "1";
        } else {
            situacion = "3";
        }

        if (txtClave.getText().length() > 0) {
            tipo2 = "AND c.clave like '" + txtClave.getText() + "%'";
        }
        if (txtDesc.getText().length() > 0) {
            tipo3 = "AND c.descripcion like '" + txtDesc.getText() + "%'";
        }
        if (txtMinima.getText().length() > 0) {
            tipo4 = "AND c.minima like '" + txtMinima.getText() + "%'";
        }
        if (txtMaxima.getText().length() > 0) {
            tipo4 = "AND c.maxima like '" + txtMaxima.getText() + "%'";
        }

        String sql;
        if (situacion.equals("3")) {
            sql = "SELECT c.clave, c.descripcion, c.minima, c.maxima "
                    + "from calidadcereza c "
                    + "where c.ID_Situacion <> 3 " + tipo1 + " " + tipo2 + " " + tipo3 + " " + tipo4;
        } else {
            sql = "SELECT c.clave, c.descripcion, c.minima, c.maxima "
                    + "from calidadcereza c "
                    + "where c.ID_Situacion = " + situacion + " " + tipo1 + " " + tipo2 + " " + tipo3 + " " + tipo4;
        }
        limpiar(tablaCalSeco);
        mdb.cargarInformacion2(modelo, 4, sql);

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
        txtClave = new javax.swing.JTextField();
        txtDesc = new javax.swing.JTextField();
        txtMinima = new javax.swing.JTextField();
        txtMaxima = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCalSeco = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        comboSituacion = new javax.swing.JComboBox<String>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setPreferredSize(new java.awt.Dimension(830, 570));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        txtClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtClaveKeyReleased(evt);
            }
        });

        txtDesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescKeyReleased(evt);
            }
        });

        txtMinima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMinimaKeyReleased(evt);
            }
        });

        txtMaxima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaximaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMinima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaCalSeco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave", "Descripcion", "Minima", "Máxima"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCalSeco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCalSecoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaCalSeco);
        if (tablaCalSeco.getColumnModel().getColumnCount() > 0) {
            tablaCalSeco.getColumnModel().getColumn(0).setResizable(false);
            tablaCalSeco.getColumnModel().getColumn(1).setResizable(false);
            tablaCalSeco.getColumnModel().getColumn(2).setResizable(false);
            tablaCalSeco.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel10.setText("Situacion");

        comboSituacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboSituacionItemStateChanged(evt);
            }
        });
        comboSituacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSituacionActionPerformed(evt);
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
                .addComponent(comboSituacion, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(comboSituacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
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
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jdCC = new jdCalificacionCereza(null, true, "1", "", descripcion, minima, maxima, Idioma, cn);
        jdCC.jpCC = this;
        jdCC.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
    String clave = "", descripcion = "", maxima = "", minima = "", situacion = "";
    private void tablaCalSecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCalSecoMouseClicked
        // TODO add your handling code here:
        try {
            clave = tablaCalSeco.getValueAt(tablaCalSeco.getSelectedRow(), 0) + "";  //Estado String
            descripcion = tablaCalSeco.getValueAt(tablaCalSeco.getSelectedRow(), 1) + "";
            minima = tablaCalSeco.getValueAt(tablaCalSeco.getSelectedRow(), 2) + "";
            maxima = tablaCalSeco.getValueAt(tablaCalSeco.getSelectedRow(), 3) + "";
            situacion = comboSituacion.getSelectedItem() + "";

            if (evt.getClickCount() == 2) {
                if (situacion.equals("Activo")) {
                    jdCC = new jdCalificacionCereza(null, true, "2", clave, descripcion, minima, maxima, Idioma, cn);
                    jdCC.jpCC = this;
                    jdCC.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Dato Inactivo");
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tablaCalSecoMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (clave.equals("")) {
            JOptionPane.showMessageDialog(null, idioma.getProperty("SeleccionRegistro"));
        } else {
            if (situacion.equals("Activo")) {
                jdCC = new jdCalificacionCereza(null, true, "2", clave, descripcion, minima, maxima, Idioma, cn);
                jdCC.jpCC = this;
                jdCC.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Dato Inactivo");
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtClaveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveKeyReleased
        // TODO add your handling code here:
        busqueda();
    }//GEN-LAST:event_txtClaveKeyReleased

    private void txtDescKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescKeyReleased
        // TODO add your handling code here:
        busqueda();
    }//GEN-LAST:event_txtDescKeyReleased

    private void txtMinimaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMinimaKeyReleased
        // TODO add your handling code here:
        busqueda();
    }//GEN-LAST:event_txtMinimaKeyReleased

    private void txtMaximaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaximaKeyReleased
        // TODO add your handling code here:
        busqueda();
    }//GEN-LAST:event_txtMaximaKeyReleased
    String estatus = "2";
    private void comboSituacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboSituacionItemStateChanged
        // TODO add your handling code here:
        if (comboSituacion.getSelectedItem().equals("Inactivo")) {
            estatus = "1";
            jButton4.setText("Activar");
        } else {
            estatus = "2";
            jButton4.setText("Desactivar");
        }
        busqueda();
    }//GEN-LAST:event_comboSituacionItemStateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (comboSituacion.getSelectedIndex() == 0) {
            mdb.actualizarBasicos("UPDATE calidadcereza SET ID_Situacion=2 where clave='" + clave + "'");
        } else if (comboSituacion.getSelectedIndex() == 1) {
            mdb.actualizarBasicos("UPDATE calidadcereza SET ID_Situacion=1 where clave='" + clave + "'");
        }
        busqueda();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.removeAll();
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void comboSituacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSituacionActionPerformed
        // TODO add your handling code here:
        if (comboSituacion.getSelectedItem().equals(idioma.getProperty("Inactivos"))) {
            jButton4.setText(idioma.getProperty("Activar"));
            jButton4.setEnabled(true);
        } else if (comboSituacion.getSelectedItem().equals(idioma.getProperty("Activos"))) {
            jButton4.setText(idioma.getProperty("Desactivar"));
            jButton4.setEnabled(true);
        } else {
            jButton4.setEnabled(false);
        }
        busqueda();
    }//GEN-LAST:event_comboSituacionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboSituacion;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaCalSeco;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtMaxima;
    private javax.swing.JTextField txtMinima;
    // End of variables declaration//GEN-END:variables
}
