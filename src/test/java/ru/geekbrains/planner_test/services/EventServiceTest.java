package ru.geekbrains.planner_test.services;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import ru.geekbrains.planner_test.daos.EventDao;
import ru.geekbrains.planner_test.dtos.EventDto;

import java.time.LocalDateTime;

@SpringBootTest(classes = EventService.class)
@ActiveProfiles("test")
public class EventServiceTest {

    @Autowired
    private EventService eventService;

    @MockBean
    private EventDao eventDao;

    static EventDto buildEventDto() {
        EventDto eventDto = new EventDto();
        eventDto.setId(null);
        eventDto.setTitle("TestDto2");
        eventDto.setEventStart(LocalDateTime.now());
        eventDto.setEventEnd(LocalDateTime.now());
        return eventDto;
    }

    private EventDto eventDto = new EventDto(null, "TestDto", LocalDateTime.now(), LocalDateTime.now());

    @Test
    public void createNewEventTest() {
        eventService.createNewEvent(buildEventDto());
        Mockito.verify(eventDao, Mockito.times(1)).save(ArgumentMatchers.any());
    }

}
