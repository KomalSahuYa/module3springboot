package com.app.book.util;

import com.app.book.dto.BookDto;
import com.app.book.entity.Book;

public class DtoEntityMapper {
	public static BookDto convertToBookDto(Book book) {
		if(book==null) {
			return null;
		}
		BookDto dto=new BookDto();
		dto.setTitle(book.getTitle());
		dto.setAuthor(book.getAuthor());
		dto.setPrice(book.getPrice());
		
		return dto;
		
	}
	
	public static Book convertToBook(BookDto bookdto) {
		if(bookdto==null) {
		return null;
		}
		Book book=new Book();
		book.setTitle(bookdto.getTitle());
		book.setAuthor(bookdto.getAuthor());
		book.setPrice(bookdto.getPrice());
		return book;
		
	}

}
