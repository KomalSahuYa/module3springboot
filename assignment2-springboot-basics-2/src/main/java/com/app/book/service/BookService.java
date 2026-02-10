package com.app.book.service;

import java.util.List;

import com.app.book.dto.BookDto;

public interface BookService {
	public BookDto addBook(BookDto dto);

	public BookDto updateBook(Integer id, BookDto dto);

	public BookDto getBook(Integer id);

	public List<BookDto> getAllBooks();

	public void deleteBook(Integer id);
}
