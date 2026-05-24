package com.example.demo.controller;

import com.example.demo.entity.Discipline;
import com.example.demo.service.DisciplineService;
import com.example.demo.service.OperationResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/disciplines")
public class DisciplineController {

    private final DisciplineService disciplineService;

    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping
    public ResponseEntity<OperationResult<List<Discipline>>> getAllDisciplines() {
        return ResponseEntity.ok(disciplineService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperationResult<Discipline>> getDiscipline(@PathVariable Long id) {
        OperationResult<Discipline> result = disciplineService.findById(id);
        return toResponse(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OperationResult<Discipline>> createDiscipline(@RequestBody Discipline discipline) {
        OperationResult<Discipline> result = disciplineService.create(discipline);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping
    public ResponseEntity<OperationResult<Discipline>> updateDiscipline(@RequestBody Discipline discipline) {
        OperationResult<Discipline> result = disciplineService.update(discipline);
        return toResponse(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OperationResult<Void>> deleteDiscipline(@PathVariable Long id) {
        OperationResult<Void> result = disciplineService.delete(id);
        return toResponse(result, HttpStatus.OK);
    }

    private <T> ResponseEntity<OperationResult<T>> toResponse(OperationResult<T> result, HttpStatus successStatus) {
        if (result.isSuccess()) {
            return ResponseEntity.status(successStatus).body(result);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }
}
