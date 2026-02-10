package com.app.book.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.book.dto.BookDto;
import com.app.book.service.BookService;

@RestController
@RequestMapping("api/books")
public class BookController {
	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@PostMapping
	public BookDto add(@RequestBody BookDto dto) {
		return bookService.addBook(dto);
	}
	
	@GetMapping("/{id}")
		public BookDto get(@PathVariable Integer id) {
			return bookService.getBook(id);
		}
	
	@PutMapping("/{id}")
	public BookDto update(@PathVariable Integer id,BookDto dto) {
		return bookService.updateBook(id, dto);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		bookService.deleteBook(id);
	}

}
