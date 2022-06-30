package ru.geekbrains.planner_test.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.geekbrains.planner_test.exception.UserException;
import ru.geekbrains.planner_test.exception.UserNotFoundException;

@ControllerAdvice
@Slf4j
public class UserExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleEventNotFoundException(final UserNotFoundException e) {
        log.error(e.getMessage());
        UserException exc = new UserException(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(exc, HttpStatus.NOT_FOUND);
    }

}