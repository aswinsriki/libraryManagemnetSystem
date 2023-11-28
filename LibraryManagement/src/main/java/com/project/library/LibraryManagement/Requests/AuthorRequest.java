package com.project.library.LibraryManagement.Requests;

import com.project.library.LibraryManagement.Entities.Books;
import com.project.library.LibraryManagement.Entities.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequest
{
    private Integer authorId;
    private List<Integer> userId;
    private List<Integer> bookId;
}
