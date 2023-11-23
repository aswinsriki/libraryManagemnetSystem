package com.project.library.LibraryManagement.repository;

import com.project.library.LibraryManagement.Entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer>
{

}
