/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_Personas;

import Formas_FincaCert.jdFormularioProductor;
import Formas_FincaCert.jpProductores;
import Idioma.Propiedades;
import Metodos_Configuraciones.metodosDatosBasicos;
import Metodos_Configuraciones.validaConfi;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Carlos Valdez
 */
public class jdFormularioPersonas extends javax.swing.JDialog {

    /**
     * Creates new form jdDetallePersona1
     */
    metodosDatosBasicos mdb;
    jdFormularioProductor formProd;
    jdAsignacionesPersonas2 jdAP;
    jdSociedadesPersonas formSoc;
    jpPersonas jpDP;
    jpProductores jpP;
    validaConfi valiConf;
    
    private JPanel contentPane;
    String idPersona, tipo, tipoPersona, Idioma;
    File fichero = null;
    Connection cn;
    Propiedades idioma;

    public jdFormularioPersonas(java.awt.Frame parent, boolean modal, String tipo, String idPersona, String tipoPersona, String Idioma, Connection c) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        cn = c;
        this.Idioma = Idioma;
        mdb = new metodosDatosBasicos(cn, Idioma);
        idioma = new Propiedades(Idioma);
        valiConf = new validaConfi();
        this.idPersona = idPersona;
        this.tipoPersona = tipoPersona;
        this.tipo = tipo;

