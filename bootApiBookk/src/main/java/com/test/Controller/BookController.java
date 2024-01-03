package com.test.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Book>> getBook() {
		List<Book> list = this.bookService.getAllBooks();
		if(list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //build is used to create proper object
		}
		return ResponseEntity.of(Optional.of(list));
 	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id")int id) {
		Book book = this.bookService.getBook(id);
		
		if(book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(book));
	}
	
	// CREATE ----------------------------
	@PostMapping("/books") 
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b = null;
		
		try {
			b = this.bookService.addBook(book);
			System.out.println(book);
			return ResponseEntity.of(Optional.of(b));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	// DELETE ----------------------------
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Void> deletedBook(@PathVariable("bookId") int bookId) {
		
		try {
			this.bookService.deleteBook(bookId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	// UPDATE ----------------------------
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
		
		try {
			this.bookService.updateBook(book, bookId);
			return ResponseEntity.ok().body(book);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
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
