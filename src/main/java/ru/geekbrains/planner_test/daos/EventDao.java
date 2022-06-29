package ru.geekbrains.planner_test.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.planner_test.entities.Event;

public interface EventDao extends JpaRepository<Event, Long> {
}
