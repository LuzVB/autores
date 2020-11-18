/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.exception.filter;

import edu.unicundi.controller.pojo.ErrorWrraper;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author Valentina
 */
public class BadRequestExceptionFilter implements ExceptionMapper<BadRequestException> {

    @Override
    public Response toResponse(BadRequestException exception) {
       
       ErrorWrraper error =new ErrorWrraper (exception.getMessage(),exception.getResponse().getStatus(),exception.getResponse().getStatusInfo().toString());
       final Response.Status status;
       status = (Response.Status) exception.getResponse().getStatusInfo();
       return Response.status(status).entity(error).build();
    }
    
}
