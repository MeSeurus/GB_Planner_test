package ru.geekbrains.planner_test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.planner_test.entity.Event;

public interface EventDao extends JpaRepository<Event, Long> {
}
