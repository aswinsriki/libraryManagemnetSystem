package com.project.library.LibraryManagement.Requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PublisherRequest
{
    private Integer publisherId;
    private List<Integer> userId;
    private List<Integer> bookId;
}
