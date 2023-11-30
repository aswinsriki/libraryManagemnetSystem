package com.project.library.LibraryManagement.service;

import com.project.library.LibraryManagement.Entities.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class StatisticsService
{
    @Autowired
    private BookService bookService;

    @Scheduled
    public void updateStatistics()
    {
//        Books bestSellingBook = bookService.findBestSellingBook();
    }
}
