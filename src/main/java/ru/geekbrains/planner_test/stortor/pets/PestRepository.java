package ru.geekbrains.planner_test.stortor.pets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PestRepository extends JpaRepository<Pet, Long>, CrudRepository<Pet, Long> {
}
