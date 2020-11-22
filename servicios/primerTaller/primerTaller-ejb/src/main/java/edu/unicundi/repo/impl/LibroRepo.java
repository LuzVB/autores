/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.repo.impl;

import edu.unicundi.entity.Libro;
import edu.unicundi.entity.view_autor_libro;
import edu.unicundi.repo.AbstractFacade;
import edu.unicundi.repo.ILibroRepo;
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
    
    @Override
    public Integer CantidadLibros() {
        Query query = this.entity.createNamedQuery("Libro.cantidadLibros");
        String consulta = query.getSingleResult().toString();
        Integer resultado = Integer.parseInt(consulta); 
        return resultado  ;
    }
    
    @Override
    public List<view_autor_libro> listarLibro(Integer pag, Integer size) {
        int pagina = pag *size;
        this.entity.getEntityManagerFactory().getCache().evictAll();
        TypedQuery<view_autor_libro> lista= this.entity.createNamedQuery("view_autor_libro.listarPagina", view_autor_libro.class); 
        lista.setParameter("pag", pagina);
        lista.setParameter("size", size);               
        return lista.getResultList();      
    }
}

