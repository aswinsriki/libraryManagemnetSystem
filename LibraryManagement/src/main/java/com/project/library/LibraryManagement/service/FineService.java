package com.project.library.LibraryManagement.service;

import com.project.library.LibraryManagement.Entities.Fines;
import com.project.library.LibraryManagement.Entities.Transactions;
import com.project.library.LibraryManagement.repository.FineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class FineService {

    @Autowired
    private FineRepository fineRepository;

//    @Autowired
//    private Transactions transaction;
//
////    public Double calculateFineValueByUserId(Integer userId) {
////        List<Fines> fines = fineRepository.findByUserId(userId);
////
////        return calculateFine();
////    }
//
//    public double calculateFine() {
//
//        double fineValue = 0.0;
//
//        if (transaction.getReturnDate().isAfter(transaction.getDueDate())) {
//            long daysOverdue = ChronoUnit.DAYS.between(transaction.getDueDate(), transaction.getReturnDate());
//            fineValue = daysOverdue * 2.0;
//        }
//        return fineValue;
//    }
}
