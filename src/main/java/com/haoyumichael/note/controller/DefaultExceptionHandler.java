package com.haoyumichael.note.controller;

import java.util.List;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DefaultExceptionHandler implements ExceptionMapper<ArithmeticException> {

	@Context
    private HttpHeaders headers;
	
    @Override
    public Response toResponse(ArithmeticException e) { 
    	System.out.println(headers);
    	
        // For simplicity I am preparing error xml by hand.
        // Ideally we should create an ErrorResponse class to hold the error info.
        StringBuilder response = new StringBuilder("<response>");
        response.append("<status>ERROR</status>");
        response.append("<message>" + e.getMessage() + "</message>");
        response.append("</response>");
        ResponseSample rs = new ResponseSample();
        rs.setStatus("status1");
        rs.setMessage(e.getMessage());
        return Response.serverError().entity(rs).type(MediaType.APPLICATION_JSON).build();
        
    }
}
