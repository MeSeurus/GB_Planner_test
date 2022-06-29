package ru.geekbrains.planner_test.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.planner_test.entities.CalendarDay;
import ru.geekbrains.planner_test.repositories.CalendarDayRepository;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CalendarDayService {
    private final CalendarDayRepository calendarDayRepository;

    public void save(CalendarDay CalendarDay){
        calendarDayRepository.save(CalendarDay);
    }

    public List<CalendarDay> findAll(){
        return calendarDayRepository.findAll();
    }

    public void fillCalendarDays(Integer year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date startDate = calendar.getTime();

        calendar.set(Calendar.YEAR, year + 1);
        Date endDate = calendar.getTime();

        List<CalendarDay> calendarDayList = new ArrayList<>();

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(startDate);
        while(gregorianCalendar.getTime().before(endDate)){
            calendarDayList.add(new CalendarDay(gregorianCalendar.getTime()));
            gregorianCalendar.add(Calendar.DAY_OF_YEAR, 1);
        }

        calendarDayRepository.saveAll(calendarDayList);
    }

}
