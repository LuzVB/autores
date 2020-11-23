/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.repo.impl;

import edu.unicundi.entity.Curso;
import edu.unicundi.repo.ICursoRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Luz
 */
@Stateless
public class CursoRepo implements ICursoRepo {

    @PersistenceContext(unitName = "edu.unicundi_primerTaller-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager entity;

    @Override
    public List<Curso> listar() {
        TypedQuery<Curso> cursoList = this.entity.createNamedQuery("Curso.listarTodo", Curso.class);
        return cursoList.getResultList();
    }

    @Override
    public Curso listarPorId(Integer id) {
        Curso curso = this.entity.find(Curso.class, id);
        return curso;
    }

    @Override
    public void guardar(Curso curso) {
        this.entity.persist(curso);
    }

    @Override
    public void editar(Curso curso) {
        this.entity.merge(curso);
    }

    @Override
    public void eliminar(Curso curso) {
        this.entity.remove(curso);
    }

}
