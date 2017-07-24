package com.example.objectMap;

public class KeyNotFoundException extends RuntimeException {
	
	private String msg = " \" Not Found in Object";
	
	public KeyNotFoundException(String message) {
		super(message);
    }
	
}
