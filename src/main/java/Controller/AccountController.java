/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DaoImpl.accountDaoImpl;
import Service.AccountService;
import View.Home;
import View.SignUp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import model.Account;
import model.Transaction;
import model.User;

/**
 *
 * @author Dev khatri
 */
public class AccountController{
    private AccountService accountService;
    public AccountController(){
        this.accountService = new AccountService();
    }
    public void createAccount(User user,SignUp signUpView){
        if(user != null){
        String pin = JOptionPane.showInputDialog(null,"Enter your pin");
        String balance = JOptionPane.showInputDialog(null,"With how much balance do you want to open the account");
        Random random = new Random();
        Account account = new Account();
        account.setPin(Integer.parseInt(pin));
        account.setBalance(Integer.parseInt(balance));
        account.setAccountNumber(random.nextLong(1000000000,999999999999l));
        account.setAccountHolderId(user.getUserId());
        int accountId = accountService.createAccount(account,user.getUserId());
        if(accountId > 0){
            signUpView.dispose();
            JOptionPane.showMessageDialog(null,"Your Account number : " + account.getAccountNumber());
            JOptionPane.showMessageDialog(null,"Your pin number : " + account.getPin());
            new Home(user,account).setVisible(true);
        }
        }
    }
    public Account getAccountDetails(int userId){
      return accountService.getAccountDetails(userId);
    }
    
     public String withDraw(Account account,int amountToWithDraw){
         Date d = new Date();
         Transaction transaction = new Transaction();
         transaction.setAmount(amountToWithDraw);
         transaction.setSender_Accountno(account.getAccountNumber());
         transaction.setTransaction_Type("withdraw");
         transaction.setReceiver_Accountno(-1);
         transaction.setTranscation_date(d.toString());
         return accountService.withDraw(account, transaction);
   }
   public String deposit(Account Account,int amounToDeposit){
         Date d = new Date();
         Transaction transaction = new Transaction();
         transaction.setAmount(amounToDeposit);
         transaction.setSender_Accountno(Account.getAccountNumber());
         transaction.setTransaction_Type("deposit");
         transaction.setReceiver_Accountno(-1);
         transaction.setTranscation_date(d.toString());
         return accountService.deposit(Account, transaction);
   }
   public boolean transfer(Account SenderAccount,String receiverAccountno,int ammountToTransfer){
       Account receiverAccount = accountService.getReceiverAccount(receiverAccountno);
       if(receiverAccount != null){
         Date d = new Date();
         Transaction transaction = new Transaction();
         transaction.setAmount(ammountToTransfer);
         transaction.setSender_Accountno(SenderAccount.getAccountNumber());
         transaction.setReceiver_Accountno(receiverAccount.getAccountNumber());
         transaction.setTransaction_Type("transfer");
         transaction.setTranscation_date(d.toString());
         boolean result = accountService.transfer(SenderAccount, receiverAccount, transaction);
         if(result) return result;
         else transaction = null;
       }else JOptionPane.showMessageDialog(null, "Account does not exist against entered accountno");
       return false;
   }   
public ArrayList<Transaction> getTransactions(Account Account){
    return accountService.getTransactions(Account);
}
    
}
