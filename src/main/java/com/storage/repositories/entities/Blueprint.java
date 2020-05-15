package com.storage.repositories.entities;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "blueprints")
public class Blueprint implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="BLUEPRINTS_ID_GENERATOR", sequenceName="SEQ_BLUEPRINTS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BLUEPRINTS_ID_GENERATOR")
    @Column(name = "id")
    private String id;
    
    @Column(name = "created_date")
    private Date createdDate;
    
    @Column(name = "last_updated_date")
    private Date lastUpdatedDate;
    
    @JoinColumn(name = "desinger_id")
    @ManyToOne
    private User desinger;
    
    @JoinColumn(name = "last_updater_id")
    @ManyToOne
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
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
    
}
