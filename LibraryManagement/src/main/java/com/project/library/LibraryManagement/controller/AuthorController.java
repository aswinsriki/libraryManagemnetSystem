package com.project.library.LibraryManagement.controller;

import com.project.library.LibraryManagement.Entities.Author;
import com.project.library.LibraryManagement.Requests.AuthorRequest;
import com.project.library.LibraryManagement.repository.AuthorRepository;
import com.project.library.LibraryManagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/api/author/")
public class AuthorController
{
    @Autowired
    private AuthorService authorService;

    @PostMapping("/create")
    public ResponseEntity<Author> createAuthor(@RequestBody AuthorRequest authorRequest) {
        Author author = authorService.createAuthorAndAssociateWithUsersAndBooks(
                authorRequest.getAuthorId(),
                authorRequest.getBookId(),
                authorRequest.getUserId()
                );
        return ResponseEntity.ok(author);
    }
}
