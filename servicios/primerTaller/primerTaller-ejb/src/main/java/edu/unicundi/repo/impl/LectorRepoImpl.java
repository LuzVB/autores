/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.repo.impl;

import edu.unicundi.entity.Lector;
import edu.unicundi.repo.AbstractFacade;
import edu.unicundi.repo.ILectorRepo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Valentina
 */
@Stateless
public class LectorRepoImpl extends AbstractFacade<Lector, Integer> implements ILectorRepo{
    
    @PersistenceContext(unitName = "edu.unicundi_primerTaller-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager entity;

    public LectorRepoImpl() {
        super(Lector.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return entity;
    }

}

