package com.example.springboot_practice.service;

import com.example.springboot_practice.entity.Student;
import com.example.springboot_practice.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    public List<Student> getAllStudents(){
        return studentRepository.findAllStudents();
    }
    public Optional<Student> getStudentById(int id){
        return studentRepository.findStudentById(id);
    }

    public String addNewStudent(Student student){
        return studentRepository.createStudent(student);
    }

    public String updateStudent(Student student){
        return studentRepository.updateStudent(student);
    }
    public String deleteStudentById(int id){
        return studentRepository.deleteStudentById(id);
    }
}

