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
@Table(name = "users")
public class Users
{
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    private Integer userId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String address;
    private Long userPhoneNo;


    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public enum UserType
    {
        ADMIN,
        GUEST,
        STUDENT
    }

    @ManyToMany(mappedBy = "user")
    private List<Books> books;

    @ManyToMany
    @JoinTable(
            name = "user_publisher_map",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "userId"
            ),
            inverseJoinColumns = @JoinColumn(name = "publisher_id")
    )
    private List<Publisher> publishers;

    @ManyToMany
    @JoinTable(
            name = "user_author_map",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "userId"
            ),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authorList;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private List<Transactions> transaction;
}
