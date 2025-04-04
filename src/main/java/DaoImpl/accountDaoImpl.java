/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoImpl;

import Dao.accountDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import db.dbSql;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author Dev khatri
 */
public class accountDaoImpl implements accountDao{
    Connection conn;
    public accountDaoImpl(){
        this.conn = dbSql.makeConnection();
    }
    @Override
    public int createAccount(Account account,int userId){
        String accountTableQuery = "CREATE TABLE IF NOT EXISTS account("+
                  "accountId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"+
                  "userId INT NOT NULL,"+
                  "FOREIGN KEY (userId) REFERENCES user(userId),"+
                  "pin INT NOT NULL,"+
                  "balance INT,"+
                  "account_no BIGINT NOT NULL"+
                ")";
        try {
             Statement statement =conn.createStatement();
             statement.executeUpdate(accountTableQuery);
             
             String accountRowQuery = "INSERT INTO account(userId,pin,balance,account_no) VALUES (?,?,?,?)";
             PreparedStatement ps = conn.prepareStatement(accountRowQuery, Statement.RETURN_GENERATED_KEYS);
             ps.setInt(1, userId);
             ps.setInt(2, account.getPin());
             ps.setInt(3, account.getBalance());
             ps.setLong(4, account.getAccountNumber());
            // ps.setInt(4, userId);
             ps.executeUpdate();
             ResultSet accountIds = ps.getGeneratedKeys();
             if(accountIds.next()){
                account.setAccountId(accountIds.getInt(1));
                return account.getAccountId();
             } 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
          //  throw new Error(e.getMessage());
        }
        return -1;
    }
    @Override
    public Account getAccountDetailsById(int userId){
        String RetrieveAccount = "select a.userId,a.accountId,a.pin,a.balance,a.account_no,u.user_name,u.user_email from user as u inner join account as a on a.userId = u.userId where a.user_Id = "+userId+" and u.userId = "+userId+"";
        try {
        Statement st = conn.createStatement();
        ResultSet result = st.executeQuery(RetrieveAccount);
            while (result.next()) {
                Account account = new Account();
                User User = new User();
                User.setUserId(result.getInt(1));
                User.setName(result.getString(6));
                User.setEmail(result.getString(7));
                
                account.setAccountId(result.getInt(2));
                account.setPin(result.getInt(3));
                account.setBalance(result.getInt(4));
                account.setAccountNumber(result.getLong(5));
                account.setaccountHolderName(result.getString(6));
                account.setAccountHolderId(result.getInt(1));
                return account;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Override
    public Account getReceiverAccount(long receiverAccountno){
        String receiver_AccountnoQuery = "SELECT * FROM account WHERE account_no = "+receiverAccountno+" ";
        try{
            PreparedStatement ps = conn.prepareStatement(receiver_AccountnoQuery);
            ResultSet rs = ps.executeQuery();
           if(rs.next()){
               Account receiveraccount = new Account();
               receiveraccount.setAccountId(rs.getInt(1));
               receiveraccount.setAccountHolderId(rs.getInt(2));
               receiveraccount.setPin(rs.getInt(3));
               receiveraccount.setBalance(rs.getInt(4));
               receiveraccount.setAccountNumber(rs.getLong(5));
               return receiveraccount;
           }
        }catch(SQLException Ex){
            System.out.println(Ex.getMessage());
        }
        return null;
    }
     @Override
    public boolean withdraw(Account account,Transaction transaction){
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
            ps.setLong(1, account.getAccountNumber());
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
            account.setBalance(account.getBalance() - transaction.getAmount());
            // Update account balance in db 
            String updateBalanceQuery = "UPDATE account SET balance = ? WHERE account_no = ?";
            ps = conn.prepareStatement(updateBalanceQuery);
            ps.setInt(1, account.getBalance());
            ps.setLong(2, account.getAccountNumber());
            ps.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean deposit(Account account,Transaction transaction){
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
            ps.setLong(1, account.getAccountNumber());
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
            account.setBalance(account.getBalance() + transaction.getAmount());
            // Update account balance in db 
            String updateBalanceQuery = "UPDATE account SET balance = ? WHERE account_no = ?";
            ps = conn.prepareStatement(updateBalanceQuery);
            ps.setInt(1, account.getBalance());
            ps.setLong(2, account.getAccountNumber());
            ps.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
     public boolean Transfer(Account senderAccount,Account receiverAccount, Transaction transaction){
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
            ps.setLong(1, senderAccount.getAccountNumber());
            ps.setInt(2, transaction.getAmount());
            ps.setLong(3, receiverAccount.getAccountNumber());
            ps.setString(4, transaction.getTranscation_date());
            ps.setString(5, transaction.getTransaction_Type());
            ps.executeUpdate();
            
            ResultSet generatedkeys = ps.getGeneratedKeys();
            if (generatedkeys.next()) {
                transaction.setTranscationId(generatedkeys.getInt(1));
            }
          
            // add Amount in receiver Account
           receiverAccount.setBalance(receiverAccount.getBalance() + transaction.getAmount());
           String updateReceiverBalance = "UPDATE account SET balance = ? WHERE account_no = ?";
           ps = conn.prepareStatement(updateReceiverBalance);
           ps.setInt(1, receiverAccount.getBalance());
           ps.setLong(2, receiverAccount.getAccountNumber());
           ps.executeUpdate();
           
            // Update account balance in db 
            senderAccount.setBalance(senderAccount.getBalance() - transaction.getAmount());
            String updateBalanceQuery = "UPDATE account SET balance = ? WHERE account_no = ?";
            ps = conn.prepareStatement(updateBalanceQuery);
            ps.setInt(1, senderAccount.getBalance());
            ps.setLong(2, senderAccount.getAccountNumber());
            ps.executeUpdate();
            
            return true;
          } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public ArrayList<Transaction> getTransactions(Account Account){
         String getTransactionsQuery = "select transactions.amount,transactions.transcation_date, transactions.transaction_type,transactions.sender_accountno, transactions.receiver_accountno from transactions  inner join account on sender_accountno = account_no where sender_accountno = "+Account.getAccountNumber()+" ";
         try{
          Statement st = conn.createStatement();
          ResultSet rs = st.executeQuery(getTransactionsQuery);
          ArrayList<Transaction> transactionsArrayList = new ArrayList<>();
              while (rs.next()) {                  
                  Transaction transaction = new Transaction();
                  transaction.setAmount(rs.getInt(1));
                  transaction.setTranscation_date(rs.getString(2));
                  transaction.setTransaction_Type(rs.getString(3));
                  transaction.setSender_Accountno(rs.getLong(4));
                  transaction.setReceiver_Accountno(rs.getLong(5));
//                  transactionsArrayList.add(transaction);
                  if(transaction.getReceiver_Accountno() > 0){
                   Statement st2 = conn.createStatement();
                  String getreceiverDetailsQuery = "select user_name,account.account_no from account inner join user on account.userId = user.userId where account.account_no = "+transaction.getReceiver_Accountno()+" ";
                  ResultSet rs2 = st2.executeQuery(getreceiverDetailsQuery);
                  if(rs2.next()){
                      if(transaction.getReceiver_Accountno() == rs2.getLong(2)){
                          transaction.setReceiver_name(rs2.getString(1));
                      }
                  }
                  }
                  transactionsArrayList.add(transaction);
                }
              return transactionsArrayList;
          }catch(SQLException ex){
             System.out.println("Error : " + ex.getMessage());
         }
         return null;
    }
}
