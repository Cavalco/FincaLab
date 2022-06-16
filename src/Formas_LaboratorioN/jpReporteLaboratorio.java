/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_LaboratorioN;

import Conexion.Conexion;
import Formas_laboratorio.excel;
import Formas_laboratorio.jpBitacora;
import Metodos_Configuraciones.metodosDatosBasicos;
import Metodos_Configuraciones.metodosLaboratorio;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

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
    DefaultTableModel modelo;
    jdEvaluacion jdEA;
    jdCatacion2 jdc;

    public jpReporteLaboratorio(Connection cn, String Idioma) {
        initComponents();

        this.cn = cn;
        mL = new metodosLaboratorio(cn, "");
        modelo = (DefaultTableModel) tablaBitacora.getModel();

        llenarTabla();

        //  separarDefectos();
    }

    public void llenarTabla() {
        limpiar(tablaBitacora);
        //limpiar(jTable3);

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
                + "    '' as 'Predio',\n"
                + "    b.comunidad as 'Comunidad',\n"
                + "    b.calidadcereza as 'Calidad Cereza',\n"
                + "    d.PesoEv as 'Peso Ev',\n"
                + "    d.humedad_c as 'Humedad C',\n"
                + "    d.humedad_o as 'Humedad O',\n"
                + "    b.Metodosecado as 'Metodo Secado',\n"
                + "    d.Densidadoro as 'Densidad Oro',\n"
                + "    '' as 'Peso Criba#',\n"
                + "    d.uniformidad as 'Uniformidad Oro',\n"
                + "    d.color as 'Color Oro',\n"
                + "    '' as 'Agua',\n"
                + "    t.numerotazas as 'Numero Tazas',\n"
                + "    b.observacionesMuestra as 'Coment1',\n"
                + "    d.observaciones as 'Coment2',\n"
                + "    '' as 'Coment3',\n"
                + "    d.fecha as 'Fecha Ev Asp',\n"
                + "    d.evaluador as 'Evaluador',\n"
                + "    t.fecha as 'Fecha Ev Taz',\n"
                + "    t.catadornom as 'Evaluado Por',\n"
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

        procesos();
    }

    public void procesos() {

        //       JOptionPane.showMessageDialog(null, jTable1.getRowCount());
        for (int i = 0; i < tablaBitacora.getRowCount(); i++) {
            String peso = tablaBitacora.getValueAt(i, 57) + "";
            //JOptionPane.showMessageDialog(null, peso);

            if (peso.equals("null")) {

            } else {
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

                tablaBitacora.setValueAt(peso19, i, 57);
                tablaBitacora.setValueAt(peso18, i, 58);
                tablaBitacora.setValueAt(peso17, i, 59);
                tablaBitacora.setValueAt(peso16, i, 60);
                tablaBitacora.setValueAt(peso15, i, 61);
                tablaBitacora.setValueAt(pesoF, i, 62);

                String cadenaDefectos = tablaBitacora.getValueAt(i, 63) + "";
                String defectos[] = cadenaDefectos.split(",");
                //Peso Criba 19
                //jTable1.setValueAt(defectos[0], i, 63);
                tablaBitacora.setValueAt(defectos[1], i, 63);
                tablaBitacora.setValueAt(defectos[2], i, 64);
                tablaBitacora.setValueAt(defectos[3], i, 65);
                tablaBitacora.setValueAt(defectos[4], i, 66);
                tablaBitacora.setValueAt(defectos[5], i, 67);
                tablaBitacora.setValueAt(defectos[6], i, 68);
                tablaBitacora.setValueAt(defectos[7], i, 69);
                tablaBitacora.setValueAt(defectos[8], i, 70);
                tablaBitacora.setValueAt(defectos[9], i, 71);
                tablaBitacora.setValueAt(defectos[10], i, 72);
                tablaBitacora.setValueAt(defectos[11], i, 73);
                tablaBitacora.setValueAt(defectos[12], i, 74);
                tablaBitacora.setValueAt(defectos[13], i, 75);
                tablaBitacora.setValueAt(defectos[14], i, 76);
                tablaBitacora.setValueAt(defectos[15], i, 77);
                tablaBitacora.setValueAt(defectos[16], i, 78);
                tablaBitacora.setValueAt(defectos[17], i, 79);
                //Grano Humedo 19                            
                //jTable1.setValueAt(defectos[18], i, 79);
                tablaBitacora.setValueAt(defectos[19], i, 80);
                tablaBitacora.setValueAt(defectos[20], i, 81);
                tablaBitacora.setValueAt(defectos[21], i, 82);
                tablaBitacora.setValueAt(defectos[22], i, 83);
                tablaBitacora.setValueAt(defectos[23], i, 84);
                //Peso Criba 18                
                //jTable1.setValueAt(defectos[24], i, 87);
                tablaBitacora.setValueAt(defectos[25], i, 85);
                tablaBitacora.setValueAt(defectos[26], i, 86);
                tablaBitacora.setValueAt(defectos[27], i, 87);
                tablaBitacora.setValueAt(defectos[28], i, 88);
                tablaBitacora.setValueAt(defectos[29], i, 89);
                tablaBitacora.setValueAt(defectos[30], i, 90);
                tablaBitacora.setValueAt(defectos[31], i, 91);
                tablaBitacora.setValueAt(defectos[32], i, 92);
                tablaBitacora.setValueAt(defectos[33], i, 93);
                tablaBitacora.setValueAt(defectos[34], i, 94);
                tablaBitacora.setValueAt(defectos[35], i, 95);
                tablaBitacora.setValueAt(defectos[36], i, 96);
                tablaBitacora.setValueAt(defectos[37], i, 97);
                tablaBitacora.setValueAt(defectos[38], i, 98);
                tablaBitacora.setValueAt(defectos[39], i, 99);
                tablaBitacora.setValueAt(defectos[40], i, 100);
                tablaBitacora.setValueAt(defectos[41], i, 101);
                //Grano Humedo 18
                //jTable1.setValueAt(defectos[42], i, 101);
                tablaBitacora.setValueAt(defectos[43], i, 102);
                tablaBitacora.setValueAt(defectos[44], i, 103);
                tablaBitacora.setValueAt(defectos[45], i, 104);
                tablaBitacora.setValueAt(defectos[46], i, 105);
                tablaBitacora.setValueAt(defectos[47], i, 106);
                //Peso Criba 17
                //jTable1.setValueAt(defectos[48], i, 111);
                tablaBitacora.setValueAt(defectos[49], i, 107);
                tablaBitacora.setValueAt(defectos[50], i, 108);
                tablaBitacora.setValueAt(defectos[51], i, 109);
                tablaBitacora.setValueAt(defectos[52], i, 110);
                tablaBitacora.setValueAt(defectos[53], i, 111);
                tablaBitacora.setValueAt(defectos[54], i, 112);
                tablaBitacora.setValueAt(defectos[55], i, 113);
                tablaBitacora.setValueAt(defectos[56], i, 114);
                tablaBitacora.setValueAt(defectos[57], i, 115);
                tablaBitacora.setValueAt(defectos[58], i, 116);
                tablaBitacora.setValueAt(defectos[59], i, 117);
                tablaBitacora.setValueAt(defectos[60], i, 118);
                tablaBitacora.setValueAt(defectos[61], i, 119);
                tablaBitacora.setValueAt(defectos[62], i, 120);
                tablaBitacora.setValueAt(defectos[63], i, 121);
                tablaBitacora.setValueAt(defectos[64], i, 122);
                tablaBitacora.setValueAt(defectos[65], i, 123);
                //Grano Humedo 17                
                //jTable1.setValueAt(defectos[66], i, 123);
                tablaBitacora.setValueAt(defectos[67], i, 124);
                tablaBitacora.setValueAt(defectos[68], i, 125);
                tablaBitacora.setValueAt(defectos[69], i, 126);
                tablaBitacora.setValueAt(defectos[70], i, 127);
                tablaBitacora.setValueAt(defectos[71], i, 128);
                //Peso Criba 16                
                // jTable1.setValueAt(defectos[72], i, 135);
                tablaBitacora.setValueAt(defectos[73], i, 129);
                tablaBitacora.setValueAt(defectos[74], i, 130);
                tablaBitacora.setValueAt(defectos[75], i, 131);
                tablaBitacora.setValueAt(defectos[76], i, 132);
                tablaBitacora.setValueAt(defectos[77], i, 133);
                tablaBitacora.setValueAt(defectos[78], i, 134);
                tablaBitacora.setValueAt(defectos[79], i, 135);
                tablaBitacora.setValueAt(defectos[80], i, 136);
                tablaBitacora.setValueAt(defectos[81], i, 137);
                tablaBitacora.setValueAt(defectos[82], i, 138);
                tablaBitacora.setValueAt(defectos[83], i, 139);
                tablaBitacora.setValueAt(defectos[84], i, 140);
                tablaBitacora.setValueAt(defectos[85], i, 141);
                tablaBitacora.setValueAt(defectos[86], i, 142);
                tablaBitacora.setValueAt(defectos[87], i, 143);
                tablaBitacora.setValueAt(defectos[88], i, 144);
                tablaBitacora.setValueAt(defectos[89], i, 145);
                //Grano Humedo 16               
                // jTable1.setValueAt(defectos[90], i, 145);
                tablaBitacora.setValueAt(defectos[91], i, 146);
                tablaBitacora.setValueAt(defectos[92], i, 147);
                tablaBitacora.setValueAt(defectos[93], i, 148);
                tablaBitacora.setValueAt(defectos[94], i, 149);
                tablaBitacora.setValueAt(defectos[95], i, 150);
                //Peso Criba 15
                // jTable1.setValueAt(defectos[96], i, 159);
                tablaBitacora.setValueAt(defectos[97], i, 151);
                tablaBitacora.setValueAt(defectos[98], i, 152);
                tablaBitacora.setValueAt(defectos[99], i, 153);
                tablaBitacora.setValueAt(defectos[100], i, 154);
                tablaBitacora.setValueAt(defectos[101], i, 155);
                tablaBitacora.setValueAt(defectos[102], i, 156);
                tablaBitacora.setValueAt(defectos[103], i, 157);
                tablaBitacora.setValueAt(defectos[104], i, 158);
                tablaBitacora.setValueAt(defectos[105], i, 159);
                tablaBitacora.setValueAt(defectos[106], i, 160);
                tablaBitacora.setValueAt(defectos[107], i, 161);
                tablaBitacora.setValueAt(defectos[108], i, 162);
                tablaBitacora.setValueAt(defectos[109], i, 163);
                tablaBitacora.setValueAt(defectos[110], i, 164);
                tablaBitacora.setValueAt(defectos[111], i, 165);
                tablaBitacora.setValueAt(defectos[112], i, 166);
                tablaBitacora.setValueAt(defectos[113], i, 167);
                //Grano Humedo 15
                //jTable1.setValueAt(defectos[114], i, 167);
                tablaBitacora.setValueAt(defectos[115], i, 168);
                tablaBitacora.setValueAt(defectos[116], i, 169);
                tablaBitacora.setValueAt(defectos[117], i, 170);
                tablaBitacora.setValueAt(defectos[118], i, 171);
                tablaBitacora.setValueAt(defectos[119], i, 172);
                //Peso Criba F                
                //jTable1.setValueAt(defectos[120], i, 183);
                tablaBitacora.setValueAt(defectos[121], i, 173);
                tablaBitacora.setValueAt(defectos[122], i, 174);
                tablaBitacora.setValueAt(defectos[123], i, 175);
                tablaBitacora.setValueAt(defectos[124], i, 176);
                tablaBitacora.setValueAt(defectos[125], i, 177);
                tablaBitacora.setValueAt(defectos[126], i, 178);
                tablaBitacora.setValueAt(defectos[127], i, 179);
                tablaBitacora.setValueAt(defectos[128], i, 180);
                tablaBitacora.setValueAt(defectos[129], i, 181);
                tablaBitacora.setValueAt(defectos[130], i, 182);
                tablaBitacora.setValueAt(defectos[131], i, 183);
                tablaBitacora.setValueAt(defectos[132], i, 184);
                tablaBitacora.setValueAt(defectos[133], i, 185);
                tablaBitacora.setValueAt(defectos[134], i, 186);
                tablaBitacora.setValueAt(defectos[135], i, 187);
                tablaBitacora.setValueAt(defectos[136], i, 188);
                tablaBitacora.setValueAt(defectos[137], i, 189);
                //Grano Humedo F
                //jTable1.setValueAt(defectos[138], i, 189);
                tablaBitacora.setValueAt(defectos[139], i, 190);
                tablaBitacora.setValueAt(defectos[140], i, 191);
                tablaBitacora.setValueAt(defectos[141], i, 192);
                tablaBitacora.setValueAt(defectos[142], i, 193);
                tablaBitacora.setValueAt(defectos[143], i, 194);
            }
            //Separar cualidades Seco
            String cadenaSeco = tablaBitacora.getValueAt(i, 36) + "";
            if (cadenaSeco.equals("null")) {
                // JOptionPane.showMessageDialog(null, "Valí Seco");
            } else {
                String cualidadesSeco[] = cadenaSeco.split(",");
                cadenaSeco = cualidadesSeco[0];
                cualidadesSeco = cadenaSeco.split(":");
                tablaBitacora.setValueAt(cualidadesSeco[1], i, 36);
            }
            //Separar cualidades MojadoQuebrado
            String cadenaMojQue = tablaBitacora.getValueAt(i, 39) + "";
            if (cadenaMojQue.equals("null")) {
                // JOptionPane.showMessageDialog(null, "Valí Mojado");
            } else {
                String cualidadesMojQue[] = cadenaMojQue.split(",");
                cadenaMojQue = cualidadesMojQue[1];
                cualidadesMojQue = cadenaMojQue.split(":");
                tablaBitacora.setValueAt(cualidadesMojQue[1], i, 39);
            }
            //Separar cualidades Sabor
            String cadenaSabor = tablaBitacora.getValueAt(i, 41) + "";
            if (cadenaSabor.equals("null")) {
                // JOptionPane.showMessageDialog(null, "Valí Sabor");
            } else {
                String cualidadesSabor[] = cadenaSabor.split(",");
                cadenaSabor = cualidadesSabor[0];
                cualidadesSabor = cadenaSabor.split(":");
                tablaBitacora.setValueAt(cualidadesSabor[1], i, 41);
            }
            //Separar cualidades Remanente
            String cadenaRemanente = tablaBitacora.getValueAt(i, 43) + "";
            if (cadenaRemanente.equals("null")) {
                // JOptionPane.showMessageDialog(null, "Valí Remanente");
            } else {
                String cualidadesRemanente[] = cadenaRemanente.split(",");
                cadenaRemanente = cualidadesRemanente[1];
                cualidadesRemanente = cadenaRemanente.split(":");
                tablaBitacora.setValueAt(cualidadesRemanente[1], i, 43);
            }
            //Separar cualidades Acidez
            String cadenaAcidez = tablaBitacora.getValueAt(i, 45) + "";
            if (cadenaAcidez.equals("null")) {
                // JOptionPane.showMessageDialog(null, "Valí Acidez");
            } else {
                String cualidadesAcidez[] = cadenaAcidez.split(",");
                cadenaAcidez = cualidadesAcidez[2];
                cualidadesAcidez = cadenaAcidez.split(":");
                tablaBitacora.setValueAt(cualidadesAcidez[1], i, 45);
            }
            //Separar cualidades Cuerpo
            String cadenaCuerpo = tablaBitacora.getValueAt(i, 48) + "";
            if (cadenaCuerpo.equals("null")) {
                //  JOptionPane.showMessageDialog(null, "Valí Cuerpo");
            } else {
                String cualidadesCuerpo[] = cadenaCuerpo.split(",");
                cadenaCuerpo = cualidadesCuerpo[3];
                cualidadesCuerpo = cadenaCuerpo.split(":");
                tablaBitacora.setValueAt(cualidadesCuerpo[1], i, 48);
            }
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBitacora = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jMenuItem1.setText("Evaluacion Por Aspecto");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Evaluacion Por Taza");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        jMenuItem3.setText("Reporte Individual");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem3);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablaBitacora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CSM", "Fecha Llegada", "Tomada Por", "Fecha Lote", "Proceso Cafe", "Forma Cafe", "Peso", "Sacos", "Beneficio", "Lote", "Certificado", "Sociedad", "Predio", "Comunidad", "Calidad Cereza", "Peso Ev", "Humedad C", "Humedad O", "Metado Secado", "Densidad Oro", "Peso Criba", "Uniformidad", "Color Oro", "Agua", "Numero Tazas", "Comentario 1", "Comentario 2", "Comentario 3", "Fecha Evaluacion A", "Evaluador", "Fecha Evaluacion T", "Evaluado Por", "Nivel Tostado", "Uniformidad", "Quakers", "Seco", "Cualidades Seco", "Mojado", "Quebrado", "Cualidades Mojado/Quebrado", "Sabor", "Cualidades Sabor", "Sabor Remanente", "Cualidades Sabor R", "Acidez", "Cualidades Acidez", "Intensidad Acidez", "Cuerpo", "Cualidades Cuerpo", "Intensidad Cuerpo", "Balance", "Uniformidad Taza", "Taza Limpia", "Dulzor", "Num Tazas", "Intensidad Defectos", "Catador", "Peso 19", "Peso 18", "Peso 17", "Peso 16", "Peso 15", "Peso F", "Broca Severa 19", "Broca 19", "Negro 19", "Negro Parcial 19", "Agrio 19", "Agrio Parcial 19", "Aplastado 19", "Daño o Mordido 19", "Daño y Agrio Parcial 19", "Blanco/Flotador 19", "Elefante 19", "Concha 19", "Malformado 19", "Daño por Hongos 19", "Inmaduro 19", "Sobresecado 19", "Arrugado 19", "Quebrado 19", "Cereza Seca 19", "Pergamino 19", "Cascara o Pulpa Seca 19", "Materia Extraña 19", "Broca Severa 18", "Broca 18", "Negro 18", "Negro Parcial 18", "Agrio 18", "Agrio Parcial 18", "Aplastado 18", "Daño o Mordido 18", "Daño y Agrio Parcial 18", "Blanco/Flotador 18", "Elefante 18", "Concha 18", "Malformado 18", "Daño por Hongos 18", "Inmaduro 18", "Sobresecado 18", "Arrugado 18", "Quebrado 18", "Cereza Seca 18", "Pergamino 18", "Cascara o Pulpa Seca 18", "Materia Extraña 18", "Broca Severa 17", "Broca 17", "Negro 17", "Negro Parcial 17", "Agrio 17", "Agrio Parcial 17", "Aplastado 17", "Daño o Mordido 17", "Daño y Agrio Parcial 17", "Blanco/Flotador 17", "Elefante 17", "Concha 17", "Malformado 17", "Daño por Hongos 17", "Inmaduro 17", "Sobresecado 17", "Arrugado 17", "Quebrado 17", "Cereza Seca 17", "Pergamino 17", "Cascara o Pulpa Seca 17", "Materia Extraña 17", "Broca Severa 16", "Broca 16", "Negro 16", "Negro Parcial 16", "Agrio 16", "Agrio Parcial 16", "Aplastado 16", "Daño o Mordido 16", "Daño y Agrio Parcial 16", "Blanco/Flotador 16", "Elefante 16", "Concha 16", "Malformado 16", "Daño por Hongos 16", "Inmaduro 16", "Sobresecado 16", "Arrugado 16", "Quebrado 16", "Cereza Seca 16", "Pergamino 16", "Cascara o Pulpa Seca 16", "Materia Extraña 16", "Broca Severa 15", "Broca 15", "Negro 15", "Negro Parcial 15", "Agrio 15", "Agrio Parcial 15", "Aplastado 15", "Daño o Mordido 15", "Daño y Agrio Parcial 15", "Blanco/Flotador 15", "Elefante 15", "Concha 15", "Malformado 15", "Daño por Hongos 15", "Inmaduro 15", "Sobresecado 15", "Arrugado 15", "Quebrado 15", "Cereza Seca 15", "Pergamino 15", "Cascara o Pulpa Seca 15", "Materia Extraña 15", "Broca Severa F", "Broca F", "Negro F", "Negro Parcial F", "Agrio F", "Agrio Parcial F", "Aplastado F", "Daño o Mordido F", "Daño y Agrio Parcial F", "Blanco/Flotador F", "Elefante F", "Concha F", "Malformado F", "Daño por Hongos F", "Inmaduro F", "Sobresecado F", "Arrugado F", "Quebrado F", "Cereza Seca F", "Pergamino F", "Cascara o Pulpa Seca F", "Materia Extraña F"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaBitacora.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaBitacora.setComponentPopupMenu(jPopupMenu1);
        tablaBitacora.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaBitacora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBitacoraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaBitacora);

        jButton1.setText("Exportar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
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

    public void exportarExcel(JTable t) throws IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".csv");
            try {
                File archivoXLS = new File(ruta);
                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                }
                archivoXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
                Sheet hoja = libro.createSheet("Reporte Laboratorio");
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            exportarExcel(tablaBitacora);
        } catch (IOException ex) {
            Logger.getLogger(jpReporteLaboratorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    String id = "";
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //EVALUACION POR ASPECTO
        if (!csm.equals("")) {
            id = mL.comprobarExistencia("select id_bitacora from bitacoralab "
                    + "where (id_muestra='" + csm + "' and comunidad='" + comunidad + "')");
            //System.out.println(id + csm + comunindad + tipo + forma);
            jdEA = new jdEvaluacion(cn, id, csm, comunidad, proceso, forma, calCer, "");

            jdEA.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    String csm = "", comunidad = "", proceso = "", forma = "", calCer = "",taza="";
    private void tablaBitacoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBitacoraMouseClicked
        // TODO add your handling code here:
        csm = tablaBitacora.getValueAt(tablaBitacora.getSelectedRow(), 0) + "";
        comunidad = tablaBitacora.getValueAt(tablaBitacora.getSelectedRow(), 13) + "";
        proceso = tablaBitacora.getValueAt(tablaBitacora.getSelectedRow(), 4) + "";
        forma = tablaBitacora.getValueAt(tablaBitacora.getSelectedRow(), 5) + "";
        calCer = mL.devuelveUnDato("select calidadcereza from bitacoralab "
                + "where (id_muestra='" + csm + "' and comunidad='" + comunidad + "')");
        taza = mL.devuelveUnDato("select taza from bitacoralab "
                + "where (id_muestra='" + csm + "' and comunidad='" + comunidad + "')");
        /* csm = tablabitacora.getValueAt(tablabitacora.getSelectedRow(), 0) + "";
        tipo = tablabitacora.getValueAt(tablabitacora.getSelectedRow(), 2) + "";
        forma = tablabitacora.getValueAt(tablabitacora.getSelectedRow(), 3) + "";
        kgconfirm = tablabitacora.getValueAt(tablabitacora.getSelectedRow(), 9) + "";
        comunindad = tablabitacora.getValueAt(tablabitacora.getSelectedRow(), 11) + "";
        estatus = tablabitacora.getValueAt(tablabitacora.getSelectedRow(), 12) + "";
        aspecto = mdb.devuelveUnDato("select aspecto from bitacoralab "
                + "where (id_muestra='" + csm + "' and comunidad='" + comunindad + "')");
        taza = mdb.devuelveUnDato("select taza from bitacoralab "
                + "where (id_muestra='" + csm + "' and comunidad='" + comunindad + "')");
        mezasig = mdb.devuelveUnDato("select mezasig from bitacoralab "
                + "where (id_muestra='" + csm + "' and comunidad='" + comunindad + "')");
        calcer = mdb.devuelveUnDato("select calidadcereza from bitacoralab "
                + "where (id_muestra='" + csm + "' and comunidad='" + comunindad + "')");
        kgconfirm = mdb.devuelveUnDato("select Kgconfirm from bitacoralab "
                + "where (id_muestra='" + csm + "' and comunidad='" + comunindad + "')");
        /*if (kgconfirm.equals("1")) {
            yn.setText(idioma.getProperty("Si"));
            yn.setForeground(Color.green);
            kgyn.setEnabled(false);
        } else {
            yn.setText(idioma.getProperty("No"));
            yn.setForeground(Color.red);
            kgyn.setEnabled(true);
        }*/
 /*   if (estatus.equals(idioma.getProperty("Desactivada"))) {
            jMenuItem4.setText(idioma.getProperty("Activar"));
            System.out.println(estatus);
        } else {
            jMenuItem4.setText(idioma.getProperty("Desactivar"));
        }
        if (taza.equals("1") || aspecto.equals("0")) {
            evtaza.setEnabled(false);
            System.out.println(estatus);
        } else {
            evtaza.setEnabled(true);
        }
        if (aspecto.equals("1")) {
            evaspecto.setEnabled(false);
            System.out.println(estatus);
        } else {
            evaspecto.setEnabled(true);
        }
        if (aspecto.equals("1")/**
                 * && taza.equals("1")
         */
 /*      )
        {
            jMenuItem1.setEnabled(true);
            System.out.println(estatus);
        }else {
            jMenuItem1.setEnabled(false);
        }
        if (aspecto.equals("1") && taza.equals("1") && mezasig.equals("0")) {
            mezcla.setEnabled(true);
            System.out.println(estatus);
        } else {
            mezcla.setEnabled(false);
        }
        if (taza.equals("1")) {
            sabores.setEnabled(true);
            System.out.println(estatus);
        } else {
            sabores.setEnabled(false);
        }

        if (kgconfirm.equals("1")) {
            kgConfirmados.setText("Kg Confimados");
            kgConfirmados.setForeground(Color.green);
        } else {
            kgConfirmados.setText("Kg No Confirmados");
            kgConfirmados.setForeground(Color.red);
        }  */

    }//GEN-LAST:event_tablaBitacoraMouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        //EVALUACION POR TAZA
        if (!csm.equals("")) {
            id = mL.comprobarExistencia("select id_bitacora from bitacoralab "
                    + "where (id_muestra='" + csm + "' and comunidad='" + comunidad + "')");

            jdc = new jdCatacion2(cn, proceso, id, csm, comunidad, forma);
//Modificar para refrescar
//          jdc.jpCT = this;
            jdc.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    excel excel = new excel();
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        //REPORTE INDIVIDUAL
            id = mL.devuelveUnDato("select id_bitacora from bitacoralab "
                + "where (id_muestra='" + csm + "' and comunidad='" + comunidad + "')");
        try {
            excel.datos(cn, csm, id, taza, "");      // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(jpBitacora.class.getName()).log(Level.SEVERE, null, ex);
        }

        Barra_progreso b = new Barra_progreso();
        b.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaBitacora;
    // End of variables declaration//GEN-END:variables
}
