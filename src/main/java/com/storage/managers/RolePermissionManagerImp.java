/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.managers;

import com.storage.api.response.RoleAndPermission.RolesAndpermissionsWithIdsResponse;
import com.storage.managers.interfaces.RolePermissionManager;
import com.storage.managers.mappers.RolesAndPermissionsMapper;
import com.storage.repositories.PermissionRepository;
import com.storage.repositories.RoleRepository;
import com.storage.repositories.entities.Permission;
import com.storage.repositories.entities.Role;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RolePermissionManagerImp implements RolePermissionManager{

    RoleRepository roleRepository;
    PermissionRepository permissionRepository;
    
    @Autowired
        public RolePermissionManagerImp(RoleRepository roleRepository, PermissionRepository permissionRepository) {
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
    }
    
    
    @Override
    public RolesAndpermissionsWithIdsResponse getAllRolesAndPermissionsWithIds() {
        List<Role> roles = (List<Role>) roleRepository.findAll();
        List<Permission> permissions = (List<Permission>) permissionRepository.findAll();
        RolesAndpermissionsWithIdsResponse response = mappedGetAllRolesAndPermissionsWithIdsResponse(roles,permissions);
        return response;
    }
    
    private RolesAndpermissionsWithIdsResponse mappedGetAllRolesAndPermissionsWithIdsResponse(List<Role> roles, List<Permission> permissions){
        RolesAndPermissionsMapper mapper = new RolesAndPermissionsMapper();
        Map<Long,String> mappedRoles = mapper.mappedRolesWithId(roles);
        Map<Long,String> mappedPermissions = mapper.mappedPermissionsWithId(permissions);
        return mapper.mappedRolesAndPermissionToResponse(mappedRoles, mappedPermissions);
    }
    
}
