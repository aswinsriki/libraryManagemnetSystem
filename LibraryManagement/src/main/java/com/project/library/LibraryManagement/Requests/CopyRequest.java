package com.project.library.LibraryManagement.Requests;

import com.project.library.LibraryManagement.Entities.Books;
import com.project.library.LibraryManagement.Entities.Copies;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CopyRequest
{
    private Copies.AvailabilityStatus availabilityStatus;

    private Copies.PhysicalCondition physicalCondition;

    private Integer bookId;
}
