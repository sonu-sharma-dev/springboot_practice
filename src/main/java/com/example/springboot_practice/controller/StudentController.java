package com.example.springboot_practice.controller;


import com.example.springboot_practice.entity.Student;
import com.example.springboot_practice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    List<Student> getStudentsList(){
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    Optional<Student> getStudentsListById(@PathVariable int id){
            return studentService.getStudentById(id);
    }

    @GetMapping("/student")
    Optional<Student> getStudentsListByIdUsingRequestParam(@RequestParam int id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/student")
    String saveStudent(@RequestBody Student student){
        return studentService.addNewStudent(student);
    }

    @PutMapping("/student")
    String updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/student/{id}")
    String updateStudent(@PathVariable int id){
        return studentService.deleteStudentById(id);
    }
}
