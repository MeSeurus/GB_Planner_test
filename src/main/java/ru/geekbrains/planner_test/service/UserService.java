package ru.geekbrains.planner_test.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.planner_test.dto.UserDto;
import ru.geekbrains.planner_test.entity.User;
import ru.geekbrains.planner_test.exception.UserNotFoundException;
import ru.geekbrains.planner_test.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional

public class UserService {

    private final UserRepository userRepository;


    public List<UserDto> findAll(){
        return userRepository.findAll().stream().map(UserDto::new).collect(Collectors.toList());
    }
    public UserDto findById(Long id) {
        User userFromDb = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Event with id = " + id + " not found"));
        return new UserDto(userFromDb);
    }

    public void deleteById(Long id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException("Event with id = " + id + " not found for delete");
        }
        userRepository.deleteById(id);
    }

    public void editById(Long id, UserDto userDto) {
        User userFromDb = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Event with id = " + id + " not found for edit"));
        userFromDb.setEmail(userDto.getEmail());
        userFromDb.setFirstName(userDto.getFirstName());
        userFromDb.setLastName(userDto.getLastName());
        userRepository.save(userFromDb);
    }
}
