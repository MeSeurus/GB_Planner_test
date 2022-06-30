package ru.geekbrains.planner_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.planner_test.entity.KanbanEntity;

public interface KanbanRepository extends JpaRepository<KanbanEntity, Long> {
}
