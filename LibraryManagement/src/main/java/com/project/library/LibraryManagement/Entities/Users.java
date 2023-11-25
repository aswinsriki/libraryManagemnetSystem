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

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Transactions> transactions = new ArrayList<>();


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

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private List<Transactions> transaction;
}
