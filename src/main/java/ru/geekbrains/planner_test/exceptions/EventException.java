package ru.geekbrains.planner_test.exceptions;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class EventException {

    private int status;
    private String message;
    private LocalDateTime timestamp;

    public EventException(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}
