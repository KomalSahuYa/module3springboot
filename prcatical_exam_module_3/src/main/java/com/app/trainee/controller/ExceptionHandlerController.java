package com.app.trainee.controller;

import java.time.LocalDateTime;

import org.antlr.v4.runtime.atn.ErrorInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.trainee.exceptions.TraineeDataAccessException;

@RestControllerAdvice
public class ExceptionHandlerController {
	
	@Value("${TRAINEE_NOT_FOUND_MESSAGE}")
	private String errorMessage404;
	
	@ExceptionHandler(TraineeDataAccessException.class)
    public ResponseEntity<String> handleNotFound(TraineeDataAccessException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

}
