package com.project.library.LibraryManagement.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transactions")
public class Transactions
{
    @Id
    @SequenceGenerator(
            name = "transaction_sequence",
            sequenceName = "transaction_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "transaction_sequence"
    )
    private Integer transactionId;


    private LocalDate dueDate;
    private LocalDate checkOutDate;
    private LocalDate returnDate;


    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "book_id",
            referencedColumnName = "bookId"
    )
    private Books book;


    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "userId"
    )
    private Users user;


    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "copy_id",
            referencedColumnName = "copyId"
    )
    private Copies copy;


    @OneToOne(
            mappedBy = "transaction",
            cascade = CascadeType.ALL
    )
    private Fines fine;

    public enum TransactionStatus
    {
        PAID,
        UNPAID,
    }


    @Column(name = "transaction_status")
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;
}
