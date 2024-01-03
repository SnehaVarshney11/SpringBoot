package com.test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.Entities.Book;
import com.test.Service.BookService;

@RestController //No need to add Response Body
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	// READ ----------------------------
	@GetMapping("/books") 
	public List<Book> getBook() {
		return this.bookService.getAllBooks();
	}
	
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id")int id) {
		return this.bookService.getBook(id);
	}
	
	// CREATE ----------------------------
	@PostMapping("/books") 
	public Book addBook(@RequestBody Book book) {
		Book b = this.bookService.addBook(book);
		return b;
	}
	
	// DELETE ----------------------------
	@DeleteMapping("/books/{bookId}")
	public void deletedBook(@PathVariable("bookId") int bookId) {
		this.bookService.deleteBook(bookId);
	}
	
	// UPDATE ----------------------------
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
		this.bookService.updateBook(book, bookId);
		return book;
	}
	
/*	
	//@RequestMapping(value = "/books", method = RequestMethod.GET)
	//@ResponseBody //return op as String
	@GetMapping("/books")
	public Book getBook() {
		
		Book book = new Book();
        book.setId(1); 
        book.setTitle("Java Edition");
        book.setAuthor("XYZ");

        return book;
	}
	*/
}
