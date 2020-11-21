/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.repo;

import edu.unicundi.entity.Autor;
import edu.unicundi.entity.AutorLector;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Valentina
 */
@Local
public interface IAutorLectorRepo {
    
    public void guardar(AutorLector autorLector);
    
    public List<AutorLector> listarAutorLector(Integer idAutor);
    
     public List<AutorLector> listarLectorAutor(Integer idAutor);
    
    public List<Autor> listarLectorAutorNo(Integer idAutor);
    
    public int  desasociarLector(int idAutor, int idLector);
    
}

