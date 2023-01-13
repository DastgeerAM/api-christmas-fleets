package com.santa.fleets.pojo;

import org.springframework.stereotype.Component;

@Component
public class ErrorBean {

	private String errorCode;

	private String errorReason;

	public ErrorBean() {
		super();
	}

	public ErrorBean(final String errorCode, final String errorReason) {
		super();
		this.errorCode = errorCode;
		this.errorReason = errorReason;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorReason() {
		return errorReason;
	}

	public void setErrorReason(String errorReason) {
		this.errorReason = errorReason;
	}

}
