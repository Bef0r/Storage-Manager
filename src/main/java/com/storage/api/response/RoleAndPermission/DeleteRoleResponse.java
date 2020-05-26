/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.api.response.RoleAndPermission;

public class DeleteRoleResponse {
    long roleId;
    int numberOfDeletedPermissions;

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public int getNumberOfDeletedPermissions() {
        return numberOfDeletedPermissions;
    }

    public void setNumberOfDeletedPermissions(int numberOfDeletedPermissions) {
        this.numberOfDeletedPermissions = numberOfDeletedPermissions;
    }    
}
