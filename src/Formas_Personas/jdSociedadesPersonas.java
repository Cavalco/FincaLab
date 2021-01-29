/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_Personas;

import Formas_FincaCert.jdFormularioProductor;
import Formas_Configuraciones_Recepcion.*;
import Idioma.Propiedades;
import Metodos_Configuraciones.metodosDatosBasicos;
import java.sql.Connection;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos Valdez
 */
public class jdSociedadesPersonas extends javax.swing.JDialog {

    /**
     * Creates new form jdFormaProceso
     */
    Connection cn;
    String tipoOperacion, nombre, idPersona, tipoPersona, Idioma;
    metodosDatosBasicos mdb;
    Propiedades idioma;
    jpEvaluaciones jpE;
    jdFormularioProductor jdFP;

    public jdSociedadesPersonas(java.awt.Frame parent, boolean modal, String tipoOperacion, String tipoPersona, String nombre, String idPersona, String Idioma, Connection c) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        cn = c;
        this.idPersona = idPersona;
        this.Idioma = Idioma;
        this.tipoOperacion = tipoOperacion;
        this.nombre = nombre;
        this.tipoPersona = tipoPersona;
        mdb = new metodosDatosBasicos(cn, Idioma);
        idioma = new Propiedades(Idioma);

        llenarTabla();
        //lblPregunta.setText(tipoPregunta);
        setTitle(idioma.getProperty("Sociedades"));
        tablaSociedades.getColumnModel().getColumn(0).setHeaderValue(idioma.getProperty("Sociedad"));
        tablaSociedades.getColumnModel().getColumn(1).setHeaderValue(idioma.getProperty("Seleccione"));
        labelPersona.setText(nombre);

        //JOptionPane.showMessageDialog(null, "Tipo Operacion=" + tipoOperacion + " - Tipo Persona=" + tipoPersona + " - id=" + idPersona);
        rellenar();

    }

    public void llenarTabla() {
        limpiar(tablaSociedades);
        DefaultTableModel modelo = (DefaultTableModel) tablaSociedades.getModel();
        mdb.cargarInformacion2(modelo, 1, "select razonsocial from personam order by razonsocial asc");
    }

    public void rellenar() {

        String estadoSocio;
        if (tipoPersona.equals("1")) {
            estadoSocio = mdb.devuelveUnDato("select estadoSocio from personaf where id=" + idPersona);
        } else {
            estadoSocio = mdb.devuelveUnDato("select estadoSocio from personam where id=" + idPersona);
        }

        //1 Socio Activado
        if (estadoSocio.equals("1")) {
            jRadioButton1.setSelected(true);
            lblPregunta.setText("¿A que sociedades perteneces?");
        } else if (estadoSocio.equals("2")) { //2 No Asociado Activado
            jRadioButton2.setSelected(true);
            lblPregunta.setText("¿En que sociedades participas?");
        } else {
            //0 Ninguno activado
        }

        DefaultTableModel modelo = (DefaultTableModel) tablaSociedades.getModel();
        String[] datos;

        if (tipoPersona.equals("1")) {
            datos = mdb.generadorStrings("select p.razonsocial \n"
                    + "from sociedadespersona a\n "
                    + "inner join personam p on (a.ID_asociado=p.ID)\n "
                    + "where a.id_persona= " + idPersona + " and a.tipoPersona=1 order by p.razonsocial asc").split("¬");

            //labelPersona.setText(mdb.devuelveUnDato("select concat(nombre,' ',apellidomaterno,' ',apellidopaterno) as nombre from personaf where id=" + idPersona));
        } else {
            datos = mdb.generadorStrings("select p.razonsocial \n"
                    + "from sociedadespersona a\n "
                    + "inner join personam p on (a.ID_asociado=p.ID)\n "
                    + "where a.id_persona= " + idPersona + " and a.tipoPersona=2 order by p.razonsocial asc").split("¬");

            //labelPersona.setText(mdb.devuelveUnDato("select razonsocial from personam where id=" + idPersona));
        }
        int e = 0;
        //System.out.println("Tamaño datos= " + datos.length);
        for (int i = 0; i < modelo.getRowCount(); i++) {
            System.out.println("i =" + i + " --- " + " e =" + e);
            if (e == datos.length) {
                break;
            } else {
                if (modelo.getValueAt(i, 0).equals(datos[e])) {
                    //System.out.println("Vuelta # "+e+ "-- Dato BD= "+datos[e]+ " = "+modelo.getValueAt(i,0));
                    modelo.setValueAt(true, i, 1);
                    e = e + 1;
                }
            }
        }
    }

    /*    public void abrirFormulario(String formulario) {
        //JOptionPane.showMessageDialog(null, "Entre al case");
        switch (formulario) {
            case "Productor":
                jdFP = new jdFormularioProductor(null, true, idPersona, tipoPregunta,tipoPersona, cn);
                jdFP.setVisible(true);
                break;
        }
    }
     */
    public void tipoOperacion() {
        DefaultTableModel modelo = (DefaultTableModel) tablaSociedades.getModel();

        if (tipoOperacion.equals("1")) {

            if (tipoPersona.equals("1")) {
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    String desc = modelo.getValueAt(i, 0) + "";
                    String valor = modelo.getValueAt(i, 1) + "";
                    if (valor.equals("true")) {
                        String idPM = mdb.devuelveId("select id from personam where razonsocial='" + desc + "'");
                        mdb.insertarEnCiclo("INSERT INTO sociedadespersona VALUES(null, " + idPersona + "," + idPM + ", 1 )");
                    }
                }
                JOptionPane.showMessageDialog(null, "Inserción Exitosa");
            } else {
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    String desc = modelo.getValueAt(i, 0) + "";
                    String valor = modelo.getValueAt(i, 1) + "";
                    if (valor.equals("true")) {
                        String idPM = mdb.devuelveId("select id from personam where razonsocial='" + desc + "'");
                        mdb.insertarEnCiclo("INSERT INTO sociedadespersona VALUES(null, " + idPersona + "," + idPM + ", 2 )");
                    }
                }
                JOptionPane.showMessageDialog(null, "Inserción Exitosa");

            }

        } else if (tipoOperacion.equals("2")) {

            if (tipoPersona.equals("1")) {
                mdb.actualizarBasicos("delete from sociedadespersona where id_persona=" + idPersona + " and tipoPersona=1");

                for (int i = 0; i < modelo.getRowCount(); i++) {
                    String desc = modelo.getValueAt(i, 0) + "";
                    String valor = modelo.getValueAt(i, 1) + "";
                    if (valor.equals("true")) {
                        String idPM = mdb.devuelveId("select id from personam where razonsocial='" + desc + "'");
                        mdb.insertarEnCiclo("INSERT INTO sociedadespersona VALUES(null, " + idPersona + "," + idPM + ",1 )");
                    }
                }

            } else {

                mdb.actualizarBasicos("delete from sociedadespersona where id_persona=" + idPersona + " and tipoPersona=2");

                for (int i = 0; i < modelo.getRowCount(); i++) {
                    String desc = modelo.getValueAt(i, 0) + "";
                    String valor = modelo.getValueAt(i, 1) + "";
                    if (valor.equals("true")) {
                        String idPM = mdb.devuelveId("select id from personam where razonsocial='" + desc + "'");
                        mdb.insertarEnCiclo("INSERT INTO sociedadespersona VALUES(null, " + idPersona + "," + idPM + ",2 )");
                    }
                }
            }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSociedades = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblPregunta = new javax.swing.JLabel();
        labelPersona = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaSociedades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Sociedad", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaSociedades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaSociedadesMouseClicked(evt);
            }
        });
        tablaSociedades.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaSociedadesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablaSociedades);
        if (tablaSociedades.getColumnModel().getColumnCount() > 0) {
            tablaSociedades.getColumnModel().getColumn(0).setResizable(false);
            tablaSociedades.getColumnModel().getColumn(1).setMinWidth(60);
            tablaSociedades.getColumnModel().getColumn(1).setPreferredWidth(60);
            tablaSociedades.getColumnModel().getColumn(1).setMaxWidth(60);
        }

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cerrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblPregunta.setText("pregunta");

        labelPersona.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelPersona.setText("-");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jRadioButton1.setText("Socio");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("No Asociado");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccione ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPersona)
                            .addComponent(lblPregunta))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPersona)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPregunta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        tipoOperacion();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaSociedadesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaSociedadesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaSociedadesKeyReleased
    String valorTB = "", sociedad = "";
    private void tablaSociedadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaSociedadesMouseClicked
        // TODO add your handling code here:
