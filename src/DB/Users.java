/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import UI.RegisterForm;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Shashika
 */
public class Users extends Database{
    @Override
    public String getTableName(){
            return "users";
    }
    
    /**
     * User Login function
     * @param userName
     * @param password
     * @return true if the username and password matches a user account
     */
    public boolean authenticate(String userName,String password){
        //Hashing password  
        String hashtext = this.passwordHash(password); 
        userName = userName.replace("'", "");
        userName = userName.replace("\\", "");
        List result = this.get(" `user_name` = '"+userName+"' AND `password` = '"+hashtext+"'");
        return result.size()==1;
    }
    
    /**
     * Hashing User passwords
     * @param password
     * @return 
     */
    public String passwordHash(String password){
        //Hashing password        
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        m.reset();
        m.update(password.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        String hashtext = bigInt.toString(16);
        // Now we need to zero pad it if you actually want the full 32 chars.
        while(hashtext.length() < 32 ){
          hashtext = "0"+hashtext;
        }
        return hashtext;
    }
}
