/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.controllers;

import com.storage.api.requests.RoleAndPermission.NewRoleRequest;
import com.storage.api.requests.RoleAndPermission.UpdateRoleRequest;
import com.storage.controllers.exceptions.LanguageAndDescriptionSelector;
import com.storage.controllers.exceptions.exceptionConstans.ExceptionConstans;
import com.storage.managers.exceptions.RoleNameAlreadyExistsException;
import com.storage.managers.interfaces.RolePermissionManager;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/rest/roleandpermission")
public class RoleAndPermissionController {

    @Autowired
    RolePermissionManager rolePermissionManager;

    @GetMapping()
    public ResponseEntity<?> getRolesAndpermissionsWithIdsResponse() {
        return ResponseEntity.ok(rolePermissionManager.getAllRolesAndPermissionsWithIds());
    }

    @GetMapping(path = "/{roleId}")
    public ResponseEntity<?> getRolepermissions(@RequestHeader("accept-language") String language, @PathVariable("roleId") long roleId) {
        try {
            return ResponseEntity.ok(rolePermissionManager.getRolePermissions(roleId));
        } catch (EntityNotFoundException entityException) {
            return ResponseEntity.status(ExceptionConstans.ROLE_DOES_NOT_EXISTS)
                    .body(LanguageAndDescriptionSelector.languageAndDescriptionSelector(language, ExceptionConstans.ROLE_DOES_NOT_EXISTS));
        }
    }

    @PostMapping()
    public ResponseEntity<?> createdNewRole(@RequestHeader("accept-language") String language, @RequestBody NewRoleRequest newRoleRequest) {
        try {
            return ResponseEntity.ok(rolePermissionManager.createNewRoleWithPermissions(newRoleRequest));
        } catch (RoleNameAlreadyExistsException roleNameAlreadyExistsException) {
            return ResponseEntity.status(ExceptionConstans.ROLE_NAME_EXISTS)
                    .body(LanguageAndDescriptionSelector.languageAndDescriptionSelector(language, ExceptionConstans.ROLE_NAME_EXISTS));
        }
    }

    @PutMapping(path = "/{roleId}")
    public ResponseEntity<?> updateRole(@RequestHeader("accept-language") String language, @PathVariable("roleId") long roleId, @RequestBody UpdateRoleRequest updateRoleRequest) {
        try {
            return ResponseEntity.ok(rolePermissionManager.updateRolePermissions(roleId, updateRoleRequest));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(LanguageAndDescriptionSelector.languageAndDescriptionSelector(language, ExceptionConstans.INTERNAL_SERVER_ERROR_ROLE_UPDATE));
        }
    }

    @DeleteMapping(path = "/{roleId}")
    public ResponseEntity<?> deleteRoleWithPermissions(@RequestHeader("accept-language") String language, @PathVariable("roleId") long roleId) {
        try {
            return ResponseEntity.ok(rolePermissionManager.deleteRoleWithPermissions(roleId));
        } catch (EntityNotFoundException entityNotFoundException) {
            return ResponseEntity.status(ExceptionConstans.ROLE_DOES_NOT_EXISTS)
                    .body(LanguageAndDescriptionSelector.languageAndDescriptionSelector(language,ExceptionConstans.ROLE_DOES_NOT_EXISTS));
        }
    }

}
