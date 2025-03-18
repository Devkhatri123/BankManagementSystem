/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;
import java.util.ArrayList;
import model.account;
import model.Transaction;
/**
 *
 * @author Dev khatri
 */
public interface TransactionDao {
    public void withdraw(account Account,Transaction transaction);
    public void deposit(account Account,Transaction transaction);
    public boolean Transfer(account SenderAccount,account ReceiverAccount, Transaction transaction);
    public ArrayList<Transaction> getTransactions(account Account);
}
