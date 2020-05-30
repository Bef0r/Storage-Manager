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
import com.storage.managers.exceptions.RoleUpdateCreatedException;
import com.storage.managers.exceptions.RoleUpdateDeleteException;
import com.storage.managers.interfaces.RolePermissionManager;
import javax.persistence.EntityNotFoundException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
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

    private static final Logger logger = LogManager.getLogger(RoleAndPermissionController.class);

    @Autowired
    RolePermissionManager rolePermissionManager;

    @GetMapping()
    public ResponseEntity<?> getRolesAndpermissionsWithIdsResponse() {
        try {
            return ResponseEntity.ok(rolePermissionManager.getAllRolesAndPermissionsWithIds());
        } catch (Exception e) {
            logger.error("getRolesAndpermissionsWithIdsResponse" + "    " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ExceptionConstans.DEFAULT_EXCEPTON_MESSAGE);
        }
    }

    @GetMapping(path = "/{roleId}")
    public ResponseEntity<?> getRolepermissions(@RequestHeader("accept-language") String language, @PathVariable("roleId") long roleId) {
        try {
            return ResponseEntity.ok(rolePermissionManager.getRolePermissions(roleId));
        } catch (EntityNotFoundException entityException) {
            logger.warn(ExceptionConstans.ROLE_DOES_NOT_EXISTS + "    " + ExceptionConstans.ROLE_DOES_NOT_EXISTS);
            return ResponseEntity.status(ExceptionConstans.ROLE_DOES_NOT_EXISTS)
                    .body(LanguageAndDescriptionSelector.languageAndDescriptionSelector(language, ExceptionConstans.ROLE_DOES_NOT_EXISTS));
        } catch (Exception e) {
            logger.error("getRolepermissions" + "    " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ExceptionConstans.DEFAULT_EXCEPTON_MESSAGE);
        }
    }

    @PostMapping()
    public ResponseEntity<?> createdNewRole(@RequestHeader("accept-language") String language, @RequestBody NewRoleRequest newRoleRequest) {
        try {
            return ResponseEntity.ok(rolePermissionManager.createNewRoleWithPermissions(newRoleRequest));
        } catch (RoleNameAlreadyExistsException roleNameAlreadyExistsException) {
            logger.warn(ExceptionConstans.ROLE_NAME_EXISTS + "    " + roleNameAlreadyExistsException);
            return ResponseEntity.status(ExceptionConstans.ROLE_NAME_EXISTS)
                    .body(LanguageAndDescriptionSelector.languageAndDescriptionSelector(language, ExceptionConstans.ROLE_NAME_EXISTS));
        } catch (Exception e) {
            logger.error("createdNewRole" + "    " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ExceptionConstans.DEFAULT_EXCEPTON_MESSAGE);
        }
    }

    @PutMapping(path = "/{roleId}")
    public ResponseEntity<?> updateRole(@RequestHeader("accept-language") String language, @PathVariable("roleId") long roleId, @RequestBody UpdateRoleRequest updateRoleRequest) {
        try {
            return ResponseEntity.ok(rolePermissionManager.updateRolePermissions(roleId, updateRoleRequest));
        } catch (RoleUpdateCreatedException e) {
            logger.warn(ExceptionConstans.ROLE_UPDATE_CREATE_ERROR + " " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(LanguageAndDescriptionSelector.languageAndDescriptionSelector(language, ExceptionConstans.INTERNAL_SERVER_ERROR_ROLE_UPDATE));
        } catch (RoleUpdateDeleteException e) {
            logger.warn(ExceptionConstans.ROLE_UPDATE_DELETE_ERROR + "    " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(LanguageAndDescriptionSelector.languageAndDescriptionSelector(language, ExceptionConstans.INTERNAL_SERVER_ERROR_ROLE_UPDATE));
        } catch (Exception e) {
            logger.error("updateRole" + "    " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ExceptionConstans.DEFAULT_EXCEPTON_MESSAGE);
        }
    }

    @DeleteMapping(path = "/{roleId}")
    public ResponseEntity<?> deleteRoleWithPermissions(@RequestHeader("accept-language") String language, @PathVariable("roleId") long roleId) {
        try {
            return ResponseEntity.ok(rolePermissionManager.deleteRoleWithPermissions(roleId));
        } catch (EntityNotFoundException entityNotFoundException) {
            logger.warn(ExceptionConstans.ROLE_DOES_NOT_EXISTS + "    " + entityNotFoundException);
            return ResponseEntity.status(ExceptionConstans.ROLE_DOES_NOT_EXISTS)
                    .body(LanguageAndDescriptionSelector.languageAndDescriptionSelector(language, ExceptionConstans.ROLE_DOES_NOT_EXISTS));
        } catch (Exception e) {
            logger.error("deleteRoleWithPermissions" + "    " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ExceptionConstans.DEFAULT_EXCEPTON_MESSAGE);
        }
    }

}
