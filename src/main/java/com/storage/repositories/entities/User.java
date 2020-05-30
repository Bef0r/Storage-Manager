/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.repositories.entities;

import com.storage.repositories.entities.enums.Languages;
import com.storage.repositories.entities.enums.Units;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="USERS_ID_GENERATOR", sequenceName="SEQ_USERS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERS_ID_GENERATOR")
    @Column(name = "id")
    private Long id;
    
    @Column(name = "user_name")
    private String userName;
    
    @Column(name = "pwd")
    private String pwd;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "language")
    @Enumerated(EnumType.STRING)
    private Languages language;

    @Column(name = "unit")
    @Enumerated(EnumType.STRING)
    private Units unit;
    
    @Column(name = "dark_mode")
    private Boolean darkMode;
    
    @OneToMany(mappedBy = "orderUser")
    private List<Workpiece> orderWorkpieces;
    
    @OneToMany(mappedBy = "reservedUser")
    private List<Workpiece> reservedWorkpieces;
    
    @Column(name = "role_id")
    private Long role;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Languages getLanguage() {
        return language;
    }

    public void setLanguage(Languages language) {
        this.language = language;
    }

    public Units getUnit() {
        return unit;
    }

    public void setUnit(Units unit) {
        this.unit = unit;
    }

    public Boolean getDarkMode() {
        return darkMode;
    }

    public void setDarkMode(Boolean darkMode) {
        this.darkMode = darkMode;
    }

    public List<Workpiece> getReservedWorkpieces() {
        return reservedWorkpieces;
    }

    public void setReservedWorkpieces(List<Workpiece> reservedWorkpieces) {
        this.reservedWorkpieces = reservedWorkpieces;
    }
    
    public List<Workpiece> getOrderWorkpieces() {
        return orderWorkpieces;
    }

    public void setOrderWorkpieces(List<Workpiece> orderWorkpieces) {
        this.orderWorkpieces = orderWorkpieces;
    }

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }
    
}
