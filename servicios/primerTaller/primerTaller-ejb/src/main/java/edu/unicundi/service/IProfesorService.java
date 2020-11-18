/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.service;

import edu.unicundi.dto.Profesor;
import edu.unicundi.dto.ProfesorA;
import edu.unicundi.entity.profesor;
import edu.unicundi.exception.ListaVaciaException;
import edu.unicundi.exception.NoValidoException;
import edu.unicundi.exception.ParamRequiredException;
import edu.unicundi.exception.ParamUsedException;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.ObjectNotFoundException;

/**
 *
 * @author Valentina
 */
@Local
public interface IProfesorService {
    public void listarProfesor() throws ListaVaciaException;

    public void listarProfesorCedula(int cedula) throws NoValidoException;

    public void listarProfesorMateria(String materia) throws NoValidoException;

    public void traerMateria(String materia) throws NoValidoException;

    public void traerCedula(int cedula)  throws NoValidoException;

    public void listaMateriasProfesor() throws NoValidoException,SQLException ;

    public void editarProfesor(Profesor profesor);

    public void insertarProfesor(Profesor profesorInsertar) throws Exception,NoValidoException;

    public void traerUltimoID() throws SQLException;

    public void eliminarProfesor(int idProfesor) throws NoValidoException;

    public List<Profesor> getListaProfesores();
    
    public void registroProfesor(ProfesorA profesor);
    
    public List<ProfesorA> retornarProfesores() throws ObjectNotFoundException;
    
    public List<profesor> listar();

    public profesor listarPorId(Integer id) throws ObjectNotFoundException;

    public void guardar(profesor profesor) throws ParamRequiredException, ObjectNotFoundException, ParamUsedException;

    public void editar(profesor profesor) throws ParamRequiredException, ObjectNotFoundException, ParamUsedException;

    public void eliminar(Integer id) throws ObjectNotFoundException;
}
