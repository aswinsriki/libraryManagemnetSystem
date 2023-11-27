package com.project.library.LibraryManagement.controller;

import com.project.library.LibraryManagement.Entities.Copies;
import com.project.library.LibraryManagement.repository.CopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.notFound;

@RestController
@ResponseBody
@RequestMapping("/api/copy/")
public class CopyController
{
    @Autowired
    private CopyRepository copyRepository;

    @GetMapping
    public List<Copies> getAllCopiesList()
    {
        return copyRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Copies> createCopies(@RequestBody Copies copy)
    {
        Copies savedCopy = copyRepository.save(copy);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCopy);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCopyById(@PathVariable Integer id)
    {
        if(!copyRepository.existsById(id))
        {
            return notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Copies> updateCopyById(@PathVariable Integer id, @RequestBody Copies updatedCopy)
    {
        if(!copyRepository.existsById(id))
        {
            return notFound().build();
        }
        updatedCopy.setCopyId(id);
        Copies savedCopy = copyRepository.save(updatedCopy);
        return ResponseEntity.ok(savedCopy);
    }
}
