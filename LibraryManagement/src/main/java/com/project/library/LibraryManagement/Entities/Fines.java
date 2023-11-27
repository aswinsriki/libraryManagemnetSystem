package com.project.library.LibraryManagement.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "fines")
public class Fines
{
    @Id
    @SequenceGenerator(
            name = "fine_sequence",
            sequenceName = "fine_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "fine_sequence"
    )
    Integer fineId;

    private BigDecimal fineAmount;

    @Enumerated
    @Column(name = "payment_status")
    private FinePaymentStatus finePaymentStatus;

    private LocalDate dueDate;
    private LocalDate returnDate;

    public enum FinePaymentStatus{
        PAID,
        UNPAID
    }

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "userId"
    )
    private Users user;

    @OneToOne
    @JoinColumn(
            name = "transaction_id",
            referencedColumnName = "transactionId"
    )
    private Transactions transaction;
}
