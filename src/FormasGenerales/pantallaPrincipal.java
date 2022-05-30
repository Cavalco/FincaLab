/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormasGenerales;

import Conexion.Conexion;
import FormasInternas.internalPrueba;
import FormasInternas.panelPrueba;
import Formas_BeneficioHumedo.jdSeleccionBeneficio;
import Formas_BeneficioHumedo.jpCortesRecibidos;
import Formas_BeneficioHumedo.jpLotesConfirmados;
import Formas_BeneficioHumedo.jpLotesEnProceso;
import Formas_BeneficioHumedo.jpSubLotesSecos;
import Formas_Configuraciones_BeneficioHumedo.jpActividadesBH;
import Formas_Configuraciones_BeneficioHumedo.jpAreaAlmacen;
import Formas_Configuraciones_BeneficioHumedo.jpClima;
import Formas_Configuraciones_BeneficioHumedo.jpMaquinaria;
import Formas_Configuraciones_BeneficioHumedo.jpRutas;
import Formas_Configuraciones_BeneficioHumedo.jpSobrante;
import Formas_Configuraciones_BeneficioHumedo.jpVehiculo;
import Formas_Configuraciones_DatosBasicos.jpColoniaEjido;
import Formas_Configuraciones_DatosBasicos.jpEstado;
import Formas_Configuraciones_DatosBasicos.jpFondo;
import Formas_Configuraciones_DatosBasicos.jpGiroEmpresa;
import Formas_Configuraciones_DatosBasicos.jpLocalidad;
import Formas_Configuraciones_DatosBasicos.jpMunicipio;
import Formas_Configuraciones_DatosBasicos.jpPais;
import Formas_Configuraciones_FincaCert.Certificados.CodComb;
import Formas_Configuraciones_FincaCert.Certificados.jpCertificado;
import Formas_Configuraciones_FincaCert.Certificados.jpCertificador;
import Formas_Configuraciones_FincaCert.Certificados.jpCodigosCertificados;
import Formas_Configuraciones_FincaCert.jpActividadesParcela;
import Formas_Configuraciones_FincaCert.jpCalidadSombra;
import Formas_Configuraciones_FincaCert.jpCultivos;
import Formas_Configuraciones_FincaCert.jpDiseñoPlantacion;
import Formas_Configuraciones_FincaCert.jpEnfermedadPlaga;
import Formas_Configuraciones_FincaCert.jpFauna;
import Formas_Configuraciones_FincaCert.jpFertilizante;
import Formas_Configuraciones_FincaCert.jpFlora;
import Formas_Configuraciones_FincaCert.jpHerbicida;
import Formas_Configuraciones_FincaCert.jpSistemaProduccion;
import Formas_Configuraciones_FincaCert.jpSuelos;
import Formas_Configuraciones_FincaCert.Certificados.jpTipoCertificacion;
import Formas_Configuraciones_FincaCert.jpCategoriaDeArchivos;
import Formas_Configuraciones_FincaCert.jpControlMaleza;
import Formas_Configuraciones_FincaCert.jpMaquinariaHerramienta;
import Formas_Configuraciones_FincaCert.jpMotivoPlantacion;
import Formas_Configuraciones_FincaCert.jpTipoAccion;
import Formas_Configuraciones_FincaCert.jpTipoPoda;
import Formas_Configuraciones_FincaCert.jpTipoSombra;
import Formas_Configuraciones_FincaCert.jpVariedadCafe;
import Formas_Configuraciones_Idiomas.jpIdioma;
import Formas_Configuraciones_Recepcion.jpCalificacionCereza;
import Formas_Configuraciones_Recepcion.jpCalificacionSeco;
import Formas_Configuraciones_Recepcion.jpEvaluaciones;
import Formas_Configuraciones_Recepcion.jpFactorForma;
import Formas_Configuraciones_Recepcion.jpFormaCafe;
import Formas_Configuraciones_Recepcion.jpEstadoCafe;
import Formas_Configuraciones_Recepcion.jpFormaProceso;
import Formas_Configuraciones_Recepcion.jpMaximoRendimiento;
import Formas_Configuraciones_Recepcion.jpMaximoTamañoPromedio;
import Formas_Configuraciones_Recepcion.jpProcesoCafe;
import Formas_Configuraciones_Recepcion.jpReglasEvaluacion;
import Formas_Configuraciones_Recepcion.jpTipoEvaluacion;
import Formas_Configuraciones_Seguridad.jpPerfiles;
import Formas_Configuraciones_Seguridad.jpUsuarios;
import Formas_Configuraciones_Sociedades.jpPuestos;
import Formas_Configuraciones_Sociedades.jpRetenciones;
import Formas_FincaCert.jpProductores;
import Formas_Personas.jpPersonas;
import Formas_Personas.jpPersonas;
import Formas_Recepcion.jdRecibos;
import Formas_Recepcion.jdSeleccionRecepcion;
import Formas_Recepcion.jpCortesDelDia;
import Formas_Recepcion.jpCortesDelDia;
import Formas_Recepcion.jpCortesEnviados;
import Formas_Recepcion.jpRecibos;
import Formas_Sociedades.jpAlmacenes;
import Formas_Sociedades.jpBeneficiosH;
import Formas_Sociedades.jpCatalogoSociedades;
import Formas_Sociedades.jpLocalidadesSociedades;
import Formas_Sociedades.jpRecepcion;
import Formas_laboratorio.jpBitacora;
import Formas_LaboratorioN.jpRecibirMuestras;
import Formas_Almacen.jdSeleccionAlmacen;
import Formas_Almacen.jpMuestras;
import Formas_Almacen.jpSubLotesRecibidosAlmacen;
import Formas_Almacen.jpSubLotesActivosAlmacen;
import Formas_Almacen.jpSubLotesEnviadosAlmacen;
import Formas_BeneficioHumedov2.jdEntradaBH;
import Formas_BeneficioHumedov2.jpAnalisis;
import Formas_BeneficioHumedov2.jpProcesosBH;
import Formas_BeneficioHumedov2.jpRecibirBoletas;
import Formas_Exportar_Importar.jpExportar_Importar;
import Formas_Exportar_Importar.jpImportar;
import Formas_BeneficioHumedov2.jpBitacoraUnaVista;
import Formas_LaboratorioN.jpReporteLaboratorio;
import Formas_Reportes.jpAcopioProductor;
import Formas_Reportes.jpBoletasSalidaRecepcion;
import Formas_Reportes.jpEvaluacionRecepcion;
import Formas_Reportes.jpFichasTecnicas;
import Formas_Reportes.jpHistorialCertificaciones;
import Formas_Reportes.jpPadronParcelario;
import Formas_Reportes.jpReporteKilosSociedad;
import Formas_Reportes.jpReporteRecibos;
import Formas_Reportes.jpReseñaHistoriaSociedad;
import Idioma.Propiedades;
import MetodosGenerales.JComboCheckBox;
import Metodos_Configuraciones.metodosDatosBasicos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.text.ParseException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;

/**
 *
 * @author Carlos Valdez
 */
