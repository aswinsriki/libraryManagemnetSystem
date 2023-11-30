package com.project.library.LibraryManagement.controller;

import org.springframework.ui.Model;
import com.project.library.LibraryManagement.Entities.Books;
import com.project.library.LibraryManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DisplayBooksController
{
    @Autowired
    private BookService bookService;

    @GetMapping("/displayAllBooks")
    public String displayAllBooks(Model model) {
        List<Books> books = bookService.getAllBooks();
        model.addAttribute("Books", books);
        return "displayAllBooks";
    }
}
