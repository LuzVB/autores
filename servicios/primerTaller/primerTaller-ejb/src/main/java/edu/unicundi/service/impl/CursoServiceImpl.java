/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.service.impl;

import edu.unicundi.entity.Curso;
import edu.unicundi.exception.ObjectNotFoundException;
import edu.unicundi.exception.ParamRequiredException;
import edu.unicundi.exception.ParamUsedException;
import edu.unicundi.repo.ICursoRepo;
import edu.unicundi.service.ICursoService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Luz
 */
@Stateless
public class CursoServiceImpl implements ICursoService{

    @EJB
    private ICursoRepo repo;
    
    @Override
    public List<Curso> listar() {
       return repo.listar();
    }

    @Override
    public Curso listarPorId(Integer id) throws ObjectNotFoundException {
       Curso curso = repo.listarPorId(id);
        if (curso != null) {
            return curso;
        } else {
            throw new ObjectNotFoundException("El curso no existe.");
        }
    }

    @Override
    public void guardar(Curso curso) {
        repo.guardar(curso);
    }

    @Override
    public void editar(Curso curso) throws ParamRequiredException, ObjectNotFoundException, ParamUsedException {
       if (curso.getId() == null) {
            throw new ParamRequiredException("Id es requerido para edición");
        } else {
            this.listarPorId(curso.getId());
//            this.validarCamposEdicion(curso);
            repo.editar(curso);
        }
    }

    @Override
    public void eliminar(Integer id) throws ObjectNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//    private void validarCamposEdicion(Curso curso) throws ParamUsedException {
//        Integer validacion = repo.validarCedula(profesor.getCedula(), profesor.getId());
//        if (validacion != 0) {
//            throw new ParamUsedException("Cédula ya se encuentra registrada");
//        }
//
//        validacion = repo.validarCorreo(profesor.getCorreo(), profesor.getId());
//        if (validacion != 0) {
//            throw new ParamUsedException("Correo ya se encuentra registradao");
//        }
//    }
    
}
