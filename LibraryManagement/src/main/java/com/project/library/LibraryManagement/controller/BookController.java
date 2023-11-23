package com.project.library.LibraryManagement.controller;

import com.project.library.LibraryManagement.Entities.Books;
import com.project.library.LibraryManagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@ResponseBody
@RequestMapping("/api/books")
public class BookController
{
    @Autowired
    private BookRepository bookRepository;

    // Get all books
    @GetMapping
    public List<Books> getAllBooks()
    {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Books> getBookById(@PathVariable Integer id)
    {
        Optional<Books> requestedBook = bookRepository.findById(id);

        return requestedBook.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Books> createBook(@RequestBody Books book) {
        Books savedBook = bookRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Books> updateBook(@PathVariable Integer id, @RequestBody Books updatedBook) {
        if (!bookRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedBook.setBookId(id);
        Books savedBook = bookRepository.save(updatedBook);
        return ResponseEntity.ok(savedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        if (!bookRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
