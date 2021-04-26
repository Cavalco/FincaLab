/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_LaboratorioN;

import Formas_laboratorio.jpBitacora;
import Metodos_Configuraciones.metodosLaboratorio;
import java.awt.Dimension;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author jCarl
 */
public class jdCatacion2 extends javax.swing.JFrame {

    DecimalFormat formato = new DecimalFormat("#.#");
    double dryv = 0, promFragancia, a1, a2, a3;
    int l1, l2, totalD;
    Connection cn;
    metodosLaboratorio mdb;
    String id = "";
    jpBitacora jpCT;
    jpPanelSaboresDry jp;
    jpPanelSaboresAftertaste jpSA;
    jpPanelSaboresAcidity jpAC;
    //String csm = "", comunidad = "", tipo = "", id, forma = "";

    /**
     * Creates new form jdCatacion
     */
    public jdCatacion2(Connection cn, String proceso, String id, String csm, String comunidad, String formaCafe) {
        initComponents();
        setLocationRelativeTo(null);

        this.cn = cn;
        this.id = id;
        lblCSM.setText(csm);
        lblProceso.setText(proceso);
        lblComunidad.setText(comunidad);

        Date date = new Date(System.currentTimeMillis());
        txtFecha.setMaxSelectableDate(date);
        mdb = new metodosLaboratorio(cn, "");
    }

    //Formula para evaluación en taza
    public void formula() {
        //JOptionPane.showMessageDialog(null,"Entre al metodo");
        double total, a = Double.valueOf(lblFragancia.getText()), b, c, d,
                e, f, g, h, i, j, k, l;

        if (!txtSabor.getText().equals("")) {
            b = Double.valueOf(txtSabor.getText());
        } else {
            b = 0;
        }

        if (!txtAftertaste.getText().equals("")) {
            c = Double.valueOf(txtAftertaste.getText());
        } else {
            c = 0;
        }

        if (!txtAcidez.getText().equals("")) {
            d = Double.valueOf(txtAcidez.getText());
        } else {
            d = 0;
        }

        if (!txtCuerpo.getText().equals("")) {
            e = Double.valueOf(txtCuerpo.getText());
        } else {
            e = 0;
        }

        if (!txtBalance.getText().equals("")) {
            f = Double.valueOf(txtBalance.getText());
        } else {
            f = 0;
        }

        if (!txtTazasCat.getText().equals("")) {
            g = Double.valueOf(txtTazasCat.getText());
        } else {
            g = 0;
        }

        if (!txtUniTaza.getText().equals("")) {
            h = Double.valueOf(txtUniTaza.getText());
        } else {
            h = 0;
        }

        if (!txtTazaLim.getText().equals("")) {
            i = Double.valueOf(txtTazaLim.getText());
        } else {
            i = 0;
        }

        if (!txtDulzor.getText().equals("")) {
            j = Double.valueOf(txtDulzor.getText());
        } else {
            j = 0;
        }

        if (!txtCatador.getText().equals("")) {
            k = Double.valueOf(txtCatador.getText());
        } else {
            k = 0;
        }

        if (!txtDefectos.getText().equals("")) {
            l = Double.valueOf(txtDefectos.getText());
        } else {
            l = 0;
        }
        
        //Formula anterior que debe utilizarse de nuevo para coincidir con archivo Eval Green
        //total = a + b + c + d + e + f + ((10 / g) * h) + ((10 / g) * i) + ((10 / g) * j) + k - l;
        total = a + b + c + d + e + f + h + i + j + k - l;

        lblPuntuacion.setText(formato.format(total) + "");

        System.out.println("Puntuacion: " + a + " + " + b + " + " + c + " + " + d + " + " + e + " + " + f + " + ((10/" + g + ")  " + h + ") + ((10/g)  " + i + ") + ((10/" + g + ") * " + j + ") + " + k + " - 1");
    }

    public void promedio() {
        a1 = Double.parseDouble(txtSeco.getText());
        a2 = Double.parseDouble(txtMojado.getText());
        a3 = Double.parseDouble(txtQuebrado.getText());

        promFragancia = (a1 + a2 + a3) / 3;
        lblFragancia.setText(formato.format(promFragancia) + "");
    }

