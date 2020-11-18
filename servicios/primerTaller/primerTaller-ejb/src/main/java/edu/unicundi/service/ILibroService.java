/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.service;

import edu.unicundi.dto.LibroDto;
import edu.unicundi.entity.Libro;
import edu.unicundi.exception.ObjectNotFoundException;
import edu.unicundi.exception.ParamRequiredException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Valentina
 */
@Local
public interface ILibroService {
    
    public List<LibroDto> listar();
        
    public LibroDto listarPorId(Integer id) throws ObjectNotFoundException;
    
    public void guardar(Libro libro) throws ParamRequiredException;
    
    public void editar(Libro libro) throws ParamRequiredException ,ObjectNotFoundException;
   
    public void eliminar(Integer idLibro) throws ObjectNotFoundException;
    
}
