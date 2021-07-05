/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_BeneficioHumedo;

import static Formas_Personas.jdFormularioPersonas.encodeToString;
import Idioma.Propiedades;
import MetodosGenerales.MiRender;
import MetodosGenerales.Resaltador;
import Metodos_Configuraciones.metodosDatosBasicos;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import sun.misc.BASE64Encoder;

/**
 *
 * @author USUARIO
 */
public class jdRutasProcesos extends javax.swing.JDialog {

    /**
     * Creates new form jdProcesosCortes
     */
    Connection cn;
    metodosDatosBasicos mdb;
    DefaultTableModel modelo;
    Propiedades idioma;
    String Idioma, idBeneficio, idLote;
    jdAsignarProceso jdA;
    
    public jdRutasProcesos(java.awt.Frame parent, boolean modal, String idBeneficio, String idLote, String Idioma, Connection cn) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Creación de Ruta");
        
        this.cn = cn;
        this.Idioma = Idioma;
        this.idLote = idLote;
        this.idBeneficio = idBeneficio;
        
        mdb = new metodosDatosBasicos(cn, Idioma);
        modelo = (DefaultTableModel) tablaProceso.getModel();
        cargarCombos();
        cargarProcesos();

        /*  Resaltador color = new Resaltador(2, 6);
        tablaProceso.getColumnModel().getColumn(2).setCellRenderer(color);
        tablaProceso.getColumnModel().getColumn(6).setCellRenderer(color);*/
        //tablaProceso.setDefaultRenderer(Object.class, new MiRender());
    }
    
    public void cargarCombos() {
        String[] datos = mdb.cargarCombos("select actividad from actividadesbh").split("¬");
        comboActividad.setModel(new DefaultComboBoxModel((Object[]) datos));
    }
    
    public void cargarCombos2() {
        String[] datos = mdb.cargarCombos("select nombre from maquinariabh").split("¬");
        comboMaquinaria.setModel(new DefaultComboBoxModel((Object[]) datos));
    }
    
    public void cargarProcesos() {
        String[] datos = mdb.cargarCombos("select descripcion from procesocafe").split("¬");
        comboProcesos.setModel(new DefaultComboBoxModel((Object[]) datos));
    }
    
    public void cargarRuta(String clave, String actividad) {
        
       /* String[] entradas = mdb.cargarCombos("SELECT\n"
                + "    clave\n"
                + "FROM\n"
                + "    entradasmaquinaria\n"
                + "WHERE\n"
                + "    idMaquinaria ="+mdb.devuelveUnDato("select id from maquinariabh where nombre='"+comboMaquinaria.getSelectedItem()+"'")+" ").split("¬");
        
        JOptionPane.showMessageDialog(null,"Numero entradas  "+entradas.length);*/
        
        
        mdb.cargarInformacion2(modelo, 5, "SELECT\n"
                + "    a.Actividad,\n"
                + "    e.clave,\n"
                + "    m.nombre,\n"
                + "    s.clave,\n"
                + "    s.formacafe\n"
                + "FROM\n"
                + "    maquinariabh m\n"
                + "LEFT JOIN actividadesbh a ON\n"
                + "    (a.ID = m.idActividad)\n"
                + "LEFT JOIN entradasmaquinaria e ON\n"
                + "    (e.idMaquinaria = m.id)\n"
                + "LEFT JOIN salidasmaquinaria s ON\n"
                + "    (s.idMaquinaria = m.id) "
                + "WHERE\n"
                + "    m.nombre = '" + comboMaquinaria.getSelectedItem() + "' and s.clave='" + clave + "'");
        
        String[] datos = mdb.cargarCombos("SELECT a.actividad\n"
                + "from relacionsalidamaquinarias r \n"
                + "inner join actividadesbh a on(r.idActividad=a.id)\n"
                + "where r.idMaquinaria=" + mdb.devuelveUnDato("select id from maquinariabh where nombre='" + comboMaquinaria.getSelectedItem() + "'") + " and clavesalida='" + clave + "' "
                + "and idActividad=" + mdb.devuelveUnDato("select id from actividadesbh where actividad='" + actividad + "'") + " ").split("¬");

        //validarMaquinaria();
        comboActividad.removeAllItems();
        comboActividad.setModel(new DefaultComboBoxModel((Object[]) datos));
    }
    
    public void validarMaquinaria() {
        if (mdb.devuelveUnDato("select generarLote from maquinariabh where nombre='" + comboMaquinaria.getSelectedItem() + "'").equals("1")) {
            JOptionPane.showMessageDialog(null, "Se genera nuevo lote");
            String kilos = JOptionPane.showInputDialog("Flote Kg");
        } else {
            JOptionPane.showMessageDialog(null, "No se genera un nuevo Lote");
        }
    }
    
    public static String encodeToString(BufferedImage image) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        
        try {
            ImageIO.write(image, "jpg", bos);
            byte[] imageBytes = bos.toByteArray();
            
            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);
            
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
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
        comboMaquinaria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProceso = new javax.swing.JTable();
        comboActividad = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtNombreRuta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboProcesos = new javax.swing.JComboBox<>();
        txtRuta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Maquinaria");

        tablaProceso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Actividad", "Entrada", "Maquinaria", "Salida", "Forma Salida"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaProceso);

        comboActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActividadActionPerformed(evt);
            }
        });

        jLabel2.setText("Actividad");

        jButton1.setText("Añadir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre Ruta");

        jLabel4.setText("Proceso");

        jLabel5.setText("Imagen");

        jButton3.setText("Seleccionar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Eliminar Fila");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(comboActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboMaquinaria, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(comboProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboMaquinaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(comboProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(txtNombreRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
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

    private void comboActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActividadActionPerformed
        // TODO add your handling code here:
        String[] datos = mdb.cargarCombos("select nombre from maquinariabh "
                + "where idActividad='" + mdb.devuelveUnDato("select id from actividadesbh where actividad='" + comboActividad.getSelectedItem() + "'") + "'").split("¬");
        comboMaquinaria.setModel(new DefaultComboBoxModel((Object[]) datos));
    }//GEN-LAST:event_comboActividadActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String[] salidas = mdb.cargarCombos("SELECT\n"
                + "    CONCAT(r.clavesalida, ' - ', a.actividad)\n"
                + "FROM\n"
                + "    relacionsalidamaquinarias r\n"
                + "INNER JOIN actividadesbh a ON\n"
                + "    (r.idActividad = a.id)\n"
                + "WHERE\n"
                + "    r.idMaquinaria = " + mdb.devuelveUnDato("select id from maquinariabh where nombre='" + comboMaquinaria.getSelectedItem() + "'") + "   \n"
        ).split("¬");

        //String[] entradas = mdb.cargarCombos(idLote)
        //   REVISAR POR QUE LAS SALIDAS DAN 1 MAS DE LAS QUE REALMENTE SON EJ. SON 2 SALIDAS Y MARCA 3
        //JOptionPane.showMessageDialog(null,"Salidas - "+salidas.length);
        if (salidas.length - 1 > 1) {
            jdSeleccionDeRuta jdr = new jdSeleccionDeRuta(null, true, salidas, cn);
            jdr.jdp = this;
            jdr.setVisible(true);
            
        } else { //if (salidas.length-1 == 1) {

            mdb.cargarInformacion2(modelo, 5, "SELECT\n"
                    + "    a.Actividad,\n"
                    + "    e.clave,\n"
                    + "    m.nombre,\n"
                    + "    s.clave,\n"
                    + "    s.formacafe\n"
                    + "FROM\n"
                    + "    maquinariabh m\n"
                    + "LEFT JOIN actividadesbh a ON\n"
                    + "    (a.ID = m.idActividad)\n"
                    + "LEFT JOIN entradasmaquinaria e ON\n"
                    + "    (e.idMaquinaria = m.id)\n"
                    + "LEFT JOIN salidasmaquinaria s ON\n"
                    + "    (s.idMaquinaria = m.id) "
                    + "WHERE\n"
                    + "    m.nombre = '" + comboMaquinaria.getSelectedItem() + "'");
            
            String[] datos = mdb.cargarCombos("SELECT a.actividad\n"
                    + "from relacionsalidamaquinarias r \n"
                    + "inner join actividadesbh a on(r.idActividad=a.id)\n"
                    + "where r.idMaquinaria=" + mdb.devuelveUnDato("select id from maquinariabh where nombre='" + comboMaquinaria.getSelectedItem() + "'") + " group by a.actividad").split("¬");
            
            comboActividad.removeAllItems();
            comboActividad.setModel(new DefaultComboBoxModel((Object[]) datos));
        }
        /**/
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String image_string = "NO";
        //JOptionPane.showMessageDialog(null, "Entre al boton");
        String idProceso = mdb.devuelveUnDato("select id from procesocafe where descripcion='" + comboProcesos.getSelectedItem() + "'");
        if (mdb.insertarBasicosComprobacion("insert into rutabeneficiohumedo values(null, '" + idBeneficio + "', "
                + "" + idProceso + ", "
                + "'" + txtNombreRuta.getText() + "' )")) {
            
            JOptionPane.showMessageDialog(this, "Inserción exitosa");
            
            String idRuta = mdb.devuelveUnDato("select id from rutabeneficiohumedo where nombreRuta='" + txtNombreRuta.getText() + "'");
            
            for (int i = 0; i < tablaProceso.getRowCount(); i++) {
                mdb.insertarEnCiclo("insert into detalle_rutabh values"
                        + "(" + idRuta + ", "
                        + "'" + mdb.devuelveUnDato("select id from actividadesbh where actividad='" + tablaProceso.getValueAt(i, 0) + "'") + "', "
                        + "'" + mdb.devuelveUnDato("select id from maquinariabh where nombre='" + tablaProceso.getValueAt(i, 2) + "'") + "', "
                        + "'" + tablaProceso.getValueAt(i, 4) + "', '" + tablaProceso.getValueAt(i, 3) + "'  ) ");
            }
            
            if (!txtRuta.getText().equals("")) {
                try {
                    BufferedImage img = ImageIO.read(new File(fichero.toString()));
                    image_string = encodeToString(img);
                    
                    mdb.insertarBasicos("insert into imagenrutabh values(null," + idRuta + ", '" + image_string + "' )");
                    
                } catch (Exception e) {
                }
            }
            
            JOptionPane.showMessageDialog(null, "Ruta Almacenada");
            jdA.cargarCombo();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error, Consultar OUTPUT");
        }
        

    }//GEN-LAST:event_jButton2ActionPerformed
    File fichero = null;
    private JPanel contentPane;
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        JFileChooser file = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.jpg", "jpg");
        file.setFileFilter(filtro);
        
        int seleccion = file.showOpenDialog(contentPane);
        //Si el usuario, pincha en aceptar
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            //Seleccionamos el fichero
            fichero = file.getSelectedFile();
            //Ecribe la ruta del fichero seleccionado en el campo de texto
            txtRuta.setText(fichero.getAbsolutePath());
            // ImageIcon icon = new ImageIcon(fichero.toString());
            //System.out.println(fichero.getName());
            //Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lbFoto.getWidth(), lbFoto.getHeight(), Image.SCALE_DEFAULT));
            //lbFoto.setText(null);
            //lbFoto.setIcon(icono);

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        modelo.removeRow(tablaProceso.getSelectedRow());
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(jdRutasProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdRutasProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdRutasProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdRutasProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboActividad;
    private javax.swing.JComboBox<String> comboMaquinaria;
    private javax.swing.JComboBox<String> comboProcesos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProceso;
    private javax.swing.JTextField txtNombreRuta;
    private javax.swing.JTextField txtRuta;
    // End of variables declaration//GEN-END:variables
}
