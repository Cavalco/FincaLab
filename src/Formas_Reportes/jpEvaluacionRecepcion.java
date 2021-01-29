/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_Reportes;

import Conexion.Conexion;
import Formas_Recepcion.*;
import Idioma.Propiedades;
import Metodos_Configuraciones.metodosDatosBasicos;
import Metodos_Configuraciones.metodosRecepcion;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Carlos Valdez
 */
public class jpEvaluacionRecepcion extends javax.swing.JPanel {

    /**
     * Creates new form jpRecibos
     */
    Connection cn;
    metodosDatosBasicos mdb;
    metodosRecepcion mr;
    DefaultTableModel modelo;
    jdRecibos jdR;
    String idSociedadRecepcion = "", recepcion, Idioma, idUsuario;
    Propiedades idioma;
    DefaultPieDataset data;

    public jpEvaluacionRecepcion(Connection cn, String Idioma) {
        initComponents();

        this.cn = cn;
        this.Idioma = Idioma;
        this.idUsuario = idUsuario;
        mdb = new metodosDatosBasicos(cn, Idioma);
        mr = new metodosRecepcion(cn);
        idioma = new Propiedades(Idioma);
        modelo = (DefaultTableModel) tablaInformacion.getModel();

        idSociedadRecepcion = mdb.devuelveUnDato("select idSociedad from recepciones where idRecepcion='" + recepcion + "'");
        this.recepcion = recepcion;
        // traductor();
        llenarTabla();
        //sumarColumnas();
        //llenarCombos();
        //tablaRecibos.setRowSorter(new TableRowSorter(modelo));
        data = new DefaultPieDataset();

        panelGraficas = new JPanel();
        //getContentPane().add(panelGraficas);
    }

    public void traductor() {
        /*  jLabel1.setText(idioma.getProperty("Folio"));
        jLabel2.setText(idioma.getProperty("FolioManual"));
        jLabel3.setText(idioma.getProperty("Nombre"));
        jLabel4.setText(idioma.getProperty("ApellidoPaterno"));
        jLabel5.setText(idioma.getProperty("ApellidoMaterno"));
        jLabel6.setText(idioma.getProperty("IdCorte"));

        tablaRecibos.getColumnModel().getColumn(0).setHeaderValue(idioma.getProperty("Folio"));
        tablaRecibos.getColumnModel().getColumn(1).setHeaderValue(idioma.getProperty("FolioManual"));
        tablaRecibos.getColumnModel().getColumn(2).setHeaderValue(idioma.getProperty("IdCorte"));
        // tablaRecibos.getColumnModel().getColumn(3).setHeaderValue(idioma.getProperty("FechaDeRecepcion"));
        tablaRecibos.getColumnModel().getColumn(5).setHeaderValue(idioma.getProperty("Nombre"));
        tablaRecibos.getColumnModel().getColumn(6).setHeaderValue(idioma.getProperty("ApellidoPaterno"));
        tablaRecibos.getColumnModel().getColumn(7).setHeaderValue(idioma.getProperty("ApellidoMaterno"));
        tablaRecibos.getColumnModel().getColumn(8).setHeaderValue(idioma.getProperty("Sociedad"));
        tablaRecibos.getColumnModel().getColumn(9).setHeaderValue(idioma.getProperty("Parcela"));
        tablaRecibos.getColumnModel().getColumn(10).setHeaderValue(idioma.getProperty("FormaDeCafe"));
        tablaRecibos.getColumnModel().getColumn(11).setHeaderValue(idioma.getProperty("Sacos"));
        tablaRecibos.getColumnModel().getColumn(12).setHeaderValue(idioma.getProperty("KilosRecibidos"));
        tablaRecibos.getColumnModel().getColumn(13).setHeaderValue(idioma.getProperty("TotalBruto"));
        tablaRecibos.getColumnModel().getColumn(14).setHeaderValue(idioma.getProperty("Retencion"));
        tablaRecibos.getColumnModel().getColumn(15).setHeaderValue(idioma.getProperty("Total"));
        tablaRecibos.getColumnModel().getColumn(16).setHeaderValue(idioma.getProperty("Verdes"));
        tablaRecibos.getColumnModel().getColumn(17).setHeaderValue(idioma.getProperty("Inmaduros"));
        tablaRecibos.getColumnModel().getColumn(18).setHeaderValue(idioma.getProperty("Brocados"));
        tablaRecibos.getColumnModel().getColumn(19).setHeaderValue(idioma.getProperty("Calificacion"));
        tablaRecibos.getColumnModel().getColumn(20).setHeaderValue(idioma.getProperty("Entrego"));
        tablaRecibos.getColumnModel().getColumn(21).setHeaderValue(idioma.getProperty("Observaciones"));

        jLabel7.setText(idioma.getProperty("Situacion"));
        jLabel8.setText(idioma.getProperty("TotalRecibos"));
//        jLabel9.setText(idioma.getProperty("TotalSacos"));
        jLabel10.setText(idioma.getProperty("TotalKilos"));

        jButton1.setText(idioma.getProperty("Exportar"));
        //   jButton2.setText(idioma.getProperty("Nuevo"));
        jButton5.setText(idioma.getProperty("Ver"));
        //    jButton3.setText(idioma.getProperty("Cancelar"));
        jButton4.setText(idioma.getProperty("Cerrar"));
         */
        jComboBox1.addItem(idioma.getProperty("Activos"));
        jComboBox1.addItem(idioma.getProperty("Inactivos"));
        jComboBox1.addItem(idioma.getProperty("Todos"));
    }

