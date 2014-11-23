package com.haoyumichael.note.rest.exception;

import javax.ws.rs.core.Response.Status;

public class EntityNotFoundException extends RestException {

	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(Status status, Exception cause,
			String message) {
		super(status, cause, message);
	}

	public EntityNotFoundException(Status status, Exception cause) {
		super(status, cause);
	}

	public EntityNotFoundException(Status status, String message) {
		super(status, message);
	}

	public EntityNotFoundException(String message) {
		super(message);
	}



}
