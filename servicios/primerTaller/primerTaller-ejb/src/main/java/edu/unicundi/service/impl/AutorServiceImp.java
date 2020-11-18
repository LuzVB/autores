/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.unicundi.dto.AbstractFacadePage;
import edu.unicundi.dto.AutorLectorDto;
import edu.unicundi.dto.AutorP;
import edu.unicundi.entity.Autor;
import edu.unicundi.entity.AutorLector;
import edu.unicundi.entity.Libro;
import edu.unicundi.entity.View_autor_datos;
import edu.unicundi.exception.ObjectNotFoundException;
import edu.unicundi.exception.ParamRequiredException;
import edu.unicundi.exception.ParamUsedException;
import edu.unicundi.repo.IAutorLectorRepo;
import edu.unicundi.repo.IAutorRepo;
import edu.unicundi.service.IAutorService;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.modelmapper.ModelMapper;
/**
 *
 * @author Valentina
 */
@Stateless
public class AutorServiceImp implements IAutorService {

    @EJB
    private IAutorRepo repo;
    
    @EJB
    private IAutorLectorRepo repoAutorLector;

    @Override
    public AbstractFacadePage listarVista(int pag , int size) {
          AbstractFacadePage paginado = new AbstractFacadePage() {};
          Integer validacion = repo.CantidadAutores();
          paginado.setContent(repo.listarVista(pag ,size));
          paginado.setTotalElements(validacion);
          return paginado;
    }
    
    
    @Override
    public View_autor_datos listarGeneralPorId(Integer id) throws ObjectNotFoundException{
        View_autor_datos autor = repo.listarGeneralPorId(id);
        if(autor != null) 
            return autor;
        else
            throw new ObjectNotFoundException("El autor no esta registrado.");
    }
    
    @Override
    public List<AutorP> listarOpcion1(boolean estado) {
        List<Autor> listaAutor = repo.listar("Autor.listarTodo");
        List<AutorP> listaAutorDto = new ArrayList<>();

        if (estado) {
            for (Autor lista : listaAutor) {
                ModelMapper modelMapper = new ModelMapper();
                AutorP autorDto = modelMapper.map(lista, AutorP.class);
                listaAutorDto.add(autorDto);
            }
            
            return listaAutorDto;
        } else {
            for (Autor lista : listaAutor) {
                ModelMapper modelMapper = new ModelMapper();
                AutorP autorDto = modelMapper.map(lista, AutorP.class);
                listaAutorDto.add(autorDto);
            }
            for (AutorP aut : listaAutorDto) {
                aut.setLibro(null);
            }
            
             return listaAutorDto;
        }
       
    }
     
   @Override
   public AbstractFacadePage listarPaginado(boolean estado,int pag , int size){
    
        AbstractFacadePage paginado = new AbstractFacadePage() {};
        List<Autor> listaAutor = repo.listarPaginado(pag,size);
        List<AutorP> listaAutorDto = new ArrayList<>();
        Integer validacion = repo.CantidadAutores();
        System.out.println(validacion);
        if (estado) {
            for (Autor lista : listaAutor) {
                ModelMapper modelMapper = new ModelMapper();
                AutorP autorDto = modelMapper.map(lista, AutorP.class);
                listaAutorDto.add(autorDto);
            }
                paginado.setContent(listaAutorDto);
                paginado.setTotalElements(validacion);
                return paginado;
        } else {
            for (Autor lista : listaAutor) {
                ModelMapper modelMapper = new ModelMapper();
                AutorP autorDto = modelMapper.map(lista, AutorP.class);
                listaAutorDto.add(autorDto);
            }
            for (AutorP aut : listaAutorDto) {
                aut.setLibro(null);
            }
             paginado.setContent(listaAutorDto);
             paginado.setTotalElements(validacion);
             
             return paginado;
        }
   }
   
   @Override
    public List<AutorLectorDto> listarAutorLector(Integer idAutor) {
        List<AutorLector> listaAutorLector = repoAutorLector.listarAutorLector(idAutor);
        List<AutorLectorDto> lista = new ArrayList<>();
        for (AutorLector lis : listaAutorLector) {
            ModelMapper modelMapper = new ModelMapper();
            AutorLectorDto autorLectorDto = modelMapper.map(lis, AutorLectorDto.class);   
            //autorLectorDto.getAutor().setLibro(null);
            autorLectorDto.setAutor(null);
            lista.add(autorLectorDto);            
        }        
        return lista;
    }
      
@Override
    public void asociarAutorLector(AutorLector autorLector) {
        //Validaciones
        repoAutorLector.guardar(autorLector);
    }
    
    @Override
    public void desasociarAutorLector(AutorLector autorLector) throws ObjectNotFoundException {
        int id_autor=autorLector.getAutor().getId();
        int id_lector=autorLector.getLector().getId();
       if( repoAutorLector.desasociarLector(id_autor,id_lector)==0){
            throw new ObjectNotFoundException("Autor no existe.");
       }
    }
    
