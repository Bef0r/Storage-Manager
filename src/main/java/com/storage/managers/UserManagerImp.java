/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.managers;

import com.storage.managers.interfaces.UserManager;
import com.storage.repositories.UserRepository;
import com.storage.repositories.entities.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserManagerImp implements UserManager{

    UserRepository userRepository;

    @Autowired
    public UserManagerImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    
    @Override
    public List<User> saveAllUsers(List<User> users) {
        return (List<User>) userRepository.saveAll(users);
    }
    
}
