/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_LaboratorioN;

import Conexion.Conexion;
import Metodos_Configuraciones.metodosDatosBasicos;
import Metodos_Configuraciones.metodosLaboratorio;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cronos
 */
public class jpReporteLaboratorio extends javax.swing.JPanel {

    /**
     * Creates new form jpReporteLaboratorio
     */
    Connection cn;
    metodosLaboratorio mL;
    DefaultTableModel modelo, modelo2, modelo3;

    public jpReporteLaboratorio(Connection cn, String Idioma) {
        initComponents();

        this.cn = cn;
        mL = new metodosLaboratorio(cn, "");
        modelo = (DefaultTableModel) jTable1.getModel();
        modelo2 = (DefaultTableModel) jTable2.getModel();
        modelo3 = (DefaultTableModel) jTable3.getModel();

        llenarTabla();

    }

    public void llenarTabla() {
        limpiar(jTable1);
        limpiar(jTable2);
        //    limpiar(jTable3);

        mL.cargarInformacion2(modelo, 64, "SELECT\n"
                + "    b.id_muestra as 'CSM',\n"
                + "    b.fecha_llegada as 'Fecha Llegada',\n"
                + "    b.tomadapor as 'Tomada Por',\n"
                + "    b.fechalote as 'Fecha Lote',\n"
                + "    b.tipocafe as 'Proceso Cafe',\n"
                + "    b.forma as 'Forma Cafe',\n"
                + "    b.peso as 'Peso',\n"
                + "    b.sacos as 'Sacos',\n"
                + "    b.beneficio as 'Beneficio',\n"
                + "    b.lote as 'Lote',\n"
                + "    b.certificado as 'Certificado',\n"
                + "    b.dueño as 'Sociedad',\n"
                + "    'Predio' as 'Predio',\n"
                + "    b.comunidad as 'Comunidad',\n"
                + "    b.calidadcereza as 'Calidad Cereza',\n"
                + "    d.PesoEv as 'Peso Ev',\n"
                + "    d.humedad_c as 'Humedad C',\n"
                + "    d.humedad_o as 'Humedad O',\n"
                + "    b.Metodosecado as 'Metodo Secado',\n"
                + "    d.Densidadoro as 'Densidad Oro',\n"
                + "    'Peso criba num' as 'Peso Criba#',\n"
                + "    d.uniformidad as 'Uniformidad Oro',\n"
                + "    d.color as 'Color Oro',\n"
                + "    'Agua' as 'Agua',\n"
                + "    t.numerotazas as 'Numero Tazas',\n"
                + "    'C1' as 'Coment1',\n"
                + "    'C2' as 'Coment2',\n"
                + "    'C3' as 'Coment3',\n"
                + "    d.fecha as 'Fecha Ev Asp',\n"
                + "    d.evaluador as 'Evaluador',\n"
                + "    t.fecha as 'Fecha Ev Taz',\n"
                + "    'Evaluado por' as 'Evaluado Por',\n"
                + "    t.niveltostado as 'Nivel Tostado',\n"
                + "    t.uniformidadtostado as 'Uniformidad Tostado',\n"
                + "    t.quakers as 'Quakers',\n"
                + "    t.dry as 'Seco',\n"
                + "    b.olores as 'Cualidades Seco',\n"
                + "    t.wet as 'Mojado',\n"
                + "    t.break as 'Quebrado',\n"
                + "    b.olores as 'Cualidades Moj/Queb',\n"
                + "    t.flavor as 'Sabor',\n"
                + "    b.sabores as 'Cualidades Sabor',\n"
                + "    t.aftertaste as 'Sabor Remanente',\n"
                + "    b.sabores as 'Cualidades Remanente',\n"
                + "    t.acidity as 'Acidez',\n"
                + "    b.sabores as 'Cualidades Acidez',\n"
                + "    t.intensidadacidit as 'Intensidad Acidez',\n"
                + "    t.body as 'Cuerpo',\n"
                + "    b.sabores as 'Cualidades Cuerpo',\n"
                + "    t.intensidadbody as 'Intensidad Cuerpo',\n"
                + "    t.balance as 'Balance',\n"
                + "    t.uniformidadtaza as 'Uniformidad Taza',\n"
                + "    t.tazalimpia as 'Taza Limpia',\n"
                + "    t.dulzor as 'Dulzor',\n"
                + "    t.numtazasdefect as 'Num Taza Defectos',\n"
                + "    t.intensidaddef as 'Intensidad Defectos',\n"
                + "    t.catador as 'Catador',\n"
                + "    GROUP_CONCAT(c.criba,'-', SUBSTRING_INDEX(c.datos,',',1) order by c.id_cribas),\n"
                + " 'Peso 18',"
                + " 'Peso 17',"
                + " 'Peso 16',"
                + " 'Peso 15',"
                + " 'Peso F',"
                + "    GROUP_CONCAT(c.datos order by c.id_cribas) \n"
                + "FROM\n"
                + "    bitacoralab b\n"
                + "LEFT JOIN datosev d ON\n"
                + "    (b.id_bitacora = d.id_muestra)\n"
                + "LEFT JOIN cribas c ON\n"
                + "    (c.id_bitacora = b.id_bitacora)\n"
                + "LEFT JOIN catacion t ON\n"
                + "    (t.id_bitacora = b.id_bitacora)\n"
                + "GROUP BY\n"
                + "    b.id_muestra\n"
                + "ORDER BY\n"
                + "    b.id_muestra");

        mL.cargarInformacion2(modelo2, 3, "SELECT	\n"
                + "    b.id_muestra as 'CSM',\n"
                + "   GROUP_CONCAT(c.criba,'-', SUBSTRING_INDEX(c.datos,',',1) order by c.id_cribas),\n"
                + "    GROUP_CONCAT(c.datos order by c.id_cribas) \n"
                + "FROM\n"
                + "    bitacoralab b\n"
                + "LEFT JOIN datosev d ON\n"
                + "    (b.id_bitacora = d.id_muestra)\n"
                + "LEFT JOIN cribas c ON\n"
                + "    (c.id_bitacora = b.id_bitacora)\n"
                + "LEFT JOIN catacion t ON\n"
                + "    (t.id_bitacora = b.id_bitacora)\n"
                + "GROUP BY\n"
                + "    b.id_muestra\n"
                + "ORDER BY\n"
                + "    b.id_muestra");

        procesos();
    }

