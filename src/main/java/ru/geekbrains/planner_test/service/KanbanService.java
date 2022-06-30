package ru.geekbrains.planner_test.service;

import ru.geekbrains.planner_test.entity.KanbanEntity;
import ru.geekbrains.planner_test.repository.KanbanRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class KanbanService {

    private KanbanRepository repository;

    public List<KanbanEntity> findAll() {
        var objects = (List<KanbanEntity>) repository.findAll();
        return objects;
    }

}
