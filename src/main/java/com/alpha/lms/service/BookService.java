package com.alpha.lms.service;

import java.util.List;

import com.alpha.lms.entity.Book;

public interface BookService {

	List<Book> findAll();
	
	Book findById(Long id);
	
	Book save(Book book);
	
	void deleteById(Long id);
	
	Book borrowBook(Long bookId, Long userId);
	
	Book returnBook(Long bookId);
}
