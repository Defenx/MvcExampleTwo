package com.example.studentsapp.domain.service.student;

import com.example.studentsapp.domain.model.Student;

import java.util.List;

public interface StudentParserService {

    List<Student> read(List<String> lines);
}
