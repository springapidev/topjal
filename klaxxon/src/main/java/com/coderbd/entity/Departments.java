/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Rajaul Islam
 */
@Entity
@Table(name = "departments",  uniqueConstraints = {
        @UniqueConstraint(columnNames = {"department_name","company_id","user_id"})})
public class Departments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long departmentID;
    @Column(name = "department_name",nullable = false)
    private String departmentName;
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "departmentsCollection", fetch = FetchType.LAZY)
    private Collection<Contacts> contactsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentID", fetch = FetchType.LAZY)
    private Collection<Vbfentry> vbfentryCollection;
    @JoinColumn(name = "company_id", referencedColumnName = "CompanyID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Companies companyID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentID", fetch = FetchType.LAZY)
    private Collection<Kpis> kpisCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentID", fetch = FetchType.LAZY)
    private Collection<Contacts> contactsCollection1;

    @Column(name = "created_date")
    Date createdDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public Departments() {
    }

    public Long getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Long departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Collection<Contacts> getContactsCollection() {
        return contactsCollection;
    }

    public void setContactsCollection(Collection<Contacts> contactsCollection) {
        this.contactsCollection = contactsCollection;
    }

    public Collection<Vbfentry> getVbfentryCollection() {
        return vbfentryCollection;
    }

    public void setVbfentryCollection(Collection<Vbfentry> vbfentryCollection) {
        this.vbfentryCollection = vbfentryCollection;
    }

    public Companies getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Companies companyID) {
        this.companyID = companyID;
    }

    public Collection<Kpis> getKpisCollection() {
        return kpisCollection;
    }

    public void setKpisCollection(Collection<Kpis> kpisCollection) {
        this.kpisCollection = kpisCollection;
    }

    public Collection<Contacts> getContactsCollection1() {
        return contactsCollection1;
    }

    public void setContactsCollection1(Collection<Contacts> contactsCollection1) {
        this.contactsCollection1 = contactsCollection1;
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
    public int hashCode() {
        int hash = 0;
        hash += (departmentID != null ? departmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departments)) {
            return false;
        }
        Departments other = (Departments) object;
        if ((this.departmentID == null && other.departmentID != null) || (this.departmentID != null && !this.departmentID.equals(other.departmentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "klaxxon_reverse_eng.Departments[ departmentID=" + departmentID + " ]";
    }
    
}
