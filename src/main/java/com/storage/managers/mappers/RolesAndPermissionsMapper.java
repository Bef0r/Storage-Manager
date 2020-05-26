/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.managers.mappers;

import com.storage.api.requests.RoleAndPermission.NewRoleRequest;
import com.storage.api.response.RoleAndPermission.DeleteRoleResponse;
import com.storage.api.response.RoleAndPermission.NewRoleResponse;
import com.storage.api.response.RoleAndPermission.RolesAndpermissionsWithIdsResponse;
import com.storage.api.response.RoleAndPermission.RolesPermissionsResponse;
import com.storage.api.response.RoleAndPermission.UpdateRoleResponse;
import com.storage.repositories.entities.Permission;
import com.storage.repositories.entities.Role;
import com.storage.repositories.entities.RolePermission;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RolesAndPermissionsMapper {

    public static Map<Long, String> mappedRolesWithId(List<Role> roles) {

        Map<Long, String> RolesWithIds = new HashMap<>();
        roles.forEach(role -> {
            RolesWithIds.put(role.getId(), role.getRoleName());
        });
        return RolesWithIds;
    }

    public static Map<Long, String> mappedPermissionsWithId(List<Permission> permisssions) {

        Map<Long, String> PermissionsWithIds = new HashMap<>();
        permisssions.forEach(permission -> {
            PermissionsWithIds.put(permission.getId(), permission.getPermissionName());
        });
        return PermissionsWithIds;
    }

    public static RolesAndpermissionsWithIdsResponse mappedRolesAndPermissionToResponse(Map<Long, String> roles, Map<Long, String> permissions) {
        RolesAndpermissionsWithIdsResponse response = new RolesAndpermissionsWithIdsResponse();
        response.setRoles(roles);
        response.setPermissions(permissions);
        return response;
    }

    public static RolesPermissionsResponse getRolePermissionIdResponse(long roleId, Map<Long, String> permissions) {
        RolesPermissionsResponse response = new RolesPermissionsResponse();
        response.setRoleId(roleId);
        response.setRolePermissionIds(permissions.keySet().stream().collect(Collectors.toList()));
        return response;
    }

    public static Role extractNewRoleNameIntheRequest(NewRoleRequest newRoleRequest) {
        Role requestRole = new Role();
        requestRole.setRoleName(newRoleRequest.getRoleName().toUpperCase());
        return requestRole;
    }

    public static List<RolePermission> extractRolePermissionsIntheRequest(Role newRole, List<Long> newRolePermissionIds) {
        List<RolePermission> newRolePermissions = new LinkedList<>();
        newRolePermissionIds.stream().forEach(permissionId -> {
            RolePermission newRolePermission = new RolePermission();
            newRolePermission.setRoleId(newRole.getId());
            newRolePermission.setPermissionId(permissionId);
            newRolePermissions.add(newRolePermission);
        });
        return newRolePermissions;
    }

    public static NewRoleResponse newRoleResponse(Role newRole, List<RolePermission> newRolePermissions) {
        NewRoleResponse response = new NewRoleResponse();
        response.setNewRoleId(newRole.getId());
        response.setNewRoleName(newRole.getRoleName());
        response.setNewRolePermissionIds(extractNewRolePermissionIds(newRolePermissions));
        return response;
    }

    private static List<Long> extractNewRolePermissionIds(List<RolePermission> newRolePermissions) {
        List<Long> permissionIds = new LinkedList<>();
        newRolePermissions.stream().forEach(relationship -> {
            permissionIds.add(relationship.getPermissionId());
        });
        return permissionIds;
    }

    public static List<RolePermission> createRolePermissionsMapper(Long roleId, List<Long> permissionIds) {
        List<RolePermission> relation = new LinkedList<>();
        permissionIds.forEach(permissionId -> {
            RolePermission newRelationship = new RolePermission();
            newRelationship.setRoleId(roleId);
            newRelationship.setPermissionId(permissionId);
            relation.add(newRelationship);
        });
        return relation;
    }

    public static UpdateRoleResponse updateRoleResponse(List<Long> savePermissions, Long roleId, List<Long> sameIds, int deletedRows) {
        UpdateRoleResponse response = new UpdateRoleResponse();
        List<Long> permissionsIds = new LinkedList<>();
        permissionsIds.addAll(savePermissions);
        permissionsIds.addAll(sameIds);
        response.setRoleId(roleId);
        response.setRolePermissionRelationships(permissionsIds);
        response.setNumberOfDeletedRows(deletedRows);
        response.setNumberOfNewRows(savePermissions.size());
        return response;
    }
    
    public static List<RolePermission> selectionDeleteEntities(List<RolePermission> allRolePermissions, List<Long> deletePermissionIds){
        List<RolePermission> rolePermissionsermissions = new LinkedList<>();
        allRolePermissions.forEach(permission -> {
            if(deletePermissionIds.contains(permission.getPermissionId()))
                rolePermissionsermissions.add(permission);
        });
        return rolePermissionsermissions;
    }
    
    public static DeleteRoleResponse deleteRolePermissionsMapper(long roleId, int numberOfDeletedPermissions){
        DeleteRoleResponse response = new DeleteRoleResponse();
        response.setRoleId(roleId);
        response.setNumberOfDeletedPermissions(numberOfDeletedPermissions);
        return response;
    }
}
