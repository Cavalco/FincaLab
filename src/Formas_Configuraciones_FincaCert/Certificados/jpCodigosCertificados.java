/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_Configuraciones_FincaCert.Certificados;

import Idioma.Propiedades;
import FormasGenerales.pantallaPrincipal;
import Metodos_Configuraciones.metodosDatosBasicos;
import com.placeholder.PlaceHolder;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 *
 * @author Carlos Valdez
 */
public class jpCodigosCertificados extends javax.swing.JPanel {

    /**
     * Creates new form jp
     */
    pantallaPrincipal fprin;
    jdCodigosCertificados jdCodC;
    metodosDatosBasicos mdb;
    DefaultTableModel modelo;
    Connection cn;

    Propiedades idioma;
    String Idioma;

    public jpCodigosCertificados(Connection c, String Idioma) {
        initComponents();
        cn = c;
        this.Idioma = Idioma;

        modelo = (DefaultTableModel) tablaCodigos.getModel();
        tablaCodigos.setRowSorter(new TableRowSorter(modelo));
        mdb = new metodosDatosBasicos(cn, Idioma);

        idioma = new Propiedades(Idioma);
        jButton5.setText(idioma.getProperty("Cerrar"));
        jButton2.setText(idioma.getProperty("Nuevo"));
        jButton3.setText(idioma.getProperty("Editar"));
        jButton4.setText(idioma.getProperty("Desactivar"));
        jLabel10.setText(idioma.getProperty("Situacion"));
        //jLabel6.setText(idioma.getProperty("Clave"));
        //jLabel7.setText(idioma.getProperty("Certificado"));
        
        PromptSupport.setPrompt(idioma.getProperty("Clave"), txtBusquedaClave);
        PromptSupport.setPrompt(idioma.getProperty("Certificado"), txtBusquedaCertificado);

        tablaCodigos.getColumnModel().getColumn(0).setHeaderValue(idioma.getProperty("Clave"));
        tablaCodigos.getColumnModel().getColumn(1).setHeaderValue(idioma.getProperty("Certificado"));
        tablaCodigos.getColumnModel().getColumn(2).setHeaderValue(idioma.getProperty("Contenido"));

        comboSituacion.addItem(idioma.getProperty("Activos"));
        comboSituacion.addItem(idioma.getProperty("Inactivos"));
        comboSituacion.addItem(idioma.getProperty("Todos"));

        llenaTabla();
    }

    public void llenaTabla() {
        limpiar(tablaCodigos);

        mdb.cargarInformacion2(modelo, 3, "SELECT\n"
                + "    c.codigo,\n"
                + "    c.nombre,\n"
                + "    GROUP_CONCAT(\n"
                + "        DISTINCT r.certificado,'-',R.certificadora, '-' ,R.alcance \n"
                + "    ORDER BY\n"
                + "        r.alcance ASC SEPARATOR ' / '\n"
                + "    ) AS \"Alcances\"\n"
                + "    \n"
                + "FROM\n"
                + "    codigos_certificacion c\n"
                + "INNER JOIN codigo_relacion r ON\n"
                + "    (c.codigo = r.codigo)\n"
                + " Where c.Id_Situacion=1\n "
                + "GROUP BY\n"
                + "    codigo ASC");
    }

