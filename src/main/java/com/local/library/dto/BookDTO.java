package com.local.library.dto;

public class BookDTO {
	
	private Integer bookId;
	private Integer genreId;
	private Integer authorId;
	private String title;
	private String coverUrl;
	private String synopsis;
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getGenreId() {
		return genreId;
	}
	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
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
	
	@Override
	public String toString() {
		return this.getTitle() + ": " + this.getSynopsis();
	}

}
