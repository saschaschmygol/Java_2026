package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/list";
    }

    @GetMapping
    public String listRedirect() {
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "list-students";
    }

    @GetMapping("/addStudentForm")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student-form";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(Student student) {
        studentService.saveStudent(student);
        return "redirect:/list";
    }

    @GetMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam("studentId") Integer studentId, Model model) {
        model.addAttribute("student", studentService.getStudentById(studentId));
        return "add-student-form";
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") Integer studentId) {
        studentService.deleteStudentById(studentId);
        return "redirect:/list";
    }
}
