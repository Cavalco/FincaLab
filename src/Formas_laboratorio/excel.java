/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_laboratorio;

import Conexion.Conexion;
import Metodos_Configuraciones.metodosLaboratorio;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import Idioma.Propiedades;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author
 */
public class excel {

    metodosLaboratorio mdb;
    Connection cn;
    Propiedades idioma;
    String Idioma;

    public void datos(Connection cn, String id, String idb, String taza, String Idioma) throws IOException {

        //try {
            //JOptionPane.showMessageDialog(null,"CSM "+id+ " - "+idb);
            this.cn = cn;
            this.Idioma = Idioma;
            mdb = new metodosLaboratorio(cn, Idioma);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMMdHHmm");
            Date date = new Date(System.currentTimeMillis());
            System.out.println(formatter.format(date));
            String nombre = "ReporteIndividual" + id + formatter.format(date);
            String[] datos = mdb.devuelveUnRow("select "
                    + "b.id_muestra," //0
                    + "b.fecha_llegada," //1
                    + "b.tomadapor," //2
                    + "b.fechalote,"//3
                    + "b.tipocafe," //4
                    + "b.forma," //5
                    + "b.peso," //6
                    + "b.sacos," //7
                    + "b.beneficio," //8
                    + "b.certificado," //9
                    + "b.dueño," //10
                    + "b.predio," //11
                    + "b.comunidad," //12
                    + "b.calidadcereza," //13
                    + "d.PesoEv," //14
                    + "d.humedad_c," //15
                    + "d.humedad_o," //16
                    + "b.Metodosecado," //17
                    + "d.uniformidad," //18
                    + "d.color," //19
                    + "c.numerotazas," //20
                    + "d.fecha," //21
                    + "d.evaluador," //22
                    + "c.fecha," //23
                    + "c.catadornom," //24
                    + "c.flavor," //25
                    + "c.acidity," //26
                    + "c.balance," //27
                    + "c.niveltostado," //28
                    + "c.intensidadacidit," //29
                    + "c.uniformidadtaza," //30
                    + "c.catador," //31
                    + "c.dry," //32
                    + "c.wet," //33
                    + "c.aftertaste," //34
                    + "c.body," //35
                    + "c.tazalimpia," //36
                    + "c.break," //37
                    + "c.quakers," //38
                    + "c.numtazasdefect," //39
                    + "c.uniformidadtostado," //40
                    + "c.intensidadbody," //41
                    + "c.dulzor," //42
                    + "c.intensidaddef " //43
                    + "from  bitacoralab b left join   datosev d on b.id_bitacora=d.id_bitacora left join \n"
                    + " catacion c on b.id_bitacora=c.id_bitacora where b.id_bitacora= " + idb + ";", 44).split(",");//1
            String[] datos2 = mdb.devuelveUnDato("SELECT datos FROM cribas where id_bitacora=" + idb + " and criba=19;").split(",");
            String[] datos3 = mdb.devuelveUnDato("SELECT datos FROM cribas where id_bitacora=" + idb + " and criba=18;").split(",");
            String[] datos4 = mdb.devuelveUnDato("SELECT datos FROM cribas where id_bitacora=" + idb + " and criba=17;").split(",");
            String[] datos5 = mdb.devuelveUnDato("SELECT datos FROM cribas where id_bitacora=" + idb + " and criba=16;").split(",");
            String[] datos6 = mdb.devuelveUnDato("SELECT datos FROM cribas where id_bitacora=" + idb + " and criba=15;").split(",");
            String[] datos7 = mdb.devuelveUnDato("SELECT datos FROM cribas where id_bitacora=" + idb + " and criba='F';").split(",");

            String[] datos8, datos9;
            datos8 = mdb.devuelveUnDato("select sabores from bitacoralab where id_bitacora=" + idb + ";").split(",");
            datos9 = mdb.devuelveUnDato("select olores from bitacoralab where id_bitacora=" + idb + ";").split(",");

            String[] sabor = datos8[0].split(":");
            String[] saborRemanente = datos8[1].split(":");
            String[] acidez = datos8[2].split(":");

            String[] seco = datos9[0].split(":");
            String[] mojado = datos9[1].split(":");
            String[] quebrado = datos9[2].split(":");

            //JOptionPane.showMessageDialog(null, sabor[1]+" "+saborRemanente[1]+" "+acidez[1]);
            XSSFWorkbook my_xlsx_workbook;

//obtener el nombre y la ruta del archivo a modificar
            FileInputStream input_document = new FileInputStream(new File("C:\\fincalab\\reporteLaboratorio.xlsx"));
            //acceso al libro
            my_xlsx_workbook = new XSSFWorkbook(input_document);
            //Acceso a la hoja del libro a modificar 
            XSSFSheet my_worksheet = my_xlsx_workbook.getSheetAt(0);

            if (my_worksheet == null) {
                System.out.println("F");
            }//se declaran los celdas en forma de objeto
            Cell c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, c26, c27, c28, c29, c30,
                    c31, c32, c33, c34, c35, c36, c37, c38, c39, c40, c41, c42, c43, c44, c45, c46, c47, c48, c49, c50, c51, c52, c53, c54, c55, c56, c57, c58, c59, c60, c61, c62, c63, c64, c65, c66, c67, c68, c69, c70, c71, c72, c73, c74, c75, c76, c77, c78, c79, c80, c81, c82, c83, c84, c85, c86, c87, c88, c89, c90,
                    c91, c92, c93, c94, c95, c96, c97, c98, c99, c100, c101, c102, c103, c104, c105, c106, c107, c108, c109, c110, c111, c112, c113, c114, c115, c116, c117, c118, c119, c120,
                    c121, c122, c123, c124, c125, c126, c127, c128, c129, c130, c131, c132, c133, c134, c135, c136, c137, c138, c139, c140, c141, c142, c143, c144, c145, c146, c147, c148, c149, c150,
                    c151, c152, c153, c154, c155, c156, c157, c158, c159, c160, c161, c162, c163, c164, c165, c166, c167, c168, c169, c170, c171, c172, c173, c174, c175, c176, c177, c178, c179, c180,
                    c181, c182, c183, c184, c185, c186, c187;

            //primero se obtiene la celda en forma de coordenadas row es la fila y cell es la columna, se cuenta a partir de 0 
            c1 = my_worksheet.getRow(0).getCell(5);
            if (c1 == null) {//validacion en caso de que no exista celda para que no marque error se crea la celda en caso de que al obtenerla sea nula
                c1 = my_worksheet.getRow(0).createCell(5);
            }
            c1.setCellValue(datos[0]); //se añaden los datos a la celda 
            //el proceso se repite por cada celda en especifico por sus coordenadas
            c2 = my_worksheet.getRow(1).getCell(5);
            if (c2 == null) {
                c2 = my_worksheet.getRow(1).createCell(5);
            }
            c2.setCellValue(datos[1]);

            c3 = my_worksheet.getRow(2).getCell(5);
            if (c3 == null) {
                c3 = my_worksheet.getRow(2).createCell(5);
            }
            c3.setCellValue(datos[2]);

            c4 = my_worksheet.getRow(3).getCell(5);
            if (c4 == null) {
                c4 = my_worksheet.getRow(3).createCell(5);
            }
            c4.setCellValue(datos[3]);

            c5 = my_worksheet.getRow(4).getCell(5);
            if (c5 == null) {
                c5 = my_worksheet.getRow(4).createCell(5);
            }
            c5.setCellValue(datos[4]);

            c6 = my_worksheet.getRow(5).getCell(5);
            if (c6 == null) {
                c6 = my_worksheet.getRow(5).createCell(5);
            }
            c6.setCellValue(datos[5]);

            c7 = my_worksheet.getRow(6).getCell(5);
            if (c7 == null) {
                c7 = my_worksheet.getRow(6).createCell(5);
            }
            c7.setCellValue(datos[6]);

            c8 = my_worksheet.getRow(7).getCell(5);
            if (c8 == null) {
                c8 = my_worksheet.getRow(7).createCell(5);
            }
            c8.setCellValue(datos[7]);

            c9 = my_worksheet.getRow(8).getCell(5);
            if (c9 == null) {
                c9 = my_worksheet.getRow(8).createCell(5);
            }
            c9.setCellValue(datos[8]);

            c10 = my_worksheet.getRow(10).getCell(5);
            if (c10 == null) {
                c10 = my_worksheet.getRow(10).createCell(5);
            }
            c10.setCellValue(datos[9]);

            c11 = my_worksheet.getRow(0).getCell(11);
            if (c11 == null) {
                c11 = my_worksheet.getRow(0).createCell(11);
            }
            c11.setCellValue(datos[10]);

            c12 = my_worksheet.getRow(1).getCell(11);
            if (c12 == null) {
                c12 = my_worksheet.getRow(1).createCell(11);
            }
            c12.setCellValue(datos[11]);

            c13 = my_worksheet.getRow(2).getCell(11);
            if (c13 == null) {
                c13 = my_worksheet.getRow(2).createCell(11);
            }
            c13.setCellValue(datos[12]);

            c14 = my_worksheet.getRow(3).getCell(11);
            if (c14 == null) {
                c14 = my_worksheet.getRow(3).createCell(11);
            }
            c14.setCellValue(datos[13]);

            c15 = my_worksheet.getRow(4).getCell(11);
            if (c15 == null) {
                c15 = my_worksheet.getRow(4).createCell(11);
            }
            c15.setCellValue(datos[14]);

            c16 = my_worksheet.getRow(5).getCell(11);
            if (c16 == null) {
                c16 = my_worksheet.getRow(5).createCell(11);
            }
            c16.setCellValue(datos[15]);

            c17 = my_worksheet.getRow(6).getCell(11);
            if (c17 == null) {
                c17 = my_worksheet.getRow(6).createCell(11);
            }
            c17.setCellValue(datos[17]);

            c18 = my_worksheet.getRow(5).getCell(12);
            if (c18 == null) {
                c18 = my_worksheet.getRow(5).createCell(12);
            }
            c18.setCellValue(datos[16]);

            c19 = my_worksheet.getRow(8).getCell(11);
            if (c19 == null) {
                c19 = my_worksheet.getRow(8).createCell(11);
            }
            c19.setCellValue(datos[18]);

            c20 = my_worksheet.getRow(9).getCell(11);
            if (c20 == null) {
                c20 = my_worksheet.getRow(9).createCell(11);
            }
            c20.setCellValue(datos[19]);

            c21 = my_worksheet.getRow(10).getCell(14);
            if (c21 == null) {
                c21 = my_worksheet.getRow(10).createCell(14);
            }
            c21.setCellValue(Integer.parseInt(datos[20]));

            c22 = my_worksheet.getRow(6).getCell(19);
            if (c22 == null) {
                c22 = my_worksheet.getRow(6).createCell(19);
            }
            c22.setCellValue(datos[21]);

            c23 = my_worksheet.getRow(7).getCell(19);
            if (c23 == null) {
                c23 = my_worksheet.getRow(7).createCell(19);
            }
            c23.setCellValue(datos[22]);

            c24 = my_worksheet.getRow(9).getCell(19);
            if (c24 == null) {
                c24 = my_worksheet.getRow(9).createCell(19);
            }
            c24.setCellValue(datos[23]);

            c25 = my_worksheet.getRow(10).getCell(19);
            if (c25 == null) {
                c25 = my_worksheet.getRow(10).createCell(19);
            }
            c25.setCellValue(datos[24]);

            c26 = my_worksheet.getRow(12).getCell(9);
            if (c26 == null) {
                c26 = my_worksheet.getRow(12).createCell(9);
            }
            c26.setCellValue(Double.parseDouble(datos[25]));

            c27 = my_worksheet.getRow(12).getCell(15);
            if (c27 == null) {
                c27 = my_worksheet.getRow(12).createCell(15);
            }
            c27.setCellValue(Double.parseDouble(datos[26]));

            c28 = my_worksheet.getRow(12).getCell(21);
            if (c28 == null) {
                c28 = my_worksheet.getRow(12).createCell(21);
            }
            c28.setCellValue(Double.parseDouble(datos[27]));

            c29 = my_worksheet.getRow(14).getCell(1);
            if (c29 == null) {
                c29 = my_worksheet.getRow(14).createCell(1);
            }
            c29.setCellValue(Double.parseDouble(datos[28]));

            c30 = my_worksheet.getRow(14).getCell(16);
            if (c30 == null) {
                c30 = my_worksheet.getRow(14).createCell(16);
            }
            c30.setCellValue(Double.parseDouble(datos[29]));

            c31 = my_worksheet.getRow(14).getCell(21);
            if (c31 == null) {
                c31 = my_worksheet.getRow(14).createCell(21);
            }
            c31.setCellValue(Double.parseDouble(datos[30]));

            c32 = my_worksheet.getRow(14).getCell(26);
            if (c32 == null) {
                c32 = my_worksheet.getRow(14).createCell(26);
            }
            c32.setCellValue(Double.parseDouble(datos[31]));

            c33 = my_worksheet.getRow(15).getCell(3);
            if (c33 == null) {
                c33 = my_worksheet.getRow(15).createCell(3);
            }
            c33.setCellValue(Double.parseDouble(datos[32]));

            c34 = my_worksheet.getRow(15).getCell(5);
            if (c34 == null) {
                c34 = my_worksheet.getRow(15).createCell(5);
            }
            c34.setCellValue(Double.parseDouble(datos[33]));

            c35 = my_worksheet.getRow(15).getCell(9);
            if (c35 == null) {
                c35 = my_worksheet.getRow(15).createCell(9);
            }
            c35.setCellValue(Double.parseDouble(datos[34]));

            c36 = my_worksheet.getRow(16).getCell(15);
            if (c36 == null) {
                c36 = my_worksheet.getRow(16).createCell(15);
            }
            c36.setCellValue(Double.parseDouble(datos[35]));

            c37 = my_worksheet.getRow(16).getCell(21);
            if (c37 == null) {
                c37 = my_worksheet.getRow(16).createCell(21);
            }
            c37.setCellValue(Double.parseDouble(datos[36]));

            c38 = my_worksheet.getRow(17).getCell(4);
            if (c38 == null) {
                c38 = my_worksheet.getRow(17).createCell(4);
            }
            c38.setCellValue(Double.parseDouble(datos[37]));

            c39 = my_worksheet.getRow(17).getCell(11);
            if (c39 == null) {
                c39 = my_worksheet.getRow(17).createCell(11);
            }
            c39.setCellValue(Double.parseDouble(datos[38]));
            c40 = my_worksheet.getRow(17).getCell(26);
            if (c40 == null) {
                c40 = my_worksheet.getRow(17).createCell(26);
            }
            c40.setCellValue(Double.parseDouble(datos[39]));

            c41 = my_worksheet.getRow(18).getCell(11);
            if (c41 == null) {
                c41 = my_worksheet.getRow(18).createCell(11);
            }
            c41.setCellValue(Double.parseDouble(datos[40]));

            c42 = my_worksheet.getRow(18).getCell(16);
            if (c42 == null) {
                c42 = my_worksheet.getRow(18).createCell(16);
            }
            c42.setCellValue(Double.parseDouble(datos[41]));

            c43 = my_worksheet.getRow(18).getCell(21);
            if (c43 == null) {
                c43 = my_worksheet.getRow(18).createCell(21);
            }
            c43.setCellValue(Double.parseDouble(datos[42]));

            c44 = my_worksheet.getRow(18).getCell(26);
            if (c44 == null) {
                c44 = my_worksheet.getRow(18).createCell(26);
            }
            c44.setCellValue(Double.parseDouble(datos[43]));

            //cribas 19
            c45 = my_worksheet.getRow(23).getCell(2);
            if (c45 == null) {
                c45 = my_worksheet.getRow(23).createCell(2);
            }
            c45.setCellValue(Integer.parseInt(datos2[0]));

//        );
            //Cell suma = my_worksheet.getRow(22).getCell(2);
            //suma.setCellFormula(String.format("SUMA(C24:C29)"));
            c46 = my_worksheet.getRow(23).getCell(7);
            if (c46 == null) {
                c46 = my_worksheet.getRow(23).createCell(7);
            }
            c46.setCellValue(Integer.parseInt(datos2[1]));

            c47 = my_worksheet.getRow(23).getCell(8);
            /* if (c47 == null) {
            c47 = my_worksheet.getRow(23).createCell(8);
        }*/
            c47.setCellValue(Integer.parseInt(datos2[2]));

            c48 = my_worksheet.getRow(23).getCell(9);
            if (c48 == null) {
                c48 = my_worksheet.getRow(23).createCell(9);
            }
            c48.setCellValue(Integer.parseInt(datos2[3]));

            c49 = my_worksheet.getRow(23).getCell(10);
            if (c49 == null) {
                c49 = my_worksheet.getRow(23).createCell(10);
            }
            c49.setCellValue(Integer.parseInt(datos2[4]));

            c50 = my_worksheet.getRow(23).getCell(11);
            if (c50 == null) {
                c50 = my_worksheet.getRow(23).createCell(11);
            }
            c50.setCellValue(Integer.parseInt(datos2[5]));

            c51 = my_worksheet.getRow(23).getCell(12);
            if (c51 == null) {
                c51 = my_worksheet.getRow(23).createCell(12);
            }
            c51.setCellValue(Integer.parseInt(datos2[6]));

            c52 = my_worksheet.getRow(23).getCell(13);
            if (c52 == null) {
                c52 = my_worksheet.getRow(23).createCell(13);
            }
            c52.setCellValue(Integer.parseInt(datos2[7]));

            c53 = my_worksheet.getRow(23).getCell(14);
            if (c53 == null) {
                c53 = my_worksheet.getRow(23).createCell(14);
            }
            c53.setCellValue(Integer.parseInt(datos2[8]));

            c54 = my_worksheet.getRow(23).getCell(15);
            if (c54 == null) {
                c54 = my_worksheet.getRow(23).createCell(15);
            }
            c54.setCellValue(Integer.parseInt(datos2[9]));

            c55 = my_worksheet.getRow(23).getCell(16);
            if (c55 == null) {
                c55 = my_worksheet.getRow(23).createCell(16);
            }
            c55.setCellValue(Integer.parseInt(datos2[10]));

            c56 = my_worksheet.getRow(23).getCell(17);
            if (c56 == null) {
                c56 = my_worksheet.getRow(23).createCell(17);
            }
            c56.setCellValue(Integer.parseInt(datos2[11]));

            c57 = my_worksheet.getRow(23).getCell(18);
            if (c57 == null) {
                c57 = my_worksheet.getRow(23).createCell(18);
            }
            c57.setCellValue(Integer.parseInt(datos2[12]));

            c58 = my_worksheet.getRow(23).getCell(19);
            if (c58 == null) {
                c58 = my_worksheet.getRow(23).createCell(19);
            }
            c58.setCellValue(Integer.parseInt(datos2[13]));

            c59 = my_worksheet.getRow(23).getCell(20);
            if (c59 == null) {
                c59 = my_worksheet.getRow(23).createCell(20);
            }
            c59.setCellValue(Integer.parseInt(datos2[14]));

            c60 = my_worksheet.getRow(23).getCell(21);
            if (c60 == null) {
                c60 = my_worksheet.getRow(23).createCell(21);
            }
            c60.setCellValue(Integer.parseInt(datos2[15]));

            c61 = my_worksheet.getRow(23).getCell(22);
            if (c61 == null) {
                c61 = my_worksheet.getRow(23).createCell(22);
            }
            c61.setCellValue(Integer.parseInt(datos2[16]));

            c62 = my_worksheet.getRow(23).getCell(23);
            if (c62 == null) {
                c62 = my_worksheet.getRow(23).createCell(23);
            }
            c62.setCellValue(Integer.parseInt(datos2[17]));

            c63 = my_worksheet.getRow(23).getCell(24);
            if (c63 == null) {
                c63 = my_worksheet.getRow(23).createCell(24);
            }
            c63.setCellValue(Integer.parseInt(datos2[18]));

            c64 = my_worksheet.getRow(23).getCell(25);
            if (c64 == null) {
                c64 = my_worksheet.getRow(23).createCell(25);
            }
            c64.setCellValue(Integer.parseInt(datos2[19]));

            c65 = my_worksheet.getRow(23).getCell(26);
            if (c65 == null) {
                c65 = my_worksheet.getRow(23).createCell(26);
            }
            c65.setCellValue(Integer.parseInt(datos2[20]));

            c66 = my_worksheet.getRow(23).getCell(27);
            if (c66 == null) {
                c66 = my_worksheet.getRow(23).createCell(27);
            }
            c66.setCellValue(Integer.parseInt(datos2[21]));

            c67 = my_worksheet.getRow(23).getCell(28);
            if (c67 == null) {
                c67 = my_worksheet.getRow(23).createCell(28);
            }
            c67.setCellValue(Integer.parseInt(datos2[22]));
// criba 18
            c68 = my_worksheet.getRow(24).getCell(2);
            if (c68 == null) {
                c68 = my_worksheet.getRow(24).createCell(2);
            }
            //MODIFICAR DE NUEVO
            c68.setCellValue(Integer.parseInt(datos3[0]));

            c69 = my_worksheet.getRow(24).getCell(7);
            if (c69 == null) {
                c69 = my_worksheet.getRow(24).createCell(7);
            }
            c69.setCellValue(Integer.parseInt(datos3[1]));

            c70 = my_worksheet.getRow(24).getCell(8);
            if (c70 == null) {
                c70 = my_worksheet.getRow(24).createCell(8);
            }
            c70.setCellValue(Integer.parseInt(datos3[2]));

            c71 = my_worksheet.getRow(24).getCell(9);
            if (c71 == null) {
                c71 = my_worksheet.getRow(24).createCell(9);
            }
            c71.setCellValue(Integer.parseInt(datos3[3]));

            c72 = my_worksheet.getRow(24).getCell(10);
            if (c72 == null) {
                c72 = my_worksheet.getRow(24).createCell(10);
            }
            c72.setCellValue(Integer.parseInt(datos3[4]));

            c73 = my_worksheet.getRow(24).getCell(11);
            if (c73 == null) {
                c73 = my_worksheet.getRow(24).createCell(11);
            }
            c73.setCellValue(Integer.parseInt(datos3[5]));

            c74 = my_worksheet.getRow(24).getCell(12);
            if (c74 == null) {
                c74 = my_worksheet.getRow(24).createCell(12);
            }
            c74.setCellValue(Integer.parseInt(datos3[6]));

            c75 = my_worksheet.getRow(24).getCell(13);
            if (c75 == null) {
                c75 = my_worksheet.getRow(24).createCell(13);
            }
            c75.setCellValue(Integer.parseInt(datos3[7]));

            c76 = my_worksheet.getRow(24).getCell(14);
            if (c76 == null) {
                c76 = my_worksheet.getRow(24).createCell(14);
            }
            c76.setCellValue(Integer.parseInt(datos3[8]));

            c77 = my_worksheet.getRow(24).getCell(15);
            if (c77 == null) {
                c77 = my_worksheet.getRow(24).createCell(15);
            }
            c77.setCellValue(Integer.parseInt(datos3[9]));

            c78 = my_worksheet.getRow(24).getCell(16);
            if (c78 == null) {
                c78 = my_worksheet.getRow(24).createCell(16);
            }
            c78.setCellValue(Integer.parseInt(datos3[10]));

            c79 = my_worksheet.getRow(24).getCell(17);
            if (c79 == null) {
                c79 = my_worksheet.getRow(24).createCell(17);
            }
            c79.setCellValue(Integer.parseInt(datos3[11]));

            c80 = my_worksheet.getRow(24).getCell(18);
            if (c80 == null) {
                c80 = my_worksheet.getRow(24).createCell(18);
            }
            c80.setCellValue(Integer.parseInt(datos3[12]));

            c81 = my_worksheet.getRow(24).getCell(19);
            if (c81 == null) {
                c81 = my_worksheet.getRow(24).createCell(19);
            }
            c81.setCellValue(Integer.parseInt(datos3[13]));

            c82 = my_worksheet.getRow(24).getCell(20);
            if (c82 == null) {
                c82 = my_worksheet.getRow(24).createCell(20);
            }
            c82.setCellValue(Integer.parseInt(datos3[14]));

            c83 = my_worksheet.getRow(24).getCell(21);
            if (c83 == null) {
                c83 = my_worksheet.getRow(24).createCell(21);
            }
            c83.setCellValue(Integer.parseInt(datos3[15]));

            c84 = my_worksheet.getRow(24).getCell(22);
            if (c84 == null) {
                c84 = my_worksheet.getRow(24).createCell(22);
            }
            c84.setCellValue(Integer.parseInt(datos3[16]));

            c85 = my_worksheet.getRow(24).getCell(23);
            if (c85 == null) {
                c85 = my_worksheet.getRow(24).createCell(23);
            }
            c85.setCellValue(Integer.parseInt(datos3[17]));

            c86 = my_worksheet.getRow(24).getCell(24);
            if (c86 == null) {
                c86 = my_worksheet.getRow(24).createCell(24);
            }
            c86.setCellValue(Integer.parseInt(datos3[18]));

            c87 = my_worksheet.getRow(24).getCell(25);
            if (c87 == null) {
                c87 = my_worksheet.getRow(24).createCell(25);
            }
            c87.setCellValue(Integer.parseInt(datos3[19]));

            c88 = my_worksheet.getRow(24).getCell(26);
            if (c88 == null) {
                c88 = my_worksheet.getRow(24).createCell(26);
            }
            c88.setCellValue(Integer.parseInt(datos3[20]));

            c89 = my_worksheet.getRow(24).getCell(27);
            if (c89 == null) {
                c89 = my_worksheet.getRow(24).createCell(27);
            }
            c89.setCellValue(Integer.parseInt(datos3[21]));

            c90 = my_worksheet.getRow(24).getCell(28);
            if (c90 == null) {
                c90 = my_worksheet.getRow(24).createCell(28);
            }
            c90.setCellValue(Integer.parseInt(datos3[22]));
            //criba 17
            c91 = my_worksheet.getRow(25).getCell(2);
            if (c91 == null) {
                c91 = my_worksheet.getRow(25).createCell(2);
            } //MODIFICAR DE NUEVO
            c91.setCellValue(Integer.parseInt(datos4[0]));

            c92 = my_worksheet.getRow(25).getCell(7);
            if (c92 == null) {
                c92 = my_worksheet.getRow(25).createCell(7);
            }
            c92.setCellValue(Integer.parseInt(datos4[1]));

            c93 = my_worksheet.getRow(25).getCell(8);
            if (c93 == null) {
                c93 = my_worksheet.getRow(25).createCell(8);
            }
            c93.setCellValue(Integer.parseInt(datos4[2]));

            c94 = my_worksheet.getRow(25).getCell(9);
            if (c94 == null) {
                c94 = my_worksheet.getRow(25).createCell(9);
            }
            c94.setCellValue(Integer.parseInt(datos4[3]));
            c95 = my_worksheet.getRow(25).getCell(10);
            if (c95 == null) {
                c95 = my_worksheet.getRow(25).createCell(10);
            }
            c95.setCellValue(Integer.parseInt(datos4[4]));

            c96 = my_worksheet.getRow(25).getCell(11);
            if (c96 == null) {
                c96 = my_worksheet.getRow(25).createCell(11);
            }
            c96.setCellValue(Integer.parseInt(datos4[5]));

            c97 = my_worksheet.getRow(25).getCell(12);
            if (c97 == null) {
                c97 = my_worksheet.getRow(25).createCell(12);
            }
            c97.setCellValue(Integer.parseInt(datos4[6]));

            c98 = my_worksheet.getRow(25).getCell(13);
            if (c98 == null) {
                c98 = my_worksheet.getRow(25).createCell(13);
            }
            c98.setCellValue(Integer.parseInt(datos4[7]));

            c99 = my_worksheet.getRow(25).getCell(14);
            if (c99 == null) {
                c99 = my_worksheet.getRow(25).createCell(14);
            }
            c99.setCellValue(Integer.parseInt(datos4[8]));

            c100 = my_worksheet.getRow(25).getCell(15);
            if (c100 == null) {
                c100 = my_worksheet.getRow(25).createCell(15);
            }
            c100.setCellValue(Integer.parseInt(datos4[9]));

            c101 = my_worksheet.getRow(25).getCell(16);
            if (c101 == null) {
                c101 = my_worksheet.getRow(25).createCell(16);
            }
            c101.setCellValue(Integer.parseInt(datos4[10]));

            c102 = my_worksheet.getRow(25).getCell(17);
            if (c102 == null) {
                c102 = my_worksheet.getRow(25).createCell(17);
            }
            c102.setCellValue(Integer.parseInt(datos4[11]));

            c103 = my_worksheet.getRow(25).getCell(18);
            if (c103 == null) {
                c103 = my_worksheet.getRow(25).createCell(18);
            }
            c103.setCellValue(Integer.parseInt(datos4[12]));

            c104 = my_worksheet.getRow(25).getCell(19);
            if (c104 == null) {
                c104 = my_worksheet.getRow(25).createCell(19);
            }
            c104.setCellValue(Integer.parseInt(datos4[13]));

            c105 = my_worksheet.getRow(25).getCell(20);
            if (c105 == null) {
                c105 = my_worksheet.getRow(25).createCell(20);
            }
            c105.setCellValue(Integer.parseInt(datos4[14]));

            c106 = my_worksheet.getRow(25).getCell(21);
            if (c106 == null) {
                c106 = my_worksheet.getRow(25).createCell(21);
            }
            c106.setCellValue(Integer.parseInt(datos4[15]));

            c107 = my_worksheet.getRow(25).getCell(22);
            if (c107 == null) {
                c107 = my_worksheet.getRow(25).createCell(22);
            }
            c107.setCellValue(Integer.parseInt(datos4[16]));

            c108 = my_worksheet.getRow(25).getCell(23);
            if (c108 == null) {
                c108 = my_worksheet.getRow(25).createCell(23);
            }
            c108.setCellValue(Integer.parseInt(datos4[17]));

            c109 = my_worksheet.getRow(25).getCell(24);
            if (c109 == null) {
                c109 = my_worksheet.getRow(25).createCell(24);
            }
            c109.setCellValue(Integer.parseInt(datos4[18]));

            c110 = my_worksheet.getRow(25).getCell(25);
            if (c110 == null) {
                c110 = my_worksheet.getRow(25).createCell(25);
            }
            c110.setCellValue(Integer.parseInt(datos4[19]));

            c111 = my_worksheet.getRow(25).getCell(26);
            if (c111 == null) {
                c111 = my_worksheet.getRow(25).createCell(26);
            }
            c111.setCellValue(Integer.parseInt(datos4[20]));

            c112 = my_worksheet.getRow(25).getCell(27);
            if (c112 == null) {
                c112 = my_worksheet.getRow(25).createCell(27);
            }
            c112.setCellValue(Integer.parseInt(datos4[21]));

            c113 = my_worksheet.getRow(25).getCell(28);
            if (c113 == null) {
                c113 = my_worksheet.getRow(25).createCell(28);
            }
            c113.setCellValue(Integer.parseInt(datos4[22]));
            //cribas 16
            c114 = my_worksheet.getRow(26).getCell(2);
            if (c114 == null) {
                c114 = my_worksheet.getRow(26).createCell(2);
            }
            //MODIFICAR DE NUEVO AQUI
            c114.setCellValue(Integer.parseInt(datos5[0]));

            c115 = my_worksheet.getRow(26).getCell(7);
            if (c115 == null) {
                c115 = my_worksheet.getRow(26).createCell(7);
            }
            c115.setCellValue(Integer.parseInt(datos5[1]));

            c116 = my_worksheet.getRow(26).getCell(8);
            if (c116 == null) {
                c116 = my_worksheet.getRow(26).createCell(8);
            }
            c116.setCellValue(Integer.parseInt(datos5[2]));

            c117 = my_worksheet.getRow(26).getCell(9);
            if (c117 == null) {
                c117 = my_worksheet.getRow(26).createCell(9);
            }
            c117.setCellValue(Integer.parseInt(datos5[3]));

            c118 = my_worksheet.getRow(26).getCell(10);
            if (c118 == null) {
                c118 = my_worksheet.getRow(26).createCell(10);
            }
            c118.setCellValue(Integer.parseInt(datos5[4]));

            c119 = my_worksheet.getRow(26).getCell(11);
            if (c119 == null) {
                c119 = my_worksheet.getRow(26).createCell(11);
            }
            c119.setCellValue(Integer.parseInt(datos5[5]));

            c120 = my_worksheet.getRow(26).getCell(12);
            if (c120 == null) {
                c120 = my_worksheet.getRow(26).createCell(12);
            }
            c120.setCellValue(Integer.parseInt(datos5[6]));

            c121 = my_worksheet.getRow(26).getCell(13);
            if (c121 == null) {
                c121 = my_worksheet.getRow(26).createCell(13);
            }
            c121.setCellValue(Integer.parseInt(datos5[7]));

            c122 = my_worksheet.getRow(26).getCell(14);
            if (c122 == null) {
                c122 = my_worksheet.getRow(26).createCell(14);
            }
            c122.setCellValue(Integer.parseInt(datos5[8]));

            c123 = my_worksheet.getRow(26).getCell(15);
            if (c123 == null) {
                c123 = my_worksheet.getRow(26).createCell(15);
            }
            c123.setCellValue(Integer.parseInt(datos5[9]));

            c124 = my_worksheet.getRow(26).getCell(16);
            if (c124 == null) {
                c124 = my_worksheet.getRow(26).createCell(16);
            }
            c124.setCellValue(Integer.parseInt(datos5[10]));

            c125 = my_worksheet.getRow(26).getCell(17);
            if (c125 == null) {
                c125 = my_worksheet.getRow(26).createCell(17);
            }
            c125.setCellValue(Integer.parseInt(datos5[11]));

            c126 = my_worksheet.getRow(26).getCell(18);
            if (c126 == null) {
                c126 = my_worksheet.getRow(26).createCell(18);
            }
            c126.setCellValue(Integer.parseInt(datos5[12]));

            c127 = my_worksheet.getRow(26).getCell(19);
            if (c127 == null) {
                c127 = my_worksheet.getRow(26).createCell(19);
            }
            c127.setCellValue(Integer.parseInt(datos5[13]));

            c128 = my_worksheet.getRow(26).getCell(20);
            if (c128 == null) {
                c128 = my_worksheet.getRow(26).createCell(20);
            }
            c128.setCellValue(Integer.parseInt(datos5[14]));

            c129 = my_worksheet.getRow(26).getCell(21);
            if (c129 == null) {
                c129 = my_worksheet.getRow(26).createCell(21);
            }
            c129.setCellValue(Integer.parseInt(datos5[15]));

            c130 = my_worksheet.getRow(26).getCell(22);
            if (c130 == null) {
                c130 = my_worksheet.getRow(26).createCell(22);
            }
            c130.setCellValue(Integer.parseInt(datos5[16]));

            c131 = my_worksheet.getRow(26).getCell(23);
            if (c131 == null) {
                c131 = my_worksheet.getRow(26).createCell(23);
            }
            c131.setCellValue(Integer.parseInt(datos5[17]));

            c132 = my_worksheet.getRow(26).getCell(24);
            if (c132 == null) {
                c132 = my_worksheet.getRow(26).createCell(24);
            }
            c132.setCellValue(Integer.parseInt(datos5[18]));

            c133 = my_worksheet.getRow(26).getCell(25);
            if (c133 == null) {
                c133 = my_worksheet.getRow(26).createCell(25);
            }
            c133.setCellValue(Integer.parseInt(datos5[19]));

            c134 = my_worksheet.getRow(26).getCell(26);
            if (c134 == null) {
                c134 = my_worksheet.getRow(26).createCell(26);
            }
            c134.setCellValue(Integer.parseInt(datos5[20]));

            c135 = my_worksheet.getRow(26).getCell(27);
            if (c135 == null) {
                c135 = my_worksheet.getRow(26).createCell(27);
            }
            c135.setCellValue(Integer.parseInt(datos5[21]));

            c135 = my_worksheet.getRow(26).getCell(28);
            if (c135 == null) {
                c135 = my_worksheet.getRow(26).createCell(28);
            }
            c135.setCellValue(Integer.parseInt(datos5[22]));
            //cribas 15
            c136 = my_worksheet.getRow(27).getCell(2);
            if (c136 == null) {
                c136 = my_worksheet.getRow(27).createCell(2);
            }
            //MODIFICAR DE NUEVO
            c136.setCellValue(Integer.parseInt(datos6[0]));

            c137 = my_worksheet.getRow(27).getCell(7);
            if (c137 == null) {
                c137 = my_worksheet.getRow(27).createCell(7);
            }
            c137.setCellValue(Integer.parseInt(datos6[1]));

            c138 = my_worksheet.getRow(27).getCell(8);
            if (c138 == null) {
                c138 = my_worksheet.getRow(27).createCell(8);
            }
            c138.setCellValue(Integer.parseInt(datos6[2]));

            c139 = my_worksheet.getRow(27).getCell(9);
            if (c139 == null) {
                c139 = my_worksheet.getRow(27).createCell(9);
            }
            c139.setCellValue(Integer.parseInt(datos6[3]));

            c140 = my_worksheet.getRow(27).getCell(10);
            if (c140 == null) {
                c140 = my_worksheet.getRow(27).createCell(10);
            }
            c140.setCellValue(Integer.parseInt(datos6[4]));

            c141 = my_worksheet.getRow(27).getCell(11);
            if (c141 == null) {
                c141 = my_worksheet.getRow(27).createCell(11);
            }
            c141.setCellValue(Integer.parseInt(datos6[5]));

            c142 = my_worksheet.getRow(27).getCell(12);
            if (c142 == null) {
                c142 = my_worksheet.getRow(27).createCell(12);
            }
            c142.setCellValue(Integer.parseInt(datos6[6]));

            c143 = my_worksheet.getRow(27).getCell(13);
            if (c143 == null) {
                c143 = my_worksheet.getRow(27).createCell(13);
            }
            c143.setCellValue(Integer.parseInt(datos6[7]));

            c144 = my_worksheet.getRow(27).getCell(14);
            if (c144 == null) {
                c144 = my_worksheet.getRow(27).createCell(14);
            }
            c144.setCellValue(Integer.parseInt(datos6[8]));

            c145 = my_worksheet.getRow(27).getCell(15);
            if (c145 == null) {
                c145 = my_worksheet.getRow(27).createCell(15);
            }
            c145.setCellValue(Integer.parseInt(datos6[9]));

            c146 = my_worksheet.getRow(27).getCell(16);
            if (c146 == null) {
                c146 = my_worksheet.getRow(27).createCell(16);
            }
            c146.setCellValue(Integer.parseInt(datos6[10]));

            c147 = my_worksheet.getRow(27).getCell(17);
            if (c147 == null) {
                c147 = my_worksheet.getRow(27).createCell(17);
            }
            c147.setCellValue(Integer.parseInt(datos6[11]));

            c148 = my_worksheet.getRow(27).getCell(18);
            if (c148 == null) {
                c148 = my_worksheet.getRow(27).createCell(18);
            }
            c148.setCellValue(Integer.parseInt(datos6[12]));

            c149 = my_worksheet.getRow(27).getCell(19);
            if (c149 == null) {
                c149 = my_worksheet.getRow(27).createCell(19);
            }
            c149.setCellValue(Integer.parseInt(datos6[13]));

            c150 = my_worksheet.getRow(27).getCell(20);
            if (c150 == null) {
                c150 = my_worksheet.getRow(27).createCell(20);
            }
            c150.setCellValue(Integer.parseInt(datos6[14]));

            c151 = my_worksheet.getRow(27).getCell(21);
            if (c151 == null) {
                c151 = my_worksheet.getRow(27).createCell(21);
            }
            c151.setCellValue(Integer.parseInt(datos6[15]));

            c152 = my_worksheet.getRow(27).getCell(22);
            if (c152 == null) {
                c152 = my_worksheet.getRow(27).createCell(22);
            }
            c152.setCellValue(Integer.parseInt(datos6[16]));

            c153 = my_worksheet.getRow(27).getCell(23);
            if (c153 == null) {
                c153 = my_worksheet.getRow(27).createCell(23);
            }
            c153.setCellValue(Integer.parseInt(datos6[17]));

            c154 = my_worksheet.getRow(27).getCell(24);
            if (c154 == null) {
                c154 = my_worksheet.getRow(27).createCell(24);
            }
            c154.setCellValue(Integer.parseInt(datos6[18]));

            c155 = my_worksheet.getRow(27).getCell(25);
            if (c155 == null) {
                c155 = my_worksheet.getRow(27).createCell(25);
            }
            c155.setCellValue(Integer.parseInt(datos6[19]));

            c156 = my_worksheet.getRow(27).getCell(26);
            if (c156 == null) {
                c156 = my_worksheet.getRow(27).createCell(26);
            }
            c156.setCellValue(Integer.parseInt(datos6[20]));

            c157 = my_worksheet.getRow(27).getCell(27);
            if (c157 == null) {
                c157 = my_worksheet.getRow(27).createCell(27);
            }
            c157.setCellValue(Integer.parseInt(datos6[21]));

            c158 = my_worksheet.getRow(27).getCell(28);
            if (c158 == null) {
                c158 = my_worksheet.getRow(27).createCell(28);
            }
            c158.setCellValue(Integer.parseInt(datos6[22]));
            //criba F
            c159 = my_worksheet.getRow(28).getCell(2);
            if (c159 == null) {
                c159 = my_worksheet.getRow(28).createCell(2);
            } //MODIFICAR DE NUEVO
            c159.setCellValue(Integer.parseInt(datos7[0]));

            c160 = my_worksheet.getRow(28).getCell(7);
            if (c160 == null) {
                c160 = my_worksheet.getRow(28).createCell(7);
            }
            c160.setCellValue(Integer.parseInt(datos7[1]));

            c161 = my_worksheet.getRow(28).getCell(8);
            if (c161 == null) {
                c161 = my_worksheet.getRow(28).createCell(8);
            }
            c161.setCellValue(Integer.parseInt(datos7[2]));

            c162 = my_worksheet.getRow(28).getCell(9);
            if (c162 == null) {
                c162 = my_worksheet.getRow(28).createCell(9);
            }
            c162.setCellValue(Integer.parseInt(datos7[3]));

            c163 = my_worksheet.getRow(28).getCell(10);
            if (c163 == null) {
                c163 = my_worksheet.getRow(28).createCell(10);
            }
            c163.setCellValue(Integer.parseInt(datos7[4]));

            c164 = my_worksheet.getRow(28).getCell(11);
            if (c164 == null) {
                c164 = my_worksheet.getRow(28).createCell(11);
            }
            c164.setCellValue(Integer.parseInt(datos7[5]));

            c165 = my_worksheet.getRow(28).getCell(12);
            if (c165 == null) {
                c165 = my_worksheet.getRow(28).createCell(12);
            }
            c165.setCellValue(Integer.parseInt(datos7[6]));

            c166 = my_worksheet.getRow(28).getCell(13);
            if (c166 == null) {
                c166 = my_worksheet.getRow(28).createCell(13);
            }
            c166.setCellValue(Integer.parseInt(datos7[7]));

            c167 = my_worksheet.getRow(28).getCell(14);
            if (c167 == null) {
                c167 = my_worksheet.getRow(28).createCell(14);
            }
            c167.setCellValue(Integer.parseInt(datos7[8]));

            c168 = my_worksheet.getRow(28).getCell(15);
            if (c168 == null) {
                c168 = my_worksheet.getRow(28).createCell(15);
            }
            c168.setCellValue(Integer.parseInt(datos7[9]));

            c169 = my_worksheet.getRow(28).getCell(16);
            if (c169 == null) {
                c169 = my_worksheet.getRow(28).createCell(16);
            }
            c169.setCellValue(Integer.parseInt(datos7[10]));

            c170 = my_worksheet.getRow(28).getCell(17);
            if (c170 == null) {
                c170 = my_worksheet.getRow(28).createCell(17);
            }
            c170.setCellValue(Integer.parseInt(datos7[11]));

            c171 = my_worksheet.getRow(28).getCell(18);
            if (c171 == null) {
                c171 = my_worksheet.getRow(28).createCell(18);
            }
            c171.setCellValue(Integer.parseInt(datos7[12]));

            c172 = my_worksheet.getRow(28).getCell(19);
            if (c172 == null) {
                c172 = my_worksheet.getRow(28).createCell(19);
            }
            c172.setCellValue(Integer.parseInt(datos7[13]));

            c173 = my_worksheet.getRow(28).getCell(20);
            if (c173 == null) {
                c173 = my_worksheet.getRow(28).createCell(20);
            }
            c173.setCellValue(Integer.parseInt(datos7[14]));

            c174 = my_worksheet.getRow(28).getCell(21);
            if (c174 == null) {
                c174 = my_worksheet.getRow(28).createCell(21);
            }
            c174.setCellValue(Integer.parseInt(datos7[15]));

            c175 = my_worksheet.getRow(28).getCell(22);
            if (c175 == null) {
                c175 = my_worksheet.getRow(28).createCell(22);
            }
            c175.setCellValue(Integer.parseInt(datos7[16]));

            c176 = my_worksheet.getRow(28).getCell(23);
            if (c176 == null) {
                c176 = my_worksheet.getRow(28).createCell(23);
            }
            c176.setCellValue(Integer.parseInt(datos7[17]));

            c177 = my_worksheet.getRow(28).getCell(24);
            if (c177 == null) {
                c177 = my_worksheet.getRow(28).createCell(24);
            }
            c177.setCellValue(Integer.parseInt(datos7[18]));

            c178 = my_worksheet.getRow(28).getCell(25);
            if (c178 == null) {
                c178 = my_worksheet.getRow(28).createCell(25);
            }
            c178.setCellValue(Integer.parseInt(datos7[19]));

            c179 = my_worksheet.getRow(28).getCell(26);
            if (c179 == null) {
                c179 = my_worksheet.getRow(28).createCell(26);
            }
            c179.setCellValue(Integer.parseInt(datos7[20]));

            c180 = my_worksheet.getRow(28).getCell(27);

            if (c180 == null) {
                c180 = my_worksheet.getRow(28).createCell(27);
            }
            c180.setCellValue(Integer.parseInt(datos7[21]));

            c181 = my_worksheet.getRow(28).getCell(28);
            if (c181 == null) {
                c181 = my_worksheet.getRow(28).createCell(28);
            }
            c181.setCellValue(Integer.parseInt(datos7[22]));
            // if (taza.equals("1")) {
            //sabores
            c182 = my_worksheet.getRow(13).getCell(10);
            if (c182 == null) {
                c182 = my_worksheet.getRow(13).createCell(10);
            } //sabores sabor
            c182.setCellValue(sabor[1]);

            c183 = my_worksheet.getRow(13).getCell(16);
            if (c183 == null) {
                c183 = my_worksheet.getRow(13).createCell(16);
            }//sabores acidez
            c183.setCellValue(acidez[1]);

            c184 = my_worksheet.getRow(16).getCell(4);
            if (c184 == null) {
                c184 = my_worksheet.getRow(16).createCell(4);
            } // sabores seco
            c184.setCellValue(seco[1]);

            c185 = my_worksheet.getRow(16).getCell(10);
            if (c185 == null) {
                c185 = my_worksheet.getRow(16).createCell(10);
            } // sabores aftertaste
            c185.setCellValue(saborRemanente[1]);

            c186 = my_worksheet.getRow(17).getCell(16);
            if (c186 == null) {
                c186 = my_worksheet.getRow(17).createCell(16);
            } //sabores body
            c186.setCellValue(quebrado[1]);

            c187 = my_worksheet.getRow(18).getCell(4);
            if (c187 == null) {
                c187 = my_worksheet.getRow(18).createCell(4);
            }//sabores espuma y mojado
            c187.setCellValue(quebrado[1] + "," + seco[1]);

            //}
            //XSSFFormulaEvaluator.evaluateAllFormulaCells(my_xlsx_workbook);
            //selecciona el nombre y la ruta para el archivo de salida Users\\Jacob Frankel\\Desktop\\
            FileOutputStream output_file = new FileOutputStream(new File("C:\\fincalab\\reporteLaboratorio.xlsx"));
            XSSFFormulaEvaluator.evaluateAllFormulaCells(my_xlsx_workbook);
//escribe los datos
            my_xlsx_workbook.write(output_file);
            my_xlsx_workbook.close();
            //XSSFFormulaEvaluator.evaluateAllFormulaCells(my_xlsx_workbook);
            //cierra el archivo abierto
            //output_file.flush();
            output_file.close();
            //JOptionPane.showMessageDialog(null, "Reporte Creado");
/*        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Revisar Datos Bitacora BD");
        }*/

    }

