/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.managers;

import com.storage.api.requests.RoleAndPermission.NewRoleRequest;
import com.storage.api.requests.RoleAndPermission.UpdateRoleRequest;
import com.storage.api.response.RoleAndPermission.NewRoleResponse;
import com.storage.api.response.RoleAndPermission.RolesAndpermissionsWithIdsResponse;
import com.storage.api.response.RoleAndPermission.RolesPermissionsResponse;
import com.storage.api.response.RoleAndPermission.UpdateRoleResponse;
import com.storage.managers.customClasses.CollectionToMap;
import com.storage.managers.customClasses.OperationsOfTwoLists;
import com.storage.managers.customClasses.RolePermissionsIdSelecter;
import com.storage.managers.interfaces.RolePermissionManager;
import com.storage.managers.mappers.RolesAndPermissionsMapper;
import com.storage.repositories.PermissionRepository;
import com.storage.repositories.RolePermissionRepository;
import com.storage.repositories.RoleRepository;
import com.storage.repositories.entities.Permission;
import com.storage.repositories.entities.Role;
import com.storage.repositories.entities.RolePermission;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RolePermissionManagerImp implements RolePermissionManager {

    RoleRepository roleRepository;
    PermissionRepository permissionRepository;
    RolePermissionRepository rolePermissionRepository;

    @Autowired
    public RolePermissionManagerImp(RoleRepository roleRepository, PermissionRepository permissionRepository, RolePermissionRepository rolePermissionRepository) {
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
        this.rolePermissionRepository = rolePermissionRepository;
    }

    @Override
    public RolesAndpermissionsWithIdsResponse getAllRolesAndPermissionsWithIds() {
        List<Role> roles = (List<Role>) roleRepository.findAll();
        List<Permission> permissions = (List<Permission>) permissionRepository.findAll();
        RolesAndpermissionsWithIdsResponse response = mappedGetAllRolesAndPermissionsWithIdsResponse(roles, permissions);
        return response;
    }

    private RolesAndpermissionsWithIdsResponse mappedGetAllRolesAndPermissionsWithIdsResponse(List<Role> roles, List<Permission> permissions) {
        Map<Long, String> mappedRoles = RolesAndPermissionsMapper.mappedRolesWithId(roles);
        Map<Long, String> mappedPermissions = RolesAndPermissionsMapper.mappedPermissionsWithId(permissions);
        return RolesAndPermissionsMapper.mappedRolesAndPermissionToResponse(mappedRoles, mappedPermissions);
    }

    @Override
    public RolesPermissionsResponse getRolePermissions(long roleId) {
        Optional<Role> role = roleRepository.findById(roleId);
        if (role.isEmpty()) {
            return null; // http status code
        } else {
            Map<Long, String> permissions = CollectionToMap.convertCollectionToMap(role.get().getRolePermissions());
            return RolesAndPermissionsMapper.getRolePermissionIdResponse(roleId, permissions);
        }
    }

    @Override
    public NewRoleResponse createNewRoleWithPermissions(NewRoleRequest newRoleRequest) {
        Role newRole = RolesAndPermissionsMapper.extractNewRoleNameIntheRequest(newRoleRequest);
        if (roleRepository.existsByRoleName(newRole.getRoleName())) {
            return null; // http status code
        } else {
            roleRepository.save(newRole);
            List<RolePermission> newRolePermissions = RolesAndPermissionsMapper.extractRolePermissionsIntheRequest(newRole, newRoleRequest.getPermissionIds());
            rolePermissionRepository.saveAll(newRolePermissions);
            return RolesAndPermissionsMapper.newRoleResponse(newRole, newRolePermissions);
        }

    }

    @Override
    public UpdateRoleResponse updateRolePermissions(long roleId, UpdateRoleRequest updateRoleRequest) {
        List<RolePermission> rolePermissions = rolePermissionRepository.findAllByRoleId(roleId);
        if (rolePermissions.isEmpty()) {
            return null; // http status code
        } else {
            RolePermissionsIdSelecter selector = new RolePermissionsIdSelecter(rolePermissions, updateRoleRequest.getPermissionIds());
            int deletedRows = deletePermissioRelationships(rolePermissions, selector.getDeleteIds());
            savePermissioRelationships(roleId, selector.getSaveIds());
            return RolesAndPermissionsMapper.updateRoleResponse(selector.getSaveIds(), roleId, selector.getSameRequestIdAndInDatabaseIds(), deletedRows);
        }
    }

    private int deletePermissioRelationships(List<RolePermission> allRolePermissions, List<Long> deletePermissionIds) {
        List<RolePermission> rolePermissionsermissions = new LinkedList<>();
        if (deletePermissionIds.size()>0) {
            rolePermissionsermissions = RolesAndPermissionsMapper.selectionDeleteEntities(allRolePermissions, deletePermissionIds);
            rolePermissionRepository.deleteAll(rolePermissionsermissions);
        }
        return rolePermissionsermissions.size();
    }

    private List<RolePermission> savePermissioRelationships(long roleId, List<Long> savePermissionIds) {
        List<RolePermission> saveRolePermissions = new LinkedList<>();
        if (savePermissionIds.size()>0) {
            saveRolePermissions = RolesAndPermissionsMapper.createRolePermissionsMapper(roleId, savePermissionIds);
            rolePermissionRepository.saveAll(saveRolePermissions);
        }
        return saveRolePermissions;
    }
}
