package com.example.springboot_practice.repository;

import com.example.springboot_practice.entity.Student;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository{

    List<Student> studentList;
   public StudentRepository(){
        studentList = new ArrayList<>();
        studentList.add(new Student(1,"Sonu","Sharma",new Date()));
        studentList.add(new Student(2,"Sonu","Sharma",new Date()));
        studentList.add(new Student(3,"Sonu","Sharma",new Date()));
   }

  public List<Student> findAllStudents(){
        return studentList;
    }
  public Optional<Student> findStudentById(int id){
       return studentList.stream().filter(
                x->x.getId() == id
        ).findFirst();
  }
  public Optional<Student> findStudentByFirstName(String firstName){
      return studentList.stream().filter(
              x->x.getFirstName().equals(firstName)
      ).findFirst();
  }
   public Optional<Student> findStudentByLastName(String lastName){
       return studentList.stream().filter(
               x->x.getFirstName().equals(lastName)
       ).findFirst();
   }

    public String createStudent(Student student){
        try {
            studentList.add(student);
            return "Student added successfully!";
        }
        catch (Exception ex){
            return "Something went wrong" + ex;
        }
    }

    public String updateStudent(Student student){
        Optional<Student> existingStudent = findStudentById(student.getId());

        if(existingStudent.isPresent()){
            existingStudent.get().setFirstName(student.getFirstName());
            existingStudent.get().setLastName(student.getLastName());
            existingStudent.get().setDateOfBirth(student.getDateOfBirth());
            return "Updated Successfully!";
        }
        else {
            return "Student with {0} Not Found"+student.getId();
        }
    }

    public String deleteStudentById(int id) {
       try {
           Optional<Student> existingStudent = findStudentById(id);

           if(existingStudent.isPresent()){
               studentList.remove(existingStudent.get());
               return "Successfully Deleted the student";
           }
           else{
               return "Student with {0} Not Found"+id;
           }
       }
       catch (Exception e){
           return "Something went wrong"+e;
       }
    }
}
