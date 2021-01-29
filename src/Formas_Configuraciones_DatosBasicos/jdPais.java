/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_Configuraciones_DatosBasicos;

//import Idioma.Propiedades;
import Idioma.Propiedades;
import Metodos_Configuraciones.metodosDatosBasicos;
import Metodos_Configuraciones.validaConfi;
import java.sql.Connection;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos Valdez
 */
public class jdPais extends javax.swing.JDialog {

    /**
     * Creates new form jdPais
     */
    String tipo, paisC;
    String pais, OIC, UE, ISO;
    Connection cn;
    jpPais jp;
    jdEstado jdE;
    metodosDatosBasicos mdb;
    validaConfi valiConf;
    Propiedades idioma;

    public jdPais(java.awt.Frame parent, boolean modal, String tipo, String paisC, String Idioma, Connection c) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        

        ocultar();

        this.tipo = tipo;
        this.paisC = paisC;
        cn = c;
        mdb = new metodosDatosBasicos(cn,Idioma);
        
        valiConf = new validaConfi();
        
        idioma = new Propiedades(Idioma);
        
        
        jButton1.setText(idioma.getProperty("Aceptar"));;
        jButton2.setText(idioma.getProperty("Cerrar"));;
        jLabel1.setText(idioma.getProperty("Pais"));;
        jLabel2.setText(idioma.getProperty("OIC"));;
        jLabel3.setText(idioma.getProperty("Ue"));;
        jLabel4.setText(idioma.getProperty("ISO"));;
        
        rellenarCampos();
        comparaciones();
             
    }
    
    public void comparaciones() {
        if (tipo.equals("1")) {
            //setTitle("Nuevo País");
            setTitle(idioma.getProperty("NuevoPais"));
            txtPais.setFocusable(true);
        } else {
            //setTitle("Editar Estado");
            setTitle(idioma.getProperty("EditarPais"));
            //txtEstado.setText(estado);
            //comboPais.setEnabled(false);
            //comboPais.addItem(paisC);
            //comboPais.setSelectedItem(paisC);
        }
    }
 

    public void ocultar() {
        txtUE.setVisible(false);
        txtISO.setVisible(false);
        txtOIC.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
    }

    String idPais;

    public void rellenarCampos() {
        if (tipo.equals("2")) {
            String[] campos = mdb.cargarDatosEditar(paisC).split(",");
            idPais = campos[0];
            txtPais.setText(campos[1]);
            //txtOIC.setText(campos[2]);
            //txtUE.setText(campos[3]);
            //txtISO.setText(campos[4]);
        } else {
        }
    }

    public void tipoProceso() {
        try {
            String sql = "";

            pais = txtPais.getText();
            OIC = txtOIC.getText();
            UE = txtUE.getText();
            ISO = txtISO.getText();

            if (tipo.equals("1")) {
                //nuevoPais();
                System.out.println(mdb.comprobarExistencia("select descripcion from pais where descripcion='" + txtPais.getText() + "'"));
                if (mdb.comprobarExistencia("select descripcion from pais where descripcion='" + txtPais.getText() + "'") == null) {
                    sql = "INSERT INTO pais VALUES(null,'" + pais + "', 1, 1,current_date()"
                            + ", current_time(), 1, 1, 1, 1, '" + ISO + "', '" + UE + "', '" + OIC + "')";
                    mdb.insertarBasicos(sql);
                    jp.llenaTablaPais();
                    this.dispose();
                } else {
                    //JOptionPane.showMessageDialog(null, "Dato Repetido");
                    int seleccion = JOptionPane.showOptionDialog(
                        null,
                        idioma.getProperty("RegistroExistente"), 
                        idioma.getProperty("TituloMensaje"),
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,    // null para icono por defecto.
                        new Object[] { idioma.getProperty("Aceptar")},  
                        idioma.getProperty("Aceptar"));   
                }
            } else {
                //editarPais();
                // sql = "UPDATE pais SET  descripcion ='" + pais + "', ISO='" + ISO + "', UE='" + UE + "', OIC='" + OIC + "' where descripcion='" + pais + "' ";
                sql = "UPDATE pais SET  descripcion ='" + pais + "' where descripcion='" + paisC + "' ";
                mdb.actualizarBasicos(sql);
                jp.llenaTablaPais();
                this.dispose();

            }
        } catch (Exception e) {
        }
    }

    /* public void llenaUsuarios() {
        limpiar(tablaUsuarios);
        DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();
        u.cargarUsu(modelo);
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPais = new javax.swing.JTextField();
        txtOIC = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUE = new javax.swing.JTextField();
        txtISO = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("País");

        txtPais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPaisKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaisKeyTyped(evt);
            }
        });

        jLabel2.setText("OIC");

        jLabel3.setText("UE");

        jLabel4.setText("ISO");

        jButton1.setText("Aceptar");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPais)
                    .addComponent(txtOIC, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(txtUE, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(txtISO, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtOIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtISO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (txtPais.getText().length() == 0) {
            //JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            int seleccion = JOptionPane.showOptionDialog(
                null,
                idioma.getProperty("CamposVacios"), 
                idioma.getProperty("TituloMensaje"),
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,    // null para icono por defecto.
                new Object[] { idioma.getProperty("Aceptar")},  
                idioma.getProperty("Aceptar"));              
        } else {
            tipoProceso();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtPaisKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaisKeyReleased
        // TODO add your handling code here:
        if (txtPais.getText().length() != 0) {
            txtPais.setText(valiConf.primerLetraMayuscula(txtPais.getText()).replace("S/n", "S/N"));
            txtPais.setText(valiConf.primerLetraMayuscula(txtPais.getText()).replace("S/d", "S/D"));
            txtPais.setText(valiConf.primerLetraMayuscula(txtPais.getText()).replace("S/o", "S/O"));
        }
    }//GEN-LAST:event_txtPaisKeyReleased

    private void txtPaisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaisKeyTyped
        //No admitir numeros
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtPaisKeyTyped

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
            java.util.logging.Logger.getLogger(jdPais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdPais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdPais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdPais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtISO;
    private javax.swing.JTextField txtOIC;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtUE;
    // End of variables declaration//GEN-END:variables
}
