package com.local.library.service;

import java.util.List;

import com.local.library.dto.BookDTO;
import com.local.library.exceptions.BookException;

public interface BookService {
	public List<BookDTO> getAllBooks() throws BookException;
	public BookDTO getBook(Integer bookId) throws BookException;
	public Integer addBook(BookDTO book) throws BookException;
	public void updateBook(Integer bookId, BookDTO book) throws BookException;
	public void deleteBook(Integer bookId) throws BookException;
}
