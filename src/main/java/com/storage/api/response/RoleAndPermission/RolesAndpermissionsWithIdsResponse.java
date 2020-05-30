/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.api.response.RoleAndPermission;

import java.util.HashMap;
import java.util.Map;

public class RolesAndpermissionsWithIdsResponse {
    private Map<Long,String> Roles = new HashMap<>();
    private Map<Long,String> Permissions = new HashMap<>();

    public Map<Long, String> getPermissions() {
        return Permissions;
    }

    public void setPermissions(Map<Long, String> Permissions) {
        this.Permissions = Permissions;
    }
    
    public Map<Long, String> getRoles() {
        return Roles;
    }

    public void setRoles(Map<Long, String> Roles) {
        this.Roles = Roles;
    }
}
