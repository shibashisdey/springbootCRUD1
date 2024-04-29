package com.example.pro.service;

import com.example.pro.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public Student add( Student student);

    public List<Student> getall();

    public Optional<Student> getById(String adminNo);

    public Student updateStudent(String adminId, Student student);

    public Student deleteStudent(String adminNo);


}
