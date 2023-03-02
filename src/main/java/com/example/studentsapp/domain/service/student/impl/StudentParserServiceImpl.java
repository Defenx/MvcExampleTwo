package com.example.studentsapp.domain.service.student.impl;

import com.example.studentsapp.domain.model.Student;
import com.example.studentsapp.domain.service.student.StudentParserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentParserServiceImpl implements StudentParserService {
    @Override
    public List<Student> read(List<String> lines) {
        return lines.stream()
                .map(line -> {
                    var tokens = line.split(",");

                    return Student.createNew(tokens[0], Double.valueOf(tokens[1]));
                })
                .toList();
    }
}
