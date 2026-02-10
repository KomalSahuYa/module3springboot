package com.bookapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
@Table(name="books")
public class Book {
	private Integer id;
	private String title;
	private String author;
	private Double price;
	private String isbn;
	private String category;
	public Book(String title, String author, Double price, String isbn, String category) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.isbn = isbn;
		this.category = category;
	}

	
}
