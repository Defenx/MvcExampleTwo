package com.example.studentsapp.domain.service.student.impl;

import com.example.lib.benchmark.BenchmarkBuilder;
import com.example.studentsapp.domain.dto.StudentDto;
import com.example.studentsapp.domain.enums.SortingStrategyType;
import com.example.studentsapp.domain.model.Student;
import com.example.studentsapp.domain.service.file.FileService;
import com.example.studentsapp.domain.service.sort.SortingService;
import com.example.studentsapp.domain.service.student.StudentFacade;
import com.example.studentsapp.domain.service.student.StudentParserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentFacadeImpl implements StudentFacade {

    private final FileService fileService;
    private final StudentParserService studentParserService;
    private final Map<SortingStrategyType, SortingService> sortingStrategyTypeSortingServiceMap;

    @Override
    public StudentDto getSortedStudents(MultipartFile file, SortingStrategyType sortingStrategyType) {
        var lines = fileService.read(file);

        var students = studentParserService.read(lines);

        var sortingService = Optional
                .ofNullable(sortingStrategyTypeSortingServiceMap.get(sortingStrategyType))
                .orElseThrow();

        var benchmark = new BenchmarkBuilder<List<Student>>()
                .supplier(() -> sortingService.sort(students))
                .build();

        benchmark.start();

        var sortedStudents = benchmark.getResult();

        var duration = benchmark.getDuration().getNano();

        return StudentDto
                .builder()
                .students(sortedStudents)
                .duration(duration)
                .size(sortedStudents.size())
                .build();
    }


}
