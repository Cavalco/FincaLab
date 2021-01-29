/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_Recepcion;

import Idioma.Propiedades;
import Metodos_Configuraciones.metodosDatosBasicos;
import Metodos_Configuraciones.metodosRecepcion;
import com.placeholder.PlaceHolder;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 *
 * @author Carlos Valdez
 */
public class jpRecibos extends javax.swing.JPanel {

    /**
     * Creates new form jpRecibos
     */
    Connection cn;
    metodosDatosBasicos mdb;
    metodosRecepcion mr;
    DefaultTableModel modelo;
    jdRecibos jdR;
    String idSociedadRecepcion = "", recepcion, Idioma, idUsuario;
    Propiedades idioma;

    public jpRecibos(Connection cn, String Idioma, String recepcion, String idUsuario) {
        initComponents();

        this.cn = cn;
        this.Idioma = Idioma;
        this.idUsuario = idUsuario;
        mdb = new metodosDatosBasicos(cn, Idioma);
        mr = new metodosRecepcion(cn);
        idioma = new Propiedades(Idioma);
        modelo = (DefaultTableModel) tablaRecibos.getModel();

        idSociedadRecepcion = mdb.devuelveUnDato("select idSociedad from recepciones where idRecepcion='" + recepcion + "'");
        this.recepcion = recepcion;
        traductor();
        llenarTabla();
        sumarColumnas();

    }

    public void traductor() {
        /*jLabel1.setText(idioma.getProperty("Folio"));
        jLabel2.setText(idioma.getProperty("FolioManual"));
        jLabel3.setText(idioma.getProperty("Nombre"));
        jLabel4.setText(idioma.getProperty("ApellidoPaterno"));
        jLabel5.setText(idioma.getProperty("ApellidoMaterno"));
        jLabel6.setText(idioma.getProperty("IdCorte"));
         */
        tablaRecibos.getColumnModel().getColumn(0).setHeaderValue(idioma.getProperty("Folio"));
        tablaRecibos.getColumnModel().getColumn(1).setHeaderValue(idioma.getProperty("FolioManual"));
        tablaRecibos.getColumnModel().getColumn(2).setHeaderValue(idioma.getProperty("IdCorte"));
        // tablaRecibos.getColumnModel().getColumn(3).setHeaderValue(idioma.getProperty("FechaDeRecepcion"));
        tablaRecibos.getColumnModel().getColumn(5).setHeaderValue(idioma.getProperty("Nombre"));
        tablaRecibos.getColumnModel().getColumn(6).setHeaderValue(idioma.getProperty("ApellidoPaterno"));
        tablaRecibos.getColumnModel().getColumn(7).setHeaderValue(idioma.getProperty("ApellidoMaterno"));
        tablaRecibos.getColumnModel().getColumn(8).setHeaderValue(idioma.getProperty("Sociedad"));
        tablaRecibos.getColumnModel().getColumn(9).setHeaderValue(idioma.getProperty("Parcela"));
        tablaRecibos.getColumnModel().getColumn(10).setHeaderValue(idioma.getProperty("FormaDeCafe"));
        tablaRecibos.getColumnModel().getColumn(11).setHeaderValue(idioma.getProperty("Sacos"));
        tablaRecibos.getColumnModel().getColumn(12).setHeaderValue(idioma.getProperty("KilosRecibidos"));
        tablaRecibos.getColumnModel().getColumn(13).setHeaderValue(idioma.getProperty("TotalBruto"));
        tablaRecibos.getColumnModel().getColumn(14).setHeaderValue(idioma.getProperty("Retencion"));
        tablaRecibos.getColumnModel().getColumn(15).setHeaderValue(idioma.getProperty("Total"));
        tablaRecibos.getColumnModel().getColumn(16).setHeaderValue(idioma.getProperty("Verdes"));
        tablaRecibos.getColumnModel().getColumn(17).setHeaderValue(idioma.getProperty("Inmaduros"));
        tablaRecibos.getColumnModel().getColumn(18).setHeaderValue(idioma.getProperty("Brocados"));
        tablaRecibos.getColumnModel().getColumn(19).setHeaderValue(idioma.getProperty("Calificacion"));
        tablaRecibos.getColumnModel().getColumn(20).setHeaderValue(idioma.getProperty("Entrego"));
        tablaRecibos.getColumnModel().getColumn(21).setHeaderValue(idioma.getProperty("Observaciones"));

        jLabel7.setText(idioma.getProperty("Situacion"));
        jLabel8.setText(idioma.getProperty("TotalRecibos"));
        jLabel9.setText(idioma.getProperty("TotalSacos"));
        jLabel10.setText(idioma.getProperty("TotalKilos"));

        jButton1.setText(idioma.getProperty("Exportar"));
        jButton2.setText(idioma.getProperty("Nuevo"));
        jButton5.setText(idioma.getProperty("Ver"));
        jButton3.setText(idioma.getProperty("Cancelar"));
        jButton4.setText(idioma.getProperty("Cerrar"));

        jComboBox1.addItem(idioma.getProperty("Activos"));
        jComboBox1.addItem(idioma.getProperty("Inactivos"));
        jComboBox1.addItem(idioma.getProperty("Todos"));

        PromptSupport.setPrompt(idioma.getProperty("Folio"), txtFolio);
        PromptSupport.setPrompt(idioma.getProperty("FolioManual"), txtFolioManual);
        PromptSupport.setPrompt(idioma.getProperty("Nombre"), txtNombre);
        PromptSupport.setPrompt(idioma.getProperty("ApellidoPaterno"), txtApellidoPat);
        PromptSupport.setPrompt(idioma.getProperty("ApellidoMaterno"), txtApellidoMat);
        PromptSupport.setPrompt(idioma.getProperty("IdCorte"), txtIdLote);

        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        tablaRecibos.getColumnModel().getColumn(0).setCellRenderer(tcr);
        tablaRecibos.getColumnModel().getColumn(1).setCellRenderer(tcr);
        tablaRecibos.getColumnModel().getColumn(11).setCellRenderer(tcr);
        tablaRecibos.getColumnModel().getColumn(12).setCellRenderer(tcr);
        tablaRecibos.getColumnModel().getColumn(13).setCellRenderer(tcr);
        tablaRecibos.getColumnModel().getColumn(14).setCellRenderer(tcr);
        tablaRecibos.getColumnModel().getColumn(15).setCellRenderer(tcr);
        tablaRecibos.getColumnModel().getColumn(16).setCellRenderer(tcr);
        tablaRecibos.getColumnModel().getColumn(17).setCellRenderer(tcr);
        tablaRecibos.getColumnModel().getColumn(18).setCellRenderer(tcr);
    }

