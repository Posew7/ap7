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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Yunus
 */
@Entity
@Table(name = "rehber")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rehber.findAll", query = "SELECT r FROM Rehber r")
    , @NamedQuery(name = "Rehber.findByAd", query = "SELECT r FROM Rehber r WHERE r.ad = :ad")
    , @NamedQuery(name = "Rehber.findByTel", query = "SELECT r FROM Rehber r WHERE r.tel = :tel")
    , @NamedQuery(name = "Rehber.findByBilgi", query = "SELECT r FROM Rehber r WHERE r.bilgi = :bilgi")})
public class Rehber implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ad")
    private String ad;
    @Size(max = 30)
    @Column(name = "tel")
    private String tel;
    @Size(max = 30)
    @Column(name = "bilgi")
    private String bilgi;

    public Rehber() {
    }

    public Rehber(String ad) {
        this.ad = ad;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBilgi() {
        return bilgi;
    }

    public void setBilgi(String bilgi) {
        this.bilgi = bilgi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ad != null ? ad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rehber)) {
            return false;
        }
        Rehber other = (Rehber) object;
        if ((this.ad == null && other.ad != null) || (this.ad != null && !this.ad.equals(other.ad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.posew7.ap7.entity.Rehber[ ad=" + ad + " ]";
    }
    
}
