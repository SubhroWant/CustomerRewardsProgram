package com.customerrewardsprogram.exception;

import org.springframework.http.HttpStatus;

public class CustomerRewardsProgramException extends Exception{
	private static final long serialVersionUID = -8588924808650672810L;
	
	private String message;
	private String errorCode;
	private HttpStatus httpStatus;
	
	
	public CustomerRewardsProgramException(String message, String errorCode, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.errorCode = errorCode;
		this.httpStatus = httpStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	

}
