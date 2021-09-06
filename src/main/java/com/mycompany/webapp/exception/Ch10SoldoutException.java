package com.mycompany.webapp.exception;

public class Ch10SoldoutException extends RuntimeException{
	public Ch10SoldoutException() {
		super("품절");
	}
	public Ch10SoldoutException(String message) {
		super(message);
	}
}
