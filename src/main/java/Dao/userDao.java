/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.user;

/**
 *
 * @author Dev khatri
 */
public interface userDao {
   public ArrayList<user> getUsers();
   public user createUser(user User);
   public ResultSet authenticateUser(String email,long accountno,int pin);
   public boolean isEmailExist(user User,String emailinput);
   public boolean updateEmail(user User,String emailinput);
   public boolean isPhoneNumberExist(user User,String Input);
   public boolean updatePhone(user User,String Input);
   public boolean updateAddress(user User,String Input);
}
