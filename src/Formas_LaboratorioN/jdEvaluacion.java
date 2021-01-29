/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_LaboratorioN;

import Formas_laboratorio.jpBitacora;
import Idioma.Propiedades;
import Metodos_Configuraciones.metodosLaboratorio;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import static java.lang.Integer.parseInt;
import javax.swing.JFrame;

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

    public jdEvaluacion(Connection cn, String id, String csm, String comunindad, String tipoc, String forma,String calcer, String idioma) {
        initComponents();
        
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
    }

    //Metodo para guardar la evaluación
    public void guardar() {
        String fecha = "";
        if (dcFechaE.getDate() != null) {
            fecha = new SimpleDateFormat("dd-MMM-yyyy").format(dcFechaE.getDate());
        } //se extrae la fecha del calendario y se guarda en una variable 
        String g[] = new String[3];
        String estatus = "A";
        g[0] = "insert into cribas values (null," + id + ",'19','" + A1.getText() + "," + B1.getText() + "," + C1.getText() + "," + D1.getText() + "," + E1.getText() + "," + F1.getText() + "," + G1.getText() + "," + H1.getText() + "," + I1.getText() + "," + J1.getText() + "," + K1.getText() + "," + L1.getText() + "," + M1.getText() + "," + N1.getText() + "," + O1.getText() + ","
                + "" + P1.getText() + "," + Q1.getText() + "," + R1.getText() + "," + S1.getText() + "," + T1.getText() + "," + U1.getText() + "," + V1.getText() + "," + W1.getText() + "," + X1.getText() + "'),(null," + id + ",'18','" + A2.getText() + "," + B2.getText() + "," + C2.getText() + "," + D2.getText() + "," + E2.getText() + "," + F2.getText() + "," + G2.getText() + "," + H2.getText() + "," + I2.getText() + "," + J2.getText() + "," + K2.getText() + "," + L2.getText() + "," + M2.getText() + "," + N2.getText() + "," + O2.getText() + ","
                + "" + P2.getText() + "," + Q2.getText() + "," + R2.getText() + "," + S2.getText() + "," + T2.getText() + "," + U2.getText() + "," + V2.getText() + "," + W2.getText() + "," + X2.getText() + "'),(null," + id + ",'17','" + A3.getText() + "," + B3.getText() + "," + C3.getText() + "," + D3.getText() + "," + E3.getText() + "," + F3.getText() + "," + G3.getText() + "," + H3.getText() + "," + I3.getText() + "," + J3.getText() + "," + K3.getText() + "," + L3.getText() + "," + M3.getText() + "," + N3.getText() + "," + O3.getText() + ","
                + "" + P3.getText() + "," + Q3.getText() + "," + R3.getText() + "," + S3.getText() + "," + T3.getText() + "," + U3.getText() + "," + V3.getText() + "," + W3.getText() + "," + X3.getText() + "'),(null," + id + ",'16','" + A4.getText() + "," + B4.getText() + "," + C4.getText() + "," + D4.getText() + "," + E4.getText() + "," + F4.getText() + "," + G4.getText() + "," + H4.getText() + "," + I4.getText() + "," + J4.getText() + "," + K4.getText() + "," + L4.getText() + "," + M4.getText() + "," + N4.getText() + "," + O4.getText() + ","
                + "" + P4.getText() + "," + Q4.getText() + "," + R4.getText() + "," + S4.getText() + "," + T4.getText() + "," + U4.getText() + "," + V4.getText() + "," + W4.getText() + "," + X4.getText() + "'),(null," + id + ",'15','" + A5.getText() + "," + B5.getText() + "," + C5.getText() + "," + D5.getText() + "," + E5.getText() + "," + F5.getText() + "," + G5.getText() + "," + H5.getText() + "," + I5.getText() + "," + J5.getText() + "," + K5.getText() + "," + L5.getText() + "," + M5.getText() + "," + N5.getText() + "," + O5.getText() + ","
                + "" + P5.getText() + "," + Q5.getText() + "," + R5.getText() + "," + S5.getText() + "," + T5.getText() + "," + U5.getText() + "," + V5.getText() + "," + W5.getText() + "," + X5.getText() + "'),(null," + id + ",'F','" + A6.getText() + "," + B6.getText() + "," + C6.getText() + "," + D6.getText() + "," + E6.getText() + "," + F6.getText() + "," + G6.getText() + "," + H6.getText() + "," + I6.getText() + "," + J6.getText() + "," + K6.getText() + "," + L6.getText() + "," + M6.getText() + "," + N6.getText() + "," + O6.getText() + ","
                + "" + P6.getText() + "," + Q6.getText() + "," + R6.getText() + "," + S6.getText() + "," + T6.getText() + "," + U6.getText() + "," + V6.getText() + "," + W6.getText() + "," + X6.getText() + "'),(null," + id + ",'TOTAL','" + AT.getText() + "," + BT.getText() + "," + CT.getText() + "," + DT.getText() + "," + ET.getText() + "," + FT.getText() + "," + GT.getText() + "," + HT.getText() + "," + IT.getText() + "," + JT.getText() + "," + KT.getText() + "," + LT.getText() + "," + MT.getText() + "," + NT.getText() + "," + OT.getText() + ","
                + "" + PT.getText() + "," + QT.getText() + "," + RT.getText() + "," + ST.getText() + "," + TT.getText() + "," + UT.getText() + "," + VT.getText() + "," + WT.getText() + "," + XT.getText() + "')";
        g[1] = "insert into datosev values (null," + id + ",'" + fecha + "'," + spUniOro.getValue() + ",'" + txtHumedadOro.getText() + "','" + txtHumedadCas.getText() + "'," + spColorOro.getValue() + ",'" + cbEvaluador.getSelectedItem() + "','" + lblPuntuacion.getText() + "'," + id + ",'" + txtPeso.getText() + "','" + txtDenOro.getText() + "')";
        /*System.out.println(csm + " " + comunindad);
        String taza = mdb.devuelveUnDato("select taza from bitacoralab "
                + "where (id_muestra='" + csm + "' and comunidad='" + comunindad + "')");
        if (taza.equals("1")) {
            estatus = "Disp";
        }
        g[2] = "update bitacoralab set aspecto='1'  where id_bitacora=" + id + "";*/

        if (!txtPeso.equals("0")) {
            if (!txtHumedadOro.equals("")) {
                if (!AT.equals("0")) {

                    try {

                        mdb.insertarBasicos(g[0]);
                        mdb.insertarBasicos(g[1]);
                        //mdb.insertarBasicos(g[2]);
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
        v[3] = Integer.parseInt(FT.getText());
        v[4] = Integer.parseInt(GT.getText());
        v[5] = Integer.parseInt(HT.getText());
        v[6] = Integer.parseInt(IT.getText());
        v[7] = Integer.parseInt(JT.getText());
        v[8] = Integer.parseInt(KT.getText());
        v[9] = Integer.parseInt(LT.getText());
        v[10] = Integer.parseInt(MT.getText());
        v[12] = Integer.parseInt(NT.getText());
        v[13] = Integer.parseInt(OT.getText());
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
        String strnum = num + "";
        int indice = strnum.indexOf(".");
        return Integer.parseInt(strnum.substring(0, indice));
    }

    //Operacion con las cribas
    public void suma(int num) {
        try{

        double formula, Pe, ad;
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
                av = vt / 5;
                ad = 350 / Pe;
                System.out.println("av=" + av + "ad=" + ad);
                formula = (350 / Pe) * (vt / 5);
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

                formula = (350 / Pe) * (vt / 10);
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

                formula = (350 / Pe) * (vt / 1);
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

                formula = (350 / Pe) * (vt / 3);
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

                formula = (350 / Pe) * (vt / 1);
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

                formula = (350 / Pe) * (vt / 3);
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

                formula = (350 / Pe) * (vt / 5);
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

                formula = (350 / Pe) * (vt / 5);
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
                formula = (350 / Pe) * (vt / 3);
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

                formula = (350 / Pe) * (vt / 5);
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

                formula = (350 / Pe) * (vt / 5);
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

                formula = (350 / Pe) * (vt / 5);
                res = trunc(formula);
                if (res == 0) {
                    MT.setText("0");
                } else {
                    MT.setText(res + "");
                    puntuacion();
                }
                break;
            case 14:
                v[0] = Integer.parseInt(N1.getText());
                v[1] = Integer.parseInt(N2.getText());
                v[2] = Integer.parseInt(N3.getText());
                v[3] = Integer.parseInt(N4.getText());
                v[4] = Integer.parseInt(N5.getText());
                v[5] = Integer.parseInt(N6.getText());

                vt = v[0] + v[1] + v[2] + v[3] + v[4] + v[5];

                formula = (350 / Pe) * (vt / 5);
                res = trunc(formula);
                if (res == 0) {
                    NT.setText("0");
                } else {
                    NT.setText("0");
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
                formula = (350 / Pe) * (vt / 1);
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
                formula = (350 / Pe) * (vt / 5);
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
                formula = (350 / Pe) * (vt / 5);
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
                formula = (350 / Pe) * (vt / 5);
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
                formula = (350 / Pe) * (vt / 5);
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

                formula = (350 / Pe) * (vt / 5);
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

                formula = (350 / Pe) * (vt / 5);
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

                formula = (350 / Pe) * (vt / 5);
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

                formula = (350 / Pe) * (vt / 5);
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

                formula = (350 / Pe) * (vt / 1);
                res = trunc(formula);
                if (res == 0) {
                    XT.setText("0");
                } else {
                    XT.setText(res + "");
                    puntuacion();
                }
                break;
        }
        }catch(Exception e){
            
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

        jSeparator4 = new javax.swing.JSeparator();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblCSM = new javax.swing.JLabel();
        lblComunidad = new javax.swing.JLabel();
        lblCalC = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblForma = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        dcFechaE = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtHumedadOro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtHumedadCas = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cbEvaluador = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        txtDenOro = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        lblPuntuacion = new javax.swing.JLabel();
        spUniOro = new javax.swing.JSpinner();
        spColorOro = new javax.swing.JSpinner();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
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
        jSeparator10 = new javax.swing.JSeparator();
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
        O1 = new javax.swing.JTextField();
        O2 = new javax.swing.JTextField();
        O3 = new javax.swing.JTextField();
        O4 = new javax.swing.JTextField();
        O5 = new javax.swing.JTextField();
        O6 = new javax.swing.JTextField();
        OT = new javax.swing.JTextField();
        I1 = new javax.swing.JTextField();
        I2 = new javax.swing.JTextField();
        I3 = new javax.swing.JTextField();
        I4 = new javax.swing.JTextField();
        I5 = new javax.swing.JTextField();
        I6 = new javax.swing.JTextField();
        IT = new javax.swing.JTextField();
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

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel1.setText("No. CSM:");

        jLabel2.setText("Comunidad:");

        jLabel3.setText("Calificación cereza:");

        jLabel4.setText("Tipo:");

        jLabel5.setText("Forma:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblForma, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCSM, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblComunidad, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCalC, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCSM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblComunidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblCalC, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblForma, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de evaluación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel6.setText("Fecha:");

        jLabel7.setText("Peso evaluado:");

        txtPeso.setText("0");

        jLabel8.setText("Uniformidad de café en oro:");

        jLabel9.setText("Humedad de café en oro:");

        txtHumedadOro.setText("0");

        jLabel10.setText("Humedad de cáscara:");

        jLabel11.setText("Color en oro:");

        txtHumedadCas.setText("0");

        jLabel12.setText("Evaluador:");

        cbEvaluador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "James Kosalos", "Jacob Frankel", "Carlos bustamante", "Gigi Mengistu", "Tom Bennett" }));

        jLabel13.setText("Densidad en oro:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Puntuación:");

        lblPuntuacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPuntuacion.setText("6");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel47.setText("g");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel48.setText("%");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel49.setText("%");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(spUniOro, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel6))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(65, 65, 65)
                                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel47))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(46, 46, 46)
                                            .addComponent(dcFechaE, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(21, 21, 21)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel9)
                                                    .addComponent(jLabel10))
                                                .addGap(18, 18, 18))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(77, 77, 77)))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(spColorOro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtHumedadOro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtHumedadCas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel49)
                                            .addComponent(jLabel48)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel13))
                                        .addGap(58, 58, 58)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDenOro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbEvaluador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dcFechaE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(spUniOro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtHumedadOro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48))))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtHumedadCas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel49)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel11))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spColorOro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(cbEvaluador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(txtDenOro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPuntuacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jButton1.setText("Guardar evaluación");
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
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Evaluación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel4.setAutoscrolls(true);

        jLabel15.setText("Criba");

        jLabel16.setText("19");

        jLabel17.setText("18");

        jLabel18.setText("17");

        jLabel19.setText("16");

        jLabel20.setText("15");

        jLabel21.setText("F");

        jLabel22.setText("Total");

        A2.setText("0");
        A2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                A2KeyReleased(evt);
            }
        });

        jLabel23.setText("Peso:");

        A1.setText("0");
        A1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                A1KeyReleased(evt);
            }
        });

        A3.setText("0");
        A3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                A3KeyReleased(evt);
            }
        });

        A5.setText("0");
        A5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                A5KeyReleased(evt);
            }
        });

        A6.setText("0");
        A6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                A6KeyReleased(evt);
            }
        });

        AT.setText("0");
        AT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ATKeyReleased(evt);
            }
        });

        A4.setText("0");
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

        jLabel46.setText("Material extra:");

        B1.setText("0");
        B1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B1KeyReleased(evt);
            }
        });

        B2.setText("0");
        B2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B2KeyReleased(evt);
            }
        });

        B3.setText("0");
        B3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B3KeyReleased(evt);
            }
        });

        B4.setText("0");
        B4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B4KeyReleased(evt);
            }
        });

        B5.setText("0");
        B5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B5KeyReleased(evt);
            }
        });

        B6.setText("0");
        B6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B6KeyReleased(evt);
            }
        });

        BT.setText("0");

        C1.setText("0");
        C1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                C1KeyReleased(evt);
            }
        });

        C2.setText("0");
        C2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                C2KeyReleased(evt);
            }
        });

        C3.setText("0");
        C3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                C3KeyReleased(evt);
            }
        });

        C4.setText("0");
        C4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                C4KeyReleased(evt);
            }
        });

        C5.setText("0");
        C5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                C5KeyReleased(evt);
            }
        });

        C6.setText("0");
        C6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                C6KeyReleased(evt);
            }
        });

        CT.setText("0");

        D1.setText("0");
        D1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                D1KeyReleased(evt);
            }
        });

        D2.setText("0");
        D2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                D2KeyReleased(evt);
            }
        });

        D3.setText("0");
        D3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                D3KeyReleased(evt);
            }
        });

        D4.setText("0");
        D4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                D4KeyReleased(evt);
            }
        });

        D5.setText("0");
        D5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                D5KeyReleased(evt);
            }
        });

        D6.setText("0");
        D6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                D6KeyReleased(evt);
            }
        });

        DT.setText("0");

        E1.setText("0");
        E1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                E1KeyReleased(evt);
            }
        });

        E2.setText("0");
        E2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                E2KeyReleased(evt);
            }
        });

        E3.setText("0");
        E3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                E3KeyReleased(evt);
            }
        });

        E4.setText("0");
        E4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                E4KeyReleased(evt);
            }
        });

        E5.setText("0");
        E5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                E5KeyReleased(evt);
            }
        });

        E6.setText("0");
        E6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                E6KeyReleased(evt);
            }
        });

        ET.setText("0");

        F1.setText("0");
        F1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                F1KeyReleased(evt);
            }
        });

        F2.setText("0");
        F2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                F2KeyReleased(evt);
            }
        });

        F3.setText("0");
        F3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                F3KeyReleased(evt);
            }
        });

        F4.setText("0");
        F4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                F4KeyReleased(evt);
            }
        });

        F5.setText("0");
        F5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                F5KeyReleased(evt);
            }
        });

        F6.setText("0");
        F6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                F6KeyReleased(evt);
            }
        });

        FT.setText("0");

        G1.setText("0");
        G1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                G1KeyReleased(evt);
            }
        });

        G2.setText("0");
        G2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                G2KeyReleased(evt);
            }
        });

        G3.setText("0");
        G3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                G3KeyReleased(evt);
            }
        });

        G4.setText("0");
        G4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                G4KeyReleased(evt);
            }
        });

        G5.setText("0");
        G5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                G5KeyReleased(evt);
            }
        });

        G6.setText("0");
        G6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                G6KeyReleased(evt);
            }
        });

        GT.setText("0");

        H1.setText("0");
        H1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                H1KeyReleased(evt);
            }
        });

        H2.setText("0");
        H2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                H2KeyReleased(evt);
            }
        });

        H3.setText("0");
        H3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                H3KeyReleased(evt);
            }
        });

        H4.setText("0");
        H4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                H4KeyReleased(evt);
            }
        });

        H5.setText("0");
        H5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                H5KeyReleased(evt);
            }
        });

        H6.setText("0");
        H6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                H6KeyReleased(evt);
            }
        });

        HT.setText("0");

        O1.setText("0");
        O1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                O1KeyReleased(evt);
            }
        });

        O2.setText("0");
        O2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                O2KeyReleased(evt);
            }
        });

        O3.setText("0");
        O3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                O3KeyReleased(evt);
            }
        });

        O4.setText("0");
        O4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                O4KeyReleased(evt);
            }
        });

        O5.setText("0");
        O5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                O5KeyReleased(evt);
            }
        });

        O6.setText("0");
        O6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                O6KeyReleased(evt);
            }
        });

        OT.setText("0");

        I1.setText("0");
        I1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                I1KeyReleased(evt);
            }
        });

        I2.setText("0");
        I2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                I2KeyReleased(evt);
            }
        });

        I3.setText("0");
        I3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                I3KeyReleased(evt);
            }
        });

        I4.setText("0");
        I4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                I4KeyReleased(evt);
            }
        });

        I5.setText("0");
        I5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                I5KeyReleased(evt);
            }
        });

        I6.setText("0");
        I6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                I6KeyReleased(evt);
            }
        });

        IT.setText("0");

        J1.setText("0");
        J1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                J1KeyReleased(evt);
            }
        });

        J2.setText("0");
        J2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                J2KeyReleased(evt);
            }
        });

        J3.setText("0");
        J3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                J3KeyReleased(evt);
            }
        });

        J4.setText("0");
        J4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                J4KeyReleased(evt);
            }
        });

        J5.setText("0");
        J5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                J5KeyReleased(evt);
            }
        });

        J6.setText("0");
        J6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                J6KeyReleased(evt);
            }
        });

        JT.setText("0");

        K1.setText("0");
        K1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                K1KeyReleased(evt);
            }
        });

        K2.setText("0");
        K2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                K2KeyReleased(evt);
            }
        });

        K3.setText("0");
        K3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                K3KeyReleased(evt);
            }
        });

        K4.setText("0");
        K4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                K4KeyReleased(evt);
            }
        });

        K5.setText("0");
        K5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                K5KeyReleased(evt);
            }
        });

        K6.setText("0");
        K6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                K6KeyReleased(evt);
            }
        });

        KT.setText("0");

        L1.setText("0");
        L1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                L1KeyReleased(evt);
            }
        });

        L2.setText("0");

        L3.setText("0");

        L4.setText("0");

        L5.setText("0");

        L6.setText("0");

        LT.setText("0");

        M1.setText("0");

        M2.setText("0");

        M3.setText("0");

        M4.setText("0");

        M5.setText("0");

        M6.setText("0");

        MT.setText("0");

        N1.setText("0");

        N2.setText("0");

        N3.setText("0");

        N4.setText("0");

        N5.setText("0");

        N6.setText("0");

        NT.setText("0");

        P1.setText("0");

        P2.setText("0");

        P3.setText("0");

        P4.setText("0");

        P5.setText("0");

        P6.setText("0");

        PT.setText("0");

        Q1.setText("0");

        Q2.setText("0");

        Q3.setText("0");

        Q4.setText("0");

        Q5.setText("0");

        Q6.setText("0");

        QT.setText("0");

        R1.setText("0");

        R2.setText("0");

        R3.setText("0");

        R4.setText("0");

        R5.setText("0");

        R6.setText("0");

        RT.setText("0");

        S1.setText("0");

        S2.setText("0");

        S3.setText("0");

        S4.setText("0");

        S5.setText("0");

        S6.setText("0");

        ST.setText("0");

        T1.setText("0");

        T2.setText("0");

        T3.setText("0");

        T4.setText("0");

        T5.setText("0");

        T6.setText("0");

        TT.setText("0");

        U1.setText("0");

        U2.setText("0");

        U3.setText("0");

        U4.setText("0");

        U5.setText("0");

        U6.setText("0");

        UT.setText("0");

        V1.setText("0");

        V2.setText("0");

        V3.setText("0");

        V4.setText("0");

        V5.setText("0");

        V6.setText("0");

        VT.setText("0");

        W1.setText("0");

        W2.setText("0");

        W3.setText("0");

        W4.setText("0");

        W5.setText("0");

        W6.setText("0");

        WT.setText("0");

        X1.setText("0");

        X2.setText("0");

        X3.setText("0");

        X4.setText("0");

        X5.setText("0");

        X6.setText("0");

        XT.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel43)
                            .addComponent(jLabel44)
                            .addComponent(jLabel46)
                            .addComponent(jLabel42)
                            .addComponent(jLabel40)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(76, 76, 76)
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
                                .addGap(18, 18, 18)
                                .addComponent(AT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel15)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel16)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel17)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel18)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel19)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel20)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel21)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel22)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel34)
                                            .addComponent(jLabel35)
                                            .addComponent(jLabel36)
                                            .addComponent(jLabel37)
                                            .addComponent(jLabel31)
                                            .addComponent(jLabel33)
                                            .addComponent(jLabel29)
                                            .addComponent(jLabel30)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel45)
                                                .addComponent(jLabel32)))
                                        .addGap(4, 4, 4))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel38)
                                            .addComponent(jLabel39)
                                            .addComponent(jLabel25)
                                            .addComponent(jLabel26)
                                            .addComponent(jLabel27)
                                            .addComponent(jLabel28))
                                        .addGap(37, 37, 37)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
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
                                                        .addComponent(F6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ET, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(FT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(JT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(IT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(OT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(GT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(HT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(KT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
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
                                                    .addComponent(L6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(QT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(PT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(NT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(MT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(LT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
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
                                            .addGap(18, 18, 18)
                                            .addComponent(TT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
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
                                                    .addComponent(R6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(RT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                                    .addComponent(S6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(ST, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                                    .addComponent(U6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(UT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                                    .addComponent(V6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(VT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                                    .addComponent(W6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(WT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                                    .addComponent(X6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(XT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(25, 25, 25)))))
                            .addComponent(jLabel24))
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
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(A1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel25)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel26)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel33)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel34))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(C1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(C2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(C3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(C4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(C5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(C6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(D1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(D2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(D3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(D4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(D5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(D6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(E1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(E2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(E3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(E4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(E5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(E6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(F1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(F2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(F3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(F4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(F5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(F6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(G1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(G2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(G3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(G4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(G5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(G6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(H1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(H2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(H3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(H4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(H5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(H6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(O1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(O2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(O3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(O4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(O5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(O6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(I1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(I2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(I3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(I4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(I5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(I6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(J1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(K6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(BT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(DT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(OT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(IT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(KT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel39))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(L1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(M1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(M2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(M3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(M4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(M5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(M6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(N1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(N2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(N3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(N4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(N5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(N6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(P1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(P2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(P3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(P4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(P5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(P6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Q1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Q2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Q3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Q4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Q5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Q6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(LT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(QT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(R1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(S1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(S2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(S3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(S4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(S5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(S6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ST, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(T1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(U1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(U2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(U3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(U4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(U5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(U6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(V1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(V2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(V3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(V4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(V5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(V6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(W1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(W2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(W3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(W4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(W5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(W6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(WT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(X1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(XT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        //guardar();
    }//GEN-LAST:event_jButton1MouseClicked

    private void A1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_A1KeyReleased
        // TODO add your handling code here:
        suma(1);
    }//GEN-LAST:event_A1KeyReleased

    private void A2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_A2KeyReleased
        // TODO add your handling code here:
        suma(1);
    }//GEN-LAST:event_A2KeyReleased

    private void A3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_A3KeyReleased
        // TODO add your handling code here:
        suma(1);
    }//GEN-LAST:event_A3KeyReleased

    private void A4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_A4KeyReleased
        // TODO add your handling code here:
        suma(1);
    }//GEN-LAST:event_A4KeyReleased

    private void A5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_A5KeyReleased
        // TODO add your handling code here:
        suma(1);
    }//GEN-LAST:event_A5KeyReleased

    private void A6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_A6KeyReleased
        // TODO add your handling code here:
        suma(1);
    }//GEN-LAST:event_A6KeyReleased

    private void ATKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ATKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ATKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void B1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B1KeyReleased
        // TODO add your handling code here:
        suma(2);
    }//GEN-LAST:event_B1KeyReleased

    private void B2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B2KeyReleased
        // TODO add your handling code here:
        suma(2);
    }//GEN-LAST:event_B2KeyReleased

    private void B3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B3KeyReleased
        // TODO add your handling code here:
        suma(2);
    }//GEN-LAST:event_B3KeyReleased

    private void B4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B4KeyReleased
        // TODO add your handling code here:
        suma(2);
    }//GEN-LAST:event_B4KeyReleased

    private void B5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B5KeyReleased
        // TODO add your handling code here:
        suma(2);
    }//GEN-LAST:event_B5KeyReleased

    private void B6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B6KeyReleased
        // TODO add your handling code here:
        suma(2);
    }//GEN-LAST:event_B6KeyReleased

    private void C1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C1KeyReleased
        // TODO add your handling code here:
        suma(3);
    }//GEN-LAST:event_C1KeyReleased

    private void C2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C2KeyReleased
        // TODO add your handling code here:
        suma(3);
    }//GEN-LAST:event_C2KeyReleased

    private void C3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C3KeyReleased
        // TODO add your handling code here:
        suma(3);
    }//GEN-LAST:event_C3KeyReleased

    private void C4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C4KeyReleased
        // TODO add your handling code here:
        suma(3);
    }//GEN-LAST:event_C4KeyReleased

    private void C5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C5KeyReleased
        // TODO add your handling code here:
        suma(3);
    }//GEN-LAST:event_C5KeyReleased

    private void C6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C6KeyReleased
        // TODO add your handling code here:
        suma(3);
    }//GEN-LAST:event_C6KeyReleased

    private void D1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_D1KeyReleased
        // TODO add your handling code here:
        suma(4);
    }//GEN-LAST:event_D1KeyReleased

    private void D2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_D2KeyReleased
        // TODO add your handling code here:
        suma(4);
    }//GEN-LAST:event_D2KeyReleased

    private void D3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_D3KeyReleased
        // TODO add your handling code here:
        suma(4);
    }//GEN-LAST:event_D3KeyReleased

    private void D4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_D4KeyReleased
        // TODO add your handling code here:
        suma(4);
    }//GEN-LAST:event_D4KeyReleased

    private void D5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_D5KeyReleased
        // TODO add your handling code here:
        suma(4);
    }//GEN-LAST:event_D5KeyReleased

    private void D6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_D6KeyReleased
        // TODO add your handling code here:
        suma(4);
    }//GEN-LAST:event_D6KeyReleased

    private void E1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_E1KeyReleased
        // TODO add your handling code here:
        suma(5);
    }//GEN-LAST:event_E1KeyReleased

    private void E2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_E2KeyReleased
        // TODO add your handling code here:
        suma(5);
    }//GEN-LAST:event_E2KeyReleased

    private void E3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_E3KeyReleased
        // TODO add your handling code here:
        suma(5);
    }//GEN-LAST:event_E3KeyReleased

    private void E4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_E4KeyReleased
        // TODO add your handling code here:
        suma(5);
    }//GEN-LAST:event_E4KeyReleased

    private void E5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_E5KeyReleased
        // TODO add your handling code here:
        suma(5);
    }//GEN-LAST:event_E5KeyReleased

    private void E6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_E6KeyReleased
        // TODO add your handling code here:
        suma(5);
    }//GEN-LAST:event_E6KeyReleased

    private void F1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_F1KeyReleased
        // TODO add your handling code here:
        suma(6);
    }//GEN-LAST:event_F1KeyReleased

    private void F2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_F2KeyReleased
        // TODO add your handling code here:
        suma(6);
    }//GEN-LAST:event_F2KeyReleased

    private void F3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_F3KeyReleased
        // TODO add your handling code here:
        suma(6);
    }//GEN-LAST:event_F3KeyReleased

    private void F4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_F4KeyReleased
        // TODO add your handling code here:
        suma(6);
    }//GEN-LAST:event_F4KeyReleased

    private void F5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_F5KeyReleased
        // TODO add your handling code here:
        suma(6);
    }//GEN-LAST:event_F5KeyReleased

    private void F6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_F6KeyReleased
        // TODO add your handling code here:
        suma(6);
    }//GEN-LAST:event_F6KeyReleased

    private void G1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_G1KeyReleased
        // TODO add your handling code here:
        suma(7);
    }//GEN-LAST:event_G1KeyReleased

    private void G2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_G2KeyReleased
        // TODO add your handling code here:
        suma(7);
    }//GEN-LAST:event_G2KeyReleased

    private void G3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_G3KeyReleased
        // TODO add your handling code here:
        suma(7);
    }//GEN-LAST:event_G3KeyReleased

    private void G4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_G4KeyReleased
        // TODO add your handling code here:
        suma(7);
    }//GEN-LAST:event_G4KeyReleased

    private void G5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_G5KeyReleased
        // TODO add your handling code here:
        suma(7);
    }//GEN-LAST:event_G5KeyReleased

    private void G6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_G6KeyReleased
        // TODO add your handling code here:
        suma(7);
    }//GEN-LAST:event_G6KeyReleased

    private void H1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_H1KeyReleased
        // TODO add your handling code here:
        suma(8);
    }//GEN-LAST:event_H1KeyReleased

    private void H2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_H2KeyReleased
        // TODO add your handling code here:
        suma(8);
    }//GEN-LAST:event_H2KeyReleased

    private void H3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_H3KeyReleased
        // TODO add your handling code here:
        suma(8);
    }//GEN-LAST:event_H3KeyReleased

    private void H4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_H4KeyReleased
        // TODO add your handling code here:
        suma(8);
    }//GEN-LAST:event_H4KeyReleased

    private void H5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_H5KeyReleased
        // TODO add your handling code here:
        suma(8);
    }//GEN-LAST:event_H5KeyReleased

    private void H6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_H6KeyReleased
        // TODO add your handling code here:
        suma(8);
    }//GEN-LAST:event_H6KeyReleased

    private void O1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_O1KeyReleased
        // TODO add your handling code here:
        suma(9);
    }//GEN-LAST:event_O1KeyReleased

    private void O2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_O2KeyReleased
        // TODO add your handling code here:
        suma(9);
    }//GEN-LAST:event_O2KeyReleased

    private void O3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_O3KeyReleased
        // TODO add your handling code here:
        suma(9);
    }//GEN-LAST:event_O3KeyReleased

    private void O4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_O4KeyReleased
        // TODO add your handling code here:
        suma(9);
    }//GEN-LAST:event_O4KeyReleased

    private void O5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_O5KeyReleased
        // TODO add your handling code here:
        suma(9);
    }//GEN-LAST:event_O5KeyReleased

    private void O6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_O6KeyReleased
        // TODO add your handling code here:
        suma(9);
    }//GEN-LAST:event_O6KeyReleased

    private void I1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I1KeyReleased
        // TODO add your handling code here:
        suma(9);
    }//GEN-LAST:event_I1KeyReleased

    private void I2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I2KeyReleased
        // TODO add your handling code here:
        suma(9);
    }//GEN-LAST:event_I2KeyReleased

    private void I3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I3KeyReleased
        // TODO add your handling code here:
        suma(9);
    }//GEN-LAST:event_I3KeyReleased

    private void I4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I4KeyReleased
        // TODO add your handling code here:
        suma(9);
    }//GEN-LAST:event_I4KeyReleased

    private void I5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I5KeyReleased
        // TODO add your handling code here:
        suma(9);
    }//GEN-LAST:event_I5KeyReleased

    private void I6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_I6KeyReleased
        // TODO add your handling code here:
        suma(9);
    }//GEN-LAST:event_I6KeyReleased

    private void J1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_J1KeyReleased
        // TODO add your handling code here:
        suma(10);
    }//GEN-LAST:event_J1KeyReleased

    private void J2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_J2KeyReleased
        // TODO add your handling code here:
        suma(10);
    }//GEN-LAST:event_J2KeyReleased

    private void J3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_J3KeyReleased
        // TODO add your handling code here:
        suma(10);
    }//GEN-LAST:event_J3KeyReleased

    private void J4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_J4KeyReleased
        // TODO add your handling code here:
        suma(10);
    }//GEN-LAST:event_J4KeyReleased

    private void J5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_J5KeyReleased
        // TODO add your handling code here:
        suma(10);
    }//GEN-LAST:event_J5KeyReleased

    private void J6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_J6KeyReleased
        // TODO add your handling code here:
        suma(10);
    }//GEN-LAST:event_J6KeyReleased

    private void K1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_K1KeyReleased
        // TODO add your handling code here:
        suma(11);
    }//GEN-LAST:event_K1KeyReleased

    private void K2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_K2KeyReleased
        // TODO add your handling code here:
        suma(11);
    }//GEN-LAST:event_K2KeyReleased

    private void K3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_K3KeyReleased
        // TODO add your handling code here:
        suma(11);
    }//GEN-LAST:event_K3KeyReleased

    private void K4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_K4KeyReleased
        // TODO add your handling code here:
        suma(11);
    }//GEN-LAST:event_K4KeyReleased

    private void K5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_K5KeyReleased
        // TODO add your handling code here:
        suma(11);
    }//GEN-LAST:event_K5KeyReleased

    private void K6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_K6KeyReleased
        // TODO add your handling code here:
        suma(11);
    }//GEN-LAST:event_K6KeyReleased

    private void L1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_L1KeyReleased
        // TODO add your handling code here:
        suma(12);
    }//GEN-LAST:event_L1KeyReleased

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
    public javax.swing.JTextField C1;
    public javax.swing.JTextField C2;
    public javax.swing.JTextField C3;
    public javax.swing.JTextField C4;
    public javax.swing.JTextField C5;
    public javax.swing.JTextField C6;
    public javax.swing.JTextField CT;
    public javax.swing.JTextField D1;
    public javax.swing.JTextField D2;
    public javax.swing.JTextField D3;
    public javax.swing.JTextField D4;
    public javax.swing.JTextField D5;
    public javax.swing.JTextField D6;
    public javax.swing.JTextField DT;
    public javax.swing.JTextField E1;
    public javax.swing.JTextField E2;
    public javax.swing.JTextField E3;
    public javax.swing.JTextField E4;
    public javax.swing.JTextField E5;
    public javax.swing.JTextField E6;
    public javax.swing.JTextField ET;
    public javax.swing.JTextField F1;
    public javax.swing.JTextField F2;
    public javax.swing.JTextField F3;
    public javax.swing.JTextField F4;
    public javax.swing.JTextField F5;
    public javax.swing.JTextField F6;
    public javax.swing.JTextField FT;
    public javax.swing.JTextField G1;
    public javax.swing.JTextField G2;
    public javax.swing.JTextField G3;
    public javax.swing.JTextField G4;
    public javax.swing.JTextField G5;
    public javax.swing.JTextField G6;
    public javax.swing.JTextField GT;
    public javax.swing.JTextField H1;
    public javax.swing.JTextField H2;
    public javax.swing.JTextField H3;
    public javax.swing.JTextField H4;
    public javax.swing.JTextField H5;
    public javax.swing.JTextField H6;
    public javax.swing.JTextField HT;
    public javax.swing.JTextField I1;
    public javax.swing.JTextField I2;
    public javax.swing.JTextField I3;
    public javax.swing.JTextField I4;
    public javax.swing.JTextField I5;
    public javax.swing.JTextField I6;
    public javax.swing.JTextField IT;
    public javax.swing.JTextField J1;
    public javax.swing.JTextField J2;
    public javax.swing.JTextField J3;
    public javax.swing.JTextField J4;
    public javax.swing.JTextField J5;
    public javax.swing.JTextField J6;
    public javax.swing.JTextField JT;
    public javax.swing.JTextField K1;
    public javax.swing.JTextField K2;
    public javax.swing.JTextField K3;
    public javax.swing.JTextField K4;
    public javax.swing.JTextField K5;
    public javax.swing.JTextField K6;
    public javax.swing.JTextField KT;
    public javax.swing.JTextField L1;
    public javax.swing.JTextField L2;
    public javax.swing.JTextField L3;
    public javax.swing.JTextField L4;
    public javax.swing.JTextField L5;
    public javax.swing.JTextField L6;
    public javax.swing.JTextField LT;
    public javax.swing.JTextField M1;
    public javax.swing.JTextField M2;
    public javax.swing.JTextField M3;
    public javax.swing.JTextField M4;
    public javax.swing.JTextField M5;
    public javax.swing.JTextField M6;
    public javax.swing.JTextField MT;
    public javax.swing.JTextField N1;
    public javax.swing.JTextField N2;
    public javax.swing.JTextField N3;
    public javax.swing.JTextField N4;
    public javax.swing.JTextField N5;
    public javax.swing.JTextField N6;
    public javax.swing.JTextField NT;
    public javax.swing.JTextField O1;
    public javax.swing.JTextField O2;
    public javax.swing.JTextField O3;
    public javax.swing.JTextField O4;
    public javax.swing.JTextField O5;
    public javax.swing.JTextField O6;
    public javax.swing.JTextField OT;
    public javax.swing.JTextField P1;
    public javax.swing.JTextField P2;
    public javax.swing.JTextField P3;
    public javax.swing.JTextField P4;
    public javax.swing.JTextField P5;
    public javax.swing.JTextField P6;
    public javax.swing.JTextField PT;
    public javax.swing.JTextField Q1;
    public javax.swing.JTextField Q2;
    public javax.swing.JTextField Q3;
    public javax.swing.JTextField Q4;
    public javax.swing.JTextField Q5;
    public javax.swing.JTextField Q6;
    public javax.swing.JTextField QT;
    public javax.swing.JTextField R1;
    public javax.swing.JTextField R2;
    public javax.swing.JTextField R3;
    public javax.swing.JTextField R4;
    public javax.swing.JTextField R5;
    public javax.swing.JTextField R6;
    public javax.swing.JTextField RT;
    public javax.swing.JTextField S1;
    public javax.swing.JTextField S2;
    public javax.swing.JTextField S3;
    public javax.swing.JTextField S4;
    public javax.swing.JTextField S5;
    public javax.swing.JTextField S6;
    public javax.swing.JTextField ST;
    public javax.swing.JTextField T1;
    public javax.swing.JTextField T2;
    public javax.swing.JTextField T3;
    public javax.swing.JTextField T4;
    public javax.swing.JTextField T5;
    public javax.swing.JTextField T6;
    public javax.swing.JTextField TT;
    public javax.swing.JTextField U1;
    public javax.swing.JTextField U2;
    public javax.swing.JTextField U3;
    public javax.swing.JTextField U4;
    public javax.swing.JTextField U5;
    public javax.swing.JTextField U6;
    public javax.swing.JTextField UT;
    public javax.swing.JTextField V1;
    public javax.swing.JTextField V2;
    public javax.swing.JTextField V3;
    public javax.swing.JTextField V4;
    public javax.swing.JTextField V5;
    public javax.swing.JTextField V6;
    public javax.swing.JTextField VT;
    public javax.swing.JTextField W1;
    public javax.swing.JTextField W2;
    public javax.swing.JTextField W3;
    public javax.swing.JTextField W4;
    public javax.swing.JTextField W5;
    public javax.swing.JTextField W6;
    public javax.swing.JTextField WT;
    public javax.swing.JTextField X1;
    public javax.swing.JTextField X2;
    public javax.swing.JTextField X3;
    public javax.swing.JTextField X4;
    public javax.swing.JTextField X5;
    public javax.swing.JTextField X6;
    public javax.swing.JTextField XT;
    public javax.swing.JComboBox cbEvaluador;
    public com.toedter.calendar.JDateChooser dcFechaE;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
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
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanel5;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JSeparator jSeparator1;
    public javax.swing.JSeparator jSeparator10;
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
