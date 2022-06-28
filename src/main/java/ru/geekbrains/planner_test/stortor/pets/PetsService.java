package ru.geekbrains.planner_test.stortor.pets;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetsService {

    private final PestRepository pestRepository;

    public List<Pet> findAll() {
        return pestRepository.findAll();
    }

}
