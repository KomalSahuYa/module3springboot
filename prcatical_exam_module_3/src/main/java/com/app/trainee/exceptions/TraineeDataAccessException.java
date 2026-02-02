package com.app.trainee.exceptions;

public class TraineeDataAccessException extends RuntimeException{

	public TraineeDataAccessException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public TraineeDataAccessException(String message) {
		super(message);
		
	}
	

}
