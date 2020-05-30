/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.api.response.RoleAndPermission;

import java.util.List;

/**
 *
 * @author Dell
 */
public class NewRoleResponse {
    private Long newRoleId;
    private String newRoleName;
    private List<Long> newRolePermissionIds;

    public Long getNewRoleId() {
        return newRoleId;
    }

    public void setNewRoleId(Long newRoleId) {
        this.newRoleId = newRoleId;
    }

    public String getNewRoleName() {
        return newRoleName;
    }

    public void setNewRoleName(String newRoleName) {
        this.newRoleName = newRoleName;
    }

    public List<Long> getNewRolePermissionIds() {
        return newRolePermissionIds;
    }

    public void setNewRolePermissionIds(List<Long> newRolePermissionIds) {
        this.newRolePermissionIds = newRolePermissionIds;
    }
    
}
