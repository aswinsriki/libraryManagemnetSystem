package com.project.library.LibraryManagement.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToOne
    @JoinColumn(name = "transaction_id")
    private Transactions transaction;


    private Long fineAmount;

    private String paymentStatus;

    private LocalDate paymentDate;
}
