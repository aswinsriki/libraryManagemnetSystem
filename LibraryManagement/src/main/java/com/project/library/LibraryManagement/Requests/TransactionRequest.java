package com.project.library.LibraryManagement.Requests;

import com.project.library.LibraryManagement.Entities.Transactions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest
{
    private Transactions.TransactionStatus transactionStatus;

    private LocalDate borrowedDate;

    private LocalDate dueDate;

    private BigDecimal transactionAmount;

    private Integer userId;

    private Integer bookId;

    private Integer fineId;
}
