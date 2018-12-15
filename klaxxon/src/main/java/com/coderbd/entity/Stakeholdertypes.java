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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Rajaul Islam
 */
@Entity
@Table(name = "stake_holder_types")
public class Stakeholdertypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long stakeholderTypeID;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String stakeholderType;
    @ManyToMany(mappedBy = "stakeholdertypesCollection", fetch = FetchType.LAZY)
    private Collection<Processtypes> processtypesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stakeholderTypeID", fetch = FetchType.LAZY)
    private Collection<Stakeholderentry> stakeholderentryCollection;

    public Stakeholdertypes() {
    }

    public Long getStakeholderTypeID() {
        return stakeholderTypeID;
    }

    public void setStakeholderTypeID(Long stakeholderTypeID) {
        this.stakeholderTypeID = stakeholderTypeID;
    }

    public String getStakeholderType() {
        return stakeholderType;
    }

    public void setStakeholderType(String stakeholderType) {
        this.stakeholderType = stakeholderType;
    }

    public Collection<Processtypes> getProcesstypesCollection() {
        return processtypesCollection;
    }

    public void setProcesstypesCollection(Collection<Processtypes> processtypesCollection) {
        this.processtypesCollection = processtypesCollection;
    }

    public Collection<Stakeholderentry> getStakeholderentryCollection() {
        return stakeholderentryCollection;
    }

    public void setStakeholderentryCollection(Collection<Stakeholderentry> stakeholderentryCollection) {
        this.stakeholderentryCollection = stakeholderentryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stakeholderTypeID != null ? stakeholderTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stakeholdertypes)) {
            return false;
        }
        Stakeholdertypes other = (Stakeholdertypes) object;
        if ((this.stakeholderTypeID == null && other.stakeholderTypeID != null) || (this.stakeholderTypeID != null && !this.stakeholderTypeID.equals(other.stakeholderTypeID))) {
            return false;
        }
        return true;
    }


    
}
