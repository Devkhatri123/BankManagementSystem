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
import db.dbSql;
import model.User;

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
    public ArrayList<User> getUsers(){
        ArrayList<User> users = new ArrayList<>();
        String getUsersQuery = "SELECT * FROM user";
        try {
            PreparedStatement ps = conn.prepareStatement(getUsersQuery);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User User = new User();
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
   public User createUser(User user){
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
           
            String insertUserDataQuery = "INSERT INTO user (user_name,user_fathername,user_dof,user_email,user_martialStatus,user_cnic,user_address,user_phonenumber) VALUES (?,?,?,?,?,?,?,?)";
           
            PreparedStatement ps = conn.prepareStatement(insertUserDataQuery, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setString(2, user.getFatherName());
            ps.setString(3, user.getDof());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getMartialStatus());
            ps.setString(6, user.getCnic());
            ps.setString(7, user.getAddress());
            ps.setString(8, user.getPhonenumber());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            if(ids.next()){
                user.setUserId(ids.getInt(1));
                 return user;
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
   public boolean updateEmail(User user,String emailInput){
       String updateEmailQuery = "UPDATE user SET user_email = '"+emailInput+"' WHERE userId = "+user.getUserId()+" ";
       try{
       PreparedStatement ps = conn.prepareStatement(updateEmailQuery);
       int rowAffected = ps.executeUpdate();
       JOptionPane.showMessageDialog(null, "Email updated successfully...");
       user.setEmail(emailInput);
       if(rowAffected > 0) return true;
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
        return false;
   }
   @Override 
   public boolean updatePhone(User user,String phoneInput){
        String updatePhoneQuery = "UPDATE user SET user_phonenumber = '"+phoneInput+"' WHERE userId = "+user.getUserId()+" ";
           try{
           PreparedStatement ps = conn.prepareStatement(updatePhoneQuery);
           int rowAffected = ps.executeUpdate();
                if(rowAffected > 0){
                    user.setPhonenumber(phoneInput);
                    JOptionPane.showMessageDialog(null, "Phone number updated successfully...");
                    return true;
                }
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
       return false;
   }
   
    public boolean updateAddress(User user,String addressInput){
         String updateAddressQuery = "UPDATE user SET user_address = '"+addressInput+"' WHERE userId = "+user.getUserId()+" ";
           try{
           PreparedStatement ps = conn.prepareStatement(updateAddressQuery);
           int rowAffected = ps.executeUpdate();
                if(rowAffected > 0){

                    user.setAddress(addressInput);

                    user.setAddress(addressInput);
                    JOptionPane.showMessageDialog(null, "Address updated successfully...");
                    return true;
                }
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
        return false;
    }
   
   
   public boolean isPhoneNumberExist(String phoneInput){
       String getUserQuery = "SELECT * FROM user";
        try{
        PreparedStatement ps = conn.prepareStatement(getUserQuery);
        ResultSet result = ps.executeQuery();
        while(result.next()){
            if(result.getString("user_phonenumber").equals(phoneInput)){
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
    public boolean isEmailExist(String emailInput){
        String getUserQuery = "SELECT * FROM user";
        try{
        PreparedStatement ps = conn.prepareStatement(getUserQuery);
        ResultSet result = ps.executeQuery();
        while(result.next()){
            if(result.getString("user_email").toLowerCase().equals(emailInput.toLowerCase())){
               return true;
            }
        }
        return false;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean isCnicExist(String cnicInput){
        String getUserQuery = "SELECT * FROM user";
        try{
        PreparedStatement ps = conn.prepareStatement(getUserQuery);
        ResultSet result = ps.executeQuery();
        while(result.next()){
            if(result.getString("user_cnic").toLowerCase().equals(cnicInput.toLowerCase())){
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
