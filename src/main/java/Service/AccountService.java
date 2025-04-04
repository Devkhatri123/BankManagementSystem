/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import model.Account;
import DaoImpl.accountDaoImpl;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Transaction;

/**
 *
 * @author Dev khatri
 */
public class AccountService {
    private accountDaoImpl accountDaoImpl;
    public AccountService(){
        this.accountDaoImpl = new accountDaoImpl();
    }
    
    public int createAccount(Account account ,int userId){
        if(account != null && userId > 0){
          return accountDaoImpl.createAccount(account, userId);
        }
        return -1;
    }
    
    public Account getAccountDetails(int userId){
        if(userId <= 0){
             JOptionPane.showMessageDialog(null, "operation Failed");
             return null;
        }
        Account account = accountDaoImpl.getAccountDetailsById(userId);
        if(account != null) return account;
        else{
           JOptionPane.showMessageDialog(null, "No Account Found");
           return null; 
        }
    }
    
    public String withDraw(Account account,Transaction transaction){
       if (transaction.getAmount() <= 0) {
            return "Invalid withdrawal amount.";
        }
        if (account.getBalance() < transaction.getAmount()) {
            return "Insufficient funds.";
        }

        boolean success = accountDaoImpl.withdraw(account, transaction);
        return success ? "Transaction Successful" : "Operation failed";
    }
    public String deposit(Account account,Transaction transaction){
        if(transaction.getAmount() <= 0){
            return "Invalid deposit amount.";
        }
       boolean result = accountDaoImpl.deposit(account, transaction);
       return result ? "Transaction successful" :  "Operation failed";
    }
   private boolean isTransferAble(int balance,int ammountToTransfer){
        if(balance >= ammountToTransfer) return true;
        else return false;
    }
   
    public boolean transfer(Account senderAccount,Account receiverAccount, Transaction transaction){
        if(transaction.getAmount() <= 0){
             JOptionPane.showMessageDialog(null, "Transfer amount can't be less than or zero");
             return false;
        }
        if(isTransferAble(senderAccount.getBalance(), transaction.getAmount())) return accountDaoImpl.Transfer(senderAccount, receiverAccount, transaction);
        else {
             JOptionPane.showMessageDialog(null, "You have insufficient balance in account.");
        }
        return false;
    }
    public Account getReceiverAccount(String receiverAccountno){
        if(receiverAccountno.length() > 0){
             return new accountDaoImpl().getReceiverAccount(Long.parseLong(receiverAccountno));
        }
        return null;
    }
    public ArrayList<Transaction> getTransactions(Account Account){
    return accountDaoImpl.getTransactions(Account);
}
}