        //titulo de la forma
        setTitle(idioma.getProperty("Personas"));
        //titulos de los Jpanel
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(idioma.getProperty("Atributos")));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(idioma.getProperty("DatosBasicos")));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(idioma.getProperty("Fotografia")));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(idioma.getProperty("UbicacionGeografica")));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(idioma.getProperty("Opciones")));        
        //pFisica.setSelected(true);
        //Radio persona fisica
        pFisica.setText(idioma.getProperty("PersonaFisica"));
        //Radio persona moral
        pMoral.setText(idioma.getProperty("PersonaMoral"));
        
        //Nombre
        jLabel1.setText(idioma.getProperty("Nombre"));
        //Apellido Paterno
        jLabel2.setText(idioma.getProperty("ApellidoPaterno"));
        //Apellido Materno
        jLabel3.setText(idioma.getProperty("ApellidoMaterno"));
        //Direccion
        jLabel5.setText(idioma.getProperty("Direccion"));
        //Codigo postal
        jLabel6.setText(idioma.getProperty("CodigoPostal"));
        //RFC
        jLabel15.setText(idioma.getProperty("IdentificacionFiscal"));
        //CURP
        jLabel16.setText(idioma.getProperty("RegistroDePoblacion"));
        //Telefono fijo
        jLabel7.setText(idioma.getProperty("TelefonoFijo"));
        //Telefono movil
        jLabel8.setText(idioma.getProperty("TelefonoMovil"));
        //Genero
        jLabel4.setText(idioma.getProperty("Genero"));
        //Sociedades
        jLabel14.setText(idioma.getProperty("Sociedades"));
        jButton6.setText(idioma.getProperty("Sociedades"));
        //Asignaciones
        jButton5.setText(idioma.getProperty("Asignaciones"));
        //Radio masculino
        radioM.setText(idioma.getProperty("Masculino"));
        //Radio femenino
        radioF.setText(idioma.getProperty("Femenino"));
        //Guardar
        jButton1.setText(idioma.getProperty("Guardar"));
        //Modificar
        jButton2.setText(idioma.getProperty("Modificar"));
        //Cerrar
        jButton3.setText(idioma.getProperty("Cerrar"));
        //Limpiar
        jButton7.setText(idioma.getProperty("Limpiar"));
        //Ruta del archivo
        jLabel17.setText(idioma.getProperty("RutaDelArchivo"));
        //Abrir
        jButton4.setText(idioma.getProperty("Abrir"));

        jLabel13.setText(idioma.getProperty("ColoniaEjido"));
        jLabel12.setText(idioma.getProperty("Localidad"));
        jLabel11.setText(idioma.getProperty("Municipio"));
        jLabel10.setText(idioma.getProperty("Estado"));
        jLabel9.setText(idioma.getProperty("Pais"));

        rellenarCombos();
        rellenarInformacion();
    }

    public void rellenarSociedades() {
        try {
            String ds = mdb.generadorStrings("select p.nombrecorto \n"
                    + "from sociedadespersona a\n "
                    + "inner join personam p on (a.ID_asociado=p.ID)\n "
                    + "where a.id_persona= " + idPersona + " and a.tipoPersona=1 order by p.razonsocial asc").replace("¬", ", ");

            //Eliminar los ultimos 2 caracteres que es un espacio y una coma ", " 
            lblSociedades.setText(ds.substring(0, ds.length() - 2));
        } catch (Exception e) {

        }
    }

    public void rellenarInformacion() {
        //    try {
        //EXPLICACION DE VARIABLE "TIPO" = TIPO DE PROCESO
        //Comparación de tipo de proceso (Visualizacion/Modificacion = 2 | Nuevo = 1)
        if (tipo.equals("2")) {
            //Comparacion de tipo de persona para realizar consulta en su tabla especifica.
            if (tipoPersona.equals("1")) {

                rellenarSociedades();

                String[] datos = mdb.cargarDatosFormularioPersonas("SELECT\n"
                        + "    nombre,\n"
                        + "    apellidopaterno,\n"
                        + "    apellidomaterno,\n"
                        + "    registrodepoblacion,\n"
                        + "    identificacionfiscal,\n"
                        + "    id_genero,\n"
                        + "    telefono,\n"
                        + "    telefonomovil,\n"
                        + "    direccion,\n"
                        + "    codigopostal,\n"
                        + "    p.Descripcion,\n"
                        + "    e.Descripcion,\n"
                        + "    m.Descripcion,\n"
                        + "    l.Descripcion,\n"
                        + "    c.Descripcion,\n"
                        + "    foto\n"
                        + "FROM\n"
                        + "    personaf x\n"
                        + "LEFT JOIN pais p ON\n"
                        + "    (X.ID_Pais = p.ID)\n"
                        + "LEFT JOIN estado e ON\n"
                        + "    (X.ID_Estado = e.ID)\n"
                        + "LEFT JOIN municipio m ON\n"
                        + "    (X.ID_Municipio = m.ID)\n"
                        + "LEFT JOIN localidad l ON\n"
                        + "    (X.ID_Localidad = l.ID)\n"
                        + "LEFT JOIN ejidocolonia c ON\n"
                        + "    (X.ID_EjidoColonia = c.ID)\n"
                        + "WHERE\n"
                        + "    x.id = " + idPersona, 16).split("¬");

                /*   System.out.println("DATOOOOOOOOOOOOOOOOS HERE AQUI VEEELOS PRRO \n" + mdb.cargarDatosFormularioPersonas("select nombre, apellidopaterno, apellidomaterno, "
                        + "registrodepoblacion, identificacionfiscal, id_genero,telefono, telefonomovil, direccion, codigopostal, "
                        + "id_pais, id_estado, id_municipio, id_localidad, id_ejidocolonia, foto from personaf where id=" + idPersona, 16));
                 */
                pFisica.setSelected(true);

                txtNombre.setText(datos[0]);
                txtApPat.setText(datos[1]);
                txtApMat.setText(datos[2]);

                txtCURP.setText(datos[3]);
                txtRFC.setText(datos[4]);

                if (datos[5].equals("1")) {
                    radioM.setSelected(true);
                    radioF.setSelected(false);
                } else {
                    radioM.setSelected(false);
                    radioF.setSelected(true);
                }

                txtTelefono.setText(datos[6]);
                txtTelefono1.setText(datos[7]);
                txtDireccion.setText(datos[8]);
                txtCP.setText(datos[9]);

                comboPais.setSelectedItem(datos[10]);
                comboEstado.setSelectedItem(datos[11]);
                comboMunicipio.setSelectedItem(datos[12]);
                comboLocalidad.setSelectedItem(datos[13]);
                comboColonia.setSelectedItem(datos[14]);

                txtRuta.setText(datos[15]);

                /*  if (mdb.devuelveId("select a.id from asignacionespersona a\n "
                        + "inner join puestos p on (a.id_puesto=p.ID)\n "
                        + "where a.id_persona=" + idPersona + " and p.Descripcion='Productor' ").equals("")) {
                    tProductor.setSelected(false);
                } else {
                    tProductor.setSelected(true);
                }*/

 /*if (mdb.devuelveId("select a.id from asignacionespersona a\n "
                        + "inner join puestos p on (a.id_puesto=p.ID)\n "
                        + "where a.id_persona=" + idPersona + " and p.Descripcion='Socio' ").equals("")) {
                    tSocio.setSelected(false);
                } else {
                    tSocio.setSelected(true);
                    jButton6.setEnabled(true);
                }*/
                if (!txtRuta.getText().equals("NO") || datos[15].equals("")) {
                    BufferedImage img = null;
                    img = decodeToImage(datos[15]);
                    ImageIcon icon = new ImageIcon(img);
                    Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lbFoto.getWidth(), lbFoto.getHeight(), Image.SCALE_DEFAULT));
                    lbFoto.setText(null);
                    lbFoto.setIcon(icono);
                }
                apagarCampos();
            } //Tipo de persona moral = 2
            else if (tipoPersona.equals("2")) {

                String[] datos = mdb.cargarDatosFormularioPersonas("SELECT\n"
                        + "    razonsocial,\n"
                        + "    nombrecorto,\n"
                        + "    clavecorte,\n"
                        + "    identificacionFiscal,\n"
                        + "    telefono,\n"
                        + "    direccion,\n"
                        + "    email,\n"
                        + "    paginaweb,\n"
                        + "    codigopostal,\n"
                        + "    p.Descripcion,\n"
                        + "    e.Descripcion,\n"
                        + "    m.Descripcion,\n"
                        + "    l.Descripcion,\n"
                        + "    c.Descripcion,\n"
                        + "    foto\n"
                        + "FROM\n"
                        + "    personam x\n"
                        + "INNER JOIN pais p ON\n"
                        + "    (X.ID_Pais = p.ID)\n"
                        + "INNER JOIN estado e ON\n"
                        + "    (X.ID_Estado = e.ID)\n"
                        + "INNER JOIN municipio m ON\n"
                        + "    (X.ID_Municipio = m.ID)\n"
                        + "INNER JOIN localidad l ON\n"
                        + "    (X.ID_Localidad = l.ID)\n"
                        + "INNER JOIN ejidocolonia c ON\n"
                        + "    (X.ID_EjidoColonia = c.ID)\n"
                        + "WHERE\n"
                        + "    x.id =" + idPersona, 15).split("¬");

                pFisica.setSelected(false);
                pMoral.setSelected(true);

                txtNombre.setText(datos[0]);
                txtApPat.setText(datos[1]);
                txtApMat.setText(datos[2]);
                txtRFC.setText(datos[3]);
                txtTelefono.setText(datos[4]);
                txtDireccion.setText(datos[5]);
                txtTelefono1.setText(datos[6]);
                txtCURP.setText(datos[7]);
                txtCP.setText(datos[8]);

                comboPais.setSelectedItem(datos[9]);
                comboEstado.setSelectedItem(datos[10]);
                comboMunicipio.setSelectedItem(datos[11]);
                comboLocalidad.setSelectedItem(datos[12]);
                comboColonia.setSelectedItem(datos[13]);

                txtRuta.setText(datos[14]);
                try {
                    if (!txtRuta.getText().equals("NO") || datos[14].equals("")) {
                        BufferedImage img = null;
                        img = decodeToImage(datos[14]);
                        ImageIcon icon = new ImageIcon(img);
                        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lbFoto.getWidth(), lbFoto.getHeight(), Image.SCALE_DEFAULT));
                        lbFoto.setText(null);
                        lbFoto.setIcon(icono);
                    }
                } catch (Exception e) {
                }
                /* if (mdb.devuelveId("select a.id from asignacionespersona a\n "
                        + "inner join puestos p on (a.id_puesto=p.ID)\n "
                        + "where a.id_persona=" + idPersona + " and p.Descripcion='Productor' ").equals("")) {
                    tProductor.setSelected(false);
                } else {
                    tProductor.setSelected(true);
                    jButton6.setEnabled(true);
                }

                if (mdb.devuelveId("select a.id from asignacionespersona a\n "
                        + "inner join puestos p on (a.id_puesto=p.ID)\n "
                        + "where a.id_persona=" + idPersona + " and p.Descripcion='Socio' ").equals("")) {
                    tSocio.setSelected(false);
                } else {
                    tSocio.setSelected(true);
                }*/
                apagarCampos();
            }
            /*else {
                pFisica.setSelected(true);
            }
             */
        } else {
            pFisica.setSelected(true);
            // sección para sugerir el país, estado, municipio, localidad y colonia/ejido
            // de la última persona capturada
            int f, c, l, m, e, p;
            String dc, dl;
            f = Integer.parseInt(mdb.devuelveUnDato("select id from personaf order by id desc limit 1"));
            p = Integer.parseInt(mdb.devuelveUnDato("select id_pais from personaf  where id = " + f));
            e = Integer.parseInt(mdb.devuelveUnDato("select id_estado from personaf  where id = " + f));
            m = Integer.parseInt(mdb.devuelveUnDato("select id_municipio from personaf  where id = " + f));
            l = Integer.parseInt(mdb.devuelveUnDato("select id_localidad from personaf order by id desc limit 1"));
            dl = mdb.devuelveUnDato("select descripcion from localidad where id = " + l);
            c = Integer.parseInt(mdb.devuelveUnDato("select id_ejidocolonia from personaf order by id desc limit 1"));
            dc = mdb.devuelveUnDato("select descripcion from ejidocolonia where id = " + c);

            comboPais.setSelectedIndex(p);
            /*comboEstado.setSelectedIndex(e);
            comboMunicipio.setSelectedIndex(m);
            comboLocalidad.setSelectedItem(dl);
            comboColonia.setSelectedItem(dc);*/
            // fin sección para sugerir el país, estado, municipio, localidad y colonia/ejido
            // de la última persona capturada
        }

        //  } catch (Exception e) {
        //  }
    }

    public void apagarCampos() {
        //Aplicar bloqueo de campos para visualización.
        txtNombre.setEnabled(false);
        txtApPat.setEnabled(false);
        txtApMat.setEnabled(false);
        radioM.setEnabled(false);
        pFisica.setEnabled(false);
//        tSocio.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtCP.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtTelefono1.setEnabled(false);
        comboPais.setEnabled(false);
        comboMunicipio.setEnabled(false);
        comboLocalidad.setEnabled(false);
        comboEstado.setEnabled(false);
        comboColonia.setEnabled(false);
        radioF.setEnabled(false);
//        tProductor.setEnabled(false);
        pMoral.setEnabled(false);
        txtRuta.setEnabled(false);
        jButton4.setEnabled(false);
        jButton1.setEnabled(false);
        jButton7.setEnabled(false);
        txtRFC.setEnabled(false);
        txtCURP.setEnabled(false);
    }

    public void rellenarCombos() {
        String pais, estado, municipio, localidad, colonia;
        String[] datos;

        datos = mdb.cargarCombos("SELECT descripcion from pais").split("¬");
        comboPais.setModel(new DefaultComboBoxModel((Object[]) datos));
        pais = comboPais.getSelectedItem() + "";

        datos = mdb.cargarCombos("SELECT e.descripcion \n"
                + "from estado e \n"
                + "inner join pais p on (e.id_pais=p.id) \n"
                + "where p.Descripcion='" + pais + "'").split("¬");
        comboEstado.setModel(new DefaultComboBoxModel((Object[]) datos));
        estado = comboEstado.getSelectedItem() + "";

        datos = mdb.cargarCombos("SELECT m.descripcion \n"
                + "from municipio m \n"
                + "inner join estado e on (m.id_estado=e.id) \n"
                + "where e.Descripcion='" + estado + "'").split("¬");
        comboMunicipio.setModel(new DefaultComboBoxModel((Object[]) datos));
        municipio = comboMunicipio.getSelectedItem() + "";

        datos = mdb.cargarCombos("SELECT m.descripcion \n"
                + "from localidad m \n"
                + "inner join municipio e on (m.id_municipio=e.id) \n"
                + "where e.Descripcion='" + municipio + "'").split("¬");
        comboLocalidad.setModel(new DefaultComboBoxModel((Object[]) datos));
        localidad = comboLocalidad.getSelectedItem() + "";

        datos = mdb.cargarCombos("SELECT m.descripcion \n"
                + "from ejidocolonia m \n"
                + "inner join localidad e on (m.id_localidad=e.id) \n"
                + "where e.Descripcion='" + localidad + "'").split("¬");
        comboColonia.setModel(new DefaultComboBoxModel((Object[]) datos));
    }

    void cargar() {
        BufferedImage img = null;
        String sql = "SELECT foto FROM persona where id=4";

        String imagen_string = null;

        try {
            Statement s = cn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                imagen_string = rs.getString("foto");
            }
            if (imagen_string.equals("")) {
                lbFoto.setIcon(null);
                lbFoto.setText("No existe imagen del producto");
            } else {
                img = decodeToImage(imagen_string);
                ImageIcon icon = new ImageIcon(img);
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lbFoto.getWidth(), lbFoto.getHeight(), Image.SCALE_DEFAULT));
                lbFoto.setText(null);
                lbFoto.setIcon(icono);
            }
        } catch (SQLException ex) {
        }
    }

    public void tipoFormulario() {
        if (tipo.equals("2")) {
            jButton5.setEnabled(true);
            jButton6.setEnabled(true);
        }

        if (pMoral.isSelected()) {
            txtNombre.setEnabled(true);
            txtApPat.setEnabled(true);
            txtApMat.setEnabled(true);
            radioF.setEnabled(false);
            radioM.setEnabled(false);
            txtCURP.setEnabled(true);
            txtRFC.setEnabled(true);
            txtDireccion.setEnabled(true);
            txtCP.setEnabled(true);
            txtTelefono.setEnabled(true);
            txtTelefono1.setEnabled(true);
            pMoral.setEnabled(true);
            pFisica.setEnabled(true);
//            tSocio.setEnabled(true);
            //           tProductor.setEnabled(true);
            comboPais.setEnabled(true);
            comboEstado.setEnabled(true);
            comboMunicipio.setEnabled(true);
            comboLocalidad.setEnabled(true);
            comboColonia.setEnabled(true);
            txtRuta.setEnabled(true);
            jButton4.setEnabled(true);
            jButton1.setEnabled(true);
            jLabel1.setText(idioma.getProperty("RazonSocial"));
            jLabel2.setText(idioma.getProperty("NombreCorto"));
            jLabel3.setText(idioma.getProperty("Clave"));
            jLabel16.setText(idioma.getProperty("PaginaWeb"));
            jLabel8.setText(idioma.getProperty("Email"));
        } else {
            jLabel1.setText(idioma.getProperty("Nombre"));
            jLabel2.setText(idioma.getProperty("ApellidoPaterno"));
            jLabel3.setText(idioma.getProperty("ApellidoMaterno"));
            jLabel16.setText(idioma.getProperty("RegistroDePoblacion"));
            jLabel8.setText(idioma.getProperty("TelefonoMovil"));
            txtNombre.setEnabled(true);
            txtApPat.setEnabled(true);
            txtApMat.setEnabled(true);
            radioM.setEnabled(true);
            pFisica.setEnabled(true);
//            tSocio.setEnabled(true);
            txtDireccion.setEnabled(true);
            txtCP.setEnabled(true);
            txtTelefono.setEnabled(true);
            txtTelefono1.setEnabled(true);
            txtCURP.setEnabled(true);
            txtRFC.setEnabled(true);
            comboPais.setEnabled(true);
            comboMunicipio.setEnabled(true);
            comboLocalidad.setEnabled(true);
            comboEstado.setEnabled(true);
            comboColonia.setEnabled(true);
            radioF.setEnabled(true);
//            tProductor.setEnabled(true);
            pMoral.setEnabled(true);
            txtRuta.setEnabled(true);
            jButton4.setEnabled(true);
            jButton1.setEnabled(true);
        }
    }

    public static BufferedImage decodeToImage(String imageString) {

        BufferedImage image = null;
        byte[] imageByte;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    public static String encodeToString(BufferedImage image) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, "jpg", bos);
            byte[] imageBytes = bos.toByteArray();

            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

    public Boolean validarFormulario() {
        txtNombre.setBackground(Color.WHITE);
        txtApPat.setBackground(Color.WHITE);
        txtApMat.setBackground(Color.WHITE);
        txtCP.setBackground(Color.WHITE);
        txtDireccion.setBackground(Color.WHITE);
        txtRFC.setBackground(Color.WHITE);
        txtCURP.setBackground(Color.WHITE);

        if (txtNombre.getText().length() <= 0) {
            txtNombre.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null, idioma.getProperty("DatosObligatorios"));
            return false;
        } else if (txtApPat.getText().length() <= 0) {
            txtApPat.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null, idioma.getProperty("DatosObligatorios"));
            return false;
        } else if (txtApMat.getText().length() <= 0) {
            txtApMat.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null, idioma.getProperty("DatosObligatorios"));
            return false;
        } else if (txtDireccion.getText().length() <= 0) {
            txtDireccion.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null, idioma.getProperty("DatosObligatorios"));
            return false;
        } else if (txtCP.getText().length() <= 0) {
            txtCP.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null, idioma.getProperty("DatosObligatorios"));
            return false;
        } else if (txtRFC.getText().length() <= 0) {
            txtRFC.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null, idioma.getProperty("DatosObligatorios"));
            return false;
        } else if (txtCURP.getText().length() <= 0) {
            txtCURP.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null, idioma.getProperty("DatosObligatorios"));
            return false;
        } else if (!radioM.isSelected() && !radioF.isSelected()) {
            JOptionPane.showMessageDialog(null, idioma.getProperty("SeleccionarGenero"));
            return false;
        } else if (comboPais.getSelectedIndex() == 0 || comboEstado.getSelectedIndex() == 0 || comboMunicipio.getSelectedIndex() == 0
                || comboLocalidad.getSelectedIndex() == 0 || comboColonia.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, idioma.getProperty("SeleccionUbicacion"));
            return false;
        } else {
            return true;
        }
    }

    public Boolean validarExistenciaF() {
        if (mdb.devuelveUnDato("select id from personaf "
                + "where nombre='" + txtNombre.getText() + "' and apellidopaterno='" + txtApPat.getText() + "' "
                + "and apellidomaterno='" + txtApMat.getText() + "' ").equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean validarExistenciaM() {
        if (mdb.devuelveUnDato("select id from personam "
                + "where razonsocial='" + txtNombre.getText() + "' ").equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public void tipoProceso() {
        try {
            String image_string = "NO", atributoS = "0", atributoP = "0", genero = "", asignacion = "";
            if (!txtRuta.getText().equals("NO")) {
                try {
                    BufferedImage img = ImageIO.read(new File(fichero.toString()));
                    image_string = encodeToString(img);
                } catch (Exception e) {
                }
            }

            if (pFisica.isSelected()) {
                tipoPersona = "1";
            } else {
                tipoPersona = "2";
            }

            if (radioM.isSelected()) {
                genero = "1";
            } else {
                genero = "2";
            }

            if (tipo.equals("1")) {

                if (tipoPersona.equals("1")) {
                    if (validarFormulario()) {
                        if (validarExistenciaF()) {
                            if (mdb.insertarBasicosComprobacion("INSERT INTO personaf VALUES(null, '" + txtNombre.getText() + "', "
                                    + "'" + txtApPat.getText() + "', '" + txtApMat.getText() + "', '" + txtCURP.getText() + "','" + txtRFC.getText() + "', "
                                    + "" + genero + ", '" + txtTelefono.getText() + "','" + txtTelefono1.getText() + "', "
                                    + "'" + txtDireccion.getText() + "', '" + txtCP.getText() + "', "
                                    + "'" + mdb.devuelveId("select id from pais where descripcion='" + comboPais.getSelectedItem() + "' ") + "',"
                                    + "'" + mdb.devuelveId("select id from estado where descripcion='" + comboEstado.getSelectedItem() + "' ") + "',"
                                    + "'" + mdb.devuelveId("select id from municipio where descripcion='" + comboMunicipio.getSelectedItem() + "' ") + "',"
                                    + "'" + mdb.devuelveId("select id from localidad where descripcion='" + comboLocalidad.getSelectedItem() + "' ") + "',"
                                    + "'" + mdb.devuelveId("select id from ejidocolonia where descripcion='" + comboColonia.getSelectedItem() + "' ") + "',"
                                    + " '" + image_string + "', 1,1,current_date(),current_time(),1,1,1,1,0) ")) {
                                idPersona = mdb.devuelveId("SELECT id FROM personaf ORDER BY id DESC LIMIT 1");
                                tipo = "2";
                                jButton5.setEnabled(true);
                                jButton6.setEnabled(true);
                                JOptionPane.showMessageDialog(null, idioma.getProperty("RegistroExitoso"));
                            } else {
                                JOptionPane.showMessageDialog(null, idioma.getProperty("ErrorIntenta"));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, idioma.getProperty("RegistroExistente"));
                        }
                    } else {

                    }
                } else {
                    if (validarExistenciaM()) {
                        if (mdb.insertarBasicosComprobacion("INSERT INTO personam VALUES(null,  "
                                + "'" + txtNombre.getText() + "', '" + txtApPat.getText() + "', '" + txtApMat.getText() + "','" + txtRFC.getText() + "', "
                                + "'" + txtTelefono.getText() + "','" + txtTelefono1.getText() + "','" + txtCURP.getText() + "', "
                                + "'" + txtDireccion.getText() + "', '" + txtCP.getText() + "', "
                                + "'" + mdb.devuelveId("select id from pais where descripcion='" + comboPais.getSelectedItem() + "' ") + "',"
                                + "'" + mdb.devuelveId("select id from estado where descripcion='" + comboEstado.getSelectedItem() + "' ") + "',"
                                + "'" + mdb.devuelveId("select id from municipio where descripcion='" + comboMunicipio.getSelectedItem() + "' ") + "',"
                                + "'" + mdb.devuelveId("select id from localidad where descripcion='" + comboLocalidad.getSelectedItem() + "' ") + "',"
                                + "'" + mdb.devuelveId("select id from ejidocolonia where descripcion='" + comboColonia.getSelectedItem() + "' ") + "',"
                                + " '" + image_string + "', 1,1,current_date(),current_time(),1,1,1,1,0)")) {

                            idPersona = mdb.devuelveId("SELECT id FROM personam ORDER BY id DESC LIMIT 1");
                            tipo = "2";
                            jButton5.setEnabled(true);
                            jButton6.setEnabled(true);
                            JOptionPane.showMessageDialog(null, idioma.getProperty("RegistroExitoso"));
                        } else {
                            JOptionPane.showMessageDialog(null, idioma.getProperty("ErrorIntenta"));
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, idioma.getProperty("RegistroExistente"));
                    }
                }

            } else {
                //AQUI METODOS PARA ACTUALIZACION DE DATOS
                if (tipoPersona.equals("1")) {
                    //JOptionPane.showMessageDialog(null, "Actualizar Fisica");
                    mdb.actualizarBasicos("UPDATE personaf SET nombre='" + txtNombre.getText() + "' , "
                            + "apellidoPaterno='" + txtApPat.getText() + "', apellidoMaterno='" + txtApMat.getText() + "',  "
                            + " id_genero=" + genero + ", telefono='" + txtTelefono.getText() + "', telefonoMovil='" + txtTelefono1.getText() + "',"
                            + " direccion='" + txtDireccion.getText() + "', codigopostal='" + txtCP.getText() + "', "
                            + "identificacionfiscal='" + txtRFC.getText() + "', registrodepoblacion='" + txtCURP.getText() + "', "
                            + " id_pais='" + mdb.devuelveId("select id from pais where descripcion='" + comboPais.getSelectedItem() + "' ") + "',"
                            + " id_estado='" + mdb.devuelveId("select id from estado where descripcion='" + comboEstado.getSelectedItem() + "' ") + "',"
                            + " id_municipio='" + mdb.devuelveId("select id from municipio where descripcion='" + comboMunicipio.getSelectedItem() + "' ") + "',"
                            + " id_localidad='" + mdb.devuelveId("select id from localidad where descripcion='" + comboLocalidad.getSelectedItem() + "' ") + "',"
                            + " id_ejidocolonia='" + mdb.devuelveId("select id from ejidocolonia where descripcion='" + comboColonia.getSelectedItem() + "' ") + "',"
                            + " foto='" + image_string + "' "
                            + " where id=" + idPersona);
                } else {
                    //JOptionPane.showMessageDialog(null, "Actualizar Moral");
                    mdb.actualizarBasicos("UPDATE personam SET razonsocial='" + txtNombre.getText() + "',  "
                            + "nombrecorto='" + txtApPat.getText() + "', clavecorte='" + txtApMat.getText() + "', "
                            + "identificacionfiscal='" + txtRFC.getText() + "', paginaweb='" + txtCURP.getText() + "', "
                            + " telefono='" + txtTelefono.getText() + "', email='" + txtTelefono1.getText() + "',"
                            + " direccion='" + txtDireccion.getText() + "', codigopostal='" + txtCP.getText() + "', "
                            + " id_pais='" + mdb.devuelveId("select id from pais where descripcion='" + comboPais.getSelectedItem() + "' ") + "',"
                            + " id_estado='" + mdb.devuelveId("select id from estado where descripcion='" + comboEstado.getSelectedItem() + "' ") + "',"
                            + " id_municipio='" + mdb.devuelveId("select id from municipio where descripcion='" + comboMunicipio.getSelectedItem() + "' ") + "',"
                            + " id_localidad='" + mdb.devuelveId("select id from localidad where descripcion='" + comboLocalidad.getSelectedItem() + "' ") + "',"
                            + " id_ejidocolonia='" + mdb.devuelveId("select id from ejidocolonia where descripcion='" + comboColonia.getSelectedItem() + "' ") + "',"
                            + " foto='" + image_string + "' "
                            + " where id=" + idPersona);
                }
            }
            jpDP.llenarTabla();
        } catch (Exception e) {
            System.err.println(e);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbFoto = new javax.swing.JLabel();
        txtRuta = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        radioF = new javax.swing.JRadioButton();
        radioM = new javax.swing.JRadioButton();
        txtTelefono1 = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtApPat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApMat = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtRFC = new javax.swing.JTextField();
        txtCURP = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        comboPais = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        comboEstado = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        comboMunicipio = new javax.swing.JComboBox<>();
        comboLocalidad = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        comboColonia = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        pFisica = new javax.swing.JRadioButton();
        pMoral = new javax.swing.JRadioButton();
        lblSociedades = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Personas");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Fotografia"));

        txtRuta.setEditable(false);
        txtRuta.setMaximumSize(new java.awt.Dimension(6, 20));
        txtRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRutaActionPerformed(evt);
            }
        });

        jButton4.setText("Abrir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel17.setText("Ruta del Archivo");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(12, 12, 12))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Basicos"));

        buttonGroup2.add(radioF);
        radioF.setText("Femenino");

        buttonGroup2.add(radioM);
        radioM.setText("Masculino");

        txtTelefono1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefono1ActionPerformed(evt);
            }
        });
        txtTelefono1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefono1KeyTyped(evt);
            }
        });

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel7.setText("Telefono Fijo");

        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDireccionKeyReleased(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel5.setText("Dirección");

        jLabel1.setText("Nombre");

        txtApPat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApPatActionPerformed(evt);
            }
        });
        txtApPat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApPatKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApPatKeyTyped(evt);
            }
        });

        jLabel3.setText("Apellido Materno");

        txtApMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApMatKeyReleased(evt);
            }
        });

        jLabel6.setText("Codigo Postal");

        txtCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPActionPerformed(evt);
            }
        });
        txtCP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCPKeyTyped(evt);
            }
        });

        jLabel2.setText("Apellido Paterno");

        jLabel8.setText("Telefono Movil");

        jLabel4.setText("Genero");

        jLabel15.setText("RFC");

        txtRFC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRFCKeyReleased(evt);
            }
        });

        txtCURP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCURPKeyReleased(evt);
            }
        });

        jLabel16.setText("CURP");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel5)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtApPat, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)))
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(txtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(radioM)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioF))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtApMat)
                                .addComponent(jLabel3)
                                .addComponent(jLabel6)
                                .addComponent(txtCP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApPat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioM)
                            .addComponent(radioF))))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Ubicación Geografica"));

        comboPais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mexico" }));
        comboPais.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboPaisItemStateChanged(evt);
            }
        });

        jLabel9.setText("Pais");

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mexico" }));
        comboEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboEstadoItemStateChanged(evt);
            }
        });

        jLabel10.setText("Estado");

        jLabel11.setText("Municipio");

        comboMunicipio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mexico" }));
        comboMunicipio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboMunicipioItemStateChanged(evt);
            }
        });

        comboLocalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mexico" }));
        comboLocalidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboLocalidadItemStateChanged(evt);
            }
        });

        jLabel12.setText("Localidad");

        jLabel13.setText("Colonia/Ejido");

        comboColonia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mexico" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(comboPais, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(comboMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(comboLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(comboColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cerrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton7.setText("Limpiar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        jButton5.setText("Asignaciones");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Sociedades");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Atributos"));

        buttonGroup1.add(pFisica);
        pFisica.setText("Persona Fisica");
        pFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pFisicaActionPerformed(evt);
            }
        });

        buttonGroup1.add(pMoral);
        pMoral.setText("Persona Moral");
        pMoral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pMoralActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pFisica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pMoral)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(pFisica)
                .addComponent(pMoral))
        );

        lblSociedades.setText("-");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Sociedades:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSociedades)
                                    .addComponent(jLabel14))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSociedades)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton7))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //Abrir catalogo de asignaciones
        String id = "";
        if (tipoPersona.equals("1")) {
            id = mdb.comprobarExistencia("select id from personaf "
                    + "where (nombre='" + txtNombre.getText() + "' and apellidoPaterno='" + txtApPat.getText() + "' and apellidoMaterno='" + txtApMat.getText() + "')");
        } else if (tipoPersona.equals("2")) {
            id = mdb.comprobarExistencia("select id from personam "
                    + "where (razonsocial='" + txtNombre.getText() + "')");
        }
        jdAP = new jdAsignacionesPersonas2(null, true, tipo, tipoPersona, txtNombre.getText() + " " + txtApPat.getText() + " " + txtApMat.getText(), idPersona, Idioma, cn);
        jdAP.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        tipoFormulario();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tipoProceso();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboLocalidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboLocalidadItemStateChanged
        // TODO add your handling code here:
        String[] datos;
        String localidad;

        localidad = comboLocalidad.getSelectedItem() + "";

        datos = mdb.cargarCombos("SELECT m.descripcion \n"
                + "from ejidocolonia m \n"
                + "inner join localidad e on (m.id_localidad=e.id) \n"
                + "where e.Descripcion='" + localidad + "'").split("¬");
        comboColonia.setModel(new DefaultComboBoxModel((Object[]) datos));
    }//GEN-LAST:event_comboLocalidadItemStateChanged

    private void comboMunicipioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboMunicipioItemStateChanged
        // TODO add your handling code here:
        String[] datos;
        String municipio, localidad;

        municipio = comboMunicipio.getSelectedItem() + "";

        datos = mdb.cargarCombos("SELECT m.descripcion \n"
                + "from localidad m \n"
                + "inner join municipio e on (m.id_municipio=e.id) \n"
                + "where e.Descripcion='" + municipio + "'").split("¬");
        comboLocalidad.setModel(new DefaultComboBoxModel((Object[]) datos));
        localidad = comboLocalidad.getSelectedItem() + "";

        datos = mdb.cargarCombos("SELECT m.descripcion \n"
                + "from ejidocolonia m \n"
                + "inner join localidad e on (m.id_localidad=e.id) \n"
                + "where e.Descripcion='" + localidad + "'").split("¬");
        comboColonia.setModel(new DefaultComboBoxModel((Object[]) datos));
    }//GEN-LAST:event_comboMunicipioItemStateChanged

    private void comboEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboEstadoItemStateChanged
        // TODO add your handling code here:
        String[] datos;
        String estado, municipio, localidad;

        estado = comboEstado.getSelectedItem() + "";

        datos = mdb.cargarCombos("SELECT m.descripcion \n"
                + "from municipio m \n"
                + "inner join estado e on (m.id_estado=e.id) \n"
                + "where e.Descripcion='" + estado + "'").split("¬");
        comboMunicipio.setModel(new DefaultComboBoxModel((Object[]) datos));
        municipio = comboMunicipio.getSelectedItem() + "";

        datos = mdb.cargarCombos("SELECT m.descripcion \n"
                + "from localidad m \n"
                + "inner join municipio e on (m.id_municipio=e.id) \n"
                + "where e.Descripcion='" + municipio + "'").split("¬");
        comboLocalidad.setModel(new DefaultComboBoxModel((Object[]) datos));
        localidad = comboLocalidad.getSelectedItem() + "";

        datos = mdb.cargarCombos("SELECT m.descripcion \n"
                + "from ejidocolonia m \n"
                + "inner join localidad e on (m.id_localidad=e.id) \n"
                + "where e.Descripcion='" + localidad + "'").split("¬");
        comboColonia.setModel(new DefaultComboBoxModel((Object[]) datos));
    }//GEN-LAST:event_comboEstadoItemStateChanged

    private void comboPaisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboPaisItemStateChanged
        // TODO add your handling code here:
        String[] datos;
        String pais, estado, municipio, localidad;

        pais = comboPais.getSelectedItem() + "";

        datos = mdb.cargarCombos("SELECT e.descripcion \n"
                + "from estado e \n"
                + "inner join pais p on (e.id_pais=p.id) \n"
                + "where p.Descripcion='" + pais + "'").split("¬");
        comboEstado.setModel(new DefaultComboBoxModel((Object[]) datos));
        estado = comboEstado.getSelectedItem() + "";

        datos = mdb.cargarCombos("SELECT m.descripcion \n"
                + "from municipio m \n"
                + "inner join estado e on (m.id_estado=e.id) \n"
                + "where e.Descripcion='" + estado + "'").split("¬");
        comboMunicipio.setModel(new DefaultComboBoxModel((Object[]) datos));
        municipio = comboMunicipio.getSelectedItem() + "";

        datos = mdb.cargarCombos("SELECT m.descripcion \n"
                + "from localidad m \n"
                + "inner join municipio e on (m.id_municipio=e.id) \n"
                + "where e.Descripcion='" + municipio + "'").split("¬");
        comboLocalidad.setModel(new DefaultComboBoxModel((Object[]) datos));
        localidad = comboLocalidad.getSelectedItem() + "";

        datos = mdb.cargarCombos("SELECT m.descripcion \n"
                + "from ejidocolonia m \n"
                + "inner join localidad e on (m.id_localidad=e.id) \n"
                + "where e.Descripcion='" + localidad + "'").split("¬");
        comboColonia.setModel(new DefaultComboBoxModel((Object[]) datos));
    }//GEN-LAST:event_comboPaisItemStateChanged

    private void txtCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPActionPerformed

    private void txtApPatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApPatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApPatActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtTelefono1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefono1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefono1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        JFileChooser file = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.jpg", "jpg");
        file.setFileFilter(filtro);

        int seleccion = file.showOpenDialog(contentPane);
        //Si el usuario, pincha en aceptar
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            //Seleccionamos el fichero
            fichero = file.getSelectedFile();
            //Ecribe la ruta del fichero seleccionado en el campo de texto
            txtRuta.setText(fichero.getAbsolutePath());
            ImageIcon icon = new ImageIcon(fichero.toString());
            //System.out.println(fichero.getName());
            Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lbFoto.getWidth(), lbFoto.getHeight(), Image.SCALE_DEFAULT));
            lbFoto.setText(null);
            lbFoto.setIcon(icono);

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRutaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRutaActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String nombre = "";
        if (tipoPersona.equals("1")) {
            nombre = txtNombre.getText() + " " + txtApPat.getText() + " " + txtApMat.getText();
        } else if (tipoPersona.equals("2")) {
            nombre = txtNombre.getText();
        }

        formSoc = new jdSociedadesPersonas(null, true, tipo, tipoPersona, nombre, idPersona, Idioma, cn);
        formSoc.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        jLabel1.setText("Nombre");
        jLabel2.setText("Apellido Paterno");
        jLabel3.setText("Apellido Materno");
        jLabel16.setText("CURP");
        jLabel8.setText("Telefono Movil");
        txtNombre.setEnabled(true);
        txtApPat.setEnabled(true);
        txtApMat.setEnabled(true);
        radioM.setEnabled(true);
        pFisica.setEnabled(true);
