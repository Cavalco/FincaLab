/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_LaboratorioN;

import Formas_laboratorio.jpBitacora;
import Metodos_Configuraciones.metodosLaboratorio;
import java.awt.Color;
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
        
        if (!txtSaborRemanente.getText().equals("")) {
            c = Double.valueOf(txtSaborRemanente.getText());
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
        total = a + b + c + d + e + f + ((10 / g) * h) + ((10 / g) * i) + ((10 / g) * j) + k - l;
        //total = a + b + c + d + e + f + h + i + j + k - l;

        lblPuntuacion.setText(formato.format(total) + "");
        
        System.out.println("Puntuacion: " + a + " + " + b + " + " + c + " + " + d + " + " + e + " + " + f + " + ((10/" + g + ")  " + h + ") + ((10/g)  " + i + ") + ((10/" + g + ") * " + j + ") + " + k + " - 1");
    }
    
    public Boolean validar() {
        
        if (txtFecha.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Por favor, verifique campos de fecha");
            return false;
        } else if (txtTazasCat.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Ingrese Tazas Catadas");
            return false;
        } else if (txtUniTaza.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Ingrese Uniformidad Taza");
            return false;
        } else if (txtTazaLim.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Ingrese Taza Limpia");
            return false;
        } else if (txtDulzor.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Ingrese Dulzor");
            return false;
        } else if (txtNoTazas.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Ingrese Tazas Malas");
            return false;
        } else if (txtIntensidad.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Ingrese Intensidad");
            return false;
        } else if (txtDefectos.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Ingrese Defectos");
            return false;
        } else {
            return true;
        }
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
        lblDenTos = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lblUniTos = new javax.swing.JLabel();
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
        btnMenos = new javax.swing.JButton();
        txtSeco = new javax.swing.JTextField();
        btnMas = new javax.swing.JButton();
        btnMenos2 = new javax.swing.JButton();
        txtMojado = new javax.swing.JTextField();
        btnMas2 = new javax.swing.JButton();
        btnMenos3 = new javax.swing.JButton();
        txtQuebrado = new javax.swing.JTextField();
        btnMas3 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        txtSabor = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        txtSaborRemanente = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        txtAcidez = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        txtCuerpo = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        spAcidezInt = new javax.swing.JSpinner();
        spCuerpoInt = new javax.swing.JSpinner();
        jButton18 = new javax.swing.JButton();
        txtBalance = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        txtCatador = new javax.swing.JTextField();
        jButton21 = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane54 = new javax.swing.JScrollPane();
        Body2 = new javax.swing.JTable();
        jScrollPane55 = new javax.swing.JScrollPane();
        Finish2 = new javax.swing.JTable();
        jScrollPane73 = new javax.swing.JScrollPane();
        Sweet6 = new javax.swing.JTable();
        jScrollPane74 = new javax.swing.JScrollPane();
        Floral6 = new javax.swing.JTable();
        jScrollPane75 = new javax.swing.JScrollPane();
        Fruit6 = new javax.swing.JTable();
        jScrollPane76 = new javax.swing.JScrollPane();
        SourFer6 = new javax.swing.JTable();
        jScrollPane77 = new javax.swing.JScrollPane();
        GreenVeg6 = new javax.swing.JTable();
        jScrollPane78 = new javax.swing.JScrollPane();
        Other6 = new javax.swing.JTable();
        jScrollPane79 = new javax.swing.JScrollPane();
        Roasted6 = new javax.swing.JTable();
        jScrollPane80 = new javax.swing.JScrollPane();
        Spices6 = new javax.swing.JTable();
        jScrollPane81 = new javax.swing.JScrollPane();
        Nutty6 = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane82 = new javax.swing.JScrollPane();
        Body8 = new javax.swing.JTable();
        jScrollPane83 = new javax.swing.JScrollPane();
        Finish8 = new javax.swing.JTable();
        jScrollPane84 = new javax.swing.JScrollPane();
        Sweet7 = new javax.swing.JTable();
        jScrollPane85 = new javax.swing.JScrollPane();
        Floral7 = new javax.swing.JTable();
        jScrollPane86 = new javax.swing.JScrollPane();
        Fruit7 = new javax.swing.JTable();
        jScrollPane87 = new javax.swing.JScrollPane();
        SourFer7 = new javax.swing.JTable();
        jScrollPane88 = new javax.swing.JScrollPane();
        GreenVeg7 = new javax.swing.JTable();
        jScrollPane89 = new javax.swing.JScrollPane();
        Other7 = new javax.swing.JTable();
        jScrollPane90 = new javax.swing.JScrollPane();
        Roasted7 = new javax.swing.JTable();
        jScrollPane91 = new javax.swing.JScrollPane();
        Spices7 = new javax.swing.JTable();
        jScrollPane92 = new javax.swing.JScrollPane();
        Nutty7 = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane93 = new javax.swing.JScrollPane();
        Body9 = new javax.swing.JTable();
        jScrollPane94 = new javax.swing.JScrollPane();
        Finish9 = new javax.swing.JTable();
        jScrollPane95 = new javax.swing.JScrollPane();
        Sweet8 = new javax.swing.JTable();
        jScrollPane96 = new javax.swing.JScrollPane();
        Floral8 = new javax.swing.JTable();
        jScrollPane97 = new javax.swing.JScrollPane();
        Fruit8 = new javax.swing.JTable();
        jScrollPane98 = new javax.swing.JScrollPane();
        SourFer8 = new javax.swing.JTable();
        jScrollPane99 = new javax.swing.JScrollPane();
        GreenVeg8 = new javax.swing.JTable();
        jScrollPane100 = new javax.swing.JScrollPane();
        Other8 = new javax.swing.JTable();
        jScrollPane101 = new javax.swing.JScrollPane();
        Roasted8 = new javax.swing.JTable();
        jScrollPane102 = new javax.swing.JScrollPane();
        Spices8 = new javax.swing.JTable();
        jScrollPane103 = new javax.swing.JScrollPane();
        Nutty8 = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane104 = new javax.swing.JScrollPane();
        Body10 = new javax.swing.JTable();
        jScrollPane105 = new javax.swing.JScrollPane();
        Finish10 = new javax.swing.JTable();
        jScrollPane106 = new javax.swing.JScrollPane();
        Sweet9 = new javax.swing.JTable();
        jScrollPane107 = new javax.swing.JScrollPane();
        Floral9 = new javax.swing.JTable();
        jScrollPane108 = new javax.swing.JScrollPane();
        Fruit9 = new javax.swing.JTable();
        jScrollPane109 = new javax.swing.JScrollPane();
        SourFer9 = new javax.swing.JTable();
        jScrollPane110 = new javax.swing.JScrollPane();
        GreenVeg9 = new javax.swing.JTable();
        jScrollPane111 = new javax.swing.JScrollPane();
        Other9 = new javax.swing.JTable();
        jScrollPane112 = new javax.swing.JScrollPane();
        Roasted9 = new javax.swing.JTable();
        jScrollPane113 = new javax.swing.JScrollPane();
        Spices9 = new javax.swing.JTable();
        jScrollPane114 = new javax.swing.JScrollPane();
        Nutty9 = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane115 = new javax.swing.JScrollPane();
        Body11 = new javax.swing.JTable();
        jScrollPane116 = new javax.swing.JScrollPane();
        Finish11 = new javax.swing.JTable();
        jScrollPane117 = new javax.swing.JScrollPane();
        Sweet10 = new javax.swing.JTable();
        jScrollPane118 = new javax.swing.JScrollPane();
        Floral10 = new javax.swing.JTable();
        jScrollPane119 = new javax.swing.JScrollPane();
        Fruit10 = new javax.swing.JTable();
        jScrollPane120 = new javax.swing.JScrollPane();
        SourFer10 = new javax.swing.JTable();
        jScrollPane121 = new javax.swing.JScrollPane();
        GreenVeg10 = new javax.swing.JTable();
        jScrollPane122 = new javax.swing.JScrollPane();
        Other10 = new javax.swing.JTable();
        jScrollPane123 = new javax.swing.JScrollPane();
        Roasted10 = new javax.swing.JTable();
        jScrollPane124 = new javax.swing.JScrollPane();
        Spices10 = new javax.swing.JTable();
        jScrollPane125 = new javax.swing.JScrollPane();
        Nutty10 = new javax.swing.JTable();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane137 = new javax.swing.JScrollPane();
        Body13 = new javax.swing.JTable();
        jScrollPane138 = new javax.swing.JScrollPane();
        Finish13 = new javax.swing.JTable();
        jScrollPane139 = new javax.swing.JScrollPane();
        Sweet12 = new javax.swing.JTable();
        jScrollPane140 = new javax.swing.JScrollPane();
        Floral12 = new javax.swing.JTable();
        jScrollPane141 = new javax.swing.JScrollPane();
        Fruit12 = new javax.swing.JTable();
        jScrollPane142 = new javax.swing.JScrollPane();
        SourFer12 = new javax.swing.JTable();
        jScrollPane143 = new javax.swing.JScrollPane();
        GreenVeg12 = new javax.swing.JTable();
        jScrollPane144 = new javax.swing.JScrollPane();
        Other12 = new javax.swing.JTable();
        jScrollPane145 = new javax.swing.JScrollPane();
        Roasted12 = new javax.swing.JTable();
        jScrollPane146 = new javax.swing.JScrollPane();
        Spices12 = new javax.swing.JTable();
        jScrollPane147 = new javax.swing.JScrollPane();
        Nutty12 = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        lblPuntuacion = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        lblSeco = new javax.swing.JLabel();
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
        jSeparator3 = new javax.swing.JSeparator();

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
        jTextField1.setForeground(new java.awt.Color(51, 255, 0));

        slUniTostado.setMajorTickSpacing(1);
        slUniTostado.setMaximum(5);
        slUniTostado.setMinimum(1);
        slUniTostado.setPaintLabels(true);
        slUniTostado.setValue(3);
        slUniTostado.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slUniTostadoStateChanged(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(51, 51, 51));
        jTextField2.setForeground(new java.awt.Color(51, 255, 0));

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(102, 102, 102));
        jTextField3.setForeground(new java.awt.Color(51, 255, 0));

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(153, 153, 153));
        jTextField4.setForeground(new java.awt.Color(51, 255, 0));

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(204, 204, 204));
        jTextField5.setForeground(new java.awt.Color(51, 255, 0));

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

        lblDenTos.setText("-");

        jLabel18.setText("Observaciones");

        jLabel35.setText("Uniformidad Tostado");

        lblUniTos.setText("-");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(slNivelTostado, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(slUniTostado, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addContainerGap()
                        .addComponent(jLabel35)
                        .addGap(14, 14, 14)
                        .addComponent(lblUniTos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Quakers, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblDenTos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(0, 0, Short.MAX_VALUE)))))
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
                    .addComponent(jLabel35)
                    .addComponent(lblUniTos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblDenTos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Quakers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        txtDefectos.setText("0");
        txtDefectos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDefectosKeyReleased(evt);
            }
        });

        jLabel14.setText("Tazas Malas");

        jLabel15.setText("Intensidad");

        txtNoTazas.setText("0");
        txtNoTazas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNoTazasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoTazasKeyTyped(evt);
            }
        });

        txtIntensidad.setText("0");
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addGap(112, 112, 112))
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
                .addContainerGap(13, Short.MAX_VALUE))
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

        btnMenos.setText("-");
        btnMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosActionPerformed(evt);
            }
        });

        txtSeco.setEditable(false);
        txtSeco.setText("7.0");

        btnMas.setText("+");
        btnMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasActionPerformed(evt);
            }
        });

        btnMenos2.setText("-");
        btnMenos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenos2ActionPerformed(evt);
            }
        });

        txtMojado.setEditable(false);
        txtMojado.setText("7.0");

        btnMas2.setText("+");
        btnMas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMas2ActionPerformed(evt);
            }
        });

        btnMenos3.setText("-");
        btnMenos3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenos3ActionPerformed(evt);
            }
        });

        txtQuebrado.setEditable(false);
        txtQuebrado.setText("7.0");

        btnMas3.setText("+");
        btnMas3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMas3ActionPerformed(evt);
            }
        });

        jButton10.setText("-");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        txtSabor.setEditable(false);
        txtSabor.setText("7.0");

        jButton11.setText("+");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("-");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        txtSaborRemanente.setEditable(false);
        txtSaborRemanente.setText("7.0");

        jButton13.setText("+");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("-");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        txtAcidez.setEditable(false);
        txtAcidez.setText("7.0");

        jButton15.setText("+");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("-");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        txtCuerpo.setEditable(false);
        txtCuerpo.setText("7.0");

        jButton17.setText("+");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("-");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        txtBalance.setEditable(false);
        txtBalance.setText("7.0");

        jButton19.setText("+");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setText("-");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        txtCatador.setEditable(false);
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
                                .addGap(66, 66, 66)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCatador, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel22))
                                .addGap(54, 54, 54)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(btnMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSeco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnMas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(btnMenos3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtQuebrado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnMas3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(btnMenos2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMojado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnMas2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel23)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblFragancia, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(18, 18, 18)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSaborRemanente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(69, 69, 69)
                                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCuerpo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel30)
                                .addGap(18, 18, 18)
                                .addComponent(spCuerpoInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(75, 75, 75)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSabor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(73, 73, 73)
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAcidez, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel28)
                                .addGap(18, 18, 18)
                                .addComponent(spAcidezInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 108, Short.MAX_VALUE))
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
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel21)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel22))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMenos)
                            .addComponent(txtSeco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel23)
                                .addComponent(lblFragancia, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnMenos2)
                                .addComponent(txtMojado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnMas2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMenos3)
                            .addComponent(txtQuebrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMas3))))
                .addGap(9, 9, 9)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton10)
                        .addComponent(txtSabor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton12)
                        .addComponent(txtSaborRemanente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton13))
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
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
                        .addComponent(spCuerpoInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton18)
                        .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton19)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton20)
                        .addComponent(txtCatador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton21))
                    .addComponent(jLabel32))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Información");

        Body2.setBackground(new java.awt.Color(204, 204, 204));
        Body2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Peso", null},
                {"Jarabe", null},
                {"Aceitoso", null},
                {"Suave", null}
            },
            new String [] {
                "10 Cuerpo", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Body2.setEnabled(false);
        Body2.setOpaque(false);
        Body2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Body2KeyReleased(evt);
            }
        });
        jScrollPane54.setViewportView(Body2);
        if (Body2.getColumnModel().getColumnCount() > 0) {
            Body2.getColumnModel().getColumn(1).setMinWidth(30);
            Body2.getColumnModel().getColumn(1).setPreferredWidth(30);
            Body2.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Finish2.setBackground(new java.awt.Color(204, 204, 204));
        Finish2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Duración", null},
                {"Seco", null},
                {"Astringent", null},
                {"Granoso", null}
            },
            new String [] {
                "11 Sabor Rem.", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Finish2.setEnabled(false);
        Finish2.setOpaque(false);
        Finish2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Finish2KeyReleased(evt);
            }
        });
        jScrollPane55.setViewportView(Finish2);
        if (Finish2.getColumnModel().getColumnCount() > 0) {
            Finish2.getColumnModel().getColumn(1).setMinWidth(30);
            Finish2.getColumnModel().getColumn(1).setPreferredWidth(30);
            Finish2.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Sweet6.setBackground(new java.awt.Color(255, 102, 102));
        Sweet6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Azúcar-Mor", null},
                {"   Melaza", null},
                {"   Jarab-mapl", null},
                {"   Caramelo", null},
                {"   Miel", null},
                {"Vainilla", null},
                {"Arom-Vaini", null},
                {"Dulce-Gene", null},
                {"Arom-dulce", null}
            },
            new String [] {
                "1 Dulce", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Sweet6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Sweet6KeyReleased(evt);
            }
        });
        jScrollPane73.setViewportView(Sweet6);
        if (Sweet6.getColumnModel().getColumnCount() > 0) {
            Sweet6.getColumnModel().getColumn(1).setMinWidth(30);
            Sweet6.getColumnModel().getColumn(1).setPreferredWidth(30);
            Sweet6.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Floral6.setBackground(new java.awt.Color(255, 153, 102));
        Floral6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Té-Negro", null},
                {"Floral", null},
                {"   Manzanilla", null},
                {"   Rosa", null},
                {"   Jazmine", null}
            },
            new String [] {
                "2 Floral", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Floral6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Floral6KeyReleased(evt);
            }
        });
        jScrollPane74.setViewportView(Floral6);
        if (Floral6.getColumnModel().getColumnCount() > 0) {
            Floral6.getColumnModel().getColumn(1).setMinWidth(30);
            Floral6.getColumnModel().getColumn(1).setPreferredWidth(30);
            Floral6.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Fruit6.setBackground(new java.awt.Color(255, 204, 0));
        Fruit6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Bayas", null},
                {"   Moras", null},
                {"   Frambuesa", null},
                {"   Arándano", null},
                {"   Fresa", null},
                {"Fruto-sec", null},
                {"   Pasas", null},
                {"   Ciruel-pas", null},
                {"Otras-frut", null},
                {"   Coco", null},
                {"   Cereza", null},
                {"   Granada", null},
                {"   Piña", null},
                {"   Uvas", null},
                {"   Manzana", null},
                {"   Durazno", null},
                {"   Pera", null},
                {"Citricos", null},
                {"   Toronja", null},
                {"   Naranja", null},
                {"   Limon", null},
                {"   Lima", null}
            },
            new String [] {
                "3 Afrutado", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Fruit6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Fruit6KeyReleased(evt);
            }
        });
        jScrollPane75.setViewportView(Fruit6);
        if (Fruit6.getColumnModel().getColumnCount() > 0) {
            Fruit6.getColumnModel().getColumn(1).setMinWidth(30);
            Fruit6.getColumnModel().getColumn(1).setPreferredWidth(30);
            Fruit6.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        SourFer6.setBackground(new java.awt.Color(255, 255, 153));
        SourFer6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Acido", null},
                {"   Arom-acido", null},
                {"   Acido-acét", null},
                {"   Acido-butí", null},
                {"   Acido-isoc", null},
                {"   Acido-cítr", null},
                {"   Acido-máli", null},
                {"Alcoh/Ferm", null},
                {"   Vinoso", null},
                {"   Whisky", null},
                {"   Fermentado", null},
                {"   Super-madu", null}
            },
            new String [] {
                "4 Acido/Fermentado", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SourFer6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SourFer6KeyReleased(evt);
            }
        });
        jScrollPane76.setViewportView(SourFer6);
        if (SourFer6.getColumnModel().getColumnCount() > 0) {
            SourFer6.getColumnModel().getColumn(1).setMinWidth(30);
            SourFer6.getColumnModel().getColumn(1).setPreferredWidth(30);
            SourFer6.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        GreenVeg6.setBackground(new java.awt.Color(102, 255, 102));
        GreenVeg6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Aceit-Oliv", null},
                {"Crudo", null},
                {"Verde/Vege", null},
                {"   Inmaduro", null},
                {"   Vaina", null},
                {"   Fresco", null},
                {"   Verde-oscu", null},
                {"   Vegetal", null},
                {"   Paja", null},
                {"   Herbaceo", null},
                {"Leguminoso", null}
            },
            new String [] {
                "5 Verde/Vegetal", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GreenVeg6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GreenVeg6KeyReleased(evt);
            }
        });
        jScrollPane77.setViewportView(GreenVeg6);
        if (GreenVeg6.getColumnModel().getColumnCount() > 0) {
            GreenVeg6.getColumnModel().getColumn(1).setMinWidth(30);
            GreenVeg6.getColumnModel().getColumn(1).setPreferredWidth(30);
            GreenVeg6.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Other6.setBackground(new java.awt.Color(51, 255, 255));
        Other6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Papel/Hume", null},
                {"   Rancio", null},
                {"   Carton", null},
                {"   Papel", null},
                {"   Madera", null},
                {"   Mohoso", null},
                {"   Polvo-hume", null},
                {"   Tierra", null},
                {"   Cuero", null},
                {"   Carne/cald", null},
                {"   Fenolico", null},
                {"Quimico", null},
                {"   Amargo", null},
                {"   Salado", null},
                {"   Medicinal", null},
                {"   Petroleo", null},
                {"   Zorrillo", null},
                {"   Goma", null}
            },
            new String [] {
                "6 Otros", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Other6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Other6KeyReleased(evt);
            }
        });
        jScrollPane78.setViewportView(Other6);
        if (Other6.getColumnModel().getColumnCount() > 0) {
            Other6.getColumnModel().getColumn(1).setMinWidth(30);
            Other6.getColumnModel().getColumn(1).setPreferredWidth(30);
            Other6.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Roasted6.setBackground(new java.awt.Color(0, 204, 255));
        Roasted6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Tabac-pipa", null},
                {"Tabaco", null},
                {"Quemado", null},
                {"   Acre", null},
                {"   Ceniza", null},
                {"   Humo", null},
                {"   Marrón/tos", null},
                {"Cereal", null},
                {"   Grano", null},
                {"   Malta", null}
            },
            new String [] {
                "7 Tostado", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Roasted6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Roasted6KeyReleased(evt);
            }
        });
        jScrollPane79.setViewportView(Roasted6);
        if (Roasted6.getColumnModel().getColumnCount() > 0) {
            Roasted6.getColumnModel().getColumn(1).setMinWidth(30);
            Roasted6.getColumnModel().getColumn(1).setPreferredWidth(30);
            Roasted6.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Spices6.setBackground(new java.awt.Color(153, 153, 255));
        Spices6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Acre", null},
                {"Pimienta", null},
                {"Especias-mo", null},
                {"   Anis", null},
                {"   Nuez-mosca", null},
                {"   Canela", null},
                {"   Clavo-olor", null}
            },
            new String [] {
                "8 Especias", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Spices6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Spices6KeyReleased(evt);
            }
        });
        jScrollPane80.setViewportView(Spices6);
        if (Spices6.getColumnModel().getColumnCount() > 0) {
            Spices6.getColumnModel().getColumn(1).setMinWidth(30);
            Spices6.getColumnModel().getColumn(1).setPreferredWidth(30);
            Spices6.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Nutty6.setBackground(new java.awt.Color(255, 102, 204));
        Nutty6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Nueces", null},
                {"   Mani", null},
                {"   Avellana", null},
                {"   Almendra", null},
                {"Cacao", null},
                {"   Chocolate", null},
                {"   Choc-amarg", null}
            },
            new String [] {
                "9 Nueces/Cacao", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Nutty6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Nutty6KeyReleased(evt);
            }
        });
        jScrollPane81.setViewportView(Nutty6);
        if (Nutty6.getColumnModel().getColumnCount() > 0) {
            Nutty6.getColumnModel().getColumn(1).setMinWidth(30);
            Nutty6.getColumnModel().getColumn(1).setPreferredWidth(30);
            Nutty6.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane74, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane73, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane75, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane76, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane77, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane78, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane80, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane79, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane81, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane54, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane55, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane75, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jScrollPane79, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane80, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane76, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jScrollPane73, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane74, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 58, Short.MAX_VALUE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane77, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(jScrollPane81, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane54, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane55, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane78, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(96, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Seco", jPanel16);

        Body8.setBackground(new java.awt.Color(204, 204, 204));
        Body8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Peso", null},
                {"Jarabe", null},
                {"Aceitoso", null},
                {"Suave", null}
            },
            new String [] {
                "10 Cuerpo", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Body8.setEnabled(false);
        Body8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Body8KeyReleased(evt);
            }
        });
        jScrollPane82.setViewportView(Body8);
        if (Body8.getColumnModel().getColumnCount() > 0) {
            Body8.getColumnModel().getColumn(1).setMinWidth(30);
            Body8.getColumnModel().getColumn(1).setPreferredWidth(30);
            Body8.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Finish8.setBackground(new java.awt.Color(204, 204, 204));
        Finish8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Duración", null},
                {"Seco", null},
                {"Astringent", null},
                {"Granoso", null}
            },
            new String [] {
                "11 Sabor Rem.", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Finish8.setEnabled(false);
        Finish8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Finish8KeyReleased(evt);
            }
        });
        jScrollPane83.setViewportView(Finish8);
        if (Finish8.getColumnModel().getColumnCount() > 0) {
            Finish8.getColumnModel().getColumn(1).setMinWidth(30);
            Finish8.getColumnModel().getColumn(1).setPreferredWidth(30);
            Finish8.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Sweet7.setBackground(new java.awt.Color(255, 102, 102));
        Sweet7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Azúcar-Mor", null},
                {"   Melaza", null},
                {"   Jarab-mapl", null},
                {"   Caramelo", null},
                {"   Miel", null},
                {"Vainilla", null},
                {"Arom-Vaini", null},
                {"Dulce-Gene", null},
                {"Arom-dulce", null}
            },
            new String [] {
                "1 Dulce", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Sweet7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Sweet7KeyReleased(evt);
            }
        });
        jScrollPane84.setViewportView(Sweet7);
        if (Sweet7.getColumnModel().getColumnCount() > 0) {
            Sweet7.getColumnModel().getColumn(1).setMinWidth(30);
            Sweet7.getColumnModel().getColumn(1).setPreferredWidth(30);
            Sweet7.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Floral7.setBackground(new java.awt.Color(255, 153, 102));
        Floral7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Té-Negro", null},
                {"Floral", null},
                {"   Manzanilla", null},
                {"   Rosa", null},
                {"   Jazmine", null}
            },
            new String [] {
                "2 Floral", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Floral7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Floral7KeyReleased(evt);
            }
        });
        jScrollPane85.setViewportView(Floral7);
        if (Floral7.getColumnModel().getColumnCount() > 0) {
            Floral7.getColumnModel().getColumn(1).setMinWidth(30);
            Floral7.getColumnModel().getColumn(1).setPreferredWidth(30);
            Floral7.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Fruit7.setBackground(new java.awt.Color(255, 204, 0));
        Fruit7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Bayas", null},
                {"   Moras", null},
                {"   Frambuesa", null},
                {"   Arándano", null},
                {"   Fresa", null},
                {"Fruto-sec", null},
                {"   Pasas", null},
                {"   Ciruel-pas", null},
                {"Otras-frut", null},
                {"   Coco", null},
                {"   Cereza", null},
                {"   Granada", null},
                {"   Piña", null},
                {"   Uvas", null},
                {"   Manzana", null},
                {"   Durazno", null},
                {"   Pera", null},
                {"Citricos", null},
                {"   Toronja", null},
                {"   Naranja", null},
                {"   Limon", null},
                {"   Lima", null}
            },
            new String [] {
                "3 Afrutado", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Fruit7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Fruit7KeyReleased(evt);
            }
        });
        jScrollPane86.setViewportView(Fruit7);
        if (Fruit7.getColumnModel().getColumnCount() > 0) {
            Fruit7.getColumnModel().getColumn(1).setMinWidth(30);
            Fruit7.getColumnModel().getColumn(1).setPreferredWidth(30);
            Fruit7.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        SourFer7.setBackground(new java.awt.Color(255, 255, 153));
        SourFer7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Acido", null},
                {"   Arom-acido", null},
                {"   Acido-acét", null},
                {"   Acido-butí", null},
                {"   Acido-isoc", null},
                {"   Acido-cítr", null},
                {"   Acido-máli", null},
                {"Alcoh/Ferm", null},
                {"   Vinoso", null},
                {"   Whisky", null},
                {"   Fermentado", null},
                {"   Super-madu", null}
            },
            new String [] {
                "4 Acido/Fermentado", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SourFer7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SourFer7KeyReleased(evt);
            }
        });
        jScrollPane87.setViewportView(SourFer7);
        if (SourFer7.getColumnModel().getColumnCount() > 0) {
            SourFer7.getColumnModel().getColumn(1).setMinWidth(30);
            SourFer7.getColumnModel().getColumn(1).setPreferredWidth(30);
            SourFer7.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        GreenVeg7.setBackground(new java.awt.Color(102, 255, 102));
        GreenVeg7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Aceit-Oliv", null},
                {"Crudo", null},
                {"Verde/Vege", null},
                {"   Inmaduro", null},
                {"   Vaina", null},
                {"   Fresco", null},
                {"   Verde-oscu", null},
                {"   Vegetal", null},
                {"   Paja", null},
                {"   Herbaceo", null},
                {"Leguminoso", null}
            },
            new String [] {
                "5 Verde/Vegetal", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GreenVeg7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GreenVeg7KeyReleased(evt);
            }
        });
        jScrollPane88.setViewportView(GreenVeg7);
        if (GreenVeg7.getColumnModel().getColumnCount() > 0) {
            GreenVeg7.getColumnModel().getColumn(1).setMinWidth(30);
            GreenVeg7.getColumnModel().getColumn(1).setPreferredWidth(30);
            GreenVeg7.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Other7.setBackground(new java.awt.Color(51, 255, 255));
        Other7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Papel/Hume", null},
                {"   Rancio", null},
                {"   Carton", null},
                {"   Papel", null},
                {"   Madera", null},
                {"   Mohoso", null},
                {"   Polvo-hume", null},
                {"   Tierra", null},
                {"   Cuero", null},
                {"   Carne/cald", null},
                {"   Fenolico", null},
                {"Quimico", null},
                {"   Amargo", null},
                {"   Salado", null},
                {"   Medicinal", null},
                {"   Petroleo", null},
                {"   Zorrillo", null},
                {"   Goma", null}
            },
            new String [] {
                "6 Otros", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Other7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Other7KeyReleased(evt);
            }
        });
        jScrollPane89.setViewportView(Other7);
        if (Other7.getColumnModel().getColumnCount() > 0) {
            Other7.getColumnModel().getColumn(1).setMinWidth(30);
            Other7.getColumnModel().getColumn(1).setPreferredWidth(30);
            Other7.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Roasted7.setBackground(new java.awt.Color(0, 204, 255));
        Roasted7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Tabac-pipa", null},
                {"Tabaco", null},
                {"Quemado", null},
                {"   Acre", null},
                {"   Ceniza", null},
                {"   Humo", null},
                {"   Marrón/tos", null},
                {"Cereal", null},
                {"   Grano", null},
                {"   Malta", null}
            },
            new String [] {
                "7 Tostado", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Roasted7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Roasted7KeyReleased(evt);
            }
        });
        jScrollPane90.setViewportView(Roasted7);
        if (Roasted7.getColumnModel().getColumnCount() > 0) {
            Roasted7.getColumnModel().getColumn(1).setMinWidth(30);
            Roasted7.getColumnModel().getColumn(1).setPreferredWidth(30);
            Roasted7.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Spices7.setBackground(new java.awt.Color(153, 153, 255));
        Spices7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Acre", null},
                {"Pimienta", null},
                {"Especias-mo", null},
                {"   Anis", null},
                {"   Nuez-mosca", null},
                {"   Canela", null},
                {"   Clavo-olor", null}
            },
            new String [] {
                "8 Especias", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Spices7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Spices7KeyReleased(evt);
            }
        });
        jScrollPane91.setViewportView(Spices7);
        if (Spices7.getColumnModel().getColumnCount() > 0) {
            Spices7.getColumnModel().getColumn(1).setMinWidth(30);
            Spices7.getColumnModel().getColumn(1).setPreferredWidth(30);
            Spices7.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Nutty7.setBackground(new java.awt.Color(255, 102, 204));
        Nutty7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Nueces", null},
                {"   Mani", null},
                {"   Avellana", null},
                {"   Almendra", null},
                {"Cacao", null},
                {"   Chocolate", null},
                {"   Choc-amarg", null}
            },
            new String [] {
                "9 Nueces/Cacao", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Nutty7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Nutty7KeyReleased(evt);
            }
        });
        jScrollPane92.setViewportView(Nutty7);
        if (Nutty7.getColumnModel().getColumnCount() > 0) {
            Nutty7.getColumnModel().getColumn(1).setMinWidth(30);
            Nutty7.getColumnModel().getColumn(1).setPreferredWidth(30);
            Nutty7.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane85, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane84, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane86, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane87, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane88, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane89, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane91, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane90, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane92, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane82, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane83, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane86, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jScrollPane90, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane91, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane87, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jScrollPane84, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane85, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 58, Short.MAX_VALUE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane88, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addComponent(jScrollPane92, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane82, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane83, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane89, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(96, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Mojado/Quebrado", jPanel17);

        Body9.setBackground(new java.awt.Color(204, 204, 204));
        Body9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Peso", null},
                {"Jarabe", null},
                {"Aceitoso", null},
                {"Suave", null}
            },
            new String [] {
                "10 Cuerpo", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Body9.setEnabled(false);
        Body9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Body9KeyReleased(evt);
            }
        });
        jScrollPane93.setViewportView(Body9);
        if (Body9.getColumnModel().getColumnCount() > 0) {
            Body9.getColumnModel().getColumn(1).setMinWidth(30);
            Body9.getColumnModel().getColumn(1).setPreferredWidth(30);
            Body9.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Finish9.setBackground(new java.awt.Color(204, 204, 204));
        Finish9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Duración", null},
                {"Seco", null},
                {"Astringent", null},
                {"Granoso", null}
            },
            new String [] {
                "11 Sabor Rem.", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Finish9.setEnabled(false);
        Finish9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Finish9KeyReleased(evt);
            }
        });
        jScrollPane94.setViewportView(Finish9);
        if (Finish9.getColumnModel().getColumnCount() > 0) {
            Finish9.getColumnModel().getColumn(1).setMinWidth(30);
            Finish9.getColumnModel().getColumn(1).setPreferredWidth(30);
            Finish9.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Sweet8.setBackground(new java.awt.Color(255, 102, 102));
        Sweet8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Azúcar-Mor", null},
                {"   Melaza", null},
                {"   Jarab-mapl", null},
                {"   Caramelo", null},
                {"   Miel", null},
                {"Vainilla", null},
                {"Arom-Vaini", null},
                {"Dulce-Gene", null},
                {"Arom-dulce", null}
            },
            new String [] {
                "1 Dulce", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Sweet8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Sweet8KeyReleased(evt);
            }
        });
        jScrollPane95.setViewportView(Sweet8);
        if (Sweet8.getColumnModel().getColumnCount() > 0) {
            Sweet8.getColumnModel().getColumn(1).setMinWidth(30);
            Sweet8.getColumnModel().getColumn(1).setPreferredWidth(30);
            Sweet8.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Floral8.setBackground(new java.awt.Color(255, 153, 102));
        Floral8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Té-Negro", null},
                {"Floral", null},
                {"   Manzanilla", null},
                {"   Rosa", null},
                {"   Jazmine", null}
            },
            new String [] {
                "2 Floral", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Floral8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Floral8KeyReleased(evt);
            }
        });
        jScrollPane96.setViewportView(Floral8);
        if (Floral8.getColumnModel().getColumnCount() > 0) {
            Floral8.getColumnModel().getColumn(1).setMinWidth(30);
            Floral8.getColumnModel().getColumn(1).setPreferredWidth(30);
            Floral8.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Fruit8.setBackground(new java.awt.Color(255, 204, 0));
        Fruit8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Bayas", null},
                {"   Moras", null},
                {"   Frambuesa", null},
                {"   Arándano", null},
                {"   Fresa", null},
                {"Fruto-sec", null},
                {"   Pasas", null},
                {"   Ciruel-pas", null},
                {"Otras-frut", null},
                {"   Coco", null},
                {"   Cereza", null},
                {"   Granada", null},
                {"   Piña", null},
                {"   Uvas", null},
                {"   Manzana", null},
                {"   Durazno", null},
                {"   Pera", null},
                {"Citricos", null},
                {"   Toronja", null},
                {"   Naranja", null},
                {"   Limon", null},
                {"   Lima", null}
            },
            new String [] {
                "3 Afrutado", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Fruit8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Fruit8KeyReleased(evt);
            }
        });
        jScrollPane97.setViewportView(Fruit8);
        if (Fruit8.getColumnModel().getColumnCount() > 0) {
            Fruit8.getColumnModel().getColumn(1).setMinWidth(30);
            Fruit8.getColumnModel().getColumn(1).setPreferredWidth(30);
            Fruit8.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        SourFer8.setBackground(new java.awt.Color(255, 255, 153));
        SourFer8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Acido", null},
                {"   Arom-acido", null},
                {"   Acido-acét", null},
                {"   Acido-butí", null},
                {"   Acido-isoc", null},
                {"   Acido-cítr", null},
                {"   Acido-máli", null},
                {"Alcoh/Ferm", null},
                {"   Vinoso", null},
                {"   Whisky", null},
                {"   Fermentado", null},
                {"   Super-madu", null}
            },
            new String [] {
                "4 Acido/Fermentado", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SourFer8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SourFer8KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SourFer8KeyTyped(evt);
            }
        });
        jScrollPane98.setViewportView(SourFer8);
        if (SourFer8.getColumnModel().getColumnCount() > 0) {
            SourFer8.getColumnModel().getColumn(1).setMinWidth(30);
            SourFer8.getColumnModel().getColumn(1).setPreferredWidth(30);
            SourFer8.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        GreenVeg8.setBackground(new java.awt.Color(102, 255, 102));
        GreenVeg8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Aceit-Oliv", null},
                {"Crudo", null},
                {"Verde/Vege", null},
                {"   Inmaduro", null},
                {"   Vaina", null},
                {"   Fresco", null},
                {"   Verde-oscu", null},
                {"   Vegetal", null},
                {"   Paja", null},
                {"   Herbaceo", null},
                {"Leguminoso", null}
            },
            new String [] {
                "5 Verde/Vegetal", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GreenVeg8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GreenVeg8KeyReleased(evt);
            }
        });
        jScrollPane99.setViewportView(GreenVeg8);
        if (GreenVeg8.getColumnModel().getColumnCount() > 0) {
            GreenVeg8.getColumnModel().getColumn(1).setMinWidth(30);
            GreenVeg8.getColumnModel().getColumn(1).setPreferredWidth(30);
            GreenVeg8.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Other8.setBackground(new java.awt.Color(51, 255, 255));
        Other8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Papel/Hume", null},
                {"   Rancio", null},
                {"   Carton", null},
                {"   Papel", null},
                {"   Madera", null},
                {"   Mohoso", null},
                {"   Polvo-hume", null},
                {"   Tierra", null},
                {"   Cuero", null},
                {"   Carne/cald", null},
                {"   Fenolico", null},
                {"Quimico", null},
                {"   Amargo", null},
                {"   Salado", null},
                {"   Medicinal", null},
                {"   Petroleo", null},
                {"   Zorrillo", null},
                {"   Goma", null}
            },
            new String [] {
                "6 Otros", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Other8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Other8KeyReleased(evt);
            }
        });
        jScrollPane100.setViewportView(Other8);
        if (Other8.getColumnModel().getColumnCount() > 0) {
            Other8.getColumnModel().getColumn(1).setMinWidth(30);
            Other8.getColumnModel().getColumn(1).setPreferredWidth(30);
            Other8.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Roasted8.setBackground(new java.awt.Color(0, 204, 255));
        Roasted8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Tabac-pipa", null},
                {"Tabaco", null},
                {"Quemado", null},
                {"   Acre", null},
                {"   Ceniza", null},
                {"   Humo", null},
                {"   Marrón/tos", null},
                {"Cereal", null},
                {"   Grano", null},
                {"   Malta", null}
            },
            new String [] {
                "7 Tostado", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Roasted8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Roasted8KeyReleased(evt);
            }
        });
        jScrollPane101.setViewportView(Roasted8);
        if (Roasted8.getColumnModel().getColumnCount() > 0) {
            Roasted8.getColumnModel().getColumn(1).setMinWidth(30);
            Roasted8.getColumnModel().getColumn(1).setPreferredWidth(30);
            Roasted8.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Spices8.setBackground(new java.awt.Color(153, 153, 255));
        Spices8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Acre", null},
                {"Pimienta", null},
                {"Especias-mo", null},
                {"   Anis", null},
                {"   Nuez-mosca", null},
                {"   Canela", null},
                {"   Clavo-olor", null}
            },
            new String [] {
                "8 Especias", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Spices8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Spices8KeyReleased(evt);
            }
        });
        jScrollPane102.setViewportView(Spices8);
        if (Spices8.getColumnModel().getColumnCount() > 0) {
            Spices8.getColumnModel().getColumn(1).setMinWidth(30);
            Spices8.getColumnModel().getColumn(1).setPreferredWidth(30);
            Spices8.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Nutty8.setBackground(new java.awt.Color(255, 102, 204));
        Nutty8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Nueces", null},
                {"   Mani", null},
                {"   Avellana", null},
                {"   Almendra", null},
                {"Cacao", null},
                {"   Chocolate", null},
                {"   Choc-amarg", null}
            },
            new String [] {
                "9 Nueces/Cacao", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Nutty8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Nutty8KeyReleased(evt);
            }
        });
        jScrollPane103.setViewportView(Nutty8);
        if (Nutty8.getColumnModel().getColumnCount() > 0) {
            Nutty8.getColumnModel().getColumn(1).setMinWidth(30);
            Nutty8.getColumnModel().getColumn(1).setPreferredWidth(30);
            Nutty8.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane96, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane95, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane97, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane98, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane99, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane100, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane102, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane101, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane103, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane93, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane94, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane97, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jScrollPane101, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane102, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane98, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jScrollPane95, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane96, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 58, Short.MAX_VALUE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane99, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addComponent(jScrollPane103, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane93, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane94, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane100, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Sabor", jPanel18);

        Body10.setBackground(new java.awt.Color(204, 204, 204));
        Body10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Peso", null},
                {"Jarabe", null},
                {"Aceitoso", null},
                {"Suave", null}
            },
            new String [] {
                "10 Cuerpo", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Body10.setEnabled(false);
        Body10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Body10KeyReleased(evt);
            }
        });
        jScrollPane104.setViewportView(Body10);
        if (Body10.getColumnModel().getColumnCount() > 0) {
            Body10.getColumnModel().getColumn(1).setMinWidth(30);
            Body10.getColumnModel().getColumn(1).setPreferredWidth(30);
            Body10.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Finish10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Duración", null},
                {"Seco", null},
                {"Astringent", null},
                {"Granoso", null}
            },
            new String [] {
                "11 Sabor Rem.", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Finish10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Finish10KeyReleased(evt);
            }
        });
        jScrollPane105.setViewportView(Finish10);
        if (Finish10.getColumnModel().getColumnCount() > 0) {
            Finish10.getColumnModel().getColumn(1).setMinWidth(30);
            Finish10.getColumnModel().getColumn(1).setPreferredWidth(30);
            Finish10.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Sweet9.setBackground(new java.awt.Color(255, 102, 102));
        Sweet9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Azúcar-Mor", null},
                {"   Melaza", null},
                {"   Jarab-mapl", null},
                {"   Caramelo", null},
                {"   Miel", null},
                {"Vainilla", null},
                {"Arom-Vaini", null},
                {"Dulce-Gene", null},
                {"Arom-dulce", null}
            },
            new String [] {
                "1 Dulce", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Sweet9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Sweet9KeyReleased(evt);
            }
        });
        jScrollPane106.setViewportView(Sweet9);
        if (Sweet9.getColumnModel().getColumnCount() > 0) {
            Sweet9.getColumnModel().getColumn(1).setMinWidth(30);
            Sweet9.getColumnModel().getColumn(1).setPreferredWidth(30);
            Sweet9.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Floral9.setBackground(new java.awt.Color(255, 153, 102));
        Floral9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Té-Negro", null},
                {"Floral", null},
                {"   Manzanilla", null},
                {"   Rosa", null},
                {"   Jazmine", null}
            },
            new String [] {
                "2 Floral", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Floral9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Floral9KeyReleased(evt);
            }
        });
        jScrollPane107.setViewportView(Floral9);
        if (Floral9.getColumnModel().getColumnCount() > 0) {
            Floral9.getColumnModel().getColumn(1).setMinWidth(30);
            Floral9.getColumnModel().getColumn(1).setPreferredWidth(30);
            Floral9.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Fruit9.setBackground(new java.awt.Color(255, 204, 0));
        Fruit9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Bayas", null},
                {"   Moras", null},
                {"   Frambuesa", null},
                {"   Arándano", null},
                {"   Fresa", null},
                {"Fruto-sec", null},
                {"   Pasas", null},
                {"   Ciruel-pas", null},
                {"Otras-frut", null},
                {"   Coco", null},
                {"   Cereza", null},
                {"   Granada", null},
                {"   Piña", null},
                {"   Uvas", null},
                {"   Manzana", null},
                {"   Durazno", null},
                {"   Pera", null},
                {"Citricos", null},
                {"   Toronja", null},
                {"   Naranja", null},
                {"   Limon", null},
                {"   Lima", null}
            },
            new String [] {
                "3 Afrutado", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Fruit9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Fruit9KeyReleased(evt);
            }
        });
        jScrollPane108.setViewportView(Fruit9);
        if (Fruit9.getColumnModel().getColumnCount() > 0) {
            Fruit9.getColumnModel().getColumn(1).setMinWidth(30);
            Fruit9.getColumnModel().getColumn(1).setPreferredWidth(30);
            Fruit9.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        SourFer9.setBackground(new java.awt.Color(255, 255, 153));
        SourFer9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Acido", null},
                {"   Arom-acido", null},
                {"   Acido-acét", null},
                {"   Acido-butí", null},
                {"   Acido-isoc", null},
                {"   Acido-cítr", null},
                {"   Acido-máli", null},
                {"Alcoh/Ferm", null},
                {"   Vinoso", null},
                {"   Whisky", null},
                {"   Fermentado", null},
                {"   Super-madu", null}
            },
            new String [] {
                "4 Acido/Fermentado", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SourFer9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SourFer9KeyReleased(evt);
            }
        });
        jScrollPane109.setViewportView(SourFer9);
        if (SourFer9.getColumnModel().getColumnCount() > 0) {
            SourFer9.getColumnModel().getColumn(1).setMinWidth(30);
            SourFer9.getColumnModel().getColumn(1).setPreferredWidth(30);
            SourFer9.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        GreenVeg9.setBackground(new java.awt.Color(102, 255, 102));
        GreenVeg9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Aceit-Oliv", null},
                {"Crudo", null},
                {"Verde/Vege", null},
                {"   Inmaduro", null},
                {"   Vaina", null},
                {"   Fresco", null},
                {"   Verde-oscu", null},
                {"   Vegetal", null},
                {"   Paja", null},
                {"   Herbaceo", null},
                {"Leguminoso", null}
            },
            new String [] {
                "5 Verde/Vegetal", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GreenVeg9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GreenVeg9KeyReleased(evt);
            }
        });
        jScrollPane110.setViewportView(GreenVeg9);
        if (GreenVeg9.getColumnModel().getColumnCount() > 0) {
            GreenVeg9.getColumnModel().getColumn(1).setMinWidth(30);
            GreenVeg9.getColumnModel().getColumn(1).setPreferredWidth(30);
            GreenVeg9.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Other9.setBackground(new java.awt.Color(51, 255, 255));
        Other9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Papel/Hume", null},
                {"   Rancio", null},
                {"   Carton", null},
                {"   Papel", null},
                {"   Madera", null},
                {"   Mohoso", null},
                {"   Polvo-hume", null},
                {"   Tierra", null},
                {"   Cuero", null},
                {"   Carne/cald", null},
                {"   Fenolico", null},
                {"Quimico", null},
                {"   Amargo", null},
                {"   Salado", null},
                {"   Medicinal", null},
                {"   Petroleo", null},
                {"   Zorrillo", null},
                {"   Goma", null}
            },
            new String [] {
                "6 Otros", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Other9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Other9KeyReleased(evt);
            }
        });
        jScrollPane111.setViewportView(Other9);
        if (Other9.getColumnModel().getColumnCount() > 0) {
            Other9.getColumnModel().getColumn(1).setMinWidth(30);
            Other9.getColumnModel().getColumn(1).setPreferredWidth(30);
            Other9.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Roasted9.setBackground(new java.awt.Color(0, 204, 255));
        Roasted9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Tabac-pipa", null},
                {"Tabaco", null},
                {"Quemado", null},
                {"   Acre", null},
                {"   Ceniza", null},
                {"   Humo", null},
                {"   Marrón/tos", null},
                {"Cereal", null},
                {"   Grano", null},
                {"   Malta", null}
            },
            new String [] {
                "7 Tostado", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Roasted9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Roasted9KeyReleased(evt);
            }
        });
        jScrollPane112.setViewportView(Roasted9);
        if (Roasted9.getColumnModel().getColumnCount() > 0) {
            Roasted9.getColumnModel().getColumn(1).setMinWidth(30);
            Roasted9.getColumnModel().getColumn(1).setPreferredWidth(30);
            Roasted9.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Spices9.setBackground(new java.awt.Color(153, 153, 255));
        Spices9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Acre", null},
                {"Pimienta", null},
                {"Especias-mo", null},
                {"   Anis", null},
                {"   Nuez-mosca", null},
                {"   Canela", null},
                {"   Clavo-olor", null}
            },
            new String [] {
                "8 Especias", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Spices9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Spices9KeyReleased(evt);
            }
        });
        jScrollPane113.setViewportView(Spices9);
        if (Spices9.getColumnModel().getColumnCount() > 0) {
            Spices9.getColumnModel().getColumn(1).setMinWidth(30);
            Spices9.getColumnModel().getColumn(1).setPreferredWidth(30);
            Spices9.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Nutty9.setBackground(new java.awt.Color(255, 102, 204));
        Nutty9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Nueces", null},
                {"   Mani", null},
                {"   Avellana", null},
                {"   Almendra", null},
                {"Cacao", null},
                {"   Chocolate", null},
                {"   Choc-amarg", null}
            },
            new String [] {
                "9 Nueces/Cacao", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Nutty9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Nutty9KeyReleased(evt);
            }
        });
        jScrollPane114.setViewportView(Nutty9);
        if (Nutty9.getColumnModel().getColumnCount() > 0) {
            Nutty9.getColumnModel().getColumn(1).setMinWidth(30);
            Nutty9.getColumnModel().getColumn(1).setPreferredWidth(30);
            Nutty9.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane107, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane106, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane108, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane109, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane110, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane111, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane113, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane112, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane114, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane104, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane105, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane108, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jScrollPane112, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane113, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane109, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jScrollPane106, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane107, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 58, Short.MAX_VALUE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane110, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel19Layout.createSequentialGroup()
                                        .addComponent(jScrollPane114, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane104, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane105, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane111, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(96, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Sabor Remanente", jPanel19);

        Body11.setBackground(new java.awt.Color(204, 204, 204));
        Body11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Peso", null},
                {"Jarabe", null},
                {"Aceitoso", null},
                {"Suave", null}
            },
            new String [] {
                "10 Cuerpo", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Body11.setEnabled(false);
        Body11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Body11KeyReleased(evt);
            }
        });
        jScrollPane115.setViewportView(Body11);
        if (Body11.getColumnModel().getColumnCount() > 0) {
            Body11.getColumnModel().getColumn(1).setMinWidth(30);
            Body11.getColumnModel().getColumn(1).setPreferredWidth(30);
            Body11.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Finish11.setBackground(new java.awt.Color(204, 204, 204));
        Finish11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Duración", null},
                {"Seco", null},
                {"Astringent", null},
                {"Granoso", null}
            },
            new String [] {
                "11 Sabor Rem.", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Finish11.setEnabled(false);
        Finish11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Finish11KeyReleased(evt);
            }
        });
        jScrollPane116.setViewportView(Finish11);
        if (Finish11.getColumnModel().getColumnCount() > 0) {
            Finish11.getColumnModel().getColumn(1).setMinWidth(30);
            Finish11.getColumnModel().getColumn(1).setPreferredWidth(30);
            Finish11.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Sweet10.setBackground(new java.awt.Color(204, 204, 204));
        Sweet10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Azúcar-Mor", null},
                {"   Melaza", null},
                {"   Jarab-mapl", null},
                {"   Caramelo", null},
                {"   Miel", null},
                {"Vainilla", null},
                {"Arom-Vaini", null},
                {"Dulce-Gene", null},
                {"Arom-dulce", null}
            },
            new String [] {
                "1 Dulce", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Sweet10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Sweet10KeyReleased(evt);
            }
        });
        jScrollPane117.setViewportView(Sweet10);
        if (Sweet10.getColumnModel().getColumnCount() > 0) {
            Sweet10.getColumnModel().getColumn(1).setMinWidth(30);
            Sweet10.getColumnModel().getColumn(1).setPreferredWidth(30);
            Sweet10.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Floral10.setBackground(new java.awt.Color(204, 204, 204));
        Floral10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Té-Negro", null},
                {"Floral", null},
                {"   Manzanilla", null},
                {"   Rosa", null},
                {"   Jazmine", null}
            },
            new String [] {
                "2 Floral", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Floral10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Floral10KeyReleased(evt);
            }
        });
        jScrollPane118.setViewportView(Floral10);
        if (Floral10.getColumnModel().getColumnCount() > 0) {
            Floral10.getColumnModel().getColumn(1).setMinWidth(30);
            Floral10.getColumnModel().getColumn(1).setPreferredWidth(30);
            Floral10.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Fruit10.setBackground(new java.awt.Color(255, 204, 0));
        Fruit10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Bayas", null},
                {"   Moras", null},
                {"   Frambuesa", null},
                {"   Arándano", null},
                {"   Fresa", null},
                {"Fruto-sec", null},
                {"   Pasas", null},
                {"   Ciruel-pas", null},
                {"Otras-frut", null},
                {"   Coco", null},
                {"   Cereza", null},
                {"   Granada", null},
                {"   Piña", null},
                {"   Uvas", null},
                {"   Manzana", null},
                {"   Durazno", null},
                {"   Pera", null},
                {"Citricos", null},
                {"   Toronja", null},
                {"   Naranja", null},
                {"   Limon", null},
                {"   Lima", null}
            },
            new String [] {
                "3 Afrutado", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Fruit10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Fruit10KeyReleased(evt);
            }
        });
        jScrollPane119.setViewportView(Fruit10);
        if (Fruit10.getColumnModel().getColumnCount() > 0) {
            Fruit10.getColumnModel().getColumn(1).setMinWidth(30);
            Fruit10.getColumnModel().getColumn(1).setPreferredWidth(30);
            Fruit10.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        SourFer10.setBackground(new java.awt.Color(255, 255, 153));
        SourFer10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Acido", null},
                {"   Arom-acido", null},
                {"   Acido-acét", null},
                {"   Acido-butí", null},
                {"   Acido-isoc", null},
                {"   Acido-cítr", null},
                {"   Acido-máli", null},
                {"Alcoh/Ferm", null},
                {"   Vinoso", null},
                {"   Whisky", null},
                {"   Fermentado", null},
                {"   Super-madu", null}
            },
            new String [] {
                "4 Acido/Fermentado", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SourFer10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SourFer10KeyReleased(evt);
            }
        });
        jScrollPane120.setViewportView(SourFer10);
        if (SourFer10.getColumnModel().getColumnCount() > 0) {
            SourFer10.getColumnModel().getColumn(1).setMinWidth(30);
            SourFer10.getColumnModel().getColumn(1).setPreferredWidth(30);
            SourFer10.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        GreenVeg10.setBackground(new java.awt.Color(204, 204, 204));
        GreenVeg10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Aceit-Oliv", null},
                {"Crudo", null},
                {"Verde/Vege", null},
                {"   Inmaduro", null},
                {"   Vaina", null},
                {"   Fresco", null},
                {"   Verde-oscu", null},
                {"   Vegetal", null},
                {"   Paja", null},
                {"   Herbaceo", null},
                {"Leguminoso", null}
            },
            new String [] {
                "5 Verde/Vegetal", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GreenVeg10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GreenVeg10KeyReleased(evt);
            }
        });
        jScrollPane121.setViewportView(GreenVeg10);
        if (GreenVeg10.getColumnModel().getColumnCount() > 0) {
            GreenVeg10.getColumnModel().getColumn(1).setMinWidth(30);
            GreenVeg10.getColumnModel().getColumn(1).setPreferredWidth(30);
            GreenVeg10.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Other10.setBackground(new java.awt.Color(204, 204, 204));
        Other10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Papel/Hume", null},
                {"   Rancio", null},
                {"   Carton", null},
                {"   Papel", null},
                {"   Madera", null},
                {"   Mohoso", null},
                {"   Polvo-hume", null},
                {"   Tierra", null},
                {"   Cuero", null},
                {"   Carne/cald", null},
                {"   Fenolico", null},
                {"Quimico", null},
                {"   Amargo", null},
                {"   Salado", null},
                {"   Medicinal", null},
                {"   Petroleo", null},
                {"   Zorrillo", null},
                {"   Goma", null}
            },
            new String [] {
                "6 Otros", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Other10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Other10KeyReleased(evt);
            }
        });
        jScrollPane122.setViewportView(Other10);
        if (Other10.getColumnModel().getColumnCount() > 0) {
            Other10.getColumnModel().getColumn(1).setMinWidth(30);
            Other10.getColumnModel().getColumn(1).setPreferredWidth(30);
            Other10.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Roasted10.setBackground(new java.awt.Color(204, 204, 204));
        Roasted10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Tabac-pipa", null},
                {"Tabaco", null},
                {"Quemado", null},
                {"   Acre", null},
                {"   Ceniza", null},
                {"   Humo", null},
                {"   Marrón/tos", null},
                {"Cereal", null},
                {"   Grano", null},
                {"   Malta", null}
            },
            new String [] {
                "7 Tostado", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Roasted10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Roasted10KeyReleased(evt);
            }
        });
        jScrollPane123.setViewportView(Roasted10);
        if (Roasted10.getColumnModel().getColumnCount() > 0) {
            Roasted10.getColumnModel().getColumn(1).setMinWidth(30);
            Roasted10.getColumnModel().getColumn(1).setPreferredWidth(30);
            Roasted10.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Spices10.setBackground(new java.awt.Color(204, 204, 204));
        Spices10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Acre", null},
                {"Pimienta", null},
                {"Especias-mo", null},
                {"   Anis", null},
                {"   Nuez-mosca", null},
                {"   Canela", null},
                {"   Clavo-olor", null}
            },
            new String [] {
                "8 Especias", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Spices10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Spices10KeyReleased(evt);
            }
        });
        jScrollPane124.setViewportView(Spices10);
        if (Spices10.getColumnModel().getColumnCount() > 0) {
            Spices10.getColumnModel().getColumn(1).setMinWidth(30);
            Spices10.getColumnModel().getColumn(1).setPreferredWidth(30);
            Spices10.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Nutty10.setBackground(new java.awt.Color(204, 204, 204));
        Nutty10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Nueces", null},
                {"   Mani", null},
                {"   Avellana", null},
                {"   Almendra", null},
                {"Cacao", null},
                {"   Chocolate", null},
                {"   Choc-amarg", null}
            },
            new String [] {
                "9 Nueces/Cacao", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Nutty10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Nutty10KeyReleased(evt);
            }
        });
        jScrollPane125.setViewportView(Nutty10);
        if (Nutty10.getColumnModel().getColumnCount() > 0) {
            Nutty10.getColumnModel().getColumn(1).setMinWidth(30);
            Nutty10.getColumnModel().getColumn(1).setPreferredWidth(30);
            Nutty10.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane118, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane117, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane119, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane120, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane121, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane122, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane124, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane123, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane125, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane115, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane116, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane119, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jScrollPane123, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane124, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane120, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jScrollPane117, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane118, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 58, Short.MAX_VALUE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane121, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel20Layout.createSequentialGroup()
                                        .addComponent(jScrollPane125, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane115, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane116, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane122, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(96, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Acidez", jPanel20);

        Body13.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Peso", null},
                {"Jarabe", null},
                {"Aceitoso", null},
                {"Suave", null}
            },
            new String [] {
                "10 Cuerpo", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Body13.setEnabled(false);
        Body13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Body13KeyReleased(evt);
            }
        });
        jScrollPane137.setViewportView(Body13);
        if (Body13.getColumnModel().getColumnCount() > 0) {
            Body13.getColumnModel().getColumn(1).setMinWidth(30);
            Body13.getColumnModel().getColumn(1).setPreferredWidth(30);
            Body13.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Finish13.setBackground(new java.awt.Color(204, 204, 204));
        Finish13.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Duración", null},
                {"Seco", null},
                {"Astringent", null},
                {"Granoso", null}
            },
            new String [] {
                "11 Sabor Rem.", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Finish13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Finish13KeyReleased(evt);
            }
        });
        jScrollPane138.setViewportView(Finish13);
        if (Finish13.getColumnModel().getColumnCount() > 0) {
            Finish13.getColumnModel().getColumn(1).setMinWidth(30);
            Finish13.getColumnModel().getColumn(1).setPreferredWidth(30);
            Finish13.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Sweet12.setBackground(new java.awt.Color(204, 204, 204));
        Sweet12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Azúcar-Mor", null},
                {"   Melaza", null},
                {"   Jarab-mapl", null},
                {"   Caramelo", null},
                {"   Miel", null},
                {"Vainilla", null},
                {"Arom-Vaini", null},
                {"Dulce-Gene", null},
                {"Arom-dulce", null}
            },
            new String [] {
                "1 Dulce", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Sweet12.setEnabled(false);
        Sweet12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Sweet12KeyReleased(evt);
            }
        });
        jScrollPane139.setViewportView(Sweet12);
        if (Sweet12.getColumnModel().getColumnCount() > 0) {
            Sweet12.getColumnModel().getColumn(1).setMinWidth(30);
            Sweet12.getColumnModel().getColumn(1).setPreferredWidth(30);
            Sweet12.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Floral12.setBackground(new java.awt.Color(204, 204, 204));
        Floral12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Té-Negro", null},
                {"Floral", null},
                {"   Manzanilla", null},
                {"   Rosa", null},
                {"   Jazmine", null}
            },
            new String [] {
                "2 Floral", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Floral12.setEnabled(false);
        Floral12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Floral12KeyReleased(evt);
            }
        });
        jScrollPane140.setViewportView(Floral12);
        if (Floral12.getColumnModel().getColumnCount() > 0) {
            Floral12.getColumnModel().getColumn(1).setMinWidth(30);
            Floral12.getColumnModel().getColumn(1).setPreferredWidth(30);
            Floral12.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Fruit12.setBackground(new java.awt.Color(204, 204, 204));
        Fruit12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Bayas", null},
                {"   Moras", null},
                {"   Frambuesa", null},
                {"   Arándano", null},
                {"   Fresa", null},
                {"Fruto-sec", null},
                {"   Pasas", null},
                {"   Ciruel-pas", null},
                {"Otras-frut", null},
                {"   Coco", null},
                {"   Cereza", null},
                {"   Granada", null},
                {"   Piña", null},
                {"   Uvas", null},
                {"   Manzana", null},
                {"   Durazno", null},
                {"   Pera", null},
                {"Citricos", null},
                {"   Toronja", null},
                {"   Naranja", null},
                {"   Limon", null},
                {"   Lima", null}
            },
            new String [] {
                "3 Afrutado", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Fruit12.setEnabled(false);
        Fruit12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Fruit12KeyReleased(evt);
            }
        });
        jScrollPane141.setViewportView(Fruit12);
        if (Fruit12.getColumnModel().getColumnCount() > 0) {
            Fruit12.getColumnModel().getColumn(1).setMinWidth(30);
            Fruit12.getColumnModel().getColumn(1).setPreferredWidth(30);
            Fruit12.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        SourFer12.setBackground(new java.awt.Color(204, 204, 204));
        SourFer12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Acido", null},
                {"   Arom-acido", null},
                {"   Acido-acét", null},
                {"   Acido-butí", null},
                {"   Acido-isoc", null},
                {"   Acido-cítr", null},
                {"   Acido-máli", null},
                {"Alcoh/Ferm", null},
                {"   Vinoso", null},
                {"   Whisky", null},
                {"   Fermentado", null},
                {"   Super-madu", null}
            },
            new String [] {
                "4 Acido/Fermentado", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SourFer12.setEnabled(false);
        SourFer12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SourFer12KeyReleased(evt);
            }
        });
        jScrollPane142.setViewportView(SourFer12);
        if (SourFer12.getColumnModel().getColumnCount() > 0) {
            SourFer12.getColumnModel().getColumn(1).setMinWidth(30);
            SourFer12.getColumnModel().getColumn(1).setPreferredWidth(30);
            SourFer12.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        GreenVeg12.setBackground(new java.awt.Color(204, 204, 204));
        GreenVeg12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Aceit-Oliv", null},
                {"Crudo", null},
                {"Verde/Vege", null},
                {"   Inmaduro", null},
                {"   Vaina", null},
                {"   Fresco", null},
                {"   Verde-oscu", null},
                {"   Vegetal", null},
                {"   Paja", null},
                {"   Herbaceo", null},
                {"Leguminoso", null}
            },
            new String [] {
                "5 Verde/Vegetal", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GreenVeg12.setEnabled(false);
        GreenVeg12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GreenVeg12KeyReleased(evt);
            }
        });
        jScrollPane143.setViewportView(GreenVeg12);
        if (GreenVeg12.getColumnModel().getColumnCount() > 0) {
            GreenVeg12.getColumnModel().getColumn(1).setMinWidth(30);
            GreenVeg12.getColumnModel().getColumn(1).setPreferredWidth(30);
            GreenVeg12.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Other12.setBackground(new java.awt.Color(204, 204, 204));
        Other12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Papel/Hume", null},
                {"   Rancio", null},
                {"   Carton", null},
                {"   Papel", null},
                {"   Madera", null},
                {"   Mohoso", null},
                {"   Polvo-hume", null},
                {"   Tierra", null},
                {"   Cuero", null},
                {"   Carne/cald", null},
                {"   Fenolico", null},
                {"Quimico", null},
                {"   Amargo", null},
                {"   Salado", null},
                {"   Medicinal", null},
                {"   Petroleo", null},
                {"   Zorrillo", null},
                {"   Goma", null}
            },
            new String [] {
                "6 Otros", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Other12.setEnabled(false);
        Other12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Other12KeyReleased(evt);
            }
        });
        jScrollPane144.setViewportView(Other12);
        if (Other12.getColumnModel().getColumnCount() > 0) {
            Other12.getColumnModel().getColumn(1).setMinWidth(30);
            Other12.getColumnModel().getColumn(1).setPreferredWidth(30);
            Other12.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Roasted12.setBackground(new java.awt.Color(204, 204, 204));
        Roasted12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Tabac-pipa", null},
                {"Tabaco", null},
                {"Quemado", null},
                {"   Acre", null},
                {"   Ceniza", null},
                {"   Humo", null},
                {"   Marrón/tos", null},
                {"Cereal", null},
                {"   Grano", null},
                {"   Malta", null}
            },
            new String [] {
                "7 Tostado", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Roasted12.setEnabled(false);
        Roasted12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Roasted12KeyReleased(evt);
            }
        });
        jScrollPane145.setViewportView(Roasted12);
        if (Roasted12.getColumnModel().getColumnCount() > 0) {
            Roasted12.getColumnModel().getColumn(1).setMinWidth(30);
            Roasted12.getColumnModel().getColumn(1).setPreferredWidth(30);
            Roasted12.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Spices12.setBackground(new java.awt.Color(204, 204, 204));
        Spices12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Acre", null},
                {"Pimienta", null},
                {"Especias-mo", null},
                {"   Anis", null},
                {"   Nuez-mosca", null},
                {"   Canela", null},
                {"   Clavo-olor", null}
            },
            new String [] {
                "8 Especias", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Spices12.setEnabled(false);
        Spices12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Spices12KeyReleased(evt);
            }
        });
        jScrollPane146.setViewportView(Spices12);
        if (Spices12.getColumnModel().getColumnCount() > 0) {
            Spices12.getColumnModel().getColumn(1).setMinWidth(30);
            Spices12.getColumnModel().getColumn(1).setPreferredWidth(30);
            Spices12.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        Nutty12.setBackground(new java.awt.Color(204, 204, 204));
        Nutty12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Nueces", null},
                {"   Mani", null},
                {"   Avellana", null},
                {"   Almendra", null},
                {"Cacao", null},
                {"   Chocolate", null},
                {"   Choc-amarg", null}
            },
            new String [] {
                "9 Nueces/Cacao", "Int."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Nutty12.setEnabled(false);
        Nutty12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Nutty12KeyReleased(evt);
            }
        });
        jScrollPane147.setViewportView(Nutty12);
        if (Nutty12.getColumnModel().getColumnCount() > 0) {
            Nutty12.getColumnModel().getColumn(1).setMinWidth(30);
            Nutty12.getColumnModel().getColumn(1).setPreferredWidth(30);
            Nutty12.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane140, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane139, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane141, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane142, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane143, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane144, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane146, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane145, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane147, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane137, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane138, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane141, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jScrollPane145, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane146, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane142, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jScrollPane139, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane140, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 58, Short.MAX_VALUE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane143, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel22Layout.createSequentialGroup()
                                        .addComponent(jScrollPane147, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane137, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane138, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane144, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(96, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Cuerpo", jPanel22);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Puntuación");

        lblPuntuacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPuntuacion.setForeground(new java.awt.Color(0, 0, 204));
        lblPuntuacion.setText("0.00");

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel57.setText("Seco");
        jPanel9.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 33, 48, -1));

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setText("Mojado/Quebrado");
        jPanel9.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 33, -1, -1));

        lblSeco.setText("-");
        jPanel9.add(lblSeco, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 33, 355, -1));

        lblQuebrado.setText("-");
        jPanel9.add(lblQuebrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 33, 322, -1));

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel60.setText("Sabor");
        jPanel9.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 73, 48, -1));

        lblSabor.setText("-");
        jPanel9.add(lblSabor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 73, 248, -1));

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel61.setText("Remanente");
        jPanel9.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 73, -1, -1));

        lblRemanente.setText("-");
        jPanel9.add(lblRemanente, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 73, 187, -1));

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel62.setText("Acidez");
        jPanel9.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 73, 55, -1));

        lblAcidez.setText("-");
        jPanel9.add(lblAcidez, new org.netbeans.lib.awtextra.AbsoluteConstraints(669, 73, 209, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Olores");
        jPanel9.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Sabores");
        jPanel9.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 53, -1, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Cuerpo");
        jPanel9.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 93, -1, -1));

        lblCuerpo.setText("-");
        jPanel9.add(lblCuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 93, -1, -1));
        jPanel9.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 810, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel33))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(lblPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(44, 44, 44))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(lblPuntuacion))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1044, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        // slCatador.setValue(slCatador.getValue() + 50);
        if (slCatador >= 10.0) {
            JOptionPane.showMessageDialog(null, "Limite");
        } else {
            slCatador = slCatador + 0.5;
            txtCatador.setText(slCatador + "");
        }
        if(txtCatador.getText() != "7.0")
            txtCatador.setBackground(Color.CYAN);
        promedio();
        formula();
    }//GEN-LAST:event_jButton21ActionPerformed
    Double slCatador = 7.0;
    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        // slCatador.setValue(slCatador.getValue() - 50);
        if (slCatador <= 4.0) {
            JOptionPane.showMessageDialog(null, "Limite");
        } else {
            slCatador = slCatador - 0.5;
            txtCatador.setText(slCatador + "");
        }
        if(txtCatador.getText() != "7.0")
            txtCatador.setBackground(Color.CYAN);
        promedio();
        formula();
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        //  slBalance.setValue(slBalance.getValue() + 50);
        if (slBalance >= 10.0) {
            JOptionPane.showMessageDialog(null, "Limite");
        } else {
            slBalance = slBalance + 0.5;
            txtBalance.setText(slBalance + "");
        }
        if(txtBalance.getText() != "7.0")
            txtBalance.setBackground(Color.CYAN);
        promedio();
        formula();
    }//GEN-LAST:event_jButton19ActionPerformed
    Double slBalance = 7.0;
    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        //  slBalance.setValue(slBalance.getValue() - 50);
        if (slBalance <= 4.0) {
            JOptionPane.showMessageDialog(null, "Limite");
        } else {
            slBalance = slBalance - 0.5;
            txtBalance.setText(slBalance + "");
        }
        if(txtBalance.getText() != "7.0")
            txtBalance.setBackground(Color.CYAN);
        promedio();
        formula();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        // slCuerpo.setValue(slCuerpo.getValue() + 50);
        if (slCuerpo >= 10.0) {
            JOptionPane.showMessageDialog(null, "Limite");
        } else {
            slCuerpo = slCuerpo + 0.5;
            txtCuerpo.setText(slCuerpo + "");
        }
        if(txtCuerpo.getText() != "7.0")
            txtCuerpo.setBackground(Color.CYAN);
        promedio();
        formula();
    }//GEN-LAST:event_jButton17ActionPerformed
    Double slCuerpo = 7.0;
    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        //   slCuerpo.setValue(slCuerpo.getValue() - 50);
        if (slCuerpo <= 4.0) {
            JOptionPane.showMessageDialog(null, "Limite");
        } else {
            slCuerpo = slCuerpo - 0.5;
            txtCuerpo.setText(slCuerpo + "");
        }
        if(txtCuerpo.getText() != "7.0")
            txtCuerpo.setBackground(Color.CYAN);
        promedio();
        formula();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        //  slAcidez.setValue(slAcidez.getValue() + 50);
        if (slAcidez >= 10.0) {
            JOptionPane.showMessageDialog(null, "Limite");
        } else {
            slAcidez = slAcidez + 0.5;
            txtAcidez.setText(slAcidez + "");
        }
        if(txtAcidez.getText() != "7.0")
            txtAcidez.setBackground(Color.CYAN);
        promedio();
        formula();
    }//GEN-LAST:event_jButton15ActionPerformed
    Double slAcidez = 7.0;
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        //  slAcidez.setValue(slAcidez.getValue() - 50);
        if (slAcidez <= 4.0) {
            JOptionPane.showMessageDialog(null, "Limite");
        } else {
            slAcidez = slAcidez - 0.5;
            txtAcidez.setText(slAcidez + "");
        }
        if(txtAcidez.getText() != "7.0")
            txtAcidez.setBackground(Color.CYAN);
        promedio();
        formula();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        //slAftertaste.setValue(slAftertaste.getValue() + 50);
        if (slSaborRemanente >= 10) {
            JOptionPane.showMessageDialog(null, "Limite");
        } else {
            slSaborRemanente = slSaborRemanente + 0.5;
            txtSaborRemanente.setText(slSaborRemanente + "");
        }
        if(txtSaborRemanente.getText() != "7.0")
            txtSaborRemanente.setBackground(Color.CYAN);
        promedio();
        formula();
    }//GEN-LAST:event_jButton13ActionPerformed
    Double slSaborRemanente = 7.0;
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        //  slAftertaste.setValue(slAftertaste.getValue() - 50);
        if (slSaborRemanente <= 4.0) {
            JOptionPane.showMessageDialog(null, "Limite");
        } else {
            slSaborRemanente = slSaborRemanente - 0.5;
            txtSaborRemanente.setText(slSaborRemanente + "");
        }
        if(txtSaborRemanente.getText() != "7.0")
            txtSaborRemanente.setBackground(Color.CYAN);
        promedio();
        formula();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        //  slSabor.setValue(slSabor.getValue() + 50);
        if (slSabor >= 10.0) {
            JOptionPane.showMessageDialog(null, "Limite");
        } else {
            slSabor = slSabor + 0.5;
            txtSabor.setText(slSabor + "");
        }
        if(txtSabor.getText() != "7.0")
            txtSabor.setBackground(Color.CYAN);
        promedio();
        formula();
    }//GEN-LAST:event_jButton11ActionPerformed
    Double slSabor = 7.0;
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        //  slSabor.setValue(slSabor.getValue() - 50);
        if (slSabor <= 4.0) {
            JOptionPane.showMessageDialog(null, "Limite");
        } else {
            slSabor = slSabor - 0.5;
            txtSabor.setText(slSabor + "");
        }
        if(txtSabor.getText() != "7.0")
            txtSabor.setBackground(Color.CYAN);
        promedio();
        formula();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void btnMas3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMas3ActionPerformed
        // TODO add your handling code here:
        //  slQuebrado.setValue(slQuebrado.getValue() + 50);
        if (slQuebrado >= 10.0) {
            JOptionPane.showMessageDialog(null, "Limite");
        } else {
            slQuebrado = slQuebrado + 0.5;
            txtQuebrado.setText(slQuebrado + "");
        }
        if(txtQuebrado.getText() != "7.0")
            txtQuebrado.setBackground(Color.CYAN);
        promedio();
        formula();
    }//GEN-LAST:event_btnMas3ActionPerformed
    Double slQuebrado = 7.0;
    private void btnMenos3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenos3ActionPerformed
        // TODO add your handling code here:
        //  slQuebrado.setValue(slQuebrado.getValue() - 50);
        if (slQuebrado <= 4.0) {
            JOptionPane.showMessageDialog(null, "Limite");
        } else {
            slQuebrado = slQuebrado - 0.5;
            txtQuebrado.setText(slQuebrado + "");
        }
        if(txtQuebrado.getText() != "7.0")
            txtQuebrado.setBackground(Color.CYAN);
        promedio();
        formula();
    }//GEN-LAST:event_btnMenos3ActionPerformed

    private void btnMas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMas2ActionPerformed
        // TODO add your handling code here:
        // slMojado.setValue(slMojado.getValue() + 50);
        if (slMojado >= 10.0) {
            JOptionPane.showMessageDialog(null, "Limite");
        } else {
            slMojado = slMojado + 0.5;
            txtMojado.setText(slMojado + "");
        }
        if(txtMojado.getText() != "7.0")
            txtMojado.setBackground(Color.CYAN);
        promedio();
        formula();
    }//GEN-LAST:event_btnMas2ActionPerformed
    Double slMojado = 7.0;
    private void btnMenos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenos2ActionPerformed
        // TODO add your handling code here:
        if (slMojado <= 4.0) {
            JOptionPane.showMessageDialog(null, "Limite");
        } else {
            slMojado = slMojado - 0.5;
            txtMojado.setText(slMojado + "");
        }
        if(txtMojado.getText() != "7.0")
            txtMojado.setBackground(Color.CYAN);
        promedio();
        formula();
    }//GEN-LAST:event_btnMenos2ActionPerformed

    private void btnMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasActionPerformed
        // TODO add your handling code here:
        //  slSeco.setValue(slSeco.getValue() + 50);
        if (slSeco >= 10.0) {
            JOptionPane.showMessageDialog(null, "Limite");
        } else {
            slSeco = slSeco + 0.5;
            txtSeco.setText(slSeco + "");
        }
        if(txtSeco.getText() != "7.0")
            txtSeco.setBackground(Color.CYAN);
        promedio();
        formula();
    }//GEN-LAST:event_btnMasActionPerformed
    Double slSeco = 7.0;
    private void btnMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosActionPerformed
        // TODO add your handling code here:
        //   slSeco.setValue(slSeco.getValue() - 50);
        if (slSeco <= 4.0) {
            JOptionPane.showMessageDialog(null, "Limite");
        } else {
            slSeco = slSeco - 0.5;
            txtSeco.setText(slSeco + "");
        }
        if(txtSeco.getText() != "7.0")
            txtSeco.setBackground(Color.CYAN);
        promedio();
        formula();
    }//GEN-LAST:event_btnMenosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (validar()) {
            guardar();
        } else {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_jButton1MouseClicked

    private void txtTazasCatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTazasCatKeyReleased
        // TODO add your handling code here:
        formula();
    }//GEN-LAST:event_txtTazasCatKeyReleased

    private void txtIntensidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIntensidadKeyTyped
        // TODO add your handling code here:
        char m = evt.getKeyChar();
        if (Character.isAlphabetic(m)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtIntensidadKeyTyped

    private void txtIntensidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIntensidadKeyReleased
        // TODO add your handling code here:
        l1 = Integer.parseInt(txtNoTazas.getText());
        l2 = Integer.parseInt(txtIntensidad.getText());
        totalD = l1 * l2;
        txtDefectos.setText(formato.format(totalD) + "");
    }//GEN-LAST:event_txtIntensidadKeyReleased

    private void txtNoTazasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoTazasKeyTyped
        // TODO add your handling code here:
        char m = evt.getKeyChar();
        if (Character.isAlphabetic(m)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNoTazasKeyTyped

    private void txtNoTazasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoTazasKeyReleased
        // TODO add your handling code here:
        l1 = Integer.parseInt(txtNoTazas.getText());
        l2 = Integer.parseInt(txtIntensidad.getText());
        totalD = l1 * l2;
        txtDefectos.setText(formato.format(totalD) + "");
    }//GEN-LAST:event_txtNoTazasKeyReleased

    private void txtDefectosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDefectosKeyReleased
        // TODO add your handling code here:
        formula();
    }//GEN-LAST:event_txtDefectosKeyReleased

    private void txtDulzorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDulzorKeyTyped
        // TODO add your handling code here:
        char m = evt.getKeyChar();
        if (Character.isAlphabetic(m)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtDulzorKeyTyped

    private void txtDulzorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDulzorKeyReleased
        // TODO add your handling code here:
        formula();
    }//GEN-LAST:event_txtDulzorKeyReleased

    private void txtTazaLimKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTazaLimKeyTyped
        // TODO add your handling code here:
        char m = evt.getKeyChar();
        if (Character.isAlphabetic(m)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTazaLimKeyTyped

    private void txtTazaLimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTazaLimKeyReleased
        // TODO add your handling code here:
        formula();
    }//GEN-LAST:event_txtTazaLimKeyReleased

    private void txtUniTazaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUniTazaKeyTyped
        // TODO add your handling code here:
        char m = evt.getKeyChar();
        if (Character.isAlphabetic(m)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtUniTazaKeyTyped

    private void txtUniTazaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUniTazaKeyReleased
        // TODO add your handling code here:
        formula();
    }//GEN-LAST:event_txtUniTazaKeyReleased

    private void slNivelTostadoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slNivelTostadoStateChanged
        // TODO add your handling code here:
        System.out.println(slNivelTostado.getValue());
        int valor = slNivelTostado.getValue();
        // JOptionPane.showMessageDialog(null, slNivelTostado.getValue());

        if (valor == 1) {
            jTextField4.setText("");
            jTextField3.setText("");
            jTextField2.setText("");
            jTextField1.setText("");
            jTextField5.setText("✔");
        } else if (valor == 2) {
            jTextField5.setText("");
            jTextField3.setText("");
            jTextField2.setText("");
            jTextField1.setText("");
            jTextField4.setText("✔");
        } else if (valor == 3) {
            jTextField4.setText("");
            jTextField5.setText("");
            jTextField2.setText("");
            jTextField1.setText("");
            jTextField3.setText("✔");
        } else if (valor == 4) {
            jTextField4.setText("");
            jTextField5.setText("");
            jTextField3.setText("");
            jTextField1.setText("");
            jTextField2.setText("✔");
        } else {
            jTextField4.setText("");
            jTextField5.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField1.setText("✔");
        }
        

    }//GEN-LAST:event_slNivelTostadoStateChanged

    private void Nutty6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Nutty6KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Nutty6.getValueAt(Nutty6.getSelectedRow(), 0) + "";
        intensidad = Nutty6.getValueAt(Nutty6.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sSeco += sabor.trim() + intensidad + " ";
            lblSeco.setText(sSeco);
        } else {
            Nutty6.setValueAt("", Nutty6.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Nutty6KeyReleased

    private void Spices6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Spices6KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Spices6.getValueAt(Spices6.getSelectedRow(), 0) + "";
        intensidad = Spices6.getValueAt(Spices6.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sSeco += sabor.trim() + intensidad + " ";
            lblSeco.setText(sSeco);
        } else {
            Spices6.setValueAt("", Spices6.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Spices6KeyReleased

    private void Roasted6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Roasted6KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Roasted6.getValueAt(Roasted6.getSelectedRow(), 0) + "";
        intensidad = Roasted6.getValueAt(Roasted6.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sSeco += sabor.trim() + intensidad + " ";
            lblSeco.setText(sSeco);
        } else {
            Roasted6.setValueAt("", Roasted6.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Roasted6KeyReleased

    private void Other6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Other6KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Other6.getValueAt(Other6.getSelectedRow(), 0) + "";
        intensidad = Other6.getValueAt(Other6.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sSeco += sabor.trim() + intensidad + " ";
            lblSeco.setText(sSeco);
        } else {
            Other6.setValueAt("", Other6.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Other6KeyReleased

    private void GreenVeg6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GreenVeg6KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = GreenVeg6.getValueAt(GreenVeg6.getSelectedRow(), 0) + "";
        intensidad = GreenVeg6.getValueAt(GreenVeg6.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sSeco += sabor.trim() + intensidad + " ";
            lblSeco.setText(sSeco);
        } else {
            GreenVeg6.setValueAt("", GreenVeg6.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_GreenVeg6KeyReleased

    private void SourFer6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SourFer6KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = SourFer6.getValueAt(SourFer6.getSelectedRow(), 0) + "";
        intensidad = SourFer6.getValueAt(SourFer6.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sSeco += sabor.trim() + intensidad + " ";
            lblSeco.setText(sSeco);
        } else {
            SourFer6.setValueAt("", SourFer6.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_SourFer6KeyReleased

    private void Fruit6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Fruit6KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Fruit6.getValueAt(Fruit6.getSelectedRow(), 0) + "";
        intensidad = Fruit6.getValueAt(Fruit6.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sSeco += sabor.trim() + intensidad + " ";
            lblSeco.setText(sSeco);
        } else {
            Fruit6.setValueAt("", Fruit6.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Fruit6KeyReleased

    private void Floral6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Floral6KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Floral6.getValueAt(Floral6.getSelectedRow(), 0) + "";
        intensidad = Floral6.getValueAt(Floral6.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sSeco += sabor.trim() + intensidad + " ";
            lblSeco.setText(sSeco);
        } else {
            Floral6.setValueAt("", Floral6.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Floral6KeyReleased

    private void Sweet6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Sweet6KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Sweet6.getValueAt(Sweet6.getSelectedRow(), 0) + "";
        intensidad = Sweet6.getValueAt(Sweet6.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sSeco += sabor.trim() + intensidad + " ";
            lblSeco.setText(sSeco);
        } else {
            Sweet6.setValueAt("", Sweet6.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Sweet6KeyReleased

    private void Finish2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Finish2KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Finish2.getValueAt(Finish2.getSelectedRow(), 0) + "";
        intensidad = Finish2.getValueAt(Finish2.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sSeco += sabor.trim() + intensidad + " ";
            lblSeco.setText(sSeco);
        } else {
            Finish2.setValueAt("", Finish2.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Finish2KeyReleased

    private void Body2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Body2KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Body2.getValueAt(Body2.getSelectedRow(), 0) + "";
        intensidad = Body2.getValueAt(Body2.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sSeco += sabor.trim() + intensidad + " ";
            lblSeco.setText(sSeco);
        } else {
            Body2.setValueAt("", Body2.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Body2KeyReleased

    private void Body8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Body8KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Body8.getValueAt(Body8.getSelectedRow(), 0) + "";
        intensidad = Body8.getValueAt(Body8.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sMojadoQuebrado += sabor.trim() + intensidad + " ";
            lblQuebrado.setText(sMojadoQuebrado);
        } else {
            Body8.setValueAt("", Body8.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Body8KeyReleased

    private void Finish8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Finish8KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Finish8.getValueAt(Finish8.getSelectedRow(), 0) + "";
        intensidad = Finish8.getValueAt(Finish8.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sMojadoQuebrado += sabor.trim() + intensidad + " ";
            lblQuebrado.setText(sMojadoQuebrado);
        } else {
            Finish8.setValueAt("", Finish8.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Finish8KeyReleased

    private void Sweet7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Sweet7KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Sweet7.getValueAt(Sweet7.getSelectedRow(), 0) + "";
        intensidad = Sweet7.getValueAt(Sweet7.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sMojadoQuebrado += sabor.trim() + intensidad + " ";
            lblQuebrado.setText(sMojadoQuebrado);
        } else {
            Sweet7.setValueAt("", Sweet7.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Sweet7KeyReleased

    private void Floral7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Floral7KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Floral7.getValueAt(Floral7.getSelectedRow(), 0) + "";
        intensidad = Floral7.getValueAt(Floral7.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sMojadoQuebrado += sabor.trim() + intensidad + " ";
            lblQuebrado.setText(sMojadoQuebrado);
        } else {
            Floral7.setValueAt("", Floral7.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Floral7KeyReleased

    private void Fruit7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Fruit7KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Fruit7.getValueAt(Fruit7.getSelectedRow(), 0) + "";
        intensidad = Fruit7.getValueAt(Fruit7.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sMojadoQuebrado += sabor.trim() + intensidad + " ";
            lblQuebrado.setText(sMojadoQuebrado);
        } else {
            Fruit7.setValueAt("", Fruit7.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Fruit7KeyReleased

    private void SourFer7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SourFer7KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = SourFer7.getValueAt(SourFer7.getSelectedRow(), 0) + "";
        intensidad = SourFer7.getValueAt(SourFer7.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sMojadoQuebrado += sabor.trim() + intensidad + " ";
            lblQuebrado.setText(sMojadoQuebrado);
        } else {
            SourFer7.setValueAt("", SourFer7.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_SourFer7KeyReleased

    private void GreenVeg7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GreenVeg7KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = GreenVeg7.getValueAt(GreenVeg7.getSelectedRow(), 0) + "";
        intensidad = GreenVeg7.getValueAt(GreenVeg7.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sMojadoQuebrado += sabor.trim() + intensidad + " ";
            lblQuebrado.setText(sMojadoQuebrado);
        } else {
            GreenVeg7.setValueAt("", GreenVeg7.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_GreenVeg7KeyReleased

    private void Other7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Other7KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Other7.getValueAt(Other7.getSelectedRow(), 0) + "";
        intensidad = Other7.getValueAt(Other7.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sMojadoQuebrado += sabor.trim() + intensidad + " ";
            lblQuebrado.setText(sMojadoQuebrado);
        } else {
            Other7.setValueAt("", Other7.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Other7KeyReleased

    private void Roasted7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Roasted7KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Roasted7.getValueAt(Roasted7.getSelectedRow(), 0) + "";
        intensidad = Roasted7.getValueAt(Roasted7.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sMojadoQuebrado += sabor.trim() + intensidad + " ";
            lblQuebrado.setText(sMojadoQuebrado);
        } else {
            Roasted7.setValueAt("", Roasted7.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Roasted7KeyReleased

    private void Spices7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Spices7KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Spices7.getValueAt(Spices7.getSelectedRow(), 0) + "";
        intensidad = Spices7.getValueAt(Spices7.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sMojadoQuebrado += sabor.trim() + intensidad + " ";
            lblQuebrado.setText(sMojadoQuebrado);
        } else {
            Spices7.setValueAt("", Spices7.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Spices7KeyReleased

    private void Nutty7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Nutty7KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Nutty7.getValueAt(Nutty7.getSelectedRow(), 0) + "";
        intensidad = Nutty7.getValueAt(Nutty7.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sMojadoQuebrado += sabor.trim() + intensidad + " ";
            lblQuebrado.setText(sMojadoQuebrado);
        } else {
            Nutty7.setValueAt("", Nutty7.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Nutty7KeyReleased

    private void Body10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Body10KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Body10.getValueAt(Body10.getSelectedRow(), 0) + "";
        intensidad = Body10.getValueAt(Body10.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sRemanente += sabor.trim() + intensidad + " ";
            lblRemanente.setText(sRemanente);
        } else {
            Body10.setValueAt("", Body10.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Body10KeyReleased

    private void Finish10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Finish10KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Finish10.getValueAt(Finish10.getSelectedRow(), 0) + "";
        intensidad = Finish10.getValueAt(Finish10.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sRemanente += sabor.trim() + intensidad + " ";
            lblRemanente.setText(sRemanente);
        } else {
            Finish10.setValueAt("", Finish10.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Finish10KeyReleased

    private void Sweet9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Sweet9KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Sweet9.getValueAt(Sweet9.getSelectedRow(), 0) + "";
        intensidad = Sweet9.getValueAt(Sweet9.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sRemanente += sabor.trim() + intensidad + " ";
            lblRemanente.setText(sRemanente);
        } else {
            Sweet9.setValueAt("", Sweet9.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Sweet9KeyReleased

    private void Floral9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Floral9KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Floral9.getValueAt(Floral9.getSelectedRow(), 0) + "";
        intensidad = Floral9.getValueAt(Floral9.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sRemanente += sabor.trim() + intensidad + " ";
            lblRemanente.setText(sRemanente);
        } else {
            Floral9.setValueAt("", Floral9.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Floral9KeyReleased

    private void Fruit9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Fruit9KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Fruit9.getValueAt(Fruit9.getSelectedRow(), 0) + "";
        intensidad = Fruit9.getValueAt(Fruit9.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sRemanente += sabor.trim() + intensidad + " ";
            lblRemanente.setText(sRemanente);
        } else {
            Fruit9.setValueAt("", Fruit9.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Fruit9KeyReleased

    private void SourFer9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SourFer9KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = SourFer9.getValueAt(SourFer9.getSelectedRow(), 0) + "";
        intensidad = SourFer9.getValueAt(SourFer9.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sRemanente += sabor.trim() + intensidad + " ";
            lblRemanente.setText(sRemanente);
        } else {
            SourFer9.setValueAt("", SourFer9.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_SourFer9KeyReleased

    private void GreenVeg9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GreenVeg9KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = GreenVeg9.getValueAt(GreenVeg9.getSelectedRow(), 0) + "";
        intensidad = GreenVeg9.getValueAt(GreenVeg9.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sRemanente += sabor.trim() + intensidad + " ";
            lblRemanente.setText(sRemanente);
        } else {
            GreenVeg9.setValueAt("", GreenVeg9.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_GreenVeg9KeyReleased

    private void Other9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Other9KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Other9.getValueAt(Other9.getSelectedRow(), 0) + "";
        intensidad = Other9.getValueAt(Other9.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sRemanente += sabor.trim() + intensidad + " ";
            lblRemanente.setText(sRemanente);
        } else {
            Other9.setValueAt("", Other9.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Other9KeyReleased

    private void Roasted9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Roasted9KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Roasted9.getValueAt(Roasted9.getSelectedRow(), 0) + "";
        intensidad = Roasted9.getValueAt(Roasted9.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sRemanente += sabor.trim() + intensidad + " ";
            lblRemanente.setText(sRemanente);
        } else {
            Roasted9.setValueAt("", Roasted9.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Roasted9KeyReleased

    private void Spices9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Spices9KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Spices9.getValueAt(Spices9.getSelectedRow(), 0) + "";
        intensidad = Spices9.getValueAt(Spices9.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sRemanente += sabor.trim() + intensidad + " ";
            lblRemanente.setText(sRemanente);
        } else {
            Spices9.setValueAt("", Spices9.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Spices9KeyReleased

    private void Nutty9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Nutty9KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Nutty9.getValueAt(Nutty9.getSelectedRow(), 0) + "";
        intensidad = Nutty9.getValueAt(Nutty9.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sRemanente += sabor.trim() + intensidad + " ";
            lblRemanente.setText(sRemanente);
        } else {
            Nutty9.setValueAt("", Nutty9.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Nutty9KeyReleased

    private void Body11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Body11KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Body11.getValueAt(Body11.getSelectedRow(), 0) + "";
        intensidad = Body11.getValueAt(Body11.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sAcidez += sabor.trim() + intensidad + " ";
            lblAcidez.setText(sAcidez);
        } else {
            Body11.setValueAt("", Body11.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Body11KeyReleased

    private void Finish11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Finish11KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Finish11.getValueAt(Finish11.getSelectedRow(), 0) + "";
        intensidad = Finish11.getValueAt(Finish11.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sAcidez += sabor.trim() + intensidad + " ";
            lblAcidez.setText(sAcidez);
        } else {
            Finish11.setValueAt("", Finish11.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Finish11KeyReleased

    private void Sweet10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Sweet10KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Sweet10.getValueAt(Sweet10.getSelectedRow(), 0) + "";
        intensidad = Sweet10.getValueAt(Sweet10.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sAcidez += sabor.trim() + intensidad + " ";
            lblAcidez.setText(sAcidez);
        } else {
            Sweet10.setValueAt("", Sweet10.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Sweet10KeyReleased

    private void Floral10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Floral10KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Floral10.getValueAt(Floral10.getSelectedRow(), 0) + "";
        intensidad = Floral10.getValueAt(Floral10.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sAcidez += sabor.trim() + intensidad + " ";
            lblAcidez.setText(sAcidez);
        } else {
            Floral10.setValueAt("", Floral10.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Floral10KeyReleased

    private void Fruit10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Fruit10KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Fruit10.getValueAt(Fruit10.getSelectedRow(), 0) + "";
        intensidad = Fruit10.getValueAt(Fruit10.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sAcidez += sabor.trim() + intensidad + " ";
            lblAcidez.setText(sAcidez);
        } else {
            Fruit10.setValueAt("", Fruit10.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Fruit10KeyReleased

    private void SourFer10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SourFer10KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = SourFer10.getValueAt(SourFer10.getSelectedRow(), 0) + "";
        intensidad = SourFer10.getValueAt(SourFer10.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sAcidez += sabor.trim() + intensidad + " ";
            lblAcidez.setText(sAcidez);
        } else {
            SourFer10.setValueAt("", SourFer10.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_SourFer10KeyReleased

    private void GreenVeg10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GreenVeg10KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = GreenVeg10.getValueAt(GreenVeg10.getSelectedRow(), 0) + "";
        intensidad = GreenVeg10.getValueAt(GreenVeg10.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sAcidez += sabor.trim() + intensidad + " ";
            lblAcidez.setText(sAcidez);
        } else {
            GreenVeg10.setValueAt("", GreenVeg10.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_GreenVeg10KeyReleased

    private void Other10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Other10KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Other10.getValueAt(Other10.getSelectedRow(), 0) + "";
        intensidad = Other10.getValueAt(Other10.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sAcidez += sabor.trim() + intensidad + " ";
            lblAcidez.setText(sAcidez);
        } else {
            Other10.setValueAt("", Other10.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Other10KeyReleased

    private void Roasted10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Roasted10KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Roasted10.getValueAt(Roasted10.getSelectedRow(), 0) + "";
        intensidad = Roasted10.getValueAt(Roasted10.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sAcidez += sabor.trim() + intensidad + " ";
            lblAcidez.setText(sAcidez);
        } else {
            Roasted10.setValueAt("", Roasted10.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Roasted10KeyReleased

    private void Spices10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Spices10KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Spices10.getValueAt(Spices10.getSelectedRow(), 0) + "";
        intensidad = Spices10.getValueAt(Spices10.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sAcidez += sabor.trim() + intensidad + " ";
            lblAcidez.setText(sAcidez);
        } else {
            Spices10.setValueAt("", Spices10.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Spices10KeyReleased

    private void Nutty10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Nutty10KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Nutty10.getValueAt(Nutty10.getSelectedRow(), 0) + "";
        intensidad = Nutty10.getValueAt(Nutty10.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sAcidez += sabor.trim() + intensidad + " ";
            lblAcidez.setText(sAcidez);
        } else {
            Nutty10.setValueAt("", Nutty10.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Nutty10KeyReleased

    private void Body13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Body13KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Body13.getValueAt(Body13.getSelectedRow(), 0) + "";
        intensidad = Body13.getValueAt(Body13.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sCuerpo += sabor.trim() + intensidad + " ";
            lblCuerpo.setText(sCuerpo);
        } else {
            Body13.setValueAt("", Body13.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Body13KeyReleased

    private void Finish13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Finish13KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Finish13.getValueAt(Finish13.getSelectedRow(), 0) + "";
        intensidad = Finish13.getValueAt(Finish13.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sCuerpo += sabor.trim() + intensidad + " ";
            lblCuerpo.setText(sCuerpo);
        } else {
            Finish13.setValueAt("", Finish13.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Finish13KeyReleased

    private void Sweet12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Sweet12KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Sweet12.getValueAt(Sweet12.getSelectedRow(), 0) + "";
        intensidad = Sweet12.getValueAt(Sweet12.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sCuerpo += sabor.trim() + intensidad + " ";
            lblCuerpo.setText(sCuerpo);
        } else {
            Sweet12.setValueAt("", Sweet12.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Sweet12KeyReleased

    private void Floral12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Floral12KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Floral12.getValueAt(Floral12.getSelectedRow(), 0) + "";
        intensidad = Floral12.getValueAt(Floral12.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sCuerpo += sabor.trim() + intensidad + " ";
            lblCuerpo.setText(sCuerpo);
        } else {
            Floral12.setValueAt("", Floral12.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Floral12KeyReleased

    private void Fruit12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Fruit12KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Fruit12.getValueAt(Fruit12.getSelectedRow(), 0) + "";
        intensidad = Fruit12.getValueAt(Fruit12.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sCuerpo += sabor.trim() + intensidad + " ";
            lblCuerpo.setText(sCuerpo);
        } else {
            Fruit12.setValueAt("", Fruit12.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Fruit12KeyReleased

    private void SourFer12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SourFer12KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = SourFer12.getValueAt(SourFer12.getSelectedRow(), 0) + "";
        intensidad = SourFer12.getValueAt(SourFer12.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sCuerpo += sabor.trim() + intensidad + " ";
            lblCuerpo.setText(sCuerpo);
        } else {
            SourFer12.setValueAt("", SourFer12.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_SourFer12KeyReleased

    private void GreenVeg12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GreenVeg12KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = GreenVeg12.getValueAt(GreenVeg12.getSelectedRow(), 0) + "";
        intensidad = GreenVeg12.getValueAt(GreenVeg12.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sCuerpo += sabor.trim() + intensidad + " ";
            lblCuerpo.setText(sCuerpo);
        } else {
            GreenVeg12.setValueAt("", GreenVeg12.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_GreenVeg12KeyReleased

    private void Other12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Other12KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Other12.getValueAt(Other12.getSelectedRow(), 0) + "";
        intensidad = Other12.getValueAt(Other12.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sCuerpo += sabor.trim() + intensidad + " ";
            lblCuerpo.setText(sCuerpo);
        } else {
            Other12.setValueAt("", Other12.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Other12KeyReleased

    private void Roasted12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Roasted12KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Roasted12.getValueAt(Roasted12.getSelectedRow(), 0) + "";
        intensidad = Roasted12.getValueAt(Roasted12.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sCuerpo += sabor.trim() + intensidad + " ";
            lblCuerpo.setText(sCuerpo);
        } else {
            Roasted12.setValueAt("", Roasted12.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Roasted12KeyReleased

    private void Spices12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Spices12KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Spices12.getValueAt(Spices12.getSelectedRow(), 0) + "";
        intensidad = Spices12.getValueAt(Spices12.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sCuerpo += sabor.trim() + intensidad + " ";
            lblCuerpo.setText(sCuerpo);
        } else {
            Spices12.setValueAt("", Spices12.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Spices12KeyReleased

    private void Nutty12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Nutty12KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Nutty12.getValueAt(Nutty12.getSelectedRow(), 0) + "";
        intensidad = Nutty12.getValueAt(Nutty12.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sCuerpo += sabor.trim() + intensidad + " ";
            lblCuerpo.setText(sCuerpo);
        } else {
            Nutty12.setValueAt("", Nutty12.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Nutty12KeyReleased

    private void Nutty8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Nutty8KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Nutty8.getValueAt(Nutty8.getSelectedRow(), 0) + "";
        intensidad = Nutty8.getValueAt(Nutty8.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sSabor += sabor.trim() + intensidad + " ";
            lblSabor.setText(sSabor);
        } else {
            Nutty8.setValueAt("", Nutty8.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Nutty8KeyReleased

    private void Spices8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Spices8KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Spices8.getValueAt(Spices8.getSelectedRow(), 0) + "";
        intensidad = Spices8.getValueAt(Spices8.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sSabor += sabor.trim() + intensidad + " ";
            lblSabor.setText(sSabor);
        } else {
            Spices8.setValueAt("", Spices8.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Spices8KeyReleased

    private void Roasted8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Roasted8KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Roasted8.getValueAt(Roasted8.getSelectedRow(), 0) + "";
        intensidad = Roasted8.getValueAt(Roasted8.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sSabor += sabor.trim() + intensidad + " ";
            lblSabor.setText(sSabor);
        } else {
            Roasted8.setValueAt("", Roasted8.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Roasted8KeyReleased

    private void Other8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Other8KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Other8.getValueAt(Other8.getSelectedRow(), 0) + "";
        intensidad = Other8.getValueAt(Other8.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sSabor += sabor.trim() + intensidad + " ";
            lblSabor.setText(sSabor);
        } else {
            Other8.setValueAt("", Other8.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Other8KeyReleased

    private void GreenVeg8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GreenVeg8KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = GreenVeg8.getValueAt(GreenVeg8.getSelectedRow(), 0) + "";
        intensidad = GreenVeg8.getValueAt(GreenVeg8.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sSabor += sabor.trim() + intensidad + " ";
            lblSabor.setText(sSabor);
        } else {
            GreenVeg8.setValueAt("", GreenVeg8.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_GreenVeg8KeyReleased

    private void SourFer8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SourFer8KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = SourFer8.getValueAt(SourFer8.getSelectedRow(), 0) + "";
        intensidad = SourFer8.getValueAt(SourFer8.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sSabor += sabor.trim() + intensidad + " ";
            lblSabor.setText(sSabor);
        } else {
            SourFer8.setValueAt("", SourFer8.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_SourFer8KeyReleased

    private void Fruit8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Fruit8KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Fruit8.getValueAt(Fruit8.getSelectedRow(), 0) + "";
        intensidad = Fruit8.getValueAt(Fruit8.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sSabor += sabor.trim() + intensidad + " ";
            lblSabor.setText(sSabor);
        } else {
            Fruit8.setValueAt("", Fruit8.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Fruit8KeyReleased

    private void Floral8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Floral8KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Floral8.getValueAt(Floral8.getSelectedRow(), 0) + "";
        intensidad = Floral8.getValueAt(Floral8.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sSabor += sabor.trim() + intensidad + " ";
            lblSabor.setText(sSabor);
        } else {
            Floral8.setValueAt("", Floral8.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Floral8KeyReleased

    private void Sweet8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Sweet8KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Sweet8.getValueAt(Sweet8.getSelectedRow(), 0) + "";
        intensidad = Sweet8.getValueAt(Sweet8.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sSabor += sabor.trim() + intensidad + " ";
            lblSabor.setText(sSabor);
        } else {
            Sweet8.setValueAt("", Sweet8.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Sweet8KeyReleased

    private void Finish9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Finish9KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Finish9.getValueAt(Finish9.getSelectedRow(), 0) + "";
        intensidad = Finish9.getValueAt(Finish9.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sSabor += sabor.trim() + intensidad + " ";
            lblSabor.setText(sSabor);
        } else {
            Finish9.setValueAt("", Finish9.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Finish9KeyReleased

    private void Body9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Body9KeyReleased
        // TODO add your handling code here:
        String sabor = "", intensidad = "";
        sabor = Body9.getValueAt(Body9.getSelectedRow(), 0) + "";
        intensidad = Body9.getValueAt(Body9.getSelectedRow(), 1) + "";
        
        if (intensidad.equals("1") || intensidad.equals("2") || intensidad.equals("3")) {
            sSabor += sabor.trim() + intensidad + " ";
            lblSabor.setText(sSabor);
        } else {
            Body9.setValueAt("", Body9.getSelectedRow(), 1);
        }
    }//GEN-LAST:event_Body9KeyReleased

    private void SourFer8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SourFer8KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_SourFer8KeyTyped

    private void slUniTostadoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slUniTostadoStateChanged
        // TODO add your handling code here:
        lblUniTos.setText(slUniTostado.getValue()+"");
    }//GEN-LAST:event_slUniTostadoStateChanged
    
    String sSeco = "";
    String sMojadoQuebrado = "";
    String sSabor = "";
    String sRemanente = "";
    String sAcidez = "";
    String sCuerpo = "";
    String cadenaSabores = "", cadenaOlores = "";
    
    public void guardar() {
        cadenaSabores = "Sabor:" + lblSabor.getText() + ", Sabor Remanente:" + lblRemanente.getText() + ", Acidez:" + lblAcidez.getText() + ", Cuerpo:" + lblCuerpo.getText();
        
        cadenaOlores = "Seco:" + lblSeco.getText() + ", Mojado/Quebrado:" + lblQuebrado.getText();
        
        JOptionPane.showMessageDialog(null, "Sabores:" + cadenaSabores + "\nOlores:" + cadenaOlores);
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
                        + lblFragancia.getText() + "','" + txtSabor.getText() + "','" + txtSaborRemanente.getText() + "','"
                        + txtAcidez.getText() + "','" + spAcidezInt.getValue() + "','" + txtCuerpo.getText() + "','"
                        + spCuerpoInt.getValue() + "','" + txtBalance.getText() + "','"
                        + txtCatador.getText() + "','Consenso','" + fecha + "','" + lblDenTos.getText() + "')");
                
                mdb.actualizarBasicos("update bitacoralab set taza='1', estatus='" + estatus + "', "
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
    private javax.swing.JTable Body10;
    private javax.swing.JTable Body11;
    private javax.swing.JTable Body13;
    private javax.swing.JTable Body2;
    private javax.swing.JTable Body8;
    private javax.swing.JTable Body9;
    private javax.swing.JTable Finish10;
    private javax.swing.JTable Finish11;
    private javax.swing.JTable Finish13;
    private javax.swing.JTable Finish2;
    private javax.swing.JTable Finish8;
    private javax.swing.JTable Finish9;
    private javax.swing.JTable Floral10;
    private javax.swing.JTable Floral12;
    private javax.swing.JTable Floral6;
    private javax.swing.JTable Floral7;
    private javax.swing.JTable Floral8;
    private javax.swing.JTable Floral9;
    private javax.swing.JTable Fruit10;
    private javax.swing.JTable Fruit12;
    private javax.swing.JTable Fruit6;
    private javax.swing.JTable Fruit7;
    private javax.swing.JTable Fruit8;
    private javax.swing.JTable Fruit9;
    private javax.swing.JTable GreenVeg10;
    private javax.swing.JTable GreenVeg12;
    private javax.swing.JTable GreenVeg6;
    private javax.swing.JTable GreenVeg7;
    private javax.swing.JTable GreenVeg8;
    private javax.swing.JTable GreenVeg9;
    private javax.swing.JTable Nutty10;
    private javax.swing.JTable Nutty12;
    private javax.swing.JTable Nutty6;
    private javax.swing.JTable Nutty7;
    private javax.swing.JTable Nutty8;
    private javax.swing.JTable Nutty9;
    private javax.swing.JTable Other10;
    private javax.swing.JTable Other12;
    private javax.swing.JTable Other6;
    private javax.swing.JTable Other7;
    private javax.swing.JTable Other8;
    private javax.swing.JTable Other9;
    private javax.swing.JTextField Quakers;
    private javax.swing.JTable Roasted10;
    private javax.swing.JTable Roasted12;
    private javax.swing.JTable Roasted6;
    private javax.swing.JTable Roasted7;
    private javax.swing.JTable Roasted8;
    private javax.swing.JTable Roasted9;
    private javax.swing.JTable SourFer10;
    private javax.swing.JTable SourFer12;
    private javax.swing.JTable SourFer6;
    private javax.swing.JTable SourFer7;
    private javax.swing.JTable SourFer8;
    private javax.swing.JTable SourFer9;
    private javax.swing.JTable Spices10;
    private javax.swing.JTable Spices12;
    private javax.swing.JTable Spices6;
    private javax.swing.JTable Spices7;
    private javax.swing.JTable Spices8;
    private javax.swing.JTable Spices9;
    private javax.swing.JTable Sweet10;
    private javax.swing.JTable Sweet12;
    private javax.swing.JTable Sweet6;
    private javax.swing.JTable Sweet7;
    private javax.swing.JTable Sweet8;
    private javax.swing.JTable Sweet9;
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
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane100;
    private javax.swing.JScrollPane jScrollPane101;
    private javax.swing.JScrollPane jScrollPane102;
    private javax.swing.JScrollPane jScrollPane103;
    private javax.swing.JScrollPane jScrollPane104;
    private javax.swing.JScrollPane jScrollPane105;
    private javax.swing.JScrollPane jScrollPane106;
    private javax.swing.JScrollPane jScrollPane107;
    private javax.swing.JScrollPane jScrollPane108;
    private javax.swing.JScrollPane jScrollPane109;
    private javax.swing.JScrollPane jScrollPane110;
    private javax.swing.JScrollPane jScrollPane111;
    private javax.swing.JScrollPane jScrollPane112;
    private javax.swing.JScrollPane jScrollPane113;
    private javax.swing.JScrollPane jScrollPane114;
    private javax.swing.JScrollPane jScrollPane115;
    private javax.swing.JScrollPane jScrollPane116;
    private javax.swing.JScrollPane jScrollPane117;
    private javax.swing.JScrollPane jScrollPane118;
    private javax.swing.JScrollPane jScrollPane119;
    private javax.swing.JScrollPane jScrollPane120;
    private javax.swing.JScrollPane jScrollPane121;
    private javax.swing.JScrollPane jScrollPane122;
    private javax.swing.JScrollPane jScrollPane123;
    private javax.swing.JScrollPane jScrollPane124;
    private javax.swing.JScrollPane jScrollPane125;
    private javax.swing.JScrollPane jScrollPane137;
    private javax.swing.JScrollPane jScrollPane138;
    private javax.swing.JScrollPane jScrollPane139;
    private javax.swing.JScrollPane jScrollPane140;
    private javax.swing.JScrollPane jScrollPane141;
    private javax.swing.JScrollPane jScrollPane142;
    private javax.swing.JScrollPane jScrollPane143;
    private javax.swing.JScrollPane jScrollPane144;
    private javax.swing.JScrollPane jScrollPane145;
    private javax.swing.JScrollPane jScrollPane146;
    private javax.swing.JScrollPane jScrollPane147;
    private javax.swing.JScrollPane jScrollPane54;
    private javax.swing.JScrollPane jScrollPane55;
    private javax.swing.JScrollPane jScrollPane73;
    private javax.swing.JScrollPane jScrollPane74;
    private javax.swing.JScrollPane jScrollPane75;
    private javax.swing.JScrollPane jScrollPane76;
    private javax.swing.JScrollPane jScrollPane77;
    private javax.swing.JScrollPane jScrollPane78;
    private javax.swing.JScrollPane jScrollPane79;
    private javax.swing.JScrollPane jScrollPane80;
    private javax.swing.JScrollPane jScrollPane81;
    private javax.swing.JScrollPane jScrollPane82;
    private javax.swing.JScrollPane jScrollPane83;
    private javax.swing.JScrollPane jScrollPane84;
    private javax.swing.JScrollPane jScrollPane85;
    private javax.swing.JScrollPane jScrollPane86;
    private javax.swing.JScrollPane jScrollPane87;
    private javax.swing.JScrollPane jScrollPane88;
    private javax.swing.JScrollPane jScrollPane89;
    private javax.swing.JScrollPane jScrollPane90;
    private javax.swing.JScrollPane jScrollPane91;
    private javax.swing.JScrollPane jScrollPane92;
    private javax.swing.JScrollPane jScrollPane93;
    private javax.swing.JScrollPane jScrollPane94;
    private javax.swing.JScrollPane jScrollPane95;
    private javax.swing.JScrollPane jScrollPane96;
    private javax.swing.JScrollPane jScrollPane97;
    private javax.swing.JScrollPane jScrollPane98;
    private javax.swing.JScrollPane jScrollPane99;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
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
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lblAcidez;
    private javax.swing.JLabel lblCSM;
    private javax.swing.JLabel lblComunidad;
    private javax.swing.JLabel lblCuerpo;
    private javax.swing.JLabel lblDenTos;
    private javax.swing.JLabel lblFragancia;
    private javax.swing.JLabel lblProceso;
    private javax.swing.JLabel lblPuntuacion;
    private javax.swing.JLabel lblQuebrado;
    private javax.swing.JLabel lblRemanente;
    private javax.swing.JLabel lblSabor;
    private javax.swing.JLabel lblSeco;
    private javax.swing.JLabel lblUniTos;
    private javax.swing.JSlider slNivelTostado;
    private javax.swing.JSlider slUniTostado;
    private javax.swing.JSpinner spAcidezInt;
    private javax.swing.JSpinner spCuerpoInt;
    private javax.swing.JTextField txtAcidez;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtCatador;
    private javax.swing.JTextField txtCuerpo;
    private javax.swing.JTextField txtDefectos;
    private javax.swing.JTextField txtDulzor;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtIntensidad;
    private javax.swing.JTextField txtMojado;
    private javax.swing.JTextField txtNoTazas;
    private javax.swing.JTextField txtQuebrado;
    private javax.swing.JTextField txtSabor;
    private javax.swing.JTextField txtSaborRemanente;
    private javax.swing.JTextField txtSeco;
    private javax.swing.JTextField txtTazaLim;
    private javax.swing.JTextField txtTazasCat;
    private javax.swing.JTextField txtUniTaza;
    // End of variables declaration//GEN-END:variables
}
