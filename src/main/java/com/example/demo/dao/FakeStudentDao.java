package com.example.demo.dao;

import com.example.demo.model.Student;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class FakeStudentDao implements StudentDao{

    private static  List<Student> Database = new ArrayList<>();

    @Override
    public List<Student> selectAllStudent() {
        return Database;
    }

    @Override
    public int insertStudent( Student student) {
        UUID id = UUID.randomUUID();
        Database.add(new Student(id,student.getName()));
        return 1;
    }

    @Override
    public int updateStudent(Student student) {
        Optional<Student> optionalStudent = selectStudentById(student.getUuid());
        if(!optionalStudent.isPresent()){
            return -1;
        }
        int indexToUpdate = -1;
        for (int i = 0;i<Database.size();i++){
            if(student.getUuid().equals(Database.get(i).getUuid())){
                indexToUpdate = i;
                break;
            }
        }
        Database.set(indexToUpdate,student);
        return 1;
    }

    @Override
    public Optional<Student> selectStudentById(UUID uuid) {
        for (Student s : Database) {
            if (s.getUuid().equals(uuid)) {
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }

    @Override
    public int removeStudentById(UUID uuid) {
        Optional<Student> optionalStudent = selectStudentById(uuid);
        if(!optionalStudent.isPresent()){
            return -1;
        }
        Database.remove(optionalStudent.get());
        return 1;
    }
}
