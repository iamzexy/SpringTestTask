package com.iamzexy.SpringTestTask.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Demin Artem
 */
@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(value = UserException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleUserException(UserException userException) {
        return new ResponseEntity<>(userException.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
