package com.local.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.local.library.dto.GenreDTO;
import com.local.library.entity.Genre;
import com.local.library.exceptions.GenreException;
import com.local.library.repository.GenreRepository;

@Service(value = "genreService")
@Transactional
public class GenreServiceImpl implements GenreService{
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Autowired
	private Environment environment;

	@Override
	public GenreDTO getGenre(Integer genreId) throws GenreException {
		Optional<Genre> optional = genreRepository.findById(genreId);
		Genre genre = optional.orElseThrow(() -> new GenreException(environment.getProperty("Genre.NOT_FOUND")));
		GenreDTO genreDTO = new GenreDTO();
		genreDTO.setGenreId(genre.getGenreId());
		genreDTO.setGenre(genre.getGenre());
		return genreDTO;
	}

	@Override
	public List<GenreDTO> getAllGenres() throws GenreException {
		Iterable<Genre> genres = genreRepository.findAll();
		List<GenreDTO> genreList = new ArrayList<>();
		genres.forEach(genre -> {
			GenreDTO genreDTO = new GenreDTO();
			genreDTO.setGenre(genre.getGenre());
			genreDTO.setGenreId(genre.getGenreId());
			genreList.add(genreDTO);
		});
		if (genreList.isEmpty()) { 
			throw new GenreException(environment.getProperty("Genre.NONE_FOUND"));
		}
		return genreList;
	}

	@Override
	public Integer addGenre(GenreDTO genre) throws GenreException {
		Genre genreEntity = new Genre();
		genreEntity.setGenreId(genre.getGenreId());
		genreEntity.setGenre(genre.getGenre());
		Genre temporaryGenreDTO = genreRepository.save(genreEntity);
		return temporaryGenreDTO.getGenreId();
	}

	@Override
	public void deleteGenre(Integer genreId) throws GenreException {
		Optional<Genre> optional = genreRepository.findById(genreId);
		optional.orElseThrow(() -> new GenreException(environment.getProperty("Genre.DELETE_SUCCESS")));
		genreRepository.deleteById(genreId);
	}

}
