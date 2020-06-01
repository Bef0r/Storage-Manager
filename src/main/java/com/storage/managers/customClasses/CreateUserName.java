/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.managers.customClasses;

import com.storage.repositories.entities.User;

/**
 *
 * @author Dell
 */
public class CreateUserName {

    public static String createUserName(User user) {
        StringBuilder sb = new StringBuilder();
        sb.append(user.getFirstName());
        sb.append(" ");
        sb.append(user.getLastName());
        return sb.toString();
    }
}
