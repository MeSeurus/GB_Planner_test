package ru.geekbrains.planner_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.planner_test.entities.CalendarDay;

public interface CalendarDayRepository extends JpaRepository<CalendarDay, Long> {
}
