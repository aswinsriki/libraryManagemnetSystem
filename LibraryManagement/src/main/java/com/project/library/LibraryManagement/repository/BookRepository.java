package com.project.library.LibraryManagement.repository;

import com.project.library.LibraryManagement.Entities.Books;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer>
{
    //custom jpql queries
    Optional<Books> findByAuthorName(String authorName);

    Optional<Books> findByPublisherNameContaining(String publisherName);

    List<Books> findByAuthorNameAndPublisherName(String authorName, String publisherName);

    List<Books> findByTitle(String title);

    List<Books> findByPublicationYear(Long publicationYear);



    @Transactional
    @Modifying
    @Query("DELETE FROM Books b WHERE b.authorName = :authorName")
    void deleteByAuthorName(String authorName);


    @Transactional
    @Modifying
    @Query("UPDATE Books b SET b.publicationYear = :year")
    void updatePublicationYear(@Param("year") int publicationYear);
}
