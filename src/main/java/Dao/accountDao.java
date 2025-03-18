/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;
import model.*;
/**
 *
 * @author Dev khatri
 */
public interface accountDao {
    public account createAccount(account account,int userId);
    public account getAccountDetailsById(int accountid);
    public account getReceiverAccount(long receiverAccountno);
}
