package com.local.library.service;

import java.util.List;

import com.local.library.dto.AuthorDTO;
import com.local.library.exceptions.AuthorException;

public interface AuthorService {
	public AuthorDTO getAuthor(Integer authorId) throws AuthorException;
	public List<AuthorDTO> getAllAuthors() throws AuthorException;
	public Integer addAuthor(AuthorDTO author) throws AuthorException;
	public void updateAuthor(Integer authorId, String mention) throws AuthorException;
	public void deleteAuthor(Integer authorId) throws AuthorException;
}
