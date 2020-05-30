/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.api.response.RoleAndPermission;

import java.util.Map;

public class DeleteRoleResponse {
    long roleId;
    int numberOfDeletedPermissions;
    Map<Long,String> involvedUsers;
    
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

    public Map<Long, String> getInvolvedUsers() {
        return involvedUsers;
    }

    public void setInvolvedUsers(Map<Long, String> involvedUsers) {
        this.involvedUsers = involvedUsers;
    }
}
