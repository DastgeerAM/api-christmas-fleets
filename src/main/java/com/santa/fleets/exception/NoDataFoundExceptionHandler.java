package com.santa.fleets.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoDataFoundExceptionHandler extends RuntimeException {

	public static final long serialVersionUID = 1L;

	public NoDataFoundExceptionHandler() {
		super();
	}

}
