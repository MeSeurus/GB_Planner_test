package ru.geekbrains.planner_test.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.planner_test.entitys.Event;

public interface EventDao extends JpaRepository<Event, Long> {
}
