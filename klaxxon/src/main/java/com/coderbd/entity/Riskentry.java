/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Rajail Islam
 */
@Entity
@Table(name = "risk_entry", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CSFEntryID"})})
public class Riskentry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer riskEntryID;
    @Column(length = 255)
    private String riskName;
    @Column(length = 255)
    private String riskTreatment;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double implementationCost;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date expiryDate;
    @Temporal(TemporalType.DATE)
    private Date reviewDate;
    @Column(length = 255)
    private String attachRiskTreatmentPlan;
    @Basic(optional = false)
    @Column(nullable = false)
    private int riskAversion;
    @JoinColumn(name = "ARMSTypeID", referencedColumnName = "ARMSTypeID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Armstypes aRMSTypeID;
    @JoinColumn(name = "CSFEntryID", referencedColumnName = "CSFEntryID", nullable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Csfentry cSFEntryID;
    @JoinColumn(name = "ContactID", referencedColumnName = "ContactID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Contacts contactID;
    @JoinColumn(name = "ReviewPeriodID", referencedColumnName = "ReviewPeriodID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Reviewperiods reviewPeriodID;

    public Riskentry() {
    }

    public Riskentry(Integer riskEntryID) {
        this.riskEntryID = riskEntryID;
    }

    public Riskentry(Integer riskEntryID, int riskAversion) {
        this.riskEntryID = riskEntryID;
        this.riskAversion = riskAversion;
    }

    public Integer getRiskEntryID() {
        return riskEntryID;
    }

    public void setRiskEntryID(Integer riskEntryID) {
        this.riskEntryID = riskEntryID;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public String getRiskTreatment() {
        return riskTreatment;
    }

    public void setRiskTreatment(String riskTreatment) {
        this.riskTreatment = riskTreatment;
    }

    public Double getImplementationCost() {
        return implementationCost;
    }

    public void setImplementationCost(Double implementationCost) {
        this.implementationCost = implementationCost;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getAttachRiskTreatmentPlan() {
        return attachRiskTreatmentPlan;
    }

    public void setAttachRiskTreatmentPlan(String attachRiskTreatmentPlan) {
        this.attachRiskTreatmentPlan = attachRiskTreatmentPlan;
    }

    public int getRiskAversion() {
        return riskAversion;
    }

    public void setRiskAversion(int riskAversion) {
        this.riskAversion = riskAversion;
    }

    public Armstypes getARMSTypeID() {
        return aRMSTypeID;
    }

    public void setARMSTypeID(Armstypes aRMSTypeID) {
        this.aRMSTypeID = aRMSTypeID;
    }

    public Csfentry getCSFEntryID() {
        return cSFEntryID;
    }

    public void setCSFEntryID(Csfentry cSFEntryID) {
        this.cSFEntryID = cSFEntryID;
    }

    public Contacts getContactID() {
        return contactID;
    }

    public void setContactID(Contacts contactID) {
        this.contactID = contactID;
    }

    public Reviewperiods getReviewPeriodID() {
        return reviewPeriodID;
    }

    public void setReviewPeriodID(Reviewperiods reviewPeriodID) {
        this.reviewPeriodID = reviewPeriodID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (riskEntryID != null ? riskEntryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Riskentry)) {
            return false;
        }
        Riskentry other = (Riskentry) object;
        if ((this.riskEntryID == null && other.riskEntryID != null) || (this.riskEntryID != null && !this.riskEntryID.equals(other.riskEntryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "klaxxon_reverse_eng.Riskentry[ riskEntryID=" + riskEntryID + " ]";
    }
    
}
