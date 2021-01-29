/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetodosGenerales;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author USUARIO
 */
public class MiRender2 extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row,
            int column) {

    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
      
    if(table.getValueAt(row,4).toString().equals("0") && table.getValueAt(row,5).toString().equals("0")){
        setBackground(Color.red);
    }
        
        return this;
    }

}
