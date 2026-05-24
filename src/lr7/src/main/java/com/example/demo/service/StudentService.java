package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public OperationResult<List<Student>> findAll() {
        List<Student> students = studentDao.findAll();
        return OperationResult.success("Students received successfully", students);
    }

    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    public OperationResult<Student> findById(Integer id) {
        return studentDao.findById(id)
                .map(student -> OperationResult.success("Student received successfully", student))
                .orElseGet(() -> OperationResult.failure("Student with id " + id + " not found"));
    }

    public Student getStudentById(Integer id) {
        return studentDao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student with id " + id + " not found"));
    }

    public OperationResult<Student> create(Student student) {
        student.setId(null);
        Student savedStudent = studentDao.save(student);
        return OperationResult.success("Student created successfully", savedStudent);
    }

    public void saveStudent(Student student) {
        studentDao.save(student);
    }

    public OperationResult<Student> update(Student student) {
        Integer id = student.getId();
        if (id == null) {
            return OperationResult.failure("Student id is required for update");
        }

        if (!studentDao.existsById(id)) {
            return OperationResult.failure("Student with id " + id + " not found");
        }

        Student savedStudent = studentDao.save(student);
        return OperationResult.success("Student updated successfully", savedStudent);
    }

    public OperationResult<Void> delete(Integer id) {
        if (!studentDao.existsById(id)) {
            return OperationResult.failure("Student with id " + id + " not found");
        }

        studentDao.deleteById(id);
        return OperationResult.success("Student deleted successfully", null);
    }

    public void deleteStudentById(Integer id) {
        studentDao.deleteById(id);
    }
}
