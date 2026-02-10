package com.app.trainee.controller;





import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.trainee.exceptions.TraineeDataAccessException;

@RestControllerAdvice
public class ExceptionHandlerController {
	
	
	@ExceptionHandler(TraineeDataAccessException.class)
    public ResponseEntity<String> handleNotFound(TraineeDataAccessException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

}
