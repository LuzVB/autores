/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.exception.filter;

import edu.unicundi.controller.pojo.ErrorWrraper;
import edu.unicundi.exception.ParamUsedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Valentina
 */
@Provider
public class ParamUsedExceptionFilter implements ExceptionMapper<ParamUsedException> {

    @Override
    public Response toResponse(ParamUsedException ex) {
        System.out.println("Entro a ParamUsedException");
        ex.printStackTrace();
        ErrorWrraper error = new ErrorWrraper(ex.getMessage(), 400, "BAD_REQUEST");
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
}