/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "arms_types")
public class Armstypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer aRMSTypeID;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String aRMSType;
    @OneToMany(mappedBy = "aRMSTypeID", fetch = FetchType.LAZY)
    private Collection<Riskentry> riskentryCollection;

    public Armstypes() {
    }

    public Armstypes(Integer aRMSTypeID) {
        this.aRMSTypeID = aRMSTypeID;
    }

    public Armstypes(Integer aRMSTypeID, String aRMSType) {
        this.aRMSTypeID = aRMSTypeID;
        this.aRMSType = aRMSType;
    }

    public Integer getARMSTypeID() {
        return aRMSTypeID;
    }

    public void setARMSTypeID(Integer aRMSTypeID) {
        this.aRMSTypeID = aRMSTypeID;
    }

    public String getARMSType() {
        return aRMSType;
    }

    public void setARMSType(String aRMSType) {
        this.aRMSType = aRMSType;
    }

    public Collection<Riskentry> getRiskentryCollection() {
        return riskentryCollection;
    }

    public void setRiskentryCollection(Collection<Riskentry> riskentryCollection) {
        this.riskentryCollection = riskentryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aRMSTypeID != null ? aRMSTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Armstypes)) {
            return false;
        }
        Armstypes other = (Armstypes) object;
        if ((this.aRMSTypeID == null && other.aRMSTypeID != null) || (this.aRMSTypeID != null && !this.aRMSTypeID.equals(other.aRMSTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "klaxxon_reverse_eng.Armstypes[ aRMSTypeID=" + aRMSTypeID + " ]";
    }
    
}
