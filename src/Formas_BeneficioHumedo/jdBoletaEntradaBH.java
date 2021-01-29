/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_BeneficioHumedo;

import Formas_Recepcion.jdRecibos;
import Metodos.ArchivoPDF;
import MetodosGenerales.MiRender;
import Metodos_Configuraciones.metodosBeneficioHumedo;
import Reportes.creacionPDF;
import com.itextpdf.text.DocumentException;
import java.awt.Desktop;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author USUARIO
 */
public class jdBoletaEntradaBH extends javax.swing.JDialog {

    /**
     * Creates new form jdBoletaEntradaBH
     */
    String idBoleta, idSociedad, idBeneficio, tipoOrigen, ventanaOrigen,Idioma;
    Connection cn;
    metodosBeneficioHumedo mbh;
    DefaultTableModel modelo;
    creacionPDF pdf;
    jpCortesRecibidos jp;
    jdBoletasMultiples jdm;

    public jdBoletaEntradaBH(java.awt.Frame parent, boolean modal, String idBoleta, String idSociedad, String idBeneficio, String tipoOrigen, String ventanaOrigen, String Idioma, Connection cn) throws ParseException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        this.cn = cn;
        this.idBoleta = idBoleta;
        this.idSociedad = idSociedad;
        this.idBeneficio = idBeneficio;
        this.tipoOrigen = tipoOrigen;
        this.ventanaOrigen = ventanaOrigen;
        this.Idioma=Idioma;

        mbh = new metodosBeneficioHumedo(cn);
        pdf = new creacionPDF(cn, "");
        modelo = (DefaultTableModel) jTable1.getModel();

