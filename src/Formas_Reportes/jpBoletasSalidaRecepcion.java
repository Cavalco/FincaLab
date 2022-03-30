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
import com.placeholder.PlaceHolder;
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
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Carlos Valdez
 */
public class jpBoletasSalidaRecepcion extends javax.swing.JPanel {

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

    public jpBoletasSalidaRecepcion(Connection cn, String Idioma) {
        initComponents();

        this.cn = cn;
        this.Idioma = Idioma;
        this.idUsuario = idUsuario;
        mdb = new metodosDatosBasicos(cn, Idioma);
        mr = new metodosRecepcion(cn);
        idioma = new Propiedades(Idioma);
        modelo = (DefaultTableModel) tablaBoletas.getModel();

        idSociedadRecepcion = mdb.devuelveUnDato("select idSociedad from recepciones where idRecepcion='" + recepcion + "'");
        this.recepcion = recepcion;
        traductor();
        llenarTabla();
        //sumarColumnas();
        llenarCombos();
        //  tablaRecibos.setRowSorter(new TableRowSorter(modelo));
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
 /*jComboBox1.addItem(idioma.getProperty("Activos"));
        jComboBox1.addItem(idioma.getProperty("Inactivos"));
        jComboBox1.addItem(idioma.getProperty("Todos"));*/

        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        tablaBoletas.getColumnModel().getColumn(7).setCellRenderer(tcr);
        tablaBoletas.getColumnModel().getColumn(8).setCellRenderer(tcr);
        tablaBoletas.getColumnModel().getColumn(9).setCellRenderer(tcr);
        tablaBoletas.getColumnModel().getColumn(10).setCellRenderer(tcr);
    }

    public void llenarTabla() {
        limpiar(tablaBoletas);
        String[] bds = {"fincalab_basilio", "fincalab_procaa", "fincalab_caldio", "fincalab_astal", "fincalab_tambor", "fincalab_malinal", "fincalab_cuerno"};
        for (int i = 0; i < bds.length; i++) {
            cn = (new Conexion()).conectar(bds[i]);
            mdb = new metodosDatosBasicos(cn, Idioma);
            mdb.cargarInformacion2(modelo, 11,
                    "SELECT\n"
                    + "	pm.NombreCorto,\n"
                    + "    b.idBoleta,\n"
                    + "    b.fecha,\n"
                    + "    re.idRecepcion,\n"
                    + "    IF(\n"
                    + "        b.tipoLugar = 'B',\n"
                    + "        bh.nombre,\n"
                    + "        al.nombreAlmacen\n"
                    + "    ),\n"
                    + "    v.Responsable,\n"
                    + "    c.formaCafe,\n"
                    + "    FORMAT(b.totalSacos,0),\n"
                    + "    FORMAT(b.totalKg,2),\n"
                    + "    FORMAT(c.costoAcumulado,2),\n"
                    + "    b.idBoletaManual,\n"
                    + "    b.fechaBoletaManual,\n"
                    + "    FALSE\n"
                    + "FROM\n"
                    + "    boletasalidareceptor b\n"
                    + "LEFT JOIN cortesdeldia c ON\n"
                    + "    (c.idLote = b.idLote)\n"
                    + "LEFT JOIN recepciones re ON\n"
                    + "    (b.origen = re.idRecepcion)\n"
                    + "LEFT JOIN beneficioshumedos bh ON\n"
                    + "    (bh.nombre = b.destino)\n"
                    + "LEFT JOIN almacenes al ON\n"
                    + "    (al.id = b.destino)\n"
                    + "LEFT JOIN vehiculo v ON\n"
                    + "    (v.ID = b.idTransporte)\n"
                    + "LEFT JOIN personam pm ON\n"
                    + "	(pm.ID = b.idSociedad)\n"
                    + "WHERE\n"
                    + "    b.estatus = '1'\n"
                    + "GROUP BY\n"
                    + "    b.idBoleta\n"
                    + "ORDER BY\n"
                    + "    b.id");
        }
        cambiarMesLetra(tablaBoletas, 2);
    }

    public void cambiarMesLetra(JTable tabla, int fila) {
        for (int i = 0; i < tabla.getRowCount(); i++) {

            String fecha = tabla.getValueAt(i, fila) + "";

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
            tabla.setValueAt(fecha, i, fila);
        }
    }

    public void llenarCombos() {
        String[] datos = mdb.cargarCombos("select nombrecorto from personam").split("¬");
        comboSociedades.setModel(new DefaultComboBoxModel((Object[]) datos));
    }

