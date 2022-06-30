package ru.geekbrains.planner_test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.planner_test.dto.PetDto;
import ru.geekbrains.planner_test.service.PetService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    @GetMapping()
    public List<PetDto> findAll() {
        return petService.findAll().stream().map(p -> new PetDto(p.getId(), p.getTitle(), p.getScore())).collect(Collectors.toList());
    }
}
