/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.posew7.ap7.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yunus
 */
@Entity
@Table(name = "grsklnc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grsklnc.q", query = "SELECT g FROM Grsklnc g WHERE g.klnc = :klnc and g.sfr = :sfr")
    , @NamedQuery(name = "Grsklnc.findAll", query = "SELECT g FROM Grsklnc g")
    , @NamedQuery(name = "Grsklnc.findByNo", query = "SELECT g FROM Grsklnc g WHERE g.no = :no")
    , @NamedQuery(name = "Grsklnc.findByKlnc", query = "SELECT g FROM Grsklnc g WHERE g.klnc = :klnc")
    , @NamedQuery(name = "Grsklnc.findBySfr", query = "SELECT g FROM Grsklnc g WHERE g.sfr = :sfr")})
public class Grsklnc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "no")
    private Integer no;
    @Size(max = 30)
    @Column(name = "klnc")
    private String klnc;
    @Size(max = 30)
    @Column(name = "sfr")
    private String sfr;

    public Grsklnc() {
    }

    public Grsklnc(Integer no) {
        this.no = no;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getKlnc() {
        return klnc;
    }

    public void setKlnc(String klnc) {
        this.klnc = klnc;
    }

    public String getSfr() {
        return sfr;
    }

    public void setSfr(String sfr) {
        this.sfr = sfr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (no != null ? no.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grsklnc)) {
            return false;
        }
        Grsklnc other = (Grsklnc) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.posew7.ap7.entity.Grsklnc[ no=" + no + " ]";
    }
    
}
