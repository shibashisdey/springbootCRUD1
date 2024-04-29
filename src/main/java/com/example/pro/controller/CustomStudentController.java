package com.example.pro.controller;

import com.example.pro.exception.StudentListisEmpty;
import com.example.pro.exception.StudentNotFound;
import com.example.pro.model.Student;
import com.example.pro.service.CustomStudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/custom/students")
@Tag(name = "Student Using Custom Repo",description = "Documentation for API")
public class CustomStudentController {
    @Autowired
    private CustomStudentService customstudentService;
    public ResponseEntity<?> responseEntity;

    @GetMapping("/bySection/{section}")
    public ResponseEntity<List<Student>> getStudentsBySection(@PathVariable("section") String section) {
        try {
            List<Student> students = customstudentService.getStudentsBySection(section);
            responseEntity =new ResponseEntity<>(students, HttpStatus.OK);
        }
        catch (StudentNotFound studentNotFound){
            responseEntity=new ResponseEntity<>("No student  found by this section.",HttpStatus.BAD_REQUEST);
        }
        catch (StudentListisEmpty studentListisEmpty){
            responseEntity=new ResponseEntity<>("the student list is empty please enter some value first",HttpStatus.BAD_REQUEST);
        }
        return (ResponseEntity<List<Student>>) responseEntity;
    }

}
