
import UI.LoginForm;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Shashika
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Displaying the login form");
//        MainFrame myFrame = new MainFrame();
//        myFrame.init();
        LoginForm welcome = new LoginForm();
        welcome.setVisible(true);
    }
    
}
