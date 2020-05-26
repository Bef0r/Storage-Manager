/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.managers.customClasses;

import com.storage.repositories.entities.RolePermission;
import java.util.List;

public class RolePermissionsIdSelecter {

    List<Long> sameRequestIdAndInDatabaseIds;
    List<Long> deleteIds;
    List<Long> saveIds;

    public RolePermissionsIdSelecter(List<RolePermission> dbPermissionIds, List<Long> requestPermissionIds) {
        List<Long> permissionId = CollectionToMap.convertRolePermissionPermissionIdsToList(dbPermissionIds);
        this.sameRequestIdAndInDatabaseIds = OperationsOfTwoLists.getListsUnio(requestPermissionIds, permissionId);
        this.deleteIds = OperationsOfTwoLists.getADifferenceB(permissionId, sameRequestIdAndInDatabaseIds);
        this.saveIds = OperationsOfTwoLists.getADifferenceB(requestPermissionIds, sameRequestIdAndInDatabaseIds);
    }

    public List<Long> getSameRequestIdAndInDatabaseIds() {
        return sameRequestIdAndInDatabaseIds;
    }

    public List<Long> getDeleteIds() {
        return deleteIds;
    }

    public List<Long> getSaveIds() {
        return saveIds;
    }
    
    

}
