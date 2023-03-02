package com.example.studentsapp.infrastructure;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerConfiguration {

    @ExceptionHandler(Exception.class)
    public void defaultExceptionHandler(HttpServletResponse httpServletResponse) throws IOException {
        log.error("smth went wrong");
        httpServletResponse.sendError(HttpStatus.BAD_REQUEST.value());
    }
}
