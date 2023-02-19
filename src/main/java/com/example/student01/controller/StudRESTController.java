package com.example.student01.controller;

import com.example.student01.model.Student;
import com.example.student01.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudRESTController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/stud1/{name}")
    public Student getstud1(@PathVariable String name) {
        return new Student(name);
    }

    @GetMapping("/stud2/{name}")
    public Student getstud2(@PathVariable Optional<String> name) {
        if (name.isPresent()) {
            return new Student(name.get());
        } else {
            return new Student("");
        }
    }

    @GetMapping("/stud3/{name}")
    public Student getstud3(@PathVariable String name) {
        return studentRepository.findByName(name).orElse(new Student(name + " Not Found"));
    }

    @GetMapping("/stud4/{name}")
    public Student getstud4(@PathVariable String name) {
        //return studentRepository.findByName(name).orElseThrow(() -> new RuntimeException("xxx"));
        return studentRepository.findByName(name).orElseThrow(() -> new StudentNotFoundException(name));
    }

    @GetMapping("/stud5/{name}")
    public ResponseEntity<Student> getstud5(@PathVariable String name) {
        var stud = studentRepository.findByName(name);
        if (stud.isPresent()) {
            return new ResponseEntity<>(stud.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student postStudent(@RequestBody Student student) {
        System.out.println(student);
        return studentRepository.save(student);
    }

    @PutMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student putStudent(@RequestBody Student student) {
        System.out.println(student);
        return studentRepository.save(student);
    }

    @DeleteMapping
    public ResponseEntity<Student> deleteStudent(@RequestParam Integer id) {
        studentRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}