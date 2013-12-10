/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.endro.bifa.dao;

/**
 *
 * @author bumijonet
 */
public interface UserLoginDao {
    
    boolean isContain(String username, String password) ;
    
}
