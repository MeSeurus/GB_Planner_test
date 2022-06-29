package ru.geekbrains.planner_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.planner_test.entity.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
