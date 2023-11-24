package com.project.library.LibraryManagement.service;

import com.project.library.LibraryManagement.Entities.Users;
import com.project.library.LibraryManagement.controller.UserController;
import com.project.library.LibraryManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public List<Users> findUserByLastNameAndFirstName(String lastName, String firstName)
    {
        return userRepository.findByLastNameAndFirstName(lastName, firstName);
    }


    public List<Users> findUserByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    public Optional<Users> getUserByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }
}
