package ru.geekbrains.planner_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.planner_test.entity.CalendarDay;

public interface CalendarDayRepository extends JpaRepository<CalendarDay, Long> {
}
