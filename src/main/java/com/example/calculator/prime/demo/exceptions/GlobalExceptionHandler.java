package com.example.calculator.prime.demo.exceptions;

import com.example.calculator.prime.demo.dto.ErrorDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Value("${spring.application.name}")
    private String serviceName;

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<?> handleHttpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException ex) {
        ErrorDTO errorDTO = ErrorDTO.builder()
                .message(ex.getMessage())
                //.details(Arrays.stream(ex.getStackTrace()).map(StackTraceElement::toString).collect(Collectors.toList()))
                .details(Collections.singletonList(ex.toString()))
                .source(serviceName)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(ex.getStatusCode().value()).contentType(MediaType.APPLICATION_JSON).body(errorDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        ex.printStackTrace();
        ErrorDTO errorDTO = ErrorDTO.builder()
                .message(ex.getMessage())
                //.details(Arrays.stream(ex.getStackTrace()).map(StackTraceElement::toString).collect(Collectors.toList()))
                .details(Collections.singletonList(ex.toString()))
                .source(serviceName)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDTO);
    }

}