public class pantallaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form pantallaPrincipal
     */
    Connection cn;
    panelPrueba pP;
    jpTipoSombra jpTS;
    Propiedades idioma;
    String idUsuario, Idioma;
    metodosDatosBasicos mdb;

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Imagenes/icon_flab32x32.png"));

        return retValue;
    }

    public pantallaPrincipal(String idUsuario, String Idioma, Connection cn) throws ParseException {
        initComponents();
        setLocationRelativeTo(null);
        this.cn = cn;
        this.Idioma = Idioma;
        this.idUsuario = idUsuario;

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        idioma = new Propiedades(Idioma);
        mdb = new metodosDatosBasicos(cn, Idioma);
        setTitle(idioma.getProperty("TituloVentanaPrincipal"));

        JOptionPane.showMessageDialog(null, "Bienvenido a FincaLab");

        validarModulos();
        cambiarIdioma();

        //DefaultTreeCellRenderer render = (DefaultTreeCellRenderer) jTree1.getCellRenderer();
        //render.setLeafIcon(new ImageIcon(this.getClass().getResource("../Imagenes/database.png")));
        //render.setOpenIcon(new ImageIcon(this.getClass().getResource("../Imagenes/database.png")));
        //render.setClosedIcon(new ImageIcon(this.getClass().getResource("../Imagenes/database.png")));
    }

    public void validarModulos() {

        //No existe aun por eso falseeee
        btnLaboratorio.setVisible(false);

        String modulos[] = mdb.devolverLineaDatos("select configurador, personas, fincacert,recepcion, beneficiohumedo,sociedades,laboratorio,almacen, usuario "
                + "from usuarios where id=" + idUsuario, 9).split("¬");

        if (modulos[0].equals("1")) {
            btnConfigurador.setVisible(true);
        } else {
            btnConfigurador.setVisible(false);
        }
        if (modulos[1].equals("1")) {
            btnPersonas.setVisible(true);
        } else {
            btnPersonas.setVisible(false);
        }
        if (modulos[2].equals("1")) {
            btnFincaCert.setVisible(true);
        } else {
            btnFincaCert.setVisible(false);
        }
        if (modulos[3].equals("1")) {
            btnRecepcion.setVisible(true);
        } else {
            btnRecepcion.setVisible(false);
        }
        if (modulos[4].equals("1")) {
            btnBH.setVisible(true);
        } else {
            btnBH.setVisible(false);
        }
        if (modulos[5].equals("1")) {
            btnSociedades.setVisible(true);
        } else {
            btnSociedades.setVisible(false);
        }
        if (modulos[6].equals("1")) {
            btnLaboratorio.setVisible(true);
        } else {
            btnLaboratorio.setVisible(false);
        }
        if (modulos[7].equals("1")) {
            btnAlmacen.setVisible(true);
        } else {
            btnAlmacen.setVisible(false);
        }

        jLabel4.setText(modulos[8]);
    }

    public void cambiarIdioma() {

        btnConfigurador.setText(idioma.getProperty("Configurador"));
        btnPersonas.setText(idioma.getProperty("Personas"));
        btnFincaCert.setText(idioma.getProperty("FincaCert"));
        btnRecepcion.setText(idioma.getProperty("Recepcion"));
        btnBH.setText(idioma.getProperty("BeneficioHumedo"));
        btnLaboratorio.setText(idioma.getProperty("Laboratorio"));
        btnSociedades.setText(idioma.getProperty("Sociedades"));
        btnAlmacen.setText(idioma.getProperty("Almacen"));
        jLabel1.setText(idioma.getProperty("Bienvenido"));
        jLabel5.setText(idioma.getProperty("Usuario"));
        setTitle(idioma.getProperty("TituloVentanaPrincipal"));
        jButton1.setText(idioma.getProperty("Salir"));

        jLabel3.setVisible(false);
        jLabel6.setVisible(false);
    }

    public void pintarPanel(String tipo) throws ParseException {
        Dimension size = panelPrincipal.getSize();
        //Tamaño Manual = 830, 570
        //Propiedades idioma = new Propiedades(comboIdioma.getSelectedItem() + "");
        //String tipo2 = idioma.getProperty("Pais");
        //JOptionPane.showMessageDialog(null, "Valor " + tipo2);

        if (idioma.getProperty("Pais").equals(tipo)) {
            //JOptionPane.showMessageDialog(null, "Entre");
            jpPais jpP = new jpPais(cn, Idioma);
            jpP.setSize(size);
            jpP.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpP);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Sociedades").equals(tipo)) {
            jpCatalogoSociedades jpCPre = new jpCatalogoSociedades(cn, Idioma);
            jpCPre.setSize(size);
            jpCPre.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpCPre);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Estado").equals(tipo)) {
            jpEstado jpE = new jpEstado(cn, Idioma);
            jpE.setSize(size);
            jpE.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpE);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Municipio").equals(tipo)) {
            jpMunicipio jpM = new jpMunicipio(cn, Idioma);
            jpM.setSize(size);
            jpM.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpM);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Localidad").equals(tipo)) {
            jpLocalidad jpL = new jpLocalidad(cn, Idioma);
            jpL.setSize(size);
            jpL.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpL);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("ColoniaEjido").equals(tipo)) {
            jpColoniaEjido jpCE = new jpColoniaEjido(cn, Idioma);
            jpCE.setSize(size);
            jpCE.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpCE);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("GiroEmpresa").equals(tipo)) {
            jpGiroEmpresa jpCE = new jpGiroEmpresa(cn, Idioma);
            jpCE.setSize(size);
            jpCE.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpCE);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("TipoDeSombra").equals(tipo)) {
            jpTipoSombra jpCE = new jpTipoSombra(cn, Idioma);
            jpCE.setSize(size);
            jpCE.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpCE);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("CalidadDeSombra").equals(tipo)) {
            jpCalidadSombra jpCE = new jpCalidadSombra(cn, Idioma);
            jpCE.setSize(size);
            jpCE.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpCE);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("VariedadDeCafe").equals(tipo)) {
            jpVariedadCafe jpCE = new jpVariedadCafe(cn, Idioma);
            jpCE.setSize(size);
            jpCE.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpCE);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Cultivos").equals(tipo)) {
            jpCultivos jpCE = new jpCultivos(cn, Idioma);
            jpCE.setSize(size);
            jpCE.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpCE);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("DisenoDePlantacion").equals(tipo)) {
            jpDiseñoPlantacion jpCE = new jpDiseñoPlantacion(cn, Idioma);
            jpCE.setSize(size);
            jpCE.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpCE);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Herbicida").equals(tipo)) {
            jpHerbicida jpCE = new jpHerbicida(cn, Idioma);
            jpCE.setSize(size);
            jpCE.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpCE);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("EnfermedadPlaga").equals(tipo)) {
            jpEnfermedadPlaga jpCE = new jpEnfermedadPlaga(cn, Idioma);
            jpCE.setSize(size);
            jpCE.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpCE);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Fertilizante").equals(tipo)) {
            jpFertilizante jpFe = new jpFertilizante(cn);
            jpFe.setSize(size);
            jpFe.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpFe);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("SistemaDeProduccion").equals(tipo)) {
            jpSistemaProduccion jpSP = new jpSistemaProduccion(cn, Idioma);
            jpSP.setSize(size);
            jpSP.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpSP);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("TiposDeEvaluacion").equals(tipo)) {
            jpTipoEvaluacion jpTE = new jpTipoEvaluacion(cn, Idioma);
            jpTE.setSize(size);
            jpTE.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpTE);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("ActividadesParcela").equals(tipo)) {
            jpActividadesParcela jpAP = new jpActividadesParcela(cn);
            jpAP.setSize(size);
            jpAP.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpAP);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("FormaDeCafe").equals(tipo)) {
            jpFormaCafe jpFC = new jpFormaCafe(cn, Idioma);
            jpFC.setSize(size);
            jpFC.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpFC);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("EstadoDeCafe").equals(tipo)) {
            jpEstadoCafe jpFC = new jpEstadoCafe(cn, Idioma);
            jpFC.setSize(size);
            jpFC.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpFC);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("TipoDeCertificaciones").equals(tipo)) {
            jpTipoCertificacion jpTC = new jpTipoCertificacion(cn, Idioma);
            jpTC.setSize(size);
            jpTC.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpTC);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("ActividadesBH").equals(tipo)) {
            jpActividadesBH jpABH = new jpActividadesBH(cn, Idioma);
            jpABH.setSize(size);
            jpABH.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpABH);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Sobrantes").equals(tipo)) {
            jpSobrante jpS = new jpSobrante(cn, Idioma);
            jpS.setSize(size);
            jpS.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpS);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("ReglasDeEvaluacion").equals(tipo)) {
            jpReglasEvaluacion jpR = new jpReglasEvaluacion(cn);
            jpR.setSize(size);
            jpR.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpR);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("CalificacionSeco").equals(tipo)) {
            jpCalificacionSeco jpCalS = new jpCalificacionSeco(cn);
            jpCalS.setSize(size);
            jpCalS.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpCalS);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("CalificacionCereza").equals(tipo)) {
            jpCalificacionCereza jpCC = new jpCalificacionCereza(cn, Idioma);
            jpCC.setSize(size);
            jpCC.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpCC);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Evaluaciones").equals(tipo)) {
            jpEvaluaciones jpEva = new jpEvaluaciones(cn, Idioma);
            jpEva.setSize(size);
            jpEva.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpEva);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Personas").equals(tipo)) {
            jpPersonas jpPer = new jpPersonas(cn, Idioma);
            jpPer.setSize(size);
            jpPer.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpPer);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Perfiles").equals(tipo)) {
            jpPerfiles jpPerf = new jpPerfiles(cn, Idioma);
            jpPerf.setSize(size);
            jpPerf.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpPerf);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Usuarios").equals(tipo)) {
            jpUsuarios jpUsu = new jpUsuarios(cn, Idioma);
            jpUsu.setSize(size);
            jpUsu.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpUsu);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Retenciones").equals(tipo)) {
            jpRetenciones jpRet = new jpRetenciones(cn, Idioma);
            jpRet.setSize(size);
            jpRet.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpRet);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Puestos").equals(tipo)) {
            jpPuestos jpPues = new jpPuestos(cn, Idioma);
            jpPues.setSize(size);
            jpPues.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpPues);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("TipoDeSuelo").equals(tipo)) {
            jpSuelos jpTSuelo = new jpSuelos(cn, Idioma);
            jpTSuelo.setSize(size);
            jpTSuelo.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpTSuelo);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("NativoFauna").equals(tipo)) {
            jpFauna jpNF = new jpFauna(cn, Idioma);
            jpNF.setSize(size);
            jpNF.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpNF);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("NativoFlora").equals(tipo)) {
            jpFlora jpNFlora = new jpFlora(cn, Idioma);
            jpNFlora.setSize(size);
            jpNFlora.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpNFlora);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Certificado").equals(tipo)) {
            jpCertificado jpCertificado = new jpCertificado(cn, Idioma);
            jpCertificado.setSize(size);
            jpCertificado.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpCertificado);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Certificador").equals(tipo)) {
            jpCertificador jpCertificador = new jpCertificador(cn, Idioma);
            jpCertificador.setSize(size);
            jpCertificador.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpCertificador);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("TipoDeAccion").equals(tipo)) {
            jpTipoAccion jpTipoA = new jpTipoAccion(cn, Idioma);
            jpTipoA.setSize(size);
            jpTipoA.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpTipoA);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("MotivoPlantacion").equals(tipo)) {
            jpMotivoPlantacion jpMPlan = new jpMotivoPlantacion(cn, Idioma);
            jpMPlan.setSize(size);
            jpMPlan.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpMPlan);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("MaquinariaHerramienta").equals(tipo)) {
            jpMaquinariaHerramienta jpMH = new jpMaquinariaHerramienta(cn, Idioma);
            jpMH.setSize(size);
            jpMH.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpMH);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("ControlMaleza").equals(tipo)) {
            jpControlMaleza jpCMaleza = new jpControlMaleza(cn);
            jpCMaleza.setSize(size);
            jpCMaleza.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpCMaleza);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("TipoPoda").equals(tipo)) {
            jpTipoPoda jpTPoda = new jpTipoPoda(cn);
            jpTPoda.setSize(size);
            jpTPoda.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpTPoda);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("CategoriaArchivo").equals(tipo)) {
            jpCategoriaDeArchivos jpCArch = new jpCategoriaDeArchivos(cn);
            jpCArch.setSize(size);
            jpCArch.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpCArch);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("ProcesoDeCafe").equals(tipo)) {
            jpProcesoCafe jpProcC = new jpProcesoCafe(cn, Idioma);
            jpProcC.setSize(size);
            jpProcC.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpProcC);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("FactorFormaCafe").equals(tipo)) {
            jpFactorForma jpFFC = new jpFactorForma(cn);
            jpFFC.setSize(size);
            jpFFC.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpFFC);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("MaximoTamanoPromedio").equals(tipo)) {
            jpMaximoTamañoPromedio jpMTP = new jpMaximoTamañoPromedio(cn);
            jpMTP.setSize(size);
            jpMTP.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpMTP);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Vehiculos").equals(tipo)) {
            jpVehiculo jpVh = new jpVehiculo(cn, Idioma);
            jpVh.setSize(size);
            jpVh.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpVh);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("ActividadesBH").equals(tipo)) {
            jpAreaAlmacen jpAAl = new jpAreaAlmacen(cn);
            jpAAl.setSize(size);
            jpAAl.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpAAl);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Clima").equals(tipo)) {
            jpClima jpClima = new jpClima(cn);
            jpClima.setSize(size);
            jpClima.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpClima);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Idioma").equals(tipo)) {
            jpIdioma jpIdi = new jpIdioma(cn);
            jpIdi.setSize(size);
            jpIdi.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpIdi);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Rutas").equals(tipo)) {
            jpRutas jpRut = new jpRutas(cn);
            jpRut.setSize(size);
            jpRut.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpRut);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("MaximoRendimiento").equals(tipo)) {
            jpMaximoRendimiento jpMR = new jpMaximoRendimiento(cn);
            jpMR.setSize(size);
            jpMR.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpMR);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
            /* } else if (idioma.getProperty("FormaProceso").equals(tipo)) {
             jpFormaProceso jpFP = new jpFormaProceso(cn);
             jpFP.setSize(size);
             jpFP.setLocation(0, 0);
             panelPrincipal.removeAll();
             panelPrincipal.add(jpFP);
             panelPrincipal.revalidate();
             panelPrincipal.repaint();*/
        } else if (idioma.getProperty("Productores").equals(tipo)) {
            jpProductores jpPro = new jpProductores(cn, Idioma);
            jpPro.setSize(size);
            jpPro.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpPro);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Codigos").equals(tipo)) {
            jpCodigosCertificados jpCodC = new jpCodigosCertificados(cn, Idioma);
            jpCodC.setSize(size);
            jpCodC.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpCodC);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Recibos").equals(tipo)) {
            jpRecibos jpRec = new jpRecibos(cn, Idioma, recepcion, idUsuario);
            jpRec.setSize(size);
            jpRec.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpRec);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("CortesDelDia").equals(tipo)) {
            jpCortesDelDia jpLot = new jpCortesDelDia(cn, Idioma, recepcion);
            jpLot.setSize(size);
            jpLot.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpLot);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("CortesEnviados").equals(tipo)) {
            jpCortesEnviados jpLotE = new jpCortesEnviados(cn, Idioma, recepcion);
            jpLotE.setSize(size);
            jpLotE.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpLotE);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Recepciones").equals(tipo)) {
            jpRecepcion jpRece = new jpRecepcion(cn, Idioma);
            jpRece.setSize(size);
            jpRece.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpRece);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("BeneficiosHumedos").equals(tipo)) {
            jpBeneficiosH jpBH = new jpBeneficiosH(cn, Idioma);
            jpBH.setSize(size);
            jpBH.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpBH);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Almacenes").equals(tipo)) {
            jpAlmacenes jpAlm = new jpAlmacenes(cn, Idioma);
            jpAlm.setSize(size);
            jpAlm.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpAlm);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("CortesRecibidos").equals(tipo)) {
            jpCortesRecibidos jpCR = new jpCortesRecibidos(beneficio, cn, Idioma);
            //jpRecibirBoletas jpCR = new jpRecibirBoletas(beneficio, cn);
            jpCR.setSize(size);
            jpCR.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpCR);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Bitacora").equals(tipo)) {
            //jpLotesConfirmados jpLC = new jpLotesConfirmados(beneficio, Idioma, cn);
            //jpProcesosBH jpLC = new jpProcesosBH(beneficio, cn);
            jpBitacoraUnaVista jpLC = new jpBitacoraUnaVista(beneficio, Idioma, cn);
            jpLC.setSize(size);
            jpLC.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpLC);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Maquinaria").equals(tipo)) {
            jpMaquinaria jpMa = new jpMaquinaria(cn, Idioma);
            jpMa.setSize(size);
            jpMa.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpMa);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();

        } else if (idioma.getProperty("CortesProcesoSecado").equals(tipo)) {
            jpLotesEnProceso jpLPS = new jpLotesEnProceso(beneficio, Idioma, cn);
            jpLPS.setSize(size);
            jpLPS.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpLPS);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("SubLotesSecos").equals(tipo)) {
            jpSubLotesSecos jpSLS = new jpSubLotesSecos(beneficio, Idioma, cn);
            jpSLS.setSize(size);
            jpSLS.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpSLS);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();

        } else if (idioma.getProperty("BitacoraLaboratorio").equals(tipo)) {
            jpReporteLaboratorio jpCPre = new jpReporteLaboratorio(cn, Idioma);
            jpCPre.setSize(size);
            jpCPre.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpCPre);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();

        } else if (idioma.getProperty("MuestrasRecibidas").equals(tipo)) {
            jpRecibirMuestras jprec = new jpRecibirMuestras(cn, Idioma);
            jprec.setSize(size);
            jprec.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jprec);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("ReporteGeneral").equals(tipo)) {
            jpReporteLaboratorio jpRL = new jpReporteLaboratorio(cn, Idioma);
            jpRL.setSize(size);
            jpRL.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpRL);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();

        } else if (idioma.getProperty("SubLotesRecibidos").equals(tipo)) {
            jpSubLotesRecibidosAlmacen jpSLR = new jpSubLotesRecibidosAlmacen(almacen, Idioma, cn);
            jpSLR.setSize(size);
            jpSLR.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpSLR);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();

        } else if (idioma.getProperty("SubLotesActivos").equals(tipo)) {
            jpSubLotesActivosAlmacen jpSLA = new jpSubLotesActivosAlmacen(almacen, Idioma, cn);
            jpSLA.setSize(size);
            jpSLA.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpSLA);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();

        } else if (idioma.getProperty("Analisis").equals(tipo)) {
            jpAnalisis jpAn = new jpAnalisis(beneficio, cn);
            jpAn.setSize(size);
            jpAn.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpAn);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Muestras").equals(tipo)) {
            jpMuestras jpM = new jpMuestras(cn, Idioma);
            jpM.setSize(size);
            jpM.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpM);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("SubLotesEnviados").equals(tipo)) {
            jpSubLotesEnviadosAlmacen jpSLE = new jpSubLotesEnviadosAlmacen(almacen, Idioma, cn);
            jpSLE.setSize(size);
            jpSLE.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpSLE);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("ReportesRecepcion").equals(tipo)) {
            jpReporteRecibos jpRR = new jpReporteRecibos(cn, Idioma);
            jpRR.setSize(size);
            jpRR.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpRR);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Exportar").equals(tipo)) {
            jpExportar_Importar jpEI = new jpExportar_Importar(cn, Idioma);
            jpEI.setSize(size);
            jpEI.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpEI);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Importar").equals(tipo)) {
            jpImportar jpI = new jpImportar(cn, Idioma);
            jpI.setSize(size);
            jpI.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpI);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("ReportesKilosSociedad").equals(tipo)) {
            jpReporteKilosSociedad jpRKS = new jpReporteKilosSociedad(cn, Idioma);
            jpRKS.setSize(size);
            jpRKS.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpRKS);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("ReportesBoletaSalida").equals(tipo)) {
            jpBoletasSalidaRecepcion jpRKS = new jpBoletasSalidaRecepcion(cn, Idioma);
            jpRKS.setSize(size);
            jpRKS.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpRKS);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("ReportesAcopioProductor").equals(tipo)) {
            jpAcopioProductor jpAP = new jpAcopioProductor(cn, Idioma);
            jpAP.setSize(size);
            jpAP.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpAP);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("ReseñaHistoriaSociedad").equals(tipo)) {
            jpReseñaHistoriaSociedad jpRHS = new jpReseñaHistoriaSociedad(cn, Idioma);
            jpRHS.setSize(size);
            jpRHS.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpRHS);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("EvaluacionRecepcion").equals(tipo)) {
            jpEvaluacionRecepcion jpRHS = new jpEvaluacionRecepcion(cn, Idioma);
            jpRHS.setSize(size);
            jpRHS.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpRHS);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("Analisis").equals(tipo)) {
            jpAnalisis jpA = new jpAnalisis(beneficio, cn);
            jpA.setSize(size);
            jpA.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpA);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("HistorialCertificaciones").equals(tipo)) {
            jpHistorialCertificaciones jpHC = new jpHistorialCertificaciones(cn, Idioma);
            jpHC.setSize(size);
            jpHC.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpHC);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("PadronParcelario").equals(tipo)) {
            jpPadronParcelario jpPP = new jpPadronParcelario(cn, Idioma);
            jpPP.setSize(size);
            jpPP.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpPP);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else if (idioma.getProperty("FichasTecnicas").equals(tipo)) {
            jpFichasTecnicas jpPP = new jpFichasTecnicas(cn, Idioma);
            jpPP.setSize(size);
            jpPP.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(jpPP);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else {
            JLabel lbl = new JLabel();
            lbl.setSize(panelPrincipal.getWidth(), panelPrincipal.getHeight());
            ImageIcon fot = new ImageIcon("granos fondo.jpg");
            Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
            lbl.setIcon(icono);
            //jpFondo jpF = new jpFondo();
            //jpF.setSize(size);
            //.setLocation(0, 0);
            panelPrincipal.removeAll();
            panelPrincipal.add(lbl);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        }

        /* switch (tipo) {
         case "Sociedades":
         jpCatalogoSociedades jpCPre = new jpCatalogoSociedades(cn);
         jpCPre.setSize(size);
         jpCPre.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpCPre);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;

         case "Localidades":
         jpLocalidadesSociedades jpLS = new jpLocalidadesSociedades(cn);
         jpLS.setSize(size);
         jpLS.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpLS);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Pais":
         jpPais jpP = new jpPais(cn);
         jpP.setSize(size);
         jpP.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpP);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();

         //jpP.fprin=this;
         break;
         case "Estado":
         jpEstado jpE = new jpEstado(cn);
         jpE.setSize(size);
         jpE.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpE);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Municipio":
         jpMunicipio jpM = new jpMunicipio(cn);
         jpM.setSize(size);
         jpM.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpM);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Localidad":
         jpLocalidad jpL = new jpLocalidad(cn);
         jpL.setSize(size);
         jpL.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpL);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Colonia/Ejido":
         jpColoniaEjido jpCE = new jpColoniaEjido(cn);
         jpCE.setSize(size);
         jpCE.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpCE);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Giro de Empresa":
         jpGiroEmpresa jpGE = new jpGiroEmpresa(cn);
         jpGE.setSize(size);
         jpGE.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpGE);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Tipo de Sombra":
         jpTipoSombra jpTS = new jpTipoSombra(cn);
         jpTS.setSize(size);
         jpTS.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpTS);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Calidad de Sombra":
         jpCalidadSombra jpCS = new jpCalidadSombra(cn);
         jpCS.pp = this;
         jpCS.setSize(size);
         jpCS.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpCS);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Variedad de Café":
         jpVariedadCafe jpV = new jpVariedadCafe(cn);
         jpV.setSize(size);
         jpV.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpV);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Cultivos":
         jpCultivos jpC = new jpCultivos(cn);
         jpC.setSize(size);
         jpC.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpC);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Diseño Plantación":
         jpDiseñoPlantacion jpDP = new jpDiseñoPlantacion(cn);
         jpDP.setSize(size);
         jpDP.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpDP);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Herbicida":
         jpHerbicida jpH = new jpHerbicida(cn);
         jpH.setSize(size);
         jpH.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpH);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Enfermedad/Plaga":
         jpEnfermedadPlaga jpEP = new jpEnfermedadPlaga(cn);
         jpEP.setSize(size);
         jpEP.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpEP);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Fertilizante":
         jpFertilizante jpFe = new jpFertilizante(cn);
         jpFe.setSize(size);
         jpFe.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpFe);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Sistemas de Producción":
         jpSistemaProduccion jpSP = new jpSistemaProduccion(cn);
         jpSP.setSize(size);
         jpSP.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpSP);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Tipos de Evaluación":
         jpTipoEvaluacion jpTE = new jpTipoEvaluacion(cn);
         jpTE.setSize(size);
         jpTE.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpTE);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Actividades de Parcela":
         jpActividadesParcela jpAP = new jpActividadesParcela(cn);
         jpAP.setSize(size);
         jpAP.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpAP);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Forma de Café":
         jpFormaCafe jpFC = new jpFormaCafe(cn);
         jpFC.setSize(size);
         jpFC.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpFC);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Tipo de Certificaciones":
         jpTipoCertificacion jpTC = new jpTipoCertificacion(cn);
         jpTC.setSize(size);
         jpTC.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpTC);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Actividades de BH":
         jpActividadesBH jpABH = new jpActividadesBH(cn);
         jpABH.setSize(size);
         jpABH.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpABH);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Sobrantes":
         jpSobrante jpS = new jpSobrante(cn);
         jpS.setSize(size);
         jpS.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpS);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Reglas de Evaluación":
         jpReglasEvaluacion jpR = new jpReglasEvaluacion(cn);
         jpR.setSize(size);
         jpR.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpR);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;

         case "Calificación Seco":
         jpCalificacionSeco jpCalS = new jpCalificacionSeco(cn);
         jpCalS.setSize(size);
         jpCalS.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpCalS);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Calificación Cereza":
         jpCalificacionCereza jpCC = new jpCalificacionCereza(cn);
         jpCC.setSize(size);
         jpCC.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpCC);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Evaluaciones":
         jpEvaluaciones jpEva = new jpEvaluaciones(cn);
         jpEva.setSize(size);
         jpEva.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpEva);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Propuesta 1":
         jpPersonas jpPer = new jpPersonas(cn);
         jpPer.setSize(size);
         jpPer.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpPer);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Personas":
         jpPersonas jpPer1 = new jpPersonas(cn);
         jpPer1.setSize(size);
         jpPer1.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpPer1);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Perfiles":
         jpPerfiles jpPerf = new jpPerfiles(cn);
         jpPerf.setSize(size);
         jpPerf.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpPerf);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Retenciones":
         jpRetenciones jpRet = new jpRetenciones(cn);
         jpRet.setSize(size);
         jpRet.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpRet);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Puestos":
         jpPuestos jpPues = new jpPuestos(cn);
         jpPues.setSize(size);
         jpPues.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpPues);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Tipos de Suelo":
         jpSuelos jpTSuelo = new jpSuelos(cn);
         jpTSuelo.setSize(size);
         jpTSuelo.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpTSuelo);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Nativo Fauna":
         jpFauna jpNF = new jpFauna(cn);
         jpNF.setSize(size);
         jpNF.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpNF);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Nativo Flora":
         jpFlora jpNFlora = new jpFlora(cn);
         jpNFlora.setSize(size);
         jpNFlora.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpNFlora);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Certificado":
         jpCertificado jpCertificado = new jpCertificado(cn);
         jpCertificado.setSize(size);
         jpCertificado.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpCertificado);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Certificador":
         jpCertificador jpCertificador = new jpCertificador(cn);
         jpCertificador.setSize(size);
         jpCertificador.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpCertificador);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Tipo de Acción":
         jpTipoAccion jpTipoA = new jpTipoAccion(cn);
         jpTipoA.setSize(size);
         jpTipoA.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpTipoA);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Motivo Plantación":
         jpMotivoPlantacion jpMPlan = new jpMotivoPlantacion(cn);
         jpMPlan.setSize(size);
         jpMPlan.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpMPlan);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Maquinaria/Herramienta":
         jpMaquinariaHerramienta jpMH = new jpMaquinariaHerramienta(cn);
         jpMH.setSize(size);
         jpMH.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpMH);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Control Maleza":
         jpControlMaleza jpCMaleza = new jpControlMaleza(cn);
         jpCMaleza.setSize(size);
         jpCMaleza.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpCMaleza);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Tipo de Poda":
         jpTipoPoda jpTPoda = new jpTipoPoda(cn);
         jpTPoda.setSize(size);
         jpTPoda.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpTPoda);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Categoria de Archivo":
         jpCategoriaDeArchivos jpCArch = new jpCategoriaDeArchivos(cn);
         jpCArch.setSize(size);
         jpCArch.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpCArch);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Proceso de Café":
         jpProcesoCafe jpProcC = new jpProcesoCafe(cn);
         jpProcC.setSize(size);
         jpProcC.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpProcC);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Factor por Forma de Café":
         jpFactorForma jpFFC = new jpFactorForma(cn);
         jpFFC.setSize(size);
         jpFFC.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpFFC);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Máximo Tamaño Promedio":
         jpMaximoTamañoPromedio jpMTP = new jpMaximoTamañoPromedio(cn);
         jpMTP.setSize(size);
         jpMTP.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpMTP);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Vehículos":
         jpVehiculo jpVh = new jpVehiculo(cn);
         jpVh.setSize(size);
         jpVh.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpVh);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Área de Almacén":
         jpAreaAlmacen jpAAl = new jpAreaAlmacen(cn);
         jpAAl.setSize(size);
         jpAAl.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpAAl);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Climas":
         jpClima jpClima = new jpClima(cn);
         jpClima.setSize(size);
         jpClima.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpClima);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Idiomas":
         jpIdioma jpIdi = new jpIdioma(cn);
         jpIdi.setSize(size);
         jpIdi.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpIdi);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Rutas":
         jpRutas jpRut = new jpRutas(cn);
         jpRut.setSize(size);
         jpRut.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpRut);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Máximo Rendimiento":
         jpMaximoRendimiento jpMR = new jpMaximoRendimiento(cn);
         jpMR.setSize(size);
         jpMR.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpMR);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Forma Procesos":
         jpFormaProceso jpFP = new jpFormaProceso(cn);
         jpFP.setSize(size);
         jpFP.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpFP);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Productores":
         jpProductores jpPro = new jpProductores(cn);
         jpPro.setSize(size);
         jpPro.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpPro);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Codigos":
         jpCodigosCertificados jpCodC = new jpCodigosCertificados(cn);
         jpCodC.setSize(size);
         jpCodC.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpCodC);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Recibos":
         jpRecibos jpRec = new jpRecibos(cn, recepcion);
         jpRec.setSize(size);
         jpRec.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpRec);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Cortes del día":
         jpCortesDelDia jpLot = new jpCortesDelDia(cn, recepcion);
         jpLot.setSize(size);
         jpLot.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpLot);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Cortes Enviados":
         jpCortesEnviados jpLotE = new jpCortesEnviados(cn, recepcion);
         jpLotE.setSize(size);
         jpLotE.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpLotE);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Recepcion":
         jpRecepcion jpRece = new jpRecepcion(cn);
         jpRece.setSize(size);
         jpRece.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpRece);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Beneficios Humedos":
         jpBeneficiosH jpBH = new jpBeneficiosH(cn);
         jpBH.setSize(size);
         jpBH.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpBH);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         case "Almacenes":
         jpAlmacenes jpAlm = new jpAlmacenes(cn);
         jpAlm.setSize(size);
         jpAlm.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpAlm);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;

         case "Cortes Recibidos":
         jpCortesRecibidos jpCR = new jpCortesRecibidos(beneficio, cn);
         jpCR.setSize(size);
         jpCR.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpCR);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;

         case "Lotes Confirmados":
         jpLotesConfirmados jpLC = new jpLotesConfirmados(cn);
         jpLC.setSize(size);
         jpLC.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpLC);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;

         case "Maquinaria":
         jpMaquinaria jpMa = new jpMaquinaria(cn);
         jpMa.setSize(size);
         jpMa.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(jpMa);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;

         default:
         JLabel lbl = new JLabel();
         lbl.setSize(panelPrincipal.getWidth(), panelPrincipal.getHeight());
         ImageIcon fot = new ImageIcon("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\Sistema-CAFESUMEX\\src\\Imagenes\\granos fondo.jpg");
         Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
         lbl.setIcon(icono);
         //jpFondo jpF = new jpFondo();
         //jpF.setSize(size);
         //.setLocation(0, 0);
         panelPrincipal.removeAll();
         panelPrincipal.add(lbl);
         panelPrincipal.revalidate();
         panelPrincipal.repaint();
         break;
         }*/
    }

    public void recepcion(String recepcion) {
        this.recepcion = recepcion;

        try {
            pintarPanel("fondo");
        } catch (ParseException ex) {
            Logger.getLogger(pantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        panelArbol.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane2.setOpaque(false);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Recepcion"));
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Recibos"));
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("CortesDelDia"));
        javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("CortesEnviados"));
        javax.swing.tree.DefaultMutableTreeNode treeNode5 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Exportar"));
        treeNode1.add(treeNode2);
        treeNode1.add(treeNode3);
        treeNode1.add(treeNode4);
        treeNode1.add(treeNode5);

        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jLabel3.setVisible(true);
        jLabel6.setVisible(true);
        jLabel3.setText("Recepcion");
        jLabel6.setText(recepcion);

        //CAMBIAR COLORES BOTOTES
        btnRecepcion.setBackground(new Color(26, 66, 21));
        //QUITAR COLOR
        btnSociedades.setBackground(Color.getColor("FFFFFF"));
        btnPersonas.setBackground(Color.getColor("FFFFFF"));
        btnFincaCert.setBackground(Color.getColor("FFFFFF"));
        btnConfigurador.setBackground(Color.getColor("FFFFFF"));
        btnBH.setBackground(Color.getColor("FFFFFF"));
        btnLaboratorio.setBackground(Color.getColor("FFFFFF"));
        btnAlmacen.setBackground(Color.getColor("FFFFFF"));
        btnExportar.setBackground(Color.getColor("FFFFFF"));
        btnReportes.setBackground(Color.getColor("FFFFFF"));
    }

    public void beneficio(String beneficio) {
        this.beneficio = beneficio;

        panelArbol.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane2.setOpaque(false);

        /*  javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("BeneficioHumedo"));
         javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("BoletasRecibidas"));
         javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Procesos"));
         javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Analisis");

         */
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("BeneficioHumedo"));
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("CortesRecibidos"));
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("CortesConfirmados"));
        javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("CortesProcesoSecado"));
        javax.swing.tree.DefaultMutableTreeNode treeNode5 = new javax.swing.tree.DefaultMutableTreeNode("SubLotes Secos");
        //javax.swing.tree.DefaultMutableTreeNode treeNode6 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("SubLotesEnviados"));
        javax.swing.tree.DefaultMutableTreeNode treeNode7 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Analisis"));
        javax.swing.tree.DefaultMutableTreeNode treeNode8 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Bitacora"));
        javax.swing.tree.DefaultMutableTreeNode treeNode9 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Muestras"));

        //        javax.swing.tree.DefaultMutableTreeNode treeNode7 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("ConsumoAgua"));
