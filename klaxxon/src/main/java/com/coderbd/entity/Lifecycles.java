/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Rajail Islam
 */
@Entity
@Table(name = "life_cycles")
public class Lifecycles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer lifeCycleID;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String lifeCycle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lifeCycleID", fetch = FetchType.LAZY)
    private Collection<Vulnerabilitytypes> vulnerabilitytypesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lifeCycleID", fetch = FetchType.LAZY)
    private Collection<Csfentry> csfentryCollection;

    public Lifecycles() {
    }

    public Lifecycles(Integer lifeCycleID) {
        this.lifeCycleID = lifeCycleID;
    }

    public Lifecycles(Integer lifeCycleID, String lifeCycle) {
        this.lifeCycleID = lifeCycleID;
        this.lifeCycle = lifeCycle;
    }

    public Integer getLifeCycleID() {
        return lifeCycleID;
    }

    public void setLifeCycleID(Integer lifeCycleID) {
        this.lifeCycleID = lifeCycleID;
    }

    public String getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(String lifeCycle) {
        this.lifeCycle = lifeCycle;
    }

    public Collection<Vulnerabilitytypes> getVulnerabilitytypesCollection() {
        return vulnerabilitytypesCollection;
    }

    public void setVulnerabilitytypesCollection(Collection<Vulnerabilitytypes> vulnerabilitytypesCollection) {
        this.vulnerabilitytypesCollection = vulnerabilitytypesCollection;
    }

    public Collection<Csfentry> getCsfentryCollection() {
        return csfentryCollection;
    }

    public void setCsfentryCollection(Collection<Csfentry> csfentryCollection) {
        this.csfentryCollection = csfentryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lifeCycleID != null ? lifeCycleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lifecycles)) {
            return false;
        }
        Lifecycles other = (Lifecycles) object;
        if ((this.lifeCycleID == null && other.lifeCycleID != null) || (this.lifeCycleID != null && !this.lifeCycleID.equals(other.lifeCycleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "klaxxon_reverse_eng.Lifecycles[ lifeCycleID=" + lifeCycleID + " ]";
    }
    
}
