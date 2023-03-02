package com.example.studentsapp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Duration;

@Data
@AllArgsConstructor
@Builder
public class FileStudentDto {

    private Integer duration;
    private Integer size;
}
