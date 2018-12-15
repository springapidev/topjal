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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Rajail Islam
 */
@Entity
@Table(name = "klaxxon_old",  uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CSFEntryID"})})
public class Threatsentry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer threatsEntryID;
    @JoinColumn(name = "CSFEntryID", referencedColumnName = "CSFEntryID", nullable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Csfentry cSFEntryID;
    @JoinColumn(name = "ThreatIikelihoodTypeID", referencedColumnName = "ImpactTypeID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Impacttypes threatIikelihoodTypeID;
    @JoinColumn(name = "ThreatImpactTypeID", referencedColumnName = "ImpactTypeID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Impacttypes threatImpactTypeID;
    @JoinColumn(name = "RateOccurenceID", referencedColumnName = "RateOccurenceID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Rateoccurences rateOccurenceID;
    @JoinColumn(name = "ThreatTypeID", referencedColumnName = "ThreatTypeID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Threattypes threatTypeID;

    public Threatsentry() {
    }

    public Threatsentry(Integer threatsEntryID) {
        this.threatsEntryID = threatsEntryID;
    }

    public Integer getThreatsEntryID() {
        return threatsEntryID;
    }

    public void setThreatsEntryID(Integer threatsEntryID) {
        this.threatsEntryID = threatsEntryID;
    }

    public Csfentry getCSFEntryID() {
        return cSFEntryID;
    }

    public void setCSFEntryID(Csfentry cSFEntryID) {
        this.cSFEntryID = cSFEntryID;
    }

    public Impacttypes getThreatIikelihoodTypeID() {
        return threatIikelihoodTypeID;
    }

    public void setThreatIikelihoodTypeID(Impacttypes threatIikelihoodTypeID) {
        this.threatIikelihoodTypeID = threatIikelihoodTypeID;
    }

    public Impacttypes getThreatImpactTypeID() {
        return threatImpactTypeID;
    }

    public void setThreatImpactTypeID(Impacttypes threatImpactTypeID) {
        this.threatImpactTypeID = threatImpactTypeID;
    }

    public Rateoccurences getRateOccurenceID() {
        return rateOccurenceID;
    }

    public void setRateOccurenceID(Rateoccurences rateOccurenceID) {
        this.rateOccurenceID = rateOccurenceID;
    }

    public Threattypes getThreatTypeID() {
        return threatTypeID;
    }

    public void setThreatTypeID(Threattypes threatTypeID) {
        this.threatTypeID = threatTypeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (threatsEntryID != null ? threatsEntryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Threatsentry)) {
            return false;
        }
        Threatsentry other = (Threatsentry) object;
        if ((this.threatsEntryID == null && other.threatsEntryID != null) || (this.threatsEntryID != null && !this.threatsEntryID.equals(other.threatsEntryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "klaxxon_reverse_eng.Threatsentry[ threatsEntryID=" + threatsEntryID + " ]";
    }
    
}
