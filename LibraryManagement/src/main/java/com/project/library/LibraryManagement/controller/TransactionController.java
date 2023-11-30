package com.project.library.LibraryManagement.controller;

import com.project.library.LibraryManagement.Entities.Transactions;
import com.project.library.LibraryManagement.Requests.TransactionRequest;
import com.project.library.LibraryManagement.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PutMapping("/{transactionId}/updateTransactionAmount")
    public ResponseEntity<String> updateTransactionAmount(@PathVariable Integer transactionId)
    {
        try
        {
            transactionService.updateTransactionAmount(transactionId);
            return ResponseEntity.ok("Transaction amount updated Successfully");
        }
        catch(RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("transaction with that transactionId not found");
        }
    }
}
