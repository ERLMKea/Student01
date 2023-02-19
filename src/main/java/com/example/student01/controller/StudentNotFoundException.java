package com.example.student01.controller;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(String name) {
        super("Student not found with name : " + name);
    }

}