    public void procesos() {
        try {
            for (int i = 0; i < jTable1.getRowCount(); i++) {

                String peso = jTable1.getValueAt(i, 57) + "";
                //    if (!peso.equals("") || !peso.equals("null")) {

                String cribas[] = peso.split(",");
                String criba19 = cribas[0];
                String criba18 = cribas[1];
                String criba17 = cribas[2];
                String criba16 = cribas[3];
                String criba15 = cribas[4];
                String cribaF = cribas[5];

                String pesos19[] = criba19.split("-");
                String pesos18[] = criba18.split("-");
                String pesos17[] = criba17.split("-");
                String pesos16[] = criba16.split("-");
                String pesos15[] = criba15.split("-");
                String pesosF[] = cribaF.split("-");

                String peso19 = pesos19[1];
                String peso18 = pesos18[1];
                String peso17 = pesos17[1];
                String peso16 = pesos16[1];
                String peso15 = pesos15[1];
                String pesoF = pesosF[1];

                jTable1.setValueAt(peso19, i, 57);
                jTable1.setValueAt(peso18, i, 58);
                jTable1.setValueAt(peso17, i, 59);
                jTable1.setValueAt(peso16, i, 60);
                jTable1.setValueAt(peso15, i, 61);
                jTable1.setValueAt(pesoF, i, 62);

                /*String cadenaDefectos = jTable1.getValueAt(i, 63) + "";
                String defectos[] = cadenaDefectos.split(",");

                jTable1.setValueAt(defectos[0], i, 63);
                jTable1.setValueAt(defectos[1], i, 64);
                jTable1.setValueAt(defectos[2], i, 65);
                jTable1.setValueAt(defectos[3], i, 66);
                jTable1.setValueAt(defectos[4], i, 67);
                jTable1.setValueAt(defectos[5], i, 68);
                jTable1.setValueAt(defectos[6], i, 69);
                jTable1.setValueAt(defectos[7], i, 70);
                jTable1.setValueAt(defectos[8], i, 71);
                jTable1.setValueAt(defectos[9], i, 72);
                jTable1.setValueAt(defectos[10], i, 73);
                jTable1.setValueAt(defectos[11], i, 74);
                jTable1.setValueAt(defectos[12], i, 75);
                jTable1.setValueAt(defectos[13], i, 76);
                jTable1.setValueAt(defectos[14], i, 77);
                jTable1.setValueAt(defectos[15], i, 78);
                jTable1.setValueAt(defectos[16], i, 79);
                jTable1.setValueAt(defectos[17], i, 80);
                jTable1.setValueAt(defectos[18], i, 81);
                jTable1.setValueAt(defectos[19], i, 82);
                jTable1.setValueAt(defectos[20], i, 83);
                jTable1.setValueAt(defectos[21], i, 84);
                jTable1.setValueAt(defectos[22], i, 85);
                jTable1.setValueAt(defectos[23], i, 86);
                jTable1.setValueAt(defectos[24], i, 87);
                jTable1.setValueAt(defectos[25], i, 88);
                jTable1.setValueAt(defectos[26], i, 89);
                jTable1.setValueAt(defectos[27], i, 90);
                jTable1.setValueAt(defectos[28], i, 91);
                jTable1.setValueAt(defectos[29], i, 92);
                jTable1.setValueAt(defectos[30], i, 93);
                jTable1.setValueAt(defectos[31], i, 94);
                jTable1.setValueAt(defectos[32], i, 95);
                jTable1.setValueAt(defectos[33], i, 96);
                jTable1.setValueAt(defectos[34], i, 97);
                jTable1.setValueAt(defectos[35], i, 98);
                jTable1.setValueAt(defectos[36], i, 99);
                jTable1.setValueAt(defectos[37], i, 100);
                jTable1.setValueAt(defectos[38], i, 101);
                jTable1.setValueAt(defectos[39], i, 102);
                jTable1.setValueAt(defectos[40], i, 103);
                jTable1.setValueAt(defectos[41], i, 104);
                jTable1.setValueAt(defectos[42], i, 105);
                jTable1.setValueAt(defectos[43], i, 106);
                jTable1.setValueAt(defectos[44], i, 107);
                jTable1.setValueAt(defectos[45], i, 108);
                jTable1.setValueAt(defectos[46], i, 109);
                jTable1.setValueAt(defectos[47], i, 110);
                jTable1.setValueAt(defectos[48], i, 111);
                jTable1.setValueAt(defectos[49], i, 112);
                jTable1.setValueAt(defectos[50], i, 113);
                jTable1.setValueAt(defectos[51], i, 114);
                jTable1.setValueAt(defectos[52], i, 115);
                jTable1.setValueAt(defectos[53], i, 116);
                jTable1.setValueAt(defectos[54], i, 117);
                jTable1.setValueAt(defectos[55], i, 118);
                jTable1.setValueAt(defectos[56], i, 119);
                jTable1.setValueAt(defectos[57], i, 120);
                jTable1.setValueAt(defectos[58], i, 121);
                jTable1.setValueAt(defectos[59], i, 122);
                jTable1.setValueAt(defectos[60], i, 123);
                jTable1.setValueAt(defectos[61], i, 124);
                jTable1.setValueAt(defectos[62], i, 125);
                jTable1.setValueAt(defectos[63], i, 126);
                jTable1.setValueAt(defectos[64], i, 127);
                jTable1.setValueAt(defectos[65], i, 128);
                jTable1.setValueAt(defectos[66], i, 129);
                jTable1.setValueAt(defectos[67], i, 130);
                jTable1.setValueAt(defectos[68], i, 131);
                jTable1.setValueAt(defectos[69], i, 132);
                jTable1.setValueAt(defectos[70], i, 133);
                jTable1.setValueAt(defectos[71], i, 134);
                jTable1.setValueAt(defectos[72], i, 135);
                jTable1.setValueAt(defectos[73], i, 136);
                jTable1.setValueAt(defectos[74], i, 137);
                jTable1.setValueAt(defectos[75], i, 138);
                jTable1.setValueAt(defectos[76], i, 139);
                jTable1.setValueAt(defectos[77], i, 140);
                jTable1.setValueAt(defectos[78], i, 141);
                jTable1.setValueAt(defectos[79], i, 142);
                jTable1.setValueAt(defectos[80], i, 143);
                jTable1.setValueAt(defectos[81], i, 144);
                jTable1.setValueAt(defectos[82], i, 145);
                jTable1.setValueAt(defectos[83], i, 146);
                jTable1.setValueAt(defectos[84], i, 147);
                jTable1.setValueAt(defectos[85], i, 148);
                jTable1.setValueAt(defectos[86], i, 149);
                jTable1.setValueAt(defectos[87], i, 150);
                jTable1.setValueAt(defectos[88], i, 151);
                jTable1.setValueAt(defectos[89], i, 152);
                jTable1.setValueAt(defectos[90], i, 153);
                jTable1.setValueAt(defectos[91], i, 154);
                jTable1.setValueAt(defectos[92], i, 155);
                jTable1.setValueAt(defectos[93], i, 156);
                jTable1.setValueAt(defectos[94], i, 157);
                jTable1.setValueAt(defectos[95], i, 158);
                jTable1.setValueAt(defectos[96], i, 159);
                jTable1.setValueAt(defectos[97], i, 160);
                jTable1.setValueAt(defectos[98], i, 161);
                jTable1.setValueAt(defectos[99], i, 162);
                jTable1.setValueAt(defectos[100], i, 163);
                jTable1.setValueAt(defectos[101], i, 164);
                jTable1.setValueAt(defectos[102], i, 165);
                jTable1.setValueAt(defectos[103], i, 166);
                jTable1.setValueAt(defectos[104], i, 167);
                jTable1.setValueAt(defectos[105], i, 168);
                jTable1.setValueAt(defectos[106], i, 169);
                jTable1.setValueAt(defectos[107], i, 170);
                jTable1.setValueAt(defectos[108], i, 171);
                jTable1.setValueAt(defectos[109], i, 172);
                jTable1.setValueAt(defectos[110], i, 173);
                jTable1.setValueAt(defectos[111], i, 174);
                jTable1.setValueAt(defectos[112], i, 175);
                jTable1.setValueAt(defectos[113], i, 176);
                jTable1.setValueAt(defectos[114], i, 177);
                jTable1.setValueAt(defectos[115], i, 178);
                jTable1.setValueAt(defectos[116], i, 179);
                jTable1.setValueAt(defectos[117], i, 180);
                jTable1.setValueAt(defectos[118], i, 181);
                jTable1.setValueAt(defectos[119], i, 182);
                jTable1.setValueAt(defectos[120], i, 183);
                jTable1.setValueAt(defectos[121], i, 184);
                jTable1.setValueAt(defectos[122], i, 185);
                jTable1.setValueAt(defectos[123], i, 186);
                jTable1.setValueAt(defectos[124], i, 187);
                jTable1.setValueAt(defectos[125], i, 188);
                jTable1.setValueAt(defectos[126], i, 189);
                jTable1.setValueAt(defectos[127], i, 190);
                jTable1.setValueAt(defectos[128], i, 191);
                jTable1.setValueAt(defectos[129], i, 192);
                jTable1.setValueAt(defectos[130], i, 193);
                jTable1.setValueAt(defectos[131], i, 194);
                jTable1.setValueAt(defectos[132], i, 195);
                jTable1.setValueAt(defectos[133], i, 196);
                jTable1.setValueAt(defectos[134], i, 197);
                jTable1.setValueAt(defectos[135], i, 198);
                jTable1.setValueAt(defectos[136], i, 199);
                jTable1.setValueAt(defectos[137], i, 200);
                jTable1.setValueAt(defectos[138], i, 201);*/
            }

             } catch (Exception e) {

        }
            
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                String cadenaDefectos = jTable1.getValueAt(i, 63) + "";
                String defectos[] = cadenaDefectos.split(",");

                //JOptionPane.showMessageDialog(null,cadenaDefectos);
                
                jTable1.setValueAt(defectos[0], i, 63);
                jTable1.setValueAt(defectos[1], i, 64);
                jTable1.setValueAt(defectos[2], i, 65);
                jTable1.setValueAt(defectos[3], i, 66);
                jTable1.setValueAt(defectos[4], i, 67);
                jTable1.setValueAt(defectos[5], i, 68);
                jTable1.setValueAt(defectos[6], i, 69);
                jTable1.setValueAt(defectos[7], i, 70);
                jTable1.setValueAt(defectos[8], i, 71);
                jTable1.setValueAt(defectos[9], i, 72);
                jTable1.setValueAt(defectos[10], i, 73);
                jTable1.setValueAt(defectos[11], i, 74);
                jTable1.setValueAt(defectos[12], i, 75);
                jTable1.setValueAt(defectos[13], i, 76);
                jTable1.setValueAt(defectos[14], i, 77);
                jTable1.setValueAt(defectos[15], i, 78);
                jTable1.setValueAt(defectos[16], i, 79);
                jTable1.setValueAt(defectos[17], i, 80);
                jTable1.setValueAt(defectos[18], i, 81);
                jTable1.setValueAt(defectos[19], i, 82);
                jTable1.setValueAt(defectos[20], i, 83);
                jTable1.setValueAt(defectos[21], i, 84);
                jTable1.setValueAt(defectos[22], i, 85);
                jTable1.setValueAt(defectos[23], i, 86);
                jTable1.setValueAt(defectos[24], i, 87);
                jTable1.setValueAt(defectos[25], i, 88);
                jTable1.setValueAt(defectos[26], i, 89);
                jTable1.setValueAt(defectos[27], i, 90);
                jTable1.setValueAt(defectos[28], i, 91);
                jTable1.setValueAt(defectos[29], i, 92);
                jTable1.setValueAt(defectos[30], i, 93);
                jTable1.setValueAt(defectos[31], i, 94);
                jTable1.setValueAt(defectos[32], i, 95);
                jTable1.setValueAt(defectos[33], i, 96);
                jTable1.setValueAt(defectos[34], i, 97);
                jTable1.setValueAt(defectos[35], i, 98);
                jTable1.setValueAt(defectos[36], i, 99);
                jTable1.setValueAt(defectos[37], i, 100);
                jTable1.setValueAt(defectos[38], i, 101);
                jTable1.setValueAt(defectos[39], i, 102);
                jTable1.setValueAt(defectos[40], i, 103);
                jTable1.setValueAt(defectos[41], i, 104);
                jTable1.setValueAt(defectos[42], i, 105);
                jTable1.setValueAt(defectos[43], i, 106);
                jTable1.setValueAt(defectos[44], i, 107);
                jTable1.setValueAt(defectos[45], i, 108);
                jTable1.setValueAt(defectos[46], i, 109);
                jTable1.setValueAt(defectos[47], i, 110);
                jTable1.setValueAt(defectos[48], i, 111);
                jTable1.setValueAt(defectos[49], i, 112);
                jTable1.setValueAt(defectos[50], i, 113);
                jTable1.setValueAt(defectos[51], i, 114);
                jTable1.setValueAt(defectos[52], i, 115);
                jTable1.setValueAt(defectos[53], i, 116);
                jTable1.setValueAt(defectos[54], i, 117);
                jTable1.setValueAt(defectos[55], i, 118);
                jTable1.setValueAt(defectos[56], i, 119);
                jTable1.setValueAt(defectos[57], i, 120);
                jTable1.setValueAt(defectos[58], i, 121);
                jTable1.setValueAt(defectos[59], i, 122);
                jTable1.setValueAt(defectos[60], i, 123);
                jTable1.setValueAt(defectos[61], i, 124);
                jTable1.setValueAt(defectos[62], i, 125);
                jTable1.setValueAt(defectos[63], i, 126);
                jTable1.setValueAt(defectos[64], i, 127);
                jTable1.setValueAt(defectos[65], i, 128);
                jTable1.setValueAt(defectos[66], i, 129);
                jTable1.setValueAt(defectos[67], i, 130);
                jTable1.setValueAt(defectos[68], i, 131);
                jTable1.setValueAt(defectos[69], i, 132);
                jTable1.setValueAt(defectos[70], i, 133);
                jTable1.setValueAt(defectos[71], i, 134);
                jTable1.setValueAt(defectos[72], i, 135);
                jTable1.setValueAt(defectos[73], i, 136);
                jTable1.setValueAt(defectos[74], i, 137);
                jTable1.setValueAt(defectos[75], i, 138);
                jTable1.setValueAt(defectos[76], i, 139);
                jTable1.setValueAt(defectos[77], i, 140);
                jTable1.setValueAt(defectos[78], i, 141);
                jTable1.setValueAt(defectos[79], i, 142);
                jTable1.setValueAt(defectos[80], i, 143);
                jTable1.setValueAt(defectos[81], i, 144);
                jTable1.setValueAt(defectos[82], i, 145);
                jTable1.setValueAt(defectos[83], i, 146);
                jTable1.setValueAt(defectos[84], i, 147);
                jTable1.setValueAt(defectos[85], i, 148);
                jTable1.setValueAt(defectos[86], i, 149);
                jTable1.setValueAt(defectos[87], i, 150);
                jTable1.setValueAt(defectos[88], i, 151);
                jTable1.setValueAt(defectos[89], i, 152);
                jTable1.setValueAt(defectos[90], i, 153);
                jTable1.setValueAt(defectos[91], i, 154);
                jTable1.setValueAt(defectos[92], i, 155);
                jTable1.setValueAt(defectos[93], i, 156);
                jTable1.setValueAt(defectos[94], i, 157);
                jTable1.setValueAt(defectos[95], i, 158);
                jTable1.setValueAt(defectos[96], i, 159);
                jTable1.setValueAt(defectos[97], i, 160);
                jTable1.setValueAt(defectos[98], i, 161);
                jTable1.setValueAt(defectos[99], i, 162);
                jTable1.setValueAt(defectos[100], i, 163);
                jTable1.setValueAt(defectos[101], i, 164);
                jTable1.setValueAt(defectos[102], i, 165);
                jTable1.setValueAt(defectos[103], i, 166);
                jTable1.setValueAt(defectos[104], i, 167);
                jTable1.setValueAt(defectos[105], i, 168);
                jTable1.setValueAt(defectos[106], i, 169);
                jTable1.setValueAt(defectos[107], i, 170);
                jTable1.setValueAt(defectos[108], i, 171);
                jTable1.setValueAt(defectos[109], i, 172);
                jTable1.setValueAt(defectos[110], i, 173);
                jTable1.setValueAt(defectos[111], i, 174);
                jTable1.setValueAt(defectos[112], i, 175);
                jTable1.setValueAt(defectos[113], i, 176);
                jTable1.setValueAt(defectos[114], i, 177);
                jTable1.setValueAt(defectos[115], i, 178);
                jTable1.setValueAt(defectos[116], i, 179);
                jTable1.setValueAt(defectos[117], i, 180);
                jTable1.setValueAt(defectos[118], i, 181);
                jTable1.setValueAt(defectos[119], i, 182);
                jTable1.setValueAt(defectos[120], i, 183);
                jTable1.setValueAt(defectos[121], i, 184);
                jTable1.setValueAt(defectos[122], i, 185);
                jTable1.setValueAt(defectos[123], i, 186);
                jTable1.setValueAt(defectos[124], i, 187);
                jTable1.setValueAt(defectos[125], i, 188);
                jTable1.setValueAt(defectos[126], i, 189);
                jTable1.setValueAt(defectos[127], i, 190);
                jTable1.setValueAt(defectos[128], i, 191);
                jTable1.setValueAt(defectos[129], i, 192);
                jTable1.setValueAt(defectos[130], i, 193);
                jTable1.setValueAt(defectos[131], i, 194);
                jTable1.setValueAt(defectos[132], i, 195);
                jTable1.setValueAt(defectos[133], i, 196);
                jTable1.setValueAt(defectos[134], i, 197);
                jTable1.setValueAt(defectos[135], i, 198);
                jTable1.setValueAt(defectos[136], i, 199);
 //               jTable1.setValueAt(defectos[137], i, 200);
//                jTable1.setValueAt(defectos[138], i, 201);
            }

       
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
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CSM", "Fecha Llegada", "Tomada Por", "Fecha Lote", "Proceso Cafe", "Forma Cafe", "Peso", "Sacos", "Beneficio", "Lote", "Certificado", "Sociedad", "Predio", "Comunidad", "Calidad Cereza", "Peso Ev", "Humedad C", "Humedad O", "Metado Secado", "Densidad Oro", "Peso Criba", "Uniformidad", "Color Oro", "Agua", "Numero Tazas", "Comentario 1", "Comentario 2", "Comentario 3", "Fecha Evaluacion A", "Evaluador", "Fecha Evaluacion T", "Evaluado Por", "Nivel Tostado", "Uniformidad", "Quakers", "Seco", "Cualidades Seco", "Mojado", "Quebrado", "Cualidades Mojado/Quebrado", "Sabor", "Cualidades Sabor", "Sabor Remanente", "Cualidades Sabor R", "Acidez", "Cualidades Acidez", "Intensidad Acidez", "Cuerpo", "Cualidades Cuerpo", "Intensidad Cuerpo", "Balance", "Uniformidad Taza", "Taza Limpia", "Dulzor", "Num Tazas", "Intensidad Defectos", "Catador", "Peso 19", "Peso 18", "Peso 17", "Peso 16", "Peso 15", "Peso F", "Broca Severa 19", "Broca 19", "Negro 19", "Negro Parcial 19", "Agrio 19", "Agrio Parcial 19", "Aplastado 19", "Daño o Mordido 19", "Daño y Agrio Parcial 19", "Blanco/Flotador 19", "Elefante 19", "Concha 19", "Malformado 19", "Daño por Hongos 19", "Inmaduro 19", "Sobresecado 19", "Arrugado 19", "Grano Humedo 19", "Quebrado 19", "Cereza Seca 19", "Pergamino 19", "Cascara o Pulpa Seca 19", "Materia Extraña 19", "Broca Severa 18", "Broca 18", "Negro 18", "Negro Parcial 18", "Agrio 18", "Agrio Parcial 18", "Aplastado 18", "Daño o Mordido 18", "Daño y Agrio Parcial 18", "Blanco/Flotador 18", "Elefante 18", "Concha 18", "Malformado 18", "Daño por Hongos 18", "Inmaduro 18", "Sobresecado 18", "Arrugado 18", "Grano Humedo 18", "Quebrado 18", "Cereza Seca 18", "Pergamino 18", "Cascara o Pulpa Seca 18", "Materia Extraña 18", "Broca Severa 17", "Broca 17", "Negro 17", "Negro Parcial 17", "Agrio 17", "Agrio Parcial 17", "Aplastado 17", "Daño o Mordido 17", "Daño y Agrio Parcial 17", "Blanco/Flotador 17", "Elefante 17", "Concha 17", "Malformado 17", "Daño por Hongos 17", "Inmaduro 17", "Sobresecado 17", "Arrugado 17", "Grano Humedo 17", "Quebrado 17", "Cereza Seca 17", "Pergamino 17", "Cascara o Pulpa Seca 17", "Materia Extraña 17", "Broca Severa 16", "Broca 16", "Negro 16", "Negro Parcial 16", "Agrio 16", "Agrio Parcial 16", "Aplastado 16", "Daño o Mordido 16", "Daño y Agrio Parcial 16", "Blanco/Flotador 16", "Elefante 16", "Concha 16", "Malformado 16", "Daño por Hongos 16", "Inmaduro 16", "Sobresecado 16", "Arrugado 16", "Grano Humedo 16", "Quebrado 16", "Cereza Seca 16", "Pergamino 16", "Cascara o Pulpa Seca 16", "Materia Extraña 16", "Broca Severa 15", "Broca 15", "Negro 15", "Negro Parcial 15", "Agrio 15", "Agrio Parcial 15", "Aplastado 15", "Daño o Mordido 15", "Daño y Agrio Parcial 15", "Blanco/Flotador 15", "Elefante 15", "Concha 15", "Malformado 15", "Daño por Hongos 15", "Inmaduro 15", "Sobresecado 15", "Arrugado 15", "Grano Humedo 15", "Quebrado 15", "Cereza Seca 15", "Pergamino 15", "Cascara o Pulpa Seca 15", "Materia Extraña 15", "Broca Severa F", "Broca F", "Negro F", "Negro Parcial F", "Agrio F", "Agrio Parcial F", "Aplastado F", "Daño o Mordido F", "Daño y Agrio Parcial F", "Blanco/Flotador F", "Elefante F", "Concha F", "Malformado F", "Daño por Hongos F", "Inmaduro F", "Sobresecado F", "Arrugado F", "Grano Humedo F", "Quebrado F", "Cereza Seca F", "Pergamino F", "Cascara o Pulpa Seca F", "Materia Extraña F"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CSM", "# Criba Peso", "Defectos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMinWidth(35);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(35);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(35);
            jTable2.getColumnModel().getColumn(1).setMinWidth(150);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable2.getColumnModel().getColumn(1).setMaxWidth(150);
        }

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Peso 19", "Peso 18", "Peso 17", "Peso 16", "Peso 15", "Peso F"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
