/*
INSERT INTO `vbftypes` (`VBFTypeID`, `VBFType`) VALUES
(1, 'Email'),
(2, 'Power'),
(3, 'Online Payment Gateway'),
(4, 'Database Collaboration Engine'),
(5, 'Telephone'),
(6, 'Service Desk'),
(7, 'Payroll'),
(8, 'Computer Hardware'),
(9, 'HR (Human Resource Development)'),
(10, 'Examination sales'),
(11, 'Continuous integration'),
(12, 'Elearning Portal (ITIL Training)'),
(13, 'Elearning Portal (ITIL Training)'),
(14, 'Test VBF'),
(15, 'Wire harness provision'),
(16, 'Nuclear centrifuge');
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
@Table(name = "vbf_types")
public class Vbftypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long vBFTypeID;
    @Basic(optional = false)
    @Column(nullable = false, length = 255,unique = true)
    private String vBFType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vBFTypeID", fetch = FetchType.LAZY)
    private Collection<Vbfentry> vbfentryCollection;

    public Vbftypes() {
    }

    public Long getvBFTypeID() {
        return vBFTypeID;
    }

    public void setvBFTypeID(Long vBFTypeID) {
        this.vBFTypeID = vBFTypeID;
    }

    public String getvBFType() {
        return vBFType;
    }

    public void setvBFType(String vBFType) {
        this.vBFType = vBFType;
    }

    public String getVBFType() {
        return vBFType;
    }

    public void setVBFType(String vBFType) {
        this.vBFType = vBFType;
    }

    public Collection<Vbfentry> getVbfentryCollection() {
        return vbfentryCollection;
    }

    public void setVbfentryCollection(Collection<Vbfentry> vbfentryCollection) {
        this.vbfentryCollection = vbfentryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vBFTypeID != null ? vBFTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vbftypes)) {
            return false;
        }
        Vbftypes other = (Vbftypes) object;
        if ((this.vBFTypeID == null && other.vBFTypeID != null) || (this.vBFTypeID != null && !this.vBFTypeID.equals(other.vBFTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "klaxxon_reverse_eng.Vbftypes[ vBFTypeID=" + vBFTypeID + " ]";
    }

}
