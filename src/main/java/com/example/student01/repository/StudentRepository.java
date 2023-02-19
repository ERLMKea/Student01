package com.example.student01.repository;

import com.example.student01.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findByName(String name);
    Optional<Student> findByBornDate(LocalDate date);
    List<Student> findAllByName(String name);

}
