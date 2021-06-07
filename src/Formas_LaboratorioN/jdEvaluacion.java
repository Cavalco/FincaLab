/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_LaboratorioN;

import Formas_laboratorio.jpBitacora;
import Idioma.Propiedades;
import Metodos_Configuraciones.metodosLaboratorio;
import java.awt.Dimension;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import static java.lang.Integer.parseInt;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author jCarl
 */
public class jdEvaluacion extends javax.swing.JFrame {

    /**
     * Creates new form jdEvaluacion
     */
    Propiedades idioma;
    String Idioma;
    metodosLaboratorio mdb;
    Connection cn;
    String csm = "", comunindad = "", tipo = "", id, forma = "";
    jpBitacora jpDP;
    DecimalFormat df;

    public jdEvaluacion(Connection cn, String id, String csm, String comunindad, String tipoc, String forma, String calcer, String idioma) {
        initComponents();

        setLocationRelativeTo(null);
        this.cn = cn;
        this.csm = csm;
        this.comunindad = comunindad;

        this.tipo = tipoc;
        this.forma = forma;
        this.id = id;
        lblCSM.setText(csm);
        lblComunidad.setText(comunindad);
        lblTipo.setText(tipoc);
        lblForma.setText(forma);
        lblCalC.setText(calcer);
        mdb = new metodosLaboratorio(cn, "");

        df = new DecimalFormat("#.0");

    }

