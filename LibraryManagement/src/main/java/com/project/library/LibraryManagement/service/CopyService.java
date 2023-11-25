package com.project.library.LibraryManagement.service;

import com.project.library.LibraryManagement.Entities.Copies;
import com.project.library.LibraryManagement.Entities.Transactions;
import com.project.library.LibraryManagement.repository.CopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class CopyService
{
    @Autowired
    private CopyRepository copyRepository;

    public double calculateFine(Transactions transaction)
    {
        double fineValue = 0.0;

        if(transaction.getReturnDate().isAfter(transaction.getDueDate()))
        {
            long daysOverDue = ChronoUnit.DAYS.between(transaction.getDueDate(), transaction.getReturnDate());
            fineValue = daysOverDue * 2;
        }
        return fineValue;
    }
}
