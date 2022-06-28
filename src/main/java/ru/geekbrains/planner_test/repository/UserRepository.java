package ru.geekbrains.planner_test.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.planner_test.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
