/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.repositories.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "roles")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="ROLES_ID_GENERATOR", sequenceName="SEQ_ROLES")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLES_ID_GENERATOR")
    @Column(name = "id")
    private Long id;
    
    @Column(name = "role_name")
    private String roleName;
    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
        name = "roles_permissions", 
        joinColumns = @JoinColumn(name = "role_id"), 
        inverseJoinColumns = @JoinColumn(name = "permission_id")) 
    private List<Permission> rolePermissions;
    
    @OneToMany(mappedBy = "role")
    private List<User> users;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Permission> getRolePermissions() {
        return rolePermissions;
    }

    public void setRolePermissions(List<Permission> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }
    
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
