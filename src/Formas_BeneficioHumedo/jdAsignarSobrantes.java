/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_BeneficioHumedo;

import MetodosGenerales.MiRender;
import Metodos_Configuraciones.metodosBeneficioHumedo;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cronos
 */
public class jdAsignarSobrantes extends javax.swing.JDialog {

    /**
     * Creates new form jdAsignarSobrantes
     */
    metodosBeneficioHumedo mbh;
    DefaultTableModel modelo, modelo2;
    jdAsignarProceso jdA;
    String idLote, idBeneficio, idRuta, ruta, proceso, idSociedad, tipo, formaSalida,cert;
    Connection cn;
    float totalKilos = 0;

    public jdAsignarSobrantes(java.awt.Frame parent, boolean modal, DefaultTableModel modelo,
            String idBeneficio, String idLote, String Idioma, String idRuta, String ruta,
            String proceso, String tipo, String cert, String formaSalida, Connection cn) {
        super(parent, modal);
        initComponents();

        setTitle("Fragmentación");
        setLocationRelativeTo(null);

        this.cn = cn;
        this.modelo = modelo;
        this.ruta = ruta;
        this.proceso = proceso;
        this.tipo = tipo;
        this.idLote = idLote;
        this.idRuta = idRuta;
        this.idBeneficio = idBeneficio;
        this.formaSalida = formaSalida;
        this.cert=cert;

        mbh = new metodosBeneficioHumedo(cn);

        tablaSobrantes.setDefaultRenderer(Object.class, new MiRender());
        modelo2 = (DefaultTableModel) tablaSobrantes.getModel();
        validarMaquinaria();
        infoLote();
        totalKilos = Float.parseFloat(lblKilos.getText());
        idSociedad = mbh.devuelveUnDato("select idSociedad from beneficioshumedos where nombre='" + idBeneficio + "'");
    }

    public void validarMaquinaria() {
        //JOptionPane.showMessageDialog(null,"Entre a Validar maquinaria");
        for (int i = 0; i < modelo.getRowCount(); i++) {
            String maquinaria = modelo.getValueAt(i, 3) + "";
             //JOptionPane.showMessageDialog(null,i);
            mbh.cargarInformacion(modelo2, 4, "select a.actividad, m.nombre, s.Nombre, '0.00' \n"
                    + "from maquinariabh m\n"
                    + "left join actividadesbh a on (m.idActividad=a.ID)\n"
                    + "left join sobrante s on (m.sobrante=s.ID)\n"
                    + "where m.generarLote=1 and m.nombre='" + maquinaria + "'");
        }
    }

    public void sumarSobrantes() {
        try {
            float totalSobrante = 0;
            for (int i = 0; i < tablaSobrantes.getRowCount(); i++) {
                String sobranteIndividual = tablaSobrantes.getValueAt(i, 3) + "";
                //JOptionPane.showMessageDialog(null,"Sobrante "+sobranteIndividual);
                totalSobrante = totalSobrante + Float.parseFloat(sobranteIndividual);
            }
            totalSobrantes.setText(totalSobrante + "");
            //Resta: Total - Sobrantes
            lblKilos.setText(totalKilos - totalSobrante + "");
        } catch (NumberFormatException e) {

        }
    }

    public void infoLote() {

        switch (tipo) {

            case "Lote":
                String datos[] = mbh.devolverLineaDatos("select c.idLote, c.formaCafe, b.estadoCafe, b.costalesRecibidos, b.kgRecibidos \n"
                        + "from boletaentradabh b\n"
                        + "inner join boletasalidareceptor bs on (bs.idLote=b.idLote)\n"
                        + "inner join cortesdeldia c on (c.idLote=bs.idLote) where bs.idLote='" + idLote + "' ", 5).split("¬");
                lblIdLote.setText(datos[0]);
                jLabel5.setText(datos[0]);
                lblFormaCafe.setText(datos[1]);
                lblEstadoCafe.setText(datos[2]);
                lblSacos.setText(datos[3]);
                lblKilos.setText(datos[4]);
                lblRuta.setText(ruta);
                lblProceso.setText(proceso);
                labelCertificacion.setText(cert);
                break;
            case "SubLote":
                String datos2[] = mbh.devolverLineaDatos("select idSubLote, formaCafe, estadoCafe, idLoteOrigen, kgTotales \n"
                        + "from sublotesconfirmados b\n"
                        + "where idSubLote='" + idLote + "' ", 5).split("¬");

                lblIdLote.setText(datos2[0]);
                lblFormaCafe.setText(datos2[1]);
                lblEstadoCafe.setText(datos2[2]);
                // lblSacos.setText(datos2[3]);
                lblKilos.setText(datos2[4]);
                lblRuta.setText(ruta);
                lblProceso.setText(proceso);
                jLabel5.setText(datos2[3]);
                labelCertificacion.setText(cert);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Revisar Tipo");
                break;
        }

    }

