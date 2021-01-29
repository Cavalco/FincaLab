/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_BeneficioHumedo;

import MetodosGenerales.MiRender2;
import Metodos_Configuraciones.metodosBeneficioHumedo;
import java.sql.Connection;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cronos
 */
public class jdBoletasMultiples extends javax.swing.JDialog {

    /**
     * Creates new form jdBoletasMultiples
     */
    String idBoleta, idBeneficio, idSociedad;
    metodosBeneficioHumedo mbh;
    Connection cn;
    DefaultTableModel modelo;
    MiRender2 mirender = new MiRender2();
    jpCortesRecibidos jp;
    jdBoletaEntradaBH jdBBH;

    public jdBoletasMultiples(java.awt.Frame parent, boolean modal, String idBoleta, String idBeneficio, String idSociedad, Connection cn) throws ParseException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        jTable1.setDefaultRenderer(jTable1.getColumnClass(4), mirender);

        this.cn = cn;
        this.idBoleta = idBoleta;
        this.idBeneficio = idBeneficio;
        this.idSociedad = idSociedad;
        mbh = new metodosBeneficioHumedo(cn);
        modelo = (DefaultTableModel) jTable1.getModel();
        llenarDatos();
        llenarTabla();

    }

    public void llenarDatos() throws ParseException {
        try {
            //JOptionPane.showMessageDialog(null, "Nuevo");
            String[] datos = mbh.devolverLineaDatos("SELECT\n"
                    + "    r.nombrecorto,\n"
                    + "    bh.nombrecorto,\n"
                    + "    fecha,\n"
                    + "    fechaBoletaManual,\n"
                    + "    idBoletaManual,\n"
                    + "    idBoleta,\n"
                    + "    totalSacos,\n"
                    + "    totalKg,\n"
                    + "    b.descripcion,\n"
                    + "    transporteLimpio,\n"
                    + "    v.Nombre,\n"
                    + "    v.Placas,\n"
                    + "    v.Responsable, "
                    + "    horaactual, "
                    + "    horaBoletaManual "
                    + "FROM\n"
                    + "    boletasalidareceptor b\n"
                    + "LEFT JOIN vehiculo v ON\n"
                    + "    (v.ID = b.idTransporte)\n"
                    + "LEFT JOIN recepciones r ON\n"
                    + "    (r.idRecepcion = b.origen)\n"
                    + "LEFT JOIN beneficioshumedos bh ON\n"
                    + "    (bh.nombre = b.destino)\n"
                    + "WHERE\n"
                    + "    idBoleta = '" + idBoleta + "'\n"
                    + "GROUP BY\n"
                    + "    idBoleta", 15).split("¬");

            /*SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        
        if (!datos[3].equals("")) {
            fechaDate = formato.parse(datos[3]);
            jDateChooser2.setDate(fechaDate);
        }*/
            jLabel25.setText(idBoleta);
            jLabel3.setText(datos[0]);
            jLabel4.setText(datos[1]);
            jLabel13.setText(datos[2]);
            jLabel23.setText(datos[3]);
            jLabel22.setText(datos[4]);
            //txtBoletaManual.setText(datos[4]);
            //txtSacosEnviados.setText(datos[6]);
            //txtKgEnviados.setText(datos[7]);
            //txtTransporte.setText(datos[10]);
            //txtPlacas.setText(datos[11]);
            //txtChofer.setText(datos[12]);
            jLabel14.setText(datos[13]);
            //jLabel7.setText(datos[14]);
            //txtObservaciones.setText(datos[8]);
            /*  if (datos[9].equals("1")) {
                checkSi.setSelected(true);
            } else if (datos[9].equals("0")) {
                checkNo.setSelected(true);
            }*/

        } catch (Exception e) {

        }
    }

    public void llenarTabla() {
        limpiar(jTable1);
        mbh.cargarInformacion(modelo, 6,
                "select m.sacosEnviados, m.kilosEnviados,v.responsable,v.nombre, m.sacosRecibidos, m.kilosRecibidos\n "
                + "from  multipleboletasalidarecepcion m\n "
                + "left join vehiculo v on (v.ID=m.idTransporte)\n "
                + "where idBoleta='" + idBoleta + "'");
    }

    public Boolean calcularDiferencias() {
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            if (Double.parseDouble(jTable1.getValueAt(i, 0) + "") > Double.parseDouble(jTable1.getValueAt(i, 4) + "")
                    || Double.parseDouble(jTable1.getValueAt(i, 1) + "") > Double.parseDouble(jTable1.getValueAt(i, 5) + "")) {
                return false;
            }
        }
        return true;
    }

    public void registrarEnvios() throws ParseException {

        if (calcularDiferencias()) {

            for (int i = 0; i < jTable1.getRowCount(); i++) {
                String idTransporte = mbh.devuelveUnDato("select id from vehiculo where responsable='" + jTable1.getValueAt(i, 2) + "' and "
                        + "nombre='" + jTable1.getValueAt(i, 3) + "'");

                if (!jTable1.getValueAt(i, 4).toString().equals("0") && !jTable1.getValueAt(i, 5).toString().equals("0")) {

                    mbh.actualizarBoleta("update multipleboletasalidarecepcion set sacosRecibidos=" + jTable1.getValueAt(i, 4) + ", "
                            + "kilosRecibidos='" + jTable1.getValueAt(i, 5) + "', estado=0 "
                            + "where idBoleta='" + idBoleta + "' and idTransporte=" + idTransporte + " "
                            + "and sacosEnviados=" + jTable1.getValueAt(i, 0) + " and kilosEnviados='" + jTable1.getValueAt(i, 1) + "'");

                }
            }
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
            validar();

        } else {

            int dialogButton = JOptionPane.showConfirmDialog(this, "Faltan sacos y/o kilos ¿Deseas Continuar?",
                    "Alerta", JOptionPane.YES_NO_OPTION);

            if (dialogButton == 0) {
                // JOptionPane.showMessageDialog(null, "entre al yes");
                for (int i = 0; i < jTable1.getRowCount(); i++) {
                    String idTransporte = mbh.devuelveUnDato("select id from vehiculo where responsable='" + jTable1.getValueAt(i, 2) + "'");

                    if (!jTable1.getValueAt(i, 3).toString().equals("0") && !jTable1.getValueAt(i, 4).toString().equals("0")) {

                        mbh.actualizarBoleta("update multipleboletasalidarecepcion set sacosRecibidos=" + jTable1.getValueAt(i, 4) + ", "
                                + "kilosRecibidos='" + jTable1.getValueAt(i, 5) + "', estado=0 "
                                + "where idBoleta='" + idBoleta + "' and idTransporte=" + idTransporte + " "
                                + "and sacosEnviados=" + jTable1.getValueAt(i, 0) + " and kilosEnviados='" + jTable1.getValueAt(i, 1) + "'");

                    }
                }
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                validar();
            } else {
                //JOptionPane.showMessageDialog(null, "entre al no");
            }
        }

    }

    public void validar() throws ParseException {

        String datos = mbh.validarMultiples("select estado from multipleboletasalidarecepcion where idBoleta='" + idBoleta + "'");
        // JOptionPane.showMessageDialog(null, datos);

        if (datos.contains("1")) {
            JOptionPane.showMessageDialog(null, "Boleta No Disponible");
            this.dispose();
        } else {
        /*    JOptionPane.showMessageDialog(null, "Boleta Disponible");
            jdBBH = new jdBoletaEntradaBH(null, true, idBoleta, idSociedad, idBeneficio, "Nuevo", "BoletaMultiple", cn);
            jdBBH.jdm = this;
            jdBBH.setVisible(true);*/
        }

    }

    public void actualizarCortesRecibidos() {
        jp.llenarTabla();
        this.dispose();
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
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Confirmación Multiple");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Id Boleta");

        jLabel25.setText("jLabel25");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Destino");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Origen");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Fecha Salida");

        jLabel14.setText("jLabel14");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Hora");

        jLabel13.setText("jLabel13");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Boleta Manual");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Fecha Boleta Manual");

        jLabel23.setText("jLabel13");

        jLabel22.setText("jLabel13");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Hora");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Sacos Enviados", "Kilos Enviados", "Responsable", "Transporte", "Sacos Recibidos", "Kilos Recibidos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel26)
                        .addGap(0, 92, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel24))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(jLabel25))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel14)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel13)
                            .addComponent(jLabel20)
                            .addComponent(jLabel22)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel23)))
                    .addComponent(jSeparator2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
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
        try {
            // TODO add your handling code here:
            registrarEnvios();
            jTable1.setDefaultRenderer(jTable1.getColumnClass(3), mirender);
        } catch (ParseException ex) {
            Logger.getLogger(jdBoletasMultiples.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(jdBoletasMultiples.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdBoletasMultiples.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdBoletasMultiples.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdBoletasMultiples.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
 /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdBoletasMultiples dialog = new jdBoletasMultiples(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
