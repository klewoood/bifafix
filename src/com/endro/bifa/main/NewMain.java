/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.endro.bifa.main;

import com.endro.bifa.dao.UserDao;
import com.endro.bifa.database.Databases;
import com.endro.bifa.entity.User;
import com.endro.bifa.error.BifaExeption;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author klewoood
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, BifaExeption {
        // TODO code application logic here
        UserDao dao = Databases.getUser();
        
        dao.deleteUser(666);
                
    }
    
}
