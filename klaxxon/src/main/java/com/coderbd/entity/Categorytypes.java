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
 * @author Rajaul Islam
 */
@Entity
@Table(name = "category_types")
public class Categorytypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer categoryTypeID;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String categoryType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryTypeID", fetch = FetchType.LAZY)
    private Collection<Kpis> kpisCollection;

    public Categorytypes() {
    }

    public Categorytypes(Integer categoryTypeID) {
        this.categoryTypeID = categoryTypeID;
    }

    public Categorytypes(Integer categoryTypeID, String categoryType) {
        this.categoryTypeID = categoryTypeID;
        this.categoryType = categoryType;
    }

    public Integer getCategoryTypeID() {
        return categoryTypeID;
    }

    public void setCategoryTypeID(Integer categoryTypeID) {
        this.categoryTypeID = categoryTypeID;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public Collection<Kpis> getKpisCollection() {
        return kpisCollection;
    }

    public void setKpisCollection(Collection<Kpis> kpisCollection) {
        this.kpisCollection = kpisCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryTypeID != null ? categoryTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorytypes)) {
            return false;
        }
        Categorytypes other = (Categorytypes) object;
        if ((this.categoryTypeID == null && other.categoryTypeID != null) || (this.categoryTypeID != null && !this.categoryTypeID.equals(other.categoryTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "klaxxon_reverse_eng.Categorytypes[ categoryTypeID=" + categoryTypeID + " ]";
    }
    
}
