package com.test.Dao;

import org.springframework.data.repository.CrudRepository;

import com.test.Entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
	public Book findById(int id);
}
