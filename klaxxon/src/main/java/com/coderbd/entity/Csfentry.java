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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Rajail Islam
 */
@Entity
@Table(name = "csfentry")
public class Csfentry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer cSFEntryID;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cSFEntryID", fetch = FetchType.LAZY)
    private Stakeholderentry stakeholderentry;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cSFEntryID", fetch = FetchType.LAZY)
    private Riskentry riskentry;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cSFEntryID", fetch = FetchType.LAZY)
    private Vulnerabilityentry vulnerabilityentry;
    @JoinColumn(name = "CSFTypeID", referencedColumnName = "CSFTypeID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Csftypes cSFTypeID;
    @JoinColumn(name = "ImpactTypeID", referencedColumnName = "ImpactTypeID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Impacttypes impactTypeID;
    @JoinColumn(name = "RiskImpactTypeID", referencedColumnName = "ImpactTypeID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Impacttypes riskImpactTypeID;
    @JoinColumn(name = "LifeCycleID", referencedColumnName = "LifeCycleID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Lifecycles lifeCycleID;
    @JoinColumn(name = "ProcessTypeID", referencedColumnName = "ProcessTypeID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Processtypes processTypeID;
    @JoinColumn(name = "ServiceTypeID", referencedColumnName = "ServiceTypeID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Servicetypes serviceTypeID;
    @JoinColumn(name = "VBFEntryID", referencedColumnName = "VBFEntryID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vbfentry vBFEntryID;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cSFEntryID", fetch = FetchType.LAZY)
    private Threatsentry threatsentry;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cSFEntryID", fetch = FetchType.LAZY)
    private Collection<Kpis> kpisCollection;

    public Csfentry() {
    }

    public Csfentry(Integer cSFEntryID) {
        this.cSFEntryID = cSFEntryID;
    }

    public Integer getCSFEntryID() {
        return cSFEntryID;
    }

    public void setCSFEntryID(Integer cSFEntryID) {
        this.cSFEntryID = cSFEntryID;
    }

    public Stakeholderentry getStakeholderentry() {
        return stakeholderentry;
    }

    public void setStakeholderentry(Stakeholderentry stakeholderentry) {
        this.stakeholderentry = stakeholderentry;
    }

    public Riskentry getRiskentry() {
        return riskentry;
    }

    public void setRiskentry(Riskentry riskentry) {
        this.riskentry = riskentry;
    }

    public Vulnerabilityentry getVulnerabilityentry() {
        return vulnerabilityentry;
    }

    public void setVulnerabilityentry(Vulnerabilityentry vulnerabilityentry) {
        this.vulnerabilityentry = vulnerabilityentry;
    }

    public Csftypes getCSFTypeID() {
        return cSFTypeID;
    }

    public void setCSFTypeID(Csftypes cSFTypeID) {
        this.cSFTypeID = cSFTypeID;
    }

    public Impacttypes getImpactTypeID() {
        return impactTypeID;
    }

    public void setImpactTypeID(Impacttypes impactTypeID) {
        this.impactTypeID = impactTypeID;
    }

    public Impacttypes getRiskImpactTypeID() {
        return riskImpactTypeID;
    }

    public void setRiskImpactTypeID(Impacttypes riskImpactTypeID) {
        this.riskImpactTypeID = riskImpactTypeID;
    }

    public Lifecycles getLifeCycleID() {
        return lifeCycleID;
    }

    public void setLifeCycleID(Lifecycles lifeCycleID) {
        this.lifeCycleID = lifeCycleID;
    }

    public Processtypes getProcessTypeID() {
        return processTypeID;
    }

    public void setProcessTypeID(Processtypes processTypeID) {
        this.processTypeID = processTypeID;
    }

    public Servicetypes getServiceTypeID() {
        return serviceTypeID;
    }

    public void setServiceTypeID(Servicetypes serviceTypeID) {
        this.serviceTypeID = serviceTypeID;
    }

    public Vbfentry getVBFEntryID() {
        return vBFEntryID;
    }

    public void setVBFEntryID(Vbfentry vBFEntryID) {
        this.vBFEntryID = vBFEntryID;
    }

    public Threatsentry getThreatsentry() {
        return threatsentry;
    }

    public void setThreatsentry(Threatsentry threatsentry) {
        this.threatsentry = threatsentry;
    }

    public Collection<Kpis> getKpisCollection() {
        return kpisCollection;
    }

    public void setKpisCollection(Collection<Kpis> kpisCollection) {
        this.kpisCollection = kpisCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cSFEntryID != null ? cSFEntryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Csfentry)) {
            return false;
        }
        Csfentry other = (Csfentry) object;
        if ((this.cSFEntryID == null && other.cSFEntryID != null) || (this.cSFEntryID != null && !this.cSFEntryID.equals(other.cSFEntryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "klaxxon_reverse_eng.Csfentry[ cSFEntryID=" + cSFEntryID + " ]";
    }
    
}
