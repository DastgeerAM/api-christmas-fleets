package com.santa.fleets.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequestValidationException extends RuntimeException {

	public static final long serialVersionUID = 1L;

	public RequestValidationException() {
		super();
	}

}
