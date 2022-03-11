/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

/**
 *
 * @author Shashika
 */
public class BookLending extends Database {
    @Override
    public String getTableName(){
            return "book_lending";
    }
    
    public void return_book(int bookId){
        this.insertData("Update `book_lending` SET `state` = '2' WHERE `book_id` = '"+bookId+"' AND `state` = '1';");
    }
}
