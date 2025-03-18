/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoImpl;

import Dao.TransactionDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.account;
import mysql.dbSql;
import model.Transaction;
/**
 *
 * @author Dev khatri
 */
public class TransactionDaoImpl implements TransactionDao{
    Connection conn;
    public TransactionDaoImpl(){
        this.conn = dbSql.makeConnection();
    }
    @Override
    public void withdraw(account Account,Transaction transaction){
        String createTransactionTable ="CREATE TABLE IF NOT EXISTS Transactions("
                + "transaction_id INT PRIMARY KEY AUTO_INCREMENT,"+
                  "sender_accountno BIGINT NOT NULL,"+
                  "CONSTRAINT fk_sender_accountno FOREIGN KEY (sender_accountno) REFERENCES account(account_no),"+
                  "amount INT NOT NULL,"+
                  "receiver_accountno BIGINT DEFAULT NULL,"+
                  "CONSTRAINT fk_receiver_accountno FOREIGN KEY (receiver_accountno) REFERENCES account(account_no),"+
                  "transcation_date VARCHAR(60) NOT NULL,"+
                  "transaction_type VARCHAR(15) NOT NULL"+
                ")";
        try {
          Statement st = conn.createStatement();
          st.execute(createTransactionTable);
         
            String addTransactionDetailsQuery = "INSERT INTO transactions(sender_accountno,amount,receiver_accountno,transcation_date,transaction_type) VALUES(?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(addTransactionDetailsQuery,Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, Account.getAccountNumber());
            ps.setInt(2, transaction.getAmount());
            ps.setNull(3, -1);
            ps.setString(4, transaction.getTranscation_date());
            ps.setString(5, transaction.getTransaction_Type());
            ps.executeUpdate();
            
            ResultSet generatedkeys = ps.getGeneratedKeys();
            if (generatedkeys.next()) {
                transaction.setTranscationId(generatedkeys.getInt(1));
            }
            
            
            // Deduct balance
            Account.setBalance(Account.getBalance() - transaction.getAmount());
            // Update account balance in db 
            String updateBalanceQuery = "UPDATE account SET balance = ? WHERE account_no = ?";
            ps = conn.prepareStatement(updateBalanceQuery);
            ps.setInt(1, Account.getBalance());
            ps.setLong(2, Account.getAccountNumber());
            ps.executeUpdate();
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void deposit(account Account,Transaction transaction){
          String createTransactionTable ="CREATE TABLE IF NOT EXISTS Transactions("
                + "transaction_id INT PRIMARY KEY AUTO_INCREMENT,"+
                  "sender_accountno BIGINT NOT NULL,"+
                  "CONSTRAINT fk_sender_accountno FOREIGN KEY (sender_accountno) REFERENCES account(account_no),"+
                  "amount INT NOT NULL,"+
                  "receiver_accountno BIGINT DEFAULT NULL,"+
                  "CONSTRAINT fk_receiver_accountno FOREIGN KEY (receiver_accountno) REFERENCES account(account_no),"+
                  "transcation_date VARCHAR(60) NOT NULL,"+
                  "transaction_type VARCHAR(15) NOT NULL"+
                ")";
        try {
          Statement st = conn.createStatement();
          st.execute(createTransactionTable);
         
            String addTransactionDetailsQuery = "INSERT INTO transactions(sender_accountno,amount,receiver_accountno,transcation_date,transaction_type) VALUES(?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(addTransactionDetailsQuery,Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, Account.getAccountNumber());
            ps.setInt(2, transaction.getAmount());
            ps.setNull(3, -1);
            ps.setString(4, transaction.getTranscation_date());
            ps.setString(5, transaction.getTransaction_Type());
            ps.executeUpdate();
            
            ResultSet generatedkeys = ps.getGeneratedKeys();
            if (generatedkeys.next()) {
                transaction.setTranscationId(generatedkeys.getInt(1));
            }
            
            
            // Add balance in User Account
            Account.setBalance(Account.getBalance() + transaction.getAmount());
            // Update account balance in db 
            String updateBalanceQuery = "UPDATE account SET balance = ? WHERE account_no = ?";
            ps = conn.prepareStatement(updateBalanceQuery);
            ps.setInt(1, Account.getBalance());
            ps.setLong(2, Account.getAccountNumber());
            ps.executeUpdate();
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     public boolean Transfer(account SenderAccount,account ReceiverAccount, Transaction transaction){
            String createTransactionTable ="CREATE TABLE IF NOT EXISTS Transactions("
                + "transaction_id INT PRIMARY KEY AUTO_INCREMENT,"+
                  "sender_accountno BIGINT NOT NULL,"+
                  "CONSTRAINT fk_sender_accountno FOREIGN KEY (sender_accountno) REFERENCES account(account_no),"+
                  "amount INT NOT NULL,"+
                  "receiver_accountno BIGINT DEFAULT NULL,"+
                  "CONSTRAINT fk_receiver_accountno FOREIGN KEY (receiver_accountno) REFERENCES account(account_no),"+
                  "transcation_date VARCHAR(60) NOT NULL,"+
                  "transaction_type VARCHAR(15) NOT NULL"+
                ")";
        try {
          Statement st = conn.createStatement();
          st.execute(createTransactionTable);
          
           String addTransactionDetailsQuery = "INSERT INTO transactions(sender_accountno,amount,receiver_accountno,transcation_date,transaction_type) VALUES(?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(addTransactionDetailsQuery,Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, SenderAccount.getAccountNumber());
            ps.setInt(2, transaction.getAmount());
            ps.setLong(3, ReceiverAccount.getAccountNumber());
            ps.setString(4, transaction.getTranscation_date());
            ps.setString(5, transaction.getTransaction_Type());
            ps.executeUpdate();
            
            ResultSet generatedkeys = ps.getGeneratedKeys();
            if (generatedkeys.next()) {
                transaction.setTranscationId(generatedkeys.getInt(1));
            }
          
            // add Amount in receiver Account
           ReceiverAccount.setBalance(ReceiverAccount.getBalance() + transaction.getAmount());
           String updateReceiverBalance = "UPDATE account SET balance = ? WHERE account_no = ?";
           ps = conn.prepareStatement(updateReceiverBalance);
           ps.setInt(1, ReceiverAccount.getBalance());
           ps.setLong(2, ReceiverAccount.getAccountNumber());
           ps.executeUpdate();
           
            // Update account balance in db 
            SenderAccount.setBalance(SenderAccount.getBalance() - transaction.getAmount());
            String updateBalanceQuery = "UPDATE account SET balance = ? WHERE account_no = ?";
            ps = conn.prepareStatement(updateBalanceQuery);
            ps.setInt(1, SenderAccount.getBalance());
            ps.setLong(2, SenderAccount.getAccountNumber());
            ps.executeUpdate();
            
            return true;
          } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public ArrayList<Transaction> getTransactions(account Account){
         String getTransactionsQuery = "SELECT * FROM account WHERE account_no = "+Account.getAccountNumber()+"";
         try{
          Statement st = conn.createStatement();
          ResultSet rs = st.executeQuery(getTransactionsQuery);
          if(rs.next()){
          ArrayList<Transaction> transactionsArrayList = new ArrayList<>();
              while (rs.next()) {                  
                  Transaction transaction = new Transaction();
              }
              return transactionsArrayList;
          }
         }catch(SQLException ex){
             System.out.println(ex.getMessage());
         }
         return null;
    }
}