    public void imprimir(JTable modelo2, Connection cn, String Idioma) {
        this.cn = cn;
        this.Idioma = Idioma;
        mdb = new metodosLaboratorio(cn, Idioma);
        DecimalFormat formato = new DecimalFormat("#.##");
        String array[] = new String[26];
        String a1 = "", a2 = "", a3 = "";
        int a4;

        //Access the workbook
        XSSFWorkbook my_xlsx_workbook;
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Reporte General");
        //This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("0", new Object[]{"% F", "Estado Mezcla", "CSM", "Beneficio", "Lote", "Proceso", "Forma Cafe", "Certificacion", "Kilogramos", "Conf", "Sacos", "Comunidad",
            "Dueño", "Fec. Lote", "Taza", "Aspecto", "H. Oro", "Broca Severa", "Rendimiento", "Quakers", "Sabores (Seco)", "Sabores (Sabor)", "Sabores (Post Gusto)", "Sabores (Finish)", "Sabores (cuerpo)", "Observaciones", "Densidad Oro", "Densidad Tostado"});
        a4 = modelo2.getRowCount();
        for (int i = 0; i < a4; i++) {
            String id = "", taza = "";
            array[0] = modelo2.getValueAt(i, 0) + "";
            String[] sab1 = new String[2];
            String[] datos81 = new String[15];
            String[] sab2 = new String[2];

            String[] sab3 = new String[2];

            String[] sab4 = new String[2];

            String[] sab5 = new String[2];

            String[] sab6 = new String[2];

            String[] sab7 = new String[2];
            String[] sab8 = new String[2];
            String[] sab9 = new String[2];
            System.out.println(array[0]);
            if (array[0].equals("null")) {
                array[0] = "";
            }
            array[1] = modelo2.getValueAt(i, 1) + "";
            System.out.println(array[1]);
            if (array[1].equals("null")) {
                array[1] = "";
            }
            array[2] = modelo2.getValueAt(i, 2) + "";
            System.out.println(array[2]);
            if (array[2].equals("null")) {
                array[2] = "";
            }
            array[3] = modelo2.getValueAt(i, 3) + "";
            System.out.println(array[3]);
            if (array[3].equals("null")) {
                array[3] = "";
            }
            array[4] = modelo2.getValueAt(i, 4) + "";
            System.out.println(array[4]);
            if (array[4].equals("null")) {
                array[4] = "";
            }
            array[5] = modelo2.getValueAt(i, 5) + "";
            System.out.println(array[5]);
            if (array[5].equals("null")) {
                array[5] = "";
            }
            array[6] = modelo2.getValueAt(i, 6) + "";
            System.out.println(array[6]);
            if (array[6].equals("null")) {
                array[6] = "";
            }
            array[7] = modelo2.getValueAt(i, 7) + "";
            System.out.println(array[7]);
            if (array[7].equals("null")) {
                array[7] = "";
            }
            array[8] = modelo2.getValueAt(i, 8) + "";
            System.out.println(array[8]);
            if (array[8].equals("null")) {
                array[8] = "";
            } else if (array[8].equals("1")) {
                array[8] = "S";
            } else {
                array[8] = "N";
            }
            array[9] = modelo2.getValueAt(i, 9) + "";
            System.out.println(array[9]);
            if (array[9].equals("null")) {
                array[9] = "";
            }
            array[10] = modelo2.getValueAt(i, 10) + "";
            System.out.println(array[10]);
            if (array[10].equals("null")) {
                array[10] = "";
            }
            array[11] = modelo2.getValueAt(i, 11) + "";
            System.out.println(array[11]);
            if (array[11].equals("null")) {
                array[11] = "";
            }
            array[12] = modelo2.getValueAt(i, 12) + "";
            System.out.println(array[12]);
            if (array[12].equals("null")) {
                array[12] = "";
            }
            array[13] = modelo2.getValueAt(i, 13) + "";
            System.out.println(array[13]);
            if (array[13].equals("null")) {
                array[13] = "";
            }
            array[14] = modelo2.getValueAt(i, 14) + "";
            System.out.println(array[14]);
            if (array[14].equals("null")) {
                array[14] = "";
            }
            array[15] = modelo2.getValueAt(i, 15) + "";
            System.out.println(array[15]);
            if (array[15].equals("null")) {
                array[15] = "";
            }
            array[16] = modelo2.getValueAt(i, 16) + "";
            System.out.println(array[16]);
            if (array[16].equals("null")) {
                array[16] = "";
            }
            array[17] = modelo2.getValueAt(i, 17) + "";
            System.out.println(array[17]);
            if (array[17].equals("null")) {
                array[17] = "";
                datos81[0] = "";
                datos81[1] = "";
                datos81[2] = "";
            } else {

                datos81 = array[17].split(";");

                sab4 = datos81[3].split(":");
                sab5 = datos81[4].split(":");
                sab6 = datos81[5].split(":");
                sab7 = datos81[6].split(":");
                sab8 = sab5[1].split("-");
                sab9 = sab8[1].split("=");
                System.out.println(sab1[0]);
                System.out.println(datos81[0]);//1 dry flavor
                System.out.println(sab2[0]);
                System.out.println(datos81[1]);//1 wet flavor
                System.out.println(sab3[0]);
                System.out.println(datos81[2]);//1 break flavor
                System.out.println(sab4[0]);
                System.out.println(sab4[1]);//1 flavor flavors
                System.out.println(sab5[0]);
                System.out.println(sab8[0]);//1 after taste flavor
                System.out.println(sab9[1]);//finish flavor 
                System.out.println(sab6[0]);
                System.out.println(sab6[1]);//1 acidity flavors
                System.out.println(sab7[0]);
                System.out.println(sab7[1]);//1 body
            }
            array[18] = modelo2.getValueAt(i, 18) + "";
            System.out.println(array[18]);
            if (array[18].equals("null")) {
                array[18] = "";
            }
            array[19] = modelo2.getValueAt(i, 19) + "";
            System.out.println(array[19]);
            if (array[19].equals("null")) {
                array[19] = "";
            }
            array[20] = modelo2.getValueAt(i, 20) + "";
            System.out.println(array[20]);
            if (array[20].equals("null")) {
                array[20] = "";
            }
            array[21] = modelo2.getValueAt(i, 21) + "";
            System.out.println(array[21]);
            if (array[21].equals("null")) {
                array[21] = "";
            }
            id = mdb.comprobarExistencia("select id_bitacora from bitacoralab "
                    + "where (id_muestra='" + array[1] + "' and comunidad='" + array[10] + "')");
            taza = mdb.devuelveUnDato("select aspecto from bitacoralab "
                    + "where (id_muestra='" + array[1] + "' and comunidad='" + array[10] + "')");
            if (taza.equals("1")) {

                a2 = mdb.devuelveUnDato("select PesoEv from datosev "
                        + "where (id_bitacora='" + id + "')");
                String[] datos7 = mdb.devuelveUnDato("SELECT datos FROM cribas where id_bitacora=" + id + " and criba='F';").split(",");
                String[] datos8 = mdb.devuelveUnDato("SELECT datos FROM cribas where id_bitacora=" + id + " and criba='TOTAL';").split(",");
                a1 = formato.format(100 * Integer.parseInt(datos7[0]) / Integer.parseInt(datos8[0])) + "%";
                a3 = formato.format(100 * Integer.parseInt(datos8[0]) / Integer.parseInt(a2)) + "%";
                array[22] = a1;//de aqui para abajo no hay valor
                array[23] = datos8[1];
                array[24] = a3;
            } else {
                array[22] = "";//de aqui para abajo no hay valor
                array[23] = "";
                array[24] = "";
            }

            data.put("" + i + 1 + "", new Object[]{array[22], array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7], array[8], array[9], array[10], array[11], array[12], array[13], array[14], array[15], array[23], array[24], array[16], datos81[0] + " " + datos81[1] + " " + datos81[2], sab4[1], sab8[0], sab9[1], sab7[1], array[18], array[19], array[20], array[21]});
        }

        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }
            }
        }
        try {
            //Write the workbook in file system Users\\Jacob Frankel\\Desktop\\
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MMM_d_HHmm");
            Date date = new Date(System.currentTimeMillis());
            System.out.println(formatter.format(date));
            String nombre = "Reporte_CSM_" + formatter.format(date);
            FileOutputStream out = new FileOutputStream(new File("C:\\" + nombre + ".xlsx"));
            workbook.write(out);
            out.close();

            JOptionPane.showMessageDialog(null, "reporte creado: " + nombre + ".xlsx en C:");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {

        //Access the workbook
        /*   //Blank workbook
      XSSFWorkbook workbook = new XSSFWorkbook();
      //Create a blank sheet
      XSSFSheet sheet = workbook.createSheet("Employee Data");
      //This data needs to be written (Object[])
      Map<String, Object[]> data = new TreeMap<String, Object[]>();
      data.put("1", new Object[] {"ID", "NAME", "LASTNAME"});
      data.put("2", new Object[] {1, "Amit", "Shukla"});
      data.put("3", new Object[] {2, "Lokesh", "Gupta"});
      data.put("4", new Object[] {3, "John", "Adwards"});
      data.put("5", new Object[] {4, "Brian", "Schultz"});
      //Iterate over data and write to sheet
      Set<String> keyset = data.keySet();
      int rownum = 0;
      for (String key : keyset)
      {
      Row row = sheet.createRow(rownum++);
      Object [] objArr = data.get(key);
      int cellnum = 0;
      for (Object obj : objArr)
      {
      Cell cell = row.createCell(cellnum++);
      if(obj instanceof String)
      cell.setCellValue((String)obj);
      else if(obj instanceof Integer)
      cell.setCellValue((Integer)obj);
      }
      }
      try
      {
      //Write the workbook in file system
      FileOutputStream out = new FileOutputStream(new File("howtodoinjava_demo.xlsx"));
      workbook.write(out);
      out.close();
      System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
      }
      catch (Exception e)
      {
      e.printStackTrace();
      }
       //Read the spreadsheet that needs to be updated
          FileInputStream input_document = new FileInputStream(new File("plantilla.xlsx"));
          //Access the workbook
          my_xlsx_workbook = new XSSFWorkbook(input_document);
          //Access the worksheet, so that we can update / modify it.
          XSSFSheet my_worksheet = my_xlsx_workbook.getSheetAt(0);
          // declare a Cell object
          
          if (my_worksheet==null) {
              System.out.println("F"); 
        }
          Cell cell;
          my_worksheet.getRow(1);
          
          // Access the cell first to update the value
          cell = my_worksheet.getRow(1).getCell(0);
          // Get current value and then add 5 to it
          
          
          if (cell==null) {
             
              cell=my_worksheet.getRow(1).createCell(0);
        }
cell.setCellValue(7);
          //Close the InputStream
      
      //write changes
 //Open FileOutputStream to write updates
              FileOutputStream output_file = new FileOutputStream(new File("plantilla1.xlsx")) ;
          //write changes
          my_xlsx_workbook.write(output_file);
          //close the stream
       output_file.close();  */
    }

}