    /*
        Mezcla.- Lot-CP-BH-1-Mix-151

        Fragmentación.- Lot-CP-BH-1-Frg-151

        Sobrantes.-         Lot-CP-BH-1-Lft1-19
                            Lot-AD-BH-1-Lft2-20
                            Lot-CP-BH-1-Lft3-21
                            Lot-CP-BH-1-Lft4-22

        Descripción de lote en Beneficio Húmedo.
        Lot.- Lote
        CP.- Clave Sociedad
        BH.- Beneficio Húmedo
        1.- Numero de Beneficio Húmedo
        Frg.- (Frg=Fragmentado, Mix=Mezclado, Lft+Numéro(1, 2, 3, 4)=Sobrantes)
        151.- Es el numero consecutivo de lote por B.H. 
     */
    public void crearId() {
        //String ids = "";
        DefaultTableModel model = (DefaultTableModel) tablaLotes.getModel();
        limpiar(tablaLotes);
        for (int i = 0; i < tablaSobrantes.getRowCount(); i++) {

            String tipoSobrante = tablaSobrantes.getValueAt(i, 2) + "";
            String cantidadKilos = tablaSobrantes.getValueAt(i, 3) + "";
            //String numRegistros = mbh.devuelveUnDato("SELECT count(id) FROM sublotesconfirmados");
            int nuevoConsecutivo;
            String idNuevoSubLote = "";
            String ultimoIdSubLote[] = mbh.devuelveUnDato("SELECT\n"
                    + "    idSublote\n"
                    + "FROM\n"
                    + "    sublotesconfirmados\n"
                    + "ORDER BY\n"
                    + "    id\n"
                    + "DESC\n"
                    + "LIMIT 1").split("-");

            //JOptionPane.showMessageDialog(null,ultimoIdSubLote);
            
            if (mbh.devuelveUnDato("SELECT\n"
                    + "    idSublote\n"
                    + "FROM\n"
                    + "    sublotesconfirmados\n"
                    + "ORDER BY\n"
                    + "    id\n"
                    + "DESC\n"
                    + "LIMIT 1").equals("") || mbh.devuelveUnDato("SELECT\n"
                    + "    idSublote\n"
                    + "FROM\n"
                    + "    sublotesconfirmados\n"
                    + "ORDER BY\n"
                    + "    id\n"
                    + "DESC\n"
                    + "LIMIT 1").equals(" ")) {
                 nuevoConsecutivo = 1;
            } else {
                //idNuevoSubLote = ultimoIdSubLote[3];
                idNuevoSubLote= mbh.devuelveUnDato("SELECT COUNT(id) FROM sublotesconfirmados");
                nuevoConsecutivo = (Integer.parseInt(idNuevoSubLote) + 1) + i;
            }
            //int idConsecutivo = (Integer.parseInt(numRegistros) + 1) + i;
            String idSubLote = "";

            switch (tipoSobrante) {
                case "Flote Kg":
                    idSubLote = "SLot-" + idBeneficio + "-Frg1-" + nuevoConsecutivo;
                    break;
                case "Repaso De Verdes Kg":
                    idSubLote = "SLot-" + idBeneficio + "-Frg2-" + nuevoConsecutivo;
                    break;
                case "Espumilla Kg":
                    idSubLote = "SLot-" + idBeneficio + "-Frg3-" + nuevoConsecutivo;
                    break;
                case "Sobrante Lavadora Kg":
                    idSubLote = "SLot-" + idBeneficio + "-Frg4-" + nuevoConsecutivo;
                    break;
            }
            //limpiar(tablaLotes);
            if (!cantidadKilos.equals("0.00")) {
                model.addRow(new Object[]{tablaSobrantes.getValueAt(i, 2), idSubLote, tablaSobrantes.getValueAt(i, 3)});
            }
        }

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
        tablaSobrantes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalSobrantes = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        lblIdLote = new javax.swing.JLabel();
        lblFormaCafe = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblEstadoCafe = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblSacos = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblKilos = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaLotes = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblRuta = new javax.swing.JLabel();
        lblProceso = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        labelCertificacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablaSobrantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Actividad", "Maquinaria", "Sobrante", "Kilos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaSobrantes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaSobrantesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablaSobrantes);
        if (tablaSobrantes.getColumnModel().getColumnCount() > 0) {
            tablaSobrantes.getColumnModel().getColumn(0).setResizable(false);
            tablaSobrantes.getColumnModel().getColumn(1).setResizable(false);
            tablaSobrantes.getColumnModel().getColumn(2).setResizable(false);
            tablaSobrantes.getColumnModel().getColumn(2).setHeaderValue("Sobrante");
            tablaSobrantes.getColumnModel().getColumn(3).setResizable(false);
            tablaSobrantes.getColumnModel().getColumn(3).setHeaderValue("Kilos");
        }

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Capturar Fragmentos");

        jLabel2.setText("Total Sobrantes");

