package ru.geekbrains.planner_test.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.planner_test.entities.CalendarDay;
import ru.geekbrains.planner_test.services.CalendarDayService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/calendar")
public class CalendarDayController {
    private final CalendarDayService CalendarDayService;

    @GetMapping
    public List<CalendarDay> getCalendarDays(){
        return CalendarDayService.findAll();
    }

    @PostMapping("/{year}")
    public void fillCalendarDays(@PathVariable Integer year){
        CalendarDayService.fillCalendarDays(year);
    }
}
