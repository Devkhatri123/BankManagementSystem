/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;
import java.util.ArrayList;
import model.*;
/**
 *
 * @author Dev khatri
 */
public interface accountDao {
    public int createAccount(Account account,int userId);
    public Account getAccountDetailsById(int accountid);
    public Account getReceiverAccount(long receiverAccountno);
    public boolean withdraw(Account account,Transaction transaction);
    public boolean deposit(Account account,Transaction transaction);
    public boolean Transfer(Account senderAccount,Account receiverAccount, Transaction transaction);
    public ArrayList<Transaction> getTransactions(Account account);
}
