/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_laboratorio;

import Idioma.Propiedades;
import Metodos_Configuraciones.metodosLaboratorio;
import java.awt.Color;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
//import Formas_laboratorio.excel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


/**
 *
 * @author Contador
 */
public class jpBitacora extends javax.swing.JPanel {

    Connection cn;
    metodosLaboratorio mdb;
    DefaultTableModel modelo, modelo2;
    jdEvaluacionA jdDP;
    Propiedades idioma;
    String Idioma;
    JdCatacion jdc;
    jdObservaciones jdo;
  
    ArrayList<String> array = new ArrayList<String>();

    /**
     * Creates new form jpBitacora
     */
    public jpBitacora(Connection c, String Idioma) {
        initComponents();
        cn = c;
          this.Idioma=Idioma;
        mdb = new metodosLaboratorio(cn,Idioma);
        modelo = (DefaultTableModel) tablabitacora.getModel();
         modelo2 = (DefaultTableModel) tablaconsulta.getModel();
        llenarTabla();
        tablabitacora.setRowSorter(new TableRowSorter(modelo));
         tablaconsulta.setRowSorter(new TableRowSorter(modelo2));
        
         ALL.setSelected(true);
           idioma = new Propiedades(Idioma);
          
        jButton2.setText(idioma.getProperty("Imprimir"));
        
       
        tablabitacora.getColumnModel().getColumn(1).setHeaderValue(idioma.getProperty("FechaLLegada"));
        tablabitacora.getColumnModel().getColumn(2).setHeaderValue(idioma.getProperty("Proceso"));
        tablabitacora.getColumnModel().getColumn(3).setHeaderValue(idioma.getProperty("Forma"));
        tablabitacora.getColumnModel().getColumn(4).setHeaderValue(idioma.getProperty("Beneficio"));
        tablabitacora.getColumnModel().getColumn(5).setHeaderValue(idioma.getProperty("Dueño"));
        tablabitacora.getColumnModel().getColumn(6).setHeaderValue(idioma.getProperty("Sublote"));
        tablabitacora.getColumnModel().getColumn(7).setHeaderValue(idioma.getProperty("Certificion"));
        tablabitacora.getColumnModel().getColumn(8).setHeaderValue(idioma.getProperty("Peso"));
        tablabitacora.getColumnModel().getColumn(9).setHeaderValue(idioma.getProperty("Sacos"));
         tablabitacora.getColumnModel().getColumn(10).setHeaderValue(idioma.getProperty("Comunidad"));
         tablabitacora.getColumnModel().getColumn(11).setHeaderValue(idioma.getProperty("Estatus"));
        tablabitacora.getColumnModel().getColumn(12).setHeaderValue(idioma.getProperty("EvalAspecto"));
        tablabitacora.getColumnModel().getColumn(13).setHeaderValue(idioma.getProperty("EvalTaza"));
        tablabitacora.getColumnModel().getColumn(14).setHeaderValue(idioma.getProperty("Mezcla"));
   
     
        Sinevaluar.setText(idioma.getProperty("SnEvaluar"));
        Aspecto.setText(idioma.getProperty("EvAspecto"));
        Catadas.setText(idioma.getProperty("CatLis"));
        ALL.setText(idioma.getProperty("Todas"));
        
        jLabel1.setText(idioma.getProperty("FiltrarPC"));
        jLabel2.setText(idioma.getProperty("BusquedaPor"));
      
        jLabel4.setText(idioma.getProperty("KilosConfirmados"));
        jLabel5.setText(idioma.getProperty("FiltrarPEV"));
        
        jMenuItem1.setText(idioma.getProperty("ReporteIndividual"));
        evaspecto.setText(idioma.getProperty("EvaluacionPorAspecto"));
        evtaza.setText(idioma.getProperty("EvaluacionDeTaza"));
        jMenuItem4.setText(idioma.getProperty("Desactivar"));
        jMenuItem5.setText(idioma.getProperty("Observaciones"));
        sabores.setText(idioma.getProperty("Sabores"));
        mezcla.setText(idioma.getProperty("AsignarMezcla"));
        kgyn.setText(idioma.getProperty("ConfirmarKilos"));
     
        jComboBox1.addItem(idioma.getProperty("Activas"));
        jComboBox1.addItem(idioma.getProperty("Desactivada"));
        jComboBox1.addItem(idioma.getProperty("Todas"));
        
        combobusqueda.addItem(idioma.getProperty("Seleccion"));
        combobusqueda.addItem(idioma.getProperty("Csm"));
        combobusqueda.addItem(idioma.getProperty("FechaLLegada"));
        combobusqueda.addItem(idioma.getProperty("Proceso"));
        combobusqueda.addItem(idioma.getProperty("Forma"));
        combobusqueda.addItem(idioma.getProperty("Beneficio"));
        combobusqueda.addItem(idioma.getProperty("Dueño"));
      //  tablabitacora.setAutoResizeMode(AUTO_RESIZE_ALL_COLUMNS);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        evaspecto = new javax.swing.JMenuItem();
        evtaza = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        sabores = new javax.swing.JMenuItem();
        mezcla = new javax.swing.JMenuItem();
        kgyn = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        combotipo = new javax.swing.JComboBox<>();
        combobusqueda = new javax.swing.JComboBox<>();
        txtBusqueda = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        Sinevaluar = new javax.swing.JRadioButton();
        Catadas = new javax.swing.JRadioButton();
        Aspecto = new javax.swing.JRadioButton();
        ALL = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablabitacora = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaconsulta = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        yn = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        jMenuItem1.setText("Reporte Individual");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        evaspecto.setText("Evaluacion Por Aspecto");
        evaspecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evaspectoActionPerformed(evt);
            }
        });
        jPopupMenu1.add(evaspecto);

        evtaza.setText("Evaluacion De Taza");
        evtaza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evtazaActionPerformed(evt);
            }
        });
        jPopupMenu1.add(evtaza);

        jMenuItem4.setText("Desactivar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem4);

        jMenuItem5.setText("Observaciones");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem5);

        sabores.setText("Sabores");
        sabores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saboresActionPerformed(evt);
            }
        });
        jPopupMenu1.add(sabores);

        mezcla.setText("Asignar mezcla");
        mezcla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mezclaActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mezcla);

        kgyn.setText("Confirmar Kilos");
        kgyn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kgynActionPerformed(evt);
            }
        });
        jPopupMenu1.add(kgyn);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        combotipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Natural", "Lavado", "Semi Lavado" }));
        combotipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combotipoItemStateChanged(evt);
            }
        });

        combobusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "# CSM", "Fecha de llegada", "Proceso", "Forma", "Beneficio", "Dueño" }));

        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyTyped(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        buttonGroup1.add(Sinevaluar);
        Sinevaluar.setText("Sin evaluar");
        Sinevaluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SinevaluarActionPerformed(evt);
            }
        });

        buttonGroup1.add(Catadas);
        Catadas.setText("Catadas y listas para Mezclas");
        Catadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CatadasActionPerformed(evt);
            }
        });

        buttonGroup1.add(Aspecto);
        Aspecto.setText("Evaluada Por Aspecto");
        Aspecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AspectoActionPerformed(evt);
            }
        });

        buttonGroup1.add(ALL);
        ALL.setText("Todas");
        ALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ALLActionPerformed(evt);
            }
        });

        jLabel5.setText("Filtrado Por Evaluaciones");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ALL)
                    .addComponent(Sinevaluar)
                    .addComponent(Aspecto)
                    .addComponent(Catadas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Sinevaluar, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Aspecto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Catadas, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ALL, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Filtrar por proceso de cafe:");

        jLabel2.setText("Busqueda por:");

        tablabitacora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "# CSM", "Fecha de Llegada", "Proceso", "Forma", "Beneficio", "Dueño", "#Sub Lote", "Certificacion", "Peso KG", "# Sacos", "Comunidad", "Estatus", "Eval Aspecto", "Eval Taza", "Mezcla"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablabitacora.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablabitacora.setComponentPopupMenu(jPopupMenu1);
        tablabitacora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablabitacoraMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablabitacora);

        tablaconsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaconsulta.setEnabled(false);
        tablaconsulta.setFocusable(false);
        tablaconsulta.setOpaque(false);
        jScrollPane1.setViewportView(tablaconsulta);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Kilos Confirmados:");

        yn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yn)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(358, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtBusqueda)
                        .addComponent(combobusqueda, 0, 163, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combotipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combobusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(yn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton2.setText("Imprimir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 924, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(123, 123, 123))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
public void llenarTabla() {
        limpiar(tablabitacora);
      limpiar(tablaconsulta);
        mdb.cargarInformacion2(modelo, 15, "SELECT b.id_muestra,b.fecha_llegada,b.tipocafe,b.forma,b.beneficio,b.dueño,b.lote,b.certificado,b.peso,b.sacos,\n" +
"b.comunidad,b.estatus,d.puntuacion,c.Puntuacion,b.mezcla from bitacoralab b left join datosev d on b.id_bitacora=d.id_bitacora left join \n" +
" catacion c on b.id_bitacora=c.id_bitacora where estatus != 'Desactivada' order by b.id_muestra");
         mdb.cargarInformacion2(modelo2,21, " select b.estatus,b.id_muestra,b.beneficio,b.lote,b.tipocafe,b.forma,b.certificado,b.peso,b.Kgconfirm,\n" +
" b.sacos,b.comunidad,b.dueño,b.fechalote,c.Puntuacion,d.puntuacion,d.humedad_o,c.quakers,b.sabores,\n" +
" b.observaciones,d.Densidadoro,c.densidadtostado from  bitacoralab b left join   datosev d on b.id_bitacora=d.id_bitacora left join \n" +
" catacion c on b.id_bitacora=c.id_bitacora where estatus != 'Desactivada' order by b.id_muestra");
   String[] datos2 = mdb.cargarCombos2("select CONCAT(Descripcion,' -', Clave,'- ') FROM procesocafe where clave != 'PR';").split("¬");//1
        combotipo.setModel(new DefaultComboBoxModel((Object[]) datos2));
}

    public void busqueda() {
        String busquedatxt = "",taza="",aspecto="";
        String busqueda = "";
        String busquedacombo = "";
        String Tipocafe = "";
        String where = "";
        String status = "and b.estatus != 'Desactivada'";
        String busq = "";
        
        Tipocafe = combotipo.getSelectedItem() + "";
        if (!Tipocafe.equals(idioma.getProperty("Todos"))) {
           String[] datos1;
        datos1 = Tipocafe.split("-");
       
        Tipocafe=datos1[1];
            
        } 
        if (busquedacombo.equals(idioma.getProperty("Seleccion"))) {
            busquedacombo = "";
        }
        if (txtBusqueda.getText().length() > 0) {
            busquedacombo = combobusqueda.getSelectedItem() + "";
            if (busquedacombo.equals(idioma.getProperty("Csm"))) {
                busq = "and b.id_muestra like '" + txtBusqueda.getText() + "%'";
            }
            if (busquedacombo.equals(idioma.getProperty("FechaLLegada"))) {
                busq = "and b.fecha_llegada like '" + txtBusqueda.getText() + "%'";
            }
            if (busquedacombo.equals(idioma.getProperty("Proceso"))) {
                busq = "and b.tipocafe like '" + txtBusqueda.getText() + "%'";
            }
            if (busquedacombo.equals(idioma.getProperty("Forma"))) {
                busq = "and b.forma like '" + txtBusqueda.getText() + "%'";
            }
            if (busquedacombo.equals(idioma.getProperty("Beneficio"))) {
                busq = "and b.beneficio like '" + txtBusqueda.getText() + "%'";
            }
            if (busquedacombo.equals(idioma.getProperty("Dueño"))) {
                busq = "and b.dueño like '" + txtBusqueda.getText() + "%'";
            }
        }
        if (jComboBox1.equals(idioma.getProperty("Activas"))) {
           status = "and b.estatus != 'Desactivada'";
        }
           if (jComboBox1.equals(idioma.getProperty("Todas"))) {
            status = "";
        }
            if (jComboBox1.equals(idioma.getProperty("Desactivada"))) {
            status = " and b.estatus like 'Desactivada'";
        }
            //filtros de evaluaciones
        if (Sinevaluar.isSelected()) {
            taza="and b.taza = '0'" ;
            aspecto="and b.aspecto = '0'";
        }
     
        if (Catadas.isSelected()) {
                       taza="and b.taza = '1'" ;
            aspecto="and b.aspecto = '1'";
        }
       
        if (Aspecto.isSelected()) {
                      taza="and b.taza = '0'" ;
            aspecto="and b.aspecto = '1'";
        }
        if (ALL.isSelected()) {
                       taza="" ;
            aspecto="";
        }
        String sql,sql2;
        System.out.println("SITUACION: " + Tipocafe);
        if (Tipocafe.equals(idioma.getProperty("Todos"))) {
            sql = "SELECT b.id_muestra,b.fecha_llegada,b.tipocafe,b.forma,b.beneficio,b.dueño,b.lote,b.certificado,b.peso,b.sacos,\n" +
"b.comunidad,b.estatus,d.puntuacion,c.Puntuacion,b.mezcla from bitacoralab b left join datosev d on b.id_bitacora=d.id_bitacora left join \n" +
" catacion c on b.id_bitacora=c.id_bitacora where tipocafe !='z'" + busq + status+aspecto+taza+" order by b.id_muestra";
        sql2=" select b.estatus,b.id_muestra,b.beneficio,b.lote,b.tipocafe,b.forma,b.certificado,b.peso,b.Kgconfirm,\n" +
" b.sacos,b.comunidad,b.dueño,b.fechalote,c.Puntuacion,d.puntuacion,d.humedad_o,c.quakers,b.sabores,\n" +
" b.observaciones,d.Densidadoro,c.densidadtostado from  bitacoralab b left join   datosev d on b.id_bitacora=d.id_bitacora left join \n" +
" catacion c on b.id_bitacora=c.id_bitacora where tipocafe !='z'" + busq + status+aspecto+taza+" order by b.id_muestra";
            System.out.println(sql);
            System.out.println(sql2);
        } else {
            sql = "SELECT b.id_muestra,b.fecha_llegada,b.tipocafe,b.forma,b.beneficio,b.dueño,b.lote,b.certificado,b.peso,b.sacos,\n" +
"b.comunidad,b.estatus,d.puntuacion,c.Puntuacion,b.mezcla from bitacoralab b left join datosev d on b.id_bitacora=d.id_bitacora left join \n" +
" catacion c on b.id_bitacora=c.id_bitacora where tipocafe='" + Tipocafe + "'" + busq + status+aspecto+taza+" order by b.id_muestra";
              sql2=" select b.estatus,b.id_muestra,b.beneficio,b.lote,b.tipocafe,b.forma,b.certificado,b.peso,b.Kgconfirm,\n" +
" b.sacos,b.comunidad,b.dueño,b.fechalote,c.Puntuacion,d.puntuacion,d.humedad_o,c.quakers,b.sabores,\n" +
" b.observaciones,d.Densidadoro,c.densidadtostado from  bitacoralab b left join   datosev d on b.id_bitacora=d.id_bitacora left join \n" +
" catacion c on b.id_bitacora=c.id_bitacora where tipocafe='" + Tipocafe + "'" + busq + status+aspecto+taza+" order by b.id_muestra";
      System.out.println(sql);
            System.out.println(sql2);
        }
         limpiar(tablabitacora);
         limpiar(tablaconsulta);
        mdb.cargarInformacion2(modelo, 15, sql);
        mdb.cargarInformacion2(modelo2,21, sql2);
    }
    String csm = "", comunindad = "", tipo = "", id, forma = "", estatus = "", taza = "", aspecto = "",mezasig="",calcer="",kgconfirm="";
    private void tablabitacoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablabitacoraMouseClicked
        csm = tablabitacora.getValueAt(tablabitacora.getSelectedRow(), 0) + "";
        comunindad = tablabitacora.getValueAt(tablabitacora.getSelectedRow(), 10) + "";
        tipo = tablabitacora.getValueAt(tablabitacora.getSelectedRow(), 2) + "";
        forma = tablabitacora.getValueAt(tablabitacora.getSelectedRow(), 3) + "";
        estatus = tablabitacora.getValueAt(tablabitacora.getSelectedRow(), 11) + "";
        aspecto = mdb.devuelveUnDato("select aspecto from bitacoralab "
                + "where (id_muestra='" + csm + "' and comunidad='" + comunindad + "')");
        taza = mdb.devuelveUnDato("select taza from bitacoralab "
                + "where (id_muestra='" + csm + "' and comunidad='" + comunindad + "')");
        mezasig = mdb.devuelveUnDato("select mezasig from bitacoralab "
                + "where (id_muestra='" + csm + "' and comunidad='" + comunindad + "')");
           calcer = mdb.devuelveUnDato("select calidadcereza from bitacoralab "
                + "where (id_muestra='" + csm + "' and comunidad='" + comunindad + "')");
            kgconfirm = mdb.devuelveUnDato("select Kgconfirm from bitacoralab "
                + "where (id_muestra='" + csm + "' and comunidad='" + comunindad + "')");
            if (kgconfirm.equals("1")) {
            yn.setText(idioma.getProperty("Si"));
            yn.setForeground(Color.green);
       kgyn.setEnabled(false);
            }else{yn.setText(idioma.getProperty("No"));
            yn.setForeground(Color.red);
              kgyn.setEnabled(true);}
        if (estatus.equals(idioma.getProperty("Desactivada"))) {
            jMenuItem4.setText(idioma.getProperty("Activar"));
            System.out.println(estatus);
        } else {
            jMenuItem4.setText(idioma.getProperty("Desactivar"));
        }
        if (taza.equals("1")||aspecto.equals("0")) {
            evtaza.setEnabled(false);
            System.out.println(estatus);
        } else {
            evtaza.setEnabled(true);
        }
        if (aspecto.equals("1")) {
            evaspecto.setEnabled(false);
            System.out.println(estatus);
        } else {
            evaspecto.setEnabled(true);
        }
        if (aspecto.equals("1")/** && taza.equals("1")*/) {
            jMenuItem1.setEnabled(true);
            System.out.println(estatus);
        } else {
            jMenuItem1.setEnabled(false);
        }
        if (aspecto.equals("1") && taza.equals("1")&&mezasig.equals("0")) {
            mezcla.setEnabled(true);
            System.out.println(estatus);
        } else {
            mezcla.setEnabled(false);
        }
        if ( taza.equals("1")) {
           sabores.setEnabled(true);
            System.out.println(estatus);
        } else {
            sabores.setEnabled(false);
        }
      
    }//GEN-LAST:event_tablabitacoraMouseClicked
    private void SinevaluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SinevaluarActionPerformed
        busqueda();
    }//GEN-LAST:event_SinevaluarActionPerformed
    private void limpiar(JTable tabla) {
        while (tabla.getRowCount() > 0) {
            ((DefaultTableModel) tabla.getModel()).removeRow(0);
        }
    }
    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed

    }//GEN-LAST:event_txtBusquedaActionPerformed
    private void CatadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CatadasActionPerformed
        busqueda();
    }//GEN-LAST:event_CatadasActionPerformed
    private void AspectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AspectoActionPerformed
        busqueda();
    }//GEN-LAST:event_AspectoActionPerformed
    private void ALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ALLActionPerformed
        busqueda();
    }//GEN-LAST:event_ALLActionPerformed
    private void combotipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combotipoItemStateChanged
        busqueda();
    }//GEN-LAST:event_combotipoItemStateChanged
    private void txtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyTyped

    }//GEN-LAST:event_txtBusquedaKeyTyped
    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        busqueda();
    }//GEN-LAST:event_txtBusquedaKeyReleased
    private void evaspectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evaspectoActionPerformed
        if (!csm.equals("")) {
            id = mdb.comprobarExistencia("select id_bitacora from bitacoralab "
                    + "where (id_muestra='" + csm + "' and comunidad='" + comunindad + "')");
            System.out.println(id+ csm+ comunindad+ tipo+ forma);
            jdDP = new jdEvaluacionA(null, true, "2", id, csm, comunindad, tipo, forma, cn,calcer,Idioma);
            jdDP.jpDP = this;
            jdDP.setVisible(true);
        }
    }//GEN-LAST:event_evaspectoActionPerformed
    private void evtazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evtazaActionPerformed
        if (!csm.equals("")) {
            id = mdb.comprobarExistencia("select id_bitacora from bitacoralab "
                    + "where (id_muestra='" + csm + "' and comunidad='" + comunindad + "')");

            jdc = new JdCatacion(null, true, "2", id, csm, comunindad, tipo, forma, cn,Idioma);
            jdc.jpCT = this;
            jdc.setVisible(true);
        }
    }//GEN-LAST:event_evtazaActionPerformed
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if (!csm.equals("")) {
            if (estatus.equals(idioma.getProperty("Desactivada"))) {
                String sql = "UPDATE bitacoralab SET estatus='Activada' where id_muestra='" + csm + "'and comunidad='" + comunindad + "'";
                mdb.actualizarBasicos(sql);
                busqueda();
            } else {
                String sql = "UPDATE bitacoralab SET estatus='Desactivada' where id_muestra='" + csm + "'and comunidad='" + comunindad + "'";
                mdb.actualizarBasicos(sql);
                busqueda();
            }
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed
    String observaciones;
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if (!csm.equals("")) {
            id = mdb.devuelveUnDato("select id_bitacora from bitacoralab "
                    + "where (id_muestra='" + csm + "' and comunidad='" + comunindad + "')");
            observaciones = mdb.devuelveUnDato("select observaciones from bitacoralab where id_bitacora=" + id);
            jdo = new jdObservaciones(null, true, observaciones, id, cn,1,Idioma);
            jdo.jpo = this;
            jdo.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        id = mdb.devuelveUnDato("select id_bitacora from bitacoralab "
                + "where (id_muestra='" + csm + "' and comunidad='" + comunindad + "')");
        try {
            excel.datos(cn, csm, id,taza,Idioma);      // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(jpBitacora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void saboresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saboresActionPerformed
       if (!csm.equals("")) {
            id = mdb.devuelveUnDato("select id_bitacora from bitacoralab "
                    + "where (id_muestra='" + csm + "' and comunidad='" + comunindad + "')");
            observaciones = mdb.devuelveUnDato("select sabores from bitacoralab where id_bitacora=" + id);
            jdo = new jdObservaciones(null, true, observaciones, id, cn,2,Idioma);
            jdo.jpo = this;
            jdo.setVisible(true);
        }    // TODO add your handling code here:
    }//GEN-LAST:event_saboresActionPerformed

    private void mezclaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mezclaActionPerformed
   if (!csm.equals("")) {
            id = mdb.devuelveUnDato("select id_bitacora from bitacoralab "
                    + "where (id_muestra='" + csm + "' and comunidad='" + comunindad + "')");
            observaciones = mdb.devuelveUnDato("select mezcla from bitacoralab where id_bitacora=" + id);
            jdo = new jdObservaciones(null, true, observaciones, id, cn,3,Idioma);
            jdo.jpo = this;
            jdo.setVisible(true);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_mezclaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    excel.imprimir(tablaconsulta,cn,Idioma);    // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void kgynActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kgynActionPerformed
 if (!csm.equals("")) {
            if (kgconfirm.equals("0")) {
                String sql = "UPDATE bitacoralab SET Kgconfirm='1' where id_muestra='" + csm + "'and comunidad='" + comunindad + "'";
                mdb.actualizarBasicos(sql);               
                busqueda();
                 yn.setText(idioma.getProperty("Si"));
            yn.setForeground(Color.green);
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_kgynActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
busqueda();        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ALL;
    private javax.swing.JRadioButton Aspecto;
    private javax.swing.JRadioButton Catadas;
    private javax.swing.JRadioButton Sinevaluar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> combobusqueda;
    private javax.swing.JComboBox<String> combotipo;
    private javax.swing.JMenuItem evaspecto;
    private javax.swing.JMenuItem evtaza;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem kgyn;
    private javax.swing.JMenuItem mezcla;
    private javax.swing.JMenuItem sabores;
    private javax.swing.JTable tablabitacora;
    private javax.swing.JTable tablaconsulta;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JLabel yn;
    // End of variables declaration//GEN-END:variables
  excel excel = new excel();
}
