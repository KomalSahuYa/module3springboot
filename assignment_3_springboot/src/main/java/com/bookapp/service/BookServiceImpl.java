package com.bookapp.service;

import java.util.List;

import com.bookapp.dto.BookDto;
import com.bookapp.entities.Book;
import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.repository.BookRepository;
import com.bookapp.util.EntityDtoMapper;

public class BookServiceImpl implements BookService{
	private final BookRepository bookRepo;
	
	public BookServiceImpl(BookRepository bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}

	@Override
	public BookDto addBook(BookDto dto) {
		return EntityDtoMapper.convertToBookDto(bookRepo.save(EntityDtoMapper.convertToBook(dto)));
		
	}

	@Override
	public BookDto updateBook(Integer id, BookDto dto) {
		Book bookToUpdate =bookRepo.findById(id).orElseThrow(()->new BookNotFoundException("Book not found"));
		bookToUpdate.setTitle(dto.getTitle());
		bookToUpdate.setAuthor(dto.getAuthor());
		bookToUpdate.setPrice(dto.getPrice());
		Book updatedBook=bookRepo.save(bookToUpdate);
		return EntityDtoMapper.convertToBookDto(updatedBook);
	}

	@Override
	public BookDto getBook(Integer id) {
		
		Book book =bookRepo.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found "));
		return EntityDtoMapper.convertToBookDto(book);
		
		
	}

	@Override
	public List<BookDto> getAllBooks() {
		
		return bookRepo.findAll().stream().map(EntityDtoMapper::convertToBookDto).toList();
	}

	@Override
	public void deleteBook(Integer id) {
		Book book=bookRepo.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found"));
		bookRepo.delete(book);
		
	}
	@Override
	public List<BookDto> getByAuthor(String author){
		return bookRepo.findByAuthor(author).stream().map(EntityDtoMapper::convertToBookDto).toList();
	}
	
	public List<BookDto> getByKeywordInTitle(String keyword){
		return bookRepo.getByKeywordInTitle(keyword).stream().map(EntityDtoMapper::convertToBookDto).toList();
		
	}
	public List<BookDto> getByPriceLessThan(Double Price){
		return null;
	}
	
	@Override
	public List<BookDto> getBooksInPriceRange(Double min,Double max){
		return bookRepo.findByPriceRange(min, max).stream().map(EntityDtoMapper::convertToBookDto).toList();
	}
	

}