    /*  public void cadenas(String cadena) {

        if (!cadena.equals("")) {
            cadena = cadena.substring(0, cadena.length() - 1);
        }

        switch (jComboBox1.getSelectedItem() + "") {
            case "Seco":
                lblSeco.setText(cadena);
                break;

            case "Mojado":
                lblMojado.setText(cadena);
                break;

            case "Quebrado":
                lblQuebrado.setText(cadena);
                break;

            case "Sabor":
                lblSabor.setText(cadena);
                break;

            case "Sabor Remanente":
                lblRemanente.setText(cadena);
                break;

            case "Acidez":
                lblAcidez.setText(cadena);
                break;

        }

    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCSM = new javax.swing.JLabel();
        lblComunidad = new javax.swing.JLabel();
        lblProceso = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        slUniTostado = new javax.swing.JSlider();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        slNivelTostado = new javax.swing.JSlider();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Quakers = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtDenTostado1 = new javax.swing.JTextField();
        Quakers1 = new javax.swing.JTextField();
        lblDenTos = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtUniTaza = new javax.swing.JTextField();
        txtTazaLim = new javax.swing.JTextField();
        txtDulzor = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txtDefectos = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtNoTazas = new javax.swing.JTextField();
        txtIntensidad = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtTazasCat = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblFragancia = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        slSeco = new javax.swing.JSlider();
        btnMenos = new javax.swing.JButton();
        txtSeco = new javax.swing.JTextField();
        btnMas = new javax.swing.JButton();
        slMojado = new javax.swing.JSlider();
        btnMenos2 = new javax.swing.JButton();
        txtMojado = new javax.swing.JTextField();
        btnMas2 = new javax.swing.JButton();
        slQuebrado = new javax.swing.JSlider();
        btnMenos3 = new javax.swing.JButton();
        txtQuebrado = new javax.swing.JTextField();
        btnMas3 = new javax.swing.JButton();
        slSabor = new javax.swing.JSlider();
        jButton10 = new javax.swing.JButton();
        txtSabor = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        slAftertaste = new javax.swing.JSlider();
        jButton12 = new javax.swing.JButton();
        txtAftertaste = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        slAcidez = new javax.swing.JSlider();
        jButton14 = new javax.swing.JButton();
        txtAcidez = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        slCuerpo = new javax.swing.JSlider();
        jButton16 = new javax.swing.JButton();
        txtCuerpo = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        spAcidezInt = new javax.swing.JSpinner();
        spCuerpoInt = new javax.swing.JSpinner();
        slBalance = new javax.swing.JSlider();
        jButton18 = new javax.swing.JButton();
        txtBalance = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        slCatador = new javax.swing.JSlider();
        jButton20 = new javax.swing.JButton();
        txtCatador = new javax.swing.JTextField();
        jButton21 = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        Sweet = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        Floral = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        Fruit = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        SourFer = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        GreenVeg = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        Other = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        Roasted = new javax.swing.JTable();
        jScrollPane13 = new javax.swing.JScrollPane();
        Spices = new javax.swing.JTable();
        jScrollPane14 = new javax.swing.JScrollPane();
        Nutty = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        Sweet1 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        Floral1 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        Fruit1 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        SourFer1 = new javax.swing.JTable();
        jScrollPane18 = new javax.swing.JScrollPane();
        GreenVeg1 = new javax.swing.JTable();
        jScrollPane19 = new javax.swing.JScrollPane();
        Other1 = new javax.swing.JTable();
        jScrollPane20 = new javax.swing.JScrollPane();
        Roasted1 = new javax.swing.JTable();
        jScrollPane21 = new javax.swing.JScrollPane();
        Spices1 = new javax.swing.JTable();
        jScrollPane22 = new javax.swing.JScrollPane();
        Nutty1 = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane23 = new javax.swing.JScrollPane();
        Sweet2 = new javax.swing.JTable();
        jScrollPane24 = new javax.swing.JScrollPane();
        Floral2 = new javax.swing.JTable();
        jScrollPane25 = new javax.swing.JScrollPane();
        Fruit2 = new javax.swing.JTable();
        jScrollPane26 = new javax.swing.JScrollPane();
        SourFer2 = new javax.swing.JTable();
        jScrollPane27 = new javax.swing.JScrollPane();
        GreenVeg2 = new javax.swing.JTable();
        jScrollPane28 = new javax.swing.JScrollPane();
        Other2 = new javax.swing.JTable();
        jScrollPane29 = new javax.swing.JScrollPane();
        Roasted2 = new javax.swing.JTable();
        jScrollPane30 = new javax.swing.JScrollPane();
        Spices2 = new javax.swing.JTable();
        jScrollPane31 = new javax.swing.JScrollPane();
        Nutty2 = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane32 = new javax.swing.JScrollPane();
        Sweet3 = new javax.swing.JTable();
        jScrollPane33 = new javax.swing.JScrollPane();
        Floral3 = new javax.swing.JTable();
        jScrollPane34 = new javax.swing.JScrollPane();
        Fruit3 = new javax.swing.JTable();
        jScrollPane35 = new javax.swing.JScrollPane();
        SourFer3 = new javax.swing.JTable();
        jScrollPane36 = new javax.swing.JScrollPane();
        GreenVeg3 = new javax.swing.JTable();
        jScrollPane37 = new javax.swing.JScrollPane();
        Other3 = new javax.swing.JTable();
        jScrollPane38 = new javax.swing.JScrollPane();
        Roasted3 = new javax.swing.JTable();
        jScrollPane39 = new javax.swing.JScrollPane();
        Spices3 = new javax.swing.JTable();
        jScrollPane40 = new javax.swing.JScrollPane();
        Nutty3 = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane41 = new javax.swing.JScrollPane();
        Sweet4 = new javax.swing.JTable();
        jScrollPane42 = new javax.swing.JScrollPane();
        Floral4 = new javax.swing.JTable();
        jScrollPane43 = new javax.swing.JScrollPane();
        Fruit4 = new javax.swing.JTable();
        jScrollPane44 = new javax.swing.JScrollPane();
        SourFer4 = new javax.swing.JTable();
        jScrollPane45 = new javax.swing.JScrollPane();
        GreenVeg4 = new javax.swing.JTable();
        jScrollPane46 = new javax.swing.JScrollPane();
        Body1 = new javax.swing.JTable();
        jScrollPane47 = new javax.swing.JScrollPane();
        Finish1 = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane48 = new javax.swing.JScrollPane();
        SourFer5 = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane54 = new javax.swing.JScrollPane();
        Body2 = new javax.swing.JTable();
        jScrollPane55 = new javax.swing.JScrollPane();
        Finish2 = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        lblPuntuacion = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        lblSeco = new javax.swing.JLabel();
        lblMojado = new javax.swing.JLabel();
        lblQuebrado = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        lblSabor = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        lblRemanente = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        lblAcidez = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        lblCuerpo = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Evaluaciòn Taza");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("No. de CSM:");

        jLabel2.setText("Comunidad:");

        jLabel3.setText("Proceso:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCSM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblComunidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCSM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblComunidad, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Nivel de tostado");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 0, 0));

        slUniTostado.setMajorTickSpacing(1);
        slUniTostado.setMaximum(5);
        slUniTostado.setMinimum(1);
        slUniTostado.setPaintLabels(true);
        slUniTostado.setValue(3);

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(51, 51, 51));

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(102, 102, 102));

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(153, 153, 153));

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setText("Uniformidad de tostado");

        slNivelTostado.setMajorTickSpacing(1);
        slNivelTostado.setMaximum(5);
        slNivelTostado.setMinimum(1);
        slNivelTostado.setPaintLabels(true);
        slNivelTostado.setValue(3);
        slNivelTostado.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slNivelTostadoStateChanged(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("* 5 = parejo");

        jLabel7.setText("Densidad de tostado:");

        jLabel8.setText("Quakers:");

        jLabel35.setText("Peso, gm");

        jLabel36.setText("Volumen, ml");

        lblDenTos.setText("-");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(slNivelTostado, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(slUniTostado, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Quakers, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblDenTos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Quakers1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDenTostado1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel4))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel5)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addComponent(slNivelTostado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slUniTostado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDenTostado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Quakers1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblDenTos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Quakers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtFecha.setDateFormatString("d/MMM/yyyy");

        jLabel9.setText("Fecha");

        jLabel10.setText("Uniformidad Taza");

        jLabel11.setText("Taza limpia");

        jLabel12.setText("Dulzor");

        txtUniTaza.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUniTazaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUniTazaKeyTyped(evt);
            }
        });

        txtTazaLim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTazaLimKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTazaLimKeyTyped(evt);
            }
        });

        txtDulzor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDulzorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDulzorKeyTyped(evt);
            }
        });

        txtDefectos.setEditable(false);
        txtDefectos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDefectosKeyReleased(evt);
            }
        });

        jLabel14.setText("Tazas Malas");

        jLabel15.setText("Intensidad");

        txtNoTazas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNoTazasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoTazasKeyTyped(evt);
            }
        });

        txtIntensidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIntensidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIntensidadKeyTyped(evt);
            }
        });

        jLabel16.setForeground(new java.awt.Color(204, 0, 0));
        jLabel16.setText("* 4 = Rechazado");

        jLabel19.setText("Tazas Catadas");

        txtTazasCat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTazasCatKeyReleased(evt);
            }
        });

        jLabel13.setText("Defectos Agregados");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTazasCat)
                    .addComponent(txtNoTazas)
                    .addComponent(txtIntensidad)
                    .addComponent(txtDefectos)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel19)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel13))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtUniTaza, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtTazaLim))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtDulzor)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTazasCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtUniTaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTazaLim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtDulzor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNoTazas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIntensidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDefectos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addGap(107, 107, 107))
        );

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

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

        jButton2.setText("Salir");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setText("Seco:");

        jLabel21.setText("Mojado:");

        jLabel22.setText("Quebrado:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Fragancia:");

        lblFragancia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFragancia.setText("7.0");

        jLabel25.setText("Sabor:");

        jLabel26.setText("Sabor Remanente:");

        jLabel27.setText("Acidez:");

        jLabel28.setText("Intensidad (1-5):");

        jLabel29.setText("Cuerpo:");

        jLabel30.setText("Intensidad (1-5):");

        jLabel31.setText("Balance:");

        jLabel32.setText("Catador:");

        slSeco.setMaximum(950);
        slSeco.setMinimum(450);
        slSeco.setToolTipText("");
        slSeco.setValue(700);
        slSeco.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slSecoStateChanged(evt);
            }
        });

        btnMenos.setText("-");
        btnMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosActionPerformed(evt);
            }
        });

        txtSeco.setText("7.0");

        btnMas.setText("+");
        btnMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasActionPerformed(evt);
            }
        });

        slMojado.setMajorTickSpacing(50);
        slMojado.setMaximum(950);
        slMojado.setMinimum(450);
        slMojado.setValue(700);
        slMojado.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slMojadoStateChanged(evt);
            }
        });

        btnMenos2.setText("-");
        btnMenos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenos2ActionPerformed(evt);
            }
        });

        txtMojado.setText("7.0");

        btnMas2.setText("+");
        btnMas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMas2ActionPerformed(evt);
            }
        });

        slQuebrado.setMajorTickSpacing(50);
        slQuebrado.setMaximum(950);
        slQuebrado.setMinimum(450);
        slQuebrado.setValue(700);
        slQuebrado.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slQuebradoStateChanged(evt);
            }
        });

        btnMenos3.setText("-");
        btnMenos3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenos3ActionPerformed(evt);
            }
        });

        txtQuebrado.setText("7.0");

        btnMas3.setText("+");
        btnMas3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMas3ActionPerformed(evt);
            }
        });

        slSabor.setMaximum(950);
        slSabor.setMinimum(450);
        slSabor.setValue(700);
        slSabor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slSaborStateChanged(evt);
            }
        });

        jButton10.setText("-");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        txtSabor.setText("7.0");

        jButton11.setText("+");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        slAftertaste.setMaximum(950);
        slAftertaste.setMinimum(450);
        slAftertaste.setValue(700);
        slAftertaste.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slAftertasteStateChanged(evt);
            }
        });

        jButton12.setText("-");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        txtAftertaste.setText("7.0");

        jButton13.setText("+");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        slAcidez.setMaximum(950);
        slAcidez.setMinimum(450);
        slAcidez.setValue(700);
        slAcidez.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slAcidezStateChanged(evt);
            }
        });

        jButton14.setText("-");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        txtAcidez.setText("7.0");

        jButton15.setText("+");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        slCuerpo.setMaximum(950);
        slCuerpo.setMinimum(450);
        slCuerpo.setValue(700);
        slCuerpo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slCuerpoStateChanged(evt);
            }
        });

        jButton16.setText("-");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        txtCuerpo.setText("7.0");

        jButton17.setText("+");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        slBalance.setMaximum(950);
        slBalance.setMinimum(450);
        slBalance.setValue(700);
        slBalance.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slBalanceStateChanged(evt);
            }
        });

        jButton18.setText("-");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        txtBalance.setText("7.0");

        jButton19.setText("+");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        slCatador.setMaximum(950);
        slCatador.setMinimum(450);
        slCatador.setValue(700);
        slCatador.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slCatadorStateChanged(evt);
            }
        });

        jButton20.setText("-");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        txtCatador.setText("7.0");

        jButton21.setText("+");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator6)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator5)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel31))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(slBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton19))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(slCatador, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCatador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton21))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel22))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(slSeco, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnMenos)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSeco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnMas))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(slQuebrado, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnMenos3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtQuebrado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnMas3))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(slMojado, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnMenos2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMojado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnMas2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel23)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblFragancia, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(slAftertaste, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAftertaste, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton13))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(18, 18, 18)
                                .addComponent(slCuerpo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCuerpo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton17)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel30)
                                .addGap(18, 18, 18)
                                .addComponent(spCuerpoInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(slSabor, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSabor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton11))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(59, 59, 59)
                                .addComponent(slAcidez, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAcidez, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel28)
                                .addGap(18, 18, 18)
                                .addComponent(spAcidezInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addComponent(jSeparator7)
                    .addComponent(jSeparator8)
                    .addComponent(jSeparator9))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnMenos)
                        .addComponent(txtSeco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMas))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel20)
                        .addComponent(slSeco, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnMenos2)
                        .addComponent(txtMojado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMas2)
                        .addComponent(jLabel23)
                        .addComponent(lblFragancia, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel21)
                        .addComponent(slMojado, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnMenos3)
                        .addComponent(txtQuebrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMas3))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel22)
                        .addComponent(slQuebrado, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton10)
                        .addComponent(txtSabor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton11))
                    .addComponent(slSabor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton12)
                        .addComponent(txtAftertaste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton13))
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(slAftertaste, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(slAcidez, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton14)
                        .addComponent(txtAcidez, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton15)
                        .addComponent(jLabel28)
                        .addComponent(spAcidezInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton16)
                        .addComponent(txtCuerpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton17)
                        .addComponent(jLabel30)
                        .addComponent(spCuerpoInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(slCuerpo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton18)
                        .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton19))
                    .addComponent(slBalance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton20)
                        .addComponent(txtCatador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton21))
                    .addComponent(slCatador, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel33.setText("Información");

        Sweet.setBackground(new java.awt.Color(255, 102, 102));
        Sweet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Dulce", null},
                {"Azúcar-Mor", null},
                {"Melaza", null},
                {"Jarab-mapl", null},
                {"Caramelo", null},
                {"Miel", null},
                {"Vainilla", null}
            },
            new String [] {
                "1 Cualidad", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Sweet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SweetMouseClicked(evt);
            }
        });
        Sweet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SweetKeyReleased(evt);
            }
        });
        jScrollPane9.setViewportView(Sweet);

        Floral.setBackground(new java.awt.Color(255, 153, 102));
        Floral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Floral", null},
                {"Té-Negro", null},
                {"Manzanilla", null},
                {"Rosa", null},
                {"Jazmine", null}
            },
            new String [] {
                "2 Cualidad", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Floral.setPreferredSize(new java.awt.Dimension(175, 80));
        Floral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FloralKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(Floral);

        Fruit.setBackground(new java.awt.Color(255, 204, 0));
        Fruit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Frutas", null},
                {"Bayas", null},
                {"Moras", null},
                {"Frambuesa", null},
                {"Arándano", null},
                {"Fresa", null},
                {"Fruto-sec", null},
                {"Pasas", null},
                {"Ciruel-pas", null},
                {"Otras-frut", null},
                {"Coco", null},
                {"Cereza", null},
                {"Granada", null},
                {"Piña", null},
                {"Uvas", null},
                {"Manzana", null},
                {"Durazno", null},
                {"Pera", null},
                {"Citricos", null},
                {"Toronja", null},
                {"Naranja", null},
                {"Limon", null},
                {"Lima", null}
            },
            new String [] {
                "3 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Fruit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FruitKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(Fruit);

        SourFer.setBackground(new java.awt.Color(255, 255, 153));
        SourFer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Acido", null},
                {"Arom-acido", null},
                {"Acido-acét", null},
                {"Acido-butí", null},
                {"Acido-isoc", null},
                {"Acido-cítr", null},
                {"Acido-máli", null},
                {"Alcoh/Ferm", null},
                {"Vinoso", null},
                {"Whisky", null},
                {"Fermentado", null},
                {"Super-madu", null}
            },
            new String [] {
                "4 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SourFer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SourFerKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(SourFer);

        GreenVeg.setBackground(new java.awt.Color(102, 255, 102));
        GreenVeg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Verde/Vegetal", null},
                {"Aceit-Oliv", null},
                {"Crudo", null},
                {"Verde/Vege", null},
                {"Inmaduro", null},
                {"Vaina", null},
                {"Fresco", null},
                {"Verde-oscu", null},
                {"Vegetal", null},
                {"Paja", null},
                {"Herbaceo", null},
                {"Leguminoso", null}
            },
            new String [] {
                "5 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GreenVeg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GreenVegKeyReleased(evt);
            }
        });
        jScrollPane10.setViewportView(GreenVeg);

        Other.setBackground(new java.awt.Color(51, 255, 255));
        Other.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Otros", null},
                {"Papel/Hume", null},
                {"Rancio", null},
                {"Carton", null},
                {"Papel", null},
                {"Madera", null},
                {"Mohoso", null},
                {"Polvo-hume", null},
                {"Tierra", null},
                {"Cuero", null},
                {"Carne/cald", null},
                {"Fenolico", null},
                {"Quimico", null},
                {"Amargo", null},
                {"Salado", null},
                {"Medicinal", null},
                {"Petroleo", null},
                {"Zorrillo", null},
                {"Goma", null}
            },
            new String [] {
                "6 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Other.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                OtherKeyReleased(evt);
            }
        });
        jScrollPane11.setViewportView(Other);

        Roasted.setBackground(new java.awt.Color(0, 204, 255));
        Roasted.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Tostado", null},
                {"Tabac-pipa", null},
                {"Tabaco", null},
                {"Quemado", null},
                {"Acre", null},
                {"Ceniza", null},
                {"Humo", null},
                {"Marrón/tos", null},
                {"Cereal", null},
                {"Grano", null},
                {"Malta", null}
            },
            new String [] {
                "7 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Roasted.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RoastedKeyReleased(evt);
            }
        });
        jScrollPane12.setViewportView(Roasted);

        Spices.setBackground(new java.awt.Color(153, 153, 255));
        Spices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Especias", null},
                {"Acre", null},
                {"Pimienta", null},
                {"Especias-mo", null},
                {"Anis", null},
                {"Nuez-mosca", null},
                {"Canela", null},
                {"Clavo-olor", null}
            },
            new String [] {
                "8 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Spices.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SpicesKeyReleased(evt);
            }
        });
        jScrollPane13.setViewportView(Spices);

        Nutty.setBackground(new java.awt.Color(255, 102, 204));
        Nutty.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Nueces/Cacao", null},
                {"Nueces", null},
                {"Mani", null},
                {"Avellana", null},
                {"Almendra", null},
                {"Cacao", null},
                {"Chocolate", null},
                {"Choc-amarg", null}
            },
            new String [] {
                "9 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Nutty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NuttyKeyReleased(evt);
            }
        });
        jScrollPane14.setViewportView(Nutty);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Seco", jPanel10);

        Sweet1.setBackground(new java.awt.Color(255, 102, 102));
        Sweet1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Dulce", null},
                {"Azúcar-Mor", null},
                {"Melaza", null},
                {"Jarab-mapl", null},
                {"Caramelo", null},
                {"Miel", null},
                {"Vainilla", null}
            },
            new String [] {
                "1 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Sweet1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Sweet1KeyReleased(evt);
            }
        });
        jScrollPane17.setViewportView(Sweet1);

        Floral1.setBackground(new java.awt.Color(255, 153, 102));
        Floral1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Floral", null},
                {"Té-Negro", null},
                {"Manzanilla", null},
                {"Rosa", null},
                {"Jazmine", null}
            },
            new String [] {
                "2 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Floral1.setPreferredSize(new java.awt.Dimension(175, 80));
        Floral1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Floral1KeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(Floral1);

        Fruit1.setBackground(new java.awt.Color(255, 204, 0));
        Fruit1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Frutas", null},
                {"Bayas", null},
                {"Moras", null},
                {"Frambuesa", null},
                {"Arándano", null},
                {"Fresa", null},
                {"Fruto-sec", null},
                {"Pasas", null},
                {"Ciruel-pas", null},
                {"Otras-frut", null},
                {"Coco", null},
                {"Cereza", null},
                {"Granada", null},
                {"Piña", null},
                {"Uvas", null},
                {"Manzana", null},
                {"Durazno", null},
                {"Pera", null},
                {"Citricos", null},
                {"Toronja", null},
                {"Naranja", null},
                {"Limon", null},
                {"Lima", null}
            },
            new String [] {
                "3 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Fruit1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Fruit1KeyReleased(evt);
            }
        });
        jScrollPane7.setViewportView(Fruit1);

        SourFer1.setBackground(new java.awt.Color(255, 255, 153));
        SourFer1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Acido", null},
                {"Arom-acido", null},
                {"Acido-acét", null},
                {"Acido-butí", null},
                {"Acido-isoc", null},
                {"Acido-cítr", null},
                {"Acido-máli", null},
                {"Alcoh/Ferm", null},
                {"Vinoso", null},
                {"Whisky", null},
                {"Fermentado", null},
                {"Super-madu", null}
            },
            new String [] {
                "4 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SourFer1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SourFer1KeyReleased(evt);
            }
        });
        jScrollPane8.setViewportView(SourFer1);

        GreenVeg1.setBackground(new java.awt.Color(102, 255, 102));
        GreenVeg1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Verde/Vegetal", null},
                {"Aceit-Oliv", null},
                {"Crudo", null},
                {"Verde/Vege", null},
                {"Inmaduro", null},
                {"Vaina", null},
                {"Fresco", null},
                {"Verde-oscu", null},
                {"Vegetal", null},
                {"Paja", null},
                {"Herbaceo", null},
                {"Leguminoso", null}
            },
            new String [] {
                "5 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GreenVeg1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GreenVeg1KeyReleased(evt);
            }
        });
        jScrollPane18.setViewportView(GreenVeg1);

        Other1.setBackground(new java.awt.Color(51, 255, 255));
        Other1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Otros", null},
                {"Papel/Hume", null},
                {"Rancio", null},
                {"Carton", null},
                {"Papel", null},
                {"Madera", null},
                {"Mohoso", null},
                {"Polvo-hume", null},
                {"Tierra", null},
                {"Cuero", null},
                {"Carne/cald", null},
                {"Fenolico", null},
                {"Quimico", null},
                {"Amargo", null},
                {"Salado", null},
                {"Medicinal", null},
                {"Petroleo", null},
                {"Zorrillo", null},
                {"Goma", null}
            },
            new String [] {
                "6 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Other1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Other1KeyReleased(evt);
            }
        });
        jScrollPane19.setViewportView(Other1);

        Roasted1.setBackground(new java.awt.Color(0, 204, 255));
        Roasted1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Tostado", null},
                {"Tabac-pipa", null},
                {"Tabaco", null},
                {"Quemado", null},
                {"Acre", null},
                {"Ceniza", null},
                {"Humo", null},
                {"Marrón/tos", null},
                {"Cereal", null},
                {"Grano", null},
                {"Malta", null}
            },
            new String [] {
                "7 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Roasted1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Roasted1KeyReleased(evt);
            }
        });
        jScrollPane20.setViewportView(Roasted1);

        Spices1.setBackground(new java.awt.Color(153, 153, 255));
        Spices1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Especias", null},
                {"Acre", null},
                {"Pimienta", null},
                {"Especias marrones", null},
                {"Anis", null},
                {"Nuez moscada", null},
                {"Canela", null},
                {"Clavo de olor", null}
            },
            new String [] {
                "8 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Spices1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Spices1KeyReleased(evt);
            }
        });
        jScrollPane21.setViewportView(Spices1);

        Nutty1.setBackground(new java.awt.Color(255, 102, 204));
        Nutty1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Nueces/Cacao", null},
                {"Nueces", null},
                {"Mani", null},
                {"Avellana", null},
                {"Almendra", null},
                {"Cacao", null},
                {"Choocolate", null},
                {"Choc amargo", null}
            },
            new String [] {
                "9 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Nutty1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Nutty1KeyReleased(evt);
            }
        });
        jScrollPane22.setViewportView(Nutty1);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1065, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                        .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(12, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Mojado", jPanel11);

        Sweet2.setBackground(new java.awt.Color(255, 102, 102));
        Sweet2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Dulce", null},
                {"Azúcar-Mor", null},
                {"Melaza", null},
                {"Jarab-mapl", null},
                {"Caramelo", null},
                {"Miel", null},
                {"Vainilla", null}
            },
            new String [] {
                "1 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Sweet2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Sweet2KeyReleased(evt);
            }
        });
        jScrollPane23.setViewportView(Sweet2);

        Floral2.setBackground(new java.awt.Color(255, 153, 102));
        Floral2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Floral", null},
                {"Té-Negro", null},
                {"Manzanilla", null},
                {"Rosa", null},
                {"Jazmine", null}
            },
            new String [] {
                "2 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Floral2.setPreferredSize(new java.awt.Dimension(175, 80));
        Floral2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Floral2KeyReleased(evt);
            }
        });
        jScrollPane24.setViewportView(Floral2);

        Fruit2.setBackground(new java.awt.Color(255, 204, 0));
        Fruit2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Frutas", null},
                {"Bayas", null},
                {"Moras", null},
                {"Frambuesa", null},
                {"Arándano", null},
                {"Fresa", null},
                {"Fruto-sec", null},
                {"Pasas", null},
                {"Ciruel-pas", null},
                {"Otras-frut", null},
                {"Coco", null},
                {"Cereza", null},
                {"Granada", null},
                {"Piña", null},
                {"Uvas", null},
                {"Manzana", null},
                {"Durazno", null},
                {"Pera", null},
                {"Citricos", null},
                {"Toronja", null},
                {"Naranja", null},
                {"Limon", null},
                {"Lima", null}
            },
            new String [] {
                "3 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Fruit2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Fruit2KeyReleased(evt);
            }
        });
        jScrollPane25.setViewportView(Fruit2);

        SourFer2.setBackground(new java.awt.Color(255, 255, 153));
        SourFer2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Acido", null},
                {"Arom-acido", null},
                {"Acido-acét", null},
                {"Acido-butí", null},
                {"Acido-isoc", null},
                {"Acido-cítr", null},
                {"Acido-máli", null},
                {"Alcoh/Ferm", null},
                {"Vinoso", null},
                {"Whisky", null},
                {"Fermentado", null},
                {"Super-madu", null}
            },
            new String [] {
                "4 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SourFer2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SourFer2KeyReleased(evt);
            }
        });
        jScrollPane26.setViewportView(SourFer2);

        GreenVeg2.setBackground(new java.awt.Color(102, 255, 102));
        GreenVeg2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Verde/Vegetal", null},
                {"Aceit-Oliv", null},
                {"Crudo", null},
                {"Verde/Vege", null},
                {"Inmaduro", null},
                {"Vaina", null},
                {"Fresco", null},
                {"Verde-oscu", null},
                {"Vegetal", null},
                {"Paja", null},
                {"Herbaceo", null},
                {"Leguminoso", null}
            },
            new String [] {
                "5 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GreenVeg2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GreenVeg2KeyReleased(evt);
            }
        });
        jScrollPane27.setViewportView(GreenVeg2);

        Other2.setBackground(new java.awt.Color(51, 255, 255));
        Other2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Otros", null},
                {"Papel/Hume", null},
                {"Rancio", null},
                {"Carton", null},
                {"Papel", null},
                {"Madera", null},
                {"Mohoso", null},
                {"Polvo-hume", null},
                {"Tierra", null},
                {"Cuero", null},
                {"Carne/cald", null},
                {"Fenolico", null},
                {"Quimico", null},
                {"Amargo", null},
                {"Salado", null},
                {"Medicinal", null},
                {"Petroleo", null},
                {"Zorrillo", null},
                {"Goma", null}
            },
            new String [] {
                "6 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Other2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Other2KeyReleased(evt);
            }
        });
        jScrollPane28.setViewportView(Other2);

        Roasted2.setBackground(new java.awt.Color(0, 204, 255));
        Roasted2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Tostado", null},
                {"Tabac-pipa", null},
                {"Tabaco", null},
                {"Quemado", null},
                {"Acre", null},
                {"Ceniza", null},
                {"Humo", null},
                {"Marrón/tos", null},
                {"Cereal", null},
                {"Grano", null},
                {"Malta", null}
            },
            new String [] {
                "7 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Roasted2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Roasted2KeyReleased(evt);
            }
        });
        jScrollPane29.setViewportView(Roasted2);

        Spices2.setBackground(new java.awt.Color(153, 153, 255));
        Spices2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Especias", null},
                {"Acre", null},
                {"Pimienta", null},
                {"Especias marrones", null},
                {"Anis", null},
                {"Nuez moscada", null},
                {"Canela", null},
                {"Clavo de olor", null}
            },
            new String [] {
                "8 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Spices2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Spices2KeyReleased(evt);
            }
        });
        jScrollPane30.setViewportView(Spices2);

        Nutty2.setBackground(new java.awt.Color(255, 102, 204));
        Nutty2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Nueces/Cacao", null},
                {"Nueces", null},
                {"Mani", null},
                {"Avellana", null},
                {"Almendra", null},
                {"Cacao", null},
                {"Chocolate", null},
                {"Choc amargo", null}
            },
            new String [] {
                "9 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Nutty2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Nutty2KeyReleased(evt);
            }
        });
        jScrollPane31.setViewportView(Nutty2);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1065, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                        .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane26, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane27, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane30, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                        .addComponent(jScrollPane31, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(jScrollPane26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jScrollPane30, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane31, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(12, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Quebrado", jPanel12);

        Sweet3.setBackground(new java.awt.Color(255, 102, 102));
        Sweet3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Dulce", null},
                {"Azúcar-Mor", null},
                {"Melaza", null},
                {"Jarab-mapl", null},
                {"Caramelo", null},
                {"Miel", null},
                {"Vainilla", null}
            },
            new String [] {
                "1 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Sweet3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Sweet3KeyReleased(evt);
            }
        });
        jScrollPane32.setViewportView(Sweet3);

        Floral3.setBackground(new java.awt.Color(255, 153, 102));
        Floral3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Floral", null},
                {"Té-Negro", null},
                {"Manzanilla", null},
                {"Rosa", null},
                {"Jazmine", null}
            },
            new String [] {
                "2 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Floral3.setPreferredSize(new java.awt.Dimension(175, 80));
        Floral3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Floral3KeyReleased(evt);
            }
        });
        jScrollPane33.setViewportView(Floral3);

        Fruit3.setBackground(new java.awt.Color(255, 204, 0));
        Fruit3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Frutas", null},
                {"Bayas", null},
                {"Moras", null},
                {"Frambuesa", null},
                {"Arándano", null},
                {"Fresa", null},
                {"Fruto-sec", null},
                {"Pasas", null},
                {"Ciruel-pas", null},
                {"Otras-frut", null},
                {"Coco", null},
                {"Cereza", null},
                {"Granada", null},
                {"Piña", null},
                {"Uvas", null},
                {"Manzana", null},
                {"Durazno", null},
                {"Pera", null},
                {"Citricos", null},
                {"Toronja", null},
                {"Naranja", null},
                {"Limon", null},
                {"Lima", null}
            },
            new String [] {
                "3 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Fruit3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Fruit3KeyReleased(evt);
            }
        });
        jScrollPane34.setViewportView(Fruit3);

        SourFer3.setBackground(new java.awt.Color(255, 255, 153));
        SourFer3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Acido", null},
                {"Arom-acido", null},
                {"Acido-acét", null},
                {"Acido-butí", null},
                {"Acido-isoc", null},
                {"Acido-cítr", null},
                {"Acido-máli", null},
                {"Alcoh/Ferm", null},
                {"Vinoso", null},
                {"Whisky", null},
                {"Fermentado", null},
                {"Super-madu", null}
            },
            new String [] {
                "4 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SourFer3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SourFer3KeyReleased(evt);
            }
        });
        jScrollPane35.setViewportView(SourFer3);

        GreenVeg3.setBackground(new java.awt.Color(102, 255, 102));
        GreenVeg3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Verde/Vegetal", null},
                {"Aceit-Oliv", null},
                {"Crudo", null},
                {"Verde/Vege", null},
                {"Inmaduro", null},
                {"Vaina", null},
                {"Fresco", null},
                {"Verde-oscu", null},
                {"Vegetal", null},
                {"Paja", null},
                {"Herbaceo", null},
                {"Leguminoso", null}
            },
            new String [] {
                "5 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GreenVeg3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GreenVeg3KeyReleased(evt);
            }
        });
        jScrollPane36.setViewportView(GreenVeg3);

        Other3.setBackground(new java.awt.Color(51, 255, 255));
        Other3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Otros", null},
                {"Papel/Hume", null},
                {"Rancio", null},
                {"Carton", null},
                {"Papel", null},
                {"Madera", null},
                {"Mohoso", null},
                {"Polvo-hume", null},
                {"Tierra", null},
                {"Cuero", null},
                {"Carne/cald", null},
                {"Fenolico", null},
                {"Quimico", null},
                {"Amargo", null},
                {"Salado", null},
                {"Medicinal", null},
                {"Petroleo", null},
                {"Zorrillo", null},
                {"Goma", null}
            },
            new String [] {
                "6 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Other3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Other3KeyReleased(evt);
            }
        });
        jScrollPane37.setViewportView(Other3);

        Roasted3.setBackground(new java.awt.Color(0, 204, 255));
        Roasted3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Tostado", null},
                {"Tabac-pipa", null},
                {"Tabaco", null},
                {"Quemado", null},
                {"Acre", null},
                {"Ceniza", null},
                {"Humo", null},
                {"Marrón/tos", null},
                {"Cereal", null},
                {"Grano", null},
                {"Malta", null}
            },
            new String [] {
                "7 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Roasted3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Roasted3KeyReleased(evt);
            }
        });
        jScrollPane38.setViewportView(Roasted3);

        Spices3.setBackground(new java.awt.Color(153, 153, 255));
        Spices3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Especias", null},
                {"Acre", null},
                {"Pimienta", null},
                {"Especias marrones", null},
                {"Anis", null},
                {"Nuez moscada", null},
                {"Canela", null},
                {"Clavo de olor", null}
            },
            new String [] {
                "8 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Spices3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Spices3KeyReleased(evt);
            }
        });
        jScrollPane39.setViewportView(Spices3);

        Nutty3.setBackground(new java.awt.Color(255, 102, 204));
        Nutty3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Nueces/Cacap", null},
                {"Nueces", null},
                {"Mani", null},
                {"Avellana", null},
                {"Almendra", null},
                {"Cacao", null},
                {"Chocolate", null},
                {"Choc amargo", null}
            },
            new String [] {
                "9 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Nutty3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Nutty3KeyReleased(evt);
            }
        });
        jScrollPane40.setViewportView(Nutty3);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1065, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane32, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                        .addComponent(jScrollPane33, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane34, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane35, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane36, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane37, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane38, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane39, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                        .addComponent(jScrollPane40, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(jScrollPane32, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane33, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane34, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(jScrollPane35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(jScrollPane39, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane40, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane37, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane38, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(12, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Sabor", jPanel13);

        Sweet4.setBackground(new java.awt.Color(255, 102, 102));
        Sweet4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Dulce", null},
                {"Azúcar-Mor", null},
                {"Melaza", null},
                {"Jarab-mapl", null},
                {"Caramelo", null},
                {"Miel", null},
                {"Vainilla", null}
            },
            new String [] {
                "1 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Sweet4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Sweet4KeyReleased(evt);
            }
        });
        jScrollPane41.setViewportView(Sweet4);

        Floral4.setBackground(new java.awt.Color(255, 153, 102));
        Floral4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Floral", null},
                {"Té-Negro", null},
                {"Manzanilla", null},
                {"Rosa", null},
                {"Jazmine", null}
            },
            new String [] {
                "2 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Floral4.setPreferredSize(new java.awt.Dimension(175, 80));
        Floral4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Floral4KeyReleased(evt);
            }
        });
        jScrollPane42.setViewportView(Floral4);

        Fruit4.setBackground(new java.awt.Color(255, 204, 0));
        Fruit4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Frutas", null},
                {"Bayas", null},
                {"Moras", null},
                {"Frambuesa", null},
                {"Arándano", null},
                {"Fresa", null},
                {"Fruto-sec", null},
                {"Pasas", null},
                {"Ciruel-pas", null},
                {"Otras-frut", null},
                {"Coco", null},
                {"Cereza", null},
                {"Granada", null},
                {"Piña", null},
                {"Uvas", null},
                {"Manzana", null},
                {"Durazno", null},
                {"Pera", null},
                {"Citricos", null},
                {"Toronja", null},
                {"Naranja", null},
                {"Limon", null},
                {"Lima", null}
            },
            new String [] {
                "3 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Fruit4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Fruit4KeyReleased(evt);
            }
        });
        jScrollPane43.setViewportView(Fruit4);

        SourFer4.setBackground(new java.awt.Color(255, 255, 153));
        SourFer4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Acido", null},
                {"Arom-acido", null},
                {"Acido-acét", null},
                {"Acido-butí", null},
                {"Acido-isoc", null},
                {"Acido-cítr", null},
                {"Acido-máli", null},
                {"Alcoh/Ferm", null},
                {"Vinoso", null},
                {"Whisky", null},
                {"Fermentado", null},
                {"Super-madu", null}
            },
            new String [] {
                "4 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SourFer4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SourFer4KeyReleased(evt);
            }
        });
        jScrollPane44.setViewportView(SourFer4);

        GreenVeg4.setBackground(new java.awt.Color(102, 255, 102));
        GreenVeg4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Verde/Vegetal", null},
                {"Aceit-Oliv", null},
                {"Crudo", null},
                {"Verde/Vege", null},
                {"Inmaduro", null},
                {"Vaina", null},
                {"Fresco", null},
                {"Verde-oscu", null},
                {"Vegetal", null},
                {"Paja", null},
                {"Herbaceo", null},
                {"Leguminoso", null}
            },
            new String [] {
                "5 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GreenVeg4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GreenVeg4KeyReleased(evt);
            }
        });
        jScrollPane45.setViewportView(GreenVeg4);

        Body1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Ligero", null},
                {"Medio", null},
                {"Pesado", null},
                {"Jarabe", null},
                {"Aceitoso", null},
                {"Suave", null}
            },
            new String [] {
                "Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Body1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Body1KeyReleased(evt);
            }
        });
        jScrollPane46.setViewportView(Body1);

        Finish1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Corto", null},
                {"Medio", null},
                {"Largo", null},
                {"Seco", null},
                {"Astringente", null}
            },
            new String [] {
                "Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Finish1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Finish1KeyReleased(evt);
            }
        });
        jScrollPane47.setViewportView(Finish1);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane41, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane42, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane43, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane44, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane45, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane46, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane47, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane46, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane47, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane44, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jScrollPane41, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane42, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane43, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        jTabbedPane1.addTab("Sabor Remanente", jPanel14);

        SourFer5.setBackground(new java.awt.Color(255, 255, 153));
        SourFer5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Acido", null},
                {"Arom-acido", null},
                {"Acido-acét", null},
                {"Acido-butí", null},
                {"Acido-isoc", null},
                {"Acido-cítr", null},
                {"Acido-máli", null},
                {"Alcoh/Ferm", null},
                {"Vinoso", null},
                {"Whisky", null},
                {"Fermentado", null},
                {"Super-madu", null}
            },
            new String [] {
                "4 Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SourFer5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SourFer5KeyReleased(evt);
            }
        });
        jScrollPane48.setViewportView(SourFer5);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane48, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addGap(921, 921, 921))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane48, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(188, 188, 188))
        );

        jTabbedPane1.addTab("Acidez", jPanel15);

        Body2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Ligero", null},
                {"Medio", null},
                {"Pesado", null},
                {"Jarabe", null},
                {"Aceitoso", null},
                {"Suave", null}
            },
            new String [] {
                "Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Body2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Body2KeyReleased(evt);
            }
        });
        jScrollPane54.setViewportView(Body2);

        Finish2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Corto", null},
                {"Medio", null},
                {"Largo", null},
                {"Seco", null},
                {"Astringent", null}
            },
            new String [] {
                "Cualidades", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Finish2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Finish2KeyReleased(evt);
            }
        });
        jScrollPane55.setViewportView(Finish2);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane54, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane55, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(772, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane54, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane55, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(285, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cuerpo", jPanel16);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Puntuación");

        lblPuntuacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPuntuacion.setForeground(new java.awt.Color(0, 0, 204));
        lblPuntuacion.setText("0.00");

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel57.setText("Seco");

        jLabel58.setText("Mojado");

        jLabel59.setText("Quebrado");

        lblSeco.setText("-");

        lblMojado.setText("-");

        lblQuebrado.setText("-");

        jLabel60.setText("Sabor");

        lblSabor.setText("-");

        jLabel61.setText("Remanente");

        lblRemanente.setText("-");

        jLabel62.setText("Acidez");

        lblAcidez.setText("-");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Olores");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Sabores");

        jLabel37.setText("Cuerpo");

        lblCuerpo.setText("-");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel61)
                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel24)
                    .addComponent(jLabel34)
                    .addComponent(jLabel37))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(lblCuerpo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblQuebrado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMojado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSeco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSabor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRemanente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAcidez, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(lblSeco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(lblMojado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(lblQuebrado))
                .addGap(18, 18, 18)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel60)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel61)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel62))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(lblSabor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRemanente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAcidez)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(lblCuerpo))
                .addContainerGap())
        );

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Cualidades");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel33))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel18))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(lblPuntuacion))
                        .addGap(76, 76, 76)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1120, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void slSecoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slSecoStateChanged
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(this, slSeco.getValue());
        Double valor = Double.parseDouble(slSeco.getValue() + "");
        Double valor2 = valor / 100;

        if (valor2 >= 4.0 && valor < 5.0) {
            valor2 = 4.5;
        }
        if (valor2 >= 6.0 && valor < 6.5) {
            valor2 = 6.0;
        }

        txtSeco.setText(valor2 + "");
        promedio();
    }//GEN-LAST:event_slSecoStateChanged

    private void btnMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosActionPerformed
        // TODO add your handling code here:
        slSeco.setValue(slSeco.getValue() - 50);
        promedio();
        formula();
    }//GEN-LAST:event_btnMenosActionPerformed

    private void btnMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasActionPerformed
        // TODO add your handling code here:
        slSeco.setValue(slSeco.getValue() + 50);
        promedio();
        formula();
    }//GEN-LAST:event_btnMasActionPerformed

    private void slMojadoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slMojadoStateChanged
        // TODO add your handling code here:
        Double valor = Double.parseDouble(slMojado.getValue() + "");
        Double valor2 = valor / 100;
        txtMojado.setText(valor2 + "");
        promedio();
    }//GEN-LAST:event_slMojadoStateChanged

    private void slQuebradoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slQuebradoStateChanged
        // TODO add your handling code here:
        Double valor = Double.parseDouble(slQuebrado.getValue() + "");
        Double valor2 = valor / 100;
        txtQuebrado.setText(valor2 + "");
        promedio();
    }//GEN-LAST:event_slQuebradoStateChanged

    private void btnMenos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenos2ActionPerformed
        // TODO add your handling code here:
        slMojado.setValue(slMojado.getValue() - 50);
        promedio();
        formula();
    }//GEN-LAST:event_btnMenos2ActionPerformed

    private void btnMas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMas2ActionPerformed
        // TODO add your handling code here:
        slMojado.setValue(slMojado.getValue() + 50);
        promedio();
        formula();
    }//GEN-LAST:event_btnMas2ActionPerformed

    private void btnMenos3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenos3ActionPerformed
        // TODO add your handling code here:
        slQuebrado.setValue(slQuebrado.getValue() - 50);
        promedio();
        formula();
    }//GEN-LAST:event_btnMenos3ActionPerformed

    private void btnMas3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMas3ActionPerformed
        // TODO add your handling code here:
        slQuebrado.setValue(slQuebrado.getValue() + 50);
        promedio();
        formula();
    }//GEN-LAST:event_btnMas3ActionPerformed

    private void slSaborStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slSaborStateChanged
        // TODO add your handling code here:
        Double valor = Double.parseDouble(slSabor.getValue() + "");
        Double valor2 = valor / 100;
        txtSabor.setText(valor2 + "");
    }//GEN-LAST:event_slSaborStateChanged

    private void slAftertasteStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slAftertasteStateChanged
        // TODO add your handling code here:
        Double valor = Double.parseDouble(slAftertaste.getValue() + "");
        Double valor2 = valor / 100;
        txtAftertaste.setText(valor2 + "");
    }//GEN-LAST:event_slAftertasteStateChanged

    private void slAcidezStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slAcidezStateChanged
        // TODO add your handling code here:
        Double valor = Double.parseDouble(slAcidez.getValue() + "");
        Double valor2 = valor / 100;
        txtAcidez.setText(valor2 + "");
    }//GEN-LAST:event_slAcidezStateChanged

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        slSabor.setValue(slSabor.getValue() - 50);
        promedio();
        formula();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        slSabor.setValue(slSabor.getValue() + 50);
        promedio();
        formula();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        slAftertaste.setValue(slAftertaste.getValue() - 50);
        promedio();
        formula();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        slAftertaste.setValue(slAftertaste.getValue() + 50);
        promedio();
        formula();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        slAcidez.setValue(slAcidez.getValue() - 50);
        promedio();
        formula();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        slAcidez.setValue(slAcidez.getValue() + 50);
        promedio();
        formula();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void slCuerpoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slCuerpoStateChanged
        // TODO add your handling code here:
        Double valor = Double.parseDouble(slCuerpo.getValue() + "");
        Double valor2 = valor / 100;
        txtCuerpo.setText(valor2 + "");
    }//GEN-LAST:event_slCuerpoStateChanged

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        slCuerpo.setValue(slCuerpo.getValue() - 50);
        promedio();
        formula();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        slCuerpo.setValue(slCuerpo.getValue() + 50);
        promedio();
        formula();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void slBalanceStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slBalanceStateChanged
        // TODO add your handling code here:
        Double valor = Double.parseDouble(slBalance.getValue() + "");
        Double valor2 = valor / 100;
        txtBalance.setText(valor2 + "");
    }//GEN-LAST:event_slBalanceStateChanged

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        slBalance.setValue(slBalance.getValue() - 50);
        promedio();
        formula();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        slBalance.setValue(slBalance.getValue() + 50);
        promedio();
        formula();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void slCatadorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slCatadorStateChanged
        // TODO add your handling code here:
        Double valor = Double.parseDouble(slCatador.getValue() + "");
        Double valor2 = valor / 100;
        txtCatador.setText(valor2 + "");
    }//GEN-LAST:event_slCatadorStateChanged

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        slCatador.setValue(slCatador.getValue() - 50);
        promedio();
        formula();
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        slCatador.setValue(slCatador.getValue() + 50);
        promedio();
        formula();
    }//GEN-LAST:event_jButton21ActionPerformed

    private void txtNoTazasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoTazasKeyTyped
        // TODO add your handling code here:
        char m = evt.getKeyChar();
        if (Character.isAlphabetic(m)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNoTazasKeyTyped

    private void txtUniTazaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUniTazaKeyTyped
        // TODO add your handling code here:
        char m = evt.getKeyChar();
        if (Character.isAlphabetic(m)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtUniTazaKeyTyped

    private void txtTazaLimKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTazaLimKeyTyped
        // TODO add your handling code here:
        char m = evt.getKeyChar();
        if (Character.isAlphabetic(m)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTazaLimKeyTyped

    private void txtDulzorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDulzorKeyTyped
        // TODO add your handling code here:
        char m = evt.getKeyChar();
        if (Character.isAlphabetic(m)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtDulzorKeyTyped

    private void txtIntensidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIntensidadKeyTyped
        // TODO add your handling code here:
        char m = evt.getKeyChar();
        if (Character.isAlphabetic(m)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtIntensidadKeyTyped

    private void txtNoTazasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoTazasKeyReleased
        // TODO add your handling code here:
        l1 = Integer.parseInt(txtNoTazas.getText());
        l2 = Integer.parseInt(txtIntensidad.getText());
        totalD = l1 * l2;
        txtDefectos.setText(formato.format(totalD) + "");

    }//GEN-LAST:event_txtNoTazasKeyReleased

    private void txtIntensidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIntensidadKeyReleased
        // TODO add your handling code here:
        l1 = Integer.parseInt(txtNoTazas.getText());
        l2 = Integer.parseInt(txtIntensidad.getText());
        totalD = l1 * l2;
        txtDefectos.setText(formato.format(totalD) + "");
    }//GEN-LAST:event_txtIntensidadKeyReleased

    private void txtUniTazaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUniTazaKeyReleased
        // TODO add your handling code here:
        formula();
    }//GEN-LAST:event_txtUniTazaKeyReleased

    private void txtTazaLimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTazaLimKeyReleased
        // TODO add your handling code here:
        formula();
    }//GEN-LAST:event_txtTazaLimKeyReleased

    private void txtDulzorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDulzorKeyReleased
        // TODO add your handling code here:
        formula();
    }//GEN-LAST:event_txtDulzorKeyReleased

    private void slNivelTostadoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slNivelTostadoStateChanged
        // TODO add your handling code here:
        System.out.println(slNivelTostado.getValue());
    }//GEN-LAST:event_slNivelTostadoStateChanged

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_jButton1MouseClicked

    private void txtDefectosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDefectosKeyReleased
        // TODO add your handling code here:
        formula();
    }//GEN-LAST:event_txtDefectosKeyReleased

    private void txtTazasCatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTazasCatKeyReleased
        // TODO add your handling code here:
        formula();
    }//GEN-LAST:event_txtTazasCatKeyReleased
    String sSeco = "";
    String sMojado = "";
    String sQuebrado = "";
    String sSabor = "";
    String sRemanente = "";
    String sAcidez = "";
    String sCuerpo = "";
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SourFer5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SourFer5KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = SourFer5.getValueAt(SourFer5.getSelectedRow(), 0) + "";
        intensidad = SourFer5.getValueAt(SourFer5.getSelectedRow(), 1) + "";

        sAcidez += sabor + intensidad + " ";

        lblAcidez.setText(sAcidez);
    }//GEN-LAST:event_SourFer5KeyReleased

    private void Finish1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Finish1KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Finish1.getValueAt(Finish1.getSelectedRow(), 0) + "";
        intensidad = Finish1.getValueAt(Finish1.getSelectedRow(), 1) + "";

        sRemanente += sabor + intensidad + " ";

        lblRemanente.setText(sRemanente);
    }//GEN-LAST:event_Finish1KeyReleased

    private void Body1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Body1KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Body1.getValueAt(Body1.getSelectedRow(), 0) + "";
        intensidad = Body1.getValueAt(Body1.getSelectedRow(), 1) + "";

        sRemanente += sabor + intensidad + " ";

        lblRemanente.setText(sRemanente);
    }//GEN-LAST:event_Body1KeyReleased

    private void GreenVeg4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GreenVeg4KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = GreenVeg4.getValueAt(GreenVeg4.getSelectedRow(), 0) + "";
        intensidad = GreenVeg4.getValueAt(GreenVeg4.getSelectedRow(), 1) + "";

        sRemanente += sabor + intensidad + " ";

        lblRemanente.setText(sRemanente);
    }//GEN-LAST:event_GreenVeg4KeyReleased

    private void SourFer4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SourFer4KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = SourFer4.getValueAt(SourFer4.getSelectedRow(), 0) + "";
        intensidad = SourFer4.getValueAt(SourFer4.getSelectedRow(), 1) + "";

        sRemanente += sabor + intensidad + " ";

        lblRemanente.setText(sRemanente);
    }//GEN-LAST:event_SourFer4KeyReleased

    private void Fruit4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Fruit4KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Fruit4.getValueAt(Fruit4.getSelectedRow(), 0) + "";
        intensidad = Fruit4.getValueAt(Fruit4.getSelectedRow(), 1) + "";

        sRemanente += sabor + intensidad + " ";

        lblRemanente.setText(sRemanente);
    }//GEN-LAST:event_Fruit4KeyReleased

    private void Floral4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Floral4KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Floral4.getValueAt(Floral4.getSelectedRow(), 0) + "";
        intensidad = Floral4.getValueAt(Floral4.getSelectedRow(), 1) + "";

        sRemanente += sabor + intensidad + " ";

        lblRemanente.setText(sRemanente);
    }//GEN-LAST:event_Floral4KeyReleased

    private void Sweet4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Sweet4KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Sweet4.getValueAt(Sweet4.getSelectedRow(), 0) + "";
        intensidad = Sweet4.getValueAt(Sweet4.getSelectedRow(), 1) + "";

        sRemanente += sabor + intensidad + " ";

        lblRemanente.setText(sRemanente);
    }//GEN-LAST:event_Sweet4KeyReleased

    private void Nutty3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Nutty3KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Nutty3.getValueAt(Nutty3.getSelectedRow(), 0) + "";
        intensidad = Nutty3.getValueAt(Nutty3.getSelectedRow(), 1) + "";

        sSabor += sabor + intensidad + " ";

        lblSabor.setText(sSabor);
    }//GEN-LAST:event_Nutty3KeyReleased

    private void Spices3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Spices3KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Spices3.getValueAt(Spices3.getSelectedRow(), 0) + "";
        intensidad = Spices3.getValueAt(Spices3.getSelectedRow(), 1) + "";

        sSabor += sabor + intensidad + " ";

        lblSabor.setText(sSabor);
    }//GEN-LAST:event_Spices3KeyReleased

    private void Roasted3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Roasted3KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Roasted3.getValueAt(Roasted3.getSelectedRow(), 0) + "";
        intensidad = Roasted3.getValueAt(Roasted3.getSelectedRow(), 1) + "";

        sSabor += sabor + intensidad + " ";

        lblSabor.setText(sSabor);
    }//GEN-LAST:event_Roasted3KeyReleased

    private void Other3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Other3KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Other3.getValueAt(Other3.getSelectedRow(), 0) + "";
        intensidad = Other3.getValueAt(Other3.getSelectedRow(), 1) + "";

        sSabor += sabor + intensidad + " ";

        lblSabor.setText(sSabor);
    }//GEN-LAST:event_Other3KeyReleased

    private void GreenVeg3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GreenVeg3KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = GreenVeg3.getValueAt(GreenVeg3.getSelectedRow(), 0) + "";
        intensidad = GreenVeg3.getValueAt(GreenVeg3.getSelectedRow(), 1) + "";

        sSabor += sabor + intensidad + " ";

        lblSabor.setText(sSabor);
    }//GEN-LAST:event_GreenVeg3KeyReleased

    private void SourFer3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SourFer3KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = SourFer3.getValueAt(SourFer3.getSelectedRow(), 0) + "";
        intensidad = SourFer3.getValueAt(SourFer3.getSelectedRow(), 1) + "";

        sSabor += sabor + intensidad + " ";

        lblSabor.setText(sSabor);
    }//GEN-LAST:event_SourFer3KeyReleased

    private void Fruit3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Fruit3KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Fruit3.getValueAt(Fruit3.getSelectedRow(), 0) + "";
        intensidad = Fruit3.getValueAt(Fruit3.getSelectedRow(), 1) + "";

        sSabor += sabor + intensidad + " ";

        lblSabor.setText(sSabor);
    }//GEN-LAST:event_Fruit3KeyReleased

    private void Floral3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Floral3KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Floral3.getValueAt(Floral3.getSelectedRow(), 0) + "";
        intensidad = Floral3.getValueAt(Floral3.getSelectedRow(), 1) + "";

        sSabor += sabor + intensidad + " ";

        lblSabor.setText(sSabor);
    }//GEN-LAST:event_Floral3KeyReleased

    private void Sweet3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Sweet3KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Sweet3.getValueAt(Sweet3.getSelectedRow(), 0) + "";
        intensidad = Sweet3.getValueAt(Sweet3.getSelectedRow(), 1) + "";

        sSabor += sabor + intensidad + " ";

        lblSabor.setText(sSabor);
    }//GEN-LAST:event_Sweet3KeyReleased

    private void Nutty2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Nutty2KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Nutty2.getValueAt(Nutty2.getSelectedRow(), 0) + "";
        intensidad = Nutty2.getValueAt(Nutty2.getSelectedRow(), 1) + "";

        sQuebrado += sabor + intensidad + " ";

        lblQuebrado.setText(sQuebrado);
    }//GEN-LAST:event_Nutty2KeyReleased

    private void Spices2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Spices2KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Spices2.getValueAt(Spices2.getSelectedRow(), 0) + "";
        intensidad = Spices2.getValueAt(Spices2.getSelectedRow(), 1) + "";

        sQuebrado += sabor + intensidad + " ";

        lblQuebrado.setText(sQuebrado);
    }//GEN-LAST:event_Spices2KeyReleased

    private void Roasted2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Roasted2KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Roasted2.getValueAt(Roasted2.getSelectedRow(), 0) + "";
        intensidad = Roasted2.getValueAt(Roasted2.getSelectedRow(), 1) + "";

        sQuebrado += sabor + intensidad + " ";

        lblQuebrado.setText(sQuebrado);
    }//GEN-LAST:event_Roasted2KeyReleased

    private void Other2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Other2KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Other2.getValueAt(Other2.getSelectedRow(), 0) + "";
        intensidad = Other2.getValueAt(Other2.getSelectedRow(), 1) + "";

        sQuebrado += sabor + intensidad + " ";

        lblQuebrado.setText(sQuebrado);
    }//GEN-LAST:event_Other2KeyReleased

    private void GreenVeg2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GreenVeg2KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = GreenVeg2.getValueAt(GreenVeg2.getSelectedRow(), 0) + "";
        intensidad = GreenVeg2.getValueAt(GreenVeg2.getSelectedRow(), 1) + "";

        sQuebrado += sabor + intensidad + " ";

        lblQuebrado.setText(sQuebrado);
    }//GEN-LAST:event_GreenVeg2KeyReleased

    private void SourFer2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SourFer2KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = SourFer2.getValueAt(SourFer2.getSelectedRow(), 0) + "";
        intensidad = SourFer2.getValueAt(SourFer2.getSelectedRow(), 1) + "";

        sQuebrado += sabor + intensidad + " ";

        lblQuebrado.setText(sQuebrado);
    }//GEN-LAST:event_SourFer2KeyReleased

    private void Fruit2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Fruit2KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Fruit2.getValueAt(Fruit2.getSelectedRow(), 0) + "";
        intensidad = Fruit2.getValueAt(Fruit2.getSelectedRow(), 1) + "";

        sQuebrado += sabor + intensidad + " ";

        lblQuebrado.setText(sQuebrado);
    }//GEN-LAST:event_Fruit2KeyReleased

    private void Floral2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Floral2KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Floral2.getValueAt(Floral2.getSelectedRow(), 0) + "";
        intensidad = Floral2.getValueAt(Floral2.getSelectedRow(), 1) + "";

        sQuebrado += sabor + intensidad + " ";

        lblQuebrado.setText(sQuebrado);
    }//GEN-LAST:event_Floral2KeyReleased

    private void Sweet2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Sweet2KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Sweet2.getValueAt(Sweet2.getSelectedRow(), 0) + "";
        intensidad = Sweet2.getValueAt(Sweet2.getSelectedRow(), 1) + "";

        sQuebrado += sabor + intensidad + " ";

        lblQuebrado.setText(sQuebrado);
    }//GEN-LAST:event_Sweet2KeyReleased

    private void Nutty1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Nutty1KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Nutty1.getValueAt(Nutty1.getSelectedRow(), 0) + "";
        intensidad = Nutty1.getValueAt(Nutty1.getSelectedRow(), 1) + "";

        sMojado += sabor + intensidad + " ";

        lblMojado.setText(sMojado);
    }//GEN-LAST:event_Nutty1KeyReleased

    private void Spices1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Spices1KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Spices1.getValueAt(Spices1.getSelectedRow(), 0) + "";
        intensidad = Spices1.getValueAt(Spices1.getSelectedRow(), 1) + "";

        sMojado += sabor + intensidad + " ";

        lblMojado.setText(sMojado);
    }//GEN-LAST:event_Spices1KeyReleased

    private void Roasted1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Roasted1KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Roasted1.getValueAt(Roasted1.getSelectedRow(), 0) + "";
        intensidad = Roasted1.getValueAt(Roasted1.getSelectedRow(), 1) + "";

        sMojado += sabor + intensidad + " ";

        lblMojado.setText(sMojado);
    }//GEN-LAST:event_Roasted1KeyReleased

    private void Other1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Other1KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Other1.getValueAt(Other1.getSelectedRow(), 0) + "";
        intensidad = Other1.getValueAt(Other1.getSelectedRow(), 1) + "";

        sMojado += sabor + intensidad + " ";

        lblMojado.setText(sMojado);
    }//GEN-LAST:event_Other1KeyReleased

    private void GreenVeg1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GreenVeg1KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = GreenVeg1.getValueAt(GreenVeg1.getSelectedRow(), 0) + "";
        intensidad = GreenVeg1.getValueAt(GreenVeg1.getSelectedRow(), 1) + "";

        sMojado += sabor + intensidad + " ";

        lblMojado.setText(sMojado);
    }//GEN-LAST:event_GreenVeg1KeyReleased

    private void SourFer1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SourFer1KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = SourFer1.getValueAt(SourFer1.getSelectedRow(), 0) + "";
        intensidad = SourFer1.getValueAt(SourFer1.getSelectedRow(), 1) + "";

        sMojado += sabor + intensidad + " ";

        lblMojado.setText(sMojado);
    }//GEN-LAST:event_SourFer1KeyReleased

    private void Fruit1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Fruit1KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Fruit1.getValueAt(Fruit1.getSelectedRow(), 0) + "";
        intensidad = Fruit1.getValueAt(Fruit1.getSelectedRow(), 1) + "";

        sMojado += sabor + intensidad + " ";

        lblMojado.setText(sMojado);
    }//GEN-LAST:event_Fruit1KeyReleased

    private void Floral1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Floral1KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Floral1.getValueAt(Floral1.getSelectedRow(), 0) + "";
        intensidad = Floral1.getValueAt(Floral1.getSelectedRow(), 1) + "";

        sMojado += sabor + intensidad + " ";

        lblMojado.setText(sMojado);
    }//GEN-LAST:event_Floral1KeyReleased

    private void Sweet1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Sweet1KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Sweet1.getValueAt(Sweet1.getSelectedRow(), 0) + "";
        intensidad = Sweet1.getValueAt(Sweet1.getSelectedRow(), 1) + "";

        sMojado += sabor + intensidad + " ";

        lblMojado.setText(sMojado);
    }//GEN-LAST:event_Sweet1KeyReleased

    private void NuttyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NuttyKeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Nutty.getValueAt(Nutty.getSelectedRow(), 0) + "";
        intensidad = Nutty.getValueAt(Nutty.getSelectedRow(), 1) + "";

        sSeco += sabor + intensidad + " ";

        lblSeco.setText(sSeco);
    }//GEN-LAST:event_NuttyKeyReleased

    private void SpicesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SpicesKeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Spices.getValueAt(Spices.getSelectedRow(), 0) + "";
        intensidad = Spices.getValueAt(Spices.getSelectedRow(), 1) + "";

        sSeco += sabor + intensidad + " ";

        lblSeco.setText(sSeco);
    }//GEN-LAST:event_SpicesKeyReleased

    private void RoastedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RoastedKeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Roasted.getValueAt(Roasted.getSelectedRow(), 0) + "";
        intensidad = Roasted.getValueAt(Roasted.getSelectedRow(), 1) + "";

        sSeco += sabor + intensidad + " ";

        lblSeco.setText(sSeco);
    }//GEN-LAST:event_RoastedKeyReleased

    private void OtherKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_OtherKeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Other.getValueAt(Other.getSelectedRow(), 0) + "";
        intensidad = Other.getValueAt(Other.getSelectedRow(), 1) + "";

        sSeco += sabor + intensidad + " ";

        lblSeco.setText(sSeco);
    }//GEN-LAST:event_OtherKeyReleased

    private void GreenVegKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GreenVegKeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = GreenVeg.getValueAt(GreenVeg.getSelectedRow(), 0) + "";
        intensidad = GreenVeg.getValueAt(GreenVeg.getSelectedRow(), 1) + "";

        sSeco += sabor + intensidad + " ";

        lblSeco.setText(sSeco);
    }//GEN-LAST:event_GreenVegKeyReleased

    private void SourFerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SourFerKeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = SourFer.getValueAt(SourFer.getSelectedRow(), 0) + "";
        intensidad = SourFer.getValueAt(SourFer.getSelectedRow(), 1) + "";

        sSeco += sabor + intensidad + " ";

        lblSeco.setText(sSeco);
    }//GEN-LAST:event_SourFerKeyReleased

    private void FruitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FruitKeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Fruit.getValueAt(Fruit.getSelectedRow(), 0) + "";
        intensidad = Fruit.getValueAt(Fruit.getSelectedRow(), 1) + "";

        if (!intensidad.equals("") || intensidad != null) {
            sSeco += sabor + intensidad + " ";
        }

        lblSeco.setText(sSeco);
    }//GEN-LAST:event_FruitKeyReleased

    private void FloralKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FloralKeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Floral.getValueAt(Floral.getSelectedRow(), 0) + "";
        intensidad = Floral.getValueAt(Floral.getSelectedRow(), 1) + "";

        if (!intensidad.equals("") || intensidad != null) {
            sSeco += sabor + intensidad + " ";
        }

        lblSeco.setText(sSeco);
    }//GEN-LAST:event_FloralKeyReleased

    //String sabor = "", intensidad = "";
    private void SweetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SweetKeyReleased
        // TODO add your handling code here:
        //VALIDAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAR
        String sabor = "", intensidad = "";
        sabor = Sweet.getValueAt(Sweet.getSelectedRow(), 0) + "";
        intensidad = Sweet.getValueAt(Sweet.getSelectedRow(), 1) + "";

        if (!intensidad.equals("") || intensidad != null) {
            sSeco += sabor + intensidad + " ";
        }

        lblSeco.setText(sSeco);
    }//GEN-LAST:event_SweetKeyReleased

    private void SweetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SweetMouseClicked
        // TODO add your handling code here:
        /*        sabor = Sweet.getValueAt(Sweet.getSelectedRow(), 0) + "";
        intensidad = Sweet.getValueAt(Sweet.getSelectedRow(), 1) + "";*/
    }//GEN-LAST:event_SweetMouseClicked

    private void Body2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Body2KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Body2.getValueAt(Body2.getSelectedRow(), 0) + "";
        intensidad = Body2.getValueAt(Body2.getSelectedRow(), 1) + "";

        sCuerpo += sabor + intensidad + " ";

        lblCuerpo.setText(sCuerpo);
    }//GEN-LAST:event_Body2KeyReleased

    private void Finish2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Finish2KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Finish2.getValueAt(Finish2.getSelectedRow(), 0) + "";
        intensidad = Finish2.getValueAt(Finish2.getSelectedRow(), 1) + "";

        sCuerpo += sabor + intensidad + " ";

        lblCuerpo.setText(sCuerpo);
    }//GEN-LAST:event_Finish2KeyReleased

    String cadenaSabores = "", cadenaOlores = "";

    public void guardar() {
        cadenaSabores = "Sabor: " + lblSabor.getText() + ", Sabor Remanente: " + lblRemanente.getText() + ", Acidez: " + lblAcidez.getText();

        cadenaOlores = "Seco: " + lblSeco.getText() + ", Mojado: " + lblMojado.getText() + ", Quebrado: " + lblQuebrado.getText();

        JOptionPane.showMessageDialog(null, "Sabores: " + cadenaSabores + "\nOlores: " + cadenaOlores);
        String fecha = null;
        if (txtFecha.getDate() != null) {
            fecha = new SimpleDateFormat("dd-MMM-yyyy").format(txtFecha.getDate());
        }
        //slNivelTostado.getValue();
        String estatus = "T";
        String aspecto = mdb.devuelveUnDato("select aspecto from bitacoralab "
                + "where (id_muestra='" + lblCSM.getText() + "' and comunidad='" + lblComunidad.getText() + "')");
        if (aspecto.equals("1")) {
            estatus = "Disp";
        }
        if (fecha != null) {
            try {

                mdb.insertarBasicos("insert into catacion values "
                        + "(null," + id + "," + slNivelTostado.getValue() + "," + slUniTostado.getValue() + ","
                        + Quakers.getText() + ",'" + lblPuntuacion.getText() + "'," + txtTazasCat.getText() + ","
                        + txtDefectos.getText() + "," + txtNoTazas.getText() + "," + txtIntensidad.getText() + ","
                        + txtUniTaza.getText() + "," + txtTazaLim.getText() + "," + txtDulzor.getText() + ",'"
                        + txtSeco.getText() + "','" + txtMojado.getText() + "','" + txtQuebrado.getText() + "','"
                        + lblFragancia.getText() + "','" + txtSabor.getText() + "','" + txtAftertaste.getText() + "','"
                        + txtAcidez.getText() + "','" + spAcidezInt.getValue() + "','" + txtCuerpo.getText() + "','"
                        + spCuerpoInt.getValue() + "','" + txtBalance.getText() + "','"
                        + txtCatador.getText() + "','Consenso','" + fecha + "','" + lblDenTos.getText() + "')");

                mdb.actualizarBasicos("update bitacoralab set taza='1', "
                        + "sabores= '" + cadenaSabores + "', olores='" + cadenaOlores + "' where id_bitacora=" + id);
                //jpCT.llenarTabla();
                this.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e + "Error try");
            }
        } else {
            JOptionPane.showMessageDialog(null, "¡Selecciona La Fecha!");
        }
    }

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
            java.util.logging.Logger.getLogger(jdCatacion2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdCatacion2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdCatacion2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdCatacion2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
 /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jdCatacion().setVisible(true);
            }
        //</editor-fold>

        /* Create and display the form */
 /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jdCatacion().setVisible(true);
            }
        //</editor-fold>

        /* Create and display the form */
 /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jdCatacion().setVisible(true);
            }
        //</editor-fold>

        /* Create and display the form */
 /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jdCatacion().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Body1;
    private javax.swing.JTable Body2;
    private javax.swing.JTable Finish1;
    private javax.swing.JTable Finish2;
    private javax.swing.JTable Floral;
    private javax.swing.JTable Floral1;
    private javax.swing.JTable Floral2;
    private javax.swing.JTable Floral3;
    private javax.swing.JTable Floral4;
    private javax.swing.JTable Fruit;
    private javax.swing.JTable Fruit1;
    private javax.swing.JTable Fruit2;
    private javax.swing.JTable Fruit3;
    private javax.swing.JTable Fruit4;
    private javax.swing.JTable GreenVeg;
    private javax.swing.JTable GreenVeg1;
    private javax.swing.JTable GreenVeg2;
    private javax.swing.JTable GreenVeg3;
    private javax.swing.JTable GreenVeg4;
    private javax.swing.JTable Nutty;
    private javax.swing.JTable Nutty1;
    private javax.swing.JTable Nutty2;
    private javax.swing.JTable Nutty3;
    private javax.swing.JTable Other;
    private javax.swing.JTable Other1;
    private javax.swing.JTable Other2;
    private javax.swing.JTable Other3;
    private javax.swing.JTextField Quakers;
    private javax.swing.JTextField Quakers1;
    private javax.swing.JTable Roasted;
    private javax.swing.JTable Roasted1;
    private javax.swing.JTable Roasted2;
    private javax.swing.JTable Roasted3;
    private javax.swing.JTable SourFer;
    private javax.swing.JTable SourFer1;
    private javax.swing.JTable SourFer2;
    private javax.swing.JTable SourFer3;
    private javax.swing.JTable SourFer4;
    private javax.swing.JTable SourFer5;
    private javax.swing.JTable Spices;
    private javax.swing.JTable Spices1;
    private javax.swing.JTable Spices2;
    private javax.swing.JTable Spices3;
    private javax.swing.JTable Sweet;
    private javax.swing.JTable Sweet1;
    private javax.swing.JTable Sweet2;
    private javax.swing.JTable Sweet3;
    private javax.swing.JTable Sweet4;
    private javax.swing.JButton btnMas;
    private javax.swing.JButton btnMas2;
    private javax.swing.JButton btnMas3;
    private javax.swing.JButton btnMenos;
    private javax.swing.JButton btnMenos2;
    private javax.swing.JButton btnMenos3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
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
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane33;
    private javax.swing.JScrollPane jScrollPane34;
    private javax.swing.JScrollPane jScrollPane35;
    private javax.swing.JScrollPane jScrollPane36;
    private javax.swing.JScrollPane jScrollPane37;
    private javax.swing.JScrollPane jScrollPane38;
    private javax.swing.JScrollPane jScrollPane39;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane40;
    private javax.swing.JScrollPane jScrollPane41;
    private javax.swing.JScrollPane jScrollPane42;
    private javax.swing.JScrollPane jScrollPane43;
    private javax.swing.JScrollPane jScrollPane44;
    private javax.swing.JScrollPane jScrollPane45;
    private javax.swing.JScrollPane jScrollPane46;
    private javax.swing.JScrollPane jScrollPane47;
    private javax.swing.JScrollPane jScrollPane48;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane54;
    private javax.swing.JScrollPane jScrollPane55;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lblAcidez;
    private javax.swing.JLabel lblCSM;
    private javax.swing.JLabel lblComunidad;
    private javax.swing.JLabel lblCuerpo;
    private javax.swing.JLabel lblDenTos;
    private javax.swing.JLabel lblFragancia;
    private javax.swing.JLabel lblMojado;
    private javax.swing.JLabel lblProceso;
    private javax.swing.JLabel lblPuntuacion;
    private javax.swing.JLabel lblQuebrado;
    private javax.swing.JLabel lblRemanente;
    private javax.swing.JLabel lblSabor;
    private javax.swing.JLabel lblSeco;
    private javax.swing.JSlider slAcidez;
    private javax.swing.JSlider slAftertaste;
    private javax.swing.JSlider slBalance;
    private javax.swing.JSlider slCatador;
    private javax.swing.JSlider slCuerpo;
    private javax.swing.JSlider slMojado;
    private javax.swing.JSlider slNivelTostado;
    private javax.swing.JSlider slQuebrado;
    private javax.swing.JSlider slSabor;
    private javax.swing.JSlider slSeco;
    private javax.swing.JSlider slUniTostado;
    private javax.swing.JSpinner spAcidezInt;
    private javax.swing.JSpinner spCuerpoInt;
    private javax.swing.JTextField txtAcidez;
    private javax.swing.JTextField txtAftertaste;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtCatador;
    private javax.swing.JTextField txtCuerpo;
    private javax.swing.JTextField txtDefectos;
    private javax.swing.JTextField txtDenTostado1;
    private javax.swing.JTextField txtDulzor;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtIntensidad;
    private javax.swing.JTextField txtMojado;
    private javax.swing.JTextField txtNoTazas;
    private javax.swing.JTextField txtQuebrado;
    private javax.swing.JTextField txtSabor;
    private javax.swing.JTextField txtSeco;
    private javax.swing.JTextField txtTazaLim;
    private javax.swing.JTextField txtTazasCat;
    private javax.swing.JTextField txtUniTaza;
    // End of variables declaration//GEN-END:variables
}
