/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.exception.filter;

import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import edu.unicundi.controller.pojo.ErrorWrraper;
import edu.unicundi.exception.NoValidoException;
import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Luz
 */
@Provider

public class NoValidoExceptionFilter implements ExceptionMapper<NoValidoException>{
    
    @ApiResponses(value = {
        @ApiResponse(code = 404, message = "NOT_FOUND")})
    @Override
    public Response toResponse(NoValidoException exception) {
        ErrorWrraper error = new ErrorWrraper(exception.getMessage(), 404, "NOT_FOUND");
        return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }

}
