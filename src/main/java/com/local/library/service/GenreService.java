package com.local.library.service;

import java.util.List;

import com.local.library.dto.GenreDTO;
import com.local.library.exceptions.GenreException;

public interface GenreService {
	public GenreDTO getGenre(Integer genreId) throws GenreException;
	public List<GenreDTO> getAllGenres() throws GenreException;
	public Integer addGenre(GenreDTO genre) throws GenreException;
	public void deleteGenre(Integer genreId) throws GenreException;
}
