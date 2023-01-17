package com.rest.exception;

import com.rest.dto.ErrorResponseDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Log4j2
@RestControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponseDto> handleException(EntityNotFoundException exception) {
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .message(exception.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponseDto> handleException(UniqueFullNameException exception) {
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message(exception.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleException(Exception exception) {
        log.error(exception.getMessage(), exception);
        return ResponseEntity.internalServerError().build();
    }
}
