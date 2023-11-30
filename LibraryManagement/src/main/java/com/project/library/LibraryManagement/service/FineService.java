package com.project.library.LibraryManagement.service;

import com.project.library.LibraryManagement.Entities.Fines;
import com.project.library.LibraryManagement.Entities.Transactions;
import com.project.library.LibraryManagement.Entities.Users;
import com.project.library.LibraryManagement.Requests.FineRequest;
import com.project.library.LibraryManagement.repository.FineRepository;
import com.project.library.LibraryManagement.repository.TransactionRepository;
import com.project.library.LibraryManagement.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
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

    public double calculateFine(LocalDate dueDate, LocalDate returnDate)
    {
        Duration duration = Duration.between(dueDate.atStartOfDay(), returnDate.atStartOfDay());
        long daysDifference = Math.abs(duration.toDays());
        return daysDifference * 10;
    }

    public Fines createFineAndAssociateWithUserAndTransaction(FineRequest fineRequest)
    {
        Integer userId = fineRequest.getUserId();
        Integer transactionId = fineRequest.getTransactionId();

        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));

        Transactions transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found with ID: " + transactionId));

        Fines fines = new Fines();

        fines.setUser(user);
        fines.setTransaction(transaction);

        fines.setFineAmount(fineRequest.getFineAmount());
        fines.setFinePaymentStatus(fineRequest.getFinePaymentStatus());
        fines.setDueDate(fineRequest.getDueDate());
        fines.setReturnDate(fineRequest.getReturnDate());

        return fineRepository.save(fines);
    }

    public void updateFineAmount(Integer fineId)
    {
        Fines fine = fineRepository.findById(fineId)
                .orElseThrow(() -> new RuntimeException("Fine not found with ID" + fineId));
        double fineAmount = calculateFine(fine.getDueDate(), fine.getReturnDate());
        fineRepository.updateFineAmount(fineId, fineAmount);
    }
}