    public void llenarTabla() {
        limpiar(tablaRecibos);
        mdb.cargarInformacion2(modelo, 22, "select r.id, r.folioManual,r.idLote, r.fechaCreacion,r.fechaRecepcion, pf.Nombre, pf.ApellidoPaterno, pf.ApellidoMaterno,\n"
                + "pm.RazonSocial, p.nombre, r.formaCafe, r.sacos, r.kgRecibidos, r.totalBruto, r.retencion, r.total, r.verdes, r.inmaduros, r.brocados, r.calificacion, r.personaEntrego, r.observaciones\n"
                + "from recibos r\n"
                + "inner join personam pm on ( pm.ID=r.idSociedad)\n"
                + "inner join personaf pf on ( pf.ID=r.idPersona)\n"
                + "inner join parcelas p on ( p.id=r.idParcela)\n"
                + "inner join recepciones re on(r.idRecepcion=re.idRecepcion)\n"
                + "where re.idRecepcion='" + recepcion + "' and r.id_situacion=1 order by r.id");
        cambiarMesLetra(tablaRecibos);
        cambiarMesLetra2(tablaRecibos);
    }

    /*
                + "inner join recepciones re on(r.idSociedad=re.idSociedad)"*/
    public void buscar(String tipo) {
        limpiar(tablaRecibos);
        String where = "", situacion = "";

        switch (jComboBox1.getSelectedIndex()) {
            //Activos
            case 0:
                situacion = " =1 ";
                break;
            //Inactivos
            case 1:
                situacion = " =0 ";
                break;
            //Todos
            case 2:
                situacion = " <> 3 ";
                break;
        }

        switch (tipo) {

            case "Folio":
                where = " and r.id like '" + txtFolio.getText() + "%'";
                break;
            case "Folio Manual":
                where = " and r.folioManual like '" + txtFolioManual.getText() + "%'";
                break;
            case "Nombre":
                where = " and pf.nombre like '" + txtNombre.getText() + "%'";
                break;
            case "Ape Pat":
                where = " and pf.apellidoPaterno like '" + txtApellidoPat.getText() + "%'";
                break;
            case "Ape Mat":
                where = " and pf.apellidoMaterno like '" + txtApellidoMat.getText() + "%'";
                break;
            case "Id Corte":
                where = " and r.idLote like '" + txtIdLote.getText() + "%'";
                break;
            default:
                where = "";
                break;
        }
        mdb.cargarInformacion2(modelo, 21, "select r.id, r.folioManual,r.idLote, r.fechaCreacion,r.fechaRecepcion, pf.Nombre, pf.ApellidoPaterno, pf.ApellidoMaterno,\n"
                + "pm.RazonSocial, p.nombre, r.formaCafe, r.sacos, r.kgRecibidos, r.totalBruto, r.retencion, r.total, r.verdes, r.inmaduros, r.brocados, r.calificacion, r.personaEntrego, r.observaciones\n"
                + "from recibos r\n"
                + "inner join personam pm on ( pm.ID=r.idSociedad)\n"
                + "inner join personaf pf on ( pf.ID=r.idPersona)\n"
                + "inner join parcelas p on ( p.id=r.idParcela) "
                + "where r.id_situacion " + situacion + " and r.idSociedad=" + idSociedadRecepcion + "  " + where);
        cambiarMesLetra(tablaRecibos);
        cambiarMesLetra2(tablaRecibos);
    }

