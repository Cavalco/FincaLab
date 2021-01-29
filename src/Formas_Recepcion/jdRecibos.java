/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_Recepcion;

import Idioma.Propiedades;
import Metodos_Configuraciones.metodosDatosBasicos;
import Metodos_Configuraciones.metodosRecepcion;
import Reportes.creacionPDF;
import Visual.Visual;
import Visual.jdVisual;
import com.itextpdf.text.DocumentException;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @au thor Carlos Valdez
 */
public class jdRecibos extends javax.swing.JDialog {

    /**
     * Creates new form jdRecibos
     */
    metodosRecepcion mr;

    jpRecibos jpR;
    Connection cn;
    String idRecibo, tipoOperacion, idSociedad, idRecepcion, Idioma, idUsuario;
    Propiedades idioma;

    public jdRecibos(java.awt.Frame parent, boolean modal, String idRecibo, String tipoOperacion, String idRecepcion, String idSociedad, String idUsuario, String Idioma, Connection c) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        cn = c;
        mr = new metodosRecepcion(cn);
        this.idRecibo = idRecibo;
        this.tipoOperacion = tipoOperacion;
        this.idSociedad = idSociedad;
        this.idRecepcion = idRecepcion;
        this.Idioma = Idioma;
        this.idUsuario = idUsuario;
        idioma = new Propiedades(Idioma);
        labelRecepcion.setText(idRecepcion);
        txtSociedad.setText(mr.devuelveUnDato("select nombrecorto from personam where id=" + idSociedad + " "));
        AutoCompleteDecorator.decorate(comboProductor);
        //idRecepcion = mr.devuelveUnDato("select id from recepciones where idRecepcion='" + recepcion + "'");

