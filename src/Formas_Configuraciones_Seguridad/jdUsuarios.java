/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_Configuraciones_Seguridad;

import Idioma.Propiedades;
import Metodos_Configuraciones.metodosDatosBasicos;
import Metodos_Configuraciones.validaConfi;
import com.placeholder.PlaceHolder;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos Valdez
 */
public class jdUsuarios extends javax.swing.JDialog {

    /**
     * Creates new form jdPais
     */
    String tipo, PerfilesC;
    String Perfiles, nombre, id;
    Connection cn;
    jpUsuarios jp;
    validaConfi valiConf;
    metodosDatosBasicos mdb;
    Propiedades idioma;
    String Idioma, idPersonaE;

    public jdUsuarios(java.awt.Frame parent, boolean modal, String tipo, String PerfilesC, String nombre, String idPersonaE, String Idioma, Connection c) throws ParseException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        this.tipo = tipo;
        this.PerfilesC = PerfilesC;
        this.Idioma = Idioma;
        this.nombre = nombre;
        this.idPersonaE = idPersonaE;
        cn = c;
        valiConf = new validaConfi();
        idioma = new Propiedades(Idioma);
        mdb = new metodosDatosBasicos(cn, Idioma);

        traductor();

        String datos[] = mdb.cargarCombos("SELECT CONCAT(Nombre, ', ', apellidoPaterno, ', ', apellidoMaterno) from personaf").split("¬");
        comboPersonas.setModel(new DefaultComboBoxModel((Object[]) datos));

