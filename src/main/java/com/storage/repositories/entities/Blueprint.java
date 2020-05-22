package com.storage.repositories.entities;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Random;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "blueprints")
public class Blueprint implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="BLUEPRINTS_ID_GENERATOR", sequenceName="SEQ_BLUEPRINTS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BLUEPRINTS_ID_GENERATOR")
    @Column(name = "id")
    private String id;
    
    @Column(name = "created_date")
    private ZonedDateTime  createdDate;
    
    @Column(name = "last_updated_date")
    private ZonedDateTime  lastUpdatedDate;
    
    @JoinColumn(name = "desinger_id")
    @OneToOne
    private User desinger;
    
    @JoinColumn(name = "last_updater_id")
    @OneToOne
    private User lastUpdater;
    
    @JoinColumn(name = "workpiece_id")
    @ManyToOne
    private Workpiece workpiece;

    public Blueprint() {
    }

    public Blueprint(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ZonedDateTime  getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime  createdDate) {
        this.createdDate = createdDate;
    }

    public ZonedDateTime  getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(ZonedDateTime  lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public User getDesinger() {
        return desinger;
    }

    public void setDesinger(User desinger) {
        this.desinger = desinger;
    }

    public User getLastUpdater() {
        return lastUpdater;
    }

    public void setLastUpdater(User lastUpdater) {
        this.lastUpdater = lastUpdater;
    }

    public Workpiece getWorkpiece() {
        return workpiece;
    }

    public void setWorkpiece(Workpiece workpiece) {
        this.workpiece = workpiece;
    }
    
        public String generateWorkpieceIdOnlyTest(){
        Random random = new Random();
        String generatedString = "BLUEPRINT_";
        for (int i = 0; i < 10; i++) {
            generatedString= generatedString + random.nextInt(9);
        }
        return generatedString;
    }
}
