/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_Recepcion;

import Idioma.Propiedades;
import Metodos_Configuraciones.metodosDatosBasicos;
import com.placeholder.PlaceHolder;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 *
 * @author Carlos Valdez
 */
public class jpCortesDelDia extends javax.swing.JPanel {

    /**
     * Creates new form jpRecibos
     */
    Connection cn;
    metodosDatosBasicos mdb;
    DefaultTableModel modelo, modelo2;
    jdRecibos jdR;
    String idSociedad, sociedad, idRecepcion, Idioma;
    Propiedades idioma;

    public jpCortesDelDia(Connection cn, String Idioma, String idRecepcion) throws ParseException {
        initComponents();

        this.cn = cn;
        this.Idioma = Idioma;
        mdb = new metodosDatosBasicos(cn, Idioma);
        idioma = new Propiedades(Idioma);
        modelo = (DefaultTableModel) jTable1.getModel();

        this.idRecepcion = idRecepcion;
        idSociedad = mdb.devuelveUnDato("select idSociedad from recepciones where idRecepcion='" + idRecepcion + "'");
        //idRecepcion = mdb.devuelveUnDato("select id from recepciones where idRecepcion='" + recepcion + "'");
        sociedad = mdb.devuelveUnDato("select nombrecorto from personam where id=" + idSociedad);

        traductor();
        llenarTabla();

        PromptSupport.setPrompt(idioma.getProperty("IdCorte"), txtCorte);
    }

