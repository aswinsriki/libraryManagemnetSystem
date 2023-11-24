package com.project.library.LibraryManagement.service;

import com.project.library.LibraryManagement.Entities.Books;
import com.project.library.LibraryManagement.Entities.Users;
import com.project.library.LibraryManagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Books> getBookById(Integer id)
    {
        return bookRepository.findById(id);
    }

    public Books createBooks(Books book) {
        return bookRepository.save(book);
    }

    public void deleteBookById(Integer id) {
        bookRepository.deleteById(id);
    }

    public Books updateBookById(Integer id, Books updatedBook)
    {
        Optional<Books> existingUserOptional = bookRepository.findById(id);

        if (existingUserOptional.isPresent()) {
            Books existingBook = existingUserOptional.get();

            existingBook.setBookId(updatedBook.getBookId());

            existingBook.setAuthorName(updatedBook.getAuthorName());

            existingBook.setTitle(updatedBook.getTitle());

            existingBook.setPublisherName(updatedBook.getPublisherName());

            existingBook.setPublicationYear(updatedBook.getPublicationYear());

            return bookRepository.save(existingBook);
        }
        return null;
    }

    public List<Books> findAuthorAndPublisherName(String authorName, String publisherName) {
        return bookRepository.findByAuthorNameAndPublisherName(authorName, publisherName);
    }

    public Optional<Books> findBooksByAuthorName(String authorName) {
        return bookRepository.findByAuthorName(authorName);
    }

    public Optional<Books> findBooksByPublisherName(String publisherName) {
        return bookRepository.findByPublisherNameContaining(publisherName);
    }

    public List<Books> findBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Books> getBooksByPublicationYear(Long publicationYear)
    {
        return bookRepository.findByPublicationYear(publicationYear);
    }

    public void deleteBooksByAuthorName(String authorName)
    {
        bookRepository.deleteByAuthorName(authorName);
    }
}
