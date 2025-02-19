/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoImpl;

import Dao.accountDao;
import java.sql.Connection;
import mysql.dbSql;

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
    public void createAccount(){
        
    }
}
