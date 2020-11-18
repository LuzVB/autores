/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.repo.impl;

import edu.unicundi.entity.profesor;
import edu.unicundi.repo.IProfesorRepo;
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
public class ProfesorRepo implements IProfesorRepo {

    @PersistenceContext(unitName="edu.unicundi_primerTaller-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager entity;
    
    @Override
    public List<profesor> listar() {
        TypedQuery<profesor> profesorList = this.entity.createNamedQuery("Profesor.listarTodo", profesor.class);                
        return profesorList.getResultList();
//        List profesorList = this.entity.createQuery("SELECT c FROM profesor c").getResultList();
//        return profesorList;
    }

    @Override
    public profesor listarPorId(Integer id) {
//          return this.entity.find(Profesor.class, id);
        profesor Profesor = this.entity.find(profesor.class, id);
        return Profesor;
    }

    @Override
    public void guardar(profesor Profesor) {
        this.entity.persist(Profesor);
    }

    @Override
    public void editar(profesor profesor) {
            this.entity.merge(profesor);
    }

    @Override
    public void eliminar(profesor profesor) {       
        this.entity.remove(profesor);
    }
 
    @Override
    public Integer validarCedulaEditar(String cedula, Integer id) {
        Query query = this.entity.createNamedQuery("Profesor.validarCedula");
        query.setParameter("cedula", cedula);
        query.setParameter("id", id);
        String consulta = query.getSingleResult().toString();
        Integer resultado = Integer.parseInt(consulta); 
        return resultado  ;
//        return (Integer) query.getSingleResult();
    }

    @Override
    public Integer validarCorreoEditar(String correo, Integer id) {
        Query query = this.entity.createNamedQuery("Profesor.validarCorreo");
        query.setParameter("correo", correo);
        query.setParameter("id", id);
        String consulta = query.getSingleResult().toString();
        Integer resultado = Integer.parseInt(consulta); 
        return resultado  ;
    }
    
    @Override
    public Integer validarCedulaGuardar(String cedula) {
        Query query = this.entity.createNamedQuery("Profesor.validarCedulaGuardar");
        query.setParameter("cedula", cedula);
        String consulta = query.getSingleResult().toString();
        Integer resultado = Integer.parseInt(consulta); 
        return resultado  ;
//        return (Integer) query.getSingleResult();
    }

    @Override
    public Integer validarCorreoGuardar(String correo) {
        Query query = this.entity.createNamedQuery("Profesor.validarCorreoGuardar");
        query.setParameter("correo", correo);
        String consulta = query.getSingleResult().toString();
        Integer resultado = Integer.parseInt(consulta); 
        return resultado  ;
    }
    
}
