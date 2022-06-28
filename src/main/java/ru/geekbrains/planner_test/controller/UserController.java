package ru.geekbrains.planner_test.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.planner_test.entity.User;
import ru.geekbrains.planner_test.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@NoArgsConstructor
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public Iterable<User> findAll(){
        return userService.findAll();
    }


}