    public void cambiarMesLetra(JTable tabla) {
        for (int i = 0; i < tabla.getRowCount(); i++) {

            String fecha = tabla.getValueAt(i, 3) + "";

            String[] fecha2 = fecha.split("-");

            String año = fecha2[0];
            String mes = fecha2[1];
            String dia = fecha2[2];

            switch (mes) {
                case "01":
                    mes = "Ene";
                    break;
                case "02":
                    mes = "Feb";
                    break;
                case "03":
                    mes = "Mar";
                    break;
                case "04":
                    mes = "Abr";
                    break;
                case "05":
                    mes = "May";
                    break;
                case "06":
                    mes = "Jun";
                    break;
                case "07":
                    mes = "Jul";
                    break;
                case "08":
                    mes = "Ago";
                    break;
                case "09":
                    mes = "Sep";
                    break;
                case "10":
                    mes = "Oct";
                    break;
                case "11":
                    mes = "Nov";
                    break;
                case "12":
                    mes = "Dic";
                    break;
                default:
                    mes = "Invalid month";
                    break;
            }
            fecha = año + "-" + mes + "-" + dia;
            tabla.setValueAt(fecha, i, 3);
        }
    }

    public void cambiarMesLetra2(JTable tabla) {
        for (int i = 0; i < tabla.getRowCount(); i++) {

            String fecha = tabla.getValueAt(i, 4) + "";

            if (!fecha.equals("")) {
                String[] fecha2 = fecha.split("-");

                String año = fecha2[0];
                String mes = fecha2[1];
                String dia = fecha2[2];
                switch (mes) {
                    case "01":
                        mes = "Ene";
                        break;
                    case "02":
                        mes = "Feb";
                        break;
                    case "03":
                        mes = "Mar";
                        break;
                    case "04":
                        mes = "Abr";
                        break;
                    case "05":
                        mes = "May";
                        break;
                    case "06":
                        mes = "Jun";
                        break;
                    case "07":
                        mes = "Jul";
                        break;
                    case "08":
                        mes = "Ago";
                        break;
                    case "09":
                        mes = "Sep";
                        break;
                    case "10":
                        mes = "Oct";
                        break;
                    case "11":
                        mes = "Nov";
                        break;
                    case "12":
                        mes = "Dic";
                        break;
                    default:
                        mes = "Invalid month";
                        break;
                }
                fecha = año + "-" + mes + "-" + dia;
                tabla.setValueAt(fecha, i, 4);
            }
        }
    }

