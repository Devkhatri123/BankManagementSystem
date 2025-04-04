/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DaoImpl.userDaoImpl;
import Service.UserService;
import View.Home;
import View.LoginPage;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Account;
import model.User;

/**
 *
 * @author Dev khatri
 */
public class UserController {
     private UserService userService;
     public UserController(){
         this.userService = new UserService();
     }
    public User registerUser(String name,String fathername,String dof,String email,String martailStatus,String cnic,String address,String phonenumber){
        User user = new User();
        user.setName(name);
        user.setFatherName(fathername);
        user.setDof(dof);
        user.setEmail(email);
        user.setMartialStatus(martailStatus);
        user.setCnic(cnic);
        user.setAddress(address);
        user.setPhonenumber(phonenumber);
        return userService.createUser(user);
     }
    
    public void authenticateUser(String email,String accountno,String pin,LoginPage loginpage){
        ResultSet result = userService.authenticate(email, Long.parseLong(accountno), Integer.parseInt(pin));
        if(result != null){
            try{
            Account account = new Account();
            account.setAccountId(result.getInt("accountId"));
            account.setAccountNumber(result.getLong("account_no"));
            account.setPin(result.getInt("pin"));
            account.setBalance(result.getInt("balance"));
            User user = new User();
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
     public boolean updateEmail(User user,String emailinput){
      if(user.getEmail().toLowerCase().equals(emailinput.toLowerCase())){
          JOptionPane.showMessageDialog(null, "Email is same");
          return false;
      }
      return userService.updateEmail(user,emailinput);
    }
     public boolean updatePhone(User User,String Input){
         return userService.updatePhone(User, Input);
    }
     public boolean updateAddress(User user,String Input){
         return userService.updateAddress(user, Input);
     }
}