    public void busqueda() {
        String tipoP = "";
        String tipoK = "";
        String situacion = "";
        situacion = comboSituacion.getSelectedIndex() + "";

        if (situacion.equals("1")) {
            situacion = "2";
        } else if (situacion.equals("0")) {
            situacion = "1";
        } else {
            situacion = "3";
        }

        if (txtBusquedaClave.getText().length() > 0) {
            tipoP = " AND c.codigo like '" + txtBusquedaClave.getText() + "%'";
        }
        if (txtBusquedaCertificado.getText().length() > 0) {
            tipoK = " AND c.nombre like '" + txtBusquedaCertificado.getText() + "%'";
        }

        String sql;
        System.out.println("SITUACION: " + situacion);
        if (situacion.equals("3")) {
            sql = "SELECT\n"
                    + "    c.codigo,\n"
                    + "    c.nombre,\n"
                    + "    GROUP_CONCAT(\n"
                    + "        DISTINCT r.certificado,'-',R.certificadora, '-' ,R.alcance \n"
                    + "    ORDER BY\n"
                    + "        r.alcance ASC SEPARATOR ' / '\n"
                    + "    ) AS \"Alcances\"\n"
                    + "    \n"
                    + "FROM\n"
                    + "    codigos_certificacion c\n"
                    + "INNER JOIN codigo_relacion r ON\n"
                    + "    (c.codigo = r.codigo) \n"
                    + "WHERE c.ID_Situacion<>3 " + tipoP + tipoK
                    + " GROUP BY\n"
                    + "    codigo ASC ";
        } else {
            sql = "SELECT\n"
                    + "    c.codigo,\n"
                    + "    c.nombre,\n"
                    + "    GROUP_CONCAT(\n"
                    + "        DISTINCT r.certificado,'-',R.certificadora, '-' ,R.alcance \n"
                    + "    ORDER BY\n"
                    + "        r.alcance ASC SEPARATOR ' / '\n"
                    + "    ) AS \"Alcances\"\n"
                    + "    \n"
                    + "FROM\n"
                    + "    codigos_certificacion c\n"
                    + "INNER JOIN codigo_relacion r ON\n"
                    + "    (c.codigo = r.codigo)\n"
                    + "WHERE c.ID_Situacion=" + situacion + tipoP + tipoK
                    + " GROUP BY\n"
                    + "    codigo ASC ";
        }
        //System.out.println(sql);
        limpiar(tablaCodigos);
        mdb.cargarInformacion2(modelo, 3, sql);

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
        txtBusquedaClave = new javax.swing.JTextField();
        txtBusquedaCertificado = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCodigos = new javax.swing.JTable();
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

        txtBusquedaClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaClaveActionPerformed(evt);
            }
        });
        txtBusquedaClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaClaveKeyReleased(evt);
            }
        });

        txtBusquedaCertificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaCertificadoActionPerformed(evt);
            }
        });
        txtBusquedaCertificado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaCertificadoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBusquedaClave, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtBusquedaCertificado, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(370, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtBusquedaCertificado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusquedaClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaCodigos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave", "Nombre", "Contenido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCodigos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCodigosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaCodigos);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 293, Short.MAX_VALUE)
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
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
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
                .addGap(29, 29, 29)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jdCodC = new jdCodigosCertificados(cn, Idioma,"-");
        jdCodC.jp = this;
        jdCodC.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         if (Clave.equals("")) {
            JOptionPane.showMessageDialog(null,"selecciona un registro");
        }else{
             jdCodC = new jdCodigosCertificados(cn,Idioma,Clave);
        jdCodC.jp = this;
        jdCodC.setVisible(true);
        }

    }//GEN-LAST:event_jButton3ActionPerformed
    String Clave = "";
    String TxTvar = "";
    private void tablaCodigosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCodigosMouseClicked
        // TODO add your handling code here: Retenciones
        Clave = modelo.getValueAt(tablaCodigos.getSelectedRow(), 0) + "";  //
        TxTvar=modelo.getValueAt(tablaCodigos.getSelectedRow(), 1) + "";
        
        if (evt.getClickCount() == 1) {
            System.out.println("1 Clic");
        }
        if (evt.getClickCount() == 2) {          
            jdCodC = new jdCodigosCertificados(cn,Idioma,Clave);
            jdCodC.jp = this;
            jdCodC.setVisible(true);
        }
    }//GEN-LAST:event_tablaCodigosMouseClicked

    private void txtBusquedaClaveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaClaveKeyReleased
        // TODO add your handling code here:
        busqueda();
    }//GEN-LAST:event_txtBusquedaClaveKeyReleased

    private void comboSituacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboSituacionItemStateChanged
        // TODO add your handling code here:
        //busqueda();
    }//GEN-LAST:event_comboSituacionItemStateChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.removeAll();
        this.revalidate();
        this.repaint();
        /*fprin.panelPrincipal.removeAll();
        fprin.panelPrincipal.revalidate();
        fprin.panelPrincipal.repaint();*/
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (Clave.equals("")) {
            JOptionPane.showMessageDialog(null, idioma.getProperty("SeleccionRegistro"));
        } else {
            if (comboSituacion.getSelectedIndex() == 0) {
                mdb.actualizarBasicos("UPDATE codigos_certificacion SET ID_Situacion=2 where codigo='" + Clave + "'");
            } else if (comboSituacion.getSelectedIndex() == 1) {
                mdb.actualizarBasicos("UPDATE codigos_certificacion SET ID_Situacion=1 where codigo='" + Clave + "'");
            }
        }
        busqueda();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtBusquedaClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaClaveActionPerformed

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

    private void txtBusquedaCertificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaCertificadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaCertificadoActionPerformed

    private void txtBusquedaCertificadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaCertificadoKeyReleased
        busqueda(); // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaCertificadoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> comboSituacion;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton4;
    public javax.swing.JButton jButton5;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JPanel jPanel5;
    public javax.swing.JPanel jPanel6;
    public javax.swing.JPanel jPanel7;
    public javax.swing.JPanel jPanel8;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tablaCodigos;
    public javax.swing.JTextField txtBusquedaCertificado;
    public javax.swing.JTextField txtBusquedaClave;
    // End of variables declaration//GEN-END:variables
}
