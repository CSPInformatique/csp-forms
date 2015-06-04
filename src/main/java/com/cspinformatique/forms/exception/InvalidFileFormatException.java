package com.cspinformatique.forms.exception;

public class InvalidFileFormatException extends RuntimeException {
	private static final long serialVersionUID = 5746665336072700899L;
	
	private String message;
	
	public InvalidFileFormatException(String message){
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
