package com.local.library.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.local.library.dto.AuthorDTO;


@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer authorId;
	private String name;
	private String mention;
	
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	
	public String getMention() {
		return mention;
	}
	public void setMention(String mention) {
		this.mention = mention;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.getAuthorId() + ": " + this.getName();
	}
	
	@Override
	public int hashCode() {
		return 22 + super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		AuthorDTO other = (AuthorDTO) obj;
		if (this.getAuthorId() == null) {
			if (other.getAuthorId() != null)
				return false;
		} else if (!this.getAuthorId().equals(other.getAuthorId()))
			return false;
		return true;
	}

	

}
