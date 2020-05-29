/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.managers;

import com.storage.api.requests.RoleAndPermission.NewRoleRequest;
import com.storage.api.requests.RoleAndPermission.UpdateRoleRequest;
import com.storage.api.response.RoleAndPermission.DeleteRoleResponse;
import com.storage.api.response.RoleAndPermission.NewRoleResponse;
import com.storage.api.response.RoleAndPermission.RolesAndpermissionsWithIdsResponse;
import com.storage.api.response.RoleAndPermission.RolesPermissionsResponse;
import com.storage.api.response.RoleAndPermission.UpdateRoleResponse;
import com.storage.managers.customClasses.CollectionToMap;
import com.storage.managers.customClasses.RolePermissionsIdSelecter;
import com.storage.managers.exceptions.RoleNameAlreadyExistsException;
import com.storage.managers.exceptions.RoleUpdateCreatedException;
import com.storage.managers.exceptions.RoleUpdateDeleteException;
import com.storage.managers.interfaces.RolePermissionManager;
import com.storage.managers.mappers.RolesAndPermissionsMapper;
import com.storage.repositories.PermissionRepository;
import com.storage.repositories.RolePermissionRepository;
import com.storage.repositories.RoleRepository;
import com.storage.repositories.entities.Permission;
import com.storage.repositories.entities.Role;
import com.storage.repositories.entities.RolePermission;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
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
        List<Role> roles = roleRepository.findAll();
        List<Permission> permissions = permissionRepository.findAll();
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
            throw new EntityNotFoundException();
        } else {
            Map<Long, String> permissions = CollectionToMap.convertCollectionToMap(role.get().getRolePermissions());
            return RolesAndPermissionsMapper.getRolePermissionIdResponse(roleId, permissions);
        }
    }

    @Override
    @Transactional
    public NewRoleResponse createNewRoleWithPermissions(NewRoleRequest newRoleRequest) throws RoleNameAlreadyExistsException {
        Role newRole = RolesAndPermissionsMapper.extractNewRoleNameIntheRequest(newRoleRequest);
        if (roleRepository.existsByRoleName(newRole.getRoleName())) {
            throw new RoleNameAlreadyExistsException();
        } else {
            roleRepository.save(newRole);
            List<RolePermission> newRolePermissions = RolesAndPermissionsMapper.extractRolePermissionsIntheRequest(newRole, newRoleRequest.getPermissionIds());
            rolePermissionRepository.saveAll(newRolePermissions);
            return RolesAndPermissionsMapper.newRoleResponse(newRole, newRolePermissions);
        }

    }

    @Override
    @Transactional
    public UpdateRoleResponse updateRolePermissions(long roleId, UpdateRoleRequest updateRoleRequest) throws RoleUpdateDeleteException, RoleUpdateCreatedException{
        List<RolePermission> rolePermissions = rolePermissionRepository.findAllByRoleId(roleId);
        RolePermissionsIdSelecter selector = new RolePermissionsIdSelecter(rolePermissions, updateRoleRequest.getPermissionIds());
        int deletedRows = deletePermissioRelationships(rolePermissions, selector.getDeleteIds());
        savePermissioRelationships(roleId, selector.getSaveIds());
        return RolesAndPermissionsMapper.updateRoleResponse(selector.getSaveIds(), roleId, selector.getSameRequestIdAndInDatabaseIds(), deletedRows);
    }

    private int deletePermissioRelationships(List<RolePermission> allRolePermissions, List<Long> deletePermissionIds) throws RoleUpdateDeleteException {
        List<RolePermission> rolePermissionsermissions = new LinkedList<>();
        if (deletePermissionIds.size() > 0) {
            rolePermissionsermissions = RolesAndPermissionsMapper.selectionDeleteEntities(allRolePermissions, deletePermissionIds);
            try {
                rolePermissionRepository.deleteAll(rolePermissionsermissions);
            } catch (Exception e) {
                throw new RoleUpdateDeleteException("The api cannot be deleted");
            }
        }
        return rolePermissionsermissions.size();
    }

    private List<RolePermission> savePermissioRelationships(long roleId, List<Long> savePermissionIds) throws RoleUpdateCreatedException {
        List<RolePermission> saveRolePermissions = new LinkedList<>();
        if (savePermissionIds.size() > 0) {
            saveRolePermissions = RolesAndPermissionsMapper.createRolePermissionsMapper(roleId, savePermissionIds);
            try {
                rolePermissionRepository.saveAll(saveRolePermissions);
            } catch (Exception e) {
                throw new RoleUpdateCreatedException("the api cannot be create");
            }

        }
        return saveRolePermissions;
    }

    @Override
    @Transactional
    public DeleteRoleResponse deleteRoleWithPermissions(long roleId) {
        Optional<Role> deleteRole = roleRepository.findById(roleId); //maybe role's permissions mapped to role
        if (!deleteRole.isEmpty()) {
            List<RolePermission> rolePermissionRelationships = rolePermissionRepository.findAllByRoleId(roleId);
            int sizeOfList = rolePermissionRelationships.size();
            if (sizeOfList > 0) {
                rolePermissionRepository.deleteAll(rolePermissionRelationships);
            }
            roleRepository.delete(deleteRole.get());
            return RolesAndPermissionsMapper.deleteRolePermissionsMapper(roleId, sizeOfList);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