//        javax.swing.tree.DefaultMutableTreeNode treeNode8 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("EntregaCascarilla"));
//        javax.swing.tree.DefaultMutableTreeNode treeNode9 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("ClimaTemperaturaAmbiente"));
//        javax.swing.tree.DefaultMutableTreeNode treeNode10 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("MantenimientoMaquinaria"));
//        javax.swing.tree.DefaultMutableTreeNode treeNode11 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("LimpiezaDeMaquinaria"));
//        javax.swing.tree.DefaultMutableTreeNode treeNode12 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("EvaluacionMaquinaria"));
        //    javax.swing.tree.DefaultMutableTreeNode treeNode13 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("SubLotesSecos"));
        treeNode1.add(treeNode2);
        //treeNode1.add(treeNode3);
        //treeNode1.add(treeNode4);
        //     treeNode1.add(treeNode4);
        // treeNode1.add(treeNode5);
        //treeNode1.add(treeNode6);
        treeNode1.add(treeNode8);
        treeNode1.add(treeNode9);
        treeNode1.add(treeNode7);
//        treeNode1.add(treeNode8);
//        treeNode1.add(treeNode9);
//        treeNode1.add(treeNode10);
//        treeNode1.add(treeNode11);
        //  treeNode1.add(treeNode13);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jLabel3.setVisible(true);
        jLabel6.setVisible(true);
        jLabel3.setText("Beneficio");
        jLabel6.setText(beneficio);
        try {
            pintarPanel("fondo");
        } catch (ParseException ex) {
            Logger.getLogger(pantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        //CAMBIAR COLORES BOTOTES
        btnBH.setBackground(new Color(26, 66, 21));
        //QUITAR COLOR
        btnSociedades.setBackground(Color.getColor("FFFFFF"));
        btnPersonas.setBackground(Color.getColor("FFFFFF"));
        btnFincaCert.setBackground(Color.getColor("FFFFFF"));
        btnRecepcion.setBackground(Color.getColor("FFFFFF"));
        btnConfigurador.setBackground(Color.getColor("FFFFFF"));
        btnLaboratorio.setBackground(Color.getColor("FFFFFF"));
        btnAlmacen.setBackground(Color.getColor("FFFFFF"));
        btnExportar.setBackground(Color.getColor("FFFFFF"));
        btnReportes.setBackground(Color.getColor("FFFFFF"));
    }

    public void almacen(String almacen) {
        this.almacen = almacen;

        panelArbol.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane2.setOpaque(false);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("ModuloAlmacen"));
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("SubLotesRecibidos"));
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("SubLotesActivos"));
        javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("SubLotesEnviados"));
        javax.swing.tree.DefaultMutableTreeNode treeNode5 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Muestras"));

        treeNode1.add(treeNode2);
        treeNode1.add(treeNode3);
        treeNode1.add(treeNode4);
        treeNode1.add(treeNode5);

        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));

        try {
            pintarPanel("fondo");
        } catch (ParseException ex) {
            Logger.getLogger(pantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        //CAMBIAR COLORES BOTOTES
        btnAlmacen.setBackground(new Color(26, 66, 21));
        //QUITAR COLOR
        btnSociedades.setBackground(Color.getColor("FFFFFF"));
        btnPersonas.setBackground(Color.getColor("FFFFFF"));
        btnConfigurador.setBackground(Color.getColor("FFFFFF"));
        btnFincaCert.setBackground(Color.getColor("FFFFFF"));
        btnRecepcion.setBackground(Color.getColor("FFFFFF"));
        btnBH.setBackground(Color.getColor("FFFFFF"));
        btnLaboratorio.setBackground(Color.getColor("FFFFFF"));
    }

    /*
     public void paint(Graphics grafico) {
     Dimension height = getSize();
     //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
     ImageIcon Img = new ImageIcon(getClass().getResource("/Imagenes/FondoPantalla.png"));
     //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
     grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
     panelPrincipal.setOpaque(false);
     panelPrincipal.paint(grafico);

     }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        btnConfigurador = new javax.swing.JButton();
        btnPersonas = new javax.swing.JButton();
        btnFincaCert = new javax.swing.JButton();
        btnRecepcion = new javax.swing.JButton();
        btnBH = new javax.swing.JButton();
        btnLaboratorio = new javax.swing.JButton();
        btnSociedades = new javax.swing.JButton();
        btnAlmacen = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        panelArbol = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        panelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FincaLab - Pantalla Principal");
        setBackground(new java.awt.Color(67, 39, 18));
        setFocusTraversalPolicyProvider(true);
        setIconImage(getIconImage());
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnConfigurador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/database(2).png"))); // NOI18N
        btnConfigurador.setText("Configurador");
        btnConfigurador.setToolTipText("");
        btnConfigurador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfigurador.setFocusPainted(false);
        btnConfigurador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConfigurador.setOpaque(false);
        btnConfigurador.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnConfigurador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguradorActionPerformed(evt);
            }
        });

        btnPersonas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/group(1).png"))); // NOI18N
        btnPersonas.setText("Personas");
        btnPersonas.setToolTipText("");
        btnPersonas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPersonas.setFocusPainted(false);
        btnPersonas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPersonas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonasActionPerformed(evt);
            }
        });

        btnFincaCert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/avatar.png"))); // NOI18N
        btnFincaCert.setText("FincaCert");
        btnFincaCert.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFincaCert.setFocusPainted(false);
        btnFincaCert.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFincaCert.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFincaCert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFincaCertActionPerformed(evt);
            }
        });

        btnRecepcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cash.png"))); // NOI18N
        btnRecepcion.setText("Recepcion");
        btnRecepcion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRecepcion.setFocusPainted(false);
        btnRecepcion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRecepcion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRecepcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecepcionActionPerformed(evt);
            }
        });

        btnBH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/machinery.png"))); // NOI18N
        btnBH.setText("B Humedo");
        btnBH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBH.setFocusPainted(false);
        btnBH.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBH.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBHActionPerformed(evt);
            }
        });

        btnLaboratorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/breakfast.png"))); // NOI18N
        btnLaboratorio.setText("Laboratorio");
        btnLaboratorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLaboratorio.setFocusPainted(false);
        btnLaboratorio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLaboratorio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaboratorioActionPerformed(evt);
            }
        });

        btnSociedades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/network.png"))); // NOI18N
        btnSociedades.setText("Sociedades");
        btnSociedades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSociedades.setFocusPainted(false);
        btnSociedades.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSociedades.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSociedades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSociedadesActionPerformed(evt);
            }
        });

        btnAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/warehouse.png"))); // NOI18N
        btnAlmacen.setText("Almacen");
        btnAlmacen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlmacen.setFocusPainted(false);
        btnAlmacen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlmacen.setOpaque(false);
        btnAlmacen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlmacenActionPerformed(evt);
            }
        });

        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/report.png"))); // NOI18N
        btnReportes.setText("Administracion");
        btnReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportes.setFocusPainted(false);
        btnReportes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReportes.setOpaque(false);
        btnReportes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        btnExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/import.png"))); // NOI18N
        btnExportar.setText("Exportar/Importar");
        btnExportar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExportar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExportarMouseClicked(evt);
            }
        });
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnConfigurador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPersonas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFincaCert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRecepcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLaboratorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSociedades)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlmacen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReportes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExportar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSociedades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLaboratorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRecepcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFincaCert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPersonas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfigurador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlmacen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReportes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExportar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelArbol.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane2.setOpaque(false);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("FincaLab");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTree1MouseClicked(evt);
            }
        });
        jTree1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTree1KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTree1);

        panelPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(130, 94, 68));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Usuario:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("jLabel4");

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("jLabel3");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jButton1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)))
        );

        javax.swing.GroupLayout panelArbolLayout = new javax.swing.GroupLayout(panelArbol);
        panelArbol.setLayout(panelArbolLayout);
        panelArbolLayout.setHorizontalGroup(
            panelArbolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArbolLayout.createSequentialGroup()
                .addGroup(panelArbolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelArbolLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelArbolLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelArbolLayout.setVerticalGroup(
            panelArbolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArbolLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelArbolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                    .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelArbol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelArbol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTree1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MouseClicked
        // TODO add your handling code here:
        TreePath tp; //jTree1.getPathForLocation(evt.getX(), evt.getY());
        tp = jTree1.getSelectionPath();

        String tipoPanel = jTree1.getLastSelectedPathComponent() + "";

        if (tp != null) {
            System.out.println(jTree1.getLastSelectedPathComponent());//tp.toString()+ "COUNT: "+c);
            // JOptionPane.showMessageDialog(null, tp.getPathCount());

            try {
                pintarPanel(tipoPanel);
            } catch (ParseException ex) {
                Logger.getLogger(pantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        /* if(compara.equals("Pais")){
         internalPrueba ip = new internalPrueba();
         escritorio.add(ip);
         ip.show();
         }*/
 /*JPanel panelPrueba = new JPanel();
         JFrame f = new JFrame();
         f.getContentPane().add(panelPrueba);
         */
        //  JPanel pP = new JPanel(panelPrueba);
        //  panelPrincipal.add(panelPrueba,BorderLayout.CENTER);

    }//GEN-LAST:event_jTree1MouseClicked

    private void btnPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonasActionPerformed
        // TODO add your handling code here:
        panelArbol.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane2.setOpaque(false);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("ModuloPersonas"));
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Personas"));
        treeNode1.add(treeNode2);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));

        try {
            pintarPanel("fondo");
        } catch (ParseException ex) {
            Logger.getLogger(pantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        //CAMBIAR COLORES BOTOTES
        btnPersonas.setBackground(new Color(26, 66, 21));
        //QUITAR COLOR
        btnSociedades.setBackground(Color.getColor("FFFFFF"));
        btnConfigurador.setBackground(Color.getColor("FFFFFF"));
        btnFincaCert.setBackground(Color.getColor("FFFFFF"));
        btnRecepcion.setBackground(Color.getColor("FFFFFF"));
        btnBH.setBackground(Color.getColor("FFFFFF"));
        btnLaboratorio.setBackground(Color.getColor("FFFFFF"));
        btnAlmacen.setBackground(Color.getColor("FFFFFF"));
        btnExportar.setBackground(Color.getColor("FFFFFF"));
        btnReportes.setBackground(Color.getColor("FFFFFF"));
    }//GEN-LAST:event_btnPersonasActionPerformed

    private void jTree1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTree1KeyReleased
        // TODO add your handling code here:
        TreePath tp; //jTree1.getPathForLocation(evt.getX(), evt.getY());
        tp = jTree1.getSelectionPath();

        String tipoPanel = jTree1.getLastSelectedPathComponent() + "";

        if (tp != null) {
            char car = (char) evt.getKeyCode();
            if (car == evt.VK_ENTER) {
                try {
                    pintarPanel(tipoPanel);
                    //this.botonIngresarActionPerformed(null);
                } catch (ParseException ex) {
                    Logger.getLogger(pantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jTree1KeyReleased

    private void btnConfiguradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguradorActionPerformed
        // TODO add your handling code here:
        panelArbol.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane2.setOpaque(false);
        /*opciones que no se estan usando actualmente
         si se requirieran se activaran
         desactivadas el 29-Jul-2019 por Candelario
         */
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Configuracion"));
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("DatosBasicos"));
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("UbicacionGeografica"));
        javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Pais"));
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Estado"));
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Municipio"));
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Localidad"));
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("ColoniaEjido"));
        treeNode3.add(treeNode4);
        //treeNode2.add(treeNode3);
        /*opciones que no se estan usando actualmente
         si se requirieran se activaran
         desactivadas el 29-Jul-2019 por Candelario
         */
//        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Personas"));
//        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("GiroEmpresa"));
//        treeNode3.add(treeNode4);
//        treeNode2.add(treeNode3);
        /*opciones que no se estan usando actualmente
         si se requirieran se activaran
         desactivadas el 29-Jul-2019 por Candelario
         */
        //treeNode1.add(treeNode2);
        treeNode1.add(treeNode3);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Seguridad"));
        /*opciones que no se estan usando actualmente
         si se requirieran se activaran
         desactivadas el 29-Jul-2019 por Candelario
         */
//        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Perfiles"));
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Usuarios"));
//        treeNode2.add(treeNode3);
        treeNode2.add(treeNode4);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Sociedad"));
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Retenciones"));
        treeNode2.add(treeNode3);
//        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Puestos"));
//        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("FincaCert"));
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("TipoDeSuelo"));
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("NativoFauna"));
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("NativoFlora"));
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("TipoDeSombra"));
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("CalidadDeSombra"));
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Certificados"));
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Certificado"));
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Certificador"));
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("TipoDeCertificaciones"));
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Codigos"));
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("VariedadDeCafe"));
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Cultivos"));
        treeNode2.add(treeNode3);