/*        sociedad = tablaSociedades.getValueAt(tablaSociedades.getSelectedRow(), 0) + "";
        valorTB = tablaSociedades.getValueAt(tablaSociedades.getSelectedRow(), 1) + "";

        if (valorTB.equals("true")) {

            if (mdb.comprobarExistencia("select id from sociedadespersona where id_personafisica=" + idPersona + " and id_personamoral =" + mdb.devuelveId("select id from personam where razonsocial='" + sociedad + "'") + " ") == null) {
                mdb.insertarBasicos("insert into asignacionespersona "
                        + "values (null," + idPersona + ", " + mdb.devuelveId("select id from personam where razonsocial='" + sociedad + "'") + ")");

                int result = JOptionPane.showConfirmDialog(null, "¿Deseas añadir la información de '" + sociedad + "' ?",
                        null, JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    abrirFormulario(sociedad);
                } else {
                    JOptionPane.showMessageDialog(null, "Información Pendiente");
                }
            }
        }*/
    }//GEN-LAST:event_tablaSociedadesMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        if (tipoPersona.equals("1")) {
            mdb.actualizarBasicos("update personaf set estadoSocio=1 where id=" + idPersona);
        } else {
            mdb.actualizarBasicos("update personaf set estadoSocio=1 where id=" + idPersona);
        }

        lblPregunta.setText("¿A que sociedades perteneces?");
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        if (tipoPersona.equals("1")) {
            mdb.actualizarBasicos("update personaf set estadoSocio=2 where id=" + idPersona);
        } else {
            mdb.actualizarBasicos("update personaf set estadoSocio=2 where id=" + idPersona);
        }

        lblPregunta.setText("¿En que sociedades participas?");
    }//GEN-LAST:event_jRadioButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(jdSociedadesPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdSociedadesPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdSociedadesPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdSociedadesPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelPersona;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JTable tablaSociedades;
    // End of variables declaration//GEN-END:variables
}
