//package com.example.pro.service;
//
//import com.example.pro.exception.StudentNotFound;
//import com.example.pro.model.Student;
//import com.example.pro.repo.CustomStudentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CustomStudentService {
//
//    @Autowired
//    private CustomStudentRepository customstudentRepository;
//
//    public List<Student> getStudentsBySection(String section) throws StudentNotFound {
//        List<Student> std = customstudentRepository.findBySection(section);
//        return customstudentRepository.findBySection(section);
//    }
//}

package com.example.pro.service;

import com.example.pro.exception.StudentListisEmpty;
import com.example.pro.exception.StudentNotFound;
import com.example.pro.model.Student;
import com.example.pro.repo.CustomStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//
//@Service
//public class CustomStudentService {
//
//    @Autowired
//    private CustomStudentRepository customStudentRepository;
//
//    public Optional<Student> getStudentsBySection(String section) throws StudentNotFound {
//        Optional<Student> students = customStudentRepository.findBySection(section);
//
//        if (students.isEmpty()) {
//            throw new StudentListisEmpty(String.format("No students found with section '%s'", section));
//        }
//        else if (students.isPresent())
//        return students;
//        else throw new StudentNotFound("No students found with section");
//    }
//}
@Service
public class CustomStudentService {

    @Autowired
    private CustomStudentRepository customStudentRepository;

    public List<Student> getStudentsBySection(String section) throws StudentNotFound {
        List<Student> students = customStudentRepository.findBySection(section);

        if (students.isEmpty()) {
            throw new StudentNotFound(String.format("No students found with section"));
        }

        return students;
    }
}