    //Metodo para guardar la evaluación
    public void guardar() {
        String fecha = "";
        if (dcFechaE.getDate() != null) {
            fecha = new SimpleDateFormat("dd-MMM-yyyy").format(dcFechaE.getDate());
        } //se extrae la fecha del calendario y se guarda en una variable 
        String g[] = new String[3];
        String estatus = "A";
        g[0] = "insert into cribas values (null," + id + ",'19',"
                + "'" + A1.getText() + "," + B1.getText() + "," + C1.getText() + "," + D1.getText() + "," + E1.getText() + "," + F1.getText() + "," + G1.getText() + "," + H1.getText() + "," + I1.getText() + ","+ O1.getText() + "," + J1.getText() + "," + K1.getText() + "," + L1.getText() + "," + M1.getText() + "," + N1.getText() + "," 
                + "" + P1.getText() + "," + Q1.getText() + "," + R1.getText() + "," + S1.getText() + "," + T1.getText() + "," + U1.getText() + "," + V1.getText() + "," + W1.getText() + "," + X1.getText() + "'),(null," + id + ",'18','" + A2.getText() + "," + B2.getText() + "," + C2.getText() + "," + D2.getText() + "," + E2.getText() + "," + F2.getText() + "," + G2.getText() + "," + H2.getText() + "," + I2.getText() + ","+ O2.getText() + ","   + J2.getText() + "," + K2.getText() + "," + L2.getText() + "," + M2.getText() + "," + N2.getText() + "," 
                + "" + P2.getText() + "," + Q2.getText() + "," + R2.getText() + "," + S2.getText() + "," + T2.getText() + "," + U2.getText() + "," + V2.getText() + "," + W2.getText() + "," + X2.getText() + "'),(null," + id + ",'17','" + A3.getText() + "," + B3.getText() + "," + C3.getText() + "," + D3.getText() + "," + E3.getText() + "," + F3.getText() + "," + G3.getText() + "," + H3.getText() + "," + I3.getText() + ","+ O3.getText() + "," + J3.getText() + "," + K3.getText() + "," + L3.getText() + "," + M3.getText() + "," + N3.getText() + "," 
                + "" + P3.getText() + "," + Q3.getText() + "," + R3.getText() + "," + S3.getText() + "," + T3.getText() + "," + U3.getText() + "," + V3.getText() + "," + W3.getText() + "," + X3.getText() + "'),(null," + id + ",'16','" + A4.getText() + "," + B4.getText() + "," + C4.getText() + "," + D4.getText() + "," + E4.getText() + "," + F4.getText() + "," + G4.getText() + "," + H4.getText() + "," + I4.getText() + ","+ O4.getText() + "," + J4.getText() + "," + K4.getText() + "," + L4.getText() + "," + M4.getText() + "," + N4.getText() + "," 
                + "" + P4.getText() + "," + Q4.getText() + "," + R4.getText() + "," + S4.getText() + "," + T4.getText() + "," + U4.getText() + "," + V4.getText() + "," + W4.getText() + "," + X4.getText() + "'),(null," + id + ",'15','" + A5.getText() + "," + B5.getText() + "," + C5.getText() + "," + D5.getText() + "," + E5.getText() + "," + F5.getText() + "," + G5.getText() + "," + H5.getText() + "," + I5.getText() + ","+ O5.getText() + "," + J5.getText() + "," + K5.getText() + "," + L5.getText() + "," + M5.getText() + "," + N5.getText() + "," 
                + "" + P5.getText() + "," + Q5.getText() + "," + R5.getText() + "," + S5.getText() + "," + T5.getText() + "," + U5.getText() + "," + V5.getText() + "," + W5.getText() + "," + X5.getText() + "'),(null," + id + ",'F','" + A6.getText() + "," + B6.getText() + "," + C6.getText() + "," + D6.getText() + "," + E6.getText() + "," + F6.getText() + "," + G6.getText() + "," + H6.getText() + "," + I6.getText() + ","+ O6.getText() + "," + J6.getText() + "," + K6.getText() + "," + L6.getText() + "," + M6.getText() + "," + N6.getText() + "," 
                + "" + P6.getText() + "," + Q6.getText() + "," + R6.getText() + "," + S6.getText() + "," + T6.getText() + "," + U6.getText() + "," + V6.getText() + "," + W6.getText() + "," + X6.getText() + "'),(null," + id + ",'TOTAL','" + AT.getText() + "," + BT.getText() + "," + CT.getText() + "," + DT.getText() + "," + ET.getText() + "," + FT.getText() + "," + GT.getText() + "," + HT.getText() + "," + IT.getText() + ","+ OT.getText() + "," + JT.getText() + "," + KT.getText() + "," + LT.getText() + "," + MT.getText() + "," + NT.getText() + "," 
                + "" + PT.getText() + "," + QT.getText() + "," + RT.getText() + "," + ST.getText() + "," + TT.getText() + "," + UT.getText() + "," + VT.getText() + "," + WT.getText() + "," + XT.getText() + "')";

        g[1] = "insert into datosev values (null," + id + ","
                + "'" + fecha + "'," + spUniOro.getValue() + ","
                + "'" + txtHumedadOro.getText() + "','" + txtHumedadCas.getText() + "',"
                + "" + spColorOro.getValue() + ",'" + cbEvaluador.getSelectedItem() + "',"
                + "'" + lblPuntuacion.getText() + "'," + id + ",'" + txtPeso.getText() + "',"
                + "'" + txtDenOro.getText() + "','" + jLabel10.getText() + "' )";
        System.out.println(csm + " " + comunindad);
        String taza = mdb.devuelveUnDato("select taza from bitacoralab "
                + "where (id_muestra='" + csm + "' and comunidad='" + comunindad + "')");
        if (taza.equals("1")) {
            estatus = "Disp";
        }
        g[2] = "update bitacoralab set aspecto='1'  where id_bitacora=" + id + "";

        if (!txtPeso.equals("0")) {
            if (!txtHumedadOro.equals("")) {
                if (!AT.equals("0")) {

                    try {

                        mdb.insertarBasicos(g[0]);
                        mdb.insertarBasicos(g[1]);
                        mdb.insertarBasicos(g[2]);
                        JOptionPane.showMessageDialog(null, "Inserción Exitosa");
                        //jpDP.llenarTabla();
                    } catch (Exception e) {
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "¡Asegurate de llenar los pesos en las cribas!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "¡Escribe la Humedad de oro!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "¡Escribe cuanto peso esta siendo evaluado!");
        }

    }

    //Metodo para sacar la puntuacion
    public void puntuacion() {
        int v[] = new int[23], total = 0;
        v[0] = Integer.parseInt(BT.getText());
        v[1] = Integer.parseInt(CT.getText());
        v[2] = Integer.parseInt(DT.getText());
        v[3] = Integer.parseInt(ET.getText());
        v[4] = Integer.parseInt(FT.getText());
        v[5] = Integer.parseInt(GT.getText());
        v[6] = Integer.parseInt(HT.getText());
        v[7] = Integer.parseInt(OT.getText());
        v[8] = Integer.parseInt(JT.getText());
        v[9] = Integer.parseInt(KT.getText());
        v[10] = Integer.parseInt(LT.getText());
        v[11] = Integer.parseInt(MT.getText());
        v[12] = Integer.parseInt(NT.getText());
        v[13] = Integer.parseInt(IT.getText());
        v[14] = Integer.parseInt(PT.getText());
        v[15] = Integer.parseInt(QT.getText());
        v[16] = Integer.parseInt(RT.getText());
        v[17] = Integer.parseInt(ST.getText());
        v[18] = Integer.parseInt(TT.getText());
        v[19] = Integer.parseInt(UT.getText());
        v[20] = Integer.parseInt(VT.getText());
        v[21] = Integer.parseInt(WT.getText());
        v[22] = Integer.parseInt(XT.getText());
        int i = 0;
        do {
            total = total + v[i];
            i++;
            //System.out.println(total);
        } while (i < 23);

        lblPuntuacion.setText(total + "");
    }

    //Truncar resultados
    public static int trunc(double num) {
        //JOptionPane.showMessageDialog(null,"num: "+num);
        String strnum = num + "";
        int indice = strnum.indexOf(".");
        return Integer.parseInt(strnum.substring(0, indice));
    }

    public void rendimiento() {
        double rendimiento = (Double.parseDouble(AT.getText()) * 100) / Double.parseDouble(txtPeso.getText());
        jLabel10.setText(df.format(rendimiento) + "");
    }

    //Operacion con las cribas
    public void suma(int num) {
        try {

            double formula, Pe, ad, suma;
            int v[] = new int[6], vt, res, av;
            Pe = Integer.parseInt(txtPeso.getText());
            switch (num) {
                case 1:
                    v[0] = Integer.parseInt(A1.getText());
                    v[1] = Integer.parseInt(A2.getText());
                    v[2] = Integer.parseInt(A3.getText());
                    v[3] = Integer.parseInt(A4.getText());
                    v[4] = Integer.parseInt(A5.getText());
                    v[5] = Integer.parseInt(A6.getText());

                    vt = v[0] + v[1] + v[2] + v[3] + v[4] + v[5];

                    AT.setText(vt + "");
                    break;
                case 2:
                    v[0] = Integer.parseInt(B1.getText());
                    v[1] = Integer.parseInt(B2.getText());
                    v[2] = Integer.parseInt(B3.getText());
                    v[3] = Integer.parseInt(B4.getText());
                    v[4] = Integer.parseInt(B5.getText());
                    v[5] = Integer.parseInt(B6.getText());

                    vt = v[0] + v[1] + v[2] + v[3] + v[4] + v[5];
                    
                    BT1.setText(vt+"");
                    
                    suma = Double.parseDouble(A1.getText()) + Double.parseDouble(A2.getText())
                            + Double.parseDouble(A3.getText()) + Double.parseDouble(A4.getText());

                    formula = (350 / Double.parseDouble(AT.getText())) * (Double.parseDouble(AT.getText()) / suma) * vt;

                    BT2.setText(df.format(formula)+"");
                    
                    formula = Double.parseDouble(df.format(formula)) / 5;

                    System.out.println(formula);
                    res = trunc(formula);
                    System.out.println(res);
                    if (res == 0) {
                        BT.setText("0");
                    } else {
                        BT.setText(res + "");
                        puntuacion();
                    }

                    break;

                case 3:
                    v[0] = Integer.parseInt(C1.getText());
                    v[1] = Integer.parseInt(C2.getText());
                    v[2] = Integer.parseInt(C3.getText());
                    v[3] = Integer.parseInt(C4.getText());
                    v[4] = Integer.parseInt(C5.getText());
                    v[5] = Integer.parseInt(C6.getText());

                    vt = v[0] + v[1] + v[2] + v[3] + v[4] + v[5];

                    CT1.setText(vt+"");
                    
                    suma = Double.parseDouble(A1.getText()) + Double.parseDouble(A2.getText())
                            + Double.parseDouble(A3.getText()) + Double.parseDouble(A4.getText());

                    formula = (350 / Double.parseDouble(AT.getText())) * (Double.parseDouble(AT.getText()) / suma) * vt;

                    CT2.setText(df.format(formula)+"");
                    
                    formula = formula / 10;

                    System.out.println("formula = " + formula);
                    res = trunc(formula);
                    System.out.println("res = " + res);
                    if (res == 0) {
                        CT.setText("0");
                    } else {
                        CT.setText(res + "");
                        puntuacion();
                    }
                    break;
                case 4:
                    v[0] = Integer.parseInt(D1.getText());
                    v[1] = Integer.parseInt(D2.getText());
                    v[2] = Integer.parseInt(D3.getText());
                    v[3] = Integer.parseInt(D4.getText());
                    v[4] = Integer.parseInt(D5.getText());
                    v[5] = Integer.parseInt(D6.getText());

                    vt = v[0] + v[1] + v[2] + v[3] + v[4] + v[5];

                    DT1.setText(vt+"");
                    
                    suma = Double.parseDouble(A1.getText()) + Double.parseDouble(A2.getText())
                            + Double.parseDouble(A3.getText()) + Double.parseDouble(A4.getText());

                    formula = (350 / Double.parseDouble(AT.getText())) * (Double.parseDouble(AT.getText()) / suma) * vt;

                    DT2.setText(df.format(formula)+"");
                    
                    formula = formula / 1;

                    System.out.println("(350/" + AT.getText() + ") * (" + AT.getText() + "/" + suma + ") * " + vt);

                    res = trunc(formula);
                    if (res == 0) {
                        DT.setText("0");
                    } else {
                        DT.setText(res + "");
                        puntuacion();
                    }
                    break;
                case 5:
                    v[0] = Integer.parseInt(E1.getText());
                    v[1] = Integer.parseInt(E2.getText());
                    v[2] = Integer.parseInt(E3.getText());
                    v[3] = Integer.parseInt(E4.getText());
                    v[4] = Integer.parseInt(E5.getText());
                    v[5] = Integer.parseInt(E6.getText());

                    vt = v[0] + v[1] + v[2] + v[3] + v[4] + v[5];

                    ET1.setText(vt+"");
                    
                    suma = Double.parseDouble(A1.getText()) + Double.parseDouble(A2.getText())
                            + Double.parseDouble(A3.getText()) + Double.parseDouble(A4.getText());

                    formula = (350 / Double.parseDouble(AT.getText())) * (Double.parseDouble(AT.getText()) / suma) * vt;

                    ET2.setText(df.format(formula)+"");
                    
                    formula = formula / 3;

                    res = trunc(formula);
                    if (res == 0) {
                        ET.setText("0");
                    } else {
                        ET.setText(res + "");
                        puntuacion();
                    }
                    break;
                case 6:
                    v[0] = Integer.parseInt(F1.getText());
                    v[1] = Integer.parseInt(F2.getText());
                    v[2] = Integer.parseInt(F3.getText());
                    v[3] = Integer.parseInt(F4.getText());
                    v[4] = Integer.parseInt(F5.getText());
                    v[5] = Integer.parseInt(F6.getText());

                    vt = v[0] + v[1] + v[2] + v[3] + v[4] + v[5];
                    
                    FT1.setText(vt+"");

                    suma = Double.parseDouble(A1.getText()) + Double.parseDouble(A2.getText())
                            + Double.parseDouble(A3.getText()) + Double.parseDouble(A4.getText());

                    formula = (350 / Double.parseDouble(AT.getText())) * (Double.parseDouble(AT.getText()) / suma) * vt;

                    FT2.setText(df.format(formula)+"");
                    
                    formula = formula / 1;

                    res = trunc(formula);
                    if (res == 0) {
                        FT.setText("0");
                    } else if (tipo.equals("N")) {
                        FT.setText("0");
                    } else {
                        FT.setText(res + "");
                        puntuacion();
                    }
                    break;
                case 7:
                    v[0] = Integer.parseInt(G1.getText());
                    v[1] = Integer.parseInt(G2.getText());
                    v[2] = Integer.parseInt(G3.getText());
                    v[3] = Integer.parseInt(G4.getText());
                    v[4] = Integer.parseInt(G5.getText());
                    v[5] = Integer.parseInt(G6.getText());

                    vt = v[0] + v[1] + v[2] + v[3] + v[4] + v[5];
                    
                    GT1.setText(vt+"");

                    suma = Double.parseDouble(A1.getText()) + Double.parseDouble(A2.getText())
                            + Double.parseDouble(A3.getText()) + Double.parseDouble(A4.getText());

                    formula = (350 / Double.parseDouble(AT.getText())) * (Double.parseDouble(AT.getText()) / suma) * vt;

                    GT2.setText(df.format(formula)+"");
                    
                    formula = formula / 3;

                    res = trunc(formula);
                    if (res == 0) {
                        GT.setText("0");
                    } else {
                        GT.setText(res + "");
                        puntuacion();
                    }
                    break;
                case 8:
                    v[0] = Integer.parseInt(H1.getText());
                    v[1] = Integer.parseInt(H2.getText());
                    v[2] = Integer.parseInt(H3.getText());
                    v[3] = Integer.parseInt(H4.getText());
                    v[4] = Integer.parseInt(H5.getText());
                    v[5] = Integer.parseInt(H6.getText());

                    vt = v[0] + v[1] + v[2] + v[3] + v[4] + v[5];
                    
                    HT1.setText(vt+"");

                    suma = Double.parseDouble(A1.getText()) + Double.parseDouble(A2.getText())
                            + Double.parseDouble(A3.getText()) + Double.parseDouble(A4.getText());

                    formula = (350 / Double.parseDouble(AT.getText())) * (Double.parseDouble(AT.getText()) / suma) * vt;

                    HT2.setText(df.format(formula)+"");
                    
                    formula = formula / 5;

                    res = trunc(formula);
                    if (res == 0) {
                        HT.setText("0");
                    } else {
                        HT.setText(res + "");
                        puntuacion();
                    }
                    break;
                case 9:
                    v[0] = Integer.parseInt(I1.getText());
                    v[1] = Integer.parseInt(I2.getText());
                    v[2] = Integer.parseInt(I3.getText());
                    v[3] = Integer.parseInt(I4.getText());
                    v[4] = Integer.parseInt(I5.getText());
                    v[5] = Integer.parseInt(I6.getText());

                    vt = v[0] + v[1] + v[2] + v[3] + v[4] + v[5];
                    
                    IT1.setText(vt+"");

                    suma = Double.parseDouble(A1.getText()) + Double.parseDouble(A2.getText())
                            + Double.parseDouble(A3.getText()) + Double.parseDouble(A4.getText());

                    formula = (350 / Double.parseDouble(AT.getText())) * (Double.parseDouble(AT.getText()) / suma) * vt;

                    IT2.setText(df.format(formula)+"");
                    
                    formula = formula / 5;

                    res = trunc(formula);
                    if (res == 0) {
                        IT.setText("0");
                    } else {
                        IT.setText(res + "");
                        puntuacion();
                    }
                    break;
                case 10:
                    v[0] = Integer.parseInt(J1.getText());
                    v[1] = Integer.parseInt(J2.getText());
                    v[2] = Integer.parseInt(J3.getText());
                    v[3] = Integer.parseInt(J4.getText());
                    v[4] = Integer.parseInt(J5.getText());
                    v[5] = Integer.parseInt(J6.getText());

                    vt = v[0] + v[1] + v[2] + v[3] + v[4] + v[5];
                    
                    JT1.setText(vt+"");

                    suma = Double.parseDouble(A1.getText()) + Double.parseDouble(A2.getText())
                            + Double.parseDouble(A3.getText()) + Double.parseDouble(A4.getText());

                    formula = (350 / Double.parseDouble(AT.getText())) * (Double.parseDouble(AT.getText()) / suma) * vt;

                    JT2.setText(df.format(formula)+"");
                    
                    formula = formula / 5;

                    res = trunc(formula);
                    if (res == 0) {
                        JT.setText("0");
                    } else {
                        JT.setText(res + "");
                        puntuacion();
                    }
                    break;
                case 11:
                    v[0] = Integer.parseInt(K1.getText());
                    v[1] = Integer.parseInt(K2.getText());
                    v[2] = Integer.parseInt(K3.getText());
                    v[3] = Integer.parseInt(K4.getText());
                    v[4] = Integer.parseInt(K5.getText());
                    v[5] = Integer.parseInt(K6.getText());

                    vt = v[0] + v[1] + v[2] + v[3] + v[4] + v[5];
                    
                    KT1.setText(vt+"");

                    suma = Double.parseDouble(A1.getText()) + Double.parseDouble(A2.getText())
                            + Double.parseDouble(A3.getText()) + Double.parseDouble(A4.getText());

                    formula = (350 / Double.parseDouble(AT.getText())) * (Double.parseDouble(AT.getText()) / suma) * vt;

                    KT2.setText(df.format(formula)+"");
                    
                    formula = formula / 5;

                    res = trunc(formula);
                    if (res == 0) {
                        KT.setText("0");
                    } else {
                        KT.setText(res + "");
                        puntuacion();
                    }
                    break;
                case 12:
                    v[0] = Integer.parseInt(L1.getText());
                    v[1] = Integer.parseInt(L2.getText());
                    v[2] = Integer.parseInt(L3.getText());
                    v[3] = Integer.parseInt(L4.getText());
                    v[4] = Integer.parseInt(L5.getText());
                    v[5] = Integer.parseInt(L6.getText());

                    vt = v[0] + v[1] + v[2] + v[3] + v[4] + v[5];
                    
                    LT1.setText(vt+"");

                    suma = Double.parseDouble(A1.getText()) + Double.parseDouble(A2.getText())
                            + Double.parseDouble(A3.getText()) + Double.parseDouble(A4.getText());

                    formula = (350 / Double.parseDouble(AT.getText())) * (Double.parseDouble(AT.getText()) / suma) * vt;

                    LT2.setText(df.format(formula)+"");
                    
                    formula = formula / 5;

                    res = trunc(formula);
                    if (res == 0) {
                        LT.setText("0");
                    } else {
                        LT.setText("0");
                        puntuacion();
                    }
                    break;
                case 13:
                    v[0] = Integer.parseInt(M1.getText());
                    v[1] = Integer.parseInt(M2.getText());
                    v[2] = Integer.parseInt(M3.getText());
                    v[3] = Integer.parseInt(M4.getText());
                    v[4] = Integer.parseInt(M5.getText());
                    v[5] = Integer.parseInt(M6.getText());

                    vt = v[0] + v[1] + v[2] + v[3] + v[4] + v[5];
                    
                    MT1.setText(vt+"");

                    suma = Double.parseDouble(A1.getText()) + Double.parseDouble(A2.getText())
                            + Double.parseDouble(A3.getText()) + Double.parseDouble(A4.getText());

                    formula = (350 / Double.parseDouble(AT.getText())) * (Double.parseDouble(AT.getText()) / suma) * vt;

                    MT2.setText(df.format(formula)+"");
                    
                    formula = formula / 5;

                    res = trunc(formula);
                    if (res == 0) {
                        MT.setText("0");
                    } else {
                        MT.setText(res + "");
                        puntuacion();
                    }
                    break;
                case 14:
                    //JOptionPane.showMessageDialog(null, "Entre");
                    v[0] = Integer.parseInt(N1.getText());
                    v[1] = Integer.parseInt(N2.getText());
                    v[2] = Integer.parseInt(N3.getText());
                    v[3] = Integer.parseInt(N4.getText());
                    v[4] = Integer.parseInt(N5.getText());
                    v[5] = Integer.parseInt(N6.getText());

                    vt = v[0] + v[1] + v[2] + v[3] + v[4] + v[5];
                    
                    NT1.setText(vt+"");

                    suma = Double.parseDouble(A1.getText()) + Double.parseDouble(A2.getText())
                            + Double.parseDouble(A3.getText()) + Double.parseDouble(A4.getText());

                    formula = (350 / Double.parseDouble(AT.getText())) * (Double.parseDouble(AT.getText()) / suma) * vt;

                    NT2.setText(df.format(formula)+"");
                    
                    formula = formula / 1;

                    res = trunc(formula);
                    if (res == 0) {
                        NT.setText("0");
                    } else {
                        NT.setText(res + "");
                        puntuacion();
                    }
                    break;
                case 15:
                    v[0] = Integer.parseInt(O1.getText());
                    v[1] = Integer.parseInt(O2.getText());
                    v[2] = Integer.parseInt(O3.getText());
                    v[3] = Integer.parseInt(O4.getText());
                    v[4] = Integer.parseInt(O5.getText());
                    v[5] = Integer.parseInt(O6.getText());

                    vt = v[0] + v[1] + v[2] + v[3] + v[4] + v[5];
                    
                    OT1.setText(vt+"");

                    suma = Double.parseDouble(A1.getText()) + Double.parseDouble(A2.getText())
                            + Double.parseDouble(A3.getText()) + Double.parseDouble(A4.getText());

                    formula = (350 / Double.parseDouble(AT.getText())) * (Double.parseDouble(AT.getText()) / suma) * vt;

                    formula = formula / 3;

                    OT2.setText(df.format(formula)+"");
                    
                    res = trunc(formula);
                    if (res == 0) {
                        OT.setText("0");
                    } else {
                        OT.setText(res + "");
                        puntuacion();
                    }
                    break;
                case 16:
                    v[0] = Integer.parseInt(P1.getText());
                    v[1] = Integer.parseInt(P2.getText());
                    v[2] = Integer.parseInt(P3.getText());
                    v[3] = Integer.parseInt(P4.getText());
                    v[4] = Integer.parseInt(P5.getText());
                    v[5] = Integer.parseInt(P6.getText());

                    vt = v[0] + v[1] + v[2] + v[3] + v[4] + v[5];
                    
                    PT1.setText(vt+"");

                    suma = Double.parseDouble(A1.getText()) + Double.parseDouble(A2.getText())
                            + Double.parseDouble(A3.getText()) + Double.parseDouble(A4.getText());

                    formula = (350 / Double.parseDouble(AT.getText())) * (Double.parseDouble(AT.getText()) / suma) * vt;

                    PT2.setText(df.format(formula)+"");
                    
                    formula = formula / 5;

                    res = trunc(formula);
                    if (res == 0) {
                        PT.setText("0");
                    } else {
                        PT.setText(res + "");
                        puntuacion();
                    }
                    break;
                case 17:
                    v[0] = Integer.parseInt(Q1.getText());
                    v[1] = Integer.parseInt(Q2.getText());
                    v[2] = Integer.parseInt(Q3.getText());
                    v[3] = Integer.parseInt(Q4.getText());
                    v[4] = Integer.parseInt(Q5.getText());
                    v[5] = Integer.parseInt(Q6.getText());

                    vt = v[0] + v[1] + v[2] + v[3] + v[4] + v[5];
                    
                    QT1.setText(vt+"");

                    suma = Double.parseDouble(A1.getText()) + Double.parseDouble(A2.getText())
                            + Double.parseDouble(A3.getText()) + Double.parseDouble(A4.getText());

                    formula = (350 / Double.parseDouble(AT.getText())) * (Double.parseDouble(AT.getText()) / suma) * vt;

                    QT2.setText(df.format(formula)+"");
                    
                    formula = formula / 5;

                    res = trunc(formula);
                    if (res == 0) {
                        QT.setText("0");
                    } else {
                        QT.setText(res + "");
                        puntuacion();
                    }
                    break;
                case 18:
                    v[0] = Integer.parseInt(R1.getText());
                    v[1] = Integer.parseInt(R2.getText());
                    v[2] = Integer.parseInt(R3.getText());
                    v[3] = Integer.parseInt(R4.getText());
                    v[4] = Integer.parseInt(R5.getText());
                    v[5] = Integer.parseInt(R6.getText());

                    vt = v[0] + v[1] + v[2] + v[3] + v[4] + v[5];
                    
                    RT1.setText(vt+"");

                    suma = Double.parseDouble(A1.getText()) + Double.parseDouble(A2.getText())
                            + Double.parseDouble(A3.getText()) + Double.parseDouble(A4.getText());

                    formula = (350 / Double.parseDouble(AT.getText())) * (Double.parseDouble(AT.getText()) / suma) * vt;

                    RT2.setText(df.format(formula)+"");
                    
                    formula = formula / 5;

                    res = trunc(formula);
                    if (res == 0) {
                        RT.setText("0");
                    } else {
                        RT.setText(res + "");
                        puntuacion();
                    }
                    break;
                case 19:
                    v[0] = Integer.parseInt(S1.getText());
                    v[1] = Integer.parseInt(S2.getText());
                    v[2] = Integer.parseInt(S3.getText());
                    v[3] = Integer.parseInt(S4.getText());
                    v[4] = Integer.parseInt(S5.getText());
                    v[5] = Integer.parseInt(S6.getText());

                    vt = v[0] + v[1] + v[2] + v[3] + v[4] + v[5];
                    
                    ST1.setText(vt+"");

                    suma = Double.parseDouble(A1.getText()) + Double.parseDouble(A2.getText())
                            + Double.parseDouble(A3.getText()) + Double.parseDouble(A4.getText());

                    formula = (350 / Double.parseDouble(AT.getText())) * (Double.parseDouble(AT.getText()) / suma) * vt;

                    ST2.setText(df.format(formula)+"");
                    
                    formula = formula / 5;

                    res = trunc(formula);
                    if (res == 0) {
                        ST.setText("0");
                    } else {
                        ST.setText(res + "");
                        puntuacion();
                    }
                    break;
                case 20:
                    v[0] = Integer.parseInt(T1.getText());
                    v[1] = Integer.parseInt(T2.getText());
                    v[2] = Integer.parseInt(T3.getText());
                    v[3] = Integer.parseInt(T4.getText());
                    v[4] = Integer.parseInt(T5.getText());
                    v[5] = Integer.parseInt(T6.getText());

                    vt = v[0] + v[1] + v[2] + v[3] + v[4] + v[5];
                    
                    TT1.setText(vt+"");

                    suma = Double.parseDouble(A1.getText()) + Double.parseDouble(A2.getText())
                            + Double.parseDouble(A3.getText()) + Double.parseDouble(A4.getText());

                    formula = (350 / Double.parseDouble(AT.getText())) * (Double.parseDouble(AT.getText()) / suma) * vt;

                    TT2.setText(df.format(formula)+"");
                    
                    formula = formula / 5;

                    res = trunc(formula);
                    if (res == 0) {
                        TT.setText("0");
                    } else {
                        TT.setText("0");
                        puntuacion();
                    }
                    break;
                case 21:
                    v[0] = Integer.parseInt(U1.getText());
                    v[1] = Integer.parseInt(U2.getText());
                    v[2] = Integer.parseInt(U3.getText());
                    v[3] = Integer.parseInt(U4.getText());
                    v[4] = Integer.parseInt(U5.getText());
                    v[5] = Integer.parseInt(U6.getText());
                    
                    vt = v[0] + v[1] + v[2] + v[3] + v[4] + v[5];
                    
                    UT1.setText(vt+"");

                    suma = Double.parseDouble(A1.getText()) + Double.parseDouble(A2.getText())
                            + Double.parseDouble(A3.getText()) + Double.parseDouble(A4.getText());

                    formula = (350 / Double.parseDouble(AT.getText())) * (Double.parseDouble(AT.getText()) / suma) * vt;

                    UT2.setText(df.format(formula)+"");
                    
                    formula = formula / 5;

                    res = trunc(formula);
                    if (res == 0) {
                        UT.setText("0");
                    } else {
                        UT.setText(res + "");
                        puntuacion();
                    }
                    break;
                case 22:
                    v[0] = Integer.parseInt(V1.getText());
                    v[1] = Integer.parseInt(V2.getText());
                    v[2] = Integer.parseInt(V3.getText());
                    v[3] = Integer.parseInt(V4.getText());
                    v[4] = Integer.parseInt(V5.getText());
                    v[5] = Integer.parseInt(V6.getText());
                    
                    vt = v[0] + v[1] + v[2] + v[3] + v[4] + v[5];
                    
                    VT1.setText(vt+"");

                    suma = Double.parseDouble(A1.getText()) + Double.parseDouble(A2.getText())
                            + Double.parseDouble(A3.getText()) + Double.parseDouble(A4.getText());

                    formula = (350 / Double.parseDouble(AT.getText())) * (Double.parseDouble(AT.getText()) / suma) * vt;

                    VT2.setText(df.format(formula)+"");
                    
                    formula = formula / 5;

                    res = trunc(formula);
                    if (res == 0) {
                        VT.setText("0");
                    } else {
                        VT.setText(res + "");
                        puntuacion();
                    }
                    break;
                case 23:
                    v[0] = Integer.parseInt(W1.getText());
                    v[1] = Integer.parseInt(W2.getText());
                    v[2] = Integer.parseInt(W3.getText());
                    v[3] = Integer.parseInt(W4.getText());
                    v[4] = Integer.parseInt(W5.getText());
                    v[5] = Integer.parseInt(W6.getText());

                    vt = v[0] + v[1] + v[2] + v[3] + v[4] + v[5];
                    
                    WT1.setText(vt+"");

                    suma = Double.parseDouble(A1.getText()) + Double.parseDouble(A2.getText())
                            + Double.parseDouble(A3.getText()) + Double.parseDouble(A4.getText());

                    formula = (350 / Double.parseDouble(AT.getText())) * (Double.parseDouble(AT.getText()) / suma) * vt;

                    WT2.setText(df.format(formula)+"");
                    
                    formula = formula / 5;

                    res = trunc(formula);
                    if (res == 0) {
                        WT.setText("0");
                    } else {
                        WT.setText(res + "");
                        puntuacion();
                    }
                    break;
                case 24:
                    v[0] = Integer.parseInt(X1.getText());
                    v[1] = Integer.parseInt(X2.getText());
                    v[2] = Integer.parseInt(X3.getText());
                    v[3] = Integer.parseInt(X4.getText());
                    v[4] = Integer.parseInt(X5.getText());
                    v[5] = Integer.parseInt(X6.getText());

                    vt = v[0] + v[1] + v[2] + v[3] + v[4] + v[5];

                    suma = Double.parseDouble(A1.getText()) + Double.parseDouble(A2.getText())
                            + Double.parseDouble(A3.getText()) + Double.parseDouble(A4.getText());

                    formula = (350 / Double.parseDouble(AT.getText())) * (Double.parseDouble(AT.getText()) / suma) * vt;

                    formula = formula / 1;

                    res = trunc(formula);
                    if (res == 0) {
                        XT.setText("0");
                    } else {
                        XT.setText(res + "");
                        puntuacion();
                    }
                    break;
            }
        } catch (Exception e) {

        }

    }
    
    //Metodo para quitar el 0 con el Focus
    public void quitarCero(JTextField texto){
        if(texto.getText().equals("0"))
            texto.setText("");
    }
    
    //Metodo para poner el 0 con perdida de Focus
    public void ponerCero(JTextField texto){
        if(texto.getText().equals(""))
            texto.setText("0");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator4 = new javax.swing.JSeparator();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        A2 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        A1 = new javax.swing.JTextField();
        A3 = new javax.swing.JTextField();
        A5 = new javax.swing.JTextField();
        A6 = new javax.swing.JTextField();
        AT = new javax.swing.JTextField();
        A4 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        B1 = new javax.swing.JTextField();
        B2 = new javax.swing.JTextField();
        B3 = new javax.swing.JTextField();
        B4 = new javax.swing.JTextField();
        B5 = new javax.swing.JTextField();
        B6 = new javax.swing.JTextField();
        BT = new javax.swing.JTextField();
        C1 = new javax.swing.JTextField();
        C2 = new javax.swing.JTextField();
        C3 = new javax.swing.JTextField();
        C4 = new javax.swing.JTextField();
        C5 = new javax.swing.JTextField();
        C6 = new javax.swing.JTextField();
        CT = new javax.swing.JTextField();
        D1 = new javax.swing.JTextField();
        D2 = new javax.swing.JTextField();
        D3 = new javax.swing.JTextField();
        D4 = new javax.swing.JTextField();
        D5 = new javax.swing.JTextField();
        D6 = new javax.swing.JTextField();
        DT = new javax.swing.JTextField();
        E1 = new javax.swing.JTextField();
        E2 = new javax.swing.JTextField();
        E3 = new javax.swing.JTextField();
        E4 = new javax.swing.JTextField();
        E5 = new javax.swing.JTextField();
        E6 = new javax.swing.JTextField();
        ET = new javax.swing.JTextField();
        F1 = new javax.swing.JTextField();
        F2 = new javax.swing.JTextField();
        F3 = new javax.swing.JTextField();
        F4 = new javax.swing.JTextField();
        F5 = new javax.swing.JTextField();
        F6 = new javax.swing.JTextField();
        FT = new javax.swing.JTextField();
        G1 = new javax.swing.JTextField();
        G2 = new javax.swing.JTextField();
        G3 = new javax.swing.JTextField();
        G4 = new javax.swing.JTextField();
        G5 = new javax.swing.JTextField();
        G6 = new javax.swing.JTextField();
        GT = new javax.swing.JTextField();
        H1 = new javax.swing.JTextField();
        H2 = new javax.swing.JTextField();
        H3 = new javax.swing.JTextField();
        H4 = new javax.swing.JTextField();
        H5 = new javax.swing.JTextField();
        H6 = new javax.swing.JTextField();
        HT = new javax.swing.JTextField();
        I1 = new javax.swing.JTextField();
        I2 = new javax.swing.JTextField();
        I3 = new javax.swing.JTextField();
        I4 = new javax.swing.JTextField();
        I5 = new javax.swing.JTextField();
        I6 = new javax.swing.JTextField();
        IT = new javax.swing.JTextField();
        O1 = new javax.swing.JTextField();
        O2 = new javax.swing.JTextField();
        O3 = new javax.swing.JTextField();
        O4 = new javax.swing.JTextField();
        O5 = new javax.swing.JTextField();
        O6 = new javax.swing.JTextField();
        OT = new javax.swing.JTextField();
        J1 = new javax.swing.JTextField();
        J2 = new javax.swing.JTextField();
        J3 = new javax.swing.JTextField();
        J4 = new javax.swing.JTextField();
        J5 = new javax.swing.JTextField();
        J6 = new javax.swing.JTextField();
        JT = new javax.swing.JTextField();
        K1 = new javax.swing.JTextField();
        K2 = new javax.swing.JTextField();
        K3 = new javax.swing.JTextField();
        K4 = new javax.swing.JTextField();
        K5 = new javax.swing.JTextField();
        K6 = new javax.swing.JTextField();
        KT = new javax.swing.JTextField();
        L1 = new javax.swing.JTextField();
        L2 = new javax.swing.JTextField();
        L3 = new javax.swing.JTextField();
        L4 = new javax.swing.JTextField();
        L5 = new javax.swing.JTextField();
        L6 = new javax.swing.JTextField();
        LT = new javax.swing.JTextField();
        M1 = new javax.swing.JTextField();
        M2 = new javax.swing.JTextField();
        M3 = new javax.swing.JTextField();
        M4 = new javax.swing.JTextField();
        M5 = new javax.swing.JTextField();
        M6 = new javax.swing.JTextField();
        MT = new javax.swing.JTextField();
        N1 = new javax.swing.JTextField();
        N2 = new javax.swing.JTextField();
        N3 = new javax.swing.JTextField();
        N4 = new javax.swing.JTextField();
        N5 = new javax.swing.JTextField();
        N6 = new javax.swing.JTextField();
        NT = new javax.swing.JTextField();
        P1 = new javax.swing.JTextField();
        P2 = new javax.swing.JTextField();
        P3 = new javax.swing.JTextField();
        P4 = new javax.swing.JTextField();
        P5 = new javax.swing.JTextField();
        P6 = new javax.swing.JTextField();
        PT = new javax.swing.JTextField();
        Q1 = new javax.swing.JTextField();
        Q2 = new javax.swing.JTextField();
        Q3 = new javax.swing.JTextField();
        Q4 = new javax.swing.JTextField();
        Q5 = new javax.swing.JTextField();
        Q6 = new javax.swing.JTextField();
        QT = new javax.swing.JTextField();
        R1 = new javax.swing.JTextField();
        R2 = new javax.swing.JTextField();
        R3 = new javax.swing.JTextField();
        R4 = new javax.swing.JTextField();
        R5 = new javax.swing.JTextField();
        R6 = new javax.swing.JTextField();
        RT = new javax.swing.JTextField();
        S1 = new javax.swing.JTextField();
        S2 = new javax.swing.JTextField();
        S3 = new javax.swing.JTextField();
        S4 = new javax.swing.JTextField();
        S5 = new javax.swing.JTextField();
        S6 = new javax.swing.JTextField();
        ST = new javax.swing.JTextField();
        T1 = new javax.swing.JTextField();
        T2 = new javax.swing.JTextField();
        T3 = new javax.swing.JTextField();
        T4 = new javax.swing.JTextField();
        T5 = new javax.swing.JTextField();
        T6 = new javax.swing.JTextField();
        TT = new javax.swing.JTextField();
        U1 = new javax.swing.JTextField();
        U2 = new javax.swing.JTextField();
        U3 = new javax.swing.JTextField();
        U4 = new javax.swing.JTextField();
        U5 = new javax.swing.JTextField();
        U6 = new javax.swing.JTextField();
        UT = new javax.swing.JTextField();
        V1 = new javax.swing.JTextField();
        V2 = new javax.swing.JTextField();
        V3 = new javax.swing.JTextField();
        V4 = new javax.swing.JTextField();
        V5 = new javax.swing.JTextField();
        V6 = new javax.swing.JTextField();
        VT = new javax.swing.JTextField();
        W1 = new javax.swing.JTextField();
        W2 = new javax.swing.JTextField();
        W3 = new javax.swing.JTextField();
        W4 = new javax.swing.JTextField();
        W5 = new javax.swing.JTextField();
        W6 = new javax.swing.JTextField();
        WT = new javax.swing.JTextField();
        X1 = new javax.swing.JTextField();
        X2 = new javax.swing.JTextField();
        X3 = new javax.swing.JTextField();
        X4 = new javax.swing.JTextField();
        X5 = new javax.swing.JTextField();
        X6 = new javax.swing.JTextField();
        XT = new javax.swing.JTextField();
        BT1 = new javax.swing.JTextField();
        CT1 = new javax.swing.JTextField();
        DT1 = new javax.swing.JTextField();
        ET1 = new javax.swing.JTextField();
        FT1 = new javax.swing.JTextField();
        GT1 = new javax.swing.JTextField();
        HT1 = new javax.swing.JTextField();
        IT1 = new javax.swing.JTextField();
        OT1 = new javax.swing.JTextField();
        JT1 = new javax.swing.JTextField();
        KT1 = new javax.swing.JTextField();
        LT1 = new javax.swing.JTextField();
        MT1 = new javax.swing.JTextField();
        NT1 = new javax.swing.JTextField();
        PT1 = new javax.swing.JTextField();
        QT1 = new javax.swing.JTextField();
        RT1 = new javax.swing.JTextField();
        ST1 = new javax.swing.JTextField();
        TT1 = new javax.swing.JTextField();
        UT1 = new javax.swing.JTextField();
        VT1 = new javax.swing.JTextField();
        WT1 = new javax.swing.JTextField();
        XT1 = new javax.swing.JTextField();
        WT2 = new javax.swing.JTextField();
        LT2 = new javax.swing.JTextField();
        PT2 = new javax.swing.JTextField();
        QT2 = new javax.swing.JTextField();
        MT2 = new javax.swing.JTextField();
        TT2 = new javax.swing.JTextField();
        RT2 = new javax.swing.JTextField();
        CT2 = new javax.swing.JTextField();
        XT2 = new javax.swing.JTextField();
        GT2 = new javax.swing.JTextField();
        UT2 = new javax.swing.JTextField();
        ET2 = new javax.swing.JTextField();
        DT2 = new javax.swing.JTextField();
        FT2 = new javax.swing.JTextField();
        OT2 = new javax.swing.JTextField();
        JT2 = new javax.swing.JTextField();
        HT2 = new javax.swing.JTextField();
        NT2 = new javax.swing.JTextField();
        IT2 = new javax.swing.JTextField();
        ST2 = new javax.swing.JTextField();
        BT2 = new javax.swing.JTextField();
        KT2 = new javax.swing.JTextField();
        VT2 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblCSM = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblComunidad = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCalC = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblForma = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        dcFechaE = new com.toedter.calendar.JDateChooser();
        jLabel51 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        spUniOro = new javax.swing.JSpinner();
        jLabel53 = new javax.swing.JLabel();
        txtHumedadOro = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        txtHumedadCas = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        spColorOro = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        cbEvaluador = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        txtDenOro = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        lblPuntuacion = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Evaluación Aspecto");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Guardar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(null);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setAutoscrolls(true);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Criba");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("19");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("18");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("17");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("16");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("15");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("F");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Total");

        A2.setText("0");
        A2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                A2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                A2FocusLost(evt);
            }
        });
        A2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                A2KeyReleased(evt);
            }
        });

        jLabel23.setText("Peso:");

        A1.setText("0");
        A1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                A1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                A1FocusLost(evt);
            }
        });
        A1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                A1KeyReleased(evt);
            }
        });

        A3.setText("0");
        A3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                A3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                A3FocusLost(evt);
            }
        });
        A3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                A3KeyReleased(evt);
            }
        });

        A5.setText("0");
        A5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                A5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                A5FocusLost(evt);
            }
        });
        A5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                A5KeyReleased(evt);
            }
        });

        A6.setText("0");
        A6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                A6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                A6FocusLost(evt);
            }
        });
        A6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                A6KeyReleased(evt);
            }
        });

        AT.setEditable(false);
        AT.setText("0");
        AT.setEnabled(false);
        AT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ATKeyReleased(evt);
            }
        });

        A4.setText("0");
        A4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                A4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                A4FocusLost(evt);
            }
        });
        A4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                A4KeyReleased(evt);
            }
        });

        jLabel24.setText("Broca severa:");

        jLabel25.setText("Broca:");

        jLabel26.setText("Negro:");

        jLabel27.setText("Negro parcial:");

        jLabel28.setText("Agrio:");

        jLabel29.setText("Agrio parcial:");

        jLabel30.setText("Aplastado:");

        jLabel31.setText("Daño o Mordido:");

        jLabel32.setText("Daño y Agrio parcial:");

        jLabel33.setText("Blanco/Flotador:");

        jLabel34.setText("Elefante:");

        jLabel35.setText("Concha:");

        jLabel36.setText("Malformado:");

        jLabel37.setText("Daño por hongos:");

        jLabel38.setText("Inmaduro:");

        jLabel39.setText("Sobresecado:");

        jLabel40.setText("Arrugado:");

        jLabel41.setText("Grano humedo:");

        jLabel42.setText("Quebrado:");

        jLabel43.setText("Cereza seca:");

        jLabel44.setText("Pergamino:");

        jLabel45.setText("Cáscara/pulpa seca:");

        jLabel46.setText("Materia extra:");

        B1.setText("0");
        B1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                B1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                B1FocusLost(evt);
            }
        });
        B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1ActionPerformed(evt);
            }
        });
        B1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B1KeyReleased(evt);
            }
        });

        B2.setText("0");
        B2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                B2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                B2FocusLost(evt);
            }
        });
        B2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B2KeyReleased(evt);
            }
        });

        B3.setText("0");
        B3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                B3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                B3FocusLost(evt);
            }
        });
        B3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B3KeyReleased(evt);
            }
        });

        B4.setText("0");
        B4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                B4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                B4FocusLost(evt);
            }
        });
        B4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B4KeyReleased(evt);
            }
        });

        B5.setText("0");
        B5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                B5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                B5FocusLost(evt);
            }
        });
        B5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B5KeyReleased(evt);
            }
        });

        B6.setText("0");
        B6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                B6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                B6FocusLost(evt);
            }
        });
        B6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B6KeyReleased(evt);
            }
        });

        BT.setEditable(false);
        BT.setText("0");
        BT.setEnabled(false);

        C1.setText("0");
        C1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                C1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                C1FocusLost(evt);
            }
        });
        C1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                C1KeyReleased(evt);
            }
        });

        C2.setText("0");
        C2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                C2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                C2FocusLost(evt);
            }
        });
        C2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                C2KeyReleased(evt);
            }
        });

        C3.setText("0");
        C3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                C3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                C3FocusLost(evt);
            }
        });
        C3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                C3KeyReleased(evt);
            }
        });

        C4.setText("0");
        C4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                C4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                C4FocusLost(evt);
            }
        });
        C4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                C4KeyReleased(evt);
            }
        });

        C5.setText("0");
        C5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                C5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                C5FocusLost(evt);
            }
        });
        C5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                C5KeyReleased(evt);
            }
        });

        C6.setText("0");
        C6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                C6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                C6FocusLost(evt);
            }
        });
        C6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                C6KeyReleased(evt);
            }
        });

        CT.setEditable(false);
        CT.setText("0");
        CT.setEnabled(false);

        D1.setText("0");
        D1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                D1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                D1FocusLost(evt);
            }
        });
        D1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                D1KeyReleased(evt);
            }
        });

        D2.setText("0");
        D2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                D2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                D2FocusLost(evt);
            }
        });
        D2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                D2KeyReleased(evt);
            }
        });

        D3.setText("0");
        D3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                D3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                D3FocusLost(evt);
            }
        });
        D3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                D3KeyReleased(evt);
            }
        });

        D4.setText("0");
        D4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                D4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                D4FocusLost(evt);
            }
        });
        D4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                D4KeyReleased(evt);
            }
        });

        D5.setText("0");
        D5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                D5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                D5FocusLost(evt);
            }
        });
        D5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                D5KeyReleased(evt);
            }
        });

        D6.setText("0");
        D6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                D6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                D6FocusLost(evt);
            }
        });
        D6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                D6KeyReleased(evt);
            }
        });

        DT.setEditable(false);
        DT.setText("0");
        DT.setEnabled(false);

        E1.setText("0");
        E1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                E1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                E1FocusLost(evt);
            }
        });
        E1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                E1KeyReleased(evt);
            }
        });

        E2.setText("0");
        E2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                E2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                E2FocusLost(evt);
            }
        });
        E2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                E2KeyReleased(evt);
            }
        });

        E3.setText("0");
        E3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                E3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                E3FocusLost(evt);
            }
        });
        E3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                E3KeyReleased(evt);
            }
        });

        E4.setText("0");
        E4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                E4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                E4FocusLost(evt);
            }
        });
        E4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                E4KeyReleased(evt);
            }
        });

        E5.setText("0");
        E5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                E5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                E5FocusLost(evt);
            }
        });
        E5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                E5KeyReleased(evt);
            }
        });

        E6.setText("0");
        E6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                E6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                E6FocusLost(evt);
            }
        });
        E6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                E6KeyReleased(evt);
            }
        });

        ET.setEditable(false);
        ET.setText("0");
        ET.setEnabled(false);

        F1.setText("0");
        F1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                F1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                F1FocusLost(evt);
            }
        });
        F1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                F1KeyReleased(evt);
            }
        });

        F2.setText("0");
        F2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                F2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                F2FocusLost(evt);
            }
        });
        F2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                F2KeyReleased(evt);
            }
        });

        F3.setText("0");
        F3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                F3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                F3FocusLost(evt);
            }
        });
        F3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                F3KeyReleased(evt);
            }
        });

        F4.setText("0");
        F4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                F4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                F4FocusLost(evt);
            }
        });
        F4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                F4KeyReleased(evt);
            }
        });

        F5.setText("0");
        F5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                F5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                F5FocusLost(evt);
            }
        });
        F5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                F5KeyReleased(evt);
            }
        });

        F6.setText("0");
        F6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                F6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                F6FocusLost(evt);
            }
        });
        F6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                F6KeyReleased(evt);
            }
        });

        FT.setEditable(false);
        FT.setText("0");
        FT.setEnabled(false);

        G1.setText("0");
        G1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                G1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                G1FocusLost(evt);
            }
        });
        G1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                G1KeyReleased(evt);
            }
        });

        G2.setText("0");
        G2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                G2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                G2FocusLost(evt);
            }
        });
        G2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                G2KeyReleased(evt);
            }
        });

        G3.setText("0");
        G3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                G3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                G3FocusLost(evt);
            }
        });
        G3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                G3KeyReleased(evt);
            }
        });

        G4.setText("0");
        G4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                G4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                G4FocusLost(evt);
            }
        });
        G4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                G4KeyReleased(evt);
            }
        });

        G5.setText("0");
        G5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                G5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                G5FocusLost(evt);
            }
        });
        G5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                G5KeyReleased(evt);
            }
        });

        G6.setText("0");
        G6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                G6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                G6FocusLost(evt);
            }
        });
        G6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                G6KeyReleased(evt);
            }
        });

        GT.setEditable(false);
        GT.setText("0");
        GT.setEnabled(false);

        H1.setText("0");
        H1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                H1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                H1FocusLost(evt);
            }
        });
        H1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                H1KeyReleased(evt);
            }
        });

        H2.setText("0");
        H2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                H2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                H2FocusLost(evt);
            }
        });
        H2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                H2KeyReleased(evt);
            }
        });

        H3.setText("0");
        H3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                H3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                H3FocusLost(evt);
            }
        });
        H3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                H3KeyReleased(evt);
            }
        });

        H4.setText("0");
        H4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                H4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                H4FocusLost(evt);
            }
        });
        H4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                H4KeyReleased(evt);
            }
        });

        H5.setText("0");
        H5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                H5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                H5FocusLost(evt);
            }
        });
        H5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                H5KeyReleased(evt);
            }
        });

        H6.setText("0");
        H6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                H6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                H6FocusLost(evt);
            }
        });
        H6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                H6KeyReleased(evt);
            }
        });

        HT.setEditable(false);
        HT.setText("0");
        HT.setEnabled(false);

        I1.setText("0");
        I1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                I1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                I1FocusLost(evt);
            }
        });
        I1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                I1KeyReleased(evt);
            }
        });

        I2.setText("0");
        I2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                I2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                I2FocusLost(evt);
            }
        });
        I2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                I2KeyReleased(evt);
            }
        });

        I3.setText("0");
        I3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                I3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                I3FocusLost(evt);
            }
        });
        I3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                I3KeyReleased(evt);
            }
        });

        I4.setText("0");
        I4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                I4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                I4FocusLost(evt);
            }
        });
        I4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                I4KeyReleased(evt);
            }
        });

        I5.setText("0");
        I5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                I5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                I5FocusLost(evt);
            }
        });
        I5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                I5KeyReleased(evt);
            }
        });

        I6.setText("0");
        I6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                I6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                I6FocusLost(evt);
            }
        });
        I6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                I6KeyReleased(evt);
            }
        });

        IT.setEditable(false);
        IT.setText("0");
        IT.setEnabled(false);

        O1.setText("0");
        O1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                O1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                O1FocusLost(evt);
            }
        });
        O1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                O1KeyReleased(evt);
            }
        });

        O2.setText("0");
        O2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                O2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                O2FocusLost(evt);
            }
        });
        O2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                O2KeyReleased(evt);
            }
        });

        O3.setText("0");
        O3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                O3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                O3FocusLost(evt);
            }
        });
        O3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                O3KeyReleased(evt);
            }
        });

        O4.setText("0");
        O4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                O4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                O4FocusLost(evt);
            }
        });
        O4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                O4KeyReleased(evt);
            }
        });

        O5.setText("0");
        O5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                O5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                O5FocusLost(evt);
            }
        });
        O5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                O5KeyReleased(evt);
            }
        });

        O6.setText("0");
        O6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                O6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                O6FocusLost(evt);
            }
        });
        O6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                O6KeyReleased(evt);
            }
        });

        OT.setEditable(false);
        OT.setText("0");
        OT.setEnabled(false);

        J1.setText("0");
        J1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                J1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                J1FocusLost(evt);
            }
        });
        J1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                J1KeyReleased(evt);
            }
        });

        J2.setText("0");
        J2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                J2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                J2FocusLost(evt);
            }
        });
        J2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                J2KeyReleased(evt);
            }
        });

        J3.setText("0");
        J3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                J3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                J3FocusLost(evt);
            }
        });
        J3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                J3KeyReleased(evt);
            }
        });

        J4.setText("0");
        J4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                J4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                J4FocusLost(evt);
            }
        });
        J4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                J4KeyReleased(evt);
            }
        });

        J5.setText("0");
        J5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                J5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                J5FocusLost(evt);
            }
        });
        J5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                J5KeyReleased(evt);
            }
        });

        J6.setText("0");
        J6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                J6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                J6FocusLost(evt);
            }
        });
        J6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                J6KeyReleased(evt);
            }
        });

        JT.setEditable(false);
        JT.setText("0");
        JT.setEnabled(false);

        K1.setText("0");
        K1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                K1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                K1FocusLost(evt);
            }
        });
        K1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                K1KeyReleased(evt);
            }
        });

        K2.setText("0");
        K2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                K2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                K2FocusLost(evt);
            }
        });
        K2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                K2KeyReleased(evt);
            }
        });

        K3.setText("0");
        K3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                K3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                K3FocusLost(evt);
            }
        });
        K3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                K3KeyReleased(evt);
            }
        });

        K4.setText("0");
        K4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                K4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                K4FocusLost(evt);
            }
        });
        K4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                K4KeyReleased(evt);
            }
        });

        K5.setText("0");
        K5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                K5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                K5FocusLost(evt);
            }
        });
        K5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                K5KeyReleased(evt);
            }
        });

        K6.setText("0");
        K6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                K6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                K6FocusLost(evt);
            }
        });
        K6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                K6KeyReleased(evt);
            }
        });

        KT.setEditable(false);
        KT.setText("0");
        KT.setEnabled(false);

        L1.setText("0");
        L1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                L1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                L1FocusLost(evt);
            }
        });
        L1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                L1KeyReleased(evt);
            }
        });

        L2.setText("0");
        L2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                L2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                L2FocusLost(evt);
            }
        });
        L2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                L2KeyReleased(evt);
            }
        });

        L3.setText("0");
        L3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                L3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                L3FocusLost(evt);
            }
        });
        L3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                L3KeyReleased(evt);
            }
        });

        L4.setText("0");
        L4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                L4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                L4FocusLost(evt);
            }
        });
        L4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                L4KeyReleased(evt);
            }
        });

        L5.setText("0");
        L5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                L5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                L5FocusLost(evt);
            }
        });
        L5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                L5KeyReleased(evt);
            }
        });

        L6.setText("0");
        L6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                L6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                L6FocusLost(evt);
            }
        });
        L6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                L6KeyReleased(evt);
            }
        });

        LT.setEditable(false);
        LT.setText("0");
        LT.setEnabled(false);

        M1.setText("0");
        M1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                M1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                M1FocusLost(evt);
            }
        });
        M1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                M1KeyReleased(evt);
            }
        });

        M2.setText("0");
        M2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                M2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                M2FocusLost(evt);
            }
        });
        M2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                M2KeyReleased(evt);
            }
        });

        M3.setText("0");
        M3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                M3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                M3FocusLost(evt);
            }
        });
        M3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                M3KeyReleased(evt);
            }
        });

        M4.setText("0");
        M4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                M4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                M4FocusLost(evt);
            }
        });
        M4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                M4KeyReleased(evt);
            }
        });

        M5.setText("0");
        M5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                M5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                M5FocusLost(evt);
            }
        });
        M5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                M5KeyReleased(evt);
            }
        });

        M6.setText("0");
        M6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                M6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                M6FocusLost(evt);
            }
        });
        M6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                M6KeyReleased(evt);
            }
        });

        MT.setEditable(false);
        MT.setText("0");
        MT.setEnabled(false);

        N1.setText("0");
        N1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                N1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                N1FocusLost(evt);
            }
        });
        N1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                N1KeyReleased(evt);
            }
        });

        N2.setText("0");
        N2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                N2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                N2FocusLost(evt);
            }
        });
        N2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                N2KeyReleased(evt);
            }
        });

        N3.setText("0");
        N3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                N3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                N3FocusLost(evt);
            }
        });
        N3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                N3KeyReleased(evt);
            }
        });

        N4.setText("0");
        N4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                N4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                N4FocusLost(evt);
            }
        });
        N4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                N4KeyReleased(evt);
            }
        });

        N5.setText("0");
        N5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                N5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                N5FocusLost(evt);
            }
        });
        N5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                N5KeyReleased(evt);
            }
        });

        N6.setText("0");
        N6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                N6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                N6FocusLost(evt);
            }
        });
        N6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                N6KeyReleased(evt);
            }
        });

        NT.setEditable(false);
        NT.setText("0");
        NT.setEnabled(false);

        P1.setText("0");
        P1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                P1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                P1FocusLost(evt);
            }
        });
        P1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                P1KeyReleased(evt);
            }
        });

        P2.setText("0");
        P2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                P2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                P2FocusLost(evt);
            }
        });
        P2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                P2KeyReleased(evt);
            }
        });

        P3.setText("0");
        P3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                P3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                P3FocusLost(evt);
            }
        });
        P3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                P3KeyReleased(evt);
            }
        });

        P4.setText("0");
        P4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                P4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                P4FocusLost(evt);
            }
        });
        P4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                P4KeyReleased(evt);
            }
        });

        P5.setText("0");
        P5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                P5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                P5FocusLost(evt);
            }
        });
        P5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                P5KeyPressed(evt);
            }
        });

        P6.setText("0");
        P6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                P6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                P6FocusLost(evt);
            }
        });
        P6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                P6KeyReleased(evt);
            }
        });

        PT.setEditable(false);
        PT.setText("0");
        PT.setEnabled(false);

        Q1.setText("0");
        Q1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Q1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Q1FocusLost(evt);
            }
        });
        Q1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q1KeyReleased(evt);
            }
        });

        Q2.setText("0");
        Q2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Q2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Q2FocusLost(evt);
            }
        });
        Q2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q2KeyReleased(evt);
            }
        });

        Q3.setText("0");
        Q3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Q3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Q3FocusLost(evt);
            }
        });
        Q3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q3KeyReleased(evt);
            }
        });

        Q4.setText("0");
        Q4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Q4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Q4FocusLost(evt);
            }
        });
        Q4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q4KeyReleased(evt);
            }
        });

        Q5.setText("0");
        Q5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Q5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Q5FocusLost(evt);
            }
        });
        Q5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q5KeyReleased(evt);
            }
        });

        Q6.setText("0");
        Q6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Q6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Q6FocusLost(evt);
            }
        });
        Q6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Q6KeyReleased(evt);
            }
        });

        QT.setEditable(false);
        QT.setText("0");
        QT.setEnabled(false);

        R1.setText("0");
        R1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                R1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                R1FocusLost(evt);
            }
        });
        R1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                R1KeyReleased(evt);
            }
        });

        R2.setText("0");
        R2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                R2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                R2FocusLost(evt);
            }
        });
        R2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                R2KeyReleased(evt);
            }
        });

        R3.setText("0");
        R3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                R3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                R3FocusLost(evt);
            }
        });
        R3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                R3KeyReleased(evt);
            }
        });

        R4.setText("0");
        R4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                R4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                R4FocusLost(evt);
            }
        });
        R4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                R4KeyReleased(evt);
            }
        });

        R5.setText("0");
        R5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                R5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                R5FocusLost(evt);
            }
        });
        R5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                R5KeyReleased(evt);
            }
        });

        R6.setText("0");
        R6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                R6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                R6FocusLost(evt);
            }
        });
        R6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                R6KeyReleased(evt);
            }
        });

        RT.setEditable(false);
        RT.setText("0");
        RT.setEnabled(false);

        S1.setText("0");
        S1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                S1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                S1FocusLost(evt);
            }
        });
        S1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                S1KeyReleased(evt);
            }
        });

        S2.setText("0");
        S2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                S2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                S2FocusLost(evt);
            }
        });
        S2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                S2KeyReleased(evt);
            }
        });

        S3.setText("0");
        S3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                S3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                S3FocusLost(evt);
            }
        });
        S3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                S3KeyReleased(evt);
            }
        });

        S4.setText("0");
        S4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                S4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                S4FocusLost(evt);
            }
        });
        S4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                S4KeyReleased(evt);
            }
        });

        S5.setText("0");
        S5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                S5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                S5FocusLost(evt);
            }
        });
        S5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                S5KeyReleased(evt);
            }
        });

        S6.setText("0");
        S6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                S6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                S6FocusLost(evt);
            }
        });
        S6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                S6KeyReleased(evt);
            }
        });

        ST.setEditable(false);
        ST.setText("0");
        ST.setEnabled(false);

        T1.setText("0");
        T1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                T1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                T1FocusLost(evt);
            }
        });
        T1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                T1KeyReleased(evt);
            }
        });

        T2.setText("0");
        T2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                T2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                T2FocusLost(evt);
            }
        });
        T2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                T2KeyReleased(evt);
            }
        });

        T3.setText("0");
        T3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                T3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                T3FocusLost(evt);
            }
        });
        T3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                T3KeyReleased(evt);
            }
        });

        T4.setText("0");
        T4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                T4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                T4FocusLost(evt);
            }
        });
        T4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                T4KeyReleased(evt);
            }
        });

        T5.setText("0");
        T5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                T5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                T5FocusLost(evt);
            }
        });
        T5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                T5KeyReleased(evt);
            }
        });

        T6.setText("0");
        T6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                T6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                T6FocusLost(evt);
            }
        });
        T6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                T6KeyReleased(evt);
            }
        });

        TT.setEditable(false);
        TT.setText("0");
        TT.setEnabled(false);

        U1.setText("0");
        U1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                U1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                U1FocusLost(evt);
            }
        });
        U1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                U1KeyReleased(evt);
            }
        });

        U2.setText("0");
        U2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                U2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                U2FocusLost(evt);
            }
        });
        U2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                U2KeyReleased(evt);
            }
        });

        U3.setText("0");
        U3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                U3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                U3FocusLost(evt);
            }
        });
        U3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                U3KeyReleased(evt);
            }
        });

        U4.setText("0");
        U4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                U4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                U4FocusLost(evt);
            }
        });
        U4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                U4KeyReleased(evt);
            }
        });

        U5.setText("0");
        U5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                U5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                U5FocusLost(evt);
            }
        });
        U5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                U5KeyReleased(evt);
            }
        });

        U6.setText("0");
        U6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                U6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                U6FocusLost(evt);
            }
        });
        U6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                U6KeyReleased(evt);
            }
        });

        UT.setEditable(false);
        UT.setText("0");
        UT.setEnabled(false);

        V1.setText("0");
        V1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                V1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                V1FocusLost(evt);
            }
        });
        V1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V1KeyReleased(evt);
            }
        });

        V2.setText("0");
        V2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                V2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                V2FocusLost(evt);
            }
        });
        V2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V2KeyReleased(evt);
            }
        });

        V3.setText("0");
        V3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                V3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                V3FocusLost(evt);
            }
        });
        V3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V3KeyReleased(evt);
            }
        });

        V4.setText("0");
        V4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                V4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                V4FocusLost(evt);
            }
        });
        V4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V4KeyReleased(evt);
            }
        });

        V5.setText("0");
        V5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                V5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                V5FocusLost(evt);
            }
        });
        V5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V5KeyReleased(evt);
            }
        });

        V6.setText("0");
        V6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                V6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                V6FocusLost(evt);
            }
        });
        V6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                V6KeyReleased(evt);
            }
        });

        VT.setEditable(false);
        VT.setText("0");
        VT.setEnabled(false);

        W1.setText("0");
        W1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                W1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                W1FocusLost(evt);
            }
        });
        W1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                W1KeyReleased(evt);
            }
        });

        W2.setText("0");
        W2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                W2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                W2FocusLost(evt);
            }
        });
        W2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                W2KeyReleased(evt);
            }
        });

        W3.setText("0");
        W3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                W3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                W3FocusLost(evt);
            }
        });
        W3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                W3KeyReleased(evt);
            }
        });

        W4.setText("0");
        W4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                W4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                W4FocusLost(evt);
            }
        });
        W4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                W4KeyReleased(evt);
            }
        });

        W5.setText("0");
        W5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                W5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                W5FocusLost(evt);
            }
        });
        W5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                W5KeyReleased(evt);
            }
        });

        W6.setText("0");
        W6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                W6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                W6FocusLost(evt);
            }
        });
        W6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                W6KeyReleased(evt);
            }
        });

        WT.setEditable(false);
        WT.setText("0");
        WT.setEnabled(false);

        X1.setText("0");
        X1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                X1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                X1FocusLost(evt);
            }
        });
        X1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                X1KeyReleased(evt);
            }
        });

        X2.setText("0");
        X2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                X2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                X2FocusLost(evt);
            }
        });
        X2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                X2KeyReleased(evt);
            }
        });

        X3.setText("0");
        X3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                X3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                X3FocusLost(evt);
            }
        });
        X3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                X3KeyReleased(evt);
            }
        });

        X4.setText("0");
        X4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                X4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                X4FocusLost(evt);
            }
        });
        X4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                X4KeyReleased(evt);
            }
        });

        X5.setText("0");
        X5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                X5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                X5FocusLost(evt);
            }
        });
        X5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                X5KeyReleased(evt);
            }
        });

        X6.setText("0");
        X6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                X6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                X6FocusLost(evt);
            }
        });
        X6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                X6KeyReleased(evt);
            }
        });

        XT.setEditable(false);
        XT.setText("0");
        XT.setEnabled(false);

        BT1.setEditable(false);
        BT1.setText("0");
        BT1.setEnabled(false);

        CT1.setEditable(false);
        CT1.setText("0");
        CT1.setEnabled(false);

        DT1.setEditable(false);
        DT1.setText("0");
        DT1.setEnabled(false);

        ET1.setEditable(false);
        ET1.setText("0");
        ET1.setEnabled(false);

        FT1.setEditable(false);
        FT1.setText("0");
        FT1.setEnabled(false);

        GT1.setEditable(false);
        GT1.setText("0");
        GT1.setEnabled(false);

        HT1.setEditable(false);
        HT1.setText("0");
        HT1.setEnabled(false);

        IT1.setEditable(false);
        IT1.setText("0");
        IT1.setEnabled(false);

        OT1.setEditable(false);
        OT1.setText("0");
        OT1.setEnabled(false);

        JT1.setEditable(false);
        JT1.setText("0");
        JT1.setEnabled(false);

        KT1.setEditable(false);
        KT1.setText("0");
        KT1.setEnabled(false);

        LT1.setEditable(false);
        LT1.setText("0");
        LT1.setEnabled(false);

        MT1.setEditable(false);
        MT1.setText("0");
        MT1.setEnabled(false);

        NT1.setEditable(false);
        NT1.setText("0");
        NT1.setEnabled(false);

        PT1.setEditable(false);
        PT1.setText("0");
        PT1.setEnabled(false);

        QT1.setEditable(false);
        QT1.setText("0");
        QT1.setEnabled(false);

        RT1.setEditable(false);
        RT1.setText("0");
        RT1.setEnabled(false);

        ST1.setEditable(false);
        ST1.setText("0");
        ST1.setEnabled(false);

        TT1.setEditable(false);
        TT1.setText("0");
        TT1.setEnabled(false);

        UT1.setEditable(false);
        UT1.setText("0");
        UT1.setEnabled(false);

        VT1.setEditable(false);
        VT1.setText("0");
        VT1.setEnabled(false);

        WT1.setEditable(false);
        WT1.setText("0");
        WT1.setEnabled(false);

        XT1.setEditable(false);
        XT1.setText("0");
        XT1.setEnabled(false);

        WT2.setEditable(false);
        WT2.setText("0");
        WT2.setEnabled(false);

        LT2.setEditable(false);
        LT2.setText("0");
        LT2.setEnabled(false);

        PT2.setEditable(false);
        PT2.setText("0");
        PT2.setEnabled(false);

        QT2.setEditable(false);
        QT2.setText("0");
        QT2.setEnabled(false);

        MT2.setEditable(false);
        MT2.setText("0");
        MT2.setEnabled(false);

        TT2.setEditable(false);
        TT2.setText("0");
        TT2.setEnabled(false);

        RT2.setEditable(false);
        RT2.setText("0");
        RT2.setEnabled(false);

        CT2.setEditable(false);
        CT2.setText("0");
        CT2.setEnabled(false);

        XT2.setEditable(false);
        XT2.setText("0");
        XT2.setEnabled(false);

        GT2.setEditable(false);
        GT2.setText("0");
        GT2.setEnabled(false);

        UT2.setEditable(false);
        UT2.setText("0");
        UT2.setEnabled(false);

        ET2.setEditable(false);
        ET2.setText("0");
        ET2.setEnabled(false);

        DT2.setEditable(false);
        DT2.setText("0");
        DT2.setEnabled(false);

        FT2.setEditable(false);
        FT2.setText("0");
        FT2.setEnabled(false);

        OT2.setEditable(false);
        OT2.setText("0");
        OT2.setEnabled(false);

        JT2.setEditable(false);
        JT2.setText("0");
        JT2.setEnabled(false);

        HT2.setEditable(false);
        HT2.setText("0");
        HT2.setEnabled(false);

        NT2.setEditable(false);
        NT2.setText("0");
        NT2.setEnabled(false);

        IT2.setEditable(false);
        IT2.setText("0");
        IT2.setEnabled(false);

        ST2.setEditable(false);
        ST2.setText("0");
        ST2.setEnabled(false);

        BT2.setEditable(false);
        BT2.setText("0");
        BT2.setEnabled(false);

        KT2.setEditable(false);
        KT2.setText("0");
        KT2.setEnabled(false);

        VT2.setEditable(false);
        VT2.setText("0");
        VT2.setEnabled(false);

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel57.setText("Escalados");

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setText("Puntuación");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel15)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel16)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel17)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel18)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel19)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel20)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel21)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel57)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel58))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(jLabel45)
                                                .addGap(4, 4, 4))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel38)
                                                    .addComponent(jLabel39)
                                                    .addComponent(jLabel25)
                                                    .addComponent(jLabel26)
                                                    .addComponent(jLabel27)
                                                    .addComponent(jLabel28)
                                                    .addComponent(jLabel37)
                                                    .addComponent(jLabel36)
                                                    .addComponent(jLabel35)
                                                    .addComponent(jLabel34)
                                                    .addComponent(jLabel33)
                                                    .addComponent(jLabel32)
                                                    .addComponent(jLabel31)
                                                    .addComponent(jLabel30)
                                                    .addComponent(jLabel29)
                                                    .addComponent(jLabel24))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(T1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(T2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(T3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(T4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(T5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(T6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(R1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(R2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(R3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(R4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(R5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(R6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(S1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(S2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(S3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(S4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(S5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(S6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(U1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(U2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(U3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(U4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(U5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(U6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(V1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(V2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(V3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(V4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(V5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(V6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(W1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(W2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(W3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(W4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(W5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(W6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(X1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(X2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(X3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(X4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(X5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(X6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(30, 30, 30))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(J1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(J2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(J3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(J4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(J5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(J6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(O1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(O2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(O3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(O4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(O5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(O6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(I1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(I2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(I3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(I4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(I5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(I6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(H1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(H2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(H3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(H4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(H5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(H6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(G1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(G2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(G3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(G4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(G5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(G6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(K1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(K2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(K3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(K4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(K5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(K6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addGap(1, 1, 1)
                                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(B6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addComponent(E1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(E2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(E3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(E4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(E5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(E6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addComponent(C1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(C2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(C3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(C4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(C5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(C6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addComponent(D1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(D2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(D3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(D4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(D5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(D6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addComponent(F1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(F2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(F3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(F4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(F5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(F6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addComponent(Q1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(Q2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(Q3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(Q4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(Q5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(Q6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addComponent(P1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(P2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(P3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(P4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(P5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(P6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addComponent(N1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(N2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(N3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(N4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(N5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(N6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addComponent(M1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(M2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(M3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(M4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(M5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(M6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addComponent(L1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(L2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(L3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(L4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(L5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(L6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addGap(29, 29, 29))))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel41)
                                            .addComponent(jLabel43)
                                            .addComponent(jLabel44)
                                            .addComponent(jLabel46)
                                            .addComponent(jLabel42)
                                            .addComponent(jLabel40))
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DT1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CT1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ET1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(FT1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(JT1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(OT1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(IT1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(GT1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(HT1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(KT1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BT1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(QT1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(PT1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(NT1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(MT1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LT1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(TT1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(RT1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ST1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(UT1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(VT1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(WT1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(XT1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DT2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CT2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ET2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(FT2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(JT2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(OT2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(IT2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(GT2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(HT2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(KT2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BT2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(QT2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(PT2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(NT2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(MT2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LT2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(TT2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(RT2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ST2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(UT2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(VT2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(WT2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(XT2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ET, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(FT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(JT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(OT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(IT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(GT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(HT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(KT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(QT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(PT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(NT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(MT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(TT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(RT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ST, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(UT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(VT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(WT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(XT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(87, 87, 87)
                                .addComponent(A1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(A2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(A3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(A4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(A5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(A6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(AT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(68, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57)
                    .addComponent(jLabel58))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(A1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(A2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(A3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(A4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(A5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(A6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(C1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(C2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(C3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(C4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(C5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(C6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(D1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(D2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(D3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(D4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(D5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(D6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(E1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(E2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(E3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(E4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(E5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(E6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(F1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(F2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(F3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(F4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(F5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(F6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(G1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(G2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(G3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(G4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(G5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(G6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(H1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(H2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(H3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(H4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(H5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(H6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(I1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(I2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(I3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(I4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(I5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(I6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(O1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(O2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(O3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(O4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(O5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(O6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(J1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(J2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(J3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(J4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(J5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(J6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(K1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(K2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(K3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(K4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(K5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(K6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(L1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(M1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(M2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(M3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(M4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(M5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(M6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(N1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(N2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(N3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(N4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(N5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(N6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(P1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(P2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(P3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(P4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(P5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(P6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Q1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Q2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Q3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Q4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Q5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Q6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(R1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(R2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(R3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(R4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(R5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(R6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(S1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(S2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(S3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(S4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(S5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(S6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(T1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(T2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(T3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(T4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(T5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(T6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(U1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(U2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(U3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(U4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(U5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(U6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(V1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(V2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(V3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(V4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(V5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(V6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(W1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(W2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(W3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(W4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(W5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(W6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(X1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(X2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(X3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(X4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(X5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(X6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(BT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(CT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(DT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(FT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(GT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(HT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(IT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(OT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(KT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(LT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(MT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(NT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(PT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(QT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(RT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ST, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(UT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(VT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(WT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(XT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(BT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(CT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(DT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ET1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(FT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(GT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(HT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(IT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(OT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(KT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(LT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(MT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(NT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(PT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(QT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(RT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ST1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(UT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(VT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(WT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(XT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(BT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(CT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(DT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ET2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(FT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(GT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(HT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(IT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(OT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(KT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(LT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(MT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(NT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(PT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(QT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(RT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ST2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(UT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(VT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(WT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(XT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel4);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("# CSM");

        lblCSM.setText("csm");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Comunidad");

        lblComunidad.setText("comunidad");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Tipo");

        lblTipo.setText("tipo");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Calificación Cereza");

        lblCalC.setText("calificacion");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Forma");

        lblForma.setText("forma");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblCSM, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lblComunidad))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lblTipo))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(lblCalC))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblForma)
                    .addComponent(jLabel5))
                .addContainerGap(482, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCSM, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblComunidad)
                    .addComponent(lblTipo)
                    .addComponent(lblCalC)
                    .addComponent(lblForma))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel50.setText("Información");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Fecha");

        jLabel51.setText("Peso Evaluado");

        txtPeso.setText("0");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel47.setText("g");

        jLabel52.setText("Uniformidad Café Oro");

        jLabel53.setText("Humedad Café Oro");

        txtHumedadOro.setText("0");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel48.setText("%");

        jLabel54.setText("Humedad Cascara");

        txtHumedadCas.setText("0");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel49.setText("%");

        jLabel55.setText("Color En Oro");

        jLabel12.setText("Evaluador");

        cbEvaluador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione..", "Carlos Bustamante", "Daniel Bustamante", "Kala Wolfe", "Jacob Daniel Donaghy" }));

        jLabel13.setText("Densidad En Oro");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Puntuación");

        lblPuntuacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel9.setText("Rendimiento");

        jLabel10.setText("-");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spColorOro)
                    .addComponent(dcFechaE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtPeso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel47))
                    .addComponent(spUniOro)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtHumedadCas)
                            .addComponent(txtHumedadOro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(cbEvaluador, 0, 160, Short.MAX_VALUE)
                    .addComponent(txtDenOro)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel51)
                            .addComponent(jLabel52)
                            .addComponent(jLabel53)
                            .addComponent(jLabel54)
                            .addComponent(jLabel55)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPuntuacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcFechaE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spUniOro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHumedadOro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHumedadCas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spColorOro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbEvaluador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDenOro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setText("Datos de Evaluacion");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Evaluacion");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Acciones");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(jLabel7))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE))
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

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        //guardar();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void X6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_X6KeyReleased
        // TODO add your handling code here:
        suma(24);
    }//GEN-LAST:event_X6KeyReleased

    private void X5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_X5KeyReleased
        // TODO add your handling code here:
        suma(24);
    }//GEN-LAST:event_X5KeyReleased

    private void X4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_X4KeyReleased
        // TODO add your handling code here:
        suma(24);
    }//GEN-LAST:event_X4KeyReleased

    private void X3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_X3KeyReleased
        // TODO add your handling code here:
        suma(24);
    }//GEN-LAST:event_X3KeyReleased

    private void X2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_X2KeyReleased
        // TODO add your handling code here:
        suma(24);
    }//GEN-LAST:event_X2KeyReleased

    private void X1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_X1KeyReleased
        // TODO add your handling code here:
        suma(24);
    }//GEN-LAST:event_X1KeyReleased

    private void W6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_W6KeyReleased
        // TODO add your handling code here:
        suma(23);
    }//GEN-LAST:event_W6KeyReleased

    private void W5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_W5KeyReleased
        // TODO add your handling code here:
        suma(23);
    }//GEN-LAST:event_W5KeyReleased

    private void W4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_W4KeyReleased
        // TODO add your handling code here:
        suma(23);
    }//GEN-LAST:event_W4KeyReleased

    private void W3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_W3KeyReleased
        // TODO add your handling code here:
        suma(23);
    }//GEN-LAST:event_W3KeyReleased

    private void W2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_W2KeyReleased
        // TODO add your handling code here:
        suma(23);
    }//GEN-LAST:event_W2KeyReleased

    private void W1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_W1KeyReleased
        // TODO add your handling code here:
        suma(23);
    }//GEN-LAST:event_W1KeyReleased

    private void V6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V6KeyReleased
        // TODO add your handling code here:
        suma(22);
    }//GEN-LAST:event_V6KeyReleased

    private void V5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V5KeyReleased
        // TODO add your handling code here:
        suma(22);
    }//GEN-LAST:event_V5KeyReleased

    private void V4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V4KeyReleased
        // TODO add your handling code here:
        suma(22);
    }//GEN-LAST:event_V4KeyReleased

    private void V3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V3KeyReleased
        // TODO add your handling code here:
        suma(22);
    }//GEN-LAST:event_V3KeyReleased

    private void V2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V2KeyReleased
        // TODO add your handling code here:
        suma(22);
    }//GEN-LAST:event_V2KeyReleased

    private void V1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_V1KeyReleased
        // TODO add your handling code here:
        suma(22);
    }//GEN-LAST:event_V1KeyReleased

    private void U6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_U6KeyReleased
        // TODO add your handling code here:
        suma(21);
    }//GEN-LAST:event_U6KeyReleased

    private void U5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_U5KeyReleased
        // TODO add your handling code here:
        suma(21);
    }//GEN-LAST:event_U5KeyReleased

    private void U4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_U4KeyReleased
        // TODO add your handling code here:
        suma(21);
    }//GEN-LAST:event_U4KeyReleased

    private void U3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_U3KeyReleased
        // TODO add your handling code here:
        suma(21);
    }//GEN-LAST:event_U3KeyReleased

    private void U2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_U2KeyReleased
        // TODO add your handling code here:
        suma(21);
    }//GEN-LAST:event_U2KeyReleased

    private void U1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_U1KeyReleased
        // TODO add your handling code here:
        suma(21);
    }//GEN-LAST:event_U1KeyReleased

    private void T6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_T6KeyReleased
        // TODO add your handling code here:
        suma(20);
    }//GEN-LAST:event_T6KeyReleased

    private void T5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_T5KeyReleased
        // TODO add your handling code here:
        suma(20);
    }//GEN-LAST:event_T5KeyReleased

    private void T4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_T4KeyReleased
        // TODO add your handling code here:
        suma(20);
    }//GEN-LAST:event_T4KeyReleased

    private void T3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_T3KeyReleased
        // TODO add your handling code here:
        suma(20);
    }//GEN-LAST:event_T3KeyReleased

    private void T2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_T2KeyReleased
        // TODO add your handling code here:
        suma(20);
    }//GEN-LAST:event_T2KeyReleased

    private void T1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_T1KeyReleased
        // TODO add your handling code here:
        suma(20);
    }//GEN-LAST:event_T1KeyReleased

    private void S6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_S6KeyReleased
        // TODO add your handling code here:
        suma(19);
    }//GEN-LAST:event_S6KeyReleased

    private void S5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_S5KeyReleased
        // TODO add your handling code here:
        suma(19);
    }//GEN-LAST:event_S5KeyReleased

    private void S4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_S4KeyReleased
        // TODO add your handling code here:
        suma(19);
    }//GEN-LAST:event_S4KeyReleased

    private void S3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_S3KeyReleased
        // TODO add your handling code here:
        suma(19);
    }//GEN-LAST:event_S3KeyReleased

    private void S2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_S2KeyReleased
        // TODO add your handling code here:
        suma(19);
    }//GEN-LAST:event_S2KeyReleased

    private void S1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_S1KeyReleased
        // TODO add your handling code here:
        suma(19);
    }//GEN-LAST:event_S1KeyReleased

    private void R6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_R6KeyReleased
        // TODO add your handling code here:
        suma(18);
    }//GEN-LAST:event_R6KeyReleased

    private void R5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_R5KeyReleased
        // TODO add your handling code here:
        suma(18);
    }//GEN-LAST:event_R5KeyReleased

    private void R4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_R4KeyReleased
        // TODO add your handling code here:
        suma(18);
    }//GEN-LAST:event_R4KeyReleased

    private void R3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_R3KeyReleased
        // TODO add your handling code here:
        suma(18);
    }//GEN-LAST:event_R3KeyReleased

    private void R2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_R2KeyReleased
        // TODO add your handling code here:
        suma(18);
    }//GEN-LAST:event_R2KeyReleased

    private void R1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_R1KeyReleased
        // TODO add your handling code here:
        suma(18);
    }//GEN-LAST:event_R1KeyReleased

    private void Q6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q6KeyReleased
        // TODO add your handling code here:
        //   suma(17);
    }//GEN-LAST:event_Q6KeyReleased

    private void Q5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q5KeyReleased
        // TODO add your handling code here:
        //   suma(17);
    }//GEN-LAST:event_Q5KeyReleased

    private void Q4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q4KeyReleased
        // TODO add your handling code here:
        //   suma(17);
    }//GEN-LAST:event_Q4KeyReleased

    private void Q3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q3KeyReleased
        // TODO add your handling code here:
        //  suma(17);
    }//GEN-LAST:event_Q3KeyReleased

    private void Q2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q2KeyReleased
        // TODO add your handling code here:
        //   suma(17);
    }//GEN-LAST:event_Q2KeyReleased

    private void Q1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Q1KeyReleased
        // TODO add your handling code here:
        //    suma(17);
    }//GEN-LAST:event_Q1KeyReleased

    private void P6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_P6KeyReleased
        // TODO add your handling code here:
        suma(16);
    }//GEN-LAST:event_P6KeyReleased

    private void P5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_P5KeyPressed
        // TODO add your handling code here:
        suma(16);
    }//GEN-LAST:event_P5KeyPressed

    private void P4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_P4KeyReleased
        // TODO add your handling code here:
        suma(16);
    }//GEN-LAST:event_P4KeyReleased

    private void P3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_P3KeyReleased
        // TODO add your handling code here:
        suma(16);
    }//GEN-LAST:event_P3KeyReleased

    private void P2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_P2KeyReleased
        // TODO add your handling code here:
        suma(16);
    }//GEN-LAST:event_P2KeyReleased

    private void P1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_P1KeyReleased
        // TODO add your handling code here:
        suma(16);
    }//GEN-LAST:event_P1KeyReleased

    private void N6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_N6KeyReleased
        // TODO add your handling code here:
        suma(14);
    }//GEN-LAST:event_N6KeyReleased

    private void N5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_N5KeyReleased
        // TODO add your handling code here:
        suma(14);
    }//GEN-LAST:event_N5KeyReleased

    private void N4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_N4KeyReleased
        // TODO add your handling code here:
        suma(14);
    }//GEN-LAST:event_N4KeyReleased

    private void N3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_N3KeyReleased
        // TODO add your handling code here:
        suma(14);
    }//GEN-LAST:event_N3KeyReleased

    private void N2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_N2KeyReleased
        // TODO add your handling code here:
        suma(14);
    }//GEN-LAST:event_N2KeyReleased

    private void N1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_N1KeyReleased
        // TODO add your handling code here:
        suma(14);
    }//GEN-LAST:event_N1KeyReleased

    private void M6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_M6KeyReleased
        // TODO add your handling code here:
        //   suma(13);
    }//GEN-LAST:event_M6KeyReleased

    private void M5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_M5KeyReleased
        // TODO add your handling code here:
        //   suma(13);
    }//GEN-LAST:event_M5KeyReleased

    private void M4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_M4KeyReleased
        // TODO add your handling code here:
        //   suma(13);
    }//GEN-LAST:event_M4KeyReleased

    private void M3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_M3KeyReleased
        // TODO add your handling code here:
        //   suma(13);
    }//GEN-LAST:event_M3KeyReleased

    private void M2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_M2KeyReleased
        // TODO add your handling code here:
        //   suma(13);
    }//GEN-LAST:event_M2KeyReleased

    private void M1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_M1KeyReleased
        // TODO add your handling code here:
        //    suma(13);
    }//GEN-LAST:event_M1KeyReleased

    private void L6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_L6KeyReleased
        // TODO add your handling code here:
        //  suma(12);
    }//GEN-LAST:event_L6KeyReleased

    private void L5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_L5KeyReleased
        // TODO add your handling code here:
        //    suma(12);
    }//GEN-LAST:event_L5KeyReleased

    private void L4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_L4KeyReleased
        // TODO add your handling code here:
        //       suma(12);
    }//GEN-LAST:event_L4KeyReleased

    private void L3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_L3KeyReleased
        // TODO add your handling code here:
        //     suma(12);
    }//GEN-LAST:event_L3KeyReleased

    private void L2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_L2KeyReleased
        // TODO add your handling code here:
        //      suma(12);
    }//GEN-LAST:event_L2KeyReleased

    private void L1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_L1KeyReleased
        // TODO add your handling code here:
        //    suma(12);
    }//GEN-LAST:event_L1KeyReleased

    private void K6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_K6KeyReleased
        // TODO add your handling code here:
        //    suma(11);
    }//GEN-LAST:event_K6KeyReleased

    private void K5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_K5KeyReleased
        // TODO add your handling code here:
        //    suma(11);
    }//GEN-LAST:event_K5KeyReleased

    private void K4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_K4KeyReleased
        // TODO add your handling code here:
        //    suma(11);
    }//GEN-LAST:event_K4KeyReleased

    private void K3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_K3KeyReleased
        // TODO add your handling code here:
        //     suma(11);
    }//GEN-LAST:event_K3KeyReleased

    private void K2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_K2KeyReleased
        // TODO add your handling code here:
        //       suma(11);
    }//GEN-LAST:event_K2KeyReleased

    private void K1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_K1KeyReleased
        // TODO add your handling code here:
        //        suma(11);
    }//GEN-LAST:event_K1KeyReleased

    private void J6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_J6KeyReleased
        // TODO add your handling code here:
        suma(10);
    }//GEN-LAST:event_J6KeyReleased

    private void J5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_J5KeyReleased
        // TODO add your handling code here:
        suma(10);
    }//GEN-LAST:event_J5KeyReleased

    private void J4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_J4KeyReleased
        // TODO add your handling code here:
        suma(10);
    }//GEN-LAST:event_J4KeyReleased

    private void J3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_J3KeyReleased
        // TODO add your handling code here:
        suma(10);
    }//GEN-LAST:event_J3KeyReleased

    private void J2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_J2KeyReleased
        // TODO add your handling code here:
        suma(10);
    }//GEN-LAST:event_J2KeyReleased

    private void J1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_J1KeyReleased
        // TODO add your handling code here:
        suma(10);
    }//GEN-LAST:event_J1KeyReleased

    private void O6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_O6KeyReleased
        // TODO add your handling code here:
        suma(15);
    }//GEN-LAST:event_O6KeyReleased

    private void O5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_O5KeyReleased
        // TODO add your handling code here:
        suma(15);
    }//GEN-LAST:event_O5KeyReleased

    private void O4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_O4KeyReleased
        // TODO add your handling code here:
        suma(15);
    }//GEN-LAST:event_O4KeyReleased

    private void O3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_O3KeyReleased
        // TODO add your handling code here:
        suma(15);
    }//GEN-LAST:event_O3KeyReleased

    private void O2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_O2KeyReleased
        // TODO add your handling code here:
        suma(15);
    }//GEN-LAST:event_O2KeyReleased

    private void O1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_O1KeyReleased
        // TODO add your handling code here:
        suma(15);
    }//GEN-LAST:event_O1KeyReleased

    private void I6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I6KeyReleased
        // TODO add your handling code here:
        suma(9);
    }//GEN-LAST:event_I6KeyReleased

    private void I5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I5KeyReleased
        // TODO add your handling code here:
        suma(9);
    }//GEN-LAST:event_I5KeyReleased

    private void I4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I4KeyReleased
        // TODO add your handling code here:
        suma(9);
    }//GEN-LAST:event_I4KeyReleased

    private void I3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I3KeyReleased
        // TODO add your handling code here:
        suma(9);
    }//GEN-LAST:event_I3KeyReleased

    private void I2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I2KeyReleased
        // TODO add your handling code here:
        suma(9);
    }//GEN-LAST:event_I2KeyReleased

    private void I1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I1KeyReleased
        // TODO add your handling code here:
        suma(9);
    }//GEN-LAST:event_I1KeyReleased

    private void H6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_H6KeyReleased
        // TODO add your handling code here:
        suma(8);
    }//GEN-LAST:event_H6KeyReleased

    private void H5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_H5KeyReleased
        // TODO add your handling code here:
        suma(8);
    }//GEN-LAST:event_H5KeyReleased

    private void H4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_H4KeyReleased
        // TODO add your handling code here:
        suma(8);
    }//GEN-LAST:event_H4KeyReleased

    private void H3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_H3KeyReleased
        // TODO add your handling code here:
        suma(8);
    }//GEN-LAST:event_H3KeyReleased

    private void H2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_H2KeyReleased
        // TODO add your handling code here:
        suma(8);
    }//GEN-LAST:event_H2KeyReleased

    private void H1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_H1KeyReleased
        // TODO add your handling code here:
        suma(8);
    }//GEN-LAST:event_H1KeyReleased

    private void G6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_G6KeyReleased
        // TODO add your handling code here:
        suma(7);
    }//GEN-LAST:event_G6KeyReleased

    private void G5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_G5KeyReleased
        // TODO add your handling code here:
        suma(7);
    }//GEN-LAST:event_G5KeyReleased

    private void G4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_G4KeyReleased
        // TODO add your handling code here:
        suma(7);
    }//GEN-LAST:event_G4KeyReleased

    private void G3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_G3KeyReleased
        // TODO add your handling code here:
        suma(7);
    }//GEN-LAST:event_G3KeyReleased

    private void G2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_G2KeyReleased
        // TODO add your handling code here:
        suma(7);
    }//GEN-LAST:event_G2KeyReleased

    private void G1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_G1KeyReleased
        // TODO add your handling code here:
        suma(7);
    }//GEN-LAST:event_G1KeyReleased

    private void F6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_F6KeyReleased
        // TODO add your handling code here:
        suma(6);
    }//GEN-LAST:event_F6KeyReleased

    private void F5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_F5KeyReleased
        // TODO add your handling code here:
        suma(6);
    }//GEN-LAST:event_F5KeyReleased

    private void F4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_F4KeyReleased
        // TODO add your handling code here:
        suma(6);
    }//GEN-LAST:event_F4KeyReleased

    private void F3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_F3KeyReleased
        // TODO add your handling code here:
        suma(6);
    }//GEN-LAST:event_F3KeyReleased

    private void F2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_F2KeyReleased
        // TODO add your handling code here:
        suma(6);
    }//GEN-LAST:event_F2KeyReleased

    private void F1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_F1KeyReleased
        // TODO add your handling code here:
        suma(6);
    }//GEN-LAST:event_F1KeyReleased

    private void E6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_E6KeyReleased
        // TODO add your handling code here:
        suma(5);
    }//GEN-LAST:event_E6KeyReleased

    private void E5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_E5KeyReleased
        // TODO add your handling code here:
        suma(5);
    }//GEN-LAST:event_E5KeyReleased

    private void E4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_E4KeyReleased
        // TODO add your handling code here:
        suma(5);
    }//GEN-LAST:event_E4KeyReleased

    private void E3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_E3KeyReleased
        // TODO add your handling code here:
        suma(5);
    }//GEN-LAST:event_E3KeyReleased

    private void E2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_E2KeyReleased
        // TODO add your handling code here:
        suma(5);
    }//GEN-LAST:event_E2KeyReleased

    private void E1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_E1KeyReleased
        // TODO add your handling code here:
        suma(5);
    }//GEN-LAST:event_E1KeyReleased

    private void D6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_D6KeyReleased
        // TODO add your handling code here:
        suma(4);
    }//GEN-LAST:event_D6KeyReleased

    private void D5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_D5KeyReleased
        // TODO add your handling code here:
        suma(4);
    }//GEN-LAST:event_D5KeyReleased

    private void D4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_D4KeyReleased
        // TODO add your handling code here:
        suma(4);
    }//GEN-LAST:event_D4KeyReleased

    private void D3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_D3KeyReleased
        // TODO add your handling code here:
        suma(4);
    }//GEN-LAST:event_D3KeyReleased

    private void D2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_D2KeyReleased
        // TODO add your handling code here:
        suma(4);
    }//GEN-LAST:event_D2KeyReleased

    private void D1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_D1KeyReleased
        // TODO add your handling code here:
        suma(4);
    }//GEN-LAST:event_D1KeyReleased

    private void C6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C6KeyReleased
        // TODO add your handling code here:
        suma(3);
    }//GEN-LAST:event_C6KeyReleased

    private void C5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C5KeyReleased
        // TODO add your handling code here:
        suma(3);
    }//GEN-LAST:event_C5KeyReleased

    private void C4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C4KeyReleased
        // TODO add your handling code here:
        suma(3);
    }//GEN-LAST:event_C4KeyReleased

    private void C3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C3KeyReleased
        // TODO add your handling code here:
        suma(3);
    }//GEN-LAST:event_C3KeyReleased

    private void C2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C2KeyReleased
        // TODO add your handling code here:
        suma(3);
    }//GEN-LAST:event_C2KeyReleased

    private void C1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C1KeyReleased
        // TODO add your handling code here:
        suma(3);
    }//GEN-LAST:event_C1KeyReleased

    private void B6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B6KeyReleased
        // TODO add your handling code here:
        suma(2);
    }//GEN-LAST:event_B6KeyReleased

    private void B5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B5KeyReleased
        // TODO add your handling code here:
        suma(2);
    }//GEN-LAST:event_B5KeyReleased

    private void B4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B4KeyReleased
        // TODO add your handling code here:
        suma(2);
    }//GEN-LAST:event_B4KeyReleased

    private void B3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B3KeyReleased
        // TODO add your handling code here:
        suma(2);
    }//GEN-LAST:event_B3KeyReleased

    private void B2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B2KeyReleased
        // TODO add your handling code here:
        suma(2);
    }//GEN-LAST:event_B2KeyReleased

    private void B1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B1KeyReleased
        // TODO add your handling code here:
        suma(2);
    }//GEN-LAST:event_B1KeyReleased

    private void B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_B1ActionPerformed

    private void A4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_A4KeyReleased
        // TODO add your handling code here:
        suma(1);
        rendimiento();
    }//GEN-LAST:event_A4KeyReleased

    private void ATKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ATKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ATKeyReleased

    private void A6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_A6KeyReleased
        // TODO add your handling code here:
        suma(1);
        rendimiento();
    }//GEN-LAST:event_A6KeyReleased

    private void A5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_A5KeyReleased
        // TODO add your handling code here:
        suma(1);
        rendimiento();
    }//GEN-LAST:event_A5KeyReleased

    private void A3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_A3KeyReleased
        // TODO add your handling code here:
        suma(1);
        rendimiento();
    }//GEN-LAST:event_A3KeyReleased

    private void A1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_A1KeyReleased
        // TODO add your handling code here:
        suma(1);
        rendimiento();
    }//GEN-LAST:event_A1KeyReleased

    private void A2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_A2KeyReleased
        // TODO add your handling code here:
        suma(1);
        rendimiento();
    }//GEN-LAST:event_A2KeyReleased

    private void A1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_A1FocusGained
        // TODO add your handling code here:
        quitarCero(A1);
    }//GEN-LAST:event_A1FocusGained

    private void A1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_A1FocusLost
        // TODO add your handling code here:
        ponerCero(A1);
        suma(1);
        rendimiento();
    }//GEN-LAST:event_A1FocusLost

    private void A2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_A2FocusGained
        // TODO add your handling code here:
        quitarCero(A2);
    }//GEN-LAST:event_A2FocusGained

    private void A2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_A2FocusLost
        // TODO add your handling code here:
        ponerCero(A2);
        suma(1);
        rendimiento();
    }//GEN-LAST:event_A2FocusLost

    private void A3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_A3FocusGained
        // TODO add your handling code here:
        quitarCero(A3);
    }//GEN-LAST:event_A3FocusGained

    private void A3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_A3FocusLost
        // TODO add your handling code here:
        ponerCero(A3);
        suma(1);
        rendimiento();
    }//GEN-LAST:event_A3FocusLost

    private void A4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_A4FocusGained
        // TODO add your handling code here:
        quitarCero(A4);
    }//GEN-LAST:event_A4FocusGained

    private void A4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_A4FocusLost
        // TODO add your handling code here:
        ponerCero(A4);
        suma(1);
        rendimiento();
    }//GEN-LAST:event_A4FocusLost

    private void A5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_A5FocusGained
        // TODO add your handling code here:
        quitarCero(A5);
    }//GEN-LAST:event_A5FocusGained

    private void A5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_A5FocusLost
        // TODO add your handling code here:
        ponerCero(A5);
        suma(1);
        rendimiento();
    }//GEN-LAST:event_A5FocusLost

    private void A6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_A6FocusGained
        // TODO add your handling code here:
        quitarCero(A6);
    }//GEN-LAST:event_A6FocusGained

    private void A6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_A6FocusLost
        // TODO add your handling code here:
        ponerCero(A6);
        suma(1);
        rendimiento();
    }//GEN-LAST:event_A6FocusLost

    private void B1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_B1FocusGained
        // TODO add your handling code here:
        quitarCero(B1);
    }//GEN-LAST:event_B1FocusGained

    private void B1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_B1FocusLost
        // TODO add your handling code here:
        ponerCero(B1);
        suma(2);
        rendimiento();
    }//GEN-LAST:event_B1FocusLost

    private void B2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_B2FocusGained
        // TODO add your handling code here:
        quitarCero(B2);
    }//GEN-LAST:event_B2FocusGained

    private void B2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_B2FocusLost
        // TODO add your handling code here:
        ponerCero(B2);
        suma(2);
        rendimiento();
    }//GEN-LAST:event_B2FocusLost

    private void B3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_B3FocusGained
        // TODO add your handling code here:
        quitarCero(B3);
    }//GEN-LAST:event_B3FocusGained

    private void B3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_B3FocusLost
        // TODO add your handling code here:
        ponerCero(B3);
        suma(2);
        rendimiento();
    }//GEN-LAST:event_B3FocusLost

    private void B4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_B4FocusGained
        // TODO add your handling code here:
        quitarCero(B4);
    }//GEN-LAST:event_B4FocusGained

    private void B4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_B4FocusLost
        // TODO add your handling code here:
        ponerCero(B4);
        suma(2);
        rendimiento();
    }//GEN-LAST:event_B4FocusLost

    private void B5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_B5FocusGained
        // TODO add your handling code here:
        quitarCero(B5);
    }//GEN-LAST:event_B5FocusGained

    private void B5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_B5FocusLost
        // TODO add your handling code here:
        ponerCero(B5);
        suma(2);
        rendimiento();
    }//GEN-LAST:event_B5FocusLost

    private void B6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_B6FocusGained
        // TODO add your handling code here:
        quitarCero(B6);
    }//GEN-LAST:event_B6FocusGained

    private void B6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_B6FocusLost
        // TODO add your handling code here:
        ponerCero(B6);
        suma(2);
        rendimiento();
    }//GEN-LAST:event_B6FocusLost

    private void C1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_C1FocusGained
        // TODO add your handling code here:
        quitarCero(C1);
    }//GEN-LAST:event_C1FocusGained

    private void C1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_C1FocusLost
        // TODO add your handling code here:
        ponerCero(C1);
        suma(3);
        rendimiento();
    }//GEN-LAST:event_C1FocusLost

    private void C2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_C2FocusGained
        // TODO add your handling code here:
        quitarCero(C2);
    }//GEN-LAST:event_C2FocusGained

    private void C2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_C2FocusLost
        // TODO add your handling code here:
        ponerCero(C2);
        suma(3);
        rendimiento();
    }//GEN-LAST:event_C2FocusLost

    private void C3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_C3FocusGained
        // TODO add your handling code here:
        quitarCero(C3);
    }//GEN-LAST:event_C3FocusGained

    private void C3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_C3FocusLost
        // TODO add your handling code here:
        ponerCero(C3);
        suma(3);
        rendimiento();
    }//GEN-LAST:event_C3FocusLost

    private void C4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_C4FocusGained
        // TODO add your handling code here:
        quitarCero(C4);
    }//GEN-LAST:event_C4FocusGained

    private void C4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_C4FocusLost
        // TODO add your handling code here:
        ponerCero(C4);
        suma(3);
        rendimiento();
    }//GEN-LAST:event_C4FocusLost

    private void C5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_C5FocusGained
        // TODO add your handling code here:
        quitarCero(C5);
    }//GEN-LAST:event_C5FocusGained

    private void C5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_C5FocusLost
        // TODO add your handling code here:
        ponerCero(C5);
        suma(3);
        rendimiento();
    }//GEN-LAST:event_C5FocusLost

    private void C6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_C6FocusGained
        // TODO add your handling code here:
        quitarCero(C6);
    }//GEN-LAST:event_C6FocusGained

    private void C6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_C6FocusLost
        // TODO add your handling code here:
        ponerCero(C6);
        suma(3);
        rendimiento();
    }//GEN-LAST:event_C6FocusLost

    private void D1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_D1FocusGained
        // TODO add your handling code here:
        quitarCero(D1);
    }//GEN-LAST:event_D1FocusGained

    private void D1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_D1FocusLost
        // TODO add your handling code here:
        ponerCero(D1);
        suma(4);
        rendimiento();
    }//GEN-LAST:event_D1FocusLost

    private void D2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_D2FocusGained
        // TODO add your handling code here:
        quitarCero(D2);
    }//GEN-LAST:event_D2FocusGained

    private void D2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_D2FocusLost
        // TODO add your handling code here:
        ponerCero(D2);
        suma(4);
        rendimiento();
    }//GEN-LAST:event_D2FocusLost

    private void D3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_D3FocusGained
        // TODO add your handling code here:
        quitarCero(D3);
    }//GEN-LAST:event_D3FocusGained

    private void D3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_D3FocusLost
        // TODO add your handling code here:
        ponerCero(D3);
        suma(4);
        rendimiento();
    }//GEN-LAST:event_D3FocusLost

    private void D4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_D4FocusGained
        // TODO add your handling code here:
        quitarCero(D4);
    }//GEN-LAST:event_D4FocusGained

    private void D4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_D4FocusLost
        // TODO add your handling code here:
        ponerCero(D4);
        suma(4);
        rendimiento();
    }//GEN-LAST:event_D4FocusLost

    private void D5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_D5FocusGained
        // TODO add your handling code here:
        quitarCero(D5);
    }//GEN-LAST:event_D5FocusGained

    private void D5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_D5FocusLost
        // TODO add your handling code here:
        ponerCero(D5);
        suma(4);
        rendimiento();
    }//GEN-LAST:event_D5FocusLost

    private void D6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_D6FocusGained
        // TODO add your handling code here:
        quitarCero(D6);
    }//GEN-LAST:event_D6FocusGained

    private void D6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_D6FocusLost
        // TODO add your handling code here:
        ponerCero(D6
        );
        suma(4);
        rendimiento();
    }//GEN-LAST:event_D6FocusLost

    private void E1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_E1FocusGained
        // TODO add your handling code here:
        quitarCero(E1);
    }//GEN-LAST:event_E1FocusGained

    private void E1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_E1FocusLost
        // TODO add your handling code here:
        ponerCero(E1);
        suma(5);
        rendimiento();
    }//GEN-LAST:event_E1FocusLost

    private void E2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_E2FocusGained
        // TODO add your handling code here:
        quitarCero(E2);
    }//GEN-LAST:event_E2FocusGained

    private void E2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_E2FocusLost
        // TODO add your handling code here:
        ponerCero(E2);
        suma(5);
        rendimiento();
    }//GEN-LAST:event_E2FocusLost

    private void E3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_E3FocusGained
        // TODO add your handling code here:
        quitarCero(E3);
    }//GEN-LAST:event_E3FocusGained

    private void E3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_E3FocusLost
        // TODO add your handling code here:
        ponerCero(E3);
        suma(5);
        rendimiento();
    }//GEN-LAST:event_E3FocusLost

    private void E4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_E4FocusGained
        // TODO add your handling code here:
        quitarCero(E4);
    }//GEN-LAST:event_E4FocusGained

    private void E4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_E4FocusLost
        // TODO add your handling code here:
        ponerCero(E4);
        suma(5);
        rendimiento();
    }//GEN-LAST:event_E4FocusLost

    private void E5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_E5FocusGained
        // TODO add your handling code here:
        quitarCero(E5);
    }//GEN-LAST:event_E5FocusGained

    private void E5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_E5FocusLost
        // TODO add your handling code here:
        ponerCero(E5);
        suma(5);
        rendimiento();
    }//GEN-LAST:event_E5FocusLost

    private void E6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_E6FocusGained
        // TODO add your handling code here:
        quitarCero(E6);
    }//GEN-LAST:event_E6FocusGained

    private void E6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_E6FocusLost
        // TODO add your handling code here:
        ponerCero(E6);
        suma(5);
        rendimiento();
    }//GEN-LAST:event_E6FocusLost

    private void F1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_F1FocusGained
        // TODO add your handling code here:
        quitarCero(F1);
    }//GEN-LAST:event_F1FocusGained

    private void F1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_F1FocusLost
        // TODO add your handling code here:
        ponerCero(F1);
        suma(6);
        rendimiento();
    }//GEN-LAST:event_F1FocusLost

    private void F2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_F2FocusGained
        // TODO add your handling code here:
        quitarCero(F2);
    }//GEN-LAST:event_F2FocusGained

    private void F2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_F2FocusLost
        // TODO add your handling code here:
        ponerCero(F2);
        suma(6);
        rendimiento();
    }//GEN-LAST:event_F2FocusLost

    private void F3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_F3FocusGained
        // TODO add your handling code here:
        quitarCero(F3);
    }//GEN-LAST:event_F3FocusGained

    private void F3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_F3FocusLost
        // TODO add your handling code here:
        ponerCero(F3);
        suma(6);
        rendimiento();
    }//GEN-LAST:event_F3FocusLost

    private void F4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_F4FocusGained
        // TODO add your handling code here:
        quitarCero(F4);
    }//GEN-LAST:event_F4FocusGained

    private void F4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_F4FocusLost
        // TODO add your handling code here:
        ponerCero(F4);
        suma(6);
        rendimiento();
    }//GEN-LAST:event_F4FocusLost

    private void F5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_F5FocusGained
        // TODO add your handling code here:
        quitarCero(F5);
    }//GEN-LAST:event_F5FocusGained

    private void F5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_F5FocusLost
        // TODO add your handling code here:
        ponerCero(F5);
        suma(6);
        rendimiento();
    }//GEN-LAST:event_F5FocusLost

    private void F6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_F6FocusGained
        // TODO add your handling code here:
        quitarCero(F6);
    }//GEN-LAST:event_F6FocusGained

    private void F6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_F6FocusLost
        // TODO add your handling code here:
        ponerCero(F6);
        suma(6);
        rendimiento();
    }//GEN-LAST:event_F6FocusLost

    private void G1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_G1FocusGained
        // TODO add your handling code here:
        quitarCero(G1);
    }//GEN-LAST:event_G1FocusGained

    private void G1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_G1FocusLost
        // TODO add your handling code here:
        ponerCero(G1);
        suma(7);
        rendimiento();
    }//GEN-LAST:event_G1FocusLost

    private void G2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_G2FocusGained
        // TODO add your handling code here:
        quitarCero(G2);
    }//GEN-LAST:event_G2FocusGained

    private void G2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_G2FocusLost
        // TODO add your handling code here:
        ponerCero(G2);
        suma(7);
        rendimiento();
    }//GEN-LAST:event_G2FocusLost

    private void G3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_G3FocusGained
        // TODO add your handling code here:
        quitarCero(G3);
    }//GEN-LAST:event_G3FocusGained

    private void G3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_G3FocusLost
        // TODO add your handling code here:
        ponerCero(G3);
        suma(7);
        rendimiento();
    }//GEN-LAST:event_G3FocusLost

    private void G4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_G4FocusGained
        // TODO add your handling code here:
        quitarCero(G4);
    }//GEN-LAST:event_G4FocusGained

    private void G4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_G4FocusLost
        // TODO add your handling code here:
        ponerCero(G4);
        suma(7);
        rendimiento();
    }//GEN-LAST:event_G4FocusLost

    private void G5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_G5FocusGained
        // TODO add your handling code here:
        quitarCero(G5);
    }//GEN-LAST:event_G5FocusGained

    private void G5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_G5FocusLost
        // TODO add your handling code here:
        ponerCero(G5);
        suma(7);
        rendimiento();
    }//GEN-LAST:event_G5FocusLost

    private void G6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_G6FocusGained
        // TODO add your handling code here:
        quitarCero(G6);
    }//GEN-LAST:event_G6FocusGained

    private void G6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_G6FocusLost
        // TODO add your handling code here:
        ponerCero(G6);
        suma(7);
        rendimiento();
    }//GEN-LAST:event_G6FocusLost

    private void H1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_H1FocusGained
        // TODO add your handling code here:
        quitarCero(H1);
    }//GEN-LAST:event_H1FocusGained

    private void H1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_H1FocusLost
        // TODO add your handling code here:
        ponerCero(H1);
        suma(8);
        rendimiento();
    }//GEN-LAST:event_H1FocusLost

    private void H2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_H2FocusGained
        // TODO add your handling code here:
        quitarCero(H2);
    }//GEN-LAST:event_H2FocusGained

    private void H2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_H2FocusLost
        // TODO add your handling code here:
        ponerCero(H2);
        suma(8);
        rendimiento();
    }//GEN-LAST:event_H2FocusLost

    private void H3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_H3FocusGained
        // TODO add your handling code here:
        quitarCero(H3);
    }//GEN-LAST:event_H3FocusGained

    private void H3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_H3FocusLost
        // TODO add your handling code here:
        ponerCero(H3);
        suma(8);
        rendimiento();
    }//GEN-LAST:event_H3FocusLost

    private void H4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_H4FocusGained
        // TODO add your handling code here:
        quitarCero(H4);
    }//GEN-LAST:event_H4FocusGained

    private void H4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_H4FocusLost
        // TODO add your handling code here:
        ponerCero(H4);
        suma(8);
        rendimiento();
    }//GEN-LAST:event_H4FocusLost

    private void H5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_H5FocusGained
        // TODO add your handling code here:
        quitarCero(H5);
    }//GEN-LAST:event_H5FocusGained

    private void H5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_H5FocusLost
        // TODO add your handling code here:
        ponerCero(H5);
        suma(8);
        rendimiento();
    }//GEN-LAST:event_H5FocusLost

    private void H6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_H6FocusGained
        // TODO add your handling code here:
        quitarCero(H6);
    }//GEN-LAST:event_H6FocusGained

    private void H6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_H6FocusLost
        // TODO add your handling code here:
        ponerCero(H6);
        suma(8);
        rendimiento();
    }//GEN-LAST:event_H6FocusLost

    private void I1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_I1FocusGained
        // TODO add your handling code here:
        quitarCero(I1);
    }//GEN-LAST:event_I1FocusGained

    private void I1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_I1FocusLost
        // TODO add your handling code here:
        ponerCero(I1);
        suma(9);
        rendimiento();
    }//GEN-LAST:event_I1FocusLost

    private void I2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_I2FocusGained
        // TODO add your handling code here:
        quitarCero(I2);
    }//GEN-LAST:event_I2FocusGained

    private void I2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_I2FocusLost
        // TODO add your handling code here:
        ponerCero(I2);
        suma(9);
        rendimiento();
    }//GEN-LAST:event_I2FocusLost

    private void I3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_I3FocusGained
        // TODO add your handling code here:
        quitarCero(I3);
    }//GEN-LAST:event_I3FocusGained

    private void I3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_I3FocusLost
        // TODO add your handling code here:
        ponerCero(I3);
        suma(9);
        rendimiento();
    }//GEN-LAST:event_I3FocusLost

    private void I4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_I4FocusGained
        // TODO add your handling code here:
        quitarCero(I4);
    }//GEN-LAST:event_I4FocusGained

    private void I4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_I4FocusLost
        // TODO add your handling code here:
        ponerCero(I4);
        suma(9);
        rendimiento();
    }//GEN-LAST:event_I4FocusLost

    private void I5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_I5FocusGained
        // TODO add your handling code here:
        quitarCero(I5);
    }//GEN-LAST:event_I5FocusGained

    private void I5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_I5FocusLost
        // TODO add your handling code here:
        ponerCero(I5);
        suma(9);
        rendimiento();
    }//GEN-LAST:event_I5FocusLost

    private void I6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_I6FocusGained
        // TODO add your handling code here:
        quitarCero(I6);
    }//GEN-LAST:event_I6FocusGained

    private void I6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_I6FocusLost
        // TODO add your handling code here:
        ponerCero(I6);
        suma(9);
        rendimiento();
    }//GEN-LAST:event_I6FocusLost

    private void O1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_O1FocusGained
        // TODO add your handling code here:
        quitarCero(O1);
    }//GEN-LAST:event_O1FocusGained

    private void O1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_O1FocusLost
        // TODO add your handling code here:
        ponerCero(O1);
        suma(15);
        rendimiento();
    }//GEN-LAST:event_O1FocusLost

    private void O2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_O2FocusGained
        // TODO add your handling code here:
        quitarCero(O2);
    }//GEN-LAST:event_O2FocusGained

    private void O2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_O2FocusLost
        // TODO add your handling code here:
        ponerCero(O2);
        suma(15);
        rendimiento();
    }//GEN-LAST:event_O2FocusLost

    private void O3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_O3FocusGained
        // TODO add your handling code here:
        quitarCero(O3);
    }//GEN-LAST:event_O3FocusGained

    private void O3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_O3FocusLost
        // TODO add your handling code here:
        ponerCero(O3);
        suma(15);
        rendimiento();
    }//GEN-LAST:event_O3FocusLost

    private void O4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_O4FocusGained
        // TODO add your handling code here:
        quitarCero(O4);
    }//GEN-LAST:event_O4FocusGained

    private void O4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_O4FocusLost
        // TODO add your handling code here:
        ponerCero(O4);
        suma(15);
        rendimiento();
    }//GEN-LAST:event_O4FocusLost

    private void O5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_O5FocusGained
        // TODO add your handling code here:
        quitarCero(O5);
    }//GEN-LAST:event_O5FocusGained

    private void O5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_O5FocusLost
        // TODO add your handling code here:
        ponerCero(O5);
        suma(15);
        rendimiento();
    }//GEN-LAST:event_O5FocusLost

    private void O6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_O6FocusGained
        // TODO add your handling code here:
        quitarCero(O6);
    }//GEN-LAST:event_O6FocusGained

    private void O6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_O6FocusLost
        // TODO add your handling code here:
        ponerCero(O6);
        suma(15);
        rendimiento();
    }//GEN-LAST:event_O6FocusLost

    private void J1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_J1FocusGained
        // TODO add your handling code here:
        quitarCero(J1);
    }//GEN-LAST:event_J1FocusGained

    private void J1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_J1FocusLost
        // TODO add your handling code here:
        ponerCero(J1);
        suma(10);
        rendimiento();
    }//GEN-LAST:event_J1FocusLost

    private void J2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_J2FocusGained
        // TODO add your handling code here:
        quitarCero(J2);
    }//GEN-LAST:event_J2FocusGained

    private void J2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_J2FocusLost
        // TODO add your handling code here:
        ponerCero(J2);
        suma(10);
        rendimiento();
    }//GEN-LAST:event_J2FocusLost

    private void J3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_J3FocusGained
        // TODO add your handling code here:
        quitarCero(J3);
    }//GEN-LAST:event_J3FocusGained

    private void J3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_J3FocusLost
        // TODO add your handling code here:
        ponerCero(J3);
        suma(10);
        rendimiento();
    }//GEN-LAST:event_J3FocusLost

    private void J4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_J4FocusGained
        // TODO add your handling code here:
        quitarCero(J4);
    }//GEN-LAST:event_J4FocusGained

    private void J4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_J4FocusLost
        // TODO add your handling code here:
        ponerCero(J4);
        suma(10);
        rendimiento();
    }//GEN-LAST:event_J4FocusLost

    private void J5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_J5FocusGained
        // TODO add your handling code here:
        quitarCero(J5);
    }//GEN-LAST:event_J5FocusGained

    private void J5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_J5FocusLost
        // TODO add your handling code here:
        ponerCero(J5);
        suma(10);
        rendimiento();
    }//GEN-LAST:event_J5FocusLost

    private void J6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_J6FocusGained
        // TODO add your handling code here:
        quitarCero(J6);
    }//GEN-LAST:event_J6FocusGained

    private void J6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_J6FocusLost
        // TODO add your handling code here:
        ponerCero(J6);
        suma(10);
        rendimiento();
    }//GEN-LAST:event_J6FocusLost

    private void K1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_K1FocusGained
        // TODO add your handling code here:
        quitarCero(K1);
    }//GEN-LAST:event_K1FocusGained

    private void K1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_K1FocusLost
        // TODO add your handling code here:
        ponerCero(K1);
        suma(11);
        rendimiento();
    }//GEN-LAST:event_K1FocusLost

    private void K2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_K2FocusGained
        // TODO add your handling code here:
        quitarCero(K2);
    }//GEN-LAST:event_K2FocusGained

    private void K2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_K2FocusLost
        // TODO add your handling code here:
        ponerCero(K2);
        suma(11);
        rendimiento();
    }//GEN-LAST:event_K2FocusLost

    private void K3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_K3FocusGained
        // TODO add your handling code here:
        quitarCero(K3);
    }//GEN-LAST:event_K3FocusGained

    private void K3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_K3FocusLost
        // TODO add your handling code here:
        ponerCero(K3);
        suma(11);
        rendimiento();
    }//GEN-LAST:event_K3FocusLost

    private void K4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_K4FocusGained
        // TODO add your handling code here:
        quitarCero(K4);
    }//GEN-LAST:event_K4FocusGained

    private void K4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_K4FocusLost
        // TODO add your handling code here:
        ponerCero(K4);
        suma(11);
        rendimiento();
    }//GEN-LAST:event_K4FocusLost

    private void K5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_K5FocusGained
        // TODO add your handling code here:
        quitarCero(K5);
    }//GEN-LAST:event_K5FocusGained

    private void K5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_K5FocusLost
        // TODO add your handling code here:
        ponerCero(K5);
        suma(11);
        rendimiento();
    }//GEN-LAST:event_K5FocusLost

    private void K6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_K6FocusGained
        // TODO add your handling code here:
        quitarCero(K6);
    }//GEN-LAST:event_K6FocusGained

    private void K6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_K6FocusLost
        // TODO add your handling code here:
        ponerCero(K6);
        suma(11);
        rendimiento();
    }//GEN-LAST:event_K6FocusLost

    private void L1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_L1FocusGained
        // TODO add your handling code here:
        quitarCero(L1);
    }//GEN-LAST:event_L1FocusGained

    private void L1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_L1FocusLost
        // TODO add your handling code here:
        ponerCero(L1);
        suma(12);
        rendimiento();
    }//GEN-LAST:event_L1FocusLost

    private void L2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_L2FocusGained
        // TODO add your handling cde here:
        quitarCero(L2);
    }//GEN-LAST:event_L2FocusGained

    private void L2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_L2FocusLost
        // TODO add your handling code here:
        ponerCero(L2);
        suma(12);
        rendimiento();
    }//GEN-LAST:event_L2FocusLost

    private void L3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_L3FocusGained
        // TODO add your handling code here:
        quitarCero(L3);
    }//GEN-LAST:event_L3FocusGained

    private void L3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_L3FocusLost
        // TODO add your handling code here:
        ponerCero(L3);
        suma(12);
        rendimiento();
    }//GEN-LAST:event_L3FocusLost

    private void L4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_L4FocusGained
        // TODO add your handling code here:
        quitarCero(L4);
    }//GEN-LAST:event_L4FocusGained

    private void L4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_L4FocusLost
        // TODO add your handling code here:
        ponerCero(L4);
        suma(12);
        rendimiento();
    }//GEN-LAST:event_L4FocusLost

    private void L5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_L5FocusGained
        // TODO add your handling code here:
        quitarCero(L5);
    }//GEN-LAST:event_L5FocusGained

    private void L5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_L5FocusLost
        // TODO add your handling code here:
        ponerCero(L5);
        suma(12);
        rendimiento();
    }//GEN-LAST:event_L5FocusLost

    private void L6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_L6FocusGained
        // TODO add your handling code here:
        quitarCero(L6);
    }//GEN-LAST:event_L6FocusGained

    private void L6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_L6FocusLost
        // TODO add your handling code here:
        ponerCero(L6);
        suma(12);
        rendimiento();
    }//GEN-LAST:event_L6FocusLost

    private void M1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_M1FocusGained
        // TODO add your handling code here:
        quitarCero(M1);
    }//GEN-LAST:event_M1FocusGained

    private void M1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_M1FocusLost
        // TODO add your handling code here:
        ponerCero(M1);
        suma(13);
        rendimiento();
    }//GEN-LAST:event_M1FocusLost

    private void M2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_M2FocusGained
        // TODO add your handling code here:
        quitarCero(M2);
    }//GEN-LAST:event_M2FocusGained

    private void M2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_M2FocusLost
        // TODO add your handling code here:
        ponerCero(M2);
        suma(13);
        rendimiento();
    }//GEN-LAST:event_M2FocusLost

    private void M3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_M3FocusGained
        // TODO add your handling code here:
        quitarCero(M3);
    }//GEN-LAST:event_M3FocusGained

    private void M3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_M3FocusLost
        // TODO add your handling code here:
        ponerCero(M3);
        suma(13);
        rendimiento();
    }//GEN-LAST:event_M3FocusLost

    private void M4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_M4FocusGained
        // TODO add your handling code here:
        quitarCero(M4);
    }//GEN-LAST:event_M4FocusGained

    private void M4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_M4FocusLost
        // TODO add your handling code here:
        ponerCero(M4);
        suma(13);
        rendimiento();
    }//GEN-LAST:event_M4FocusLost

    private void M5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_M5FocusGained
        // TODO add your handling code here:
        quitarCero(M5);
    }//GEN-LAST:event_M5FocusGained

    private void M5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_M5FocusLost
        // TODO add your handling code here:
        ponerCero(M5);
        suma(13);
        rendimiento();
    }//GEN-LAST:event_M5FocusLost

    private void M6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_M6FocusGained
        // TODO add your handling code here:
        quitarCero(M6);
    }//GEN-LAST:event_M6FocusGained

    private void M6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_M6FocusLost
        // TODO add your handling code here:
        ponerCero(M6);
        suma(13);
        rendimiento();
    }//GEN-LAST:event_M6FocusLost

    private void N1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_N1FocusGained
        // TODO add your handling code here:
        quitarCero(N1);
    }//GEN-LAST:event_N1FocusGained

    private void N1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_N1FocusLost
        // TODO add your handling code here:
        ponerCero(N1);
        suma(14);
        rendimiento();
    }//GEN-LAST:event_N1FocusLost

    private void N2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_N2FocusGained
        // TODO add your handling code here:
        quitarCero(N2);
    }//GEN-LAST:event_N2FocusGained

    private void N2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_N2FocusLost
        // TODO add your handling code here:
        ponerCero(N2);
        suma(14);
        rendimiento();
    }//GEN-LAST:event_N2FocusLost

    private void N3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_N3FocusGained
        // TODO add your handling code here:
        quitarCero(N3);
    }//GEN-LAST:event_N3FocusGained

    private void N3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_N3FocusLost
        // TODO add your handling code here:
        ponerCero(N3);
        suma(14);
        rendimiento();
    }//GEN-LAST:event_N3FocusLost

    private void N4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_N4FocusGained
        // TODO add your handling code here:
        quitarCero(N4);
    }//GEN-LAST:event_N4FocusGained

    private void N4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_N4FocusLost
        // TODO add your handling code here:
        ponerCero(N4);
        suma(14);
        rendimiento();
    }//GEN-LAST:event_N4FocusLost

    private void N5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_N5FocusGained
        // TODO add your handling code here:
        quitarCero(N5);
    }//GEN-LAST:event_N5FocusGained

    private void N5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_N5FocusLost
        // TODO add your handling code here:
        ponerCero(N5);
        suma(14);
        rendimiento();
    }//GEN-LAST:event_N5FocusLost

    private void N6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_N6FocusGained
        // TODO add your handling code here:
        quitarCero(N6);
    }//GEN-LAST:event_N6FocusGained

    private void N6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_N6FocusLost
        // TODO add your handling code here:
        ponerCero(N6);
        suma(14);
        rendimiento();
    }//GEN-LAST:event_N6FocusLost

    private void P1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_P1FocusGained
        // TODO add your handling code here:
        quitarCero(P1);
    }//GEN-LAST:event_P1FocusGained

    private void P1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_P1FocusLost
        // TODO add your handling code here:
        ponerCero(P1);
        suma(16);
        rendimiento();
    }//GEN-LAST:event_P1FocusLost

    private void P2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_P2FocusGained
        // TODO add your handling code here:
        quitarCero(P2);
    }//GEN-LAST:event_P2FocusGained

    private void P2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_P2FocusLost
        // TODO add your handling code here:
        ponerCero(P2);
        suma(16);
        rendimiento();
    }//GEN-LAST:event_P2FocusLost

    private void P3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_P3FocusGained
        // TODO add your handling code here:
        quitarCero(P3);
    }//GEN-LAST:event_P3FocusGained

    private void P3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_P3FocusLost
        // TODO add your handling code here:
        ponerCero(P3);
        suma(16);
        rendimiento();
    }//GEN-LAST:event_P3FocusLost

    private void P4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_P4FocusGained
        // TODO add your handling code here:
        quitarCero(P4);
    }//GEN-LAST:event_P4FocusGained

    private void P4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_P4FocusLost
        // TODO add your handling code here:
        ponerCero(P4);
        suma(16);
        rendimiento();
    }//GEN-LAST:event_P4FocusLost

    private void P5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_P5FocusGained
        // TODO add your handling code here:
        quitarCero(P5);
    }//GEN-LAST:event_P5FocusGained

    private void P5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_P5FocusLost
        // TODO add your handling code here:
        ponerCero(P5);
        suma(16);
        rendimiento();
    }//GEN-LAST:event_P5FocusLost

    private void P6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_P6FocusGained
        // TODO add your handling code here:
        quitarCero(P6);
    }//GEN-LAST:event_P6FocusGained

    private void P6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_P6FocusLost
        // TODO add your handling code here:
        ponerCero(P6);
        suma(16);
        rendimiento();
    }//GEN-LAST:event_P6FocusLost

    private void Q1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Q1FocusGained
        // TODO add your handling code here:
        quitarCero(Q1);
    }//GEN-LAST:event_Q1FocusGained

    private void Q1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Q1FocusLost
        // TODO add your handling code here:
        ponerCero(Q1);
        suma(17);
        rendimiento();
    }//GEN-LAST:event_Q1FocusLost

    private void Q2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Q2FocusGained
        // TODO add your handling code here:
        quitarCero(Q2);
    }//GEN-LAST:event_Q2FocusGained

    private void Q2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Q2FocusLost
        // TODO add your handling code here:
        ponerCero(Q2);
        suma(17);
        rendimiento();
    }//GEN-LAST:event_Q2FocusLost

    private void Q3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Q3FocusGained
        // TODO add your handling code here:
        quitarCero(Q3);
    }//GEN-LAST:event_Q3FocusGained

    private void Q3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Q3FocusLost
        // TODO add your handling code here:
        ponerCero(Q3);
        suma(17);
        rendimiento();
    }//GEN-LAST:event_Q3FocusLost

    private void Q4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Q4FocusGained
        // TODO add your handling code here:
        quitarCero(Q4);
    }//GEN-LAST:event_Q4FocusGained

    private void Q4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Q4FocusLost
        // TODO add your handling code here:
        ponerCero(Q4);
        suma(17);
        rendimiento();
    }//GEN-LAST:event_Q4FocusLost

    private void Q5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Q5FocusGained
        // TODO add your handling code here:
        quitarCero(Q5);
    }//GEN-LAST:event_Q5FocusGained

    private void Q5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Q5FocusLost
        // TODO add your handling code here:
        ponerCero(Q5);
        suma(17);
        rendimiento();
    }//GEN-LAST:event_Q5FocusLost

    private void Q6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Q6FocusGained
        // TODO add your handling code here:
        quitarCero(Q6);
    }//GEN-LAST:event_Q6FocusGained

    private void Q6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Q6FocusLost
        // TODO add your handling code here:
        ponerCero(Q6);
        suma(17);
        rendimiento();
    }//GEN-LAST:event_Q6FocusLost

    private void R1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_R1FocusGained
        // TODO add your handling code here:
        quitarCero(R1);
    }//GEN-LAST:event_R1FocusGained

    private void R1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_R1FocusLost
        // TODO add your handling code here:
        ponerCero(R1);
        suma(18);
        rendimiento();
    }//GEN-LAST:event_R1FocusLost

    private void R2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_R2FocusGained
        // TODO add your handling code here:
        quitarCero(R2);
    }//GEN-LAST:event_R2FocusGained

    private void R2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_R2FocusLost
        // TODO add your handling code here:
        ponerCero(R2);
        suma(18);
        rendimiento();
    }//GEN-LAST:event_R2FocusLost

    private void R3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_R3FocusGained
        // TODO add your handling code here:
        quitarCero(R3);
    }//GEN-LAST:event_R3FocusGained

    private void R3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_R3FocusLost
        // TODO add your handling code here:
        ponerCero(R3);
        suma(18);
        rendimiento();
    }//GEN-LAST:event_R3FocusLost

    private void R4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_R4FocusGained
        // TODO add your handling code here:
        quitarCero(R4);
    }//GEN-LAST:event_R4FocusGained

    private void R4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_R4FocusLost
        // TODO add your handling code here:
        ponerCero(R4);
        suma(18);
        rendimiento();
    }//GEN-LAST:event_R4FocusLost

    private void R5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_R5FocusGained
        // TODO add your handling code here:
        quitarCero(R5);
    }//GEN-LAST:event_R5FocusGained

    private void R5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_R5FocusLost
        // TODO add your handling code here:
        ponerCero(R5);
        suma(18);
        rendimiento();
    }//GEN-LAST:event_R5FocusLost

    private void R6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_R6FocusGained
        // TODO add your handling code here:
        quitarCero(R6);
    }//GEN-LAST:event_R6FocusGained

    private void R6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_R6FocusLost
        // TODO add your handling code here:
        ponerCero(R6);
        suma(18);
        rendimiento();
    }//GEN-LAST:event_R6FocusLost

    private void S1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S1FocusGained
        // TODO add your handling code here:
        quitarCero(S1);
    }//GEN-LAST:event_S1FocusGained

    private void S1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S1FocusLost
        // TODO add your handling code here:
        ponerCero(S1);
        suma(19);
        rendimiento();
    }//GEN-LAST:event_S1FocusLost

    private void S2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S2FocusGained
        // TODO add your handling code here:
        quitarCero(S2);
    }//GEN-LAST:event_S2FocusGained

    private void S2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S2FocusLost
        // TODO add your handling code here:
        ponerCero(S2);
        suma(19);
        rendimiento();
    }//GEN-LAST:event_S2FocusLost

    private void S3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S3FocusGained
        // TODO add your handling code here:
        quitarCero(S3);
    }//GEN-LAST:event_S3FocusGained

    private void S3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S3FocusLost
        // TODO add your handling code here:
        ponerCero(S3);
        suma(19);
        rendimiento();
    }//GEN-LAST:event_S3FocusLost

    private void S4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S4FocusGained
        // TODO add your handling code here:
        quitarCero(S4);
    }//GEN-LAST:event_S4FocusGained

    private void S4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S4FocusLost
        // TODO add your handling code here:
        ponerCero(S4);
        suma(19);
        rendimiento();
    }//GEN-LAST:event_S4FocusLost

    private void S5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S5FocusGained
        // TODO add your handling code here:
        quitarCero(S5);
    }//GEN-LAST:event_S5FocusGained

    private void S5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S5FocusLost
        // TODO add your handling code here:
        ponerCero(S5);
        suma(19);
        rendimiento();
    }//GEN-LAST:event_S5FocusLost

    private void S6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S6FocusGained
        // TODO add your handling code here:
        quitarCero(S6);
    }//GEN-LAST:event_S6FocusGained

    private void S6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S6FocusLost
        // TODO add your handling code here:
        ponerCero(S6);
        suma(19);
        rendimiento();
    }//GEN-LAST:event_S6FocusLost

    private void T1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_T1FocusGained
        // TODO add your handling code here:
        quitarCero(T1);
    }//GEN-LAST:event_T1FocusGained

    private void T1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_T1FocusLost
        // TODO add your handling code here:
        ponerCero(T1);
        suma(20);
        rendimiento();
    }//GEN-LAST:event_T1FocusLost

    private void T2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_T2FocusGained
        // TODO add your handling code here:
        quitarCero(T2);
    }//GEN-LAST:event_T2FocusGained

    private void T2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_T2FocusLost
        // TODO add your handling code here:
        ponerCero(T2);
        suma(20);
        rendimiento();
    }//GEN-LAST:event_T2FocusLost

    private void T3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_T3FocusGained
        // TODO add your handling code here:
        quitarCero(T3);
    }//GEN-LAST:event_T3FocusGained

    private void T3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_T3FocusLost
        // TODO add your handling code here:
        ponerCero(T3);
        suma(20);
        rendimiento();
    }//GEN-LAST:event_T3FocusLost

    private void T4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_T4FocusGained
        // TODO add your handling code here:
        quitarCero(T4);
    }//GEN-LAST:event_T4FocusGained

    private void T4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_T4FocusLost
        // TODO add your handling code here:
        ponerCero(T4);
        suma(20);
        rendimiento();
    }//GEN-LAST:event_T4FocusLost

    private void T5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_T5FocusGained
        // TODO add your handling code here:
        ponerCero(T5);
        suma(20);
        rendimiento();
    }//GEN-LAST:event_T5FocusGained

    private void T5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_T5FocusLost
        // TODO add your handling code here:
        ponerCero(T5);
        suma(20);
        rendimiento();
    }//GEN-LAST:event_T5FocusLost

    private void T6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_T6FocusGained
        // TODO add your handling code here:
        quitarCero(T6);
    }//GEN-LAST:event_T6FocusGained

    private void T6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_T6FocusLost
        // TODO add your handling code here:
        ponerCero(T6);
        suma(20);
        rendimiento();
    }//GEN-LAST:event_T6FocusLost

    private void U1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_U1FocusGained
        // TODO add your handling code here:
        quitarCero(U1);
    }//GEN-LAST:event_U1FocusGained

    private void U1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_U1FocusLost
        // TODO add your handling code here:
        ponerCero(U1);
        suma(21);
        rendimiento();
    }//GEN-LAST:event_U1FocusLost

    private void U2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_U2FocusGained
        // TODO add your handling code here:
        quitarCero(U2);
    }//GEN-LAST:event_U2FocusGained

    private void U2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_U2FocusLost
        // TODO add your handling code here:
        ponerCero(U2);
        suma(21);
        rendimiento();
    }//GEN-LAST:event_U2FocusLost

    private void U3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_U3FocusGained
        // TODO add your handling code here:
        quitarCero(U3);
    }//GEN-LAST:event_U3FocusGained

    private void U3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_U3FocusLost
        // TODO add your handling code here:
        ponerCero(U3);
        suma(21);
        rendimiento();
    }//GEN-LAST:event_U3FocusLost

    private void U4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_U4FocusGained
        // TODO add your handling code here:
        quitarCero(U4);
    }//GEN-LAST:event_U4FocusGained

    private void U4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_U4FocusLost
        // TODO add your handling code here:
        ponerCero(U4);
        suma(21);
        rendimiento();
    }//GEN-LAST:event_U4FocusLost

    private void U5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_U5FocusGained
        // TODO add your handling code here:
        quitarCero(U5);
    }//GEN-LAST:event_U5FocusGained

    private void U5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_U5FocusLost
        // TODO add your handling code here:
        ponerCero(U5);
        suma(21);
        rendimiento();
    }//GEN-LAST:event_U5FocusLost

    private void U6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_U6FocusGained
        // TODO add your handling code here:
        quitarCero(U6);
    }//GEN-LAST:event_U6FocusGained

    private void U6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_U6FocusLost
        // TODO add your handling code here:
        ponerCero(U6);
        suma(21);
        rendimiento();
    }//GEN-LAST:event_U6FocusLost

    private void V1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_V1FocusGained
        // TODO add your handling code here:
        quitarCero(V1);
    }//GEN-LAST:event_V1FocusGained

    private void V1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_V1FocusLost
        // TODO add your handling code here:
        ponerCero(V1);
        suma(22);
        rendimiento();
    }//GEN-LAST:event_V1FocusLost

    private void V2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_V2FocusGained
        // TODO add your handling code here:
        quitarCero(V2);
    }//GEN-LAST:event_V2FocusGained

    private void V2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_V2FocusLost
        // TODO add your handling code here:
        ponerCero(V2);
        suma(22);
        rendimiento();
    }//GEN-LAST:event_V2FocusLost

    private void V3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_V3FocusGained
        // TODO add your handling code here:
        quitarCero(V3);
    }//GEN-LAST:event_V3FocusGained

    private void V3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_V3FocusLost
        // TODO add your handling code here:
        ponerCero(V3);
        suma(22);
        rendimiento();
    }//GEN-LAST:event_V3FocusLost

    private void V4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_V4FocusGained
        // TODO add your handling code here:
        quitarCero(V4);
    }//GEN-LAST:event_V4FocusGained

    private void V4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_V4FocusLost
        // TODO add your handling code here:
        ponerCero(V4);
        suma(22);
        rendimiento();
    }//GEN-LAST:event_V4FocusLost

    private void V5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_V5FocusGained
        // TODO add your handling code here:
        quitarCero(V5);
    }//GEN-LAST:event_V5FocusGained

    private void V5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_V5FocusLost
        // TODO add your handling code here:
        ponerCero(V5);
        suma(22);
        rendimiento();
    }//GEN-LAST:event_V5FocusLost

    private void V6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_V6FocusGained
        // TODO add your handling code here:
        quitarCero(V6);
    }//GEN-LAST:event_V6FocusGained

    private void V6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_V6FocusLost
        // TODO add your handling code here:
        ponerCero(V6);
        suma(22);
        rendimiento();
    }//GEN-LAST:event_V6FocusLost

    private void W1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_W1FocusGained
        // TODO add your handling code here:
        quitarCero(W1);
    }//GEN-LAST:event_W1FocusGained

    private void W1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_W1FocusLost
        // TODO add your handling code here:
        ponerCero(W1);
        suma(23);
        rendimiento();
    }//GEN-LAST:event_W1FocusLost

    private void W2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_W2FocusGained
        // TODO add your handling code here:
        quitarCero(W2);
    }//GEN-LAST:event_W2FocusGained

    private void W2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_W2FocusLost
        // TODO add your handling code here:
        ponerCero(W2);
        suma(23);
        rendimiento();
    }//GEN-LAST:event_W2FocusLost

    private void W3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_W3FocusGained
        // TODO add your handling code here:
        quitarCero(W3);
    }//GEN-LAST:event_W3FocusGained

    private void W3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_W3FocusLost
        // TODO add your handling code here:
        ponerCero(W3);
        suma(23);
        rendimiento();
    }//GEN-LAST:event_W3FocusLost

    private void W4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_W4FocusGained
        // TODO add your handling code here:
        quitarCero(W4);
    }//GEN-LAST:event_W4FocusGained

    private void W4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_W4FocusLost
        // TODO add your handling code here:
        ponerCero(W4);
        suma(23);
        rendimiento();
    }//GEN-LAST:event_W4FocusLost

    private void W5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_W5FocusGained
        // TODO add your handling code here:
        quitarCero(W5);
    }//GEN-LAST:event_W5FocusGained

    private void W5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_W5FocusLost
        // TODO add your handling code here:
        ponerCero(W5);
        suma(23);
        rendimiento();
    }//GEN-LAST:event_W5FocusLost

    private void W6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_W6FocusGained
        // TODO add your handling code here:
        quitarCero(W6);
    }//GEN-LAST:event_W6FocusGained

    private void W6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_W6FocusLost
        // TODO add your handling code here:
        ponerCero(W6);
        suma(23);
        rendimiento();
    }//GEN-LAST:event_W6FocusLost

    private void X1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_X1FocusGained
        // TODO add your handling code here:
        quitarCero(X1);
    }//GEN-LAST:event_X1FocusGained

    private void X1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_X1FocusLost
        // TODO add your handling code here:
        ponerCero(X1);
        suma(24);
        rendimiento();
    }//GEN-LAST:event_X1FocusLost

    private void X2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_X2FocusGained
        // TODO add your handling code here:
        quitarCero(X2);
    }//GEN-LAST:event_X2FocusGained

    private void X2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_X2FocusLost
        // TODO add your handling code here:
        ponerCero(X2);
        suma(24);
        rendimiento();
    }//GEN-LAST:event_X2FocusLost

    private void X3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_X3FocusGained
        // TODO add your handling code here:
        quitarCero(X3);
    }//GEN-LAST:event_X3FocusGained

    private void X3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_X3FocusLost
        // TODO add your handling code here:
        ponerCero(X3);
        suma(24);
        rendimiento();
    }//GEN-LAST:event_X3FocusLost

    private void X4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_X4FocusGained
        // TODO add your handling code here:
        quitarCero(X4);
    }//GEN-LAST:event_X4FocusGained

    private void X4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_X4FocusLost
        // TODO add your handling code here:
        ponerCero(X4);
        suma(24);
        rendimiento();
    }//GEN-LAST:event_X4FocusLost

    private void X5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_X5FocusGained
        // TODO add your handling code here:
        quitarCero(X5);
    }//GEN-LAST:event_X5FocusGained

    private void X5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_X5FocusLost
        // TODO add your handling code here:
        ponerCero(X5);
        suma(24);
        rendimiento();
    }//GEN-LAST:event_X5FocusLost

    private void X6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_X6FocusGained
        // TODO add your handling code here:
        quitarCero(X6);
    }//GEN-LAST:event_X6FocusGained

    private void X6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_X6FocusLost
        // TODO add your handling code here:
        ponerCero(X6);
        suma(24);
        rendimiento();
    }//GEN-LAST:event_X6FocusLost

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
 /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jdEvaluacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdEvaluacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdEvaluacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdEvaluacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form */
 /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jdEvaluacion().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField A1;
    public javax.swing.JTextField A2;
    public javax.swing.JTextField A3;
    public javax.swing.JTextField A4;
    public javax.swing.JTextField A5;
    public javax.swing.JTextField A6;
    public javax.swing.JTextField AT;
    public javax.swing.JTextField B1;
    public javax.swing.JTextField B2;
    public javax.swing.JTextField B3;
    public javax.swing.JTextField B4;
    public javax.swing.JTextField B5;
    public javax.swing.JTextField B6;
    public javax.swing.JTextField BT;
    public javax.swing.JTextField BT1;
    public javax.swing.JTextField BT2;
    public javax.swing.JTextField C1;
    public javax.swing.JTextField C2;
    public javax.swing.JTextField C3;
    public javax.swing.JTextField C4;
    public javax.swing.JTextField C5;
    public javax.swing.JTextField C6;
    public javax.swing.JTextField CT;
    public javax.swing.JTextField CT1;
    public javax.swing.JTextField CT2;
    public javax.swing.JTextField D1;
    public javax.swing.JTextField D2;
    public javax.swing.JTextField D3;
    public javax.swing.JTextField D4;
    public javax.swing.JTextField D5;
    public javax.swing.JTextField D6;
    public javax.swing.JTextField DT;
    public javax.swing.JTextField DT1;
    public javax.swing.JTextField DT2;
    public javax.swing.JTextField E1;
    public javax.swing.JTextField E2;
    public javax.swing.JTextField E3;
    public javax.swing.JTextField E4;
    public javax.swing.JTextField E5;
    public javax.swing.JTextField E6;
    public javax.swing.JTextField ET;
    public javax.swing.JTextField ET1;
    public javax.swing.JTextField ET2;
    public javax.swing.JTextField F1;
    public javax.swing.JTextField F2;
    public javax.swing.JTextField F3;
    public javax.swing.JTextField F4;
    public javax.swing.JTextField F5;
    public javax.swing.JTextField F6;
    public javax.swing.JTextField FT;
    public javax.swing.JTextField FT1;
    public javax.swing.JTextField FT2;
    public javax.swing.JTextField G1;
    public javax.swing.JTextField G2;
    public javax.swing.JTextField G3;
    public javax.swing.JTextField G4;
    public javax.swing.JTextField G5;
    public javax.swing.JTextField G6;
    public javax.swing.JTextField GT;
    public javax.swing.JTextField GT1;
    public javax.swing.JTextField GT2;
    public javax.swing.JTextField H1;
    public javax.swing.JTextField H2;
    public javax.swing.JTextField H3;
    public javax.swing.JTextField H4;
    public javax.swing.JTextField H5;
    public javax.swing.JTextField H6;
    public javax.swing.JTextField HT;
    public javax.swing.JTextField HT1;
    public javax.swing.JTextField HT2;
    public javax.swing.JTextField I1;
    public javax.swing.JTextField I2;
    public javax.swing.JTextField I3;
    public javax.swing.JTextField I4;
    public javax.swing.JTextField I5;
    public javax.swing.JTextField I6;
    public javax.swing.JTextField IT;
    public javax.swing.JTextField IT1;
    public javax.swing.JTextField IT2;
    public javax.swing.JTextField J1;
    public javax.swing.JTextField J2;
    public javax.swing.JTextField J3;
    public javax.swing.JTextField J4;
    public javax.swing.JTextField J5;
    public javax.swing.JTextField J6;
    public javax.swing.JTextField JT;
    public javax.swing.JTextField JT1;
    public javax.swing.JTextField JT2;
    public javax.swing.JTextField K1;
    public javax.swing.JTextField K2;
    public javax.swing.JTextField K3;
    public javax.swing.JTextField K4;
    public javax.swing.JTextField K5;
    public javax.swing.JTextField K6;
    public javax.swing.JTextField KT;
    public javax.swing.JTextField KT1;
    public javax.swing.JTextField KT2;
    public javax.swing.JTextField L1;
    public javax.swing.JTextField L2;
    public javax.swing.JTextField L3;
    public javax.swing.JTextField L4;
    public javax.swing.JTextField L5;
    public javax.swing.JTextField L6;
    public javax.swing.JTextField LT;
    public javax.swing.JTextField LT1;
    public javax.swing.JTextField LT2;
    public javax.swing.JTextField M1;
    public javax.swing.JTextField M2;
    public javax.swing.JTextField M3;
    public javax.swing.JTextField M4;
    public javax.swing.JTextField M5;
    public javax.swing.JTextField M6;
    public javax.swing.JTextField MT;
    public javax.swing.JTextField MT1;
    public javax.swing.JTextField MT2;
    public javax.swing.JTextField N1;
    public javax.swing.JTextField N2;
    public javax.swing.JTextField N3;
    public javax.swing.JTextField N4;
    public javax.swing.JTextField N5;
    public javax.swing.JTextField N6;
    public javax.swing.JTextField NT;
    public javax.swing.JTextField NT1;
    public javax.swing.JTextField NT2;
    public javax.swing.JTextField O1;
    public javax.swing.JTextField O2;
    public javax.swing.JTextField O3;
    public javax.swing.JTextField O4;
    public javax.swing.JTextField O5;
    public javax.swing.JTextField O6;
    public javax.swing.JTextField OT;
    public javax.swing.JTextField OT1;
    public javax.swing.JTextField OT2;
    public javax.swing.JTextField P1;
    public javax.swing.JTextField P2;
    public javax.swing.JTextField P3;
    public javax.swing.JTextField P4;
    public javax.swing.JTextField P5;
    public javax.swing.JTextField P6;
    public javax.swing.JTextField PT;
    public javax.swing.JTextField PT1;
    public javax.swing.JTextField PT2;
    public javax.swing.JTextField Q1;
    public javax.swing.JTextField Q2;
    public javax.swing.JTextField Q3;
    public javax.swing.JTextField Q4;
    public javax.swing.JTextField Q5;
    public javax.swing.JTextField Q6;
    public javax.swing.JTextField QT;
    public javax.swing.JTextField QT1;
    public javax.swing.JTextField QT2;
    public javax.swing.JTextField R1;
    public javax.swing.JTextField R2;
    public javax.swing.JTextField R3;
    public javax.swing.JTextField R4;
    public javax.swing.JTextField R5;
    public javax.swing.JTextField R6;
    public javax.swing.JTextField RT;
    public javax.swing.JTextField RT1;
    public javax.swing.JTextField RT2;
    public javax.swing.JTextField S1;
    public javax.swing.JTextField S2;
    public javax.swing.JTextField S3;
    public javax.swing.JTextField S4;
    public javax.swing.JTextField S5;
    public javax.swing.JTextField S6;
    public javax.swing.JTextField ST;
    public javax.swing.JTextField ST1;
    public javax.swing.JTextField ST2;
    public javax.swing.JTextField T1;
    public javax.swing.JTextField T2;
    public javax.swing.JTextField T3;
    public javax.swing.JTextField T4;
    public javax.swing.JTextField T5;
    public javax.swing.JTextField T6;
    public javax.swing.JTextField TT;
    public javax.swing.JTextField TT1;
    public javax.swing.JTextField TT2;
    public javax.swing.JTextField U1;
    public javax.swing.JTextField U2;
    public javax.swing.JTextField U3;
    public javax.swing.JTextField U4;
    public javax.swing.JTextField U5;
    public javax.swing.JTextField U6;
    public javax.swing.JTextField UT;
    public javax.swing.JTextField UT1;
    public javax.swing.JTextField UT2;
    public javax.swing.JTextField V1;
    public javax.swing.JTextField V2;
    public javax.swing.JTextField V3;
    public javax.swing.JTextField V4;
    public javax.swing.JTextField V5;
    public javax.swing.JTextField V6;
    public javax.swing.JTextField VT;
    public javax.swing.JTextField VT1;
    public javax.swing.JTextField VT2;
    public javax.swing.JTextField W1;
    public javax.swing.JTextField W2;
    public javax.swing.JTextField W3;
    public javax.swing.JTextField W4;
    public javax.swing.JTextField W5;
    public javax.swing.JTextField W6;
    public javax.swing.JTextField WT;
    public javax.swing.JTextField WT1;
    public javax.swing.JTextField WT2;
    public javax.swing.JTextField X1;
    public javax.swing.JTextField X2;
    public javax.swing.JTextField X3;
    public javax.swing.JTextField X4;
    public javax.swing.JTextField X5;
    public javax.swing.JTextField X6;
    public javax.swing.JTextField XT;
    public javax.swing.JTextField XT1;
    public javax.swing.JTextField XT2;
    public javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JComboBox cbEvaluador;
    public com.toedter.calendar.JDateChooser dcFechaE;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel16;
    public javax.swing.JLabel jLabel17;
    public javax.swing.JLabel jLabel18;
    public javax.swing.JLabel jLabel19;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel20;
    public javax.swing.JLabel jLabel21;
    public javax.swing.JLabel jLabel22;
    public javax.swing.JLabel jLabel23;
    public javax.swing.JLabel jLabel24;
    public javax.swing.JLabel jLabel25;
    public javax.swing.JLabel jLabel26;
    public javax.swing.JLabel jLabel27;
    public javax.swing.JLabel jLabel28;
    public javax.swing.JLabel jLabel29;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel30;
    public javax.swing.JLabel jLabel31;
    public javax.swing.JLabel jLabel32;
    public javax.swing.JLabel jLabel33;
    public javax.swing.JLabel jLabel34;
    public javax.swing.JLabel jLabel35;
    public javax.swing.JLabel jLabel36;
    public javax.swing.JLabel jLabel37;
    public javax.swing.JLabel jLabel38;
    public javax.swing.JLabel jLabel39;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel40;
    public javax.swing.JLabel jLabel41;
    public javax.swing.JLabel jLabel42;
    public javax.swing.JLabel jLabel43;
    public javax.swing.JLabel jLabel44;
    public javax.swing.JLabel jLabel45;
    public javax.swing.JLabel jLabel46;
    public javax.swing.JLabel jLabel47;
    public javax.swing.JLabel jLabel48;
    public javax.swing.JLabel jLabel49;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel50;
    public javax.swing.JLabel jLabel51;
    public javax.swing.JLabel jLabel52;
    public javax.swing.JLabel jLabel53;
    public javax.swing.JLabel jLabel54;
    public javax.swing.JLabel jLabel55;
    public javax.swing.JLabel jLabel56;
    public javax.swing.JLabel jLabel57;
    public javax.swing.JLabel jLabel58;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanel5;
    public javax.swing.JPanel jPanel6;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JSeparator jSeparator1;
    public javax.swing.JSeparator jSeparator2;
    public javax.swing.JSeparator jSeparator4;
    public javax.swing.JTextField jTextField29;
    public javax.swing.JTextField jTextField30;
    public javax.swing.JTextField jTextField31;
    public javax.swing.JTextField jTextField32;
    public javax.swing.JTextField jTextField33;
    public javax.swing.JTextField jTextField34;
    public javax.swing.JTextField jTextField35;
    public javax.swing.JLabel lblCSM;
    public javax.swing.JLabel lblCalC;
    public javax.swing.JLabel lblComunidad;
    public javax.swing.JLabel lblForma;
    public javax.swing.JLabel lblPuntuacion;
    public javax.swing.JLabel lblTipo;
    public javax.swing.JSpinner spColorOro;
    public javax.swing.JSpinner spUniOro;
    public javax.swing.JTextField txtDenOro;
    public javax.swing.JTextField txtHumedadCas;
    public javax.swing.JTextField txtHumedadOro;
    public javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables
}
