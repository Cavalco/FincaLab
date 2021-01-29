/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_Configuraciones_DatosBasicos;

import Idioma.Propiedades;
import Metodos_Configuraciones.metodosDatosBasicos;
//import com.placeholder.PromptSupport;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 *
 * @author Carlos Valdez
 */
public class jpColoniaEjido extends javax.swing.JPanel {

    /**
     * Creates new form jpColoniaEjido
     */
    DefaultTableModel modelo;
    metodosDatosBasicos mdb;
    jdColoniaEjido jdC;
    Connection cn;
    Propiedades idioma;
    String Idioma;

    public jpColoniaEjido(Connection c, String Idioma) {
        initComponents();

        cn = c;
        this.Idioma = Idioma;
        mdb = new metodosDatosBasicos(cn, Idioma);
        modelo = (DefaultTableModel) tablaColonia.getModel();

        tablaColonia.setRowSorter(new TableRowSorter(modelo));

        idioma = new Propiedades(Idioma);

        jButton2.setText(idioma.getProperty("Nuevo"));
        jButton3.setText(idioma.getProperty("Editar"));
        jButton4.setText(idioma.getProperty("Desactivar"));
        jButton5.setText(idioma.getProperty("Cerrar"));
        //jLabel6.setText(idioma.getProperty("ColoniaEjido"));
        //jLabel7.setText(idioma.getProperty("Localidad"));
        //jLabel8.setText(idioma.getProperty("Municipio"));
        //jLabel9.setText(idioma.getProperty("Estado"));
        jLabel10.setText(idioma.getProperty("Situacion"));
        //jLabel1.setText(idioma.getProperty("Pais"));
        
        PromptSupport.setPrompt(idioma.getProperty("ColoniaEjido"), txtBusquedaC);
        PromptSupport.setPrompt(idioma.getProperty("Localidad"), txtBusquedaL);
        PromptSupport.setPrompt(idioma.getProperty("Municipio"), txtBusquedaM);
        PromptSupport.setPrompt(idioma.getProperty("Estado"), txtBusquedaE);
        PromptSupport.setPrompt(idioma.getProperty("Pais"), txtBusquedaP);

        tablaColonia.getColumnModel().getColumn(0).setHeaderValue(idioma.getProperty("ColoniaEjido"));
        tablaColonia.getColumnModel().getColumn(1).setHeaderValue(idioma.getProperty("Localidad"));
        tablaColonia.getColumnModel().getColumn(2).setHeaderValue(idioma.getProperty("Municipio"));
        tablaColonia.getColumnModel().getColumn(3).setHeaderValue(idioma.getProperty("Estado"));
        tablaColonia.getColumnModel().getColumn(4).setHeaderValue(idioma.getProperty("Pais"));

        comboSituacion.addItem(idioma.getProperty("Activos"));
        comboSituacion.addItem(idioma.getProperty("Inactivos"));
        comboSituacion.addItem(idioma.getProperty("Todos"));

        llenaTablaColonia();
        
        //
    //    PromptSupport holder = new PromptSupport(txtBusquedaC, idioma.getProperty("ColoniaEjido"));
    }

    public void llenaTablaColonia() {
        limpiar(tablaColonia);
        mdb.cargarInformacion2(modelo, 5, "select c.descripcion, l.Descripcion, m.Descripcion,e.descripcion, p.descripcion \n"
                + "from ejidocolonia c \n"
                + "inner join localidad l on (c.ID_Localidad=l.ID)\n"
                + "inner join municipio m on (l.ID_Municipio=m.ID)  \n"
                + "inner join estado e on (m.ID_Estado=e.ID) \n"
                + "inner join pais p on (e.ID_Pais=p.ID)\n"
                + "where c.ID_Situacion=1");
    }

