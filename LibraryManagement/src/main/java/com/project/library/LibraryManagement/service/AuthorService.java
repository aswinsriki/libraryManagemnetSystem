package com.project.library.LibraryManagement.service;

import com.project.library.LibraryManagement.Entities.Author;
import com.project.library.LibraryManagement.Entities.Books;
import com.project.library.LibraryManagement.Entities.Users;
import com.project.library.LibraryManagement.Requests.AuthorRequest;
import com.project.library.LibraryManagement.repository.AuthorRepository;
import com.project.library.LibraryManagement.repository.BookRepository;
import com.project.library.LibraryManagement.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

//    public void createAuthorAndAssociateWithBooks(AuthorRequest authorRequest)
//    {
//        Author author = new Author();
//
//        author.setAuthorId(authorRequest.getAuthorId());
//        author.setBooks(authorRequest.getBookId());
//        author.setUser(authorRequest.getUsers());
//
//        Books books = bookRepository.findById(authorRequest.getBookId())
//    }

    public Author createAuthorAndAssociateWithUsersAndBooks(Integer authorId, List<Integer> bookIds, List<Integer> userIds) {
        Author author = new Author();
        author.setAuthorId(authorId);

        List<Users> users = userRepository.findAllById(userIds);
        author.setUser(users);

        List<Books> books = bookRepository.findAllById(bookIds);
        author.setBooks(books);

        return authorRepository.save(author);
    }
}
