/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.repositories.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "permissions")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="PERMISSIONS_ID_GENERATOR", sequenceName="SEQ_PERMISSIONS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERMISSIONS_ID_GENERATOR")
    @Column(name = "id")
    private Long id;
    
    @Column(name = "permission_name")
    private String permissionName;
    
    @OneToMany(mappedBy = "permission")
    private Collection<RolePermission> rolePermissions;

    public Permission() {
    }

    public Permission(Long id) {
        this.id = id;
    }

    public Permission(Long id, String permissionName) {
        this.id = id;
        this.permissionName = permissionName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Collection<RolePermission> getRolePermissions() {
        return rolePermissions;
    }

    public void setRolePermissions(Collection<RolePermission> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }
    
}