        totalSobrantes.setText("0.00");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Listado de SubLotes");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Id Lote");

        lblIdLote.setText(".");

        lblFormaCafe.setText("-");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Forma Café");

        lblEstadoCafe.setText("-");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Estado Café");

        lblSacos.setText("-");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Sacos");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Kilos");

        lblKilos.setText(".");

        tablaLotes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sobrante", "Id Lote", "Kilos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaLotes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaLotesKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tablaLotes);
        if (tablaLotes.getColumnModel().getColumnCount() > 0) {
            tablaLotes.getColumnModel().getColumn(0).setResizable(false);
            tablaLotes.getColumnModel().getColumn(1).setResizable(false);
            tablaLotes.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Ruta");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Proceso");

        lblRuta.setText("-");

        lblProceso.setText("-");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("SubLote Origen");

        jLabel5.setText("-");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Certificacion");

        labelCertificacion.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(lblIdLote))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFormaCafe)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(lblEstadoCafe))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(lblSacos))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(lblKilos))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(lblRuta))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(lblProceso))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelCertificacion)
                                    .addComponent(jLabel17)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(totalSobrantes)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1))
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane1)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE))))
                        .addGap(0, 59, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIdLote)
                            .addComponent(lblFormaCafe)
                            .addComponent(lblEstadoCafe)
                            .addComponent(lblSacos)
                            .addComponent(lblKilos)
                            .addComponent(lblRuta)
                            .addComponent(lblProceso)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCertificacion)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(totalSobrantes)
                    .addComponent(jButton1))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaSobrantesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaSobrantesKeyReleased
        // TODO add your handling code here:
        //String totalIndividual = tablaSobrantes.getValueAt(tablaSobrantes.getValueAt(0), WIDTH)
        sumarSobrantes();
        crearId();
    }//GEN-LAST:event_tablaSobrantesKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Date date = new Date();
        String fechaActual = new SimpleDateFormat("yyyy-MM-dd").format(date);
        //Insertando idLote ruta original
        String loteOrigen =  jLabel5.getText();
        
        if (mbh.insertarBoleta("insert into lotesprocesosecado "
                + "values(null, '" + loteOrigen + "', '" + idBeneficio + "', '" + lblIdLote.getText() + "', "
                + "" + idRuta + ", '" + fechaActual + "', '" + lblFormaCafe.getText() + "', '" + lblEstadoCafe.getText() + "', "
                + "'" + lblKilos.getText() + "', '" + formaSalida + "','0',' ', 1  )")) {
            
           mbh.insertarBoleta("insert into historialsublotes values('" + jLabel5.getText() + "', '" + lblIdLote.getText() + "', "
                    + "'" + lblFormaCafe.getText() + "', '" + lblEstadoCafe.getText() + "', " + lblKilos.getText() + ",'" + fechaActual + "','Fragmentacion','1'  ) ");

            
        }

        //Insertando idSubLotes generados sobrantes
        String forma = "", estado = "";
        for (int i = 0; i < tablaLotes.getRowCount(); i++) {

            switch (tablaLotes.getValueAt(i, 0) + "") {
                case "Flote Kg":
                    forma = "Cereza";
                    estado = "Escurrido";
                    break;

                case "Repaso De Verdes Kg":
                    forma = "Cereza";
                    estado = "Escurrido";
                    break;

            }

            if (mbh.insertarBoleta("insert into sublotesconfirmados values("
                    + "null, '" + jLabel5.getText() + "', '" + tablaLotes.getValueAt(i, 1) + "', '" + idBeneficio + "',"
                    + "'" + fechaActual + "', '" + forma + "', '"+cert+"', '" + estado + "' ,'" + tablaLotes.getValueAt(i, 2) + "','1' )")) {
            } else {
                JOptionPane.showMessageDialog(null, "Error Almacenando SubLotes Automaticos");
            }
        }

        if (tipo.equals("Lote")) {
            mbh.actualizarBoleta("update sublotesconfirmados set estatus='0' where idSublote='"+lblIdLote.getText()+"'");
        } else if (tipo.equals("SubLote")) {
            mbh.actualizarBoleta("update sublotesconfirmados set estatus='0' "
                    + "where idSubLote='" + lblIdLote.getText() + "'");
        }

        this.dispose();
        jdA.acutalizarTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaLotesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaLotesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaLotesKeyReleased

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
            java.util.logging.Logger.getLogger(jdAsignarSobrantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdAsignarSobrantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdAsignarSobrantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdAsignarSobrantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
 /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdAsignarSobrantes dialog = new jdAsignarSobrantes(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelCertificacion;
    private javax.swing.JLabel lblEstadoCafe;
    private javax.swing.JLabel lblFormaCafe;
    private javax.swing.JLabel lblIdLote;
    private javax.swing.JLabel lblKilos;
    private javax.swing.JLabel lblProceso;
    private javax.swing.JLabel lblRuta;
    private javax.swing.JLabel lblSacos;
    private javax.swing.JTable tablaLotes;
    private javax.swing.JTable tablaSobrantes;
    private javax.swing.JLabel totalSobrantes;
    // End of variables declaration//GEN-END:variables
}
