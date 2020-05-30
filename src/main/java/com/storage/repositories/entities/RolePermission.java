/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.repositories.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "roles_permissions")
public class RolePermission implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    @SequenceGenerator(name="ROLES_PERMISSIONS_ID_GENERATOR", sequenceName="SEQ_ROLES_PERMISSIONS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLES_PERMISSIONS_ID_GENERATOR")
    private Long id;
    
    @Column(name = "role_id")
    private Long roleId;
    
    @Column(name = "permission_id")
    private Long permissionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    
}
