/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.managers.interfaces;

import com.storage.repositories.entities.User;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface UserManager {
    public List<User> saveAllUsers(List<User> users);
}
