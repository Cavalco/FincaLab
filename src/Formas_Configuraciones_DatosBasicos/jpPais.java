/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_Configuraciones_DatosBasicos;

import FormasGenerales.pantallaPrincipal;
import Idioma.Propiedades;
import MetodosGenerales.ClaseTable;
import Metodos_Configuraciones.metodosDatosBasicos;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 *
 * @author Carlos Valdez
 */
public class jpPais extends javax.swing.JPanel {

    /**
     * Creates new form jpPais
     */
    pantallaPrincipal fprin;
    jdPais jdP;
    metodosDatosBasicos mdb;
    DefaultTableModel modelo, modelo2;
    //TableRowSorter<TableModel> modeloOrdenado;
    Connection cn;
    Propiedades idioma;
    String Idioma;

    public jpPais(Connection c, String Idioma) {
        initComponents();
        cn = c;
        mdb = new metodosDatosBasicos(cn,Idioma);
        modelo = (DefaultTableModel) tablaPais.getModel();
        this.Idioma = Idioma;
        //modelo = (DefaultTableModel) tablaPais.getModel();
        //tablaPais.setRowSorter(new TableRowSorter(modeloOrdenado));
        //modelo2 = (DefaultTableModel) tablaPais.getModel();
        //tablaPais.setFillsViewportHeight(true);
        //tablaPais.setAutoCreateRowSorter(true);
        //modeloOrdenado = new TableRowSorter<TableModel>(modelo);
        //tablaPais.setRowSorter(modeloOrdenado);

        /*      DefaultTableModel tablaPedidos = (DefaultTableModel) tablaPais.getModel();
        RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tablaPedidos);
        tablaPais.setRowSorter(sorter);
         */
        idioma = new Propiedades(Idioma);
        jButton2.setText(idioma.getProperty("Nuevo"));
        jButton3.setText(idioma.getProperty("Editar"));
        jButton4.setText(idioma.getProperty("Desactivar"));
        jButton5.setText(idioma.getProperty("Cerrar"));
        jLabel10.setText(idioma.getProperty("Situacion"));
        jLabel6.setText(idioma.getProperty("Pais"));
        //jLabel7.settext(idioma.getProperty("OIC"));;
        //jLabel8.settext(idioma.getProperty("UE"));;
        //jLabel9.settext(idioma.getProperty("ISO"));;

        tablaPais.getColumnModel().getColumn(0).setHeaderValue(idioma.getProperty("Pais"));

        comboSituacion.addItem(idioma.getProperty("Activos"));
        comboSituacion.addItem(idioma.getProperty("Inactivos"));
        comboSituacion.addItem(idioma.getProperty("Todos"));

        txtBusquedaUE.setVisible(false);
        txtBusquedaISO.setVisible(false);
        txtBusquedaOIC.setVisible(false);
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
        
        //Place Holder
        PromptSupport.setPrompt(idioma.getProperty("Pais"), txtBusquedaP);

        //  ClaseTable.ordernar(tablaPais);
        llenaTablaPais();

        /* tablaPais.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int col = tablaPais.columnAtPoint(e.getPoint());
                String name = tablaPais.getColumnName(col);
                System.out.println("Column index selected " + col + " " + name);
                ordena(name);
            }
        });*/
    }

    /*  public void ordena(String name) {

        String sql = "SELECT descripcion, OIC, UE, ISO from pais WHERE ID_SItuacion=1 order by descripcion asc";
        limpiar(tablaPais);
        mdb.cargarInformacion2(modelo, 4, sql);
    }*/
    public void llenaTablaPais() {
        limpiar(tablaPais);
        mdb.cargarInformacion2(modelo, 1, "select descripcion from pais where ID_Situacion=1");
    }

