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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Rajaul Islam
 */
@Entity
@Table(name = "process_types", schema = "")
public class Processtypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long processTypeID;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String processType;

    @JoinTable(name = "processtypestakeholdertypes", joinColumns = {
        @JoinColumn(name = "ProcessTypeID", referencedColumnName = "ProcessTypeID", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "StakeholderTypeID", referencedColumnName = "StakeholderTypeID", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Stakeholdertypes> stakeholdertypesCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "processTypeID", fetch = FetchType.LAZY)
    private Collection<Csftypes> csftypesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "processTypeID", fetch = FetchType.LAZY)
    private Collection<Csfentry> csfentryCollection;

    public Processtypes() {
    }

    public Long getProcessTypeID() {
        return processTypeID;
    }

    public void setProcessTypeID(Long processTypeID) {
        this.processTypeID = processTypeID;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public Collection<Stakeholdertypes> getStakeholdertypesCollection() {
        return stakeholdertypesCollection;
    }

    public void setStakeholdertypesCollection(Collection<Stakeholdertypes> stakeholdertypesCollection) {
        this.stakeholdertypesCollection = stakeholdertypesCollection;
    }

    public Collection<Csftypes> getCsftypesCollection() {
        return csftypesCollection;
    }

    public void setCsftypesCollection(Collection<Csftypes> csftypesCollection) {
        this.csftypesCollection = csftypesCollection;
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
        hash += (processTypeID != null ? processTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Processtypes)) {
            return false;
        }
        Processtypes other = (Processtypes) object;
        if ((this.processTypeID == null && other.processTypeID != null) || (this.processTypeID != null && !this.processTypeID.equals(other.processTypeID))) {
            return false;
        }
        return true;
    }


    
}
