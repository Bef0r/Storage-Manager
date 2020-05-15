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
@Table(name = "locations")
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="LOCATIONS_ID_GENERATOR", sequenceName="SEQ_LOCATIONS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOCATIONS_ID_GENERATOR")
    @Column(name = "id")
    private Long id;
    
    @JoinColumn(name = "floor_id", referencedColumnName = "id")
    @ManyToOne
    private Floor floor;
    
    @JoinColumn(name = "line_id", referencedColumnName = "id")
    @ManyToOne
    private Line line;
    
    @JoinColumn(name = "shelf_id", referencedColumnName = "id")
    @ManyToOne
    private Shelf shelf;
    
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    @ManyToOne
    private Store store;
    
    @JoinColumn(name = "workpiece_id", referencedColumnName = "id")
    @ManyToOne
    private Workpiece workpiece;

    public Location() {
    }

    public Location(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Workpiece getWorkpiece() {
        return workpiece;
    }

    public void setWorkpiece(Workpiece workpiece) {
        this.workpiece = workpiece;
    }
    
}