    public void busquedaColonia() {
        String tipoC = "";
        String tipoL = "";
        String tipoM = "";
        String tipoE = "";
        String tipoP = "";
        String situacion = "";

        situacion = comboSituacion.getSelectedIndex() + "";

        if (situacion.equals("1")) {
            situacion = "2";
        } else if (situacion.equals("0")) {
            situacion = "1";
        } else {
            situacion = "3";
        }

        if (txtBusquedaC.getText().length() > 0) {
            tipoC = "AND c.descripcion like '" + txtBusquedaC.getText() + "%'";
        }
        if (txtBusquedaL.getText().length() > 0) {
            tipoL = "AND l.descripcion like '" + txtBusquedaL.getText() + "%'";
        }
        if (txtBusquedaM.getText().length() > 0) {
            tipoM = "AND m.descripcion like '" + txtBusquedaM.getText() + "%'";
        }
        if (txtBusquedaE.getText().length() > 0) {
            tipoE = "AND e.descripcion like '" + txtBusquedaE.getText() + "%'";
        }
        if (txtBusquedaP.getText().length() > 0) {
            tipoP = "AND p.descripcion like '" + txtBusquedaP.getText() + "%'";
        }

        String sql;
        if (situacion.equals("3")) {
            sql = "SELECT  c.Descripcion,l.descripcion, m.descripcion, e.descripcion, p.descripcion \n"
                    + "from ejidocolonia c \n"
                    + "inner join localidad l on (c.ID_Localidad=l.ID) \n"
                    + "inner join municipio m on (l.ID_Municipio=m.ID) \n"
                    + "inner join estado e on (m.ID_Estado=e.ID) \n"
                    + "inner join pais p on (e.ID_Pais=p.ID) \n"
                    + "where c.ID_Situacion <> 3 " + tipoC + " " + tipoL + " " + tipoM + " " + tipoE + " " + tipoP;
        } else {
            sql = "SELECT  c.Descripcion,l.descripcion, m.descripcion, e.descripcion, p.descripcion \n"
                    + "from ejidocolonia c \n"
                    + "inner join localidad l on (c.ID_Localidad=l.ID) \n"
                    + "inner join municipio m on (l.ID_Municipio=m.ID) \n"
                    + "inner join estado e on (m.ID_Estado=e.ID) \n"
                    + "inner join pais p on (e.ID_Pais=p.ID) \n"
                    + "where c.ID_Situacion=" + situacion + " " + tipoC + " " + tipoL + " " + tipoM + " " + tipoE + " " + tipoP;
        }
        limpiar(tablaColonia);
        mdb.cargarInformacion2(modelo, 5, sql);

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
        txtBusquedaC = new javax.swing.JTextField();
        txtBusquedaL = new javax.swing.JTextField();
        txtBusquedaM = new javax.swing.JTextField();
        txtBusquedaE = new javax.swing.JTextField();
        txtBusquedaP = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaColonia = new javax.swing.JTable();
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

        txtBusquedaC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaCKeyReleased(evt);
            }
        });

        txtBusquedaL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaLKeyReleased(evt);
            }
        });

        txtBusquedaM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaMKeyReleased(evt);
            }
        });

        txtBusquedaE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaEKeyReleased(evt);
            }
        });

        txtBusquedaP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaPKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBusquedaC, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtBusquedaL, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBusquedaM, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBusquedaE, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBusquedaP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBusquedaE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBusquedaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtBusquedaM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBusquedaL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBusquedaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaColonia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Colonia/Ejido", "Localidad", "Municipio", "Estado", "País"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaColonia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaColoniaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaColonia);
        if (tablaColonia.getColumnModel().getColumnCount() > 0) {
            tablaColonia.getColumnModel().getColumn(0).setResizable(false);
            tablaColonia.getColumnModel().getColumn(1).setResizable(false);
            tablaColonia.getColumnModel().getColumn(2).setResizable(false);
            tablaColonia.getColumnModel().getColumn(3).setResizable(false);
            tablaColonia.getColumnModel().getColumn(4).setResizable(false);
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
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
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
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
        jdC = new jdColoniaEjido(null, true, "1", "", localidad, municipio, estado, pais, Idioma, cn);
        jdC.jpC = this;
        jdC.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
    String localidad = "", municipio = "", estado = "", pais = "", colonia = "";
    private void tablaColoniaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaColoniaMouseClicked
        // TODO add your handling code here:
        colonia = modelo.getValueAt(tablaColonia.getSelectedRow(), 0) + "";
        localidad = modelo.getValueAt(tablaColonia.getSelectedRow(), 1) + "";  //Estado String
        municipio = modelo.getValueAt(tablaColonia.getSelectedRow(), 2) + "";
        estado = modelo.getValueAt(tablaColonia.getSelectedRow(), 3) + "";
        pais = modelo.getValueAt(tablaColonia.getSelectedRow(), 4) + "";

        if (evt.getClickCount() == 1) {
            System.out.println("1 Clic");
        }
        if (evt.getClickCount() == 2) {
            jdC = new jdColoniaEjido(null, true, "2", colonia, localidad, municipio, estado, pais, Idioma, cn);
            jdC.jpC = this;
            jdC.setVisible(true);
        }
    }//GEN-LAST:event_tablaColoniaMouseClicked

    private void txtBusquedaCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaCKeyReleased
        // TODO add your handling code here:
        busquedaColonia();
    }//GEN-LAST:event_txtBusquedaCKeyReleased

    private void txtBusquedaLKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaLKeyReleased
        // TODO add your handling code here:
        busquedaColonia();
    }//GEN-LAST:event_txtBusquedaLKeyReleased

    private void txtBusquedaMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaMKeyReleased
        // TODO add your handling code here:
        busquedaColonia();
    }//GEN-LAST:event_txtBusquedaMKeyReleased

    private void txtBusquedaEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaEKeyReleased
        // TODO add your handling code here:
        busquedaColonia();
    }//GEN-LAST:event_txtBusquedaEKeyReleased

    private void txtBusquedaPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaPKeyReleased
        // TODO add your handling code here:
        busquedaColonia();
    }//GEN-LAST:event_txtBusquedaPKeyReleased

    private void comboSituacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboSituacionItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_comboSituacionItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (colonia.equals("")) {
            //JOptionPane.showMessageDialog(null, idioma.getProperty("SeleccionRegistro"));
            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    idioma.getProperty("SeleccionRegistro"),
                    idioma.getProperty("TituloMensaje"),
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, // null para icono por defecto.
                    new Object[]{idioma.getProperty("Aceptar")},
                    idioma.getProperty("Aceptar"));
        } else {
            jdC = new jdColoniaEjido(null, true, "2", colonia, localidad, municipio, estado, pais, Idioma, cn);
            jdC.jpC = this;
            jdC.setVisible(true);
            colonia = "";
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (colonia.equals("")) {
            //JOptionPane.showMessageDialog(null,idioma.getProperty("SeleccionRegistro"));
            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    idioma.getProperty("SeleccionRegistro"),
                    idioma.getProperty("TituloMensaje"),
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, // null para icono por defecto.
                    new Object[]{idioma.getProperty("Aceptar")},
                    idioma.getProperty("Aceptar"));
        } else {
            if (comboSituacion.getSelectedIndex() == 0) {
                mdb.actualizarBasicos("UPDATE ejidocolonia SET ID_Situacion=2 where descripcion='" + colonia + "'");
            } else if (comboSituacion.getSelectedIndex() == 1) {
                mdb.actualizarBasicos("UPDATE ejidocolonia SET ID_Situacion=1 where descripcion='" + colonia + "'");
            }
            busquedaColonia();
            colonia = "";
        }
        /*        if (comboSituacion.getSelectedIndex() == 0) {
            mdb.actualizarBasicos("UPDATE ejidocolonia SET ID_Situacion=2 where descripcion='" + colonia + "'");
        } else if (comboSituacion.getSelectedIndex() == 1) {
            mdb.actualizarBasicos("UPDATE ejidocolonia SET ID_Situacion=1 where descripcion='" + colonia + "'");
        }
        busquedaColonia();*/
    }//GEN-LAST:event_jButton4ActionPerformed

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
        busquedaColonia();
    }//GEN-LAST:event_comboSituacionActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.removeAll();
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_jButton5ActionPerformed


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
    private javax.swing.JTable tablaColonia;
    private javax.swing.JTextField txtBusquedaC;
    private javax.swing.JTextField txtBusquedaE;
    private javax.swing.JTextField txtBusquedaL;
    private javax.swing.JTextField txtBusquedaM;
    private javax.swing.JTextField txtBusquedaP;
    // End of variables declaration//GEN-END:variables
}
