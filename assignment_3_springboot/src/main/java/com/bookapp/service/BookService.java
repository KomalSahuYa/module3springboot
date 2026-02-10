package com.bookapp.service;
import java.util.List;

import com.bookapp.dto.BookDto;


public interface BookService {
	public BookDto addBook(BookDto dto);

	public BookDto updateBook(Integer id, BookDto dto);

	public BookDto getBook(Integer id);

	public List<BookDto> getAllBooks();

	public void deleteBook(Integer id);
	
	public List<BookDto> getByAuthor(String author);
	
	public List<BookDto> getBooksInPriceRange(Double min,Double max);
}
