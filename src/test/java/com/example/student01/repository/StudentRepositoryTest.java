package com.example.student01.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.student01.model.Student;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        Student std = new Student();
        std.setName("Vibbe");
        std.setBornDate(LocalDate.now());
        studentRepository.save(std);
    }


    @Test
    void testViggo() {

        Optional<Student> stdo = studentRepository.findById(1);
        Student std = new Student();
        if (stdo.isPresent()) {
            std = stdo.get();
        }
        assertEquals("Vibbe", std.getName());
    }

    @Test
    void testNameViggo() {

        assertEquals("Vibbe", studentRepository.findByName("Vibbe").orElse(new Student()).getName());
    }

}
