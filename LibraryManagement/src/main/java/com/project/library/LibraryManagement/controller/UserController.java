package com.project.library.LibraryManagement.controller;

import com.project.library.LibraryManagement.Entities.Books;
import com.project.library.LibraryManagement.Entities.Users;
import com.project.library.LibraryManagement.repository.UserRepository;
import com.project.library.LibraryManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.notFound;

@RestController
@ResponseBody
@RequestMapping("/api/users/")
public class UserController
{

    @Autowired
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Users> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    public ResponseEntity<Users> createUser(@RequestBody Users user)
    {
        Users createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Integer id)
    {
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Users> updateUserById(@PathVariable Integer id, @RequestBody Users updatedUser)
    {
        Users updatedUserData = userService.updateUserById(id, updatedUser);
        return ResponseEntity.ok(updatedUserData);
    }

//    @PutMapping("{firstName}")
//    public ResponseEntity<Users> updateUserByFirstName(@PathVariable Integer id, @RequestBody String firstName)
//    {
//        if(!userRepository.existsByFirstName(firstName))
//        {
//            return notFound().build();
//        }
//        updatedUser.setUserFirstName(firstName);
//        Users savedUser = userRepository.save(updatedUser);
//        return ResponseEntity.ok(savedUser);
//    }

    @GetMapping("/lastNameAndFirstName")
    public List<Users> findByLastNameAndFirstName(@RequestParam String lastName, @RequestParam String firstName)
    {
            return userService.findByLastNameAndFirstName(lastName, firstName);
    }

    @GetMapping("/searchByFirstName")
    public ResponseEntity<Users> getUserByFirstName(@RequestParam String firstName)
    {
        Users user = userService.getUserByFirstName(firstName);
        return ResponseEntity.ok(user);
    }


    @GetMapping("/searchByLastName")
    public ResponseEntity<List<Users>> getUserLastName(@RequestParam String lastName)
    {
        List<Users> user = userService.getUserByLastName(lastName);
        return ResponseEntity.ok(user);
    }


    @GetMapping("/searchUserByEmailId")
    public ResponseEntity<List<Users>> getUsersByEmailId(@RequestParam String emailId)
    {
        List<Users> user = userService.getUserByEmailId(emailId);
        return ResponseEntity.ok(user);
    }


    @PutMapping("/updateUserType")
    public ResponseEntity<Users> updateUserType(@RequestParam Integer id, @RequestBody Users updatedUser)
    {
        Users updatedUserData = userService.updateUserTypeValue(id, updatedUser);
        return ResponseEntity.ok(updatedUserData);
    }
}
