/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_LaboratorioN;

import Metodos_Configuraciones.metodosLaboratorio;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Cronos
 */
public class jdReporteIndividual extends javax.swing.JDialog {

    /**
     * Creates new form jdReporteIndividual
     */
    Connection cn;
    String csm;
    metodosLaboratorio mlb;
    DefaultTableModel modelo;

    public jdReporteIndividual(java.awt.Frame parent, boolean modal, String csm, Connection cn) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        this.cn = cn;
        this.csm = csm;

        mlb = new metodosLaboratorio(cn, "");
        modelo = (DefaultTableModel) tablaDefectos.getModel();
        cargarDatos();
        //prueba();
        //modelo = (DefaultTableModel) tablabitacora.getModel();

    }

    /*   public void llenarTabla() {
        limpiar(tablabitacora);
        //limpiar(tablaconsulta);
        mdb.cargarInformacion2(modelo, 16, "SELECT b.id_muestra,b.fecha_llegada,b.tipocafe,b.forma,b.beneficio,b.dueño,b.lote,b.certificado,b.peso,b.Kgconfirm,b.sacos,\n"
                + "b.comunidad,b.estatus,d.puntuacion,c.Puntuacion,b.mezcla from bitacoralab b left join datosev d on b.id_bitacora=d.id_bitacora left join \n"
                + " catacion c on b.id_bitacora=c.id_bitacora where estatus != 'Desactivada' order by b.id_muestra");
           mdb.cargarInformacion2(modelo2, 21, " select b.estatus,b.id_muestra,b.beneficio,b.lote,b.tipocafe,b.forma,b.certificado,b.peso,b.Kgconfirm,\n"
                + " b.sacos,b.comunidad,b.dueño,b.fechalote,c.Puntuacion,d.puntuacion,d.humedad_o,c.quakers,b.sabores,\n"
                + " b.observaciones,d.Densidadoro,c.densidadtostado from  bitacoralab b left join   datosev d on b.id_bitacora=d.id_bitacora left join \n"
                + " catacion c on b.id_bitacora=c.id_bitacora where estatus != 'Desactivada' order by b.id_muestra");
          String[] datos2 = mdb.cargarCombos2("select CONCAT(Descripcion,' -', Clave,'- ') FROM procesocafe where clave != 'PR';").split("¬");//1
        combotipo.setModel(new DefaultComboBoxModel((Object[]) datos2));
    }*/
    public void cargarDatos() {
        String[] cadena = mlb.devuelveUnRow("SELECT\n"
                + "    b.id_muestra,\n"
                + "    b.fecha_llegada,\n"
                + "    b.tomadapor,\n"
                + "    b.fechalote,\n"
                + "    b.tipocafe,\n"
                + "    b.forma,\n"
                + "    b.peso,\n"
                + "    b.sacos,\n"
                + "    b.beneficio,\n"
                + "    'Id Fuente',\n"
                + "    b.certificado,\n"
                + "    b.dueño,\n"
                + "    'Predio',\n"
                + "    b.comunidad,\n"
                + "    b.calidadcereza,\n"
                + "    d.PesoEv,\n"
                + "    d.humedad_c,\n"
                + "    b.Metodosecado,\n"
                + "    'Peso75cc',\n"
                + "    '#Criba',\n"
                + "    d.uniformidad,\n"
                + "    'Color',\n"
                + "    'Act Agua',\n"
                + "    c.numerotazas,\n"
                + "    d.fecha,\n"
                + "    d.evaluador,\n"
                + "    c.fecha,\n"
                + "    'Eva Taza',\n"
                + "    c.fragance,\n"
                + "    c.flavor,\n"
                + "    c.acidity,\n"
                + "    c.intensidadacidit,\n"
                + "    c.balance,\n"
                + "    c.dry,\n"
                + "    c.wet,\n"
                + "    c.aftertaste,\n"
                + "    c.body,\n"
                + "    c.intensidadbody,\n"
                + "    c.uniformidadtaza,\n"
                + "    c.tazalimpia,\n"
                + "    c.dulzor,\n"
                + "    c.defectos,\n"
                + "    c.numtazasdefect,\n"
                + "    c.intensidaddef,\n"
                + "    c.quakers,\n"
                + "    c.break,\n"
                + "    c.catador,\n"
                + "    c.Puntuacion,\n"
                + "    d.rendimiento, c.uniformidadtostado,b.sabores, b.olores \n"
                + "FROM\n"
                + "    bitacoralab b\n"
                + "INNER JOIN datosev d ON\n"
                + "    (b.id_bitacora = d.id_muestra)\n"
                + "INNER JOIN catacion c ON\n"
                + "    (b.id_bitacora = c.id_bitacora)\n"
                + "WHERE\n"
                + "    b.id_bitacora = '" + mlb.devuelveUnDato("select id_bitacora from bitacoralab where id_muestra='" + csm + "'") + "'", 52).split(",");

        lblCsm.setText(cadena[0]);
        lblFechaLlegada.setText(cadena[1]);
        lblTomadaPor.setText(cadena[2]);
        lblFechaLote.setText(cadena[3]);
        lblProceso.setText(cadena[4]);
        lblForma.setText(cadena[5]);
        lblPesoLote.setText(cadena[6]);
        lblSacos.setText(cadena[7]);
        //lblFuente.setText(cadena[8]);
        //lblIdFuebte.setText(cadena[9]);
        lblCertificacion.setText(cadena[10]);
        lblDueño.setText(cadena[11]);
        //lblPredio.setText(cadena[12]);
        lblLocalidad.setText(cadena[13]);
        lblCalidad.setText(cadena[14]);
        lblPesoEvaluado.setText(cadena[15]);
        lblHumedad.setText(cadena[16]);
        lblMetodo.setText(cadena[17]);
        lblPeso75cc.setText(cadena[18]);
        //criba
        lblUniOro.setText(cadena[20]);
        lblColor.setText(cadena[21]);
//        lblAgua.setText(cadena[22]);
        lblTazasEvaluadas.setText(cadena[23]);
        lblFechaAspecto.setText(cadena[24]);
        lblAspectoEval.setText(cadena[25]);
        lblFechaTaza.setText(cadena[26]);
        // lblTazaEval.setText(cadena[27]);
        lblAroma.setText(cadena[28]);
        lblSabor.setText(cadena[29]);
        lblAcidez.setText(cadena[30]);
        lblIntAcidez.setText(cadena[31]);
        lblBalance.setText(cadena[32]);
        lblSeco.setText(cadena[33]);
        lblMojado.setText(cadena[34]);
        lblRemanente.setText(cadena[35]);
        lblCuerpo.setText(cadena[36]);
        lblInteCuerpo.setText(cadena[37]);
        lblUniTaza.setText(cadena[38]);
        lblTazaLimpia.setText(cadena[39]);
        lblDulzor.setText(cadena[40]);
        lblDefectos.setText(cadena[41]);
        lblTazaDefectos.setText(cadena[42]);
        lblInteDefectos.setText(cadena[43]);
        lblQuakers.setText(cadena[44]);
        lblEspuma.setText(cadena[45]);
        lblCatador.setText(cadena[46]);
        lblPuntuacion.setText(cadena[47]);
        lblRendimiento.setText(cadena[48]);
        lblUniTostado.setText(cadena[49]);

        System.out.print(cadena[50]);
        System.out.print(cadena[51]);

        String[] sabores = cadena[50].split(":");
        lblCualidadesSabor.setText(sabores[1]);

        String[] remanente = cadena[51].split(":");
        lblCualidadesRemanente.setText(remanente[1]);

        String[] acidez = cadena[52].split(":");
        lblCualidadesAcidez.setText(acidez[1]);

        String[] seco = cadena[53].split(":");
        String[] mojado = cadena[54].split(":");

        lblCualidadesSeco.setText(seco[1] + " " + mojado[1]);

        String[] quebrado = cadena[55].split(":");
        lblCualidadesQuebrado.setText(quebrado[1]);

        /* mlb.cargarInformacion2(modelo, 1, "SELECT Concat(criba,',',datos)\n"
                + "FROM cribas\n"
                + "WHERE id_bitacora = '" + mlb.devuelveUnDato("select id_bitacora from bitacoralab where id_muestra='" + csm + "'") + "'");
         */
        String[] cadenaC = mlb.devuelveUnDato("SELECT Concat(criba,',',datos)\n"
                + "FROM cribas\n"
                + "WHERE id_bitacora = "
                + "'" + mlb.devuelveUnDato("select id_bitacora from bitacoralab where id_muestra='" + csm + "'") + "' "
                + "and criba=19").split(",");

        JOptionPane.showMessageDialog(null,cadenaC);
        System.out.println(cadenaC);
        
        String criba = cadenaC[0];
        String peso = cadenaC[1];
        String brocaS = cadenaC[2];
        String broca = cadenaC[3];
        String negro = cadenaC[4];
        String negroP = cadenaC[5];
        String agrio = cadenaC[6];
        String agrioP = cadenaC[7];
        String aplastado = cadenaC[8];
        String daño = cadenaC[9];
        String dañoAgrio = cadenaC[10];
        String blanco = cadenaC[11];
        String elefante = cadenaC[12];
        String concha = cadenaC[13];
        String malformado = cadenaC[14];
        String hongos = cadenaC[15];
        String inmaduro = cadenaC[16];
        String sobresecado = cadenaC[17];
        String arrugado = cadenaC[18];
        //String humedo = cadenaC[19];
        String quebrad = cadenaC[20];
        String cerezaS = cadenaC[21];
        String pergamino = cadenaC[22];
        String cascara = cadenaC[23];
        String materia = cadenaC[24];

        modelo.addRow(new Object[]{criba, peso, brocaS, broca, negro,
            negroP, agrio, agrioP, aplastado, daño,
            dañoAgrio, blanco, elefante, concha, malformado,
            hongos, inmaduro, sobresecado, arrugado,
            quebrad, cerezaS, pergamino, cascara, materia});

        cadenaC = mlb.devuelveUnDato("SELECT Concat(criba,',',datos)\n"
                + "FROM cribas\n"
                + "WHERE id_bitacora = "
                + "'" + mlb.devuelveUnDato("select id_bitacora from bitacoralab where id_muestra='" + csm + "'") + "' "
                + "and criba=18").split(",");

        criba = cadenaC[0];
        peso = cadenaC[1];
        brocaS = cadenaC[2];
        broca = cadenaC[3];
        negro = cadenaC[4];
        negroP = cadenaC[5];
        agrio = cadenaC[6];
        agrioP = cadenaC[7];
        aplastado = cadenaC[8];
        daño = cadenaC[9];
        dañoAgrio = cadenaC[10];
        blanco = cadenaC[11];
        elefante = cadenaC[12];
        concha = cadenaC[13];
        malformado = cadenaC[14];
        hongos = cadenaC[15];
        inmaduro = cadenaC[16];
        sobresecado = cadenaC[17];
        arrugado = cadenaC[18];
        //humedo = cadenaC[19];
        quebrad = cadenaC[20];
        cerezaS = cadenaC[21];
        pergamino = cadenaC[22];
        cascara = cadenaC[23];
        materia = cadenaC[24];

        modelo.addRow(new Object[]{criba, peso, brocaS, broca, negro,
            negroP, agrio, agrioP, aplastado, daño,
            dañoAgrio, blanco, elefante, concha, malformado,
            hongos, inmaduro, sobresecado, arrugado,
            quebrad, cerezaS, pergamino, cascara, materia});

        cadenaC = mlb.devuelveUnDato("SELECT Concat(criba,',',datos)\n"
                + "FROM cribas\n"
                + "WHERE id_bitacora = "
                + "'" + mlb.devuelveUnDato("select id_bitacora from bitacoralab where id_muestra='" + csm + "'") + "' "
                + "and criba=17").split(",");

        criba = cadenaC[0];
        peso = cadenaC[1];
        brocaS = cadenaC[2];
        broca = cadenaC[3];
        negro = cadenaC[4];
        negroP = cadenaC[5];
        agrio = cadenaC[6];
        agrioP = cadenaC[7];
        aplastado = cadenaC[8];
        daño = cadenaC[9];
        dañoAgrio = cadenaC[10];
        blanco = cadenaC[11];
        elefante = cadenaC[12];
        concha = cadenaC[13];
        malformado = cadenaC[14];
        hongos = cadenaC[15];
        inmaduro = cadenaC[16];
        sobresecado = cadenaC[17];
        arrugado = cadenaC[18];
        //humedo = cadenaC[19];
        quebrad = cadenaC[20];
        cerezaS = cadenaC[21];
        pergamino = cadenaC[22];
        cascara = cadenaC[23];
        materia = cadenaC[24];

        modelo.addRow(new Object[]{criba, peso, brocaS, broca, negro,
            negroP, agrio, agrioP, aplastado, daño,
            dañoAgrio, blanco, elefante, concha, malformado,
            hongos, inmaduro, sobresecado, arrugado,
            quebrad, cerezaS, pergamino, cascara, materia});

        cadenaC = mlb.devuelveUnDato("SELECT Concat(criba,',',datos)\n"
                + "FROM cribas\n"
                + "WHERE id_bitacora = "
                + "'" + mlb.devuelveUnDato("select id_bitacora from bitacoralab where id_muestra='" + csm + "'") + "' "
                + "and criba=16").split(",");

        criba = cadenaC[0];
        peso = cadenaC[1];
        brocaS = cadenaC[2];
        broca = cadenaC[3];
        negro = cadenaC[4];
        negroP = cadenaC[5];
        agrio = cadenaC[6];
        agrioP = cadenaC[7];
        aplastado = cadenaC[8];
        daño = cadenaC[9];
        dañoAgrio = cadenaC[10];
        blanco = cadenaC[11];
        elefante = cadenaC[12];
        concha = cadenaC[13];
        malformado = cadenaC[14];
        hongos = cadenaC[15];
        inmaduro = cadenaC[16];
        sobresecado = cadenaC[17];
        arrugado = cadenaC[18];
        //humedo = cadenaC[19];
        quebrad = cadenaC[20];
        cerezaS = cadenaC[21];
        pergamino = cadenaC[22];
        cascara = cadenaC[23];
        materia = cadenaC[24];
        modelo.addRow(new Object[]{criba, peso, brocaS, broca, negro,
            negroP, agrio, agrioP, aplastado, daño,
            dañoAgrio, blanco, elefante, concha, malformado,
            hongos, inmaduro, sobresecado, arrugado,
            quebrad, cerezaS, pergamino, cascara, materia});

        cadenaC = mlb.devuelveUnDato("SELECT Concat(criba,',',datos)\n"
                + "FROM cribas\n"
                + "WHERE id_bitacora = "
                + "'" + mlb.devuelveUnDato("select id_bitacora from bitacoralab where id_muestra='" + csm + "'") + "' "
                + "and criba=15").split(",");

        criba = cadenaC[0];
        peso = cadenaC[1];
        brocaS = cadenaC[2];
        broca = cadenaC[3];
        negro = cadenaC[4];
        negroP = cadenaC[5];
        agrio = cadenaC[6];
        agrioP = cadenaC[7];
        aplastado = cadenaC[8];
        daño = cadenaC[9];
        dañoAgrio = cadenaC[10];
        blanco = cadenaC[11];
        elefante = cadenaC[12];
        concha = cadenaC[13];
        malformado = cadenaC[14];
        hongos = cadenaC[15];
        inmaduro = cadenaC[16];
        sobresecado = cadenaC[17];
        arrugado = cadenaC[18];
        //humedo = cadenaC[19];
        quebrad = cadenaC[20];
        cerezaS = cadenaC[21];
        pergamino = cadenaC[22];
        cascara = cadenaC[23];
        materia = cadenaC[24];

        modelo.addRow(new Object[]{criba, peso, brocaS, broca, negro,
            negroP, agrio, agrioP, aplastado, daño,
            dañoAgrio, blanco, elefante, concha, malformado,
            hongos, inmaduro, sobresecado, arrugado,
            quebrad, cerezaS, pergamino, cascara, materia});

        cadenaC = mlb.devuelveUnDato("SELECT Concat(criba,',',datos)\n"
                + "FROM cribas\n"
                + "WHERE id_bitacora = "
                + "'" + mlb.devuelveUnDato("select id_bitacora from bitacoralab where id_muestra='" + csm + "'") + "' "
                + "and criba='F'").split(",");

        criba = cadenaC[0];
        peso = cadenaC[1];
        brocaS = cadenaC[2];
        broca = cadenaC[3];
        negro = cadenaC[4];
        negroP = cadenaC[5];
        agrio = cadenaC[6];
        agrioP = cadenaC[7];
        aplastado = cadenaC[8];
        daño = cadenaC[9];
        dañoAgrio = cadenaC[10];
        blanco = cadenaC[11];
        elefante = cadenaC[12];
        concha = cadenaC[13];
        malformado = cadenaC[14];
        hongos = cadenaC[15];
        inmaduro = cadenaC[16];
        sobresecado = cadenaC[17];
        arrugado = cadenaC[18];
        //humedo = cadenaC[19];
        quebrad = cadenaC[20];
        cerezaS = cadenaC[21];
        pergamino = cadenaC[22];
        cascara = cadenaC[23];
        materia = cadenaC[24];

        modelo.addRow(new Object[]{criba, peso, brocaS, broca, negro,
            negroP, agrio, agrioP, aplastado, daño,
            dañoAgrio, blanco, elefante, concha, malformado,
            hongos, inmaduro, sobresecado, arrugado,
            quebrad, cerezaS, pergamino, cascara, materia});

        cadenaC = mlb.devuelveUnDato("SELECT Concat(criba,',',datos)\n"
                + "FROM cribas\n"
                + "WHERE id_bitacora = "
                + "'" + mlb.devuelveUnDato("select id_bitacora from bitacoralab where id_muestra='" + csm + "'") + "' "
                + "and criba='TOTAL'").split(",");

        criba = cadenaC[0];
        peso = cadenaC[1];
        brocaS = cadenaC[2];
        broca = cadenaC[3];
        negro = cadenaC[4];
        negroP = cadenaC[5];
        agrio = cadenaC[6];
        agrioP = cadenaC[7];
        aplastado = cadenaC[8];
        daño = cadenaC[9];
        dañoAgrio = cadenaC[10];
        blanco = cadenaC[11];
        elefante = cadenaC[12];
        concha = cadenaC[13];
        malformado = cadenaC[14];
        hongos = cadenaC[15];
        inmaduro = cadenaC[16];
        sobresecado = cadenaC[17];
        arrugado = cadenaC[18];
        //humedo = cadenaC[19];
        quebrad = cadenaC[20];
        cerezaS = cadenaC[21];
        pergamino = cadenaC[22];
        cascara = cadenaC[23];
        materia = cadenaC[24];

        modelo.addRow(new Object[]{criba, peso, brocaS, broca, negro,
            negroP, agrio, agrioP, aplastado, daño,
            dañoAgrio, blanco, elefante, concha, malformado,
            hongos, inmaduro, sobresecado, arrugado,
            quebrad, cerezaS, pergamino, cascara, materia});

        /*for (int i = 0; i >= cadenaC.length; i++) {

        }*/
    }

    public void prueba() {
        // initComponents();
        int totalBroca = 0, totalBS = 0, totalNegro = 0, totalNP = 0, totalAgrio = 0,
                totalAplastado = 0, totalAP = 0, totalDaño = 0, totalDañoYAgrio = 0,
                totalBlanco = 0, totalElefante = 0, totalConcha = 0, totalMalformado = 0, totalHongos = 0,
                totalInmaduro = 0, totalSobresecado = 0, totalArrugado = 0, totalCereza = 0, totalPergamino = 0, totalCascara = 0,
                totalMateria = 0, totalQuebrado = 0;

        for (int i = 0; i < tablaDefectos.getRowCount(); i++) {
            totalBroca = totalBroca + Integer.parseInt(tablaDefectos.getValueAt(i, 2) + "");
            totalBS = totalBS + Integer.parseInt(tablaDefectos.getValueAt(i, 3) + "");
            totalNegro = totalNegro + Integer.parseInt(tablaDefectos.getValueAt(i, 4) + "");
            totalNP = totalNP + Integer.parseInt(tablaDefectos.getValueAt(i, 5) + "");
            totalAgrio = totalAgrio + Integer.parseInt(tablaDefectos.getValueAt(i, 6) + "");
            totalAP = totalAP + Integer.parseInt(tablaDefectos.getValueAt(i, 7) + "");
            totalAplastado = totalAplastado + Integer.parseInt(tablaDefectos.getValueAt(i, 8) + "");
            totalDaño = totalDaño + Integer.parseInt(tablaDefectos.getValueAt(i, 9) + "");
            totalDañoYAgrio = totalDañoYAgrio + Integer.parseInt(tablaDefectos.getValueAt(i, 10) + "");
            totalBlanco = totalBlanco + Integer.parseInt(tablaDefectos.getValueAt(i, 11) + "");
            totalElefante = totalElefante + Integer.parseInt(tablaDefectos.getValueAt(i, 12) + "");
            totalConcha = totalConcha + Integer.parseInt(tablaDefectos.getValueAt(i, 13) + "");
            totalMalformado = totalMalformado + Integer.parseInt(tablaDefectos.getValueAt(i, 14) + "");
            totalHongos = totalHongos + Integer.parseInt(tablaDefectos.getValueAt(i, 15) + "");
            totalInmaduro = totalInmaduro + Integer.parseInt(tablaDefectos.getValueAt(i, 16) + "");
            totalSobresecado = totalSobresecado + Integer.parseInt(tablaDefectos.getValueAt(i, 17) + "");
            totalArrugado = totalArrugado + Integer.parseInt(tablaDefectos.getValueAt(i, 18) + "");
            totalQuebrado = totalQuebrado + Integer.parseInt(tablaDefectos.getValueAt(i, 19) + "");
            totalCereza = totalCereza + Integer.parseInt(tablaDefectos.getValueAt(i, 20) + "");
            totalPergamino = totalPergamino + Integer.parseInt(tablaDefectos.getValueAt(i, 21) + "");
            totalCascara = totalCascara + Integer.parseInt(tablaDefectos.getValueAt(i, 22) + "");
            totalMateria = totalMateria + Integer.parseInt(tablaDefectos.getValueAt(i, 23) + "");
        }
        //JOptionPane.showMessageDialog(null,totalBS+"- "+totalNegro);
        //Se almacenan los datos que seran usados en el gráfico
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        datos.setValue(totalBroca, "Granos", "Broca");
        datos.setValue(totalBS, "Granos", "Broca Severa");
        datos.setValue(totalNegro, "Granos", "Negro");
        datos.setValue(totalNP, "Granos", "Negro Parcial");
        datos.setValue(totalAgrio, "Granos", "Agrio");
        datos.setValue(totalAP, "Granos", "Agrio Parcial");
        //    datos.setValue(totalAplastado, "Granos", "Aplastado");
        datos.setValue(totalDaño, "Granos", "Daño");
        //   datos.setValue(totalDañoYAgrio, "Granos", "Daño Y Agrio");
        datos.setValue(totalBlanco, "Granos", "Blanco");
        //   datos.setValue(totalElefante, "Granos", "Elefante");
        datos.setValue(totalConcha, "Granos", "Concha");
        //   datos.setValue(totalMalformado, "Granos", "Malformado");
        datos.setValue(totalHongos, "Granos", "Daño Hongos");
        //    datos.setValue(totalInmaduro, "Granos", "Inmaduro");
        //    datos.setValue(totalSobresecado, "Granos", "Sobresecado");
        datos.setValue(totalArrugado, "Granos", "Arrugado");
        datos.setValue(totalQuebrado, "Granos", "Quebrado");
        datos.setValue(totalCereza, "Granos", "Cereza Seca");
        datos.setValue(totalPergamino, "Granos", "Pergamino");
        datos.setValue(totalCascara, "Granos", "Cascara");
        datos.setValue(totalMateria, "Granos", "Materia Extraña");

        //Se crea el gráfico y se asignan algunas caracteristicas
        JFreeChart grafico_barras = ChartFactory.createBarChart3D("Cuenta de Defectos", "Defectos", "Numero Granos", datos, PlotOrientation.VERTICAL, true, true, false);

        //Se guarda el grafico
        BufferedImage image = grafico_barras.createBufferedImage(700, 300);

        //Se crea la imagen y se agrega a la etiqueta
        grafico.setIcon(new ImageIcon(image));

        pack();
        repaint();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblCsm = new javax.swing.JLabel();
        lblFechaLlegada = new javax.swing.JLabel();
        lblFechaLote = new javax.swing.JLabel();
        lblTomadaPor = new javax.swing.JLabel();
        lblPesoLote = new javax.swing.JLabel();
        lblSacos = new javax.swing.JLabel();
        lblForma = new javax.swing.JLabel();
        lblProceso = new javax.swing.JLabel();
        lblCertificacion = new javax.swing.JLabel();
        lblIdFuente = new javax.swing.JLabel();
        lblFuente = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lblPredio = new javax.swing.JLabel();
        lblDueño = new javax.swing.JLabel();
        lblLocalidad = new javax.swing.JLabel();
        lblCalidad = new javax.swing.JLabel();
        lblPesoEvaluado = new javax.swing.JLabel();
        lblHumedad = new javax.swing.JLabel();
        lblMetodo = new javax.swing.JLabel();
        lblPeso75cc = new javax.swing.JLabel();
        lblUniOro = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        lblRendimiento = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        lblFechaAspecto = new javax.swing.JLabel();
        lblAspectoEval = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        lblTazaEval = new javax.swing.JLabel();
        lblFechaTaza = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        lblTazasEvaluadas = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        lblAroma = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        lblSabor = new javax.swing.JLabel();
        lblAcidez = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        lblBalance = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        lblCualidadesSabor = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        lblCualidadesAcidez = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        lblSeco = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        lblMojado = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        lblRemanente = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        lblIntAcidez = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        lblCualidadesRemanente = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        lblCuerpo = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        lblInteCuerpo = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        lblTazaLimpia = new javax.swing.JLabel();
        lblUniTaza = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        lblDulzor = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        lblCatador = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        lblDefectos = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        lblTazaDefectos = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        lblInteDefectos = new javax.swing.JLabel();
        lblPuntuacion = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        lblEspuma = new javax.swing.JLabel();
        lblCualidadesQuebrado = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        lblQuakers = new javax.swing.JLabel();
        lblUniTostado = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        lblCualidadesSeco = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDefectos = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        grafico = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte Individual");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("CSM");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Fecha Llegada");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Tomada Por");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Fecha Lote");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Proceso");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Forma Café");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Fuente Del Café");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Sacos");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Peso Lote (kg)");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Certificación");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Id Fuente");

        lblCsm.setText("-");

        lblFechaLlegada.setText("-");

        lblFechaLote.setText("-");

        lblTomadaPor.setText("-");

        lblPesoLote.setText("-");

        lblSacos.setText("-");

        lblForma.setText("-");

        lblProceso.setText("-");

        lblCertificacion.setText("-");

        lblIdFuente.setText("-");

        lblFuente.setText("-");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Dueño");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Predio");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Localidad");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Calidad Cereza");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Peso Evaluado (g)");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("Humedad Con/Sin");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("Metodo Secado");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Peso 75cc / # Criba");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Uniformidad Oro");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("Color En Oro");

        lblPredio.setText("-");

        lblDueño.setText("-");

        lblLocalidad.setText("-");

        lblCalidad.setText("-");

        lblPesoEvaluado.setText("-");

        lblHumedad.setText("-");

        lblMetodo.setText("-");

        lblPeso75cc.setText("-");

        lblUniOro.setText("-");

        lblColor.setText("-");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel46.setText("Rendimiento %");

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("Puntuación Defectos");

        lblRendimiento.setText("-");

        jLabel58.setText("-");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel47.setText("Fecha");

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Aspecto");

        lblFechaAspecto.setText("-");

        lblAspectoEval.setText("-");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setText("Evaluado Por");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Taza");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setText("Fecha");

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setText("Evaluado Por");

        lblTazaEval.setText("-");

        lblFechaTaza.setText("-");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAspectoEval, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaAspecto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaTaza, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTazaEval, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53)
                            .addComponent(lblFechaTaza))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(lblTazaEval)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(lblFechaAspecto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(lblAspectoEval))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel55.setText("Tazas Evaluadas");

        lblTazasEvaluadas.setText("-");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblCsm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22)
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblPesoLote, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblPredio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(19, 19, 19)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblPeso75cc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel30)
                                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel7)
                                        .addGap(22, 22, 22)
                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblFechaLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSacos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblUniOro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblTomadaPor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblFuente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblColor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblFechaLote, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblIdFuente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblPesoEvaluado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTazasEvaluadas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblForma, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(lblCertificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblHumedad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(lblDueño, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(22, 22, 22)
                                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(1, 1, 1)
                                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel52)
                                    .addComponent(jLabel46)
                                    .addComponent(lblRendimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9)
                    .addComponent(jLabel24)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCsm)
                    .addComponent(lblPesoLote)
                    .addComponent(lblPredio)
                    .addComponent(lblPeso75cc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jLabel25)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaLlegada)
                    .addComponent(lblSacos)
                    .addComponent(lblLocalidad)
                    .addComponent(lblUniOro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel26)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTomadaPor)
                    .addComponent(lblFuente)
                    .addComponent(lblCalidad)
                    .addComponent(lblColor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel11)
                    .addComponent(jLabel27)
                    .addComponent(jLabel55))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaLote)
                    .addComponent(lblIdFuente)
                    .addComponent(lblPesoEvaluado)
                    .addComponent(lblTazasEvaluadas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProceso)
                            .addComponent(lblCertificacion)
                            .addComponent(lblHumedad)
                            .addComponent(lblRendimiento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel23)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblForma)
                            .addComponent(lblDueño)
                            .addComponent(lblMetodo)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel58)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setToolTipText("");

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel60.setText("Fragancia/Aroma");

        lblAroma.setText("-");

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel62.setText("Sabor");

        lblSabor.setText("-");

        lblAcidez.setText("-");

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel65.setText("Acidez");

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel66.setText("Balance");

        lblBalance.setText("-");

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel68.setText("Cualidades");

        lblCualidadesSabor.setText("-");

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel70.setText("Cualidades");

        lblCualidadesAcidez.setText("-");

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel72.setText("Seco");

        lblSeco.setText("-");

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel74.setText("Mojado");

        lblMojado.setText("-");

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel76.setText("Sabor Remanente");

        lblRemanente.setText("-");

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel78.setText("Intensidad");

        lblIntAcidez.setText("-");

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel80.setText("Cualidades");

        lblCualidadesRemanente.setText("-");

        jLabel82.setText("-");

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel83.setText("Cualidades");

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel84.setText("Cuerpo");

        lblCuerpo.setText("-");

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel86.setText("Intensidad");

        lblInteCuerpo.setText("-");

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel88.setText("Taza Limpia");

        lblTazaLimpia.setText("-");

        lblUniTaza.setText("-");

        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel91.setText("Uniformidad Tazas");

        lblDulzor.setText("-");

        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel93.setText("Dulzor");

        jLabel94.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel94.setText("Catador");

        lblCatador.setText("-");

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel96.setText("Defectos");

        lblDefectos.setText("-");

        jLabel98.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel98.setText("# Tazas");

        lblTazaDefectos.setText("-");

        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel100.setText("Intensidad");

        lblInteDefectos.setText("-");

        lblPuntuacion.setText("-");

        jLabel103.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel103.setText("Espuma");

        jLabel104.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel104.setText("Cualidades");

        lblEspuma.setText("-");

        lblCualidadesQuebrado.setText("-");

        jLabel107.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel107.setText("Quakers");

        lblQuakers.setText("-");

        lblUniTostado.setText("-");

        jLabel110.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel110.setText("Uniformidad Tostado");

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel95.setText("Puntuacion");

        lblCualidadesSeco.setText("-");

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel81.setText("Cualidades");

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel59.setText("Taza");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel60)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblAroma, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel72)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblSeco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel74)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblMojado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel81)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblCualidadesSeco, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel104)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblCualidadesQuebrado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel103)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblEspuma, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel59))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel62)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblSabor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel80)
                                    .addComponent(jLabel68))
                                .addGap(187, 187, 187)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel70)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblCualidadesAcidez, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel65)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblAcidez, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel78)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblIntAcidez, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel66)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(40, 40, 40)
                                                .addComponent(jLabel94)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblCatador, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(204, 204, 204)
                                                .addComponent(jLabel110)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblUniTostado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel100)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblInteDefectos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel98)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblTazaDefectos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel96)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblDefectos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel95)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel84)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblCuerpo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel83)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel88)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblTazaLimpia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel93)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblDulzor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel107)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblQuakers, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel91)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblUniTaza, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCualidadesSabor, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblCualidadesRemanente, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel76)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblRemanente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel86)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblInteCuerpo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel62)
                            .addComponent(lblSabor)
                            .addComponent(jLabel59))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel60)
                                .addComponent(lblAroma))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel68)
                                .addComponent(lblCualidadesSabor))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65)
                            .addComponent(lblAcidez)
                            .addComponent(jLabel66)
                            .addComponent(lblBalance)
                            .addComponent(jLabel78)
                            .addComponent(lblIntAcidez)
                            .addComponent(jLabel94)
                            .addComponent(lblCatador)
                            .addComponent(lblPuntuacion)
                            .addComponent(jLabel95))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel70)
                            .addComponent(lblCualidadesAcidez))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel76)
                            .addComponent(lblRemanente)
                            .addComponent(jLabel72)
                            .addComponent(lblSeco)
                            .addComponent(jLabel74)
                            .addComponent(lblMojado)
                            .addComponent(jLabel86)
                            .addComponent(lblInteCuerpo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel80)
                            .addComponent(lblCualidadesRemanente)
                            .addComponent(jLabel81)
                            .addComponent(lblCualidadesSeco))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel103)
                                    .addComponent(lblEspuma))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel104)
                                    .addComponent(lblCualidadesQuebrado)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel84)
                                    .addComponent(lblCuerpo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel83)
                                    .addComponent(jLabel82)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel96)
                                    .addComponent(lblDefectos))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel98)
                                    .addComponent(lblTazaDefectos))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel100)
                                    .addComponent(lblInteDefectos)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel91)
                                    .addComponent(lblUniTaza))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel88)
                                    .addComponent(lblTazaLimpia))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel93)
                                    .addComponent(lblDulzor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel107)
                                    .addComponent(lblQuakers)
                                    .addComponent(jLabel110)
                                    .addComponent(lblUniTostado))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        tablaDefectos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Criba", "Peso (g)", "Broca Severa", "Broca", "Negro", "Negro Parcial", "Agrio", "Agrio Parcial", "Aplastado", "Daño", "Daño Y Agrio Parcial", "Blanco", "Elefante", "Concha", "Malformado", "Daño Hongos", "Inmaduro", "Sobresecado", "Arrugado", "Quebrado", "Cereza Seca", "Pergamino", "Cascara", "Materia Extraña"
            }
        ));
        jScrollPane1.setViewportView(tablaDefectos);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Información General");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Evaluaciones");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Granos / Defectos");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(grafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(grafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(jdReporteIndividual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdReporteIndividual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdReporteIndividual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdReporteIndividual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
 /*  java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
                jdReporteIndividual dialog = new jdReporteIndividual(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel grafico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAcidez;
    private javax.swing.JLabel lblAroma;
    private javax.swing.JLabel lblAspectoEval;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblCalidad;
    private javax.swing.JLabel lblCatador;
    private javax.swing.JLabel lblCertificacion;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblCsm;
    private javax.swing.JLabel lblCualidadesAcidez;
    private javax.swing.JLabel lblCualidadesQuebrado;
    private javax.swing.JLabel lblCualidadesRemanente;
    private javax.swing.JLabel lblCualidadesSabor;
    private javax.swing.JLabel lblCualidadesSeco;
    private javax.swing.JLabel lblCuerpo;
    private javax.swing.JLabel lblDefectos;
    private javax.swing.JLabel lblDueño;
    private javax.swing.JLabel lblDulzor;
    private javax.swing.JLabel lblEspuma;
    private javax.swing.JLabel lblFechaAspecto;
    private javax.swing.JLabel lblFechaLlegada;
    private javax.swing.JLabel lblFechaLote;
    private javax.swing.JLabel lblFechaTaza;
    private javax.swing.JLabel lblForma;
    private javax.swing.JLabel lblFuente;
    private javax.swing.JLabel lblHumedad;
    private javax.swing.JLabel lblIdFuente;
    private javax.swing.JLabel lblIntAcidez;
    private javax.swing.JLabel lblInteCuerpo;
    private javax.swing.JLabel lblInteDefectos;
    private javax.swing.JLabel lblLocalidad;
    private javax.swing.JLabel lblMetodo;
    private javax.swing.JLabel lblMojado;
    private javax.swing.JLabel lblPeso75cc;
    private javax.swing.JLabel lblPesoEvaluado;
    private javax.swing.JLabel lblPesoLote;
    private javax.swing.JLabel lblPredio;
    private javax.swing.JLabel lblProceso;
    private javax.swing.JLabel lblPuntuacion;
    private javax.swing.JLabel lblQuakers;
    private javax.swing.JLabel lblRemanente;
    private javax.swing.JLabel lblRendimiento;
    private javax.swing.JLabel lblSabor;
    private javax.swing.JLabel lblSacos;
    private javax.swing.JLabel lblSeco;
    private javax.swing.JLabel lblTazaDefectos;
    private javax.swing.JLabel lblTazaEval;
    private javax.swing.JLabel lblTazaLimpia;
    private javax.swing.JLabel lblTazasEvaluadas;
    private javax.swing.JLabel lblTomadaPor;
    private javax.swing.JLabel lblUniOro;
    private javax.swing.JLabel lblUniTaza;
    private javax.swing.JLabel lblUniTostado;
    private javax.swing.JTable tablaDefectos;
    // End of variables declaration//GEN-END:variables
}
