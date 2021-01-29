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
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 *
 * @author Carlos Valdez
 */
public class jpReporteRecibos extends javax.swing.JPanel {

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

    public jpReporteRecibos(Connection cn, String Idioma) {
        initComponents();

        this.cn = cn;
        this.Idioma = Idioma;
        this.idUsuario = idUsuario;
        mdb = new metodosDatosBasicos(cn, Idioma);
        mr = new metodosRecepcion(cn);
        idioma = new Propiedades(Idioma);
        modelo = (DefaultTableModel) tablaRecibos.getModel();

        idSociedadRecepcion = mdb.devuelveUnDato("select idSociedad from recepciones where idRecepcion='" + recepcion + "'");
        this.recepcion = recepcion;
        // traductor();
        llenarTabla();
        sumarColumnas();
        llenarCombos();
        tablaRecibos.setRowSorter(new TableRowSorter(modelo));

        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        tablaRecibos.getColumnModel().getColumn(3).setCellRenderer(tcr);
        tablaRecibos.getColumnModel().getColumn(4).setCellRenderer(tcr);
        tablaRecibos.getColumnModel().getColumn(15).setCellRenderer(tcr);
        tablaRecibos.getColumnModel().getColumn(16).setCellRenderer(tcr);
        tablaRecibos.getColumnModel().getColumn(17).setCellRenderer(tcr);
        tablaRecibos.getColumnModel().getColumn(18).setCellRenderer(tcr);
        tablaRecibos.getColumnModel().getColumn(19).setCellRenderer(tcr);
        tablaRecibos.getColumnModel().getColumn(20).setCellRenderer(tcr);
        tablaRecibos.getColumnModel().getColumn(21).setCellRenderer(tcr);
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
        
        //PlaceHolder
        PromptSupport.setPrompt(idioma.getProperty("Nombre"), txtNombre);
        PromptSupport.setPrompt(idioma.getProperty("Folio"), txtFolio);
        PromptSupport.setPrompt(idioma.getProperty("FolioManual"), txtFolioManual);
        PromptSupport.setPrompt(idioma.getProperty("IdCorte"), txtIdLote);
    }

    public void llenarCombos() {
        String[] datosCodC = mdb.cargarCombos("select nombre from codigos_certificacion").split("¬");
        comboCertificacion.setModel(new DefaultComboBoxModel((Object[]) datosCodC));
    }

    public void llenarTabla() {
        limpiar(tablaRecibos);
        String[] bds = {"fincalab_cafesumex", "fincalab_basilio", "fincalab_procaa", "fincalab_caldio", "fincalab_astal", "fincalab_cafeico", "fincalab_cuerno", "fincalab_tambor"};
        for (int i = 0; i < bds.length; i++) {
            cn = (new Conexion()).conectar(bds[i]);
            mdb = new metodosDatosBasicos(cn, Idioma);
            mdb.cargarInformacion2(modelo, 25, "SELECT\n"
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
                    + "WHERE r.fechaRecepcion >  '2020-01-01' and r.id_situacion=1 \n"
                    + "ORDER BY\n"
                    + "    pm.NombreCorto ASC,r.fechaRecepcion ASC");

        }
        cambiarMesLetra(tablaRecibos, 2);
    }

