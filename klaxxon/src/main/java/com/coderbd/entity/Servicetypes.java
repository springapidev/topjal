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
@Table(name = "service_types")
public class Servicetypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer serviceTypeID;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String serviceType;
    @Basic(optional = false)
    @Column(nullable = false)
    private int weigh;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceTypeID", fetch = FetchType.LAZY)
    private Collection<Csfentry> csfentryCollection;

    public Servicetypes() {
    }

    public Servicetypes(Integer serviceTypeID) {
        this.serviceTypeID = serviceTypeID;
    }

    public Servicetypes(Integer serviceTypeID, String serviceType, int weigh) {
        this.serviceTypeID = serviceTypeID;
        this.serviceType = serviceType;
        this.weigh = weigh;
    }

    public Integer getServiceTypeID() {
        return serviceTypeID;
    }

    public void setServiceTypeID(Integer serviceTypeID) {
        this.serviceTypeID = serviceTypeID;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public int getWeigh() {
        return weigh;
    }

    public void setWeigh(int weigh) {
        this.weigh = weigh;
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
        hash += (serviceTypeID != null ? serviceTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicetypes)) {
            return false;
        }
        Servicetypes other = (Servicetypes) object;
        if ((this.serviceTypeID == null && other.serviceTypeID != null) || (this.serviceTypeID != null && !this.serviceTypeID.equals(other.serviceTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "klaxxon_reverse_eng.Servicetypes[ serviceTypeID=" + serviceTypeID + " ]";
    }
    
}
