package com.bookapp.util;

import com.bookapp.dto.BookDto;
import com.bookapp.entities.Book;

public class EntityDtoMapper {
	public static Book convertToBook(BookDto bookDto) {
		if(bookDto==null) {
			return null;
		}
		Book book =new Book();
		
		book.setTitle(bookDto.getTitle());
		book.setAuthor(bookDto.getAuthor());
		book.setPrice(bookDto.getPrice());
		book.setIsbn(bookDto.getIsbn());
		book.setCategory(bookDto.getCategory());
		
		return book;
	}
	public static BookDto convertToBookDto(Book book) {
		if(book==null) {
			return null;
		}
		BookDto dto=new BookDto();
		dto.setTitle(book.getTitle());
		dto.setAuthor(book.getAuthor());
		dto.setPrice(book.getPrice());
		dto.setIsbn(book.getIsbn());
		dto.setCategory(book.getCategory());
		return dto;
		
	}

}
