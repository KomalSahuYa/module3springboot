package com.app.trainee.exceptions;

public class TraineeDataAccessException extends RuntimeException{

	private static final long serialVersionUID = 3500010559249825882L;

	public TraineeDataAccessException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public TraineeDataAccessException(String message) {
		super(message);
		
	}
	

}
