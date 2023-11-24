package com.project.library.LibraryManagement.service;

import com.project.library.LibraryManagement.Entities.Copies;
import com.project.library.LibraryManagement.repository.CopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CopyService
{
    @Autowired
    private CopyRepository copyRepository;
}
