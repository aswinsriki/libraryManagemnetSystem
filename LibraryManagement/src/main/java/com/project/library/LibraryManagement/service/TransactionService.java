package com.project.library.LibraryManagement.service;

import com.project.library.LibraryManagement.Entities.Books;
import com.project.library.LibraryManagement.Entities.Transactions;
import com.project.library.LibraryManagement.Entities.Users;
import com.project.library.LibraryManagement.Requests.TransactionRequest;
import com.project.library.LibraryManagement.repository.BookRepository;
import com.project.library.LibraryManagement.repository.TransactionRepository;
import com.project.library.LibraryManagement.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.time.Duration;
import java.time.LocalDate;

@Service
public class TransactionService
{
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public Transactions createTransactionAndAssociateWithUserAndBook(TransactionRequest transactionRequest) {
        Integer userId = transactionRequest.getUserId();
        Integer bookId = transactionRequest.getBookId();

        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));

        Books book = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with ID: " + bookId));

        Transactions transaction = new Transactions();

        transaction.setTransactionAmount(transactionRequest.getTransactionAmount());
        transaction.setDueDate(transactionRequest.getDueDate());
        transaction.setBorrowedDate(transactionRequest.getBorrowedDate());
        transaction.setTransactionStatus(transactionRequest.getTransactionStatus());

        transaction.setUser(user);
        transaction.setBook(book);
        return transactionRepository.save(transaction);
    }


    public void updateTransactionAmount(Integer transactionId)
    {
        Transactions transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        double amount = calculateTransactionAmount(transaction.getBorrowedDate(), transaction.getDueDate());

        transactionRepository.updateTransactionAmount(transactionId, amount);
    }

    private double calculateTransactionAmount(LocalDate borrowedDate, LocalDate dueDate)
    {
        Duration duration = Duration.between(borrowedDate.atStartOfDay(), dueDate.atStartOfDay());
        long daysDifference = Math.abs(duration.toDays());
        return daysDifference * 20;
    }
}
