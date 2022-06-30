package ru.geekbrains.planner_test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.planner_test.dto.EventDto;
import ru.geekbrains.planner_test.service.EventService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/event")
public class EventController {

    private final EventService eventService;

    @GetMapping("/all")
    public List<EventDto> findAll() {
        return eventService.findAll();
    }

    @GetMapping("/{id}")
    public EventDto findById(@PathVariable Long id) {
        return eventService.findById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewEvent(@RequestBody EventDto eventDto) {
        eventService.createNewEvent(eventDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        eventService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editEventById(@PathVariable Long id, @RequestBody EventDto eventDto) {
        eventService.editById(id, eventDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
