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

import com.local.library.dto.AuthorDTO;
import com.local.library.exceptions.AuthorException;
import com.local.library.service.AuthorService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class AuthorAPI {

	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping(value = "/authors")
	public ResponseEntity<List<AuthorDTO>> getAllAuthors() throws AuthorException{
		List<AuthorDTO> authorList = authorService.getAllAuthors();
		return new ResponseEntity<>(authorList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/authors/{authorId}")
	public ResponseEntity<AuthorDTO> getAuthor(@PathVariable Integer authorId)throws AuthorException{
		AuthorDTO author = authorService.getAuthor(authorId);
		return new ResponseEntity<>(author, HttpStatus.OK);
	}
	
	@PostMapping(value = "/authors")
	public ResponseEntity<String> addAuthor(@RequestBody AuthorDTO author)throws AuthorException {
		Integer authorId = authorService.addAuthor(author);
		String successMessage = "" + authorId;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/authors/{authorId}")
	public ResponseEntity<String> updateAuthor(@PathVariable Integer authorId, @RequestBody String mention) throws AuthorException {
		authorService.updateAuthor(authorId, mention);
		String successMessage = environment.getProperty("Author.UPDATE_SUCCESS") + " WITH AN ID OF " + authorId;
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/authors/{authorId}")
	public ResponseEntity<String> deleteAuthor(@PathVariable Integer authorId) throws AuthorException {
		authorService.deleteAuthor(authorId);
		String successMessage = environment.getProperty("Author.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
}
