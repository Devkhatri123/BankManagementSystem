/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoImpl;

import Dao.userDao;
import com.mysql.cj.jdbc.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mysql.dbSql;
import model.user;

/**
 *
 * @author Dev khatri
 */
public class userDaoImpl implements userDao{
    static Connection conn;
    public userDaoImpl(){
        conn = dbSql.makeConnection();
    }
    
    
    @Override
    public ArrayList<user> getUsers(){
        ArrayList<user> users = new ArrayList<>();
        String getUsersQuery = "SELECT * FROM user";
        try {
            PreparedStatement ps = conn.prepareStatement(getUsersQuery);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user User = new user();
                User.setEmail(rs.getString(5));
                User.setCnic(rs.getString(7));
                User.setPhonenumber(rs.getString(9));
                users.add(User);
            }
            return users;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
   }
    
    
    @Override
   public user createUser(user User){
        String createUserTableQuery = "CREATE TABLE IF NOT EXISTS user(" +
"                   userId int PRIMARY KEY NOT NULL AUTO_INCREMENT," +
"                   user_name VARCHAR(50) NOT NULL," +
"                   user_fathername VARCHAR(50) NOT NULL," +
"                   user_dof VARCHAR(70) NOT NULL," +
"                   user_email VARCHAR(40) NOT NULL UNIQUE," +
"                   user_martialStatus VARCHAR(12)," +
"                   user_cnic VARCHAR(13) NOT NULL UNIQUE," +
"                   user_address VARCHAR(70) NOT NULL," +
"                   user_phonenumber VARCHAR(12) NOT NULL UNIQUE" +
"                 )";
        try {
           Statement statement = conn.createStatement();   
           statement.executeUpdate(createUserTableQuery);
           
          if(!isEmailExist(User, User.getEmail())){
           
           String insertUserDataQuery = "INSERT INTO user (user_name,user_fathername,user_dof,user_email,user_martialStatus,user_cnic,user_address,user_phonenumber) VALUES (?,?,?,?,?,?,?,?)";
           
            PreparedStatement ps = conn.prepareStatement(insertUserDataQuery, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, User.getName());
            ps.setString(2, User.getFatherName());
            ps.setString(3, User.getDof());
            ps.setString(4, User.getEmail());
            ps.setString(5, User.getMartialStatus());
            ps.setString(6, User.getCnic());
            ps.setString(7, User.getAddress());
            ps.setString(8, User.getPhonenumber());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            if(ids.next()){
                User.setUserId(ids.getInt(1));
            }
            return User;
          }else {
              JOptionPane.showMessageDialog(null, "Email is already in use");
              User = null;
              return null;
          }
        } catch (SQLException e) {
           
            System.out.println(e.getMessage());
        }
        return null;
            
    }
   @Override
   public ResultSet authenticateUser(String email,long accountno,int pin){
       ResultSet resultSet = null;
       String getAccountQuery = "select u.userId,u.user_name, u.user_email,a.accountId,a.account_no,a.pin,a.balance from user as u inner join account as a on u.userId = a.userId where u.user_email = ? and a.account_no = ? and a.pin = ?;";
       try {
           PreparedStatement ps = conn.prepareStatement(getAccountQuery);
           ps.setString(1, email);
           ps.setLong(2, accountno);
           ps.setInt(3, pin);
           resultSet = ps.executeQuery();
           if(resultSet.next()){
               System.out.println("Account reterived");
               return resultSet;
           }
           
       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }
       return null;
   }
   @Override
   public boolean updateEmail(user User,String emailinput){
       if(!isEmailExist(User,emailinput)){
       String updateEmailQuery = "UPDATE user SET user_email = '"+emailinput+"' WHERE userId = "+User.getUserId()+" ";
       try{
       PreparedStatement ps = conn.prepareStatement(updateEmailQuery);
       int rowAffected = ps.executeUpdate();
       JOptionPane.showMessageDialog(null, "Email updated successfully...");
       User.setEmail(emailinput);
       if(rowAffected > 0) return true;
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
        }else{
           JOptionPane.showMessageDialog(null, "Email already exist in database");
       }
        return false;
   }
   @Override 
   public boolean updatePhone(user User,String Input){
       if(!isPhoneNumberExist(User,Input)){
            String updatePhoneQuery = "UPDATE user SET user_phonenumber = '"+Input+"' WHERE userId = "+User.getUserId()+" ";
           try{
           PreparedStatement ps = conn.prepareStatement(updatePhoneQuery);
           int rowAffected = ps.executeUpdate();
                if(rowAffected > 0){
                    User.setPhonenumber(Input);
                    JOptionPane.showMessageDialog(null, "Phone number updated successfully...");
                    return true;
                }
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
       }else{
          JOptionPane.showMessageDialog(null, "Phone number already exist in database"); 
       }
       return false;
   }
   
    public boolean updateAddress(user User,String Input){
         String updateAddressQuery = "UPDATE user SET user_address = '"+Input+"' WHERE userId = "+User.getUserId()+" ";
           try{
           PreparedStatement ps = conn.prepareStatement(updateAddressQuery);
           int rowAffected = ps.executeUpdate();
                if(rowAffected > 0){
                    User.setPhonenumber(Input);
                    JOptionPane.showMessageDialog(null, "Address updated successfully...");
                    return true;
                }
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
        return false;
    }
   
   
   public boolean isPhoneNumberExist(user User,String Input){
       String getUserQuery = "SELECT * FROM user";
        try{
        PreparedStatement ps = conn.prepareStatement(getUserQuery);
        ResultSet result = ps.executeQuery();
        while(result.next()){
            if(result.getString("user_phonenumber").toLowerCase().equals(Input.toLowerCase())){
               return true;
            }
        }
        return false;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
       return true;
   }
    @Override
    public boolean isEmailExist(user User,String emailinput){
        String getUserQuery = "SELECT * FROM user";
        try{
        PreparedStatement ps = conn.prepareStatement(getUserQuery);
        ResultSet result = ps.executeQuery();
        while(result.next()){
            if(result.getString("user_email").toLowerCase().equals(emailinput.toLowerCase())){
               return true;
            }
        }
        return false;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
