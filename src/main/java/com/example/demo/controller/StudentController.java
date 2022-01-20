package com.example.demo.controller;

import com.example.demo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/student")
public class StudentController {

    @GetMapping
    public Student hello(){
        Student student = new Student(UUID.randomUUID(),"Kent");
        return student;
    }

}
