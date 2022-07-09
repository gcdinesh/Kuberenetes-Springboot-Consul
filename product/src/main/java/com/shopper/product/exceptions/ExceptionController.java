package com.shopper.product.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(ProductServiceException.class)
    public ResponseEntity<Object> exception(ProductServiceException exception) {
        return new ResponseEntity<>(exception.getErrorDetail(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetail> exception(UserNotFoundException exception) {
        return new ResponseEntity<>(exception.getErrorDetail(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<Object> exception(InvalidPasswordException exception) {
        return new ResponseEntity<>(exception.getErrorDetail(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidUserDetailsException.class)
    public ResponseEntity<Object> exception(InvalidUserDetailsException exception) {
        return new ResponseEntity<>(exception.getErrorDetail(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exception(Object object) {
        ProductServiceException exception = new ProductServiceException(Messages.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(exception.getErrorDetail(), HttpStatus.BAD_REQUEST);
    }

}
