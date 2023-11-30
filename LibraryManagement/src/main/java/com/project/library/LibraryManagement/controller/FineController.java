package com.project.library.LibraryManagement.controller;

import com.project.library.LibraryManagement.Entities.Fines;
import com.project.library.LibraryManagement.Entities.Transactions;
import com.project.library.LibraryManagement.Requests.FineRequest;
import com.project.library.LibraryManagement.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/api/fines")
public class FineController
{
    @Autowired
    private FineService fineService;

    @PostMapping("/creatingFines")
    public ResponseEntity<Fines> createFineAndAssociateWithUserAndTransaction(@RequestBody FineRequest fineRequest)
    {
        Fines createdFines = fineService.createFineAndAssociateWithUserAndTransaction(fineRequest);
        return ResponseEntity.ok(createdFines);
    }

    @PutMapping("{fineId}/updateFines")
    public ResponseEntity<String> updateFineAmount(@PathVariable Integer fineId)
    {
        try
        {
            fineService.updateFineAmount(fineId);
            return ResponseEntity.ok("Fine Amount updated successfully");
        }
        catch(RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fine with that fineId not found");
        }
    }
}