    public void traductor() {
        //jLabel1.setText(idioma.getProperty("IdCorte"));
        jLabel1.setText(idioma.getProperty("Desde"));
        jLabel2.setText(idioma.getProperty("Hasta"));
        jButton2.setText(idioma.getProperty("Buscar"));

        jLabel4.setText(idioma.getProperty("CortesDelDia"));
        jLabel3.setText(idioma.getProperty("RecibosDelcorte"));

        jLabel7.setText(idioma.getProperty("Situacion"));
        jLabel8.setText(idioma.getProperty("TotalRecibos"));
        jLabel9.setText(idioma.getProperty("TotalSacos"));
        jLabel10.setText(idioma.getProperty("TotalKilos"));

        jButton1.setText(idioma.getProperty("Enviar"));
        jButton5.setText(idioma.getProperty("VerRecibo"));
        jButton4.setText(idioma.getProperty("Cerrar"));

        //Tabla Cortes del Dia
        jTable1.getColumnModel().getColumn(0).setHeaderValue(idioma.getProperty("Fecha"));
        jTable1.getColumnModel().getColumn(1).setHeaderValue(idioma.getProperty("FechaJuliana"));
        jTable1.getColumnModel().getColumn(2).setHeaderValue(idioma.getProperty("IdCorte"));
        jTable1.getColumnModel().getColumn(3).setHeaderValue(idioma.getProperty("Sociedad"));
        jTable1.getColumnModel().getColumn(4).setHeaderValue(idioma.getProperty("FormaDeCafe"));
        jTable1.getColumnModel().getColumn(5).setHeaderValue(idioma.getProperty("Sacos"));
        jTable1.getColumnModel().getColumn(6).setHeaderValue(idioma.getProperty("Kilos"));
        jTable1.getColumnModel().getColumn(7).setHeaderValue(idioma.getProperty("CostoAcumulado"));
        jTable1.getColumnModel().getColumn(9).setHeaderValue(idioma.getProperty("Lista"));

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

         DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        jTable1.getColumnModel().getColumn(5).setCellRenderer(tcr);
        jTable1.getColumnModel().getColumn(6).setCellRenderer(tcr);
        jTable1.getColumnModel().getColumn(7).setCellRenderer(tcr);

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

    public void llenarTabla() throws ParseException {
        limpiar(jTable1);

        mdb.cargarInformacion2(modelo, 9,
                "select fechaCreacion, julianDate, idLote, sociedad, formaCafe, sacos, kg, costoAcumulado, estatus "
                + "from cortesdeldia "
                + "where sociedad='" + sociedad + "' and idRecepcion='" + idRecepcion + "' and estatus='Activo' order by id");

        cambiarMesLetra(jTable1,0);
    }

    public void cambiarMesLetra(JTable tabla, int fila) {
        for (int i = 0; i < tabla.getRowCount(); i++) {

            String fecha = tabla.getValueAt(i, fila) + "";

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
            tabla.setValueAt(fecha, i, fila);
        }
    }

    public void sumarColumnas() {

        float contadorKg = 0;
        int contadorSacos = 0;

        contadorProductores.setText(tablaRecibos.getRowCount() + "");

        for (int i = 0; i < tablaRecibos.getRowCount(); i++) {
            contadorKg = contadorKg + Float.parseFloat(tablaRecibos.getValueAt(i, 12) + "");
            contadorSacos = contadorSacos + Integer.parseInt(tablaRecibos.getValueAt(i, 11) + "");
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
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        contadorProductores = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        contadorSacos = new javax.swing.JLabel();
        contadorKg = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaRecibos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtCorte = new javax.swing.JTextField();
        jdFecha1 = new com.toedter.calendar.JDateChooser();
        jdFecha2 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Fecha de Creacion", "Julian Date", "Id Corte", "Sociedad", "Forma de Caf[e", "Sacos", "Kg", "Costo Acumulado", "Estatus", "Lista"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setText("Situacion");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activos", "Inactivos", "Todos" }));

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Cerrar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        contadorProductores.setText("-");

        jLabel8.setText("Total Recibos");

        jLabel9.setText("Total Sacos");

        jLabel10.setText("Total Kg");

        contadorSacos.setText("-");

        contadorKg.setText("-");

        tablaRecibos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folio", "Folio Manual", "Id Lote", "Fecha Sistema", "Fecha Manual", "Nombre", "Apellido Paterno", "Apellido Materno", "Sociedad", "Parcela", "Forma Cafe", "Sacos", "Kg Recibidos", "Total Bruto", "Retencion", "Total", "Verdes", "Inmaduros", "Brocados", "Calificacion", "Entregó", "Observaciones"
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
        jScrollPane2.setViewportView(tablaRecibos);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Recibos del Corte");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Cortes del Día");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        txtCorte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCorteKeyReleased(evt);
            }
        });

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Desde");

        jLabel2.setText("Hasta");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCorte, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(226, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addComponent(jdFecha1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jdFecha2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jButton5.setText("Ver Recibo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                                .addComponent(jButton5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(contadorSacos)
                                        .addComponent(contadorKg))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(contadorProductores)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton4)
                            .addComponent(jButton5))
                        .addContainerGap())))
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
    String idRecibo = "", idLote = "";
    int row_selected;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        limpiar(tablaRecibos);
        modelo2 = (DefaultTableModel) tablaRecibos.getModel();

        row_selected = jTable1.getSelectedRow();
       // JOptionPane.showMessageDialog(null, "Row " + row_selected);
        idLote = jTable1.getValueAt(jTable1.getSelectedRow(), 2) + "";
        mdb.cargarInformacion2(modelo2, 22, "select r.id, r.folioManual,r.idLote,r.fechacreacion, r.fechaRecepcion, pf.Nombre, pf.ApellidoPaterno, pf.ApellidoMaterno,\n"
                + "pm.RazonSocial, p.nombre, r.formaCafe, r.sacos, r.kgRecibidos, r.totalBruto, r.retencion, r.total, r.verdes, r.inmaduros, r.brocados, r.calificacion, r.personaEntrego, r.observaciones\n"
                + "from recibos r\n"
                + "inner join personam pm on ( pm.ID=r.idSociedad)\n"
                + "inner join personaf pf on ( pf.ID=r.idPersona)\n"
                + "inner join parcelas p on ( p.id=r.idParcela) "
                + "where r.idLote='" + idLote + "' and r.id_situacion=1");
        cambiarMesLetra(tablaRecibos,3);
        cambiarMesLetra(tablaRecibos,4);
        sumarColumnas();
        idRecibo = "";
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void tablaRecibosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRecibosMouseClicked
        // TODO add your handling code here:
        idRecibo = tablaRecibos.getValueAt(tablaRecibos.getSelectedRow(), 0) + "";

        if (evt.getClickCount() == 2) {
            jdR = new jdRecibos(null, true, idRecibo, "2", idRecepcion, idSociedad, "", Idioma, cn);
            jdR.setVisible(true);
        }
    }//GEN-LAST:event_tablaRecibosMouseClicked

    private void txtCorteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorteKeyReleased
        // TODO add your handling code here:
        limpiar(jTable1);
        mdb.cargarInformacion2(modelo, 9,
                "select fechaCreacion, julianDate, idLote, sociedad, formaCafe, sacos, kg, costoAcumulado, estatus "
                + "from cortesdeldia "
                + "where sociedad='" + sociedad + "' and estatus='Activo' and idLote like '" + txtCorte.getText() + "%'");
        cambiarMesLetra(jTable1,0);
        sumarColumnas();
    }//GEN-LAST:event_txtCorteKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String fecha1 = new SimpleDateFormat("yyyy-MM-dd").format(jdFecha1.getDate());
        String fecha2 = new SimpleDateFormat("yyyy-MM-dd").format(jdFecha2.getDate());
        limpiar(jTable1);
        mdb.cargarInformacion2(modelo, 9,
                "select fechaCreacion, julianDate, idLote, sociedad, formaCafe, sacos, kg, costoAcumulado, estatus "
                + "from cortesdeldia "
                + "where sociedad='" + sociedad + "' and estatus='Activo' and (fechaCreacion between '" + fecha1 + "' and '" + fecha2 + "')");
        cambiarMesLetra(jTable1,0);
        sumarColumnas();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String cadenaIdCortes = "";

        for (int i = 0; i < modelo.getRowCount(); i++) {
            String valor = modelo.getValueAt(i, 9) + "";
            if (valor.equals("true")) {
                String idCorte = modelo.getValueAt(i, 2) + "";
                cadenaIdCortes += idCorte + "¬";
            }
        }

        //JOptionPane.showMessageDialog(null,"Id Corte Entrante = "+cadenaIdCortes); 
        //ABRIR BOLETA DE SALIDA DE RECEPTOR
        if (cadenaIdCortes.equals("")) {
            JOptionPane.showMessageDialog(null, "Selecciona Cortes");
        } else {
            jdBoletaSalidaReceptor jdr = new jdBoletaSalidaReceptor(null, true, cadenaIdCortes, sociedad, idRecepcion, Idioma, cn);
            jdr.jpL = this;
            jdr.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (idRecibo.equals("")) {
            JOptionPane.showMessageDialog(null, "Selecciona Recibo");
        } else {
            jdR = new jdRecibos(null, true, idRecibo, "2", idRecepcion, idSociedad, "", Idioma, cn);
            jdR.setVisible(true);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (row_selected >= 0) {
                    row_selected = row_selected - 1;
                    idLote = jTable1.getValueAt(row_selected, 2) + "";
                } else {
                    JOptionPane.showMessageDialog(null, "Limite de Tabla");
                }
                break;
            case KeyEvent.VK_DOWN:
                row_selected = row_selected + 1;
                idLote = jTable1.getValueAt(row_selected, 2) + "";
                break;
        }
        limpiar(tablaRecibos);
        mdb.cargarInformacion2(modelo2, 22, "select r.id, r.folioManual,r.idLote,r.fechacreacion, r.fechaRecepcion, pf.Nombre, pf.ApellidoPaterno, pf.ApellidoMaterno,\n"
                + "pm.RazonSocial, p.nombre, r.formaCafe, r.sacos, r.kgRecibidos, r.totalBruto, r.retencion, r.total, r.verdes, r.inmaduros, r.brocados, r.calificacion, r.personaEntrego, r.observaciones\n"
                + "from recibos r\n"
                + "inner join personam pm on ( pm.ID=r.idSociedad)\n"
                + "inner join personaf pf on ( pf.ID=r.idPersona)\n"
                + "inner join parcelas p on ( p.id=r.idParcela) "
                + "where r.idLote='" + idLote + "' and r.id_situacion=1");

        sumarColumnas();

    }//GEN-LAST:event_jTable1KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contadorKg;
    private javax.swing.JLabel contadorProductores;
    private javax.swing.JLabel contadorSacos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser jdFecha1;
    private com.toedter.calendar.JDateChooser jdFecha2;
    private javax.swing.JTable tablaRecibos;
    private javax.swing.JTextField txtCorte;
    // End of variables declaration//GEN-END:variables
}
