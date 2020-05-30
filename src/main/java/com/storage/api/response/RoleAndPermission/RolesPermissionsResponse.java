/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.api.response.RoleAndPermission;

import java.util.List;

public class RolesPermissionsResponse {
    Long roleId;
    List<Long> rolePermissionIds;

    public RolesPermissionsResponse() {
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<Long> getRolePermissionIds() {
        return rolePermissionIds;
    }

    public void setRolePermissionIds(List<Long> rolePermissionIds) {
        this.rolePermissionIds = rolePermissionIds;
    }
    
}
