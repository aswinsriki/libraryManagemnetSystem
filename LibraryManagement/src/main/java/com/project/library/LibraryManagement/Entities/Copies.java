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
    private Integer copyId;

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

    @Column(name = "availability_status")
    @Enumerated(EnumType.STRING)
    private AvailabilityStatus availabilityStatus;


    @Column(name="physical_condition")
    @Enumerated(EnumType.STRING)
    private PhysicalCondition physicalCondition;



    @ManyToOne
    @JoinColumn(
            name = "book_id",
            referencedColumnName = "bookId"
    )
    private Books book;
}