//        tSocio.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtCP.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtTelefono1.setEnabled(true);
        txtCURP.setEnabled(true);
        txtRFC.setEnabled(true);
        comboPais.setEnabled(true);
        comboMunicipio.setEnabled(true);
        comboLocalidad.setEnabled(true);
        comboEstado.setEnabled(true);
        comboColonia.setEnabled(true);
        radioF.setEnabled(true);
//      Productor.setEnabled(true);
        pMoral.setEnabled(true);
        txtRuta.setEnabled(true);
        jButton4.setEnabled(true);
        jButton1.setEnabled(true);
        jButton2.setEnabled(false);
        jButton5.setEnabled(false);
        jButton6.setEnabled(false);

        txtNombre.setText("");
        txtApPat.setText("");
        txtApMat.setText("");
        txtDireccion.setText("");
        txtCP.setText("");
        txtTelefono.setText("");
        txtTelefono1.setText("");
        txtCURP.setText("");
        txtRFC.setText("");
        txtRuta.setText("");

//        tSocio.setSelected(false);
//        tProductor.setSelected(false);
        idPersona = "";
        tipo = "1";


    }//GEN-LAST:event_jButton7ActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        // TODO add your handling code here:
        if (txtNombre.getText().length() != 0) {
            txtNombre.setText(valiConf.primerLetraMayuscula(txtNombre.getText()).replace("S/n", "S/N"));
            txtNombre.setText(valiConf.primerLetraMayuscula(txtNombre.getText()).replace("S/d", "S/D"));
            txtNombre.setText(valiConf.primerLetraMayuscula(txtNombre.getText()).replace("S/o", "S/O"));
        }
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtApPatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApPatKeyReleased
        // TODO add your handling code here:
        if (txtApPat.getText().length() != 0) {
            txtApPat.setText(valiConf.primerLetraMayuscula(txtApPat.getText()).replace("S/n", "S/N"));
            txtApPat.setText(valiConf.primerLetraMayuscula(txtApPat.getText()).replace("S/d", "S/D"));
            txtApPat.setText(valiConf.primerLetraMayuscula(txtApPat.getText()).replace("S/o", "S/O"));
        }
    }//GEN-LAST:event_txtApPatKeyReleased

    private void txtApMatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApMatKeyReleased
        // TODO add your handling code here:
        if (txtApMat.getText().length() != 0) {
            txtApMat.setText(valiConf.primerLetraMayuscula(txtApMat.getText()).replace("S/n", "S/N"));
            txtApMat.setText(valiConf.primerLetraMayuscula(txtApMat.getText()).replace("S/d", "S/D"));
            txtApMat.setText(valiConf.primerLetraMayuscula(txtApMat.getText()).replace("S/o", "S/O"));
        }
    }//GEN-LAST:event_txtApMatKeyReleased

    private void txtDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyReleased
        // TODO add your handling code here:
        if (txtDireccion.getText().length() != 0) {
            txtDireccion.setText(valiConf.primerLetraMayuscula(txtDireccion.getText()).replace("S/n", "S/N"));
            txtDireccion.setText(valiConf.primerLetraMayuscula(txtDireccion.getText()).replace("S/d", "S/D"));
            txtDireccion.setText(valiConf.primerLetraMayuscula(txtDireccion.getText()).replace("S/o", "S/O"));
        } 
    }//GEN-LAST:event_txtDireccionKeyReleased

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApPatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApPatKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtApPatKeyTyped

    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoKeyReleased

    private void txtTelefono1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefono1KeyTyped
        // TODO add your handling code here:
        if (pFisica.isSelected()) {
            char c = evt.getKeyChar();
            if (Character.isLetter(c)) {
                getToolkit().beep();
                evt.consume();
            }
        } else {
            txtTelefono1.setText(txtTelefono1.getText().toLowerCase());
        }
    }//GEN-LAST:event_txtTelefono1KeyTyped

    //Metodo para validar RFC
    public boolean validarRFC(String rfc) {
        rfc = rfc.toUpperCase().trim();
        return rfc.toUpperCase().matches("[A-Z]{4}[0-9]{6}[A-Z0-9]{3}");
    }

    private void txtRFCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRFCKeyReleased
        // TODO add your handling code here:
        txtRFC.setText(txtRFC.getText().toUpperCase());
        //se agrego este if para poder decir que la persona no tiene RFC
        //añadido el 22/Ago/19 por cande
        if (!txtRFC.getText().equals("S/D")) {
            if (validarRFC(txtRFC.getText())) {
                txtRFC.setBackground(Color.WHITE);
            } else {
                txtRFC.setBackground(Color.RED);
                //txtRFC.setToolTipText("Formato RFC Invalido");
                txtRFC.setToolTipText(idioma.getProperty("RFCInvalido"));
            }
        }
    }//GEN-LAST:event_txtRFCKeyReleased

    public boolean validarCURP(String curp) {
        String regex
                = "[A-Z]{1}[AEIOU]{1}[A-Z]{2}[0-9]{2}"
                + "(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])"
                + "[HM]{1}"
                + "(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)"
                + "[B-DF-HJ-NP-TV-Z]{3}"
                + "[0-9A-Z]{1}[0-9]{1}$";
        Pattern patron = Pattern.compile(regex);
        if (!patron.matcher(curp).matches()) {
            return false;
        } else {
            return true;
        }
    }

    private void txtCURPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCURPKeyReleased
        // TODO add your handling code here:
        if (pFisica.isSelected()) {
            txtCURP.setText(txtCURP.getText().toUpperCase());
            //se agrego este if para poder decir que la persona no tiene RFC
            //añadido el 22/Ago/19 por cande
            if (!txtCURP.getText().equals("S/D")){
                if (validarCURP(txtCURP.getText())) {
                    txtCURP.setBackground(Color.WHITE);
                } else {
                    txtCURP.setBackground(Color.RED);
                    //txtCURP.setToolTipText("Formato Curp Invalido");
                    txtCURP.setToolTipText(idioma.getProperty("CURPInvalido"));
                }
            }
        } else {
            txtCURP.setText(txtCURP.getText().toLowerCase());
        }
    }//GEN-LAST:event_txtCURPKeyReleased

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void pFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pFisicaActionPerformed
        // TODO add your handling code here:
        tipoFormulario();
    }//GEN-LAST:event_pFisicaActionPerformed

    private void pMoralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pMoralActionPerformed
        // TODO add your handling code here:
        tipoFormulario();
    }//GEN-LAST:event_pMoralActionPerformed

    private void txtCPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtCPKeyTyped

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
            java.util.logging.Logger.getLogger(jdFormularioPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdFormularioPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdFormularioPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdFormularioPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
 /*        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdDetallePersona1 dialog = new jdDetallePersona1(new javax.swing.JFrame(), true);
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
 /*        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdDetallePersona1 dialog = new jdDetallePersona1(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> comboColonia;
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JComboBox<String> comboLocalidad;
    private javax.swing.JComboBox<String> comboMunicipio;
    private javax.swing.JComboBox<String> comboPais;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lbFoto;
    private javax.swing.JLabel lblSociedades;
    private javax.swing.JRadioButton pFisica;
    private javax.swing.JRadioButton pMoral;
    private javax.swing.JRadioButton radioF;
    private javax.swing.JRadioButton radioM;
    private javax.swing.JTextField txtApMat;
    private javax.swing.JTextField txtApPat;
    private javax.swing.JTextField txtCP;
    private javax.swing.JTextField txtCURP;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRFC;
    private javax.swing.JTextField txtRuta;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefono1;
    // End of variables declaration//GEN-END:variables
}
