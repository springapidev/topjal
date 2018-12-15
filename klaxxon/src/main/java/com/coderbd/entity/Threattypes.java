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
@Table(name = "threat_types")
public class Threattypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer threatTypeID;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String threatType;
    @Column(length = 255)
    private String vulnerabilityReference;
    @Column(length = 255)
    private String threatTypeDuration;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "threatTypeID", fetch = FetchType.LAZY)
    private Collection<Threatsentry> threatsentryCollection;

    public Threattypes() {
    }

    public Threattypes(Integer threatTypeID) {
        this.threatTypeID = threatTypeID;
    }

    public Threattypes(Integer threatTypeID, String threatType) {
        this.threatTypeID = threatTypeID;
        this.threatType = threatType;
    }

    public Integer getThreatTypeID() {
        return threatTypeID;
    }

    public void setThreatTypeID(Integer threatTypeID) {
        this.threatTypeID = threatTypeID;
    }

    public String getThreatType() {
        return threatType;
    }

    public void setThreatType(String threatType) {
        this.threatType = threatType;
    }

    public String getVulnerabilityReference() {
        return vulnerabilityReference;
    }

    public void setVulnerabilityReference(String vulnerabilityReference) {
        this.vulnerabilityReference = vulnerabilityReference;
    }

    public String getThreatTypeDuration() {
        return threatTypeDuration;
    }

    public void setThreatTypeDuration(String threatTypeDuration) {
        this.threatTypeDuration = threatTypeDuration;
    }

    public Collection<Threatsentry> getThreatsentryCollection() {
        return threatsentryCollection;
    }

    public void setThreatsentryCollection(Collection<Threatsentry> threatsentryCollection) {
        this.threatsentryCollection = threatsentryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (threatTypeID != null ? threatTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Threattypes)) {
            return false;
        }
        Threattypes other = (Threattypes) object;
        if ((this.threatTypeID == null && other.threatTypeID != null) || (this.threatTypeID != null && !this.threatTypeID.equals(other.threatTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "klaxxon_reverse_eng.Threattypes[ threatTypeID=" + threatTypeID + " ]";
    }
    
}
