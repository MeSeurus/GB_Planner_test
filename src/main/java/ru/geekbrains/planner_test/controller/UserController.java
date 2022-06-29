package ru.geekbrains.planner_test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.planner_test.dto.UserDto;
import ru.geekbrains.planner_test.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")

public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public List<UserDto> findAll(){
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id) {
        return userService.findById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editEventById(@PathVariable Long id, @RequestBody UserDto eventDto) {
        userService.editById(id, eventDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
