/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.endro.bifa.error;

/**
 *
 * @author bumijonet
 */
public class BifaError extends Exception {

    /**
     * Creates a new instance of <code>BifaError</code> without detail message.
     */
    public BifaError() {
    }

    /**
     * Constructs an instance of <code>BifaError</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public BifaError(String msg) {
        super(msg);
    }
}
