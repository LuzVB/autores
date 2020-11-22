/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.controller;

import edu.unicundi.dto.AbstractFacadePage;
import edu.unicundi.dto.LibroDto;
import edu.unicundi.entity.Libro;
import edu.unicundi.exception.ObjectNotFoundException;
import edu.unicundi.exception.ParamRequiredException;
import edu.unicundi.exception.ParamUsedException;
import edu.unicundi.service.ILibroService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Valentina
 */
@Stateless
@Path("/libros")
public class LibroController {
    
    
    @EJB
    private ILibroService service;
    
    @Path("/listar/page={paginado}/size={size}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar(@PathParam("paginado") int pag, @PathParam("size") int size)  {
        AbstractFacadePage listarLibro = service.listarlibros(pag, size);
        return Response.status(Response.Status.OK).entity(listarLibro).build();       
    }        

    @Path("/retornarPorId/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornarPorId(@PathParam("id" ) Integer id) throws ObjectNotFoundException {
        LibroDto libro = service.listarPorId(id);
        return Response.status(Response.Status.OK).entity(libro).build();       
    }      
      
    @Path("/guardar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardar(@Valid Libro libro) throws ParamRequiredException {
        service.guardar(libro);
        return Response.status(Response.Status.CREATED).build();
    }
    
    
    @Path("/editar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@Valid Libro libro) throws ParamRequiredException, ObjectNotFoundException, ParamUsedException {
        service.editar(libro);
        return Response.status(Response.Status.OK).build();
    }
}
