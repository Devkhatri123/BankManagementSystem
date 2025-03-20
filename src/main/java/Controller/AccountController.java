/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DaoImpl.accountDaoImpl;
import View.Home;
import View.SignUp;
import java.util.Random;
import javax.swing.JOptionPane;
import model.account;
import model.user;

/**
 *
 * @author Dev khatri
 */
public class AccountController {
    private accountDaoImpl accountDaoImpl;
    public AccountController(){
        this.accountDaoImpl =new accountDaoImpl();
    }
    public void createAccount(user User,SignUp signUpView){
        if(User != null){
        String pin = JOptionPane.showInputDialog(null,"Enter your pin");
        String balance = JOptionPane.showInputDialog(null,"With how much balance do you want to open the account");
        Random random = new Random();
        account Account = new account();
        Account.setPin(Integer.parseInt(pin));
        Account.setBalance(Integer.parseInt(balance));
        Account.setAccountNumber(random.nextLong(1000000000,999999999999l));
        Account.setAccountHolderId(User.getUserId());
        Account = accountDaoImpl.createAccount(Account,User.getUserId());
        if(Account != null){
            signUpView.dispose();
            JOptionPane.showMessageDialog(null,"Your Account number : " + Account.getAccountNumber());
            JOptionPane.showMessageDialog(null,"Your pin number : " + Account.getPin());
            new Home(User,Account).setVisible(true);
        }
        }
    }
    public account getAccountDetails(int userId){
      account account = accountDaoImpl.getAccountDetailsById(userId);
      return account;
    }
}
