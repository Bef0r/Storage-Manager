/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.controllers;

import com.storage.repositories.BlueprintRepository;
import com.storage.repositories.LocationRepository;
import com.storage.repositories.PermissionRepository;
import com.storage.repositories.RoleRepository;
import com.storage.repositories.UserRepository;
import com.storage.repositories.WorkpieceRepository;
import com.storage.repositories.entities.Blueprint;
import com.storage.repositories.entities.Location;
import com.storage.repositories.entities.Permission;
import com.storage.repositories.entities.Role;
import com.storage.repositories.entities.User;
import com.storage.repositories.entities.Workpiece;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("rest/test")
public class TestController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BlueprintRepository blueprintRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private WorkpieceRepository workpieceRepository;
    
    @GetMapping(path ="/")
    public String test(){
    	Optional<Blueprint> b = blueprintRepository.findById("1");
    	Location e = locationRepository.findById(1);
    	User u = userRepository.findById(1);
        Optional<Permission> p = permissionRepository.findById(1);
        Workpiece w = workpieceRepository.findById(1);
    	Blueprint b1 = new Blueprint();
        return b1.generateWorkpieceIdOnlyTest();
    }
}
