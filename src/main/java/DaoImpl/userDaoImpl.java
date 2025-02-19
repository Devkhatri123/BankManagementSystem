/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoImpl;

import Dao.userDao;
import java.sql.Connection;
import mysql.dbSql;

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
   public void createUser(String name,String fathername,String dof,String email,String martailStatus,String cnic,String address,String phoneNumber){
        String createUserTableQuery = "CREATE TABLE IF NOT EXIST user("
                +  "userId int PRIMARY KEY NOT NULL AUTO_INCREMENT,"+
                   "user_name VARCHAR(50) NOT NULL,"+
                   "user_fathername VARCHAR(50) NOT NULL,"+
                   "user_dof VARCHAR(70) NOT NULL,"+
                   "user_email VARCHAR(40) NOT NULL,"+
                   "user_martialStatus VARCHAR(12),"+
                   "user_cnic VARCHAR(13) NOT NULL,"+
                   "user_address VARCHAR(70) NOT NULL,"+
                   "user_phonenumber VARCHAR(12) NOT NULL"+
                ")";
    }
}
