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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Rajail Islam
 */
@Entity
@Table(name = "csf_types")
public class Csftypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long cSFTypeID;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String cSFType;
    @JoinColumn(name = "ProcessTypeID",  nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Processtypes processTypeID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cSFTypeID", fetch = FetchType.LAZY)
    private Collection<Csfentry> csfentryCollection;

    public Csftypes() {
    }



    public String getCSFType() {
        return cSFType;
    }

    public void setCSFType(String cSFType) {
        this.cSFType = cSFType;
    }

    public Processtypes getProcessTypeID() {
        return processTypeID;
    }

    public void setProcessTypeID(Processtypes processTypeID) {
        this.processTypeID = processTypeID;
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
        hash += (cSFTypeID != null ? cSFTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Csftypes)) {
            return false;
        }
        Csftypes other = (Csftypes) object;
        if ((this.cSFTypeID == null && other.cSFTypeID != null) || (this.cSFTypeID != null && !this.cSFTypeID.equals(other.cSFTypeID))) {
            return false;
        }
        return true;
    }

    public Long getcSFTypeID() {
        return cSFTypeID;
    }

    public void setcSFTypeID(Long cSFTypeID) {
        this.cSFTypeID = cSFTypeID;
    }

    public String getcSFType() {
        return cSFType;
    }

    public void setcSFType(String cSFType) {
        this.cSFType = cSFType;
    }

    @Override
    public String toString() {
        return "Csftypes{" +
                "cSFTypeID=" + cSFTypeID +
                ", cSFType='" + cSFType + '\'' +
                ", processTypeID=" + processTypeID +
                ", csfentryCollection=" + csfentryCollection +
                '}';
    }
}
