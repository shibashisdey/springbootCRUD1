package com.example.pro.controller;

import com.example.pro.exception.StudentAlreadyFound;
import com.example.pro.exception.StudentListisEmpty;
import com.example.pro.exception.StudentNotFound;
import com.example.pro.model.Student;
import com.example.pro.service.StudentService;
import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@Tag(name = "StudentController",description = "Documentation for Crud APIs")
public class StudentController {
    @Autowired
    public StudentService studentService;
    public ResponseEntity<?> responseEntity;

    @GetMapping("/list")
    public ResponseEntity<?> getall() {
        try {
            List<Student> students = studentService.getall();
            responseEntity = new ResponseEntity<>(students, HttpStatus.OK);
        }
       catch (StudentListisEmpty e){
            responseEntity=new ResponseEntity<>("the student list is empty",HttpStatus.BAD_REQUEST);
       }

        return responseEntity;
    }
    @GetMapping("/get/{adminNo}")

    public ResponseEntity<?> getById(@PathVariable("adminNo")String adminNO) {
        try {
            Optional<Student> students = studentService.getById(adminNO);
            responseEntity =new ResponseEntity<>(students, HttpStatus.OK);
        }
        catch (StudentNotFound studentNotFound){
            responseEntity=new ResponseEntity<>("Student not found by this Id",HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Student student) {
        try {
            Student student1 = studentService.add(student);
            responseEntity = new ResponseEntity<>(student, HttpStatus.OK);
        }
        catch (StudentAlreadyFound e) {
            responseEntity =new ResponseEntity<>("Data already found",HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

    @PutMapping("/update/{adminNo}")
    public ResponseEntity<?> update(@PathVariable("adminNo")String adminNo,@RequestBody Student student){
        try {
            Student std1 = studentService.updateStudent(adminNo,student);
            responseEntity = new ResponseEntity<>(std1,HttpStatus.ACCEPTED);
        }
        catch (StudentNotFound studentNotFound){
            responseEntity=new ResponseEntity<>("No student by this Id",HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }
    @DeleteMapping("/delete/{adminNo}")
    public ResponseEntity<?> deleteStudent(@PathVariable("adminNo")String adminNo){
        try {
            Student std1 = studentService.deleteStudent(adminNo);
            responseEntity = new ResponseEntity<>(std1,HttpStatus.ACCEPTED);
        }
        catch (StudentNotFound e){
            responseEntity=new ResponseEntity<>("Student by this Id dosen't exist",HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }
}


