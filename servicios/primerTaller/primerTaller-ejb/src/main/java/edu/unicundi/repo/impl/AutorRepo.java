/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.repo.impl;

import edu.unicundi.entity.Autor;
import edu.unicundi.entity.Libro;
import edu.unicundi.entity.View_autor_datos;
import edu.unicundi.repo.AbstractFacade;
import edu.unicundi.repo.IAutorRepo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Valentina
 */
@Stateless
public class AutorRepo  extends AbstractFacade<Autor, Integer> implements IAutorRepo {

    @PersistenceContext(unitName = "edu.unicundi_primerTaller-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager entity;

    public AutorRepo() {
        super(Autor.class);
    }
      
    @Override
    public List<Autor> listarOpcion1() {
        this.entity.getEntityManagerFactory().getCache().evictAll();
        TypedQuery<Autor> listaAutor = this.entity.createNamedQuery("Autor.listarTodo", Autor.class);                
        return listaAutor.getResultList();        
    }
    
    @Override
    public List<Autor> listarPaginado(Integer pag, Integer size) {
        int pagina = pag *size;
        this.entity.getEntityManagerFactory().getCache().evictAll();
        TypedQuery<Autor> listaAutor = this.entity.createNamedQuery("Autor.listarPagina", Autor.class); 
        listaAutor.setParameter("pag", pagina);
        listaAutor.setParameter("size", size);
        
        return listaAutor.getResultList();  
    }
    
    @Override
    public List<View_autor_datos> listarVista(Integer pag, Integer size) {
        
        int pagina = pag *size;
        this.entity.getEntityManagerFactory().getCache().evictAll();
        TypedQuery<View_autor_datos> lista= this.entity.createNamedQuery("View_autor_datos.listarPagina", View_autor_datos.class); 
        lista.setParameter("pag", pagina);
        lista.setParameter("size", size);               
        return lista.getResultList();      
    }
    
    @Override
    public View_autor_datos listarGeneralPorId(Integer id) {
        View_autor_datos autor = this.entity.find(View_autor_datos.class, id);
        return autor;
    }
    
    @Override
    public List<Autor> listarOpcion2() {
        this.entity.getEntityManagerFactory().getCache().evictAll();
        TypedQuery<Autor> listaAutor = this.entity.createNamedQuery("Autor.listarSoloAutor", Autor.class);                
        return listaAutor.getResultList();        
    }
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<Autor> listarOpcion3() {
        TypedQuery<Autor> listaAutor = this.entity.createNamedQuery("Autor.listarTodo", Autor.class);                
        return listaAutor.getResultList();                
    }
    
    
    @Override
    public Autor listarPorIdA(Integer id) {
        Autor listaAutor =  this.entity.find(Autor.class, id);
        return listaAutor;
    }

    @Override
    public Integer validaId(Integer id) {
        Query query = this.entity.createNamedQuery("Autor.validarAutor");
        query.setParameter("id", id);
        String consulta = query.getSingleResult().toString();
        Integer resultado = Integer.parseInt(consulta); 
        return resultado  ;
    }
    
    @Override
    public Integer CantidadAutores() {
        Query query = this.entity.createNamedQuery("Autor.cantidadAutores");
        String consulta = query.getSingleResult().toString();
        Integer resultado = Integer.parseInt(consulta); 
        return resultado  ;
    }
    
    @Override
    public void bloquear(Integer id) {
        Boolean estado = false;
        Query q = entity.createNamedQuery("Autor.estado");
        q.setParameter("estado", estado);
        q.setParameter("id", id);
        q.executeUpdate();
    }

    @Override
    public void habilitar(Integer id) {
        Boolean estado = true;
        Query q = entity.createNamedQuery("Autor.estado");
        q.setParameter("estado", estado);
        q.setParameter("id", id);
        q.executeUpdate();
    }

   @Override
    protected EntityManager getEntityManager() {
        return entity;
    } 



}