    @Override
    public List<Autor> listarOpcion2() {
        return repo.listarOpcion2();
    }
    
    @Override
    public List<Autor> listarOpcion3(boolean estado) {
        
        List<Autor> listaAutor = repo.listarOpcion3();
        if (estado) {
            return listaAutor;
        } else {

            for (Autor lista : listaAutor) {
                lista.setLibro(null);
            }
        }
        return listaAutor;
    }
    
    @Override
    public List<AutorP> listar(int estado) {
        List<AutorP> autor = new ArrayList<>();
        List<Autor> autorLista = repo.listar("Autor.listarTodo");
        for (Autor a : autorLista) {
            List<Libro> libro = new ArrayList<>();
            AutorP AutorPojo = new AutorP();
            AutorPojo.setId(a.getId());
            AutorPojo.setApellido(a.getApellido());
            AutorPojo.setFecha(a.getFecha());
            AutorPojo.setNombre(a.getNombre());
            AutorPojo.setEstado(a.getEstado());
            for (Libro libros : a.getLibro()) {
                Libro l = new Libro();
                l.setId(libros.getId());
                l.setNombre(libros.getNombre());
                l.setAutor(libros.getAutor());
                l.setEditorial(libros.getEditorial());
                libro.add(l);
            }
            if (estado == 1) {
                AutorPojo.setLibro(libro);
            }
            autor.add(AutorPojo);
        }

        return autor;
    }

    @Override
    public Autor listarPorId(Integer id) throws ObjectNotFoundException {
        Autor autor = repo.listarPorId(id);
        if (autor == null) {
            throw new ObjectNotFoundException("Autor no existe.");
        } else {
            return autor;
        }
    }
    
    @Override
    public AutorP listarPorIdA(Integer id, int estado) throws ObjectNotFoundException {
        Autor autor = repo.listarPorId(id);
        AutorP a = new AutorP();
        
        if (autor == null) {
            throw new ObjectNotFoundException("Autor no existe.");
        } else {
            a.setApellido(autor.getApellido());
            a.setNombre(autor.getNombre());
            a.setFecha(autor.getFecha());
            a.setId(autor.getId());
            a.setEstado(autor.getEstado());
            if (estado == 1) {
                a.setLibro(autor.getLibro());
                return a;
            } else {
                return a;
            }
        }
    }

    @Override
    public void guardar(Autor autor) {
         if(autor.getLibro() != null) {
            for(Libro libro: autor.getLibro()) {
                libro.setAutor(autor);
            }
        }
        
        /*if(autor.getDireccion() == null) 
            throw new ParamRequiredException("Dirección es requerida");*/
        if(autor.getDireccion() != null)
                autor.getDireccion().setAutor(autor);        
        
        repo.guardar(autor);
    }

    @Override
    public void editar(Autor autor) throws ParamRequiredException, ObjectNotFoundException{
        if(autor.getId() == null)    
            throw new ParamRequiredException("Id es requerido para edición");
        else {
            Autor autorAux = repo.listarPorId(autor.getId());
            
            if(autor == null)
                throw new ObjectNotFoundException("Autor no existe.");
            
            autorAux.setApellido(autor.getApellido());
            autorAux.setNombre(autor.getNombre());
            autorAux.setFecha(autor.getFecha());
            
            if(autor.getDireccion() != null) {
                autorAux.getDireccion().setBarrio(autor.getDireccion().getBarrio());
                autorAux.getDireccion().setDireccion(autor.getDireccion().getDireccion());
            }
            //EVITAR ESTO
            //autorAux.setLibro(autor.getLibro());
            //autorAux.getLibro().get(0).setNombre("nombre");
            
            repo.editar(autorAux);
        }
        
    }

    @Override
    public void eliminar(Integer id) throws ObjectNotFoundException {
        Autor autor = this.listarPorId(id);
        repo.eliminar(autor);
    }
    
    @Override
    public void eliminarOpcion2(Integer id) throws ObjectNotFoundException {
        Autor autor = this.listarPorId(id);
        if(autor.getLibro().isEmpty() == true){
              repo.eliminar(autor);
        }else{
             throw new ObjectNotFoundException("El autor tiene asociados los libros(ELIMINE LOS LIBROS).");

        }
    }

    @Override
    public void bloquearAutor(Integer idAutor) throws ParamUsedException {
        this.validarId(idAutor);
        repo.bloquear(idAutor);
    }
    
    @Override
    public void habilitarAutor(Integer idAutor) throws ParamUsedException {
        this.validarId(idAutor);
        repo.habilitar(idAutor);
    }
    
    
     private void validarId(Integer idAutor) throws ParamUsedException{
            Integer validacion = repo.validaId(idAutor);
            if(validacion == 0)
                throw new ParamUsedException("El ID no se escuentra registrado");          
    } 
}
