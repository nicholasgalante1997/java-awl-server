package com.local.library.dto;

public class GenreDTO {

	private Integer genreId;
	private String genre;
	
	public Integer getGenreId() {
		return genreId;
	}
	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@Override
	public String toString() {
		return this.getGenreId() + ": " + this.getGenre();
	}

}
