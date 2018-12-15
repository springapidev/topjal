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
@Table(name = "impact_types")
public class Impacttypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long impactTypeID;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String impact;
    @Basic(optional = false)
    @Column(nullable = false)
    private int weight;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "riskImpactTypeID", fetch = FetchType.LAZY)
    private Collection<Stakeholderentry> stakeholderentryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "valueAndImportanceImpactTypeID", fetch = FetchType.LAZY)
    private Collection<Stakeholderentry> stakeholderentryCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "businessImpactTypeID", fetch = FetchType.LAZY)
    private Collection<Vbfentry> vbfentryCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "impactTypeID", fetch = FetchType.LAZY)
    private Collection<Vulnerabilityentry> vulnerabilityentryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "impactTypeID", fetch = FetchType.LAZY)
    private Collection<Csfentry> csfentryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "riskImpactTypeID", fetch = FetchType.LAZY)
    private Collection<Csfentry> csfentryCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "threatIikelihoodTypeID", fetch = FetchType.LAZY)
    private Collection<Threatsentry> threatsentryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "threatImpactTypeID", fetch = FetchType.LAZY)
    private Collection<Threatsentry> threatsentryCollection1;

    public Impacttypes() {
    }

    public Long getImpactTypeID() {
        return impactTypeID;
    }

    public void setImpactTypeID(Long impactTypeID) {
        this.impactTypeID = impactTypeID;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Collection<Stakeholderentry> getStakeholderentryCollection() {
        return stakeholderentryCollection;
    }

    public void setStakeholderentryCollection(Collection<Stakeholderentry> stakeholderentryCollection) {
        this.stakeholderentryCollection = stakeholderentryCollection;
    }

    public Collection<Stakeholderentry> getStakeholderentryCollection1() {
        return stakeholderentryCollection1;
    }

    public void setStakeholderentryCollection1(Collection<Stakeholderentry> stakeholderentryCollection1) {
        this.stakeholderentryCollection1 = stakeholderentryCollection1;
    }

    public Collection<Vbfentry> getVbfentryCollection() {
        return vbfentryCollection;
    }

    public void setVbfentryCollection(Collection<Vbfentry> vbfentryCollection) {
        this.vbfentryCollection = vbfentryCollection;
    }



    public Collection<Vulnerabilityentry> getVulnerabilityentryCollection() {
        return vulnerabilityentryCollection;
    }

    public void setVulnerabilityentryCollection(Collection<Vulnerabilityentry> vulnerabilityentryCollection) {
        this.vulnerabilityentryCollection = vulnerabilityentryCollection;
    }

    public Collection<Csfentry> getCsfentryCollection() {
        return csfentryCollection;
    }

    public void setCsfentryCollection(Collection<Csfentry> csfentryCollection) {
        this.csfentryCollection = csfentryCollection;
    }

    public Collection<Csfentry> getCsfentryCollection1() {
        return csfentryCollection1;
    }

    public void setCsfentryCollection1(Collection<Csfentry> csfentryCollection1) {
        this.csfentryCollection1 = csfentryCollection1;
    }

    public Collection<Threatsentry> getThreatsentryCollection() {
        return threatsentryCollection;
    }

    public void setThreatsentryCollection(Collection<Threatsentry> threatsentryCollection) {
        this.threatsentryCollection = threatsentryCollection;
    }

    public Collection<Threatsentry> getThreatsentryCollection1() {
        return threatsentryCollection1;
    }

    public void setThreatsentryCollection1(Collection<Threatsentry> threatsentryCollection1) {
        this.threatsentryCollection1 = threatsentryCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (impactTypeID != null ? impactTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Impacttypes)) {
            return false;
        }
        Impacttypes other = (Impacttypes) object;
        if ((this.impactTypeID == null && other.impactTypeID != null) || (this.impactTypeID != null && !this.impactTypeID.equals(other.impactTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Impacttypes{" +
                "impactTypeID=" + impactTypeID +
                '}';
    }
}
