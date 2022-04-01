package com.example.yssampleapp.domain.exception;

import com.example.yssampleapp.domain.model.CustomError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

/*
Handles the exception handling and exposes the relevant information to the upstream client.
 */
@RestControllerAdvice
@Slf4j
public class AppControllerAdvice {
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<Object> mediaTypeNotSupportedExceptionHandler(Exception exception, WebRequest request){
        CustomError customError = CustomError.builder()
                .errorCode(415)
                .errorMessage("Only application/json requests are supported.")
                .build();
        //return the response entity
        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(customError);
    }

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<Object> internalServerErrorHandler(Exception exception, WebRequest request){
        CustomError customError = CustomError.builder()
                .errorCode(500)
                .errorMessage("An error in the application occurred while processing the request. Please try again later.")
                .build();
        //return the response entity
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(customError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> missingFieldsException(Exception exception, WebRequest request){
        log.error(exception.getMessage());
        CustomError customError = CustomError.builder()
                .errorCode(400)
                .errorMessage("Missing Required fields. Please check.")
                .build();
        //return the response entity
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customError);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Object> badRequestExceptionHandler(Exception exception, WebRequest request){
        log.error(exception.getMessage());
        String errorMessage = "";
        if(exception.getMessage().equals("400 BAD_REQUEST")) {
            errorMessage = "Invalid request or Invalid Arguments submitted in the request to be processed";
        } else {
            errorMessage = exception.getMessage();
        }
        CustomError customError = CustomError.builder()
                .errorCode(400)
                .errorMessage(errorMessage)
                .build();
        //return the response entity
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customError);
    }
}
