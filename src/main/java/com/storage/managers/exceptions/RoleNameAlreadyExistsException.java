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
public class RoleNameAlreadyExistsException extends Exception {

    public RoleNameAlreadyExistsException() {
    }

    public RoleNameAlreadyExistsException(String msg) {
        super(msg);
    }
}
