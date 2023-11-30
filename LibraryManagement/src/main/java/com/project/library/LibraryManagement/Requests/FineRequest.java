package com.project.library.LibraryManagement.Requests;

import com.project.library.LibraryManagement.Entities.Fines;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FineRequest
{
    private Fines.FinePaymentStatus finePaymentStatus;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private BigDecimal fineAmount;
    private Integer fineId;
    private Integer userId;
    private Integer transactionId;
}
