//package com.project.library.LibraryManagement.components;
//
//import com.project.library.LibraryManagement.service.BookService;
//import com.project.library.LibraryManagement.service.CopyService;
//import com.project.library.LibraryManagement.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataLoaderOnStartUp implements CommandLineRunner
//{
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private BookService bookService;
//    @Autowired
//    private CopyService copyService;
//
//
//    @Override
//    public void run(String... args) throws Exception
//    {
//        // Load user data
//        userService.loadUserDataOnStartup();
//        // Load Book data
//        bookService.loadBookDataOnStartup();
//        // Load Copy data
//        copyService.loadCopyDataOnStartUp();
//    }
//}
