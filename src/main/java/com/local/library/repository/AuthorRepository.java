package com.local.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.local.library.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer>{

}
