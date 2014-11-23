package com.haoyumichael.note.rest.dto;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.haoyumichael.note.rest.exception.RestException;

public class RestExceptionDTO {

	private Status status;
	private int code;
	private String type;
	private String message;

	public static RestExceptionDTO fromException(RestException e) {
		RestExceptionDTO dto = new RestExceptionDTO();
		if(e.getStatus() != null)
		{
			dto.status = e.getStatus();
			dto.code = e.getStatus().getStatusCode();
		}
		else
		{
			dto.status = Response.Status.INTERNAL_SERVER_ERROR;
			dto.code = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
		}
		
		dto.type = e.getClass().getSimpleName();
		dto.message = e.getMessage();

		return dto;
	}


	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
