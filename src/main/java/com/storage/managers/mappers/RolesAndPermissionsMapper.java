/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.managers.mappers;

import com.storage.api.response.RoleAndPermission.RolesWithIdsResponse;
import com.storage.repositories.entities.Role;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RolesAndPermissionsMapper {
    
    public RolesWithIdsResponse getAllRolesWithIds(List<Role> roles){
        RolesWithIdsResponse mappedRolesWithIds = new RolesWithIdsResponse();
        
        Map<Long,String> RolesWithIds = new HashMap<>();
        roles.forEach(role->{
            RolesWithIds.put(role.getId(), role.getRoleName());
        });
        
        mappedRolesWithIds.setRoles(RolesWithIds);
        
        return mappedRolesWithIds;
    }
}
