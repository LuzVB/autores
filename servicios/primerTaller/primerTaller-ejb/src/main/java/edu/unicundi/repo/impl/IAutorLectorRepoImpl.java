/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.repo.impl;

import edu.unicundi.entity.Autor;
import edu.unicundi.entity.AutorLector;
import edu.unicundi.repo.IAutorLectorRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Valentina
 */
@Stateless
public class IAutorLectorRepoImpl implements IAutorLectorRepo{
    
    @PersistenceContext(unitName = "edu.unicundi_primerTaller-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager entity;

    @Override
    public void guardar(AutorLector autorLector) {
        entity.persist(autorLector);
    }

    @Override
    public List<AutorLector> listarAutorLector(Integer idAutor) {
        this.entity.getEntityManagerFactory().getCache().evictAll();
        TypedQuery<AutorLector> listaAutorLector = this.entity.createNamedQuery("AutorLector.listarLectorPorAutor", AutorLector.class);                
        listaAutorLector.setParameter("idAutor", idAutor);
        return listaAutorLector.getResultList();                
    }
    
    @Override
    public List<AutorLector> listarLectorAutor(Integer idAutor) {
        this.entity.getEntityManagerFactory().getCache().evictAll();
        TypedQuery<AutorLector> listaAutorLector = this.entity.createNamedQuery("AutorLector.listarAutorPorLector", AutorLector.class);                
        listaAutorLector.setParameter("idLector", idAutor);
        return listaAutorLector.getResultList();                
    }
    
    @Override
    public List<Autor> listarLectorAutorNo(Integer idAutor) {
        this.entity.getEntityManagerFactory().getCache().evictAll();
        TypedQuery<Autor> listaAutorLector = this.entity.createNamedQuery("AutorLector.listarAutorPorLectorNo", Autor.class);                
        listaAutorLector.setParameter("idLector", idAutor);
        return listaAutorLector.getResultList();                
    }
    
    
    @Override
    public int  desasociarLector(int idAutor, int idLector) {
        Query query = this.entity.createNamedQuery("AutorLector.desasociar", AutorLector.class);            
        query.setParameter("idAutor", idAutor);  
        query.setParameter("idLector", idLector);   
        return query.executeUpdate();
    }
            
}

