package com.project.library.LibraryManagement.controller;

import com.project.library.LibraryManagement.Entities.Author;
import com.project.library.LibraryManagement.Entities.Publisher;
import com.project.library.LibraryManagement.Requests.PublisherRequest;
import com.project.library.LibraryManagement.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/api/publisher/")
public class PublisherController
{
    @Autowired
    private PublisherService publisherService;

    @PostMapping("/creatingPublisher")
    public ResponseEntity<Publisher> createPublisher(@RequestBody PublisherRequest publisherRequest)
    {
        Publisher publisher = publisherService.createPublisherAndAssociateWithUsersAndBooks(
                publisherRequest.getPublisherId(),
                publisherRequest.getBookId(),
                publisherRequest.getUserId()
        );
        return ResponseEntity.ok(publisher);
    }
}
