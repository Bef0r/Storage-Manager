/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.managers.customClasses;

import com.storage.repositories.entities.RolePermission;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class CollectionToMap {
    public static Map<Long,String> convertCollectionToMap(Collection<RolePermission> permissions){
        Map<Long,String> map = new HashMap<>();
        permissions.forEach(permission->{
            map.put(permission.getPermission().getId(), permission.getPermission().getPermissionName());
        });
        return map;
    }
}
