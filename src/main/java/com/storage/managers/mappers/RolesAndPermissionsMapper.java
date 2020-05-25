/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.managers.mappers;

import com.storage.api.requests.RoleAndPermission.NewRoleRequest;
import com.storage.api.response.RoleAndPermission.NewRoleResponse;
import com.storage.api.response.RoleAndPermission.RolesAndpermissionsWithIdsResponse;
import com.storage.api.response.RoleAndPermission.RolesPermissionsResponse;
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
    
    public static Role extractNewRoleNameIntheRequest(NewRoleRequest newRoleRequest){
        Role requestRole = new Role();
        requestRole.setRoleName(newRoleRequest.getRoleName().toUpperCase());
        return requestRole;
    }
    
    public static  List<RolePermission> extractRolePermissionsIntheRequest(Role newRole, NewRoleRequest newRoleRequest){
        List<RolePermission> newRolePermissions = new LinkedList<>(); 
        newRoleRequest.getPermissionIds().stream().forEach(permissionId->{
            RolePermission newRolePermission = new RolePermission();
            newRolePermission.setRoleId(newRole.getId());
            newRolePermission.setPermissionId(permissionId);
            newRolePermissions.add(newRolePermission);
        });
        return newRolePermissions;
    }
    
    public static NewRoleResponse newRoleResponse(Role newRole,  List<RolePermission> newRolePermissions){
        NewRoleResponse response = new NewRoleResponse();
        response.setNewRoleId(newRole.getId());
        response.setNewRoleName(newRole.getRoleName());
        response.setNewRolePermissionIds(extractNewRolePermissionIds(newRolePermissions));
        return response;
    }
    
    private static List<Long> extractNewRolePermissionIds(List<RolePermission> newRolePermissions){
        List<Long> permissionIds = new LinkedList<>();
        newRolePermissions.stream().forEach(relationship->{
            permissionIds.add(relationship.getPermissionId());
        });
        return permissionIds;
    }
}
