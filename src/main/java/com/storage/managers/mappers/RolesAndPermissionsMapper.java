/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.managers.mappers;

import com.storage.api.response.RoleAndPermission.RolesAndpermissionsWithIdsResponse;
import com.storage.repositories.entities.Permission;
import com.storage.repositories.entities.Role;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RolesAndPermissionsMapper {
    
    public  Map<Long,String> mappedRolesWithId(List<Role> roles){
        
        Map<Long,String> RolesWithIds = new HashMap<>();
        roles.forEach(role->{
            RolesWithIds.put(role.getId(), role.getRoleName());
        });
        
        return RolesWithIds;
    }
    
     public  Map<Long,String> mappedPermissionsWithId(List<Permission> permisssions){
        
        Map<Long,String> PermissionsWithIds = new HashMap<>();
        permisssions.forEach(permission->{
            PermissionsWithIds.put(permission.getId(),permission.getPermissionName());
        });
        
        return PermissionsWithIds;
    }
     
     public RolesAndpermissionsWithIdsResponse mappedRolesAndPermissionToResponse(Map<Long,String> roles,Map<Long,String> permissions){
         RolesAndpermissionsWithIdsResponse response = new RolesAndpermissionsWithIdsResponse();
         response.setRoles(roles);
         response.setPermissions(permissions);
         
         return response;
     }
}
