package com.project.library.LibraryManagement.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
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


    //    private LocalDate paymentDate;
    private LocalDate borrowedDate;
    private LocalDate dueDate; // assume returnDate and paymentDate are same in the transaction table.
                               // Only when the returnDate and paymentDate are not same, it becomes a late return and therefore, the user with that userId would've to pay the fineAmount. Otherwise, the user would have to pay only the normalAmount.

    private BigDecimal transactionAmount;

    public enum TransactionStatus
    {
        PAID,
        UNPAID,
    }

    @Column(name = "transaction_status")
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

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
            name = "book_id",
            referencedColumnName = "bookId"
    )
    private Books book;


    @OneToOne(
            mappedBy = "transaction",
            cascade = CascadeType.ALL
    )
    private Fines fine;
}
