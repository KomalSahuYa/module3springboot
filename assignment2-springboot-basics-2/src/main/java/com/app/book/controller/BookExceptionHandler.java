package com.app.book.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.book.exceptions.BookNotFoundException;

@RestControllerAdvice
public class BookExceptionHandler {

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<String> handlenotfound(BookNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
	}
}
