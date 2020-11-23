/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.repo;

import edu.unicundi.entity.Curso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Luz
 */
@Local 
public interface ICursoRepo {

    public List<Curso> listar();

    public Curso listarPorId(Integer id);

    public void guardar(Curso curso);

    public void editar(Curso curso);

    public void eliminar(Curso curso);
}
