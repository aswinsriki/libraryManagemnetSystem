package com.project.library.LibraryManagement.repository;

import com.project.library.LibraryManagement.Entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer>
{

}
