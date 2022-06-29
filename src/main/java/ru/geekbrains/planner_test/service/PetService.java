package ru.geekbrains.planner_test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.planner_test.entity.Pet;
import ru.geekbrains.planner_test.repository.PetRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    public List<Pet> findAll() {
        return petRepository.findAll();
    }

}
