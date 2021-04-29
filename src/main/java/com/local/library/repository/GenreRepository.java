package com.local.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.local.library.entity.Genre;

public interface GenreRepository extends CrudRepository<Genre, Integer>{

}
