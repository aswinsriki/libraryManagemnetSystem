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

    public Books(Integer bookId)
    {
        this.bookId = bookId;
    }

    @Column(name = "publisher_name")
    private String publisherName;

    @Column(name = "no_of_copies")
    private Integer noOfCopies;

    @Column(name = "author_name")
    private String authorName;

    private Long publicationYear;

    @OneToMany(
            mappedBy = "book",
            orphanRemoval = true
    )
    private List<Transactions> transactions;


    @OneToMany(
            mappedBy = "book",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Copies> copies;


    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author authors;


    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publishers;

    @ManyToMany
    @JoinTable(
            name = "book_user_map",
            joinColumns = @JoinColumn(
                    name = "book_id",
                    referencedColumnName = "bookId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "userId"
            )
    )
    private List<Users> user;
}