    public void graficas() {
        // Fuente de Datos
        data.setValue("Calificacion 3", 70);
        data.setValue("Calificacion 1", 20);
        data.setValue("Calificacion 2", 40);

        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart(
                "Grafica Calificaciones",
                data,
                true,
                true,
                false);
        // Mostrar Grafico en frame
        ChartFrame frame = new ChartFrame("JFreeChart", chart);
        frame.pack();
        frame.setVisible(true);

        // Crear el Panel del Grafico con ChartPanel
        //ChartPanel chartPanel = new ChartPanel(chart);
        //panelGraficas.add(chartPanel);    
        /*ChartPanel panel = new ChartPanel(chart);        
        panelGraficas.setLayout(new java.awt.BorderLayout());
        panelGraficas.add(panel);   
        panelGraficas.validate();*/
    }

    public void llenarTabla() {
        limpiar(tablaInformacion);
        String[] bds = {"fincalab_basilio", "fincalab_procaa", "fincalab_caldio", "fincalab_astal", "fincalab_tambor"};
        for (int i = 0; i < bds.length; i++) {
            cn = (new Conexion()).conectar(bds[i]);
            mdb = new metodosDatosBasicos(cn, Idioma);
            mdb.cargarInformacion2(modelo, 17, "SELECT\n"
                    + "    r.fechaRecepcion,\n"
                    + "    pm.NombreCorto,\n"
                    + "    r.id,\n"
                    + "    p.clave_productor,\n"
                    + "    pf.ApellidoPaterno,\n"
                    + "    pf.ApellidoMaterno,\n"
                    + "    pf.Nombre,\n"
                    + "    case pf.ID_Genero  when 1 then 'Masculino'  when 2 then 'Femenino' end as Genero,\n"
                    + "    pa.clave_parcela,\n"
                    + "    pa.nombre,\n"
                    + "    c.nombre,\n"
                    + "    r.formaCafe,\n"
                    + "    r.inmaduros,\n"
                    + "    r.verdes,\n"
                    + "    r.brocados,\n"
                    + "    100-(r.verdes*r.verdes+r.inmaduros+r.brocados) as Cal_numerica,\n"
                    + "    r.idLote\n"
                    + "FROM\n"
                    + "    recibos r\n"
                    + "LEFT JOIN personam pm ON\n"
                    + "    (pm.ID = r.idSociedad)\n"
                    + "LEFT JOIN personaf pf ON\n"
                    + "    (pf.ID = r.idPersona)\n"
                    + "LEFT JOIN productor p ON\n"
                    + "    (p.id_persona = r.idPersona)\n"
                    + "LEFT JOIN parcelas pa ON\n"
                    + "    (pa.id = r.idParcela)\n"
                    + "LEFT JOIN codigos_certificacion c ON\n"
                    + "    (\n"
                    + "        c.codigo=pa.clave_certificacion\n"
                    + "    )\n"
                    + "WHERE r.fechaRecepcion >  '2020-01-01'\n"
                    + "ORDER BY\n"
                    + "    r.fechaRecepcion ASC");

        }

    }

