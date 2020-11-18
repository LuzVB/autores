/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.repo;

import edu.unicundi.entity.profesor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Valentina
 */
@Local 
public interface IProfesorRepo {
    public List<profesor> listar();

    public profesor listarPorId(Integer id);

    public void guardar(profesor Profesor);

    public void editar(profesor Profesor);

    public void eliminar(profesor profesor);
    
    public Integer validarCedulaEditar(String cedula, Integer id);
    
    public Integer validarCorreoEditar(String correo, Integer id);
    
    public Integer validarCedulaGuardar(String cedula);
    
    public Integer validarCorreoGuardar(String correo);
}
