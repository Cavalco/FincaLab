/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_Personas;

import Formas_FincaCert.jdFormularioProductor;
import Formas_Configuraciones_Recepcion.*;
import Idioma.Propiedades;
import Metodos_Configuraciones.metodosDatosBasicos;
import java.sql.Connection;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos Valdez
 */
public class jdAsignacionesPersonas2 extends javax.swing.JDialog {

    /**
     * Creates new form jdFormaProceso
     */
    Connection cn;
    String tipoPersona, nombrePersona, idPersona, tipoOperacion, Idioma;
    metodosDatosBasicos mdb;
    jpEvaluaciones jpE;
    jdSociedadesPersonas formSoc;
    jdFormularioProductor jdFP;
    Propiedades idioma;

    public jdAsignacionesPersonas2(java.awt.Frame parent, boolean modal, String tipoOperacion, String tipoPersona, String nombrePersona, String idPersona, String Idioma, Connection c) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        cn = c;
        this.idPersona = idPersona;
        this.Idioma = Idioma;
        //tipoPersona es el tipo de persona
        this.tipoPersona = tipoPersona;
        this.tipoOperacion = tipoOperacion;
        this.nombrePersona = nombrePersona;
        mdb = new metodosDatosBasicos(cn, Idioma);
        idioma = new Propiedades(Idioma);
        labelPersona.setText(nombrePersona);
        setTitle(idioma.getProperty("Asignaciones"));

