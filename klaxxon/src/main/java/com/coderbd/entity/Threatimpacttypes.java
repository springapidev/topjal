/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Rajail Islam
 */
@Entity
@Table(name = "threat_impact_types")
public class Threatimpacttypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer impactTypeID;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String impact;
    @Basic(optional = false)
    @Column(nullable = false)
    private int weight;

    public Threatimpacttypes() {
    }

    public Threatimpacttypes(Integer impactTypeID) {
        this.impactTypeID = impactTypeID;
    }

    public Threatimpacttypes(Integer impactTypeID, String impact, int weight) {
        this.impactTypeID = impactTypeID;
        this.impact = impact;
        this.weight = weight;
    }

    public Integer getImpactTypeID() {
        return impactTypeID;
    }

    public void setImpactTypeID(Integer impactTypeID) {
        this.impactTypeID = impactTypeID;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (impactTypeID != null ? impactTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Threatimpacttypes)) {
            return false;
        }
        Threatimpacttypes other = (Threatimpacttypes) object;
        if ((this.impactTypeID == null && other.impactTypeID != null) || (this.impactTypeID != null && !this.impactTypeID.equals(other.impactTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "klaxxon_reverse_eng.Threatimpacttypes[ impactTypeID=" + impactTypeID + " ]";
    }
    
}
