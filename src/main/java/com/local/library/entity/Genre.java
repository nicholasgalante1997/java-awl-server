package com.local.library.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.local.library.dto.GenreDTO;

@Entity
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@Override
	public int hashCode() {
		return 22 + super.hashCode();
	}
	
	@Override 
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} 
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		GenreDTO other = (GenreDTO) obj;
		if (this.toString() != other.toString()) {
			return false;
		}
		return true;
	}
}
