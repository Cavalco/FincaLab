/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_BeneficioHumedo;

import Formas_BeneficioHumedov2.jpBitacoraUnaVista;
import Metodos_Configuraciones.metodosBeneficioHumedo;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class jdAsignarProceso extends javax.swing.JDialog {

    /**
     * Creates new form jdAsignarProceso
     */
    Connection cn;
    String Idioma, idBeneficio, idLoteC, tipo, cert,idSociedadLote;
    metodosBeneficioHumedo mbh;
    DefaultTableModel modelo;
    // jpBitacoraUnaVista jp;
    //jpLotesConfirmados jp;

    public jdAsignarProceso(java.awt.Frame parent, boolean modal, String idBeneficio, String idLoteC, 
            String tipo, String cert, String Idioma,String idSociedadLote, Connection cn) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        this.cn = cn;
        this.Idioma = Idioma;
        this.idLoteC = idLoteC;
        this.tipo = tipo;
        this.cert = cert;
        this.idBeneficio = idBeneficio;
        this.idSociedadLote=idSociedadLote;

        mbh = new metodosBeneficioHumedo(cn);
        modelo = (DefaultTableModel) tablaProceso.getModel();

        jLabel12.setVisible(false);
        jLabel13.setVisible(false);

        setTitle("Asignación Ruta de Procesos");
        cargarCombo();
        infoLote();

        jButton4.setVisible(false);
    }

    public void infoLote() {
        String datos[] = mbh.devolverLineaDatos("SELECT\n"
                + "    idSubLote,\n"
                + "    formaEntrada,\n"
                + "    estadoEntrada,\n"
                + "    costalesRecibidos,\n"
                + "    kgRecibidos,\n"
                + "    idLoteOrigen "
                + "FROM\n"
                + "    sublotesconfirmados b\n"
                + "WHERE\n"
                + "    id = '" + idLoteC + "'", 6).split("¬");

        jLabel2.setText(datos[0]);
        jLabel8.setText(datos[1]);
        jLabel9.setText(datos[2]);
        jLabel10.setText(datos[3]);
        jLabel15.setText(datos[5]);
        jLabel11.setText(datos[4]);
        labelCerti.setText(cert);

    }

    /*   public void infoLote() {
        if (tipo.equals("Lote")) {

            String datos[] = mbh.devolverLineaDatos("SELECT\n"
                    + "    b.idLote,\n"
                    + "    c.formaCafe,\n"
                    + "    b.estadoCafe,\n"
                    + "    b.costalesRecibidos,\n"
                    + "    b.kgRecibidos\n"
                    + "FROM\n"
                    + "    boletaentradabh b\n"
                    + "INNER JOIN cortesdeldia c ON\n"
                    + "    (c.idLote = b.idLote)\n"
                    + "WHERE\n"
                    + "    b.idLote = '" + idLote + "'", 5).split("¬");

            jLabel2.setText(datos[0]);
            jLabel8.setText(datos[1]);
            jLabel9.setText(datos[2]);
            jLabel10.setText(datos[3]);
            jLabel15.setText(datos[0]);
            jLabel11.setText(datos[4]);
            labelCerti.setText(cert);
        } else if (tipo.equals("SubLote")) {
            String datos[] = mbh.devolverLineaDatos("SELECT\n"
                    + "    idSubLote,\n"
                    + "    formaCafe,\n"
                    + "    estadoCafe,\n"
                    + "    idLoteOrigen,\n"
                    + "    kgTotales\n"
                    + "FROM\n"
                    + "    sublotesconfirmados b\n"
                    + "WHERE\n"
                    + "    idSubLote = '" + idLote + "'", 5).split("¬");

            jLabel2.setText(datos[0]);
            jLabel8.setText(datos[1]);
            jLabel9.setText(datos[2]);
            jLabel15.setText(datos[3]);
            jLabel11.setText(datos[4]);
        } else {
            JOptionPane.showMessageDialog(null, "Revisar Tipo");
        }
    }*/
    public void cargarCombo() {
        String datos[] = mbh.cargarCombos("select nombreRuta from rutabeneficiohumedo group by nombreRuta").split("¬");
        jComboBox1.setModel(new DefaultComboBoxModel((Object[]) datos));
    }

    public Boolean comprobarSobrantes() {
        String linea = "";
        for (int i = 0; i < modelo.getRowCount(); i++) {
            String maquinaria = modelo.getValueAt(i, 3) + "";
            // JOptionPane.showMessageDialog();
            linea += mbh.devolverLineaDatos("select a.actividad, m.nombre, s.Nombre, '0.00' \n"
                    + "from maquinariabh m\n"
                    + "left join actividadesbh a on (m.idActividad=a.ID)\n"
                    + "left join sobrante s on (m.sobrante=s.ID)\n"
                    + "where m.generarLote=1 and m.nombre='" + maquinaria + "'", 4);
        }

        if (linea.equals("")) {
            // JOptionPane.showMessageDialog(null,"No hay datos"+linea);
            return false;
        } else {
            //JOptionPane.showMessageDialog(null,"Si hay datos\n"+linea);
            return true;
        }

    }

    /*   public void validarMaquinaria() {

        for (int i = 0; i < tablaProceso.getRowCount(); i++) {
            String maquinaria = tablaProceso.getValueAt(i, 1) + "";
            mbh.cargarInformacion(modelo2, 3, "select a.actividad, m.nombre, s.Nombre \n"
                    + "from maquinariabh m\n"
                    + "inner join actividadesbh a on (m.idActividad=a.ID)\n"
                    + "inner join sobrante s on (m.sobrante=s.ID)\n"
                    + "where m.generarLote=1 and m.nombre='" + maquinaria + "'");
        }

            if (mbh.devuelveUnDato("select generarLote from maquinariabh where nombre='" + comboMaquinaria.getSelectedItem() + "'").equals("1")) {
            JOptionPane.showMessageDialog(null, "Se genera nuevo lote");
            String kilos = JOptionPane.showInputDialog("Flote Kg");
        } else {
            JOptionPane.showMessageDialog(null, "No se genera un nuevo Lote");
        }
    }*/
    public void acutalizarTabla() {
        //  jp.llenarTabla();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProceso = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        labelCerti = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblCadenaRuta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablaProceso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pasos", "Actividad", "Entrada", "Maquinaria", "Salida", "Forma Salida"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProceso.setEnabled(false);
        jScrollPane1.setViewportView(tablaProceso);
        if (tablaProceso.getColumnModel().getColumnCount() > 0) {
            tablaProceso.getColumnModel().getColumn(0).setMinWidth(55);
            tablaProceso.getColumnModel().getColumn(0).setPreferredWidth(55);
            tablaProceso.getColumnModel().getColumn(0).setMaxWidth(55);
        }

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Rutas Disponibles");

        jButton1.setText("Asignar Proceso");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Nueva Ruta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Id Lote");

        jLabel2.setText(".");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Forma Café");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Estado Café");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Sacos");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Kilos");

        jLabel8.setText("-");

        jLabel9.setText("-");

        jLabel10.setText("-");

        jLabel11.setText("-");

        jLabel12.setText("jLabel12");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Tipo de Proceso");

        jButton3.setText("Visualizar Ruta");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("SubLote Origen");

        jLabel15.setText("-");

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        labelCerti.setText("-");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Certificacion");

        lblCadenaRuta.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCadenaRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(labelCerti))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCerti))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel12)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(lblCadenaRuta)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jdImagenRuta jdImagen = new jdImagenRuta(null, true, cn, jComboBox1.getSelectedItem() + "");
        jdImagen.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jdRutasProcesos jdR = new jdRutasProcesos(null, true, idBeneficio, idLoteC, Idioma, cn);
        jdR.jdA = this;
        jdR.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Date date = new Date();
        String fechaActual = new SimpleDateFormat("yyyy-MM-dd").format(date);
        String idRuta = mbh.devuelveUnDato("select id from rutabeneficiohumedo where nombreRuta='" + jComboBox1.getSelectedItem() + "' ");
        int numeroRegistros = tablaProceso.getRowCount() - 1;
        String formaSalida = tablaProceso.getValueAt(numeroRegistros, 5) + "";
        JOptionPane.showMessageDialog(null,formaSalida);

        if (comprobarSobrantes()) {
            jdAsignarSobrantes jdS = new jdAsignarSobrantes(null, true, modelo, idBeneficio, idLoteC, "", idRuta, 
                    jComboBox1.getSelectedItem() + "", jLabel12.getText(), tipo, cert, formaSalida, lblCadenaRuta.getText(),idSociedadLote, cn);
            jdS.jdA = this;
            jdS.setVisible(true);
        } else {

            mbh.actualizarBoleta("update sublotesconfirmados set rutaDespulpe='" + jComboBox1.getSelectedItem() + "', idRuta=" + idRuta + ","
                    + "formaFinal='" + formaSalida + "', procesoFinal='" + jLabel12.getText() + "' where id=" + idLoteC);

            /*if (tipo.equals("Lote")) {
                    mbh.actualizarBoleta("update boletaentradabh set estatus='0' "
                            + "where idLote='" + jLabel2.getText() + "' "
                            + "and idBoleta='" + mbh.devuelveUnDato("select idBoleta from boletaentradabh where idLote='" + jLabel15.getText() + "'") + "'");
                } else {
                    mbh.actualizarBoleta("update sublotesconfirmados set estatus='0' "
                            + "where idSubLote='" + jLabel2.getText() + "'");
                }*/
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        limpiar(tablaProceso);
        mbh.cargarInformacion(modelo, 6, "SELECT\n"
                + "    @rownum := @rownum +1,\n"
                + "    a.Actividad,\n"
                + "    e.clave,\n"
                + "    m.nombre,\n"
                + "    d.claveSalida,\n"
                + "    d.formasalida\n"
                + "FROM\n"
                + "    rutabeneficiohumedo ru\n"
                + "INNER JOIN detalle_rutabh d ON\n"
                + "    (ru.id = d.idRuta)\n"
                + "INNER JOIN entradasmaquinaria e ON\n"
                + "    (e.idMaquinaria = d.maquinaria)\n"
                + "INNER JOIN maquinariabh m ON\n"
                + "    (m.id = d.maquinaria)\n"
                + "INNER JOIN actividadesbh a ON\n"
                + "    (a.ID = d.actividad),\n"
                + "    (\n"
                + "SELECT\n"
                + "    @rownum := 0\n"
                + ") r\n"
                + "WHERE\n"
                + "    ru.nombreRuta ='" + jComboBox1.getSelectedItem() + "' ");

        jLabel12.setVisible(true);
        jLabel12.setText(mbh.devuelveUnDato("select p.descripcion "
                + "from rutabeneficiohumedo r "
                + "inner join procesocafe p on (p.id=r.idProceso) "
                + "where r.nombreRuta='" + jComboBox1.getSelectedItem() + "'"));
        jLabel13.setVisible(true);

        String cadenaRuta = "";
        for (int i = 0; i < modelo.getRowCount(); i++) {
            cadenaRuta += modelo.getValueAt(i, 3) + ",";
        }
        cadenaRuta = cadenaRuta.substring(0, cadenaRuta.length() - 1);
        lblCadenaRuta.setText(cadenaRuta);
        cadenaRuta = "";
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int numeroRegistros = tablaProceso.getRowCount() - 1;
        JOptionPane.showMessageDialog(null, numeroRegistros);
        String formaSalida = tablaProceso.getValueAt(numeroRegistros, 5) + "";
        JOptionPane.showMessageDialog(null, "Forma Salida" + formaSalida);
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
            java.util.logging.Logger.getLogger(jdAsignarProceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdAsignarProceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdAsignarProceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdAsignarProceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
 /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdAsignarProceso dialog = new jdAsignarProceso(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelCerti;
    private javax.swing.JLabel lblCadenaRuta;
    private javax.swing.JTable tablaProceso;
    // End of variables declaration//GEN-END:variables
}
