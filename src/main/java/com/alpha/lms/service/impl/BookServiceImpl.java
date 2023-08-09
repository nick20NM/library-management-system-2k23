package com.alpha.lms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.lms.entity.Book;
import com.alpha.lms.entity.User;
import com.alpha.lms.repository.BookRepository;
import com.alpha.lms.repository.UserRepository;
import com.alpha.lms.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book findById(Long id) {
		return bookRepository.findById(id).orElse(null);
	}

	@Override
	public Book save(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public void deleteById(Long id) {
		bookRepository.deleteById(id);
	}

	@Override
	public Book borrowBook(Long bookId, Long userId) {
		Book book = findById(bookId);
		User user = userRepository.findById(userId).orElse(null);

		if (book != null && !book.isBorrowed() && user != null) {
			System.out.println("!book.isBorrowed()="+!book.isBorrowed());
			book.setBorrowedBy(user);
			book.setBorrowed(true);
			return save(book);
		}
		// Handle errors (e.g., book not found, book already borrowed, user not found)
		return null;
	}

	@Override
	public Book returnBook(Long bookId) {
		Book book = findById(bookId);
		
		if (book!=null && book.isBorrowed()) {
			System.out.println("book.isBorrowed()="+book.isBorrowed());
			book.setBorrowedBy(null);
			book.setBorrowed(false);
			return save(book);
		}
		// Handle errors (e.g., book not found, book not borrowed)
		return null;
	}

}
