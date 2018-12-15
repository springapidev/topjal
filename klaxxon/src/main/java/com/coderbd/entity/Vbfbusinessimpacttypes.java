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
import javax.persistence.Table;

/**
 *
 * @author Rajaul Islam
 */
@Entity
@Table(name = "vbf_business_impact_types")
public class Vbfbusinessimpacttypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long impactTypeID;
    @Basic(optional = false)
    @Column(nullable = false, length = 255,unique = true)
    private String impact;
    @Basic(optional = false)
    @Column(nullable = false)
    private int weight;

    public Vbfbusinessimpacttypes() {
    }

    public Long getImpactTypeID() {
        return impactTypeID;
    }

    public void setImpactTypeID(Long impactTypeID) {
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

        if (!(object instanceof Vbfbusinessimpacttypes)) {
            return false;
        }
        Vbfbusinessimpacttypes other = (Vbfbusinessimpacttypes) object;
        if ((this.impactTypeID == null && other.impactTypeID != null) || (this.impactTypeID != null && !this.impactTypeID.equals(other.impactTypeID))) {
            return false;
        }
        return true;
    }


}
