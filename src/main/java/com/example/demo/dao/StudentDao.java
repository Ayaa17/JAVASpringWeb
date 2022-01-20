package com.example.demo.dao;

import com.example.demo.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentDao {

    Optional<Student> selectStudentById(UUID uuid);

    List<Student> selectAllStudent();

    int insertStudent(Student student);

    int updateStudent(Student student);

    int removeStudentById(UUID uuid);

}
