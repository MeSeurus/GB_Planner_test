package ru.geekbrains.planner_test.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.geekbrains.planner_test.exception.EventException;
import ru.geekbrains.planner_test.exception.EventNotFoundException;

@ControllerAdvice
@Slf4j
public class EventExceptionHandler {

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<?> handleEventNotFoundException(final EventNotFoundException e) {
        log.error(e.getMessage());
        EventException exc = new EventException(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(exc, HttpStatus.NOT_FOUND);
    }

}
