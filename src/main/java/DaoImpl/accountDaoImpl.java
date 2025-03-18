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
import mysql.dbSql;
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
    public account createAccount(account Account,int userId){
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
             ps.setInt(2, Account.getPin());
             ps.setInt(3, Account.getBalance());
             ps.setLong(4, Account.getAccountNumber());
            // ps.setInt(4, userId);
             ps.executeUpdate();
             ResultSet accountIds = ps.getGeneratedKeys();
             if(accountIds.next()){
                Account.setAccountId(accountIds.getInt(1));
                return Account;
             } 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
          //  throw new Error(e.getMessage());
        }
        return null;
    }
    @Override
    public account getAccountDetailsById(int userId){
        String RetrieveAccount = "select a.userId,a.accountId,a.pin,a.balance,a.account_no,u.user_name,u.user_email from user as u inner join account as a on a.userId = u.userId where a.user_Id = "+userId+" and u.userId = "+userId+"";
        try {
        Statement st = conn.createStatement();
        ResultSet result = st.executeQuery(RetrieveAccount);
            while (result.next()) {
                account account = new account();
                user User = new user();
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
    public account getReceiverAccount(long receiverAccountno){
        String receiver_AccountnoQuery = "SELECT * FROM account WHERE account_no = "+receiverAccountno+" ";
        try{
            PreparedStatement ps = conn.prepareStatement(receiver_AccountnoQuery);
            ResultSet rs = ps.executeQuery();
           if(rs.next()){
               account receiveraccount = new account();
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
}
