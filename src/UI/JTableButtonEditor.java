/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.EventObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Shashika
 */
public class JTableButtonEditor extends DefaultCellEditor {

    protected JButton btn;
    private String lbl;
    private Boolean clicked;
    private JFrame srcFrame;
  
    public JTableButtonEditor(JTextField txt, JFrame srcFrame){
        super(txt);
        this.srcFrame = srcFrame;
        btn = new JButton();
        btn.setOpaque(true);
        
        //button click action
        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              fireEditingStopped();
            }
        });     
        
    }

    @Override
     public Component getTableCellEditorComponent(JTable table, Object obj, boolean selected, int row, int col){
         lbl = obj==null ? "":obj.toString();
         btn.setText("Book Info");
         clicked=true;
         return btn;
     }

    @Override
    public Object getCellEditorValue() {
       if(clicked){
           BookDetails bookDetails = new BookDetails();
           try {
               bookDetails.SetBook(lbl);
           } catch (SQLException ex) {
               Logger.getLogger(JTableButtonEditor.class.getName()).log(Level.SEVERE, null, ex);
           }
           bookDetails.setVisible(true);
           this.srcFrame.dispose();
            
       }
       clicked = false;
       return new String(lbl);
    }

    @Override
    public boolean stopCellEditing() {
        clicked = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }    
}
