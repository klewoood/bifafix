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
        
        User user = new User();
        user.setId_clien(566);
        user.setNama("Khabib");
        user.setAlamat("Cilacap");
        user.setJenis_kelamin("pria");
        user.setPengenal("KTP");
        user.setId_pengenal("5568978164");
        user.setPekerjaan("Ngoperator warnet");
        user.setTgl_lahir(new Date());
        user.setTelephone("68575669691");
        user.setMaksud_kedatangan("Surver");
        user.setId_resepsionis(7);
        
        dao.insertUser(user);
    }
    
}
