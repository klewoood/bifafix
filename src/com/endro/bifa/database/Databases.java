/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endro.bifa.database;

import com.endro.bifa.dao.UserDao;
import com.endro.bifa.dao.implement.UserDaoImpl;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author bumijonet
 */
public class Databases {

    private static Connection koneksi;
    private static UserDao user;

    public static Connection getKoneksi() throws SQLException {
        if (koneksi == null) {
            MysqlDataSource msSource = new MysqlDataSource();

            msSource.setURL("jdbc:mysql://localhost:3306/bifa");
            msSource.setUser("root");
            msSource.setPassword("bumijonet");

            koneksi = msSource.getConnection();
        }
        return koneksi;
    }

    public static UserDao getUser() throws SQLException {
        if(user==null){
            user = new UserDaoImpl(getKoneksi());
        }
        return user;
    }

    
}
