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
    private UserRepository userRepository;


    @Autowired
    private UserService userService;

    @GetMapping
    public List<Users> getAllUsers()
    {
        return userRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users user)
    {
        Users savedUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Integer id)
    {
        if(!userRepository.existsById(id))
        {
            return notFound().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Users> updateUserById(@PathVariable Integer id, @RequestBody Users updatedUser)
    {
        if (!userRepository.existsById(id)) {
            return notFound().build();
        }
        updatedUser.setUserId(id);
        Users savedUser = userRepository.save(updatedUser);
        return ResponseEntity.ok(savedUser);
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
    public ResponseEntity<?> findByLastNameAndFirstName(
            @RequestParam String lastName,
            @RequestParam String firstName) {

        List<Users> users = userService.findUserByLastNameAndFirstName(lastName, firstName);

        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No users found with the given last name and first name");
        }
    }

    @GetMapping("/FirstName")
    public ResponseEntity<?> getUserByFirstName(@RequestParam String firstName) {

        List<Users> users = userService.findUserByFirstName(firstName);

        if (!users.isEmpty())
        {
            return ResponseEntity.ok(users);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No users found with the given first name");
        }
    }


    @GetMapping("/lastName")
    public ResponseEntity<?> getUserByLastName(@RequestParam String lastName)
    {
        Optional<Users> userOptional = userService.getUserByLastName(lastName);

        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null); // Or provide an appropriate message or object
        }
    }
}
