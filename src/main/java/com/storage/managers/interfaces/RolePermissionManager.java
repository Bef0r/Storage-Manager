/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.managers.interfaces;

import com.storage.api.requests.RoleAndPermission.NewRoleRequest;
import com.storage.api.requests.RoleAndPermission.UpdateRoleRequest;
import com.storage.api.response.RoleAndPermission.DeleteRoleResponse;
import com.storage.api.response.RoleAndPermission.NewRoleResponse;
import com.storage.api.response.RoleAndPermission.RolesAndpermissionsWithIdsResponse;
import com.storage.api.response.RoleAndPermission.RolesPermissionsResponse;
import com.storage.api.response.RoleAndPermission.UpdateRoleResponse;
import com.storage.managers.exceptions.RoleNameAlreadyExistsException;
import com.storage.managers.exceptions.RoleUpdateCreatedException;
import com.storage.managers.exceptions.RoleUpdateDeleteException;


public interface RolePermissionManager {
    public RolesAndpermissionsWithIdsResponse getAllRolesAndPermissionsWithIds();
    public RolesPermissionsResponse getRolePermissions(long roleId);
    public NewRoleResponse createNewRoleWithPermissions(NewRoleRequest newRoleRequest) throws RoleNameAlreadyExistsException;
    public UpdateRoleResponse updateRolePermissions(long roleId, UpdateRoleRequest updateRoleRequest) throws RoleUpdateDeleteException, RoleUpdateCreatedException;
    public DeleteRoleResponse deleteRoleWithPermissions(long roleId);
}
