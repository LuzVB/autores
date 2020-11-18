/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.exception.filter;

import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import edu.unicundi.controller.pojo.ErrorWrraper;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.apache.http.client.HttpResponseException;

/**
 *
 * @author Luz
 */
@Provider
public class HttpResponseExceptionFilter implements ExceptionMapper<HttpResponseException> {
     
    @ApiResponses(value = {
        @ApiResponse( code = 400, message = "BAD_REQUEST")})
    @Override
    public Response toResponse(HttpResponseException exception) {
        ErrorWrraper error =new ErrorWrraper (exception.getMessage(),400, "BAD_REQUEST");
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
    
}
