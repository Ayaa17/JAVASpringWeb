package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class Student {

    private UUID uuid ;
    private String name;

    public Student(UUID _uuid,String _name){
        this.uuid = _uuid;
        this.name = _name;

    }

    public UUID getUuid() {
        return uuid;
    }
    @JsonIgnore  //忽略序列化
    public String getName() {
        return name;
    }
}