//        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("TipoDeAccion"));
//        treeNode2.add(treeNode3);
        /*opciones que no se estan usando actualmente
         si se requirieran se activaran
         desactivadas el 29-Jul-2019 por Candelario
         */
//        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("DisenoDePlantacion"));
//        treeNode2.add(treeNode3);
//        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("MotivoPlantacion"));
//        treeNode2.add(treeNode3);
//        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Herbicida"));
//        treeNode2.add(treeNode3);
//        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("MaquinariaHerramienta"));
//        treeNode2.add(treeNode3);
//        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("EnfermedadPlaga"));
//        treeNode2.add(treeNode3);
//        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("ControlMaleza"));
//        treeNode2.add(treeNode3);
//        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Fertilizante"));
//        treeNode2.add(treeNode3);
//        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("TipoPoda"));
//        treeNode2.add(treeNode3);
//        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("CategoriaArchivo"));
//        treeNode2.add(treeNode3);
//        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("ActividadesParcela"));
//        treeNode2.add(treeNode3);

        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("SistemaDeProduccion"));
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Recepcion"));
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("ProcesoDeCafe"));
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("FormaDeCafe"));
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("EstadoDeCafe"));
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("TiposDeEvaluacion"));
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Evaluaciones"));
        treeNode2.add(treeNode3);
