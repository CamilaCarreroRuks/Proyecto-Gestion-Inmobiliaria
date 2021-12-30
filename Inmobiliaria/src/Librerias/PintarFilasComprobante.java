package Librerias;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Camila Carrero
 */
public class PintarFilasComprobante extends DefaultTableCellRenderer{
    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {     
   Boolean numero = (Boolean) table.getValueAt(row, 4);
        if (numero == false) {
            setForeground(new Color(128,128,128));
        }else{
           setForeground(Color.BLACK); 
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }   
}
