package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.OperationResult;
import com.example.demo.service.StudentService;
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
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<OperationResult<List<Student>>> getAllStudents() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperationResult<Student>> getStudent(@PathVariable Long id) {
        OperationResult<Student> result = studentService.findById(id);
        return toResponse(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OperationResult<Student>> createStudent(@RequestBody Student student) {
        OperationResult<Student> result = studentService.create(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping
    public ResponseEntity<OperationResult<Student>> updateStudent(@RequestBody Student student) {
        OperationResult<Student> result = studentService.update(student);
        return toResponse(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OperationResult<Void>> deleteStudent(@PathVariable Long id) {
        OperationResult<Void> result = studentService.delete(id);
        return toResponse(result, HttpStatus.OK);
    }

    private <T> ResponseEntity<OperationResult<T>> toResponse(OperationResult<T> result, HttpStatus successStatus) {
        if (result.isSuccess()) {
            return ResponseEntity.status(successStatus).body(result);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }
}
