/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Rajaul Islam
 */
@Entity
@Table(name = "vbf_entry")
public class Vbfentry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long vBFEntryID;
    @Column(length = 500)
    private String vision;
    @Column(length = 500)
    private String misson;
    @Basic(optional = false)
    @Column(nullable = false)
    private double revenue;

    @JoinColumn(name = "department_id", referencedColumnName = "DepartmentID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Departments departmentID;

    @JoinColumn(name = "impact_type_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Impacttypes businessImpactTypeID;

    @JoinColumn(name = "vbf_likelihood_type_id",  nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vbflikelihoodtypes vbflikelihoodtypes;

    @JoinColumn(name = "vbf_type_id", referencedColumnName = "VBFTypeID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vbftypes vBFTypeID;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vBFEntryID", fetch = FetchType.LAZY)
    private Collection<Csfentry> csfentryCollection;

    @Column(name = "created_date")
    Date createdDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Vbfentry() {
    }

    public Long getvBFEntryID() {
        return vBFEntryID;
    }

    public void setvBFEntryID(Long vBFEntryID) {
        this.vBFEntryID = vBFEntryID;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getMisson() {
        return misson;
    }

    public void setMisson(String misson) {
        this.misson = misson;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public Departments getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Departments departmentID) {
        this.departmentID = departmentID;
    }

    public Impacttypes getBusinessImpactTypeID() {
        return businessImpactTypeID;
    }

    public void setBusinessImpactTypeID(Impacttypes businessImpactTypeID) {
        this.businessImpactTypeID = businessImpactTypeID;
    }

    public Vbflikelihoodtypes getVbflikelihoodtypes() {
        return vbflikelihoodtypes;
    }

    public void setVbflikelihoodtypes(Vbflikelihoodtypes vbflikelihoodtypes) {
        this.vbflikelihoodtypes = vbflikelihoodtypes;
    }

    public Vbftypes getvBFTypeID() {
        return vBFTypeID;
    }

    public void setvBFTypeID(Vbftypes vBFTypeID) {
        this.vBFTypeID = vBFTypeID;
    }

    public Collection<Csfentry> getCsfentryCollection() {
        return csfentryCollection;
    }

    public void setCsfentryCollection(Collection<Csfentry> csfentryCollection) {
        this.csfentryCollection = csfentryCollection;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vbfentry vbfentry = (Vbfentry) o;
        return Double.compare(vbfentry.getRevenue(), getRevenue()) == 0 &&
                Objects.equals(getvBFEntryID(), vbfentry.getvBFEntryID()) &&
                Objects.equals(getVision(), vbfentry.getVision()) &&
                Objects.equals(getMisson(), vbfentry.getMisson()) &&
                Objects.equals(getDepartmentID(), vbfentry.getDepartmentID()) &&
                Objects.equals(getBusinessImpactTypeID(), vbfentry.getBusinessImpactTypeID()) &&
                Objects.equals(getVbflikelihoodtypes(), vbfentry.getVbflikelihoodtypes()) &&
                Objects.equals(getvBFTypeID(), vbfentry.getvBFTypeID()) &&
                Objects.equals(getCsfentryCollection(), vbfentry.getCsfentryCollection());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getvBFEntryID(), getVision(), getMisson(), getRevenue(), getDepartmentID(), getBusinessImpactTypeID(), getVbflikelihoodtypes(), getvBFTypeID(), getCsfentryCollection());
    }

    @Override
    public String toString() {
        return "Vbfentry{" +
                "vBFEntryID=" + vBFEntryID +
                ", vision='" + vision + '\'' +
                ", misson='" + misson + '\'' +
                ", revenue=" + revenue +
                ", departmentID=" + departmentID +
                ", businessImpactTypeID=" + businessImpactTypeID +
                ", vbflikelihoodtypes=" + vbflikelihoodtypes +
                ", vBFTypeID=" + vBFTypeID +
                ", csfentryCollection=" + csfentryCollection +
                ", createdDate=" + createdDate +
                ", user=" + user +
                '}';
    }
}
