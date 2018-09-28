/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.posew7.ap7.sesion;

import com.posew7.ap7.entity.Rehber;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Yunus
 */
@Stateless
public class RehberFacade extends AbstractFacade<Rehber> {

    @PersistenceContext(unitName = "com.posew7_ap7_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RehberFacade() {
        super(Rehber.class);
    }
    
}
