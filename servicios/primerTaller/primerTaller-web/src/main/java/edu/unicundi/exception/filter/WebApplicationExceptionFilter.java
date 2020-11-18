/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.exception.filter;

import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import edu.unicundi.controller.pojo.ErrorWrraper;
import java.util.Date;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Valentina
 */
@Provider
public class WebApplicationExceptionFilter implements ExceptionMapper<WebApplicationException>{

    @Override
    public Response toResponse(WebApplicationException exception) {
       
       ErrorWrraper error =new ErrorWrraper (exception.getMessage(),exception.getResponse().getStatus(),exception.getResponse().getStatusInfo().toString());
       final Response.Status status;
       status = (Status) exception.getResponse().getStatusInfo();
       return Response.status(status).entity(error).build();
    } 
}
