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
import javax.persistence.Table;

/**
 *
 * @author Rajail Islam
 */
@Entity
@Table(name = "kpis")
public class Kpis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer kpiid;
    @Column(length = 255)
    private String description;
    @Column(length = 255)
    private String priority;
    @JoinColumn(name = "CSFEntryID", referencedColumnName = "CSFEntryID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Csfentry cSFEntryID;
    @JoinColumn(name = "CategoryTypeID", referencedColumnName = "CategoryTypeID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categorytypes categoryTypeID;
    @JoinColumn(name = "ContactID", referencedColumnName = "ContactID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Contacts contactID;
    @JoinColumn(name = "DepartmentID", referencedColumnName = "DepartmentID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Departments departmentID;

    public Kpis() {
    }

    public Kpis(Integer kpiid) {
        this.kpiid = kpiid;
    }

    public Integer getKpiid() {
        return kpiid;
    }

    public void setKpiid(Integer kpiid) {
        this.kpiid = kpiid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Csfentry getCSFEntryID() {
        return cSFEntryID;
    }

    public void setCSFEntryID(Csfentry cSFEntryID) {
        this.cSFEntryID = cSFEntryID;
    }

    public Categorytypes getCategoryTypeID() {
        return categoryTypeID;
    }

    public void setCategoryTypeID(Categorytypes categoryTypeID) {
        this.categoryTypeID = categoryTypeID;
    }

    public Contacts getContactID() {
        return contactID;
    }

    public void setContactID(Contacts contactID) {
        this.contactID = contactID;
    }

    public Departments getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Departments departmentID) {
        this.departmentID = departmentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kpiid != null ? kpiid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kpis)) {
            return false;
        }
        Kpis other = (Kpis) object;
        if ((this.kpiid == null && other.kpiid != null) || (this.kpiid != null && !this.kpiid.equals(other.kpiid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "klaxxon_reverse_eng.Kpis[ kpiid=" + kpiid + " ]";
    }
    
}