    public void cambiarMesLetra(JTable tabla) {
        for (int i = 0; i < tabla.getRowCount(); i++) {

            String fecha = tabla.getValueAt(i, 2) + "";

            String[] fecha2 = fecha.split("-");

            String año = fecha2[0];
            String mes = fecha2[1];
            String dia = fecha2[2];

            switch (mes) {
                case "01":
                    mes = "Ene";
                    break;
                case "02":
                    mes = "Feb";
                    break;
                case "03":
                    mes = "Mar";
                    break;
                case "04":
                    mes = "Abr";
                    break;
                case "05":
                    mes = "May";
                    break;
                case "06":
                    mes = "Jun";
                    break;
                case "07":
                    mes = "Jul";
                    break;
                case "08":
                    mes = "Ago";
                    break;
                case "09":
                    mes = "Sep";
                    break;
                case "10":
                    mes = "Oct";
                    break;
                case "11":
                    mes = "Nov";
                    break;
                case "12":
                    mes = "Dic";
                    break;
                default:
                    mes = "Invalid month";
                    break;
            }
            fecha = año + "-" + mes + "-" + dia;
            tabla.setValueAt(fecha, i, 2);
        }
    }

    public void cambiarMesLetra2(JTable tabla) {
        for (int i = 0; i < tabla.getRowCount(); i++) {

            String fecha = tabla.getValueAt(i, 3) + "";

            if (!fecha.equals("")) {
                String[] fecha2 = fecha.split("-");

                String año = fecha2[0];
                String mes = fecha2[1];
                String dia = fecha2[2];
                switch (mes) {
                    case "01":
                        mes = "Ene";
                        break;
                    case "02":
                        mes = "Feb";
                        break;
                    case "03":
                        mes = "Mar";
                        break;
                    case "04":
                        mes = "Abr";
                        break;
                    case "05":
                        mes = "May";
                        break;
                    case "06":
                        mes = "Jun";
                        break;
                    case "07":
                        mes = "Jul";
                        break;
                    case "08":
                        mes = "Ago";
                        break;
                    case "09":
                        mes = "Sep";
                        break;
                    case "10":
                        mes = "Oct";
                        break;
                    case "11":
                        mes = "Nov";
                        break;
                    case "12":
                        mes = "Dic";
                        break;
                    default:
                        mes = "Invalid month";
                        break;
                }
                fecha = año + "-" + mes + "-" + dia;
                tabla.setValueAt(fecha, i, 3);
            }
        }
    }

    public void sumarColumnas() {

    }

    private void limpiar(JTable tabla) {
        while (tabla.getRowCount() > 0) {
            ((DefaultTableModel) tabla.getModel()).removeRow(0);
        }
    }

