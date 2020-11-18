/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.exception.filter;

import edu.unicundi.controller.pojo.ErrorWrraper;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author Valentina
 */
//Es Get y se envia POST con o sin raw
public class NotAllowedExceptionFilter implements ExceptionMapper<NotAllowedException> {

    @Override
    public Response toResponse(NotAllowedException ex) {
        ErrorWrraper error = new ErrorWrraper("La peticion es un GET y se envio un POST // viene sin cuerpo", 405, "METHOD_NOT_ALLOWED");
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).entity(error).build();
    }
}
