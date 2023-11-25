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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Publisher
{
    @Id
    @SequenceGenerator(
            name = "publisher_sequence",
            sequenceName = "publisher_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "publisher_sequence"
    )
    private Integer publisherId;

//
//    @OneToOne(
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY,
//            optional = false // this means that only if we add the value in the Books table, only then we can add values into the Publishers column.
//    )

    @OneToMany(
            mappedBy = "publisher", // this is the reference variable that we used to reference this class Publisher.
            cascade = CascadeType.ALL,
            orphanRemoval = true
            // we cannot use joinColumn here because it is already defined in the other class where it was linked OneToOne.
    )
    private List<Books> books = new ArrayList<>();
}
