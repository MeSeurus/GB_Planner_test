package ru.geekbrains.planner_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.planner_test.entitys.Pet;

@Repository
public interface PetsRepository extends JpaRepository<Pet, Long> {
}