//        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("FactorFormaCafe"));
//        treeNode2.add(treeNode3);
//        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("CalificacionSeco"));
//        treeNode2.add(treeNode3);
//        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("MaximoRendimiento"));
//        treeNode2.add(treeNode3);
//        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("MaximoTamanoPromedio"));
//        treeNode2.add(treeNode3);
//        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("ReglasDeEvaluacion"));
//        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("CalificacionCereza"));
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("BeneficioHumedo"));
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Vehiculos"));
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Maquinaria"));
        treeNode2.add(treeNode3);
        /*opciones que no se estan usando actualmente
         si se requirieran se activaran
         desactivadas el 29-Jul-2019 por Candelario
         */
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("ActividadesBH"));
        treeNode2.add(treeNode3);
//        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("AreasAlmacen"));
//        treeNode2.add(treeNode3);
//        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Rutas"));
//        treeNode2.add(treeNode3);
//        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Climas"));
//        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Sobrantes"));
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
//        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Idioma"));
//        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Idiomas"));
//        treeNode2.add(treeNode3);
//        treeNode1.add(treeNode2);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));

        //CAMBIAR COLORES BOTOTES
        btnConfigurador.setBackground(new Color(26, 66, 21));
        //QUITAR COLOR
        btnSociedades.setBackground(Color.getColor("FFFFFF"));
        btnPersonas.setBackground(Color.getColor("FFFFFF"));
        btnFincaCert.setBackground(Color.getColor("FFFFFF"));
        btnRecepcion.setBackground(Color.getColor("FFFFFF"));
        btnBH.setBackground(Color.getColor("FFFFFF"));
        btnLaboratorio.setBackground(Color.getColor("FFFFFF"));
        btnAlmacen.setBackground(Color.getColor("FFFFFF"));
        btnExportar.setBackground(Color.getColor("FFFFFF"));
        btnReportes.setBackground(Color.getColor("FFFFFF"));

        try {
            pintarPanel("fondo");
        } catch (ParseException ex) {
            Logger.getLogger(pantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnConfiguradorActionPerformed

    private void btnFincaCertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFincaCertActionPerformed
        // TODO add your handling code here:
        panelArbol.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane2.setOpaque(false);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("FincaCert"));
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Productores"));
        treeNode1.add(treeNode2);

        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));

        try {
            pintarPanel("fondo");
        } catch (ParseException ex) {
            Logger.getLogger(pantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        //CAMBIAR COLORES BOTOTES
        btnFincaCert.setBackground(new Color(26, 66, 21));
        //QUITAR COLOR
        btnSociedades.setBackground(Color.getColor("FFFFFF"));
        btnPersonas.setBackground(Color.getColor("FFFFFF"));
        btnConfigurador.setBackground(Color.getColor("FFFFFF"));
        btnRecepcion.setBackground(Color.getColor("FFFFFF"));
        btnBH.setBackground(Color.getColor("FFFFFF"));
        btnLaboratorio.setBackground(Color.getColor("FFFFFF"));
        btnAlmacen.setBackground(Color.getColor("FFFFFF"));
        btnExportar.setBackground(Color.getColor("FFFFFF"));
        btnReportes.setBackground(Color.getColor("FFFFFF"));
    }//GEN-LAST:event_btnFincaCertActionPerformed
    String recepcion = "";
    private void btnRecepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecepcionActionPerformed
        // TODO add your handling code here:
        jdSeleccionRecepcion jdSRecepcion = new jdSeleccionRecepcion(null, true, Idioma, jLabel4.getText(), cn);
        jdSRecepcion.pPrin = this;
        jdSRecepcion.setVisible(true);
    }//GEN-LAST:event_btnRecepcionActionPerformed
    String beneficio = "";
    private void btnBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBHActionPerformed
        // TODO add your handling code here:
        jdSeleccionBeneficio jdSBH = new jdSeleccionBeneficio(null, true, Idioma, jLabel4.getText(), cn);
        jdSBH.pPrin = this;
        jdSBH.setVisible(true);
    }//GEN-LAST:event_btnBHActionPerformed

    private void btnLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaboratorioActionPerformed
        // TODO add your handling code here:
        panelArbol.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane2.setOpaque(false);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("ModuloLaboratorio"));
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("MuestrasRecibidas"));
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("BitacoraLaboratorio"));
       // javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("ReporteGeneral"));
        treeNode1.add(treeNode2);
        treeNode1.add(treeNode3);
      //  treeNode1.add(treeNode4);

        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));

        try {
            pintarPanel("fondo");
        } catch (ParseException ex) {
            Logger.getLogger(pantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        //CAMBIAR COLORES BOTOTES
        btnLaboratorio.setBackground(new Color(26, 66, 21));
        //QUITAR COLOR
        btnSociedades.setBackground(Color.getColor("FFFFFF"));
        btnPersonas.setBackground(Color.getColor("FFFFFF"));
        btnConfigurador.setBackground(Color.getColor("FFFFFF"));
        btnFincaCert.setBackground(Color.getColor("FFFFFF"));
        btnRecepcion.setBackground(Color.getColor("FFFFFF"));
        btnBH.setBackground(Color.getColor("FFFFFF"));
        btnAlmacen.setBackground(Color.getColor("FFFFFF"));
        btnExportar.setBackground(Color.getColor("FFFFFF"));
        btnReportes.setBackground(Color.getColor("FFFFFF"));
    }//GEN-LAST:event_btnLaboratorioActionPerformed

    private void btnSociedadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSociedadesActionPerformed
        panelArbol.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane2.setOpaque(false);
        /*opciones que no se estan usando actualmente
         si se requirieran se activaran
         desactivadas el 29-Jul-2019 por Candelario
         */
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("ModuloSociedades"));
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Sociedades"));
//        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Localidades"));
        javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Recepciones"));
        javax.swing.tree.DefaultMutableTreeNode treeNode5 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("BeneficiosHumedos"));
        javax.swing.tree.DefaultMutableTreeNode treeNode6 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("Almacenes"));
        treeNode1.add(treeNode2);