    public void exportarExcel(JTable t) throws IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xls");
            try {
                File archivoXLS = new File(ruta);
                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                }
                archivoXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
                Sheet hoja = libro.createSheet("Mi hoja de trabajo 1");
                hoja.setDisplayGridlines(true);
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (f == 0) {
                            celda.setCellValue(t.getColumnName(c));
                        }
                    }
                }
                int filaInicio = 1;
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (t.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                        } else if (t.getValueAt(f, c) instanceof Float) {
                            celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
                        } else {
                            celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                        }
                    }
                }
                libro.write(archivo);
                archivo.close();
                Desktop.getDesktop().open(archivoXLS);
            } catch (IOException | NumberFormatException e) {
                throw e;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInformacion = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jFecha1 = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jFecha2 = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        contadorKg = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        contadorEstimacion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        contadorDinero = new javax.swing.JLabel();
        contadorRecibos = new javax.swing.JLabel();
        panelGraficas = new javax.swing.JPanel();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablaInformacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Sociedad", "Folio", "Clave Productor", "Apellido Paterno", "Apellido Materno", "Nombre", "Genero", "Clave Parcela", "Nombre Parcela", "Certificado", "Forma Cafè", "Inmaduros", "Verdes", "Brocados", "Calificacion", "Id Lote"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaInformacion.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tablaInformacion);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        jFecha1.setDateFormatString("d/MMM/yyyy");

        jLabel12.setText("Desde");

        jFecha2.setDateFormatString("d/MMM/yyyy");

        jLabel13.setText("Hasta");

        jButton2.setText("Aplicar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Grafica Pastel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Grafica");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Grafica Barras");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton5)
                            .addComponent(jButton6)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jFecha1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jFecha2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setText("Situacion");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activos", "Inactivos", "Todos" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Exportar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Cerrar");

        contadorKg.setText("-");

        jLabel8.setText("Total Kg");

        jLabel10.setText("Total Estimación");

        contadorEstimacion.setText("-");

        jLabel1.setText("Total Dinero");

        jLabel2.setText("Total Recibos");

        contadorDinero.setText("-");

        contadorRecibos.setText("-");

        panelGraficas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panelGraficasLayout = new javax.swing.GroupLayout(panelGraficas);
        panelGraficas.setLayout(panelGraficasLayout);
        panelGraficasLayout.setHorizontalGroup(
            panelGraficasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelGraficasLayout.setVerticalGroup(
            panelGraficasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 985, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(contadorKg))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(contadorEstimacion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(contadorDinero))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(contadorRecibos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelGraficas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelGraficas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(contadorEstimacion)
                                .addComponent(contadorDinero)
                                .addComponent(contadorRecibos))
                            .addComponent(contadorKg))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
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
    }// </editor-fold>//GEN-END:initComponents
    String porCorte = "";
    String idRecibo = "", idCorteRecibo = "", sacosRecibo = "", kilosRecibo = "", totalRecibo = "";
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:

            exportarExcel(tablaInformacion);
            /*  mdb.exportar("SELECT\n"
            + "    pm.NombreCorto,\n"
            + "    pm.RazonSocial,\n"
            + "    r.fechaRecepcion,\n"
            + "    r.id,\n"
            + "    r.folioManual,\n"
            + "    p.clave_productor,\n"
            + "    pf.ApellidoPaterno,\n"
            + "    pf.ApellidoMaterno,\n"
            + "    pf.Nombre,\n"
            + "    case pf.ID_Genero  when 1 then 'Masculino'  when 2 then 'Femenino' end as Genero,\n"
            + "    pf.estadoSocio,\n"
            + "    pa.clave_parcela,\n"
            + "    pa.nombre,\n"
            + "    c.nombre,\n"
            + "    r.formaCafe,\n"
            + "    r.inmaduros,\n"
            + "    r.verdes,\n"
            + "    r.brocados,\n"
            + "    100-(r.verdes*r.verdes+r.inmaduros+r.brocados) as Cal_numerica,\n"
            + "    r.kgRecibidos,\n"
            + "    r.precioBrutoKgSociedad,\n"
            + "    r.totalBruto,\n"
            + "    case pf.estadoSocio when 1 then 'SI' when 2 then 'NO' when 0 then 'NO' end as Socio2,\n"
            + "    r.observaciones,\n"
            + "    r.idLote\n"
            + "FROM\n"
            + "    recibos r\n"
            + "LEFT JOIN personam pm ON\n"
            + "    (pm.ID = r.idSociedad)\n"
            + "LEFT JOIN personaf pf ON\n"
            + "    (pf.ID = r.idPersona)\n"
            + "LEFT JOIN productor p ON\n"
            + "    (p.id_persona = r.idPersona)\n"
            + "LEFT JOIN parcelas pa ON\n"
            + "    (pa.id = r.idParcela)\n"
            + "LEFT JOIN codigos_certificacion c ON\n"
            + "    (\n"
            + "        c.codigo=pa.clave_certificacion\n"
            + "    )\n"
            + "WHERE r.fechaRecepcion >  '2020-01-01' and r.id_situacion=1\n"
            + "ORDER BY\n"
            + "    r.fechaRecepcion ASC\n"
            + "INTO OUTFILE 'C:/fichero.csv'\n"
            + "FIELDS TERMINATED BY ','\n"
            + "ENCLOSED BY '\\\"'\n"
            + "LINES TERMINATED BY '\\r\\n'");
            
            Desktop desktop = Desktop.getDesktop();
            try {
            desktop.open(new java.io.File("C:/fichero.csv"));
            } catch (IOException ex) {
            Logger.getLogger(jdRecibos.class.getName()).log(Level.SEVERE, null, ex);
            }
             */        } catch (IOException ex) {
            Logger.getLogger(jpEvaluacionRecepcion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed
    String whereFechas = "";
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String fecha1 = new SimpleDateFormat("yyyy-MM-dd").format(jFecha1.getDate());
        String fecha2 = new SimpleDateFormat("yyyy-MM-dd").format(jFecha2.getDate());
        whereFechas = " where r.fechaRecepcion BETWEEN '" + fecha1 + "' and '" + fecha2 + "' ";
        llenarTabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        graficas();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        double poblacion = 0.7;
        double tasa_crecimiento = 3.9;

        XYSeries series = new XYSeries("");

        for (int i = 0; i < 30; i++) {
            series.add(i, poblacion * 100);
            // Variante de la ecuacion de Verhulst
            poblacion = poblacion * tasa_crecimiento * (1 - poblacion);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Crecimiento Población",
                "Tiempo ->",
                "Población ->",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                false,
                false
        );

        // Mostramos la grafica dentro del jPanel1
        /* ChartPanel panel = new ChartPanel(chart);
        panelGraficas.setLayout(new java.awt.BorderLayout());
        panelGraficas.add(panel);
        panelGraficas.validate();*/
        ChartFrame frame = new ChartFrame("JFreeChart", chart);
        frame.pack();
        frame.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        datos.setValue(15, "Inmaduros", "<1");
        datos.setValue(9, "Brocados", "<1");
         datos.setValue(18, "Verdes", "<1");
        datos.setValue(18, "Inmaduros", "1-2");
        datos.setValue(35, "Inmaduros", "2-3");
        datos.setValue(18, "Inmaduros", "3-4");
        datos.setValue(8, "Inmaduros", "4-5");
        datos.setValue(3, "Inmaduros", ">5");
        
        //Se crea el gráfico y se asignan algunas caracteristicas
        JFreeChart chart = ChartFactory.createBarChart3D("Cereza Organización", "Cereza", "%", datos, PlotOrientation.VERTICAL, true, true, false);

        ChartFrame frame = new ChartFrame("JFreeChart", chart);
        frame.pack();
        frame.setVisible(true);

    }//GEN-LAST:event_jButton6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contadorDinero;
    private javax.swing.JLabel contadorEstimacion;
    private javax.swing.JLabel contadorKg;
    private javax.swing.JLabel contadorRecibos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jFecha1;
    private com.toedter.calendar.JDateChooser jFecha2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelGraficas;
    private javax.swing.JTable tablaInformacion;
    // End of variables declaration//GEN-END:variables
}
