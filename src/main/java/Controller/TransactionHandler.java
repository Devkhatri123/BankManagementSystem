/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DaoImpl.TransactionDaoImpl;
import java.util.Date;
import javax.swing.JOptionPane;
import model.account;
import model.Transaction;
import DaoImpl.accountDaoImpl;
import java.util.ArrayList;

/**
 *
 * @author Dev khatri
 */
public class TransactionHandler {
   private TransactionDaoImpl TransactionDaoImpl;
   private accountDaoImpl AccountDaoImpl;
   public TransactionHandler(){
       this.TransactionDaoImpl = new TransactionDaoImpl();
       this.AccountDaoImpl = new accountDaoImpl();
   }
   public String withDraw(account Account,int AmountToWithDraw){
       if(Account.isWithdrawable(Account.getBalance(), AmountToWithDraw)){
           Date d = new Date();
           Transaction transaction = new Transaction();
           transaction.setAmount(AmountToWithDraw);
           transaction.setSender_Accountno(Account.getAccountNumber());
           transaction.setTransaction_Type("withdraw");
           transaction.setReceiver_Accountno(-1);
           transaction.setTranscation_date(d.toString());
           TransactionDaoImpl.withdraw(Account,transaction);
       }else return "You have insufficient balance in your account";
       return "";
   }
   public void deposit(account Account,int amounToDeposit){
         Date d = new Date();
         Transaction transaction = new Transaction();
         transaction.setAmount(amounToDeposit);
         transaction.setSender_Accountno(Account.getAccountNumber());
         transaction.setTransaction_Type("deposit");
         transaction.setReceiver_Accountno(-1);
         transaction.setTranscation_date(d.toString());
         TransactionDaoImpl.deposit(Account, transaction);
   }
   public boolean transfer(account SenderAccount,String receiverAccountno,int ammountToTransfer){
       if(SenderAccount.isTransable(SenderAccount.getBalance(), ammountToTransfer)){
       account receiverAccount = getReceiverAccount(Long.parseLong(receiverAccountno));
       if(receiverAccount != null){
         Date d = new Date();
         Transaction transaction = new Transaction();
         transaction.setAmount(ammountToTransfer);
         transaction.setSender_Accountno(SenderAccount.getAccountNumber());
         transaction.setReceiver_Accountno(receiverAccount.getAccountNumber());
         transaction.setTransaction_Type("transfer");
         transaction.setTranscation_date(d.toString());
         return TransactionDaoImpl.Transfer(SenderAccount, receiverAccount, transaction);
       }else JOptionPane.showMessageDialog(null, "Account does not exist against entered accountno");
       }else{
           JOptionPane.showMessageDialog(null, "You have insufficient balance in account.");
       }
        return false;
   }
   
public account getReceiverAccount(long receiverAccountno){
    return AccountDaoImpl.getReceiverAccount(receiverAccountno);
}
public ArrayList<Transaction> getTransactions(account Account){
    return TransactionDaoImpl.getTransactions(Account);
}
}
