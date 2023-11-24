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
@Table(name = "books")
public class Books {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Integer bookId;
    private String title;

    @Column(name = "publisher_name")
    private String publisherName;

    @Column(name = "author_name")
    private String authorName;

    private Long publicationYear;

//    @OneToMany(
//            cascade = CascadeType.ALL
//    )
//
//    @JoinColumn(
//            name = "book_id",
//            referencedColumnName = "bookId"
//    )
//    private List<Copies> copies;

//    @OneToMany(mappedBy = "books", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Transactions> Copies = new ArrayList<>();
//
//    @OneToMany(mappedBy = "books", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Transactions> Transactions = new ArrayList<>();


    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private Author author;

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private Publisher publisher;
}