        if (tipoOrigen.equals("Nuevo")) {
            llenarTabla();
            llenarDatos();
            jDateChooser1.setDate(GregorianCalendar.getInstance().getTime());
        } else if (tipoOrigen.equals("Existente")) {
            llenarTablaExistente();
            llenarDatosExistente();
        }
        jTable1.setDefaultRenderer(Object.class, new MiRender());
    }

    public void setBox(JTable tabla, TableColumn columna) {
        String[] datos = mbh.cargarCombos("select descripcion from estadocafe").split("¬");
        JComboBox c = new JComboBox((Object[]) datos);

        columna.setCellEditor(new DefaultCellEditor(c));
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        columna.setCellRenderer(renderer);
    }

    public void llenarTabla() {
        limpiar(jTable1);
        mbh.cargarInformacionColumna1B(modelo, 4, "SELECT c.idLote,  c.formaCafe, b.sacosEnviados, b.kilosEnviados\n"
                + "from cortesdeldia c\n"
                + "LEFT join boletasalidareceptor b on(c.idLote=b.idLote)\n"
                + "where b.idBoleta='" + idBoleta + "' ");
        setBox(jTable1, jTable1.getColumnModel().getColumn(4));
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
            txtSacosEnviados.setText(datos[6]);
            txtKgEnviados.setText(datos[7]);
            txtTransporte.setText(datos[10]);
            txtPlacas.setText(datos[11]);
            txtChofer.setText(datos[12]);
            jLabel14.setText(datos[13]);
            jLabel7.setText(datos[14]);
            //txtObservaciones.setText(datos[8]);
            if (datos[9].equals("1")) {
                checkSi.setSelected(true);
            } else if (datos[9].equals("0")) {
                checkNo.setSelected(true);
            }

        } catch (Exception e) {

        }
    }

    public String idBoletaEntrada() {

        String ultimoIdBoleta = mbh.devuelveUnDato("select idBoleta from boletaentradabh where idSociedad=" + idSociedad + " order by id desc limit 1");
        int numeroConsecutivo = 0;

        if (ultimoIdBoleta.equals("") || ultimoIdBoleta == null) {
            numeroConsecutivo = 1;
        } else {
            String[] datos = ultimoIdBoleta.split("-");
            numeroConsecutivo = Integer.parseInt(datos[4]) + 1;
        }

        return "BOL-" + mbh.devuelveUnDato("select clavecorte from personam where id='" + idSociedad + "'") + "-0-0-" + numeroConsecutivo;
    }

    public void sumar() {
        try {
            int costales = 0;
            double kg = 0;
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                costales = costales + Integer.parseInt(jTable1.getValueAt(i, 5) + "");
                kg = kg + Double.parseDouble(jTable1.getValueAt(i, 6) + "");
            }

            txtTotalSacos.setText(costales + "");
            txtTotalKg.setText(kg + "");
        } catch (Exception e) {

        }
    }

    public void llenarTablaExistente() {
        limpiar(jTable1);
        mbh.cargarInformacionColumna1B(modelo, 7, "SELECT\n"
                + "    bh.idLote,\n"
                + "    c.formaCafe,\n"
                + "    bs.sacosEnviados,\n"
                + "    bs.kilosEnviados,\n"
                + "    bh.estadoCafe,\n"
                + "    bh.costalesRecibidos,\n"
                + "    bh.kgRecibidos\n"
                + "FROM\n"
                + "    boletaentradabh bh\n"
                + "LEFT JOIN boletasalidareceptor bs ON\n"
                + "    (bs.idLote = bh.idLote)\n"
                + "LEFT JOIN cortesdeldia c ON\n"
                + "    (c.idLote = bh.idLote)\n"
                + "WHERE\n"
                + "    bh.idBoleta = '" + idBoleta + "'");
        //setBox(jTable1, jTable1.getColumnModel().getColumn(4));
    }

    public void llenarDatosExistente() throws ParseException {
        try {
            //JOptionPane.showMessageDialog(null, "Existente");
            String[] datos = mbh.devolverLineaDatos("SELECT\n"
                    + "    r.nombrecorto,\n"
                    + "    bh.nombrecorto,\n"
                    + "    b.fecha,\n"
                    + "    b.fechaBoletaManual,\n"
                    + "    b.idBoletaManual,\n"
                    + "    b.idBoleta,\n"
                    + "    b.totalSacos,\n"
                    + "    b.totalKg,\n"
                    + "    b.descripcion,\n"
                    + "    b.transporteLimpio,\n"
                    + "    v.Nombre,\n"
                    + "    v.Placas,\n"
                    + "    v.Responsable,\n"
                    + "    b.horaactual,\n"
                    + "    b.horaBoletaManual,\n"
                    + "    be.idBoletaManual,\n"
                    + "    be.fechaBoletaManual,\n"
                    + "    be.fechaEntrada,\n"
                    + "    be.kgRecibidos,\n"
                    + "    be.costalesRecibidos\n"
                    + "FROM\n"
                    + "    boletaentradabh be\n"
                    + "LEFT JOIN boletasalidareceptor b ON\n"
                    + "    (b.idBoleta = be.idBoleta)\n"
                    + "LEFT JOIN vehiculo v ON\n"
                    + "    (v.ID = b.idTransporte)\n"
                    + "LEFT JOIN recepciones r ON\n"
                    + "    (r.idRecepcion = b.origen)\n"
                    + "LEFT JOIN beneficioshumedos bh ON\n"
                    + "    (bh.nombre = b.destino)\n"
                    + "WHERE\n"
                    + "    be.idBoleta = '" + idBoleta + "'\n"
                    + "GROUP BY\n"
                    + "    be.idBoleta", 20).split("¬");

            /*SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        
        if (!datos[3].equals("")) {
            fechaDate = formato.parse(datos[3]);
            jDateChooser2.setDate(fechaDate);
        }*/

 /*Dato0 :RE-GT-4
        Dato1: Bh-Rustico
        Dato2: 2019-06-04
        Dato3:
        Dato4:0
        Dato5:BOL-GT-0-0-2
        Dato6:11
        Dato7:201.0
        Dato8:sdfdsfsdfs
        Dato9:1
        Dato10:Ford Negra
        Dato11:PE-38-170
        Dato12:Benigno Altamirano
        Dato13:12:08:23
             */
            jLabel3.setText(datos[0]);
            jLabel4.setText(datos[1]);
            jLabel13.setText(datos[2]);
            jLabel23.setText(datos[3]);
            jLabel22.setText(datos[4]);
            //txtBoletaManual.setText(datos[4]);
            txtSacosEnviados.setText(datos[6]);
            txtKgEnviados.setText(datos[7]);
            txtTransporte.setText(datos[10]);
            txtPlacas.setText(datos[11]);
            txtChofer.setText(datos[12]);
            jLabel14.setText(datos[13]);
            jLabel7.setText(datos[14]);

            if (!datos[15].equals("")) {
                jCheckBox1.setSelected(true);
            }
            txtBoletaManual.setText(datos[15]);

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaDate = null;

            if (!datos[16].equals("")) {
                fechaDate = formato.parse(datos[16]);
                fechaBM.setDate(fechaDate);
            }

            if (!datos[17].equals("")) {
                fechaDate = formato.parse(datos[17]);
                jDateChooser1.setDate(fechaDate);
            }

            txtTotalKg.setText(datos[18]);
            txtTotalSacos.setText(datos[19]);
            //txtObservaciones.setText(datos[8]);
            if (datos[9].equals("1")) {
                checkSi.setSelected(true);
            } else if (datos[9].equals("0")) {
                checkNo.setSelected(true);
            }
            jLabel25.setText(idBoleta);
            jButton1.setVisible(false);
            //jCheckBox1.setEnabled(false);
        } catch (Exception e) {

        }
    }

    public void crearBoletaEntrada() {
        // String estadoCafe = jTable1.getValueAt(0, 4) + "";
        try {
            Date date = new Date();
            String fechaBoletaManual = "", boletaManual = "";
            String fechaEntrada = new SimpleDateFormat("yyyy-MM-dd").format(date);

            if (jCheckBox1.isSelected()) {
                boletaManual = txtBoletaManual.getText();
                fechaBoletaManual = new SimpleDateFormat("yyyy-MM-dd").format(fechaBM.getDate());
            }
            Boolean valor = null;
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                if (jTable1.getValueAt(i, 5).equals("") || jTable1.getValueAt(i, 6).equals("")) {
                    valor = false;
                }
                valor = true;
            }

            if (valor == true) {
                for (int i = 0; i < jTable1.getRowCount(); i++) {
                    //JOptionPane.showMessageDialog(null,"Vuelta: "+i);

                    if (mbh.insertarEnCiclo("insert into boletaentradabh values"
                            + " (null,'" + idBeneficio + "', '" + idBoleta + "', '" + jTable1.getValueAt(i, 0) + "', '" + boletaManual + "','" + fechaBoletaManual + "', "
                            + " '" + fechaEntrada + "','" + jTable1.getValueAt(i, 6) + "','" + jTable1.getValueAt(i, 5) + "', "
                            + "'" + jTable1.getValueAt(i, 4) + "', '1'  )")) {

                        //JOptionPane.showMessageDialog(null,"Si voy a insertar");
                        
                        mbh.insertarEnCiclo("insert into sublotesconfirmados values("
                                + "null, '" + jTable1.getValueAt(i, 0) + "', '" + jTable1.getValueAt(i, 0) + "', '" + idBeneficio + "', "
                                + "'" + fechaEntrada + "', '" + jTable1.getValueAt(i, 1) + "',"
                                + "'" + mbh.devuelveUnDato("select certificacion\n"
                                        + "from cortesdeldia\n"
                                        + "where idLote='"+jTable1.getValueAt(i, 0)+"' ") + "' , '" + jTable1.getValueAt(i, 4) + "', '" + jTable1.getValueAt(i, 6) + "', '1' )");

                         mbh.actualizarBoleta("update boletasalidareceptor set estatus=2 where idBoleta='" + idBoleta + "'");
                    }
                }
                
                JOptionPane.showMessageDialog(null,"Entrada Exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "Revisar Kilos y Sacos Recibidos");
            }

            if (ventanaOrigen.equals("CortesRecibidos")) {
                jp.llenarTabla();
            } else {
                jdm.actualizarCortesRecibidos();
            }

            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, Entrada BH\n" + e);

        }

        /*   try {
            pdf.pdfRecibo(mbh.devuelveUnDato("select id from boletaentradabh order by id desc limit 1"));
        } catch (DocumentException ex) {
            Logger.getLogger(jdBoletaEntradaBH.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(jdBoletaEntradaBH.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(jdBoletaEntradaBH.class.getName()).log(Level.SEVERE, null, ex);
        }

        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(new java.io.File("pruebaRecibo.pdf"));
        } catch (IOException ex) {
            Logger.getLogger(jdRecibos.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    public Object[][] obtenerContenidoTabla(DefaultTableModel modelo) {
        Object[][] contenido = null;
        contenido = new Object[modelo.getRowCount()][modelo.getColumnCount()];
        for (int i = 0; i < modelo.getRowCount(); i++) {
            for (int j = 0; j < modelo.getColumnCount(); j++) {
                contenido[i][j] = modelo.getValueAt(i, j);
            }
        }
        return contenido;
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtBoletaManual = new javax.swing.JTextField();
        fechaBM = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtSacosEnviados = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtKgEnviados = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTotalSacos = new javax.swing.JTextField();
        txtTotalKg = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtTransporte = new javax.swing.JTextField();
        txtPlacas = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtChofer = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        checkSi = new javax.swing.JCheckBox();
        checkNo = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Boleta De Entrada A Beneficio Humedo");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Origen");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Destino");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Fecha Salida");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Hora");

        jDateChooser1.setDateFormatString("dd/MMM/yyyy");
        jDateChooser1.setEnabled(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Corte", "Forma Café", "Sacos", "Kg", "Estado Café", "Costales Recibidos", "Kg Recibidos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        txtBoletaManual.setEnabled(false);
        txtBoletaManual.setOpaque(false);

        fechaBM.setDateFormatString("dd/MMM/yyyy");
        fechaBM.setEnabled(false);
        fechaBM.setOpaque(false);

        jLabel8.setText("Fecha Manual");

        jLabel9.setText("Total Sacos Enviados:");

        txtSacosEnviados.setEnabled(false);
        txtSacosEnviados.setOpaque(false);

        jLabel10.setText("Total Kg Enviados:");

        txtKgEnviados.setEnabled(false);
        txtKgEnviados.setOpaque(false);

        jLabel11.setText("Total Sacos:");

        jLabel12.setText("Total Kg:");

        txtTotalSacos.setEnabled(false);
        txtTotalSacos.setOpaque(false);

        txtTotalKg.setEnabled(false);
        txtTotalKg.setOpaque(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Transporte"));

        jLabel15.setText("Transporte");

        txtTransporte.setEnabled(false);
        txtTransporte.setOpaque(false);

        txtPlacas.setEnabled(false);
        txtPlacas.setOpaque(false);

        jLabel16.setText("No. Placas");

        jLabel17.setText("Nombre Chofer");

        txtChofer.setEnabled(false);
        txtChofer.setOpaque(false);

        jLabel18.setText("¿Vehiculo Limpio?");

        checkSi.setText("Si");

        checkNo.setText("No");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(txtTransporte, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(txtPlacas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(txtChofer, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(checkSi)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(checkNo))
                        .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkSi)
                    .addComponent(checkNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlacas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");

        jLabel13.setText("jLabel13");

        jLabel14.setText("jLabel14");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Boleta Manual");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Fecha Boleta Manual");

        jLabel22.setText("jLabel13");

        jLabel23.setText("jLabel13");

        jCheckBox1.setText("Boleta Manual");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Id Boleta");

        jLabel25.setText("jLabel25");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Hora");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Observaciones"));

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        txtObservaciones.setOpaque(false);
        jScrollPane2.setViewportView(txtObservaciones);

        jLabel19.setText("Observaciones");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton3.setText("Abrir PDF");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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
                            .addComponent(txtBoletaManual, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(fechaBM, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSacosEnviados)
                            .addComponent(txtKgEnviados, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTotalSacos)
                            .addComponent(txtTotalKg, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                                        .addComponent(jLabel25)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jCheckBox1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBoletaManual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fechaBM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtTotalSacos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtTotalKg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtSacosEnviados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtKgEnviados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jButton3))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
        sumar();
    }//GEN-LAST:event_jTable1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        crearBoletaEntrada();
        
        Object[][] contenido = obtenerContenidoTabla(modelo);
        creacionPDF pdf = new creacionPDF(cn, Idioma);
        try {
            pdf.pdfBoletaEntradaBH(mbh.devuelveUnDato("select idBoleta from boletaentradabh order by id desc limit 1"), contenido, txtObservaciones.getText());
        } catch (Exception e) {

        }

        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(new java.io.File("C:\\fincalab\\pruebaBoleta.pdf"));
        } catch (IOException ex) {
            Logger.getLogger(jdRecibos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox1.isSelected()) {
            txtBoletaManual.setEnabled(true);
            fechaBM.setEnabled(true);
        } else {
            txtBoletaManual.setEnabled(false);
            fechaBM.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Object[][] contenido = obtenerContenidoTabla(modelo);
        creacionPDF pdf = new creacionPDF(cn, Idioma);
        try {
            pdf.pdfBoletaEntradaBH(mbh.devuelveUnDato("select idBoleta from boletaentradabh order by id desc limit 1"), contenido, txtObservaciones.getText());
        } catch (Exception e) {

        }

        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(new java.io.File("C:\\fincalab\\pruebaBoleta.pdf"));
        } catch (IOException ex) {
            Logger.getLogger(jdRecibos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(jdBoletaEntradaBH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdBoletaEntradaBH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdBoletaEntradaBH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdBoletaEntradaBH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
 /*   java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdBoletaEntradaBH dialog = new jdBoletaEntradaBH(new javax.swing.JFrame(), true);
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
    private javax.swing.JCheckBox checkNo;
    private javax.swing.JCheckBox checkSi;
    private com.toedter.calendar.JDateChooser fechaBM;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBoletaManual;
    private javax.swing.JTextField txtChofer;
    private javax.swing.JTextField txtKgEnviados;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JTextField txtPlacas;
    private javax.swing.JTextField txtSacosEnviados;
    private javax.swing.JTextField txtTotalKg;
    private javax.swing.JTextField txtTotalSacos;
    private javax.swing.JTextField txtTransporte;
    // End of variables declaration//GEN-END:variables
}
