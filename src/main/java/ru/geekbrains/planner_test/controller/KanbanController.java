package ru.geekbrains.planner_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.planner_test.entity.KanbanEntity;
import ru.geekbrains.planner_test.exception.ResourceNotFoundException;
import ru.geekbrains.planner_test.repository.KanbanRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kanban")
public class KanbanController {

    private KanbanRepository kanbanRepository;

    @GetMapping
    public List<KanbanEntity> getAllKanbanEntity() {
        return kanbanRepository.findAll();
    }

    @PostMapping
    public KanbanEntity createKanbanEntity(@RequestBody KanbanEntity kanban) {
        return kanbanRepository.save(kanban);
    }
    @GetMapping("/{id}")
    public ResponseEntity<KanbanEntity> getElectricsById(@PathVariable Long id) {
        KanbanEntity kanban = kanbanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist with id: " + id));
        return ResponseEntity.ok(kanban);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KanbanEntity> updateKanbanEntity(@PathVariable Long id, @RequestBody KanbanEntity kanbanUpdate) {
        KanbanEntity kanban = kanbanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist with id: " + id));

        kanban.setName(kanbanUpdate.getName());
        kanban.setDescription(kanbanUpdate.getDescription());
        kanban.setTasks(kanbanUpdate.getTasks());
        kanban.setUsers(kanbanUpdate.getUsers());

        KanbanEntity updatedKanbanEntity = kanbanRepository.save(kanban);
        return ResponseEntity.ok(updatedKanbanEntity);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteKanbanEntity(@PathVariable Long id) {
        KanbanEntity kanban = kanbanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist with id: " + id));

        kanbanRepository.delete(kanban);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
