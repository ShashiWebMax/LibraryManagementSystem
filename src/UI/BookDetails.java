/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import DB.Books;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author Shashika
 */
public class BookDetails extends javax.swing.JFrame {

    /**
     * Creates new form BookDetails
     */
    public BookDetails() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private int bookID;
    
    private String mode;
    /**
     * Set the form mode to new or update
     * @param Mode 
     */
    public void SetMode(String mode){
        this.mode = mode;
        if(mode.equals("new")){
            this.stateShowLabel.setVisible(false);
            this.stateLabel.setVisible(false);
            this.deleteBookButton.setVisible(false);
        }else{
            this.titleLabel.setText("Update Book");
            this.saveButton.setText("Update Book");
        }
    }
    
    public void SetBook(String bookID) throws SQLException{
        this.SetMode("view");
        //find the book
        Books books = new Books();
        ResultSet result = books.getResultSet("`id` = "+bookID+"");
        if(result.next()){
            this.nameInput.setText(result.getString("name"));        
            this.isbnInput.setText(Integer.toString(result.getInt("isbn")));
            this.authorInput.setText(result.getString("author"));
            this.descriptionInput.setText(result.getString("description"));
            this.categoryInput.setSelectedItem(result.getString("category"));
            this.languageInput.setSelectedItem(result.getString("language"));
            if(result.getInt("state") == 1){
                this.stateShowLabel.setText("Available");
            }else{
                this.stateShowLabel.setText("Barrowed");
            }
        
        }
        this.bookID = result.getInt("id");
//        System.out.println(this.);   
        
    }
    
    private Map bookData = new HashMap<String, String>();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        isbnLabel = new javax.swing.JLabel();
        isbnInput = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        nameInput = new javax.swing.JTextField();
        authorLabel = new javax.swing.JLabel();
        authorInput = new javax.swing.JTextField();
        categoryLabel = new javax.swing.JLabel();
        categoryInput = new javax.swing.JComboBox<>();
        descriptionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionInput = new javax.swing.JTextArea();
        languageLabel = new javax.swing.JLabel();
        languageInput = new javax.swing.JComboBox<>();
        stateLabel = new javax.swing.JLabel();
        stateShowLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        backToHomeButton = new javax.swing.JButton();
        deleteBookButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setDisplayedMnemonic('\n');
        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 102, 102));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Add new book");
        titleLabel.setAlignmentX(10.0F);
        titleLabel.setAlignmentY(10.0F);
        titleLabel.setAutoscrolls(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        isbnLabel.setText("ISBN Number");

        nameLabel.setText("Name");

        authorLabel.setText("Author");

        categoryLabel.setText("Category");

        categoryInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fiction", "non-fiction", "Biography", "Children's books", "Cookbooks", "Graphic novels", "Humor", "Memoirs", "Music", "Nature", "Philosophy", "Politics", "Religion", "Romance", "Science", "Self-help", "Sports", "Travel" }));

        descriptionLabel.setText("Description");

        descriptionInput.setColumns(20);
        descriptionInput.setRows(5);
        jScrollPane1.setViewportView(descriptionInput);

        languageLabel.setText("Language");

        languageInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sinhala", "Tamil", "English", "Other" }));

        stateLabel.setText("State");

        stateShowLabel.setText("State");

        saveButton.setBackground(new java.awt.Color(214, 220, 221));
        saveButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        saveButton.setForeground(new java.awt.Color(0, 102, 102));
        saveButton.setText("Register Book");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        backToHomeButton.setBackground(new java.awt.Color(221, 220, 214));
        backToHomeButton.setForeground(new java.awt.Color(153, 51, 0));
        backToHomeButton.setText("< Back to Home Screen");
        backToHomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToHomeButtonActionPerformed(evt);
            }
        });

        deleteBookButton.setBackground(new java.awt.Color(221, 220, 214));
        deleteBookButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteBookButton.setForeground(new java.awt.Color(255, 0, 0));
        deleteBookButton.setText("Delete Book");
        deleteBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBookButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(isbnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(isbnInput))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameInput, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(authorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(authorInput, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(categoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoryInput, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(stateLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(languageLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(languageInput, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stateShowLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(backToHomeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteBookButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(isbnLabel)
                    .addComponent(isbnInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(authorLabel)
                    .addComponent(authorInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryLabel)
                    .addComponent(categoryInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descriptionLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(languageLabel)
                    .addComponent(languageInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stateLabel)
                    .addComponent(stateShowLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backToHomeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteBookButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backToHomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToHomeButtonActionPerformed
        MainUI mainUI = new MainUI();
        mainUI.setVisible(true);        
        this.dispose();
    }//GEN-LAST:event_backToHomeButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        //loading inputs
        bookData.put("name",this.nameInput.getText());
        bookData.put("author",this.authorInput.getText());
        bookData.put("category",this.categoryInput.getSelectedItem().toString());
        bookData.put("isbn",this.isbnInput.getText());
        bookData.put("description",this.descriptionInput.getText());
        bookData.put("language",this.languageInput.getSelectedItem().toString());
        if(bookData.get("name").equals("")){
            JOptionPane.showMessageDialog(null, "Book Name can not be empty","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(bookData.get("isbn").equals("")){
            JOptionPane.showMessageDialog(null, "ISBN number can not be empty","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(this.mode.equals("new")){
            this.addBook();
        }else{
            this.updateBook();
        }
        //go back to MainUI
        MainUI mainUI = new MainUI();
        mainUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void deleteBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBookButtonActionPerformed
       int input = JOptionPane.showConfirmDialog(null, "Do you want to Delete this book?");
        // 0=yes, 1=no, 2=cancel
       if(input == 0){
            Books books = new Books();
            books.delete( this.bookID);
            //go back to MainUI
            MainUI mainUI = new MainUI();
            mainUI.setVisible(true);
            this.dispose();
       }
    }//GEN-LAST:event_deleteBookButtonActionPerformed

    private void addBook(){
        //add biik data to the database        
        this.bookData.put("state","1");
        Books books = new Books();
        books.insert(this.bookData);
        //show a success message
        JOptionPane.showMessageDialog(null, "Book added successfully");
        
    }
    
    private void updateBook(){
        Books books = new Books();
        books.update(this.bookData, this.bookID);
        //show a success message
        JOptionPane.showMessageDialog(null, "Book Updated successfully");    
    }
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
            java.util.logging.Logger.getLogger(BookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField authorInput;
    private javax.swing.JLabel authorLabel;
    private javax.swing.JButton backToHomeButton;
    private javax.swing.JComboBox<String> categoryInput;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JButton deleteBookButton;
    private javax.swing.JTextArea descriptionInput;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextField isbnInput;
    private javax.swing.JLabel isbnLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> languageInput;
    private javax.swing.JLabel languageLabel;
    private javax.swing.JTextField nameInput;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel stateLabel;
    private javax.swing.JLabel stateShowLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}