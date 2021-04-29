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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.local.library.dto.GenreDTO;
import com.local.library.exceptions.GenreException;
import com.local.library.service.GenreService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class GenreAPI {
	
	@Autowired
	private GenreService genreService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping(value = "/genres")
	public ResponseEntity<List<GenreDTO>> getAllGenres() throws GenreException{
		List<GenreDTO> genreList = genreService.getAllGenres();
		return new ResponseEntity<>(genreList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/genres/{genreId}")
	public ResponseEntity<GenreDTO> getGenre(@PathVariable Integer genreId) throws GenreException {
		GenreDTO genreDTO = genreService.getGenre(genreId);
		return new ResponseEntity<>(genreDTO, HttpStatus.OK);
	}
	
	@PostMapping(value = "/genres")
	public ResponseEntity<String> addGenre(@RequestBody GenreDTO genreDTO) throws GenreException {
		Integer genreId = genreService.addGenre(genreDTO);
		String successMessage = "" + genreId;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/genres/{genreId}")
	public ResponseEntity<String> deleteGenre(@PathVariable Integer genreId) throws GenreException {
		genreService.deleteGenre(genreId);
		String successMessage = environment.getProperty("Genre.DELETE_SUCCESS") + genreId;
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}

}
