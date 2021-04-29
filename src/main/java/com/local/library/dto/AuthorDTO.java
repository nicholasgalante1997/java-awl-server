package com.local.library.dto;

public class AuthorDTO {
	
	private Integer authorId;
	private String name;
	private String mention;
	
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMention() {
		return mention;
	}
	public void setMention(String mention) {
		this.mention = mention;
	}
	
	@Override
	public String toString() {
		return this.getAuthorId() + ": " + this.getName();
	}

}
