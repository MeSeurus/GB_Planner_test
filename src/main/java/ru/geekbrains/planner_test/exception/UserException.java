package ru.geekbrains.planner_test.exception;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserException {

    private int status;
    private String message;
    private LocalDateTime timestamp;

    public UserException(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}