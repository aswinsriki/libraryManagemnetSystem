package com.project.library.LibraryManagement.service;

import com.project.library.LibraryManagement.Entities.Fines;
import com.project.library.LibraryManagement.Entities.Transactions;
import com.project.library.LibraryManagement.Entities.Users;
import com.project.library.LibraryManagement.repository.FineRepository;
import com.project.library.LibraryManagement.repository.TransactionRepository;
import com.project.library.LibraryManagement.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class FineService {

    @Autowired
    private FineRepository fineRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

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

    public void createFineAndAssociateWithUserAndTransaction(Integer userId, Integer transactionId, Fines fine) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));

        Transactions transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found with ID: " + transactionId));

        fine.setUser(user);
        fine.setTransaction(transaction);
        fineRepository.save(fine);
    }
}
