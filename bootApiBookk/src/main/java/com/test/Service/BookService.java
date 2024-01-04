package com.test.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.Dao.BookRepository;
import com.test.Entities.Book;

@Component //Can also use @Service
public class BookService {

	//private static List<Book> listBook = new ArrayList<Book>();
	
	/*
	static {
		listBook.add(new Book(12, "Java", "XYZ"));
		listBook.add(new Book(2, "Python", "ABC"));
		listBook.add(new Book(23, "C++", "PS"));
		listBook.add(new Book(3, "C", "PO"));
	}
	*/
	
	@Autowired
	private BookRepository bookRepository;
	
	//get all books
	public List<Book> getAllBooks() {
		//return listBook;
		List<Book> listBook = (List<Book>) this.bookRepository.findAll();
		return listBook;
	}
	
	
	//get single book
	public Book getBook(int id) {
		Book book = null;
		try {
			//book = listBook.stream().filter(e->e.getId()==id).findFirst().get();
			book = this.bookRepository.findById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return book;
	}
	
	// Creation ----------------------
	//adding the book -  called by controller
	public Book addBook(Book b) {
		//listBook.add(b);
		//return b;
		Book res = bookRepository.save(b);
		return res;
	}
	
	// Deletion ----------------------
	public void deleteBook(int bookId) {
        //listBook = listBook.stream().filter(book -> book.getId() != bookId).collect(Collectors.toList());
		bookRepository.deleteById(bookId);
    }
	
	// Update ----------------------
	// BookService.java
	public void updateBook(Book book, int bookId) {
		/*
	    listBook = listBook.stream().map(b -> {
	        if (b.getId() == bookId) {
	            b.setTitle(book.getTitle());
	            b.setAuthor(book.getAuthor());
	        }
	        return b;
	    }).collect(Collectors.toList());
	    */
		book.setId(bookId);
		bookRepository.save(book);
	}

}