//        treeNode1.add(treeNode3);
        treeNode1.add(treeNode4);
        treeNode1.add(treeNode5);
        treeNode1.add(treeNode6);

        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));

        try {
            pintarPanel("fondo");
        } catch (ParseException ex) {
            Logger.getLogger(pantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        //CAMBIAR COLORES BOTOTES
        btnSociedades.setBackground(new Color(26, 66, 21));
        //QUITAR COLOR
        btnRecepcion.setBackground(Color.getColor("FFFFFF"));
        btnPersonas.setBackground(Color.getColor("FFFFFF"));
        btnFincaCert.setBackground(Color.getColor("FFFFFF"));
        btnConfigurador.setBackground(Color.getColor("FFFFFF"));
        btnBH.setBackground(Color.getColor("FFFFFF"));
        btnLaboratorio.setBackground(Color.getColor("FFFFFF"));
        btnAlmacen.setBackground(Color.getColor("FFFFFF"));
        btnExportar.setBackground(Color.getColor("FFFFFF"));
        btnReportes.setBackground(Color.getColor("FFFFFF"));
    }//GEN-LAST:event_btnSociedadesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:

            int opcion = JOptionPane.showConfirmDialog(null, "¿Realmente desea salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion == 0) {
                pantallaLogin pLogin = new pantallaLogin();
                pLogin.setVisible(true);
                this.dispose();
            } else {

            }

        } catch (ParseException ex) {
            Logger.getLogger(pantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    String almacen = "";
    private void btnAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlmacenActionPerformed
        // TODO add your handling code here:
        jdSeleccionAlmacen jdSAL = new jdSeleccionAlmacen(null, true, Idioma, cn);
        jdSAL.pPrin = this;
        jdSAL.setVisible(true);
        /*
         panelArbol.setBorder(javax.swing.BorderFactory.createEtchedBorder());

         jScrollPane2.setOpaque(false);

         javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("ModuloAlmacen"));
         javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("SubLotesRecibidos"));
         javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("SubLotesActivos"));
         javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode(idioma.getProperty("SubLotesEnviados"));
         treeNode1.add(treeNode2);
         treeNode1.add(treeNode3);
         treeNode1.add(treeNode4);

         jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));

         try {
         pintarPanel("fondo");
         } catch (ParseException ex) {
         Logger.getLogger(pantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
         }

         //CAMBIAR COLORES BOTOTES
         btnAlmacen.setBackground(new Color(26, 66, 21));
         //QUITAR COLOR
         btnSociedades.setBackground(Color.getColor("FFFFFF"));
         btnPersonas.setBackground(Color.getColor("FFFFFF"));
         btnConfigurador.setBackground(Color.getColor("FFFFFF"));
         btnFincaCert.setBackground(Color.getColor("FFFFFF"));
         btnRecepcion.setBackground(Color.getColor("FFFFFF"));
         btnBH.setBackground(Color.getColor("FFFFFF"));
         btnLaboratorio.setBackground(Color.getColor("FFFFFF"));*/
    }//GEN-LAST:event_btnAlmacenActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        // TODO add your handling code here:

        panelArbol.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane2.setOpaque(false);
        //FALTAN LAS TRADUCCIONES DEL MENU EN ARBOL AQUI PONSELAAAAAAAAAAAAAAAAS NO LO OLVIDES BYE

        javax.swing.tree.DefaultMutableTreeNode treeNode0 = new javax.swing.tree.DefaultMutableTreeNode("Administracion");
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Recepcion");

        treeNode0.add(treeNode1);

        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Reporte General Recibos");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Reporte Kilos Sociedad");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Reporte Boletas Salida");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Reporte Acopio Productor");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Evaluacion en Recepcion");
        treeNode1.add(treeNode2);

        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Sociedades");
        javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Reseña Historia Sociedades");
        treeNode0.add(treeNode3);
        treeNode3.add(treeNode4);

        javax.swing.tree.DefaultMutableTreeNode treeNode5 = new javax.swing.tree.DefaultMutableTreeNode("FincaCert");
        treeNode0.add(treeNode5);
        javax.swing.tree.DefaultMutableTreeNode treeNode6 = new javax.swing.tree.DefaultMutableTreeNode("Historial Certificaciones");
        treeNode5.add(treeNode6);
        javax.swing.tree.DefaultMutableTreeNode treeNode7 = new javax.swing.tree.DefaultMutableTreeNode("Padron Parcelario");
        treeNode5.add(treeNode7);
        javax.swing.tree.DefaultMutableTreeNode treeNode8 = new javax.swing.tree.DefaultMutableTreeNode("Fichas Tecnicas");
        treeNode5.add(treeNode8);

        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode0));

        try {
            pintarPanel("fondo");
        } catch (ParseException ex) {
            Logger.getLogger(pantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        //CAMBIAR COLORES BOTOTES
        btnReportes.setBackground(new Color(26, 66, 21));
        //QUITAR COLOR
        btnSociedades.setBackground(Color.getColor("FFFFFF"));
        btnConfigurador.setBackground(Color.getColor("FFFFFF"));
        btnFincaCert.setBackground(Color.getColor("FFFFFF"));
        btnRecepcion.setBackground(Color.getColor("FFFFFF"));
        btnBH.setBackground(Color.getColor("FFFFFF"));
        btnLaboratorio.setBackground(Color.getColor("FFFFFF"));
        btnAlmacen.setBackground(Color.getColor("FFFFFF"));
        btnPersonas.setBackground(Color.getColor("FFFFFF"));
        btnExportar.setBackground(Color.getColor("FFFFFF"));
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnExportarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportarMouseClicked
        // TODO add your handling code here:
        panelArbol.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane2.setOpaque(false);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Exportar/Importar");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Exportar");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Importar");
        treeNode1.add(treeNode2);
        treeNode1.add(treeNode3);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));

        try {
            pintarPanel("fondo");
        } catch (ParseException ex) {
            Logger.getLogger(pantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        //CAMBIAR COLORES BOTOTES
        btnExportar.setBackground(new Color(26, 66, 21));
        //QUITAR COLOR
        btnSociedades.setBackground(Color.getColor("FFFFFF"));
        btnConfigurador.setBackground(Color.getColor("FFFFFF"));
        btnFincaCert.setBackground(Color.getColor("FFFFFF"));
        btnRecepcion.setBackground(Color.getColor("FFFFFF"));
        btnBH.setBackground(Color.getColor("FFFFFF"));
        btnLaboratorio.setBackground(Color.getColor("FFFFFF"));
        btnAlmacen.setBackground(Color.getColor("FFFFFF"));
        btnPersonas.setBackground(Color.getColor("FFFFFF"));
        btnReportes.setBackground(Color.getColor("FFFFFF"));

    }//GEN-LAST:event_btnExportarMouseClicked

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnExportarActionPerformed

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
            java.util.logging.Logger.getLogger(pantallaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantallaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantallaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantallaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
 /*  java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
         try {
         new pantallaPrincipal().setVisible(true);
         } catch (ParseException ex) {
         Logger.getLogger(pantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
         }
         }
         });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlmacen;
    private javax.swing.JButton btnBH;
    private javax.swing.JButton btnConfigurador;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnFincaCert;
    private javax.swing.JButton btnLaboratorio;
    private javax.swing.JButton btnPersonas;
    private javax.swing.JButton btnRecepcion;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnSociedades;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    private javax.swing.JPanel panelArbol;
    public javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
