package com.project.library.LibraryManagement.repository;

import com.project.library.LibraryManagement.Entities.Fines;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FineRepository extends JpaRepository<Fines, Integer>
{
    @Transactional
    @Modifying
    @Query("UPDATE Fines f SET f.fineAmount = :amount WHERE f.fineId = :fineId")
    void updateFineAmount(Integer fineId, double amount);
}
