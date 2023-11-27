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

//    public Double calculateFineValueByFineId(Integer fineId) {
//        List<Fines> fines = fineRepository.findByFineId(fineId);
//
//        return calculateFine();
//    }

    public double calculateFine(Fines fines) {

        double fineValue = 0.0;

        if (fines.getReturnDate().isAfter(fines.getDueDate())) {
            long daysOverdue = ChronoUnit.DAYS.between(fines.getDueDate(), fines.getReturnDate());
            fineValue = daysOverdue * 2.0;
        }
        return fineValue;
    }
}
