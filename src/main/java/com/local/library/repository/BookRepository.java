package com.local.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.local.library.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{

}
