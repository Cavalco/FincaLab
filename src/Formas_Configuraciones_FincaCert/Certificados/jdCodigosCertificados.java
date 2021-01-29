/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_Configuraciones_FincaCert.Certificados;

import Idioma.Propiedades;
import Metodos_Configuraciones.metodosDatosBasicos;
import com.placeholder.PlaceHolder;
import java.sql.Connection;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos Valdez
 */
public class jdCodigosCertificados extends javax.swing.JFrame {

    /**
     * Creates new form jpCodigosCertificados
     */
    Connection cn;
    jpCodigosCertificados jp;
    metodosDatosBasicos mdb;
    Propiedades idioma;
    String codigo;
    DefaultTableModel modelo;

    public jdCodigosCertificados(Connection c, String Idioma, String codigo) {
        initComponents();
        setLocationRelativeTo(null);

        cn = c;
        this.codigo = codigo;
        mdb = new metodosDatosBasicos(cn, Idioma);
        modelo = (DefaultTableModel) tablaContenido.getModel();
        idioma = new Propiedades(Idioma);

        if (!codigo.equals("-")) {
            rellenarDatos();
            setTitle(idioma.getProperty("EditarCodigo"));
        } else {
            validacion();
            setTitle(idioma.getProperty("NuevoCodigo"));
        }

        jButton4.setText(idioma.getProperty("Limpiar"));
        jButton6.setText(idioma.getProperty("Guardar"));
        jButton3.setText(idioma.getProperty("Agregar"));
        jButton5.setText(idioma.getProperty("Eliminar"));

        jLabel4.setText(idioma.getProperty("NombreIdentificador"));
        jLabel6.setText(idioma.getProperty("Codigo"));
        
        PlaceHolder holder = new PlaceHolder(txtNombre, idioma.getProperty("NombreIdentificador"));
        PlaceHolder holder2 = new PlaceHolder(txtCodigo, idioma.getProperty("Codigo"));

        jLabel1.setText(idioma.getProperty("Certificado"));
        jLabel2.setText(idioma.getProperty("Certificador"));
        jLabel3.setText(idioma.getProperty("Alcances"));

        tablaContenido.getColumnModel().getColumn(0).setHeaderValue(idioma.getProperty("Certificado"));
        tablaContenido.getColumnModel().getColumn(1).setHeaderValue(idioma.getProperty("Certificador"));
        tablaContenido.getColumnModel().getColumn(2).setHeaderValue(idioma.getProperty("Alcances"));

        rellenarCombos();
    }

    public void rellenarDatos() {
        txtCodigo.setText(codigo);
        txtNombre.setText(mdb.devuelveUnDato("select nombre from codigos_certificacion where codigo='" + codigo + "'"));
        mdb.cargarInformacion2(modelo, 3,
                "select certificado,certificadora,alcance from codigo_relacion where codigo='" + codigo + "'");
    }

    public void rellenarCombos() {
        String[] datos;

        datos = mdb.cargarCombos("SELECT descripcion from certificado").split("¬");
        comboCertificado.setModel(new DefaultComboBoxModel((Object[]) datos));

        datos = mdb.cargarCombos("SELECT descripcion from certificadora").split("¬");
        comboCertificadora.setModel(new DefaultComboBoxModel((Object[]) datos));

        datos = mdb.cargarCombos("SELECT descripcion from estandarescert").split("¬");
        comboAlcances.setModel(new DefaultComboBoxModel((Object[]) datos));
    }

    public void validacion() {
        String codigo = mdb.devuelveUnDato("SELECT codigo FROM codigos_certificacion ORDER BY id DESC LIMIT 1");

        if (codigo.equals("")) {
            txtCodigo.setText("AA");
        } else {
            txtCodigo.setText(generarCodigo(codigo));
        }

    }

    public String generarCodigo(String letras) {
        //JOptionPane.showMessageDialog(null,"Recibí estás letras = "+letras);
        char letra1actual = letras.charAt(0);
        char letra2actual = letras.charAt(1);
        String codigo;

        char letra1nueva;
        char letra2nueva;

        if (letra2actual == 'Z') {
            //JOptionPane.showMessageDialog(null,"Entre a 1 sentencia");
            letra1nueva = (char) (letras.charAt(0) + 1);
            //letrasT.setText(letra1nueva + "A");
            codigo = letra1nueva + "A";
        } else {
            //JOptionPane.showMessageDialog(null,"Entre  al else");
            letra2nueva = (char) (letras.charAt(1) + 1);
            //letrasT.setText(letra1actual + "" + letra2nueva);
            codigo = letra1actual + "" + letra2nueva;
        }
        return codigo;
    }

