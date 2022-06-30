package ru.geekbrains.planner_test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.planner_test.entitiy.CalendarDay;
import ru.geekbrains.planner_test.service.CalendarDayService;

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
