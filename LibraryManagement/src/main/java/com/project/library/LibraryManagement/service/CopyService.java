package com.project.library.LibraryManagement.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.library.LibraryManagement.Entities.Books;
import com.project.library.LibraryManagement.Entities.Copies;
import com.project.library.LibraryManagement.Entities.Transactions;
import com.project.library.LibraryManagement.repository.BookRepository;
import com.project.library.LibraryManagement.repository.CopyRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CopyService
{
    @Autowired
    private CopyRepository copyRepository;

    @Autowired
    private BookRepository bookRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    @Transactional
    public void loadCopyOnDataStartUp()
    {
        try
        {
            ObjectMapper om = new ObjectMapper();

            ClassPathResource resource = new ClassPathResource("Json files/copy.json");

            File file = resource.getFile();

            List<Copies> copies = om.readValue(file, om.getTypeFactory().constructCollectionType(List.class, Copies.class));

            for (Copies copy : copies)
            {
                Books attachedBook = bookRepository.findById(copy.getBook().getBookId()).orElse(null);

                if (attachedBook != null)
                {
                    entityManager.detach(attachedBook);
                }
                copy.setBook(attachedBook);
            }

            copyRepository.saveAll(copies);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
