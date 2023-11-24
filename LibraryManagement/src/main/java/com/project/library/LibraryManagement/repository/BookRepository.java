package com.project.library.LibraryManagement.repository;

import com.project.library.LibraryManagement.Entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer>
{
    //custom jpql queries
    Optional<Books> findByAuthorName(String authorName);

    Optional<List<Books>> findByPublisherNameContaining(String publisherName);
}
