package com.project.library.LibraryManagement.controller;

import com.project.library.LibraryManagement.Entities.Copies;
import com.project.library.LibraryManagement.Requests.CopyRequest;
import com.project.library.LibraryManagement.repository.CopyRepository;
import com.project.library.LibraryManagement.service.CopyService;
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
    private CopyService copyService;

    @PostMapping("/creatingCopies/")
    public ResponseEntity<Copies> createCopies(@RequestBody CopyRequest copyRequest)
    {
        Copies createdCopy = copyService.createCopyAlongWithBooks(copyRequest);
        return ResponseEntity.ok(createdCopy);
    }


//    @GetMapping
//    public List<Copies> getAllCopiesList()
//    {
//        return copyRepository.findAll();
//    }

//    @DeleteMapping("{id}")
//    public ResponseEntity<Void> deleteCopyById(@PathVariable Integer id)
//    {
//        if(!copyRepository.existsById(id))
//        {
//            return notFound().build();
//        }
//        return ResponseEntity.noContent().build();
//    }
//
//    @PutMapping("{id}")
//    public ResponseEntity<Copies> updateCopyById(@PathVariable Integer id, @RequestBody Copies updatedCopy)
//    {
//        if(!copyRepository.existsById(id))
//        {
//            return notFound().build();
//        }
//        updatedCopy.setCopyId(id);
//        Copies savedCopy = copyRepository.save(updatedCopy);
//        return ResponseEntity.ok(savedCopy);
//    }
}
