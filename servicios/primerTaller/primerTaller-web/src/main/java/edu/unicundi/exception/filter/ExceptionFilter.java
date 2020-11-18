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

/**
 *
 * @author Valentina
 */
@Provider
public class ExceptionFilter implements ExceptionMapper<Exception>{

    @ApiResponses(value = {
        @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR")})
    @Override
    public Response toResponse(Exception exception) {
        ErrorWrraper error = new ErrorWrraper(exception.getMessage(), 500, "INTERNAL_SERVER_ERROR");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();

    }
}