    public void tipoProceso() {

        if (codigo.equals("-")) {

            mdb.insertarBasicos("insert into codigos_certificacion values(null,'" + txtCodigo.getText() + "', '" + txtNombre.getText() + "',1, 1,current_date(), current_time(), 1, 1, 1, 1 )");

            for (int i = 0; i < tablaContenido.getRowCount(); i++) {
                mdb.insertarEnCiclo("insert into codigo_relacion values('" + txtCodigo.getText() + "', '" + tablaContenido.getValueAt(i, 0) + "', "
                        + "'" + tablaContenido.getValueAt(i, 1) + "', '" + tablaContenido.getValueAt(i, 2) + "',1, 1,current_date(), current_time(), 1, 1, 1, 1 )");
            }
            txtCodigo.setText(generarCodigo(txtCodigo.getText()));

        } else {
            mdb.actualizarBasicos("delete from codigo_relacion where codigo='" + codigo + "'");
            mdb.actualizarBasicos("update codigos_certificacion set nombre='" + txtNombre.getText() + "' where codigo='"+codigo+"'");

            for (int i = 0; i < tablaContenido.getRowCount(); i++) {
                mdb.insertarEnCiclo("insert into codigo_relacion values('" + txtCodigo.getText() + "', '" + tablaContenido.getValueAt(i, 0) + "', "
                        + "'" + tablaContenido.getValueAt(i, 1) + "', '" + tablaContenido.getValueAt(i, 2) + "',1, 1,current_date(), current_time(), 1, 1, 1, 1 )");
            }
            JOptionPane.showMessageDialog(null, idioma.getProperty("RegistroExitoso"));
        }

        jp.llenaTabla();
        limpiar(tablaContenido);
        txtNombre.setText("");
        comboCertificado.setSelectedIndex(0);
        comboCertificadora.setSelectedIndex(0);
        comboAlcances.setSelectedIndex(0);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboCertificado = new javax.swing.JComboBox<>();
        comboCertificadora = new javax.swing.JComboBox<>();
        comboAlcances = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaContenido = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtAlcances = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Certificado");

        jLabel2.setText("Certificadora");

        jLabel3.setText("Alcances");

        comboCertificado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Organico", "Cafe de Mujeres", "Cas 4C" }));

        comboCertificadora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mayacert", "Cafesumex", "Biolatina", "Metrocert" }));

        comboAlcances.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SIN ALCANCE", "NOP", "USDA", "LOP" }));

        jLabel4.setText("Nombre / Identificador");

        tablaContenido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Certificado", "Certificadora", "Alcance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaContenido);

        jButton2.setText("+");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Añadir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtAlcances.setText("-");

        jButton4.setText("Limpiar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Eliminar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Guardar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        txtCodigo.setEditable(false);
        txtCodigo.setEnabled(false);

        jLabel6.setText("Codigo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)
                        .addGap(1, 1, 1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(comboCertificado, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(comboCertificadora, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboAlcances, javax.swing.GroupLayout.Alignment.LEADING, 0, 170, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtAlcances)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCertificado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCertificadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboAlcances, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAlcances)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) tablaContenido.getModel();

        String certificado = comboCertificado.getSelectedItem() + "",
                certificadora = comboCertificadora.getSelectedItem() + "",
                alcance = comboAlcances.getSelectedItem() + "";

        if (txtAlcances.getText().equals("-")) {
            modelo.addRow(new Object[]{certificado, certificadora, alcance});
        } else {
            modelo.addRow(new Object[]{certificado, certificadora, txtAlcances.getText().substring(2)});
            txtAlcances.setText("-");
            this.alcances = "";
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    String alcances = "";
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        alcances += ", " + comboAlcances.getSelectedItem() + "";
        txtAlcances.setText(alcances);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        txtAlcances.setText("-");
        alcances = "";
        limpiar(tablaContenido);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            DefaultTableModel modelo = (DefaultTableModel) tablaContenido.getModel();
            modelo.removeRow(tablaContenido.getSelectedRow());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecciona un elemento");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        tipoProceso();
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(jdCodigosCertificados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdCodigosCertificados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdCodigosCertificados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdCodigosCertificados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
 /*        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jdCodigosCertificados().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboAlcances;
    private javax.swing.JComboBox<String> comboCertificado;
    private javax.swing.JComboBox<String> comboCertificadora;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaContenido;
    private javax.swing.JLabel txtAlcances;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
