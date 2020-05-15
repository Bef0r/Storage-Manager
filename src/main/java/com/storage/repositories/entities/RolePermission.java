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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    
    @JoinColumn(name = "permission_id")
    @ManyToOne()
    private Permission permission;
    
    @JoinColumn(name = "role_id")
    @ManyToOne()
    private Role role;

    public RolePermission() {
    }

    public RolePermission(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
}
