package com.santa.fleets.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.Forbidden;
import org.springframework.web.context.request.WebRequest;

import com.santa.fleets.pojo.ErrorBean;
import com.santa.fleets.pojo.ResponsePayload;
import com.santa.fleets.util.Constants;

@ControllerAdvice
@Configuration
public class GlobalExceptionHandler {

	@ExceptionHandler(NoDataFoundExceptionHandler.class)
	public ResponseEntity<ResponsePayload> noDataFoundExceptionHandler(NoDataFoundExceptionHandler ex, WebRequest req) {
		ResponsePayload payload = new ResponsePayload();
		return new ResponseEntity<ResponsePayload>(payload, HttpStatus.NO_CONTENT);

	}

	@ExceptionHandler(Forbidden.class)
	public ResponseEntity<ErrorBean> forbiddenExceptionHandler(Forbidden ex, WebRequest req) {
		ErrorBean payload = new ErrorBean(Constants.ERROR_CODE_403, Constants.PERMISSON_ERROR);
		return new ResponseEntity<ErrorBean>(payload, HttpStatus.FORBIDDEN);

	}

	@ExceptionHandler(InternalServerError.class)
	public ResponseEntity<ErrorBean> internalServerError(InternalServerError ex, WebRequest req) {
		ErrorBean payload = new ErrorBean(Constants.ERROR_CODE_500, Constants.SOMETHING_WRONG);
		return new ResponseEntity<ErrorBean>(payload, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(RequestValidationException.class)
	public ResponseEntity<ErrorBean> requestValidationException(RequestValidationException ex, WebRequest req) {
		ErrorBean payload = new ErrorBean(Constants.ERROR_CODE_400, Constants.MISSING_BODY_PARAM);
		return new ResponseEntity<ErrorBean>(payload, HttpStatus.BAD_REQUEST);

	}

}
