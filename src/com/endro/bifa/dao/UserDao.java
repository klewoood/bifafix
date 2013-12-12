/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endro.bifa.dao;

import com.endro.bifa.entity.User;
import com.endro.bifa.error.BifaExeption;
import java.util.List;

/**
 *
 * @author klewoood
 */
public interface UserDao {

    public void insertUser(User user) throws BifaExeption;
    
    public void updateUser(User user) throws BifaExeption;
    
    public void deleteUser(Integer id_clien) throws BifaExeption;
    
    public User getByIdUser(Integer id_clien) throws BifaExeption;
    
    public List<User> getAll() throws BifaExeption;
}
