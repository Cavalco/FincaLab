/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_Configuraciones_DatosBasicos;

import Idioma.Propiedades;
import Metodos_Configuraciones.metodosDatosBasicos;
import Metodos_Configuraciones.validaConfi;
import com.placeholder.PlaceHolder;
import java.sql.Connection;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Valdez
 */
public class jdMunicipio extends javax.swing.JDialog {

    /**
     * Creates new form jdMunicipio
     */
    metodosDatosBasicos mdb;
    validaConfi valiConf;
    jdMunicipio jdM;
    jpMunicipio jpM;
    Connection cn;
    Propiedades idioma;
    String tipo, municipio, pais, estado;

    public jdMunicipio(java.awt.Frame parent, boolean modal, String tipo, String municipio, String pais, String estado, String Idioma, Connection c) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        cn = c;
        this.tipo = tipo;
        this.municipio = municipio;
        this.estado = estado;
        this.pais = pais;

        mdb = new metodosDatosBasicos(cn, Idioma);
        valiConf = new validaConfi();
        idioma = new Propiedades(Idioma);

        txtMunicipio.setText(municipio);

        jButton2.setText(idioma.getProperty("Aceptar"));
        jButton3.setText(idioma.getProperty("Cancelar"));
        jLabel1.setText(idioma.getProperty("Pais"));
        jLabel3.setText(idioma.getProperty("Estado"));
        jLabel2.setText(idioma.getProperty("Municipio"));
        PlaceHolder holder4 = new PlaceHolder(txtMunicipio, idioma.getProperty("Municipio"));
        
        rellenarCombos();

        if (tipo.equals("1")) {
            setTitle(idioma.getProperty("NuevoMunicipio"));
            // sección para sugerir el país y estado del último municipio capturado
            int e,p;
            e=Integer.parseInt(mdb.devuelveUnDato("select id_estado from municipio order by id desc limit 1"));
            p=Integer.parseInt(mdb.devuelveUnDato("select id_pais from estado where id = "+e));
            comboPais.setSelectedIndex(p);
            comboEstado.setSelectedIndex(e);            
            // fin sección para sugerir el país y estado del último municipio capturado
        } else {
            setTitle(idioma.getProperty("EditarMunicipio"));
            comboPais.setEnabled(false);
            comboEstado.setEnabled(false);

            comboPais.addItem(pais);
            comboEstado.addItem(estado);

            comboPais.setSelectedItem(pais);
            comboEstado.setSelectedItem(estado);
        }

    }

    String[] datos;

    public void rellenarCombos() {
        datos = mdb.cargarCombos("SELECT descripcion from pais").split("¬");
        comboPais.setModel(new DefaultComboBoxModel((Object[]) datos));

        datos = mdb.cargarCombos("SELECT e.descripcion \n"
                + "from estado e \n"
                + "inner join pais p on (e.id_pais=p.id) \n"
                + "where p.Descripcion='" + pais + "'").split("¬");
        comboEstado.setModel(new DefaultComboBoxModel((Object[]) datos));
        //comboEstado.setSelectedItem(estado);
    }

    public void tipoProceso() {
        String sql = "";

        String estado = comboEstado.getSelectedItem() + "";

        if (tipo.equals("1")) {
            //nuevoMunicipio
            if (!comboEstado.getSelectedItem().equals(idioma.getProperty("Seleccione"))
                    || !comboPais.getSelectedItem().equals(idioma.getProperty("Seleccione"))) {
                if (mdb.comprobarExistencia("select descripcion from municipio where descripcion='" + txtMunicipio.getText() + "'") == null) {

                    sql = "INSERT INTO municipio VALUES(null,'" + txtMunicipio.getText() + "', 1, 1,current_date()"
                            + ", current_time(), 1, 1, 1, 1, " + mdb.devuelveId("select id from estado where descripcion='" + estado + "'") + " )";
                    mdb.insertarBasicos(sql);
                    jpM.llenaTablaMunicipios();
                    this.dispose();
                } else {
                    //JOptionPane.showMessageDialog(null, idioma.getProperty("RegistroExistente"));
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
                //JOptionPane.showMessageDialog(null, idioma.getProperty("SeleccionUbicacion"));
                int seleccion = JOptionPane.showOptionDialog(
                    null,
                    idioma.getProperty("SeleccionUbicacion"), 
                    idioma.getProperty("TituloMensaje"),
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,    // null para icono por defecto.
                    new Object[] { idioma.getProperty("Aceptar")},  
                    idioma.getProperty("Aceptar"));                   
            }
        } else {
            //editarMunicipio();
            if (mdb.comprobarExistencia("select descripcion from municipio where descripcion='" + txtMunicipio.getText() + "'") == null) {
                sql = "UPDATE municipio SET  descripcion ='" + txtMunicipio.getText() + "', ID_Estado='" + mdb.devuelveId("select id from estado where descripcion='" + estado + "'") + "' where descripcion='" + municipio + "' ";
                mdb.actualizarBasicos(sql);
                jpM.llenaTablaMunicipios();
                this.dispose();
            } else {
                //JOptionPane.showMessageDialog(null, idioma.getProperty("RegistroExistente"));
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
        txtMunicipio = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        comboEstado = new javax.swing.JComboBox<String>();
        jLabel3 = new javax.swing.JLabel();
        comboPais = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtMunicipio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMunicipioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMunicipioKeyTyped(evt);
            }
        });

        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        comboEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboEstadoItemStateChanged(evt);
            }
        });
        comboEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboEstadoMouseClicked(evt);
            }
        });

        jLabel3.setText("Estado");

        comboPais.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboPaisItemStateChanged(evt);
            }
        });

        jLabel1.setText("Pais");

        jLabel2.setText("Localidad");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton3))
                        .addComponent(txtMunicipio)
                        .addComponent(comboEstado, 0, 280, Short.MAX_VALUE)
                        .addComponent(comboPais, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (txtMunicipio.getText().length() == 0) {
            //JOptionPane.showMessageDialog(null, idioma.getProperty("CamposVacios"));
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void comboEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboEstadoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboEstadoItemStateChanged

    private void comboEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboEstadoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_comboEstadoMouseClicked

    private void comboPaisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboPaisItemStateChanged
        // TODO add your handling code here:
        String p = comboPais.getSelectedItem() + "";
        datos = mdb.cargarCombos("SELECT e.descripcion \n"
                + "from estado e \n"
                + "inner join pais p on (e.id_pais=p.id) \n"
                + "where p.Descripcion='" + p + "'").split("¬");
        comboEstado.setModel(new DefaultComboBoxModel((Object[]) datos));
    }//GEN-LAST:event_comboPaisItemStateChanged

    private void txtMunicipioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMunicipioKeyReleased
        // TODO add your handling code here:
        txtMunicipio.setText(valiConf.primerLetraMayuscula(txtMunicipio.getText()));
    }//GEN-LAST:event_txtMunicipioKeyReleased

    private void txtMunicipioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMunicipioKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtMunicipioKeyTyped

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
            java.util.logging.Logger.getLogger(jdMunicipio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdMunicipio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdMunicipio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdMunicipio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
 /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdMunicipio dialog = new jdMunicipio(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JComboBox<String> comboPais;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtMunicipio;
    // End of variables declaration//GEN-END:variables
}
