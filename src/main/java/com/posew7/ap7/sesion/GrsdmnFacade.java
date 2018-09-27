/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.posew7.ap7.sesion;

import com.posew7.ap7.entity.Grsdmn;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Yunus
 */
@Stateless
public class GrsdmnFacade extends AbstractFacade<Grsdmn> {

    @PersistenceContext(unitName = "com.posew7_ap7_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GrsdmnFacade() {
        super(Grsdmn.class);
    }

    public boolean giriseYetkiliMi(String p_kullanici, String p_sifre) {
        try {
            Grsdmn g = em.createNamedQuery("Grsdmn.q", Grsdmn.class).setParameter("klnc", p_kullanici).setParameter("sfr", p_sifre).getSingleResult();
            if (g != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

}
