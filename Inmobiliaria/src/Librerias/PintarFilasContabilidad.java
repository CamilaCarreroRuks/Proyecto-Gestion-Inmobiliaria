package Librerias;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Camila Carrero
 */
public class PintarFilasContabilidad extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        try {
            Double saldo = Double.parseDouble(table.getValueAt(row, 6).toString().replace(",", "").replace(".", ""));
            if (saldo == 0.0) {
                setForeground(new Color(128, 128, 128));
            } else if (saldo == null || saldo != 0.0) {
                setForeground(Color.BLACK);
            }
        } catch (NullPointerException e) {
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
