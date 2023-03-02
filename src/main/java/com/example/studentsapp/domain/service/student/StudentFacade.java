package com.example.studentsapp.domain.service.student;

import com.example.studentsapp.domain.dto.StudentDto;
import com.example.studentsapp.domain.enums.SortingStrategyType;
import org.springframework.web.multipart.MultipartFile;

public interface StudentFacade {

    StudentDto getSortedStudents(MultipartFile file, SortingStrategyType sortingStrategyType);
}
