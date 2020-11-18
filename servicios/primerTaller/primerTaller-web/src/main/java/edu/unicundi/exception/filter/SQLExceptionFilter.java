/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.exception.filter;

import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import edu.unicundi.controller.pojo.ErrorWrraper;
import java.sql.SQLException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Luz
 */
@Provider
public class SQLExceptionFilter implements ExceptionMapper<SQLException> {

    @ApiResponses(value = {
        @ApiResponse(code = 502, message = "BAD_GATEWAY")})
    @Override
    public Response toResponse(SQLException exception) {
        ErrorWrraper error =new ErrorWrraper (exception.getMessage(),502, "BAD_GATEWAY");
        return Response.status(Response.Status.BAD_GATEWAY).entity(error).build();
    }
    
}
