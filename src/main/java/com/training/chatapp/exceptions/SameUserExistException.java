package com.training.chatapp.exceptions;

public class SameUserExistException extends Exception {
	private static final long serialVersionUID = 1L;
	public SameUserExistException() {
		super();
	}
	
	public SameUserExistException(String message) {
		super(message);
	}
	
	public SameUserExistException(String message,Throwable cause) {
		super(message,cause);
	}
	
	public SameUserExistException(Throwable cause) {
		super(cause);
	}
	
}
