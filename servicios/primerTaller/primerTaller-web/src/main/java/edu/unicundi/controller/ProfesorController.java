/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.controller;


import edu.unicundi.dto.Profesor;
import edu.unicundi.dto.ProfesorA;
import edu.unicundi.entity.profesor;
import edu.unicundi.exception.ListaVaciaException;
import edu.unicundi.exception.NoValidoException;
import edu.unicundi.exception.ParamRequiredException;
import edu.unicundi.exception.ParamUsedException;
import edu.unicundi.service.IProfesorService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 *
 * @author Valentina
 */
@Stateless
@Path("/profesores")
public class ProfesorController {

    @EJB
    public IProfesorService service;

    @Path("/guardar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardar(@Valid profesor Profesor)  throws ParamRequiredException, ObjectNotFoundException, ParamUsedException {
        service.guardar(Profesor);
        return Response.status(Response.Status.CREATED).build();
    }

    @Path("/listar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar()   {
        List<profesor> dataProfesor = service.listar();
        return Response.status(Response.Status.OK).entity(dataProfesor).build();
    }
    
    @Path("/listarId/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPorId(@PathParam("id") Integer id) throws ObjectNotFoundException  {
        profesor Profesor = service.listarPorId(id);
        return Response.status(Response.Status.OK).entity(Profesor).build(); //.entity(service.getListaProfesores()).build();
    }
     @Path("/editar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@Valid profesor profesor) throws ParamRequiredException, ObjectNotFoundException, ParamUsedException {
        service.editar(profesor);
        return Response.status(Response.Status.OK).build();
    }
    @Path("/eliminarP/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id" ) Integer id) throws ObjectNotFoundException {
        service.eliminar(id);
        return Response.status(Response.Status.NO_CONTENT).build();       
    }     
    
    @Path("/retornarProfesor")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornarProfesor() throws SQLException, ListaVaciaException {
        service.listarProfesor();
        return Response.status(Response.Status.OK).entity(service.getListaProfesores()).build();
    }

    @Path("/retornar")
    @GET
    public Response listaProfesor() throws EJBException, ObjectNotFoundException {
        List<ProfesorA> dataProfesor = service.retornarProfesores();
        return Response.status(Response.Status.OK).entity(dataProfesor).build();
    }

    @Path("/retornarProfesorCedula/{cedula}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornarEstudiantePorCedula(@Min(999999) @Max(99999999) @PathParam("cedula") int cedula) throws NoValidoException  {
        service.listarProfesorCedula(cedula);
        return Response.status(Response.Status.OK).entity(service.getListaProfesores()).build();
    }

    @Path("/retornarProfesorMateria/{materia}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornarEstudiantePorMateria(@Size(min = 4, max = 21, message = "La materia debe tener minimo 4 y maximo 12 caracteres") @PathParam("materia") String materia)throws NoValidoException {
        service.listarProfesorMateria(materia);
        return Response.status(Response.Status.OK).entity(service.getListaProfesores()).build();
    }

    @Path("/editarProfesor")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@Valid Profesor profesor) throws SQLException {
        service.editarProfesor(profesor);
        return Response.status(Response.Status.OK).build();
    }

    @Path("/insertar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertarProfesor(@Valid ProfesorA profesor) throws IOException, FileNotFoundException, ClassNotFoundException {
        service.registroProfesor(profesor);
        return Response.status(Response.Status.CREATED).build();
    }

    @Path("/insertarProfesor")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertarEstudiante(@Valid Profesor profesor) throws Exception,NoValidoException {
        service.insertarProfesor(profesor);
        return Response.status(Response.Status.CREATED).build();
    }

    @Path("eliminar/{idProfesor}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("idProfesor") int id) throws NoValidoException {
        service.eliminarProfesor(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
