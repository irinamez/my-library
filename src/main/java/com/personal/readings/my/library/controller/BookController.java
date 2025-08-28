package com.personal.readings.my.library.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personal.readings.my.library.model.Book;
import com.personal.readings.my.library.service.BookService;

@RestController
@RequestMapping("/api/readings")
public class BookController {
	
	private final BookService bookService;
	
	public BookController(BookService bookService) {
        this.bookService = bookService;
    }
	
	@PostMapping
    public ResponseEntity<Book> createBook(@RequestParam("bookName") String bookName, @RequestParam("bookAuthor") String bookAuthor,
    		@RequestParam("genre") String genre, @RequestParam("status") String status) {
		Book book = Book.builder()
                .name(bookName)
                .author(bookAuthor)
                .genre(genre)
                .build();
		Book createdBook = bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }
	
	@GetMapping("/title")
	public ResponseEntity<Book> getBookByTitle(@RequestParam("bookName") String bookName){
		Book searchedBook = bookService.getBookByTitle(bookName);
		return ResponseEntity.status(HttpStatus.OK).body(searchedBook);
	}
	
	@GetMapping("/author")
	public ResponseEntity<Book> getBookByAuthor(@RequestParam("bookAuthor") String bookAuthor){
		Book searchedBook = bookService.getBookByAuthor(bookAuthor);
		return ResponseEntity.status(HttpStatus.OK).body(searchedBook);
	}
	
	@PutMapping
	public void updateBookDetails(@RequestBody Book book) {
		bookService.updateBook(book);
	}
	
}
