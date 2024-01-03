package com.test.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.test.Entities.Book;

@Component //Can also use @Service
public class BookService {
	
	private static List<Book> listBook = new ArrayList<Book>();
	
	static {
		listBook.add(new Book(12, "Java", "XYZ"));
		listBook.add(new Book(2, "Python", "ABC"));
		listBook.add(new Book(23, "C++", "PS"));
		listBook.add(new Book(3, "C", "PO"));
	}
	
	//get all books
	public List<Book> getAllBooks() {
		return listBook;
	}
	
	//get single book
	public Book getBook(int id) {
		Book book = null;
		book = listBook.stream().filter(e->e.getId()==id).findFirst().get();
		return book;
	}
}