    public void sumarColumnas() {

        float contadorKg = 0, contadorSacos = 0;

        contadorProductores.setText(tablaRecibos.getRowCount() + "");

        for (int i = 0; i < tablaRecibos.getRowCount(); i++) {
            contadorSacos = contadorSacos + Float.parseFloat(tablaRecibos.getValueAt(i, 11) + "");
            contadorKg = contadorKg + Float.parseFloat(tablaRecibos.getValueAt(i, 12) + "");
        }

        this.contadorKg.setText(contadorKg + "");
        this.contadorSacos.setText(contadorSacos + "");
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRecibos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtFolio = new javax.swing.JTextField();
        txtFolioManual = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidoPat = new javax.swing.JTextField();
        txtApellidoMat = new javax.swing.JTextField();
        txtIdLote = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        contadorProductores = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        contadorSacos = new javax.swing.JLabel();
        contadorKg = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablaRecibos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Folio", "Folio Manual", "Id Corte", "Fecha Sistema", "Fecha Manual", "Nombre", "Apellido Paterno", "Apellido Materno", "Sociedad", "Parcela", "Forma Cafe", "Sacos", "Kg Recibidos", "Total Bruto", "Retencion", "Total", "Verdes", "Inmaduros", "Brocados", "Calificacion", "Entregó", "Observaciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaRecibos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaRecibos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaRecibosMouseClicked(evt);
            }
        });
        tablaRecibos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaRecibosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablaRecibos);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        txtFolio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFolioKeyReleased(evt);
            }
        });

        txtFolioManual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFolioManualKeyReleased(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        txtApellidoPat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidoPatKeyReleased(evt);
            }
        });

        txtApellidoMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidoMatKeyReleased(evt);
            }
        });

        txtIdLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdLoteKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFolioManual, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidoPat, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidoMat, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdLote, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtFolioManual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtApellidoPat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtApellidoMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtIdLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel7.setText("Situacion");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Exportar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Nuevo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cerrar");

        jButton5.setText("Ver");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        contadorProductores.setText("-");

        jLabel8.setText("Total Recibos");

        jLabel9.setText("Total Sacos");

        jLabel10.setText("Total Kg");

        contadorSacos.setText("-");

        contadorKg.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(contadorProductores))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(contadorSacos))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(contadorKg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jButton3)
                        .addComponent(jButton4)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(contadorSacos)
                        .addComponent(contadorKg))
                    .addComponent(contadorProductores))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jdRecibos jdr = new jdRecibos(null, true, "", "1", recepcion, idSociedadRecepcion, idUsuario, Idioma, cn);
        jdr.jpR = this;
        jdr.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtFolioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFolioKeyReleased
        // TODO add your handling code here:
        buscar("Folio");
        sumarColumnas();
    }//GEN-LAST:event_txtFolioKeyReleased

    private void txtFolioManualKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFolioManualKeyReleased
        // TODO add your handling code here:
        buscar("Folio Manual");
        sumarColumnas();
    }//GEN-LAST:event_txtFolioManualKeyReleased

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        // TODO add your handling code here:
        buscar("Nombre");
        sumarColumnas();
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtApellidoPatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoPatKeyReleased
        // TODO add your handling code here:
        buscar("Ape Pat");
        sumarColumnas();

    }//GEN-LAST:event_txtApellidoPatKeyReleased

    private void txtApellidoMatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoMatKeyReleased
        // TODO add your handling code here:
        buscar("Ape Mat");
        sumarColumnas();
    }//GEN-LAST:event_txtApellidoMatKeyReleased

    private void txtIdLoteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdLoteKeyReleased
        // TODO add your handling code here:
        buscar("Id Corte");
        sumarColumnas();
    }//GEN-LAST:event_txtIdLoteKeyReleased
    String idRecibo = "", idCorteRecibo = "", sacosRecibo = "", kilosRecibo = "", totalRecibo = "";
    private void tablaRecibosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRecibosMouseClicked
        // TODO add your handling code here:

        idRecibo = tablaRecibos.getValueAt(tablaRecibos.getSelectedRow(), 0) + "";
        idCorteRecibo = tablaRecibos.getValueAt(tablaRecibos.getSelectedRow(), 2) + "";
        sacosRecibo = tablaRecibos.getValueAt(tablaRecibos.getSelectedRow(), 11) + "";
        kilosRecibo = tablaRecibos.getValueAt(tablaRecibos.getSelectedRow(), 12) + "";
        totalRecibo = tablaRecibos.getValueAt(tablaRecibos.getSelectedRow(), 15) + "";

        if (evt.getClickCount() == 2) {
            jdR = new jdRecibos(null, true, idRecibo, "2", recepcion, idSociedadRecepcion, idUsuario, Idioma, cn);
            jdR.setVisible(true);
        }
        row_selected = tablaRecibos.getSelectedRow();
    }//GEN-LAST:event_tablaRecibosMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        jdR = new jdRecibos(null, true, idRecibo, "2", recepcion, idSociedadRecepcion, idUsuario, Idioma, cn);
        jdR.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        buscar("");
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        int result = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas cancelar?",
                "Confirmar Cancelación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        // 0=yes, 1=no, 2=cancel

        if (result == 0) {
            //JOptionPane.showMessageDialog(null, "SI");
            mdb.actualizarBasicos("update cortesdeldia "
                    + "set sacos = (sacos - " + sacosRecibo + "), "
                    + "kg= (kg - " + kilosRecibo + "), "
                    + "costoAcumulado = (costoAcumulado-" + totalRecibo + ") "
                    + "where idLote='" + idCorteRecibo + "' ");

            mdb.actualizarBasicos("update recibos set id_situacion=0 where id=" + idRecibo);

        } else {
            //JOptionPane.showMessageDialog(null, "NO");
        }

    }//GEN-LAST:event_jButton3ActionPerformed
    String rutaER;
    private JPanel contentPane;
    File fichero = null;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        JFileChooser file = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.csv", "csv");
        file.setFileFilter(filtro);

        int seleccion = file.showOpenDialog(contentPane);
        //Si el usuario, pincha en aceptar
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            //Seleccionamos el fichero
            fichero = file.getSelectedFile();
            //Ecribe la ruta del fichero seleccionado en el campo de texto
            rutaER = fichero.getAbsolutePath();
            rutaER = rutaER.replace('\\', '/');
            //System.out.println(fichero.getName());
            JOptionPane.showMessageDialog(null, rutaER);
        }

        mdb.exportar("SELECT\n"
                + "    pm.NombreCorto,\n"
                + "    pm.RazonSocial,\n"
                + "    r.fechaRecepcion,\n"
                + "    r.id,\n"
                + "    r.folioManual,\n"
                + "    p.clave_productor,\n"
                + "    pf.ApellidoPaterno,\n"
                + "    pf.ApellidoMaterno,\n"
                + "    pf.Nombre,\n"
                + "    case pf.ID_Genero  when 1 then 'Masculino'  when 2 then 'Femenino' end as Genero,\n"
                + "    pf.estadoSocio,\n"
                + "    pa.clave_parcela,\n"
                + "    pa.nombre,\n"
                + "    c.nombre,\n"
                + "    r.formaCafe,\n"
                + "    r.inmaduros,\n"
                + "    r.verdes,\n"
                + "    r.brocados,\n"
                + "    100-(r.verdes*r.verdes+r.inmaduros+r.brocados) as Cal_numerica,\n"
                + "    r.kgRecibidos,\n"
                + "    r.precioBrutoKgSociedad,\n"
                + "    r.totalBruto,\n"
                + "    case pf.estadoSocio when 1 then 'SI' when 2 then 'NO' when 0 then 'NO' end as Socio2,\n"
                + "    r.observaciones,\n"
                + "    r.idLote\n"
                + "FROM\n"
                + "    recibos r\n"
                + "LEFT JOIN personam pm ON\n"
                + "    (pm.ID = r.idSociedad)\n"
                + "LEFT JOIN personaf pf ON\n"
                + "    (pf.ID = r.idPersona)\n"
                + "LEFT JOIN productor p ON\n"
                + "    (p.id_persona = r.idPersona)\n"
                + "LEFT JOIN parcelas pa ON\n"
                + "    (pa.id = r.idParcela)\n"
                + "LEFT JOIN codigos_certificacion c ON\n"
                + "    (\n"
                + "        c.codigo=pa.clave_certificacion\n"
                + "    )\n"
                + "WHERE r.fechaRecepcion >  '2020-01-01' and r.id_situacion=1\n"
                + "ORDER BY\n"
                + "    r.fechaRecepcion ASC\n"
                + "INTO OUTFILE '" + rutaER + ".csv'\n"
                + "FIELDS TERMINATED BY ','\n"
                + "ENCLOSED BY '\\\"'\n"
                + "LINES TERMINATED BY '\\r\\n'");

        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(new java.io.File(rutaER + ".csv"));
        } catch (IOException ex) {
            Logger.getLogger(jdRecibos.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton1ActionPerformed
    int row_selected;
    private void tablaRecibosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaRecibosKeyReleased
        // TODO add your handling code here:
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (row_selected >= 0) {
                    row_selected = row_selected - 1;
                    idRecibo = tablaRecibos.getValueAt(row_selected, 0) + "";
                } else {
                    JOptionPane.showMessageDialog(null, "Limite de Tabla");
                }
                break;
            case KeyEvent.VK_DOWN:
                row_selected = row_selected + 1;
                idRecibo = tablaRecibos.getValueAt(row_selected, 0) + "";
                break;
        }
        //JOptionPane.showMessageDialog(null, idRecibo);
    }//GEN-LAST:event_tablaRecibosKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contadorKg;
    private javax.swing.JLabel contadorProductores;
    private javax.swing.JLabel contadorSacos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaRecibos;
    private javax.swing.JTextField txtApellidoMat;
    private javax.swing.JTextField txtApellidoPat;
    private javax.swing.JTextField txtFolio;
    private javax.swing.JTextField txtFolioManual;
    private javax.swing.JTextField txtIdLote;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
