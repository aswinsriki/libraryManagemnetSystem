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
    private final UserRepository userRepository;

    public List<Users> findUserByLastNameAndFirstName(String lastName, String firstName)
    {
        return userRepository.findByLastNameAndFirstName(lastName, firstName);
    }


    public Users findUserByFirstName(String firstName)
    {
        return userRepository.findByFirstName(firstName);
    }

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public List<Users> getAllUsers()
    {
        return userRepository.findAll();
    }

    public Users createUser(Users user)
    {
        return userRepository.save(user);
    }

    public void deleteUserById(Integer id)
    {
        userRepository.deleteById(id);
    }

    public Users updateUserById(Integer id, Users updatedUser)
    {
        Optional<Users> existingUserOptional = userRepository.findById(id);

        if (existingUserOptional.isPresent())
        {
            Users existingUser = existingUserOptional.get();

            existingUser.setFirstName(updatedUser.getFirstName());

            existingUser.setLastName(updatedUser.getLastName());

            existingUser.setAddress(updatedUser.getAddress());

            existingUser.setUserType(updatedUser.getUserType());

            existingUser.setUserPhoneNo(updatedUser.getUserPhoneNo());

            existingUser.setEmailId(updatedUser.getEmailId());

            return userRepository.save(existingUser);
        }
        else
        {
            return null;
        }
    }

    public List<Users> findByLastNameAndFirstName(String lastName, String firstName)
    {
        return userRepository.findByLastNameAndFirstName(lastName, firstName);
    }

    public Users getUserByFirstName(String firstName)
    {
        return userRepository.findByFirstName(firstName);
    }

    public List<Users> getUserByLastName(String lastName)
    {
        return userRepository.findByLastName(lastName);
    }

    public List<Users> getUserByEmailId(String emailId)
    {
        return userRepository.findByEmailId(emailId);
    }

    public Users updateUserTypeValue(Integer id, Users updatedUser)
    {
        Optional<Users> existingUserOptional = userRepository.findById(id);

        if (existingUserOptional.isPresent())
        {
            Users existingUser = existingUserOptional.get();

            existingUser.setUserType(updatedUser.getUserType());

            return userRepository.save(existingUser);
        }
        else
        {
            return null;
        }
    }
}
