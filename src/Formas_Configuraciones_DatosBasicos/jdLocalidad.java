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
public class jdLocalidad extends javax.swing.JDialog {

    /**
     * Creates new form jdLocalidad
     */
    metodosDatosBasicos mdb;
    validaConfi valiConf;
    Connection cn;
    jpLocalidad jpL;
    Propiedades idioma;
    String l, m, e, p, tipo;

    public jdLocalidad(java.awt.Frame parent, boolean modal, String tipo, String l, String m, String e, String p, String Idioma, Connection c) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        cn = c;
        this.l = l;
        this.m = m;
        this.e = e;
        this.p = p;
        this.tipo = tipo;

        mdb = new metodosDatosBasicos(cn,Idioma);
        valiConf = new validaConfi();
        idioma = new Propiedades(Idioma);

        txtLocalidad.setText(l);

        jButton2.setText(idioma.getProperty("Aceptar"));
        jButton3.setText(idioma.getProperty("Cancelar"));
        jLabel1.setText(idioma.getProperty("Pais"));
        jLabel3.setText(idioma.getProperty("Estado"));        
        jLabel4.setText(idioma.getProperty("Municipio"));        
        jLabel2.setText(idioma.getProperty("Localidad"));
        
        PlaceHolder holder = new PlaceHolder(txtLocalidad, idioma.getProperty("Localidad"));
        
        
        rellenarCombos();
        comparaciones();
    }

    public void comparaciones() {
        if (tipo.equals("1")) {
            setTitle(idioma.getProperty("NuevaLocalidad"));
            // sección para sugerir el país, estado y municipio de la última localidad capturada
            int m,e,p;
            m=Integer.parseInt(mdb.devuelveUnDato("select id_municipio from localidad order by id desc limit 1"));
            e=Integer.parseInt(mdb.devuelveUnDato("select id_estado from municipio where id = "+m));
            p=Integer.parseInt(mdb.devuelveUnDato("select id_pais from estado where id = "+e));
            comboPais.setSelectedIndex(p);
            comboEstado.setSelectedIndex(e);
            comboMunicipio.setSelectedIndex(m);            
            // fin sección para sugerir el país, estado y municipio de la última localidad capturada
        } else {
            setTitle(idioma.getProperty("EditarLocalidad"));

            comboPais.setEnabled(false);
            comboEstado.setEnabled(false);
            comboMunicipio.setEnabled(false);

            comboMunicipio.addItem(m);
            comboMunicipio.setSelectedItem(m);

            comboEstado.addItem(e);
            comboEstado.setSelectedItem(e);

            comboPais.addItem(p);
            comboPais.setSelectedItem(p);
        }
    }

    String[] datos;

    public void rellenarCombos() {
        String pais, estado;

        datos = mdb.cargarCombos("SELECT descripcion from pais").split("¬");
        comboPais.setModel(new DefaultComboBoxModel((Object[]) datos));

        pais = comboPais.getSelectedItem() + "";

        datos = mdb.cargarCombos("SELECT e.descripcion \n"
                + "from estado e \n"
                + "inner join pais p on (e.id_pais=p.id) \n"
                + "where p.Descripcion='" + pais + "'").split("¬");
        comboEstado.setModel(new DefaultComboBoxModel((Object[]) datos));

        estado = comboEstado.getSelectedItem() + "";

        datos = mdb.cargarCombos("SELECT m.descripcion \n"
                + "from municipio m \n"
                + "inner join estado e on (m.id_estado=e.id) \n"
                + "where e.Descripcion='" + estado + "'").split("¬");
        comboMunicipio.setModel(new DefaultComboBoxModel((Object[]) datos));

        comboMunicipio.setSelectedItem(m);
    }

    public void tipoProceso() {
        String sql = "";

        String municipio = comboMunicipio.getSelectedItem() + "";

        if (tipo.equals("1")) {
            //nuevo
            if (mdb.comprobarExistencia("select descripcion from localidad where descripcion='" + txtLocalidad.getText() + "'") == null) {
                sql = "INSERT INTO localidad VALUES(null,'" + txtLocalidad.getText() + "', 1, 1,current_date()"
                        + ", current_time(), 1, 1, 1, 1, " + mdb.devuelveId("select id from municipio where descripcion='"+municipio+"'") + " )";
                mdb.insertarBasicos(sql);
                jpL.llenaTablaLocalidad();
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
            //editar
            sql = "UPDATE localidad SET descripcion ='" + txtLocalidad.getText() + "', ID_municipio='" + mdb.devuelveId("select id from municipio where descripcion='"+municipio+"'") + "' where descripcion='" + l + "' ";
            System.out.println(sql);
            mdb.actualizarBasicos(sql);
            jpL.llenaTablaLocalidad();
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
        txtLocalidad = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        comboEstado = new javax.swing.JComboBox<String>();
        jLabel3 = new javax.swing.JLabel();
        comboPais = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboMunicipio = new javax.swing.JComboBox<String>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtLocalidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLocalidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLocalidadKeyTyped(evt);
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

        jLabel4.setText("Municipio");

        comboMunicipio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboMunicipioItemStateChanged(evt);
            }
        });
        comboMunicipio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboMunicipioMouseClicked(evt);
            }
        });

        jLabel2.setText("Localidad");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(comboMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton3))
                        .addComponent(txtLocalidad)
                        .addComponent(comboEstado, 0, 280, Short.MAX_VALUE)
                        .addComponent(comboPais, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (txtLocalidad.getText().length() == 0) {
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void comboEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboEstadoItemStateChanged
        // TODO add your handling code here:
        datos = mdb.cargarCombos("SELECT m.descripcion \n"
                + "from municipio m \n"
                + "inner join estado e on (m.id_estado=e.id) \n"
                + "where e.Descripcion='" + comboEstado.getSelectedItem() + "" + "'").split("¬");
        comboMunicipio.setModel(new DefaultComboBoxModel((Object[]) datos));
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

        datos = mdb.cargarCombos("SELECT m.descripcion \n"
                + "from municipio m \n"
                + "inner join estado e on (m.id_estado=e.id) \n"
                + "where e.Descripcion='" + comboEstado.getSelectedItem() + "" + "'").split("¬");
        comboMunicipio.setModel(new DefaultComboBoxModel((Object[]) datos));
    }//GEN-LAST:event_comboPaisItemStateChanged

    private void comboMunicipioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboMunicipioItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboMunicipioItemStateChanged

    private void comboMunicipioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboMunicipioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_comboMunicipioMouseClicked

    private void txtLocalidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocalidadKeyReleased
        // TODO add your handling code here:
        txtLocalidad.setText(valiConf.primerLetraMayuscula(txtLocalidad.getText()));
    }//GEN-LAST:event_txtLocalidadKeyReleased

    private void txtLocalidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocalidadKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtLocalidadKeyTyped

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
            java.util.logging.Logger.getLogger(jdLocalidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdLocalidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdLocalidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdLocalidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
 /*        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdLocalidad dialog = new jdLocalidad(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> comboMunicipio;
    private javax.swing.JComboBox<String> comboPais;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtLocalidad;
    // End of variables declaration//GEN-END:variables
}
