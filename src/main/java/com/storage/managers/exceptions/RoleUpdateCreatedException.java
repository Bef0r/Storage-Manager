/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.managers.exceptions;

/**
 *
 * @author Dell
 */
public class RoleUpdateCreatedException extends Exception {

    /**
     * Creates a new instance of <code>RoleUpdateCreatedException</code> without
     * detail message.
     */
    public RoleUpdateCreatedException() {
    }

    /**
     * Constructs an instance of <code>RoleUpdateCreatedException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public RoleUpdateCreatedException(String msg) {
        super(msg);
    }
}
