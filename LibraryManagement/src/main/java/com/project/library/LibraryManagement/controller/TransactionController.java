package com.project.library.LibraryManagement.controller;

import com.project.library.LibraryManagement.Entities.Transactions;
import com.project.library.LibraryManagement.Requests.TransactionRequest;
import com.project.library.LibraryManagement.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/api/transaction/")
public class TransactionController
{

    @Autowired
    private TransactionService transactionService;
    @PostMapping("/creatingTransaction")
    public ResponseEntity<Transactions> createTransactionAlongWithBookAndUserAndFine(@RequestBody TransactionRequest transactionRequest)
    {
        Transactions createdTransactions = transactionService.createTransactionAndAssociateWithUserAndBook(transactionRequest);
        return ResponseEntity.ok(createdTransactions);
    }
}
