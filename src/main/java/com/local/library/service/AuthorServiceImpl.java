package com.local.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.local.library.dto.AuthorDTO;
import com.local.library.entity.Author;
import com.local.library.exceptions.AuthorException;
import com.local.library.repository.AuthorRepository;

@Service(value = "authorService")
@Transactional
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public AuthorDTO getAuthor(Integer authorId) throws AuthorException{
		Optional<Author> opt = authorRepository.findById(authorId);
		Author author = opt.orElseThrow(() -> new AuthorException("Author.NOT_FOUND"));
		AuthorDTO author2 = new AuthorDTO();
		author2.setAuthorId(author.getAuthorId());
		author2.setMention(author.getMention());
		author2.setName(author.getName());
		return author2;
	}

	@Override
	public List<AuthorDTO> getAllAuthors() throws AuthorException{
		Iterable<Author> authors = authorRepository.findAll();
		List<AuthorDTO> authorList = new ArrayList<>();
		authors.forEach((author) -> {
			AuthorDTO a = new AuthorDTO();
			a.setName(author.getName());
			a.setAuthorId(author.getAuthorId());
			a.setMention(author.getMention());
			authorList.add(a);
		});
		if (authorList.isEmpty()) {
			throw new AuthorException("Author.NONE_FOUND");
		}
		return authorList;
	}

	@Override
	public Integer addAuthor(AuthorDTO author) throws AuthorException{
		Author authorEntity = new Author();
		authorEntity.setAuthorId(author.getAuthorId());
		authorEntity.setMention(author.getMention());
		authorEntity.setName(author.getName());
		Author authorEntity2 = authorRepository.save(authorEntity);
		return authorEntity2.getAuthorId();
	}

	@Override
	public void updateAuthor(Integer authorId, String mention) throws AuthorException{
		Optional<Author> author = authorRepository.findById(authorId);
		Author a = author.orElseThrow(() -> new AuthorException("Author.NOT_FOUND"));
		a.setMention(mention);
	}

	@Override
	public void deleteAuthor(Integer authorId) throws AuthorException{
		Optional<Author> author = authorRepository.findById(authorId);
		author.orElseThrow(() -> new AuthorException("Author.NOT_FOUND"));
		authorRepository.deleteById(authorId);
	}
	
}
