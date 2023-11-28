package com.project.library.LibraryManagement.service;

import com.project.library.LibraryManagement.Entities.Books;
import com.project.library.LibraryManagement.Entities.Copies;
import com.project.library.LibraryManagement.Requests.CopyRequest;
import com.project.library.LibraryManagement.repository.BookRepository;
import com.project.library.LibraryManagement.repository.CopyRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CopyService
{
    @Autowired
    private CopyRepository copyRepository;

    @Autowired
    private BookRepository bookRepository;

//    @PersistenceContext
//    private EntityManager entityManager;

//    @PostConstruct
//    @Transactional
//    public void loadCopyDataOnStartUp()
//    {
//        try
//        {
//            ObjectMapper om = new ObjectMapper();
//
//            ClassPathResource resource = new ClassPathResource("Json files/copy.json");
//
//            File file = resource.getFile();
//
//            List<Copies> copies = om.readValue(file, om.getTypeFactory().constructCollectionType(List.class, Copies.class));
//
//            for (Copies copy : copies)
//            {
//                Books attachedBook = bookRepository.findById(copy.getBook().getBookId()).orElse(null);
//
//                if (attachedBook != null)
//                {
//                    entityManager.detach(attachedBook);
//                }
//                copy.setBook(attachedBook);
//            }
//
//            copyRepository.saveAll(copies);
//        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//        }
//    }

//    public void createCopyAndAssociateWithBook(Integer bookId, Copies copy)
//    {
//        Books book = bookRepository.findById(bookId)
//                .orElseThrow(() -> {
//                    return new EntityNotFoundException("Book not found with ID: " + bookId);
//                });
//
//        copy.setBook(book);
//        copyRepository.save(copy);
//    }


    public Copies createCopyAlongWithBooks(CopyRequest copyRequest)
    {
        Copies copy = new Copies();

        // Set other properties of the Copy entity from copyRequest...
        copy.setAvailabilityStatus(copyRequest.getAvailabilityStatus());
        copy.setPhysicalCondition(copyRequest.getPhysicalCondition());

        // Fetch the Book entity from the database
        Books book = bookRepository.findById(copyRequest.getBookId())
                .orElseThrow(() -> new EntityNotFoundException("Book not found with ID: " + copyRequest.getBookId()));

        // Set the fetched Book entity in the Copy entity means first we are fetching the books information from the BookRepository and then getting them to add this to copy entry that we are entering into the database.
        copy.setBook(book);

        // Save the Copy entity
        return copyRepository.save(copy);
    }
}
