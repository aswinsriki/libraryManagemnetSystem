package com.project.library.LibraryManagement.repository;

import com.project.library.LibraryManagement.Entities.Fines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FineRepository extends JpaRepository<Fines, Integer>
{
//    List<Fines> findByUserId(Integer userId);
}
