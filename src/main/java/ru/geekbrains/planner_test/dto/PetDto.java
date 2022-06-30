package ru.geekbrains.planner_test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PetDto {
    private Long id;
    private String title;
    private Integer score;
}
