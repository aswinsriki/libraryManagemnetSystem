package com.project.library.LibraryManagement.controller;

import com.project.library.LibraryManagement.Entities.Transactions;
import com.project.library.LibraryManagement.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/api/fines")
public class FineController
{
    @Autowired
    private FineService fineService;


//    @GetMapping("{userId}/calculateFine")
//    public BigDecimal calculateFine(@PathVariable Long userId)
//    {
//        Transactions transaction;
//        Integer id = transaction.getTransaction(userId);
//
//
//        return fineService.calculateFine(transaction);
//    }

//
//    @GetMapping("/calculate/{userId}")
//    public ResponseEntity<Double> calculateFineValueByUserId(@PathVariable Integer userId)
//    {
//        Double calculatedFineValue = fineService.calculateFineValueByUserId(userId);
//        return ResponseEntity.ok(calculatedFineValue);
//    }
}
