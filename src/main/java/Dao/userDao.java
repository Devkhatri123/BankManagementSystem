/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import java.sql.ResultSet;
import model.user;

/**
 *
 * @author Dev khatri
 */
public interface userDao {
   public user createUser(user User);
   public ResultSet authenticateUser(String email,long accountno,int pin);
}
