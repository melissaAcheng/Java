package com.melissacheng.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.melissacheng.mvc.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	// Retrieves all books from the database
	List<Book> findAll();
	// Finds books with descriptions containing the search string
	List<Book> findByDescriptionContaining(String search);
	// Counts how many titles contain a certain string
	Long countByTitleContaining(String search);
	// Deletes a book that starts with a specific title
	Long deleteByTitleStartingWith(String search);
}
