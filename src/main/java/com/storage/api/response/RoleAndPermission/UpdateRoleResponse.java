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
public class UpdateRoleResponse {
    Long roleId;
    List<Long> rolePermissionRelationships;
    int numberOfDeletedRows;
    int numberOfNewRows;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    } 

    public List<Long> getRolePermissionRelationships() {
        return rolePermissionRelationships;
    }

    public void setRolePermissionRelationships(List<Long> rolePermissionRelationships) {
        this.rolePermissionRelationships = rolePermissionRelationships;
    }

    public int getNumberOfDeletedRows() {
        return numberOfDeletedRows;
    }

    public void setNumberOfDeletedRows(int numberOfDeletedRows) {
        this.numberOfDeletedRows = numberOfDeletedRows;
    }

    public int getNumberOfNewRows() {
        return numberOfNewRows;
    }

    public void setNumberOfNewRows(int numberOfNewRows) {
        this.numberOfNewRows = numberOfNewRows;
    }
        
}
