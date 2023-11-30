package com.project.library.LibraryManagement.repository;


import com.project.library.LibraryManagement.Entities.Transactions;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Integer>
{
    @Transactional
    @Modifying
    @Query("UPDATE Transactions t SET t.transactionAmount = :amount WHERE t.transactionId = :transactionId")
    void updateTransactionAmount(Integer transactionId, double amount);

    @Query("SELECT t.book.id FROM Transactions t" +
            "GROUP BY t.book.id ORDER BY SUM(t.transactionAmount) DESC")
    Integer findBestSellingBookId();
}
