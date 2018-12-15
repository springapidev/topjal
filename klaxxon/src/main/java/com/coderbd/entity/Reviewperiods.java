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
@Table(name = "review_periods")
public class Reviewperiods implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer reviewPeriodID;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String reviewPeriod;
    @OneToMany(mappedBy = "reviewPeriodID", fetch = FetchType.LAZY)
    private Collection<Riskentry> riskentryCollection;

    public Reviewperiods() {
    }

    public Reviewperiods(Integer reviewPeriodID) {
        this.reviewPeriodID = reviewPeriodID;
    }

    public Reviewperiods(Integer reviewPeriodID, String reviewPeriod) {
        this.reviewPeriodID = reviewPeriodID;
        this.reviewPeriod = reviewPeriod;
    }

    public Integer getReviewPeriodID() {
        return reviewPeriodID;
    }

    public void setReviewPeriodID(Integer reviewPeriodID) {
        this.reviewPeriodID = reviewPeriodID;
    }

    public String getReviewPeriod() {
        return reviewPeriod;
    }

    public void setReviewPeriod(String reviewPeriod) {
        this.reviewPeriod = reviewPeriod;
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
        hash += (reviewPeriodID != null ? reviewPeriodID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reviewperiods)) {
            return false;
        }
        Reviewperiods other = (Reviewperiods) object;
        if ((this.reviewPeriodID == null && other.reviewPeriodID != null) || (this.reviewPeriodID != null && !this.reviewPeriodID.equals(other.reviewPeriodID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "klaxxon_reverse_eng.Reviewperiods[ reviewPeriodID=" + reviewPeriodID + " ]";
    }
    
}