    /*
                + "inner join recepciones re on(r.idSociedad=re.idSociedad)"*/
    public void buscar(String tipo) {
        limpiar(tablaRecibos);
        String where = "", situacion = "";

        switch (jComboBox1.getSelectedIndex()) {
            //Activos
            case 0:
                situacion = " =1 ";
                break;
            //Inactivos
            case 1:
                situacion = " =0 ";
                break;
            //Todos
            case 2:
                situacion = " <> 3 ";
                break;
        }

        switch (tipo) {

            case "Folio":
                where = " and r.id like '" + txtFolio.getText() + "%'";
                break;
            case "Folio Manual":
                where = " and r.folioManual like '" + txtFolioManual.getText() + "%'";
                break;
            case "Nombre":
                where = " and pf.nombre like '" + txtNombre.getText() + "%'";
                break;
            case "Ape Pat":
//                where = " and pf.apellidoPaterno like '" + txtApellidoPat.getText() + "%'";
                break;
            case "Ape Mat":
                //             where = " and pf.apellidoMaterno like '" + txtApellidoMat.getText() + "%'";
                break;
            case "Id Corte":
                where = " and r.idLote like '" + txtIdLote.getText() + "%'";
                break;
            default:
                where = "";
                break;
        }
        mdb.cargarInformacion2(modelo, 21, "select r.id, r.folioManual,r.idLote, r.fechaCreacion,r.fechaRecepcion, pf.Nombre, pf.ApellidoPaterno, pf.ApellidoMaterno,\n"
                + "pm.RazonSocial, p.nombre, r.formaCafe, r.sacos, r.kgRecibidos, r.totalBruto, r.retencion, r.total, r.verdes, r.inmaduros, r.brocados, r.calificacion, r.personaEntrego, r.observaciones\n"
                + "from recibos r\n"
                + "inner join personam pm on ( pm.ID=r.idSociedad)\n"
                + "inner join personaf pf on ( pf.ID=r.idPersona)\n"
                + "inner join parcelas p on ( p.id=r.idParcela) "
                + "where r.id_situacion " + situacion + " and r.idSociedad=" + idSociedadRecepcion + "  " + where);
        cambiarMesLetra(tablaRecibos, 2);
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

    public void sumarColumnas() {

        float contadorKg = 0, contadorSacos = 0;

        contadorProductores.setText(tablaRecibos.getRowCount() + "");

        for (int i = 0; i < tablaRecibos.getRowCount(); i++) {
            //contadorSacos = contadorSacos + Float.parseFloat(tablaRecibos.getValueAt(i, 11) + "");
            contadorKg = contadorKg + Float.parseFloat(tablaRecibos.getValueAt(i, 19) + "");
        }

//        this.contadorKg.setText(contadorKg + "");
        //  this.contadorSacos.setText(contadorSacos + "");
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
                hoja.setDisplayGridlines(false);
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

    public void busquedaGeneral() {

        limpiar(tablaRecibos);

        switch (jComboBox2.getSelectedItem() + "") {
            case "Seleccione":
                sociedad = "Seleccione";
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
            case "Cuerno":
                sociedad = "fincalab_cuerno";

        }

        if (!sociedad.equals("Seleccione")) {

            cn = (new Conexion()).conectar(sociedad);
            mdb = new metodosDatosBasicos(cn, Idioma);
            mdb.cargarInformacion2(modelo, 25, "SELECT\n"
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
                    + "WHERE r.fechaRecepcion >  '2020-01-01' " + whereCert + " " + datoProductor + " " + porFolio + " " + porManual + " " + porCorte + " "
                    + "ORDER BY\n"
                    + "    r.fechaRecepcion ASC");
            //  cambiarMesLetra(tablaRecibos);
        } else if (sociedad.equals("Seleccione")) {
            String[] bds = {"fincalab_basilio", "fincalab_procaa", "fincalab_caldio", "fincalab_astal", "fincalab_tambor"};
            for (int i = 0; i < bds.length; i++) {
                //JOptionPane.showMessageDialog(null,"Entre al ciclo");
                cn = (new Conexion()).conectar(bds[i]);
                mdb = new metodosDatosBasicos(cn, Idioma);
                mdb.cargarInformacion2(modelo, 25, "SELECT\n"
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
                        + "WHERE r.fechaRecepcion >  '2020-01-01' " + whereCert + " " + datoProductor + " " + porFolio + " " + porManual + " " + porCorte + " "
                        + "ORDER BY\n"
                        + "    r.fechaRecepcion ASC");
            }
        }
        sumarColumnas();
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
        tablaRecibos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFolio = new javax.swing.JTextField();
        txtFolioManual = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtIdLote = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        comboCertificacion = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        contadorProductores = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablaRecibos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Sociedad", "Descripcion Sociedad", "Fecha Recepcion", "Folio", "Folio Manual", "Clave Productor", "Apellido Paterno", "Apellido Materno", "Nombre", "Genero", "Socio", "Clave Parcela", "Nombre Parcela", "Certificado", "Forma Cafe", "Inmaduros", "Verdes", "Brocados", "Calificacion", "Kilos Recibidos", "Precio por Kilo", "Total", "Socio 2", "Observaciones", "Id Corte"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaRecibos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaRecibos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaRecibosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaRecibos);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        jLabel1.setText("Folio");

        txtFolio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFolioKeyReleased(evt);
            }
        });

