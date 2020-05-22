/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.managers;

import com.storage.api.response.RoleAndPermission.RolesResponse;
import com.storage.managers.interfaces.RolePermissionManager;
import com.storage.managers.mappers.RolesAndPermissionsMapper;
import com.storage.repositories.RoleRepository;
import com.storage.repositories.entities.Role;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class RolePermissionManagerImp implements RolePermissionManager{

    RoleRepository roleRepository;

    @Autowired
    public RolePermissionManagerImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    
    
    @Override
    public RolesResponse getAllRolesWithIds() {
        RolesAndPermissionsMapper mapper = new RolesAndPermissionsMapper();
        List<Role> roles = (List<Role>) roleRepository.findAll();
        RolesResponse response = mapper.getAlRolesWithIds(roles);
        return response;
    }
    
}
