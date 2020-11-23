/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.controller;

import edu.unicundi.entity.Curso;
import edu.unicundi.entity.profesor;
import edu.unicundi.exception.ObjectNotFoundException;
import edu.unicundi.exception.ParamRequiredException;
import edu.unicundi.exception.ParamUsedException;
import edu.unicundi.service.ICursoService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
 * @author Luz
 */
@Stateless
@Path("/cursos")
public class CursoController {

    @EJB
    private ICursoService service;

    @Path("/listar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listr() {
        List<Curso> listaCurso = service.listar();
        return Response.status(Response.Status.OK).entity(listaCurso).build();
    }

    @Path("/listarId/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPorId(@PathParam("id") Integer id) throws ObjectNotFoundException {
        Curso curso = service.listarPorId(id);
        return Response.status(Response.Status.OK).entity(curso).build(); //.entity(service.getListaProfesores()).build();
    }

    @Path("/guardar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardar(@Valid Curso curso) {
        service.guardar(curso);
        return Response.status(Response.Status.CREATED).build();
    }

    @Path("/editar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@Valid Curso curso) throws ParamRequiredException, ObjectNotFoundException, ParamUsedException, javax.ejb.ObjectNotFoundException {
        service.editar(curso);
        return Response.status(Response.Status.OK).build();
    }

    @Path("/eliminar/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id") Integer id) throws ObjectNotFoundException, javax.ejb.ObjectNotFoundException {
        service.eliminar(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
