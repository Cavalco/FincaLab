/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_LaboratorioN;

import Idioma.Propiedades;
import Metodos_Configuraciones.metodosLaboratorio;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author jCarl
 */
public class jdNuevaMuestra extends javax.swing.JFrame {

    Connection cn;
    //Propiedades idioma;
    metodosLaboratorio ml;
    String KgConfirmed = "0";

    public jdNuevaMuestra(Connection cn, String idioma) {

        initComponents();
        this.cn = cn;
        ml = new metodosLaboratorio(cn, "");
        rellenarCombos();
        csm();
    }

    public void csm() {
        int csm;
        if (ml.devuelveUnDato("select id_muestra from bitacoralab order by id_muestra desc limit 1").equals("")) {
            csm = 1;
        } else {
            csm = Integer.parseInt(ml.devuelveUnDato("select id_muestra from bitacoralab order by id_muestra desc limit 1"));
            csm = csm + 1;
        }

        txtNoCSM.setText(csm + "");
    }

    public void rellenarCombos() {
        String[] datosProceso = ml.cargarCombos("SELECT Clave from procesocafe").split("¬");
        cmbProceso.setModel(new DefaultComboBoxModel((Object[]) datosProceso));
        String[] datos1 = ml.cargarCombos("SELECT NombreCorto from personam").split("¬");//1
        cmbDueno.setModel(new DefaultComboBoxModel((Object[]) datos1));
        String[] datos2 = ml.cargarCombos("SELECT Codigo from codigos_certificacion").split("¬");
        cmbCertificacion.setModel(new DefaultComboBoxModel((Object[]) datos2));
        String[] datos3 = ml.cargarCombos("select Clave  from formacafe").split("¬");
        cmbFormaCafe.setModel(new DefaultComboBoxModel((Object[]) datos3));
        String[] datos4 = ml.cargarCombos("SELECT Descripcion from calidadcereza").split("¬");
        cmbCalidadCereza.setModel(new DefaultComboBoxModel((Object[]) datos4));
        String[] datos5 = ml.cargarCombos("SELECT nombre from beneficioshumedos").split("¬");
        cmbBeneficio.setModel(new DefaultComboBoxModel((Object[]) datos5));
        String[] datos6 = ml.cargarCombos("select Descripcion from localidad").split("¬");
        cmbComunidad.setModel(new DefaultComboBoxModel((Object[]) datos6));
        String[] datos7 = ml.cargarCombos("select nombreAlmacen from almacenes").split("¬");
        cmbUbicacion.setModel(new DefaultComboBoxModel((Object[]) datos7));
        String[] datos8 = ml.cargarCombos("select CONCAT(pf.Nombre,' ', pf.apellidoPaterno,' ', pf.apellidoMaterno) from productor p inner join personaf pf on (p.id_persona=pf.ID) where tipoPersona=1").split("¬");//1
        cmbProductor.setModel(new DefaultComboBoxModel((Object[]) datos8));
        String[] datos9 = ml.cargarCombos("SELECT Responsable from vehiculo").split("¬");
        cmbTransportada.setModel(new DefaultComboBoxModel((Object[]) datos9));
    }

