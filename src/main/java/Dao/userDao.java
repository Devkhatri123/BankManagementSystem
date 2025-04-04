/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author Dev khatri
 */
public interface userDao {
   public ArrayList<User> getUsers();
   public User createUser(User user);
   public ResultSet authenticateUser(String email,long accountno,int pin);
   public boolean isEmailExist(String emailInput);
   public boolean updateEmail(User user,String emailInput);
   public boolean isPhoneNumberExist(String numberInput);
   public boolean updatePhone(User user,String numberInput);
   public boolean updateAddress(User user,String addressInput);
   public boolean isCnicExist(String cnicInput);
}
