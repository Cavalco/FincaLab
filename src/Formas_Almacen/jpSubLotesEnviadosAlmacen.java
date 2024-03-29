/*                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_Almacen;
import Idioma.Propiedades;
import Metodos_Configuraciones.metodosAlmacen;
import Metodos_Configuraciones.metodosDatosBasicos;
import java.sql.Connection;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Developer
 */
public class jpSubLotesEnviadosAlmacen extends javax.swing.JPanel {

    /**
     * Creates new form jpSubLotesEnviados
     */
    Connection cn;
    metodosAlmacen mal;
    DefaultTableModel modelo;
    String almacen, idSociedad, idAlmacen;
    Propiedades idioma;
    String Idioma;

    public jpSubLotesEnviadosAlmacen(String almacen, String Idioma, Connection cn) {
        initComponents();

        this.cn = cn;
        this.almacen = almacen;
        mal = new metodosAlmacen(cn);
        modelo = (DefaultTableModel) jTable1.getModel();
        this.Idioma = Idioma;
        
        idioma = new Propiedades(Idioma);
        
        jTable1.getColumnModel().getColumn(0).setHeaderValue(idioma.getProperty("NoBoleta"));
        jTable1.getColumnModel().getColumn(1).setHeaderValue(idioma.getProperty("FechaDeEnvio"));
        jTable1.getColumnModel().getColumn(2).setHeaderValue(idioma.getProperty("FolioManual"));
        jTable1.getColumnModel().getColumn(3).setHeaderValue(idioma.getProperty("FechaDeBoletaManualEntrada"));
        jTable1.getColumnModel().getColumn(4).setHeaderValue(idioma.getProperty("Vehiculo"));
        jTable1.getColumnModel().getColumn(5).setHeaderValue(idioma.getProperty("Placas"));
        jTable1.getColumnModel().getColumn(6).setHeaderValue(idioma.getProperty("NombreDelResponsable"));
        jTable1.getColumnModel().getColumn(7).setHeaderValue(idioma.getProperty("KgEnviados"));
        jTable1.getColumnModel().getColumn(8).setHeaderValue(idioma.getProperty("SacosEnviados"));
        
        jButton3.setText(idioma.getProperty("Exportar"));
        jButton5.setText(idioma.getProperty("Cerrar"));
        

        idSociedad = mal.devuelveUnDato("Select idSociedad from almacenes where nombreAlmacen ='" + almacen + "'");
        idAlmacen = mal.devuelveUnDato("select id from almacenes where nombreAlmacen ='" + almacen + "'");
        //llenarTabla(); se cancela esta linea hasta tener la tabla de boletas de salidas de BH    
    }
    public void llenarTabla() {
        limpiar(jTable1);
        mal.cargarInformacionColumna1B(modelo, 9, "SELECT b.idBoleta,b.fecha, b.idBoletaManual, b.fechaBoletaManual,  v.Nombre, v.Placas, v.Responsable, b.totalKg, b.totalSacos\n"
                + "from boletasalidareceptor b\n"
                + "left join vehiculo v on (b.idTransporte=v.ID) \n"
                + "where b.destino=" + idAlmacen + " and estatus=1 and tipoLugar='B' group by b.idBoleta order by b.id  ");
    }

    public void validarBoletaMultiple() throws ParseException {
/*
        String datos = mbh.validarMultiples("select estado from multipleboletasalidarecepcion where idBoleta='" + idBoleta + "'");
        // JOptionPane.showMessageDialog(null, datos);

        if (datos.contains("1")) {
            jdBoletasMultiples jdBM = new jdBoletasMultiples(null, true, idBoleta, idBeneficio, idSociedad, cn);
            jdBM.jp = this;
            jdBM.setVisible(true);

        } else {
            jdBoletaEntradaBH jdBBH = new jdBoletaEntradaBH(null, true, idBoleta, idSociedad, idBeneficio, "Nuevo", "CortesRecibidos", cn);
            jdBBH.jp = this;
            jdBBH.setVisible(true);
        }
*/
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
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No. Boleta", "Fecha de Envio", "Folio Manual", "Fecha Boleta Manual", "Vehiculo", "Placas", "Responsable", "Kg Enviados", "Sacos Enviados"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton3.setText("Exportar");

        jButton5.setText("Cerrar");
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton5))
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
    String idBoleta = "";
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        idBoleta = jTable1.getValueAt(jTable1.getSelectedRow(), 0) + "";
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.removeAll();
        this.revalidate();
        
        this.repaint();
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
