/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormasGenerales;

import Conexion.Conexion;
import Idioma.Propiedades;
import Metodos_Configuraciones.metodosDatosBasicos;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Cronos
 */
public class pantallaLogin extends javax.swing.JFrame {

    metodosDatosBasicos mdb;
    pantallaPrincipal pPrin;
    Propiedades idioma;
    Connection cn;

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Imagenes/icon_flab32x32.png"));

        return retValue;
    }

    /**
     * Creates new form pantallaLogin
     */
    public pantallaLogin() throws ParseException {
        initComponents();
        setLocationRelativeTo(null);

        ///  this.cn = cn = (new Conexion()).conectar();
        //  mdb = new metodosDatosBasicos(cn,comboIdioma.getSelectedItem() + "");
        //pPrin = new pantallaPrincipal(cn);
        //  traductor();
    }

    public void conectando() {
        String bd = "";
        switch (comboBaseDatos.getSelectedItem() + "") {
            case "Seleccione":
                
                bd = "prueba_bh";
                break;
            case "Astal":
                bd = "fincalab_astal";
                break;
            case "Caldio":
                bd = "fincalab_caldio";
                break;
            case "Cafeico":
                bd = "fincalab_cafeico";
                break;
            case "Basilio/Riviera":
                bd = "fincalab_basilio";
                break;
            case "Tambor":
                bd = "fincalab_tambor";
                break;
            case "Procaa":
                bd = "fincalab2019_procca";
                break;
            case "Cuerno":
                bd = "fincalab_cuerno";
                break;
        }

        cn = (new Conexion()).conectar(bd);
        mdb = new metodosDatosBasicos(cn, comboIdioma.getSelectedItem() + "");
        //pPrin = new pantallaPrincipal(cn);
        traductor();
    }

    public void traductor() {
        idioma = new Propiedades(comboIdioma.getSelectedItem() + "");

//        jLabel1.setText(idioma.getProperty("Usuario"));
        // jLabel2.setText(idioma.getProperty("Contrasena"));
        // jLabel3.setText(idioma.getProperty("Idioma"));
        jButton1.setText(idioma.getProperty("Ingresar"));
        jButton2.setText(idioma.getProperty("Salir"));

        setTitle(idioma.getProperty("Bienvenida"));
    }

    public void validarLogin() throws ParseException {

        String linea = mdb.devolverLineaDatos("select id,usuario, contrasena, fechaCaducidad,id_situacion "
                + "from usuarios where usuario='" + txtUsuario.getText() + "' and contrasena='" + txtContrasena.getText() + "'", 5);
        String datos[] = linea.split("¬");

        if (!linea.equals("")) {
            validarFechas(datos[3], datos[1]);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario No Existe");
        }

        linea = mdb.devolverLineaDatos("select id,usuario, contrasena, fechaCaducidad,id_situacion "
                + "from usuarios where usuario='" + txtUsuario.getText() + "' and contrasena='" + txtContrasena.getText() + "'", 5);
        String datos2[] = linea.split("¬");

        if (!linea.equals("")) {
            if (datos2[4].equals("1")) {
                pPrin = new pantallaPrincipal(datos[0], comboIdioma.getSelectedItem() + "", cn);
                pPrin.setVisible(true);
                this.dispose();
            } else if (datos2[4].equals("0")) {
                JOptionPane.showMessageDialog(null, "Usuario Inactivo");
            }
        } else {
            //JOptionPane.showMessageDialog(null, "Usuario Inexistente");
            txtUsuario.setText("");
            txtContrasena.setText("");
            txtUsuario.requestFocus();
        }
    }

    public void validarFechas(String fechaBaseDatos, String usuario) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();
        Date date2 = sdf.parse(fechaBaseDatos);

        if (date.after(date2) == false) {
            System.out.println("Vigente");
        } else {
            mdb.desactivarUsuario("update usuarios set id_situacion=0 where usuario='" + usuario + "'");
        }

        System.out.println("Fecha Sistema " + date + "\nFecha Base D " + date2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboBaseDatos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        comboIdioma = new javax.swing.JComboBox<>();
        txtContrasena = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comboBaseDatos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Astal", "Caldio", "Basilio/Riviera", "Cafeico", "Procaa", "Cuerno", "Tambor" }));
        getContentPane().add(comboBaseDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 120, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/loginFincalab2.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 620));

        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 424, 150, 40));

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 424, 140, 40));

        comboIdioma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Español", "Ingles", "Ingles Etiopia", "Oromo" }));
        comboIdioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboIdiomaActionPerformed(evt);
            }
        });
        getContentPane().add(comboIdioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 330, 230, 60));

        txtContrasena.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtContrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContrasenaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContrasenaKeyTyped(evt);
            }
        });
        getContentPane().add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 210, 240, 60));

        txtUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 90, 240, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboIdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboIdiomaActionPerformed
        // TODO add your handling code here:
        traductor();
    }//GEN-LAST:event_comboIdiomaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            conectando();
            validarLogin();
        } catch (ParseException ex) {
            Logger.getLogger(pantallaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtContrasenaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContrasenaKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtContrasenaKeyTyped

    private void txtContrasenaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContrasenaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                conectando();
                validarLogin();
            } catch (ParseException ex) {
                Logger.getLogger(pantallaLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtContrasenaKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
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
            java.util.logging.Logger.getLogger(pantallaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantallaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantallaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantallaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new pantallaLogin().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(pantallaLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBaseDatos;
    private javax.swing.JComboBox<String> comboIdioma;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
