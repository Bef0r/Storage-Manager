/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.controllers;

import com.storage.api.response.RoleAndPermission.RolesAndpermissionsWithIdsResponse;
import com.storage.api.response.RoleAndPermission.RolesPermissionsResponse;
import com.storage.managers.interfaces.RolePermissionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/rest/roleandpermission")
public class RoleAndPermissionController {
    
    @Autowired
    RolePermissionManager rolePermissionManager;

    
    @GetMapping(path ="/")
    public RolesAndpermissionsWithIdsResponse getRolesAndpermissionsWithIdsResponse(){
        return rolePermissionManager.getAllRolesAndPermissionsWithIds();
    }
    
    @GetMapping(path ="/{roleId}")
    public RolesPermissionsResponse getRolepermissions(@PathVariable("roleId") long roleId){
        return rolePermissionManager.getRolePermissions(roleId);
    }
}