        txtFolioManual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFolioManualKeyReleased(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        txtIdLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdLoteKeyReleased(evt);
            }
        });

        jLabel2.setText("Folio Manual");

        jLabel6.setText("Id Corte");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Astal", "Procaa", "Basilio", "Riviera", "Caldio", "Cafeico", "Tambor", "Cuerno" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel9.setText("Sociedad");

        comboCertificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Sin Certificacion", "Organico", "Mujeres" }));
        comboCertificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCertificacionActionPerformed(evt);
            }
        });

        jLabel11.setText("Certificacion");

        jLabel12.setText("Fechas");

        jLabel13.setText("Fechas");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Nombre", "Apellido Paterno", "Apellido Materno", "Clave" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel4.setText("Datos Productor");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(comboCertificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFolioManual, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtIdLote, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboCertificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel12))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFolioManual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        jButton5.setText("Ver");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        contadorProductores.setText("-");

        jLabel8.setText("Total Recibos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(contadorProductores))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton4)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jButton5)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contadorProductores)))
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

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        // TODO add your handling code here:
        //"WHERE r.fechaRecepcion >  '2020-01-01' and " + datoProductor + " like '" + txtNombre.getText() + "%' \n"
        switch (jComboBox4.getSelectedItem() + "") {
            case "Nombre":
                datoProductor = " and pf.nombre like  '" + txtNombre.getText() + "%' ";
                break;
            case "Apellido Paterno":
                datoProductor = " and pf.apellidopaterno like '" + txtNombre.getText() + "%' ";
                break;
            case "Apellido Materno":
                datoProductor = " and pf.apellidomaterno like '" + txtNombre.getText() + "%' ";
                break;
            case "Clave":
                datoProductor = " and p.clave_productor like '" + txtNombre.getText() + "%' ";
                break;
        }
        busquedaGeneral();
    }//GEN-LAST:event_txtNombreKeyReleased
    String porCorte = "";
    private void txtIdLoteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdLoteKeyReleased
        // TODO add your handling code here:
        porCorte = " and r.idLote like '" + txtIdLote.getText() + "%'";
        busquedaGeneral();
    }//GEN-LAST:event_txtIdLoteKeyReleased
    String idRecibo = "", idCorteRecibo = "", sacosRecibo = "", kilosRecibo = "", totalRecibo = "";
    private void tablaRecibosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRecibosMouseClicked
        // TODO add your handling code here:

        idRecibo = tablaRecibos.getValueAt(tablaRecibos.getSelectedRow(), 0) + "";
        idCorteRecibo = tablaRecibos.getValueAt(tablaRecibos.getSelectedRow(), 2) + "";
        sacosRecibo = tablaRecibos.getValueAt(tablaRecibos.getSelectedRow(), 11) + "";
        kilosRecibo = tablaRecibos.getValueAt(tablaRecibos.getSelectedRow(), 12) + "";
        totalRecibo = tablaRecibos.getValueAt(tablaRecibos.getSelectedRow(), 15) + "";

        if (evt.getClickCount() == 2) {
            jdR = new jdRecibos(null, true, idRecibo, "2", recepcion, idSociedadRecepcion, idUsuario, Idioma, cn);
            jdR.setVisible(true);
        }

    }//GEN-LAST:event_tablaRecibosMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        jdR = new jdRecibos(null, true, idRecibo, "2", recepcion, idSociedadRecepcion, idUsuario, Idioma, cn);
        jdR.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        buscar("");
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:

            exportarExcel(tablaRecibos);
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
            Logger.getLogger(jpReporteRecibos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed
    String sociedad = "";
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        busquedaGeneral();
    }//GEN-LAST:event_jComboBox2ActionPerformed
    String whereCert = "";
    private void comboCertificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCertificacionActionPerformed
        // TODO add your handling code here:
        if (comboCertificacion.getSelectedItem().equals("Seleccione")) {
            whereCert = "";
        } else {
            whereCert = " and c.nombre='" + comboCertificacion.getSelectedItem() + "' ";
        }
        busquedaGeneral();
    }//GEN-LAST:event_comboCertificacionActionPerformed
    String datoProductor = "";
    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox4ActionPerformed
    String porFolio = "";
    private void txtFolioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFolioKeyReleased
        // TODO add your handling code here:
        porFolio = " and r.id like '" + txtFolio.getText() + "%' ";
        busquedaGeneral();
    }//GEN-LAST:event_txtFolioKeyReleased
    String porManual = "";
    private void txtFolioManualKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFolioManualKeyReleased
        // TODO add your handling code here:
        porManual = " and r.folioManual like '" + txtFolioManual.getText() + "%' ";
        busquedaGeneral();
    }//GEN-LAST:event_txtFolioManualKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboCertificacion;
    private javax.swing.JLabel contadorProductores;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaRecibos;
    private javax.swing.JTextField txtFolio;
    private javax.swing.JTextField txtFolioManual;
    private javax.swing.JTextField txtIdLote;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
