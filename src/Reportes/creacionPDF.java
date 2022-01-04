/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import Idioma.Propiedades;
import Metodos_Configuraciones.metodosDatosBasicos;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class creacionPDF {

    metodosDatosBasicos mdb;
    Connection cn;
    Propiedades idioma;
    String Idioma;

    public creacionPDF(Connection cn, String Idioma) {
        this.cn = cn;
        this.Idioma = Idioma;
        idioma = new Propiedades(Idioma);
        mdb = new metodosDatosBasicos(cn, Idioma);
    }

    public void pdfBoletaSalidaRecepcion(String idBoleta, Object[][] contenido) throws FileNotFoundException, DocumentException, SQLException {

        String[] datos = mdb.devolverLineaDatos("SELECT\n"
                + "    b.idBoletaManual,\n"
                + "    r.idRecepcion,\n"
                + "    IF(\n"
                + "        b.tipoLugar = 'B',\n"
                + "        bh.nombre,\n"
                + "        al.nombreAlmacen\n"
                + "    ),\n"
                + "    b.fecha,\n"
                + "    b.totalSacos,\n"
                + "    b.totalKg,\n"
                + "    b.transporteLimpio,\n"
                + "    b.descripcion,\n"
                + "    v.Nombre,\n"
                + "    v.Placas,\n"
                + "    v.Responsable,\n"
                + "    pm.RazonSocial,\n"
                + "    pm.Telefono,\n"
                + "    pm.Direccion,\n"
                + "    l.Descripcion,\n"
                + "    ec.Descripcion, b.fechaboletamanual,\n"
                + "    CONCAT(pf.Nombre,' ',pf.ApellidoPaterno,' ',pf.ApellidoMaterno)\n"
                + "FROM\n"
                + "    boletasalidareceptor b\n"
                + "LEFT JOIN vehiculo v ON\n"
                + "    (b.idTransporte = v.ID)\n"
                + "LEFT JOIN recepciones r ON\n"
                + "    (r.idRecepcion = b.origen)\n"
                + "LEFT JOIN beneficioshumedos bh ON\n"
                + "    (bh.nombre = b.destino)\n"
                + "LEFT JOIN almacenes al ON\n"
                + "    (al.id = b.destino)\n"
                + "LEFT JOIN personam pm ON\n"
                + "    (b.idSociedad = pm.ID)\n"
                + "LEFT JOIN ejidocolonia ec ON\n"
                + "    (pm.ID_EjidoColonia = ec.ID)\n"
                + "LEFT JOIN localidad l ON\n"
                + "    (pm.ID_Localidad = l.ID)\n"
                + "LEFT JOIN personaf pf ON\n"
                + "    (pf.ID = r.idResponsable)\n"
                + "WHERE\n"
                + "    b.idBoleta = '" + idBoleta + "'\n"
                + "GROUP BY\n"
                + "    b.idBoleta", 18).split("¬");

        String boletaManual = datos[0];
        String origen = datos[1];
        String destino = datos[2];
        String fecha = datos[3];
        String totalSacos = datos[4];
        String totalKg = datos[5];
        String transporteLimpio = datos[6];
        String observaciones = datos[7];
        String vehiculo = datos[8];
        String placas = datos[9];
        String responsableAuto = datos[10];
        String razonsocial = datos[11];
        String tel = datos[12];
        String direccion = datos[13];
        String localidad = datos[14];
        String colonia = datos[15];
        String fechaManual = datos[16];
        String encargado = datos[17];

        Document documento = new Document(PageSize.LETTER);
        Document documento2 = new Document(PageSize.LETTER);

        FileOutputStream ficheroPdf = new FileOutputStream("C:\\FincaLab\\pruebaBoleta.pdf");
        PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);

        documento.open();

        Font fuente = new Font();
        Font fuente2 = new Font();
        Font fuente3 = new Font();
        fuente.setSize(12);
        fuente2.setSize(9);
        fuente3.setSize(7);

        for (int i = 0; i < 2; i++) {

            Paragraph titulo = new Paragraph(razonsocial, fuente);
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);

            Paragraph ubicacion = new Paragraph(direccion + " " + localidad + ", " + colonia, fuente2);
            ubicacion.setAlignment(Element.ALIGN_CENTER);
            documento.add(ubicacion);

            Paragraph telefono = new Paragraph(idioma.getProperty("Telefono") + " " + tel, fuente2);
            telefono.setAlignment(Element.ALIGN_CENTER);
            documento.add(telefono);

            Paragraph horarioBoleta = new Paragraph(idioma.getProperty("Fecha") + " " + fecha, fuente2);
            horarioBoleta.setAlignment(Element.ALIGN_RIGHT);
            documento.add(horarioBoleta);

            Paragraph idRecep = new Paragraph(idioma.getProperty("Recepcion"), fuente2);
            idRecep.setAlignment(Element.ALIGN_CENTER);
            documento.add(idRecep);

            Paragraph numBoleta = new Paragraph(idBoleta, fuente2);
            numBoleta.setAlignment(Element.ALIGN_CENTER);
            documento.add(numBoleta);

            // Paragraph idBoletaM = new Paragraph(idioma.getProperty("BoletaManual") + " " + boletaManual + "                            " + idioma.getProperty("NoBoleta") + " " + idBoleta + "\n\n", fuente2);
            Paragraph idBoletaM = new Paragraph(idioma.getProperty("BoletaManual") + " " + boletaManual, fuente2);
            idBoletaM.setAlignment(Element.ALIGN_CENTER);
            documento.add(idBoletaM);

            Paragraph fechaBoletaM = new Paragraph(idioma.getProperty("FechaDeBoletaManual") + " " + fechaManual, fuente2);
            fechaBoletaM.setAlignment(Element.ALIGN_CENTER);
            documento.add(fechaBoletaM);

            Paragraph origenDestino = new Paragraph(idioma.getProperty("Origen") + " " + origen + "\n" + idioma.getProperty("Destino") + " " + destino, fuente2);
            origenDestino.setAlignment(Element.ALIGN_LEFT);
            documento.add(origenDestino);

            documento.add(new Paragraph("\n"));

            documento.add(tablaBoletaSalida(contenido, totalSacos, totalKg));

            String leyendalimpio = "";
            if (transporteLimpio.equals("1")) {
                //JOptionPane.showMessageDialog(null,"Transporte Limpio");
                leyendalimpio = idioma.getProperty("TransporteLimpio") + ": SI";
            } else {
                // JOptionPane.showMessageDialog(null,"Transporte Sucio");
                leyendalimpio = idioma.getProperty("TransporteLimpio") + ": NO";
            }

            documento.add(new Paragraph("\n"));
            //documento.add(new Paragraph("Información de Transporte", fuente2));
            documento.add(tablaTransporteSalida(vehiculo, placas, responsableAuto, leyendalimpio));

            documento.add(new Paragraph("\n"));

            documento.add(tablaObservaciones(observaciones));

            documento.add(new Paragraph("\n"));

            documento.add(tablaFirmas(responsableAuto, encargado));

            documento.add(new Paragraph("\n"));

        }

        Chapter chapSecond = new Chapter(1);

        documento.add(chapSecond);

        for (int i = 0; i < 2; i++) {

            Paragraph titulo = new Paragraph(razonsocial, fuente);
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);

            Paragraph ubicacion = new Paragraph(direccion + " " + localidad + ", " + colonia, fuente2);
            ubicacion.setAlignment(Element.ALIGN_CENTER);
            documento.add(ubicacion);

            Paragraph telefono = new Paragraph(idioma.getProperty("Telefono") + " " + tel, fuente2);
            telefono.setAlignment(Element.ALIGN_CENTER);
            documento.add(telefono);

            Paragraph horarioBoleta = new Paragraph(idioma.getProperty("Fecha") + " " + fecha, fuente2);
            horarioBoleta.setAlignment(Element.ALIGN_RIGHT);
            documento.add(horarioBoleta);

            Paragraph idRecep = new Paragraph(idioma.getProperty("Recepcion"), fuente2);
            idRecep.setAlignment(Element.ALIGN_CENTER);
            documento.add(idRecep);

            Paragraph numBoleta = new Paragraph(idBoleta, fuente2);
            numBoleta.setAlignment(Element.ALIGN_CENTER);
            documento.add(numBoleta);

            // Paragraph idBoletaM = new Paragraph(idioma.getProperty("BoletaManual") + " " + boletaManual + "                            " + idioma.getProperty("NoBoleta") + " " + idBoleta + "\n\n", fuente2);
            Paragraph idBoletaM = new Paragraph(idioma.getProperty("BoletaManual") + " " + boletaManual, fuente2);
            idBoletaM.setAlignment(Element.ALIGN_CENTER);
            documento.add(idBoletaM);

            Paragraph fechaBoletaM = new Paragraph(idioma.getProperty("FechaDeBoletaManual") + " " + fechaManual, fuente2);
            fechaBoletaM.setAlignment(Element.ALIGN_CENTER);
            documento.add(fechaBoletaM);

            Paragraph origenDestino = new Paragraph(idioma.getProperty("Origen") + " " + origen + "\n" + idioma.getProperty("Destino") + " " + destino, fuente2);
            origenDestino.setAlignment(Element.ALIGN_LEFT);
            documento.add(origenDestino);

            documento.add(new Paragraph("\n"));

            documento.add(tablaBoletaSalida(contenido, totalSacos, totalKg));

            String leyendalimpio = "";
            if (transporteLimpio.equals("1")) {
                //JOptionPane.showMessageDialog(null,"Transporte Limpio");
                leyendalimpio = idioma.getProperty("TransporteLimpio") + ": SI";
            } else {
                // JOptionPane.showMessageDialog(null,"Transporte Sucio");
                leyendalimpio = idioma.getProperty("TransporteLimpio") + ": NO";
            }

            documento.add(new Paragraph("\n"));
            //documento.add(new Paragraph("Información de Transporte", fuente2));
            documento.add(tablaTransporteSalida(vehiculo, placas, responsableAuto, leyendalimpio));

            documento.add(new Paragraph("\n"));

            documento.add(tablaObservaciones(observaciones));

            documento.add(new Paragraph("\n"));

            documento.add(tablaFirmas(responsableAuto, encargado));

            documento.add(new Paragraph("\n"));
        }

        documento.close();
    }

    public void pdfBoletaEntradaBH(String idBoleta, Object[][] contenido, String observaciones)
            throws FileNotFoundException, DocumentException, SQLException {

        //JOptionPane.showMessageDialog(null, "Estoy en pfg boleta bh");
        String[] datos = mdb.devolverLineaDatos("SELECT\n"
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
                + "    be.costalesRecibidos,\n"
                + "    pm.NombreCorto,\n"
                + "    pm.razonsocial,\n"
                + "    bh.telefono,\n"
                + "    bh.domicilio,\n"
                + "    l.Descripcion,\n"
                + "    r.idRecepcion,\n"
                + "    bh.nombre \n"
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
                + "LEFT JOIN personam pm ON\n"
                + "    (pm.ID = bh.idSociedad)\n"
                + "LEFT JOIN localidad l ON\n"
                + "    (bh.idLocalidad = l.ID)\n"
                + "WHERE\n"
                + "    be.idBoleta = '" + idBoleta + "'\n"
                + "GROUP BY\n"
                + "    be.idBoleta", 27).split("¬");

        JOptionPane.showMessageDialog(null, datos);

        String nombreRecepcion = datos[0];
        String nombreBeneficio = datos[1];
        String totalSacos = datos[6];
        String totalKilos = datos[7];
        String vehiculo = datos[10];
        String placas = datos[11];
        String transportista = datos[12];
        String fechaEntrada = datos[17];
        String kgRecibidos = datos[18];
        String costalesRecibidos = datos[19];
        String sociedad = datos[20];
        String razonSocial = datos[21];
        String telefono = datos[22];
        String domicilio = datos[23];
        String localidad = datos[24];
        String idRecepcion = datos[25];
        String idBeneficio = datos[26];

        String capturista = mdb.devuelveUnDato("select CONCAT(pf.Nombre,' ',pf.ApellidoPaterno,' ',pf.ApellidoMaterno) \n"
                + "from beneficioshumedos b\n"
                + "left join personaf pf on(pf.ID=b.idPersonaCapturista)\n"
                + "where b.nombre='" + idBeneficio + "'");

        String encargado = mdb.devuelveUnDato("select CONCAT(pf2.Nombre,' ',pf2.ApellidoPaterno,' ',pf2.ApellidoMaterno) \n"
                + "from beneficioshumedos b\n"
                + "left join personaf pf2 on(pf2.ID=b.idPersonaEncargada)\n"
                + "where b.nombre='" + idBeneficio + "' ");

        Document documento = new Document(PageSize.LETTER);

        FileOutputStream ficheroPdf = new FileOutputStream("C:\\fincalab\\pruebaBoleta.pdf");
        PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);

        documento.open();

        Font fuente = new Font();
        Font fuente2 = new Font();
        Font fuente3 = new Font();
        fuente.setSize(12);
        fuente2.setSize(9);
        fuente3.setSize(7);

        Paragraph titulo = new Paragraph(razonSocial, fuente);
        titulo.setAlignment(Element.ALIGN_CENTER);
        documento.add(titulo);

        Paragraph ubicacion = new Paragraph(domicilio + " " + localidad, fuente2);
        ubicacion.setAlignment(Element.ALIGN_CENTER);
        documento.add(ubicacion);

        Paragraph tel = new Paragraph(idioma.getProperty("Telefono") + " " + telefono, fuente2);
        tel.setAlignment(Element.ALIGN_CENTER);
        documento.add(tel);

        Paragraph horarioBoleta = new Paragraph(idioma.getProperty("Fecha") + " " + fechaEntrada, fuente2);
        horarioBoleta.setAlignment(Element.ALIGN_RIGHT);
        documento.add(horarioBoleta);

        Paragraph idRecep = new Paragraph("Beneficio Humedo", fuente2);
        idRecep.setAlignment(Element.ALIGN_CENTER);
        documento.add(idRecep);

        Paragraph numBoleta = new Paragraph(idBoleta, fuente2);
        numBoleta.setAlignment(Element.ALIGN_CENTER);
        documento.add(numBoleta);

        Paragraph origenDestino = new Paragraph(idioma.getProperty("Origen") + " / " + nombreRecepcion + " " + idRecepcion + "\n" + idioma.getProperty("Destino") + " " + nombreBeneficio + " / " + idBeneficio, fuente2);
        origenDestino.setAlignment(Element.ALIGN_LEFT);
        documento.add(origenDestino);

        documento.add(new Paragraph("\n"));
        documento.add(tablaBoletaEntradaBH(contenido, totalSacos, totalKilos));
        documento.add(new Paragraph("\n"));

        documento.add(tablaObservaciones(observaciones));

        documento.add(new Paragraph("\n"));

        documento.add(tablaTransporteSalida(vehiculo, placas, transportista, ""));

        documento.add(new Paragraph("\n"));

        documento.add(tablaFirmasBH(transportista, capturista, encargado));

        documento.close();
    }

    public void pdfBoletaSalidaRecepcionDivision(String idBoleta, Object[][] contenido, DefaultTableModel modelo) throws FileNotFoundException, DocumentException, SQLException {

        String[] datos = mdb.devolverLineaDatos("SELECT\n"
                + "    b.idBoletaManual,\n"
                + "    r.idRecepcion,\n"
                + "    IF(\n"
                + "        b.tipoLugar = 'B',\n"
                + "        bh.nombre,\n"
                + "        al.nombreAlmacen\n"
                + "    ),\n"
                + "    b.fecha,\n"
                + "    b.totalSacos,\n"
                + "    b.totalKg,\n"
                + "    b.transporteLimpio,\n"
                + "    b.descripcion,\n"
                + "    v.Nombre,\n"
                + "    v.Placas,\n"
                + "    v.Responsable,\n"
                + "    pm.RazonSocial,\n"
                + "    pm.Telefono,\n"
                + "    pm.Direccion,\n"
                + "    l.Descripcion,\n"
                + "    ec.Descripcion,\n"
                + "    CONCAT(pf.Nombre,' ',pf.ApellidoPaterno,' ',pf.ApellidoMaterno)\n"
                + "FROM\n"
                + "    boletasalidareceptor b\n"
                + "LEFT JOIN vehiculo v ON\n"
                + "    (b.idTransporte = v.ID)\n"
                + "LEFT JOIN recepciones r ON\n"
                + "    (r.idRecepcion = b.origen)\n"
                + "LEFT JOIN beneficioshumedos bh ON\n"
                + "    (bh.nombre = b.destino)\n"
                + "LEFT JOIN almacenes al ON\n"
                + "    (al.id = b.destino)\n"
                + "LEFT JOIN personam pm ON\n"
                + "    (b.idSociedad = pm.ID)\n"
                + "LEFT JOIN ejidocolonia ec ON\n"
                + "    (pm.ID_EjidoColonia = ec.ID)\n"
                + "LEFT JOIN localidad l ON\n"
                + "    (pm.ID_Localidad = l.ID)\n"
                + "LEFT JOIN personaf pf ON\n"
                + "    (pf.ID = r.idResponsable)\n"
                + "WHERE\n"
                + "    b.idBoleta = '" + idBoleta + "'\n"
                + "GROUP BY\n"
                + "    b.idBoleta", 17).split("¬");

        String boletaManual = datos[0];
        String origen = datos[1];
        String destino = datos[2];
        String fecha = datos[3];
        String totalSacos = datos[4];
        String totalKg = datos[5];
        String transporteLimpio = datos[6];
        String observaciones = datos[7];
        String vehiculo = datos[8];
        String placas = datos[9];
        String responsableAuto = datos[10];
        String razonsocial = datos[11];
        String tel = datos[12];
        String direccion = datos[13];
        String localidad = datos[14];
        String colonia = datos[15];
        String encargado = datos[16];

        Document documento = new Document(PageSize.LETTER);

        FileOutputStream ficheroPdf = new FileOutputStream("C:\\fincalab\\pruebaBoleta.pdf");
        PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);

        documento.open();
        //Creamos numero de hojas dependiendo el numero de divisiones
        for (int i = 0; i < modelo.getRowCount(); i++) {

            documento.newPage();

            Font fuente = new Font();
            Font fuente2 = new Font();
            Font fuente3 = new Font();
            fuente.setSize(12);
            fuente2.setSize(9);
            fuente3.setSize(7);

            Paragraph titulo = new Paragraph(razonsocial, fuente);
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);

            Paragraph ubicacion = new Paragraph(direccion + " " + localidad + ", " + colonia, fuente2);
            ubicacion.setAlignment(Element.ALIGN_CENTER);
            documento.add(ubicacion);

            Paragraph telefono = new Paragraph(idioma.getProperty("Telefono") + " " + tel, fuente2);
            telefono.setAlignment(Element.ALIGN_CENTER);
            documento.add(telefono);

            Paragraph horarioBoleta = new Paragraph(idioma.getProperty("Fecha") + " " + fecha, fuente2);
            horarioBoleta.setAlignment(Element.ALIGN_RIGHT);
            documento.add(horarioBoleta);

            Paragraph idRecep = new Paragraph(idioma.getProperty("Recepcion"), fuente2);
            idRecep.setAlignment(Element.ALIGN_CENTER);
            documento.add(idRecep);

            Paragraph numBoleta = new Paragraph(idBoleta, fuente2);
            numBoleta.setAlignment(Element.ALIGN_CENTER);
            documento.add(numBoleta);

            // Paragraph idBoletaM = new Paragraph(idioma.getProperty("BoletaManual") + " " + boletaManual + "                            " + idioma.getProperty("NoBoleta") + " " + idBoleta + "\n\n", fuente2);
            Paragraph idBoletaM = new Paragraph(idioma.getProperty("BoletaManual") + " " + boletaManual, fuente2);
            idBoletaM.setAlignment(Element.ALIGN_CENTER);
            documento.add(idBoletaM);

            Paragraph origenDestino = new Paragraph(idioma.getProperty("Origen") + " " + origen + "\n" + idioma.getProperty("Destino") + " " + destino, fuente2);
            origenDestino.setAlignment(Element.ALIGN_LEFT);
            documento.add(origenDestino);

            documento.add(new Paragraph("\n"));

            documento.add(new Paragraph("Información Cortes", fuente3));
            documento.add(new Paragraph(" ", fuente3));
            documento.add(tablaBoletaSalida(contenido, totalSacos, totalKg));

            documento.add(new Paragraph("\n"));

            Font fuente2_1 = new Font();
            fuente2_1.setSize(7);

            PdfPTable table = new PdfPTable(3);
            table.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

            table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));

            Paragraph columna1 = new Paragraph("Boleta " + (i + 1) + "/" + modelo.getRowCount());
            Paragraph columna2 = new Paragraph("Sacos Enviados");
            Paragraph columna3 = new Paragraph("Kilos Enviados");

            columna1.getFont().setStyle(Font.BOLD);
            columna1.getFont().setSize(7);

            columna2.getFont().setStyle(Font.BOLD);
            columna2.getFont().setSize(7);

            columna3.getFont().setStyle(Font.BOLD);
            columna3.getFont().setSize(7);

            table.addCell(columna1);
            table.addCell(columna2);
            table.addCell(columna3);

            table.setHeaderRows(1);
            table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
            table.setWidthPercentage(100);

            Paragraph col1 = new Paragraph(modelo.getValueAt(i, 0) + "", fuente2_1);
            table.addCell(col1);

            Paragraph col2 = new Paragraph(modelo.getValueAt(i, 1) + "", fuente2_1);
            table.addCell(col2);

            Paragraph col3 = new Paragraph(modelo.getValueAt(i, 2) + "", fuente2_1);
            table.addCell(col3);

            documento.add(new Paragraph("Información Boleta #" + (i + 1), fuente3));
            documento.add(new Paragraph(" ", fuente3));
            documento.add(table);
            documento.add(new Paragraph("\n"));

            String leyendalimpio = "";
            if (transporteLimpio.equals("1")) {
                //JOptionPane.showMessageDialog(null,"Transporte Limpio");
                leyendalimpio = idioma.getProperty("TransporteLimpio") + ": SI";
            } else {
                // JOptionPane.showMessageDialog(null,"Transporte Sucio");
                leyendalimpio = idioma.getProperty("TransporteLimpio") + ": NO";
            }

            //       Font fuente2_1 = new Font();
            // fuente2_1.setSize(7);
            PdfPTable table2 = new PdfPTable(3);
            table2.setHorizontalAlignment(Element.ALIGN_CENTER);
            table2.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

            table2.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));

            Paragraph columna12 = new Paragraph("Vehículo");
            Paragraph columna22 = new Paragraph("Placas");
            Paragraph columna32 = new Paragraph("Responsable");

            columna12.getFont().setStyle(Font.BOLD);
            columna12.getFont().setSize(7);

            columna22.getFont().setStyle(Font.BOLD);
            columna22.getFont().setSize(7);

            columna32.getFont().setStyle(Font.BOLD);
            columna32.getFont().setSize(7);

            table2.addCell(columna12);
            table2.addCell(columna22);
            table2.addCell(columna32);

            table2.setHeaderRows(1);
            table2.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
            table2.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table2.getDefaultCell().setBorder(Rectangle.NO_BORDER);
            table2.setWidthPercentage(100);

            String cadena = modelo.getValueAt(i, 3) + "";
            String[] info = cadena.split(", ");

            Paragraph col12 = new Paragraph(info[1], fuente2_1);
            table2.addCell(col12);

            Paragraph col22 = new Paragraph(info[2], fuente2_1);
            table2.addCell(col22);

            Paragraph col32 = new Paragraph(info[0], fuente2_1);
            table2.addCell(col32);

            documento.add(new Paragraph("Información Transporte", fuente3));
            documento.add(new Paragraph(" ", fuente3));
            documento.add(table2);
            //No necesaria para boleta multiple
            // documento.add(tablaTransporteSalida(vehiculo, placas, responsableAuto,leyendalimpio ));

            documento.add(new Paragraph("\n"));
            documento.add(tablaObservaciones(observaciones));

            /*Paragraph observa = new Paragraph(idioma.getProperty("Observaciones") + "\n" + observaciones, fuente2);
            observa.setAlignment(Element.ALIGN_LEFT);

            documento.add(observa);*/
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("\n"));

            documento.add(tablaFirmas(info[0], encargado));

        }

        documento.close();
    }

    public PdfPTable tablaBoletaSalida(Object[][] contenido, String sacos, String kg) throws SQLException {
        Font fuente2 = new Font();
        fuente2.setSize(7);

        PdfPTable table = new PdfPTable(5);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

        table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));

        Paragraph columna1 = new Paragraph(idioma.getProperty("IdCorte"));
        Paragraph columna2 = new Paragraph(idioma.getProperty("Certificacion"));
        Paragraph columna3 = new Paragraph(idioma.getProperty("FormaDeCafe"));
        Paragraph columna4 = new Paragraph(idioma.getProperty("Sacos"));
        Paragraph columna5 = new Paragraph(idioma.getProperty("Kilos"));

        columna1.getFont().setStyle(Font.BOLD);
        columna1.getFont().setSize(7);

        columna2.getFont().setStyle(Font.BOLD);
        columna2.getFont().setSize(7);

        columna3.getFont().setStyle(Font.BOLD);
        columna3.getFont().setSize(7);

        columna4.getFont().setStyle(Font.BOLD);
        columna4.getFont().setSize(7);

        columna5.getFont().setStyle(Font.BOLD);
        columna5.getFont().setSize(7);

        table.addCell(columna1);
        table.addCell(columna2);
        table.addCell(columna3);
        table.addCell(columna4);
        table.addCell(columna5);
        table.setHeaderRows(1);
        table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.setWidthPercentage(100);

        for (int counter = 0; counter < contenido.length; counter++) {

            //Paragraph col0 = new Paragraph(String.valueOf(counter + 1), fuente2);
            // table.addCell(col0);
            Paragraph col1 = new Paragraph(contenido[counter][0] + "", fuente2);
            //JOptionPane.showMessageDialog(null,"Dato "+contenido[counter][0]);
            table.addCell(col1);

            Paragraph col2 = new Paragraph(contenido[counter][1] + "", fuente2);
            // JOptionPane.showMessageDialog(null,"Dato "+contenido[counter][1]);
            table.addCell(col2);

            Paragraph col3 = new Paragraph(contenido[counter][2] + "", fuente2);
            // JOptionPane.showMessageDialog(null,"Dato "+contenido[counter][2]);
            table.addCell(col3);

            Paragraph col4 = new Paragraph(contenido[counter][3] + "", fuente2);
            // JOptionPane.showMessageDialog(null,"Dato "+contenido[counter][3]);
            table.addCell(col4);

            Paragraph col5 = new Paragraph(contenido[counter][4] + "", fuente2);
            //JOptionPane.showMessageDialog(null,"Dato "+contenido[counter][4]);
            table.addCell(col5);

        }
        Paragraph totales = new Paragraph("Totales", fuente2);
        Paragraph totalSacos = new Paragraph(sacos, fuente2);
        Paragraph totalKg = new Paragraph(kg, fuente2);

        table.addCell("");
        table.addCell("");
        table.addCell(totales);
        table.addCell(totalSacos);
        table.addCell(totalKg);

        return table;
    }

    public PdfPTable tablaBoletaEntradaBH(Object[][] contenido, String sacos, String kg) throws SQLException {
        Font fuente2 = new Font();
        fuente2.setSize(7);

        PdfPTable table = new PdfPTable(7);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

        table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));

        Paragraph columna1 = new Paragraph(idioma.getProperty("IdCorte"));
        Paragraph columna2 = new Paragraph(idioma.getProperty("FormaDeCafe"));
        Paragraph columna3 = new Paragraph(idioma.getProperty("Sacos"));
        Paragraph columna4 = new Paragraph(idioma.getProperty("Kilos"));
        Paragraph columna5 = new Paragraph(idioma.getProperty("EstadoDeCafe"));
        Paragraph columna6 = new Paragraph(idioma.getProperty("CostalesRecibidos"));
        Paragraph columna7 = new Paragraph(idioma.getProperty("KilosRecibidos"));

        columna1.getFont().setStyle(Font.BOLD);
        columna1.getFont().setSize(7);

        columna2.getFont().setStyle(Font.BOLD);
        columna2.getFont().setSize(7);

        columna3.getFont().setStyle(Font.BOLD);
        columna3.getFont().setSize(7);

        columna4.getFont().setStyle(Font.BOLD);
        columna4.getFont().setSize(7);

        columna5.getFont().setStyle(Font.BOLD);
        columna5.getFont().setSize(7);

        columna6.getFont().setStyle(Font.BOLD);
        columna6.getFont().setSize(7);

        columna7.getFont().setStyle(Font.BOLD);
        columna7.getFont().setSize(7);

        table.addCell(columna1);
        table.addCell(columna2);
        table.addCell(columna3);
        table.addCell(columna4);
        table.addCell(columna5);
        table.addCell(columna6);
        table.addCell(columna7);

        table.setHeaderRows(1);
        table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.setWidthPercentage(100);

        for (int counter = 0; counter < contenido.length; counter++) {

            //Paragraph col0 = new Paragraph(String.valueOf(counter + 1), fuente2);
            // table.addCell(col0);
            Paragraph col1 = new Paragraph(contenido[counter][0] + "", fuente2);
            //JOptionPane.showMessageDialog(null,"Dato "+contenido[counter][0]);
            table.addCell(col1);

            Paragraph col2 = new Paragraph(contenido[counter][1] + "", fuente2);
            // JOptionPane.showMessageDialog(null,"Dato "+contenido[counter][1]);
            table.addCell(col2);

            Paragraph col3 = new Paragraph(contenido[counter][2] + "", fuente2);
            // JOptionPane.showMessageDialog(null,"Dato "+contenido[counter][2]);
            table.addCell(col3);

            Paragraph col4 = new Paragraph(contenido[counter][3] + "", fuente2);
            // JOptionPane.showMessageDialog(null,"Dato "+contenido[counter][3]);
            table.addCell(col4);

            Paragraph col5 = new Paragraph(contenido[counter][4] + "", fuente2);
            //JOptionPane.showMessageDialog(null,"Dato "+contenido[counter][4]);
            table.addCell(col5);

            Paragraph col6 = new Paragraph(contenido[counter][5] + "", fuente2);
            //JOptionPane.showMessageDialog(null,"Dato "+contenido[counter][4]);
            table.addCell(col6);

            Paragraph col7 = new Paragraph(contenido[counter][6] + "", fuente2);
            //JOptionPane.showMessageDialog(null,"Dato "+contenido[counter][4]);
            table.addCell(col7);
        }

        Paragraph totales = new Paragraph("Totales", fuente2);
        Paragraph totalSacos = new Paragraph(sacos, fuente2);
        Paragraph totalKg = new Paragraph(kg, fuente2);

        table.addCell("");
        table.addCell("");
        table.addCell("");
        table.addCell("");
        table.addCell(totales);
        table.addCell(totalSacos);
        table.addCell(totalKg);

        return table;
    }

    public PdfPTable tablaFirmasBH(String transportista, String capturista, String encargado) {
        Font fuente2 = new Font();
        fuente2.setSize(9);
        Font fuente3 = new Font();
        fuente3.setSize(9);
        fuente3.setStyle(Font.BOLD);

        PdfPTable table = new PdfPTable(3);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

        table.getDefaultCell().setBackgroundColor(GrayColor.WHITE);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.setWidthPercentage(100);

        table.addCell(new Paragraph("Entrega", fuente2));
        table.addCell(new Paragraph("Recibe", fuente2));
        table.addCell(new Paragraph("Encargado", fuente2));

        table.addCell(new Paragraph(transportista, fuente3));
        table.addCell(new Paragraph(capturista, fuente3));
        table.addCell(new Paragraph(encargado, fuente3));

        return table;
    }

    public PdfPTable tablaFirmas(String chofer, String recibe) throws SQLException {
        Font fuente2 = new Font();
        fuente2.setSize(9);
        Font fuente3 = new Font();
        fuente3.setSize(9);
        fuente3.setStyle(Font.BOLD);

        PdfPTable table = new PdfPTable(2);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

        table.getDefaultCell().setBackgroundColor(GrayColor.WHITE);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.setWidthPercentage(100);

        table.addCell(new Paragraph(recibe, fuente2));
        table.addCell(new Paragraph(chofer, fuente2));

        table.addCell(new Paragraph(idioma.getProperty("Receptor"), fuente3));
        table.addCell(new Paragraph(idioma.getProperty("QuienRecibe"), fuente3));

        return table;
    }

    public PdfPTable tablaFirmasRecibo(String recibio, String entrego, String productor) throws SQLException {
        Font fuente2 = new Font();
        fuente2.setSize(7);
        Font fuente3 = new Font();
        fuente3.setSize(7);
        fuente3.setStyle(Font.BOLD);

        PdfPTable table = new PdfPTable(3);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

        table.getDefaultCell().setBackgroundColor(GrayColor.WHITE);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.setWidthPercentage(100);

        table.addCell(new Paragraph(recibio, fuente2));
        table.addCell(new Paragraph(entrego, fuente2));
        table.addCell(new Paragraph(productor, fuente2));

        table.addCell(new Paragraph(idioma.getProperty("Receptor"), fuente3));
        table.addCell(new Paragraph(idioma.getProperty("QuienEntrega"), fuente3));
        table.addCell(new Paragraph(idioma.getProperty("AQuienSePaga"), fuente3));

        return table;
    }

    public PdfPTable tablaTransporteSalida(String transporte, String placas, String responsableAuto, String leyenda) throws SQLException {

        Font fuente2_1 = new Font();
        fuente2_1.setSize(7);

        PdfPTable table = new PdfPTable(3);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

        table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));

        Paragraph columna1 = new Paragraph("Vehículo");
        Paragraph columna2 = new Paragraph("Placas");
        Paragraph columna3 = new Paragraph("Responsable");

        columna1.getFont().setStyle(Font.BOLD);
        columna1.getFont().setSize(7);

        columna2.getFont().setStyle(Font.BOLD);
        columna2.getFont().setSize(7);

        columna3.getFont().setStyle(Font.BOLD);
        columna3.getFont().setSize(7);

        table.addCell(columna1);
        table.addCell(columna2);
        table.addCell(columna3);

        table.setHeaderRows(1);
        table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.setWidthPercentage(100);

        Paragraph col1 = new Paragraph(transporte, fuente2_1);
        table.addCell(col1);

        Paragraph col2 = new Paragraph(placas, fuente2_1);
        table.addCell(col2);

        Paragraph col3 = new Paragraph(responsableAuto, fuente2_1);
        table.addCell(col3);

        return table;
    }

    public PdfPTable tablaObservaciones(String observaciones) throws SQLException {

        Font fuente2_1 = new Font();
        fuente2_1.setSize(7);

        PdfPTable table = new PdfPTable(1);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

        table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));

        Paragraph columna1 = new Paragraph("Observaciones");

        columna1.getFont().setStyle(Font.BOLD);
        columna1.getFont().setSize(7);

        table.addCell(columna1);

        table.setHeaderRows(1);
        table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.setWidthPercentage(100);

        Paragraph col1 = new Paragraph(observaciones, fuente2_1);
        table.addCell(col1);

        return table;
    }

    public void pdfRecibo(String idRecibo)
            throws DocumentException, IOException, SQLException {

        try {

            String[] datos = mdb.devolverLineaDatos("SELECT\n"
                    + "    r.id,\n"
                    + "    r.folioManual,\n"
                    + "    r.formaCafe,\n"
                    + "    r.sacos,\n"
                    + "    r.kgRecibidos,\n"
                    + "    r.totalBruto,\n"
                    + "    r.retencion,\n"
                    + "    r.total,\n"
                    + "    r.precioNeto,\n"
                    + "    r.verdes,\n"
                    + "    r.inmaduros,\n"
                    + "    r.brocados,\n"
                    + "    r.calificacion,\n"
                    + "    r.personaEntrego,\n"
                    + "    r.observaciones,\n"
                    + "    r.precioBrutoKgSociedad,\n"
                    + "    r.precioNetoKgSociedad,\n"
                    + "    Concat (pf.Nombre,' ',pf.apellidopaterno,' ',apellidomaterno),\n"
                    + "    lPer.Descripcion,\n"
                    + "    prod.clave_productor,\n"
                    + "    pm.RazonSocial,\n"
                    + "    pm.NombreCorto,\n"
                    + "    pm.Direccion,\n"
                    + "    lpm.Descripcion,\n"
                    + "    epm.descripcion,\n"
                    + "    r.fechaCreacion,\n"
                    + "    par.nombre,\n"
                    + "    par.clave_parcela,\n"
                    + "    par.clave_certificacion,\n"
                    + "    lpar.descripcion,\n"
                    + "    r.personaRecibio, "
                    + "    r.fechaRecepcion "
                    + "FROM\n"
                    + "    recibos r\n"
                    + "INNER JOIN personaf pf ON\n"
                    + "    (r.idPersona = pf.ID)\n"
                    + "INNER JOIN localidad lPer ON\n"
                    + "    (pf.ID_Localidad = lPer.ID)\n"
                    + "INNER JOIN productor prod ON\n"
                    + "    (prod.id_persona = pf.ID)\n"
                    + "INNER JOIN personam pm ON\n"
                    + "    (r.idSociedad = pm.ID)\n"
                    + "INNER JOIN localidad lpm ON\n"
                    + "    (pm.ID_Localidad = lpm.ID)\n"
                    + "INNER JOIN estado epm ON\n"
                    + "    (pm.ID_Estado = epm.ID)\n"
                    + "INNER JOIN parcelas par ON\n"
                    + "    (r.idParcela = par.id)\n"
                    + "INNER JOIN localidad lpar ON\n"
                    + "    (par.id_localidad = lpar.ID)\n"
                    + "WHERE\n"
                    + "    r.id = " + idRecibo + " AND prod.tipoPersona = 1", 32).split("¬");

            String id = datos[0];
            String folioManual = datos[1];
            String formaCafe = datos[2];
            String sacos = datos[3];
            String kgRecibidos = datos[4];
            String totalBruto = datos[5];
            String retencion = datos[6];
            String total = datos[7];
            String precioNeto = datos[8];
            String verdes = datos[9];
            String inmaduros = datos[10];
            String brocados = datos[11];
            String calificacion = datos[12];
            String pEntrego = datos[13];
            String observaciones = datos[14];
            String precioBrutoKgSociedad = datos[15];
            String precioNetoKgSociedad = datos[16];
            String nombreProductor = datos[17];
            String localidadProd = datos[18];
            String claveProd = datos[19];
            String razonsocial = datos[20];
            String nombrecorto = datos[21];
            String direccionSociedad = datos[22];
            String localidadSociedad = datos[23];
            String estadoSociedad = datos[24];
            String fechaRecibo = datos[25];
            String nombrePar = datos[26];
            String clavePar = datos[27];
            String certPar = datos[28];
            String localidadPar = datos[29];
            String personaRecibio = datos[30];
            String fechaManual = datos[31];
            Document documento = new Document(PageSize.LETTER);
            //Image img = Image.getInstance("mega200px.png");
            //C:\\Users\\acer\\Desktop\\pruebaRecibo.pdf
            FileOutputStream ficheroPdf = new FileOutputStream("C:\\fincalab\\pruebaRecibo.pdf");
            PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);

            documento.open();
            //img.setAbsolutePosition(380f, 695f);

            Font fuente = new Font();
            Font fuente2 = new Font();
            Font fuenteNegrita = new Font(Font.FontFamily.UNDEFINED, 7, Font.BOLD);
            fuente.setSize(8);
            fuente2.setSize(7);

            //documento.add(img);
            Paragraph titulo = new Paragraph(idioma.getProperty("ReciboCompraCafe"), fuente);
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);

            Paragraph infoSociedad = new Paragraph(razonsocial + "      " + direccionSociedad + "      " + idioma.getProperty("Localidad") + " " + localidadSociedad + "        " + idioma.getProperty("Estado") + " " + estadoSociedad, fuente2);
            infoSociedad.setAlignment(Element.ALIGN_CENTER);
            documento.add(infoSociedad);

            Paragraph infoRecibo = new Paragraph(idioma.getProperty("Fecha") + " " + fechaRecibo + " - Fecha Manual " + fechaManual + "                                      " + idioma.getProperty("FolioManual") + " " + folioManual + "                                       " + idioma.getProperty("Folio") + " " + id, fuente2);
            infoRecibo.setAlignment(Element.ALIGN_CENTER);
            documento.add(infoRecibo);

            Paragraph bla = new Paragraph("-", fuente2);
            documento.add(bla);

            documento.add(tablaProdParc(nombreProductor, claveProd, localidadProd, nombrecorto, nombrePar, clavePar, localidadPar, certPar));

            //documento.add(bla);
            documento.add(tablaRecibo(verdes, precioBrutoKgSociedad, inmaduros, precioNetoKgSociedad,
                    brocados, totalBruto, formaCafe, retencion, sacos, total, calificacion, kgRecibidos));

            Paragraph observa = new Paragraph(observaciones, fuente2);
            documento.add(observa);

            //documento.add(bla);
            documento.add(tablaFirmasRecibo(personaRecibio, pEntrego, nombreProductor));

            Paragraph division = new Paragraph("------------------------------------------------------------------------------------------------------------------", fuente2);
            division.setAlignment(Element.ALIGN_JUSTIFIED_ALL);
            documento.add(division);

            // ----------------------------------------------------------------------------------------------------------------------
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);

            infoSociedad.setAlignment(Element.ALIGN_CENTER);
            documento.add(infoSociedad);

            infoRecibo.setAlignment(Element.ALIGN_CENTER);
            documento.add(infoRecibo);

            documento.add(bla);

            documento.add(tablaProdParc(nombreProductor, claveProd, localidadProd, nombrecorto, nombrePar, clavePar, localidadPar, certPar));

            //documento.add(bla);
            documento.add(tablaRecibo(verdes, precioBrutoKgSociedad, inmaduros, precioNetoKgSociedad,
                    brocados, totalBruto, formaCafe, retencion, sacos, total, calificacion, kgRecibidos));

            documento.add(observa);

            //documento.add(bla);
            documento.add(tablaFirmasRecibo(personaRecibio, pEntrego, nombreProductor));

            division.setAlignment(Element.ALIGN_JUSTIFIED_ALL);
            documento.add(division);

            // ----------------------------------------------------------------------------------------------------------------------
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);

            infoSociedad.setAlignment(Element.ALIGN_CENTER);
            documento.add(infoSociedad);

            infoRecibo.setAlignment(Element.ALIGN_CENTER);
            documento.add(infoRecibo);

            documento.add(bla);

            documento.add(tablaProdParc(nombreProductor, claveProd, localidadProd, nombrecorto, nombrePar, clavePar, localidadPar, certPar));

            // documento.add(bla);
            documento.add(tablaRecibo(verdes, precioBrutoKgSociedad, inmaduros, precioNetoKgSociedad,
                    brocados, totalBruto, formaCafe, retencion, sacos, total, calificacion, kgRecibidos));

            documento.add(observa);

            //documento.add(bla);
            documento.add(tablaFirmasRecibo(personaRecibio, pEntrego, nombreProductor));

            division.setAlignment(Element.ALIGN_JUSTIFIED_ALL);
            documento.add(division);
            //----------------------------------------------------------------------------------------------------------------------------

            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);

            infoSociedad.setAlignment(Element.ALIGN_CENTER);
            documento.add(infoSociedad);

            infoRecibo.setAlignment(Element.ALIGN_CENTER);
            documento.add(infoRecibo);

            documento.add(bla);

            documento.add(tablaProdParc(nombreProductor, claveProd, localidadProd, nombrecorto, nombrePar, clavePar, localidadPar, certPar));

            //documento.add(bla);
            documento.add(tablaRecibo(verdes, precioBrutoKgSociedad, inmaduros, precioNetoKgSociedad,
                    brocados, totalBruto, formaCafe, retencion, sacos, total, calificacion, kgRecibidos));

            documento.add(observa);

            //documento.add(bla);
            documento.add(tablaFirmasRecibo(personaRecibio, pEntrego, nombreProductor));

            documento.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    public PdfPTable tablaRecibo(String verdes, String precioBrutoKgSociedad, String inmaduros, String precioNetoKgSociedad,
            String brocados, String totalBruto, String formaCafe, String retencion, String sacos, String total, String calificacion, String kgRecibidos) {

        Font fuente2 = new Font();
        fuente2.setSize(7);

        PdfPTable table = new PdfPTable(2);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);

        table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));

        Paragraph columna1 = new Paragraph(formaCafe + "           " + idioma.getProperty("Calificacion") + " " + calificacion);
        Paragraph columna2 = new Paragraph(idioma.getProperty("Totales"));

        columna1.getFont().setStyle(Font.BOLD);
        columna1.getFont().setSize(7);

        columna2.getFont().setStyle(Font.BOLD);
        columna2.getFont().setSize(7);

        Font fuente3 = new Font();
        fuente3.setSize(7);

        table.addCell(columna1);
        table.addCell(columna2);

        table.setHeaderRows(1);
        table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.setWidthPercentage(100);

        Paragraph dVerdes = new Paragraph(idioma.getProperty("Verdes") + "      " + verdes, fuente3);
        Paragraph dPrecioBrutoCereza = new Paragraph(idioma.getProperty("PrecioBrutoCerezaKg") + "         $" + precioBrutoKgSociedad, fuente3);
        Paragraph dInmaduros = new Paragraph(idioma.getProperty("Inmaduros") + "      " + inmaduros, fuente3);
        Paragraph dPrecioNetoCereza = new Paragraph(idioma.getProperty("PrecioNetoCerezaKg") + "         $" + precioNetoKgSociedad, fuente3);
        Paragraph dBrocados = new Paragraph(idioma.getProperty("Brocados") + "      " + brocados, fuente3);
        Paragraph dtotalBruto = new Paragraph(idioma.getProperty("PrecioBrutoCereza") + "         $" + totalBruto, fuente3);
        Paragraph dFormaCafe = new Paragraph(idioma.getProperty("FormaDeCafe") + "        " + formaCafe, fuente3);
        Paragraph dRetenciones = new Paragraph(idioma.getProperty("Retenciones") + "         $" + retencion, fuente3);
        Paragraph dSacos = new Paragraph(idioma.getProperty("Sacos") + "      " + sacos, fuente3);
        Paragraph dPago = new Paragraph(idioma.getProperty("PagoProductor") + "         $" + total, fuente3);
        Paragraph dCalifica = new Paragraph(idioma.getProperty("Calificacion") + "        " + calificacion, fuente3);
        Paragraph dKg = new Paragraph(idioma.getProperty("KgRecibidos") + "      " + kgRecibidos, fuente3);

        /*table.addCell(dVerdes);
        table.addCell(dFormaCafe);
        table.addCell(dInmaduros);
        table.addCell(dPrecioBrutoCereza);
        table.addCell(dBrocados);
        table.addCell(dPrecioNetoCereza);
        table.addCell(dSacos);
        table.addCell(dtotalBruto);
        table.addCell(dCalifica);
        table.addCell(dRetenciones);
        table.addCell(dKg);
        table.addCell(dPago);*/
        table.addCell(dVerdes);
        table.addCell(dPrecioBrutoCereza);
        table.addCell(dInmaduros);
        table.addCell(dPrecioNetoCereza);
        table.addCell(dBrocados);
        table.addCell(dtotalBruto);
        table.addCell(dSacos);
        table.addCell(dRetenciones);
        table.addCell(dKg);
        table.addCell(dPago);

        return table;

    }

    public PdfPTable tablaProdParc(String prod, String claveProd, String locaProd, String sociedad, String parce,
            String claveParce, String locaParce, String certParce) {
        Font fuente2 = new Font();
        fuente2.setSize(7);

        PdfPTable table = new PdfPTable(2);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

        table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));

        Paragraph columna1 = new Paragraph(idioma.getProperty("Productor") + " " + prod + "    -   " + claveProd);
        Paragraph columna2 = new Paragraph(idioma.getProperty("Parcela") + " " + parce + "    -   " + claveParce);

        columna1.getFont().setStyle(Font.BOLD);
        columna1.getFont().setSize(7);

        columna2.getFont().setStyle(Font.BOLD);
        columna2.getFont().setSize(7);

        table.addCell(columna1);
        table.addCell(columna2);

        table.setHeaderRows(1);
        table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.setWidthPercentage(100);

        Paragraph datosProd = new Paragraph(locaProd, fuente2);
        table.addCell(datosProd);

        Paragraph datosParc = new Paragraph(locaParce + " " + idioma.getProperty("Certificado") + " " + certParce, fuente2);
        table.addCell(datosParc);

        Paragraph datosProd2 = new Paragraph(sociedad, fuente2);
        table.addCell(datosProd2);

        Paragraph datosParc2 = new Paragraph(idioma.getProperty("Certificado") + " " + certParce, fuente2);
        table.addCell(datosParc2);

        return table;
    }

    /* public void pdfBoletaEntradaBH(String idBoleta, Object[][] contenido) throws FileNotFoundException, DocumentException, SQLException {

        String[] datos = mdb.devolverLineaDatos("SELECT\n"
                + "    b.idBoletaManual,\n"
                + "    r.idRecepcion,\n"
                + "    IF(\n"
                + "        b.tipoLugar = 'B',\n"
                + "        bh.nombre,\n"
                + "        al.nombreAlmacen\n"
                + "    ),\n"
                + "    b.fecha,\n"
                + "    b.totalSacos,\n"
                + "    b.totalKg,\n"
                + "    b.transporteLimpio,\n"
                + "    b.descripcion,\n"
                + "    v.Nombre,\n"
                + "    v.Placas,\n"
                + "    v.Responsable,\n"
                + "    pm.RazonSocial,\n"
                + "    pm.Telefono,\n"
                + "    pm.Direccion,\n"
                + "    l.Descripcion,\n"
                + "    ec.Descripcion,\n"
                + "    CONCAT(pf.Nombre,' ',pf.ApellidoPaterno,' ',pf.ApellidoMaterno)\n"
                + "FROM\n"
                + "    boletasalidareceptor b\n"
                + "LEFT JOIN vehiculo v ON\n"
                + "    (b.idTransporte = v.ID)\n"
                + "LEFT JOIN recepciones r ON\n"
                + "    (r.id = b.origen)\n"
                + "LEFT JOIN beneficioshumedos bh ON\n"
                + "    (bh.id = b.destino)\n"
                + "LEFT JOIN almacenes al ON\n"
                + "    (al.id = b.destino)\n"
                + "LEFT JOIN personam pm ON\n"
                + "    (b.idSociedad = pm.ID)\n"
                + "LEFT JOIN ejidocolonia ec ON\n"
                + "    (pm.ID_EjidoColonia = ec.ID)\n"
                + "LEFT JOIN localidad l ON\n"
                + "    (pm.ID_Localidad = l.ID)\n"
                + "LEFT JOIN personaf pf ON\n"
                + "    (pf.ID = r.idResponsable)\n"
                + "WHERE\n"
                + "    b.idBoleta = '" + idBoleta + "'\n"
                + "GROUP BY\n"
                + "    b.idBoleta", 17).split("¬");

        String boletaManual = datos[0];
        String origen = datos[1];
        String destino = datos[2];
        String fecha = datos[3];
        String totalSacos = datos[4];
        String totalKg = datos[5];
        String transporteLimpio = datos[6];
        String observaciones = datos[7];
        String vehiculo = datos[8];
        String placas = datos[9];
        String responsableAuto = datos[10];
        String razonsocial = datos[11];
        String tel = datos[12];
        String direccion = datos[13];
        String localidad = datos[14];
        String colonia = datos[15];
        String encargado = datos[16];

        Document documento = new Document(PageSize.LETTER);

        FileOutputStream ficheroPdf = new FileOutputStream("C:\\fincalab\\pruebaBoleta.pdf");
        PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);

        documento.open();

        Font fuente = new Font();
        Font fuente2 = new Font();
        fuente.setSize(12);
        fuente2.setSize(9);

        Paragraph titulo = new Paragraph(razonsocial, fuente);
        titulo.setAlignment(Element.ALIGN_CENTER);
        documento.add(titulo);

        Paragraph ubicacion = new Paragraph(direccion + " " + localidad + ", " + colonia, fuente2);
        ubicacion.setAlignment(Element.ALIGN_CENTER);
        documento.add(ubicacion);

        Paragraph telefono = new Paragraph(idioma.getProperty("Telefono") + " " + tel, fuente2);
        telefono.setAlignment(Element.ALIGN_CENTER);
        documento.add(telefono);

        Paragraph horarioBoleta = new Paragraph(idioma.getProperty("Fecha") + " " + fecha, fuente2);
        horarioBoleta.setAlignment(Element.ALIGN_RIGHT);
        documento.add(horarioBoleta);

        Paragraph idRecep = new Paragraph(idioma.getProperty("Recepcion"), fuente2);
        idRecep.setAlignment(Element.ALIGN_CENTER);
        documento.add(idRecep);

        Paragraph idBoletaM = new Paragraph(idioma.getProperty("BoletaManual") + " " + boletaManual + "                            " + idioma.getProperty("NoBoleta") + " " + idBoleta + "\n\n", fuente2);
        idBoletaM.setAlignment(Element.ALIGN_CENTER);
        documento.add(idBoletaM);

        Paragraph origenDestino = new Paragraph(idioma.getProperty("Origen") + " " + origen + "\n" + idioma.getProperty("Destino") + " " + destino, fuente2);
        origenDestino.setAlignment(Element.ALIGN_LEFT);
        documento.add(origenDestino);

        documento.add(new Paragraph("\n"));

        documento.add(tablaBoletaSalida(contenido, totalSacos, totalKg));

        documento.add(new Paragraph("\n"));
        documento.add(new Paragraph("\n"));

        Paragraph datosVehiculo
                = new Paragraph(idioma.getProperty("Transporte") + " " + vehiculo + "\n" + idioma.getProperty("Placas") + " " + placas + "\n" + idioma.getProperty("Responsable") + " " + responsableAuto, fuente2);
        datosVehiculo.setAlignment(Element.ALIGN_LEFT);
        documento.add(datosVehiculo);

        String leyendalimpio = "";
        if (transporteLimpio.equals("1")) {
            //JOptionPane.showMessageDialog(null,"Transporte Limpio");
            leyendalimpio = idioma.getProperty("TransporteLimpio") + ": ✓";
        } else {
            // JOptionPane.showMessageDialog(null,"Transporte Sucio");
            leyendalimpio = idioma.getProperty("TransporteLimpio") + ": ✖";
        }

        Paragraph transporteL = new Paragraph(leyendalimpio + "\n\n", fuente2);
        transporteL.setAlignment(Element.ALIGN_LEFT);
        documento.add(transporteL);

        Paragraph observa = new Paragraph(idioma.getProperty("Observaciones") + "\n" + observaciones, fuente2);
        observa.setAlignment(Element.ALIGN_LEFT);
        documento.add(observa);

        documento.add(new Paragraph("\n"));
        documento.add(new Paragraph("\n"));
        documento.add(new Paragraph("\n"));

        documento.add(tablaFirmas(responsableAuto, encargado));

        documento.close();
    }*/
    //REPORTE DE RASTREO BH
    //REPORTE DE PRUEBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    public void pdfReporteBH(String idSubLoteConsecutivo) throws FileNotFoundException, DocumentException {

        Document documento = new Document(PageSize.A4.rotate());

        FileOutputStream ficheroPdf = new FileOutputStream("C:\\fincalab\\reporteBH.pdf");
        PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);

        documento.open();

        Font fuente = new Font();
        //Font fuente2 = new Font(Font.ARIAL,10,Font.BOLD );
        fuente.setSize(10);
        fuente.setStyle(Font.BOLD);
        //fuente2.setSize(9);

        Paragraph GTN = new Paragraph("GRUPO TERRUÑO NAYARITA, S. DE R.L. DE C.V.", fuente);
        GTN.setAlignment(Element.ALIGN_CENTER);
        documento.add(GTN);

        Paragraph titulo = new Paragraph("Reporte de Beneficio Humedo");
        titulo.setAlignment(Element.ALIGN_CENTER);
        documento.add(titulo);

        documento.add(new Paragraph("\n"));

        Paragraph sociedad
                = new Paragraph("Sociedad Responsable: Procca                      Cosecha: AC                      Beneficio: Patios Rustico", fuente);
        sociedad.setAlignment(Element.ALIGN_CENTER);
        documento.add(sociedad);

        documento.add(new Paragraph("\n"));

        String[] datos = mdb.devolverLineaDatos("SELECT\n"
                + "    s.idSubLote,\n"
                + "    s.formaFinal,\n"
                + "    s.procesoFinal,\n"
                + "    s.estadoFinal,\n"
                + "    s.costalesFinales,\n"
                + "    s.kilosFinales,\n"
                + "    s.humedad,\n"
                + "    m.tomadaPor,\n"
                + "    m.tomademuestra,\n"
                + "    m.beneficio\n"
                + "FROM\n"
                + "    sublotesconfirmados s\n"
                + "LEFT JOIN muestrasenviadas m ON\n"
                + "    (S.idSubLote = M.idlote)\n"
                + "WHERE\n"
                + "    s.id = 5", 10).split("¬");

        String idSublote = datos[0];
        String formaFinal = datos[1];
        String procesoFinal = datos[2];
        String estadoFinal = datos[3];
        String costales = datos[4];
        String kilos = datos[5];
        String humedad = datos[6];
        String tomadaPor = datos[7];
        String fechaToma = datos[8];
        String beneficio = datos[9];

        documento.add(tablaLoteFinal(idSublote, formaFinal, procesoFinal, estadoFinal, costales, kilos, humedad, tomadaPor, fechaToma, beneficio));

        documento.close();

    }

    public PdfPTable tablaLoteFinal(String idSublote, String formaFinal, String procesoFinal,
            String estadoFinal, String costales, String kilos, String humedad,
            String tomadaPor, String fechaToma, String beneficio) {
        Font fuente2 = new Font();
        fuente2.setSize(7);

        PdfPTable table = new PdfPTable(2);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

        table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));

        Paragraph columna1 = new Paragraph("Datos Generales de Lote Final ");
        Paragraph columna2 = new Paragraph("Numero de Lote - " + idSublote);

        columna1.getFont().setStyle(Font.BOLD);
        columna1.getFont().setSize(8);

        columna2.getFont().setStyle(Font.BOLD);
        columna2.getFont().setSize(8);

        table.addCell(columna1);
        table.addCell(columna2);

        table.setHeaderRows(1);
        table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.setWidthPercentage(100);

        Paragraph datosProd = new Paragraph("Forma " + formaFinal + "              Proceso " + procesoFinal, fuente2);
        table.addCell(datosProd);

        Paragraph datosParc = new Paragraph("Estado " + estadoFinal + "                Rendimiento 19.55%", fuente2);
        table.addCell(datosParc);

        Paragraph datosProd2 = new Paragraph("Sacos: " + costales + "                       Kilos: " + kilos, fuente2);
        table.addCell(datosProd2);

        Paragraph datosParc2 = new Paragraph("Humedad " + humedad + "             Beneficio " + beneficio, fuente2);
        table.addCell(datosParc2);

        Paragraph datosToma = new Paragraph("Tomada Por: " + tomadaPor, fuente2);
        table.addCell(datosToma);

        Paragraph datosToma2 = new Paragraph("Fecha Muestra " + fechaToma, fuente2);
        table.addCell(datosToma2);

        return table;
    }
    
    
    
    
    /********************* BOLETA SALIDA BH ************************/
    
     public void pdfBoletaSalidaBH(String idBoleta, Object[][] contenido, String observaciones)
            throws FileNotFoundException, DocumentException, SQLException {

        //JOptionPane.showMessageDialog(null, "Estoy en pfg boleta bh");
        String[] datos = mdb.devolverLineaDatos("SELECT\n"
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
                + "    be.costalesRecibidos,\n"
                + "    pm.NombreCorto,\n"
                + "    pm.razonsocial,\n"
                + "    bh.telefono,\n"
                + "    bh.domicilio,\n"
                + "    l.Descripcion,\n"
                + "    r.idRecepcion,\n"
                + "    bh.nombre \n"
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
                + "LEFT JOIN personam pm ON\n"
                + "    (pm.ID = bh.idSociedad)\n"
                + "LEFT JOIN localidad l ON\n"
                + "    (bh.idLocalidad = l.ID)\n"
                + "WHERE\n"
                + "    be.idBoleta = '" + idBoleta + "'\n"
                + "GROUP BY\n"
                + "    be.idBoleta", 27).split("¬");

        JOptionPane.showMessageDialog(null, datos);

        String nombreRecepcion = datos[0];
        String nombreBeneficio = datos[1];
        String totalSacos = datos[6];
        String totalKilos = datos[7];
        String vehiculo = datos[10];
        String placas = datos[11];
        String transportista = datos[12];
        String fechaEntrada = datos[17];
        String kgRecibidos = datos[18];
        String costalesRecibidos = datos[19];
        String sociedad = datos[20];
        String razonSocial = datos[21];
        String telefono = datos[22];
        String domicilio = datos[23];
        String localidad = datos[24];
        String idRecepcion = datos[25];
        String idBeneficio = datos[26];

        String capturista = mdb.devuelveUnDato("select CONCAT(pf.Nombre,' ',pf.ApellidoPaterno,' ',pf.ApellidoMaterno) \n"
                + "from beneficioshumedos b\n"
                + "left join personaf pf on(pf.ID=b.idPersonaCapturista)\n"
                + "where b.nombre='" + idBeneficio + "'");

        String encargado = mdb.devuelveUnDato("select CONCAT(pf2.Nombre,' ',pf2.ApellidoPaterno,' ',pf2.ApellidoMaterno) \n"
                + "from beneficioshumedos b\n"
                + "left join personaf pf2 on(pf2.ID=b.idPersonaEncargada)\n"
                + "where b.nombre='" + idBeneficio + "' ");

        Document documento = new Document(PageSize.LETTER);

        FileOutputStream ficheroPdf = new FileOutputStream("C:\\fincalab\\pruebaBoleta.pdf");
        PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);

        documento.open();

        Font fuente = new Font();
        Font fuente2 = new Font();
        Font fuente3 = new Font();
        fuente.setSize(12);
        fuente2.setSize(9);
        fuente3.setSize(7);

        Paragraph titulo = new Paragraph(razonSocial, fuente);
        titulo.setAlignment(Element.ALIGN_CENTER);
        documento.add(titulo);

        Paragraph ubicacion = new Paragraph(domicilio + " " + localidad, fuente2);
        ubicacion.setAlignment(Element.ALIGN_CENTER);
        documento.add(ubicacion);

        Paragraph tel = new Paragraph(idioma.getProperty("Telefono") + " " + telefono, fuente2);
        tel.setAlignment(Element.ALIGN_CENTER);
        documento.add(tel);

        Paragraph horarioBoleta = new Paragraph(idioma.getProperty("Fecha") + " " + fechaEntrada, fuente2);
        horarioBoleta.setAlignment(Element.ALIGN_RIGHT);
        documento.add(horarioBoleta);

        Paragraph idRecep = new Paragraph("Beneficio Humedo", fuente2);
        idRecep.setAlignment(Element.ALIGN_CENTER);
        documento.add(idRecep);

        Paragraph numBoleta = new Paragraph(idBoleta, fuente2);
        numBoleta.setAlignment(Element.ALIGN_CENTER);
        documento.add(numBoleta);

        Paragraph origenDestino = new Paragraph(idioma.getProperty("Origen") + " / " + nombreRecepcion + " " + idRecepcion + "\n" + idioma.getProperty("Destino") + " " + nombreBeneficio + " / " + idBeneficio, fuente2);
        origenDestino.setAlignment(Element.ALIGN_LEFT);
        documento.add(origenDestino);

        documento.add(new Paragraph("\n"));
        documento.add(tablaBoletaEntradaBH(contenido, totalSacos, totalKilos));
        documento.add(new Paragraph("\n"));

        documento.add(tablaObservaciones(observaciones));

        documento.add(new Paragraph("\n"));

        documento.add(tablaTransporteSalida(vehiculo, placas, transportista, ""));

        documento.add(new Paragraph("\n"));

        documento.add(tablaFirmasBH(transportista, capturista, encargado));

        documento.close();
    }

}
