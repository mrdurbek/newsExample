package com.example.newsExample.exception;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;



@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<?> forbiddenException(ForbiddenException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                403,
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return ResponseEntity.ok(message);
    }


}
