package com.ty.hospital_app.hospitalboot_app.exception;

public class NoSuchIdFoundException extends RuntimeException{
	private String message = "No such Id to be found in the Database";

	public NoSuchIdFoundException(String message) {
		super();
		this.message = message;
	}

	public NoSuchIdFoundException() {
		
	}

	@Override
	public String getMessage() {
		return message;
	}
}
