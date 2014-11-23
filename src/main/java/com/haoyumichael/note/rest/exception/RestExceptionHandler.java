package com.haoyumichael.note.rest.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.haoyumichael.note.rest.dto.RestExceptionDTO;

@Provider
public class RestExceptionHandler implements ExceptionMapper<RestException> 
{

	public Response toResponse(RestException e) {
		RestExceptionDTO dto = RestExceptionDTO.fromException(e);

		RestExceptionDTO resp = new RestExceptionDTO();

        return Response.status(dto.getStatus()).entity(dto).type(MediaType.APPLICATION_JSON_TYPE).build();

		
//	    if (e.getStatus() != null) {
//	        return Response.status(e.getStatus()).entity(dto).type(MediaType.APPLICATION_JSON_TYPE).build();
//	      } else {
//	        return Response.serverError().entity(dto).type(MediaType.APPLICATION_JSON_TYPE).build();
//	      }
//		resp.setCode(Response.Status.CONFLICT.getStatusCode() + "");
//		resp.setMsg("Confict test only");
//		return Response.status(Response.Status.CONFLICT).entity(resp).type(MediaType.APPLICATION_JSON_TYPE).build();
	}

}
