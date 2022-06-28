package ru.geekbrains.planner_test.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.planner_test.entity.User;
import ru.geekbrains.planner_test.repository.UserRepository;


@Service
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }
}
