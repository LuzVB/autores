/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.repo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author ASUS-PC
 */
public abstract class AbstractFacade<T, V> {
      
    private Class<T> entityClass;
    
//    private List<T> lista;
   
    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();    
    
    public List<T> listar(String S) {
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
        TypedQuery<T> lista = getEntityManager().createNamedQuery(S, entityClass);                
        return lista.getResultList();      
    }
    
    public T listarPorId(V id) {
        return getEntityManager().find(entityClass, id);
    }
    
    public void guardar(T entity) {
        getEntityManager().persist(entity);
    }
    
    public void editar(T entity) {
         getEntityManager().merge(entity);
    }
   
    public void eliminar(T entity) {
        getEntityManager().remove(entity);
    }
    
    
}
