package ru.geekbrains.planner_test.dto;
import lombok.*;
import ru.geekbrains.planner_test.entity.Event;
import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EventDto {

    private Long id;
    private String title;
    private Timestamp eventStart;
    private Timestamp eventEnd;

    public EventDto(Event event) {
        this.id = event.getId();
        this.title = event.getTitle();
        this.eventStart = event.getEventStart();
        this.eventEnd = event.getEventEnd();
    }
}
