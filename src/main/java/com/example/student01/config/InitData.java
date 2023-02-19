package com.example.student01.config;

import com.example.student01.model.Student;
import com.example.student01.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;



    @Override
    public void run(String... args) throws Exception {
        if (3>4) {
            Student std1 = new Student();
            //std1.setId(1);
            std1.setBornDate(LocalDate.now());
            std1.setName("Vibbe");
            std1.setBornTime(LocalTime.now());
            studentRepository.save(std1);

            //std1 = new Student();
            //std1.setId(2);
            std1.setId(10);
            std1.setName("Viggo");
            studentRepository.save(std1);

            List<Student> students = studentRepository.findAll();
            System.out.println(students.size());

        } else {
            System.out.println("no initdata saved");
        }
    }
}