        if (!idRecibo.equals("")) {
            cargarDatosRecibos();
            bloquear();
        } else {
            //jButton2.setVisible(false);
            String datos[] = mr.cargarCombos("select f.descripcion \n"
                    + "from preciocafesociedad p \n"
                    + "inner join formacafe f on (p.id_formaCafe=f.id) "
                    + "inner join personam pm on (p.id_sociedad=pm.id)"
                    + "where pm.nombrecorto='" + txtSociedad.getText() + "'").split("¬");
            comboForma.setModel(new DefaultComboBoxModel((Object[]) datos));

            jDateChooser1.setDate(GregorianCalendar.getInstance().getTime());
            jButton4.setVisible(false);
            combos();
        }
        if (tipoOperacion.equals("2")) {
            setTitle("Recibo Folio " + idRecibo);
        }
        cambiarIdioma();
    }

    public void cambiarIdioma() {

        //EtiquetaSociedad
        jLabel6.setText(idioma.getProperty("sociedad"));
        //Etiqueta "Productor"
        jLabel2.setText(idioma.getProperty("Productor"));
        //Nombre Productor
        jLabel5.setText(idioma.getProperty("Nombre"));
        //Clave Productor
        jLabel3.setText(idioma.getProperty("ClaveProductor"));
        //Parcela
        jLabel4.setText(idioma.getProperty("Parcela"));
        //Nombre Parcela
        jLabel7.setText(idioma.getProperty("NombreParcela"));
        //Clave Parcela
        jLabel8.setText(idioma.getProperty("ClaveParcela"));
        //Certificacion
        jLabel9.setText(idioma.getProperty("Certificado"));
        //Forma de Cafe
        jLabel31.setText(idioma.getProperty("FormaDeCafe"));
        //Id Corte
        jLabel21.setText(idioma.getProperty("IdCorte"));
        //Entrego
        jLabel22.setText(idioma.getProperty("Entrego"));
        //Totales
        jLabel15.setText(idioma.getProperty("Totales"));
        //Sacos
        jLabel10.setText(idioma.getProperty("Sacos"));
        //kg Recibidos
        jLabel11.setText(idioma.getProperty("KgRecibidos"));
        //TotalBruto
        jLabel12.setText(idioma.getProperty("TotalBruto"));
        //Retencion
        jLabel13.setText(idioma.getProperty("Retencion"));
        //Total
        jLabel14.setText(idioma.getProperty("Total"));
        //Evaluacion Cereza
        jLabel16.setText(idioma.getProperty("EvaluacionCereza"));
        //Verdes
        jLabel17.setText(idioma.getProperty("Verdes"));
        //Inmaduros
        jLabel18.setText(idioma.getProperty("Inmaduros"));
        //Brocados
        jLabel19.setText(idioma.getProperty("Brocados"));
        //Calificacion
        jLabel20.setText(idioma.getProperty("Calificacion"));

        jCheckBox1.setText(idioma.getProperty("FolioManual"));
        jLabel16.setText(idioma.getProperty("EvaluacionCereza"));
        radioSocio.setText(idioma.getProperty("Socio"));
        radioEnlace.setText(idioma.getProperty("EnlaceComercial"));
        jLabel23.setText(idioma.getProperty("Observaciones"));

    }

    public void combos() {

        if (radioSocio.isSelected()) {
            String datos[] = mr.cargarCombos("select CONCAT(pf.Nombre, ', ', pf.apellidoPaterno, ', ', pf.apellidoMaterno) "
                    + "from productor p "
                    + "inner join personaf pf on (p.id_persona=pf.ID) "
                    + "inner join sociedadespersona s on(pf.id = s.id_persona) "
                    + "where pf.estadosocio=1 and p.tipoPersona=1 and s.tipoPersona=1 and id_asociado=" + idSociedad).split("¬");
            comboProductor.setModel(new DefaultComboBoxModel((Object[]) datos));
            tipoPersona = "1";
        } else if (radioEnlace.isSelected()) {
            String datos[] = mr.cargarCombos("select CONCAT(pf.Nombre, ', ', pf.apellidoPaterno, ', ', pf.apellidoMaterno) \n"
                    + "from personaf pf \n"
                    + "inner join asignacionespersona a on(pf.ID=a.id_persona) \n"
                    + "inner join sociedadespersona s on(pf.id = s.id_persona) "
                    + "where pf.estadosocio=2 and a.codigo='Productor' and s.tipoPersona=1 and id_asociado=" + idSociedad).split("¬");
            comboProductor.setModel(new DefaultComboBoxModel((Object[]) datos));
            tipoPersona = "2";
        }

    }

    String idPersona = "";

    public String claveProductor() {
        // JOptionPane.showMessageDialog(null, "Entre");
        String nombre = comboProductor.getSelectedItem() + "";
        String ap, am;

        if (nombre.equals("Seleccione..")) {
            //No hace nada here
        } else {
            if (radioSocio.isSelected()) {
                // JOptionPane.showMessageDialog(null, "Entre Socio");
                String datos[] = nombre.split(",");
                nombre = datos[0].trim();
                ap = datos[1].trim();
                am = datos[2].trim();
                idPersona = mr.devuelveId("select id from personaf where nombre='" + nombre + "' and apellidopaterno ='" + ap + "' and apellidomaterno='" + am + "' ");
                return mr.devuelveUnDato("select clave_productor from productor where id_persona =" + idPersona + " and tipoPersona=1");

            } else if (radioEnlace.isSelected()) {
                // JOptionPane.showMessageDialog(null, "Entre Enlace");
                // System.out.println("***************************************************************************************");
                String datos[] = nombre.split(",");
                nombre = datos[0].trim();
                ap = datos[1].trim();
                am = datos[2].trim();
                idPersona = mr.devuelveId("select id from personaf where nombre='" + nombre + "' and apellidopaterno ='" + ap + "' and apellidomaterno='" + am + "' ");
                return mr.devuelveUnDato("select clave_productor from productor where id_persona =" + idPersona + " and tipoPersona=1");

            }
        }

        return null;
    }

    public void datosParcelas() {
        if (comboParcela.getSelectedItem().equals("Seleccione..")) {

        } else {
            if (radioSocio.isSelected()) {
                String idParcela = mr.devuelveUnDato("select id from parcelas where id_persona=" + idPersona + " and nombre='" + comboParcela.getSelectedItem() + "' and tipoPersona=1");
                String datos[] = mr.devuelveUnDato("select concat(clave_parcela,'¬', clave_certificacion) from parcelas where id=" + idParcela + " and tipoPersona=1").split("¬");

                txtClaveParcela.setText(datos[0]);
                txtCertificacion.setText(datos[1]);
            } else if (radioEnlace.isSelected()) {
                String idParcela = mr.devuelveUnDato("select id from parcelas where id_persona=" + idPersona + " and nombre='" + comboParcela.getSelectedItem() + "' and tipoPersona=1");
                String datos[] = mr.devuelveUnDato("select concat(clave_parcela,'¬', clave_certificacion) from parcelas where id=" + idParcela + " and tipoPersona=1").split("¬");
                txtClaveParcela.setText(datos[0]);
                txtCertificacion.setText(datos[1]);
            }
        }
    }

    public void cargarDatosRecibos() {
        try {
            String[] datos
                    = mr.devolverLineaDatos("SELECT concat(pf.Nombre,' ', pf.ApellidoPaterno,' ', pf.ApellidoMaterno), pm.nombrecorto,\n"
                            + "r.fechaRecepcion, p.clave_productor, pa.nombre, pa.clave_parcela, pa.clave_certificacion,\n"
                            + "r.folioManual,r.idLote,r.personaEntrego,r.sacos,r.kgRecibidos,r.totalBruto,r.retencion,r.total,r.verdes,r.inmaduros,r.brocados,r.calificacion,r.observaciones, r.formaCafe, r.precioBrutoKgSociedad, r.precioNetoKgSociedad, r.retencionKgSociedad\n"
                            + "from recibos r\n"
                            + "inner join personaf pf on(pf.ID=r.idPersona)\n"
                            + "inner join personam pm on(pm.ID=r.idSociedad)\n"
                            + "inner join productor p on(p.id_persona=pf.ID)\n"
                            + "inner join parcelas pa on(pa.id=r.idParcela)\n"
                            + "where r.id=" + idRecibo + " and p.tipoPersona=1", 24).split("¬");

            comboProductor.addItem(datos[0]);
            comboProductor.setSelectedItem(datos[0]);
            txtSociedad.setText(datos[1]);

            //JOptionPane.showMessageDialog(null,"Fecha "+datos[2]);
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaDate = null;

            if (!datos[2].equals("")) {
                fechaDate = formato.parse(datos[2]);
                jDateChooser1.setDate(fechaDate);
            }
            //jDateChooser1.setDateFormatString(datos[2]);
            txtClaveProductor.setText(datos[3]);
            comboParcela.addItem(datos[4]);
            comboParcela.setSelectedItem(datos[4]);
            txtClaveParcela.setText(datos[5]);
            txtCertificacion.setText(datos[6]);
            txtFolio.setText(datos[7]);
            txtIdCorte.setText(datos[8]);
            txtEntrego.setText(datos[9]);
            txtSacos.setText(datos[10]);
            txtKgRecibidos.setText(datos[11]);
            txtTotalBruto.setText(datos[12]);
            txtRetencion.setText(datos[13]);
            txtTotal.setText(datos[14]);
            txtVerdes.setText(datos[15]);
            txtInmaduros.setText(datos[16]);
            txtBrocados.setText(datos[17]);
            txtCalificacion.setText(datos[18]);
            txtObservaciones.setText(datos[19]);
            comboForma.addItem(datos[20]);
            comboForma.setSelectedItem(datos[20]);

            txtPrecioBruto.setText(datos[21]);
            txtPrecioNeto.setText(datos[22]);
            txtRetencionKg.setText(datos[23]);

        } catch (Exception e) {

        }
    }

    public void bloquear() {
        //jButton1.setEnabled(false);
        comboProductor.setEnabled(false);
        comboProductor.setEnabled(false);
        txtSociedad.setEnabled(false);
        //fecha datos[2
        txtClaveProductor.setEnabled(false);
        comboParcela.setEnabled(false);
        comboParcela.setEnabled(false);
        txtClaveParcela.setEnabled(false);
        txtCertificacion.setEnabled(false);
        txtFolio.setEnabled(false);
        txtIdCorte.setEnabled(false);
        txtEntrego.setEnabled(false);
        txtSacos.setEnabled(false);
        txtKgRecibidos.setEnabled(false);
        txtTotalBruto.setEnabled(false);
        txtRetencion.setEnabled(false);
        txtTotal.setEnabled(false);
        txtVerdes.setEnabled(false);
        txtInmaduros.setEnabled(false);
        txtBrocados.setEnabled(false);
        txtCalificacion.setEnabled(false);
        txtObservaciones.setEnabled(false);
        radioSocio.setEnabled(false);
        radioEnlace.setEnabled(false);
        jDateChooser1.setEnabled(false);
        comboForma.setEnabled(false);
        jCheckBox1.setEnabled(false);
        jButton5.setVisible(false);
    }
    String idCorte = "";

    public void generarIdCorte() {
        String clavecorte = mr.devuelveUnDato("select clavecorte from personam where nombrecorto='" + txtSociedad.getText() + "' ");

        Date fecha = new Date();
        String anio = new SimpleDateFormat("yy").format(fecha);

        String julianDateString = new SimpleDateFormat("'0'D").format(jDateChooser1.getDate());
        String numeroRecepcion = idRecepcion.substring(idRecepcion.length() - 1);
        String[] num = idRecepcion.split("-");

        //JOptionPane.showMessageDialog(null, "Valor: " + numeroRecepcion);
        String[] calificacion = txtCalificacion.getText().split(" ");

        idCorte = clavecorte + num[2] + "-" + anio + "" + julianDateString + "-" + txtCertificacion.getText() + "-" + calificacion[0];
        txtIdCorte.setText(idCorte);
    }

    public void calcularCalificacion() {
        try {
            //JOptionPane.showMessageDialog(null,"Entre al metodo");
            String formula = "", id_evaluacion;
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");

            if (comboForma.getSelectedItem().equals("Seleccione..")) {
                JOptionPane.showMessageDialog(null, "Seleccione forma de cafe");
            } else {
                id_evaluacion = mr.devuelveId("select id from formacafe where descripcion='" + comboForma.getSelectedItem() + "' ") + "";

                formula = mr.devuelveUnDato("SELECT te.Formula\n"
                        + "from formaevaluacion fe\n"
                        + "inner join tipoevaluacion te on (fe.ID_Evaluacion=te.ID)\n"
                        + "where fe.id_forma=" + id_evaluacion);
            }

            if (idioma.getProperty("Cereza").equals(comboForma.getSelectedItem() + "")) {
                //Checar los datos del combo en ingles
                String valores = formula.replace("v", txtVerdes.getText());
                valores = valores.replace("b", txtBrocados.getText());
                valores = valores.replace("i", txtInmaduros.getText());
                valores = valores.substring(2);
                System.out.println(valores);
                //JOptionPane.showMessageDialog(null, valores);
                try {
                    Object result = engine.eval(valores);
                    int valor = (int) result;
                    System.out.println(valor);
                    //JOptionPane.showMessageDialog(null, "Resultado: " + valor);
                    txtCalificacion.setText(mr.devolverCalificacion(valor));
                } catch (ScriptException ex) {
                    Logger.getLogger(jdRecibos.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (Exception e) {

        }
    }

    public void calcularPrecios() {
        try {
            DecimalFormat df = new DecimalFormat("#.00");

            float precioneto = Float.parseFloat(txtPrecioNeto.getText());
            float preciobruto = Float.parseFloat(txtPrecioBruto.getText());
            float kgRecibidos = Float.parseFloat(txtKgRecibidos.getText());

            txtTotalBruto.setText(df.format(preciobruto * kgRecibidos) + "");
            txtTotal.setText(df.format(precioneto * kgRecibidos) + "");
            txtRetencion.setText(df.format(Float.parseFloat(txtRetencionKg.getText()) * kgRecibidos) + "");

        } catch (Exception e) {
        }
    }

    public Boolean validar() {
        if (comboProductor.getSelectedItem().equals("Seleccione..")) {
            JOptionPane.showMessageDialog(null, "Seleccione Productor");
            return false;
        } else if (comboParcela.getSelectedItem().equals("Seleccione..")) {
            JOptionPane.showMessageDialog(null, "Seleccione Parcela");
            return false;
        } else if (comboForma.getSelectedItem().equals("Seleccione..")) {
            JOptionPane.showMessageDialog(null, "Seleccione Forma de Café");
            return false;
        } else if (txtEntrego.getText().length() <= 0 || txtSacos.getText().length() <= 0 || txtKgRecibidos.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Existen Campos Vacios");
            return false;
        } else if (txtCalificacion.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Evaluacion Incorrecta");
            return false;
        } else if (Double.parseDouble(txtKgRecibidos.getText()) < Double.parseDouble(txtSacos.getText())) {
            JOptionPane.showMessageDialog(null, "La cantidad de kilos no puede ser menor a la cantidad de sacos");
            return false;
        } else {
            return true;
        }

    }

    /*public void crearPdf(String idRecibo) throws JRException {
        JasperReport archivo = JasperCompileManager.compileReport("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\Sistema-CAFESUMEX\\src\\Reportes\\recepcionRecibo.jasper");
        //JasperReport reporte = null;
        //String path = "src\\Reportes\\recepcionRecibo.jasper";
        //JOptionPane.showMessageDialog(null,"Id "+idSociedad);
        Map parametro = new HashMap();
        parametro.put("id", Integer.parseInt(idRecibo));
        //URL path = this.getClass().getResource("Reportes\\recepcionRecibo.jasper");
        //String ruta = "Reportes\\recepcionRecibo.jasper";
        //reporte = (JasperReport) JRLoader.loadObject(path);

        JasperPrint jprint = JasperFillManager.fillReport(archivo, parametro, cn);
        JasperExportManager.exportReportToPdfFile(jprint, "reportee.pdf");
        //JasperViewer view = new JasperViewer(jprint, false);
        //view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //view.setVisible(true);

        select r.id, r.folioManual, r.formaCafe, r.sacos, r.kgRecibidos, r.totalBruto, r.retencion, r.total, r.precioNeto, r.verdes, r.inmaduros, r.brocados, r.calificacion, r.personaEntrego, r.observaciones, r.precioBrutoKgSociedad, r.precioNetoKgSociedad, pf.Nombre, lPer.Descripcion, prod.clave_productor
from recibos r
inner join personaf pf on (r.idPersona=pf.ID)
inner join localidad lPer on (pf.ID_Localidad=lPer.ID)
inner join productor prod on (prod.id_persona=pf.ID)
where r.id = 43 and prod.tipoPersona=1    
    }*/
    public void validarCorte() {

        Date fecha = new Date();
        String anio = new SimpleDateFormat("yy").format(fecha);
        Date date = new Date();
        String julianDateString = new SimpleDateFormat("'0'D").format(jDateChooser1.getDate());

        String fechaCreacion = new SimpleDateFormat("yyyy-MM-dd").format(jDateChooser1.getDate());

        //jDateChooser1.
        if (mr.devuelveId("select id from cortesdeldia where idLote= '" + txtIdCorte.getText() + "'") == null
                || mr.devuelveId("select id from cortesdeldia where idLote= '" + txtIdCorte.getText() + "'").equals("")) {

            //JOptionPane.showMessageDialog(null, "No existe");
            mr.insertarCorte("insert into cortesdeldia values(null, '" + fechaCreacion + "', '" + julianDateString + "', "
                    + " '" + txtIdCorte.getText() + "', '" + txtSociedad.getText() + "', '" + comboForma.getSelectedItem() + "', '" + txtSacos.getText() + "',"
                    + " '" + txtKgRecibidos.getText() + "', '" + txtTotal.getText() + "', 'Activo', '" + txtCalificacion.getText() + "', '" + txtCertificacion.getText() + "', '" + idRecepcion + "' )");

        } else {
            //JOptionPane.showMessageDialog(null, "Si existe");
            mr.actualizarCorte("update cortesdeldia set sacos = (sacos + " + txtSacos.getText() + "), kg= (kg + " + txtKgRecibidos.getText() + "), costoAcumulado = (costoAcumulado+" + txtTotal.getText() + ") where idLote='" + txtIdCorte.getText() + "' ");

        }
    }

    public void calcularRetencion() {
        DecimalFormat df = new DecimalFormat("#.00");

        if (comboForma.getSelectedItem().equals("Seleccione..")) {
            txtPrecioBruto.setText("0.00");
            txtRetencionKg.setText("0.00");
            txtPrecioNeto.setText("0.00");
        } else {

            String[] datos = mr.devolverLineaDatos("select p.precioKg, r.importe "
                    + "from preciocafesociedad p "
                    + "inner join retenciones r on (p.id_retencion=r.id) "
                    + "where id_sociedad=" + mr.devuelveId("select id from personam where nombrecorto='" + txtSociedad.getText() + "'") + " and "
                    + "id_formaCafe=" + mr.devuelveId("select id from formaCafe where descripcion='" + comboForma.getSelectedItem() + "'") + " ", 2).split("¬");

            float precioBruto = Float.parseFloat(datos[0]);
            float retencion = Float.parseFloat(datos[1]) / 100;
            float precioNeto = precioBruto - retencion;

            txtPrecioBruto.setText(df.format(precioBruto) + "");
            txtRetencionKg.setText(df.format(retencion) + "");
            txtPrecioNeto.setText(df.format(precioNeto) + "");
        }
    }

    public void cambiarMesLetra(String fecha) {
        //JOptionPane.showMessageDialog(null, fecha);
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
        fecha = dia + "-" + mes + "-" + año;
        txtFolio.setText(fecha);
        jDateChooser1.setDateFormatString(fecha);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtSociedad = new javax.swing.JTextField();
        labelRecepcion = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        txtFolio = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboProductor = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtClaveProductor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        radioSocio = new javax.swing.JRadioButton();
        radioEnlace = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboParcela = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtClaveParcela = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCertificacion = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        comboForma = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtIdCorte = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        txtEntrego = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtSacos = new javax.swing.JTextField();
        txtKgRecibidos = new javax.swing.JTextField();
        txtTotalBruto = new javax.swing.JTextField();
        txtRetencion = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtCalificacion = new javax.swing.JTextField();
        txtInmaduros = new javax.swing.JTextField();
        txtVerdes = new javax.swing.JTextField();
        txtBrocados = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtPrecioBruto = new javax.swing.JLabel();
        txtRetencionKg = new javax.swing.JLabel();
        txtPrecioNeto = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Recibo");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Sociedad");

        txtSociedad.setEditable(false);
        txtSociedad.setText("Riviera");

        labelRecepcion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelRecepcion.setText("Id Recepcion");

        jCheckBox1.setText("Recibo Manual");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        txtFolio.setEnabled(false);

        jDateChooser1.setDateFormatString("dd/MMM/yyyy");
        jDateChooser1.setEnabled(false);
        jDateChooser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooser1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jDateChooser1MouseEntered(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("P\nr\no\nd\nu\nc\nt\no\nr");

        comboProductor.setEditable(true);
        comboProductor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione.." }));
        comboProductor.setToolTipText("");
        comboProductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProductorActionPerformed(evt);
            }
        });

        jLabel3.setText("Clave Productor");

        txtClaveProductor.setEditable(false);
        txtClaveProductor.setEnabled(false);

        jLabel5.setText("Nombre");

        buttonGroup1.add(radioSocio);
        radioSocio.setSelected(true);
        radioSocio.setText("Socio");
        radioSocio.setOpaque(false);
        radioSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSocioActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioEnlace);
        radioEnlace.setText("Enlace Comercial");
        radioEnlace.setOpaque(false);
        radioEnlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioEnlaceActionPerformed(evt);
            }
        });

        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(comboProductor, 0, 227, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1)))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(radioSocio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(radioEnlace))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtClaveProductor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioEnlace)
                            .addComponent(radioSocio)
                            .addComponent(jLabel2))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboProductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClaveProductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Parcela");

        jLabel7.setText("Nombre");

        comboParcela.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione.." }));
        comboParcela.setToolTipText("");
        comboParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboParcelaActionPerformed(evt);
            }
        });

        jLabel8.setText("Clave Parcela");

        txtClaveParcela.setEditable(false);
        txtClaveParcela.setEnabled(false);

        jLabel9.setText("Certificación");

        txtCertificacion.setEditable(false);
        txtCertificacion.setEnabled(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboParcela, 0, 155, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtClaveParcela)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCertificacion)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCertificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(6, 6, 6)
                        .addComponent(txtClaveParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Forma de Café");

        comboForma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFormaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(comboForma, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboForma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Id Corte");

        txtIdCorte.setEditable(false);
        txtIdCorte.setEnabled(false);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdCorte)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdCorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Entregó");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEntrego)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEntrego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Totales");

        txtSacos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSacosKeyTyped(evt);
            }
        });

        txtKgRecibidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKgRecibidosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKgRecibidosKeyTyped(evt);
            }
        });

        txtTotalBruto.setEditable(false);
        txtTotalBruto.setForeground(new java.awt.Color(102, 102, 102));

        txtRetencion.setEditable(false);
        txtRetencion.setForeground(new java.awt.Color(102, 102, 102));
        txtRetencion.setText("0");

        txtTotal.setEditable(false);
        txtTotal.setForeground(new java.awt.Color(102, 102, 102));

        jLabel10.setText("Sacos:");

        jLabel11.setText("Kg Recibidos:");

        jLabel12.setText("Total Bruto:");

        jLabel13.setText("Retencion:");

        jLabel14.setText("Total:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSacos, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKgRecibidos, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalBruto, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRetencion, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtSacos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtKgRecibidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtTotalBruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtRetencion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Evaluación Cereza");

        jLabel17.setText("Verdes");

        jLabel18.setText("Inmaduros");

        jLabel19.setText("Brocados");

        jLabel20.setText("Calificacion");

        txtCalificacion.setEditable(false);
        txtCalificacion.setEnabled(false);

        txtInmaduros.setEnabled(false);
        txtInmaduros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtInmadurosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtInmadurosKeyTyped(evt);
            }
        });

        txtVerdes.setEnabled(false);
        txtVerdes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtVerdesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVerdesKeyTyped(evt);
            }
        });

        txtBrocados.setEnabled(false);
        txtBrocados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBrocadosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBrocadosKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtInmaduros)
                            .addComponent(txtCalificacion)
                            .addComponent(txtBrocados, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVerdes, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtVerdes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtInmaduros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtBrocados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        jScrollPane1.setViewportView(txtObservaciones);

        jLabel23.setText("Observaciones");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Anticipos"));

        jLabel24.setText("Anticipo bruto por Kg =");

        jLabel25.setText("Retencion por Kg =");

        jLabel26.setText("Anticipo neto por Kg =");

        txtPrecioBruto.setText("0.0");

        txtRetencionKg.setText("0.0");

        txtPrecioNeto.setText("0.0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecioBruto)
                    .addComponent(txtRetencionKg)
                    .addComponent(txtPrecioNeto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtPrecioBruto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtRetencionKg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtPrecioNeto))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Información Adicional");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtHora.setEnabled(false);

        jLabel1.setText("Fecha Recibo Manual");

        jLabel27.setText("Hora");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(112, 112, 112)
                                        .addComponent(labelRecepcion))
                                    .addComponent(txtSociedad, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(160, 160, 160)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(labelRecepcion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSociedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox1)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jButton4.setText("Abrir PDF");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Guardar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Cerrar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox1.isSelected()) {
            txtFolio.setEnabled(true);
            jDateChooser1.setEnabled(true);
            txtHora.setEnabled(true);
        } else {
            txtFolio.setEnabled(false);
            jDateChooser1.setEnabled(false);
            txtHora.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void comboProductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProductorActionPerformed
        // TODO add your handling code here:
        /*       String persona = comboProductor.getSelectedItem() + "";

        if (tipoOperacion.equals("1")) {

            txtClaveProductor.setText(claveProductor());
            if (radioSocio.isSelected()) {
                String datos[] = mr.cargarCombos("select nombre from parcelas where id_persona=" + idPersona + " and tipoPersona=1").split("¬");
                comboParcela.setModel(new DefaultComboBoxModel((Object[]) datos));
                txtEntrego.setText(persona.replace(",", ""));
            } else if (radioEnlace.isSelected()) {
                String datos[] = mr.cargarCombos("select nombre from parcelas where id_persona=" + idPersona + " and tipoPersona=1").split("¬");
                comboParcela.setModel(new DefaultComboBoxModel((Object[]) datos));
            }

            txtClaveParcela.setText("");
            txtCertificacion.setText("");
        }*/
    }//GEN-LAST:event_comboProductorActionPerformed

    private void radioSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSocioActionPerformed
        // TODO add your handling code here:
        combos();
    }//GEN-LAST:event_radioSocioActionPerformed

    private void radioEnlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEnlaceActionPerformed
        combos();        // TODO add your handling code here:
    }//GEN-LAST:event_radioEnlaceActionPerformed

    private void comboParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboParcelaActionPerformed
        // TODO add your handling code here:
        if (tipoOperacion.equals("1")) {
            datosParcelas();
            generarIdCorte();
        }
    }//GEN-LAST:event_comboParcelaActionPerformed

    private void comboFormaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFormaActionPerformed
        // TODO add your handling code here:

        if (idioma.getProperty("Cereza").equals(comboForma.getSelectedItem() + "")) {
            txtVerdes.setEnabled(true);
            txtInmaduros.setEnabled(true);
            txtBrocados.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Evaluacions No Disponibles Momentaneamente");
            txtVerdes.setEnabled(false);
            txtInmaduros.setEnabled(false);
            txtBrocados.setEnabled(false);
        }

        calcularRetencion();
    }//GEN-LAST:event_comboFormaActionPerformed

    private void txtSacosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSacosKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtSacosKeyTyped

    private void txtKgRecibidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKgRecibidosKeyReleased
        // TODO add your handling code here:
        if (comboForma.getSelectedItem().equals("Seleccione..")) {
            JOptionPane.showMessageDialog(null, "Seleccione Forma Café");
        } else if (txtKgRecibidos.getText().equals("")) {
            txtTotalBruto.setText("0.00");
            txtTotal.setText("0.00");
            txtRetencion.setText("0.00");
        } else {
            calcularPrecios();
        }
    }//GEN-LAST:event_txtKgRecibidosKeyReleased

    private void txtKgRecibidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKgRecibidosKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtKgRecibidosKeyTyped

    private void txtInmadurosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInmadurosKeyReleased
        // TODO add your handling code here:
        calcularCalificacion();
        generarIdCorte();
    }//GEN-LAST:event_txtInmadurosKeyReleased

    private void txtInmadurosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInmadurosKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtInmadurosKeyTyped

    private void txtVerdesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVerdesKeyReleased
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(null, "Entre al evento");
        calcularCalificacion();
        generarIdCorte();
    }//GEN-LAST:event_txtVerdesKeyReleased

    private void txtVerdesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVerdesKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtVerdesKeyTyped

    private void txtBrocadosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBrocadosKeyReleased
        // TODO add your handling code here:
        calcularCalificacion();
        generarIdCorte();
    }//GEN-LAST:event_txtBrocadosKeyReleased

    private void txtBrocadosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBrocadosKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtBrocadosKeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        creacionPDF pdf = new creacionPDF(cn, Idioma);
        try {
            pdf.pdfRecibo(idRecibo);
        } catch (DocumentException ex) {
            Logger.getLogger(jdRecibos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(jdRecibos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(jdRecibos.class.getName()).log(Level.SEVERE, null, ex);
        }

        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(new java.io.File("C:\\fincalab\\pruebaRecibo.pdf"));
        } catch (IOException ex) {
            Logger.getLogger(jdRecibos.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*jdVisual v = new jdVisual(null, true, "pruebaRecibo.pdf");
        v.setVisible(true);*/
        // this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String sociedad = "", folio = "", nombreProductor = "", claveProductor = "",
                nombreParcela = "", claveParcela = "", certificacion = "", sacos = "", kgRecibidos = "",
                totalBruto = "", retencion = "", total = "", verdes = "", inmaduros = "", brocados = "", calificacion = "",
                idLote = "", personaEntrego = "", observaciones = "", idProductor, idParcela, idSociedad, personaRecibio;

        String fechaRecibo = new SimpleDateFormat("yyyy-MM-dd").format(jDateChooser1.getDate());

        Date date = new Date();
        String fechaActual = new SimpleDateFormat("yyyy-MM-dd").format(date);

        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        String horaActual = hourFormat.format(date);

        sociedad = txtSociedad.getText();
        folio = txtFolio.getText();
        nombreProductor = comboProductor.getSelectedItem() + "";
        claveProductor = txtClaveProductor.getText();
        nombreParcela = comboParcela.getSelectedItem() + "";
        claveParcela = txtClaveParcela.getText();
        certificacion = txtCertificacion.getText();
        sacos = txtSacos.getText();
        kgRecibidos = txtKgRecibidos.getText();
        totalBruto = txtTotalBruto.getText();
        retencion = txtRetencion.getText();
        total = txtTotal.getText();
        verdes = txtVerdes.getText();
        inmaduros = txtInmaduros.getText();
        brocados = txtBrocados.getText();
        calificacion = txtCalificacion.getText();
        idLote = txtIdCorte.getText();
        personaEntrego = txtEntrego.getText();
        observaciones = txtObservaciones.getText();

        idProductor = mr.devuelveId("select id from productor where clave_productor='" + claveProductor + "' ");
        idParcela = mr.devuelveId("select id from parcelas where clave_parcela='" + claveParcela + "' ");
        idSociedad = mr.devuelveId("select id from personam where nombrecorto='" + sociedad + "'");
        personaRecibio = mr.devuelveUnDato("SELECT\n"
                + "    CONCAT(\n"
                + "        pf.nombre,\n"
                + "        ' ',\n"
                + "        pf.apellidopaterno,\n"
                + "        ' ',\n"
                + "        pf.apellidomaterno\n"
                + "    )\n"
                + "FROM\n"
                + "    recepciones r\n"
                + "LEFT JOIN personaf pf ON\n"
                + "    (r.idResponsable = pf.id)\n"
                + "WHERE\n"
                + "    r.idRecepcion='" + idRecepcion + "'");
        //metodosDatosBasicos mdb = new metodosDatosBasicos(cn, Idioma);
        if (validar()) {
            if (mr.insertarRecibo("INSERT INTO recibos VALUES(null,'" + idRecepcion + "' ,'" + idLote + "', " + idPersona + ", " + idParcela + ", " + idSociedad + ", '" + folio + "', "
                    + "'" + comboForma.getSelectedItem() + "','" + sacos + "', "
                    + "'" + kgRecibidos + "', '" + totalBruto + "', '" + retencion + "', '" + total + "', '" + txtPrecioNeto.getText() + "',  '" + verdes + "', '" + inmaduros + "', "
                    + "'" + brocados + "', '" + calificacion + "', '" + personaEntrego + "', '" + personaRecibio + "', '" + observaciones + "','" + fechaRecibo + "', '" + txtHora.getText() + "', '" + fechaActual + "', '" + horaActual + "', "
                    + "'" + txtPrecioBruto.getText() + "', '" + txtPrecioNeto.getText() + "', '" + txtRetencionKg.getText() + "', 1 ) ")) {
                validarCorte();
                creacionPDF pdf = new creacionPDF(cn, Idioma);

                try {
                    pdf.pdfRecibo(mr.devuelveUnDato("select id from recibos order by id desc limit 1"));
                } catch (DocumentException ex) {
                    Logger.getLogger(jdRecibos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(jdRecibos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(jdRecibos.class.getName()).log(Level.SEVERE, null, ex);
                }

                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.open(new java.io.File("C:\\fincalab\\pruebaRecibo.pdf"));
                } catch (IOException ex) {
                    Logger.getLogger(jdRecibos.class.getName()).log(Level.SEVERE, null, ex);
                }

                this.dispose();
                jpR.llenarTabla();

            } else {
                JOptionPane.showMessageDialog(null, "Error al crear recibo");
            }

        } else {

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        //String fechaRecibo = new SimpleDateFormat("yyyy-MMM-dd").format(jDateChooser1.getDate());
        // txtFolio.setText(fechaRecibo);
        //cambiarMesLetra(fechaRecibo);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jDateChooser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jDateChooser1MouseClicked

    private void jDateChooser1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1MouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String persona = comboProductor.getSelectedItem() + "";

        if (tipoOperacion.equals("1")) {

            txtClaveProductor.setText(claveProductor());
            if (radioSocio.isSelected()) {
                String datos[] = mr.cargarCombos("select nombre from parcelas where id_persona=" + idPersona + " and tipoPersona=1").split("¬");
                comboParcela.setModel(new DefaultComboBoxModel((Object[]) datos));
                txtEntrego.setText(persona.replace(",", ""));
            } else if (radioEnlace.isSelected()) {
                String datos[] = mr.cargarCombos("select nombre from parcelas where id_persona=" + idPersona + " and tipoPersona=1").split("¬");
                comboParcela.setModel(new DefaultComboBoxModel((Object[]) datos));
                txtEntrego.setText(persona.replace(",", ""));
            }

            txtClaveParcela.setText("");
            txtCertificacion.setText("");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    String tipoPersona = "";

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
            java.util.logging.Logger.getLogger(jdRecibos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdRecibos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdRecibos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdRecibos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> comboForma;
    private javax.swing.JComboBox<String> comboParcela;
    private javax.swing.JComboBox<String> comboProductor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelRecepcion;
    private javax.swing.JRadioButton radioEnlace;
    private javax.swing.JRadioButton radioSocio;
    private javax.swing.JTextField txtBrocados;
    private javax.swing.JTextField txtCalificacion;
    private javax.swing.JTextField txtCertificacion;
    private javax.swing.JTextField txtClaveParcela;
    private javax.swing.JTextField txtClaveProductor;
    private javax.swing.JTextField txtEntrego;
    private javax.swing.JTextField txtFolio;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtIdCorte;
    private javax.swing.JTextField txtInmaduros;
    private javax.swing.JTextField txtKgRecibidos;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JLabel txtPrecioBruto;
    private javax.swing.JLabel txtPrecioNeto;
    private javax.swing.JTextField txtRetencion;
    private javax.swing.JLabel txtRetencionKg;
    private javax.swing.JTextField txtSacos;
    private javax.swing.JTextField txtSociedad;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalBruto;
    private javax.swing.JTextField txtVerdes;
    // End of variables declaration//GEN-END:variables
}
