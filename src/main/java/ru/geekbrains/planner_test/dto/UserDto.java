package ru.geekbrains.planner_test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.geekbrains.planner_test.entity.User;

@Data
@AllArgsConstructor
public class UserDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;

    public UserDto(User user){
        this.id = user.getId();
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }

}
