/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.managers.customClasses;

import com.storage.repositories.entities.Permission;
import com.storage.repositories.entities.RolePermission;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class CollectionToMap {
    public static Map<Long,String> convertCollectionToMap(List<Permission> permissions){
        Map<Long,String> map = new HashMap<>();
        permissions.forEach(permission->{
            map.put(permission.getId(), permission.getPermissionName());
        });
        return map;
    }
    
    public static List<Long> convertRolePermissionPermissionIdsToList(List<RolePermission> rolePermissions){
        List<Long> permissionId = new LinkedList<>();
        rolePermissions.forEach(relationships->{
            permissionId.add(relationships.getPermissionId());
        });
        return permissionId;
    }
}
