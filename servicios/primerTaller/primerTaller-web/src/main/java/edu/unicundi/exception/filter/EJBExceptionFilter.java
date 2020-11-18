package edu.unicundi.exception.filter;

import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import edu.unicundi.controller.pojo.ErrorWrraper;
import javax.ejb.EJBException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luz
 */
@Provider
public class EJBExceptionFilter implements ExceptionMapper<EJBException>{

     @ApiResponses(value = {
        @ApiResponse( code = 400, message = "BAD_REQUEST")})
    @Override
    public Response toResponse(EJBException exception) {
        ErrorWrraper error = new ErrorWrraper (exception.getMessage(),400, "BAD_REQUEST");
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
    
}