    public void Guardar2() {
        String fechaLlegada = new SimpleDateFormat("dd-MMM-yyyy").format(dcFechaLlegada.getDate());
        String fechaRecibo2 = new SimpleDateFormat("dd-MMM-yyyy").format(dcFechaLote.getDate());
        String fechaRecibo3 = new SimpleDateFormat("dd-MMM-yyyy").format(dcFinSecado.getDate());
        String fechaRecibo4 = new SimpleDateFormat("dd-MMM-yyyy").format(dcToma.getDate());
        String fechaRecibo5 = new SimpleDateFormat("dd-MMM-yyyy").format(dcFechaCo.getDate());
        String Kg = "0";
        if(validar()){
            if (cbKg.isSelected()) {
            Kg = "1";
            }
        String res = "insert into bitacoralab (id_bitacora,id_muestra,fecha_llegada,tipocafe,forma,beneficio,dueño,"
                + "lote,peso,sacos,comunidad,estatus,taza,aspecto,mezasig,Metodosecado,calidadcereza,pesomuestra,ubicacioncafe"
                + ",nomlote,predio,productor,fechalote,terminosecado,tomademuestra,fechacosecha,tomadapor,recibidapor,transportadapor,"
                + "certificado,idlote,Kgconfirm) values(null," + txtNoCSM.getText() + ",'" + fechaLlegada + "','" + cmbProceso.getSelectedItem() + "','" + cmbFormaCafe.getSelectedItem() + "','"
                + cmbBeneficio.getSelectedItem() + "','" + cmbDueno.getSelectedItem() + "','" + txtSublote.getText() + "','" + txtKilos.getText()
                + "','" + txtCostales.getText() + "','" + cmbComunidad.getSelectedItem() + "','Activada','0','0','0','" + cmbMetodoSecado.getSelectedItem()
                + "','" + cmbCalidadCereza.getSelectedItem() + "','" + txtPesoMuestra.getText() + "','" + cmbUbicacion.getSelectedItem() + "','" + txtnombreLote.getText() + "','" + txtPredio.getText() + "'"
                + ",'" + cmbProductor.getSelectedItem() + "','" + fechaRecibo2 + "','" + fechaRecibo3 + "','" + fechaRecibo4 + "','" + fechaRecibo5 + "','" + cmbTomada.getSelectedItem() + "','"
                + cmbRecibida.getSelectedItem() + "','" + cmbTransportada.getSelectedItem() + "','" + cmbCertificacion.getSelectedItem() + "','" + txtIdSublote.getText()
                + "','" + Kg + "')";
        System.out.println(res);
        ml.insertarBasicos(res);
        JOptionPane.showMessageDialog(null, "Inserción Exitosa");
       }
        JOptionPane.showMessageDialog(null, "Hola");
    }

