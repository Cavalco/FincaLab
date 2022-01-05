/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_Recepcion;

import Idioma.Propiedades;
import Metodos_Configuraciones.metodosDatosBasicos;
import Reportes.creacionPDF;
import com.itextpdf.text.DocumentException;
import java.awt.Desktop;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class jdBoletaSalidaReceptor extends javax.swing.JDialog {

    /**
     * Creates new form jdBoletaSalidaReceptor
     */
    Connection cn;
    metodosDatosBasicos mdb;
    DefaultTableModel modelo;
    String cadenaIdsCortes, sociedad, idSociedad, idRecepcion, Idioma;
    jpCortesDelDia jpL;
    Propiedades idioma;

    public jdBoletaSalidaReceptor(java.awt.Frame parent, boolean modal, String cadenaIdsCortes, String sociedad, String idRecepcion, String Idioma, Connection cn) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        this.cn = cn;
        this.Idioma = Idioma;
        this.idRecepcion = idRecepcion;
        idioma = new Propiedades(Idioma);
        mdb = new metodosDatosBasicos(cn, Idioma);
        this.cadenaIdsCortes = cadenaIdsCortes;
        modelo = (DefaultTableModel) jTable1.getModel();

        //idRecepcion = mdb.devuelveUnDato("select id from recepciones where idRecepcion='" + recepcion + "'");
        jDateChooser1.setDate(GregorianCalendar.getInstance().getTime());

        this.sociedad = sociedad;

        lblSociedad.setText(sociedad);
        lblRecepcion.setText(idRecepcion);

        idSociedad = mdb.devuelveUnDato("select idSociedad from recepciones where idRecepcion='" + idRecepcion + "' ");

        //String ultimoIdBoleta = mdb.devuelveUnDato("select idBoleta from boletasalidareceptor where idSociedad="+idSociedad+" order by id desc limit 1");
        //JOptionPane.showMessageDialog(null, "Ultimo id de la sociedad "+sociedad+ " ="+ultimoIdBoleta);
        traductor();
        llenarTablaIdCortes();
        llenarCombos();
    }

    public void traductor() {
        jLabel11.setText(idioma.getProperty("Origen"));
        jLabel12.setText(idioma.getProperty("Recepcion"));
        jLabel1.setText(idioma.getProperty("Destino"));
        jLabel2.setText(idioma.getProperty("Fecha"));

        jCheckBox1.setText(idioma.getProperty("BoletaManual"));
        jLabel4.setText(idioma.getProperty("FechaDeBoletaManual"));

        jLabel5.setText(idioma.getProperty("TotalSacos"));
        jLabel6.setText(idioma.getProperty("TotalKilos"));

        jLabel7.setText(idioma.getProperty("Transporte"));
        jLabel8.setText(idioma.getProperty("Placas"));
        jLabel9.setText(idioma.getProperty("NombreChofer"));
        jLabel10.setText(idioma.getProperty("Observaciones"));

        jButton2.setText(idioma.getProperty("Aceptar"));
        jButton3.setText(idioma.getProperty("Cancelar"));

        valorL.setText(idioma.getProperty("TransporteLimpio"));

        comboTipoDestino.addItem(idioma.getProperty("Seleccione"));
        comboTipoDestino.addItem(idioma.getProperty("BeneficioHumedo"));
        comboTipoDestino.addItem(idioma.getProperty("Almacen"));

        jTable1.getColumnModel().getColumn(0).setHeaderValue(idioma.getProperty("IdCorte"));
        jTable1.getColumnModel().getColumn(1).setHeaderValue(idioma.getProperty("Certificado"));
        jTable1.getColumnModel().getColumn(2).setHeaderValue(idioma.getProperty("FormaDeCafe"));
        jTable1.getColumnModel().getColumn(3).setHeaderValue(idioma.getProperty("Sacos"));
        jTable1.getColumnModel().getColumn(4).setHeaderValue(idioma.getProperty("Kilos"));

    }

    public void llenarTablaIdCortes() {
        limpiar(jTable1);
        String[] cadena = cadenaIdsCortes.split("¬");
        int totalSacos = 0;
        float totalKg = 0;

        for (int i = 0; i < cadena.length; i++) {
            mdb.cargarInformacion2(modelo, 5, "select idLote, certificacion, formaCafe, sacos, kg from cortesdeldia where idLote='" + cadena[i] + "'");
        }

        for (int i = 0; i < modelo.getRowCount(); i++) {
            totalSacos = totalSacos + Integer.parseInt(modelo.getValueAt(i, 3) + "");
            totalKg = totalKg + Float.parseFloat(modelo.getValueAt(i, 4) + "");
        }

        txtTotalSacos.setText(totalSacos + "");
        txtTotalKg.setText(totalKg + "");
    }

    public void llenarCombos() {
        String[] sociedades = mdb.cargarCombos("select nombrecorto from personam").split("¬");
        comboSociedades.setModel(new DefaultComboBoxModel((Object[]) sociedades));
    }

    public void datosTransporte(String vehiculo, String placas, String chofer) {
        txtVehiculo.setText(vehiculo);
        txtPlacas.setText(placas);
        txtChofer.setText(chofer);
    }

    public void procesoCombos() {
        String datos[];
        String idSociedad = mdb.devuelveId("select id from personam where nombrecorto='" + comboSociedades.getSelectedItem() + "'");

        if (idSociedad.equals("")) {
        } else {
            if (idioma.getProperty("BeneficioHumedo").equals(comboTipoDestino.getSelectedItem())) {
                datos = mdb.cargarCombos("select nombrecorto from beneficioshumedos where idSociedad=" + idSociedad + " ").split("¬");
                comboDestino.setModel(new DefaultComboBoxModel((Object[]) datos));
            } else if (idioma.getProperty("Almacen").equals(comboTipoDestino.getSelectedItem())) {
                datos = mdb.cargarCombos("select nombrealmacen from almacenes where idSociedad=" + idSociedad + " ").split("¬");
                comboDestino.setModel(new DefaultComboBoxModel((Object[]) datos));
            }
        }
    }

    public String idBoletaSalida() {

        String ultimoIdBoleta = mdb.devuelveUnDato("select idBoleta from boletasalidareceptor where idSociedad=" + idSociedad + " order by id desc limit 1");
        int numeroConsecutivo = 0;

        if (ultimoIdBoleta.equals("") || ultimoIdBoleta.equals("null")) {
            numeroConsecutivo = 1;
        } else {
            String[] datos = ultimoIdBoleta.split("-");
            numeroConsecutivo = Integer.parseInt(datos[4]) + 1;
        }

        return "BOL-" + mdb.devuelveUnDato("select clavecorte from personam where nombrecorto='" + sociedad + "'") + "-0-0-" + numeroConsecutivo;
    }

    public Boolean validar() {

        if (comboSociedades.getSelectedItem().equals(idioma.getProperty("Seleccione")) || comboTipoDestino.getSelectedItem().equals(idioma.getProperty("Seleccione"))
                || comboDestino.getSelectedItem().equals(idioma.getProperty("Seleccione"))) {
            JOptionPane.showMessageDialog(null, "Seleccione Destino");
            return false;
        } else if (txtVehiculo.getText().length() <= 0 || txtPlacas.getText().length() <= 0 || txtChofer.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Seleccione Transporte");
            return false;
        } else {
            return true;
        }
    }

    public Boolean validarConDivision() {

        if (comboSociedades.getSelectedItem().equals(idioma.getProperty("Seleccione")) || comboTipoDestino.getSelectedItem().equals(idioma.getProperty("Seleccione"))
                || comboDestino.getSelectedItem().equals(idioma.getProperty("Seleccione"))) {
            JOptionPane.showMessageDialog(null, "Seleccione Destino");
            return false;
        } else {
            return true;
        }
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

    public void insertarBoleta() {
        String idTransporte = mdb.devuelveUnDato("select id from vehiculo where nombre='" + txtVehiculo.getText() + "' and placas = '" + txtPlacas.getText() + "' and responsable='" + txtChofer.getText() + "'  ");
        String fechaBoleta = new SimpleDateFormat("yyyy-MM-dd").format(jDateChooser1.getDate());
        String fechaBoletaManual = "";
        String idBeneficio = "", tipoLugar = "";
        String valorLimpio = "", idBoletaSalida = idBoletaSalida();
        String boletaManual = "";

        if (comboTipoDestino.getSelectedIndex() == 1) {
            idBeneficio = mdb.devuelveUnDato("select nombre from beneficioshumedos where nombrecorto='"+comboDestino.getSelectedItem()+"' ");
            tipoLugar = "B";
        } else if (comboTipoDestino.getSelectedIndex() == 2) {
            idBeneficio = comboDestino.getSelectedItem() + "";
            tipoLugar = "A";
        }

        Date date = new Date();
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        String horaActual = hourFormat.format(date);

        if (txtBoletaManual.getText().equals("")) {
            boletaManual = "";
        } else {
            boletaManual = txtBoletaManual.getText();
            fechaBoletaManual = new SimpleDateFormat("yyyy-MM-dd").format(jDateChooser2.getDate());
        }

        if (valorL.isSelected()) {
            //Está limpio
            valorLimpio = "1";
        } else {
            //Sucio
            valorLimpio = "0";
        }
        if (validar() == true) {
            for (int i = 0; i < modelo.getRowCount(); i++) {
                String idLote = modelo.getValueAt(i, 0) + "";
                // JOptionPane.showMessageDialog(null, "Lote "+idLote);
                if (mdb.insertarEnCiclo("insert into boletasalidareceptor values (null, '" + idRecepcion + "', " + idSociedad + ", '" + idBoletaSalida + "', '" + idLote + "', '" + boletaManual + "', "
                        + "" + idTransporte + ", '" + fechaBoleta + "', '" + horaActual + "', '" + fechaBoletaManual + "','" + txtHora.getText() + "', '" + txtTotalSacos.getText() + "', '" + txtTotalKg.getText() + "', "
                        + "'" + idRecepcion + "', '" + idBeneficio + "', '" + tipoLugar + "', '" + txtObserva.getText() + "', " + valorLimpio + ", "
                        + "'" + modelo.getValueAt(i, 3) + "', '" + modelo.getValueAt(i, 4) + "', '1',0 )") == true) {

                    mdb.actualizarEnCiclo("update cortesdeldia set estatus='Inactivo' where idLote='" + idLote + "'");

                    JOptionPane.showMessageDialog(null, "Id Boleta Asignado = " + idBoletaSalida);

                    try {
                        jpL.llenarTabla();
                    } catch (ParseException ex) {
                        Logger.getLogger(jdBoletaSalidaReceptor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.dispose();

                } else {
                    //Entra aqui si no se inserta correctamente en ciclo
                }

            }

            Object[][] contenido = obtenerContenidoTabla(modelo);
            creacionPDF pdf = new creacionPDF(cn, Idioma);
            try {
                pdf.pdfBoletaSalidaRecepcion(mdb.devuelveUnDato("select idBoleta from boletasalidareceptor order by id desc limit 1"), contenido);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(jdBoletaSalidaReceptor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(jdBoletaSalidaReceptor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(jdBoletaSalidaReceptor.class.getName()).log(Level.SEVERE, null, ex);
            }

            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(new java.io.File("pruebaBoleta.pdf"));
            } catch (IOException ex) {
                Logger.getLogger(jdRecibos.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            //Entra aqui si no esta bien validado
        }

    } 
            
            
    //REVISAR POR QUE SE ELIMINO METODO
    //public void insertarBoletaDivision(DefaultTableModel modelo2) 

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
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        comboSociedades = new javax.swing.JComboBox<>();
        comboTipoDestino = new javax.swing.JComboBox<>();
        comboDestino = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        txtBoletaManual = new javax.swing.JTextField();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txtTotalSacos = new javax.swing.JTextField();
        txtTotalKg = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtVehiculo = new javax.swing.JTextField();
        txtPlacas = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtChofer = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        valorL = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        lblSociedad = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblRecepcion = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        txtHora = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObserva = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Boleta de Salida Receptor");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id Lote", "Certificacion", "Forma de Café", "Sacos", "Kg"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Destino");

        comboSociedades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboSociedades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSociedadesActionPerformed(evt);
            }
        });

        comboTipoDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoDestinoActionPerformed(evt);
            }
        });

        jLabel2.setText("Fecha");

        jDateChooser1.setDateFormatString("dd/MMM/yyyy");
        jDateChooser1.setEnabled(false);

        txtBoletaManual.setEnabled(false);

        jDateChooser2.setDateFormatString("dd/MMM/yyyy");
        jDateChooser2.setEnabled(false);

        jLabel4.setText("Fecha");

        txtTotalSacos.setEditable(false);

        txtTotalKg.setEditable(false);

        jLabel5.setText("Total Sacos");

        jLabel6.setText("Total Kg");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Transporte"));

        jLabel7.setText("Transporte");

        jLabel8.setText("Numero de Placas");

        jLabel9.setText("Nombre del Chofer");

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        valorL.setText("Transporte Limpio");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtPlacas, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtChofer, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(valorL))
                            .addComponent(txtVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(valorL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPlacas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtChofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Origen");

        lblSociedad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSociedad.setText("jLabel12");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Recepción");

        lblRecepcion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRecepcion.setText("lblRecepcion");

        jCheckBox1.setText("Boleta Manual");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        txtHora.setEnabled(false);

        jLabel3.setText("Hora");

        jButton4.setText("Dividir Envio");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Observaciones"));
        jPanel3.setToolTipText("");

        txtObserva.setColumns(20);
        txtObserva.setRows(5);
        jScrollPane2.setViewportView(txtObserva);

        jLabel10.setText("Observaciones");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addGap(16, 16, 16))
        );

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
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboSociedades, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboTipoDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addGap(18, 18, 18)
                            .addComponent(lblSociedad)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel12)
                            .addGap(18, 18, 18)
                            .addComponent(lblRecepcion))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtBoletaManual, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jCheckBox1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(272, 272, 272)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTotalSacos, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(txtTotalKg, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblSociedad)
                    .addComponent(jLabel12)
                    .addComponent(lblRecepcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboSociedades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboTipoDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTotalSacos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTotalKg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jCheckBox1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtBoletaManual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jdTransporteBoletaSalida jdT = new jdTransporteBoletaSalida(null, true, Idioma, cn);
        jdT.jdB = this;
        jdT.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        insertarBoleta();
        Object[][] contenido = obtenerContenidoTabla(modelo);
        creacionPDF pdf = new creacionPDF(cn, Idioma);
        try {
            pdf.pdfBoletaSalidaRecepcion(mdb.devuelveUnDato("select idBoleta from boletasalidareceptor order by id desc limit 1"), contenido);
        } catch (Exception e) {

        }

        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(new java.io.File("C:\\FincaLab\\pruebaBoleta.pdf"));
        } catch (IOException ex) {
            Logger.getLogger(jdRecibos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox1.isSelected()) {
            txtBoletaManual.setEnabled(true);
            jDateChooser2.setEnabled(true);
            txtHora.setEnabled(true);
        } else {
            txtBoletaManual.setEnabled(false);
            jDateChooser2.setEnabled(false);
            txtHora.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void comboTipoDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoDestinoActionPerformed
        // TODO add your handling code here:
        procesoCombos();
    }//GEN-LAST:event_comboTipoDestinoActionPerformed

    private void comboSociedadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSociedadesActionPerformed
        // TODO add your handling code here:
        procesoCombos();
    }//GEN-LAST:event_comboSociedadesActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jdDividirEnvio jdD = new jdDividirEnvio(null, true, txtTotalSacos.getText(), txtTotalKg.getText(), Idioma, cn);
        jdD.jdB = this;
        jdD.setVisible(true);
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
            java.util.logging.Logger.getLogger(jdBoletaSalidaReceptor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdBoletaSalidaReceptor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdBoletaSalidaReceptor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdBoletaSalidaReceptor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
 /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdBoletaSalidaReceptor dialog = new jdBoletaSalidaReceptor(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> comboDestino;
    private javax.swing.JComboBox<String> comboSociedades;
    private javax.swing.JComboBox<String> comboTipoDestino;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblRecepcion;
    private javax.swing.JLabel lblSociedad;
    private javax.swing.JTextField txtBoletaManual;
    private javax.swing.JTextField txtChofer;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextArea txtObserva;
    private javax.swing.JTextField txtPlacas;
    private javax.swing.JTextField txtTotalKg;
    private javax.swing.JTextField txtTotalSacos;
    private javax.swing.JTextField txtVehiculo;
    private javax.swing.JCheckBox valorL;
    // End of variables declaration//GEN-END:variables
}
