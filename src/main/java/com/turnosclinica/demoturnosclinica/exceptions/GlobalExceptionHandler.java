package com.turnosclinica.demoturnosclinica.exceptions;

import org.apache.log4j.*;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    public ResponseEntity<?> todosErrores(Exception ex, WebRequest req){
        logger.error(ex.getMessage());
        return new ResponseEntity<>("Error "+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest req){
        logger.error(ex.getMessage());
        return new ResponseEntity<>("Error "+ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
