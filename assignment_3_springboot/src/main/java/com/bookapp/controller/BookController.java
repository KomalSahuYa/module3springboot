package com.bookapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.dto.BookDto;
import com.bookapp.service.BookService;

@RestController
@RequestMapping("/api/books")
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
	
	@GetMapping
	public List<BookDto> getAll(){
		return bookService.getAllBooks();
	}
	
	@DeleteMapping
	public void delete(@PathVariable Integer id) {
		bookService.deleteBook(id);
	}
	
	//search by author
	@GetMapping("/author/{author}")
	public List<BookDto> getByAuthor(@PathVariable String author){
		return bookService.getByAuthor(author);
	}
	
	

}
