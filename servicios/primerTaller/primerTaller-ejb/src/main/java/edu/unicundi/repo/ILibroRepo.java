/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.repo;

import edu.unicundi.entity.Libro;
import edu.unicundi.entity.view_autor_libro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Valentina
 */
@Local
public interface ILibroRepo {
    
    public List<Libro> listar(String sql);
        
    public Libro listarPorId(Integer id);
    
    public void guardar(Libro libro);
    
    public void editar(Libro libro);
   
    public void eliminar(Libro libro);
    
     public Integer CantidadLibros();
     
    public List<view_autor_libro> listarLibro(Integer pag, Integer size);
        
}
