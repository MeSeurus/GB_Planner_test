package ru.geekbrains.planner_test.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.planner_test.entitys.Pet;
import ru.geekbrains.planner_test.repositories.PetsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetsService {

    private final PetsRepository petsRepository;

    public List<Pet> findAll() {
        return petsRepository.findAll();
    }

}
