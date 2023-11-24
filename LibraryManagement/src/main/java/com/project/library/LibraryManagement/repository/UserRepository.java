package com.project.library.LibraryManagement.repository;

import com.project.library.LibraryManagement.Entities.Users;
import com.project.library.LibraryManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>
{
//    @Modifying
//    @Query("UPDATE Users u SET u.firstName = :firstName WHERE u.id = :userId")
//    void setFirstName(@Param("userId") Long userId, @Param("firstName") String firstName);

    List<Users> findByLastNameAndFirstName(String lastName, String firstName);

    Users findByFirstName(String firstName);

    List<Users> findByLastName(String lastName);

    List<Users> findByEmailId(String emailId);

    Optional<Users> findByUserType(Integer id);
}
