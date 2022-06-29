package ru.geekbrains.planner_test.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PetDto {
    private Long id;
    private String title;
    private Integer score;
}
