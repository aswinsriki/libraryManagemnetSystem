package com.project.library.LibraryManagement.repository;

import com.project.library.LibraryManagement.Entities.Copies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CopyRepository extends JpaRepository<Copies, Integer>
{

}
