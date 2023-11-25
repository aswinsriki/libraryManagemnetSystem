package com.project.library.LibraryManagement.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "copies")
public class Copies
{
    @Id
    @SequenceGenerator(
            name = "copy_sequence",
            sequenceName = "copy_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "copy_sequence"
    )
    private int copyId;


    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "book_id",
            referencedColumnName = "bookId"
    )
    private Books book;


    @OneToMany(
            mappedBy = "copy",
            orphanRemoval = true
    )
    private List<Transactions> transactions;


    private Integer noOfCopies;

    @Column(name = "availability_status")
    @Enumerated(EnumType.STRING)
    private AvailabilityStatus availabilityStatus;


    @Column(name="physical_condition")
    @Enumerated(EnumType.STRING)
    private PhysicalCondition physicalCondition;

    public enum AvailabilityStatus
    {
        AVAILABLE,
        BORROWED,
        DAMAGED
    }

    public enum PhysicalCondition
    {
        GOOD,
        FAIR,
        DAMAGED
    }
}
