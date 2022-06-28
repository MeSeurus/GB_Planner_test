package ru.geekbrains.planner_test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.planner_test.dao.EventDao;
import ru.geekbrains.planner_test.dto.EventDto;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EventService {

    private final EventDao eventDao;

    public List<EventDto> findAll() {
        return eventDao.findAll().stream().map(item -> new EventDto(item)).collect(Collectors.toList());
    }

//    public void createNewEvent(NewEventDto newEventDto) {
//
//    }
}
