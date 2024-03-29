/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_Configuraciones_FincaCert;

import Idioma.Propiedades;
import Metodos_Configuraciones.metodosDatosBasicos;
import com.placeholder.PlaceHolder;
import java.sql.Connection;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Carlos Valdez
 */
public class jdCalidadSombra extends javax.swing.JDialog {

    /**
     * Creates new form jdCalidadSombra
     */
    jpCalidadSombra jpCS;
    Connection cn;
    String tipo, calidad, altura, tSombra, cobertura, id;
    metodosDatosBasicos mdb;
    Propiedades idioma;

    public jdCalidadSombra(java.awt.Frame parent, boolean modal, String tipo, String calidad,
            String altura, String tSombra, String cobertura, String id, String Idioma, Connection c) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        cn = c;
        mdb = new metodosDatosBasicos(cn,Idioma);
        this.tipo = tipo;
        this.calidad = calidad;
        this.tSombra = tSombra;
        this.cobertura = cobertura;
        this.altura = altura;
        this.id = id;
        
        idioma = new Propiedades(Idioma);
        
        jButton2.setText(idioma.getProperty("Aceptar"));
        jButton3.setText(idioma.getProperty("Cancelar"));
        jLabel1.setText(idioma.getProperty("CalidadEstrellas"));
        jLabel3.setText(idioma.getProperty("AlturaMaximaMts."));
        jLabel4.setText(idioma.getProperty("TipoDeSombra"));
        jLabel2.setText(idioma.getProperty("CoberturaDeSombraPorcen"));
        
        PlaceHolder holder = new PlaceHolder(txtCalidad, idioma.getProperty("CalidadEstrellas"));
        PlaceHolder holder2 = new PlaceHolder(txtAltura, idioma.getProperty("AlturaMaximaMts."));
        PlaceHolder holder4 = new PlaceHolder(txtCobertura, idioma.getProperty("CoberturaDeSombraPorcen"));
        
        

        rellenarCombos();
        comparaciones();
    }

    public void comparaciones() {
        if (tipo.equals("1")) {
            //setTitle("Nuevo Tipo de Sombra");
            setTitle(idioma.getProperty("NuevoTipoDeSombra"));

        } else {
            //setTitle("Editar Tipo de Sombra");
            setTitle(idioma.getProperty("EditarTipoDeSombra"));
            comboTipo.addItem(tSombra);
            comboTipo.setSelectedItem(tSombra);

            txtCalidad.setText(calidad);
            txtAltura.setText(altura);
            txtCobertura.setText(cobertura);
        }
    }

    String[] datos;

    public void rellenarCombos() {
        datos = mdb.cargarCombos("SELECT descripcion from tiposombra where id_situacion=1").split("¬");
        comboTipo.setModel(new DefaultComboBoxModel((Object[]) datos));
    }

    public void tipoProceso() {
        String sql = "";

        String tipoS = comboTipo.getSelectedItem() + "";

        if (tipo.equals("1")) {
            if (mdb.comprobarExistencia("select estrellas from calidadsombra where estrellas=" + txtCalidad.getText()) == null) {
                sql = "INSERT INTO calidadsombra VALUES(null," + mdb.devuelveId("select id from tiposombra where descripcion='" + tipoS + "' ") + "," + txtCalidad.getText() + ","
                        + txtAltura.getText() + "," + txtCobertura.getText() + ", 1, 1,current_date()"
                        + ", current_time(), 1, 1, 1, 1  )";
                System.out.println(sql);
                mdb.insertarBasicos(sql);
                jpCS.llenaTablaCalidad();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Dato Repetido");
            }
        } else {
            //editar
            sql = "UPDATE calidadsombra SET id_tiposombra=" + mdb.devuelveId("select id from tiposombra where descripcion='" + tipoS + "' ") + ","
                    + " estrellas=" + txtCalidad.getText() + ",alturasombrametros=" + txtAltura.getText() + ",cobertura="
                    + txtCobertura.getText() + " where id=" + id;
            mdb.actualizarBasicos(sql);
            jpCS.llenaTablaCalidad();
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
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCalidad = new javax.swing.JTextField();
        txtAltura = new javax.swing.JTextField();
        txtCobertura = new javax.swing.JTextField();
        comboTipo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Cobertura %");

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

        jLabel3.setText("Altura Maxima (metros)");

        jLabel1.setText("Calidad (Estrellas)");

        jLabel4.setText("Tipo de Sombra");

        txtCalidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCalidadKeyTyped(evt);
            }
        });

        txtAltura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAlturaKeyTyped(evt);
            }
        });

        txtCobertura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCoberturaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addComponent(txtCalidad)
                    .addComponent(txtAltura)
                    .addComponent(txtCobertura)
                    .addComponent(comboTipo, 0, 280, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCobertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        tipoProceso();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtCalidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCalidadKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {//if (Character.isLetter(c)){
            getToolkit().beep();
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtCalidadKeyTyped

    private void txtAlturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlturaKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {//if (Character.isLetter(c)){
            getToolkit().beep();
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlturaKeyTyped

    private void txtCoberturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCoberturaKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {//if (Character.isLetter(c)){
            getToolkit().beep();
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtCoberturaKeyTyped

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
            java.util.logging.Logger.getLogger(jdCalidadSombra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdCalidadSombra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdCalidadSombra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdCalidadSombra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
 /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                                jdCalidadSombra dialog = new jdCalidadSombra(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JTextField txtCalidad;
    private javax.swing.JTextField txtCobertura;
    // End of variables declaration//GEN-END:variables
}
