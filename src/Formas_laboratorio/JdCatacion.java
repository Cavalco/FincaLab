/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_laboratorio;

import Metodos_Configuraciones.metodosLaboratorio;
import java.awt.Color;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import Idioma.Propiedades;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Contador
 */
public class JdCatacion extends javax.swing.JDialog {

    /**
     * Creates new form JdCatacion
     */
    jpBitacora jpCT;
    metodosLaboratorio mdb;
    Connection cn;
    Propiedades idioma;
    String Idioma;
    String csm = "", comunindad = "", tipo = "", id, forma = "";
    String cadenaSweet = "" ,cadenaFloral = "", cadenaFrutal = "", cadenaAcFm = "", cadenaVV = "", 
            cadenaOtros = "", cadenaTostado = "", cadenaEspecias = "", cadenaNC = "";

    public JdCatacion(java.awt.Frame parent, boolean modal, String tipo, String id, String csm, String comunindad, String tipoc, String forma, Connection c, String Idioma) {
        super(parent, modal);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jdEvaluacionA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(jdEvaluacionA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(jdEvaluacionA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(jdEvaluacionA.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        this.csm = csm;
        this.comunindad = comunindad;
        this.tipo = tipoc;
        this.forma = forma;
        this.id = id;
        this.cn = c;
        this.Idioma = Idioma;
        Csm.setText(csm);
        comunidad.setText(comunindad);
        Tipo.setText(tipoc);
        mdb = new metodosLaboratorio(cn, Idioma);
        Date date = new Date(System.currentTimeMillis());
        calendario.setMaxSelectableDate(date);
    }

    String ultimoSabor = "";
    
    public void intensidadSabor(JRadioButton radio) {
        String nuevoSabor = radio.toString();
        
        if(nuevoSabor.equals(ultimoSabor)){
        cont++;    
        }
        else{
            cont = 0;
            cont++;
        }
            
        if (cont == 4) {
            cont = 0;
        }
        switch (cont) {
            case 1:
                
                radio.setBackground(Color.green);
                radio.setSelected(true);
                radio.setOpaque(true);
                break;
            case 2:
                
                radio.setBackground(Color.orange);
                radio.setSelected(true);
                radio.setOpaque(true);
                break;
            case 3:
                
                radio.setBackground(Color.red);
                radio.setSelected(true);
                radio.setOpaque(true);
                break;
            default:
                
                radio.setBackground(new Color(240, 240, 240));
                radio.setSelected(false);
                radio.setOpaque(false);
        }
        ultimoSabor = radio.toString();
    }
    
    //Guardar intensidad de sabor Dulce
    public void intensidadSweet(JRadioButton radio){
        //cadena = tipoCadena;
        switch (cont) {
            case 1:
                cadenaSweet+="1"+radio.getText()+", ";
                cadenaSweet=cadenaSweet.replace("2"+ radio.getText()+", ","" );
                cadenaSweet=cadenaSweet.replace("3"+ radio.getText()+", ","" );
                break;
            case 2:
                cadenaSweet+="2"+radio.getText()+", ";
                cadenaSweet=cadenaSweet.replace("1"+ radio.getText()+", ","" );
                cadenaSweet=cadenaSweet.replace("3"+ radio.getText()+", ","" );
                break;
            case 3:
                cadenaSweet+="3"+radio.getText()+", ";
                cadenaSweet=cadenaSweet.replace("2"+ radio.getText()+", ","" );
                cadenaSweet=cadenaSweet.replace("1"+ radio.getText()+", ","" );
                break;
            default:
                cadenaSweet=cadenaSweet.replace("3"+ radio.getText()+", ","" );
                cadenaSweet=cadenaSweet.replace("2"+ radio.getText()+", ","" );
                cadenaSweet=cadenaSweet.replace("1"+ radio.getText()+", ","" );
        }
        System.out.println("Sweet: "+cadenaSweet);
    }
    
    //Guardar intensidad de sabor Floral
    public void intensidadFloral(JRadioButton radio){
        //cadena = tipoCadena;
        switch (cont) {
            case 1:
                cadenaFloral+="1"+radio.getText()+", ";
                cadenaFloral=cadenaFloral.replace("2"+ radio.getText()+", ","" );
                cadenaFloral=cadenaFloral.replace("3"+ radio.getText()+", ","" );
                break;
            case 2:
                cadenaFloral+="2"+radio.getText()+", ";
                cadenaFloral=cadenaFloral.replace("1"+ radio.getText()+", ","" );
                cadenaFloral=cadenaFloral.replace("3"+ radio.getText()+", ","" );
                break;
            case 3:
                cadenaFloral+="3"+radio.getText()+", ";
                cadenaFloral=cadenaFloral.replace("2"+ radio.getText()+", ","" );
                cadenaFloral=cadenaFloral.replace("1"+ radio.getText()+", ","" );
                break;
            default:
                cadenaFloral=cadenaFloral.replace("3"+ radio.getText()+", ","" );
                cadenaFloral=cadenaFloral.replace("2"+ radio.getText()+", ","" );
                cadenaFloral=cadenaFloral.replace("1"+ radio.getText()+", ","" );
        }
        System.out.println("Floral: "+cadenaFloral);
    }
    
    //Guardar intensidad de sabor Frutal
    public void intensidadFrutal(JRadioButton radio){
        //cadena = tipoCadena;
        switch (cont) {
            case 1:
                cadenaFrutal+="1"+radio.getText()+", ";
                cadenaFrutal=cadenaFrutal.replace("2"+ radio.getText()+", ","" );
                cadenaFrutal=cadenaFrutal.replace("3"+ radio.getText()+", ","" );
                break;
            case 2:
                cadenaFrutal+="2"+radio.getText()+", ";
                cadenaFrutal=cadenaFrutal.replace("1"+ radio.getText()+", ","" );
                cadenaFrutal=cadenaFrutal.replace("3"+ radio.getText()+", ","" );
                break;
            case 3:
                cadenaFrutal+="3"+radio.getText()+", ";
                cadenaFrutal=cadenaFrutal.replace("2"+ radio.getText()+", ","" );
                cadenaFrutal=cadenaFrutal.replace("1"+ radio.getText()+", ","" );
                break;
            default:
                cadenaFrutal=cadenaFrutal.replace("3"+ radio.getText()+", ","" );
                cadenaFrutal=cadenaFrutal.replace("2"+ radio.getText()+", ","" );
                cadenaFrutal=cadenaFrutal.replace("1"+ radio.getText()+", ","" );
        }
        System.out.println("Frutal: "+cadenaFrutal);
    }
    //Guardar intensidad de sabor Acido/Fermentado
    public void intensidadAcFm(JRadioButton radio){
        //cadena = tipoCadena;
        switch (cont) {
            case 1:
                cadenaAcFm+="1"+radio.getText()+", ";
                cadenaAcFm=cadenaAcFm.replace("2"+ radio.getText()+", ","" );
                cadenaAcFm=cadenaAcFm.replace("3"+ radio.getText()+", ","" );
                break;
            case 2:
                cadenaAcFm+="2"+radio.getText()+", ";
                cadenaAcFm=cadenaAcFm.replace("1"+ radio.getText()+", ","" );
                cadenaAcFm=cadenaAcFm.replace("3"+ radio.getText()+", ","" );
                break;
            case 3:
                cadenaAcFm+="3"+radio.getText()+", ";
                cadenaAcFm=cadenaAcFm.replace("2"+ radio.getText()+", ","" );
                cadenaAcFm=cadenaAcFm.replace("1"+ radio.getText()+", ","" );
                break;
            default:
                cadenaAcFm=cadenaAcFm.replace("3"+ radio.getText()+", ","" );
                cadenaAcFm=cadenaAcFm.replace("2"+ radio.getText()+", ","" );
                cadenaAcFm=cadenaAcFm.replace("1"+ radio.getText()+", ","" );
        }
        System.out.println("Acido/Fermentado: "+cadenaAcFm);
    }
    
    //Guardar intensidad de sabor Verde/Vegetal
    public void intensidadVV(JRadioButton radio){
        //cadena = tipoCadena;
        switch (cont) {
            case 1:
                cadenaVV+="1"+radio.getText()+", ";
                cadenaVV=cadenaVV.replace("2"+ radio.getText()+", ","" );
                cadenaVV=cadenaVV.replace("3"+ radio.getText()+", ","" );
                break;
            case 2:
                cadenaVV+="2"+radio.getText()+", ";
                cadenaVV=cadenaVV.replace("1"+ radio.getText()+", ","" );
                cadenaVV=cadenaVV.replace("3"+ radio.getText()+", ","" );
                break;
            case 3:
                cadenaVV+="3"+radio.getText()+", ";
                cadenaVV=cadenaVV.replace("2"+ radio.getText()+", ","" );
                cadenaVV=cadenaVV.replace("1"+ radio.getText()+", ","" );
                break;
            default:
                cadenaVV=cadenaVV.replace("3"+ radio.getText()+", ","" );
                cadenaVV=cadenaVV.replace("2"+ radio.getText()+", ","" );
                cadenaVV=cadenaVV.replace("1"+ radio.getText()+", ","" );
        }
        System.out.println("Verde/Vegetal: "+cadenaVV);
    }
    
    //Guardar intensidad de sabor Otros
    public void intensidadOtros(JRadioButton radio){
        //cadena = tipoCadena;
        switch (cont) {
            case 1:
                cadenaOtros+="1"+radio.getText()+", ";
                cadenaOtros=cadenaOtros.replace("2"+ radio.getText()+", ","" );
                cadenaOtros=cadenaOtros.replace("3"+ radio.getText()+", ","" );
                break;
            case 2:
                cadenaOtros+="2"+radio.getText()+", ";
                cadenaOtros=cadenaOtros.replace("1"+ radio.getText()+", ","" );
                cadenaOtros=cadenaOtros.replace("3"+ radio.getText()+", ","" );
                break;
            case 3:
                cadenaOtros+="3"+radio.getText()+", ";
                cadenaOtros=cadenaOtros.replace("2"+ radio.getText()+", ","" );
                cadenaOtros=cadenaOtros.replace("1"+ radio.getText()+", ","" );
                break;
            default:
                cadenaOtros=cadenaOtros.replace("3"+ radio.getText()+", ","" );
                cadenaOtros=cadenaOtros.replace("2"+ radio.getText()+", ","" );
                cadenaOtros=cadenaOtros.replace("1"+ radio.getText()+", ","" );
        }
        System.out.println("Otros: "+cadenaOtros);
    }
    
    //Guardar intensidad de sabor Tostado
    public void intensidadTostado(JRadioButton radio){
        //cadena = tipoCadena;
        switch (cont) {
            case 1:
                cadenaTostado+="1"+radio.getText()+", ";
                cadenaTostado=cadenaTostado.replace("2"+ radio.getText()+", ","" );
                cadenaTostado=cadenaTostado.replace("3"+ radio.getText()+", ","" );
                break;
            case 2:
                cadenaTostado+="2"+radio.getText()+", ";
                cadenaTostado=cadenaTostado.replace("1"+ radio.getText()+", ","" );
                cadenaTostado=cadenaTostado.replace("3"+ radio.getText()+", ","" );
                break;
            case 3:
                cadenaTostado+="3"+radio.getText()+", ";
                cadenaTostado=cadenaTostado.replace("2"+ radio.getText()+", ","" );
                cadenaTostado=cadenaTostado.replace("1"+ radio.getText()+", ","" );
                break;
            default:
                cadenaTostado=cadenaTostado.replace("3"+ radio.getText()+", ","" );
                cadenaTostado=cadenaTostado.replace("2"+ radio.getText()+", ","" );
                cadenaTostado=cadenaTostado.replace("1"+ radio.getText()+", ","" );
        }
        System.out.println("Tostado: "+cadenaTostado);
    }
    
    //Guardar intensidad de sabor Especias
    public void intensidadEspecias(JRadioButton radio){
        //cadena = tipoCadena;
        switch (cont) {
            case 1:
                cadenaEspecias+="1"+radio.getText()+", ";
                cadenaEspecias=cadenaEspecias.replace("2"+ radio.getText()+", ","" );
                cadenaEspecias=cadenaEspecias.replace("3"+ radio.getText()+", ","" );
                break;
            case 2:
                cadenaEspecias+="2"+radio.getText()+", ";
                cadenaEspecias=cadenaEspecias.replace("1"+ radio.getText()+", ","" );
                cadenaEspecias=cadenaEspecias.replace("3"+ radio.getText()+", ","" );
                break;
            case 3:
                cadenaEspecias+="3"+radio.getText()+", ";
                cadenaEspecias=cadenaEspecias.replace("2"+ radio.getText()+", ","" );
                cadenaEspecias=cadenaEspecias.replace("1"+ radio.getText()+", ","" );
                break;
            default:
                cadenaEspecias=cadenaEspecias.replace("3"+ radio.getText()+", ","" );
                cadenaEspecias=cadenaEspecias.replace("2"+ radio.getText()+", ","" );
                cadenaEspecias=cadenaEspecias.replace("1"+ radio.getText()+", ","" );
        }
        System.out.println("Especias: "+cadenaEspecias);
    }
    
    //Guardar intensidad de sabor Nueces/Cacao
    public void intensidadNC(JRadioButton radio){
        //cadena = tipoCadena;
        switch (cont) {
            case 1:
                cadenaNC+="1"+radio.getText()+", ";
                cadenaNC=cadenaNC.replace("2"+ radio.getText()+", ","" );
                cadenaNC=cadenaNC.replace("3"+ radio.getText()+", ","" );
                break;
            case 2:
                cadenaNC+="2"+radio.getText()+", ";
                cadenaNC=cadenaNC.replace("1"+ radio.getText()+", ","" );
                cadenaNC=cadenaNC.replace("3"+ radio.getText()+", ","" );
                break;
            case 3:
                cadenaNC+="3"+radio.getText()+", ";
                cadenaNC=cadenaNC.replace("2"+ radio.getText()+", ","" );
                cadenaNC=cadenaNC.replace("1"+ radio.getText()+", ","" );
                break;
            default:
                cadenaNC=cadenaNC.replace("3"+ radio.getText()+", ","" );
                cadenaNC=cadenaNC.replace("2"+ radio.getText()+", ","" );
                cadenaNC=cadenaNC.replace("1"+ radio.getText()+", ","" );
        }
        System.out.println("Nueces/Cacao: "+cadenaNC);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cs = new javax.swing.JLabel();
        co = new javax.swing.JLabel();
        ti = new javax.swing.JLabel();
        Csm = new javax.swing.JLabel();
        comunidad = new javax.swing.JLabel();
        Tipo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        Puntuacion = new javax.swing.JLabel();
        Tazas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        numtazasdefectos = new javax.swing.JTextField();
        intensidadefectos = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        Defectos = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        uniformtaza = new javax.swing.JTextField();
        tazalimpia = new javax.swing.JTextField();
        dulzor = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        quakers = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel35 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        nt1 = new javax.swing.JCheckBox();
        nt2 = new javax.swing.JCheckBox();
        nt3 = new javax.swing.JCheckBox();
        nt4 = new javax.swing.JCheckBox();
        nt5 = new javax.swing.JCheckBox();
        uniformidadtostado = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        DenTost = new javax.swing.JTextField();
        Acidity = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Balance = new javax.swing.JTextField();
        Catador = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        Body = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lessAcidity = new javax.swing.JButton();
        plusAcidity = new javax.swing.JButton();
        Acidityteslider = new javax.swing.JSlider();
        plusBody = new javax.swing.JButton();
        lessBody = new javax.swing.JButton();
        Bodyslider = new javax.swing.JSlider();
        lessBalance = new javax.swing.JButton();
        lessCatador = new javax.swing.JButton();
        plusBalance = new javax.swing.JButton();
        plusCatador = new javax.swing.JButton();
        Catadorslider = new javax.swing.JSlider();
        intensidadacidity = new javax.swing.JSpinner();
        intensidadbody = new javax.swing.JSpinner();
        Balanceslider = new javax.swing.JSlider();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        calendario = new com.toedter.calendar.JDateChooser();
        jLabel85 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        plusdry = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pluswet = new javax.swing.JButton();
        plusbreak = new javax.swing.JButton();
        breaks = new javax.swing.JTextField();
        wet = new javax.swing.JTextField();
        dry = new javax.swing.JTextField();
        lessdry = new javax.swing.JButton();
        lesswet = new javax.swing.JButton();
        lessbreak = new javax.swing.JButton();
        breakslider = new javax.swing.JSlider();
        wetslider = new javax.swing.JSlider();
        dryslider = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        aroma = new javax.swing.JLabel();
        Aftertaste = new javax.swing.JTextField();
        Aftertasteslider = new javax.swing.JSlider();
        jLabel26 = new javax.swing.JLabel();
        lessaftertaste = new javax.swing.JButton();
        plusaftertaste = new javax.swing.JButton();
        flavorslider = new javax.swing.JSlider();
        lessflavor = new javax.swing.JButton();
        flavor = new javax.swing.JTextField();
        plusflavor = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        contenedorpaneles = new javax.swing.JTabbedPane();
        Dry = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        BrownSugar = new javax.swing.JRadioButton();
        MapleSugar = new javax.swing.JRadioButton();
        Carmelized = new javax.swing.JRadioButton();
        Molasses = new javax.swing.JRadioButton();
        Honey = new javax.swing.JRadioButton();
        Vanilla = new javax.swing.JRadioButton();
        Sweet = new javax.swing.JRadioButton();
        jPanel16 = new javax.swing.JPanel();
        Blackberry = new javax.swing.JRadioButton();
        Raspberry = new javax.swing.JRadioButton();
        Blueberry = new javax.swing.JRadioButton();
        Strawberry = new javax.swing.JRadioButton();
        Raisen = new javax.swing.JRadioButton();
        Prune = new javax.swing.JRadioButton();
        Coconut = new javax.swing.JRadioButton();
        Cherry = new javax.swing.JRadioButton();
        Pomagranite = new javax.swing.JRadioButton();
        Pinneapple = new javax.swing.JRadioButton();
        Grape = new javax.swing.JRadioButton();
        Apple = new javax.swing.JRadioButton();
        Peach = new javax.swing.JRadioButton();
        Pear = new javax.swing.JRadioButton();
        Grapefruit = new javax.swing.JRadioButton();
        Orange = new javax.swing.JRadioButton();
        Lemon = new javax.swing.JRadioButton();
        Lime = new javax.swing.JRadioButton();
        Fruity = new javax.swing.JRadioButton();
        Berry = new javax.swing.JRadioButton();
        DriedFruit = new javax.swing.JRadioButton();
        Otherfruit = new javax.swing.JRadioButton();
        Citrusfruit = new javax.swing.JRadioButton();
        jPanel18 = new javax.swing.JPanel();
        Vinegar = new javax.swing.JRadioButton();
        Rancidbutter = new javax.swing.JRadioButton();
        RancidCheese = new javax.swing.JRadioButton();
        Winey = new javax.swing.JRadioButton();
        Whiskey = new javax.swing.JRadioButton();
        Fermented = new javax.swing.JRadioButton();
        Overripe = new javax.swing.JRadioButton();
        OrangeAcidity = new javax.swing.JRadioButton();
        AppleAcidity = new javax.swing.JRadioButton();
        Sour = new javax.swing.JRadioButton();
        sour = new javax.swing.JRadioButton();
        Alcohol = new javax.swing.JRadioButton();
        jPanel20 = new javax.swing.JPanel();
        OliveOil = new javax.swing.JRadioButton();
        Raw = new javax.swing.JRadioButton();
        Underripe = new javax.swing.JRadioButton();
        Peapod = new javax.swing.JRadioButton();
        Fresh = new javax.swing.JRadioButton();
        DarkGreen = new javax.swing.JRadioButton();
        Vegetative = new javax.swing.JRadioButton();
        Haylike = new javax.swing.JRadioButton();
        Herblike = new javax.swing.JRadioButton();
        Beany = new javax.swing.JRadioButton();
        Green = new javax.swing.JRadioButton();
        jPanel19 = new javax.swing.JPanel();
        Stale = new javax.swing.JRadioButton();
        Cardboard = new javax.swing.JRadioButton();
        Papery = new javax.swing.JRadioButton();
        Woody = new javax.swing.JRadioButton();
        MoldyDamp = new javax.swing.JRadioButton();
        MustyDusty = new javax.swing.JRadioButton();
        MustyEarthy = new javax.swing.JRadioButton();
        Animalic = new javax.swing.JRadioButton();
        MeatyBrothy = new javax.swing.JRadioButton();
        Phenolic = new javax.swing.JRadioButton();
        Bitter = new javax.swing.JRadioButton();
        Salty = new javax.swing.JRadioButton();
        Medicinal = new javax.swing.JRadioButton();
        Petroleum = new javax.swing.JRadioButton();
        Skunky = new javax.swing.JRadioButton();
        Rubber = new javax.swing.JRadioButton();
        Other = new javax.swing.JRadioButton();
        PaperyM = new javax.swing.JRadioButton();
        Chemical = new javax.swing.JRadioButton();
        jPanel17 = new javax.swing.JPanel();
        PipeTobacco = new javax.swing.JRadioButton();
        Tobacco = new javax.swing.JRadioButton();
        Acrid = new javax.swing.JRadioButton();
        Ashy = new javax.swing.JRadioButton();
        Smoky = new javax.swing.JRadioButton();
        BrownRoast = new javax.swing.JRadioButton();
        Grain = new javax.swing.JRadioButton();
        Malt = new javax.swing.JRadioButton();
        Roasted = new javax.swing.JRadioButton();
        Burnt = new javax.swing.JRadioButton();
        Cereal = new javax.swing.JRadioButton();
        jPanel21 = new javax.swing.JPanel();
        Pungent = new javax.swing.JRadioButton();
        Pepper = new javax.swing.JRadioButton();
        Anise = new javax.swing.JRadioButton();
        Nutmeg = new javax.swing.JRadioButton();
        Cinnamon = new javax.swing.JRadioButton();
        Clove = new javax.swing.JRadioButton();
        Spices = new javax.swing.JRadioButton();
        Brownspices = new javax.swing.JRadioButton();
        jPanel22 = new javax.swing.JPanel();
        Peanuts = new javax.swing.JRadioButton();
        Hazelenut = new javax.swing.JRadioButton();
        Almond = new javax.swing.JRadioButton();
        Chocolate = new javax.swing.JRadioButton();
        DarkChocolate = new javax.swing.JRadioButton();
        Nutty = new javax.swing.JRadioButton();
        Nuttycocoa = new javax.swing.JRadioButton();
        Cocoa = new javax.swing.JRadioButton();
        jPanel15 = new javax.swing.JPanel();
        Blacktea = new javax.swing.JRadioButton();
        Chamomile = new javax.swing.JRadioButton();
        Rose = new javax.swing.JRadioButton();
        Jasmine = new javax.swing.JRadioButton();
        Floral = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        BrownSugar1 = new javax.swing.JRadioButton();
        MapleSugar1 = new javax.swing.JRadioButton();
        Carmelized1 = new javax.swing.JRadioButton();
        Molasses1 = new javax.swing.JRadioButton();
        Honey1 = new javax.swing.JRadioButton();
        Vanilla1 = new javax.swing.JRadioButton();
        Sweet1 = new javax.swing.JRadioButton();
        jPanel24 = new javax.swing.JPanel();
        Blackberry1 = new javax.swing.JRadioButton();
        Raspberry1 = new javax.swing.JRadioButton();
        Blueberry1 = new javax.swing.JRadioButton();
        Strawberry1 = new javax.swing.JRadioButton();
        Raisen1 = new javax.swing.JRadioButton();
        Prune1 = new javax.swing.JRadioButton();
        Coconut1 = new javax.swing.JRadioButton();
        Cherry1 = new javax.swing.JRadioButton();
        Pomagranite1 = new javax.swing.JRadioButton();
        Pinneapple1 = new javax.swing.JRadioButton();
        Grape1 = new javax.swing.JRadioButton();
        Apple1 = new javax.swing.JRadioButton();
        Peach1 = new javax.swing.JRadioButton();
        Pear1 = new javax.swing.JRadioButton();
        Grapefruit1 = new javax.swing.JRadioButton();
        Orange1 = new javax.swing.JRadioButton();
        Lemon1 = new javax.swing.JRadioButton();
        Lime1 = new javax.swing.JRadioButton();
        Fruity1 = new javax.swing.JRadioButton();
        Berry1 = new javax.swing.JRadioButton();
        DriedFruit1 = new javax.swing.JRadioButton();
        Otherfruit1 = new javax.swing.JRadioButton();
        Citrusfruit1 = new javax.swing.JRadioButton();
        jPanel25 = new javax.swing.JPanel();
        Blacktea1 = new javax.swing.JRadioButton();
        Chamomile1 = new javax.swing.JRadioButton();
        Rose1 = new javax.swing.JRadioButton();
        Jasmine1 = new javax.swing.JRadioButton();
        Floral1 = new javax.swing.JRadioButton();
        jPanel26 = new javax.swing.JPanel();
        Vinegar1 = new javax.swing.JRadioButton();
        Rancidbutter1 = new javax.swing.JRadioButton();
        RancidCheese1 = new javax.swing.JRadioButton();
        Winey1 = new javax.swing.JRadioButton();
        Whiskey1 = new javax.swing.JRadioButton();
        Fermented1 = new javax.swing.JRadioButton();
        Overripe1 = new javax.swing.JRadioButton();
        OrangeAcidity1 = new javax.swing.JRadioButton();
        AppleAcidity1 = new javax.swing.JRadioButton();
        Sour1 = new javax.swing.JRadioButton();
        sour1 = new javax.swing.JRadioButton();
        Alcohol1 = new javax.swing.JRadioButton();
        jPanel27 = new javax.swing.JPanel();
        OliveOil1 = new javax.swing.JRadioButton();
        Raw1 = new javax.swing.JRadioButton();
        Underripe1 = new javax.swing.JRadioButton();
        Peapod1 = new javax.swing.JRadioButton();
        Fresh1 = new javax.swing.JRadioButton();
        DarkGreen1 = new javax.swing.JRadioButton();
        Vegetative1 = new javax.swing.JRadioButton();
        Haylike1 = new javax.swing.JRadioButton();
        Herblike1 = new javax.swing.JRadioButton();
        Beany1 = new javax.swing.JRadioButton();
        Green1 = new javax.swing.JRadioButton();
        jPanel28 = new javax.swing.JPanel();
        Stale1 = new javax.swing.JRadioButton();
        Cardboard1 = new javax.swing.JRadioButton();
        Papery1 = new javax.swing.JRadioButton();
        Woody1 = new javax.swing.JRadioButton();
        MoldyDamp1 = new javax.swing.JRadioButton();
        MustyDusty1 = new javax.swing.JRadioButton();
        MustyEarthy1 = new javax.swing.JRadioButton();
        Animalic1 = new javax.swing.JRadioButton();
        MeatyBrothy1 = new javax.swing.JRadioButton();
        Phenolic1 = new javax.swing.JRadioButton();
        Bitter1 = new javax.swing.JRadioButton();
        Salty1 = new javax.swing.JRadioButton();
        Medicinal1 = new javax.swing.JRadioButton();
        Petroleum1 = new javax.swing.JRadioButton();
        Skunky1 = new javax.swing.JRadioButton();
        Rubber1 = new javax.swing.JRadioButton();
        Other1 = new javax.swing.JRadioButton();
        PaperyM1 = new javax.swing.JRadioButton();
        Chemical1 = new javax.swing.JRadioButton();
        jPanel29 = new javax.swing.JPanel();
        PipeTobacco1 = new javax.swing.JRadioButton();
        Tobacco1 = new javax.swing.JRadioButton();
        Acrid1 = new javax.swing.JRadioButton();
        Ashy1 = new javax.swing.JRadioButton();
        Smoky1 = new javax.swing.JRadioButton();
        BrownRoast1 = new javax.swing.JRadioButton();
        Grain1 = new javax.swing.JRadioButton();
        Malt1 = new javax.swing.JRadioButton();
        Roasted1 = new javax.swing.JRadioButton();
        Burnt1 = new javax.swing.JRadioButton();
        Cereal1 = new javax.swing.JRadioButton();
        jPanel30 = new javax.swing.JPanel();
        Pungent1 = new javax.swing.JRadioButton();
        Pepper1 = new javax.swing.JRadioButton();
        Anise1 = new javax.swing.JRadioButton();
        Nutmeg1 = new javax.swing.JRadioButton();
        Cinnamon1 = new javax.swing.JRadioButton();
        Clove1 = new javax.swing.JRadioButton();
        Spices1 = new javax.swing.JRadioButton();
        Brownspices1 = new javax.swing.JRadioButton();
        jPanel31 = new javax.swing.JPanel();
        Peanuts1 = new javax.swing.JRadioButton();
        Hazelenut1 = new javax.swing.JRadioButton();
        Almond1 = new javax.swing.JRadioButton();
        Chocolate1 = new javax.swing.JRadioButton();
        DarkChocolate1 = new javax.swing.JRadioButton();
        Nutty1 = new javax.swing.JRadioButton();
        Nuttycocoa1 = new javax.swing.JRadioButton();
        Cocoa1 = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel62 = new javax.swing.JPanel();
        BrownSugar2 = new javax.swing.JRadioButton();
        MapleSugar2 = new javax.swing.JRadioButton();
        Carmelized2 = new javax.swing.JRadioButton();
        Molasses2 = new javax.swing.JRadioButton();
        Honey2 = new javax.swing.JRadioButton();
        Vanilla2 = new javax.swing.JRadioButton();
        Sweet2 = new javax.swing.JRadioButton();
        jPanel63 = new javax.swing.JPanel();
        Blacktea2 = new javax.swing.JRadioButton();
        Chamomile2 = new javax.swing.JRadioButton();
        Rose2 = new javax.swing.JRadioButton();
        Jasmine2 = new javax.swing.JRadioButton();
        Floral2 = new javax.swing.JRadioButton();
        jPanel64 = new javax.swing.JPanel();
        Blackberry2 = new javax.swing.JRadioButton();
        Raspberry2 = new javax.swing.JRadioButton();
        Blueberry2 = new javax.swing.JRadioButton();
        Strawberry2 = new javax.swing.JRadioButton();
        Raisen2 = new javax.swing.JRadioButton();
        Prune2 = new javax.swing.JRadioButton();
        Coconut2 = new javax.swing.JRadioButton();
        Cherry2 = new javax.swing.JRadioButton();
        Pomagranite2 = new javax.swing.JRadioButton();
        Pinneapple2 = new javax.swing.JRadioButton();
        Grape2 = new javax.swing.JRadioButton();
        Apple2 = new javax.swing.JRadioButton();
        Peach2 = new javax.swing.JRadioButton();
        Pear2 = new javax.swing.JRadioButton();
        Grapefruit2 = new javax.swing.JRadioButton();
        Orange2 = new javax.swing.JRadioButton();
        Lemon2 = new javax.swing.JRadioButton();
        Lime2 = new javax.swing.JRadioButton();
        Fruity2 = new javax.swing.JRadioButton();
        Berry2 = new javax.swing.JRadioButton();
        DriedFruit2 = new javax.swing.JRadioButton();
        Otherfruit2 = new javax.swing.JRadioButton();
        Citrusfruit2 = new javax.swing.JRadioButton();
        jPanel65 = new javax.swing.JPanel();
        Vinegar2 = new javax.swing.JRadioButton();
        Rancidbutter2 = new javax.swing.JRadioButton();
        RancidCheese2 = new javax.swing.JRadioButton();
        Winey2 = new javax.swing.JRadioButton();
        Whiskey2 = new javax.swing.JRadioButton();
        Fermented2 = new javax.swing.JRadioButton();
        Overripe2 = new javax.swing.JRadioButton();
        OrangeAcidity2 = new javax.swing.JRadioButton();
        AppleAcidity2 = new javax.swing.JRadioButton();
        Sour2 = new javax.swing.JRadioButton();
        sour2 = new javax.swing.JRadioButton();
        Alcohol2 = new javax.swing.JRadioButton();
        jPanel66 = new javax.swing.JPanel();
        OliveOil2 = new javax.swing.JRadioButton();
        Raw2 = new javax.swing.JRadioButton();
        Underripe2 = new javax.swing.JRadioButton();
        Peapod2 = new javax.swing.JRadioButton();
        Fresh2 = new javax.swing.JRadioButton();
        DarkGreen2 = new javax.swing.JRadioButton();
        Vegetative2 = new javax.swing.JRadioButton();
        Haylike2 = new javax.swing.JRadioButton();
        Herblike2 = new javax.swing.JRadioButton();
        Beany2 = new javax.swing.JRadioButton();
        Green2 = new javax.swing.JRadioButton();
        jPanel67 = new javax.swing.JPanel();
        Stale2 = new javax.swing.JRadioButton();
        Cardboard2 = new javax.swing.JRadioButton();
        Papery2 = new javax.swing.JRadioButton();
        Woody2 = new javax.swing.JRadioButton();
        MoldyDamp2 = new javax.swing.JRadioButton();
        MustyDusty2 = new javax.swing.JRadioButton();
        MustyEarthy2 = new javax.swing.JRadioButton();
        Animalic2 = new javax.swing.JRadioButton();
        MeatyBrothy2 = new javax.swing.JRadioButton();
        Phenolic2 = new javax.swing.JRadioButton();
        Bitter2 = new javax.swing.JRadioButton();
        Salty2 = new javax.swing.JRadioButton();
        Medicinal2 = new javax.swing.JRadioButton();
        Petroleum2 = new javax.swing.JRadioButton();
        Skunky2 = new javax.swing.JRadioButton();
        Rubber2 = new javax.swing.JRadioButton();
        Other2 = new javax.swing.JRadioButton();
        PaperyM2 = new javax.swing.JRadioButton();
        Chemical2 = new javax.swing.JRadioButton();
        jPanel68 = new javax.swing.JPanel();
        PipeTobacco2 = new javax.swing.JRadioButton();
        Tobacco2 = new javax.swing.JRadioButton();
        Acrid2 = new javax.swing.JRadioButton();
        Ashy2 = new javax.swing.JRadioButton();
        Smoky2 = new javax.swing.JRadioButton();
        BrownRoast2 = new javax.swing.JRadioButton();
        Grain2 = new javax.swing.JRadioButton();
        Malt2 = new javax.swing.JRadioButton();
        Roasted2 = new javax.swing.JRadioButton();
        Burnt2 = new javax.swing.JRadioButton();
        Cereal2 = new javax.swing.JRadioButton();
        jPanel69 = new javax.swing.JPanel();
        Pungent2 = new javax.swing.JRadioButton();
        Pepper2 = new javax.swing.JRadioButton();
        Anise2 = new javax.swing.JRadioButton();
        Nutmeg2 = new javax.swing.JRadioButton();
        Cinnamon2 = new javax.swing.JRadioButton();
        Clove2 = new javax.swing.JRadioButton();
        Spices2 = new javax.swing.JRadioButton();
        Brownspices2 = new javax.swing.JRadioButton();
        jPanel70 = new javax.swing.JPanel();
        Peanuts2 = new javax.swing.JRadioButton();
        Hazelenut2 = new javax.swing.JRadioButton();
        Almond2 = new javax.swing.JRadioButton();
        Chocolate2 = new javax.swing.JRadioButton();
        DarkChocolate2 = new javax.swing.JRadioButton();
        Nutty2 = new javax.swing.JRadioButton();
        Nuttycocoa2 = new javax.swing.JRadioButton();
        Cocoa2 = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        BrownSugar3 = new javax.swing.JRadioButton();
        MapleSugar3 = new javax.swing.JRadioButton();
        Carmelized3 = new javax.swing.JRadioButton();
        Molasses3 = new javax.swing.JRadioButton();
        Honey3 = new javax.swing.JRadioButton();
        Vanilla3 = new javax.swing.JRadioButton();
        Sweet3 = new javax.swing.JRadioButton();
        jPanel33 = new javax.swing.JPanel();
        Blackberry3 = new javax.swing.JRadioButton();
        Raspberry3 = new javax.swing.JRadioButton();
        Blueberry3 = new javax.swing.JRadioButton();
        Strawberry3 = new javax.swing.JRadioButton();
        Raisen3 = new javax.swing.JRadioButton();
        Prune3 = new javax.swing.JRadioButton();
        Coconut3 = new javax.swing.JRadioButton();
        Cherry3 = new javax.swing.JRadioButton();
        Pomagranite3 = new javax.swing.JRadioButton();
        Pinneapple3 = new javax.swing.JRadioButton();
        Grape3 = new javax.swing.JRadioButton();
        Apple3 = new javax.swing.JRadioButton();
        Peach3 = new javax.swing.JRadioButton();
        Pear3 = new javax.swing.JRadioButton();
        Grapefruit3 = new javax.swing.JRadioButton();
        Orange3 = new javax.swing.JRadioButton();
        Lemon3 = new javax.swing.JRadioButton();
        Lime3 = new javax.swing.JRadioButton();
        Fruity3 = new javax.swing.JRadioButton();
        Berry3 = new javax.swing.JRadioButton();
        DriedFruit3 = new javax.swing.JRadioButton();
        Otherfruit3 = new javax.swing.JRadioButton();
        Citrusfruit3 = new javax.swing.JRadioButton();
        jPanel34 = new javax.swing.JPanel();
        Blacktea3 = new javax.swing.JRadioButton();
        Chamomile3 = new javax.swing.JRadioButton();
        Rose3 = new javax.swing.JRadioButton();
        Jasmine3 = new javax.swing.JRadioButton();
        Floral3 = new javax.swing.JRadioButton();
        jPanel35 = new javax.swing.JPanel();
        Vinegar3 = new javax.swing.JRadioButton();
        Rancidbutter3 = new javax.swing.JRadioButton();
        RancidCheese3 = new javax.swing.JRadioButton();
        Winey3 = new javax.swing.JRadioButton();
        Whiskey3 = new javax.swing.JRadioButton();
        Fermented3 = new javax.swing.JRadioButton();
        Overripe3 = new javax.swing.JRadioButton();
        OrangeAcidity3 = new javax.swing.JRadioButton();
        AppleAcidity3 = new javax.swing.JRadioButton();
        Sour3 = new javax.swing.JRadioButton();
        sour3 = new javax.swing.JRadioButton();
        Alcohol3 = new javax.swing.JRadioButton();
        jPanel36 = new javax.swing.JPanel();
        OliveOil3 = new javax.swing.JRadioButton();
        Raw3 = new javax.swing.JRadioButton();
        Underripe3 = new javax.swing.JRadioButton();
        Peapod3 = new javax.swing.JRadioButton();
        Fresh3 = new javax.swing.JRadioButton();
        DarkGreen3 = new javax.swing.JRadioButton();
        Vegetative3 = new javax.swing.JRadioButton();
        Haylike3 = new javax.swing.JRadioButton();
        Herblike3 = new javax.swing.JRadioButton();
        Beany3 = new javax.swing.JRadioButton();
        Green3 = new javax.swing.JRadioButton();
        jPanel37 = new javax.swing.JPanel();
        Stale3 = new javax.swing.JRadioButton();
        Cardboard3 = new javax.swing.JRadioButton();
        Papery3 = new javax.swing.JRadioButton();
        Woody3 = new javax.swing.JRadioButton();
        MoldyDamp3 = new javax.swing.JRadioButton();
        MustyDusty3 = new javax.swing.JRadioButton();
        MustyEarthy3 = new javax.swing.JRadioButton();
        Animalic3 = new javax.swing.JRadioButton();
        MeatyBrothy3 = new javax.swing.JRadioButton();
        Phenolic3 = new javax.swing.JRadioButton();
        Bitter3 = new javax.swing.JRadioButton();
        Salty3 = new javax.swing.JRadioButton();
        Medicinal3 = new javax.swing.JRadioButton();
        Petroleum3 = new javax.swing.JRadioButton();
        Skunky3 = new javax.swing.JRadioButton();
        Rubber3 = new javax.swing.JRadioButton();
        Other3 = new javax.swing.JRadioButton();
        PaperyM3 = new javax.swing.JRadioButton();
        Chemical3 = new javax.swing.JRadioButton();
        jPanel38 = new javax.swing.JPanel();
        PipeTobacco3 = new javax.swing.JRadioButton();
        Tobacco3 = new javax.swing.JRadioButton();
        Acrid3 = new javax.swing.JRadioButton();
        Ashy3 = new javax.swing.JRadioButton();
        Smoky3 = new javax.swing.JRadioButton();
        BrownRoast3 = new javax.swing.JRadioButton();
        Grain3 = new javax.swing.JRadioButton();
        Malt3 = new javax.swing.JRadioButton();
        Roasted3 = new javax.swing.JRadioButton();
        Burnt3 = new javax.swing.JRadioButton();
        Cereal3 = new javax.swing.JRadioButton();
        jPanel39 = new javax.swing.JPanel();
        Pungent3 = new javax.swing.JRadioButton();
        Pepper3 = new javax.swing.JRadioButton();
        Anise3 = new javax.swing.JRadioButton();
        Nutmeg3 = new javax.swing.JRadioButton();
        Cinnamon3 = new javax.swing.JRadioButton();
        Clove3 = new javax.swing.JRadioButton();
        Spices3 = new javax.swing.JRadioButton();
        Brownspices3 = new javax.swing.JRadioButton();
        jPanel40 = new javax.swing.JPanel();
        Peanuts3 = new javax.swing.JRadioButton();
        Hazelenut3 = new javax.swing.JRadioButton();
        Almond3 = new javax.swing.JRadioButton();
        Chocolate3 = new javax.swing.JRadioButton();
        DarkChocolate3 = new javax.swing.JRadioButton();
        Nutty3 = new javax.swing.JRadioButton();
        Nuttycocoa3 = new javax.swing.JRadioButton();
        Cocoa3 = new javax.swing.JRadioButton();
        Fisnish = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        Medium = new javax.swing.JRadioButton();
        Long = new javax.swing.JRadioButton();
        jLabel84 = new javax.swing.JLabel();
        Short1 = new javax.swing.JRadioButton();
        Dryf = new javax.swing.JRadioButton();
        Astringent = new javax.swing.JRadioButton();
        jPanel41 = new javax.swing.JPanel();
        BrownSugar4 = new javax.swing.JRadioButton();
        MapleSugar4 = new javax.swing.JRadioButton();
        Carmelized4 = new javax.swing.JRadioButton();
        Molasses4 = new javax.swing.JRadioButton();
        Honey4 = new javax.swing.JRadioButton();
        Vanilla4 = new javax.swing.JRadioButton();
        Sweet4 = new javax.swing.JRadioButton();
        jPanel42 = new javax.swing.JPanel();
        Blackberry4 = new javax.swing.JRadioButton();
        Raspberry4 = new javax.swing.JRadioButton();
        Blueberry4 = new javax.swing.JRadioButton();
        Strawberry4 = new javax.swing.JRadioButton();
        Raisen4 = new javax.swing.JRadioButton();
        Prune4 = new javax.swing.JRadioButton();
        Coconut4 = new javax.swing.JRadioButton();
        Cherry4 = new javax.swing.JRadioButton();
        Pomagranite4 = new javax.swing.JRadioButton();
        Pinneapple4 = new javax.swing.JRadioButton();
        Grape4 = new javax.swing.JRadioButton();
        Apple4 = new javax.swing.JRadioButton();
        Peach4 = new javax.swing.JRadioButton();
        Pear4 = new javax.swing.JRadioButton();
        Grapefruit4 = new javax.swing.JRadioButton();
        Orange4 = new javax.swing.JRadioButton();
        Lemon4 = new javax.swing.JRadioButton();
        Lime4 = new javax.swing.JRadioButton();
        Fruity4 = new javax.swing.JRadioButton();
        Berry4 = new javax.swing.JRadioButton();
        DriedFruit4 = new javax.swing.JRadioButton();
        Otherfruit4 = new javax.swing.JRadioButton();
        Citrusfruit4 = new javax.swing.JRadioButton();
        jPanel43 = new javax.swing.JPanel();
        Blacktea4 = new javax.swing.JRadioButton();
        Chamomile4 = new javax.swing.JRadioButton();
        Rose4 = new javax.swing.JRadioButton();
        Jasmine4 = new javax.swing.JRadioButton();
        Floral4 = new javax.swing.JRadioButton();
        jPanel44 = new javax.swing.JPanel();
        Vinegar4 = new javax.swing.JRadioButton();
        Rancidbutter4 = new javax.swing.JRadioButton();
        RancidCheese4 = new javax.swing.JRadioButton();
        Winey4 = new javax.swing.JRadioButton();
        Whiskey4 = new javax.swing.JRadioButton();
        Fermented4 = new javax.swing.JRadioButton();
        Overripe4 = new javax.swing.JRadioButton();
        OrangeAcidity4 = new javax.swing.JRadioButton();
        AppleAcidity4 = new javax.swing.JRadioButton();
        Sour4 = new javax.swing.JRadioButton();
        sour4 = new javax.swing.JRadioButton();
        Alcohol4 = new javax.swing.JRadioButton();
        jPanel45 = new javax.swing.JPanel();
        OliveOil4 = new javax.swing.JRadioButton();
        Raw4 = new javax.swing.JRadioButton();
        Underripe4 = new javax.swing.JRadioButton();
        Peapod4 = new javax.swing.JRadioButton();
        Fresh4 = new javax.swing.JRadioButton();
        DarkGreen4 = new javax.swing.JRadioButton();
        Vegetative4 = new javax.swing.JRadioButton();
        Haylike4 = new javax.swing.JRadioButton();
        Herblike4 = new javax.swing.JRadioButton();
        Beany4 = new javax.swing.JRadioButton();
        Green4 = new javax.swing.JRadioButton();
        jPanel46 = new javax.swing.JPanel();
        Stale4 = new javax.swing.JRadioButton();
        Cardboard4 = new javax.swing.JRadioButton();
        Papery4 = new javax.swing.JRadioButton();
        Woody4 = new javax.swing.JRadioButton();
        MoldyDamp4 = new javax.swing.JRadioButton();
        MustyDusty4 = new javax.swing.JRadioButton();
        MustyEarthy4 = new javax.swing.JRadioButton();
        Animalic4 = new javax.swing.JRadioButton();
        MeatyBrothy4 = new javax.swing.JRadioButton();
        Phenolic4 = new javax.swing.JRadioButton();
        Bitter4 = new javax.swing.JRadioButton();
        Salty4 = new javax.swing.JRadioButton();
        Medicinal4 = new javax.swing.JRadioButton();
        Petroleum4 = new javax.swing.JRadioButton();
        Skunky4 = new javax.swing.JRadioButton();
        Rubber4 = new javax.swing.JRadioButton();
        Other4 = new javax.swing.JRadioButton();
        PaperyM4 = new javax.swing.JRadioButton();
        Chemical4 = new javax.swing.JRadioButton();
        jPanel47 = new javax.swing.JPanel();
        PipeTobacco4 = new javax.swing.JRadioButton();
        Tobacco4 = new javax.swing.JRadioButton();
        Acrid4 = new javax.swing.JRadioButton();
        Ashy4 = new javax.swing.JRadioButton();
        Smoky4 = new javax.swing.JRadioButton();
        BrownRoast4 = new javax.swing.JRadioButton();
        Grain4 = new javax.swing.JRadioButton();
        Malt4 = new javax.swing.JRadioButton();
        Roasted4 = new javax.swing.JRadioButton();
        Burnt4 = new javax.swing.JRadioButton();
        Cereal4 = new javax.swing.JRadioButton();
        jPanel48 = new javax.swing.JPanel();
        Pungent4 = new javax.swing.JRadioButton();
        Pepper4 = new javax.swing.JRadioButton();
        Anise4 = new javax.swing.JRadioButton();
        Nutmeg4 = new javax.swing.JRadioButton();
        Cinnamon4 = new javax.swing.JRadioButton();
        Clove4 = new javax.swing.JRadioButton();
        Spices4 = new javax.swing.JRadioButton();
        Brownspices4 = new javax.swing.JRadioButton();
        jPanel49 = new javax.swing.JPanel();
        Peanuts4 = new javax.swing.JRadioButton();
        Hazelenut4 = new javax.swing.JRadioButton();
        Almond4 = new javax.swing.JRadioButton();
        Chocolate4 = new javax.swing.JRadioButton();
        DarkChocolate4 = new javax.swing.JRadioButton();
        Nutty4 = new javax.swing.JRadioButton();
        Nuttycocoa4 = new javax.swing.JRadioButton();
        Cocoa4 = new javax.swing.JRadioButton();
        jPanel61 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        Thin1 = new javax.swing.JRadioButton();
        Mediumbody1 = new javax.swing.JRadioButton();
        Heavy1 = new javax.swing.JRadioButton();
        Syrupy1 = new javax.swing.JRadioButton();
        Oily1 = new javax.swing.JRadioButton();
        Smooth1 = new javax.swing.JRadioButton();
        Acidityp = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        Vinegar5 = new javax.swing.JRadioButton();
        Rancidbutter5 = new javax.swing.JRadioButton();
        RancidCheese5 = new javax.swing.JRadioButton();
        Winey5 = new javax.swing.JRadioButton();
        Whiskey5 = new javax.swing.JRadioButton();
        Fermented5 = new javax.swing.JRadioButton();
        Overripe5 = new javax.swing.JRadioButton();
        jLabel75 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        OrangeAcidity5 = new javax.swing.JRadioButton();
        AppleAcidity5 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Evaluacion de Taza");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setText("Muestra");

        cs.setText("No. de CSM");

        co.setText("Comunidad");

        ti.setText("Proceso:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(co)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comunidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ti)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cs)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Csm, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cs)
                    .addComponent(Csm, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(co, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comunidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel6.setBackground(new java.awt.Color(255, 204, 153));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setForeground(new java.awt.Color(255, 204, 153));

        jLabel15.setText("Puntuacion de la taza");

        Puntuacion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Puntuacion.setText("0.00");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(Puntuacion)
                .addGap(44, 44, 44))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(20, 20, 20))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Puntuacion)
                .addContainerGap())
        );

        Tazas.setText("0");
        Tazas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TazasFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TazasFocusLost(evt);
            }
        });
        Tazas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TazasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TazasKeyTyped(evt);
            }
        });

        jLabel5.setText("Tazas Catadas:");

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel19.setText("Defectos");

        jLabel20.setText("No.Tazas:");

        jLabel21.setText("Intensidad:");

        numtazasdefectos.setText("0");
        numtazasdefectos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                numtazasdefectosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                numtazasdefectosFocusLost(evt);
            }
        });
        numtazasdefectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numtazasdefectosActionPerformed(evt);
            }
        });
        numtazasdefectos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numtazasdefectosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numtazasdefectosKeyTyped(evt);
            }
        });

        intensidadefectos.setText("0");
        intensidadefectos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                intensidadefectosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                intensidadefectosFocusLost(evt);
            }
        });
        intensidadefectos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                intensidadefectosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                intensidadefectosKeyTyped(evt);
            }
        });

        jLabel22.setText("(4=Rechazo)");

        Defectos.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(intensidadefectos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel19))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Defectos)
                                    .addComponent(numtazasdefectos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(83, 83, 83))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(Defectos))
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(numtazasdefectos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(intensidadefectos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(98, 98, 98))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel23.setText("Uniformidad");

        jLabel24.setText("Taza Limpia:");

        jLabel25.setText("Dulzor:");

        uniformtaza.setText("0");
        uniformtaza.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                uniformtazaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                uniformtazaFocusLost(evt);
            }
        });
        uniformtaza.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                uniformtazaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                uniformtazaKeyTyped(evt);
            }
        });

        tazalimpia.setText("0");
        tazalimpia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tazalimpiaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tazalimpiaFocusLost(evt);
            }
        });
        tazalimpia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tazalimpiaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tazalimpiaKeyTyped(evt);
            }
        });

        dulzor.setText("0");
        dulzor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dulzorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dulzorFocusLost(evt);
            }
        });
        dulzor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dulzorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dulzorKeyTyped(evt);
            }
        });

        jLabel32.setText("De Taza:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel32)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tazalimpia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(dulzor)
                    .addComponent(uniformtaza))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(uniformtaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32)))
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(tazalimpia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(dulzor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(Tazas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Tazas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        quakers.setText("0");
        quakers.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                quakersFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                quakersFocusLost(evt);
            }
        });

        jLabel17.setText("Quakers");

        jLabel18.setText("1    -    5");

        jLabel33.setText("Uniformidad de tostado");

        jLabel34.setText("5=Parejo");

        jLabel35.setText("Nivel de tostado");

        jTextField19.setEditable(false);
        jTextField19.setBackground(new java.awt.Color(204, 204, 204));
        jTextField19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField19ActionPerformed(evt);
            }
        });

        jTextField20.setEditable(false);
        jTextField20.setBackground(new java.awt.Color(102, 102, 102));
        jTextField20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField20ActionPerformed(evt);
            }
        });

        jTextField21.setEditable(false);
        jTextField21.setBackground(new java.awt.Color(153, 153, 153));
        jTextField21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField21ActionPerformed(evt);
            }
        });

        jTextField22.setEditable(false);
        jTextField22.setBackground(new java.awt.Color(51, 51, 51));
        jTextField22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField22ActionPerformed(evt);
            }
        });

        jTextField23.setEditable(false);
        jTextField23.setBackground(new java.awt.Color(0, 0, 0));
        jTextField23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField23ActionPerformed(evt);
            }
        });

        jLabel36.setText("1");

        jLabel37.setText("2");

        jLabel38.setText("3");

        jLabel39.setText("4");

        jLabel40.setText("5");

        buttonGroup1.add(nt1);

        buttonGroup1.add(nt2);

        buttonGroup1.add(nt3);

        buttonGroup1.add(nt4);

        buttonGroup1.add(nt5);

        uniformidadtostado.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));

        jLabel10.setText("Densidad Tostado");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(quakers, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel36)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel37))
                            .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel38)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel39))
                            .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel40))
                            .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DenTost, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(nt4)
                                .addGap(8, 8, 8)
                                .addComponent(nt5))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel35))
                            .addComponent(jLabel34)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(nt2))
                                    .addComponent(nt1))
                                .addGap(8, 8, 8)
                                .addComponent(nt3))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(uniformidadtostado))
                                .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nt3)
                    .addComponent(nt4)
                    .addComponent(nt1)
                    .addComponent(nt2)
                    .addComponent(nt5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(uniformidadtostado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quakers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(DenTost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Acidity.setText("7.0");

        jLabel6.setText("Catador");

        jLabel7.setText("Balance");

        Balance.setText("7.0");
        Balance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BalanceActionPerformed(evt);
            }
        });

        Catador.setText("7.0");

        jLabel27.setText("Acidity");

        Body.setText("7.0");

        jLabel28.setText("Body");

        jLabel29.setText("Intensidad (1-5)");

        jLabel30.setText("Intensidad (1-5)");

        lessAcidity.setText("-");
        lessAcidity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lessAcidityActionPerformed(evt);
            }
        });

        plusAcidity.setText("+");
        plusAcidity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusAcidityActionPerformed(evt);
            }
        });

        Acidityteslider.setMaximum(950);
        Acidityteslider.setMinimum(450);
        Acidityteslider.setToolTipText("");
        Acidityteslider.setValue(700);
        Acidityteslider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                AciditytesliderStateChanged(evt);
            }
        });

        plusBody.setText("+");
        plusBody.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusBodyActionPerformed(evt);
            }
        });

        lessBody.setText("-");
        lessBody.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lessBodyActionPerformed(evt);
            }
        });

        Bodyslider.setMaximum(950);
        Bodyslider.setMinimum(450);
        Bodyslider.setToolTipText("");
        Bodyslider.setValue(700);
        Bodyslider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                BodysliderStateChanged(evt);
            }
        });

        lessBalance.setText("-");
        lessBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lessBalanceActionPerformed(evt);
            }
        });

        lessCatador.setText("-");
        lessCatador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lessCatadorActionPerformed(evt);
            }
        });

        plusBalance.setText("+");
        plusBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusBalanceActionPerformed(evt);
            }
        });

        plusCatador.setText("+");
        plusCatador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusCatadorActionPerformed(evt);
            }
        });

        Catadorslider.setMaximum(950);
        Catadorslider.setMinimum(450);
        Catadorslider.setToolTipText("");
        Catadorslider.setValue(700);
        Catadorslider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                CatadorsliderStateChanged(evt);
            }
        });

        intensidadacidity.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));

        intensidadbody.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));

        Balanceslider.setMaximum(950);
        Balanceslider.setMinimum(450);
        Balanceslider.setToolTipText("");
        Balanceslider.setValue(700);
        Balanceslider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                BalancesliderStateChanged(evt);
            }
        });

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        calendario.setDateFormatString("dd-MMM-yyyy");

        jLabel85.setText("Fecha:");

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Break");

        jLabel2.setText("Wet");

        plusdry.setText("+");
        plusdry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusdryActionPerformed(evt);
            }
        });

        jLabel1.setText("Dry");

        pluswet.setText("+");
        pluswet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pluswetActionPerformed(evt);
            }
        });

        plusbreak.setText("+");
        plusbreak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusbreakActionPerformed(evt);
            }
        });

        breaks.setText("7.0");
        breaks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                breaksActionPerformed(evt);
            }
        });

        wet.setText("7.0");

        dry.setText("7.0");

        lessdry.setText("-");
        lessdry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lessdryActionPerformed(evt);
            }
        });

        lesswet.setText("-");
        lesswet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lesswetActionPerformed(evt);
            }
        });

        lessbreak.setText("-");
        lessbreak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lessbreakActionPerformed(evt);
            }
        });

        breakslider.setMaximum(950);
        breakslider.setMinimum(450);
        breakslider.setToolTipText("");
        breakslider.setValue(700);
        breakslider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                breaksliderStateChanged(evt);
            }
        });

        wetslider.setMaximum(950);
        wetslider.setMinimum(450);
        wetslider.setToolTipText("");
        wetslider.setValue(700);
        wetslider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                wetsliderStateChanged(evt);
            }
        });

        dryslider.setMaximum(950);
        dryslider.setMinimum(450);
        dryslider.setToolTipText("");
        dryslider.setValue(700);
        dryslider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                drysliderStateChanged(evt);
            }
        });

        jLabel4.setText("Fragance:");

        aroma.setText("7.00");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(breakslider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wetslider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dryslider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lessbreak, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lesswet, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lessdry, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(wet, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(breaks, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dry, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(plusbreak, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pluswet, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(plusdry, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aroma)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(dry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lessdry))
                            .addComponent(dryslider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(wet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lesswet)
                                .addComponent(jLabel2)
                                .addComponent(pluswet))
                            .addComponent(wetslider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(breaks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lessbreak)
                                .addComponent(jLabel3)
                                .addComponent(plusbreak))
                            .addComponent(breakslider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(plusdry)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(aroma)))
        );

        Aftertaste.setText("7.0");

        Aftertasteslider.setMaximum(950);
        Aftertasteslider.setMinimum(450);
        Aftertasteslider.setToolTipText("");
        Aftertasteslider.setValue(700);
        Aftertasteslider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                AftertastesliderStateChanged(evt);
            }
        });

        jLabel26.setText("Aftertaste");

        lessaftertaste.setText("-");
        lessaftertaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lessaftertasteActionPerformed(evt);
            }
        });

        plusaftertaste.setText("+");
        plusaftertaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusaftertasteActionPerformed(evt);
            }
        });

        flavorslider.setMaximum(950);
        flavorslider.setMinimum(450);
        flavorslider.setToolTipText("");
        flavorslider.setValue(700);
        flavorslider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                flavorsliderStateChanged(evt);
            }
        });

        lessflavor.setText("-");
        lessflavor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lessflavorActionPerformed(evt);
            }
        });

        flavor.setText("7.0");

        plusflavor.setText("+");
        plusflavor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusflavorActionPerformed(evt);
            }
        });

        jLabel8.setText("Flavor");

        contenedorpaneles.setBackground(new java.awt.Color(0, 0, 0));
        contenedorpaneles.setToolTipText("");
        contenedorpaneles.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        contenedorpaneles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contenedorpanelesMouseClicked(evt);
            }
        });

        Dry.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Dry.setOpaque(false);
        Dry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DryMouseClicked(evt);
            }
        });

        jPanel14.setBackground(new java.awt.Color(255, 102, 102));

        BrownSugar.setBackground(new java.awt.Color(255, 102, 102));
        BrownSugar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BrownSugar.setText("Brown Sugar");
        BrownSugar.setOpaque(false);
        BrownSugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BrownSugarMouseClicked(evt);
            }
        });

        MapleSugar.setBackground(new java.awt.Color(255, 102, 102));
        MapleSugar.setText("Maple Sugar");
        MapleSugar.setOpaque(false);
        MapleSugar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                MapleSugarItemStateChanged(evt);
            }
        });
        MapleSugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MapleSugarMouseClicked(evt);
            }
        });

        Carmelized.setBackground(new java.awt.Color(255, 102, 102));
        Carmelized.setText("Carmelized");
        Carmelized.setOpaque(false);
        Carmelized.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CarmelizedItemStateChanged(evt);
            }
        });
        Carmelized.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CarmelizedMouseClicked(evt);
            }
        });

        Molasses.setBackground(new java.awt.Color(255, 102, 102));
        Molasses.setText("Molasses");
        Molasses.setOpaque(false);
        Molasses.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                MolassesItemStateChanged(evt);
            }
        });
        Molasses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MolassesMouseClicked(evt);
            }
        });

        Honey.setText("Honey");
        Honey.setOpaque(false);
        Honey.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                HoneyItemStateChanged(evt);
            }
        });
        Honey.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HoneyMouseClicked(evt);
            }
        });

        Vanilla.setBackground(new java.awt.Color(255, 102, 102));
        Vanilla.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Vanilla.setText("Vanilla");
        Vanilla.setOpaque(false);
        Vanilla.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                VanillaItemStateChanged(evt);
            }
        });
        Vanilla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VanillaMouseClicked(evt);
            }
        });

        Sweet.setBackground(new java.awt.Color(255, 102, 102));
        Sweet.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Sweet.setText("1     Sweet");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Vanilla)
            .addComponent(Honey)
            .addComponent(Carmelized)
            .addComponent(Molasses)
            .addComponent(BrownSugar)
            .addComponent(MapleSugar)
            .addComponent(Sweet)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addComponent(Sweet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BrownSugar, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Molasses, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MapleSugar, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Carmelized, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Honey, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Vanilla, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        jPanel16.setBackground(new java.awt.Color(236, 217, 25));

        Blackberry.setBackground(new java.awt.Color(236, 217, 25));
        Blackberry.setText("Blackberry");
        Blackberry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BlackberryMouseClicked(evt);
            }
        });

        Raspberry.setBackground(new java.awt.Color(236, 217, 25));
        Raspberry.setText("Raspberry");
        Raspberry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RaspberryMouseClicked(evt);
            }
        });

        Blueberry.setBackground(new java.awt.Color(236, 217, 25));
        Blueberry.setText("Blueberry");
        Blueberry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BlueberryMouseClicked(evt);
            }
        });

        Strawberry.setBackground(new java.awt.Color(236, 217, 25));
        Strawberry.setText("Strawberry");
        Strawberry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StrawberryMouseClicked(evt);
            }
        });

        Raisen.setBackground(new java.awt.Color(236, 217, 25));
        Raisen.setText("Raisen");
        Raisen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RaisenMouseClicked(evt);
            }
        });

        Prune.setBackground(new java.awt.Color(236, 217, 25));
        Prune.setText("Prune");
        Prune.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PruneMouseClicked(evt);
            }
        });

        Coconut.setBackground(new java.awt.Color(236, 217, 25));
        Coconut.setText("Coconut");
        Coconut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CoconutMouseClicked(evt);
            }
        });

        Cherry.setBackground(new java.awt.Color(236, 217, 25));
        Cherry.setText("Cherry");
        Cherry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CherryMouseClicked(evt);
            }
        });

        Pomagranite.setBackground(new java.awt.Color(236, 217, 25));
        Pomagranite.setText("Pomagranite");
        Pomagranite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PomagraniteMouseClicked(evt);
            }
        });

        Pinneapple.setBackground(new java.awt.Color(236, 217, 25));
        Pinneapple.setText("Pinneapple");
        Pinneapple.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PinneappleMouseClicked(evt);
            }
        });

        Grape.setBackground(new java.awt.Color(236, 217, 25));
        Grape.setText("Grape");
        Grape.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GrapeMouseClicked(evt);
            }
        });

        Apple.setBackground(new java.awt.Color(236, 217, 25));
        Apple.setText("Apple");
        Apple.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AppleMouseClicked(evt);
            }
        });

        Peach.setBackground(new java.awt.Color(236, 217, 25));
        Peach.setText("Peach");
        Peach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PeachMouseClicked(evt);
            }
        });

        Pear.setBackground(new java.awt.Color(236, 217, 25));
        Pear.setText("Pear");
        Pear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PearMouseClicked(evt);
            }
        });

        Grapefruit.setBackground(new java.awt.Color(236, 217, 25));
        Grapefruit.setText("Grapefruit");
        Grapefruit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GrapefruitMouseClicked(evt);
            }
        });

        Orange.setBackground(new java.awt.Color(236, 217, 25));
        Orange.setText("Orange");
        Orange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrangeMouseClicked(evt);
            }
        });

        Lemon.setBackground(new java.awt.Color(236, 217, 25));
        Lemon.setText("Lemon");
        Lemon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LemonMouseClicked(evt);
            }
        });

        Lime.setBackground(new java.awt.Color(236, 217, 25));
        Lime.setText("Lime");
        Lime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LimeMouseClicked(evt);
            }
        });

        Fruity.setBackground(new java.awt.Color(236, 217, 25));
        Fruity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Fruity.setText("3   Fruity");
        Fruity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FruityActionPerformed(evt);
            }
        });

        Berry.setBackground(new java.awt.Color(236, 217, 25));
        Berry.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Berry.setText("Berry");
        Berry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BerryMouseClicked(evt);
            }
        });

        DriedFruit.setBackground(new java.awt.Color(236, 217, 25));
        DriedFruit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DriedFruit.setText("Dried Fruit");
        DriedFruit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DriedFruitMouseClicked(evt);
            }
        });

        Otherfruit.setBackground(new java.awt.Color(236, 217, 25));
        Otherfruit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Otherfruit.setText("Other fruit");
        Otherfruit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OtherfruitMouseClicked(evt);
            }
        });

        Citrusfruit.setBackground(new java.awt.Color(236, 217, 25));
        Citrusfruit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Citrusfruit.setText("Citrus Fruit");
        Citrusfruit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CitrusfruitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Blackberry)
                    .addComponent(Raspberry)
                    .addComponent(Blueberry)
                    .addComponent(Orange)
                    .addComponent(Lemon)
                    .addComponent(Lime)
                    .addComponent(Grapefruit)
                    .addComponent(Otherfruit)
                    .addComponent(Coconut)
                    .addComponent(Cherry)
                    .addComponent(Peach)
                    .addComponent(Grape)
                    .addComponent(Pinneapple)
                    .addComponent(Apple)
                    .addComponent(Pear)
                    .addComponent(Pomagranite)
                    .addComponent(Strawberry)
                    .addComponent(Berry)
                    .addComponent(Citrusfruit)
                    .addComponent(DriedFruit)
                    .addComponent(Fruity)
                    .addComponent(Raisen)
                    .addComponent(Prune))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(Fruity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Berry, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Blackberry, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Raspberry, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Blueberry, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Strawberry, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, Short.MAX_VALUE)
                .addComponent(DriedFruit, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Raisen, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(Prune, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Otherfruit, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Coconut, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cherry, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pomagranite, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pinneapple, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Grape, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Apple, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Peach, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pear, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Citrusfruit, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Grapefruit, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Orange, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lemon, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lime, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel18.setBackground(new java.awt.Color(255, 241, 144));

        Vinegar.setBackground(new java.awt.Color(255, 241, 144));
        Vinegar.setText("Vinegar");
        Vinegar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VinegarMouseClicked(evt);
            }
        });

        Rancidbutter.setBackground(new java.awt.Color(255, 241, 144));
        Rancidbutter.setText("Rancid butter");
        Rancidbutter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RancidbutterMouseClicked(evt);
            }
        });

        RancidCheese.setBackground(new java.awt.Color(255, 241, 144));
        RancidCheese.setText("Rancid Cheese");
        RancidCheese.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RancidCheeseMouseClicked(evt);
            }
        });

        Winey.setBackground(new java.awt.Color(255, 241, 144));
        Winey.setText("Winey");
        Winey.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WineyMouseClicked(evt);
            }
        });

        Whiskey.setBackground(new java.awt.Color(255, 241, 144));
        Whiskey.setText("Whiskey");
        Whiskey.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WhiskeyMouseClicked(evt);
            }
        });

        Fermented.setBackground(new java.awt.Color(255, 241, 144));
        Fermented.setText("Fermented");
        Fermented.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FermentedMouseClicked(evt);
            }
        });

        Overripe.setBackground(new java.awt.Color(255, 241, 144));
        Overripe.setText("Over-ripe");
        Overripe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OverripeMouseClicked(evt);
            }
        });

        OrangeAcidity.setBackground(new java.awt.Color(255, 241, 144));
        OrangeAcidity.setText("Orange Acidity");
        OrangeAcidity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrangeAcidityMouseClicked(evt);
            }
        });

        AppleAcidity.setBackground(new java.awt.Color(255, 241, 144));
        AppleAcidity.setText("Apple Acidity");
        AppleAcidity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AppleAcidityMouseClicked(evt);
            }
        });

        Sour.setBackground(new java.awt.Color(255, 241, 144));
        Sour.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Sour.setText("4 Sour/Fermented");

        sour.setBackground(new java.awt.Color(255, 241, 144));
        sour.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sour.setText("Sour");
        sour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sourMouseClicked(evt);
            }
        });

        Alcohol.setBackground(new java.awt.Color(255, 241, 144));
        Alcohol.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Alcohol.setText("Alcohol/Fermented");
        Alcohol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AlcoholMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AlcoholMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Sour)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AppleAcidity)
                            .addComponent(OrangeAcidity)
                            .addComponent(Alcohol)
                            .addComponent(sour)
                            .addComponent(RancidCheese)
                            .addComponent(Vinegar))))
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Rancidbutter)
                    .addComponent(Winey)
                    .addComponent(Whiskey)
                    .addComponent(Fermented)
                    .addComponent(Overripe))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(Sour, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(sour, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Vinegar, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Rancidbutter, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RancidCheese, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OrangeAcidity, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AppleAcidity, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Alcohol, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Winey, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Whiskey, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Fermented, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Overripe, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel20.setBackground(new java.awt.Color(123, 236, 133));

        OliveOil.setBackground(new java.awt.Color(123, 236, 133));
        OliveOil.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        OliveOil.setText("Olive Oil");
        OliveOil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OliveOilMouseClicked(evt);
            }
        });

        Raw.setBackground(new java.awt.Color(123, 236, 133));
        Raw.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Raw.setText("Raw");
        Raw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RawMouseClicked(evt);
            }
        });

        Underripe.setBackground(new java.awt.Color(123, 236, 133));
        Underripe.setText("Under-ripe");
        Underripe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UnderripeMouseClicked(evt);
            }
        });

        Peapod.setBackground(new java.awt.Color(123, 236, 133));
        Peapod.setText("Pea pod");
        Peapod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PeapodMouseClicked(evt);
            }
        });

        Fresh.setBackground(new java.awt.Color(123, 236, 133));
        Fresh.setText("Fresh");
        Fresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FreshMouseClicked(evt);
            }
        });

        DarkGreen.setBackground(new java.awt.Color(123, 236, 133));
        DarkGreen.setText("Dark Green");
        DarkGreen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DarkGreenMouseClicked(evt);
            }
        });

        Vegetative.setBackground(new java.awt.Color(123, 236, 133));
        Vegetative.setText("Vegetative");
        Vegetative.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VegetativeMouseClicked(evt);
            }
        });

        Haylike.setBackground(new java.awt.Color(123, 236, 133));
        Haylike.setText("Hay-like");
        Haylike.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HaylikeMouseClicked(evt);
            }
        });

        Herblike.setBackground(new java.awt.Color(123, 236, 133));
        Herblike.setText("Herb-like");
        Herblike.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HerblikeMouseClicked(evt);
            }
        });

        Beany.setBackground(new java.awt.Color(123, 236, 133));
        Beany.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Beany.setText("Beany");
        Beany.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BeanyMouseClicked(evt);
            }
        });

        Green.setBackground(new java.awt.Color(123, 236, 133));
        Green.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Green.setText("5 Green/Vegetative");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OliveOil)
                    .addComponent(Raw)
                    .addComponent(Underripe)
                    .addComponent(Peapod)
                    .addComponent(Fresh)
                    .addComponent(DarkGreen)
                    .addComponent(Vegetative)
                    .addComponent(Haylike)
                    .addComponent(Herblike)
                    .addComponent(Beany))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(Green, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(Green, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OliveOil, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Raw, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Beany, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Underripe, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Peapod, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Fresh, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DarkGreen, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Vegetative, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Haylike, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Herblike, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBackground(new java.awt.Color(94, 249, 235));

        Stale.setBackground(new java.awt.Color(94, 249, 235));
        Stale.setText("Stale");
        Stale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StaleMouseClicked(evt);
            }
        });

        Cardboard.setBackground(new java.awt.Color(94, 249, 235));
        Cardboard.setText("Cardboard");
        Cardboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CardboardMouseClicked(evt);
            }
        });

        Papery.setBackground(new java.awt.Color(94, 249, 235));
        Papery.setText("Papery");
        Papery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PaperyMouseClicked(evt);
            }
        });

        Woody.setBackground(new java.awt.Color(94, 249, 235));
        Woody.setText("Woody");
        Woody.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WoodyMouseClicked(evt);
            }
        });

        MoldyDamp.setBackground(new java.awt.Color(94, 249, 235));
        MoldyDamp.setText("Moldy/Damp");
        MoldyDamp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MoldyDampMouseClicked(evt);
            }
        });

        MustyDusty.setBackground(new java.awt.Color(94, 249, 235));
        MustyDusty.setText("Musty/Dusty");
        MustyDusty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MustyDustyMouseClicked(evt);
            }
        });

        MustyEarthy.setBackground(new java.awt.Color(94, 249, 235));
        MustyEarthy.setText("Musty/Earthy");
        MustyEarthy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MustyEarthyMouseClicked(evt);
            }
        });

        Animalic.setBackground(new java.awt.Color(94, 249, 235));
        Animalic.setText("Animalic");
        Animalic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AnimalicMouseClicked(evt);
            }
        });

        MeatyBrothy.setBackground(new java.awt.Color(94, 249, 235));
        MeatyBrothy.setText("Meaty/Brothy");
        MeatyBrothy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MeatyBrothyMouseClicked(evt);
            }
        });

        Phenolic.setBackground(new java.awt.Color(94, 249, 235));
        Phenolic.setText("Phenolic");
        Phenolic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PhenolicMouseClicked(evt);
            }
        });

        Bitter.setBackground(new java.awt.Color(94, 249, 235));
        Bitter.setText("Bitter");
        Bitter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BitterMouseClicked(evt);
            }
        });

        Salty.setBackground(new java.awt.Color(94, 249, 235));
        Salty.setText("Salty");
        Salty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaltyMouseClicked(evt);
            }
        });

        Medicinal.setBackground(new java.awt.Color(94, 249, 235));
        Medicinal.setText("Medicinal");
        Medicinal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MedicinalMouseClicked(evt);
            }
        });

        Petroleum.setBackground(new java.awt.Color(94, 249, 235));
        Petroleum.setText("Petroleum");
        Petroleum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PetroleumMouseClicked(evt);
            }
        });

        Skunky.setBackground(new java.awt.Color(94, 249, 235));
        Skunky.setText("Skunky");
        Skunky.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SkunkyMouseClicked(evt);
            }
        });

        Rubber.setBackground(new java.awt.Color(94, 249, 235));
        Rubber.setText("Rubber");
        Rubber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RubberMouseClicked(evt);
            }
        });

        Other.setBackground(new java.awt.Color(94, 249, 235));
        Other.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Other.setText("6    Other");

        PaperyM.setBackground(new java.awt.Color(94, 249, 235));
        PaperyM.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PaperyM.setText("Papery/Musty");
        PaperyM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PaperyMMouseClicked(evt);
            }
        });

        Chemical.setBackground(new java.awt.Color(94, 249, 235));
        Chemical.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Chemical.setText("Chemical");
        Chemical.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChemicalMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(PaperyM)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Papery)
                            .addComponent(Woody)
                            .addComponent(MoldyDamp)
                            .addComponent(MustyDusty)
                            .addComponent(MustyEarthy)
                            .addComponent(Animalic)
                            .addComponent(MeatyBrothy)
                            .addComponent(Phenolic)
                            .addComponent(Bitter)
                            .addComponent(Salty)
                            .addComponent(Medicinal)
                            .addComponent(Petroleum)
                            .addComponent(Skunky)
                            .addComponent(Rubber)
                            .addComponent(Stale)
                            .addComponent(Cardboard)
                            .addComponent(Chemical))
                        .addGap(49, 49, 49))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(Other)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(Other, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(PaperyM, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Stale, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cardboard, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Papery, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Woody, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MoldyDamp, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MustyDusty, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MustyEarthy, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Animalic, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MeatyBrothy, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Phenolic, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Chemical, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Bitter, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Salty, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Medicinal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Petroleum, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Skunky, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Rubber, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(20, 181, 225));
        jPanel17.setForeground(new java.awt.Color(20, 181, 225));

        PipeTobacco.setBackground(new java.awt.Color(20, 181, 225));
        PipeTobacco.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PipeTobacco.setText("Pipe Tobacco");
        PipeTobacco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PipeTobaccoMouseClicked(evt);
            }
        });

        Tobacco.setBackground(new java.awt.Color(20, 181, 225));
        Tobacco.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Tobacco.setText("Tobacco");
        Tobacco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TobaccoMouseClicked(evt);
            }
        });

        Acrid.setBackground(new java.awt.Color(20, 181, 225));
        Acrid.setText("Acrid");
        Acrid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AcridMouseClicked(evt);
            }
        });

        Ashy.setBackground(new java.awt.Color(20, 181, 225));
        Ashy.setText("Ashy");
        Ashy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AshyMouseClicked(evt);
            }
        });

        Smoky.setBackground(new java.awt.Color(20, 181, 225));
        Smoky.setText("Smoky");
        Smoky.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SmokyMouseClicked(evt);
            }
        });

        BrownRoast.setBackground(new java.awt.Color(20, 181, 225));
        BrownRoast.setText("Brown, Roast");
        BrownRoast.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BrownRoastMouseClicked(evt);
            }
        });

        Grain.setBackground(new java.awt.Color(20, 181, 225));
        Grain.setText("Grain");
        Grain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GrainMouseClicked(evt);
            }
        });

        Malt.setBackground(new java.awt.Color(20, 181, 225));
        Malt.setText("Malt");
        Malt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MaltMouseClicked(evt);
            }
        });

        Roasted.setBackground(new java.awt.Color(20, 181, 225));
        Roasted.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Roasted.setText("7  Roasted");

        Burnt.setBackground(new java.awt.Color(20, 181, 225));
        Burnt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Burnt.setText("Burnt");
        Burnt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BurntMouseClicked(evt);
            }
        });

        Cereal.setBackground(new java.awt.Color(20, 181, 225));
        Cereal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Cereal.setText("Cereal");
        Cereal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CerealMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PipeTobacco)
                            .addComponent(Tobacco)
                            .addComponent(Acrid)
                            .addComponent(Ashy)
                            .addComponent(Smoky)
                            .addComponent(BrownRoast)
                            .addComponent(Grain)
                            .addComponent(Malt)
                            .addComponent(Burnt)
                            .addComponent(Cereal))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Roasted)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(Roasted, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(PipeTobacco, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tobacco, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Burnt, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Acrid, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Ashy, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Smoky, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BrownRoast, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Cereal, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Grain, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Malt, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel21.setBackground(new java.awt.Color(187, 187, 240));

        Pungent.setBackground(new java.awt.Color(187, 187, 240));
        Pungent.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Pungent.setText("Pungent");
        Pungent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PungentMouseClicked(evt);
            }
        });

        Pepper.setBackground(new java.awt.Color(187, 187, 240));
        Pepper.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Pepper.setText("Pepper");
        Pepper.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PepperMouseClicked(evt);
            }
        });

        Anise.setBackground(new java.awt.Color(187, 187, 240));
        Anise.setText("Anise");
        Anise.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AniseMouseClicked(evt);
            }
        });

        Nutmeg.setBackground(new java.awt.Color(187, 187, 240));
        Nutmeg.setText("Nutmeg");
        Nutmeg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NutmegMouseClicked(evt);
            }
        });

        Cinnamon.setBackground(new java.awt.Color(187, 187, 240));
        Cinnamon.setText("Cinnamon");
        Cinnamon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CinnamonMouseClicked(evt);
            }
        });

        Clove.setBackground(new java.awt.Color(187, 187, 240));
        Clove.setText("Clove");
        Clove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloveMouseClicked(evt);
            }
        });

        Spices.setBackground(new java.awt.Color(187, 187, 240));
        Spices.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Spices.setText("8    Spices");

        Brownspices.setBackground(new java.awt.Color(187, 187, 240));
        Brownspices.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Brownspices.setText("Brown Spice");
        Brownspices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BrownspicesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Pungent)
                    .addComponent(Pepper)
                    .addComponent(Anise)
                    .addComponent(Nutmeg)
                    .addComponent(Cinnamon)
                    .addComponent(Clove)
                    .addComponent(Spices)
                    .addComponent(Brownspices))
                .addGap(8, 8, 8))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(Spices, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(Pungent, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pepper, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(Brownspices, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(Anise, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Nutmeg, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cinnamon, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Clove, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel22.setBackground(new java.awt.Color(255, 102, 255));

        Peanuts.setBackground(new java.awt.Color(255, 102, 255));
        Peanuts.setText("Peanuts");
        Peanuts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PeanutsMouseClicked(evt);
            }
        });

        Hazelenut.setBackground(new java.awt.Color(255, 102, 255));
        Hazelenut.setText("Hazelenut");
        Hazelenut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HazelenutMouseClicked(evt);
            }
        });

        Almond.setBackground(new java.awt.Color(255, 102, 255));
        Almond.setText("Almond");
        Almond.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AlmondMouseClicked(evt);
            }
        });

        Chocolate.setBackground(new java.awt.Color(255, 102, 255));
        Chocolate.setText("Chocolate");
        Chocolate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChocolateMouseClicked(evt);
            }
        });

        DarkChocolate.setBackground(new java.awt.Color(255, 102, 255));
        DarkChocolate.setText("Dark Chocolate");
        DarkChocolate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DarkChocolateMouseClicked(evt);
            }
        });

        Nutty.setBackground(new java.awt.Color(255, 102, 255));
        Nutty.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Nutty.setText("Nutty");
        Nutty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NuttyMouseClicked(evt);
            }
        });

        Nuttycocoa.setBackground(new java.awt.Color(255, 102, 255));
        Nuttycocoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Nuttycocoa.setText("9 Nutty/Cocoa");

        Cocoa.setBackground(new java.awt.Color(255, 102, 255));
        Cocoa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Cocoa.setText("Cocoa");
        Cocoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CocoaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cocoa)
                    .addComponent(Hazelenut)
                    .addComponent(Almond)
                    .addComponent(Peanuts)
                    .addComponent(DarkChocolate)
                    .addComponent(Chocolate)
                    .addComponent(Nutty)
                    .addComponent(Nuttycocoa))
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(Nuttycocoa, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(Nutty, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Peanuts, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Hazelenut, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Almond, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cocoa, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Chocolate, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DarkChocolate, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(243, 187, 111));

        Blacktea.setBackground(new java.awt.Color(243, 187, 111));
        Blacktea.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Blacktea.setText("Black tea");
        Blacktea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BlackteaMouseClicked(evt);
            }
        });

        Chamomile.setBackground(new java.awt.Color(243, 187, 111));
        Chamomile.setText("Chamomile");
        Chamomile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChamomileMouseClicked(evt);
            }
        });

        Rose.setBackground(new java.awt.Color(243, 187, 111));
        Rose.setText("Rose");
        Rose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RoseMouseClicked(evt);
            }
        });

        Jasmine.setBackground(new java.awt.Color(243, 187, 111));
        Jasmine.setText("Jasmine");
        Jasmine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JasmineMouseClicked(evt);
            }
        });

        Floral.setBackground(new java.awt.Color(243, 187, 111));
        Floral.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Floral.setText("2     Floral");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Floral)
                    .addComponent(Blacktea)
                    .addComponent(Rose)
                    .addComponent(Jasmine)
                    .addComponent(Chamomile))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(Floral)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Blacktea, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Chamomile, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Rose, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Jasmine, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DryLayout = new javax.swing.GroupLayout(Dry);
        Dry.setLayout(DryLayout);
        DryLayout.setHorizontalGroup(
            DryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DryLayout.createSequentialGroup()
                .addGroup(DryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(DryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DryLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DryLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DryLayout.createSequentialGroup()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        DryLayout.setVerticalGroup(
            DryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DryLayout.createSequentialGroup()
                .addGroup(DryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DryLayout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DryLayout.createSequentialGroup()
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jButton3))
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DryLayout.createSequentialGroup()
                        .addGroup(DryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 165, Short.MAX_VALUE))
        );

        contenedorpaneles.addTab("Dry", Dry);

        jPanel23.setBackground(new java.awt.Color(255, 102, 102));

        BrownSugar1.setBackground(new java.awt.Color(255, 102, 102));
        BrownSugar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BrownSugar1.setText("Brown Sugar");
        BrownSugar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BrownSugar1MouseClicked(evt);
            }
        });

        MapleSugar1.setBackground(new java.awt.Color(255, 102, 102));
        MapleSugar1.setText("Maple Sugar");
        MapleSugar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MapleSugar1MouseClicked(evt);
            }
        });

        Carmelized1.setBackground(new java.awt.Color(255, 102, 102));
        Carmelized1.setText("Carmelized");
        Carmelized1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Carmelized1MouseClicked(evt);
            }
        });

        Molasses1.setBackground(new java.awt.Color(255, 102, 102));
        Molasses1.setText("Molasses");
        Molasses1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Molasses1MouseClicked(evt);
            }
        });

        Honey1.setBackground(new java.awt.Color(255, 102, 102));
        Honey1.setText("Honey");
        Honey1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Honey1MouseClicked(evt);
            }
        });

        Vanilla1.setBackground(new java.awt.Color(255, 102, 102));
        Vanilla1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Vanilla1.setText("Vanilla");
        Vanilla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Vanilla1MouseClicked(evt);
            }
        });

        Sweet1.setBackground(new java.awt.Color(255, 102, 102));
        Sweet1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Sweet1.setText("1     Sweet");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Vanilla1)
            .addComponent(Honey1)
            .addComponent(Carmelized1)
            .addComponent(Molasses1)
            .addComponent(BrownSugar1)
            .addComponent(MapleSugar1)
            .addComponent(Sweet1)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addComponent(Sweet1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BrownSugar1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Molasses1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MapleSugar1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Carmelized1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Honey1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Vanilla1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        jPanel24.setBackground(new java.awt.Color(236, 217, 25));

        Blackberry1.setBackground(new java.awt.Color(236, 217, 25));
        Blackberry1.setText("Blackberry");
        Blackberry1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Blackberry1MouseClicked(evt);
            }
        });

        Raspberry1.setBackground(new java.awt.Color(236, 217, 25));
        Raspberry1.setText("Raspberry");
        Raspberry1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Raspberry1MouseClicked(evt);
            }
        });

        Blueberry1.setBackground(new java.awt.Color(236, 217, 25));
        Blueberry1.setText("Blueberry");
        Blueberry1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Blueberry1MouseClicked(evt);
            }
        });

        Strawberry1.setBackground(new java.awt.Color(236, 217, 25));
        Strawberry1.setText("Strawberry");
        Strawberry1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Strawberry1MouseClicked(evt);
            }
        });

        Raisen1.setBackground(new java.awt.Color(236, 217, 25));
        Raisen1.setText("Raisen");
        Raisen1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Raisen1MouseClicked(evt);
            }
        });

        Prune1.setBackground(new java.awt.Color(236, 217, 25));
        Prune1.setText("Prune");
        Prune1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Prune1MouseClicked(evt);
            }
        });

        Coconut1.setBackground(new java.awt.Color(236, 217, 25));
        Coconut1.setText("Coconut");
        Coconut1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Coconut1MouseClicked(evt);
            }
        });

        Cherry1.setBackground(new java.awt.Color(236, 217, 25));
        Cherry1.setText("Cherry");
        Cherry1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cherry1MouseClicked(evt);
            }
        });

        Pomagranite1.setBackground(new java.awt.Color(236, 217, 25));
        Pomagranite1.setText("Pomagranite");
        Pomagranite1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Pomagranite1MouseClicked(evt);
            }
        });

        Pinneapple1.setBackground(new java.awt.Color(236, 217, 25));
        Pinneapple1.setText("Pinneapple");
        Pinneapple1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Pinneapple1MouseClicked(evt);
            }
        });

        Grape1.setBackground(new java.awt.Color(236, 217, 25));
        Grape1.setText("Grape");
        Grape1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Grape1MouseClicked(evt);
            }
        });

        Apple1.setBackground(new java.awt.Color(236, 217, 25));
        Apple1.setText("Apple");
        Apple1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Apple1MouseClicked(evt);
            }
        });

        Peach1.setBackground(new java.awt.Color(236, 217, 25));
        Peach1.setText("Peach");
        Peach1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Peach1MouseClicked(evt);
            }
        });

        Pear1.setBackground(new java.awt.Color(236, 217, 25));
        Pear1.setText("Pear");
        Pear1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Pear1MouseClicked(evt);
            }
        });

        Grapefruit1.setBackground(new java.awt.Color(236, 217, 25));
        Grapefruit1.setText("Grapefruit");
        Grapefruit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Grapefruit1MouseClicked(evt);
            }
        });

        Orange1.setBackground(new java.awt.Color(236, 217, 25));
        Orange1.setText("Orange");
        Orange1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Orange1MouseClicked(evt);
            }
        });

        Lemon1.setBackground(new java.awt.Color(236, 217, 25));
        Lemon1.setText("Lemon");
        Lemon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Lemon1MouseClicked(evt);
            }
        });

        Lime1.setBackground(new java.awt.Color(236, 217, 25));
        Lime1.setText("Lime");
        Lime1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Lime1MouseClicked(evt);
            }
        });

        Fruity1.setBackground(new java.awt.Color(236, 217, 25));
        Fruity1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Fruity1.setText("3   Fruity");

        Berry1.setBackground(new java.awt.Color(236, 217, 25));
        Berry1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Berry1.setText("Berry");
        Berry1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Berry1MouseClicked(evt);
            }
        });

        DriedFruit1.setBackground(new java.awt.Color(236, 217, 25));
        DriedFruit1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DriedFruit1.setText("Dried Fruit");
        DriedFruit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DriedFruit1MouseClicked(evt);
            }
        });

        Otherfruit1.setBackground(new java.awt.Color(236, 217, 25));
        Otherfruit1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Otherfruit1.setText("Other fruit");
        Otherfruit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Otherfruit1MouseClicked(evt);
            }
        });

        Citrusfruit1.setBackground(new java.awt.Color(236, 217, 25));
        Citrusfruit1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Citrusfruit1.setText("Citrus Fruit");
        Citrusfruit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Citrusfruit1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Blackberry1)
                    .addComponent(Raspberry1)
                    .addComponent(Blueberry1)
                    .addComponent(Strawberry1)
                    .addComponent(Orange1)
                    .addComponent(Lemon1)
                    .addComponent(Lime1)
                    .addComponent(Grapefruit1)
                    .addComponent(Coconut1)
                    .addComponent(Cherry1)
                    .addComponent(Peach1)
                    .addComponent(Grape1)
                    .addComponent(Pinneapple1)
                    .addComponent(Apple1)
                    .addComponent(Pear1)
                    .addComponent(Pomagranite1)
                    .addComponent(Fruity1)
                    .addComponent(Berry1)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Raisen1)
                            .addComponent(Prune1)))
                    .addComponent(Otherfruit1)
                    .addComponent(Citrusfruit1)
                    .addComponent(DriedFruit1)))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(Fruity1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Berry1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Blackberry1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Raspberry1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Blueberry1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Strawberry1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DriedFruit1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Raisen1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Prune1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
                .addComponent(Otherfruit1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Coconut1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cherry1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pomagranite1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pinneapple1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Grape1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Apple1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Peach1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pear1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Citrusfruit1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Grapefruit1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Orange1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lemon1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lime1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel25.setBackground(new java.awt.Color(243, 187, 111));

        Blacktea1.setBackground(new java.awt.Color(243, 187, 111));
        Blacktea1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Blacktea1.setText("Black tea");
        Blacktea1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Blacktea1MouseClicked(evt);
            }
        });

        Chamomile1.setBackground(new java.awt.Color(243, 187, 111));
        Chamomile1.setText("Chamomile");
        Chamomile1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Chamomile1MouseClicked(evt);
            }
        });

        Rose1.setBackground(new java.awt.Color(243, 187, 111));
        Rose1.setText("Rose");
        Rose1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Rose1MouseClicked(evt);
            }
        });

        Jasmine1.setBackground(new java.awt.Color(243, 187, 111));
        Jasmine1.setText("Jasmine");

        Floral1.setBackground(new java.awt.Color(243, 187, 111));
        Floral1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Floral1.setText("2     Floral");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Floral1)
                    .addComponent(Blacktea1)
                    .addComponent(Rose1)
                    .addComponent(Jasmine1)
                    .addComponent(Chamomile1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(Floral1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Blacktea1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
                .addComponent(Chamomile1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Rose1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Jasmine1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel26.setBackground(new java.awt.Color(255, 241, 144));

        Vinegar1.setBackground(new java.awt.Color(255, 241, 144));
        Vinegar1.setText("Vinegar");
        Vinegar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Vinegar1MouseClicked(evt);
            }
        });

        Rancidbutter1.setBackground(new java.awt.Color(255, 241, 144));
        Rancidbutter1.setText("Rancid butter");
        Rancidbutter1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Rancidbutter1MouseClicked(evt);
            }
        });

        RancidCheese1.setBackground(new java.awt.Color(255, 241, 144));
        RancidCheese1.setText("Rancid Cheese");
        RancidCheese1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RancidCheese1MouseClicked(evt);
            }
        });

        Winey1.setBackground(new java.awt.Color(255, 241, 144));
        Winey1.setText("Winey");
        Winey1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Winey1MouseClicked(evt);
            }
        });

        Whiskey1.setBackground(new java.awt.Color(255, 241, 144));
        Whiskey1.setText("Whiskey");
        Whiskey1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Whiskey1MouseClicked(evt);
            }
        });

        Fermented1.setBackground(new java.awt.Color(255, 241, 144));
        Fermented1.setText("Fermented");
        Fermented1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Fermented1MouseClicked(evt);
            }
        });

        Overripe1.setBackground(new java.awt.Color(255, 241, 144));
        Overripe1.setText("Over-ripe");
        Overripe1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Overripe1MouseClicked(evt);
            }
        });

        OrangeAcidity1.setBackground(new java.awt.Color(255, 241, 144));
        OrangeAcidity1.setText("Orange Acidity");
        OrangeAcidity1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrangeAcidity1MouseClicked(evt);
            }
        });

        AppleAcidity1.setBackground(new java.awt.Color(255, 241, 144));
        AppleAcidity1.setText("Apple Acidity");
        AppleAcidity1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AppleAcidity1MouseClicked(evt);
            }
        });

        Sour1.setBackground(new java.awt.Color(255, 241, 144));
        Sour1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Sour1.setText("4 Sour/Fermented");

        sour1.setBackground(new java.awt.Color(255, 241, 144));
        sour1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sour1.setText("Sour");
        sour1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sour1MouseClicked(evt);
            }
        });

        Alcohol1.setBackground(new java.awt.Color(255, 241, 144));
        Alcohol1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Alcohol1.setText("Alcohol/Fermented");
        Alcohol1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Alcohol1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AppleAcidity1)
                    .addComponent(Sour1)
                    .addComponent(Vinegar1)
                    .addComponent(Rancidbutter1)
                    .addComponent(RancidCheese1)
                    .addComponent(OrangeAcidity1)
                    .addComponent(Winey1)
                    .addComponent(Whiskey1)
                    .addComponent(Fermented1)
                    .addComponent(Overripe1)
                    .addComponent(sour1)
                    .addComponent(Alcohol1))
                .addGap(11, 11, 11))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Sour1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(sour1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Vinegar1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Rancidbutter1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RancidCheese1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OrangeAcidity1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AppleAcidity1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Alcohol1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Winey1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Whiskey1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Fermented1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Overripe1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel27.setBackground(new java.awt.Color(123, 236, 133));

        OliveOil1.setBackground(new java.awt.Color(123, 236, 133));
        OliveOil1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        OliveOil1.setText("Olive Oil");
        OliveOil1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OliveOil1MouseClicked(evt);
            }
        });

        Raw1.setBackground(new java.awt.Color(123, 236, 133));
        Raw1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Raw1.setText("Raw");
        Raw1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Raw1MouseClicked(evt);
            }
        });

        Underripe1.setBackground(new java.awt.Color(123, 236, 133));
        Underripe1.setText("Under-ripe");
        Underripe1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Underripe1MouseClicked(evt);
            }
        });

        Peapod1.setBackground(new java.awt.Color(123, 236, 133));
        Peapod1.setText("Pea pod");
        Peapod1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Peapod1MouseClicked(evt);
            }
        });

        Fresh1.setBackground(new java.awt.Color(123, 236, 133));
        Fresh1.setText("Fresh");
        Fresh1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Fresh1MouseClicked(evt);
            }
        });

        DarkGreen1.setBackground(new java.awt.Color(123, 236, 133));
        DarkGreen1.setText("Dark Green");
        DarkGreen1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DarkGreen1MouseClicked(evt);
            }
        });

        Vegetative1.setBackground(new java.awt.Color(123, 236, 133));
        Vegetative1.setText("Vegetative");
        Vegetative1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Vegetative1MouseClicked(evt);
            }
        });

        Haylike1.setBackground(new java.awt.Color(123, 236, 133));
        Haylike1.setText("Hay-like");
        Haylike1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Haylike1MouseClicked(evt);
            }
        });

        Herblike1.setBackground(new java.awt.Color(123, 236, 133));
        Herblike1.setText("Herb-like");
        Herblike1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Herblike1MouseClicked(evt);
            }
        });

        Beany1.setBackground(new java.awt.Color(123, 236, 133));
        Beany1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Beany1.setText("Beany");
        Beany1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Beany1MouseClicked(evt);
            }
        });

        Green1.setBackground(new java.awt.Color(123, 236, 133));
        Green1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Green1.setText("5 Green/Vegetative");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OliveOil1)
                    .addComponent(Raw1)
                    .addComponent(Underripe1)
                    .addComponent(Peapod1)
                    .addComponent(Fresh1)
                    .addComponent(DarkGreen1)
                    .addComponent(Vegetative1)
                    .addComponent(Haylike1)
                    .addComponent(Herblike1)
                    .addComponent(Beany1)
                    .addComponent(Green1))
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addComponent(Green1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OliveOil1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Raw1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Beany1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Underripe1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Peapod1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Fresh1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DarkGreen1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Vegetative1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Haylike1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Herblike1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel28.setBackground(new java.awt.Color(94, 249, 235));

        Stale1.setBackground(new java.awt.Color(94, 249, 235));
        Stale1.setText("Stale");
        Stale1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Stale1MouseClicked(evt);
            }
        });

        Cardboard1.setBackground(new java.awt.Color(94, 249, 235));
        Cardboard1.setText("Cardboard");
        Cardboard1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cardboard1MouseClicked(evt);
            }
        });

        Papery1.setBackground(new java.awt.Color(94, 249, 235));
        Papery1.setText("Papery");
        Papery1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Papery1MouseClicked(evt);
            }
        });

        Woody1.setBackground(new java.awt.Color(94, 249, 235));
        Woody1.setText("Woody");
        Woody1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Woody1MouseClicked(evt);
            }
        });

        MoldyDamp1.setBackground(new java.awt.Color(94, 249, 235));
        MoldyDamp1.setText("Moldy/Damp");
        MoldyDamp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MoldyDamp1MouseClicked(evt);
            }
        });

        MustyDusty1.setBackground(new java.awt.Color(94, 249, 235));
        MustyDusty1.setText("Musty/Dusty");
        MustyDusty1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MustyDusty1MouseClicked(evt);
            }
        });

        MustyEarthy1.setBackground(new java.awt.Color(94, 249, 235));
        MustyEarthy1.setText("Musty/Earthy");
        MustyEarthy1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MustyEarthy1MouseClicked(evt);
            }
        });

        Animalic1.setBackground(new java.awt.Color(94, 249, 235));
        Animalic1.setText("Animalic");
        Animalic1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Animalic1MouseClicked(evt);
            }
        });

        MeatyBrothy1.setBackground(new java.awt.Color(94, 249, 235));
        MeatyBrothy1.setText("Meaty/Brothy");
        MeatyBrothy1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MeatyBrothy1MouseClicked(evt);
            }
        });

        Phenolic1.setBackground(new java.awt.Color(94, 249, 235));
        Phenolic1.setText("Phenolic");
        Phenolic1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Phenolic1MouseClicked(evt);
            }
        });

        Bitter1.setBackground(new java.awt.Color(94, 249, 235));
        Bitter1.setText("Bitter");
        Bitter1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Bitter1MouseClicked(evt);
            }
        });

        Salty1.setBackground(new java.awt.Color(94, 249, 235));
        Salty1.setText("Salty");
        Salty1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Salty1MouseClicked(evt);
            }
        });

        Medicinal1.setBackground(new java.awt.Color(94, 249, 235));
        Medicinal1.setText("Medicinal");
        Medicinal1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Medicinal1MouseClicked(evt);
            }
        });

        Petroleum1.setBackground(new java.awt.Color(94, 249, 235));
        Petroleum1.setText("Petroleum");
        Petroleum1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Petroleum1MouseClicked(evt);
            }
        });

        Skunky1.setBackground(new java.awt.Color(94, 249, 235));
        Skunky1.setText("Skunky");
        Skunky1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Skunky1MouseClicked(evt);
            }
        });

        Rubber1.setBackground(new java.awt.Color(94, 249, 235));
        Rubber1.setText("Rubber");
        Rubber1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Rubber1MouseClicked(evt);
            }
        });

        Other1.setBackground(new java.awt.Color(94, 249, 235));
        Other1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Other1.setText("6    Other");

        PaperyM1.setBackground(new java.awt.Color(94, 249, 235));
        PaperyM1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PaperyM1.setText("Papery/Musty");
        PaperyM1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PaperyM1MouseClicked(evt);
            }
        });

        Chemical1.setBackground(new java.awt.Color(94, 249, 235));
        Chemical1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Chemical1.setText("Chemical");
        Chemical1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Chemical1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PaperyM1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Other1)
                    .addComponent(Stale1)
                    .addComponent(Cardboard1)
                    .addComponent(Papery1)
                    .addComponent(Woody1)
                    .addComponent(MoldyDamp1)
                    .addComponent(MustyDusty1)
                    .addComponent(MustyEarthy1)
                    .addComponent(Animalic1)
                    .addComponent(MeatyBrothy1)
                    .addComponent(Phenolic1)
                    .addComponent(Bitter1)
                    .addComponent(Salty1)
                    .addComponent(Medicinal1)
                    .addComponent(Petroleum1)
                    .addComponent(Skunky1)
                    .addComponent(Rubber1)
                    .addComponent(Chemical1)))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Other1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(PaperyM1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Stale1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cardboard1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Papery1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Woody1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MoldyDamp1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MustyDusty1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MustyEarthy1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Animalic1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MeatyBrothy1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Phenolic1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Chemical1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Bitter1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Salty1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Medicinal1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Petroleum1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Skunky1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Rubber1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel29.setBackground(new java.awt.Color(20, 181, 225));
        jPanel29.setForeground(new java.awt.Color(20, 181, 225));

        PipeTobacco1.setBackground(new java.awt.Color(20, 181, 225));
        PipeTobacco1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PipeTobacco1.setText("Pipe Tobacco");
        PipeTobacco1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PipeTobacco1MouseClicked(evt);
            }
        });

        Tobacco1.setBackground(new java.awt.Color(20, 181, 225));
        Tobacco1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Tobacco1.setText("Tobacco");
        Tobacco1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tobacco1MouseClicked(evt);
            }
        });

        Acrid1.setBackground(new java.awt.Color(20, 181, 225));
        Acrid1.setText("Acrid");
        Acrid1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Acrid1MouseClicked(evt);
            }
        });

        Ashy1.setBackground(new java.awt.Color(20, 181, 225));
        Ashy1.setText("Ashy");
        Ashy1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Ashy1MouseClicked(evt);
            }
        });

        Smoky1.setBackground(new java.awt.Color(20, 181, 225));
        Smoky1.setText("Smoky");
        Smoky1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Smoky1MouseClicked(evt);
            }
        });

        BrownRoast1.setBackground(new java.awt.Color(20, 181, 225));
        BrownRoast1.setText("Brown, Roast");
        BrownRoast1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BrownRoast1MouseClicked(evt);
            }
        });

        Grain1.setBackground(new java.awt.Color(20, 181, 225));
        Grain1.setText("Grain");
        Grain1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Grain1MouseClicked(evt);
            }
        });

        Malt1.setBackground(new java.awt.Color(20, 181, 225));
        Malt1.setText("Malt");
        Malt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Malt1MouseClicked(evt);
            }
        });

        Roasted1.setBackground(new java.awt.Color(20, 181, 225));
        Roasted1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Roasted1.setText("7  Roasted");

        Burnt1.setBackground(new java.awt.Color(20, 181, 225));
        Burnt1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Burnt1.setText("Burnt");
        Burnt1.setToolTipText("");
        Burnt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Burnt1MouseClicked(evt);
            }
        });

        Cereal1.setBackground(new java.awt.Color(20, 181, 225));
        Cereal1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Cereal1.setText("Cereal");
        Cereal1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cereal1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PipeTobacco1)
            .addComponent(Tobacco1)
            .addComponent(Acrid1)
            .addComponent(Ashy1)
            .addComponent(BrownRoast1)
            .addComponent(Grain1)
            .addComponent(Malt1)
            .addComponent(Roasted1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(Cereal1)
            .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(Burnt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Smoky1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Roasted1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PipeTobacco1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tobacco1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Burnt1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Acrid1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Ashy1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Smoky1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BrownRoast1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Cereal1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Grain1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Malt1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel30.setBackground(new java.awt.Color(187, 187, 240));

        Pungent1.setBackground(new java.awt.Color(187, 187, 240));
        Pungent1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Pungent1.setText("Pungent");
        Pungent1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Pungent1MouseClicked(evt);
            }
        });

        Pepper1.setBackground(new java.awt.Color(187, 187, 240));
        Pepper1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Pepper1.setText("Pepper");
        Pepper1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Pepper1MouseClicked(evt);
            }
        });

        Anise1.setBackground(new java.awt.Color(187, 187, 240));
        Anise1.setText("Anise");
        Anise1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Anise1MouseClicked(evt);
            }
        });

        Nutmeg1.setBackground(new java.awt.Color(187, 187, 240));
        Nutmeg1.setText("Nutmeg");
        Nutmeg1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Nutmeg1MouseClicked(evt);
            }
        });

        Cinnamon1.setBackground(new java.awt.Color(187, 187, 240));
        Cinnamon1.setText("Cinnamon");
        Cinnamon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cinnamon1MouseClicked(evt);
            }
        });

        Clove1.setBackground(new java.awt.Color(187, 187, 240));
        Clove1.setText("Clove");
        Clove1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Clove1MouseClicked(evt);
            }
        });

        Spices1.setBackground(new java.awt.Color(187, 187, 240));
        Spices1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Spices1.setText("8    Spices");

        Brownspices1.setBackground(new java.awt.Color(187, 187, 240));
        Brownspices1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Brownspices1.setText("Brown Spice");
        Brownspices1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Brownspices1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Pungent1)
                    .addComponent(Pepper1)
                    .addComponent(Anise1)
                    .addComponent(Nutmeg1)
                    .addComponent(Cinnamon1)
                    .addComponent(Clove1)
                    .addComponent(Spices1)
                    .addComponent(Brownspices1))
                .addGap(0, 14, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(Spices1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(Pungent1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pepper1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(Brownspices1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Anise1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Nutmeg1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cinnamon1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Clove1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel31.setBackground(new java.awt.Color(255, 102, 255));

        Peanuts1.setBackground(new java.awt.Color(255, 102, 255));
        Peanuts1.setText("Peanuts");
        Peanuts1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Peanuts1MouseClicked(evt);
            }
        });

        Hazelenut1.setBackground(new java.awt.Color(255, 102, 255));
        Hazelenut1.setText("Hazelenut");
        Hazelenut1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Hazelenut1MouseClicked(evt);
            }
        });

        Almond1.setBackground(new java.awt.Color(255, 102, 255));
        Almond1.setText("Almond");
        Almond1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Almond1MouseClicked(evt);
            }
        });

        Chocolate1.setBackground(new java.awt.Color(255, 102, 255));
        Chocolate1.setText("Chocolate");
        Chocolate1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Chocolate1MouseClicked(evt);
            }
        });

        DarkChocolate1.setBackground(new java.awt.Color(255, 102, 255));
        DarkChocolate1.setText("Dark Chocolate");
        DarkChocolate1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DarkChocolate1MouseClicked(evt);
            }
        });

        Nutty1.setBackground(new java.awt.Color(255, 102, 255));
        Nutty1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Nutty1.setText("Nutty");
        Nutty1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Nutty1MouseClicked(evt);
            }
        });

        Nuttycocoa1.setBackground(new java.awt.Color(255, 102, 255));
        Nuttycocoa1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Nuttycocoa1.setText("9 Nutty/Cocoa");

        Cocoa1.setBackground(new java.awt.Color(255, 102, 255));
        Cocoa1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Cocoa1.setText("Cocoa");
        Cocoa1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cocoa1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cocoa1)
                    .addComponent(Hazelenut1)
                    .addComponent(Almond1)
                    .addComponent(Peanuts1)
                    .addComponent(DarkChocolate1)
                    .addComponent(Chocolate1)
                    .addComponent(Nutty1)
                    .addComponent(Nuttycocoa1)))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Nuttycocoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Nutty1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Peanuts1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Hazelenut1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Almond1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Cocoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Chocolate1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DarkChocolate1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(706, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(166, Short.MAX_VALUE))
        );

        contenedorpaneles.addTab("Wet", jPanel9);

        jPanel62.setBackground(new java.awt.Color(255, 102, 102));

        BrownSugar2.setBackground(new java.awt.Color(255, 102, 102));
        BrownSugar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BrownSugar2.setText("Brown Sugar");
        BrownSugar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BrownSugar2MouseClicked(evt);
            }
        });

        MapleSugar2.setBackground(new java.awt.Color(255, 102, 102));
        MapleSugar2.setText("Maple Sugar");
        MapleSugar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MapleSugar2MouseClicked(evt);
            }
        });

        Carmelized2.setBackground(new java.awt.Color(255, 102, 102));
        Carmelized2.setText("Carmelized");
        Carmelized2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Carmelized2MouseClicked(evt);
            }
        });

        Molasses2.setBackground(new java.awt.Color(255, 102, 102));
        Molasses2.setText("Molasses");
        Molasses2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Molasses2MouseClicked(evt);
            }
        });

        Honey2.setBackground(new java.awt.Color(255, 102, 102));
        Honey2.setText("Honey");
        Honey2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Honey2MouseClicked(evt);
            }
        });

        Vanilla2.setBackground(new java.awt.Color(255, 102, 102));
        Vanilla2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Vanilla2.setText("Vanilla");
        Vanilla2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Vanilla2MouseClicked(evt);
            }
        });

        Sweet2.setBackground(new java.awt.Color(255, 102, 102));
        Sweet2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Sweet2.setText("1     Sweet");

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Vanilla2)
                    .addComponent(Honey2)
                    .addComponent(Carmelized2)
                    .addComponent(Molasses2)
                    .addComponent(BrownSugar2)
                    .addComponent(MapleSugar2)
                    .addComponent(Sweet2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel62Layout.createSequentialGroup()
                .addComponent(Sweet2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BrownSugar2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Molasses2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MapleSugar2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Carmelized2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Honey2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Vanilla2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        jPanel63.setBackground(new java.awt.Color(243, 187, 111));

        Blacktea2.setBackground(new java.awt.Color(243, 187, 111));
        Blacktea2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Blacktea2.setText("Black tea");
        Blacktea2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Blacktea2MouseClicked(evt);
            }
        });

        Chamomile2.setBackground(new java.awt.Color(243, 187, 111));
        Chamomile2.setText("Chamomile");
        Chamomile2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Chamomile2MouseClicked(evt);
            }
        });

        Rose2.setBackground(new java.awt.Color(243, 187, 111));
        Rose2.setText("Rose");
        Rose2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Rose2MouseClicked(evt);
            }
        });

        Jasmine2.setBackground(new java.awt.Color(243, 187, 111));
        Jasmine2.setText("Jasmine");
        Jasmine2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jasmine2MouseClicked(evt);
            }
        });

        Floral2.setBackground(new java.awt.Color(243, 187, 111));
        Floral2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Floral2.setText("2     Floral");

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Floral2)
                    .addComponent(Blacktea2)
                    .addComponent(Rose2)
                    .addComponent(Jasmine2)
                    .addComponent(Chamomile2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addComponent(Floral2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Blacktea2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Chamomile2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Rose2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Jasmine2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel64.setBackground(new java.awt.Color(236, 217, 25));

        Blackberry2.setBackground(new java.awt.Color(236, 217, 25));
        Blackberry2.setText("Blackberry");
        Blackberry2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Blackberry2MouseClicked(evt);
            }
        });

        Raspberry2.setBackground(new java.awt.Color(236, 217, 25));
        Raspberry2.setText("Raspberry");
        Raspberry2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Raspberry2MouseClicked(evt);
            }
        });

        Blueberry2.setBackground(new java.awt.Color(236, 217, 25));
        Blueberry2.setText("Blueberry");
        Blueberry2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Blueberry2MouseClicked(evt);
            }
        });

        Strawberry2.setBackground(new java.awt.Color(236, 217, 25));
        Strawberry2.setText("Strawberry");
        Strawberry2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Strawberry2MouseClicked(evt);
            }
        });

        Raisen2.setBackground(new java.awt.Color(236, 217, 25));
        Raisen2.setText("Raisen");
        Raisen2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Raisen2MouseClicked(evt);
            }
        });

        Prune2.setBackground(new java.awt.Color(236, 217, 25));
        Prune2.setText("Prune");
        Prune2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Prune2MouseClicked(evt);
            }
        });

        Coconut2.setBackground(new java.awt.Color(236, 217, 25));
        Coconut2.setText("Coconut");
        Coconut2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Coconut2MouseClicked(evt);
            }
        });

        Cherry2.setBackground(new java.awt.Color(236, 217, 25));
        Cherry2.setText("Cherry");
        Cherry2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cherry2MouseClicked(evt);
            }
        });

        Pomagranite2.setBackground(new java.awt.Color(236, 217, 25));
        Pomagranite2.setText("Pomagranite");
        Pomagranite2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Pomagranite2MouseClicked(evt);
            }
        });

        Pinneapple2.setBackground(new java.awt.Color(236, 217, 25));
        Pinneapple2.setText("Pinneapple");
        Pinneapple2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Pinneapple2MouseClicked(evt);
            }
        });

        Grape2.setBackground(new java.awt.Color(236, 217, 25));
        Grape2.setText("Grape");
        Grape2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Grape2MouseClicked(evt);
            }
        });

        Apple2.setBackground(new java.awt.Color(236, 217, 25));
        Apple2.setText("Apple");
        Apple2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Apple2MouseClicked(evt);
            }
        });

        Peach2.setBackground(new java.awt.Color(236, 217, 25));
        Peach2.setText("Peach");
        Peach2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Peach2MouseClicked(evt);
            }
        });

        Pear2.setBackground(new java.awt.Color(236, 217, 25));
        Pear2.setText("Pear");
        Pear2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Pear2MouseClicked(evt);
            }
        });

        Grapefruit2.setBackground(new java.awt.Color(236, 217, 25));
        Grapefruit2.setText("Grapefruit");
        Grapefruit2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Grapefruit2MouseClicked(evt);
            }
        });

        Orange2.setBackground(new java.awt.Color(236, 217, 25));
        Orange2.setText("Orange");
        Orange2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Orange2MouseClicked(evt);
            }
        });

        Lemon2.setBackground(new java.awt.Color(236, 217, 25));
        Lemon2.setText("Lemon");
        Lemon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Lemon2MouseClicked(evt);
            }
        });

        Lime2.setBackground(new java.awt.Color(236, 217, 25));
        Lime2.setText("Lime");
        Lime2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Lime2MouseClicked(evt);
            }
        });

        Fruity2.setBackground(new java.awt.Color(236, 217, 25));
        Fruity2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Fruity2.setText("3   Fruity");

        Berry2.setBackground(new java.awt.Color(236, 217, 25));
        Berry2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Berry2.setText("Berry");
        Berry2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Berry2MouseClicked(evt);
            }
        });

        DriedFruit2.setBackground(new java.awt.Color(236, 217, 25));
        DriedFruit2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DriedFruit2.setText("Dried Fruit");
        DriedFruit2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DriedFruit2MouseClicked(evt);
            }
        });

        Otherfruit2.setBackground(new java.awt.Color(236, 217, 25));
        Otherfruit2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Otherfruit2.setText("Other fruit");
        Otherfruit2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Otherfruit2MouseClicked(evt);
            }
        });

        Citrusfruit2.setBackground(new java.awt.Color(236, 217, 25));
        Citrusfruit2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Citrusfruit2.setText("Citrus Fruit");
        Citrusfruit2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Citrusfruit2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Blackberry2)
                        .addComponent(Raspberry2)
                        .addComponent(Blueberry2)
                        .addComponent(Orange2)
                        .addComponent(Lemon2)
                        .addComponent(Lime2)
                        .addComponent(Grapefruit2)
                        .addGroup(jPanel64Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Prune2)
                                .addComponent(Raisen2)))
                        .addComponent(Coconut2)
                        .addComponent(Cherry2)
                        .addComponent(Peach2)
                        .addComponent(Grape2)
                        .addComponent(Pinneapple2)
                        .addComponent(Apple2)
                        .addComponent(Pear2)
                        .addComponent(Pomagranite2)
                        .addComponent(Fruity2)
                        .addComponent(Berry2)
                        .addComponent(Strawberry2)
                        .addComponent(Otherfruit2)
                        .addComponent(Citrusfruit2))
                    .addComponent(DriedFruit2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addComponent(Fruity2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Berry2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Blackberry2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Raspberry2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Blueberry2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Strawberry2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DriedFruit2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Raisen2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Prune2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Otherfruit2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Coconut2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cherry2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pomagranite2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pinneapple2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Grape2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Apple2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Peach2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pear2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Citrusfruit2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Grapefruit2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Orange2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lemon2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lime2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel65.setBackground(new java.awt.Color(255, 241, 144));

        Vinegar2.setBackground(new java.awt.Color(255, 241, 144));
        Vinegar2.setText("Vinegar");
        Vinegar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Vinegar2MouseClicked(evt);
            }
        });

        Rancidbutter2.setBackground(new java.awt.Color(255, 241, 144));
        Rancidbutter2.setText("Rancid butter");
        Rancidbutter2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Rancidbutter2MouseClicked(evt);
            }
        });

        RancidCheese2.setBackground(new java.awt.Color(255, 241, 144));
        RancidCheese2.setText("Rancid Cheese");
        RancidCheese2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RancidCheese2MouseClicked(evt);
            }
        });

        Winey2.setBackground(new java.awt.Color(255, 241, 144));
        Winey2.setText("Winey");
        Winey2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Winey2MouseClicked(evt);
            }
        });

        Whiskey2.setBackground(new java.awt.Color(255, 241, 144));
        Whiskey2.setText("Whiskey");
        Whiskey2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Whiskey2MouseClicked(evt);
            }
        });

        Fermented2.setBackground(new java.awt.Color(255, 241, 144));
        Fermented2.setText("Fermented");
        Fermented2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Fermented2MouseClicked(evt);
            }
        });

        Overripe2.setBackground(new java.awt.Color(255, 241, 144));
        Overripe2.setText("Over-ripe");
        Overripe2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Overripe2MouseClicked(evt);
            }
        });

        OrangeAcidity2.setBackground(new java.awt.Color(255, 241, 144));
        OrangeAcidity2.setText("Orange Acidity");
        OrangeAcidity2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrangeAcidity2MouseClicked(evt);
            }
        });

        AppleAcidity2.setBackground(new java.awt.Color(255, 241, 144));
        AppleAcidity2.setText("Apple Acidity");
        AppleAcidity2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AppleAcidity2MouseClicked(evt);
            }
        });

        Sour2.setBackground(new java.awt.Color(255, 241, 144));
        Sour2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Sour2.setText("4 Sour/Fermented");

        sour2.setBackground(new java.awt.Color(255, 241, 144));
        sour2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sour2.setText("Sour");
        sour2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sour2MouseClicked(evt);
            }
        });

        Alcohol2.setBackground(new java.awt.Color(255, 241, 144));
        Alcohol2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Alcohol2.setText("Alcohol/Fermented");
        Alcohol2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Alcohol2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel65Layout.createSequentialGroup()
                            .addComponent(Alcohol2)
                            .addGap(121, 121, 121))
                        .addGroup(jPanel65Layout.createSequentialGroup()
                            .addComponent(sour2)
                            .addContainerGap()))
                    .addGroup(jPanel65Layout.createSequentialGroup()
                        .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AppleAcidity2)
                            .addComponent(OrangeAcidity2)
                            .addComponent(Vinegar2)
                            .addComponent(Rancidbutter2)
                            .addComponent(RancidCheese2)
                            .addComponent(Winey2)
                            .addComponent(Whiskey2)
                            .addComponent(Fermented2)
                            .addComponent(Overripe2)
                            .addComponent(Sour2))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Sour2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sour2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Vinegar2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Rancidbutter2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RancidCheese2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OrangeAcidity2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AppleAcidity2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Alcohol2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Winey2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Whiskey2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Fermented2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Overripe2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel66.setBackground(new java.awt.Color(123, 236, 133));

        OliveOil2.setBackground(new java.awt.Color(123, 236, 133));
        OliveOil2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        OliveOil2.setText("Olive Oil");
        OliveOil2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OliveOil2MouseClicked(evt);
            }
        });

        Raw2.setBackground(new java.awt.Color(123, 236, 133));
        Raw2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Raw2.setText("Raw");
        Raw2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Raw2MouseClicked(evt);
            }
        });

        Underripe2.setBackground(new java.awt.Color(123, 236, 133));
        Underripe2.setText("Under-ripe");
        Underripe2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Underripe2MouseClicked(evt);
            }
        });

        Peapod2.setBackground(new java.awt.Color(123, 236, 133));
        Peapod2.setText("Pea pod");
        Peapod2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Peapod2MouseClicked(evt);
            }
        });

        Fresh2.setBackground(new java.awt.Color(123, 236, 133));
        Fresh2.setText("Fresh");
        Fresh2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Fresh2MouseClicked(evt);
            }
        });

        DarkGreen2.setBackground(new java.awt.Color(123, 236, 133));
        DarkGreen2.setText("Dark Green");
        DarkGreen2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DarkGreen2MouseClicked(evt);
            }
        });

        Vegetative2.setBackground(new java.awt.Color(123, 236, 133));
        Vegetative2.setText("Vegetative");
        Vegetative2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Vegetative2MouseClicked(evt);
            }
        });

        Haylike2.setBackground(new java.awt.Color(123, 236, 133));
        Haylike2.setText("Hay-like");
        Haylike2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Haylike2MouseClicked(evt);
            }
        });

        Herblike2.setBackground(new java.awt.Color(123, 236, 133));
        Herblike2.setText("Herb-like");
        Herblike2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Herblike2MouseClicked(evt);
            }
        });

        Beany2.setBackground(new java.awt.Color(123, 236, 133));
        Beany2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Beany2.setText("Beany");
        Beany2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Beany2MouseClicked(evt);
            }
        });

        Green2.setBackground(new java.awt.Color(123, 236, 133));
        Green2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Green2.setText("5 Green/Vegetative");

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OliveOil2)
                    .addComponent(Raw2)
                    .addComponent(Underripe2)
                    .addComponent(Peapod2)
                    .addComponent(Fresh2)
                    .addComponent(DarkGreen2)
                    .addComponent(Vegetative2)
                    .addComponent(Haylike2)
                    .addComponent(Herblike2)
                    .addComponent(Beany2)
                    .addComponent(Green2))
                .addContainerGap())
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addComponent(Green2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OliveOil2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Raw2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Beany2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Underripe2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Peapod2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Fresh2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DarkGreen2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Vegetative2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Haylike2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Herblike2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel67.setBackground(new java.awt.Color(94, 249, 235));

        Stale2.setBackground(new java.awt.Color(94, 249, 235));
        Stale2.setText("Stale");
        Stale2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Stale2MouseClicked(evt);
            }
        });

        Cardboard2.setBackground(new java.awt.Color(94, 249, 235));
        Cardboard2.setText("Cardboard");
        Cardboard2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cardboard2MouseClicked(evt);
            }
        });

        Papery2.setBackground(new java.awt.Color(94, 249, 235));
        Papery2.setText("Papery");
        Papery2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Papery2MouseClicked(evt);
            }
        });

        Woody2.setBackground(new java.awt.Color(94, 249, 235));
        Woody2.setText("Woody");
        Woody2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Woody2MouseClicked(evt);
            }
        });

        MoldyDamp2.setBackground(new java.awt.Color(94, 249, 235));
        MoldyDamp2.setText("Moldy/Damp");
        MoldyDamp2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MoldyDamp2MouseClicked(evt);
            }
        });

        MustyDusty2.setBackground(new java.awt.Color(94, 249, 235));
        MustyDusty2.setText("Musty/Dusty");
        MustyDusty2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MustyDusty2MouseClicked(evt);
            }
        });

        MustyEarthy2.setBackground(new java.awt.Color(94, 249, 235));
        MustyEarthy2.setText("Musty/Earthy");
        MustyEarthy2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MustyEarthy2MouseClicked(evt);
            }
        });

        Animalic2.setBackground(new java.awt.Color(94, 249, 235));
        Animalic2.setText("Animalic");
        Animalic2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Animalic2MouseClicked(evt);
            }
        });

        MeatyBrothy2.setBackground(new java.awt.Color(94, 249, 235));
        MeatyBrothy2.setText("Meaty/Brothy");
        MeatyBrothy2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MeatyBrothy2MouseClicked(evt);
            }
        });

        Phenolic2.setBackground(new java.awt.Color(94, 249, 235));
        Phenolic2.setText("Phenolic");
        Phenolic2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Phenolic2MouseClicked(evt);
            }
        });

        Bitter2.setBackground(new java.awt.Color(94, 249, 235));
        Bitter2.setText("Bitter");
        Bitter2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Bitter2MouseClicked(evt);
            }
        });

        Salty2.setBackground(new java.awt.Color(94, 249, 235));
        Salty2.setText("Salty");
        Salty2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Salty2MouseClicked(evt);
            }
        });

        Medicinal2.setBackground(new java.awt.Color(94, 249, 235));
        Medicinal2.setText("Medicinal");
        Medicinal2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Medicinal2MouseClicked(evt);
            }
        });

        Petroleum2.setBackground(new java.awt.Color(94, 249, 235));
        Petroleum2.setText("Petroleum");
        Petroleum2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Petroleum2MouseClicked(evt);
            }
        });

        Skunky2.setBackground(new java.awt.Color(94, 249, 235));
        Skunky2.setText("Skunky");
        Skunky2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Skunky2MouseClicked(evt);
            }
        });

        Rubber2.setBackground(new java.awt.Color(94, 249, 235));
        Rubber2.setText("Rubber");
        Rubber2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Rubber2MouseClicked(evt);
            }
        });

        Other2.setBackground(new java.awt.Color(94, 249, 235));
        Other2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Other2.setText("6    Other");

        PaperyM2.setBackground(new java.awt.Color(94, 249, 235));
        PaperyM2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PaperyM2.setText("Papery/Musty");
        PaperyM2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PaperyM2MouseClicked(evt);
            }
        });

        Chemical2.setBackground(new java.awt.Color(94, 249, 235));
        Chemical2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Chemical2.setText("Chemical");
        Chemical2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Chemical2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel67Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PaperyM2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Other2)
                    .addComponent(Stale2)
                    .addComponent(Cardboard2)
                    .addComponent(Papery2)
                    .addComponent(Woody2)
                    .addComponent(MoldyDamp2)
                    .addComponent(MustyDusty2)
                    .addComponent(MustyEarthy2)
                    .addComponent(Animalic2)
                    .addComponent(MeatyBrothy2)
                    .addComponent(Phenolic2)
                    .addComponent(Bitter2)
                    .addComponent(Salty2)
                    .addComponent(Medicinal2)
                    .addComponent(Petroleum2)
                    .addComponent(Skunky2)
                    .addComponent(Rubber2)
                    .addComponent(Chemical2)))
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Other2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PaperyM2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Stale2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cardboard2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Papery2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Woody2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MoldyDamp2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MustyDusty2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MustyEarthy2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Animalic2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MeatyBrothy2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Phenolic2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Chemical2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Bitter2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Salty2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Medicinal2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Petroleum2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Skunky2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Rubber2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel68.setBackground(new java.awt.Color(20, 181, 225));
        jPanel68.setForeground(new java.awt.Color(20, 181, 225));

        PipeTobacco2.setBackground(new java.awt.Color(20, 181, 225));
        PipeTobacco2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PipeTobacco2.setText("Pipe Tobacco");
        PipeTobacco2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PipeTobacco2MouseClicked(evt);
            }
        });

        Tobacco2.setBackground(new java.awt.Color(20, 181, 225));
        Tobacco2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Tobacco2.setText("Tobacco");
        Tobacco2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tobacco2MouseClicked(evt);
            }
        });

        Acrid2.setBackground(new java.awt.Color(20, 181, 225));
        Acrid2.setText("Acrid");
        Acrid2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Acrid2MouseClicked(evt);
            }
        });

        Ashy2.setBackground(new java.awt.Color(20, 181, 225));
        Ashy2.setText("Ashy");
        Ashy2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Ashy2MouseClicked(evt);
            }
        });

        Smoky2.setBackground(new java.awt.Color(20, 181, 225));
        Smoky2.setText("Smoky");
        Smoky2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Smoky2MouseClicked(evt);
            }
        });

        BrownRoast2.setBackground(new java.awt.Color(20, 181, 225));
        BrownRoast2.setText("Brown, Roast");
        BrownRoast2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BrownRoast2MouseClicked(evt);
            }
        });

        Grain2.setBackground(new java.awt.Color(20, 181, 225));
        Grain2.setText("Grain");
        Grain2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Grain2MouseClicked(evt);
            }
        });

        Malt2.setBackground(new java.awt.Color(20, 181, 225));
        Malt2.setText("Malt");
        Malt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Malt2MouseClicked(evt);
            }
        });

        Roasted2.setBackground(new java.awt.Color(20, 181, 225));
        Roasted2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Roasted2.setText("7  Roasted");

        Burnt2.setBackground(new java.awt.Color(20, 181, 225));
        Burnt2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Burnt2.setText("Burnt");
        Burnt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Burnt2MouseClicked(evt);
            }
        });

        Cereal2.setBackground(new java.awt.Color(20, 181, 225));
        Cereal2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Cereal2.setText("Cereal");
        Cereal2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cereal2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PipeTobacco2)
            .addComponent(Tobacco2)
            .addComponent(BrownRoast2)
            .addComponent(Grain2)
            .addComponent(Malt2)
            .addComponent(Roasted2)
            .addComponent(Acrid2)
            .addComponent(Ashy2)
            .addComponent(Cereal2)
            .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(Burnt2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Smoky2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addComponent(Roasted2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(PipeTobacco2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tobacco2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Burnt2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Acrid2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Ashy2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Smoky2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BrownRoast2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Cereal2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Grain2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Malt2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        jPanel69.setBackground(new java.awt.Color(187, 187, 240));

        Pungent2.setBackground(new java.awt.Color(187, 187, 240));
        Pungent2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Pungent2.setText("Pungent");
        Pungent2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Pungent2MouseClicked(evt);
            }
        });

        Pepper2.setBackground(new java.awt.Color(187, 187, 240));
        Pepper2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Pepper2.setText("Pepper");
        Pepper2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Pepper2MouseClicked(evt);
            }
        });

        Anise2.setBackground(new java.awt.Color(187, 187, 240));
        Anise2.setText("Anise");
        Anise2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Anise2MouseClicked(evt);
            }
        });

        Nutmeg2.setBackground(new java.awt.Color(187, 187, 240));
        Nutmeg2.setText("Nutmeg");
        Nutmeg2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Nutmeg2MouseClicked(evt);
            }
        });

        Cinnamon2.setBackground(new java.awt.Color(187, 187, 240));
        Cinnamon2.setText("Cinnamon");
        Cinnamon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cinnamon2MouseClicked(evt);
            }
        });

        Clove2.setBackground(new java.awt.Color(187, 187, 240));
        Clove2.setText("Clove");
        Clove2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Clove2MouseClicked(evt);
            }
        });

        Spices2.setBackground(new java.awt.Color(187, 187, 240));
        Spices2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Spices2.setText("8    Spices");

        Brownspices2.setBackground(new java.awt.Color(187, 187, 240));
        Brownspices2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Brownspices2.setText("Brown Spice");
        Brownspices2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Brownspices2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Pungent2)
                    .addComponent(Pepper2)
                    .addComponent(Anise2)
                    .addComponent(Nutmeg2)
                    .addComponent(Cinnamon2)
                    .addComponent(Clove2)
                    .addComponent(Spices2)
                    .addComponent(Brownspices2))
                .addGap(0, 14, Short.MAX_VALUE))
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addComponent(Spices2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(Pungent2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pepper2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Brownspices2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(Anise2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Nutmeg2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cinnamon2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Clove2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel70.setBackground(new java.awt.Color(255, 102, 255));

        Peanuts2.setBackground(new java.awt.Color(255, 102, 255));
        Peanuts2.setText("Peanuts");
        Peanuts2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Peanuts2MouseClicked(evt);
            }
        });

        Hazelenut2.setBackground(new java.awt.Color(255, 102, 255));
        Hazelenut2.setText("Hazelenut");
        Hazelenut2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Hazelenut2MouseClicked(evt);
            }
        });

        Almond2.setBackground(new java.awt.Color(255, 102, 255));
        Almond2.setText("Almond");
        Almond2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Almond2MouseClicked(evt);
            }
        });

        Chocolate2.setBackground(new java.awt.Color(255, 102, 255));
        Chocolate2.setText("Chocolate");
        Chocolate2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Chocolate2MouseClicked(evt);
            }
        });

        DarkChocolate2.setBackground(new java.awt.Color(255, 102, 255));
        DarkChocolate2.setText("Dark Chocolate");
        DarkChocolate2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DarkChocolate2MouseClicked(evt);
            }
        });

        Nutty2.setBackground(new java.awt.Color(255, 102, 255));
        Nutty2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Nutty2.setText("Nutty");
        Nutty2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Nutty2MouseClicked(evt);
            }
        });

        Nuttycocoa2.setBackground(new java.awt.Color(255, 102, 255));
        Nuttycocoa2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Nuttycocoa2.setText("9 Nutty/Cocoa");

        Cocoa2.setBackground(new java.awt.Color(255, 102, 255));
        Cocoa2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Cocoa2.setText("Cocoa");
        Cocoa2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cocoa2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel70Layout = new javax.swing.GroupLayout(jPanel70);
        jPanel70.setLayout(jPanel70Layout);
        jPanel70Layout.setHorizontalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel70Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Nuttycocoa2)
                .addContainerGap())
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cocoa2)
                    .addComponent(Hazelenut2)
                    .addComponent(Almond2)
                    .addComponent(Peanuts2)
                    .addComponent(DarkChocolate2)
                    .addComponent(Chocolate2)
                    .addComponent(Nutty2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel70Layout.setVerticalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Nuttycocoa2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(Nutty2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Peanuts2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Hazelenut2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Almond2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Cocoa2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Chocolate2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DarkChocolate2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel67, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(712, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel68, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(163, Short.MAX_VALUE))
        );

        contenedorpaneles.addTab("Break", jPanel8);

        jPanel32.setBackground(new java.awt.Color(255, 102, 102));

        BrownSugar3.setBackground(new java.awt.Color(255, 102, 102));
        BrownSugar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BrownSugar3.setText("Brown Sugar");
        BrownSugar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BrownSugar3MouseClicked(evt);
            }
        });

        MapleSugar3.setBackground(new java.awt.Color(255, 102, 102));
        MapleSugar3.setText("Maple Sugar");
        MapleSugar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MapleSugar3MouseClicked(evt);
            }
        });

        Carmelized3.setBackground(new java.awt.Color(255, 102, 102));
        Carmelized3.setText("Carmelized");
        Carmelized3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Carmelized3MouseClicked(evt);
            }
        });

        Molasses3.setBackground(new java.awt.Color(255, 102, 102));
        Molasses3.setText("Molasses");
        Molasses3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Molasses3MouseClicked(evt);
            }
        });

        Honey3.setBackground(new java.awt.Color(255, 102, 102));
        Honey3.setText("Honey");
        Honey3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Honey3MouseClicked(evt);
            }
        });

        Vanilla3.setBackground(new java.awt.Color(255, 102, 102));
        Vanilla3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Vanilla3.setText("Vanilla");
        Vanilla3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Vanilla3MouseClicked(evt);
            }
        });

        Sweet3.setBackground(new java.awt.Color(255, 102, 102));
        Sweet3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Sweet3.setText("1     Sweet");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Vanilla3)
            .addComponent(Honey3)
            .addComponent(Carmelized3)
            .addComponent(Molasses3)
            .addComponent(BrownSugar3)
            .addComponent(MapleSugar3)
            .addComponent(Sweet3)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addComponent(Sweet3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BrownSugar3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Molasses3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MapleSugar3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Carmelized3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Honey3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Vanilla3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        jPanel33.setBackground(new java.awt.Color(236, 217, 25));

        Blackberry3.setBackground(new java.awt.Color(236, 217, 25));
        Blackberry3.setText("Blackberry");
        Blackberry3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Blackberry3MouseClicked(evt);
            }
        });

        Raspberry3.setBackground(new java.awt.Color(236, 217, 25));
        Raspberry3.setText("Raspberry");
        Raspberry3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Raspberry3MouseClicked(evt);
            }
        });

        Blueberry3.setBackground(new java.awt.Color(236, 217, 25));
        Blueberry3.setText("Blueberry");
        Blueberry3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Blueberry3MouseClicked(evt);
            }
        });

        Strawberry3.setBackground(new java.awt.Color(236, 217, 25));
        Strawberry3.setText("Strawberry");
        Strawberry3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Strawberry3MouseClicked(evt);
            }
        });

        Raisen3.setBackground(new java.awt.Color(236, 217, 25));
        Raisen3.setText("Raisen");
        Raisen3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Raisen3MouseClicked(evt);
            }
        });

        Prune3.setBackground(new java.awt.Color(236, 217, 25));
        Prune3.setText("Prune");
        Prune3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Prune3MouseClicked(evt);
            }
        });

        Coconut3.setBackground(new java.awt.Color(236, 217, 25));
        Coconut3.setText("Coconut");
        Coconut3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Coconut3MouseClicked(evt);
            }
        });

        Cherry3.setBackground(new java.awt.Color(236, 217, 25));
        Cherry3.setText("Cherry");
        Cherry3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cherry3MouseClicked(evt);
            }
        });

        Pomagranite3.setBackground(new java.awt.Color(236, 217, 25));
        Pomagranite3.setText("Pomagranite");
        Pomagranite3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Pomagranite3MouseClicked(evt);
            }
        });

        Pinneapple3.setBackground(new java.awt.Color(236, 217, 25));
        Pinneapple3.setText("Pinneapple");
        Pinneapple3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Pinneapple3MouseClicked(evt);
            }
        });

        Grape3.setBackground(new java.awt.Color(236, 217, 25));
        Grape3.setText("Grape");
        Grape3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Grape3MouseClicked(evt);
            }
        });

        Apple3.setBackground(new java.awt.Color(236, 217, 25));
        Apple3.setText("Apple");
        Apple3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Apple3MouseClicked(evt);
            }
        });

        Peach3.setBackground(new java.awt.Color(236, 217, 25));
        Peach3.setText("Peach");
        Peach3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Peach3MouseClicked(evt);
            }
        });

        Pear3.setBackground(new java.awt.Color(236, 217, 25));
        Pear3.setText("Pear");
        Pear3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Pear3MouseClicked(evt);
            }
        });

        Grapefruit3.setBackground(new java.awt.Color(236, 217, 25));
        Grapefruit3.setText("Grapefruit");
        Grapefruit3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Grapefruit3MouseClicked(evt);
            }
        });

        Orange3.setBackground(new java.awt.Color(236, 217, 25));
        Orange3.setText("Orange");
        Orange3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Orange3MouseClicked(evt);
            }
        });

        Lemon3.setBackground(new java.awt.Color(236, 217, 25));
        Lemon3.setText("Lemon");
        Lemon3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Lemon3MouseClicked(evt);
            }
        });

        Lime3.setBackground(new java.awt.Color(236, 217, 25));
        Lime3.setText("Lime");
        Lime3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Lime3MouseClicked(evt);
            }
        });

        Fruity3.setBackground(new java.awt.Color(236, 217, 25));
        Fruity3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Fruity3.setText("3   Fruity");

        Berry3.setBackground(new java.awt.Color(236, 217, 25));
        Berry3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Berry3.setText("Berry");
        Berry3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Berry3MouseClicked(evt);
            }
        });

        DriedFruit3.setBackground(new java.awt.Color(236, 217, 25));
        DriedFruit3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DriedFruit3.setText("Dried Fruit");
        DriedFruit3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DriedFruit3MouseClicked(evt);
            }
        });

        Otherfruit3.setBackground(new java.awt.Color(236, 217, 25));
        Otherfruit3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Otherfruit3.setText("Other fruit");
        Otherfruit3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Otherfruit3MouseClicked(evt);
            }
        });

        Citrusfruit3.setBackground(new java.awt.Color(236, 217, 25));
        Citrusfruit3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Citrusfruit3.setText("Citrus Fruit");
        Citrusfruit3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Citrusfruit3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Citrusfruit3)
                        .addComponent(Blackberry3)
                        .addComponent(Raspberry3)
                        .addComponent(Blueberry3)
                        .addComponent(Orange3)
                        .addComponent(Lemon3)
                        .addComponent(Lime3)
                        .addComponent(Grapefruit3)
                        .addGroup(jPanel33Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Prune3)
                                .addComponent(Raisen3)
                                .addComponent(Otherfruit3)))
                        .addComponent(Coconut3)
                        .addComponent(Cherry3)
                        .addComponent(Peach3)
                        .addComponent(Grape3)
                        .addComponent(Pinneapple3)
                        .addComponent(Apple3)
                        .addComponent(Pear3)
                        .addComponent(Pomagranite3)
                        .addComponent(Fruity3)
                        .addComponent(Berry3)
                        .addComponent(Strawberry3))
                    .addComponent(DriedFruit3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(Fruity3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Berry3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Blackberry3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Raspberry3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Blueberry3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Strawberry3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DriedFruit3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Raisen3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Prune3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Otherfruit3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Coconut3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cherry3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pomagranite3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pinneapple3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Grape3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Apple3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Peach3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pear3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Citrusfruit3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Grapefruit3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Orange3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lemon3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lime3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel34.setBackground(new java.awt.Color(243, 187, 111));

        Blacktea3.setBackground(new java.awt.Color(243, 187, 111));
        Blacktea3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Blacktea3.setText("Black tea");
        Blacktea3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Blacktea3MouseClicked(evt);
            }
        });

        Chamomile3.setBackground(new java.awt.Color(243, 187, 111));
        Chamomile3.setText("Chamomile");
        Chamomile3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Chamomile3MouseClicked(evt);
            }
        });

        Rose3.setBackground(new java.awt.Color(243, 187, 111));
        Rose3.setText("Rose");
        Rose3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Rose3MouseClicked(evt);
            }
        });

        Jasmine3.setBackground(new java.awt.Color(243, 187, 111));
        Jasmine3.setText("Jasmine");
        Jasmine3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jasmine3MouseClicked(evt);
            }
        });

        Floral3.setBackground(new java.awt.Color(243, 187, 111));
        Floral3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Floral3.setText("2     Floral");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Floral3))
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Rose3)
                            .addComponent(Jasmine3)
                            .addComponent(Chamomile3)
                            .addComponent(Blacktea3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addComponent(Floral3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Blacktea3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                .addComponent(Chamomile3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Rose3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Jasmine3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel35.setBackground(new java.awt.Color(255, 241, 144));

        Vinegar3.setBackground(new java.awt.Color(255, 241, 144));
        Vinegar3.setText("Vinegar");
        Vinegar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Vinegar3MouseClicked(evt);
            }
        });

        Rancidbutter3.setBackground(new java.awt.Color(255, 241, 144));
        Rancidbutter3.setText("Rancid butter");
        Rancidbutter3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Rancidbutter3MouseClicked(evt);
            }
        });

        RancidCheese3.setBackground(new java.awt.Color(255, 241, 144));
        RancidCheese3.setText("Rancid Cheese");
        RancidCheese3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RancidCheese3MouseClicked(evt);
            }
        });

        Winey3.setBackground(new java.awt.Color(255, 241, 144));
        Winey3.setText("Winey");
        Winey3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Winey3MouseClicked(evt);
            }
        });

        Whiskey3.setBackground(new java.awt.Color(255, 241, 144));
        Whiskey3.setText("Whiskey");
        Whiskey3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Whiskey3MouseClicked(evt);
            }
        });

        Fermented3.setBackground(new java.awt.Color(255, 241, 144));
        Fermented3.setText("Fermented");
        Fermented3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Fermented3MouseClicked(evt);
            }
        });

        Overripe3.setBackground(new java.awt.Color(255, 241, 144));
        Overripe3.setText("Over-ripe");
        Overripe3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Overripe3MouseClicked(evt);
            }
        });

        OrangeAcidity3.setBackground(new java.awt.Color(255, 241, 144));
        OrangeAcidity3.setText("Orange Acidity");
        OrangeAcidity3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrangeAcidity3MouseClicked(evt);
            }
        });

        AppleAcidity3.setBackground(new java.awt.Color(255, 241, 144));
        AppleAcidity3.setText("Apple Acidity");
        AppleAcidity3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AppleAcidity3MouseClicked(evt);
            }
        });

        Sour3.setBackground(new java.awt.Color(255, 241, 144));
        Sour3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Sour3.setText("4 Sour/Fermented");

        sour3.setBackground(new java.awt.Color(255, 241, 144));
        sour3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sour3.setText("Sour");
        sour3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sour3MouseClicked(evt);
            }
        });

        Alcohol3.setBackground(new java.awt.Color(255, 241, 144));
        Alcohol3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Alcohol3.setText("Alcohol/Fermented");
        Alcohol3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Alcohol3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(Sour3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sour3)
                            .addComponent(Alcohol3)
                            .addComponent(Overripe3)
                            .addComponent(Fermented3)
                            .addComponent(Whiskey3)
                            .addComponent(Winey3)
                            .addComponent(RancidCheese3)
                            .addComponent(Rancidbutter3)
                            .addComponent(Vinegar3)
                            .addComponent(AppleAcidity3)
                            .addComponent(OrangeAcidity3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addComponent(Sour3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sour3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Vinegar3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Rancidbutter3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RancidCheese3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OrangeAcidity3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AppleAcidity3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Alcohol3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Winey3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Whiskey3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Fermented3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Overripe3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel36.setBackground(new java.awt.Color(123, 236, 133));

        OliveOil3.setBackground(new java.awt.Color(123, 236, 133));
        OliveOil3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        OliveOil3.setText("Olive Oil");
        OliveOil3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OliveOil3MouseClicked(evt);
            }
        });

        Raw3.setBackground(new java.awt.Color(123, 236, 133));
        Raw3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Raw3.setText("Raw");
        Raw3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Raw3MouseClicked(evt);
            }
        });

        Underripe3.setBackground(new java.awt.Color(123, 236, 133));
        Underripe3.setText("Under-ripe");
        Underripe3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Underripe3MouseClicked(evt);
            }
        });

        Peapod3.setBackground(new java.awt.Color(123, 236, 133));
        Peapod3.setText("Pea pod");
        Peapod3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Peapod3MouseClicked(evt);
            }
        });

        Fresh3.setBackground(new java.awt.Color(123, 236, 133));
        Fresh3.setText("Fresh");
        Fresh3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Fresh3MouseClicked(evt);
            }
        });

        DarkGreen3.setBackground(new java.awt.Color(123, 236, 133));
        DarkGreen3.setText("Dark Green");
        DarkGreen3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DarkGreen3MouseClicked(evt);
            }
        });

        Vegetative3.setBackground(new java.awt.Color(123, 236, 133));
        Vegetative3.setText("Vegetative");
        Vegetative3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Vegetative3MouseClicked(evt);
            }
        });

        Haylike3.setBackground(new java.awt.Color(123, 236, 133));
        Haylike3.setText("Hay-like");
        Haylike3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Haylike3MouseClicked(evt);
            }
        });

        Herblike3.setBackground(new java.awt.Color(123, 236, 133));
        Herblike3.setText("Herb-like");
        Herblike3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Herblike3MouseClicked(evt);
            }
        });

        Beany3.setBackground(new java.awt.Color(123, 236, 133));
        Beany3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Beany3.setText("Beany");
        Beany3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Beany3MouseClicked(evt);
            }
        });

        Green3.setBackground(new java.awt.Color(123, 236, 133));
        Green3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Green3.setText("5 Green/Vegetative");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(OliveOil3)
            .addComponent(Raw3)
            .addComponent(Underripe3)
            .addComponent(Peapod3)
            .addComponent(Fresh3)
            .addComponent(DarkGreen3)
            .addComponent(Vegetative3)
            .addComponent(Haylike3)
            .addComponent(Herblike3)
            .addComponent(Beany3)
            .addComponent(Green3)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addComponent(Green3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OliveOil3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Raw3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Beany3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Underripe3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Peapod3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Fresh3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DarkGreen3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Vegetative3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Haylike3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Herblike3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel37.setBackground(new java.awt.Color(94, 249, 235));

        Stale3.setBackground(new java.awt.Color(94, 249, 235));
        Stale3.setText("Stale");
        Stale3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Stale3MouseClicked(evt);
            }
        });

        Cardboard3.setBackground(new java.awt.Color(94, 249, 235));
        Cardboard3.setText("Cardboard");
        Cardboard3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cardboard3MouseClicked(evt);
            }
        });

        Papery3.setBackground(new java.awt.Color(94, 249, 235));
        Papery3.setText("Papery");
        Papery3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Papery3MouseClicked(evt);
            }
        });

        Woody3.setBackground(new java.awt.Color(94, 249, 235));
        Woody3.setText("Woody");
        Woody3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Woody3MouseClicked(evt);
            }
        });

        MoldyDamp3.setBackground(new java.awt.Color(94, 249, 235));
        MoldyDamp3.setText("Moldy/Damp");
        MoldyDamp3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MoldyDamp3MouseClicked(evt);
            }
        });

        MustyDusty3.setBackground(new java.awt.Color(94, 249, 235));
        MustyDusty3.setText("Musty/Dusty");
        MustyDusty3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MustyDusty3MouseClicked(evt);
            }
        });

        MustyEarthy3.setBackground(new java.awt.Color(94, 249, 235));
        MustyEarthy3.setText("Musty/Earthy");
        MustyEarthy3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MustyEarthy3MouseClicked(evt);
            }
        });

        Animalic3.setBackground(new java.awt.Color(94, 249, 235));
        Animalic3.setText("Animalic");
        Animalic3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Animalic3MouseClicked(evt);
            }
        });

        MeatyBrothy3.setBackground(new java.awt.Color(94, 249, 235));
        MeatyBrothy3.setText("Meaty/Brothy");
        MeatyBrothy3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MeatyBrothy3MouseClicked(evt);
            }
        });

        Phenolic3.setBackground(new java.awt.Color(94, 249, 235));
        Phenolic3.setText("Phenolic");
        Phenolic3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Phenolic3MouseClicked(evt);
            }
        });

        Bitter3.setBackground(new java.awt.Color(94, 249, 235));
        Bitter3.setText("Bitter");
        Bitter3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Bitter3MouseClicked(evt);
            }
        });

        Salty3.setBackground(new java.awt.Color(94, 249, 235));
        Salty3.setText("Salty");
        Salty3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Salty3MouseClicked(evt);
            }
        });

        Medicinal3.setBackground(new java.awt.Color(94, 249, 235));
        Medicinal3.setText("Medicinal");
        Medicinal3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Medicinal3MouseClicked(evt);
            }
        });

        Petroleum3.setBackground(new java.awt.Color(94, 249, 235));
        Petroleum3.setText("Petroleum");
        Petroleum3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Petroleum3MouseClicked(evt);
            }
        });

        Skunky3.setBackground(new java.awt.Color(94, 249, 235));
        Skunky3.setText("Skunky");
        Skunky3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Skunky3MouseClicked(evt);
            }
        });

        Rubber3.setBackground(new java.awt.Color(94, 249, 235));
        Rubber3.setText("Rubber");
        Rubber3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Rubber3MouseClicked(evt);
            }
        });

        Other3.setBackground(new java.awt.Color(94, 249, 235));
        Other3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Other3.setText("6    Other");

        PaperyM3.setBackground(new java.awt.Color(94, 249, 235));
        PaperyM3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PaperyM3.setText("Papery/Musty");
        PaperyM3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PaperyM3MouseClicked(evt);
            }
        });

        Chemical3.setBackground(new java.awt.Color(94, 249, 235));
        Chemical3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Chemical3.setText("Chemical");
        Chemical3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Chemical3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PaperyM3)
                    .addComponent(Other3)
                    .addComponent(Stale3)
                    .addComponent(Cardboard3)
                    .addComponent(Papery3)
                    .addComponent(Woody3)
                    .addComponent(MoldyDamp3)
                    .addComponent(MustyDusty3)
                    .addComponent(MustyEarthy3)
                    .addComponent(Animalic3)
                    .addComponent(MeatyBrothy3)
                    .addComponent(Phenolic3)
                    .addComponent(Bitter3)
                    .addComponent(Salty3)
                    .addComponent(Medicinal3)
                    .addComponent(Petroleum3)
                    .addComponent(Skunky3)
                    .addComponent(Rubber3)
                    .addComponent(Chemical3))
                .addGap(11, 11, 11))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addComponent(Other3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PaperyM3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
                .addComponent(Stale3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cardboard3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Papery3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Woody3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MoldyDamp3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MustyDusty3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MustyEarthy3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Animalic3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MeatyBrothy3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Phenolic3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Chemical3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Bitter3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Salty3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Medicinal3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Petroleum3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Skunky3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Rubber3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel38.setBackground(new java.awt.Color(20, 181, 225));
        jPanel38.setForeground(new java.awt.Color(20, 181, 225));

        PipeTobacco3.setBackground(new java.awt.Color(20, 181, 225));
        PipeTobacco3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PipeTobacco3.setText("Pipe Tobacco");
        PipeTobacco3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PipeTobacco3MouseClicked(evt);
            }
        });

        Tobacco3.setBackground(new java.awt.Color(20, 181, 225));
        Tobacco3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Tobacco3.setText("Tobacco");
        Tobacco3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tobacco3MouseClicked(evt);
            }
        });

        Acrid3.setBackground(new java.awt.Color(20, 181, 225));
        Acrid3.setText("Acrid");
        Acrid3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Acrid3MouseClicked(evt);
            }
        });

        Ashy3.setBackground(new java.awt.Color(20, 181, 225));
        Ashy3.setText("Ashy");
        Ashy3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Ashy3MouseClicked(evt);
            }
        });

        Smoky3.setBackground(new java.awt.Color(20, 181, 225));
        Smoky3.setText("Smoky");
        Smoky3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Smoky3MouseClicked(evt);
            }
        });

        BrownRoast3.setBackground(new java.awt.Color(20, 181, 225));
        BrownRoast3.setText("Brown, Roast");
        BrownRoast3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BrownRoast3MouseClicked(evt);
            }
        });

        Grain3.setBackground(new java.awt.Color(20, 181, 225));
        Grain3.setText("Grain");
        Grain3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Grain3MouseClicked(evt);
            }
        });

        Malt3.setBackground(new java.awt.Color(20, 181, 225));
        Malt3.setText("Malt");
        Malt3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Malt3MouseClicked(evt);
            }
        });

        Roasted3.setBackground(new java.awt.Color(20, 181, 225));
        Roasted3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Roasted3.setText("7  Roasted");

        Burnt3.setBackground(new java.awt.Color(20, 181, 225));
        Burnt3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Burnt3.setText("Burnt");
        Burnt3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Burnt3MouseClicked(evt);
            }
        });

        Cereal3.setBackground(new java.awt.Color(20, 181, 225));
        Cereal3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Cereal3.setText("Cereal");
        Cereal3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cereal3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PipeTobacco3)
            .addComponent(Tobacco3)
            .addComponent(Acrid3)
            .addComponent(Ashy3)
            .addComponent(BrownRoast3)
            .addComponent(Grain3)
            .addComponent(Malt3)
            .addComponent(Roasted3)
            .addComponent(Cereal3)
            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(Burnt3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Smoky3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addComponent(Roasted3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(PipeTobacco3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tobacco3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Burnt3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Acrid3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Ashy3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Smoky3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BrownRoast3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Cereal3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Grain3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Malt3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel39.setBackground(new java.awt.Color(187, 187, 240));

        Pungent3.setBackground(new java.awt.Color(187, 187, 240));
        Pungent3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Pungent3.setText("Pungent");
        Pungent3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Pungent3MouseClicked(evt);
            }
        });

        Pepper3.setBackground(new java.awt.Color(187, 187, 240));
        Pepper3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Pepper3.setText("Pepper");
        Pepper3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Pepper3MouseClicked(evt);
            }
        });

        Anise3.setBackground(new java.awt.Color(187, 187, 240));
        Anise3.setText("Anise");
        Anise3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Anise3MouseClicked(evt);
            }
        });

        Nutmeg3.setBackground(new java.awt.Color(187, 187, 240));
        Nutmeg3.setText("Nutmeg");
        Nutmeg3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Nutmeg3MouseClicked(evt);
            }
        });

        Cinnamon3.setBackground(new java.awt.Color(187, 187, 240));
        Cinnamon3.setText("Cinnamon");
        Cinnamon3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cinnamon3MouseClicked(evt);
            }
        });

        Clove3.setBackground(new java.awt.Color(187, 187, 240));
        Clove3.setText("Clove");
        Clove3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Clove3MouseClicked(evt);
            }
        });

        Spices3.setBackground(new java.awt.Color(187, 187, 240));
        Spices3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Spices3.setText("8    Spices");

        Brownspices3.setBackground(new java.awt.Color(187, 187, 240));
        Brownspices3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Brownspices3.setText("Brown Spice");
        Brownspices3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Brownspices3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Pungent3)
                    .addComponent(Pepper3)
                    .addComponent(Anise3)
                    .addComponent(Nutmeg3)
                    .addComponent(Cinnamon3)
                    .addComponent(Clove3)
                    .addComponent(Spices3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Brownspices3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(Spices3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(Pungent3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pepper3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(Brownspices3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Anise3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Nutmeg3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cinnamon3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Clove3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel40.setBackground(new java.awt.Color(255, 102, 255));

        Peanuts3.setBackground(new java.awt.Color(255, 102, 255));
        Peanuts3.setText("Peanuts");
        Peanuts3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Peanuts3MouseClicked(evt);
            }
        });

        Hazelenut3.setBackground(new java.awt.Color(255, 102, 255));
        Hazelenut3.setText("Hazelenut");
        Hazelenut3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Hazelenut3MouseClicked(evt);
            }
        });

        Almond3.setBackground(new java.awt.Color(255, 102, 255));
        Almond3.setText("Almond");
        Almond3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Almond3MouseClicked(evt);
            }
        });

        Chocolate3.setBackground(new java.awt.Color(255, 102, 255));
        Chocolate3.setText("Chocolate");
        Chocolate3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Chocolate3MouseClicked(evt);
            }
        });

        DarkChocolate3.setBackground(new java.awt.Color(255, 102, 255));
        DarkChocolate3.setText("Dark Chocolate");
        DarkChocolate3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DarkChocolate3MouseClicked(evt);
            }
        });

        Nutty3.setBackground(new java.awt.Color(255, 102, 255));
        Nutty3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Nutty3.setText("Nutty");
        Nutty3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Nutty3MouseClicked(evt);
            }
        });

        Nuttycocoa3.setBackground(new java.awt.Color(255, 102, 255));
        Nuttycocoa3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Nuttycocoa3.setText("9 Nutty/Cocoa");

        Cocoa3.setBackground(new java.awt.Color(255, 102, 255));
        Cocoa3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Cocoa3.setText("Cocoa");
        Cocoa3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cocoa3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cocoa3)
                    .addComponent(Hazelenut3)
                    .addComponent(Almond3)
                    .addComponent(Peanuts3)
                    .addComponent(DarkChocolate3)
                    .addComponent(Chocolate3)
                    .addComponent(Nutty3)
                    .addComponent(Nuttycocoa3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Nuttycocoa3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(Nutty3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Peanuts3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Hazelenut3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Almond3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Cocoa3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Chocolate3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DarkChocolate3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(158, Short.MAX_VALUE))
        );

        contenedorpaneles.addTab("Flavor", jPanel10);

        jPanel59.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroup2.add(Medium);
        Medium.setText("Medium");

        buttonGroup2.add(Long);
        Long.setText("Long");

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel84.setText("11   Finish ");

        buttonGroup2.add(Short1);
        Short1.setText("Short");

        buttonGroup2.add(Dryf);
        Dryf.setText("Dry");

        buttonGroup2.add(Astringent);
        Astringent.setText("Astringent");

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Astringent)
                    .addComponent(Dryf)
                    .addComponent(Long)
                    .addComponent(Medium)
                    .addComponent(Short1)
                    .addComponent(jLabel84))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addComponent(jLabel84)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Short1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(Medium, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Long, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Dryf, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Astringent, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel41.setBackground(new java.awt.Color(255, 102, 102));

        BrownSugar4.setBackground(new java.awt.Color(255, 102, 102));
        BrownSugar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BrownSugar4.setText("Brown Sugar");

        MapleSugar4.setBackground(new java.awt.Color(255, 102, 102));
        MapleSugar4.setText("Maple Sugar");

        Carmelized4.setBackground(new java.awt.Color(255, 102, 102));
        Carmelized4.setText("Carmelized");

        Molasses4.setBackground(new java.awt.Color(255, 102, 102));
        Molasses4.setText("Molasses");

        Honey4.setBackground(new java.awt.Color(255, 102, 102));
        Honey4.setText("Honey");

        Vanilla4.setBackground(new java.awt.Color(255, 102, 102));
        Vanilla4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Vanilla4.setText("Vanilla");

        Sweet4.setBackground(new java.awt.Color(255, 102, 102));
        Sweet4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Sweet4.setText("1     Sweet");

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Vanilla4)
            .addComponent(Honey4)
            .addComponent(Carmelized4)
            .addComponent(Molasses4)
            .addComponent(BrownSugar4)
            .addComponent(MapleSugar4)
            .addComponent(Sweet4)
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                .addComponent(Sweet4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BrownSugar4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Molasses4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MapleSugar4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Carmelized4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Honey4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Vanilla4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        jPanel42.setBackground(new java.awt.Color(236, 217, 25));

        Blackberry4.setBackground(new java.awt.Color(236, 217, 25));
        Blackberry4.setText("Blackberry");

        Raspberry4.setBackground(new java.awt.Color(236, 217, 25));
        Raspberry4.setText("Raspberry");

        Blueberry4.setBackground(new java.awt.Color(236, 217, 25));
        Blueberry4.setText("Blueberry");

        Strawberry4.setBackground(new java.awt.Color(236, 217, 25));
        Strawberry4.setText("Strawberry");

        Raisen4.setBackground(new java.awt.Color(236, 217, 25));
        Raisen4.setText("Raisen");

        Prune4.setBackground(new java.awt.Color(236, 217, 25));
        Prune4.setText("Prune");

        Coconut4.setBackground(new java.awt.Color(236, 217, 25));
        Coconut4.setText("Coconut");

        Cherry4.setBackground(new java.awt.Color(236, 217, 25));
        Cherry4.setText("Cherry");

        Pomagranite4.setBackground(new java.awt.Color(236, 217, 25));
        Pomagranite4.setText("Pomagranite");

        Pinneapple4.setBackground(new java.awt.Color(236, 217, 25));
        Pinneapple4.setText("Pinneapple");

        Grape4.setBackground(new java.awt.Color(236, 217, 25));
        Grape4.setText("Grape");

        Apple4.setBackground(new java.awt.Color(236, 217, 25));
        Apple4.setText("Apple");

        Peach4.setBackground(new java.awt.Color(236, 217, 25));
        Peach4.setText("Peach");

        Pear4.setBackground(new java.awt.Color(236, 217, 25));
        Pear4.setText("Pear");

        Grapefruit4.setBackground(new java.awt.Color(236, 217, 25));
        Grapefruit4.setText("Grapefruit");

        Orange4.setBackground(new java.awt.Color(236, 217, 25));
        Orange4.setText("Orange");

        Lemon4.setBackground(new java.awt.Color(236, 217, 25));
        Lemon4.setText("Lemon");

        Lime4.setBackground(new java.awt.Color(236, 217, 25));
        Lime4.setText("Lime");

        Fruity4.setBackground(new java.awt.Color(236, 217, 25));
        Fruity4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Fruity4.setText("3   Fruity");

        Berry4.setBackground(new java.awt.Color(236, 217, 25));
        Berry4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Berry4.setText("Berry");

        DriedFruit4.setBackground(new java.awt.Color(236, 217, 25));
        DriedFruit4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DriedFruit4.setText("Dried Fruit");

        Otherfruit4.setBackground(new java.awt.Color(236, 217, 25));
        Otherfruit4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Otherfruit4.setText("Other fruit");

        Citrusfruit4.setBackground(new java.awt.Color(236, 217, 25));
        Citrusfruit4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Citrusfruit4.setText("Citrus Fruit");

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DriedFruit4)
                    .addComponent(Blackberry4)
                    .addComponent(Raspberry4)
                    .addComponent(Blueberry4)
                    .addComponent(Orange4)
                    .addComponent(Lemon4)
                    .addComponent(Lime4)
                    .addComponent(Grapefruit4)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Prune4)
                            .addComponent(Raisen4)
                            .addComponent(Otherfruit4)))
                    .addComponent(Coconut4)
                    .addComponent(Cherry4)
                    .addComponent(Peach4)
                    .addComponent(Grape4)
                    .addComponent(Pinneapple4)
                    .addComponent(Apple4)
                    .addComponent(Pear4)
                    .addComponent(Pomagranite4)
                    .addComponent(Fruity4)
                    .addComponent(Berry4)
                    .addComponent(Strawberry4)
                    .addComponent(Citrusfruit4)))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addComponent(Fruity4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Berry4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Blackberry4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Raspberry4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Blueberry4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Strawberry4, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DriedFruit4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Raisen4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Prune4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Otherfruit4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Coconut4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cherry4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pomagranite4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pinneapple4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Grape4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Apple4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Peach4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pear4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Citrusfruit4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Grapefruit4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Orange4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lemon4, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lime4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel43.setBackground(new java.awt.Color(243, 187, 111));

        Blacktea4.setBackground(new java.awt.Color(243, 187, 111));
        Blacktea4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Blacktea4.setText("Black tea");

        Chamomile4.setBackground(new java.awt.Color(243, 187, 111));
        Chamomile4.setText("Chamomile");

        Rose4.setBackground(new java.awt.Color(243, 187, 111));
        Rose4.setText("Rose");

        Jasmine4.setBackground(new java.awt.Color(243, 187, 111));
        Jasmine4.setText("Jasmine");

        Floral4.setBackground(new java.awt.Color(243, 187, 111));
        Floral4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Floral4.setText("2     Floral");

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Floral4)
                    .addComponent(Blacktea4)
                    .addComponent(Chamomile4)
                    .addComponent(Rose4)
                    .addComponent(Jasmine4))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addComponent(Floral4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Blacktea4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Chamomile4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Rose4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Jasmine4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jPanel44.setBackground(new java.awt.Color(255, 241, 144));

        Vinegar4.setBackground(new java.awt.Color(255, 241, 144));
        Vinegar4.setText("Vinegar");

        Rancidbutter4.setBackground(new java.awt.Color(255, 241, 144));
        Rancidbutter4.setText("Rancid butter");

        RancidCheese4.setBackground(new java.awt.Color(255, 241, 144));
        RancidCheese4.setText("Rancid Cheese");

        Winey4.setBackground(new java.awt.Color(255, 241, 144));
        Winey4.setText("Winey");

        Whiskey4.setBackground(new java.awt.Color(255, 241, 144));
        Whiskey4.setText("Whiskey");

        Fermented4.setBackground(new java.awt.Color(255, 241, 144));
        Fermented4.setText("Fermented");

        Overripe4.setBackground(new java.awt.Color(255, 241, 144));
        Overripe4.setText("Over-ripe");

        OrangeAcidity4.setBackground(new java.awt.Color(255, 241, 144));
        OrangeAcidity4.setText("Orange Acidity");

        AppleAcidity4.setBackground(new java.awt.Color(255, 241, 144));
        AppleAcidity4.setText("Apple Acidity");

        Sour4.setBackground(new java.awt.Color(255, 241, 144));
        Sour4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Sour4.setText("4 Sour/Fermented");

        sour4.setBackground(new java.awt.Color(255, 241, 144));
        sour4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sour4.setText("Sour");

        Alcohol4.setBackground(new java.awt.Color(255, 241, 144));
        Alcohol4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Alcohol4.setText("Alcohol/Fermented");

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Overripe4)
                    .addComponent(Fermented4)
                    .addComponent(Whiskey4)
                    .addComponent(Winey4)
                    .addComponent(RancidCheese4)
                    .addComponent(Rancidbutter4)
                    .addComponent(Vinegar4)
                    .addComponent(AppleAcidity4)
                    .addComponent(OrangeAcidity4)
                    .addComponent(sour4)
                    .addComponent(Alcohol4)
                    .addComponent(Sour4)))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addComponent(Sour4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(sour4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(Vinegar4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Rancidbutter4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RancidCheese4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OrangeAcidity4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AppleAcidity4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Alcohol4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Winey4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Whiskey4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Fermented4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Overripe4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel45.setBackground(new java.awt.Color(123, 236, 133));

        OliveOil4.setBackground(new java.awt.Color(123, 236, 133));
        OliveOil4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        OliveOil4.setText("Olive Oil");

        Raw4.setBackground(new java.awt.Color(123, 236, 133));
        Raw4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Raw4.setText("Raw");

        Underripe4.setBackground(new java.awt.Color(123, 236, 133));
        Underripe4.setText("Under-ripe");

        Peapod4.setBackground(new java.awt.Color(123, 236, 133));
        Peapod4.setText("Pea pod");

        Fresh4.setBackground(new java.awt.Color(123, 236, 133));
        Fresh4.setText("Fresh");

        DarkGreen4.setBackground(new java.awt.Color(123, 236, 133));
        DarkGreen4.setText("Dark Green");

        Vegetative4.setBackground(new java.awt.Color(123, 236, 133));
        Vegetative4.setText("Vegetative");

        Haylike4.setBackground(new java.awt.Color(123, 236, 133));
        Haylike4.setText("Hay-like");

        Herblike4.setBackground(new java.awt.Color(123, 236, 133));
        Herblike4.setText("Herb-like");

        Beany4.setBackground(new java.awt.Color(123, 236, 133));
        Beany4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Beany4.setText("Beany");

        Green4.setBackground(new java.awt.Color(123, 236, 133));
        Green4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Green4.setText("5 Green/Vegetative");

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Underripe4)
                    .addComponent(Peapod4)
                    .addComponent(Fresh4)
                    .addComponent(DarkGreen4)
                    .addComponent(Vegetative4)
                    .addComponent(Haylike4)
                    .addComponent(Herblike4)
                    .addComponent(OliveOil4)
                    .addComponent(Raw4)
                    .addComponent(Beany4)
                    .addComponent(Green4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addComponent(Green4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OliveOil4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Raw4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Beany4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Underripe4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Peapod4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Fresh4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DarkGreen4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Vegetative4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Haylike4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Herblike4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );

        jPanel46.setBackground(new java.awt.Color(94, 249, 235));

        Stale4.setBackground(new java.awt.Color(94, 249, 235));
        Stale4.setText("Stale");
        Stale4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Stale4ActionPerformed(evt);
            }
        });

        Cardboard4.setBackground(new java.awt.Color(94, 249, 235));
        Cardboard4.setText("Cardboard");
        Cardboard4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cardboard4ActionPerformed(evt);
            }
        });

        Papery4.setBackground(new java.awt.Color(94, 249, 235));
        Papery4.setText("Papery");
        Papery4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Papery4ActionPerformed(evt);
            }
        });

        Woody4.setBackground(new java.awt.Color(94, 249, 235));
        Woody4.setText("Woody");
        Woody4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Woody4ActionPerformed(evt);
            }
        });

        MoldyDamp4.setBackground(new java.awt.Color(94, 249, 235));
        MoldyDamp4.setText("Moldy/Damp");
        MoldyDamp4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoldyDamp4ActionPerformed(evt);
            }
        });

        MustyDusty4.setBackground(new java.awt.Color(94, 249, 235));
        MustyDusty4.setText("Musty/Dusty");
        MustyDusty4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MustyDusty4ActionPerformed(evt);
            }
        });

        MustyEarthy4.setBackground(new java.awt.Color(94, 249, 235));
        MustyEarthy4.setText("Musty/Earthy");
        MustyEarthy4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MustyEarthy4ActionPerformed(evt);
            }
        });

        Animalic4.setBackground(new java.awt.Color(94, 249, 235));
        Animalic4.setText("Animalic");
        Animalic4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Animalic4ActionPerformed(evt);
            }
        });

        MeatyBrothy4.setBackground(new java.awt.Color(94, 249, 235));
        MeatyBrothy4.setText("Meaty/Brothy");
        MeatyBrothy4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MeatyBrothy4ActionPerformed(evt);
            }
        });

        Phenolic4.setBackground(new java.awt.Color(94, 249, 235));
        Phenolic4.setText("Phenolic");
        Phenolic4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Phenolic4ActionPerformed(evt);
            }
        });

        Bitter4.setBackground(new java.awt.Color(94, 249, 235));
        Bitter4.setText("Bitter");
        Bitter4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bitter4ActionPerformed(evt);
            }
        });

        Salty4.setBackground(new java.awt.Color(94, 249, 235));
        Salty4.setText("Salty");
        Salty4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Salty4ActionPerformed(evt);
            }
        });

        Medicinal4.setBackground(new java.awt.Color(94, 249, 235));
        Medicinal4.setText("Medicinal");
        Medicinal4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Medicinal4ActionPerformed(evt);
            }
        });

        Petroleum4.setBackground(new java.awt.Color(94, 249, 235));
        Petroleum4.setText("Petroleum");
        Petroleum4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Petroleum4ActionPerformed(evt);
            }
        });

        Skunky4.setBackground(new java.awt.Color(94, 249, 235));
        Skunky4.setText("Skunky");
        Skunky4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Skunky4ActionPerformed(evt);
            }
        });

        Rubber4.setBackground(new java.awt.Color(94, 249, 235));
        Rubber4.setText("Rubber");
        Rubber4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rubber4ActionPerformed(evt);
            }
        });

        Other4.setBackground(new java.awt.Color(94, 249, 235));
        Other4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Other4.setText("6    Other");

        PaperyM4.setBackground(new java.awt.Color(94, 249, 235));
        PaperyM4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PaperyM4.setText("Papery/Musty");

        Chemical4.setBackground(new java.awt.Color(94, 249, 235));
        Chemical4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Chemical4.setText("Chemical");

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Stale4)
                                .addComponent(Cardboard4)
                                .addComponent(Papery4)
                                .addComponent(Woody4)
                                .addComponent(MoldyDamp4)
                                .addComponent(MustyDusty4)
                                .addComponent(MustyEarthy4)
                                .addComponent(Animalic4)
                                .addComponent(MeatyBrothy4)
                                .addComponent(Phenolic4)
                                .addComponent(Bitter4)
                                .addComponent(Salty4)
                                .addComponent(Medicinal4)
                                .addComponent(Petroleum4)
                                .addComponent(Skunky4)
                                .addComponent(Rubber4)
                                .addComponent(Chemical4))
                            .addComponent(Other4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                        .addComponent(PaperyM4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addComponent(Other4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(PaperyM4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Stale4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cardboard4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Papery4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Woody4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MoldyDamp4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MustyDusty4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MustyEarthy4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Animalic4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MeatyBrothy4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Phenolic4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Chemical4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Bitter4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Salty4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Medicinal4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Petroleum4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Skunky4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Rubber4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel47.setBackground(new java.awt.Color(20, 181, 225));
        jPanel47.setForeground(new java.awt.Color(20, 181, 225));

        PipeTobacco4.setBackground(new java.awt.Color(20, 181, 225));
        PipeTobacco4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PipeTobacco4.setText("Pipe Tobacco");
        PipeTobacco4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PipeTobacco4ActionPerformed(evt);
            }
        });

        Tobacco4.setBackground(new java.awt.Color(20, 181, 225));
        Tobacco4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Tobacco4.setText("Tobacco");
        Tobacco4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tobacco4ActionPerformed(evt);
            }
        });

        Acrid4.setBackground(new java.awt.Color(20, 181, 225));
        Acrid4.setText("Acrid");
        Acrid4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Acrid4ActionPerformed(evt);
            }
        });

        Ashy4.setBackground(new java.awt.Color(20, 181, 225));
        Ashy4.setText("Ashy");
        Ashy4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ashy4ActionPerformed(evt);
            }
        });

        Smoky4.setBackground(new java.awt.Color(20, 181, 225));
        Smoky4.setText("Smoky");
        Smoky4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Smoky4ActionPerformed(evt);
            }
        });

        BrownRoast4.setBackground(new java.awt.Color(20, 181, 225));
        BrownRoast4.setText("Brown, Roast");
        BrownRoast4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrownRoast4ActionPerformed(evt);
            }
        });

        Grain4.setBackground(new java.awt.Color(20, 181, 225));
        Grain4.setText("Grain");
        Grain4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Grain4ActionPerformed(evt);
            }
        });

        Malt4.setBackground(new java.awt.Color(20, 181, 225));
        Malt4.setText("Malt");
        Malt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Malt4ActionPerformed(evt);
            }
        });

        Roasted4.setBackground(new java.awt.Color(20, 181, 225));
        Roasted4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Roasted4.setText("7  Roasted");

        Burnt4.setBackground(new java.awt.Color(20, 181, 225));
        Burnt4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Burnt4.setText("Burnt");
        Burnt4.setToolTipText("");

        Cereal4.setBackground(new java.awt.Color(20, 181, 225));
        Cereal4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Cereal4.setText("Cereal");

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PipeTobacco4)
            .addComponent(Tobacco4)
            .addComponent(Acrid4)
            .addComponent(Ashy4)
            .addComponent(BrownRoast4)
            .addComponent(Grain4)
            .addComponent(Roasted4)
            .addComponent(Cereal4)
            .addComponent(Malt4)
            .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(Burnt4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Smoky4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addComponent(Roasted4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(PipeTobacco4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tobacco4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Burnt4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Acrid4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Ashy4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Smoky4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BrownRoast4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Cereal4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Grain4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Malt4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jPanel48.setBackground(new java.awt.Color(187, 187, 240));

        Pungent4.setBackground(new java.awt.Color(187, 187, 240));
        Pungent4.setText("Pungent");
        Pungent4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pungent4ActionPerformed(evt);
            }
        });

        Pepper4.setBackground(new java.awt.Color(187, 187, 240));
        Pepper4.setText("Pepper");
        Pepper4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pepper4ActionPerformed(evt);
            }
        });

        Anise4.setBackground(new java.awt.Color(187, 187, 240));
        Anise4.setText("Anise");
        Anise4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Anise4ActionPerformed(evt);
            }
        });

        Nutmeg4.setBackground(new java.awt.Color(187, 187, 240));
        Nutmeg4.setText("Nutmeg");
        Nutmeg4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nutmeg4ActionPerformed(evt);
            }
        });

        Cinnamon4.setBackground(new java.awt.Color(187, 187, 240));
        Cinnamon4.setText("Cinnamon");
        Cinnamon4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cinnamon4ActionPerformed(evt);
            }
        });

        Clove4.setBackground(new java.awt.Color(187, 187, 240));
        Clove4.setText("Clove");
        Clove4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Clove4ActionPerformed(evt);
            }
        });

        Spices4.setBackground(new java.awt.Color(187, 187, 240));
        Spices4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Spices4.setText("8    Spices");

        Brownspices4.setBackground(new java.awt.Color(187, 187, 240));
        Brownspices4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Brownspices4.setText("Brown Spice");

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Pungent4)
                    .addComponent(Pepper4)
                    .addComponent(Anise4)
                    .addComponent(Nutmeg4)
                    .addComponent(Cinnamon4)
                    .addComponent(Clove4)
                    .addComponent(Spices4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Brownspices4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 14, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addComponent(Spices4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(Pungent4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pepper4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Brownspices4, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(Anise4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Nutmeg4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cinnamon4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Clove4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel49.setBackground(new java.awt.Color(255, 102, 255));

        Peanuts4.setBackground(new java.awt.Color(255, 102, 255));
        Peanuts4.setText("Peanuts");
        Peanuts4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Peanuts4ActionPerformed(evt);
            }
        });

        Hazelenut4.setBackground(new java.awt.Color(255, 102, 255));
        Hazelenut4.setText("Hazelenut");
        Hazelenut4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Hazelenut4ActionPerformed(evt);
            }
        });

        Almond4.setBackground(new java.awt.Color(255, 102, 255));
        Almond4.setText("Almond");
        Almond4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Almond4ActionPerformed(evt);
            }
        });

        Chocolate4.setBackground(new java.awt.Color(255, 102, 255));
        Chocolate4.setText("Chocolate");
        Chocolate4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Chocolate4ActionPerformed(evt);
            }
        });

        DarkChocolate4.setBackground(new java.awt.Color(255, 102, 255));
        DarkChocolate4.setText("Dark Chocolate");
        DarkChocolate4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DarkChocolate4ActionPerformed(evt);
            }
        });

        Nutty4.setBackground(new java.awt.Color(255, 102, 255));
        Nutty4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Nutty4.setText("Nutty");
        Nutty4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nutty4ActionPerformed(evt);
            }
        });

        Nuttycocoa4.setBackground(new java.awt.Color(255, 102, 255));
        Nuttycocoa4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Nuttycocoa4.setText("9 Nutty/Cocoa");

        Cocoa4.setBackground(new java.awt.Color(255, 102, 255));
        Cocoa4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Cocoa4.setText("Cocoa");

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cocoa4)
                    .addComponent(Hazelenut4)
                    .addComponent(Almond4)
                    .addComponent(Peanuts4)
                    .addComponent(DarkChocolate4)
                    .addComponent(Chocolate4)
                    .addComponent(Nutty4)
                    .addComponent(Nuttycocoa4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Nuttycocoa4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Nutty4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Peanuts4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Hazelenut4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Almond4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Cocoa4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Chocolate4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DarkChocolate4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel61.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel87.setText("10   Body ");

        buttonGroup3.add(Thin1);
        Thin1.setText("Thin");

        buttonGroup3.add(Mediumbody1);
        Mediumbody1.setText("Medium");

        buttonGroup3.add(Heavy1);
        Heavy1.setText("Heavy");

        buttonGroup3.add(Syrupy1);
        Syrupy1.setText("Syrupy");

        buttonGroup3.add(Oily1);
        Oily1.setText("Oily");

        buttonGroup3.add(Smooth1);
        Smooth1.setText("Smooth");

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Smooth1)
                    .addComponent(Oily1)
                    .addComponent(Syrupy1)
                    .addComponent(Heavy1)
                    .addComponent(Mediumbody1)
                    .addComponent(Thin1)
                    .addComponent(jLabel87))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel87)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Thin1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Mediumbody1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Heavy1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Syrupy1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Oily1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Smooth1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout FisnishLayout = new javax.swing.GroupLayout(Fisnish);
        Fisnish.setLayout(FisnishLayout);
        FisnishLayout.setHorizontalGroup(
            FisnishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FisnishLayout.createSequentialGroup()
                .addGroup(FisnishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FisnishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FisnishLayout.createSequentialGroup()
                        .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(FisnishLayout.createSequentialGroup()
                        .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(395, 395, 395)
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FisnishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FisnishLayout.createSequentialGroup()
                        .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(325, Short.MAX_VALUE))
        );
        FisnishLayout.setVerticalGroup(
            FisnishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FisnishLayout.createSequentialGroup()
                .addGroup(FisnishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FisnishLayout.createSequentialGroup()
                        .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FisnishLayout.createSequentialGroup()
                        .addGroup(FisnishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel44, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FisnishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(FisnishLayout.createSequentialGroup()
                        .addGroup(FisnishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(164, Short.MAX_VALUE))
        );

        contenedorpaneles.addTab("Aftertaste", Fisnish);

        jPanel50.setBackground(new java.awt.Color(255, 241, 144));

        Vinegar5.setBackground(new java.awt.Color(255, 241, 144));
        Vinegar5.setText("Vinegar(Acetic Acid)");

        Rancidbutter5.setBackground(new java.awt.Color(255, 241, 144));
        Rancidbutter5.setText("Rancid butter(Butyric Acid)");

        RancidCheese5.setBackground(new java.awt.Color(255, 241, 144));
        RancidCheese5.setText("Rancid Cheese(Isovaleric Acid)");

        Winey5.setBackground(new java.awt.Color(255, 241, 144));
        Winey5.setText("Winey");

        Whiskey5.setBackground(new java.awt.Color(255, 241, 144));
        Whiskey5.setText("Whiskey");

        Fermented5.setBackground(new java.awt.Color(255, 241, 144));
        Fermented5.setText("Fermented");

        Overripe5.setBackground(new java.awt.Color(255, 241, 144));
        Overripe5.setText("Over-ripe");

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel75.setText("4 Sour/Fermented");

        jLabel171.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel171.setText("Sour");

        jLabel172.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel172.setText("Alcohol/Fermented");

        OrangeAcidity5.setBackground(new java.awt.Color(255, 241, 144));
        OrangeAcidity5.setText("Orange Acidity(Citric Acid)");

        AppleAcidity5.setBackground(new java.awt.Color(255, 241, 144));
        AppleAcidity5.setText("Apple Acidity (Malic Acid)");

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addComponent(jLabel75)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RancidCheese5)
                            .addComponent(Rancidbutter5)
                            .addComponent(Vinegar5))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel171)
                            .addComponent(jLabel172))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Overripe5)
                            .addComponent(Fermented5)
                            .addComponent(Whiskey5)
                            .addComponent(Winey5)
                            .addComponent(AppleAcidity5)
                            .addComponent(OrangeAcidity5))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addComponent(jLabel75)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel171)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Vinegar5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Rancidbutter5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RancidCheese5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OrangeAcidity5, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AppleAcidity5, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel172, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Winey5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Whiskey5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Fermented5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Overripe5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout AciditypLayout = new javax.swing.GroupLayout(Acidityp);
        Acidityp.setLayout(AciditypLayout);
        AciditypLayout.setHorizontalGroup(
            AciditypLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AciditypLayout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1168, Short.MAX_VALUE))
        );
        AciditypLayout.setVerticalGroup(
            AciditypLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AciditypLayout.createSequentialGroup()
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 320, Short.MAX_VALUE))
        );

        contenedorpaneles.addTab("Acidity", Acidityp);

        jScrollPane1.setViewportView(contenedorpaneles);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel85)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3)
                            .addComponent(jSeparator4)
                            .addComponent(jSeparator5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Aftertasteslider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lessaftertaste, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Aftertaste, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(plusaftertaste, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(90, 90, 90)
                                                .addComponent(jLabel26))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Bodyslider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lessBody, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)
                                        .addComponent(Body, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(plusBody, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel28))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(189, 189, 189)
                                        .addComponent(jLabel30)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(intensidadbody, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(183, 183, 183)
                                        .addComponent(jLabel29)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(intensidadacidity, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Acidityteslider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lessAcidity, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Acidity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(plusAcidity, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel27)))
                                .addContainerGap(112, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(flavorslider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lessflavor, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(flavor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(plusflavor, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jSeparator6)
                        .addGap(2, 2, 2))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(222, 222, 222)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator7)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Balanceslider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lessBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Balance, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(plusBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Catadorslider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lessCatador, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Catador, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(plusCatador, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel6)))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel85))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(flavor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(plusflavor)
                                        .addComponent(lessflavor))
                                    .addComponent(flavorslider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lessaftertaste)
                                        .addComponent(jLabel26)
                                        .addComponent(Aftertaste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(plusaftertaste))
                                    .addComponent(Aftertasteslider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel27)
                                    .addComponent(Acidity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lessAcidity)
                                    .addComponent(plusAcidity)))
                            .addComponent(Acidityteslider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(intensidadacidity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Bodyslider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lessBody)
                                    .addComponent(Body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(plusBody)
                                    .addComponent(jLabel28))
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(intensidadbody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30))
                                .addGap(2, 2, 2)
                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lessBalance)
                                            .addComponent(Balance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(plusBalance)
                                            .addComponent(jLabel7)))
                                    .addComponent(Balanceslider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lessCatador)
                                .addComponent(Catador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(plusCatador)
                                .addComponent(jLabel6))
                            .addComponent(Catadorslider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
DecimalFormat formato = new DecimalFormat("#.#");
    private void jTextField19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19ActionPerformed

    private void jTextField20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20ActionPerformed

    private void jTextField21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField21ActionPerformed

    private void jTextField22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22ActionPerformed

    private void jTextField23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23ActionPerformed
    double flavorv = 0;
    private void flavorsliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_flavorsliderStateChanged
        flavorv = flavorslider.getValue() / 10;
        if (flavorv >= 45.0 && flavorv < 50.0) {
            flavorv = 4.5;
        }
        if (flavorv >= 50.0 && flavorv < 55.0) {
            flavorv = 5.0;
        }
        if (flavorv >= 55.0 && flavorv < 60.0) {
            flavorv = 5.5;
        }
        if (flavorv >= 60.0 && flavorv < 65.0) {
            flavorv = 6.0;
        }
        if (flavorv >= 65.0 && flavorv < 70.0) {
            flavorv = 6.5;
        }
        if (flavorv >= 70.0 && flavorv < 75.0) {
            flavorv = 7.0;
        }
        if (flavorv >= 75.0 && flavorv < 80.0) {
            flavorv = 7.5;
        }
        if (flavorv >= 80.0 && flavorv < 85.0) {
            flavorv = 8.0;
        }
        if (flavorv >= 85.0 && flavorv < 90.0) {
            flavorv = 8.5;
        }
        if (flavorv >= 90.0 && flavorv < 95.0) {
            flavorv = 9.0;
        }
        if (flavorv >= 95.0 && flavorv < 100.0) {
            flavorv = 9.5;
        }
        System.out.println(flavorv);
        flavor.setText(flavorv + "");
        formula();
        paint(4);// TODO add your handling code here:
    }//GEN-LAST:event_flavorsliderStateChanged

    private void plusflavorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusflavorActionPerformed
        flavorslider.setValue(flavorslider.getValue() + 50);
        formula();// TODO add your handling code here:
        paint(4);
    }//GEN-LAST:event_plusflavorActionPerformed

    private void lessflavorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lessflavorActionPerformed
        flavorslider.setValue(flavorslider.getValue() - 50);
        formula();// TODO add your handling code here:
        paint(4);
    }//GEN-LAST:event_lessflavorActionPerformed

    private void lessbreakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lessbreakActionPerformed
        breakslider.setValue(breakslider.getValue() - 50);
        formula();// TODO add your handling code here:
        paint(3);
    }//GEN-LAST:event_lessbreakActionPerformed

    private void lesswetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lesswetActionPerformed
        wetslider.setValue(wetslider.getValue() - 50);
        formula();
        paint(2);
// TODO add your handling code here:
    }//GEN-LAST:event_lesswetActionPerformed

    private void lessdryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lessdryActionPerformed
        dryslider.setValue(dryslider.getValue() - 50);
        formula();// TODO add your handling code here:
        paint(1);
    }//GEN-LAST:event_lessdryActionPerformed

    private void plusbreakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusbreakActionPerformed
        breakslider.setValue(breakslider.getValue() + 50);
        formula();// TODO add your handling code here:
        paint(3);
    }//GEN-LAST:event_plusbreakActionPerformed

    private void pluswetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pluswetActionPerformed
        wetslider.setValue(wetslider.getValue() + 50);
        formula();
        paint(2);
// TODO add you handling code here:
    }//GEN-LAST:event_pluswetActionPerformed

    private void plusdryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusdryActionPerformed
        dryslider.setValue(dryslider.getValue() + 50);
        formula();
        paint(1);
    }//GEN-LAST:event_plusdryActionPerformed
    public void paint(int band) {
        if (band > 0) {
            switch (band) {
                case 1:
                    contenedorpaneles.setSelectedIndex(0);
                    dry.setBackground(Color.BLUE);
                    dry.setForeground(Color.WHITE);
                    contenedorpaneles.setForegroundAt(0, Color.blue);
//Dry.setBackground(Color.BLUE);
                    wet.setBackground(Color.WHITE);
                    wet.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(1, Color.BLACK);
                    breaks.setBackground(Color.WHITE);
                    breaks.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(2, Color.BLACK);
                    flavor.setBackground(Color.WHITE);
                    flavor.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(3, Color.BLACK);
                    Aftertaste.setBackground(Color.WHITE);
                    Aftertaste.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(4, Color.BLACK);
                    Acidity.setBackground(Color.WHITE);
                    Acidity.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(5, Color.BLACK);
                    Body.setBackground(Color.WHITE);
                    Body.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(6, Color.BLACK);
                    break;
                case 2:
                    contenedorpaneles.setSelectedIndex(1);
                    dry.setBackground(Color.WHITE);
                    dry.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(0, Color.BLACK);
                    wet.setBackground(Color.BLUE);
                    wet.setForeground(Color.WHITE);
                    contenedorpaneles.setForegroundAt(1, Color.BLUE);
                    breaks.setBackground(Color.WHITE);
                    breaks.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(2, Color.BLACK);
                    flavor.setBackground(Color.WHITE);
                    flavor.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(3, Color.BLACK);
                    Aftertaste.setBackground(Color.WHITE);
                    Aftertaste.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(4, Color.BLACK);
                    Acidity.setBackground(Color.WHITE);
                    Acidity.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(5, Color.BLACK);
                    Body.setBackground(Color.WHITE);
                    Body.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(6, Color.BLACK);
                    break;
                case 3:
                    contenedorpaneles.setSelectedIndex(2);
                    dry.setBackground(Color.WHITE);
                    dry.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(0, Color.BLACK);
                    wet.setBackground(Color.WHITE);
                    wet.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(1, Color.BLACK);
                    breaks.setBackground(Color.BLUE);
                    breaks.setForeground(Color.WHITE);
                    contenedorpaneles.setForegroundAt(2, Color.BLUE);
                    flavor.setBackground(Color.WHITE);
                    flavor.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(3, Color.BLACK);
                    Aftertaste.setBackground(Color.WHITE);
                    Aftertaste.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(4, Color.BLACK);
                    Acidity.setBackground(Color.WHITE);
                    Acidity.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(5, Color.BLACK);
                    Body.setBackground(Color.WHITE);
                    Body.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(6, Color.BLACK);
                    break;

                case 4:
                    contenedorpaneles.setSelectedIndex(3);
                    dry.setBackground(Color.WHITE);
                    dry.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(0, Color.BLACK);
                    wet.setBackground(Color.WHITE);
                    wet.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(1, Color.BLACK);
                    breaks.setBackground(Color.WHITE);
                    breaks.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(2, Color.BLACK);
                    flavor.setBackground(Color.BLUE);
                    flavor.setForeground(Color.WHITE);
                    contenedorpaneles.setForegroundAt(3, Color.BLUE);
                    Aftertaste.setBackground(Color.WHITE);
                    Aftertaste.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(4, Color.BLACK);
                    Acidity.setBackground(Color.WHITE);
                    Acidity.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(5, Color.BLACK);
                    Body.setBackground(Color.WHITE);
                    Body.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(6, Color.BLACK);
                    break;
                case 5:
                    contenedorpaneles.setSelectedIndex(4);
                    dry.setBackground(Color.WHITE);
                    dry.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(0, Color.BLACK);
                    wet.setBackground(Color.WHITE);
                    wet.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(1, Color.BLACK);
                    breaks.setBackground(Color.WHITE);
                    breaks.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(2, Color.BLACK);
                    flavor.setBackground(Color.WHITE);
                    flavor.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(3, Color.BLACK);
                    Aftertaste.setBackground(Color.BLUE);
                    Aftertaste.setForeground(Color.WHITE);
                    contenedorpaneles.setForegroundAt(4, Color.BLUE);
                    Acidity.setBackground(Color.WHITE);
                    Acidity.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(5, Color.BLACK);
                    Body.setBackground(Color.WHITE);
                    Body.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(6, Color.BLACK);
                    break;
                case 6:
                    contenedorpaneles.setSelectedIndex(5);
                    dry.setBackground(Color.WHITE);
                    dry.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(0, Color.BLACK);
                    wet.setBackground(Color.WHITE);
                    wet.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(1, Color.BLACK);
                    breaks.setBackground(Color.WHITE);
                    breaks.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(2, Color.BLACK);
                    flavor.setBackground(Color.WHITE);
                    flavor.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(3, Color.BLACK);
                    Aftertaste.setBackground(Color.WHITE);
                    Aftertaste.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(4, Color.BLACK);
                    Acidity.setBackground(Color.BLUE);
                    Acidity.setForeground(Color.WHITE);
                    contenedorpaneles.setForegroundAt(5, Color.BLUE);
                    Body.setBackground(Color.WHITE);
                    Body.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(6, Color.BLACK);
                    break;
                case 7:
                    contenedorpaneles.setSelectedIndex(6);
                    dry.setBackground(Color.WHITE);
                    dry.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(0, Color.BLACK);
                    wet.setBackground(Color.WHITE);
                    wet.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(1, Color.BLACK);
                    breaks.setBackground(Color.WHITE);
                    breaks.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(2, Color.BLACK);
                    flavor.setBackground(Color.WHITE);
                    flavor.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(3, Color.BLACK);
                    Aftertaste.setBackground(Color.WHITE);
                    Aftertaste.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(4, Color.BLACK);
                    Acidity.setBackground(Color.WHITE);
                    Acidity.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(5, Color.BLACK);
                    Body.setBackground(Color.BLUE);
                    Body.setForeground(Color.WHITE);
                    contenedorpaneles.setForegroundAt(6, Color.BLUE);
                    break;
                case 8:
                    contenedorpaneles.setSelectedIndex(6);
                    dry.setBackground(Color.WHITE);
                    dry.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(0, Color.BLACK);
                    wet.setBackground(Color.WHITE);
                    wet.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(1, Color.BLACK);
                    breaks.setBackground(Color.WHITE);
                    breaks.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(2, Color.BLACK);
                    flavor.setBackground(Color.WHITE);
                    flavor.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(3, Color.BLACK);
                    Aftertaste.setBackground(Color.WHITE);
                    Aftertaste.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(4, Color.BLACK);
                    Acidity.setBackground(Color.WHITE);
                    Acidity.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(5, Color.BLACK);
                    Body.setBackground(Color.WHITE);
                    Body.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(6, Color.BLACK);
                    break;
            }
        } else {
            band = contenedorpaneles.getSelectedIndex();
            switch (band) {
                case 0:
                    contenedorpaneles.setSelectedIndex(0);
                    dry.setBackground(Color.BLUE);
                    dry.setForeground(Color.WHITE);
                    contenedorpaneles.setForegroundAt(0, Color.blue);
//Dry.setBackground(Color.BLUE);
                    wet.setBackground(Color.WHITE);
                    wet.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(1, Color.BLACK);
                    breaks.setBackground(Color.WHITE);
                    breaks.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(2, Color.BLACK);
                    flavor.setBackground(Color.WHITE);
                    flavor.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(3, Color.BLACK);
                    Aftertaste.setBackground(Color.WHITE);
                    Aftertaste.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(4, Color.BLACK);
                    Acidity.setBackground(Color.WHITE);
                    Acidity.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(5, Color.BLACK);
                    Body.setBackground(Color.WHITE);
                    Body.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(6, Color.BLACK);
                    break;
                case 1:
                    contenedorpaneles.setSelectedIndex(1);
                    dry.setBackground(Color.WHITE);
                    dry.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(0, Color.BLACK);
                    wet.setBackground(Color.BLUE);
                    wet.setForeground(Color.WHITE);
                    contenedorpaneles.setForegroundAt(1, Color.BLUE);
                    breaks.setBackground(Color.WHITE);
                    breaks.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(2, Color.BLACK);
                    flavor.setBackground(Color.WHITE);
                    flavor.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(3, Color.BLACK);
                    Aftertaste.setBackground(Color.WHITE);
                    Aftertaste.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(4, Color.BLACK);
                    Acidity.setBackground(Color.WHITE);
                    Acidity.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(5, Color.BLACK);
                    Body.setBackground(Color.WHITE);
                    Body.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(6, Color.BLACK);
                    break;
                case 2:
                    contenedorpaneles.setSelectedIndex(2);
                    dry.setBackground(Color.WHITE);
                    dry.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(0, Color.BLACK);
                    wet.setBackground(Color.WHITE);
                    wet.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(1, Color.BLACK);
                    breaks.setBackground(Color.BLUE);
                    breaks.setForeground(Color.WHITE);
                    contenedorpaneles.setForegroundAt(2, Color.BLUE);
                    flavor.setBackground(Color.WHITE);
                    flavor.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(3, Color.BLACK);
                    Aftertaste.setBackground(Color.WHITE);
                    Aftertaste.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(4, Color.BLACK);
                    Acidity.setBackground(Color.WHITE);
                    Acidity.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(5, Color.BLACK);
                    Body.setBackground(Color.WHITE);
                    Body.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(6, Color.BLACK);
                    break;

                case 3:
                    contenedorpaneles.setSelectedIndex(3);
                    dry.setBackground(Color.WHITE);
                    dry.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(0, Color.BLACK);
                    wet.setBackground(Color.WHITE);
                    wet.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(1, Color.BLACK);
                    breaks.setBackground(Color.WHITE);
                    breaks.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(2, Color.BLACK);
                    flavor.setBackground(Color.BLUE);
                    flavor.setForeground(Color.WHITE);
                    contenedorpaneles.setForegroundAt(3, Color.BLUE);
                    Aftertaste.setBackground(Color.WHITE);
                    Aftertaste.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(4, Color.BLACK);
                    Acidity.setBackground(Color.WHITE);
                    Acidity.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(5, Color.BLACK);
                    Body.setBackground(Color.WHITE);
                    Body.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(6, Color.BLACK);
                    break;
                case 4:
                    contenedorpaneles.setSelectedIndex(4);
                    dry.setBackground(Color.WHITE);
                    dry.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(0, Color.BLACK);
                    wet.setBackground(Color.WHITE);
                    wet.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(1, Color.BLACK);
                    breaks.setBackground(Color.WHITE);
                    breaks.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(2, Color.BLACK);
                    flavor.setBackground(Color.WHITE);
                    flavor.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(3, Color.BLACK);
                    Aftertaste.setBackground(Color.BLUE);
                    Aftertaste.setForeground(Color.WHITE);
                    contenedorpaneles.setForegroundAt(4, Color.BLUE);
                    Acidity.setBackground(Color.WHITE);
                    Acidity.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(5, Color.BLACK);
                    Body.setBackground(Color.WHITE);
                    Body.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(6, Color.BLACK);
                    break;
                case 5:
                    contenedorpaneles.setSelectedIndex(5);
                    dry.setBackground(Color.WHITE);
                    dry.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(0, Color.BLACK);
                    wet.setBackground(Color.WHITE);
                    wet.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(1, Color.BLACK);
                    breaks.setBackground(Color.WHITE);
                    breaks.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(2, Color.BLACK);
                    flavor.setBackground(Color.WHITE);
                    flavor.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(3, Color.BLACK);
                    Aftertaste.setBackground(Color.WHITE);
                    Aftertaste.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(4, Color.BLACK);
                    Acidity.setBackground(Color.BLUE);
                    Acidity.setForeground(Color.WHITE);
                    contenedorpaneles.setForegroundAt(5, Color.BLUE);
                    Body.setBackground(Color.WHITE);
                    Body.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(6, Color.BLACK);
                    break;
                case 6:
                    contenedorpaneles.setSelectedIndex(6);
                    dry.setBackground(Color.WHITE);
                    dry.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(0, Color.BLACK);
                    wet.setBackground(Color.WHITE);
                    wet.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(1, Color.BLACK);
                    breaks.setBackground(Color.WHITE);
                    breaks.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(2, Color.BLACK);
                    flavor.setBackground(Color.WHITE);
                    flavor.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(3, Color.BLACK);
                    Aftertaste.setBackground(Color.WHITE);
                    Aftertaste.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(4, Color.BLACK);
                    Acidity.setBackground(Color.WHITE);
                    Acidity.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(5, Color.BLACK);
                    Body.setBackground(Color.BLUE);
                    Body.setForeground(Color.WHITE);
                    contenedorpaneles.setForegroundAt(6, Color.BLUE);
                    break;
                case 7:
                    contenedorpaneles.setSelectedIndex(6);
                    dry.setBackground(Color.WHITE);
                    dry.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(0, Color.BLACK);
                    wet.setBackground(Color.WHITE);
                    wet.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(1, Color.BLACK);
                    breaks.setBackground(Color.WHITE);
                    breaks.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(2, Color.BLACK);
                    flavor.setBackground(Color.WHITE);
                    flavor.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(3, Color.BLACK);
                    Aftertaste.setBackground(Color.WHITE);
                    Aftertaste.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(4, Color.BLACK);
                    Acidity.setBackground(Color.WHITE);
                    Acidity.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(5, Color.BLACK);
                    Body.setBackground(Color.WHITE);
                    Body.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(6, Color.BLACK);
                    break;
                case 8:
                    contenedorpaneles.setSelectedIndex(6);
                    dry.setBackground(Color.WHITE);
                    dry.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(0, Color.BLACK);
                    wet.setBackground(Color.WHITE);
                    wet.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(1, Color.BLACK);
                    breaks.setBackground(Color.WHITE);
                    breaks.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(2, Color.BLACK);
                    flavor.setBackground(Color.WHITE);
                    flavor.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(3, Color.BLACK);
                    Aftertaste.setBackground(Color.WHITE);
                    Aftertaste.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(4, Color.BLACK);
                    Acidity.setBackground(Color.WHITE);
                    Acidity.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(5, Color.BLACK);
                    Body.setBackground(Color.WHITE);
                    Body.setForeground(Color.BLACK);
                    contenedorpaneles.setForegroundAt(6, Color.BLACK);
                    break;
            }
        }

    }
    private void breaksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_breaksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_breaksActionPerformed
    double breakv;
    private void breaksliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_breaksliderStateChanged

        breakv = breakslider.getValue() / 10;
        if (breakv >= 45.0 && breakv < 50.0) {
            breakv = 4.5;
        }
        if (breakv >= 50.0 && breakv < 55.0) {
            breakv = 5.0;
        }
        if (breakv >= 55.0 && breakv < 60.0) {
            breakv = 5.5;
        }
        if (breakv >= 60.0 && breakv < 65.0) {
            breakv = 6.0;
        }
        if (breakv >= 65.0 && breakv < 70.0) {
            breakv = 6.5;
        }
        if (breakv >= 70.0 && breakv < 75.0) {
            breakv = 7.0;
        }
        if (breakv >= 75.0 && breakv < 80.0) {
            breakv = 7.5;
        }
        if (breakv >= 80.0 && breakv < 85.0) {
            breakv = 8.0;
        }
        if (breakv >= 85.0 && breakv < 90.0) {
            breakv = 8.5;
        }
        if (breakv >= 90.0 && breakv < 95.0) {
            breakv = 9.0;
        }
        if (breakv >= 95.0 && breakv < 100.0) {
            breakv = 9.5;
        }
        System.out.println(breakv);
        breaks.setText(breakv + "");
        a1 = Double.valueOf(dry.getText());
        a2 = Double.valueOf(breaks.getText());
        a3 = Double.valueOf(wet.getText());
        aromaT = (a1 + a2 + a3) / 3;
        aroma.setText(formato.format(aromaT) + "");
        formula();// TODO add your handling code here:
        paint(3);
    }//GEN-LAST:event_breaksliderStateChanged
    double wetv;
    private void wetsliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_wetsliderStateChanged
        wetv = wetslider.getValue() / 10;
        if (wetv >= 45.0 && wetv < 50.0) {
            wetv = 4.5;
        }
        if (wetv >= 50.0 && wetv < 55.0) {
            wetv = 5.0;
        }
        if (wetv >= 55.0 && wetv < 60.0) {
            wetv = 5.5;
        }
        if (wetv >= 60.0 && wetv < 65.0) {
            wetv = 6.0;
        }
        if (wetv >= 65.0 && wetv < 70.0) {
            wetv = 6.5;
        }
        if (wetv >= 70.0 && wetv < 75.0) {
            wetv = 7.0;
        }
        if (wetv >= 75.0 && wetv < 80.0) {
            wetv = 7.5;
        }
        if (wetv >= 80.0 && wetv < 85.0) {
            wetv = 8.0;
        }
        if (wetv >= 85.0 && wetv < 90.0) {
            wetv = 8.5;
        }
        if (wetv >= 90.0 && wetv < 95.0) {
            wetv = 9.0;
        }
        if (wetv >= 95.0 && wetv < 100.0) {
            wetv = 9.5;
        }
        System.out.println(wetv);
        wet.setText(wetv + "");
        a1 = Double.valueOf(dry.getText());
        a2 = Double.valueOf(breaks.getText());
        a3 = Double.valueOf(wet.getText());
        aromaT = (a1 + a2 + a3) / 3;
        aroma.setText(formato.format(aromaT) + "");
        formula();// TODO add your handling code here:
        paint(2);
    }//GEN-LAST:event_wetsliderStateChanged
    double dryv = 0, aromaT, a1, a2, a3;
    private void drysliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_drysliderStateChanged
        dryv = dryslider.getValue() / 10;
        if (dryv >= 45.0 && dryv < 50.0) {
            dryv = 4.5;
        }
        if (dryv >= 50.0 && dryv < 55.0) {
            dryv = 5.0;
        }
        if (dryv >= 55.0 && dryv < 60.0) {
            dryv = 5.5;
        }
        if (dryv >= 60.0 && dryv < 65.0) {
            dryv = 6.0;
        }
        if (dryv >= 65.0 && dryv < 70.0) {
            dryv = 6.5;
        }
        if (dryv >= 70.0 && dryv < 75.0) {
            dryv = 7.0;
        }
        if (dryv >= 75.0 && dryv < 80.0) {
            dryv = 7.5;
        }
        if (dryv >= 80.0 && dryv < 85.0) {
            dryv = 8.0;
        }
        if (dryv >= 85.0 && dryv < 90.0) {
            dryv = 8.5;
        }
        if (dryv >= 90.0 && dryv < 95.0) {
            dryv = 9.0;
        }
        if (dryv >= 95.0 && dryv < 100.0) {
            dryv = 9.5;
        }
        System.out.println(dryv);
        dry.setText(dryv + "");

        a1 = dryv;
        a2 = Double.valueOf(breaks.getText());
        a3 = Double.valueOf(wet.getText());
        aromaT = (a1 + a2 + a3) / 3;
        aroma.setText(formato.format(aromaT) + "");
        formula();
        paint(1);
// TODO add your handling code here:
    }//GEN-LAST:event_drysliderStateChanged

    private void lessaftertasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lessaftertasteActionPerformed
        Aftertasteslider.setValue(Aftertasteslider.getValue() - 50);
        formula();
        paint(5);
    }//GEN-LAST:event_lessaftertasteActionPerformed

    private void lessAcidityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lessAcidityActionPerformed
        Acidityteslider.setValue(Acidityteslider.getValue() - 50);
        formula();
        paint(6);
    }//GEN-LAST:event_lessAcidityActionPerformed

    private void plusaftertasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusaftertasteActionPerformed
        Aftertasteslider.setValue(Aftertasteslider.getValue() + 50);
        formula();
        paint(5);
    }//GEN-LAST:event_plusaftertasteActionPerformed

    private void plusAcidityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusAcidityActionPerformed
        Acidityteslider.setValue(Acidityteslider.getValue() + 50);
        formula();
        paint(6);
    }//GEN-LAST:event_plusAcidityActionPerformed
    double Aftertastev = 0;
    private void AftertastesliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_AftertastesliderStateChanged
        Aftertastev = Aftertasteslider.getValue() / 10;
        if (Aftertastev >= 45.0 && Aftertastev < 50.0) {
            Aftertastev = 4.5;
        }
        if (Aftertastev >= 50.0 && Aftertastev < 55.0) {
            Aftertastev = 5.0;
        }
        if (Aftertastev >= 55.0 && Aftertastev < 60.0) {
            Aftertastev = 5.5;
        }
        if (Aftertastev >= 60.0 && Aftertastev < 65.0) {
            Aftertastev = 6.0;
        }
        if (Aftertastev >= 65.0 && Aftertastev < 70.0) {
            Aftertastev = 6.5;
        }
        if (Aftertastev >= 70.0 && Aftertastev < 75.0) {
            Aftertastev = 7.0;
        }
        if (Aftertastev >= 75.0 && Aftertastev < 80.0) {
            Aftertastev = 7.5;
        }
        if (Aftertastev >= 80.0 && Aftertastev < 85.0) {
            Aftertastev = 8.0;
        }
        if (Aftertastev >= 85.0 && Aftertastev < 90.0) {
            Aftertastev = 8.5;
        }
        if (Aftertastev >= 90.0 && Aftertastev < 95.0) {
            Aftertastev = 9.0;
        }
        if (Aftertastev >= 95.0 && Aftertastev < 100.0) {
            Aftertastev = 9.5;
        }
        System.out.println(Aftertastev);
        Aftertaste.setText(Aftertastev + "");
        formula();// TODO add your handling code here:
        paint(5);
    }//GEN-LAST:event_AftertastesliderStateChanged
    double Acidityv = 0;
    private void AciditytesliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_AciditytesliderStateChanged
        Acidityv = Acidityteslider.getValue() / 10;
        if (Acidityv >= 45.0 && Acidityv < 50.0) {
            Acidityv = 4.5;
        }
        if (Acidityv >= 50.0 && Acidityv < 55.0) {
            Acidityv = 5.0;
        }
        if (Acidityv >= 55.0 && Acidityv < 60.0) {
            Acidityv = 5.5;
        }
        if (Acidityv >= 60.0 && Acidityv < 65.0) {
            Acidityv = 6.0;
        }
        if (Acidityv >= 65.0 && Acidityv < 70.0) {
            Acidityv = 6.5;
        }
        if (Acidityv >= 70.0 && Acidityv < 75.0) {
            Acidityv = 7.0;
        }
        if (Acidityv >= 75.0 && Acidityv < 80.0) {
            Acidityv = 7.5;
        }
        if (Acidityv >= 80.0 && Acidityv < 85.0) {
            Acidityv = 8.0;
        }
        if (Acidityv >= 85.0 && Acidityv < 90.0) {
            Acidityv = 8.5;
        }
        if (Acidityv >= 90.0 && Acidityv < 95.0) {
            Acidityv = 9.0;
        }
        if (Acidityv >= 95.0 && Acidityv < 100.0) {
            Acidityv = 9.5;
        }
        System.out.println(Acidityv);
        Acidity.setText(Acidityv + "");
        formula();// TODO add your handling code here:
        paint(6);
    }//GEN-LAST:event_AciditytesliderStateChanged

    private void plusBodyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusBodyActionPerformed
        Bodyslider.setValue(Bodyslider.getValue() + 50);
        formula();// TODO add your handling code here:
        paint(7);
    }//GEN-LAST:event_plusBodyActionPerformed

    private void lessBodyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lessBodyActionPerformed
        Bodyslider.setValue(Bodyslider.getValue() - 50);
        formula();// TODO add your handling code here:
        paint(7);
    }//GEN-LAST:event_lessBodyActionPerformed
    double Bodyv = 0;
    private void BodysliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_BodysliderStateChanged
        Bodyv = Bodyslider.getValue() / 10;
        if (Bodyv >= 45.0 && Bodyv < 50.0) {
            Bodyv = 4.5;
        }
        if (Bodyv >= 50.0 && Bodyv < 55.0) {
            Bodyv = 5.0;
        }
        if (Bodyv >= 55.0 && Bodyv < 60.0) {
            Bodyv = 5.5;
        }
        if (Bodyv >= 60.0 && Bodyv < 65.0) {
            Bodyv = 6.0;
        }
        if (Bodyv >= 65.0 && Bodyv < 70.0) {
            Bodyv = 6.5;
        }
        if (Bodyv >= 70.0 && Bodyv < 75.0) {
            Bodyv = 7.0;
        }
        if (Bodyv >= 75.0 && Bodyv < 80.0) {
            Bodyv = 7.5;
        }
        if (Bodyv >= 80.0 && Bodyv < 85.0) {
            Bodyv = 8.0;
        }
        if (Bodyv >= 85.0 && Bodyv < 90.0) {
            Bodyv = 8.5;
        }
        if (Bodyv >= 90.0 && Bodyv < 95.0) {
            Bodyv = 9.0;
        }
        if (Bodyv >= 95.0 && Bodyv < 100.0) {
            Bodyv = 9.5;
        }
        System.out.println(Bodyv);
        Body.setText(Bodyv + "");
        formula();// TODO add your handling code here:
        paint(7);
    }//GEN-LAST:event_BodysliderStateChanged

    private void lessBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lessBalanceActionPerformed
        Balanceslider.setValue(Balanceslider.getValue() - 50);
        formula();
        paint(8);
// TODO add your handling code here:
    }//GEN-LAST:event_lessBalanceActionPerformed

    private void lessCatadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lessCatadorActionPerformed
        Catadorslider.setValue(Catadorslider.getValue() - 50);
        formula();
        paint(8);
    }//GEN-LAST:event_lessCatadorActionPerformed
    public void formula() {
        double total, a = Double.valueOf(aroma.getText()), b = Double.valueOf(flavor.getText()), c = Double.valueOf(Aftertaste.getText()), d = Double.valueOf(Acidity.getText()), e = Double.valueOf(Body.getText()), f = Double.valueOf(Balance.getText()), g = Double.valueOf(Tazas.getText()), h = Double.valueOf(uniformtaza.getText()), i = Double.valueOf(tazalimpia.getText()), j = Double.valueOf(dulzor.getText()), k = Double.valueOf(Catador.getText()), l = Double.valueOf(Defectos.getText());
        total = a + b + c + d + e + f + ((10 / g) * h) + ((10 / g) * i) + ((10 / g) * j) + k - l;
        Puntuacion.setText(formato.format(total) + "");
    }
    private void plusBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusBalanceActionPerformed
        Balanceslider.setValue(Balanceslider.getValue() + 50);
        formula();// TODO add your handling code here:
        paint(8);
    }//GEN-LAST:event_plusBalanceActionPerformed

    private void plusCatadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusCatadorActionPerformed
        Catadorslider.setValue(Catadorslider.getValue() + 50);
        formula();// TODO add your handling code here:
        paint(8);
    }//GEN-LAST:event_plusCatadorActionPerformed
    double Catadorv = 0;
    private void CatadorsliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_CatadorsliderStateChanged
        Catadorv = Catadorslider.getValue() / 10;
        if (Catadorv >= 45.0 && Catadorv < 50.0) {
            Catadorv = 4.5;
        }
        if (Catadorv >= 50.0 && Catadorv < 55.0) {
            Catadorv = 5.0;
        }
        if (Catadorv >= 55.0 && Catadorv < 60.0) {
            Catadorv = 5.5;
        }
        if (Catadorv >= 60.0 && Catadorv < 65.0) {
            Catadorv = 6.0;
        }
        if (Catadorv >= 65.0 && Catadorv < 70.0) {
            Catadorv = 6.5;
        }
        if (Catadorv >= 70.0 && Catadorv < 75.0) {
            Catadorv = 7.0;
        }
        if (Catadorv >= 75.0 && Catadorv < 80.0) {
            Catadorv = 7.5;
        }
        if (Catadorv >= 80.0 && Catadorv < 85.0) {
            Catadorv = 8.0;
        }
        if (Catadorv >= 85.0 && Catadorv < 90.0) {
            Catadorv = 8.5;
        }
        if (Catadorv >= 90.0 && Catadorv < 95.0) {
            Catadorv = 9.0;
        }
        if (Catadorv >= 95.0 && Catadorv < 100.0) {
            Catadorv = 9.5;
        }
        System.out.println(Catadorv);
        Catador.setText(Catadorv + "");
        formula();// TODO add your handling code here:
        paint(8);
    }//GEN-LAST:event_CatadorsliderStateChanged
    double Balancev = 0;
    private void BalancesliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_BalancesliderStateChanged
        Balancev = Balanceslider.getValue() / 10;
        if (Balancev >= 45.0 && Balancev < 50.0) {
            Balancev = 4.5;
        }
        if (Balancev >= 50.0 && Balancev < 55.0) {
            Balancev = 5.0;
        }
        if (Balancev >= 55.0 && Balancev < 60.0) {
            Balancev = 5.5;
        }
        if (Balancev >= 60.0 && Balancev < 65.0) {
            Balancev = 6.0;
        }
        if (Balancev >= 65.0 && Balancev < 70.0) {
            Balancev = 6.5;
        }
        if (Balancev >= 70.0 && Balancev < 75.0) {
            Balancev = 7.0;
        }
        if (Balancev >= 75.0 && Balancev < 80.0) {
            Balancev = 7.5;
        }
        if (Balancev >= 80.0 && Balancev < 85.0) {
            Balancev = 8.0;
        }
        if (Balancev >= 85.0 && Balancev < 90.0) {
            Balancev = 8.5;
        }
        if (Balancev >= 90.0 && Balancev < 95.0) {
            Balancev = 9.0;
        }
        if (Balancev >= 95.0 && Balancev < 100.0) {
            Balancev = 9.5;
        }
        System.out.println(Balancev);
        Balance.setText(Balancev + "");
        formula();// TODO add your handling code here:
        paint(8);
    }//GEN-LAST:event_BalancesliderStateChanged

    private void numtazasdefectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numtazasdefectosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numtazasdefectosActionPerformed
    int l1, l2, totalD;
    private void numtazasdefectosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numtazasdefectosKeyTyped
        char m = evt.getKeyChar();
        if (Character.isAlphabetic(m)) {
            getToolkit().beep();
            evt.consume();
        }    // TODO add your handling code here:
    }//GEN-LAST:event_numtazasdefectosKeyTyped

    private void intensidadefectosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_intensidadefectosKeyTyped
        char m = evt.getKeyChar();
        if (Character.isAlphabetic(m)) {
            getToolkit().beep();
            evt.consume();
        }    // TODO add your handling code here:
    }//GEN-LAST:event_intensidadefectosKeyTyped

    private void uniformtazaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uniformtazaKeyTyped
        char m = evt.getKeyChar();
        if (Character.isAlphabetic(m)) {
            getToolkit().beep();
            evt.consume();
        }      // TODO add your handling code here:
    }//GEN-LAST:event_uniformtazaKeyTyped

    private void tazalimpiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tazalimpiaKeyTyped
        char m = evt.getKeyChar();
        if (Character.isAlphabetic(m)) {
            getToolkit().beep();
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tazalimpiaKeyTyped

    private void dulzorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dulzorKeyTyped
        char m = evt.getKeyChar();
        if (Character.isAlphabetic(m)) {
            getToolkit().beep();
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_dulzorKeyTyped

    private void TazasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TazasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_TazasKeyTyped

    private void numtazasdefectosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numtazasdefectosKeyReleased
        l1 = Integer.parseInt(numtazasdefectos.getText());
        l2 = Integer.parseInt(intensidadefectos.getText());
        totalD = l1 * l2;
        Defectos.setText(formato.format(totalD) + "");        // TODO add your handling code here:
    }//GEN-LAST:event_numtazasdefectosKeyReleased

    private void intensidadefectosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_intensidadefectosKeyReleased
        l1 = Integer.parseInt(numtazasdefectos.getText());
        l2 = Integer.parseInt(intensidadefectos.getText());
        totalD = l1 * l2;
        Defectos.setText(formato.format(totalD) + "");        // TODO add your handling code here:
    }//GEN-LAST:event_intensidadefectosKeyReleased

    private void TazasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TazasFocusGained
        if (Tazas.getText().equals("0")) {
            Tazas.setText("");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_TazasFocusGained

    private void TazasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TazasFocusLost
        if (Tazas.getText().equals("")) {
            Tazas.setText("0");
        }      // TODO add your handling code here:
    }//GEN-LAST:event_TazasFocusLost

    private void numtazasdefectosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numtazasdefectosFocusGained
        if (numtazasdefectos.getText().equals("0")) {
            numtazasdefectos.setText("");
        }         // TODO add your handling code here:
    }//GEN-LAST:event_numtazasdefectosFocusGained

    private void numtazasdefectosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numtazasdefectosFocusLost
        if (numtazasdefectos.getText().equals("")) {
            numtazasdefectos.setText("0");
        }         // TODO add your handling code here:
    }//GEN-LAST:event_numtazasdefectosFocusLost

    private void intensidadefectosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_intensidadefectosFocusGained
        if (intensidadefectos.getText().equals("0")) {
            intensidadefectos.setText("");
        }         // TODO add your handling code here:
    }//GEN-LAST:event_intensidadefectosFocusGained

    private void intensidadefectosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_intensidadefectosFocusLost
        if (intensidadefectos.getText().equals("")) {
            intensidadefectos.setText("0");
        }          // TODO add your handling code here:
    }//GEN-LAST:event_intensidadefectosFocusLost

    private void uniformtazaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_uniformtazaFocusGained
        if (uniformtaza.getText().equals("0")) {
            uniformtaza.setText("");
        }     // TODO add your handling code here:
    }//GEN-LAST:event_uniformtazaFocusGained

    private void uniformtazaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_uniformtazaFocusLost
        if (uniformtaza.getText().equals("")) {
            uniformtaza.setText("0");
        }            // TODO add your handling code here:
    }//GEN-LAST:event_uniformtazaFocusLost

    private void tazalimpiaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tazalimpiaFocusGained
        if (tazalimpia.getText().equals("0")) {
            tazalimpia.setText("");
        }            // TODO add your handling code here:
    }//GEN-LAST:event_tazalimpiaFocusGained

    private void tazalimpiaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tazalimpiaFocusLost
        if (tazalimpia.getText().equals("")) {
            tazalimpia.setText("0");
        }         // TODO add your handling code here:
    }//GEN-LAST:event_tazalimpiaFocusLost

    private void dulzorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dulzorFocusGained
        if (dulzor.getText().equals("0")) {
            dulzor.setText("");
        }         // TODO add your handling code here:
    }//GEN-LAST:event_dulzorFocusGained

    private void dulzorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dulzorFocusLost
        if (dulzor.getText().equals("")) {
            dulzor.setText("0");
        }         // TODO add your handling code here:
    }//GEN-LAST:event_dulzorFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        guardar();       // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    private void MoldyDamp4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoldyDamp4ActionPerformed
        ////validbuton(MoldyDamp4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_MoldyDamp4ActionPerformed

    private void uniformtazaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uniformtazaKeyReleased
        formula();
        // TODO add your handling code here:
    }//GEN-LAST:event_uniformtazaKeyReleased

    private void tazalimpiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tazalimpiaKeyReleased
        formula();        // TODO add your handling code here:
    }//GEN-LAST:event_tazalimpiaKeyReleased

    private void dulzorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dulzorKeyReleased
        formula();        // TODO add your handling code here:
    }//GEN-LAST:event_dulzorKeyReleased

    private void TazasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TazasKeyReleased
        formula();        // TODO add your handling code here:
    }//GEN-LAST:event_TazasKeyReleased

    private void DryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DryMouseClicked
        paint(0); // TODO add your handling code here:
    }//GEN-LAST:event_DryMouseClicked

    private void contenedorpanelesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contenedorpanelesMouseClicked
        paint(0);    // TODO add your handling code here:
        jPanel41.setEnabled(false);
    }//GEN-LAST:event_contenedorpanelesMouseClicked

    private void BalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BalanceActionPerformed

    int p1 = 0, p2 = 0, p3 = 0, p4 = 0, p5 = 0, p6 = 0, p7 = 0, p8 = 0, p9 = 0;

    public void validbuton(javax.swing.JRadioButton name, int I) {
        switch (I) {
            case 1:
                if (name.isSelected()) {
                    if (p1 >= 5) {
                        JOptionPane.showMessageDialog(null, "¡Solo se pueden seleccionar 5 sabores!");
                        name.setSelected(false);
                    } else {
                        p1++;
                    }
                } else {
                    p1--;
                }
                break;
            case 2:
                if (name.isSelected()) {
                    if (p2 >= 5) {
                        JOptionPane.showMessageDialog(null, "¡Solo se pueden seleccionar 5 sabores!");
                        name.setSelected(false);
                    } else {
                        p2++;
                    }
                } else {
                    p2--;
                }
                break;
            case 3:
                if (name.isSelected()) {
                    if (p3 >= 5) {
                        JOptionPane.showMessageDialog(null, "¡Solo se pueden seleccionar 5 sabores!");
                        name.setSelected(false);
                    } else {
                        p3++;
                    }
                } else {
                    p3--;
                }
                break;

            case 4:
                if (name.isSelected()) {
                    if (p4 >= 5) {
                        JOptionPane.showMessageDialog(null, "¡Solo se pueden seleccionar 5 sabores!");
                        name.setSelected(false);
                    } else {
                        p4++;
                    }
                } else {
                    p4--;
                }
                break;
            case 5:
                if (name.isSelected()) {
                    if (p5 >= 5) {
                        JOptionPane.showMessageDialog(null, "¡Solo se pueden seleccionar 5 sabores!");
                        name.setSelected(false);
                    } else {
                        p5++;
                    }
                } else {
                    p5--;
                }
                break;
            case 6:
                if (name.isSelected()) {
                    if (p6 >= 5) {
                        JOptionPane.showMessageDialog(null, "¡Solo se pueden seleccionar 5 sabores!");
                        name.setSelected(false);
                    } else {
                        p6++;
                    }
                } else {
                    p6--;
                }
                break;
            case 7:
                if (name.isSelected()) {
                    p7++;
                } else {
                    p7--;
                }
                break;

            case 8:
                if (name.isSelected()) {
                    p8++;
                } else {
                    p8--;
                }
                break;

            case 9:
                if (name.isSelected()) {
                    p9++;
                } else {
                    p9--;
                }
                break;
        }
    }
    private void MolassesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_MolassesItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_MolassesItemStateChanged

    private void MapleSugarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_MapleSugarItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_MapleSugarItemStateChanged

    private void CarmelizedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CarmelizedItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_CarmelizedItemStateChanged

    private void HoneyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_HoneyItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_HoneyItemStateChanged

    private void VanillaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_VanillaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_VanillaItemStateChanged

    private void Stale4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Stale4ActionPerformed
        //validbuton(Stale4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Stale4ActionPerformed

    private void Cardboard4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cardboard4ActionPerformed
        //validbuton(Cardboard4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Cardboard4ActionPerformed

    private void Papery4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Papery4ActionPerformed
        //validbuton(Papery4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Papery4ActionPerformed

    private void Woody4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Woody4ActionPerformed
        //validbuton(Woody4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Woody4ActionPerformed

    private void MustyDusty4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MustyDusty4ActionPerformed
        //validbuton(MustyDusty4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_MustyDusty4ActionPerformed

    private void MustyEarthy4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MustyEarthy4ActionPerformed
        //validbuton(MustyEarthy4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_MustyEarthy4ActionPerformed

    private void Animalic4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Animalic4ActionPerformed
        //validbuton(Animalic4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Animalic4ActionPerformed

    private void MeatyBrothy4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MeatyBrothy4ActionPerformed
        //validbuton(MeatyBrothy4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_MeatyBrothy4ActionPerformed

    private void Phenolic4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Phenolic4ActionPerformed
        //validbuton(Phenolic4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Phenolic4ActionPerformed

    private void Bitter4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bitter4ActionPerformed
        //validbuton(Bitter4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Bitter4ActionPerformed

    private void Salty4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Salty4ActionPerformed
        //validbuton(Salty4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Salty4ActionPerformed

    private void Medicinal4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Medicinal4ActionPerformed
        //validbuton(Medicinal4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Medicinal4ActionPerformed

    private void Petroleum4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Petroleum4ActionPerformed
        //validbuton(Petroleum4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Petroleum4ActionPerformed

    private void Skunky4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Skunky4ActionPerformed
        //validbuton(Skunky4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Skunky4ActionPerformed

    private void Rubber4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rubber4ActionPerformed
        //validbuton(Rubber4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Rubber4ActionPerformed

    private void PipeTobacco4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PipeTobacco4ActionPerformed
        //validbuton(PipeTobacco4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_PipeTobacco4ActionPerformed

    private void Tobacco4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tobacco4ActionPerformed
        //validbuton(Tobacco4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Tobacco4ActionPerformed

    private void Acrid4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Acrid4ActionPerformed
        //validbuton(Acrid4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Acrid4ActionPerformed

    private void Ashy4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ashy4ActionPerformed
        //validbuton(Ashy4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Ashy4ActionPerformed

    private void Smoky4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Smoky4ActionPerformed
        //validbuton(Smoky4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Smoky4ActionPerformed

    private void BrownRoast4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrownRoast4ActionPerformed
        //validbuton(BrownRoast4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_BrownRoast4ActionPerformed

    private void Grain4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Grain4ActionPerformed
        //validbuton(Grain4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Grain4ActionPerformed

    private void Malt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Malt4ActionPerformed
        //validbuton(Malt4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Malt4ActionPerformed

    private void Pungent4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pungent4ActionPerformed
        //validbuton(Pungent4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Pungent4ActionPerformed

    private void Pepper4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pepper4ActionPerformed
        //validbuton(Pepper4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Pepper4ActionPerformed

    private void Anise4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Anise4ActionPerformed
        //validbuton(Anise4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Anise4ActionPerformed

    private void Nutmeg4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nutmeg4ActionPerformed
        //validbuton(Nutmeg4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Nutmeg4ActionPerformed

    private void Cinnamon4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cinnamon4ActionPerformed
        //validbuton(Cinnamon4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Cinnamon4ActionPerformed

    private void Clove4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clove4ActionPerformed
        //validbuton(Clove4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Clove4ActionPerformed

    private void Nutty4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nutty4ActionPerformed
        //validbuton(Nutty4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Nutty4ActionPerformed

    private void Peanuts4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Peanuts4ActionPerformed
        //validbuton(Peanuts4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Peanuts4ActionPerformed

    private void Hazelenut4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Hazelenut4ActionPerformed
        //validbuton(Hazelenut4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Hazelenut4ActionPerformed

    private void Almond4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Almond4ActionPerformed
        //validbuton(Almond4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Almond4ActionPerformed

    private void Chocolate4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Chocolate4ActionPerformed
        //validbuton(Chocolate4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_Chocolate4ActionPerformed

    private void DarkChocolate4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DarkChocolate4ActionPerformed
        //validbuton(DarkChocolate4,5);         // TODO add your handling code here:
    }//GEN-LAST:event_DarkChocolate4ActionPerformed

    private void quakersFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quakersFocusGained
        if (quakers.getText().equals("0")) {
            quakers.setText("");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_quakersFocusGained

    private void quakersFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quakersFocusLost
        if (quakers.getText().equals("")) {
            quakers.setText("0");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_quakersFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        this.dispose();            // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void FruityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FruityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FruityActionPerformed

    private void sourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sourMouseClicked
        // TODO add your handling code here:
        intensidadSabor(sour);
        intensidadAcFm(sour);
    }//GEN-LAST:event_sourMouseClicked

    private void VinegarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VinegarMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Vinegar);
        intensidadAcFm(Vinegar);
    }//GEN-LAST:event_VinegarMouseClicked

    private void BrownSugarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BrownSugarMouseClicked
        // TODO add your handling code here:
        intensidadSabor(BrownSugar);
        intensidadSweet(BrownSugar);
    }//GEN-LAST:event_BrownSugarMouseClicked

    private void BerryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BerryMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Berry);
        intensidadFrutal(Berry);
    }//GEN-LAST:event_BerryMouseClicked

    private void BlackteaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BlackteaMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Blacktea);
        intensidadFloral(Blacktea);
    }//GEN-LAST:event_BlackteaMouseClicked

    private void OliveOilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OliveOilMouseClicked
        // TODO add your handling code here:
        intensidadSabor(OliveOil);
        intensidadVV(OliveOil);
    }//GEN-LAST:event_OliveOilMouseClicked
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       
        if(Vinegar.getBackground() == new Color(255,0,0))
            
            JOptionPane.showMessageDialog(null,"es igual");
        else
            JOptionPane.showMessageDialog(null,"no es igual");
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void MolassesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MolassesMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Molasses);
        intensidadSweet(Molasses);
    }//GEN-LAST:event_MolassesMouseClicked

    private void VanillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VanillaMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Vanilla);
        intensidadSweet(Vanilla);
    }//GEN-LAST:event_VanillaMouseClicked

    private void JasmineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JasmineMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Jasmine);
        intensidadFloral(Jasmine);
    }//GEN-LAST:event_JasmineMouseClicked

    private void ChamomileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChamomileMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Chamomile);
        intensidadFloral(Chamomile);
    }//GEN-LAST:event_ChamomileMouseClicked

    private void RoseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RoseMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Rose);
        intensidadFloral(Rose);
    }//GEN-LAST:event_RoseMouseClicked

    private void MapleSugarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MapleSugarMouseClicked
        // TODO add your handling code here:
        intensidadSabor(MapleSugar);
        intensidadSweet(MapleSugar);
    }//GEN-LAST:event_MapleSugarMouseClicked

    private void CarmelizedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarmelizedMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Carmelized);
        intensidadSweet(Carmelized);
    }//GEN-LAST:event_CarmelizedMouseClicked

    private void HoneyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HoneyMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Honey);
        intensidadSweet(Honey);
    }//GEN-LAST:event_HoneyMouseClicked

    private void BlackberryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BlackberryMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Blackberry);
        intensidadFrutal(Blackberry);
    }//GEN-LAST:event_BlackberryMouseClicked

    private void RaspberryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RaspberryMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Raspberry);
        intensidadFrutal(Raspberry);
    }//GEN-LAST:event_RaspberryMouseClicked

    private void BlueberryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BlueberryMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Blueberry);
        intensidadFrutal(Blueberry);
    }//GEN-LAST:event_BlueberryMouseClicked

    private void StrawberryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StrawberryMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Strawberry);
        intensidadFrutal(Strawberry);
    }//GEN-LAST:event_StrawberryMouseClicked

    private void DriedFruitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DriedFruitMouseClicked
        // TODO add your handling code here:
        intensidadSabor(DriedFruit);
        intensidadFrutal(DriedFruit);
    }//GEN-LAST:event_DriedFruitMouseClicked

    private void RaisenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RaisenMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Raisen);
        intensidadFrutal(Raisen);
    }//GEN-LAST:event_RaisenMouseClicked

    private void PruneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PruneMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Prune);
        intensidadFrutal(Prune);
    }//GEN-LAST:event_PruneMouseClicked

    private void OtherfruitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OtherfruitMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Otherfruit);
        intensidadFrutal(Otherfruit);
    }//GEN-LAST:event_OtherfruitMouseClicked

    private void CoconutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CoconutMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Coconut);
        intensidadFrutal(Coconut);
    }//GEN-LAST:event_CoconutMouseClicked

    private void CherryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CherryMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Cherry);
        intensidadFrutal(Cherry);
    }//GEN-LAST:event_CherryMouseClicked

    private void PomagraniteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PomagraniteMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Pomagranite);
        intensidadFrutal(Pomagranite);
    }//GEN-LAST:event_PomagraniteMouseClicked

    private void PinneappleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PinneappleMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Pinneapple);
        intensidadFrutal(Pinneapple);
    }//GEN-LAST:event_PinneappleMouseClicked

    private void GrapeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrapeMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Grape);
        intensidadFrutal(Grape);
    }//GEN-LAST:event_GrapeMouseClicked

    private void AppleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AppleMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Apple);
        intensidadFrutal(Apple);
    }//GEN-LAST:event_AppleMouseClicked

    private void PeachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PeachMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Peach);
        intensidadFrutal(Peach);
    }//GEN-LAST:event_PeachMouseClicked

    private void PearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PearMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Pear);
        intensidadFrutal(Pear);
    }//GEN-LAST:event_PearMouseClicked

    private void CitrusfruitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CitrusfruitMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Citrusfruit);
        intensidadFrutal(Citrusfruit);
    }//GEN-LAST:event_CitrusfruitMouseClicked

    private void GrapefruitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrapefruitMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Grapefruit);
        intensidadFrutal(Grapefruit);
    }//GEN-LAST:event_GrapefruitMouseClicked

    private void OrangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrangeMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Orange);
        intensidadFrutal(Orange);
    }//GEN-LAST:event_OrangeMouseClicked

    private void LemonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LemonMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Lemon);
        intensidadFrutal(Lemon);
    }//GEN-LAST:event_LemonMouseClicked

    private void LimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LimeMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Lime);
        intensidadFrutal(Lime);
    }//GEN-LAST:event_LimeMouseClicked

    private void RancidbutterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RancidbutterMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Rancidbutter);
        intensidadAcFm(sour);
    }//GEN-LAST:event_RancidbutterMouseClicked

    private void RancidCheeseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RancidCheeseMouseClicked
        // TODO add your handling code here:
        intensidadSabor(RancidCheese);
        intensidadAcFm(RancidCheese);
    }//GEN-LAST:event_RancidCheeseMouseClicked

    private void OrangeAcidityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrangeAcidityMouseClicked
        // TODO add your handling code here:
        intensidadSabor(OrangeAcidity);
        intensidadAcFm(OrangeAcidity);
    }//GEN-LAST:event_OrangeAcidityMouseClicked

    private void AppleAcidityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AppleAcidityMouseClicked
        // TODO add your handling code here:
        intensidadSabor(AppleAcidity);
        intensidadAcFm(AppleAcidity);
    }//GEN-LAST:event_AppleAcidityMouseClicked

    private void AlcoholMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AlcoholMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_AlcoholMouseEntered

    private void AlcoholMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AlcoholMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Alcohol);
        intensidadAcFm(Alcohol);
    }//GEN-LAST:event_AlcoholMouseClicked

    private void WineyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WineyMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Winey);
        intensidadAcFm(Winey);
    }//GEN-LAST:event_WineyMouseClicked

    private void WhiskeyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WhiskeyMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Whiskey);
        intensidadAcFm(Whiskey);
    }//GEN-LAST:event_WhiskeyMouseClicked

    private void FermentedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FermentedMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Fermented);
        intensidadAcFm(Fermented);
    }//GEN-LAST:event_FermentedMouseClicked

    private void OverripeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OverripeMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Overripe);
        intensidadAcFm(Overripe);
    }//GEN-LAST:event_OverripeMouseClicked

    private void RawMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RawMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Raw);
        intensidadVV(Raw);
    }//GEN-LAST:event_RawMouseClicked

    private void BeanyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BeanyMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Beany);
        intensidadVV(Beany);
    }//GEN-LAST:event_BeanyMouseClicked

    private void UnderripeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UnderripeMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Underripe);
        intensidadVV(Underripe);
    }//GEN-LAST:event_UnderripeMouseClicked

    private void PeapodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PeapodMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Peapod);
        intensidadVV(Peapod);
    }//GEN-LAST:event_PeapodMouseClicked

    private void FreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FreshMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Fresh);
        intensidadVV(Fresh);
    }//GEN-LAST:event_FreshMouseClicked

    private void DarkGreenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DarkGreenMouseClicked
        // TODO add your handling code here:
        intensidadSabor(DarkGreen);
        intensidadVV(DarkGreen);
    }//GEN-LAST:event_DarkGreenMouseClicked

    private void VegetativeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VegetativeMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Vegetative);
        intensidadVV(Vegetative);
    }//GEN-LAST:event_VegetativeMouseClicked

    private void HaylikeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HaylikeMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Haylike);
        intensidadVV(Haylike);
    }//GEN-LAST:event_HaylikeMouseClicked

    private void HerblikeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HerblikeMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Herblike);
        intensidadVV(Herblike);
    }//GEN-LAST:event_HerblikeMouseClicked

    private void PaperyMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaperyMMouseClicked
        // TODO add your handling code here:
        intensidadSabor(PaperyM);
        intensidadOtros(PaperyM);
    }//GEN-LAST:event_PaperyMMouseClicked

    private void StaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StaleMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Stale);
        intensidadOtros(Stale);
    }//GEN-LAST:event_StaleMouseClicked

    private void CardboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CardboardMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Cardboard);
        intensidadOtros(Cardboard);
    }//GEN-LAST:event_CardboardMouseClicked

    private void PaperyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaperyMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Papery);
        intensidadOtros(Papery);
    }//GEN-LAST:event_PaperyMouseClicked

    private void WoodyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WoodyMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Woody);
        intensidadOtros(Woody);
    }//GEN-LAST:event_WoodyMouseClicked

    private void MoldyDampMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MoldyDampMouseClicked
        // TODO add your handling code here:
        intensidadSabor(MoldyDamp);
        intensidadOtros(MoldyDamp);
    }//GEN-LAST:event_MoldyDampMouseClicked

    private void MustyDustyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MustyDustyMouseClicked
        // TODO add your handling code here:
        intensidadSabor(MustyDusty);
        intensidadOtros(MustyDusty);
    }//GEN-LAST:event_MustyDustyMouseClicked

    private void MustyEarthyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MustyEarthyMouseClicked
        // TODO add your handling code here:
        intensidadSabor(MustyEarthy);
        intensidadOtros(MustyEarthy);
    }//GEN-LAST:event_MustyEarthyMouseClicked

    private void AnimalicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AnimalicMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Animalic);
        intensidadOtros(Animalic);
    }//GEN-LAST:event_AnimalicMouseClicked

    private void MeatyBrothyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MeatyBrothyMouseClicked
        // TODO add your handling code here:
        intensidadSabor(MeatyBrothy);
        intensidadOtros(MeatyBrothy);
    }//GEN-LAST:event_MeatyBrothyMouseClicked

    private void PhenolicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PhenolicMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Phenolic);
        intensidadOtros(Phenolic);
    }//GEN-LAST:event_PhenolicMouseClicked

    private void ChemicalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChemicalMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Chemical);
        intensidadOtros(Chemical);
    }//GEN-LAST:event_ChemicalMouseClicked

    private void BitterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BitterMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Bitter);
        intensidadOtros(Bitter);
    }//GEN-LAST:event_BitterMouseClicked

    private void SaltyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaltyMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Salty);
        intensidadOtros(Salty);
    }//GEN-LAST:event_SaltyMouseClicked

    private void MedicinalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicinalMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Medicinal);
        intensidadOtros(Medicinal);
    }//GEN-LAST:event_MedicinalMouseClicked

    private void PetroleumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PetroleumMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Petroleum);
        intensidadOtros(Petroleum);
    }//GEN-LAST:event_PetroleumMouseClicked

    private void SkunkyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SkunkyMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Skunky);
        intensidadOtros(Skunky);
    }//GEN-LAST:event_SkunkyMouseClicked

    private void RubberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RubberMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Rubber);
        intensidadOtros(Rubber);
    }//GEN-LAST:event_RubberMouseClicked

    private void PipeTobaccoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PipeTobaccoMouseClicked
        // TODO add your handling code here:
        intensidadSabor(PipeTobacco);
        intensidadTostado(PipeTobacco);
    }//GEN-LAST:event_PipeTobaccoMouseClicked

    private void TobaccoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TobaccoMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Tobacco);
        intensidadTostado(Tobacco);
    }//GEN-LAST:event_TobaccoMouseClicked

    private void BurntMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BurntMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Burnt);
        intensidadTostado(Burnt);
    }//GEN-LAST:event_BurntMouseClicked

    private void AcridMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AcridMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Acrid);
        intensidadTostado(Acrid);
    }//GEN-LAST:event_AcridMouseClicked

    private void AshyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AshyMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Ashy);
        intensidadTostado(Ashy);
    }//GEN-LAST:event_AshyMouseClicked

    private void SmokyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SmokyMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Smoky);
        intensidadTostado(Smoky);
    }//GEN-LAST:event_SmokyMouseClicked

    private void BrownRoastMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BrownRoastMouseClicked
        // TODO add your handling code here:
        intensidadSabor(BrownRoast);
        intensidadTostado(BrownRoast);
    }//GEN-LAST:event_BrownRoastMouseClicked

    private void CerealMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerealMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Cereal);
        intensidadTostado(Cereal);
    }//GEN-LAST:event_CerealMouseClicked

    private void GrainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrainMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Grain);
        intensidadTostado(Grain);
    }//GEN-LAST:event_GrainMouseClicked

    private void MaltMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaltMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Malt);
        intensidadTostado(Malt);
    }//GEN-LAST:event_MaltMouseClicked

    private void PungentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PungentMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Pungent);
        intensidadEspecias(Pungent);
    }//GEN-LAST:event_PungentMouseClicked

    private void PepperMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PepperMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Pepper);
        intensidadEspecias(Pepper);
    }//GEN-LAST:event_PepperMouseClicked

    private void BrownspicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BrownspicesMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Brownspices);
        intensidadEspecias(Brownspices);
    }//GEN-LAST:event_BrownspicesMouseClicked

    private void AniseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AniseMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Anise);
        intensidadEspecias(Anise);
    }//GEN-LAST:event_AniseMouseClicked

    private void NutmegMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NutmegMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Nutmeg);
        intensidadEspecias(Nutmeg);
    }//GEN-LAST:event_NutmegMouseClicked

    private void CinnamonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CinnamonMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Cinnamon);
        intensidadEspecias(Cinnamon);
    }//GEN-LAST:event_CinnamonMouseClicked

    private void CloveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloveMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Clove);
        intensidadEspecias(Clove);
    }//GEN-LAST:event_CloveMouseClicked

    private void NuttyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NuttyMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Nutty);
        intensidadNC(Nutty);
    }//GEN-LAST:event_NuttyMouseClicked

    private void PeanutsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PeanutsMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Peanuts);
        intensidadNC(Peanuts);
    }//GEN-LAST:event_PeanutsMouseClicked

    private void HazelenutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HazelenutMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Hazelenut);
        intensidadNC(Hazelenut);
    }//GEN-LAST:event_HazelenutMouseClicked

    private void AlmondMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AlmondMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Almond);
        intensidadNC(Almond);
    }//GEN-LAST:event_AlmondMouseClicked

    private void CocoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CocoaMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Cocoa);
        intensidadNC(Cocoa);
    }//GEN-LAST:event_CocoaMouseClicked

    private void ChocolateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChocolateMouseClicked
        // TODO add your handling code here:
        intensidadSabor(Chocolate);
        intensidadNC(Chocolate);
    }//GEN-LAST:event_ChocolateMouseClicked

    private void DarkChocolateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DarkChocolateMouseClicked
        // TODO add your handling code here:
        intensidadSabor(DarkChocolate);
        intensidadNC(DarkChocolate);
    }//GEN-LAST:event_DarkChocolateMouseClicked

    private void BrownSugar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BrownSugar1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(BrownSugar1);
        intensidadSweet(BrownSugar1);
    }//GEN-LAST:event_BrownSugar1MouseClicked

    private void Molasses1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Molasses1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Molasses1);
        intensidadSweet(Molasses1);
    }//GEN-LAST:event_Molasses1MouseClicked

    private void MapleSugar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MapleSugar1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(MapleSugar1);
        intensidadSweet(MapleSugar1);
    }//GEN-LAST:event_MapleSugar1MouseClicked

    private void Carmelized1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Carmelized1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Carmelized1);
        intensidadSweet(Carmelized1);
    }//GEN-LAST:event_Carmelized1MouseClicked

    private void Honey1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Honey1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Honey1);
        intensidadSweet(Honey1);
    }//GEN-LAST:event_Honey1MouseClicked

    private void Vanilla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Vanilla1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Vanilla1);
        intensidadSweet(Vanilla1);
    }//GEN-LAST:event_Vanilla1MouseClicked

    private void Blacktea1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Blacktea1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Blacktea1);
        intensidadFloral(Blacktea1);
    }//GEN-LAST:event_Blacktea1MouseClicked

    private void Chamomile1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chamomile1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Chamomile1);
        intensidadFloral(Chamomile1);
    }//GEN-LAST:event_Chamomile1MouseClicked

    private void Rose1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rose1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Rose1);
        intensidadFloral(Rose1);
    }//GEN-LAST:event_Rose1MouseClicked

    private void Berry1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Berry1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Berry1);
        intensidadFrutal(Berry1);
    }//GEN-LAST:event_Berry1MouseClicked

    private void Blackberry1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Blackberry1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Blackberry1);
        intensidadFrutal(Blackberry1);
    }//GEN-LAST:event_Blackberry1MouseClicked

    private void Raspberry1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Raspberry1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Raspberry1);
        intensidadFrutal(Raspberry1);
    }//GEN-LAST:event_Raspberry1MouseClicked

    private void Blueberry1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Blueberry1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Blueberry1);
        intensidadFrutal(Blueberry1);
    }//GEN-LAST:event_Blueberry1MouseClicked

    private void Strawberry1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Strawberry1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Strawberry1);
        intensidadFrutal(Strawberry1);
    }//GEN-LAST:event_Strawberry1MouseClicked

    private void DriedFruit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DriedFruit1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(DriedFruit1);
        intensidadFrutal(DriedFruit1);
    }//GEN-LAST:event_DriedFruit1MouseClicked

    private void Raisen1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Raisen1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Raisen1);
        intensidadFrutal(Raisen1);
    }//GEN-LAST:event_Raisen1MouseClicked

    private void Prune1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Prune1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Prune1);
        intensidadFrutal(Prune1);
    }//GEN-LAST:event_Prune1MouseClicked

    private void Otherfruit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Otherfruit1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Otherfruit1);
        intensidadFrutal(Otherfruit1);
    }//GEN-LAST:event_Otherfruit1MouseClicked

    private void Coconut1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Coconut1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Coconut1);
        intensidadFrutal(Coconut1);
    }//GEN-LAST:event_Coconut1MouseClicked

    private void Cherry1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cherry1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Cherry1);
        intensidadFrutal(Cherry1);
    }//GEN-LAST:event_Cherry1MouseClicked

    private void Pomagranite1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pomagranite1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Pomagranite1);
        intensidadFrutal(Pomagranite1);
    }//GEN-LAST:event_Pomagranite1MouseClicked

    private void Pinneapple1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pinneapple1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Pinneapple1);
        intensidadFrutal(Pinneapple1);
    }//GEN-LAST:event_Pinneapple1MouseClicked

    private void Grape1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Grape1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Grape1);
        intensidadFrutal(Grape1);
    }//GEN-LAST:event_Grape1MouseClicked

    private void Apple1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Apple1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Apple1);
        intensidadFrutal(Apple1);
    }//GEN-LAST:event_Apple1MouseClicked

    private void Peach1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Peach1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Peach1);
        intensidadFrutal(Peach1);
    }//GEN-LAST:event_Peach1MouseClicked

    private void Pear1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pear1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Pear1);
        intensidadFrutal(Pear1);
    }//GEN-LAST:event_Pear1MouseClicked

    private void Citrusfruit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Citrusfruit1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Citrusfruit1);
        intensidadFrutal(Citrusfruit1);
    }//GEN-LAST:event_Citrusfruit1MouseClicked

    private void Grapefruit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Grapefruit1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Grapefruit1);
        intensidadFrutal(Grapefruit1);
    }//GEN-LAST:event_Grapefruit1MouseClicked

    private void Orange1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Orange1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Orange1);
        intensidadFrutal(Orange1);
    }//GEN-LAST:event_Orange1MouseClicked

    private void Lemon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lemon1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Lemon1);
        intensidadFrutal(Lemon1);
    }//GEN-LAST:event_Lemon1MouseClicked

    private void Lime1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lime1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Lime1);
        intensidadFrutal(Lime1);
    }//GEN-LAST:event_Lime1MouseClicked

    private void sour1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sour1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(sour1);
        intensidadAcFm(sour1);
    }//GEN-LAST:event_sour1MouseClicked

    private void Vinegar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Vinegar1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Vinegar1);
        intensidadAcFm(Vinegar1);
    }//GEN-LAST:event_Vinegar1MouseClicked

    private void Rancidbutter1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rancidbutter1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Rancidbutter1);
        intensidadAcFm(Rancidbutter1);
    }//GEN-LAST:event_Rancidbutter1MouseClicked

    private void RancidCheese1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RancidCheese1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(RancidCheese1);
        intensidadAcFm(RancidCheese1);
    }//GEN-LAST:event_RancidCheese1MouseClicked

    private void OrangeAcidity1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrangeAcidity1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(OrangeAcidity1);
        intensidadAcFm(OrangeAcidity1);
    }//GEN-LAST:event_OrangeAcidity1MouseClicked

    private void AppleAcidity1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AppleAcidity1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(AppleAcidity1);
        intensidadAcFm(AppleAcidity1);
    }//GEN-LAST:event_AppleAcidity1MouseClicked

    private void Alcohol1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Alcohol1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Alcohol1);
        intensidadAcFm(Alcohol1);
    }//GEN-LAST:event_Alcohol1MouseClicked

    private void Winey1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Winey1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Winey1);
        intensidadAcFm(Winey1);
    }//GEN-LAST:event_Winey1MouseClicked

    private void Whiskey1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Whiskey1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Whiskey1);
        intensidadAcFm(Whiskey1);
    }//GEN-LAST:event_Whiskey1MouseClicked

    private void Fermented1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Fermented1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Fermented1);
        intensidadAcFm(Fermented1);
    }//GEN-LAST:event_Fermented1MouseClicked

    private void Overripe1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Overripe1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Overripe1);
        intensidadAcFm(Overripe1);
    }//GEN-LAST:event_Overripe1MouseClicked

    private void OliveOil1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OliveOil1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(OliveOil1);
        intensidadVV(OliveOil1);
    }//GEN-LAST:event_OliveOil1MouseClicked

    private void Raw1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Raw1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Raw1);
        intensidadVV(Raw1);
    }//GEN-LAST:event_Raw1MouseClicked

    private void Beany1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Beany1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Beany1);
        intensidadVV(Beany1);
    }//GEN-LAST:event_Beany1MouseClicked

    private void Underripe1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Underripe1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Underripe1);
        intensidadVV(Underripe1);
    }//GEN-LAST:event_Underripe1MouseClicked

    private void Peapod1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Peapod1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Peapod1);
        intensidadVV(Peapod1);
    }//GEN-LAST:event_Peapod1MouseClicked

    private void Fresh1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Fresh1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Fresh1);
        intensidadVV(Fresh1);
    }//GEN-LAST:event_Fresh1MouseClicked

    private void DarkGreen1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DarkGreen1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(DarkGreen1);
        intensidadVV(DarkGreen1);
    }//GEN-LAST:event_DarkGreen1MouseClicked

    private void Vegetative1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Vegetative1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Vegetative1);
        intensidadVV(Vegetative1);
    }//GEN-LAST:event_Vegetative1MouseClicked

    private void Haylike1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Haylike1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Haylike1);
        intensidadVV(Haylike1);
    }//GEN-LAST:event_Haylike1MouseClicked

    private void Herblike1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Herblike1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Herblike1);
        intensidadVV(Herblike1);
    }//GEN-LAST:event_Herblike1MouseClicked

    private void PaperyM1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaperyM1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(PaperyM1);
        intensidadOtros(PaperyM1);
    }//GEN-LAST:event_PaperyM1MouseClicked

    private void Stale1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Stale1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Stale1);
        intensidadOtros(Stale1);
    }//GEN-LAST:event_Stale1MouseClicked

    private void Cardboard1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cardboard1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Cardboard1);
        intensidadOtros(Cardboard1);
    }//GEN-LAST:event_Cardboard1MouseClicked

    private void Papery1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Papery1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Papery1);
        intensidadOtros(Papery1);
    }//GEN-LAST:event_Papery1MouseClicked

    private void Woody1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Woody1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Woody1);
        intensidadOtros(Woody1);
    }//GEN-LAST:event_Woody1MouseClicked

    private void MoldyDamp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MoldyDamp1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(MoldyDamp1);
        intensidadOtros(MoldyDamp1);
    }//GEN-LAST:event_MoldyDamp1MouseClicked

    private void MustyDusty1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MustyDusty1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(MustyDusty1);
        intensidadOtros(MustyDusty1);
    }//GEN-LAST:event_MustyDusty1MouseClicked

    private void MustyEarthy1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MustyEarthy1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(MustyEarthy1);
        intensidadOtros(MustyEarthy1);
    }//GEN-LAST:event_MustyEarthy1MouseClicked

    private void Animalic1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Animalic1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Animalic);
        intensidadOtros(Animalic);
    }//GEN-LAST:event_Animalic1MouseClicked

    private void MeatyBrothy1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MeatyBrothy1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(MeatyBrothy1);
        intensidadOtros(MeatyBrothy1);
    }//GEN-LAST:event_MeatyBrothy1MouseClicked

    private void Phenolic1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phenolic1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Phenolic1);
        intensidadOtros(Phenolic1);
    }//GEN-LAST:event_Phenolic1MouseClicked

    private void Chemical1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chemical1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Chemical1);
        intensidadOtros(Chemical1);
    }//GEN-LAST:event_Chemical1MouseClicked

    private void Bitter1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bitter1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Bitter1);
        intensidadOtros(Bitter1);
    }//GEN-LAST:event_Bitter1MouseClicked

    private void Salty1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Salty1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Salty1);
        intensidadOtros(Salty1);
    }//GEN-LAST:event_Salty1MouseClicked

    private void Medicinal1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Medicinal1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Medicinal1);
        intensidadOtros(Medicinal1);
    }//GEN-LAST:event_Medicinal1MouseClicked

    private void Petroleum1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Petroleum1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Petroleum1);
        intensidadOtros(Petroleum1);
    }//GEN-LAST:event_Petroleum1MouseClicked

    private void Skunky1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Skunky1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Skunky1);
        intensidadOtros(Skunky1);
    }//GEN-LAST:event_Skunky1MouseClicked

    private void Rubber1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rubber1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Rubber1);
        intensidadOtros(Rubber1);
    }//GEN-LAST:event_Rubber1MouseClicked

    private void PipeTobacco1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PipeTobacco1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(PipeTobacco1);
        intensidadTostado(PipeTobacco1);
    }//GEN-LAST:event_PipeTobacco1MouseClicked

    private void Tobacco1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tobacco1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Tobacco1);
        intensidadTostado(Tobacco1);
    }//GEN-LAST:event_Tobacco1MouseClicked

    private void Burnt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Burnt1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Burnt1);
        intensidadTostado(Burnt1);
    }//GEN-LAST:event_Burnt1MouseClicked

    private void Acrid1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Acrid1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Acrid1);
        intensidadTostado(Acrid1);
    }//GEN-LAST:event_Acrid1MouseClicked

    private void Ashy1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Ashy1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Ashy1);
        intensidadTostado(Ashy1);
    }//GEN-LAST:event_Ashy1MouseClicked

    private void Smoky1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Smoky1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Smoky1);
        intensidadTostado(Smoky1);
    }//GEN-LAST:event_Smoky1MouseClicked

    private void BrownRoast1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BrownRoast1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(BrownRoast1);
        intensidadTostado(BrownRoast1);
    }//GEN-LAST:event_BrownRoast1MouseClicked

    private void Cereal1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cereal1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Cereal1);
        intensidadTostado(Cereal1);
    }//GEN-LAST:event_Cereal1MouseClicked

    private void Grain1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Grain1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Grain1);
        intensidadTostado(Grain1);
    }//GEN-LAST:event_Grain1MouseClicked

    private void Malt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Malt1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Malt1);
        intensidadTostado(Malt1);
    }//GEN-LAST:event_Malt1MouseClicked

    private void Pungent1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pungent1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Pungent1);
        intensidadEspecias(Pungent1);
    }//GEN-LAST:event_Pungent1MouseClicked

    private void Pepper1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pepper1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Pepper1);
        intensidadEspecias(Pepper1);
    }//GEN-LAST:event_Pepper1MouseClicked

    private void Brownspices1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Brownspices1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Brownspices1);
        intensidadEspecias(Brownspices1);
    }//GEN-LAST:event_Brownspices1MouseClicked

    private void Anise1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Anise1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Anise1);
        intensidadEspecias(Anise1);
    }//GEN-LAST:event_Anise1MouseClicked

    private void Nutmeg1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Nutmeg1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Nutmeg1);
        intensidadEspecias(Nutmeg1);
    }//GEN-LAST:event_Nutmeg1MouseClicked

    private void Cinnamon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cinnamon1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Cinnamon1);
        intensidadEspecias(Cinnamon1);
    }//GEN-LAST:event_Cinnamon1MouseClicked

    private void Clove1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Clove1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Clove1);
        intensidadEspecias(Clove1);
    }//GEN-LAST:event_Clove1MouseClicked

    private void Nutty1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Nutty1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Nutty1);
        intensidadNC(Nutty1);
    }//GEN-LAST:event_Nutty1MouseClicked

    private void Peanuts1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Peanuts1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Peanuts1);
        intensidadNC(Peanuts1);
    }//GEN-LAST:event_Peanuts1MouseClicked

    private void Hazelenut1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Hazelenut1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Hazelenut1);
        intensidadNC(Hazelenut1);
    }//GEN-LAST:event_Hazelenut1MouseClicked

    private void Almond1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Almond1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Almond1);
        intensidadNC(Almond1);
    }//GEN-LAST:event_Almond1MouseClicked

    private void Cocoa1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cocoa1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Cocoa1);
        intensidadNC(Cocoa1);
    }//GEN-LAST:event_Cocoa1MouseClicked

    private void Chocolate1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chocolate1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Chocolate1);
        intensidadNC(Chocolate1);
    }//GEN-LAST:event_Chocolate1MouseClicked

    private void DarkChocolate1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DarkChocolate1MouseClicked
        // TODO add your handling code here:
        intensidadSabor(DarkChocolate1);
        intensidadNC(DarkChocolate1);
    }//GEN-LAST:event_DarkChocolate1MouseClicked

    private void BrownSugar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BrownSugar2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(BrownSugar2);
        intensidadSweet(BrownSugar2);
    }//GEN-LAST:event_BrownSugar2MouseClicked

    private void Molasses2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Molasses2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Molasses2);
        intensidadSweet(Molasses2);
    }//GEN-LAST:event_Molasses2MouseClicked

    private void MapleSugar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MapleSugar2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(MapleSugar2);
        intensidadSweet(MapleSugar2);
    }//GEN-LAST:event_MapleSugar2MouseClicked

    private void Carmelized2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Carmelized2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Carmelized2);
        intensidadSweet(Carmelized2);
    }//GEN-LAST:event_Carmelized2MouseClicked

    private void Honey2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Honey2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Honey2);
        intensidadSweet(Honey2);
    }//GEN-LAST:event_Honey2MouseClicked

    private void Vanilla2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Vanilla2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Vanilla2);
        intensidadSweet(Vanilla2);
    }//GEN-LAST:event_Vanilla2MouseClicked

    private void Blacktea2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Blacktea2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Blacktea2);
        intensidadFloral(Blacktea2);
    }//GEN-LAST:event_Blacktea2MouseClicked

    private void Chamomile2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chamomile2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Chamomile2);
        intensidadFloral(Chamomile2);
    }//GEN-LAST:event_Chamomile2MouseClicked

    private void Rose2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rose2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Rose2);
        intensidadFloral(Rose2);
    }//GEN-LAST:event_Rose2MouseClicked

    private void Jasmine2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jasmine2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Jasmine2);
        intensidadFloral(Jasmine2);
    }//GEN-LAST:event_Jasmine2MouseClicked

    private void Berry2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Berry2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Berry2);
        intensidadFrutal(Berry2);
    }//GEN-LAST:event_Berry2MouseClicked

    private void Blackberry2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Blackberry2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Blackberry2);
        intensidadFrutal(Blackberry2);
    }//GEN-LAST:event_Blackberry2MouseClicked

    private void Raspberry2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Raspberry2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Raspberry2);
        intensidadFrutal(Raspberry2);
    }//GEN-LAST:event_Raspberry2MouseClicked

    private void Blueberry2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Blueberry2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Blueberry2);
        intensidadFrutal(Blueberry2);
    }//GEN-LAST:event_Blueberry2MouseClicked

    private void Strawberry2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Strawberry2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Strawberry2);
        intensidadFrutal(Strawberry2);
    }//GEN-LAST:event_Strawberry2MouseClicked

    private void DriedFruit2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DriedFruit2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(DriedFruit2);
        intensidadFrutal(DriedFruit2);
    }//GEN-LAST:event_DriedFruit2MouseClicked

    private void Raisen2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Raisen2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Raisen2);
        intensidadFrutal(Raisen2);
    }//GEN-LAST:event_Raisen2MouseClicked

    private void Prune2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Prune2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Prune2);
        intensidadFrutal(Prune2);
    }//GEN-LAST:event_Prune2MouseClicked

    private void Otherfruit2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Otherfruit2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Otherfruit2);
        intensidadFrutal(Otherfruit2);
    }//GEN-LAST:event_Otherfruit2MouseClicked

    private void Coconut2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Coconut2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Coconut2);
        intensidadFrutal(Coconut2);
    }//GEN-LAST:event_Coconut2MouseClicked

    private void Cherry2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cherry2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Cherry2);
        intensidadFrutal(Cherry2);
    }//GEN-LAST:event_Cherry2MouseClicked

    private void Pomagranite2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pomagranite2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Pomagranite2);
        intensidadFrutal(Pomagranite2);
    }//GEN-LAST:event_Pomagranite2MouseClicked

    private void Pinneapple2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pinneapple2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Pinneapple2);
        intensidadFrutal(Pinneapple2);
    }//GEN-LAST:event_Pinneapple2MouseClicked

    private void Grape2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Grape2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Grape2);
        intensidadFrutal(Grape2);
    }//GEN-LAST:event_Grape2MouseClicked

    private void Apple2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Apple2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Apple2);
        intensidadFrutal(Apple2);
    }//GEN-LAST:event_Apple2MouseClicked

    private void Peach2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Peach2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Peach2);
        intensidadFrutal(Peach2);
    }//GEN-LAST:event_Peach2MouseClicked

    private void Pear2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pear2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Pear2);
        intensidadFrutal(Pear2);
    }//GEN-LAST:event_Pear2MouseClicked

    private void Citrusfruit2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Citrusfruit2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Citrusfruit2);
        intensidadFrutal(Citrusfruit2);
    }//GEN-LAST:event_Citrusfruit2MouseClicked

    private void Grapefruit2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Grapefruit2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Grapefruit2);
        intensidadFrutal(Grapefruit2);
    }//GEN-LAST:event_Grapefruit2MouseClicked

    private void Orange2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Orange2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Orange2);
        intensidadFrutal(Orange2);
    }//GEN-LAST:event_Orange2MouseClicked

    private void Lemon2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lemon2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Lemon2);
        intensidadFrutal(Lemon2);
    }//GEN-LAST:event_Lemon2MouseClicked

    private void Lime2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lime2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Lime2);
        intensidadFrutal(Lime2);
    }//GEN-LAST:event_Lime2MouseClicked

    private void sour2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sour2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(sour2);
        intensidadAcFm(sour2);
    }//GEN-LAST:event_sour2MouseClicked

    private void Vinegar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Vinegar2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Vinegar2);
        intensidadAcFm(Vinegar2);
    }//GEN-LAST:event_Vinegar2MouseClicked

    private void Rancidbutter2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rancidbutter2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Rancidbutter2);
        intensidadAcFm(Rancidbutter2);
    }//GEN-LAST:event_Rancidbutter2MouseClicked

    private void RancidCheese2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RancidCheese2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(RancidCheese2);
        intensidadAcFm(RancidCheese2);
    }//GEN-LAST:event_RancidCheese2MouseClicked

    private void OrangeAcidity2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrangeAcidity2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(OrangeAcidity2);
        intensidadAcFm(OrangeAcidity2);
    }//GEN-LAST:event_OrangeAcidity2MouseClicked

    private void AppleAcidity2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AppleAcidity2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(AppleAcidity2);
        intensidadAcFm(AppleAcidity2);
    }//GEN-LAST:event_AppleAcidity2MouseClicked

    private void Alcohol2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Alcohol2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Alcohol2);
        intensidadAcFm(Alcohol2);
    }//GEN-LAST:event_Alcohol2MouseClicked

    private void Winey2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Winey2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Winey2);
        intensidadAcFm(Winey2);
    }//GEN-LAST:event_Winey2MouseClicked

    private void Whiskey2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Whiskey2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Whiskey2);
        intensidadAcFm(Whiskey2);
    }//GEN-LAST:event_Whiskey2MouseClicked

    private void Fermented2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Fermented2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Fermented2);
        intensidadAcFm(Fermented2);
    }//GEN-LAST:event_Fermented2MouseClicked

    private void Overripe2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Overripe2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Overripe2);
        intensidadAcFm(Overripe2);
    }//GEN-LAST:event_Overripe2MouseClicked

    private void OliveOil2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OliveOil2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(OliveOil2);
        intensidadVV(OliveOil2);
    }//GEN-LAST:event_OliveOil2MouseClicked

    private void Raw2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Raw2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Raw2);
        intensidadVV(Raw2);
    }//GEN-LAST:event_Raw2MouseClicked

    private void Beany2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Beany2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Beany2);
        intensidadVV(Beany2);
    }//GEN-LAST:event_Beany2MouseClicked

    private void Underripe2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Underripe2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Underripe2);
        intensidadVV(Underripe2);
    }//GEN-LAST:event_Underripe2MouseClicked

    private void Peapod2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Peapod2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Peapod2);
        intensidadVV(Peapod2);
    }//GEN-LAST:event_Peapod2MouseClicked

    private void Fresh2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Fresh2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Fresh2);
        intensidadVV(Fresh2);
    }//GEN-LAST:event_Fresh2MouseClicked

    private void DarkGreen2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DarkGreen2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(DarkGreen2);
        intensidadVV(DarkGreen2);
    }//GEN-LAST:event_DarkGreen2MouseClicked

    private void Vegetative2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Vegetative2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Vegetative2);
        intensidadVV(Vegetative2);
    }//GEN-LAST:event_Vegetative2MouseClicked

    private void Haylike2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Haylike2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Haylike2);
        intensidadVV(Haylike2);
    }//GEN-LAST:event_Haylike2MouseClicked

    private void Herblike2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Herblike2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Herblike2);
        intensidadVV(Herblike2);
    }//GEN-LAST:event_Herblike2MouseClicked

    private void PaperyM2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaperyM2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(PaperyM2);
        intensidadOtros(PaperyM2);
    }//GEN-LAST:event_PaperyM2MouseClicked

    private void Stale2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Stale2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Stale2);
        intensidadOtros(Stale2);
    }//GEN-LAST:event_Stale2MouseClicked

    private void Cardboard2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cardboard2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Cardboard2);
        intensidadOtros(Cardboard2);
    }//GEN-LAST:event_Cardboard2MouseClicked

    private void Papery2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Papery2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Papery2);
        intensidadOtros(Papery2);
    }//GEN-LAST:event_Papery2MouseClicked

    private void Woody2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Woody2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Woody2);
        intensidadOtros(Woody2);
    }//GEN-LAST:event_Woody2MouseClicked

    private void MoldyDamp2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MoldyDamp2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(MoldyDamp2);
        intensidadOtros(MoldyDamp2);
    }//GEN-LAST:event_MoldyDamp2MouseClicked

    private void MustyDusty2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MustyDusty2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(MustyDusty2);
        intensidadOtros(MustyDusty2);
    }//GEN-LAST:event_MustyDusty2MouseClicked

    private void MustyEarthy2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MustyEarthy2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(MustyEarthy2);
        intensidadOtros(MustyEarthy2);
    }//GEN-LAST:event_MustyEarthy2MouseClicked

    private void Animalic2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Animalic2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Animalic2);
        intensidadOtros(Animalic2);
    }//GEN-LAST:event_Animalic2MouseClicked

    private void MeatyBrothy2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MeatyBrothy2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(MeatyBrothy2);
        intensidadOtros(MeatyBrothy2);
    }//GEN-LAST:event_MeatyBrothy2MouseClicked

    private void Phenolic2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phenolic2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Phenolic2);
        intensidadOtros(Phenolic2);
    }//GEN-LAST:event_Phenolic2MouseClicked

    private void Chemical2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chemical2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Chemical2);
        intensidadOtros(Chemical2);
    }//GEN-LAST:event_Chemical2MouseClicked

    private void Bitter2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bitter2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Bitter2);
        intensidadOtros(Bitter2);
    }//GEN-LAST:event_Bitter2MouseClicked

    private void Salty2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Salty2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Salty2);
        intensidadOtros(Salty2);
    }//GEN-LAST:event_Salty2MouseClicked

    private void Medicinal2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Medicinal2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Medicinal2);
        intensidadOtros(Medicinal2);
    }//GEN-LAST:event_Medicinal2MouseClicked

    private void Petroleum2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Petroleum2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Petroleum2);
        intensidadOtros(Petroleum2);
    }//GEN-LAST:event_Petroleum2MouseClicked

    private void Skunky2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Skunky2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Skunky2);
        intensidadOtros(Skunky2);
    }//GEN-LAST:event_Skunky2MouseClicked

    private void Rubber2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rubber2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Rubber2);
        intensidadOtros(Rubber2);
    }//GEN-LAST:event_Rubber2MouseClicked

    private void PipeTobacco2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PipeTobacco2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(PipeTobacco2);
        intensidadTostado(PipeTobacco2);
    }//GEN-LAST:event_PipeTobacco2MouseClicked

    private void Tobacco2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tobacco2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Tobacco2);
        intensidadTostado(Tobacco2);
    }//GEN-LAST:event_Tobacco2MouseClicked

    private void Burnt2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Burnt2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Burnt2);
        intensidadTostado(Burnt2);
    }//GEN-LAST:event_Burnt2MouseClicked

    private void Acrid2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Acrid2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Acrid2);
        intensidadTostado(Acrid2);
    }//GEN-LAST:event_Acrid2MouseClicked

    private void Ashy2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Ashy2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Ashy2);
        intensidadTostado(Ashy2);
    }//GEN-LAST:event_Ashy2MouseClicked

    private void Smoky2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Smoky2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Smoky2);
        intensidadTostado(Smoky2);
    }//GEN-LAST:event_Smoky2MouseClicked

    private void BrownRoast2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BrownRoast2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(BrownRoast2);
        intensidadTostado(BrownRoast2);
    }//GEN-LAST:event_BrownRoast2MouseClicked

    private void Cereal2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cereal2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Cereal2);
        intensidadTostado(Cereal2);
    }//GEN-LAST:event_Cereal2MouseClicked

    private void Grain2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Grain2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Grain2);
        intensidadTostado(Grain2);
    }//GEN-LAST:event_Grain2MouseClicked

    private void Malt2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Malt2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Malt2);
        intensidadTostado(Malt2);
    }//GEN-LAST:event_Malt2MouseClicked

    private void Pungent2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pungent2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Pungent2);
        intensidadEspecias(Pungent2);
    }//GEN-LAST:event_Pungent2MouseClicked

    private void Pepper2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pepper2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Pepper2);
        intensidadEspecias(Pepper2);
    }//GEN-LAST:event_Pepper2MouseClicked

    private void Brownspices2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Brownspices2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Brownspices2);
        intensidadEspecias(Brownspices2);
    }//GEN-LAST:event_Brownspices2MouseClicked

    private void Anise2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Anise2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Anise2);
        intensidadEspecias(Anise2);
    }//GEN-LAST:event_Anise2MouseClicked

    private void Nutmeg2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Nutmeg2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Nutmeg2);
        intensidadEspecias(Nutmeg2);
    }//GEN-LAST:event_Nutmeg2MouseClicked

    private void Cinnamon2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cinnamon2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Cinnamon2);
        intensidadEspecias(Cinnamon2);
    }//GEN-LAST:event_Cinnamon2MouseClicked

    private void Clove2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Clove2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Clove2);
        intensidadEspecias(Clove2);
    }//GEN-LAST:event_Clove2MouseClicked

    private void Nutty2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Nutty2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Nutty2);
        intensidadNC(Nutty2);
    }//GEN-LAST:event_Nutty2MouseClicked

    private void Peanuts2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Peanuts2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Peanuts2);
        intensidadNC(Peanuts2);
    }//GEN-LAST:event_Peanuts2MouseClicked

    private void Hazelenut2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Hazelenut2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Hazelenut2);
        intensidadNC(Hazelenut2);
    }//GEN-LAST:event_Hazelenut2MouseClicked

    private void Almond2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Almond2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Almond2);
        intensidadNC(Almond2);
    }//GEN-LAST:event_Almond2MouseClicked

    private void Cocoa2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cocoa2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Cocoa2);
        intensidadNC(Cocoa2);
    }//GEN-LAST:event_Cocoa2MouseClicked

    private void Chocolate2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chocolate2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Chocolate2);
        intensidadNC(Chocolate2);
    }//GEN-LAST:event_Chocolate2MouseClicked

    private void DarkChocolate2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DarkChocolate2MouseClicked
        // TODO add your handling code here:
        intensidadSabor(DarkChocolate2);
        intensidadNC(DarkChocolate2);
    }//GEN-LAST:event_DarkChocolate2MouseClicked

    private void BrownSugar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BrownSugar3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(BrownSugar3);
        intensidadSweet(BrownSugar3);
    }//GEN-LAST:event_BrownSugar3MouseClicked

    private void Molasses3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Molasses3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Molasses3);
        intensidadSweet(Molasses3);
    }//GEN-LAST:event_Molasses3MouseClicked

    private void MapleSugar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MapleSugar3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(MapleSugar3);
        intensidadSweet(MapleSugar3);
    }//GEN-LAST:event_MapleSugar3MouseClicked

    private void Carmelized3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Carmelized3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Carmelized3);
        intensidadSweet(Carmelized3);
    }//GEN-LAST:event_Carmelized3MouseClicked

    private void Honey3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Honey3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Honey3);
        intensidadSweet(Honey3);
    }//GEN-LAST:event_Honey3MouseClicked

    private void Vanilla3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Vanilla3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Vanilla3);
        intensidadSweet(Vanilla3);
    }//GEN-LAST:event_Vanilla3MouseClicked

    private void Blacktea3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Blacktea3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Blacktea3);
        intensidadFloral(Blacktea3);
    }//GEN-LAST:event_Blacktea3MouseClicked

    private void Chamomile3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chamomile3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Chamomile3);
        intensidadFloral(Chamomile3);
    }//GEN-LAST:event_Chamomile3MouseClicked

    private void Rose3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rose3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Rose3);
        intensidadFloral(Rose3);
    }//GEN-LAST:event_Rose3MouseClicked

    private void Jasmine3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jasmine3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Jasmine3);
        intensidadFloral(Jasmine3);
    }//GEN-LAST:event_Jasmine3MouseClicked

    private void Berry3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Berry3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Berry3);
        intensidadFrutal(Berry3);
    }//GEN-LAST:event_Berry3MouseClicked

    private void Blackberry3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Blackberry3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Blackberry3);
        intensidadFrutal(Blackberry3);
    }//GEN-LAST:event_Blackberry3MouseClicked

    private void Raspberry3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Raspberry3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Raspberry3);
        intensidadFrutal(Raspberry3);
    }//GEN-LAST:event_Raspberry3MouseClicked

    private void Blueberry3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Blueberry3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Blueberry3);
        intensidadFrutal(Blueberry3);
    }//GEN-LAST:event_Blueberry3MouseClicked

    private void Strawberry3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Strawberry3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Strawberry3);
        intensidadFrutal(Strawberry3);
    }//GEN-LAST:event_Strawberry3MouseClicked

    private void DriedFruit3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DriedFruit3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(DriedFruit3);
        intensidadFrutal(DriedFruit3);
    }//GEN-LAST:event_DriedFruit3MouseClicked

    private void Raisen3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Raisen3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Raisen3);
        intensidadFrutal(Raisen3);
    }//GEN-LAST:event_Raisen3MouseClicked

    private void Prune3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Prune3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Prune3);
        intensidadFrutal(Prune3);
    }//GEN-LAST:event_Prune3MouseClicked

    private void Otherfruit3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Otherfruit3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Otherfruit3);
        intensidadFrutal(Otherfruit3);
    }//GEN-LAST:event_Otherfruit3MouseClicked

    private void Coconut3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Coconut3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Coconut3);
        intensidadFrutal(Coconut3);
    }//GEN-LAST:event_Coconut3MouseClicked

    private void Cherry3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cherry3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Cherry3);
        intensidadFrutal(Cherry3);
    }//GEN-LAST:event_Cherry3MouseClicked

    private void Pomagranite3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pomagranite3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Pomagranite3);
        intensidadFrutal(Pomagranite3);
    }//GEN-LAST:event_Pomagranite3MouseClicked

    private void Pinneapple3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pinneapple3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Pinneapple3);
        intensidadFrutal(Pinneapple3);
    }//GEN-LAST:event_Pinneapple3MouseClicked

    private void Grape3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Grape3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Grape3);
        intensidadFrutal(Grape3);
    }//GEN-LAST:event_Grape3MouseClicked

    private void Apple3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Apple3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Apple3);
        intensidadFrutal(Apple3);
    }//GEN-LAST:event_Apple3MouseClicked

    private void Peach3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Peach3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Peach3);
        intensidadFrutal(Peach3);
    }//GEN-LAST:event_Peach3MouseClicked

    private void Pear3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pear3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Pear3);
        intensidadFrutal(Pear3);
    }//GEN-LAST:event_Pear3MouseClicked

    private void Citrusfruit3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Citrusfruit3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Citrusfruit3);
        intensidadFrutal(Citrusfruit3);
    }//GEN-LAST:event_Citrusfruit3MouseClicked

    private void Grapefruit3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Grapefruit3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Grapefruit3);
        intensidadFrutal(Grapefruit3);
    }//GEN-LAST:event_Grapefruit3MouseClicked

    private void Orange3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Orange3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Orange3);
        intensidadFrutal(Orange3);
    }//GEN-LAST:event_Orange3MouseClicked

    private void Lemon3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lemon3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Lemon3);
        intensidadFrutal(Lemon3);
    }//GEN-LAST:event_Lemon3MouseClicked

    private void Lime3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lime3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Lime3);
        intensidadFrutal(Lime3);
    }//GEN-LAST:event_Lime3MouseClicked

    private void sour3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sour3MouseClicked
        // TODO add your handling code here:intensidadSabor(sour);
        intensidadSabor(sour3);
        intensidadAcFm(sour3);
    }//GEN-LAST:event_sour3MouseClicked

    private void Vinegar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Vinegar3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Vinegar3);
        intensidadAcFm(Vinegar3);
    }//GEN-LAST:event_Vinegar3MouseClicked

    private void Rancidbutter3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rancidbutter3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Rancidbutter3);
        intensidadAcFm(Rancidbutter3);
    }//GEN-LAST:event_Rancidbutter3MouseClicked

    private void RancidCheese3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RancidCheese3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(RancidCheese3);
        intensidadAcFm(RancidCheese3);
    }//GEN-LAST:event_RancidCheese3MouseClicked

    private void OrangeAcidity3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrangeAcidity3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(OrangeAcidity3);
        intensidadAcFm(OrangeAcidity3);
    }//GEN-LAST:event_OrangeAcidity3MouseClicked

    private void AppleAcidity3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AppleAcidity3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(AppleAcidity3);
        intensidadAcFm(AppleAcidity3);
    }//GEN-LAST:event_AppleAcidity3MouseClicked

    private void Alcohol3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Alcohol3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Alcohol3);
        intensidadAcFm(Alcohol3);
    }//GEN-LAST:event_Alcohol3MouseClicked

    private void Winey3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Winey3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Winey3);
        intensidadAcFm(Winey3);
    }//GEN-LAST:event_Winey3MouseClicked

    private void Whiskey3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Whiskey3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Whiskey3);
        intensidadAcFm(Whiskey3);
    }//GEN-LAST:event_Whiskey3MouseClicked

    private void Fermented3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Fermented3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Fermented3);
        intensidadAcFm(Fermented3);
    }//GEN-LAST:event_Fermented3MouseClicked

    private void Overripe3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Overripe3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Overripe3);
        intensidadAcFm(Overripe3);
    }//GEN-LAST:event_Overripe3MouseClicked

    private void OliveOil3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OliveOil3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(OliveOil3);
        intensidadVV(OliveOil3);
    }//GEN-LAST:event_OliveOil3MouseClicked

    private void Raw3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Raw3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Raw3);
        intensidadVV(Raw3);
    }//GEN-LAST:event_Raw3MouseClicked

    private void Beany3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Beany3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Beany3);
        intensidadVV(Beany3);
    }//GEN-LAST:event_Beany3MouseClicked

    private void Underripe3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Underripe3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Underripe3);
        intensidadVV(Underripe3);
    }//GEN-LAST:event_Underripe3MouseClicked

    private void Peapod3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Peapod3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Peapod3);
        intensidadVV(Peapod3);
    }//GEN-LAST:event_Peapod3MouseClicked

    private void Fresh3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Fresh3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Fresh3);
        intensidadVV(Fresh3);
    }//GEN-LAST:event_Fresh3MouseClicked

    private void DarkGreen3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DarkGreen3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(DarkGreen3);
        intensidadVV(DarkGreen3);
    }//GEN-LAST:event_DarkGreen3MouseClicked

    private void Vegetative3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Vegetative3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Vegetative3);
        intensidadVV(Vegetative3);
    }//GEN-LAST:event_Vegetative3MouseClicked

    private void Haylike3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Haylike3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Haylike3);
        intensidadVV(Haylike3);
    }//GEN-LAST:event_Haylike3MouseClicked

    private void Herblike3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Herblike3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Herblike3);
        intensidadVV(Herblike3);
    }//GEN-LAST:event_Herblike3MouseClicked

    private void PaperyM3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaperyM3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(PaperyM3);
        intensidadOtros(PaperyM3);
    }//GEN-LAST:event_PaperyM3MouseClicked

    private void Stale3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Stale3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Stale3);
        intensidadOtros(Stale3);
    }//GEN-LAST:event_Stale3MouseClicked

    private void Cardboard3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cardboard3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Cardboard3);
        intensidadOtros(Cardboard3);
    }//GEN-LAST:event_Cardboard3MouseClicked

    private void Papery3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Papery3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Papery3);
        intensidadOtros(Papery3);
    }//GEN-LAST:event_Papery3MouseClicked

    private void Woody3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Woody3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Woody3);
        intensidadOtros(Woody3);
    }//GEN-LAST:event_Woody3MouseClicked

    private void MoldyDamp3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MoldyDamp3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(MoldyDamp3);
        intensidadOtros(MoldyDamp3);
    }//GEN-LAST:event_MoldyDamp3MouseClicked

    private void MustyDusty3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MustyDusty3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(MustyDusty3);
        intensidadOtros(MustyDusty3);
    }//GEN-LAST:event_MustyDusty3MouseClicked

    private void MustyEarthy3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MustyEarthy3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(MustyEarthy3);
        intensidadOtros(MustyEarthy3);
    }//GEN-LAST:event_MustyEarthy3MouseClicked

    private void Animalic3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Animalic3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Animalic3);
        intensidadOtros(Animalic3);
    }//GEN-LAST:event_Animalic3MouseClicked

    private void MeatyBrothy3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MeatyBrothy3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(MeatyBrothy3);
        intensidadOtros(MeatyBrothy3);
    }//GEN-LAST:event_MeatyBrothy3MouseClicked

    private void Phenolic3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phenolic3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Phenolic3);
        intensidadOtros(Phenolic3);
    }//GEN-LAST:event_Phenolic3MouseClicked

    private void Chemical3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chemical3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Chemical3);
        intensidadOtros(Chemical3);
    }//GEN-LAST:event_Chemical3MouseClicked

    private void Bitter3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bitter3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Bitter3);
        intensidadOtros(Bitter3);
    }//GEN-LAST:event_Bitter3MouseClicked

    private void Salty3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Salty3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Salty3);
        intensidadOtros(Salty3);
    }//GEN-LAST:event_Salty3MouseClicked

    private void Medicinal3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Medicinal3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Medicinal3);
        intensidadOtros(Medicinal3);
    }//GEN-LAST:event_Medicinal3MouseClicked

    private void Petroleum3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Petroleum3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Petroleum3);
        intensidadOtros(Petroleum3);
    }//GEN-LAST:event_Petroleum3MouseClicked

    private void Skunky3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Skunky3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Skunky3);
        intensidadOtros(Skunky3);
    }//GEN-LAST:event_Skunky3MouseClicked

    private void Rubber3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rubber3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Rubber3);
        intensidadOtros(Rubber3);
    }//GEN-LAST:event_Rubber3MouseClicked

    private void PipeTobacco3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PipeTobacco3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(PipeTobacco3);
        intensidadTostado(PipeTobacco3);
    }//GEN-LAST:event_PipeTobacco3MouseClicked

    private void Tobacco3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tobacco3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Tobacco3);
        intensidadTostado(Tobacco3);
    }//GEN-LAST:event_Tobacco3MouseClicked

    private void Burnt3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Burnt3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Burnt3);
        intensidadTostado(Burnt3);
    }//GEN-LAST:event_Burnt3MouseClicked

    private void Acrid3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Acrid3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Acrid3);
        intensidadTostado(Acrid3);
    }//GEN-LAST:event_Acrid3MouseClicked

    private void Ashy3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Ashy3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Ashy3);
        intensidadTostado(Ashy3);
    }//GEN-LAST:event_Ashy3MouseClicked

    private void Smoky3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Smoky3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Smoky3);
        intensidadTostado(Smoky3);
    }//GEN-LAST:event_Smoky3MouseClicked

    private void BrownRoast3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BrownRoast3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(BrownRoast3);
        intensidadTostado(BrownRoast3);
    }//GEN-LAST:event_BrownRoast3MouseClicked

    private void Cereal3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cereal3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Cereal3);
        intensidadTostado(Cereal3);
    }//GEN-LAST:event_Cereal3MouseClicked

    private void Grain3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Grain3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Grain3);
        intensidadTostado(Grain3);
    }//GEN-LAST:event_Grain3MouseClicked

    private void Malt3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Malt3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Malt3);
        intensidadTostado(Malt3);
    }//GEN-LAST:event_Malt3MouseClicked

    private void Pungent3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pungent3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Pungent3);
        intensidadEspecias(Pungent3);
    }//GEN-LAST:event_Pungent3MouseClicked

    private void Pepper3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pepper3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Pepper3);
        intensidadEspecias(Pepper3);
    }//GEN-LAST:event_Pepper3MouseClicked

    private void Brownspices3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Brownspices3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Brownspices3);
        intensidadEspecias(Brownspices3);
    }//GEN-LAST:event_Brownspices3MouseClicked

    private void Anise3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Anise3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Anise3);
        intensidadEspecias(Anise3);
    }//GEN-LAST:event_Anise3MouseClicked

    private void Nutmeg3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Nutmeg3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Nutmeg3);
        intensidadEspecias(Nutmeg3);
    }//GEN-LAST:event_Nutmeg3MouseClicked

    private void Cinnamon3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cinnamon3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Cinnamon3);
        intensidadEspecias(Cinnamon3);
    }//GEN-LAST:event_Cinnamon3MouseClicked

    private void Clove3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Clove3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Clove3);
        intensidadEspecias(Clove3);
    }//GEN-LAST:event_Clove3MouseClicked

    private void Nutty3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Nutty3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Nutty3);
        intensidadNC(Nutty3);
    }//GEN-LAST:event_Nutty3MouseClicked

    private void Peanuts3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Peanuts3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Peanuts3);
        intensidadNC(Peanuts3);
    }//GEN-LAST:event_Peanuts3MouseClicked

    private void Hazelenut3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Hazelenut3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Hazelenut3);
        intensidadNC(Hazelenut3);
    }//GEN-LAST:event_Hazelenut3MouseClicked

    private void Almond3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Almond3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Almond3);
        intensidadNC(Almond3);
    }//GEN-LAST:event_Almond3MouseClicked

    private void Cocoa3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cocoa3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Cocoa3);
        intensidadNC(Cocoa3);
    }//GEN-LAST:event_Cocoa3MouseClicked

    private void Chocolate3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chocolate3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(Chocolate3);
        intensidadNC(Chocolate3);
    }//GEN-LAST:event_Chocolate3MouseClicked

    private void DarkChocolate3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DarkChocolate3MouseClicked
        // TODO add your handling code here:
        intensidadSabor(DarkChocolate3);
        intensidadNC(DarkChocolate3);
    }//GEN-LAST:event_DarkChocolate3MouseClicked

    int cont = 0;
    Color original = new Color(255, 241, 144);

    public void guardar() {
        String fecha = null;
        if (calendario.getDate() != null) {
            fecha = new SimpleDateFormat("dd-MMM-yyyy").format(calendario.getDate());
        }
        int nt = 0;
        if (nt1.isSelected()) {
            nt = 1;
        }
        if (nt2.isSelected()) {
            nt = 2;
        }
        if (nt3.isSelected()) {
            nt = 3;
        }
        if (nt4.isSelected()) {
            nt = 4;
        }
        if (nt5.isSelected()) {
            nt = 5;
        }
        int dv = 0, wv = 0, bv = 0, fv = 0, av = 0, acv = 0, bov = 0;
        String d = " ", w = " ", b = " ", f = " ", a = " ", ac = " ", bo = " ", Flavors = " ";
        if (Sweet.isSelected()) {
            if (dv == 0) {
                d = d + Sweet.getText();
            } else {
                d = d + "," + Sweet.getText();
            }
            dv = 1;
        }
        if (Floral.isSelected()) {
            if (dv == 0) {
                d = d + Floral.getText();
            } else {
                d = d + "," + Floral.getText();
            }
            dv = 1;
        }
        if (Fruity.isSelected()) {
            if (dv == 0) {
                d = d + Fruity.getText();
            } else {
                d = d + "," + Fruity.getText();
            }
            dv = 1;
        }
        if (Berry.isSelected()) {
            if (dv == 0) {
                d = d + Berry.getText();
            } else {
                d = d + "," + Berry.getText();
            }
            dv = 1;
        }
        if (DriedFruit.isSelected()) {
            if (dv == 0) {
                d = d + DriedFruit.getText();
            } else {
                d = d + "," + DriedFruit.getText();
            }
            dv = 1;
        }
        if (Otherfruit.isSelected()) {
            if (dv == 0) {
                d = d + Otherfruit.getText();
            } else {
                d = d + "," + Otherfruit.getText();
            }
            dv = 1;
        }
        if (Citrusfruit.isSelected()) {
            if (dv == 0) {
                d = d + Citrusfruit.getText();
            } else {
                d = d + "," + Citrusfruit.getText();
            }
            dv = 1;
        }
        if (Sour.isSelected()) {
            if (dv == 0) {
                d = d + Sour.getText();
            } else {
                d = d + "," + Sour.getText();
            }
            dv = 1;
        }
        if (sour.isSelected()) {
            if (dv == 0) {
                d = d + sour.getText();
            } else {
                d = d + "," + sour.getText();
            }
            dv = 1;
        }
        if (Alcohol.isSelected()) {
            if (dv == 0) {
                d = d + Alcohol.getText();
            } else {
                d = d + "," + Alcohol.getText();
            }
            dv = 1;
        }
        if (Green.isSelected()) {
            if (dv == 0) {
                d = d + Green.getText();
            } else {
                d = d + "," + Green.getText();
            }
            dv = 1;
        }
        if (Other.isSelected()) {
            if (dv == 0) {
                d = d + Other.getText();
            } else {
                d = d + "," + Other.getText();
            }
            dv = 1;
        }
        if (PaperyM.isSelected()) {
            if (dv == 0) {
                d = d + PaperyM.getText();
            } else {
                d = d + "," + PaperyM.getText();
            }
            dv = 1;
        }
        if (Chemical.isSelected()) {
            if (dv == 0) {
                d = d + Chemical.getText();
            } else {
                d = d + "," + Chemical.getText();
            }
            dv = 1;
        }
        if (Roasted.isSelected()) {
            if (dv == 0) {
                d = d + Roasted.getText();
            } else {
                d = d + "," + Roasted.getText();
            }
            dv = 1;
        }
        if (Burnt.isSelected()) {
            if (dv == 0) {
                d = d + Burnt.getText();
            } else {
                d = d + "," + Burnt.getText();
            }
            dv = 1;
        }
        if (Cereal.isSelected()) {
            if (dv == 0) {
                d = d + Cereal.getText();
            } else {
                d = d + "," + Cereal.getText();
            }
            dv = 1;
        }
        if (Spices.isSelected()) {
            if (dv == 0) {
                d = d + Spices.getText();
            } else {
                d = d + "," + Spices.getText();
            }
            dv = 1;
        }
        if (Brownspices.isSelected()) {
            if (dv == 0) {
                d = d + Brownspices.getText();
            } else {
                d = d + "," + Brownspices.getText();
            }
            dv = 1;
        }
        if (Nuttycocoa.isSelected()) {
            if (dv == 0) {
                d = d + Nuttycocoa.getText();
            } else {
                d = d + "," + Nuttycocoa.getText();
            }
            dv = 1;
        }
        if (Cocoa.isSelected()) {
            if (dv == 0) {
                d = d + Cocoa.getText();
            } else {
                d = d + "," + Cocoa.getText();
            }
            dv = 1;
        }

        if (BrownSugar.isSelected()) {
            if (dv == 0) {
                d = d + BrownSugar.getText();
            } else {
                d = d + "," + BrownSugar.getText();
            }
            dv = 1;
        }
        if (Molasses.isSelected()) {
            if (dv == 0) {
                d = d + Molasses.getText();
            } else {
                d = d + "," + Molasses.getText();
            }
            dv = 1;
        }
        if (MapleSugar.isSelected()) {
            if (dv == 0) {
                d = d + MapleSugar.getText();
            } else {
                d = d + "," + MapleSugar.getText();
            }
            dv = 1;
        }
        if (Carmelized.isSelected()) {
            if (dv == 0) {
                d = d + Carmelized.getText();
            } else {
                d = d + "," + Carmelized.getText();
            }
            dv = 1;
        }
        if (Honey.isSelected()) {
            if (dv == 0) {
                d = d + Honey.getText();
            } else {
                d = d + "," + Honey.getText();
            }
            dv = 1;
        }
        if (Vanilla.isSelected()) {
            if (dv == 0) {
                d = d + Vanilla.getText();
            } else {
                d = d + "," + Vanilla.getText();
            }
            dv = 1;
        }

        if (Blacktea.isSelected()) {
            if (dv == 0) {
                d = d + Blacktea.getText();
            } else {
                d = d + "," + Blacktea.getText();
            }
            dv = 1;
        }

        if (Chamomile.isSelected()) {
            if (dv == 0) {
                d = d + Chamomile.getText();
            } else {
                d = d + "," + Chamomile.getText();
            }
            dv = 1;
        }
        if (Rose.isSelected()) {
            if (dv == 0) {
                d = d + Rose.getText();
            } else {
                d = d + "," + Rose.getText();
            }
            dv = 1;
        }
        if (Jasmine.isSelected()) {
            if (dv == 0) {
                d = d + Jasmine.getText();
            } else {
                d = d + "," + Jasmine.getText();
            }
            dv = 1;
        }

        if (Blackberry.isSelected()) {
            if (dv == 0) {
                d = d + Blackberry.getText();
            } else {
                d = d + "," + Blackberry.getText();
            }
            dv = 1;
        }
        if (Raspberry.isSelected()) {
            if (dv == 0) {
                d = d + Raspberry.getText();
            } else {
                d = d + "," + Raspberry.getText();
            }
            dv = 1;
        }
        if (Blueberry.isSelected()) {
            if (dv == 0) {
                d = d + Blueberry.getText();
            } else {
                d = d + "," + Blueberry.getText();
            }
            dv = 1;
        }
        if (Strawberry.isSelected()) {
            if (dv == 0) {
                d = d + Strawberry.getText();
            } else {
                d = d + "," + Strawberry.getText();
            }
            dv = 1;
        }
        if (Raisen.isSelected()) {
            if (dv == 0) {
                d = d + Raisen.getText();
            } else {
                d = d + "," + Raisen.getText();
            }
            dv = 1;
        }
        if (Prune.isSelected()) {
            if (dv == 0) {
                d = d + Prune.getText();
            } else {
                d = d + "," + Prune.getText();
            }
            dv = 1;
        }
        if (Coconut.isSelected()) {
            if (dv == 0) {
                d = d + Coconut.getText();
            } else {
                d = d + "," + Coconut.getText();
            }
            dv = 1;
        }
        if (Cherry.isSelected()) {
            if (dv == 0) {
                d = d + Cherry.getText();
            } else {
                d = d + "," + Cherry.getText();
            }
            dv = 1;
        }
        if (Pomagranite.isSelected()) {
            if (dv == 0) {
                d = d + Pomagranite.getText();
            } else {
                d = d + "," + Pomagranite.getText();
            }
            dv = 1;
        }
        if (Pinneapple.isSelected()) {
            if (dv == 0) {
                d = d + Pinneapple.getText();
            } else {
                d = d + "," + Pinneapple.getText();
            }
            dv = 1;
        }
        if (Grape.isSelected()) {
            if (dv == 0) {
                d = d + Grape.getText();
            } else {
                d = d + "," + Grape.getText();
            }
            dv = 1;
        }
        if (Apple.isSelected()) {
            if (dv == 0) {
                d = d + Apple.getText();
            } else {
                d = d + "," + Apple.getText();
            }
            dv = 1;
        }
        if (Peach.isSelected()) {
            if (dv == 0) {
                d = d + Peach.getText();
            } else {
                d = d + "," + Peach.getText();
            }
            dv = 1;
        }
        if (Pear.isSelected()) {
            if (dv == 0) {
                d = d + Pear.getText();
            } else {
                d = d + "," + Pear.getText();
            }
            dv = 1;
        }
        if (Grapefruit.isSelected()) {
            if (dv == 0) {
                d = d + Grapefruit.getText();
            } else {
                d = d + "," + Grapefruit.getText();
            }
            dv = 1;
        }
        if (Orange.isSelected()) {
            if (dv == 0) {
                d = d + Orange.getText();
            } else {
                d = d + "," + Orange.getText();
            }
            dv = 1;
        }
        if (Lemon.isSelected()) {
            if (dv == 0) {
                d = d + Lemon.getText();
            } else {
                d = d + "," + Lemon.getText();
            }
            dv = 1;
        }
        if (Lime.isSelected()) {
            if (dv == 0) {
                d = d + Lime.getText();
            } else {
                d = d + "," + Lime.getText();
            }
            dv = 1;
        }
        if (Vinegar.isSelected()) {
            if (dv == 0) {
                d = d + Vinegar.getText();
            } else {
                d = d + "," + Vinegar.getText();
            }
            dv = 1;
        }
        if (Rancidbutter.isSelected()) {
            if (dv == 0) {
                d = d + Rancidbutter.getText();
            } else {
                d = d + "," + Rancidbutter.getText();
            }
            dv = 1;
        }
        if (RancidCheese.isSelected()) {
            if (dv == 0) {
                d = d + RancidCheese.getText();
            } else {
                d = d + "," + RancidCheese.getText();
            }
            dv = 1;
        }
        if (OrangeAcidity.isSelected()) {
            if (dv == 0) {
                d = d + OrangeAcidity.getText();
            } else {
                d = d + "," + OrangeAcidity.getText();
            }
            dv = 1;
        }
        if (AppleAcidity.isSelected()) {
            if (dv == 0) {
                d = d + AppleAcidity.getText();
            } else {
                d = d + "," + AppleAcidity.getText();
            }
            dv = 1;
        }
        if (Winey.isSelected()) {
            if (dv == 0) {
                d = d + Winey.getText();
            } else {
                d = d + "," + Winey.getText();
            }
            dv = 1;
        }
        if (Whiskey.isSelected()) {
            if (dv == 0) {
                d = d + Whiskey.getText();
            } else {
                d = d + "," + Whiskey.getText();
            }
            dv = 1;
        }
        if (Fermented.isSelected()) {
            if (dv == 0) {
                d = d + Fermented.getText();
            } else {
                d = d + "," + Fermented.getText();
            }
            dv = 1;
        }
        if (Overripe.isSelected()) {
            if (dv == 0) {
                d = d + Overripe.getText();
            } else {
                d = d + "," + Overripe.getText();
            }
            dv = 1;
        }
        if (OliveOil.isSelected()) {
            if (dv == 0) {
                d = d + OliveOil.getText();
            } else {
                d = d + "," + OliveOil.getText();
            }
            dv = 1;
        }
        if (Raw.isSelected()) {
            if (dv == 0) {
                d = d + Raw.getText();
            } else {
                d = d + "," + Raw.getText();
            }
            dv = 1;
        }
        if (Underripe.isSelected()) {
            if (dv == 0) {
                d = d + Underripe.getText();
            } else {
                d = d + "," + Underripe.getText();
            }
            dv = 1;
        }
        if (Peapod.isSelected()) {
            if (dv == 0) {
                d = d + Peapod.getText();
            } else {
                d = d + "," + Peapod.getText();
            }
            dv = 1;
        }
        if (Fresh.isSelected()) {
            if (dv == 0) {
                d = d + Fresh.getText();
            } else {
                d = d + "," + Fresh.getText();
            }
            dv = 1;
        }
        if (DarkGreen.isSelected()) {
            if (dv == 0) {
                d = d + DarkGreen.getText();
            } else {
                d = d + "," + DarkGreen.getText();
            }
            dv = 1;
        }
        if (Vegetative.isSelected()) {
            if (dv == 0) {
                d = d + Vegetative.getText();
            } else {
                d = d + "," + Vegetative.getText();
            }
            dv = 1;
        }
        if (Haylike.isSelected()) {
            if (dv == 0) {
                d = d + Haylike.getText();
            } else {
                d = d + "," + Haylike.getText();
            }
            dv = 1;
        }
        if (Herblike.isSelected()) {
            if (dv == 0) {
                d = d + Herblike.getText();
            } else {
                d = d + "," + Herblike.getText();
            }
            dv = 1;
        }
        if (Beany.isSelected()) {
            if (dv == 0) {
                d = d + Beany.getText();
            } else {
                d = d + "," + Beany.getText();
            }
            dv = 1;
        }
        if (Stale.isSelected()) {
            if (dv == 0) {
                d = d + Stale.getText();
            } else {
                d = d + "," + Stale.getText();
            }
            dv = 1;
        }
        if (Cardboard.isSelected()) {
            if (dv == 0) {
                d = d + Cardboard.getText();
            } else {
                d = d + "," + Cardboard.getText();
            }
            dv = 1;
        }
        if (Papery.isSelected()) {
            if (dv == 0) {
                d = d + Papery.getText();
            } else {
                d = d + "," + Papery.getText();
            }
            dv = 1;
        }
        if (Woody.isSelected()) {
            if (dv == 0) {
                d = d + Woody.getText();
            } else {
                d = d + "," + Woody.getText();
            }
            dv = 1;
        }
        if (MoldyDamp.isSelected()) {
            if (dv == 0) {
                d = d + MoldyDamp.getText();
            } else {
                d = d + "," + MoldyDamp.getText();
            }
            dv = 1;
        }
        if (MustyDusty.isSelected()) {
            if (dv == 0) {
                d = d + MustyDusty.getText();
            } else {
                d = d + "," + MustyDusty.getText();
            }
            dv = 1;
        }
        if (MustyEarthy.isSelected()) {
            if (dv == 0) {
                d = d + MustyEarthy.getText();
            } else {
                d = d + "," + MustyEarthy.getText();
            }
            dv = 1;
        }
        if (Animalic.isSelected()) {
            if (dv == 0) {
                d = d + Animalic.getText();
            } else {
                d = d + "," + Animalic.getText();
            }
            dv = 1;
        }
        if (MeatyBrothy.isSelected()) {
            if (dv == 0) {
                d = d + MeatyBrothy.getText();
            } else {
                d = d + "," + MeatyBrothy.getText();
            }
            dv = 1;
        }
        if (Phenolic.isSelected()) {
            if (dv == 0) {
                d = d + Phenolic.getText();
            } else {
                d = d + "," + Phenolic.getText();
            }
            dv = 1;
        }
        if (Bitter.isSelected()) {
            if (dv == 0) {
                d = d + Bitter.getText();
            } else {
                d = d + "," + Bitter.getText();
            }
            dv = 1;
        }
        if (Salty.isSelected()) {
            if (dv == 0) {
                d = d + Salty.getText();
            } else {
                d = d + "," + Salty.getText();
            }
            dv = 1;
        }
        if (Medicinal.isSelected()) {
            if (dv == 0) {
                d = d + Medicinal.getText();
            } else {
                d = d + "," + Medicinal.getText();
            }
            dv = 1;
        }
        if (Petroleum.isSelected()) {
            if (dv == 0) {
                d = d + Petroleum.getText();
            } else {
                d = d + "," + Petroleum.getText();
            }
            dv = 1;
        }
        if (Skunky.isSelected()) {
            if (dv == 0) {
                d = d + Skunky.getText();
            } else {
                d = d + "," + Skunky.getText();
            }
            dv = 1;
        }
        if (Rubber.isSelected()) {
            if (dv == 0) {
                d = d + Rubber.getText();
            } else {
                d = d + "," + Rubber.getText();
            }
            dv = 1;
        }
        if (PipeTobacco.isSelected()) {
            if (dv == 0) {
                d = d + PipeTobacco.getText();
            } else {
                d = d + "," + PipeTobacco.getText();
            }
            dv = 1;
        }
        if (Tobacco.isSelected()) {
            if (dv == 0) {
                d = d + Tobacco.getText();
            } else {
                d = d + "," + Tobacco.getText();
            }
            dv = 1;
        }
        if (Acrid.isSelected()) {
            if (dv == 0) {
                d = d + Acrid.getText();
            } else {
                d = d + "," + Acrid.getText();
            }
            dv = 1;
        }
        if (Ashy.isSelected()) {
            if (dv == 0) {
                d = d + Ashy.getText();
            } else {
                d = d + "," + Ashy.getText();
            }
            dv = 1;
        }
        if (Smoky.isSelected()) {
            if (dv == 0) {
                d = d + Smoky.getText();
            } else {
                d = d + "," + Smoky.getText();
            }
            dv = 1;
        }
        if (BrownRoast.isSelected()) {
            if (dv == 0) {
                d = d + BrownRoast.getText();
            } else {
                d = d + "," + BrownRoast.getText();
            }
            dv = 1;
        }
        if (Grain.isSelected()) {
            if (dv == 0) {
                d = d + Grain.getText();
            } else {
                d = d + "," + Grain.getText();
            }
            dv = 1;
        }
        if (Malt.isSelected()) {
            if (dv == 0) {
                d = d + Malt.getText();
            } else {
                d = d + "," + Malt.getText();
            }
            dv = 1;
        }
        if (Pungent.isSelected()) {
            if (dv == 0) {
                d = d + Pungent.getText();
            } else {
                d = d + "," + Pungent.getText();
            }
            dv = 1;
        }
        if (Pepper.isSelected()) {
            if (dv == 0) {
                d = d + Pepper.getText();
            } else {
                d = d + "," + Pepper.getText();
            }
            dv = 1;
        }
        if (Anise.isSelected()) {
            if (dv == 0) {
                d = d + Anise.getText();
            } else {
                d = d + "," + Anise.getText();
            }
            dv = 1;
        }
        if (Nutmeg.isSelected()) {
            if (dv == 0) {
                d = d + Nutmeg.getText();
            } else {
                d = d + "," + Nutmeg.getText();
            }
            dv = 1;
        }
        if (Cinnamon.isSelected()) {
            if (dv == 0) {
                d = d + Cinnamon.getText();
            } else {
                d = d + "," + Cinnamon.getText();
            }
            dv = 1;
        }
        if (Clove.isSelected()) {
            if (dv == 0) {
                d = d + Clove.getText();
            } else {
                d = d + "," + Clove.getText();
            }
            dv = 1;
        }
        if (Nutty.isSelected()) {
            if (dv == 0) {
                d = d + Nutty.getText();
            } else {
                d = d + "," + Nutty.getText();
            }
            dv = 1;
        }
        if (Peanuts.isSelected()) {
            if (dv == 0) {
                d = d + Peanuts.getText();
            } else {
                d = d + "," + Peanuts.getText();
            }
            dv = 1;
        }
        if (Hazelenut.isSelected()) {
            if (dv == 0) {
                d = d + Hazelenut.getText();
            } else {
                d = d + "," + Hazelenut.getText();
            }
            dv = 1;
        }
        if (Almond.isSelected()) {
            if (dv == 0) {
                d = d + Almond.getText();
            } else {
                d = d + "," + Almond.getText();
            }
            dv = 1;
        }
        if (Chocolate.isSelected()) {
            if (dv == 0) {
                d = d + Chocolate.getText();
            } else {
                d = d + "," + Chocolate.getText();
            }
            dv = 1;
        }
        if (DarkChocolate.isSelected()) {
            if (dv == 0) {
                d = d + DarkChocolate.getText();
            } else {
                d = d + "," + DarkChocolate.getText();
            }
            dv = 1;
        }
        if (dv != 2) {
            d = "Dry:" + d + ";";
        }
        if (Sweet1.isSelected()) {
            if (wv == 0) {
                w = w + Sweet1.getText();
            } else {
                w = w + "," + Sweet1.getText();
            }
            wv = 1;
        }
        if (Floral1.isSelected()) {
            if (wv == 0) {
                w = w + Floral1.getText();
            } else {
                w = w + "," + Floral1.getText();
            }
            wv = 1;
        }
        if (Fruity1.isSelected()) {
            if (wv == 0) {
                w = w + Fruity1.getText();
            } else {
                w = w + "," + Fruity1.getText();
            }
            wv = 1;
        }
        if (Berry1.isSelected()) {
            if (wv == 0) {
                w = w + Berry1.getText();
            } else {
                w = w + "," + Berry1.getText();
            }
            wv = 1;
        }
        if (DriedFruit1.isSelected()) {
            if (wv == 0) {
                w = w + DriedFruit1.getText();
            } else {
                w = w + "," + DriedFruit1.getText();
            }
            wv = 1;
        }
        if (Otherfruit1.isSelected()) {
            if (wv == 0) {
                w = w + Otherfruit1.getText();
            } else {
                w = w + "," + Otherfruit1.getText();
            }
            wv = 1;
        }
        if (Citrusfruit1.isSelected()) {
            if (wv == 0) {
                w = w + Citrusfruit1.getText();
            } else {
                w = w + "," + Citrusfruit1.getText();
            }
            wv = 1;
        }
        if (Sour1.isSelected()) {
            if (wv == 0) {
                w = w + Sour1.getText();
            } else {
                w = w + "," + Sour1.getText();
            }
            wv = 1;
        }
        if (sour1.isSelected()) {
            if (wv == 0) {
                w = w + sour1.getText();
            } else {
                w = w + "," + sour1.getText();
            }
            wv = 1;
        }
        if (Alcohol1.isSelected()) {
            if (wv == 0) {
                w = w + Alcohol1.getText();
            } else {
                w = w + "," + Alcohol1.getText();
            }
            wv = 1;
        }
        if (Green1.isSelected()) {
            if (wv == 0) {
                w = w + Green1.getText();
            } else {
                w = w + "," + Green1.getText();
            }
            wv = 1;
        }
        if (Other1.isSelected()) {
            if (wv == 0) {
                w = w + Other1.getText();
            } else {
                w = w + "," + Other1.getText();
            }
            wv = 1;
        }
        if (PaperyM1.isSelected()) {
            if (wv == 0) {
                w = w + PaperyM1.getText();
            } else {
                w = w + "," + PaperyM1.getText();
            }
            wv = 1;
        }
        if (Chemical1.isSelected()) {
            if (wv == 0) {
                w = w + Chemical1.getText();
            } else {
                w = w + "," + Chemical1.getText();
            }
            wv = 1;
        }
        if (Roasted1.isSelected()) {
            if (wv == 0) {
                w = w + Roasted1.getText();
            } else {
                w = w + "," + Roasted1.getText();
            }
            wv = 1;
        }
        if (Burnt1.isSelected()) {
            if (wv == 0) {
                w = w + Burnt1.getText();
            } else {
                w = w + "," + Burnt1.getText();
            }
            wv = 1;
        }
        if (Cereal1.isSelected()) {
            if (wv == 0) {
                w = w + Cereal1.getText();
            } else {
                w = w + "," + Cereal1.getText();
            }
            wv = 1;
        }
        if (Spices1.isSelected()) {
            if (wv == 0) {
                w = w + Spices1.getText();
            } else {
                w = w + "," + Spices1.getText();
            }
            wv = 1;
        }
        if (Brownspices1.isSelected()) {
            if (wv == 0) {
                w = w + Brownspices1.getText();
            } else {
                w = w + "," + Brownspices1.getText();
            }
            wv = 1;
        }
        if (Nuttycocoa1.isSelected()) {
            if (wv == 0) {
                w = w + Nuttycocoa1.getText();
            } else {
                w = w + "," + Nuttycocoa1.getText();
            }
            wv = 1;
        }
        if (Cocoa1.isSelected()) {
            if (wv == 0) {
                w = w + Cocoa1.getText();
            } else {
                w = w + "," + Cocoa1.getText();
            }
            wv = 1;
        }

        if (BrownSugar1.isSelected()) {
            if (wv == 0) {
                w = w + BrownSugar1.getText();
            } else {
                w = w + "," + BrownSugar1.getText();
            }
            wv = 1;
        }
        if (Molasses1.isSelected()) {
            if (wv == 0) {
                w = w + Molasses1.getText();
            } else {
                w = w + "," + Molasses1.getText();
            }
            wv = 1;
        }
        if (MapleSugar1.isSelected()) {
            if (wv == 0) {
                w = w + MapleSugar1.getText();
            } else {
                w = w + "," + MapleSugar1.getText();
            }
            wv = 1;
        }
        if (Carmelized1.isSelected()) {
            if (wv == 0) {
                w = w + Carmelized1.getText();
            } else {
                w = w + "," + Carmelized1.getText();
            }
            wv = 1;
        }
        if (Honey1.isSelected()) {
            if (wv == 0) {
                w = w + Honey1.getText();
            } else {
                w = w + "," + Honey1.getText();
            }
            wv = 1;
        }
        if (Vanilla1.isSelected()) {
            if (wv == 0) {
                w = w + Vanilla1.getText();
            } else {
                w = w + "," + Vanilla1.getText();
            }
            wv = 1;
        }

        if (Blacktea1.isSelected()) {
            if (wv == 0) {
                w = w + Blacktea1.getText();
            } else {
                w = w + "," + Blacktea1.getText();
            }
            wv = 1;
        }

        if (Chamomile1.isSelected()) {
            if (wv == 0) {
                w = w + Chamomile1.getText();
            } else {
                w = w + "," + Chamomile1.getText();
            }
            wv = 1;
        }
        if (Rose1.isSelected()) {
            if (wv == 0) {
                w = w + Rose1.getText();
            } else {
                w = w + "," + Rose1.getText();
            }
            wv = 1;
        }
        if (Jasmine1.isSelected()) {
            if (wv == 0) {
                w = w + Jasmine1.getText();
            } else {
                w = w + "," + Jasmine1.getText();
            }
            wv = 1;
        }

        if (Blackberry1.isSelected()) {
            if (wv == 0) {
                w = w + Blackberry1.getText();
            } else {
                w = w + "," + Blackberry1.getText();
            }
            wv = 1;
        }
        if (Raspberry1.isSelected()) {
            if (wv == 0) {
                w = w + Raspberry1.getText();
            } else {
                w = w + "," + Raspberry1.getText();
            }
            wv = 1;
        }
        if (Blueberry1.isSelected()) {
            if (wv == 0) {
                w = w + Blueberry1.getText();
            } else {
                w = w + "," + Blueberry1.getText();
            }
            wv = 1;
        }
        if (Strawberry1.isSelected()) {
            if (wv == 0) {
                w = w + Strawberry1.getText();
            } else {
                w = w + "," + Strawberry1.getText();
            }
            wv = 1;
        }
        if (Raisen1.isSelected()) {
            if (wv == 0) {
                w = w + Raisen1.getText();
            } else {
                w = w + "," + Raisen1.getText();
            }
            wv = 1;
        }
        if (Prune1.isSelected()) {
            if (wv == 0) {
                w = w + Prune1.getText();
            } else {
                w = w + "," + Prune1.getText();
            }
            wv = 1;
        }
        if (Coconut1.isSelected()) {
            if (wv == 0) {
                w = w + Coconut1.getText();
            } else {
                w = w + "," + Coconut1.getText();
            }
            wv = 1;
        }
        if (Cherry1.isSelected()) {
            if (wv == 0) {
                w = w + Cherry1.getText();
            } else {
                w = w + "," + Cherry1.getText();
            }
            wv = 1;
        }
        if (Pomagranite1.isSelected()) {
            if (wv == 0) {
                w = w + Pomagranite1.getText();
            } else {
                w = w + "," + Pomagranite1.getText();
            }
            wv = 1;
        }
        if (Pinneapple1.isSelected()) {
            if (wv == 0) {
                w = w + Pinneapple1.getText();
            } else {
                w = w + "," + Pinneapple1.getText();
            }
            wv = 1;
        }
        if (Grape1.isSelected()) {
            if (wv == 0) {
                w = w + Grape1.getText();
            } else {
                w = w + "," + Grape1.getText();
            }
            wv = 1;
        }
        if (Apple1.isSelected()) {
            if (wv == 0) {
                w = w + Apple1.getText();
            } else {
                w = w + "," + Apple1.getText();
            }
            wv = 1;
        }
        if (Peach1.isSelected()) {
            if (wv == 0) {
                w = w + Peach1.getText();
            } else {
                w = w + "," + Peach1.getText();
            }
            wv = 1;
        }
        if (Pear1.isSelected()) {
            if (wv == 0) {
                w = w + Pear1.getText();
            } else {
                w = w + "," + Pear1.getText();
            }
            wv = 1;
        }
        if (Grapefruit1.isSelected()) {
            if (wv == 0) {
                w = w + Grapefruit1.getText();
            } else {
                w = w + "," + Grapefruit1.getText();
            }
            wv = 1;
        }
        if (Orange1.isSelected()) {
            if (wv == 0) {
                w = w + Orange1.getText();
            } else {
                w = w + "," + Orange1.getText();
            }
            wv = 1;
        }
        if (Lemon1.isSelected()) {
            if (wv == 0) {
                w = w + Lemon1.getText();
            } else {
                w = w + "," + Lemon1.getText();
            }
            wv = 1;
        }
        if (Lime1.isSelected()) {
            if (wv == 0) {
                w = w + Lime1.getText();
            } else {
                w = w + "," + Lime1.getText();
            }
            wv = 1;
        }
        if (Vinegar1.isSelected()) {
            if (wv == 0) {
                w = w + Vinegar1.getText();
            } else {
                w = w + "," + Vinegar1.getText();
            }
            wv = 1;
        }
        if (Rancidbutter1.isSelected()) {
            if (wv == 0) {
                w = w + Rancidbutter1.getText();
            } else {
                w = w + "," + Rancidbutter1.getText();
            }
            wv = 1;
        }
        if (RancidCheese1.isSelected()) {
            if (wv == 0) {
                w = w + RancidCheese1.getText();
            } else {
                w = w + "," + RancidCheese1.getText();
            }
            wv = 1;
        }
        if (OrangeAcidity1.isSelected()) {
            if (wv == 0) {
                w = w + OrangeAcidity1.getText();
            } else {
                w = w + "," + OrangeAcidity1.getText();
            }
            wv = 1;
        }
        if (AppleAcidity1.isSelected()) {
            if (wv == 0) {
                w = w + AppleAcidity1.getText();
            } else {
                w = w + "," + AppleAcidity1.getText();
            }
            wv = 1;
        }
        if (Winey1.isSelected()) {
            if (wv == 0) {
                w = w + Winey1.getText();
            } else {
                w = w + "," + Winey1.getText();
            }
            wv = 1;
        }
        if (Whiskey1.isSelected()) {
            if (wv == 0) {
                w = w + Whiskey1.getText();
            } else {
                w = w + "," + Whiskey1.getText();
            }
            wv = 1;
        }
        if (Fermented1.isSelected()) {
            if (wv == 0) {
                w = w + Fermented1.getText();
            } else {
                w = w + "," + Fermented1.getText();
            }
            wv = 1;
        }
        if (Overripe1.isSelected()) {
            if (wv == 0) {
                w = w + Overripe1.getText();
            } else {
                w = w + "," + Overripe1.getText();
            }
            wv = 1;
        }
        if (OliveOil1.isSelected()) {
            if (wv == 0) {
                w = w + OliveOil1.getText();
            } else {
                w = w + "," + OliveOil1.getText();
            }
            wv = 1;
        }
        if (Raw1.isSelected()) {
            if (wv == 0) {
                w = w + Raw1.getText();
            } else {
                w = w + "," + Raw1.getText();
            }
            wv = 1;
        }
        if (Underripe1.isSelected()) {
            if (wv == 0) {
                w = w + Underripe1.getText();
            } else {
                w = w + "," + Underripe1.getText();
            }
            wv = 1;
        }
        if (Peapod1.isSelected()) {
            if (wv == 0) {
                w = w + Peapod1.getText();
            } else {
                w = w + "," + Peapod1.getText();
            }
            wv = 1;
        }
        if (Fresh1.isSelected()) {
            if (wv == 0) {
                w = w + Fresh1.getText();
            } else {
                w = w + "," + Fresh1.getText();
            }
            wv = 1;
        }
        if (DarkGreen1.isSelected()) {
            if (wv == 0) {
                w = w + DarkGreen1.getText();
            } else {
                w = w + "," + DarkGreen1.getText();
            }
            wv = 1;
        }
        if (Vegetative1.isSelected()) {
            if (wv == 0) {
                w = w + Vegetative1.getText();
            } else {
                w = w + "," + Vegetative1.getText();
            }
            wv = 1;
        }
        if (Haylike1.isSelected()) {
            if (wv == 0) {
                w = w + Haylike1.getText();
            } else {
                w = w + "," + Haylike1.getText();
            }
            wv = 1;
        }
        if (Herblike1.isSelected()) {
            if (wv == 0) {
                w = w + Herblike1.getText();
            } else {
                w = w + "," + Herblike1.getText();
            }
            wv = 1;
        }
        if (Beany1.isSelected()) {
            if (wv == 0) {
                w = w + Beany1.getText();
            } else {
                w = w + "," + Beany1.getText();
            }
            wv = 1;
        }
        if (Stale1.isSelected()) {
            if (wv == 0) {
                w = w + Stale1.getText();
            } else {
                w = w + "," + Stale1.getText();
            }
            wv = 1;
        }
        if (Cardboard1.isSelected()) {
            if (wv == 0) {
                w = w + Cardboard1.getText();
            } else {
                w = w + "," + Cardboard1.getText();
            }
            wv = 1;
        }
        if (Papery1.isSelected()) {
            if (wv == 0) {
                w = w + Papery1.getText();
            } else {
                w = w + "," + Papery1.getText();
            }
            wv = 1;
        }
        if (Woody1.isSelected()) {
            if (wv == 0) {
                w = w + Woody1.getText();
            } else {
                w = w + "," + Woody1.getText();
            }
            wv = 1;
        }
        if (MoldyDamp1.isSelected()) {
            if (wv == 0) {
                w = w + MoldyDamp1.getText();
            } else {
                w = w + "," + MoldyDamp1.getText();
            }
            wv = 1;
        }
        if (MustyDusty1.isSelected()) {
            if (wv == 0) {
                w = w + MustyDusty1.getText();
            } else {
                w = w + "," + MustyDusty1.getText();
            }
            wv = 1;
        }
        if (MustyEarthy1.isSelected()) {
            if (wv == 0) {
                w = w + MustyEarthy1.getText();
            } else {
                w = w + "," + MustyEarthy1.getText();
            }
            wv = 1;
        }
        if (Animalic1.isSelected()) {
            if (wv == 0) {
                w = w + Animalic1.getText();
            } else {
                w = w + "," + Animalic1.getText();
            }
            wv = 1;
        }
        if (MeatyBrothy1.isSelected()) {
            if (wv == 0) {
                w = w + MeatyBrothy1.getText();
            } else {
                w = w + "," + MeatyBrothy1.getText();
            }
            wv = 1;
        }
        if (Phenolic1.isSelected()) {
            if (wv == 0) {
                w = w + Phenolic1.getText();
            } else {
                w = w + "," + Phenolic1.getText();
            }
            wv = 1;
        }
        if (Bitter1.isSelected()) {
            if (wv == 0) {
                w = w + Bitter1.getText();
            } else {
                w = w + "," + Bitter1.getText();
            }
            wv = 1;
        }
        if (Salty1.isSelected()) {
            if (wv == 0) {
                w = w + Salty1.getText();
            } else {
                w = w + "," + Salty1.getText();
            }
            wv = 1;
        }
        if (Medicinal1.isSelected()) {
            if (wv == 0) {
                w = w + Medicinal1.getText();
            } else {
                w = w + "," + Medicinal1.getText();
            }
            wv = 1;
        }
        if (Petroleum1.isSelected()) {
            if (wv == 0) {
                w = w + Petroleum1.getText();
            } else {
                w = w + "," + Petroleum1.getText();
            }
            wv = 1;
        }
        if (Skunky1.isSelected()) {
            if (wv == 0) {
                w = w + Skunky1.getText();
            } else {
                w = w + "," + Skunky1.getText();
            }
            wv = 1;
        }
        if (Rubber1.isSelected()) {
            if (wv == 0) {
                w = w + Rubber1.getText();
            } else {
                w = w + "," + Rubber1.getText();
            }
            wv = 1;
        }
        if (PipeTobacco1.isSelected()) {
            if (wv == 0) {
                w = w + PipeTobacco1.getText();
            } else {
                w = w + "," + PipeTobacco1.getText();
            }
            wv = 1;
        }
        if (Tobacco1.isSelected()) {
            if (wv == 0) {
                w = w + Tobacco1.getText();
            } else {
                w = w + "," + Tobacco1.getText();
            }
            wv = 1;
        }
        if (Acrid1.isSelected()) {
            if (wv == 0) {
                w = w + Acrid1.getText();
            } else {
                w = w + "," + Acrid1.getText();
            }
            wv = 1;
        }
        if (Ashy1.isSelected()) {
            if (wv == 0) {
                w = w + Ashy1.getText();
            } else {
                w = w + "," + Ashy1.getText();
            }
            wv = 1;
        }
        if (Smoky1.isSelected()) {
            if (wv == 0) {
                w = w + Smoky1.getText();
            } else {
                w = w + "," + Smoky1.getText();
            }
            wv = 1;
        }
        if (BrownRoast1.isSelected()) {
            if (wv == 0) {
                w = w + BrownRoast1.getText();
            } else {
                w = w + "," + BrownRoast1.getText();
            }
            wv = 1;
        }
        if (Grain1.isSelected()) {
            if (wv == 0) {
                w = w + Grain1.getText();
            } else {
                w = w + "," + Grain1.getText();
            }
            wv = 1;
        }
        if (Malt1.isSelected()) {
            if (wv == 0) {
                w = w + Malt1.getText();
            } else {
                w = w + "," + Malt1.getText();
            }
            wv = 1;
        }
        if (Pungent1.isSelected()) {
            if (wv == 0) {
                w = w + Pungent1.getText();
            } else {
                w = w + "," + Pungent1.getText();
            }
            wv = 1;
        }
        if (Pepper1.isSelected()) {
            if (wv == 0) {
                w = w + Pepper1.getText();
            } else {
                w = w + "," + Pepper1.getText();
            }
            wv = 1;
        }
        if (Anise1.isSelected()) {
            if (wv == 0) {
                w = w + Anise1.getText();
            } else {
                w = w + "," + Anise1.getText();
            }
            wv = 1;
        }
        if (Nutmeg1.isSelected()) {
            if (wv == 0) {
                w = w + Nutmeg1.getText();
            } else {
                w = w + "," + Nutmeg1.getText();
            }
            wv = 1;
        }
        if (Cinnamon1.isSelected()) {
            if (wv == 0) {
                w = w + Cinnamon1.getText();
            } else {
                w = w + "," + Cinnamon1.getText();
            }
            wv = 1;
        }
        if (Clove1.isSelected()) {
            if (wv == 0) {
                w = w + Clove1.getText();
            } else {
                w = w + "," + Clove1.getText();
            }
            wv = 1;
        }
        if (Nutty1.isSelected()) {
            if (wv == 0) {
                w = w + Nutty1.getText();
            } else {
                w = w + "," + Nutty1.getText();
            }
            wv = 1;
        }
        if (Peanuts1.isSelected()) {
            if (wv == 0) {
                w = w + Peanuts1.getText();
            } else {
                w = w + "," + Peanuts1.getText();
            }
            wv = 1;
        }
        if (Hazelenut1.isSelected()) {
            if (wv == 0) {
                w = w + Hazelenut1.getText();
            } else {
                w = w + "," + Hazelenut1.getText();
            }
            wv = 1;
        }
        if (Almond1.isSelected()) {
            if (wv == 0) {
                w = w + Almond1.getText();
            } else {
                w = w + "," + Almond1.getText();
            }
            wv = 1;
        }
        if (Chocolate1.isSelected()) {
            if (wv == 0) {
                w = w + Chocolate1.getText();
            } else {
                w = w + "," + Chocolate1.getText();
            }
            wv = 1;
        }
        if (DarkChocolate1.isSelected()) {
            if (wv == 0) {
                w = w + DarkChocolate1.getText();
            } else {
                w = w + "," + DarkChocolate1.getText();
            }
            wv = 1;
        }
        if (wv != 2) {
            w = "Wet:" + w + ";";
        }
        if (Sweet2.isSelected()) {
            if (bv == 0) {
                b = b + Sweet2.getText();
            } else {
                b = b + "," + Sweet2.getText();
            }
            bv = 2;
        }
        if (Floral2.isSelected()) {
            if (bv == 0) {
                b = b + Floral2.getText();
            } else {
                b = b + "," + Floral2.getText();
            }
            bv = 2;
        }
        if (Fruity2.isSelected()) {
            if (bv == 0) {
                b = b + Fruity2.getText();
            } else {
                b = b + "," + Fruity2.getText();
            }
            bv = 2;
        }
        if (Berry2.isSelected()) {
            if (bv == 0) {
                b = b + Berry2.getText();
            } else {
                b = b + "," + Berry2.getText();
            }
            bv = 2;
        }
        if (DriedFruit2.isSelected()) {
            if (bv == 0) {
                b = b + DriedFruit2.getText();
            } else {
                b = b + "," + DriedFruit2.getText();
            }
            bv = 2;
        }
        if (Otherfruit2.isSelected()) {
            if (bv == 0) {
                b = b + Otherfruit2.getText();
            } else {
                b = b + "," + Otherfruit2.getText();
            }
            bv = 2;
        }
        if (Citrusfruit2.isSelected()) {
            if (bv == 0) {
                b = b + Citrusfruit2.getText();
            } else {
                b = b + "," + Citrusfruit2.getText();
            }
            bv = 2;
        }
        if (Sour2.isSelected()) {
            if (bv == 0) {
                b = b + Sour2.getText();
            } else {
                b = b + "," + Sour2.getText();
            }
            bv = 2;
        }
        if (sour2.isSelected()) {
            if (bv == 0) {
                b = b + sour2.getText();
            } else {
                b = b + "," + sour2.getText();
            }
            bv = 2;
        }
        if (Alcohol2.isSelected()) {
            if (bv == 0) {
                b = b + Alcohol2.getText();
            } else {
                b = b + "," + Alcohol2.getText();
            }
            bv = 2;
        }
        if (Green2.isSelected()) {
            if (bv == 0) {
                b = b + Green2.getText();
            } else {
                b = b + "," + Green2.getText();
            }
            bv = 2;
        }
        if (Other2.isSelected()) {
            if (bv == 0) {
                b = b + Other2.getText();
            } else {
                b = b + "," + Other2.getText();
            }
            bv = 2;
        }
        if (PaperyM2.isSelected()) {
            if (bv == 0) {
                b = b + PaperyM2.getText();
            } else {
                b = b + "," + PaperyM2.getText();
            }
            bv = 2;
        }
        if (Chemical2.isSelected()) {
            if (bv == 0) {
                b = b + Chemical2.getText();
            } else {
                b = b + "," + Chemical2.getText();
            }
            bv = 2;
        }
        if (Roasted2.isSelected()) {
            if (bv == 0) {
                b = b + Roasted2.getText();
            } else {
                b = b + "," + Roasted2.getText();
            }
            bv = 2;
        }
        if (Burnt2.isSelected()) {
            if (bv == 0) {
                b = b + Burnt2.getText();
            } else {
                b = b + "," + Burnt2.getText();
            }
            bv = 2;
        }
        if (Cereal2.isSelected()) {
            if (bv == 0) {
                b = b + Cereal2.getText();
            } else {
                b = b + "," + Cereal2.getText();
            }
            bv = 2;
        }
        if (Spices2.isSelected()) {
            if (bv == 0) {
                b = b + Spices2.getText();
            } else {
                b = b + "," + Spices2.getText();
            }
            bv = 2;
        }
        if (Brownspices2.isSelected()) {
            if (bv == 0) {
                b = b + Brownspices2.getText();
            } else {
                b = b + "," + Brownspices2.getText();
            }
            bv = 2;
        }
        if (Nuttycocoa2.isSelected()) {
            if (bv == 0) {
                b = b + Nuttycocoa2.getText();
            } else {
                b = b + "," + Nuttycocoa2.getText();
            }
            bv = 2;
        }
        if (Cocoa2.isSelected()) {
            if (bv == 0) {
                b = b + Cocoa2.getText();
            } else {
                b = b + "," + Cocoa2.getText();
            }
            bv = 2;
        }

        if (BrownSugar2.isSelected()) {
            if (bv == 0) {
                b = b + BrownSugar2.getText();
            } else {
                b = b + "," + BrownSugar2.getText();
            }
            bv = 2;
        }
        if (Molasses2.isSelected()) {
            if (bv == 0) {
                b = b + Molasses2.getText();
            } else {
                b = b + "," + Molasses2.getText();
            }
            bv = 2;
        }
        if (MapleSugar2.isSelected()) {
            if (bv == 0) {
                b = b + MapleSugar2.getText();
            } else {
                b = b + "," + MapleSugar2.getText();
            }
            bv = 2;
        }
        if (Carmelized2.isSelected()) {
            if (bv == 0) {
                b = b + Carmelized2.getText();
            } else {
                b = b + "," + Carmelized2.getText();
            }
            bv = 2;
        }
        if (Honey2.isSelected()) {
            if (bv == 0) {
                b = b + Honey2.getText();
            } else {
                b = b + "," + Honey2.getText();
            }
            bv = 2;
        }
        if (Vanilla2.isSelected()) {
            if (bv == 0) {
                b = b + Vanilla2.getText();
            } else {
                b = b + "," + Vanilla2.getText();
            }
            bv = 2;
        }

        if (Blacktea2.isSelected()) {
            if (bv == 0) {
                b = b + Blacktea2.getText();
            } else {
                b = b + "," + Blacktea2.getText();
            }
            bv = 2;
        }

        if (Chamomile2.isSelected()) {
            if (bv == 0) {
                b = b + Chamomile2.getText();
            } else {
                b = b + "," + Chamomile2.getText();
            }
            bv = 2;
        }
        if (Rose2.isSelected()) {
            if (bv == 0) {
                b = b + Rose2.getText();
            } else {
                b = b + "," + Rose2.getText();
            }
            bv = 2;
        }
        if (Jasmine2.isSelected()) {
            if (bv == 0) {
                b = b + Jasmine2.getText();
            } else {
                b = b + "," + Jasmine2.getText();
            }
            bv = 2;
        }

        if (Blackberry2.isSelected()) {
            if (bv == 0) {
                b = b + Blackberry2.getText();
            } else {
                b = b + "," + Blackberry2.getText();
            }
            bv = 2;
        }
        if (Raspberry2.isSelected()) {
            if (bv == 0) {
                b = b + Raspberry2.getText();
            } else {
                b = b + "," + Raspberry2.getText();
            }
            bv = 2;
        }
        if (Blueberry2.isSelected()) {
            if (bv == 0) {
                b = b + Blueberry2.getText();
            } else {
                b = b + "," + Blueberry2.getText();
            }
            bv = 2;
        }
        if (Strawberry2.isSelected()) {
            if (bv == 0) {
                b = b + Strawberry2.getText();
            } else {
                b = b + "," + Strawberry2.getText();
            }
            bv = 2;
        }
        if (Raisen2.isSelected()) {
            if (bv == 0) {
                b = b + Raisen2.getText();
            } else {
                b = b + "," + Raisen2.getText();
            }
            bv = 2;
        }
        if (Prune2.isSelected()) {
            if (bv == 0) {
                b = b + Prune2.getText();
            } else {
                b = b + "," + Prune2.getText();
            }
            bv = 2;
        }
        if (Coconut2.isSelected()) {
            if (bv == 0) {
                b = b + Coconut2.getText();
            } else {
                b = b + "," + Coconut2.getText();
            }
            bv = 2;
        }
        if (Cherry2.isSelected()) {
            if (bv == 0) {
                b = b + Cherry2.getText();
            } else {
                b = b + "," + Cherry2.getText();
            }
            bv = 2;
        }
        if (Pomagranite2.isSelected()) {
            if (bv == 0) {
                b = b + Pomagranite2.getText();
            } else {
                b = b + "," + Pomagranite2.getText();
            }
            bv = 2;
        }
        if (Pinneapple2.isSelected()) {
            if (bv == 0) {
                b = b + Pinneapple2.getText();
            } else {
                b = b + "," + Pinneapple2.getText();
            }
            bv = 2;
        }
        if (Grape2.isSelected()) {
            if (bv == 0) {
                b = b + Grape2.getText();
            } else {
                b = b + "," + Grape2.getText();
            }
            bv = 2;
        }
        if (Apple2.isSelected()) {
            if (bv == 0) {
                b = b + Apple2.getText();
            } else {
                b = b + "," + Apple2.getText();
            }
            bv = 2;
        }
        if (Peach2.isSelected()) {
            if (bv == 0) {
                b = b + Peach2.getText();
            } else {
                b = b + "," + Peach2.getText();
            }
            bv = 2;
        }
        if (Pear2.isSelected()) {
            if (bv == 0) {
                b = b + Pear2.getText();
            } else {
                b = b + "," + Pear2.getText();
            }
            bv = 2;
        }
        if (Grapefruit2.isSelected()) {
            if (bv == 0) {
                b = b + Grapefruit2.getText();
            } else {
                b = b + "," + Grapefruit2.getText();
            }
            bv = 2;
        }
        if (Orange2.isSelected()) {
            if (bv == 0) {
                b = b + Orange2.getText();
            } else {
                b = b + "," + Orange2.getText();
            }
            bv = 2;
        }
        if (Lemon2.isSelected()) {
            if (bv == 0) {
                b = b + Lemon2.getText();
            } else {
                b = b + "," + Lemon2.getText();
            }
            bv = 2;
        }
        if (Lime2.isSelected()) {
            if (bv == 0) {
                b = b + Lime2.getText();
            } else {
                b = b + "," + Lime2.getText();
            }
            bv = 2;
        }
        if (Vinegar2.isSelected()) {
            if (bv == 0) {
                b = b + Vinegar2.getText();
            } else {
                b = b + "," + Vinegar2.getText();
            }
            bv = 2;
        }
        if (Rancidbutter2.isSelected()) {
            if (bv == 0) {
                b = b + Rancidbutter2.getText();
            } else {
                b = b + "," + Rancidbutter2.getText();
            }
            bv = 2;
        }
        if (RancidCheese2.isSelected()) {
            if (bv == 0) {
                b = b + RancidCheese2.getText();
            } else {
                b = b + "," + RancidCheese2.getText();
            }
            bv = 2;
        }
        if (OrangeAcidity2.isSelected()) {
            if (bv == 0) {
                b = b + OrangeAcidity2.getText();
            } else {
                b = b + "," + OrangeAcidity2.getText();
            }
            bv = 2;
        }
        if (AppleAcidity2.isSelected()) {
            if (bv == 0) {
                b = b + AppleAcidity2.getText();
            } else {
                b = b + "," + AppleAcidity2.getText();
            }
            bv = 2;
        }
        if (Winey2.isSelected()) {
            if (bv == 0) {
                b = b + Winey2.getText();
            } else {
                b = b + "," + Winey2.getText();
            }
            bv = 2;
        }
        if (Whiskey2.isSelected()) {
            if (bv == 0) {
                b = b + Whiskey2.getText();
            } else {
                b = b + "," + Whiskey2.getText();
            }
            bv = 2;
        }
        if (Fermented2.isSelected()) {
            if (bv == 0) {
                b = b + Fermented2.getText();
            } else {
                b = b + "," + Fermented2.getText();
            }
            bv = 2;
        }
        if (Overripe2.isSelected()) {
            if (bv == 0) {
                b = b + Overripe2.getText();
            } else {
                b = b + "," + Overripe2.getText();
            }
            bv = 2;
        }
        if (OliveOil2.isSelected()) {
            if (bv == 0) {
                b = b + OliveOil2.getText();
            } else {
                b = b + "," + OliveOil2.getText();
            }
            bv = 2;
        }
        if (Raw2.isSelected()) {
            if (bv == 0) {
                b = b + Raw2.getText();
            } else {
                b = b + "," + Raw2.getText();
            }
            bv = 2;
        }
        if (Underripe2.isSelected()) {
            if (bv == 0) {
                b = b + Underripe2.getText();
            } else {
                b = b + "," + Underripe2.getText();
            }
            bv = 2;
        }
        if (Peapod2.isSelected()) {
            if (bv == 0) {
                b = b + Peapod2.getText();
            } else {
                b = b + "," + Peapod2.getText();
            }
            bv = 2;
        }
        if (Fresh2.isSelected()) {
            if (bv == 0) {
                b = b + Fresh2.getText();
            } else {
                b = b + "," + Fresh2.getText();
            }
            bv = 2;
        }
        if (DarkGreen2.isSelected()) {
            if (bv == 0) {
                b = b + DarkGreen2.getText();
            } else {
                b = b + "," + DarkGreen2.getText();
            }
            bv = 2;
        }
        if (Vegetative2.isSelected()) {
            if (bv == 0) {
                b = b + Vegetative2.getText();
            } else {
                b = b + "," + Vegetative2.getText();
            }
            bv = 2;
        }
        if (Haylike2.isSelected()) {
            if (bv == 0) {
                b = b + Haylike2.getText();
            } else {
                b = b + "," + Haylike2.getText();
            }
            bv = 2;
        }
        if (Herblike2.isSelected()) {
            if (bv == 0) {
                b = b + Herblike2.getText();
            } else {
                b = b + "," + Herblike2.getText();
            }
            bv = 2;
        }
        if (Beany2.isSelected()) {
            if (bv == 0) {
                b = b + Beany2.getText();
            } else {
                b = b + "," + Beany2.getText();
            }
            bv = 2;
        }
        if (Stale2.isSelected()) {
            if (bv == 0) {
                b = b + Stale2.getText();
            } else {
                b = b + "," + Stale2.getText();
            }
            bv = 2;
        }
        if (Cardboard2.isSelected()) {
            if (bv == 0) {
                b = b + Cardboard2.getText();
            } else {
                b = b + "," + Cardboard2.getText();
            }
            bv = 2;
        }
        if (Papery2.isSelected()) {
            if (bv == 0) {
                b = b + Papery2.getText();
            } else {
                b = b + "," + Papery2.getText();
            }
            bv = 2;
        }
        if (Woody2.isSelected()) {
            if (bv == 0) {
                b = b + Woody2.getText();
            } else {
                b = b + "," + Woody2.getText();
            }
            bv = 2;
        }
        if (MoldyDamp2.isSelected()) {
            if (bv == 0) {
                b = b + MoldyDamp2.getText();
            } else {
                b = b + "," + MoldyDamp2.getText();
            }
            bv = 2;
        }
        if (MustyDusty2.isSelected()) {
            if (bv == 0) {
                b = b + MustyDusty2.getText();
            } else {
                b = b + "," + MustyDusty2.getText();
            }
            bv = 2;
        }
        if (MustyEarthy2.isSelected()) {
            if (bv == 0) {
                b = b + MustyEarthy2.getText();
            } else {
                b = b + "," + MustyEarthy2.getText();
            }
            bv = 2;
        }
        if (Animalic2.isSelected()) {
            if (bv == 0) {
                b = b + Animalic2.getText();
            } else {
                b = b + "," + Animalic2.getText();
            }
            bv = 2;
        }
        if (MeatyBrothy2.isSelected()) {
            if (bv == 0) {
                b = b + MeatyBrothy2.getText();
            } else {
                b = b + "," + MeatyBrothy2.getText();
            }
            bv = 2;
        }
        if (Phenolic2.isSelected()) {
            if (bv == 0) {
                b = b + Phenolic2.getText();
            } else {
                b = b + "," + Phenolic2.getText();
            }
            bv = 2;
        }
        if (Bitter2.isSelected()) {
            if (bv == 0) {
                b = b + Bitter2.getText();
            } else {
                b = b + "," + Bitter2.getText();
            }
            bv = 2;
        }
        if (Salty2.isSelected()) {
            if (bv == 0) {
                b = b + Salty2.getText();
            } else {
                b = b + "," + Salty2.getText();
            }
            bv = 2;
        }
        if (Medicinal2.isSelected()) {
            if (bv == 0) {
                b = b + Medicinal2.getText();
            } else {
                b = b + "," + Medicinal2.getText();
            }
            bv = 2;
        }
        if (Petroleum2.isSelected()) {
            if (bv == 0) {
                b = b + Petroleum2.getText();
            } else {
                b = b + "," + Petroleum2.getText();
            }
            bv = 2;
        }
        if (Skunky2.isSelected()) {
            if (bv == 0) {
                b = b + Skunky2.getText();
            } else {
                b = b + "," + Skunky2.getText();
            }
            bv = 2;
        }
        if (Rubber2.isSelected()) {
            if (bv == 0) {
                b = b + Rubber2.getText();
            } else {
                b = b + "," + Rubber2.getText();
            }
            bv = 2;
        }
        if (PipeTobacco2.isSelected()) {
            if (bv == 0) {
                b = b + PipeTobacco2.getText();
            } else {
                b = b + "," + PipeTobacco2.getText();
            }
            bv = 2;
        }
        if (Tobacco2.isSelected()) {
            if (bv == 0) {
                b = b + Tobacco2.getText();
            } else {
                b = b + "," + Tobacco2.getText();
            }
            bv = 2;
        }
        if (Acrid2.isSelected()) {
            if (bv == 0) {
                b = b + Acrid2.getText();
            } else {
                b = b + "," + Acrid2.getText();
            }
            bv = 2;
        }
        if (Ashy2.isSelected()) {
            if (bv == 0) {
                b = b + Ashy2.getText();
            } else {
                b = b + "," + Ashy2.getText();
            }
            bv = 2;
        }
        if (Smoky2.isSelected()) {
            if (bv == 0) {
                b = b + Smoky2.getText();
            } else {
                b = b + "," + Smoky2.getText();
            }
            bv = 2;
        }
        if (BrownRoast2.isSelected()) {
            if (bv == 0) {
                b = b + BrownRoast2.getText();
            } else {
                b = b + "," + BrownRoast2.getText();
            }
            bv = 2;
        }
        if (Grain2.isSelected()) {
            if (bv == 0) {
                b = b + Grain2.getText();
            } else {
                b = b + "," + Grain2.getText();
            }
            bv = 2;
        }
        if (Malt2.isSelected()) {
            if (bv == 0) {
                b = b + Malt2.getText();
            } else {
                b = b + "," + Malt2.getText();
            }
            bv = 2;
        }
        if (Pungent2.isSelected()) {
            if (bv == 0) {
                b = b + Pungent2.getText();
            } else {
                b = b + "," + Pungent2.getText();
            }
            bv = 2;
        }
        if (Pepper2.isSelected()) {
            if (bv == 0) {
                b = b + Pepper2.getText();
            } else {
                b = b + "," + Pepper2.getText();
            }
            bv = 2;
        }
        if (Anise2.isSelected()) {
            if (bv == 0) {
                b = b + Anise2.getText();
            } else {
                b = b + "," + Anise2.getText();
            }
            bv = 2;
        }
        if (Nutmeg2.isSelected()) {
            if (bv == 0) {
                b = b + Nutmeg2.getText();
            } else {
                b = b + "," + Nutmeg2.getText();
            }
            bv = 2;
        }
        if (Cinnamon2.isSelected()) {
            if (bv == 0) {
                b = b + Cinnamon2.getText();
            } else {
                b = b + "," + Cinnamon2.getText();
            }
            bv = 2;
        }
        if (Clove2.isSelected()) {
            if (bv == 0) {
                b = b + Clove2.getText();
            } else {
                b = b + "," + Clove2.getText();
            }
            bv = 2;
        }
        if (Nutty2.isSelected()) {
            if (bv == 0) {
                b = b + Nutty2.getText();
            } else {
                b = b + "," + Nutty2.getText();
            }
            bv = 2;
        }
        if (Peanuts2.isSelected()) {
            if (bv == 0) {
                b = b + Peanuts2.getText();
            } else {
                b = b + "," + Peanuts2.getText();
            }
            bv = 2;
        }
        if (Hazelenut2.isSelected()) {
            if (bv == 0) {
                b = b + Hazelenut2.getText();
            } else {
                b = b + "," + Hazelenut2.getText();
            }
            bv = 2;
        }
        if (Almond2.isSelected()) {
            if (bv == 0) {
                b = b + Almond2.getText();
            } else {
                b = b + "," + Almond2.getText();
            }
            bv = 2;
        }
        if (Chocolate2.isSelected()) {
            if (bv == 0) {
                b = b + Chocolate2.getText();
            } else {
                b = b + "," + Chocolate2.getText();
            }
            bv = 2;
        }
        if (DarkChocolate2.isSelected()) {
            if (bv == 0) {
                b = b + DarkChocolate2.getText();
            } else {
                b = b + "," + DarkChocolate2.getText();
            }
            bv = 2;
        }
        if (bv != 1) {
            b = "Break:" + b + ";";
        }
        if (Sweet3.isSelected()) {
            if (fv == 0) {
                f = f + Sweet3.getText();
            } else {
                f = f + "," + Sweet3.getText();
            }
            fv = 3;
        }
        if (Floral3.isSelected()) {
            if (fv == 0) {
                f = f + Floral3.getText();
            } else {
                f = f + "," + Floral3.getText();
            }
            fv = 3;
        }
        if (Fruity3.isSelected()) {
            if (fv == 0) {
                f = f + Fruity3.getText();
            } else {
                f = f + "," + Fruity3.getText();
            }
            fv = 3;
        }
        if (Berry3.isSelected()) {
            if (fv == 0) {
                f = f + Berry3.getText();
            } else {
                f = f + "," + Berry3.getText();
            }
            fv = 3;
        }
        if (DriedFruit3.isSelected()) {
            if (fv == 0) {
                f = f + DriedFruit3.getText();
            } else {
                f = f + "," + DriedFruit3.getText();
            }
            fv = 3;
        }
        if (Otherfruit3.isSelected()) {
            if (fv == 0) {
                f = f + Otherfruit3.getText();
            } else {
                f = f + "," + Otherfruit3.getText();
            }
            fv = 3;
        }
        if (Citrusfruit3.isSelected()) {
            if (fv == 0) {
                f = f + Citrusfruit3.getText();
            } else {
                f = f + "," + Citrusfruit3.getText();
            }
            fv = 3;
        }
        if (Sour3.isSelected()) {
            if (fv == 0) {
                f = f + Sour3.getText();
            } else {
                f = f + "," + Sour3.getText();
            }
            fv = 3;
        }
        if (sour3.isSelected()) {
            if (fv == 0) {
                f = f + sour3.getText();
            } else {
                f = f + "," + sour3.getText();
            }
            fv = 3;
        }
        if (Alcohol3.isSelected()) {
            if (fv == 0) {
                f = f + Alcohol3.getText();
            } else {
                f = f + "," + Alcohol3.getText();
            }
            fv = 3;
        }
        if (Green3.isSelected()) {
            if (fv == 0) {
                f = f + Green3.getText();
            } else {
                f = f + "," + Green3.getText();
            }
            fv = 3;
        }
        if (Other3.isSelected()) {
            if (fv == 0) {
                f = f + Other3.getText();
            } else {
                f = f + "," + Other3.getText();
            }
            fv = 3;
        }
        if (PaperyM3.isSelected()) {
            if (fv == 0) {
                f = f + PaperyM3.getText();
            } else {
                f = f + "," + PaperyM3.getText();
            }
            fv = 3;
        }
        if (Chemical3.isSelected()) {
            if (fv == 0) {
                f = f + Chemical3.getText();
            } else {
                f = f + "," + Chemical3.getText();
            }
            fv = 3;
        }
        if (Roasted3.isSelected()) {
            if (fv == 0) {
                f = f + Roasted3.getText();
            } else {
                f = f + "," + Roasted3.getText();
            }
            fv = 3;
        }
        if (Burnt3.isSelected()) {
            if (fv == 0) {
                f = f + Burnt3.getText();
            } else {
                f = f + "," + Burnt3.getText();
            }
            fv = 3;
        }
        if (Cereal3.isSelected()) {
            if (fv == 0) {
                f = f + Cereal3.getText();
            } else {
                f = f + "," + Cereal3.getText();
            }
            fv = 3;
        }
        if (Spices3.isSelected()) {
            if (fv == 0) {
                f = f + Spices3.getText();
            } else {
                f = f + "," + Spices3.getText();
            }
            fv = 3;
        }
        if (Brownspices3.isSelected()) {
            if (fv == 0) {
                f = f + Brownspices3.getText();
            } else {
                f = f + "," + Brownspices3.getText();
            }
            fv = 3;
        }
        if (Nuttycocoa3.isSelected()) {
            if (fv == 0) {
                f = f + Nuttycocoa3.getText();
            } else {
                f = f + "," + Nuttycocoa3.getText();
            }
            fv = 3;
        }
        if (Cocoa3.isSelected()) {
            if (fv == 0) {
                f = f + Cocoa3.getText();
            } else {
                f = f + "," + Cocoa3.getText();
            }
            fv = 3;
        }

        if (BrownSugar3.isSelected()) {
            if (fv == 0) {
                f = f + BrownSugar3.getText();
            } else {
                f = f + "," + BrownSugar3.getText();
            }
            fv = 3;
        }
        if (Molasses3.isSelected()) {
            if (fv == 0) {
                f = f + Molasses3.getText();
            } else {
                f = f + "," + Molasses3.getText();
            }
            fv = 3;
        }
        if (MapleSugar3.isSelected()) {
            if (fv == 0) {
                f = f + MapleSugar3.getText();
            } else {
                f = f + "," + MapleSugar3.getText();
            }
            fv = 3;
        }
        if (Carmelized3.isSelected()) {
            if (fv == 0) {
                f = f + Carmelized3.getText();
            } else {
                f = f + "," + Carmelized3.getText();
            }
            fv = 3;
        }
        if (Honey3.isSelected()) {
            if (fv == 0) {
                f = f + Honey3.getText();
            } else {
                f = f + "," + Honey3.getText();
            }
            fv = 3;
        }
        if (Vanilla3.isSelected()) {
            if (fv == 0) {
                f = f + Vanilla3.getText();
            } else {
                f = f + "," + Vanilla3.getText();
            }
            fv = 3;
        }

        if (Blacktea3.isSelected()) {
            if (fv == 0) {
                f = f + Blacktea3.getText();
            } else {
                f = f + "," + Blacktea3.getText();
            }
            fv = 3;
        }

        if (Chamomile3.isSelected()) {
            if (fv == 0) {
                f = f + Chamomile3.getText();
            } else {
                f = f + "," + Chamomile3.getText();
            }
            fv = 3;
        }
        if (Rose3.isSelected()) {
            if (fv == 0) {
                f = f + Rose3.getText();
            } else {
                f = f + "," + Rose3.getText();
            }
            fv = 3;
        }
        if (Jasmine3.isSelected()) {
            if (fv == 0) {
                f = f + Jasmine3.getText();
            } else {
                f = f + "," + Jasmine3.getText();
            }
            fv = 3;
        }

        if (Blackberry3.isSelected()) {
            if (fv == 0) {
                f = f + Blackberry3.getText();
            } else {
                f = f + "," + Blackberry3.getText();
            }
            fv = 3;
        }
        if (Raspberry3.isSelected()) {
            if (fv == 0) {
                f = f + Raspberry3.getText();
            } else {
                f = f + "," + Raspberry3.getText();
            }
            fv = 3;
        }
        if (Blueberry3.isSelected()) {
            if (fv == 0) {
                f = f + Blueberry3.getText();
            } else {
                f = f + "," + Blueberry3.getText();
            }
            fv = 3;
        }
        if (Strawberry3.isSelected()) {
            if (fv == 0) {
                f = f + Strawberry3.getText();
            } else {
                f = f + "," + Strawberry3.getText();
            }
            fv = 3;
        }
        if (Raisen3.isSelected()) {
            if (fv == 0) {
                f = f + Raisen3.getText();
            } else {
                f = f + "," + Raisen3.getText();
            }
            fv = 3;
        }
        if (Prune3.isSelected()) {
            if (fv == 0) {
                f = f + Prune3.getText();
            } else {
                f = f + "," + Prune3.getText();
            }
            fv = 3;
        }
        if (Coconut3.isSelected()) {
            if (fv == 0) {
                f = f + Coconut3.getText();
            } else {
                f = f + "," + Coconut3.getText();
            }
            fv = 3;
        }
        if (Cherry3.isSelected()) {
            if (fv == 0) {
                f = f + Cherry3.getText();
            } else {
                f = f + "," + Cherry3.getText();
            }
            fv = 3;
        }
        if (Pomagranite3.isSelected()) {
            if (fv == 0) {
                f = f + Pomagranite3.getText();
            } else {
                f = f + "," + Pomagranite3.getText();
            }
            fv = 3;
        }
        if (Pinneapple3.isSelected()) {
            if (fv == 0) {
                f = f + Pinneapple3.getText();
            } else {
                f = f + "," + Pinneapple3.getText();
            }
            fv = 3;
        }
        if (Grape3.isSelected()) {
            if (fv == 0) {
                f = f + Grape3.getText();
            } else {
                f = f + "," + Grape3.getText();
            }
            fv = 3;
        }
        if (Apple3.isSelected()) {
            if (fv == 0) {
                f = f + Apple3.getText();
            } else {
                f = f + "," + Apple3.getText();
            }
            fv = 3;
        }
        if (Peach3.isSelected()) {
            if (fv == 0) {
                f = f + Peach3.getText();
            } else {
                f = f + "," + Peach3.getText();
            }
            fv = 3;
        }
        if (Pear3.isSelected()) {
            if (fv == 0) {
                f = f + Pear3.getText();
            } else {
                f = f + "," + Pear3.getText();
            }
            fv = 3;
        }
        if (Grapefruit3.isSelected()) {
            if (fv == 0) {
                f = f + Grapefruit3.getText();
            } else {
                f = f + "," + Grapefruit3.getText();
            }
            fv = 3;
        }
        if (Orange3.isSelected()) {
            if (fv == 0) {
                f = f + Orange3.getText();
            } else {
                f = f + "," + Orange3.getText();
            }
            fv = 3;
        }
        if (Lemon3.isSelected()) {
            if (fv == 0) {
                f = f + Lemon3.getText();
            } else {
                f = f + "," + Lemon3.getText();
            }
            fv = 3;
        }
        if (Lime3.isSelected()) {
            if (fv == 0) {
                f = f + Lime3.getText();
            } else {
                f = f + "," + Lime3.getText();
            }
            fv = 3;
        }
        if (Vinegar3.isSelected()) {
            if (fv == 0) {
                f = f + Vinegar3.getText();
            } else {
                f = f + "," + Vinegar3.getText();
            }
            fv = 3;
        }
        if (Rancidbutter3.isSelected()) {
            if (fv == 0) {
                f = f + Rancidbutter3.getText();
            } else {
                f = f + "," + Rancidbutter3.getText();
            }
            fv = 3;
        }
        if (RancidCheese3.isSelected()) {
            if (fv == 0) {
                f = f + RancidCheese3.getText();
            } else {
                f = f + "," + RancidCheese3.getText();
            }
            fv = 3;
        }
        if (OrangeAcidity3.isSelected()) {
            if (fv == 0) {
                f = f + OrangeAcidity3.getText();
            } else {
                f = f + "," + OrangeAcidity3.getText();
            }
            fv = 3;
        }
        if (AppleAcidity3.isSelected()) {
            if (fv == 0) {
                f = f + AppleAcidity3.getText();
            } else {
                f = f + "," + AppleAcidity3.getText();
            }
            fv = 3;
        }
        if (Winey3.isSelected()) {
            if (fv == 0) {
                f = f + Winey3.getText();
            } else {
                f = f + "," + Winey3.getText();
            }
            fv = 3;
        }
        if (Whiskey3.isSelected()) {
            if (fv == 0) {
                f = f + Whiskey3.getText();
            } else {
                f = f + "," + Whiskey3.getText();
            }
            fv = 3;
        }
        if (Fermented3.isSelected()) {
            if (fv == 0) {
                f = f + Fermented3.getText();
            } else {
                f = f + "," + Fermented3.getText();
            }
            fv = 3;
        }
        if (Overripe3.isSelected()) {
            if (fv == 0) {
                f = f + Overripe3.getText();
            } else {
                f = f + "," + Overripe3.getText();
            }
            fv = 3;
        }
        if (OliveOil3.isSelected()) {
            if (fv == 0) {
                f = f + OliveOil3.getText();
            } else {
                f = f + "," + OliveOil3.getText();
            }
            fv = 3;
        }
        if (Raw3.isSelected()) {
            if (fv == 0) {
                f = f + Raw3.getText();
            } else {
                f = f + "," + Raw3.getText();
            }
            fv = 3;
        }
        if (Underripe3.isSelected()) {
            if (fv == 0) {
                f = f + Underripe3.getText();
            } else {
                f = f + "," + Underripe3.getText();
            }
            fv = 3;
        }
        if (Peapod3.isSelected()) {
            if (fv == 0) {
                f = f + Peapod3.getText();
            } else {
                f = f + "," + Peapod3.getText();
            }
            fv = 3;
        }
        if (Fresh3.isSelected()) {
            if (fv == 0) {
                f = f + Fresh3.getText();
            } else {
                f = f + "," + Fresh3.getText();
            }
            fv = 3;
        }
        if (DarkGreen3.isSelected()) {
            if (fv == 0) {
                f = f + DarkGreen3.getText();
            } else {
                f = f + "," + DarkGreen3.getText();
            }
            fv = 3;
        }
        if (Vegetative3.isSelected()) {
            if (fv == 0) {
                f = f + Vegetative3.getText();
            } else {
                f = f + "," + Vegetative3.getText();
            }
            fv = 3;
        }
        if (Haylike3.isSelected()) {
            if (fv == 0) {
                f = f + Haylike3.getText();
            } else {
                f = f + "," + Haylike3.getText();
            }
            fv = 3;
        }
        if (Herblike3.isSelected()) {
            if (fv == 0) {
                f = f + Herblike3.getText();
            } else {
                f = f + "," + Herblike3.getText();
            }
            fv = 3;
        }
        if (Beany3.isSelected()) {
            if (fv == 0) {
                f = f + Beany3.getText();
            } else {
                f = f + "," + Beany3.getText();
            }
            fv = 3;
        }
        if (Stale3.isSelected()) {
            if (fv == 0) {
                f = f + Stale3.getText();
            } else {
                f = f + "," + Stale3.getText();
            }
            fv = 3;
        }
        if (Cardboard3.isSelected()) {
            if (fv == 0) {
                f = f + Cardboard3.getText();
            } else {
                f = f + "," + Cardboard3.getText();
            }
            fv = 3;
        }
        if (Papery3.isSelected()) {
            if (fv == 0) {
                f = f + Papery3.getText();
            } else {
                f = f + "," + Papery3.getText();
            }
            fv = 3;
        }
        if (Woody3.isSelected()) {
            if (fv == 0) {
                f = f + Woody3.getText();
            } else {
                f = f + "," + Woody3.getText();
            }
            fv = 3;
        }
        if (MoldyDamp3.isSelected()) {
            if (fv == 0) {
                f = f + MoldyDamp3.getText();
            } else {
                f = f + "," + MoldyDamp3.getText();
            }
            fv = 3;
        }
        if (MustyDusty3.isSelected()) {
            if (fv == 0) {
                f = f + MustyDusty3.getText();
            } else {
                f = f + "," + MustyDusty3.getText();
            }
            fv = 3;
        }
        if (MustyEarthy3.isSelected()) {
            if (fv == 0) {
                f = f + MustyEarthy3.getText();
            } else {
                f = f + "," + MustyEarthy3.getText();
            }
            fv = 3;
        }
        if (Animalic3.isSelected()) {
            if (fv == 0) {
                f = f + Animalic3.getText();
            } else {
                f = f + "," + Animalic3.getText();
            }
            fv = 3;
        }
        if (MeatyBrothy3.isSelected()) {
            if (fv == 0) {
                f = f + MeatyBrothy3.getText();
            } else {
                f = f + "," + MeatyBrothy3.getText();
            }
            fv = 3;
        }
        if (Phenolic3.isSelected()) {
            if (fv == 0) {
                f = f + Phenolic3.getText();
            } else {
                f = f + "," + Phenolic3.getText();
            }
            fv = 3;
        }
        if (Bitter3.isSelected()) {
            if (fv == 0) {
                f = f + Bitter3.getText();
            } else {
                f = f + "," + Bitter3.getText();
            }
            fv = 3;
        }
        if (Salty3.isSelected()) {
            if (fv == 0) {
                f = f + Salty3.getText();
            } else {
                f = f + "," + Salty3.getText();
            }
            fv = 3;
        }
        if (Medicinal3.isSelected()) {
            if (fv == 0) {
                f = f + Medicinal3.getText();
            } else {
                f = f + "," + Medicinal3.getText();
            }
            fv = 3;
        }
        if (Petroleum3.isSelected()) {
            if (fv == 0) {
                f = f + Petroleum3.getText();
            } else {
                f = f + "," + Petroleum3.getText();
            }
            fv = 3;
        }
        if (Skunky3.isSelected()) {
            if (fv == 0) {
                f = f + Skunky3.getText();
            } else {
                f = f + "," + Skunky3.getText();
            }
            fv = 3;
        }
        if (Rubber3.isSelected()) {
            if (fv == 0) {
                f = f + Rubber3.getText();
            } else {
                f = f + "," + Rubber3.getText();
            }
            fv = 3;
        }
        if (PipeTobacco3.isSelected()) {
            if (fv == 0) {
                f = f + PipeTobacco3.getText();
            } else {
                f = f + "," + PipeTobacco3.getText();
            }
            fv = 3;
        }
        if (Tobacco3.isSelected()) {
            if (fv == 0) {
                f = f + Tobacco3.getText();
            } else {
                f = f + "," + Tobacco3.getText();
            }
            fv = 3;
        }
        if (Acrid3.isSelected()) {
            if (fv == 0) {
                f = f + Acrid3.getText();
            } else {
                f = f + "," + Acrid3.getText();
            }
            fv = 3;
        }
        if (Ashy3.isSelected()) {
            if (fv == 0) {
                f = f + Ashy3.getText();
            } else {
                f = f + "," + Ashy3.getText();
            }
            fv = 3;
        }
        if (Smoky3.isSelected()) {
            if (fv == 0) {
                f = f + Smoky3.getText();
            } else {
                f = f + "," + Smoky3.getText();
            }
            fv = 3;
        }
        if (BrownRoast3.isSelected()) {
            if (fv == 0) {
                f = f + BrownRoast3.getText();
            } else {
                f = f + "," + BrownRoast3.getText();
            }
            fv = 3;
        }
        if (Grain3.isSelected()) {
            if (fv == 0) {
                f = f + Grain3.getText();
            } else {
                f = f + "," + Grain3.getText();
            }
            fv = 3;
        }
        if (Malt3.isSelected()) {
            if (fv == 0) {
                f = f + Malt3.getText();
            } else {
                f = f + "," + Malt3.getText();
            }
            fv = 3;
        }
        if (Pungent3.isSelected()) {
            if (fv == 0) {
                f = f + Pungent3.getText();
            } else {
                f = f + "," + Pungent3.getText();
            }
            fv = 3;
        }
        if (Pepper3.isSelected()) {
            if (fv == 0) {
                f = f + Pepper3.getText();
            } else {
                f = f + "," + Pepper3.getText();
            }
            fv = 3;
        }
        if (Anise3.isSelected()) {
            if (fv == 0) {
                f = f + Anise3.getText();
            } else {
                f = f + "," + Anise3.getText();
            }
            fv = 3;
        }
        if (Nutmeg3.isSelected()) {
            if (fv == 0) {
                f = f + Nutmeg3.getText();
            } else {
                f = f + "," + Nutmeg3.getText();
            }
            fv = 3;
        }
        if (Cinnamon3.isSelected()) {
            if (fv == 0) {
                f = f + Cinnamon3.getText();
            } else {
                f = f + "," + Cinnamon3.getText();
            }
            fv = 3;
        }
        if (Clove3.isSelected()) {
            if (fv == 0) {
                f = f + Clove3.getText();
            } else {
                f = f + "," + Clove3.getText();
            }
            fv = 3;
        }
        if (Nutty3.isSelected()) {
            if (fv == 0) {
                f = f + Nutty3.getText();
            } else {
                f = f + "," + Nutty3.getText();
            }
            fv = 3;
        }
        if (Peanuts3.isSelected()) {
            if (fv == 0) {
                f = f + Peanuts3.getText();
            } else {
                f = f + "," + Peanuts3.getText();
            }
            fv = 3;
        }
        if (Hazelenut3.isSelected()) {
            if (fv == 0) {
                f = f + Hazelenut3.getText();
            } else {
                f = f + "," + Hazelenut3.getText();
            }
            fv = 3;
        }
        if (Almond3.isSelected()) {
            if (fv == 0) {
                f = f + Almond3.getText();
            } else {
                f = f + "," + Almond3.getText();
            }
            fv = 3;
        }
        if (Chocolate3.isSelected()) {
            if (fv == 0) {
                f = f + Chocolate3.getText();
            } else {
                f = f + "," + Chocolate3.getText();
            }
            fv = 3;
        }
        if (DarkChocolate3.isSelected()) {
            if (fv == 0) {
                f = f + DarkChocolate3.getText();
            } else {
                f = f + "," + DarkChocolate3.getText();
            }
            fv = 3;
        }
        if (fv != 1) {
            f = "Flavor:" + f + ";";
        }
        if (Sweet1.isSelected()) {
            if (av == 0) {
                a = a + Sweet1.getText();
            } else {
                a = a + "," + Sweet1.getText();
            }
            av = 4;
        }
        if (Floral1.isSelected()) {
            if (av == 0) {
                a = a + Floral1.getText();
            } else {
                a = a + "," + Floral1.getText();
            }
            av = 4;
        }
        if (Fruity1.isSelected()) {
            if (av == 0) {
                a = a + Fruity1.getText();
            } else {
                a = a + "," + Fruity1.getText();
            }
            av = 4;
        }
        if (Berry1.isSelected()) {
            if (av == 0) {
                a = a + Berry1.getText();
            } else {
                a = a + "," + Berry1.getText();
            }
            av = 4;
        }
        if (DriedFruit1.isSelected()) {
            if (av == 0) {
                a = a + DriedFruit1.getText();
            } else {
                a = a + "," + DriedFruit1.getText();
            }
            av = 4;
        }
        if (Otherfruit1.isSelected()) {
            if (av == 0) {
                a = a + Otherfruit1.getText();
            } else {
                a = a + "," + Otherfruit1.getText();
            }
            av = 4;
        }
        if (Citrusfruit1.isSelected()) {
            if (av == 0) {
                a = a + Citrusfruit1.getText();
            } else {
                a = a + "," + Citrusfruit1.getText();
            }
            av = 4;
        }
        if (Sour1.isSelected()) {
            if (av == 0) {
                a = a + Sour1.getText();
            } else {
                a = a + "," + Sour1.getText();
            }
            av = 4;
        }
        if (sour1.isSelected()) {
            if (av == 0) {
                a = a + sour1.getText();
            } else {
                a = a + "," + sour1.getText();
            }
            av = 4;
        }
        if (Alcohol1.isSelected()) {
            if (av == 0) {
                a = a + Alcohol1.getText();
            } else {
                a = a + "," + Alcohol1.getText();
            }
            av = 4;
        }
        if (Green1.isSelected()) {
            if (av == 0) {
                a = a + Green1.getText();
            } else {
                a = a + "," + Green1.getText();
            }
            av = 4;
        }
        if (Other1.isSelected()) {
            if (av == 0) {
                a = a + Other1.getText();
            } else {
                a = a + "," + Other1.getText();
            }
            av = 4;
        }
        if (PaperyM1.isSelected()) {
            if (av == 0) {
                a = a + PaperyM1.getText();
            } else {
                a = a + "," + PaperyM1.getText();
            }
            av = 4;
        }
        if (Chemical1.isSelected()) {
            if (av == 0) {
                a = a + Chemical1.getText();
            } else {
                a = a + "," + Chemical1.getText();
            }
            av = 4;
        }
        if (Roasted1.isSelected()) {
            if (av == 0) {
                a = a + Roasted1.getText();
            } else {
                a = a + "," + Roasted1.getText();
            }
            av = 4;
        }
        if (Burnt1.isSelected()) {
            if (av == 0) {
                a = a + Burnt1.getText();
            } else {
                a = a + "," + Burnt1.getText();
            }
            av = 4;
        }
        if (Cereal1.isSelected()) {
            if (av == 0) {
                a = a + Cereal1.getText();
            } else {
                a = a + "," + Cereal1.getText();
            }
            av = 4;
        }
        if (Spices1.isSelected()) {
            if (av == 0) {
                a = a + Spices1.getText();
            } else {
                a = a + "," + Spices1.getText();
            }
            av = 4;
        }
        if (Brownspices1.isSelected()) {
            if (av == 0) {
                a = a + Brownspices1.getText();
            } else {
                a = a + "," + Brownspices1.getText();
            }
            av = 4;
        }
        if (Nuttycocoa1.isSelected()) {
            if (av == 0) {
                a = a + Nuttycocoa1.getText();
            } else {
                a = a + "," + Nuttycocoa1.getText();
            }
            av = 4;
        }
        if (Cocoa1.isSelected()) {
            if (av == 0) {
                a = a + Cocoa1.getText();
            } else {
                a = a + "," + Cocoa1.getText();
            }
            av = 4;
        }

        if (BrownSugar4.isSelected()) {
            if (av == 0) {
                a = a + BrownSugar4.getText();
            } else {
                a = a + "," + BrownSugar4.getText();
            }
            av = 4;
        }
        if (Molasses4.isSelected()) {
            if (av == 0) {
                a = a + Molasses4.getText();
            } else {
                a = a + "," + Molasses4.getText();
            }
            av = 4;
        }
        if (MapleSugar4.isSelected()) {
            if (av == 0) {
                a = a + MapleSugar4.getText();
            } else {
                a = a + "," + MapleSugar4.getText();
            }
            av = 4;
        }
        if (Carmelized4.isSelected()) {
            if (av == 0) {
                a = a + Carmelized4.getText();
            } else {
                a = a + "," + Carmelized4.getText();
            }
            av = 4;
        }
        if (Honey4.isSelected()) {
            if (av == 0) {
                a = a + Honey4.getText();
            } else {
                a = a + "," + Honey4.getText();
            }
            av = 4;
        }
        if (Vanilla4.isSelected()) {
            if (av == 0) {
                a = a + Vanilla4.getText();
            } else {
                a = a + "," + Vanilla4.getText();
            }
            av = 4;
        }

        if (Blacktea4.isSelected()) {
            if (av == 0) {
                a = a + Blacktea4.getText();
            } else {
                a = a + "," + Blacktea4.getText();
            }
            av = 4;
        }

        if (Chamomile4.isSelected()) {
            if (av == 0) {
                a = a + Chamomile4.getText();
            } else {
                a = a + "," + Chamomile4.getText();
            }
            av = 4;
        }
        if (Rose4.isSelected()) {
            if (av == 0) {
                a = a + Rose4.getText();
            } else {
                a = a + "," + Rose4.getText();
            }
            av = 4;
        }
        if (Jasmine4.isSelected()) {
            if (av == 0) {
                a = a + Jasmine4.getText();
            } else {
                a = a + "," + Jasmine4.getText();
            }
            av = 4;
        }

        if (Blackberry4.isSelected()) {
            if (av == 0) {
                a = a + Blackberry4.getText();
            } else {
                a = a + "," + Blackberry4.getText();
            }
            av = 4;
        }
        if (Raspberry4.isSelected()) {
            if (av == 0) {
                a = a + Raspberry4.getText();
            } else {
                a = a + "," + Raspberry4.getText();
            }
            av = 4;
        }
        if (Blueberry4.isSelected()) {
            if (av == 0) {
                a = a + Blueberry4.getText();
            } else {
                a = a + "," + Blueberry4.getText();
            }
            av = 4;
        }
        if (Strawberry4.isSelected()) {
            if (av == 0) {
                a = a + Strawberry4.getText();
            } else {
                a = a + "," + Strawberry4.getText();
            }
            av = 4;
        }
        if (Raisen4.isSelected()) {
            if (av == 0) {
                a = a + Raisen4.getText();
            } else {
                a = a + "," + Raisen4.getText();
            }
            av = 4;
        }
        if (Prune4.isSelected()) {
            if (av == 0) {
                a = a + Prune4.getText();
            } else {
                a = a + "," + Prune4.getText();
            }
            av = 4;
        }
        if (Coconut4.isSelected()) {
            if (av == 0) {
                a = a + Coconut4.getText();
            } else {
                a = a + "," + Coconut4.getText();
            }
            av = 4;
        }
        if (Cherry4.isSelected()) {
            if (av == 0) {
                a = a + Cherry4.getText();
            } else {
                a = a + "," + Cherry4.getText();
            }
            av = 4;
        }
        if (Pomagranite4.isSelected()) {
            if (av == 0) {
                a = a + Pomagranite4.getText();
            } else {
                a = a + "," + Pomagranite4.getText();
            }
            av = 4;
        }
        if (Pinneapple4.isSelected()) {
            if (av == 0) {
                a = a + Pinneapple4.getText();
            } else {
                a = a + "," + Pinneapple4.getText();
            }
            av = 4;
        }
        if (Grape4.isSelected()) {
            if (av == 0) {
                a = a + Grape4.getText();
            } else {
                a = a + "," + Grape4.getText();
            }
            av = 4;
        }
        if (Apple4.isSelected()) {
            if (av == 0) {
                a = a + Apple4.getText();
            } else {
                a = a + "," + Apple4.getText();
            }
            av = 4;
        }
        if (Peach4.isSelected()) {
            if (av == 0) {
                a = a + Peach4.getText();
            } else {
                a = a + "," + Peach4.getText();
            }
            av = 4;
        }
        if (Pear4.isSelected()) {
            if (av == 0) {
                a = a + Pear4.getText();
            } else {
                a = a + "," + Pear4.getText();
            }
            av = 4;
        }
        if (Grapefruit4.isSelected()) {
            if (av == 0) {
                a = a + Grapefruit4.getText();
            } else {
                a = a + "," + Grapefruit4.getText();
            }
            av = 4;
        }
        if (Orange4.isSelected()) {
            if (av == 0) {
                a = a + Orange4.getText();
            } else {
                a = a + "," + Orange4.getText();
            }
            av = 4;
        }
        if (Lemon4.isSelected()) {
            if (av == 0) {
                a = a + Lemon4.getText();
            } else {
                a = a + "," + Lemon4.getText();
            }
            av = 4;
        }
        if (Lime4.isSelected()) {
            if (av == 0) {
                a = a + Lime4.getText();
            } else {
                a = a + "," + Lime4.getText();
            }
            av = 4;
        }
        if (Vinegar4.isSelected()) {
            if (av == 0) {
                a = a + Vinegar4.getText();
            } else {
                a = a + "," + Vinegar4.getText();
            }
            av = 4;
        }
        if (Rancidbutter4.isSelected()) {
            if (av == 0) {
                a = a + Rancidbutter4.getText();
            } else {
                a = a + "," + Rancidbutter4.getText();
            }
            av = 4;
        }
        if (RancidCheese4.isSelected()) {
            if (av == 0) {
                a = a + RancidCheese4.getText();
            } else {
                a = a + "," + RancidCheese4.getText();
            }
            av = 4;
        }
        if (OrangeAcidity4.isSelected()) {
            if (av == 0) {
                a = a + OrangeAcidity4.getText();
            } else {
                a = a + "," + OrangeAcidity4.getText();
            }
            av = 4;
        }
        if (AppleAcidity4.isSelected()) {
            if (av == 0) {
                a = a + AppleAcidity4.getText();
            } else {
                a = a + "," + AppleAcidity4.getText();
            }
            av = 4;
        }
        if (Winey4.isSelected()) {
            if (av == 0) {
                a = a + Winey4.getText();
            } else {
                a = a + "," + Winey4.getText();
            }
            av = 4;
        }
        if (Whiskey4.isSelected()) {
            if (av == 0) {
                a = a + Whiskey4.getText();
            } else {
                a = a + "," + Whiskey4.getText();
            }
            av = 4;
        }
        if (Fermented4.isSelected()) {
            if (av == 0) {
                a = a + Fermented4.getText();
            } else {
                a = a + "," + Fermented4.getText();
            }
            av = 4;
        }
        if (Overripe4.isSelected()) {
            if (av == 0) {
                a = a + Overripe4.getText();
            } else {
                a = a + "," + Overripe4.getText();
            }
            av = 4;
        }
        if (OliveOil4.isSelected()) {
            if (av == 0) {
                a = a + OliveOil4.getText();
            } else {
                a = a + "," + OliveOil4.getText();
            }
            av = 4;
        }
        if (Raw4.isSelected()) {
            if (av == 0) {
                a = a + Raw4.getText();
            } else {
                a = a + "," + Raw4.getText();
            }
            av = 4;
        }
        if (Underripe4.isSelected()) {
            if (av == 0) {
                a = a + Underripe4.getText();
            } else {
                a = a + "," + Underripe4.getText();
            }
            av = 4;
        }
        if (Peapod4.isSelected()) {
            if (av == 0) {
                a = a + Peapod4.getText();
            } else {
                a = a + "," + Peapod4.getText();
            }
            av = 4;
        }
        if (Fresh4.isSelected()) {
            if (av == 0) {
                a = a + Fresh4.getText();
            } else {
                a = a + "," + Fresh4.getText();
            }
            av = 4;
        }
        if (DarkGreen4.isSelected()) {
            if (av == 0) {
                a = a + DarkGreen4.getText();
            } else {
                a = a + "," + DarkGreen4.getText();
            }
            av = 4;
        }
        if (Vegetative4.isSelected()) {
            if (av == 0) {
                a = a + Vegetative4.getText();
            } else {
                a = a + "," + Vegetative4.getText();
            }
            av = 4;
        }
        if (Haylike4.isSelected()) {
            if (av == 0) {
                a = a + Haylike4.getText();
            } else {
                a = a + "," + Haylike4.getText();
            }
            av = 4;
        }
        if (Herblike4.isSelected()) {
            if (av == 0) {
                a = a + Herblike4.getText();
            } else {
                a = a + "," + Herblike4.getText();
            }
            av = 4;
        }
        if (Beany4.isSelected()) {
            if (av == 0) {
                a = a + Beany4.getText();
            } else {
                a = a + "," + Beany4.getText();
            }
            av = 4;
        }
        if (Stale4.isSelected()) {
            if (av == 0) {
                a = a + Stale4.getText();
            } else {
                a = a + "," + Stale4.getText();
            }
            av = 4;
        }
        if (Cardboard4.isSelected()) {
            if (av == 0) {
                a = a + Cardboard4.getText();
            } else {
                a = a + "," + Cardboard4.getText();
            }
            av = 4;
        }
        if (Papery4.isSelected()) {
            if (av == 0) {
                a = a + Papery4.getText();
            } else {
                a = a + "," + Papery4.getText();
            }
            av = 4;
        }
        if (Woody4.isSelected()) {
            if (av == 0) {
                a = a + Woody4.getText();
            } else {
                a = a + "," + Woody4.getText();
            }
            av = 4;
        }
        if (MoldyDamp4.isSelected()) {
            if (av == 0) {
                a = a + MoldyDamp4.getText();
            } else {
                a = a + "," + MoldyDamp4.getText();
            }
            av = 4;
        }
        if (MustyDusty4.isSelected()) {
            if (av == 0) {
                a = a + MustyDusty4.getText();
            } else {
                a = a + "," + MustyDusty4.getText();
            }
            av = 4;
        }
        if (MustyEarthy4.isSelected()) {
            if (av == 0) {
                a = a + MustyEarthy4.getText();
            } else {
                a = a + "," + MustyEarthy4.getText();
            }
            av = 4;
        }
        if (Animalic4.isSelected()) {
            if (av == 0) {
                a = a + Animalic4.getText();
            } else {
                a = a + "," + Animalic4.getText();
            }
            av = 4;
        }
        if (MeatyBrothy4.isSelected()) {
            if (av == 0) {
                a = a + MeatyBrothy4.getText();
            } else {
                a = a + "," + MeatyBrothy4.getText();
            }
            av = 4;
        }
        if (Phenolic4.isSelected()) {
            if (av == 0) {
                a = a + Phenolic4.getText();
            } else {
                a = a + "," + Phenolic4.getText();
            }
            av = 4;
        }
        if (Bitter4.isSelected()) {
            if (av == 0) {
                a = a + Bitter4.getText();
            } else {
                a = a + "," + Bitter4.getText();
            }
            av = 4;
        }
        if (Salty4.isSelected()) {
            if (av == 0) {
                a = a + Salty4.getText();
            } else {
                a = a + "," + Salty4.getText();
            }
            av = 4;
        }
        if (Medicinal4.isSelected()) {
            if (av == 0) {
                a = a + Medicinal4.getText();
            } else {
                a = a + "," + Medicinal4.getText();
            }
            av = 4;
        }
        if (Petroleum4.isSelected()) {
            if (av == 0) {
                a = a + Petroleum4.getText();
            } else {
                a = a + "," + Petroleum4.getText();
            }
            av = 4;
        }
        if (Skunky4.isSelected()) {
            if (av == 0) {
                a = a + Skunky4.getText();
            } else {
                a = a + "," + Skunky4.getText();
            }
            av = 4;
        }
        if (Rubber4.isSelected()) {
            if (av == 0) {
                a = a + Rubber4.getText();
            } else {
                a = a + "," + Rubber4.getText();
            }
            av = 4;
        }
        if (PipeTobacco4.isSelected()) {
            if (av == 0) {
                a = a + PipeTobacco4.getText();
            } else {
                a = a + "," + PipeTobacco4.getText();
            }
            av = 4;
        }
        if (Tobacco4.isSelected()) {
            if (av == 0) {
                a = a + Tobacco4.getText();
            } else {
                a = a + "," + Tobacco4.getText();
            }
            av = 4;
        }
        if (Acrid4.isSelected()) {
            if (av == 0) {
                a = a + Acrid4.getText();
            } else {
                a = a + "," + Acrid4.getText();
            }
            av = 4;
        }
        if (Ashy4.isSelected()) {
            if (av == 0) {
                a = a + Ashy4.getText();
            } else {
                a = a + "," + Ashy4.getText();
            }
            av = 4;
        }
        if (Smoky4.isSelected()) {
            if (av == 0) {
                a = a + Smoky4.getText();
            } else {
                a = a + "," + Smoky4.getText();
            }
            av = 4;
        }
        if (BrownRoast4.isSelected()) {
            if (av == 0) {
                a = a + BrownRoast4.getText();
            } else {
                a = a + "," + BrownRoast4.getText();
            }
            av = 4;
        }
        if (Grain4.isSelected()) {
            if (av == 0) {
                a = a + Grain4.getText();
            } else {
                a = a + "," + Grain4.getText();
            }
            av = 4;
        }
        if (Malt4.isSelected()) {
            if (av == 0) {
                a = a + Malt4.getText();
            } else {
                a = a + "," + Malt4.getText();
            }
            av = 4;
        }
        if (Pungent4.isSelected()) {
            if (av == 0) {
                a = a + Pungent4.getText();
            } else {
                a = a + "," + Pungent4.getText();
            }
            av = 4;
        }
        if (Pepper4.isSelected()) {
            if (av == 0) {
                a = a + Pepper4.getText();
            } else {
                a = a + "," + Pepper4.getText();
            }
            av = 4;
        }
        if (Anise4.isSelected()) {
            if (av == 0) {
                a = a + Anise4.getText();
            } else {
                a = a + "," + Anise4.getText();
            }
            av = 4;
        }
        if (Nutmeg4.isSelected()) {
            if (av == 0) {
                a = a + Nutmeg4.getText();
            } else {
                a = a + "," + Nutmeg4.getText();
            }
            av = 4;
        }
        if (Cinnamon4.isSelected()) {
            if (av == 0) {
                a = a + Cinnamon4.getText();
            } else {
                a = a + "," + Cinnamon4.getText();
            }
            av = 4;
        }
        if (Clove4.isSelected()) {
            if (av == 0) {
                a = a + Clove4.getText();
            } else {
                a = a + "," + Clove4.getText();
            }
            av = 4;
        }
        if (Nutty4.isSelected()) {
            if (av == 0) {
                a = a + Nutty4.getText();
            } else {
                a = a + "," + Nutty4.getText();
            }
            av = 4;
        }
        if (Peanuts4.isSelected()) {
            if (av == 0) {
                a = a + Peanuts4.getText();
            } else {
                a = a + "," + Peanuts4.getText();
            }
            av = 4;
        }
        if (Hazelenut4.isSelected()) {
            if (av == 0) {
                a = a + Hazelenut4.getText();
            } else {
                a = a + "," + Hazelenut4.getText();
            }
            av = 4;
        }
        if (Almond4.isSelected()) {
            if (av == 0) {
                a = a + Almond4.getText();
            } else {
                a = a + "," + Almond4.getText();
            }
            av = 4;
        }
        if (Chocolate4.isSelected()) {
            if (av == 0) {
                a = a + Chocolate4.getText();
            } else {
                a = a + "," + Chocolate4.getText();
            }
            av = 4;
        }
        if (DarkChocolate4.isSelected()) {
            if (av == 0) {
                a = a + DarkChocolate4.getText();
            } else {
                a = a + "," + DarkChocolate4.getText();
            }
            av = 4;
        }
        if (Short1.isSelected()) {
            if (av == 0) {
                a = a + "-finish=" + Short1.getText();
            } else {
                a = a + ",-finish=" + Short1.getText();
            }
            av = 4;
        }
        if (Medium.isSelected()) {
            if (av == 0) {
                a = a + "-finish=" + Medium.getText();
            } else {
                a = a + ",-finish=" + Medium.getText();
            }
            av = 4;
        }
        if (Long.isSelected()) {
            if (av == 0) {
                a = a + "-finish=" + Long.getText();
            } else {
                a = a + ",-finish=" + Long.getText();
            }
            av = 4;
        }
        if (Dryf.isSelected()) {
            if (av == 0) {
                a = a + "-finish=" + Dryf.getText();
            } else {
                a = a + ",-finish=" + Dryf.getText();
            }
            av = 4;
        }
        if (Astringent.isSelected()) {
            if (av == 0) {
                a = a + "-finish=" + Astringent.getText();
            } else {
                a = a + ",-finish=" + Astringent.getText();
            }
            av = 4;
        }
        if (av != 1) {
            a = "Aftertaste:" + a + ";";
        }
        if (Vinegar5.isSelected()) {
            if (acv == 0) {
                ac = ac + Vinegar5.getText();
            } else {
                ac = ac + "," + Vinegar5.getText();
            }
            acv = 5;
        }
        if (Rancidbutter5.isSelected()) {
            if (acv == 0) {
                ac = ac + Rancidbutter5.getText();
            } else {
                ac = ac + "," + Rancidbutter5.getText();
            }
            acv = 5;
        }
        if (RancidCheese5.isSelected()) {
            if (acv == 0) {
                ac = ac + RancidCheese5.getText();
            } else {
                ac = ac + "," + RancidCheese5.getText();
            }
            acv = 5;
        }
        if (OrangeAcidity5.isSelected()) {
            if (acv == 0) {
                ac = ac + OrangeAcidity5.getText();
            } else {
                ac = ac + "," + OrangeAcidity5.getText();
            }
            acv = 5;
        }
        if (AppleAcidity5.isSelected()) {
            if (acv == 0) {
                ac = ac + AppleAcidity5.getText();
            } else {
                ac = ac + "," + AppleAcidity5.getText();
            }
            acv = 5;
        }
        if (Winey5.isSelected()) {
            if (acv == 0) {
                ac = ac + Winey5.getText();
            } else {
                ac = ac + "," + Winey5.getText();
            }
            acv = 5;
        }
        if (Whiskey5.isSelected()) {
            if (acv == 0) {
                ac = ac + Whiskey5.getText();
            } else {
                ac = ac + "," + Whiskey5.getText();
            }
            acv = 5;
        }
        if (Fermented5.isSelected()) {
            if (acv == 0) {
                ac = ac + Fermented5.getText();
            } else {
                ac = ac + "," + Fermented5.getText();
            }
            acv = 5;
        }
        if (Overripe5.isSelected()) {
            if (acv == 0) {
                ac = ac + Overripe5.getText();
            } else {
                ac = ac + "," + Overripe5.getText();
            }
            acv = 5;
        }
        if (acv != 1) {
            ac = "Acidity:" + ac + ";";
        }
        /*if (Thin.isSelected()) {
            if (bov == 0) {
                bo = Thin.getText();
            }
            bov = 6;
        }
        if (Mediumbody.isSelected()) {
            if (bov == 0) {
                bo = Mediumbody.getText();
            }
            bov = 6;
        }
        if (Heavy.isSelected()) {
            if (bov == 0) {
                bo = Heavy.getText();
            }
            bov = 6;
        }
        if (Syrupy.isSelected()) {
            if (bov == 0) {
                bo = Syrupy.getText();
            }
            bov = 6;
        }
        if (Oily.isSelected()) {
            if (bov == 0) {
                bo = Oily.getText();
            }
            bov = 6;
        }
        if (Smooth.isSelected()) {
            if (bov == 0) {
                bo = Smooth.getText();
            }
            bov = 6;
        }
        if (bov != 1) {
            bo = "Body:" + bo + ";";
        }*/
        Flavors = d + w + b + f + a + ac + bo;
        System.out.println(Flavors);
        String insert = "", update = "", estatus = "T";
        String aspecto = mdb.devuelveUnDato("select aspecto from bitacoralab "
                + "where (id_muestra='" + csm + "' and comunidad='" + comunindad + "')");
        if (aspecto.equals("1")) {
            estatus = "Disp";
        }
        insert = "insert into catacion values (null," + id + "," + nt + "," + uniformidadtostado.getValue() + "," + quakers.getText() + ",'" + Puntuacion.getText() + "'," + Tazas.getText() + "," + Defectos.getText() + "," + numtazasdefectos.getText() + "," + intensidadefectos.getText() + "," + uniformtaza.getText() + "," + tazalimpia.getText() + "," + dulzor.getText() + ",'" + dry.getText() + "','" + wet.getText() + "','" + breaks.getText() + "','" + aroma.getText() + "','" + flavor.getText() + "','" + Aftertaste.getText() + "','" + Acidity.getText() + "','" + intensidadacidity.getValue() + "','" + Body.getText() + "','" + intensidadbody.getValue() + "','" + Balance.getText() + "','" + Catador.getText() + "','Consenso','" + fecha + "','" + DenTost.getText() + "')";
        update = "update bitacoralab set taza='1'   , sabores='" + Flavors + "' where id_bitacora=" + id;
        if (fecha != null) {
            //if (p1>=3) {
            // if (p2>=3) {
            //  if (p3>=3) {
            //    if (p4>=3) {
            //     if (p5>=3) {
            //      if (p6>=3) {
            //            if (p7>0) {
            //         if (p8>0) {
            try {

                mdb.insertarBasicos("insert into catacion values (null," + id + "," + nt + "," + uniformidadtostado.getValue() + "," + quakers.getText() + ",'" + Puntuacion.getText() + "'," + Tazas.getText() + "," + Defectos.getText() + "," + numtazasdefectos.getText() + "," + intensidadefectos.getText() + "," + uniformtaza.getText() + "," + tazalimpia.getText() + "," + dulzor.getText() + ",'" + dry.getText() + "','" + wet.getText() + "','" + breaks.getText() + "','" + aroma.getText() + "','" + flavor.getText() + "','" + Aftertaste.getText() + "','" + Acidity.getText() + "','" + intensidadacidity.getValue() + "','" + Body.getText() + "','" + intensidadbody.getValue() + "','" + Balance.getText() + "','" + Catador.getText() + "','Consenso','" + fecha + "','" + DenTost.getText() + "')");
                mdb.actualizarBasicos("update bitacoralab set taza='1' ,estatus='" + estatus + "'  , sabores='" + Flavors + "' where id_bitacora=" + id);
                jpCT.llenarTabla();
                try {
                    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (Exception e) {
                    // If Nimbus is not available, you can set the GUI to another look and feel.
                }
                this.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            //                  }else{JOptionPane.showMessageDialog(null, "¡Selecciona almenos 1 opcion de Finish en el apartado Aftertaste!");paint(8); }
            //             }else{JOptionPane.showMessageDialog(null, "¡Selecciona almenos una opcion en el apartado Body!");paint(7); }
            //          }else{JOptionPane.showMessageDialog(null, "¡Selecciona almenos 3 sabores en el apartado Acidity!");paint(6); }
            //      }else{JOptionPane.showMessageDialog(null, "¡Selecciona almenos 3 sabores en el apartado Aftertaste!");paint(5); }
            //    }else{JOptionPane.showMessageDialog(null, "¡Selecciona almenos 3 sabores en el apartado Flavor!");paint(4); }
            //   }else{JOptionPane.showMessageDialog(null, "¡Selecciona almenos 3 sabores en el apartado Break!");paint(3); }
            // }else{JOptionPane.showMessageDialog(null, "¡Selecciona almenos 3 sabores en el apartado Wet!");paint(2); }
            //  }else{JOptionPane.showMessageDialog(null, "¡Selecciona almenos 3 sabores en el apartado Dry!");paint(1); }
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JdCatacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdCatacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdCatacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdCatacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
 /*    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JdCatacion dialog = new JdCatacion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        //</editor-fold>

        /* Create and display the dialog */
 /*    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JdCatacion dialog = new JdCatacion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Acidity;
    private javax.swing.JPanel Acidityp;
    private javax.swing.JSlider Acidityteslider;
    private javax.swing.JRadioButton Acrid;
    private javax.swing.JRadioButton Acrid1;
    private javax.swing.JRadioButton Acrid2;
    private javax.swing.JRadioButton Acrid3;
    private javax.swing.JRadioButton Acrid4;
    private javax.swing.JTextField Aftertaste;
    private javax.swing.JSlider Aftertasteslider;
    private javax.swing.JRadioButton Alcohol;
    private javax.swing.JRadioButton Alcohol1;
    private javax.swing.JRadioButton Alcohol2;
    private javax.swing.JRadioButton Alcohol3;
    private javax.swing.JRadioButton Alcohol4;
    private javax.swing.JRadioButton Almond;
    private javax.swing.JRadioButton Almond1;
    private javax.swing.JRadioButton Almond2;
    private javax.swing.JRadioButton Almond3;
    private javax.swing.JRadioButton Almond4;
    private javax.swing.JRadioButton Animalic;
    private javax.swing.JRadioButton Animalic1;
    private javax.swing.JRadioButton Animalic2;
    private javax.swing.JRadioButton Animalic3;
    private javax.swing.JRadioButton Animalic4;
    private javax.swing.JRadioButton Anise;
    private javax.swing.JRadioButton Anise1;
    private javax.swing.JRadioButton Anise2;
    private javax.swing.JRadioButton Anise3;
    private javax.swing.JRadioButton Anise4;
    private javax.swing.JRadioButton Apple;
    private javax.swing.JRadioButton Apple1;
    private javax.swing.JRadioButton Apple2;
    private javax.swing.JRadioButton Apple3;
    private javax.swing.JRadioButton Apple4;
    private javax.swing.JRadioButton AppleAcidity;
    private javax.swing.JRadioButton AppleAcidity1;
    private javax.swing.JRadioButton AppleAcidity2;
    private javax.swing.JRadioButton AppleAcidity3;
    private javax.swing.JRadioButton AppleAcidity4;
    private javax.swing.JRadioButton AppleAcidity5;
    private javax.swing.JRadioButton Ashy;
    private javax.swing.JRadioButton Ashy1;
    private javax.swing.JRadioButton Ashy2;
    private javax.swing.JRadioButton Ashy3;
    private javax.swing.JRadioButton Ashy4;
    private javax.swing.JRadioButton Astringent;
    private javax.swing.JTextField Balance;
    private javax.swing.JSlider Balanceslider;
    private javax.swing.JRadioButton Beany;
    private javax.swing.JRadioButton Beany1;
    private javax.swing.JRadioButton Beany2;
    private javax.swing.JRadioButton Beany3;
    private javax.swing.JRadioButton Beany4;
    private javax.swing.JRadioButton Berry;
    private javax.swing.JRadioButton Berry1;
    private javax.swing.JRadioButton Berry2;
    private javax.swing.JRadioButton Berry3;
    private javax.swing.JRadioButton Berry4;
    private javax.swing.JRadioButton Bitter;
    private javax.swing.JRadioButton Bitter1;
    private javax.swing.JRadioButton Bitter2;
    private javax.swing.JRadioButton Bitter3;
    private javax.swing.JRadioButton Bitter4;
    private javax.swing.JRadioButton Blackberry;
    private javax.swing.JRadioButton Blackberry1;
    private javax.swing.JRadioButton Blackberry2;
    private javax.swing.JRadioButton Blackberry3;
    private javax.swing.JRadioButton Blackberry4;
    private javax.swing.JRadioButton Blacktea;
    private javax.swing.JRadioButton Blacktea1;
    private javax.swing.JRadioButton Blacktea2;
    private javax.swing.JRadioButton Blacktea3;
    private javax.swing.JRadioButton Blacktea4;
    private javax.swing.JRadioButton Blueberry;
    private javax.swing.JRadioButton Blueberry1;
    private javax.swing.JRadioButton Blueberry2;
    private javax.swing.JRadioButton Blueberry3;
    private javax.swing.JRadioButton Blueberry4;
    private javax.swing.JTextField Body;
    private javax.swing.JSlider Bodyslider;
    private javax.swing.JRadioButton BrownRoast;
    private javax.swing.JRadioButton BrownRoast1;
    private javax.swing.JRadioButton BrownRoast2;
    private javax.swing.JRadioButton BrownRoast3;
    private javax.swing.JRadioButton BrownRoast4;
    private javax.swing.JRadioButton BrownSugar;
    private javax.swing.JRadioButton BrownSugar1;
    private javax.swing.JRadioButton BrownSugar2;
    private javax.swing.JRadioButton BrownSugar3;
    private javax.swing.JRadioButton BrownSugar4;
    private javax.swing.JRadioButton Brownspices;
    private javax.swing.JRadioButton Brownspices1;
    private javax.swing.JRadioButton Brownspices2;
    private javax.swing.JRadioButton Brownspices3;
    private javax.swing.JRadioButton Brownspices4;
    private javax.swing.JRadioButton Burnt;
    private javax.swing.JRadioButton Burnt1;
    private javax.swing.JRadioButton Burnt2;
    private javax.swing.JRadioButton Burnt3;
    private javax.swing.JRadioButton Burnt4;
    private javax.swing.JRadioButton Cardboard;
    private javax.swing.JRadioButton Cardboard1;
    private javax.swing.JRadioButton Cardboard2;
    private javax.swing.JRadioButton Cardboard3;
    private javax.swing.JRadioButton Cardboard4;
    private javax.swing.JRadioButton Carmelized;
    private javax.swing.JRadioButton Carmelized1;
    private javax.swing.JRadioButton Carmelized2;
    private javax.swing.JRadioButton Carmelized3;
    private javax.swing.JRadioButton Carmelized4;
    private javax.swing.JTextField Catador;
    private javax.swing.JSlider Catadorslider;
    private javax.swing.JRadioButton Cereal;
    private javax.swing.JRadioButton Cereal1;
    private javax.swing.JRadioButton Cereal2;
    private javax.swing.JRadioButton Cereal3;
    private javax.swing.JRadioButton Cereal4;
    private javax.swing.JRadioButton Chamomile;
    private javax.swing.JRadioButton Chamomile1;
    private javax.swing.JRadioButton Chamomile2;
    private javax.swing.JRadioButton Chamomile3;
    private javax.swing.JRadioButton Chamomile4;
    private javax.swing.JRadioButton Chemical;
    private javax.swing.JRadioButton Chemical1;
    private javax.swing.JRadioButton Chemical2;
    private javax.swing.JRadioButton Chemical3;
    private javax.swing.JRadioButton Chemical4;
    private javax.swing.JRadioButton Cherry;
    private javax.swing.JRadioButton Cherry1;
    private javax.swing.JRadioButton Cherry2;
    private javax.swing.JRadioButton Cherry3;
    private javax.swing.JRadioButton Cherry4;
    private javax.swing.JRadioButton Chocolate;
    private javax.swing.JRadioButton Chocolate1;
    private javax.swing.JRadioButton Chocolate2;
    private javax.swing.JRadioButton Chocolate3;
    private javax.swing.JRadioButton Chocolate4;
    private javax.swing.JRadioButton Cinnamon;
    private javax.swing.JRadioButton Cinnamon1;
    private javax.swing.JRadioButton Cinnamon2;
    private javax.swing.JRadioButton Cinnamon3;
    private javax.swing.JRadioButton Cinnamon4;
    private javax.swing.JRadioButton Citrusfruit;
    private javax.swing.JRadioButton Citrusfruit1;
    private javax.swing.JRadioButton Citrusfruit2;
    private javax.swing.JRadioButton Citrusfruit3;
    private javax.swing.JRadioButton Citrusfruit4;
    private javax.swing.JRadioButton Clove;
    private javax.swing.JRadioButton Clove1;
    private javax.swing.JRadioButton Clove2;
    private javax.swing.JRadioButton Clove3;
    private javax.swing.JRadioButton Clove4;
    private javax.swing.JRadioButton Cocoa;
    private javax.swing.JRadioButton Cocoa1;
    private javax.swing.JRadioButton Cocoa2;
    private javax.swing.JRadioButton Cocoa3;
    private javax.swing.JRadioButton Cocoa4;
    private javax.swing.JRadioButton Coconut;
    private javax.swing.JRadioButton Coconut1;
    private javax.swing.JRadioButton Coconut2;
    private javax.swing.JRadioButton Coconut3;
    private javax.swing.JRadioButton Coconut4;
    private javax.swing.JLabel Csm;
    private javax.swing.JRadioButton DarkChocolate;
    private javax.swing.JRadioButton DarkChocolate1;
    private javax.swing.JRadioButton DarkChocolate2;
    private javax.swing.JRadioButton DarkChocolate3;
    private javax.swing.JRadioButton DarkChocolate4;
    private javax.swing.JRadioButton DarkGreen;
    private javax.swing.JRadioButton DarkGreen1;
    private javax.swing.JRadioButton DarkGreen2;
    private javax.swing.JRadioButton DarkGreen3;
    private javax.swing.JRadioButton DarkGreen4;
    private javax.swing.JLabel Defectos;
    private javax.swing.JTextField DenTost;
    private javax.swing.JRadioButton DriedFruit;
    private javax.swing.JRadioButton DriedFruit1;
    private javax.swing.JRadioButton DriedFruit2;
    private javax.swing.JRadioButton DriedFruit3;
    private javax.swing.JRadioButton DriedFruit4;
    private javax.swing.JPanel Dry;
    private javax.swing.JRadioButton Dryf;
    private javax.swing.JRadioButton Fermented;
    private javax.swing.JRadioButton Fermented1;
    private javax.swing.JRadioButton Fermented2;
    private javax.swing.JRadioButton Fermented3;
    private javax.swing.JRadioButton Fermented4;
    private javax.swing.JRadioButton Fermented5;
    private javax.swing.JPanel Fisnish;
    private javax.swing.JRadioButton Floral;
    private javax.swing.JRadioButton Floral1;
    private javax.swing.JRadioButton Floral2;
    private javax.swing.JRadioButton Floral3;
    private javax.swing.JRadioButton Floral4;
    private javax.swing.JRadioButton Fresh;
    private javax.swing.JRadioButton Fresh1;
    private javax.swing.JRadioButton Fresh2;
    private javax.swing.JRadioButton Fresh3;
    private javax.swing.JRadioButton Fresh4;
    private javax.swing.JRadioButton Fruity;
    private javax.swing.JRadioButton Fruity1;
    private javax.swing.JRadioButton Fruity2;
    private javax.swing.JRadioButton Fruity3;
    private javax.swing.JRadioButton Fruity4;
    private javax.swing.JRadioButton Grain;
    private javax.swing.JRadioButton Grain1;
    private javax.swing.JRadioButton Grain2;
    private javax.swing.JRadioButton Grain3;
    private javax.swing.JRadioButton Grain4;
    private javax.swing.JRadioButton Grape;
    private javax.swing.JRadioButton Grape1;
    private javax.swing.JRadioButton Grape2;
    private javax.swing.JRadioButton Grape3;
    private javax.swing.JRadioButton Grape4;
    private javax.swing.JRadioButton Grapefruit;
    private javax.swing.JRadioButton Grapefruit1;
    private javax.swing.JRadioButton Grapefruit2;
    private javax.swing.JRadioButton Grapefruit3;
    private javax.swing.JRadioButton Grapefruit4;
    private javax.swing.JRadioButton Green;
    private javax.swing.JRadioButton Green1;
    private javax.swing.JRadioButton Green2;
    private javax.swing.JRadioButton Green3;
    private javax.swing.JRadioButton Green4;
    private javax.swing.JRadioButton Haylike;
    private javax.swing.JRadioButton Haylike1;
    private javax.swing.JRadioButton Haylike2;
    private javax.swing.JRadioButton Haylike3;
    private javax.swing.JRadioButton Haylike4;
    private javax.swing.JRadioButton Hazelenut;
    private javax.swing.JRadioButton Hazelenut1;
    private javax.swing.JRadioButton Hazelenut2;
    private javax.swing.JRadioButton Hazelenut3;
    private javax.swing.JRadioButton Hazelenut4;
    private javax.swing.JRadioButton Heavy1;
    private javax.swing.JRadioButton Herblike;
    private javax.swing.JRadioButton Herblike1;
    private javax.swing.JRadioButton Herblike2;
    private javax.swing.JRadioButton Herblike3;
    private javax.swing.JRadioButton Herblike4;
    private javax.swing.JRadioButton Honey;
    private javax.swing.JRadioButton Honey1;
    private javax.swing.JRadioButton Honey2;
    private javax.swing.JRadioButton Honey3;
    private javax.swing.JRadioButton Honey4;
    private javax.swing.JRadioButton Jasmine;
    private javax.swing.JRadioButton Jasmine1;
    private javax.swing.JRadioButton Jasmine2;
    private javax.swing.JRadioButton Jasmine3;
    private javax.swing.JRadioButton Jasmine4;
    private javax.swing.JRadioButton Lemon;
    private javax.swing.JRadioButton Lemon1;
    private javax.swing.JRadioButton Lemon2;
    private javax.swing.JRadioButton Lemon3;
    private javax.swing.JRadioButton Lemon4;
    private javax.swing.JRadioButton Lime;
    private javax.swing.JRadioButton Lime1;
    private javax.swing.JRadioButton Lime2;
    private javax.swing.JRadioButton Lime3;
    private javax.swing.JRadioButton Lime4;
    private javax.swing.JRadioButton Long;
    private javax.swing.JRadioButton Malt;
    private javax.swing.JRadioButton Malt1;
    private javax.swing.JRadioButton Malt2;
    private javax.swing.JRadioButton Malt3;
    private javax.swing.JRadioButton Malt4;
    private javax.swing.JRadioButton MapleSugar;
    private javax.swing.JRadioButton MapleSugar1;
    private javax.swing.JRadioButton MapleSugar2;
    private javax.swing.JRadioButton MapleSugar3;
    private javax.swing.JRadioButton MapleSugar4;
    private javax.swing.JRadioButton MeatyBrothy;
    private javax.swing.JRadioButton MeatyBrothy1;
    private javax.swing.JRadioButton MeatyBrothy2;
    private javax.swing.JRadioButton MeatyBrothy3;
    private javax.swing.JRadioButton MeatyBrothy4;
    private javax.swing.JRadioButton Medicinal;
    private javax.swing.JRadioButton Medicinal1;
    private javax.swing.JRadioButton Medicinal2;
    private javax.swing.JRadioButton Medicinal3;
    private javax.swing.JRadioButton Medicinal4;
    private javax.swing.JRadioButton Medium;
    private javax.swing.JRadioButton Mediumbody1;
    private javax.swing.JRadioButton Molasses;
    private javax.swing.JRadioButton Molasses1;
    private javax.swing.JRadioButton Molasses2;
    private javax.swing.JRadioButton Molasses3;
    private javax.swing.JRadioButton Molasses4;
    private javax.swing.JRadioButton MoldyDamp;
    private javax.swing.JRadioButton MoldyDamp1;
    private javax.swing.JRadioButton MoldyDamp2;
    private javax.swing.JRadioButton MoldyDamp3;
    private javax.swing.JRadioButton MoldyDamp4;
    private javax.swing.JRadioButton MustyDusty;
    private javax.swing.JRadioButton MustyDusty1;
    private javax.swing.JRadioButton MustyDusty2;
    private javax.swing.JRadioButton MustyDusty3;
    private javax.swing.JRadioButton MustyDusty4;
    private javax.swing.JRadioButton MustyEarthy;
    private javax.swing.JRadioButton MustyEarthy1;
    private javax.swing.JRadioButton MustyEarthy2;
    private javax.swing.JRadioButton MustyEarthy3;
    private javax.swing.JRadioButton MustyEarthy4;
    private javax.swing.JRadioButton Nutmeg;
    private javax.swing.JRadioButton Nutmeg1;
    private javax.swing.JRadioButton Nutmeg2;
    private javax.swing.JRadioButton Nutmeg3;
    private javax.swing.JRadioButton Nutmeg4;
    private javax.swing.JRadioButton Nutty;
    private javax.swing.JRadioButton Nutty1;
    private javax.swing.JRadioButton Nutty2;
    private javax.swing.JRadioButton Nutty3;
    private javax.swing.JRadioButton Nutty4;
    private javax.swing.JRadioButton Nuttycocoa;
    private javax.swing.JRadioButton Nuttycocoa1;
    private javax.swing.JRadioButton Nuttycocoa2;
    private javax.swing.JRadioButton Nuttycocoa3;
    private javax.swing.JRadioButton Nuttycocoa4;
    private javax.swing.JRadioButton Oily1;
    private javax.swing.JRadioButton OliveOil;
    private javax.swing.JRadioButton OliveOil1;
    private javax.swing.JRadioButton OliveOil2;
    private javax.swing.JRadioButton OliveOil3;
    private javax.swing.JRadioButton OliveOil4;
    private javax.swing.JRadioButton Orange;
    private javax.swing.JRadioButton Orange1;
    private javax.swing.JRadioButton Orange2;
    private javax.swing.JRadioButton Orange3;
    private javax.swing.JRadioButton Orange4;
    private javax.swing.JRadioButton OrangeAcidity;
    private javax.swing.JRadioButton OrangeAcidity1;
    private javax.swing.JRadioButton OrangeAcidity2;
    private javax.swing.JRadioButton OrangeAcidity3;
    private javax.swing.JRadioButton OrangeAcidity4;
    private javax.swing.JRadioButton OrangeAcidity5;
    private javax.swing.JRadioButton Other;
    private javax.swing.JRadioButton Other1;
    private javax.swing.JRadioButton Other2;
    private javax.swing.JRadioButton Other3;
    private javax.swing.JRadioButton Other4;
    private javax.swing.JRadioButton Otherfruit;
    private javax.swing.JRadioButton Otherfruit1;
    private javax.swing.JRadioButton Otherfruit2;
    private javax.swing.JRadioButton Otherfruit3;
    private javax.swing.JRadioButton Otherfruit4;
    private javax.swing.JRadioButton Overripe;
    private javax.swing.JRadioButton Overripe1;
    private javax.swing.JRadioButton Overripe2;
    private javax.swing.JRadioButton Overripe3;
    private javax.swing.JRadioButton Overripe4;
    private javax.swing.JRadioButton Overripe5;
    private javax.swing.JRadioButton Papery;
    private javax.swing.JRadioButton Papery1;
    private javax.swing.JRadioButton Papery2;
    private javax.swing.JRadioButton Papery3;
    private javax.swing.JRadioButton Papery4;
    private javax.swing.JRadioButton PaperyM;
    private javax.swing.JRadioButton PaperyM1;
    private javax.swing.JRadioButton PaperyM2;
    private javax.swing.JRadioButton PaperyM3;
    private javax.swing.JRadioButton PaperyM4;
    private javax.swing.JRadioButton Peach;
    private javax.swing.JRadioButton Peach1;
    private javax.swing.JRadioButton Peach2;
    private javax.swing.JRadioButton Peach3;
    private javax.swing.JRadioButton Peach4;
    private javax.swing.JRadioButton Peanuts;
    private javax.swing.JRadioButton Peanuts1;
    private javax.swing.JRadioButton Peanuts2;
    private javax.swing.JRadioButton Peanuts3;
    private javax.swing.JRadioButton Peanuts4;
    private javax.swing.JRadioButton Peapod;
    private javax.swing.JRadioButton Peapod1;
    private javax.swing.JRadioButton Peapod2;
    private javax.swing.JRadioButton Peapod3;
    private javax.swing.JRadioButton Peapod4;
    private javax.swing.JRadioButton Pear;
    private javax.swing.JRadioButton Pear1;
    private javax.swing.JRadioButton Pear2;
    private javax.swing.JRadioButton Pear3;
    private javax.swing.JRadioButton Pear4;
    private javax.swing.JRadioButton Pepper;
    private javax.swing.JRadioButton Pepper1;
    private javax.swing.JRadioButton Pepper2;
    private javax.swing.JRadioButton Pepper3;
    private javax.swing.JRadioButton Pepper4;
    private javax.swing.JRadioButton Petroleum;
    private javax.swing.JRadioButton Petroleum1;
    private javax.swing.JRadioButton Petroleum2;
    private javax.swing.JRadioButton Petroleum3;
    private javax.swing.JRadioButton Petroleum4;
    private javax.swing.JRadioButton Phenolic;
    private javax.swing.JRadioButton Phenolic1;
    private javax.swing.JRadioButton Phenolic2;
    private javax.swing.JRadioButton Phenolic3;
    private javax.swing.JRadioButton Phenolic4;
    private javax.swing.JRadioButton Pinneapple;
    private javax.swing.JRadioButton Pinneapple1;
    private javax.swing.JRadioButton Pinneapple2;
    private javax.swing.JRadioButton Pinneapple3;
    private javax.swing.JRadioButton Pinneapple4;
    private javax.swing.JRadioButton PipeTobacco;
    private javax.swing.JRadioButton PipeTobacco1;
    private javax.swing.JRadioButton PipeTobacco2;
    private javax.swing.JRadioButton PipeTobacco3;
    private javax.swing.JRadioButton PipeTobacco4;
    private javax.swing.JRadioButton Pomagranite;
    private javax.swing.JRadioButton Pomagranite1;
    private javax.swing.JRadioButton Pomagranite2;
    private javax.swing.JRadioButton Pomagranite3;
    private javax.swing.JRadioButton Pomagranite4;
    private javax.swing.JRadioButton Prune;
    private javax.swing.JRadioButton Prune1;
    private javax.swing.JRadioButton Prune2;
    private javax.swing.JRadioButton Prune3;
    private javax.swing.JRadioButton Prune4;
    private javax.swing.JRadioButton Pungent;
    private javax.swing.JRadioButton Pungent1;
    private javax.swing.JRadioButton Pungent2;
    private javax.swing.JRadioButton Pungent3;
    private javax.swing.JRadioButton Pungent4;
    private javax.swing.JLabel Puntuacion;
    private javax.swing.JRadioButton Raisen;
    private javax.swing.JRadioButton Raisen1;
    private javax.swing.JRadioButton Raisen2;
    private javax.swing.JRadioButton Raisen3;
    private javax.swing.JRadioButton Raisen4;
    private javax.swing.JRadioButton RancidCheese;
    private javax.swing.JRadioButton RancidCheese1;
    private javax.swing.JRadioButton RancidCheese2;
    private javax.swing.JRadioButton RancidCheese3;
    private javax.swing.JRadioButton RancidCheese4;
    private javax.swing.JRadioButton RancidCheese5;
    private javax.swing.JRadioButton Rancidbutter;
    private javax.swing.JRadioButton Rancidbutter1;
    private javax.swing.JRadioButton Rancidbutter2;
    private javax.swing.JRadioButton Rancidbutter3;
    private javax.swing.JRadioButton Rancidbutter4;
    private javax.swing.JRadioButton Rancidbutter5;
    private javax.swing.JRadioButton Raspberry;
    private javax.swing.JRadioButton Raspberry1;
    private javax.swing.JRadioButton Raspberry2;
    private javax.swing.JRadioButton Raspberry3;
    private javax.swing.JRadioButton Raspberry4;
    private javax.swing.JRadioButton Raw;
    private javax.swing.JRadioButton Raw1;
    private javax.swing.JRadioButton Raw2;
    private javax.swing.JRadioButton Raw3;
    private javax.swing.JRadioButton Raw4;
    private javax.swing.JRadioButton Roasted;
    private javax.swing.JRadioButton Roasted1;
    private javax.swing.JRadioButton Roasted2;
    private javax.swing.JRadioButton Roasted3;
    private javax.swing.JRadioButton Roasted4;
    private javax.swing.JRadioButton Rose;
    private javax.swing.JRadioButton Rose1;
    private javax.swing.JRadioButton Rose2;
    private javax.swing.JRadioButton Rose3;
    private javax.swing.JRadioButton Rose4;
    private javax.swing.JRadioButton Rubber;
    private javax.swing.JRadioButton Rubber1;
    private javax.swing.JRadioButton Rubber2;
    private javax.swing.JRadioButton Rubber3;
    private javax.swing.JRadioButton Rubber4;
    private javax.swing.JRadioButton Salty;
    private javax.swing.JRadioButton Salty1;
    private javax.swing.JRadioButton Salty2;
    private javax.swing.JRadioButton Salty3;
    private javax.swing.JRadioButton Salty4;
    private javax.swing.JRadioButton Short1;
    private javax.swing.JRadioButton Skunky;
    private javax.swing.JRadioButton Skunky1;
    private javax.swing.JRadioButton Skunky2;
    private javax.swing.JRadioButton Skunky3;
    private javax.swing.JRadioButton Skunky4;
    private javax.swing.JRadioButton Smoky;
    private javax.swing.JRadioButton Smoky1;
    private javax.swing.JRadioButton Smoky2;
    private javax.swing.JRadioButton Smoky3;
    private javax.swing.JRadioButton Smoky4;
    private javax.swing.JRadioButton Smooth1;
    private javax.swing.JRadioButton Sour;
    private javax.swing.JRadioButton Sour1;
    private javax.swing.JRadioButton Sour2;
    private javax.swing.JRadioButton Sour3;
    private javax.swing.JRadioButton Sour4;
    private javax.swing.JRadioButton Spices;
    private javax.swing.JRadioButton Spices1;
    private javax.swing.JRadioButton Spices2;
    private javax.swing.JRadioButton Spices3;
    private javax.swing.JRadioButton Spices4;
    private javax.swing.JRadioButton Stale;
    private javax.swing.JRadioButton Stale1;
    private javax.swing.JRadioButton Stale2;
    private javax.swing.JRadioButton Stale3;
    private javax.swing.JRadioButton Stale4;
    private javax.swing.JRadioButton Strawberry;
    private javax.swing.JRadioButton Strawberry1;
    private javax.swing.JRadioButton Strawberry2;
    private javax.swing.JRadioButton Strawberry3;
    private javax.swing.JRadioButton Strawberry4;
    private javax.swing.JRadioButton Sweet;
    private javax.swing.JRadioButton Sweet1;
    private javax.swing.JRadioButton Sweet2;
    private javax.swing.JRadioButton Sweet3;
    private javax.swing.JRadioButton Sweet4;
    private javax.swing.JRadioButton Syrupy1;
    private javax.swing.JTextField Tazas;
    private javax.swing.JRadioButton Thin1;
    private javax.swing.JLabel Tipo;
    private javax.swing.JRadioButton Tobacco;
    private javax.swing.JRadioButton Tobacco1;
    private javax.swing.JRadioButton Tobacco2;
    private javax.swing.JRadioButton Tobacco3;
    private javax.swing.JRadioButton Tobacco4;
    private javax.swing.JRadioButton Underripe;
    private javax.swing.JRadioButton Underripe1;
    private javax.swing.JRadioButton Underripe2;
    private javax.swing.JRadioButton Underripe3;
    private javax.swing.JRadioButton Underripe4;
    private javax.swing.JRadioButton Vanilla;
    private javax.swing.JRadioButton Vanilla1;
    private javax.swing.JRadioButton Vanilla2;
    private javax.swing.JRadioButton Vanilla3;
    private javax.swing.JRadioButton Vanilla4;
    private javax.swing.JRadioButton Vegetative;
    private javax.swing.JRadioButton Vegetative1;
    private javax.swing.JRadioButton Vegetative2;
    private javax.swing.JRadioButton Vegetative3;
    private javax.swing.JRadioButton Vegetative4;
    private javax.swing.JRadioButton Vinegar;
    private javax.swing.JRadioButton Vinegar1;
    private javax.swing.JRadioButton Vinegar2;
    private javax.swing.JRadioButton Vinegar3;
    private javax.swing.JRadioButton Vinegar4;
    private javax.swing.JRadioButton Vinegar5;
    private javax.swing.JRadioButton Whiskey;
    private javax.swing.JRadioButton Whiskey1;
    private javax.swing.JRadioButton Whiskey2;
    private javax.swing.JRadioButton Whiskey3;
    private javax.swing.JRadioButton Whiskey4;
    private javax.swing.JRadioButton Whiskey5;
    private javax.swing.JRadioButton Winey;
    private javax.swing.JRadioButton Winey1;
    private javax.swing.JRadioButton Winey2;
    private javax.swing.JRadioButton Winey3;
    private javax.swing.JRadioButton Winey4;
    private javax.swing.JRadioButton Winey5;
    private javax.swing.JRadioButton Woody;
    private javax.swing.JRadioButton Woody1;
    private javax.swing.JRadioButton Woody2;
    private javax.swing.JRadioButton Woody3;
    private javax.swing.JRadioButton Woody4;
    private javax.swing.JLabel aroma;
    private javax.swing.JTextField breaks;
    private javax.swing.JSlider breakslider;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private com.toedter.calendar.JDateChooser calendario;
    private javax.swing.JLabel co;
    private javax.swing.JLabel comunidad;
    public javax.swing.JTabbedPane contenedorpaneles;
    private javax.swing.JLabel cs;
    private javax.swing.JTextField dry;
    private javax.swing.JSlider dryslider;
    private javax.swing.JTextField dulzor;
    private javax.swing.JTextField flavor;
    private javax.swing.JSlider flavorslider;
    private javax.swing.JSpinner intensidadacidity;
    private javax.swing.JSpinner intensidadbody;
    private javax.swing.JTextField intensidadefectos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
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
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JButton lessAcidity;
    private javax.swing.JButton lessBalance;
    private javax.swing.JButton lessBody;
    private javax.swing.JButton lessCatador;
    private javax.swing.JButton lessaftertaste;
    private javax.swing.JButton lessbreak;
    private javax.swing.JButton lessdry;
    private javax.swing.JButton lessflavor;
    private javax.swing.JButton lesswet;
    private javax.swing.JCheckBox nt1;
    private javax.swing.JCheckBox nt2;
    private javax.swing.JCheckBox nt3;
    private javax.swing.JCheckBox nt4;
    private javax.swing.JCheckBox nt5;
    private javax.swing.JTextField numtazasdefectos;
    private javax.swing.JButton plusAcidity;
    private javax.swing.JButton plusBalance;
    private javax.swing.JButton plusBody;
    private javax.swing.JButton plusCatador;
    private javax.swing.JButton plusaftertaste;
    private javax.swing.JButton plusbreak;
    private javax.swing.JButton plusdry;
    private javax.swing.JButton plusflavor;
    private javax.swing.JButton pluswet;
    private javax.swing.JTextField quakers;
    private javax.swing.JRadioButton sour;
    private javax.swing.JRadioButton sour1;
    private javax.swing.JRadioButton sour2;
    private javax.swing.JRadioButton sour3;
    private javax.swing.JRadioButton sour4;
    private javax.swing.JTextField tazalimpia;
    private javax.swing.JLabel ti;
    private javax.swing.JSpinner uniformidadtostado;
    private javax.swing.JTextField uniformtaza;
    private javax.swing.JTextField wet;
    private javax.swing.JSlider wetslider;
    // End of variables declaration//GEN-END:variables
}
