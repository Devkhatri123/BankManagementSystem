/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DaoImpl.userDaoImpl;
import View.Home;
import View.LoginPage;
import View.SignUp;
import com.mysql.cj.protocol.Resultset;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JOptionPane;
import model.account;
import model.user;

/**
 *
 * @author Dev khatri
 */
public class AuthController {
     private userDaoImpl userDaoImpl;
     public AuthController(){
         this.userDaoImpl = new userDaoImpl();
     }
    public user registerUser(String name,String fathername,String dof,String email,String martailStatus,String cnic,String address,String phonenumber){
        user user = new user();
        user.setName(name);
        user.setFatherName(fathername);
        user.setDof(dof);
        user.setEmail(email);
        user.setMartialStatus(martailStatus);
        user.setCnic(cnic);
        user.setAddress(address);
        user.setPhonenumber(phonenumber);
        return userDaoImpl.createUser(user);
     }
    
    public void authenticateUser(String email,String accountno,String pin,LoginPage loginpage){
        ResultSet result = userDaoImpl.authenticateUser(email, Long.parseLong(accountno), Integer.parseInt(pin));
        if(result != null){
            try{
            account account = new account();
            account.setAccountId(result.getInt("accountId"));
            account.setAccountNumber(result.getLong("account_no"));
            account.setPin(result.getInt("pin"));
            account.setBalance(result.getInt("balance"));
            user user = new user();
            user.setUserId(result.getInt("userId"));
            user.setName(result.getString("user_name"));
            user.setEmail(result.getString("user_email"));
            loginpage.setVisible(false);
            new Home(user,account).setVisible(true);
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }else JOptionPane.showMessageDialog(null, "No Account Found Against given crenditials.");
    }
//    public Object[] getAccountAfterSignUp(int userId){
//        userDaoImpl
//        Object[] obj = new Object[2];
//        return obj;
//    }
}
