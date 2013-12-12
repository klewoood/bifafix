/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.endro.bifa.error;

/**
 *
 * @author klewoood
 */
public class BifaExeption extends Exception {

    /**
     * Creates a new instance of <code>BifaExeption</code> without detail
     * message.
     */
    public BifaExeption() {
    }

    /**
     * Constructs an instance of <code>BifaExeption</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public BifaExeption(String msg) {
        super(msg);
    }
}
