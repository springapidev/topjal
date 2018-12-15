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
@Table(name = "rate_occurences")
public class Rateoccurences implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer rateOccurenceID;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String occurence;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double rate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rateOccurenceID", fetch = FetchType.LAZY)
    private Collection<Threatsentry> threatsentryCollection;

    public Rateoccurences() {
    }

    public Rateoccurences(Integer rateOccurenceID) {
        this.rateOccurenceID = rateOccurenceID;
    }

    public Rateoccurences(Integer rateOccurenceID, String occurence) {
        this.rateOccurenceID = rateOccurenceID;
        this.occurence = occurence;
    }

    public Integer getRateOccurenceID() {
        return rateOccurenceID;
    }

    public void setRateOccurenceID(Integer rateOccurenceID) {
        this.rateOccurenceID = rateOccurenceID;
    }

    public String getOccurence() {
        return occurence;
    }

    public void setOccurence(String occurence) {
        this.occurence = occurence;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Collection<Threatsentry> getThreatsentryCollection() {
        return threatsentryCollection;
    }

    public void setThreatsentryCollection(Collection<Threatsentry> threatsentryCollection) {
        this.threatsentryCollection = threatsentryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rateOccurenceID != null ? rateOccurenceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rateoccurences)) {
            return false;
        }
        Rateoccurences other = (Rateoccurences) object;
        if ((this.rateOccurenceID == null && other.rateOccurenceID != null) || (this.rateOccurenceID != null && !this.rateOccurenceID.equals(other.rateOccurenceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "klaxxon_reverse_eng.Rateoccurences[ rateOccurenceID=" + rateOccurenceID + " ]";
    }
    
}
