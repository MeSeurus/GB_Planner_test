package ru.geekbrains.planner_test.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.planner_test.dto.EventDto;
import ru.geekbrains.planner_test.service.EventService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/event")
public class EventController {

    private final EventService eventService;

    @GetMapping
    public List<EventDto> findAll(){
        return eventService.findAll();
    }

//    @PostMapping
//    public void createNewEvent(@RequestBody NewEventDto newEventDto){
//        eventService.createNewEvent(newEventDto);
//    }
}
