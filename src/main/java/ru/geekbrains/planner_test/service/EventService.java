package ru.geekbrains.planner_test.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.planner_test.dao.EventDao;
import ru.geekbrains.planner_test.dto.EventDto;
import ru.geekbrains.planner_test.entity.Event;
import ru.geekbrains.planner_test.exception.EventNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class EventService {

    private final EventDao eventDao;

    public List<EventDto> findAll() {
        return eventDao.findAll().stream().map(EventDto::new).collect(Collectors.toList());
    }

    public EventDto findById(Long id) {
        Event eventFromDb = eventDao.findById(id).orElseThrow(() -> new EventNotFoundException("Event with id = " + id + " not found"));
        return new EventDto(eventFromDb);
    }

    public void createNewEvent(EventDto eventDto) {
        Event event = new Event();
        event.setTitle(eventDto.getTitle());
        event.setEventStart(eventDto.getEventStart());
        event.setEventEnd(eventDto.getEventEnd());
        eventDao.save(event);
    }

    public void deleteById(Long id) {
        if (eventDao.findById(id).isEmpty()) {
            throw new EventNotFoundException("Event with id = " + id + " not found for delete");
        }
        eventDao.deleteById(id);
    }

    public void editById(Long id, EventDto eventDto) {
        Event eventFromDb = eventDao.findById(id).orElseThrow(() -> new EventNotFoundException("Event with id = " + id + " not found for edit"));
        eventFromDb.setTitle(eventDto.getTitle());
        eventFromDb.setEventStart(eventDto.getEventStart());
        eventFromDb.setEventEnd(eventDto.getEventEnd());
        eventDao.save(eventFromDb);
    }
}
