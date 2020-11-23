/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.service;

import edu.unicundi.entity.Curso;
import edu.unicundi.exception.ObjectNotFoundException;
import edu.unicundi.exception.ParamRequiredException;
import edu.unicundi.exception.ParamUsedException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Luz
 */
@Local
public interface ICursoService {

    public List<Curso> listar();

    public Curso listarPorId(Integer id) throws ObjectNotFoundException;

    public void guardar(Curso curso);

    public void editar(Curso curso) throws ParamRequiredException, ObjectNotFoundException, ParamUsedException;

    public void eliminar(Integer id) throws ObjectNotFoundException;
}
