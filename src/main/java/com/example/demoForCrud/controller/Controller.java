package com.example.demoForCrud.controller;

import com.example.demoForCrud.entity.Student;
import com.example.demoForCrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/add")
    public List<Student> addinfo(@RequestBody List<Student> student){
       // List<Student> std=new ArrayList<>();
        studentRepository.saveAll(student);
        return  student;
    }
    @GetMapping("/url/{id}")
    public Student getById(@PathVariable("id") String id){
       return studentRepository.getById(id);

    }
    @PutMapping("/update/{id}")
    public  String updateStudent(@PathVariable("id") String id,@RequestBody Student student){
        Student std=studentRepository.getById(id);
        std.setName(student.getName());
        std.setAge(student.getAge());
        studentRepository.save(std);
        return  "updated Succesfully";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") String id){
        studentRepository.deleteById(id);
        return  "deleted Succesfully";
    }
    @GetMapping("GetAll")
    public List<Student> getStudents(){
        List<Student> students=new ArrayList<>();
        students=studentRepository.findAll();
        return students;
    }
}
