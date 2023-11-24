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

//
//    @OneToMany(mappedBy = "copies", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Transactions> Copies = new ArrayList<>();


    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "book_id",
            referencedColumnName = "bookId"
    )
    private Books book;
}
