package com.example.studentsapp.adapter.mvc;

import com.example.studentsapp.domain.dto.FileStudentDto;
import com.example.studentsapp.domain.enums.SortingStrategyType;
import com.example.studentsapp.domain.service.student.StudentFacade;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class StudentsController {

    private final StudentFacade studentFacade;
    private final ObjectMapper objectMapper;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("sortingStrategyTypes", SortingStrategyType.values());

        return "index";
    }

    @PostMapping("/result")
    public String fileUpload(
            @RequestParam SortingStrategyType sortingStrategyType,
            @RequestParam MultipartFile file,
            Model model
    ) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException();
        }

        var studentDto = studentFacade.getSortedStudents(file, sortingStrategyType);

        model.addAttribute("studentDto", studentDto);
        model.addAttribute(
                "fileStudentDto",
                FileStudentDto
                        .builder()
                        .size(studentDto.getSize())
                        .duration(studentDto.getDuration())
                        .build()
        );

        return "result";
    }

    @PostMapping(value = "/generateFile")
    @ResponseBody
    public ResponseEntity<byte[]> generateFile(@ModelAttribute FileStudentDto fileStudentDto) throws JsonProcessingException {
        String fileName = "fileName.json";
        var jsonString = objectMapper.writeValueAsString(fileStudentDto);
        var bytes = jsonString.getBytes();
        HttpHeaders respHeaders = new HttpHeaders();
        respHeaders.setContentLength(bytes.length);
        respHeaders.setContentType(new MediaType(MediaType.APPLICATION_JSON));
        respHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
        return new ResponseEntity<>(bytes, respHeaders, HttpStatus.OK);
    }

}
