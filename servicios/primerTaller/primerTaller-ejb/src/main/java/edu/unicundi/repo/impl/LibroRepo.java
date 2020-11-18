/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.repo.impl;

import edu.unicundi.entity.Libro;
import edu.unicundi.repo.AbstractFacade;
import edu.unicundi.repo.ILibroRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Valentina
 */
@Stateless
public class LibroRepo extends AbstractFacade<Libro, Integer>  implements ILibroRepo {
    
    @PersistenceContext(unitName = "edu.unicundi_primerTaller-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager entity;
    
    public LibroRepo() {
        super(Libro.class);
    }
 
    @Override
    protected EntityManager getEntityManager() {
        return entity;
    }  
}

