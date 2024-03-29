/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formas_LaboratorioN;

import Formas_laboratorio.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Juan Carlos
 */
class jdSaboresPropuesta2 extends javax.swing.JDialog {

    /**
     * Creates new form jdSaboresPropuesta2
     */
    
    DefaultTableModel modelo;
    
    
    public jdSaboresPropuesta2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setLocationRelativeTo(null);
        
        modelo = (DefaultTableModel) Sweet.getModel();
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
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rdDry = new javax.swing.JRadioButton();
        rdWet = new javax.swing.JRadioButton();
        rdBreak = new javax.swing.JRadioButton();
        rdFlavor = new javax.swing.JRadioButton();
        rdAftertaste = new javax.swing.JRadioButton();
        rdAcidity = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Sweet = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        Floral = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        Fruity = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        SourFer = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        GreenVeg = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        Other = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        Nutty = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        Roasted = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        Spices = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        Body = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        Finish = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Categorias");

        buttonGroup1.add(rdDry);
        rdDry.setText("Dry");
        rdDry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdDryMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdWet);
        rdWet.setText("Wet");
        rdWet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdWetMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdBreak);
        rdBreak.setText("Break");
        rdBreak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdBreakMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdFlavor);
        rdFlavor.setText("Flavor");
        rdFlavor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdFlavorMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdAftertaste);
        rdAftertaste.setText("Aftertaste");
        rdAftertaste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdAftertasteMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdAcidity);
        rdAcidity.setText("Acidity");
        rdAcidity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdAcidityMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdDry)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdWet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdBreak)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdFlavor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdAftertaste)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdAcidity))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdDry)
                    .addComponent(rdWet)
                    .addComponent(rdBreak)
                    .addComponent(rdFlavor)
                    .addComponent(rdAftertaste)
                    .addComponent(rdAcidity))
                .addContainerGap())
        );

        Sweet.setBackground(new java.awt.Color(255, 102, 102));
        Sweet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Brown Sugar", null},
                {"Molasses", null},
                {"Maple Sugar", null},
                {"Caramelized", null},
                {"Honey", null}
            },
            new String [] {
                "Sabor", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Sweet);

        Floral.setBackground(new java.awt.Color(255, 153, 102));
        Floral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Black Tea", null},
                {"Chamomile", null},
                {"Rose", null},
                {"Jasmine", null}
            },
            new String [] {
                "Sabor", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Floral);

        Fruity.setBackground(new java.awt.Color(255, 204, 0));
        Fruity.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Berry", null},
                {"Blackberry", null},
                {"Raspberry", null},
                {"Blueberry", null},
                {"Strawberry", null},
                {"Dried Fruit", null},
                {"Raisen", null},
                {"Prune", null},
                {"Other fruit", null},
                {"coconut", null},
                {"Cherry", null},
                {"Pomagranite", null},
                {"Pinneapple", null},
                {"Grape", null},
                {"Apple", null},
                {"Peach", null},
                {"Pear", null},
                {"Citrus Fruit", null},
                {"Grapefruit", null},
                {"Orange", null},
                {"Lemon", null},
                {"Lime", null}
            },
            new String [] {
                "Sabor", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(Fruity);

        SourFer.setBackground(new java.awt.Color(255, 255, 153));
        SourFer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Sour", null},
                {"Vinegar", null},
                {"Rancid butter", null},
                {"Rancid Cheese", null},
                {"Orange Acidity", null},
                {"Apple Acidity", null},
                {"Alcohol/Fermented", null},
                {"Winey", null},
                {"Whiskey", null},
                {"Fermented", null},
                {"Over-ripe", null}
            },
            new String [] {
                "Sabor", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(SourFer);

        GreenVeg.setBackground(new java.awt.Color(102, 255, 102));
        GreenVeg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Olive Oil", null},
                {"Raw", null},
                {"Beany", null},
                {"Under-ripe", null},
                {"Pea pod", null},
                {"Fresh", null},
                {"Dark Green", null},
                {"Vegetative", null},
                {"Hay-like", null},
                {"Herb-like", null}
            },
            new String [] {
                "Sabor", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(GreenVeg);

        Other.setBackground(new java.awt.Color(51, 255, 255));
        Other.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Papery/Musty", null},
                {"Stale", null},
                {"Cardboard", null},
                {"Papery", null},
                {"Woody", null},
                {"Moldy/Damp", null},
                {"Musty/Dusty", null},
                {"Musty/Earthy", null},
                {"Animalic", null},
                {"Meaty/Brothy", null},
                {"Phenolic", null},
                {"Chemical", null},
                {"Bitter", null},
                {"Salty", null},
                {"Medicinal", null},
                {"Petroleum", null},
                {"Skunky", null},
                {"Rubber", null}
            },
            new String [] {
                "Sabor", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(Other);

        Nutty.setBackground(new java.awt.Color(255, 153, 255));
        Nutty.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Nutty", null},
                {"Peanuts", null},
                {"Hazelenut", null},
                {"Almond", null},
                {"Cocoa", null},
                {"Chocolate", null},
                {"Dark Chocolate", null}
            },
            new String [] {
                "Sabor", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(Nutty);

        Roasted.setBackground(new java.awt.Color(0, 204, 255));
        Roasted.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Pipe Tobacco", null},
                {"Tobacco", null},
                {"Burnt", null},
                {"Acrid", null},
                {"Ashy", null},
                {"Smoky", null},
                {"Brown/Roast", null},
                {"Cereal", null}
            },
            new String [] {
                "Sabor", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(Roasted);

        Spices.setBackground(new java.awt.Color(204, 204, 255));
        Spices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Pungent", null},
                {"Pepper", null},
                {"Brown Spice", null},
                {"Anise", null},
                {"Nutmeg", null},
                {"Cinnamon", null},
                {"Clove", null}
            },
            new String [] {
                "Sabor", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(Spices);

        Body.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Thin", null},
                {"Medium", null},
                {"Heavy", null},
                {"Syrupy", null},
                {"Oily", null},
                {"Smooth", null}
            },
            new String [] {
                "Sabor", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(Body);

        Finish.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Short", null},
                {"Medium", null},
                {"Long", null},
                {"Dry", null},
                {"Astringent", null}
            },
            new String [] {
                "Sabor", "Intensidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(Finish);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
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

    private void rdDryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdDryMouseClicked
        // TODO add your handling code here:
        if(rdDry.isSelected()){
            /////ACTIVADOS
            Sweet.setVisible(true);
            Sweet.getTableHeader().setVisible(true);
            Sweet.setOpaque(true);
            Floral.setVisible(true);
            Floral.getTableHeader().setVisible(true);
            Floral.setOpaque(true);
            Fruity.setVisible(true);
            Fruity.getTableHeader().setVisible(true);
            Fruity.setOpaque(true);
            SourFer.setVisible(true);
            SourFer.getTableHeader().setVisible(true);
            SourFer.setOpaque(true);
            GreenVeg.setVisible(true);
            GreenVeg.getTableHeader().setVisible(true);
            GreenVeg.setOpaque(true);
            Other.setVisible(true);
            Other.getTableHeader().setVisible(true);
            Other.setOpaque(true);
            Roasted.setVisible(true);
            Roasted.getTableHeader().setVisible(true);
            Roasted.setOpaque(true);
            Spices.setVisible(true);
            Spices.getTableHeader().setVisible(true);
            Spices.setOpaque(true);
            Nutty.setVisible(true);
            Nutty.getTableHeader().setVisible(true);
            Nutty.setOpaque(true);
            /////DESACTIVADOS
            Body.setVisible(false);
            Body.getTableHeader().setVisible(false);
            Body.setOpaque(false);
            Finish.setVisible(false);
            Finish.getTableHeader().setVisible(false);
            Finish.setOpaque(false);
        }
    }//GEN-LAST:event_rdDryMouseClicked

    private void rdWetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdWetMouseClicked
        // TODO add your handling code here:
        if(rdWet.isSelected()){
            /////ACTIVADOS
            Sweet.setVisible(true);
            Sweet.getTableHeader().setVisible(true);
            Sweet.setOpaque(true);
            Floral.setVisible(true);
            Floral.getTableHeader().setVisible(true);
            Floral.setOpaque(true);
            Fruity.setVisible(true);
            Fruity.getTableHeader().setVisible(true);
            Fruity.setOpaque(true);
            SourFer.setVisible(true);
            SourFer.getTableHeader().setVisible(true);
            SourFer.setOpaque(true);
            GreenVeg.setVisible(true);
            GreenVeg.getTableHeader().setVisible(true);
            GreenVeg.setOpaque(true);
            Other.setVisible(true);
            Other.getTableHeader().setVisible(true);
            Other.setOpaque(true);
            Roasted.setVisible(true);
            Roasted.getTableHeader().setVisible(true);
            Roasted.setOpaque(true);
            Spices.setVisible(true);
            Spices.getTableHeader().setVisible(true);
            Spices.setOpaque(true);
            Nutty.setVisible(true);
            Nutty.getTableHeader().setVisible(true);
            Nutty.setOpaque(true);
            /////DESACTIVADOS
            Body.setVisible(false);
            Body.getTableHeader().setVisible(false);
            Body.setOpaque(false);
            Finish.setVisible(false);
            Finish.getTableHeader().setVisible(false);
            Finish.setOpaque(false);
        }
    }//GEN-LAST:event_rdWetMouseClicked

    private void rdBreakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdBreakMouseClicked
        // TODO add your handling code here:
        if(rdBreak.isSelected()){
            /////ACTIVADOS
            Sweet.setVisible(true);
            Sweet.getTableHeader().setVisible(true);
            Sweet.setOpaque(true);
            Floral.setVisible(true);
            Floral.getTableHeader().setVisible(true);
            Floral.setOpaque(true);
            Fruity.setVisible(true);
            Fruity.getTableHeader().setVisible(true);
            Fruity.setOpaque(true);
            SourFer.setVisible(true);
            SourFer.getTableHeader().setVisible(true);
            SourFer.setOpaque(true);
            GreenVeg.setVisible(true);
            GreenVeg.getTableHeader().setVisible(true);
            GreenVeg.setOpaque(true);
            Other.setVisible(true);
            Other.getTableHeader().setVisible(true);
            Other.setOpaque(true);
            Roasted.setVisible(true);
            Roasted.getTableHeader().setVisible(true);
            Roasted.setOpaque(true);
            Spices.setVisible(true);
            Spices.getTableHeader().setVisible(true);
            Spices.setOpaque(true);
            Nutty.setVisible(true);
            Nutty.getTableHeader().setVisible(true);
            Nutty.setOpaque(true);
            /////DESACTIVADOS
            Body.setVisible(false);
            Body.getTableHeader().setVisible(false);
            Body.setOpaque(false);
            Finish.setVisible(false);
            Finish.getTableHeader().setVisible(false);
            Finish.setOpaque(false);
        }
    }//GEN-LAST:event_rdBreakMouseClicked

    private void rdFlavorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdFlavorMouseClicked
        // TODO add your handling code here:
        if(rdFlavor.isSelected()){
            /////ACTIVADOS
            Sweet.setVisible(true);
            Sweet.getTableHeader().setVisible(true);
            Sweet.setOpaque(true);
            Floral.setVisible(true);
            Floral.getTableHeader().setVisible(true);
            Floral.setOpaque(true);
            Fruity.setVisible(true);
            Fruity.getTableHeader().setVisible(true);
            Fruity.setOpaque(true);
            SourFer.setVisible(true);
            SourFer.getTableHeader().setVisible(true);
            SourFer.setOpaque(true);
            GreenVeg.setVisible(true);
            GreenVeg.getTableHeader().setVisible(true);
            GreenVeg.setOpaque(true);
            Other.setVisible(true);
            Other.getTableHeader().setVisible(true);
            Other.setOpaque(true);
            Roasted.setVisible(true);
            Roasted.getTableHeader().setVisible(true);
            Roasted.setOpaque(true);
            Spices.setVisible(true);
            Spices.getTableHeader().setVisible(true);
            Spices.setOpaque(true);
            Nutty.setVisible(true);
            Nutty.getTableHeader().setVisible(true);
            Nutty.setOpaque(true);
            /////DESACTIVADOS
            Body.setVisible(false);
            Body.getTableHeader().setVisible(false);
            Body.setOpaque(false);
            Finish.setVisible(false);
            Finish.getTableHeader().setVisible(false);
            Finish.setOpaque(false);
        }
    }//GEN-LAST:event_rdFlavorMouseClicked

    private void rdAftertasteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdAftertasteMouseClicked
        // TODO add your handling code here:
        if(rdAftertaste.isSelected()){
            //Sabores activos
            Sweet.setVisible(true);
            Sweet.getTableHeader().setVisible(true);
            Sweet.setOpaque(true);
            Floral.setVisible(true);
            Floral.getTableHeader().setVisible(true);
            Floral.setOpaque(true);
            Fruity.setVisible(true);
            Fruity.getTableHeader().setVisible(true);
            Fruity.setOpaque(true);
            SourFer.setVisible(true);
            SourFer.getTableHeader().setVisible(true);
            SourFer.setOpaque(true);
            GreenVeg.setVisible(true);
            GreenVeg.getTableHeader().setVisible(true);
            GreenVeg.setOpaque(true);
            Body.setVisible(true);
            Body.getTableHeader().setVisible(true);
            Body.setOpaque(true);
            Finish.setVisible(true);
            Finish.getTableHeader().setVisible(true);
            Finish.setOpaque(true);
            //Sabores desactivados
            Other.setVisible(false);
            Other.getTableHeader().setVisible(false);
            Other.setOpaque(false);
            Roasted.setVisible(false);
            Roasted.getTableHeader().setVisible(false);
            Roasted.setOpaque(false);
            Spices.setVisible(false);
            Spices.getTableHeader().setVisible(false);
            Spices.setOpaque(false);
            Nutty.setVisible(false);
            Nutty.getTableHeader().setVisible(false);
            Nutty.setOpaque(false);
        }
    }//GEN-LAST:event_rdAftertasteMouseClicked

    private void rdAcidityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdAcidityMouseClicked
        // TODO add your handling code here:
        if(rdAcidity.isSelected()){
            SourFer.setVisible(true);
            SourFer.getTableHeader().setVisible(true);
            SourFer.setOpaque(true);
            ////////////////////////////////
            Sweet.setVisible(false);
            Sweet.getTableHeader().setVisible(false);
            Sweet.setOpaque(false);
            Floral.setVisible(false);
            Floral.getTableHeader().setVisible(false);
            Floral.setOpaque(false);
            Fruity.setVisible(false);
            Fruity.getTableHeader().setVisible(false);
            Fruity.setOpaque(false);
            GreenVeg.setVisible(false);
            GreenVeg.getTableHeader().setVisible(false);
            GreenVeg.setOpaque(false);
            Other.setVisible(false);
            Other.getTableHeader().setVisible(false);
            Other.setOpaque(false);
            Roasted.setVisible(false);
            Roasted.getTableHeader().setVisible(false);
            Roasted.setOpaque(false);
            Spices.setVisible(false);
            Spices.getTableHeader().setVisible(false);
            Spices.setOpaque(false);
            Nutty.setVisible(false);
            Nutty.getTableHeader().setVisible(false);
            Nutty.setOpaque(false);
            Body.setVisible(false);
            Body.getTableHeader().setVisible(false);
            Body.setOpaque(false);
            Finish.setVisible(false);
            Finish.getTableHeader().setVisible(false);
            Finish.setOpaque(false);
        }
    }//GEN-LAST:event_rdAcidityMouseClicked
    
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
            java.util.logging.Logger.getLogger(jdSaboresPropuesta2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdSaboresPropuesta2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdSaboresPropuesta2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdSaboresPropuesta2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdSaboresPropuesta2 dialog = new jdSaboresPropuesta2(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Body;
    private javax.swing.JTable Finish;
    private javax.swing.JTable Floral;
    private javax.swing.JTable Fruity;
    private javax.swing.JTable GreenVeg;
    private javax.swing.JTable Nutty;
    private javax.swing.JTable Other;
    private javax.swing.JTable Roasted;
    private javax.swing.JTable SourFer;
    private javax.swing.JTable Spices;
    private javax.swing.JTable Sweet;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JRadioButton rdAcidity;
    private javax.swing.JRadioButton rdAftertaste;
    private javax.swing.JRadioButton rdBreak;
    private javax.swing.JRadioButton rdDry;
    private javax.swing.JRadioButton rdFlavor;
    private javax.swing.JRadioButton rdWet;
    // End of variables declaration//GEN-END:variables
}
