package com.project.library.LibraryManagement.repository;

import com.project.library.LibraryManagement.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>
{

}