        if (tipo.equals("Nuevo")) {
            setTitle(idioma.getProperty("NuevoUsuario"));
        } else {
            setTitle(idioma.getProperty("EditarUsuario"));
            //JOptionPane.showMessageDialog(null,nombre);
            comboPersonas.setSelectedItem(nombre);
            txtUsuario.setText(PerfilesC);
            String linea = mdb.devolverLineaDatos("select id, contrasena, fechaCaducidad,id_situacion "
                    + "configurador, personas, fincacert, recepcion, beneficiohumedo, sociedades, "
                    + "laboratorio, almacen "
                    + "from usuarios where usuario = '" + txtUsuario.getText() + "'", 9);
            String datos2[] = linea.split("¬");

            if (!linea.equals("")) {
                txtContraseña.setText(datos2[1]);
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaDate = null;
                
                if (!datos[2].equals("")) {
                    fechaDate = formato.parse(datos2[2]);
                    jDateChooser1.setDate(fechaDate);
                }
                marcarChecks();
            }/* else {
            JOptionPane.showMessageDialog(null, "Usuario No Existe");
        }*/
        }
        
    }

    /*public void ponerDatos(String datos2[]){
        
    } */
    public void marcarChecks() {
        if (mdb.devuelveUnDato("select configurador from usuarios "
                + "where usuario = '" + PerfilesC + "'").equals("1")) {
            jCheckBox1.setSelected(true);
        }
        if (mdb.devuelveUnDato("select personas from usuarios "
                + "where usuario = '" + PerfilesC + "'").equals("1")) {
            jCheckBox2.setSelected(true);
        }
        if (mdb.devuelveUnDato("select fincacert from usuarios "
                + "where usuario = '" + PerfilesC + "'").equals("1")) {
            jCheckBox3.setSelected(true);
        }
        if (mdb.devuelveUnDato("select recepcion from usuarios "
                + "where usuario = '" + PerfilesC + "'").equals("1")) {
            jCheckBox6.setSelected(true);
        }
        if (mdb.devuelveUnDato("select beneficiohumedo from usuarios "
                + "where usuario = '" + PerfilesC + "'").equals("1")) {
            jCheckBox5.setSelected(true);
        }
        if (mdb.devuelveUnDato("select sociedades from usuarios "
                + "where usuario = '" + PerfilesC + "'").equals("1")) {
            jCheckBox4.setSelected(true);
        }
        if (mdb.devuelveUnDato("select laboratorio from usuarios "
                + "where usuario = '" + PerfilesC + "'").equals("1")) {
            jCheckBox7.setSelected(true);
        }
        if (mdb.devuelveUnDato("select almacen from usuarios "
                + "where usuario = '" + PerfilesC + "'").equals("1")) {
            jCheckBox8.setSelected(true);
        }
    }

    public void traductor() {
        jLabel3.setText(idioma.getProperty("Persona"));
        jLabel2.setText(idioma.getProperty("Usuario"));
        jLabel4.setText(idioma.getProperty("Contrasena"));
        jLabel5.setText(idioma.getProperty("AsignacionModulos"));
        jLabel6.setText(idioma.getProperty("FechaCaducidad"));

        jCheckBox1.setText(idioma.getProperty("Configuracion"));
        jCheckBox2.setText(idioma.getProperty("Personas"));
        jCheckBox3.setText(idioma.getProperty("FincaCert"));
        jCheckBox4.setText(idioma.getProperty("Sociedades"));
        jCheckBox5.setText(idioma.getProperty("BeneficioHumedo"));
        jCheckBox6.setText(idioma.getProperty("Recepcion"));
        jCheckBox7.setText(idioma.getProperty("Laboratorio"));
        jCheckBox8.setText(idioma.getProperty("Almacen"));        

        jButton1.setText(idioma.getProperty("Guardar"));
        jButton2.setText(idioma.getProperty("Cancelar"));
    }

    public void tipoOperacion() {
        String vConfi, vPerson, vFinca, vRecep, vBene, vLab, vSocie, vAlm;
        String fecha = new SimpleDateFormat("yyyy-MM-dd").format(jDateChooser1.getDate());

        if (jCheckBox1.isSelected()) {
            vConfi = "1";
        } else {
            vConfi = "0";
        }

        if (jCheckBox2.isSelected()) {
            vPerson = "1";
        } else {
            vPerson = "0";
        }

        if (jCheckBox3.isSelected()) {
            vFinca = "1";
        } else {
            vFinca = "0";
        }

        if (jCheckBox4.isSelected()) {
            vSocie = "1";
        } else {
            vSocie = "0";
        }

        if (jCheckBox5.isSelected()) {
            vBene = "1";
        } else {
            vBene = "0";
        }

        if (jCheckBox6.isSelected()) {
            vRecep = "1";
        } else {
            vRecep = "0";
        }

        if (jCheckBox7.isSelected()) {
            vLab = "1";
        } else {
            vLab = "0";
        }

        if (jCheckBox8.isSelected()) {
            vAlm = "1";
        } else {
            vAlm = "0";
        }
        
        if (tipo.equals("Nuevo")) {

            if (!mdb.devuelveId("select id from usuarios where usuario='" + txtUsuario.getText() + "' ").equals("")) {
                JOptionPane.showMessageDialog(null, "Usuario Existente");
            } else {
                mdb.insertarBasicos("insert into usuarios values(null, " + idPersona + ", '" + txtUsuario.getText() + "', "
                        + "'" + txtContraseña.getText() + "', '" + fecha + "', " + vConfi + ", " + vPerson + "," + vFinca + "," + vRecep + "," + vBene + "," + vLab + "," + vSocie + "," + vAlm + ", '1' ) ");
                jp.busquedaUsuarios();
            }
        } else if (tipo.equals("Editar")) {
            mdb.actualizarBasicos("UPDATE usuarios SET usuario ='" + txtUsuario.getText() + "', "
                    + "contrasena='" + txtContraseña.getText() + "',"
                    + "fechaCaducidad='" + fecha + "',"
                    + "configurador=" + vConfi + ", personas=" + vPerson + ", fincacert=" + vFinca + ", recepcion=" + vRecep + ", beneficiohumedo=" + vBene + ", laboratorio=" + vLab +", sociedades=" + vSocie + ", almacen=" + vAlm + " "
                    + "where idPersona=" + idPersonaE);
            jp.busquedaUsuarios();
            this.dispose();
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
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboPersonas = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuarios del Sistema");
        setResizable(false);

        jLabel2.setText("Usuario");

        jLabel3.setText("Persona");

        comboPersonas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPersonasActionPerformed(evt);
            }
        });

        jLabel4.setText("Contraseña");

        jLabel5.setText("Asignación de Modulos");

        jCheckBox1.setText("Configurador");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Personas");

        jCheckBox3.setText("FincaCert");

        jCheckBox4.setText("Sociedades");

        jCheckBox5.setText("Beneficio Humedo");

        jCheckBox6.setText("Recepcion");

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Usuario");

        jDateChooser1.setDateFormatString("dd/MMM/yyyy");

        jCheckBox7.setText("Laboratorio");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        jCheckBox8.setText("Almacen");
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(comboPersonas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox3)
                                    .addComponent(jCheckBox2)
                                    .addComponent(jCheckBox1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox5)
                                    .addComponent(jCheckBox4)
                                    .addComponent(jCheckBox6))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCheckBox7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCheckBox8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel6))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtContraseña))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox6)
                            .addComponent(jCheckBox7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox5)
                            .addComponent(jCheckBox8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox4)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
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
        tipoOperacion();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed
    String idPersona;
    private void comboPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPersonasActionPerformed
        // TODO add your handling code here:
        String persona = comboPersonas.getSelectedItem() + "";
        String datos[] = persona.split(",");

        idPersona = mdb.devuelveUnDato("select id from personaf where nombre='" + datos[0] + "' "
                + "and apellidopaterno='" + datos[1].trim() + "' and apellidomaterno='" + datos[2].trim() + "'");
    }//GEN-LAST:event_comboPersonasActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
 /*        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jdPais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdPais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdPais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdPais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the dialog */
 /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdPais dialog = new jdPais(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        //</editor-fold>

        /* Create and display the dialog */
 /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdPais dialog = new jdPais(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> comboPersonas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
