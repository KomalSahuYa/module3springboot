package com.bookapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookapp.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{
	
	@Query("Select b from Boook b where b.author LIKE %:author%")
	List<Book> findByAuthor(@Param("author") String author);
	
	@Query("Select b from Book b where b.price< :price ")
	List<Book> findbyPrice(@Param("price") Double price);
	
	@Modifying
	@Query("Delete from book b where b.title=:title")
	void deleteByTitle(@Param("title") String title);
	
	@Query("SELECT b FROM Book b ORDER BY b.price DESC")
	List<Book> sortByPriceDesc();
	
	@Query(
	  value = "SELECT * FROM books WHERE price BETWEEN ?1 AND ?2",
	  nativeQuery = true
	)
	List<Book> findByPriceRange(double min, double max);
	
	@Query("SELECT b FROM Book b WHERE b.title LIKE %:keyword%")
	List<Book> getByKeywordInTitle(String Keyword);

}
