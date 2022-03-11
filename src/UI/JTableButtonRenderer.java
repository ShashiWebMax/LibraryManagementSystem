/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Shashika
 */
public class JTableButtonRenderer extends JButton implements TableCellRenderer {

    public JTableButtonRenderer() {
        setOpaque(true);
    }

    @Override 
    public Component getTableCellRendererComponent(JTable table, Object obj, boolean selected, boolean focused, int row, int column) {
           setText("Book Info"); 
        return this;  
    }
    
}
