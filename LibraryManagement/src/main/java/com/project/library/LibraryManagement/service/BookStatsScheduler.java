package com.project.library.LibraryManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class BookStatsScheduler
{
    @Autowired
    private BookService bookService;

//    @Scheduled(fixedRate = 180000)
//    public void updateBookStats() {
//        // Update book statistics using bookService
//        bookService.updateBookStats();
//    }
}
