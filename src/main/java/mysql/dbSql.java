/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dev khatri
 */
public class dbSql {
    public static Connection makeConnection() {
       String url = "jdbc:mysql://127.0.0.1:3306/sportsmanagement";
   String username = "root";
   String password = "root123";
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
                 System.out.println("connection successful...");
            return connection;
        }catch(ClassNotFoundException e){
            System.out.println("ERROR :" + e.getMessage());
        }
        catch(SQLException E){
            System.out.println("ERROR :" + E.getMessage());
        }
        return null;
    }
}
