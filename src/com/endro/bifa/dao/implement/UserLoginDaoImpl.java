/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.endro.bifa.dao.implement;

import com.endro.bifa.dao.UserLoginDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bumijonet
 */
public class UserLoginDaoImpl implements UserLoginDao{
    
    private Connection koneksi;

    public UserLoginDaoImpl(Connection koneksi) {
        this.koneksi = koneksi;
    }

    @Override
    public boolean isContain(String username, String password) {
        
        boolean b =false;
        String tempUsername=null;
        String tempPassword=null;
        
        String query = "select * from user where hak_akses = ? AND password = ? ";
        PreparedStatement statement = null;
        
        try{
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeQuery();
            
            ResultSet result = statement.executeQuery();
            
             if (result.next()) {
                result.beforeFirst();
                while (result.next()) {
                    tempUsername = result.getString("username");
                    tempPassword = result.getString("password");
                }
            }
            if (tempUsername.equalsIgnoreCase(username) && tempPassword.equalsIgnoreCase(password)) {
                b = true;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return b;
        
    }
    
}
