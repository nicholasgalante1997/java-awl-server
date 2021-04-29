package com.local.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.local.library.dto.BookDTO;
import com.local.library.entity.Book;
import com.local.library.exceptions.BookException;
import com.local.library.repository.BookRepository;

@Service(value = "bookService")
@Transactional
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private Environment environment;

	@Override
	public List<BookDTO> getAllBooks() throws BookException {
		Iterable<Book> books = bookRepository.findAll();
		List<BookDTO> bookList = new ArrayList<>();
		books.forEach(book -> {
			BookDTO b = new BookDTO();
			b.setAuthorId(book.getAuthorId());
			b.setGenreId(book.getGenreId());
			b.setBookId(book.getBookId());
			b.setCoverUrl(book.getCoverUrl());
			b.setSynopsis(book.getSynopsis());
			b.setTitle(book.getTitle());
			bookList.add(b);
		});
		if (bookList.isEmpty()) {
			throw new BookException(environment.getProperty("Book.NONE_FOUND"));
		}
		return bookList;
	}

	@Override
	public BookDTO getBook(Integer bookId) throws BookException {
		Optional<Book> optional = bookRepository.findById(bookId);
		Book book = optional.orElseThrow(() -> new BookException(environment.getProperty("Book.NOT_FOUND")));
		BookDTO bookDTO = new BookDTO();
		bookDTO.setAuthorId(book.getAuthorId());
		bookDTO.setGenreId(book.getGenreId());
		bookDTO.setBookId(book.getBookId());
		bookDTO.setTitle(book.getTitle());
		bookDTO.setCoverUrl(book.getCoverUrl());
		bookDTO.setSynopsis(book.getSynopsis());
		return bookDTO;
	}

	@Override
	public Integer addBook(BookDTO book) throws BookException {
		Book bookEntity = new Book();
		bookEntity.setAuthorId(book.getAuthorId());
		bookEntity.setGenreId(book.getGenreId());
		bookEntity.setBookId(book.getBookId());
		bookEntity.setTitle(book.getTitle());
		bookEntity.setCoverUrl(book.getCoverUrl());
		bookEntity.setSynopsis(book.getSynopsis());
		Book temporaryTransferBook = bookRepository.save(bookEntity);
		return temporaryTransferBook.getBookId();
	}

	@Override
	public void updateBook(Integer bookId, BookDTO book) throws BookException {
		Optional<Book> optional = bookRepository.findById(bookId);
		Book b = optional.orElseThrow(() -> new BookException(environment.getProperty("Book.SUCCESS")));
		b.setCoverUrl(book.getCoverUrl());
		b.setSynopsis(book.getSynopsis());
	}

	@Override
	public void deleteBook(Integer bookId) throws BookException {
		Optional<Book> optional = bookRepository.findById(bookId);
		optional.orElseThrow(() -> new BookException(environment.getProperty("Book.NOT_FOUND")));
		bookRepository.deleteById(bookId);
	}

}
