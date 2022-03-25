/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import UI.MainUI;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Shashika
 */
public class LendFacade {
    public static void lendBook(int bookId, int userID){
        //change book status as barrowed
        Books books = new Books();
        Map bookData = new HashMap<String, String>();
        bookData.put("state","2");
        books.update(bookData, bookId);
        //add book barrow record
        Map lendingData = new HashMap<String, String>();
        lendingData.put("book_id",Integer.toString(bookId) );
        lendingData.put("member_id",Integer.toString(userID));
        lendingData.put("state","1");
        BookLending bookLending = new BookLending();
        bookLending.insert(lendingData);  
    }  
    public static void returnBook(int bookID){
        // marking book as available
        Books books = new Books();
        Map bookData = new HashMap<String, String>();
        bookData.put("state","1");
        books.update(bookData, bookID);
        //setting lending record as returned
        BookLending bookLending = new BookLending();
        bookLending.return_book(bookID);
    } 
}
