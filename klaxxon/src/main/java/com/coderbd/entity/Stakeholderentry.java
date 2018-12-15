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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Rajaul Islam
 */
@Entity
@Table(name = "stake_holder_entry", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CSFEntryID"})})
public class Stakeholderentry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long stakeholderEntryID;
    @JoinColumn(name = "CSFEntryID", referencedColumnName = "CSFEntryID", nullable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Csfentry cSFEntryID;
    @JoinColumn(name = "RiskImpactTypeID", referencedColumnName = "ImpactTypeID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Impacttypes riskImpactTypeID;
//    @JoinColumn(name = "ValueAndImportanceImpactTypeID", referencedColumnName = "ImpactTypeID", nullable = false)
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    private Impacttypes valueAndImportanceImpactTypeID;
    @JoinColumn(name = "StakeholderTypeID", referencedColumnName = "StakeholderTypeID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Stakeholdertypes stakeholderTypeID;

    public Stakeholderentry() {
    }



    public Csfentry getCSFEntryID() {
        return cSFEntryID;
    }

    public void setCSFEntryID(Csfentry cSFEntryID) {
        this.cSFEntryID = cSFEntryID;
    }

    public Impacttypes getRiskImpactTypeID() {
        return riskImpactTypeID;
    }

    public void setRiskImpactTypeID(Impacttypes riskImpactTypeID) {
        this.riskImpactTypeID = riskImpactTypeID;
    }


    public Stakeholdertypes getStakeholderTypeID() {
        return stakeholderTypeID;
    }

    public void setStakeholderTypeID(Stakeholdertypes stakeholderTypeID) {
        this.stakeholderTypeID = stakeholderTypeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stakeholderEntryID != null ? stakeholderEntryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stakeholderentry)) {
            return false;
        }
        Stakeholderentry other = (Stakeholderentry) object;
        if ((this.stakeholderEntryID == null && other.stakeholderEntryID != null) || (this.stakeholderEntryID != null && !this.stakeholderEntryID.equals(other.stakeholderEntryID))) {
            return false;
        }
        return true;
    }

}
