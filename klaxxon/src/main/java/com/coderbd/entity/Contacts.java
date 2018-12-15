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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Rajail Islam
 */
@Entity
@Table(name = "contacts")
public class Contacts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer contactID;
    @Column(length = 255)
    private String contactName;
    private Integer contactPhone;
    @Column(length = 255)
    private String contactEmail;
    @JoinTable(name = "departmentcontacts", joinColumns = {
        @JoinColumn(name = "ContactID", referencedColumnName = "ContactID", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "DepartmentID", referencedColumnName = "DepartmentID", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Departments> departmentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactID", fetch = FetchType.LAZY)
    private Collection<Riskentry> riskentryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactID", fetch = FetchType.LAZY)
    private Collection<Kpis> kpisCollection;
    @JoinColumn(name = "DepartmentID", referencedColumnName = "DepartmentID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Departments departmentID;

    public Contacts() {
    }

    public Contacts(Integer contactID) {
        this.contactID = contactID;
    }

    public Integer getContactID() {
        return contactID;
    }

    public void setContactID(Integer contactID) {
        this.contactID = contactID;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public Integer getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(Integer contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Collection<Departments> getDepartmentsCollection() {
        return departmentsCollection;
    }

    public void setDepartmentsCollection(Collection<Departments> departmentsCollection) {
        this.departmentsCollection = departmentsCollection;
    }

    public Collection<Riskentry> getRiskentryCollection() {
        return riskentryCollection;
    }

    public void setRiskentryCollection(Collection<Riskentry> riskentryCollection) {
        this.riskentryCollection = riskentryCollection;
    }

    public Collection<Kpis> getKpisCollection() {
        return kpisCollection;
    }

    public void setKpisCollection(Collection<Kpis> kpisCollection) {
        this.kpisCollection = kpisCollection;
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
        hash += (contactID != null ? contactID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacts)) {
            return false;
        }
        Contacts other = (Contacts) object;
        if ((this.contactID == null && other.contactID != null) || (this.contactID != null && !this.contactID.equals(other.contactID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "klaxxon_reverse_eng.Contacts[ contactID=" + contactID + " ]";
    }
    
}
