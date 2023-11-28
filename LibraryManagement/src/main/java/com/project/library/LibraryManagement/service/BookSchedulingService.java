//package com.project.library.LibraryManagement.service;
//
//import com.project.library.LibraryManagement.Entities.Books;
//import com.project.library.LibraryManagement.repository.BookRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//public class BookSchedulingService
//{
//    @Autowired
//    private BookRepository bookRepository;
//
//    private static final Logger logger = LoggerFactory.getLogger(BookSchedulingService.class);
//
//    @Scheduled(fixedRate = 1000)
//    public void updateTable()
//    {
//        try
//        {
//            int currentYear = LocalDateTime.now().getYear();
//            bookRepository.updatePublicationYear(currentYear);
//            logger.info("Updating publication table - Set publication year to {}", currentYear);
//            Thread.sleep(10000);
//        }
//        catch(InterruptedException e)
//        {
//            e.printStackTrace();
//        }
//    }
//}
