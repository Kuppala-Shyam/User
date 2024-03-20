package com.example.User.Exception;

public class AccessDeniedException extends RuntimeException{
	private String message = "Access denied maybe because of unauthorization";

	public AccessDeniedException(String message) {
		super();
		this.message = message;
	}
	
}
