package com.local.library.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.local.library.dto.BookDTO;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;
	private Integer authorId;
	private Integer genreId;
	private String title;
	private String coverUrl;
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	public Integer getGenreId() {
		return genreId;
	}
	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCoverUrl() {
		return coverUrl;
	}
	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	private String synopsis;

	@Override
	public String toString() {
		return this.getTitle() + ": " + this.getSynopsis();
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
		BookDTO other = (BookDTO) obj;
		if (this.toString() != other.toString()) {
			return false;
		}
		return true;
	}

}