        traductor();
        marcarChecks();
    }

    public void traductor() {
        //checkSocio.setText(idioma.getProperty("Socio"));
        checkProd.setText(idioma.getProperty("Productor"));
        checkCapturistaR.setText(idioma.getProperty("CapturistaRecepcion"));
        checkCapturistaB.setText(idioma.getProperty("CapturistaBH"));
        checkEncargadoR.setText(idioma.getProperty("EncargadoRecepcion"));
        checkEncargadoB.setText(idioma.getProperty("EncargadoBH"));
        checkTransportista.setText(idioma.getProperty("Transportista"));
        //checkEnlace.setText(idioma.getProperty("EnlaceComercial"));
        jLabel3.setText(idioma.getProperty("Asignaciones"));
        jButton4.setText(idioma.getProperty("Cerrar"));

        jMenuItem1.setText(idioma.getProperty("ClaveProductor"));
        jMenuItem2.setText(idioma.getProperty("Parcela"));

        jMenuItem3.setText(idioma.getProperty("AsignarRecepcion"));
        jMenuItem6.setText(idioma.getProperty("AsignarRecepcion"));

        jMenuItem4.setText(idioma.getProperty("AsignarBeneficio"));
        jMenuItem7.setText(idioma.getProperty("AsignarBeneficio"));
    }

    public void marcarChecks() {
        String estadoSocio;
        if (tipoPersona.equals("1")) {
            estadoSocio = mdb.devuelveUnDato("select estadoSocio from personaf where id=" + idPersona);
        } else {
            estadoSocio = mdb.devuelveUnDato("select estadoSocio from personam where id=" + idPersona);
        }

        //1 Socio Activado
        if (estadoSocio.equals("1")) {
            jRadioButton1.setSelected(true);
        } else if (estadoSocio.equals("2")) { //2 No Asociado Activado
            jRadioButton2.setSelected(true);
        } else {
            //0 Ninguno activado
        }

        /* if (!mdb.devuelveUnDato("select id from asignacionespersona "
                + "where id_persona=" + idPersona + " and codigo='Enlace Comercial' ").equals("")) {
            checkEnlace.setSelected(true);
        }*/

 /*if (!mdb.devuelveUnDato("select id from asignacionespersona "
                + "where id_persona=" + idPersona + " and codigo='Socio' ").equals("")) {
            checkSocio.setSelected(true);
        }*/
        if (!mdb.devuelveUnDato("select id from asignacionespersona "
                + "where id_persona=" + idPersona + " and codigo='Productor' ").equals("")) {
            checkProd.setSelected(true);
        }

        if (!mdb.devuelveUnDato("select id from asignacionespersona "
                + "where id_persona=" + idPersona + " and codigo='Transportista' ").equals("")) {
            checkTransportista.setSelected(true);
        }

        if (!mdb.devuelveUnDato("select id from asignacionespersona "
                + "where id_persona=" + idPersona + " and codigo='Encargado Beneficio' ").equals("")) {
            checkEncargadoB.setSelected(true);
        }

        if (!mdb.devuelveUnDato("select id from asignacionespersona "
                + "where id_persona=" + idPersona + " and codigo='Encargado Recepcion' ").equals("")) {
            checkEncargadoR.setSelected(true);
        }

        if (!mdb.devuelveUnDato("select id from asignacionespersona "
                + "where id_persona=" + idPersona + " and codigo='Capturista Beneficio' ").equals("")) {
            checkCapturistaB.setSelected(true);
        }

        if (!mdb.devuelveUnDato("select id from asignacionespersona "
                + "where id_persona=" + idPersona + " and codigo='Capturista Recepcion' ").equals("")) {
            checkCapturistaR.setSelected(true);
        }

        if (!mdb.devuelveUnDato("select id from asignacionespersona "
                + "where id_persona=" + idPersona + " and codigo='Presidente' ").equals("")) {
            checkPresidente.setSelected(true);
        }

        if (!mdb.devuelveUnDato("select id from asignacionespersona "
                + "where id_persona=" + idPersona + " and codigo='Tesorero' ").equals("")) {
            checkTesorero.setSelected(true);
        }

        if (!mdb.devuelveUnDato("select id from asignacionespersona "
                + "where id_persona=" + idPersona + " and codigo='Secretario' ").equals("")) {
            checkSecretario.setSelected(true);
        }

        if (!mdb.devuelveUnDato("select id from asignacionespersona "
                + "where id_persona=" + idPersona + " and codigo='Vigilancia' ").equals("")) {
            checkVigilancia.setSelected(true);
        }

        if (!mdb.devuelveUnDato("select id from asignacionespersona "
                + "where id_persona=" + idPersona + " and codigo='Catador' ").equals("")) {
            checkCatador.setSelected(true);
        }

        if (!mdb.devuelveUnDato("select id from asignacionespersona "
                + "where id_persona=" + idPersona + " and codigo='ResponsableLaboratorio' ").equals("")) {
            checkLaboratorio.setSelected(true);
        }
        
        if (!mdb.devuelveUnDato("select id from asignacionespersona "
                + "where id_persona=" + idPersona + " and codigo='Director' ").equals("")) {
            checkDirector.setSelected(true);
        }
    }

    /* public void abrirFormulario(String formulario) {
        //JOptionPane.showMessageDialog(null, "Entre al case");
        switch (formulario) {
            case "Productor":
                if (mdb.devuelveUnDato("select clave_productor from productor where id_persona=" + idPersona + " and tipoPersona='" + tipoPersona + "' ") == null
                        || mdb.devuelveUnDato("select clave_productor from productor where id_persona=" + idPersona + " and tipoPersona='" + tipoPersona + "'").equals("")) {
                    jdFormularioProductor jdFPr = new jdFormularioProductor(null, true, idPersona, nombrePersona, tipoPersona, "NO", cn);
                    jdFPr.setVisible(true);
                } else {
                    jdFormularioProductor jdFPr = new jdFormularioProductor(null, true, idPersona, nombrePersona, tipoPersona, "SI", cn);
                    jdFPr.setVisible(true);
                }
                break;
            case "Socio":
                formSoc = new jdSociedadesPersonas(null, true, tipoOperacion, tipoPersona, nombrePersona, idPersona,Idioma, cn);
                formSoc.setVisible(true);
                break;
            case "Capturista Beneficio Humedo":
                jdAsignarBeneficio jdAB = new jdAsignarBeneficio(null, true, idPersona, nombrePersona, "Beneficio", cn);
                jdAB.setVisible(true);
                break;
        }
    }

    public void editarDetalles(String formulario, String item) {

        switch (formulario) {
            case "Productor":
                switch (item) {
                    case "Detalles Asignacion":

                        if (valorTB.equals("true")) {

                            if (mdb.devuelveUnDato("select clave_productor from productor where id_persona=" + idPersona + " and tipoPersona='" + tipoPersona + "' ") == null
                                    || mdb.devuelveUnDato("select clave_productor from productor where id_persona=" + idPersona + " and tipoPersona='" + tipoPersona + "'").equals("")) {
                                jdFormularioProductor jdFPr = new jdFormularioProductor(null, true, idPersona, nombrePersona, tipoPersona, "NO", cn);
                                jdFPr.setVisible(true);
                            } else {
                                jdFormularioProductor jdFPr = new jdFormularioProductor(null, true, idPersona, nombrePersona, tipoPersona, "SI", cn);
                                jdFPr.setVisible(true);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Puesto No Asignado");
                        }

                        break;

                    case "Parcelas":

                        if (mdb.devuelveUnDato("select clave_productor from productor where id_persona=" + idPersona + " and tipoPersona='" + tipoPersona + "'") == null
                                || mdb.devuelveUnDato("select clave_productor from productor where id_persona=" + idPersona + " and tipoPersona='" + tipoPersona + "'").equals("")) {
                            jdFormularioProductor jdFPr = new jdFormularioProductor(null, true, idPersona, nombrePersona, tipoPersona, "NO", cn);
                            jdFPr.setVisible(true);
                        } else {
                            jdFormularioParcelas jdFP = new jdFormularioParcelas(null, true, idPersona, tipoPersona, "", Idioma, cn);
                            jdFP.setVisible(true);
                        }

                        break;
                }
                break;

            case "Transportista":
                switch (item) {
                    case "Detalles Asignacion":
                        JOptionPane.showMessageDialog(null, "Detalle Transportista");
                    case "Vehiculos":
                        JOptionPane.showMessageDialog(null, "Vehichulos Transportista");
                        break;
                }
                break;

            case "Capturista Beneficio Humedo":

                switch (item) {
                    case "Detalles Asignacion":
                        if (valorTB.equals("true")) {
                            jdAsignarBeneficio jdAB = new jdAsignarBeneficio(null, true, idPersona, nombrePersona, "Beneficio", cn);
                            jdAB.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Puesto No Asignado");
                        }
                        break;
                }

                break;

            case "Capturista Recepcion":

                switch (item) {
                    case "Detalles Asignacion":
                        if (valorTB.equals("true")) {
                            jdAsignarBeneficio jdAB = new jdAsignarBeneficio(null, true, idPersona, nombrePersona, "Recepcion", cn);
                            jdAB.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Puesto No Asignado");
                        }
                        break;
                }

                break;

            case "Socio":
                switch (item) {
                    case "Detalles Asignacion":
                        formSoc = new jdSociedadesPersonas(null, true, tipoOperacion, tipoPersona, nombrePersona, idPersona,Idioma, cn);
                        formSoc.setVisible(true);
                        break;
                }

                break;
        }

    }*/
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

        menuProductor = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuCapturistaR = new javax.swing.JPopupMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuCapturistaB = new javax.swing.JPopupMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuSocio = new javax.swing.JPopupMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        menuEncargadoR = new javax.swing.JPopupMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        menuEncargadoB = new javax.swing.JPopupMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        labelPersona = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        checkProd = new javax.swing.JCheckBox();
        checkCapturistaR = new javax.swing.JCheckBox();
        checkEncargadoR = new javax.swing.JCheckBox();
        checkTransportista = new javax.swing.JCheckBox();
        checkEncargadoB = new javax.swing.JCheckBox();
        checkCapturistaB = new javax.swing.JCheckBox();
        checkPresidente = new javax.swing.JCheckBox();
        checkTesorero = new javax.swing.JCheckBox();
        checkVigilancia = new javax.swing.JCheckBox();
        checkSecretario = new javax.swing.JCheckBox();
        checkCatador = new javax.swing.JCheckBox();
        checkLaboratorio = new javax.swing.JCheckBox();
        checkDirector = new javax.swing.JCheckBox();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        menuProductor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuProductorMouseClicked(evt);
            }
        });

        jMenuItem1.setText("Codigo Productor");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuProductor.add(jMenuItem1);

        jMenuItem2.setText("Parcelas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuProductor.add(jMenuItem2);

        jMenuItem3.setText("Asignar Recepcion");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuCapturistaR.add(jMenuItem3);

        jMenuItem4.setText("Asignar Beneficio");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuCapturistaB.add(jMenuItem4);

        jMenuItem5.setText("Sociedades");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuSocio.add(jMenuItem5);

        jMenuItem6.setText("Asignar Recepcion");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menuEncargadoR.add(jMenuItem6);

        jMenuItem7.setText("Asignar Beneficio");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        menuEncargadoB.add(jMenuItem7);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Asignaciones de:");

        labelPersona.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelPersona.setText("-");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        checkProd.setText("Productor");
        checkProd.setComponentPopupMenu(menuProductor);
        checkProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkProdActionPerformed(evt);
            }
        });

        checkCapturistaR.setText("Capturista Recepción");
        checkCapturistaR.setComponentPopupMenu(menuCapturistaR);
        checkCapturistaR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCapturistaRActionPerformed(evt);
            }
        });

        checkEncargadoR.setText("Encargado Recepción");
        checkEncargadoR.setComponentPopupMenu(menuEncargadoR);
        checkEncargadoR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkEncargadoRActionPerformed(evt);
            }
        });

        checkTransportista.setText("Transportista");
        checkTransportista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTransportistaActionPerformed(evt);
            }
        });

        checkEncargadoB.setText("Encargado Beneficio");
        checkEncargadoB.setComponentPopupMenu(menuEncargadoB);
        checkEncargadoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkEncargadoBActionPerformed(evt);
            }
        });

        checkCapturistaB.setText("Capturista Beneficio");
        checkCapturistaB.setComponentPopupMenu(menuCapturistaB);
        checkCapturistaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCapturistaBActionPerformed(evt);
            }
        });

        checkPresidente.setText("Presidente");
        checkPresidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkPresidenteActionPerformed(evt);
            }
        });

        checkTesorero.setText("Tesorero");
        checkTesorero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTesoreroActionPerformed(evt);
            }
        });

        checkVigilancia.setText("Vigilancia");
        checkVigilancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkVigilanciaActionPerformed(evt);
            }
        });

        checkSecretario.setText("Secretario");
        checkSecretario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSecretarioActionPerformed(evt);
            }
        });

        checkCatador.setText("Catador");
        checkCatador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCatadorActionPerformed(evt);
            }
        });

        checkLaboratorio.setText("Responsable de Laboratorio");
        checkLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkLaboratorioActionPerformed(evt);
            }
        });

        checkDirector.setText("Director Sociedad");
        checkDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkDirectorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkCapturistaR)
                            .addComponent(checkCapturistaB)
                            .addComponent(checkTransportista)
                            .addComponent(checkPresidente)
                            .addComponent(checkSecretario)
                            .addComponent(checkProd))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkLaboratorio)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(checkCatador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkEncargadoR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                .addComponent(checkEncargadoB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkTesorero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkVigilancia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(checkDirector))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkProd)
                    .addComponent(checkCatador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkCapturistaR)
                    .addComponent(checkEncargadoR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkCapturistaB)
                    .addComponent(checkEncargadoB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkTransportista)
                    .addComponent(checkTesorero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkPresidente)
                    .addComponent(checkVigilancia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkSecretario)
                    .addComponent(checkLaboratorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkDirector)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton4.setText("Cerrar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Socio");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("No Asociado");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccione ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(labelPersona))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPersona)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    String valorTB = "", asignacion = "", item2;
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // Abrir codigo de productor
        if (!checkProd.isSelected()) {
            JOptionPane.showMessageDialog(null, "Asignacion No Registrada");
        } else {
            if (mdb.devuelveUnDato("select clave_productor from productor where id_persona=" + idPersona + " and tipoPersona='" + tipoPersona + "' ") == null
                    || mdb.devuelveUnDato("select clave_productor from productor where id_persona=" + idPersona + " and tipoPersona='" + tipoPersona + "'").equals("")) {
                jdFormularioProductor jdFPr = new jdFormularioProductor(null, true, idPersona, nombrePersona, tipoPersona, "NO", Idioma, cn);
                jdFPr.setVisible(true);
            } else {
                jdFormularioProductor jdFPr = new jdFormularioProductor(null, true, idPersona, nombrePersona, tipoPersona, "SI", Idioma, cn);
                jdFPr.setVisible(true);
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // Abrir formulario de parcelas
        if (!checkProd.isSelected()) {
            JOptionPane.showMessageDialog(null, "Asignacion No Registrada");
        } else {
            if (mdb.devuelveUnDato("select clave_productor from productor where id_persona=" + idPersona + " and tipoPersona='" + tipoPersona + "'") == null
                    || mdb.devuelveUnDato("select clave_productor from productor where id_persona=" + idPersona + " and tipoPersona='" + tipoPersona + "'").equals("")) {
                jdFormularioProductor jdFPr = new jdFormularioProductor(null, true, idPersona, nombrePersona, tipoPersona, "NO", Idioma, cn);
                jdFPr.setVisible(true);
            } else {
                jdFormularioParcelas jdFP = new jdFormularioParcelas(null, true, idPersona, tipoPersona, "", Idioma, cn);
                jdFP.setVisible(true);
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menuProductorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuProductorMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_menuProductorMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void checkProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkProdActionPerformed
        // TODO add your handling code here:
        if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()) {
            JOptionPane.showMessageDialog(null, "Seleccionar Tipo De Socio");
            checkProd.setSelected(false);
        } else {
            if (checkProd.isSelected()) {
                mdb.insertarBasicos("insert into asignacionespersona values(null," + idPersona + ", 'Productor', '" + checkProd.getText() + "', " + tipoPersona + " )");

                if (mdb.devuelveUnDato("select clave_productor from productor where id_persona=" + idPersona + " and tipoPersona='" + tipoPersona + "' ") == null
                        || mdb.devuelveUnDato("select clave_productor from productor where id_persona=" + idPersona + " and tipoPersona='" + tipoPersona + "'").equals("")) {
                    jdFormularioProductor jdFPr = new jdFormularioProductor(null, true, idPersona, nombrePersona, tipoPersona, "NO", Idioma, cn);
                    jdFPr.setVisible(true);
                } else {
                    jdFormularioProductor jdFPr = new jdFormularioProductor(null, true, idPersona, nombrePersona, tipoPersona, "SI", Idioma, cn);
                    jdFPr.setVisible(true);
                }

            } else {
                mdb.actualizarBasicos("delete from asignacionespersona where id_persona=" + idPersona + " and codigo='Productor' ");
            }
        }
    }//GEN-LAST:event_checkProdActionPerformed

    private void checkCapturistaRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCapturistaRActionPerformed
        // TODO add your handling code here:
        if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()) {
            JOptionPane.showMessageDialog(null, "Seleccionar Tipo De Socio");
            checkCapturistaR.setSelected(false);
        } else {
            if (checkCapturistaR.isSelected()) {
                mdb.insertarBasicos("insert into asignacionespersona values(null," + idPersona + ", 'Capturista Recepcion','" + checkCapturistaR.getText() + "', " + tipoPersona + " )");
            } else {
                mdb.actualizarBasicos("delete from asignacionespersona where id_persona=" + idPersona + " and codigo='Capturista Recepcion' ");
            }
        }
    }//GEN-LAST:event_checkCapturistaRActionPerformed

    private void checkEncargadoRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkEncargadoRActionPerformed
        // TODO add your handling code here:
        if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()) {
            JOptionPane.showMessageDialog(null, "Seleccionar Tipo De Socio");
            checkEncargadoR.setSelected(false);
        } else {
            if (checkEncargadoR.isSelected()) {
                mdb.insertarBasicos("insert into asignacionespersona values(null," + idPersona + ", 'Encargado Recepcion','" + checkEncargadoR.getText() + "', " + tipoPersona + " )");
            } else {
                mdb.actualizarBasicos("delete from asignacionespersona where id_persona=" + idPersona + " and codigo='Encargado Recepcion' ");
            }
        }
    }//GEN-LAST:event_checkEncargadoRActionPerformed

    private void checkCapturistaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCapturistaBActionPerformed
        // TODO add your handling code here:
        if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()) {
            JOptionPane.showMessageDialog(null, "Seleccionar Tipo De Socio");
            checkCapturistaB.setSelected(false);
        } else {
            if (checkCapturistaB.isSelected()) {
                mdb.insertarBasicos("insert into asignacionespersona values(null," + idPersona + ", 'Capturista Beneficio','" + checkCapturistaB.getText() + "', " + tipoPersona + " )");
            } else {
                mdb.actualizarBasicos("delete from asignacionespersona where id_persona=" + idPersona + " and codigo='Capturista Beneficio' ");
            }
        }
    }//GEN-LAST:event_checkCapturistaBActionPerformed

    private void checkEncargadoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkEncargadoBActionPerformed
        // TODO add your handling code here:
        if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()) {
            JOptionPane.showMessageDialog(null, "Seleccionar Tipo De Socio");
            checkEncargadoB.setSelected(false);
        } else {
            if (checkEncargadoB.isSelected()) {
                mdb.insertarBasicos("insert into asignacionespersona values(null," + idPersona + ", 'Encargado Beneficio','" + checkEncargadoB.getText() + "', " + tipoPersona + " )");
            } else {
                mdb.actualizarBasicos("delete from asignacionespersona where id_persona=" + idPersona + " and codigo='Encargado Beneficio' ");
            }
        }
    }//GEN-LAST:event_checkEncargadoBActionPerformed

    private void checkTransportistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTransportistaActionPerformed
        // TODO add your handling code here:
        if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()) {
            JOptionPane.showMessageDialog(null, "Seleccionar Tipo De Socio");
            checkTransportista.setSelected(false);
        } else {
            if (checkTransportista.isSelected()) {
                mdb.insertarBasicos("insert into asignacionespersona values(null," + idPersona + ", 'Transportista','" + checkTransportista.getText() + "', " + tipoPersona + " )");
            } else {
                mdb.actualizarBasicos("delete from asignacionespersona where id_persona=" + idPersona + " and codigo='Transportista' ");
            }
        }
    }//GEN-LAST:event_checkTransportistaActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        if (checkCapturistaR.isSelected()) {
            jdAsignarBeneficio jdAB = new jdAsignarBeneficio(null, true, idPersona, nombrePersona, "Recepcion", "Capturista", Idioma, cn);
            jdAB.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Sin asignar");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        if (checkCapturistaB.isSelected()) {
            jdAsignarBeneficio jdAB = new jdAsignarBeneficio(null, true, idPersona, nombrePersona, "Beneficio", "Capturista", Idioma, cn);
            jdAB.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Sin asignar");
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        formSoc = new jdSociedadesPersonas(null, true, tipoOperacion, tipoPersona, nombrePersona, idPersona, Idioma, cn);
        formSoc.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        if (checkEncargadoB.isSelected()) {
            jdAsignarBeneficio jdAB = new jdAsignarBeneficio(null, true, idPersona, nombrePersona, "Beneficio", "Encargado", Idioma, cn);
            jdAB.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Sin asignar");
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        if (checkEncargadoR.isSelected()) {
            jdAsignarBeneficio jdAB = new jdAsignarBeneficio(null, true, idPersona, nombrePersona, "Recepcion", "Encargado", Idioma, cn);
            jdAB.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Sin asignar");
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void checkPresidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPresidenteActionPerformed
        // TODO add your handling code here:
        if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()) {
            JOptionPane.showMessageDialog(null, "Seleccionar Tipo De Socio");
            checkPresidente.setSelected(false);
        } else {
            if (checkPresidente.isSelected()) {
                mdb.insertarBasicos("insert into asignacionespersona values(null," + idPersona + ", 'Presidente','" + checkPresidente.getText() + "', " + tipoPersona + " )");
            } else {
                mdb.actualizarBasicos("delete from asignacionespersona where id_persona=" + idPersona + " and codigo='Presidente' ");
            }
        }
    }//GEN-LAST:event_checkPresidenteActionPerformed

    private void checkTesoreroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTesoreroActionPerformed
        // TODO add your handling code here:
        if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()) {
            JOptionPane.showMessageDialog(null, "Seleccionar Tipo De Socio");
            checkTesorero.setSelected(false);
        } else {
            if (checkTesorero.isSelected()) {
                mdb.insertarBasicos("insert into asignacionespersona values(null," + idPersona + ", 'Tesorero','" + checkTesorero.getText() + "', " + tipoPersona + " )");
            } else {
                mdb.actualizarBasicos("delete from asignacionespersona where id_persona=" + idPersona + " and codigo='Tesorero' ");
            }
        }
    }//GEN-LAST:event_checkTesoreroActionPerformed

    private void checkSecretarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkSecretarioActionPerformed
        // TODO add your handling code here:
        if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()) {
            JOptionPane.showMessageDialog(null, "Seleccionar Tipo De Socio");
            checkSecretario.setSelected(false);
        } else {
            if (checkSecretario.isSelected()) {
                mdb.insertarBasicos("insert into asignacionespersona values(null," + idPersona + ", 'Secretario','" + checkSecretario.getText() + "', " + tipoPersona + " )");
            } else {
                mdb.actualizarBasicos("delete from asignacionespersona where id_persona=" + idPersona + " and codigo='Secretario' ");
            }
        }
    }//GEN-LAST:event_checkSecretarioActionPerformed

    private void checkVigilanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkVigilanciaActionPerformed
        // TODO add your handling code here:
        if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()) {
            JOptionPane.showMessageDialog(null, "Seleccionar Tipo De Socio");
            checkVigilancia.setSelected(false);
        } else {
            if (checkVigilancia.isSelected()) {
                mdb.insertarBasicos("insert into asignacionespersona values(null," + idPersona + ", 'Vigilancia','" + checkVigilancia.getText() + "', " + tipoPersona + " )");
            } else {
                mdb.actualizarBasicos("delete from asignacionespersona where id_persona=" + idPersona + " and codigo='Vigilancia' ");
            }
        }
    }//GEN-LAST:event_checkVigilanciaActionPerformed

    private void checkCatadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCatadorActionPerformed
        // TODO add your handling code here:
        if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()) {
            JOptionPane.showMessageDialog(null, "Seleccionar Tipo De Socio");
            checkCatador.setSelected(false);
        } else {
            if (checkCatador.isSelected()) {
                mdb.insertarBasicos("insert into asignacionespersona values(null," + idPersona + ", 'Catador','" + checkCatador.getText() + "', " + tipoPersona + " )");
            } else {
                mdb.actualizarBasicos("delete from asignacionespersona where id_persona=" + idPersona + " and codigo='Catador' ");
            }
        }

    }//GEN-LAST:event_checkCatadorActionPerformed

    private void checkLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkLaboratorioActionPerformed
        // TODO add your handling code here:
        if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()) {
            JOptionPane.showMessageDialog(null, "Seleccionar Tipo De Socio");
            checkLaboratorio.setSelected(false);
        } else {
            if (checkLaboratorio.isSelected()) {
                mdb.insertarBasicos("insert into asignacionespersona values(null," + idPersona + ", 'ResponsableLaboratorio','" + checkLaboratorio.getText() + "', " + tipoPersona + " )");
            } else {
                mdb.actualizarBasicos("delete from asignacionespersona where id_persona=" + idPersona + " and codigo='ResponsableLaboratorio' ");
            }
        }
    }//GEN-LAST:event_checkLaboratorioActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here: 
        if (tipoPersona.equals("1")) {
            mdb.actualizarBasicos("update personaf set estadoSocio=1 where id=" + idPersona);
        } else {
            mdb.actualizarBasicos("update personaf set estadoSocio=1 where id=" + idPersona);
        }

        formSoc = new jdSociedadesPersonas(null, true, tipoOperacion, tipoPersona, nombrePersona, idPersona, Idioma, cn);
        formSoc.setVisible(true);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:       
        if (tipoPersona.equals("1")) {
            mdb.actualizarBasicos("update personaf set estadoSocio=2 where id=" + idPersona);
        } else {
            mdb.actualizarBasicos("update personaf set estadoSocio=2 where id=" + idPersona);
        }

        formSoc = new jdSociedadesPersonas(null, true, tipoOperacion, tipoPersona, nombrePersona, idPersona, Idioma, cn);
        formSoc.setVisible(true);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void checkDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkDirectorActionPerformed
        // TODO add your handling code here:
    if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()) {
            JOptionPane.showMessageDialog(null, "Seleccionar Tipo De Socio");
            checkDirector.setSelected(false);
        } else {
            if (checkDirector.isSelected()) {
                mdb.insertarBasicos("insert into asignacionespersona values(null," + idPersona + ", 'Director','" + checkDirector.getText() + "', " + tipoPersona + " )");
            } else {
                mdb.actualizarBasicos("delete from asignacionespersona where id_persona=" + idPersona + " and codigo='Director' ");
            }
        }
    }//GEN-LAST:event_checkDirectorActionPerformed

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
            java.util.logging.Logger.getLogger(jdAsignacionesPersonas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdAsignacionesPersonas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdAsignacionesPersonas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdAsignacionesPersonas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox checkCapturistaB;
    private javax.swing.JCheckBox checkCapturistaR;
    private javax.swing.JCheckBox checkCatador;
    private javax.swing.JCheckBox checkDirector;
    private javax.swing.JCheckBox checkEncargadoB;
    private javax.swing.JCheckBox checkEncargadoR;
    private javax.swing.JCheckBox checkLaboratorio;
    private javax.swing.JCheckBox checkPresidente;
    private javax.swing.JCheckBox checkProd;
    private javax.swing.JCheckBox checkSecretario;
    private javax.swing.JCheckBox checkTesorero;
    private javax.swing.JCheckBox checkTransportista;
    private javax.swing.JCheckBox checkVigilancia;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JLabel labelPersona;
    private javax.swing.JPopupMenu menuCapturistaB;
    private javax.swing.JPopupMenu menuCapturistaR;
    private javax.swing.JPopupMenu menuEncargadoB;
    private javax.swing.JPopupMenu menuEncargadoR;
    private javax.swing.JPopupMenu menuProductor;
    private javax.swing.JPopupMenu menuSocio;
    // End of variables declaration//GEN-END:variables
}
