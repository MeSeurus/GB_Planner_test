package ru.geekbrains.planner_test.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.planner_test.dtos.PetDto;
import ru.geekbrains.planner_test.services.PetsService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pets")
public class PetsController {

    private final PetsService petsService;

    @GetMapping()
    public List<PetDto> findAll() {
        return petsService.findAll().stream().map(p -> new PetDto(p.getId(), p.getTitle(), p.getScore())).collect(Collectors.toList());
    }
}