    public void sumarColumnas() {

        float cKg = 0, cEstimacion = 0, cDinero = 0, cRecibos = 0;

        for (int i = 0; i < tablaBoletas.getRowCount(); i++) {

            String acKg = tablaBoletas.getValueAt(i, 3) + "";
            acKg = acKg.replace(",", "");
            cKg = cKg + Float.parseFloat(acKg);

            String acEstimacion = tablaBoletas.getValueAt(i, 5) + "";
            acEstimacion = acEstimacion.replace(",", "");
            cEstimacion = cEstimacion + Float.parseFloat(acEstimacion);

            String acDinero = tablaBoletas.getValueAt(i, 4) + "";
            acDinero = acDinero.replace(",", "");
            cDinero = cDinero + Float.parseFloat(acDinero);

            String acRecibos = tablaBoletas.getValueAt(i, 6) + "";
            acRecibos = acRecibos.replace(",", "");
            cRecibos = cRecibos + Float.parseFloat(acRecibos);
        }

        /*        this.contadorEstimacion.setText(cEstimacion + "");
        this.contadorKg.setText(cKg + "");
        this.contadorDinero.setText(cDinero + "");
        this.contadorRecibos.setText(cRecibos + "");*/
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
        jPanel2 = new javax.swing.JPanel();
        jFecha1 = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jFecha2 = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        comboSociedades = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBoletas = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        jLabel3.setText("Sociedades");

        comboSociedades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboSociedades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSociedadesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(comboSociedades, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 452, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboSociedades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jFecha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jFecha2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jButton2)
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

        tablaBoletas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Sociedad", "Boleta", "Fecha", "Origen", "Destino", "Transportista", "Forma de Café", "Total Sacos", "Total Kg", "Costo Acumulado", "Boleta Manual", "Fecha Boleta Manual"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaBoletas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaBoletas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBoletasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaBoletas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
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

            exportarExcel(tablaBoletas);
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
            Logger.getLogger(jpBoletasSalidaRecepcion.class.getName()).log(Level.SEVERE, null, ex);
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

    private void tablaBoletasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBoletasMouseClicked
        // TODO add your handling code here:
/*        limpiar(tablaCortes);
        modelo2 = (DefaultTableModel) tablaCortes.getModel();
        //idLote = idCorte
        //idLote = tablaCortes.getValueAt(tablaCortes.getSelectedRow(), 0) + "";
        idBoleta = tablaBoletas.getValueAt(tablaBoletas.getSelectedRow(), 0) + "";
        mdb.cargarInformacion2(modelo2, 8, "SELECT c.idLote, c.fechaCreacion, c.formaCafe, c.sacos, c.kg, c.costoAcumulado, b.sacosEnviados, b.kilosEnviados\n"
            + "from cortesdeldia c\n"
            + "inner join boletasalidareceptor b on(c.idLote=b.idLote)\n"
            + "where b.idBoleta='" + idBoleta + "' ");

        if (evt.getClickCount() == 2) {
            jdBoletaSalidaReceptorVisor jdBSV;
            try {
                jdBSV = new jdBoletaSalidaReceptorVisor(null, true, idBoleta, Idioma, cn);
                jdBSV.setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(jpCortesEnviados.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        sumarColumnas();
        idRecibo = "";*/
    }//GEN-LAST:event_tablaBoletasMouseClicked

    private void comboSociedadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSociedadesActionPerformed
        // TODO add your handling code here:
        String sociedad = "";
        limpiar(tablaBoletas);
        switch (comboSociedades.getSelectedItem() + "") {
            case "Seleccione":
                llenarTabla();
                break;
            case "Basilio":
                sociedad = "fincalab_basilio";
                break;
            case "Procaa":
                sociedad = "fincalab_procaa";
                break;
            case "Riviera":
                sociedad = "fincalab_basilio";
                break;
            case "Caldio":
                sociedad = "fincalab_caldio";
                break;
            case "Cafeico":
                sociedad = "fincalab_cafeico";
                break;
            case "Astal":
                sociedad = "fincalab_astal";
                break;

        }

        cn = (new Conexion()).conectar(sociedad);
        mdb = new metodosDatosBasicos(cn, Idioma);
        mdb.cargarInformacion2(modelo, 11,
                "SELECT\n"
                + "	pm.NombreCorto,\n"
                + "    b.idBoleta,\n"
                + "    b.fecha,\n"
                + "    re.idRecepcion,\n"
                + "    IF(\n"
                + "        b.tipoLugar = 'B',\n"
                + "        bh.nombre,\n"
                + "        al.nombreAlmacen\n"
                + "    ),\n"
                + "    v.Responsable,\n"
                + "    c.formaCafe,\n"
                + "    FORMAT(b.totalSacos,0),\n"
                + "    FORMAT(b.totalKg,2),\n"
                + "    FORMAT(c.costoAcumulado,2),\n"
                + "    b.idBoletaManual,\n"
                + "    b.fechaBoletaManual,\n"
                + "    FALSE\n"
                + "FROM\n"
                + "    boletasalidareceptor b\n"
                + "LEFT JOIN cortesdeldia c ON\n"
                + "    (c.idLote = b.idLote)\n"
                + "LEFT JOIN recepciones re ON\n"
                + "    (b.origen = re.idRecepcion)\n"
                + "LEFT JOIN beneficioshumedos bh ON\n"
                + "    (bh.nombre = b.destino)\n"
                + "LEFT JOIN almacenes al ON\n"
                + "    (al.id = b.destino)\n"
                + "LEFT JOIN vehiculo v ON\n"
                + "    (v.ID = b.idTransporte)\n"
                + "LEFT JOIN personam pm ON\n"
                + "	(pm.ID = b.idSociedad)\n"
                + "WHERE\n"
                + "    b.estatus = '1'\n"
                + "GROUP BY\n"
                + "    b.idBoleta\n"
                + "ORDER BY\n"
                + "    b.id");
    }//GEN-LAST:event_comboSociedadesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboSociedades;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jFecha1;
    private com.toedter.calendar.JDateChooser jFecha2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaBoletas;
    // End of variables declaration//GEN-END:variables
}