    public void busquedaPais() {
        String tipoP = "";
        String tipoOIC = "";
        String tipoUE = "";
        String tipoISO = "";
        String situacion = "";
        situacion = comboSituacion.getSelectedIndex() + "";

        if (situacion.equals("1")) {
            situacion = "2";
        } else if (situacion.equals("0")) {
            situacion = "1";
        } else {
            situacion = "3";
        }

        if (txtBusquedaP.getText().length() > 0) {
            tipoP = "AND descripcion like '" + txtBusquedaP.getText() + "%'";
        }
        /*    if (txtBusquedaOIC.getText().length() > 0) {
            tipoOIC = "AND OIC like '" + txtBusquedaOIC.getText() + "%'";
        }
        if (txtBusquedaUE.getText().length() > 0) {
            tipoUE = "AND UE like '" + txtBusquedaUE.getText() + "%'";
        }
        if (txtBusquedaISO.getText().length() > 0) {
            tipoISO = "AND ISO like '" + txtBusquedaISO.getText() + "%'";
        }*/
        String sql;
        //JOptionPane.showMessageDialog(null, situacion);
        if (situacion.equals("3")) {
            sql = "SELECT descripcion from pais where ID_Situacion <> 3 " + tipoP + " " + tipoOIC + " " + tipoUE + " " + tipoISO;
        } else {
            sql = "SELECT descripcion from pais WHERE ID_Situacion = " + situacion + " " + tipoP + " " + tipoOIC + " " + tipoUE + " " + tipoISO;
        }
        // JOptionPane.showMessageDialog(null, sql);
        limpiar(tablaPais);
        mdb.cargarInformacion2(modelo, 1, sql);

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
        txtBusquedaP = new javax.swing.JTextField();
        txtBusquedaOIC = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtBusquedaUE = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtBusquedaISO = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPais = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        comboSituacion = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setPreferredSize(new java.awt.Dimension(830, 570));

        jLabel6.setText("País");

        txtBusquedaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaPActionPerformed(evt);
            }
        });
        txtBusquedaP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaPKeyReleased(evt);
            }
        });

        txtBusquedaOIC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaOICKeyReleased(evt);
            }
        });

        jLabel7.setText("OIC");

        txtBusquedaUE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaUEKeyReleased(evt);
            }
        });

        jLabel8.setText("UE");

        txtBusquedaISO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaISOKeyReleased(evt);
            }
        });

        jLabel9.setText("ISO");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtBusquedaP, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtBusquedaOIC, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtBusquedaUE, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtBusquedaISO, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusquedaISO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusquedaUE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusquedaOIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusquedaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaPais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "País"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPaisMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaPaisMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tablaPais);

        jLabel10.setText("Situacion");

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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
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
        jdP = new jdPais(null, true, "1", pais, Idioma, cn);
        jdP.jp = this;
        jdP.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (pais.equals("")) {
            //JOptionPane.showMessageDialog(null,idioma.getProperty("SeleccionRegistro"));
            int seleccion = JOptionPane.showOptionDialog(
                null,
                idioma.getProperty("SeleccionRegistro"), 
                idioma.getProperty("TituloMensaje"),
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,    // null para icono por defecto.
                new Object[] { idioma.getProperty("Aceptar")},  
                idioma.getProperty("Aceptar"));
        } else {
            jdP = new jdPais(null, true, "2", pais, Idioma, cn);
            jdP.jp = this;
            jdP.setVisible(true);
            pais="";
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    String pais = "";
    private void tablaPaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPaisMouseClicked
        // TODO add your handling code here:
        modelo2 = (DefaultTableModel) tablaPais.getModel();
        pais = modelo2.getValueAt(tablaPais.getSelectedRow(), 0) + "";  //pais

        /*   System.out.println("---------------MODELO NUMERO 1---------------------");
        for(int i=0; i<modelo.getRowCount(); i++){
            System.out.println(modelo.getValueAt(i, 0)+"");
        }
        
        System.out.println("---------------MODELO NUMERO 2---------------------");
        for(int i=0; i<modelo2.getRowCount(); i++){
            System.out.println(modelo2.getValueAt(i, 0)+"");
        }*/
        if (evt.getClickCount() == 1) {
            //System.out.println("1 Clic");
        }
        if (evt.getClickCount() == 2) {
            jdP = new jdPais(null, true, "2", pais, Idioma, cn);
            jdP.jp = this;
            jdP.setVisible(true);
        }
    }//GEN-LAST:event_tablaPaisMouseClicked

    private void txtBusquedaPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaPKeyReleased
        // TODO add your handling code here:
        busquedaPais();
    }//GEN-LAST:event_txtBusquedaPKeyReleased

    private void txtBusquedaOICKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaOICKeyReleased
        // TODO add your handling code here:
        //busquedaPais();
    }//GEN-LAST:event_txtBusquedaOICKeyReleased

    private void txtBusquedaUEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaUEKeyReleased
        // TODO add your handling code here:
        //busquedaPais();
    }//GEN-LAST:event_txtBusquedaUEKeyReleased

    private void txtBusquedaISOKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaISOKeyReleased
        // TODO add your handling code here:
        //busquedaPais();
    }//GEN-LAST:event_txtBusquedaISOKeyReleased

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
        if (pais.equals("")) {
            //JOptionPane.showMessageDialog(null,idioma.getProperty("SeleccionRegistro"));
            int seleccion = JOptionPane.showOptionDialog(
                null,
                idioma.getProperty("SeleccionRegistro"), 
                idioma.getProperty("TituloMensaje"),
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,    // null para icono por defecto.
                new Object[] { idioma.getProperty("Aceptar")},  
                idioma.getProperty("Aceptar"));
        } else {        
            if (comboSituacion.getSelectedIndex() == 0) {
              mdb.actualizarBasicos("UPDATE pais SET ID_Situacion=2 where descripcion='" + pais + "'");
            } else if (comboSituacion.getSelectedIndex() == 1) {
              mdb.actualizarBasicos("UPDATE pais SET ID_Situacion=1 where descripcion='" + pais + "'");
            }
            busquedaPais();
            pais="";
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tablaPaisMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPaisMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaPaisMousePressed

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
        busquedaPais();
    }//GEN-LAST:event_comboSituacionActionPerformed

    private void txtBusquedaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaPActionPerformed
        // TODO add your handling code here:
        busquedaPais();
    }//GEN-LAST:event_txtBusquedaPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> comboSituacion;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton4;
    public javax.swing.JButton jButton5;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel5;
    public javax.swing.JPanel jPanel6;
    public javax.swing.JPanel jPanel7;
    public javax.swing.JPanel jPanel8;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tablaPais;
    public javax.swing.JTextField txtBusquedaISO;
    public javax.swing.JTextField txtBusquedaOIC;
    public javax.swing.JTextField txtBusquedaP;
    public javax.swing.JTextField txtBusquedaUE;
    // End of variables declaration//GEN-END:variables
}
