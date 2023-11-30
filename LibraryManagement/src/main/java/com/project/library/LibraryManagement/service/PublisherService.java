package com.project.library.LibraryManagement.service;

import com.project.library.LibraryManagement.Entities.Author;
import com.project.library.LibraryManagement.Entities.Books;
import com.project.library.LibraryManagement.Entities.Publisher;
import com.project.library.LibraryManagement.Entities.Users;
import com.project.library.LibraryManagement.repository.BookRepository;
import com.project.library.LibraryManagement.repository.PublisherRepository;
import com.project.library.LibraryManagement.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PublisherService
{
    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public Publisher createPublisherAndAssociateWithUsersAndBooks(Integer publisherId, List<Integer> bookIds, List<Integer> userIds) {
        Publisher publisher = new Publisher();
        publisher.setPublisherId(publisherId);

        List<Users> users = userRepository.findAllById(userIds);
        publisher.setUsers(users);

        List<Books> books = bookRepository.findAllById(bookIds);
        publisher.setBooks(books);

        return publisherRepository.save(publisher);
    }

//    @GetMapping("/getPublisher")
//    public
}
