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
@Table(name = "author")
public class Author
{
    @Id
    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "author_sequence"
    )
    private Integer authorId;


    /*
     There are two fetch types in Spring data jpa -
         (i) FetchType.EAGER - If we want to fetch both the table values, for EG: there's relationship between the two tables Books and Authors - we want to fetch the values from both the tables, then we can use EAGER fetch type.
        (ii) FetchType.LAZY - If we want to fetch only the values in the table that we want, we can specify the LAZY fetch type.
             We can exclude the values that we don't want, by using the @toString annotation and then just type exclude = ""  and inside these quotes, type what values you don't want.


     Uni directional and bi Directional relationships:
        (i) Use case of UniDirectional Relationships:
                For EG: We have course and courseMaterial Classes, we want the values in both the tables to be displayed.
                But we only have the course Repository and how can we get the courseMaterials values from the courseRepository.
                        If we use the uniDirectional relationship, then there is nothing wrong, we can use the default setup.

                Now, if we want both the Courses and CourseMaterials information to be displayed when we print the Courses from the courseRepository, then we need to define a bi-Directional relationship.
                If we want to define biDirectional relationship, let's go to the Course class and mention along with the foreign key that it is mappedBy this reference variable.
     */


    @OneToMany(
            mappedBy = "author", // this is the reference variable that we used to reference this class Author.
            cascade = CascadeType.ALL,
            orphanRemoval = true
            // we cannot use joinColumn here because it is already defined in the other class where it was linked OneToOne.
    )
    private List<Books> books = new ArrayList<>();
}
