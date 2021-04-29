package com.local.library.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.local.library.dto.BookDTO;
import com.local.library.exceptions.BookException;
import com.local.library.service.BookService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class BookAPI {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping(value = "/books")
	public ResponseEntity<List<BookDTO>> getAllBooks() throws BookException {
		List<BookDTO> b = bookService.getAllBooks();
		return new ResponseEntity<>(b, HttpStatus.OK);
	}
	
	@GetMapping(value = "/books/{bookId}")
	public ResponseEntity<BookDTO> getBook(@PathVariable Integer bookId) throws BookException {
		BookDTO b = bookService.getBook(bookId);
		return new ResponseEntity<>(b, HttpStatus.OK);
	}
	
	@PostMapping(value = "/books")
	public ResponseEntity<String> addBook(@RequestBody BookDTO book) throws BookException {
		Integer bookId = bookService.addBook(book);
		String successMessage = "" + bookId;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/books/{bookId}")
	public ResponseEntity<String> updateBook(@PathVariable Integer bookId, @RequestBody BookDTO book) throws BookException{
		bookService.updateBook(bookId, book);
		String successMessage = environment.getProperty("Book.UPDATE_SUCCESS") + " -- " + bookId;
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/books/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable Integer bookId) throws BookException {
		bookService.deleteBook(bookId);
		String successMessage = environment.getProperty("Book.DELETE_SUCCESS") + " -- " + bookId;
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}

}
