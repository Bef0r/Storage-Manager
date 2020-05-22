/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.storage.repositories.entities;

import com.storage.repositories.entities.enums.Materials;
import com.storage.repositories.entities.enums.Shapes;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Collection;
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
@Table(name = "workpieces")
public class Workpiece implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="WORKPIECES_ID_GENERATOR", sequenceName="SEQ_WORKPIECES")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WORKPIECES_ID_GENERATOR")
    @Column(name = "id")
    private Long id;
    
    @Column(name = "width")
    private Integer width;
    
    @Column(name = "depth")
    private Integer depth;
    
    @Column(name = "lenght")
    private Integer lenght;
    
    @Column(name = "external_diameter")
    private Integer externalDiameter;
    
    @Column(name = "internal_diameter")
    private Integer internalDiameter;
    
    @Column(name = "material")
    @Enumerated(EnumType.STRING)
    private Materials material;
    
    @Column(name = "shape")
    @Enumerated(EnumType.STRING)
    private Shapes shape;
    
    @Column(name = "reserved_date")
    private ZonedDateTime  reservedDate;
    
    @Column(name = "under_order")
    private Boolean underOrder;
    
    @Column(name = "order_date")
    private ZonedDateTime  orderDate;
    
    @ManyToOne
    @JoinColumn(name = "reserved_user_id")
    private User reservedUser;
    
    @JoinColumn(name = "order_user_id")
    @ManyToOne
    private User orderUser;
    
    @OneToMany(mappedBy = "workpiece")
    private Collection<Blueprint> blueprints;
    
    @OneToMany(mappedBy = "workpiece")
    private Collection<Location> locations;

    public Workpiece() {
    }

    public Workpiece(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public Integer getLenght() {
        return lenght;
    }

    public void setLenght(Integer lenght) {
        this.lenght = lenght;
    }

    public Integer getExternalDiameter() {
        return externalDiameter;
    }

    public void setExternalDiameter(Integer externalDiameter) {
        this.externalDiameter = externalDiameter;
    }

    public Integer getInternalDiameter() {
        return internalDiameter;
    }

    public void setInternalDiameter(Integer internalDiameter) {
        this.internalDiameter = internalDiameter;
    }

    public Materials getMaterial() {
        return material;
    }

    public void setMaterial(Materials material) {
        this.material = material;
    }

    public Shapes getShape() {
        return shape;
    }

    public void setShape(Shapes shape) {
        this.shape = shape;
    }

    public ZonedDateTime  getReservedDate() {
        return reservedDate;
    }

    public void setReservedDate(ZonedDateTime  reservedDate) {
        this.reservedDate = reservedDate;
    }

    public Boolean getUnderOrder() {
        return underOrder;
    }

    public void setUnderOrder(Boolean underOrder) {
        this.underOrder = underOrder;
    }

    public ZonedDateTime  getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(ZonedDateTime  orderDate) {
        this.orderDate = orderDate;
    }

    public User getReservedUser() {
        return reservedUser;
    }

    public void setReservedUser(User reservedUser) {
        this.reservedUser = reservedUser;
    }

    public User getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(User orderUser) {
        this.orderUser = orderUser;
    }

    public Collection<Blueprint> getBlueprints() {
        return blueprints;
    }

    public void setBlueprints(Collection<Blueprint> blueprints) {
        this.blueprints = blueprints;
    }

    public Collection<Location> getLocations() {
        return locations;
    }

    public void setLocations(Collection<Location> locations) {
        this.locations = locations;
    }
       
}
