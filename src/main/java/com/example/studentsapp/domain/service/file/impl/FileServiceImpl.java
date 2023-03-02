package com.example.studentsapp.domain.service.file.impl;

import com.example.studentsapp.domain.service.file.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public List<String> read(MultipartFile file) {

        List<String> lines = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            String strLine;
            while ((strLine = reader.readLine()) != null) {
                lines.add(strLine);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lines;
    }
}
