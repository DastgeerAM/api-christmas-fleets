package com.santa.fleets.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerError extends RuntimeException {

	public static final long serialVersionUID = 1L;

	public InternalServerError() {
		super();
	}

}
