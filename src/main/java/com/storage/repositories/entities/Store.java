/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.repositories.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "stores")
public class Store implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="STORES_ID_GENERATOR", sequenceName="SEQ_STORES")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STORES_ID_GENERATOR")
    @Column(name = "id")
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "location")
    private String location;
    
    @Column(name = "mobile")
    private String mobile;
    
    @OneToMany(mappedBy = "store")
    private Collection<Location> locations;

    public Store() {
    }

    public Store(Long id) {
        this.id = id;
    }

    public Store(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Collection<Location> getLocations() {
        return locations;
    }

    public void setLocations(Collection<Location> locations) {
        this.locations = locations;
    }
    
}