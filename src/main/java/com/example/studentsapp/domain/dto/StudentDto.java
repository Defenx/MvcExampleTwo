package com.example.studentsapp.domain.dto;

import com.example.studentsapp.domain.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Duration;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class StudentDto {

    private List<Student> students;
    private Integer duration;
    private Integer size;
}
