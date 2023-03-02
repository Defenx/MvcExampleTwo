package com.example.studentsapp.domain.service.file;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    List<String> read(MultipartFile file);
}
