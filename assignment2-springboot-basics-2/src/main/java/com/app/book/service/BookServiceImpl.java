package com.app.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.book.dto.BookDto;
import com.app.book.entity.Book;
import com.app.book.exceptions.BookNotFoundException;
import com.app.book.repository.BookRepository;
import com.app.book.util.DtoEntityMapper;

@Service
public class BookServiceImpl implements BookService{
	
	private final BookRepository bookRepository;
	

	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public BookDto addBook(BookDto dto) {
		
		return DtoEntityMapper.convertToBookDto(bookRepository.save(DtoEntityMapper.convertToBook(dto)));
	}

	@Override
	public BookDto updateBook(Integer id, BookDto dto) {
		Book bookToUpdate=bookRepository.findById(id);
		if(bookToUpdate==null) {
			throw new BookNotFoundException("Book does not exist");
		}
		bookToUpdate.setTitle(dto.getTitle());
		bookToUpdate.setAuthor(dto.getAuthor());
		bookToUpdate.setPrice(dto.getPrice());
		return DtoEntityMapper.convertToBookDto(bookToUpdate) ;
		
	}

	@Override
	public BookDto getBook(Integer id) {
		Book book=bookRepository.findById(id);
		if(book==null) {
			throw new BookNotFoundException("Book not found");
		}
		return DtoEntityMapper.convertToBookDto(book);
	}

	@Override
	public List<BookDto> getAllBooks() {
		return bookRepository.findAll().stream().map(DtoEntityMapper::convertToBookDto).toList();
	}

	@Override
	public void deleteBook(Integer id) {
		Book bookToDelete=bookRepository.findById(id);
		if(bookToDelete==null) {
			throw new BookNotFoundException("Book does not exist");
		}
		bookRepository.deleteById(id);
		
		
	}

}
