/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.exception.filter;

import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import edu.unicundi.controller.pojo.ErrorWrraper;
import edu.unicundi.exception.ListaVaciaException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Valentina
 */
@Provider
public class ListaVaciaExceptionFilter implements ExceptionMapper<ListaVaciaException> {
    
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "NO_CONTENT")})
    @Override
    public Response toResponse(ListaVaciaException ex) {

        ErrorWrraper error = new ErrorWrraper(ex.getMessage(), 204, "NO_CONTENT");
        return Response.status(Response.Status.NO_CONTENT).entity(error).build();
    }
    
}