    public Boolean validar() {

        if (cmbDueno.getSelectedItem().equals("Seleccione..")) {
            JOptionPane.showMessageDialog(null, "Seleccione Dueño");
            return false;
        } else if (cmbProceso.getSelectedItem().equals("Seleccione..")) {
            JOptionPane.showMessageDialog(null, "Seleccione un Proceso");
            return false;
        } else if (cmbFormaCafe.getSelectedItem().equals("Seleccione..")) {
            JOptionPane.showMessageDialog(null, "Seleccione Forma de Café");
            return false;
        } else if (txtPesoMuestra.getText().length() <= 0 || txtKilos.getText().length() <= 0 || txtCostales.getText().length() <= 0
                || txtSublote.getText().length() <= 0 || txtnombreLote.getText().length() <= 0 || txtPredio.getText().length() <= 0
                || txtIdSublote.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Existen Campos Vacios");
            return false;
        } else if (cmbCertificacion.getSelectedItem().equals("Seleccione..")) {
            JOptionPane.showMessageDialog(null, "Seleccione Certificacion");
            return false;
        } else if (cmbCalidadCereza.getSelectedItem().equals("Seleccione..")) {
            JOptionPane.showMessageDialog(null, "Seleccione Calidad de Cereza");
            return false;
        } else if (cmbMetodoSecado.getSelectedItem().equals("Seleccione..")) {
            JOptionPane.showMessageDialog(null, "Seleccione Metodo de Secado");
            return false;
        } else if (cmbBeneficio.getSelectedItem().equals("Seleccione..")) {
            JOptionPane.showMessageDialog(null, "Seleccione Beneficio");
            return false;
        } else if (cmbComunidad.getSelectedItem().equals("Seleccione..")) {
            JOptionPane.showMessageDialog(null, "Seleccione Comunidad");
            return false;
        } else if (cmbUbicacion.getSelectedItem().equals("Seleccione..")) {
            JOptionPane.showMessageDialog(null, "Seleccione Calidad de Cereza");
            return false;
        } else if (cmbProductor.getSelectedItem().equals("Seleccione..")) {
            JOptionPane.showMessageDialog(null, "Seleccione Calidad de Cereza");
            return false;
        } else if (cmbTomada.getSelectedItem().equals("Seleccione..")) {
            JOptionPane.showMessageDialog(null, "Seleccione quien Tomó la muestra");
            return false;
        } else if (cmbTransportada.getSelectedItem().equals("Seleccione..")) {
            JOptionPane.showMessageDialog(null, "Seleccione quien Transportó la muestra");
            return false;
        } else if (cmbRecibida.getSelectedItem().equals("Seleccione..")) {
            JOptionPane.showMessageDialog(null, "Seleccione quien Recibió la muestra");
            return false;
        } else if (dcFechaLlegada.getDate() == null || dcFechaLote.getDate() == null || dcFinSecado.getDate() == null
                || dcToma.getDate() == null || dcFechaCo.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Existen Fechas Vacias");
            return false;
        } else {
            return true;
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
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNoCSM = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        dcFechaLlegada = new com.toedter.calendar.JDateChooser();
        txtCapturista = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cmbDueno = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cmbProceso = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbCertificacion = new javax.swing.JComboBox<>();
        cmbMetodoSecado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmbFormaCafe = new javax.swing.JComboBox<>();
        cmbCalidadCereza = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPesoMuestra = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtKilos = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtCostales = new javax.swing.JTextField();
        cbKg = new javax.swing.JCheckBox();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        cmbTomada = new javax.swing.JComboBox<>();
        cmbRecibida = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        cmbTransportada = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtSublote = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtnombreLote = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cmbBeneficio = new javax.swing.JComboBox<>();
        cmbComunidad = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        cmbUbicacion = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cmbProductor = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        dcFechaLote = new com.toedter.calendar.JDateChooser();
        dcFinSecado = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        dcFechaCo = new com.toedter.calendar.JDateChooser();
        dcToma = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtPredio = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtIdSublote = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Información General"));

        jLabel1.setText("No. CSM");

        txtNoCSM.setEnabled(false);

        jLabel2.setText("Fecha Llegada");

        dcFechaLlegada.setDateFormatString("dd/MMM/yyyy");

        txtCapturista.setText("Karla");
        txtCapturista.setEnabled(false);

        jLabel11.setText("Capturista");

        cmbDueno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setText("Dueño");

        jLabel32.setForeground(new java.awt.Color(204, 0, 0));
        jLabel32.setText("*");

        jLabel33.setForeground(new java.awt.Color(204, 0, 0));
        jLabel33.setText("*");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11)
                            .addComponent(txtCapturista, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel33)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cmbDueno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(txtNoCSM, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel32)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(dcFechaLlegada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNoCSM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcFechaLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCapturista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDueno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Información General"));

        jLabel3.setText("Proceso");

        cmbProceso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Certificación");

        cmbCertificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbMetodoSecado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..", "Patio", "Cama africana" }));

        jLabel5.setText("Metodo Secado");

        cmbFormaCafe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbCalidadCereza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Calidad Cereza");

        jLabel9.setText("Forma Café");

        jLabel10.setText("Peso Muestra (g)");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Cantidades");

        jLabel7.setText("Kilos");

        jLabel14.setText("Costales");

        cbKg.setText("Kg Confirmados");

        jLabel28.setForeground(new java.awt.Color(204, 0, 0));
        jLabel28.setText("*");

        jLabel29.setForeground(new java.awt.Color(204, 0, 0));
        jLabel29.setText("*");

        jLabel30.setForeground(new java.awt.Color(204, 0, 0));
        jLabel30.setText("*");

        jLabel31.setForeground(new java.awt.Color(204, 0, 0));
        jLabel31.setText("*");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCertificacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbMetodoSecado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbProceso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel29))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel28))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel30)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel31))
                                .addComponent(cmbFormaCafe, 0, 168, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addComponent(cmbCalidadCereza, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel10)
                            .addComponent(txtPesoMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtKilos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCostales, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbKg)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel28))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel29))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbCertificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel31))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbFormaCafe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbCalidadCereza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMetodoSecado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesoMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKilos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCostales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbKg))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de Muestra"));

        jLabel25.setText("Tomada Por");

        cmbTomada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..", "Persona 1", "Persona 2", "Persona 3" }));

        cmbRecibida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..", "James Kosalos", "Carlos Bustamante", "Interno 1", "Interno 2" }));

        jLabel26.setText("Recibida Por");

        cmbTransportada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel27.setText("Transportada Por");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(cmbTomada, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(cmbRecibida, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(cmbTransportada, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTransportada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbRecibida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTomada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Información del Lote"));

        jLabel6.setText("Id SubLote");

        jLabel15.setText("Nombre Lote");

        jLabel16.setText("Beneficio");

        cmbBeneficio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbComunidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel17.setText("Comunidad");

        cmbUbicacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel18.setText("Ubicación del Café");

        jLabel19.setText("Predio");

        jLabel20.setText("Productor");

        cmbProductor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Fechas"));

        jLabel21.setText("Fecha de Lote");

        dcFechaLote.setDateFormatString("dd/MMM/yyyy");

        dcFinSecado.setDateFormatString("dd/MMM/yyyy");

        jLabel22.setText("Terminación secado");

        jLabel23.setText("Fecha Cosecha");

        dcFechaCo.setDateFormatString("dd/MMM/yyyy");

        dcToma.setDateFormatString("dd/MMM/yyyy");

        jLabel24.setText("Toma de Muestra");

        jLabel37.setForeground(new java.awt.Color(204, 0, 0));
        jLabel37.setText("*");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel37))
                            .addComponent(dcFechaLote, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(dcFinSecado, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(dcToma, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(dcFechaCo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcFinSecado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel37))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcFechaLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcFechaCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcToma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel34.setForeground(new java.awt.Color(204, 0, 0));
        jLabel34.setText("*");

        jLabel35.setForeground(new java.awt.Color(204, 0, 0));
        jLabel35.setText("*");

        jLabel36.setForeground(new java.awt.Color(204, 0, 0));
        jLabel36.setText("*");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 0, 0));
        jLabel38.setText("Los campos marcados con (*) son obligatorios.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtSublote, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(7, 7, 7)
                                    .addComponent(jLabel34)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtnombreLote, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addGap(7, 7, 7)
                                    .addComponent(jLabel35)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbComunidad, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel36))))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel19)
                                .addComponent(txtPredio, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel20)
                        .addComponent(cmbProductor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel38)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdSublote, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnombreLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSublote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel35))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel36))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbComunidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPredio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(26, 26, 26)))
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbProductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdSublote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel38)
                .addGap(4, 4, 4))
        );

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        Guardar2();
        /*String fechaLlegada = new SimpleDateFormat("yyyy-MM-dd").format(dcFechaLlegada.getDate());
        String fechaRecibo2 = new SimpleDateFormat("yyyy-MM-dd").format(dcFechaLote.getDate());
        String fechaRecibo3 = new SimpleDateFormat("yyyy-MM-dd").format(dcFinSecado.getDate());
        String fechaRecibo4 = new SimpleDateFormat("yyyy-MM-dd").format(dcToma.getDate());
        String fechaRecibo5 = new SimpleDateFormat("yyyy-MM-dd").format(dcFechaCo.getDate());
        
        ml.insertarBasicos("INSERT INTO muestrasrecibidas VALUES(null, '"+fechaLlegada+"', '"+txtCapturista.getText()+
                "','"+cmbDueno.getSelectedItem()+"','"+cmbProceso.getSelectedItem()+"','"+cmbFormaCafe.getSelectedItem()+
                "','"+cmbCertificacion.getSelectedItem()+"','"+cmbCalidadCereza.getSelectedItem()+"','"+cmbMetodoSecado.getSelectedItem()+
                "','"+txtPesoMuestra.getText()+"','"+txtKilos.getText()+"','"+txtCostales.getText()+"','"+txtSublote.getText()+
                "','"+txtnombreLote.getText()+"','"+cmbBeneficio.getSelectedItem()+"','"+cmbComunidad.getSelectedItem()+
                "','"+cmbUbicacion.getSelectedItem()+"','"+txtPredio.getText()+"','"+cmbProductor.getSelectedItem()+
                "','"+fechaRecibo2+"','"+fechaRecibo3+"','"+fechaRecibo4+"','"+fechaRecibo5+"','"+cmbTomada.getSelectedItem()+
                "','"+cmbRecibida.getSelectedItem()+"','"+cmbTransportada.getSelectedItem()+"')");
        JOptionPane.showMessageDialog(null, "Inserción Exitosa");
        limpiar();*/

 /*
        "insert into bitacoralab (id_bitacora,id_muestra,fecha_llegada,tipocafe,forma,beneficio,dueño,"
        + "lote,peso,sacos,comunidad,estatus,taza,aspecto,mezasig,Metodosecado,calidadcereza,pesomuestra,ubicacioncafe"
        + ",nomlote,predio,productor,fechalote,terminosecado,tomademuestra,fechacosecha,tomadapor,recibidapor,transportadapor,"
        + "certificado,idlote,Kgconfirm) values(null,null,'" + fechaLlegada + "','"+cmbProceso.getSelectedItem()+"','"+cmbFormaCafe.getSelectedItem() + "',"
        + "'" + +cmbBeneficio.getSelectedItem() + "','" + cmbDueno.getSelectedItem() + "','" + txtSublote.getText() + "','" + txtKilos.getText() + "', +
        + ",'" + txtCostales.getText() + "','" + cmbComunidad.getSelectedItem() + "','Activada','0','0','0','" + cmbMetodoDecado.getSelectedItem() + "','" 
        '"+cmbCalidadCereza.getSelectedItem()+"','" + "','" + txtPesoMuestra.getText() + "','" + cmbUbicacion.getSelectedItem() + "','" + txtnombreLote.getText() + "','" + txtPredio.getText() + "'"
        + ",'" + cmbProductor.getSelectedItem() + "','" + fechaRecibo2 + "','" + fechaRecibo3 + "','" + fechaRecibo4 + "','" + fechaRecibo5 + "','" + cmbTomada.getSelectedItem() + "','" 
        + cmbRecibida.getSelectedItem() + "','" + cmbTransportada.getSelectedItem() + "','" + cmbCertificacion.getSelectedItem() + "','" + txtIdSublote.getText() 
        + "','" + Kgconfirmed + "')";
         */

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_jButton2ActionPerformed

    public void limpiar() {
        txtNoCSM.setText("");
        dcFechaLlegada.setDate(null);
        txtCapturista.setText("");
        cmbDueno.setSelectedIndex(0);
        cmbProceso.setSelectedIndex(0);
        cmbFormaCafe.setSelectedIndex(0);
        cmbCertificacion.setSelectedIndex(0);
        cmbCalidadCereza.setSelectedIndex(0);
        cmbMetodoSecado.setSelectedIndex(0);
        txtPesoMuestra.setText("");
        txtKilos.setText("");
        txtCostales.setText("");
        txtSublote.setText("");
        txtnombreLote.setText("");
        cmbBeneficio.setSelectedIndex(0);
        cmbComunidad.setSelectedIndex(0);
        cmbUbicacion.setSelectedIndex(0);
        txtPredio.setText("");
        cmbProductor.setSelectedIndex(0);
        dcFechaLote.setDate(null);
        dcFinSecado.setDate(null);
        dcToma.setDate(null);
        dcFechaCo.setDate(null);
        cmbTomada.setSelectedIndex(0);
        cmbRecibida.setSelectedIndex(0);
        cmbTransportada.setSelectedIndex(0);
    }

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
            java.util.logging.Logger.getLogger(jdNuevaMuestra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdNuevaMuestra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdNuevaMuestra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdNuevaMuestra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
 /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jdNuevaMuestra().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbKg;
    private javax.swing.JComboBox<String> cmbBeneficio;
    private javax.swing.JComboBox<String> cmbCalidadCereza;
    private javax.swing.JComboBox<String> cmbCertificacion;
    private javax.swing.JComboBox<String> cmbComunidad;
    private javax.swing.JComboBox<String> cmbDueno;
    private javax.swing.JComboBox<String> cmbFormaCafe;
    private javax.swing.JComboBox<String> cmbMetodoSecado;
    private javax.swing.JComboBox<String> cmbProceso;
    private javax.swing.JComboBox<String> cmbProductor;
    private javax.swing.JComboBox<String> cmbRecibida;
    private javax.swing.JComboBox<String> cmbTomada;
    private javax.swing.JComboBox<String> cmbTransportada;
    private javax.swing.JComboBox<String> cmbUbicacion;
    private com.toedter.calendar.JDateChooser dcFechaCo;
    private com.toedter.calendar.JDateChooser dcFechaLlegada;
    private com.toedter.calendar.JDateChooser dcFechaLote;
    private com.toedter.calendar.JDateChooser dcFinSecado;
    private com.toedter.calendar.JDateChooser dcToma;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtCapturista;
    private javax.swing.JTextField txtCostales;
    private javax.swing.JTextField txtIdSublote;
    private javax.swing.JTextField txtKilos;
    private javax.swing.JTextField txtNoCSM;
    private javax.swing.JTextField txtPesoMuestra;
    private javax.swing.JTextField txtPredio;
    private javax.swing.JTextField txtSublote;
    private javax.swing.JTextField txtnombreLote;
    // End of variables declaration//GEN-END:variables
}
