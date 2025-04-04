/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import model.User;
import DaoImpl.userDaoImpl;
import com.mysql.cj.protocol.Resultset;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author Dev khatri
 */
public class UserService {
    private userDaoImpl userDao;
    
    public UserService(){
        this.userDao = new userDaoImpl();
    }
    public User createUser(User user){
        if(userDao.isEmailExist(user.getEmail())){
            JOptionPane.showMessageDialog(null, "Email is already in use");
            return null;
        }
        if(userDao.isPhoneNumberExist(user.getPhonenumber())){
             JOptionPane.showMessageDialog(null, "Phone number is already in use");
             return null;
         }
        if(userDao.isCnicExist(user.getCnic())){
            JOptionPane.showMessageDialog(null, "Cnic number is already in use");
             return null;
        }
       return userDao.createUser(user);
    }
    public ResultSet authenticate(String email,long accountno,int pin){
        if(email.isEmpty() || accountno <= 0 || pin <= 0){
            JOptionPane.showMessageDialog(null, "Invalid credendtails.");
            return null;
        }
       return userDao.authenticateUser(email, accountno, pin);
    }
       public boolean updateEmail(User user,String emailInput){
           if(emailInput.isEmpty()){
               JOptionPane.showMessageDialog(null, "Input is empty");
               return false;
           }
           else if (userDao.isEmailExist(emailInput)){
            JOptionPane.showMessageDialog(null, "phone is already in use");
            return false;
        }
        return userDao.updateEmail(user, emailInput);
    }
    public boolean updatePhone(User user,String phoneInput){
        if(phoneInput.isEmpty()){
             JOptionPane.showMessageDialog(null, "phone Input is empty");
             return false;
        }
        else if (userDao.isPhoneNumberExist(phoneInput)){
            JOptionPane.showMessageDialog(null, "phone is already in use");
            return false;
        }
         return userDao.updatePhone(user, phoneInput);
    }
    public boolean updateAddress(User user,String addressInput){
        if(addressInput.isEmpty()){
             JOptionPane.showMessageDialog(null, "Address Input is empty");
             return false;
        }
        return userDao.updateAddress(user, addressInput);
    }
}
