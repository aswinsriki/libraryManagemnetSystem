package com.project.library.LibraryManagement.controller;

import ch.qos.logback.core.model.Model;
import com.project.library.LibraryManagement.Entities.Author;
import com.project.library.LibraryManagement.Entities.Books;
import com.project.library.LibraryManagement.Entities.Publisher;
import com.project.library.LibraryManagement.Entities.Users;
import com.project.library.LibraryManagement.repository.BookRepository;
import com.project.library.LibraryManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.notFound;

@RestController
@ResponseBody
@RequestMapping("/api/books")
public class BookController
{
    @Autowired
    private BookService bookService;

    // Get all books
    @GetMapping("/all")
    public List<Books> getAllBooks()
    {
        return bookService.getAllBooks();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Books> getBookById(@PathVariable Integer id)
    {
        Optional<Books> requestedBook = bookService.getBookById(id);

        return requestedBook.map(ResponseEntity::ok).orElseGet(() -> notFound().build());
    }



    @GetMapping("/author/{authorName}")
    public ResponseEntity<Books> findByAuthorrName(@PathVariable String authorName)
    {
        Optional<Books> book = bookService.findBooksByAuthorName(authorName);
        return book.map(ResponseEntity::ok).orElseGet(() -> notFound().build());
    }


    @GetMapping("/pubName/{publisherName}")
    public ResponseEntity<Books> getBooksByPublisherName(@PathVariable String publisherName)
    {
        Optional<Books> book = bookService.findBooksByPublisherName(publisherName);
        return book.map(ResponseEntity::ok).orElseGet(() -> notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Books> createBook(@RequestBody Books book) {
        Books savedBook = bookService.createBooks(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Books> updateBookById(@PathVariable Integer id, @RequestBody Books updatedBook) {
        Books updatedBookData = bookService.updateBookById(id, updatedBook);
        return ResponseEntity.ok(updatedBookData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        bookService.deleteBookById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/authorAndPublisher")
    public List<Books> getBooksByAuthorAndPublisherName(@RequestParam String authorName,@RequestParam String publisherName)
    {
        List<Books> user = bookService.findAuthorAndPublisherName(authorName, publisherName);
        return user;
    }

    @GetMapping("/title")
    public List<Books> getBooksByTitle(@RequestParam String title)
    {
        List<Books> books = bookService.findBooksByTitle(title);
        return books;
    }

    @GetMapping("/publicationYear")
    public List<Books> getBooksByPublicationYear(@RequestParam Long publicationYear)
    {
        List<Books> books = bookService.getBooksByPublicationYear(publicationYear);
        return books;
    }

    @DeleteMapping("/authorName")
    public ResponseEntity<Void> deleteBooksByAuthorName(@RequestParam String authorName)
    {
        bookService.deleteBooksByAuthorName(authorName);
        return ResponseEntity.ok().build();
    }
}
