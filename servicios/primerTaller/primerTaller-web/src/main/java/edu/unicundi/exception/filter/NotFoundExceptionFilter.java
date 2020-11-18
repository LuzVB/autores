/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.exception.filter;

import edu.unicundi.controller.pojo.ErrorWrraper;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Valentina
 */

@Provider
public class NotFoundExceptionFilter implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException ex) {
        System.out.println("Entro a NotFoundExceptionFilter");
        ex.printStackTrace();                                
        ErrorWrraper error = new ErrorWrraper(ex.getMessage(), 404, "NOT_FOUND");
        return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }
}
