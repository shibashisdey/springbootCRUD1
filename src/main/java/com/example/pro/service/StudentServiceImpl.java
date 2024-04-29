package com.example.pro.service;

import com.example.pro.exception.StudentAlreadyFound;
import com.example.pro.exception.StudentListisEmpty;
import com.example.pro.exception.StudentNotFound;
import com.example.pro.model.Student;
import com.example.pro.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepo repo;

//    @Override
//    public Student add(Student student) {
//        return repo.save(student);
//    }
@Override
public Student add(Student student) throws StudentAlreadyFound {
    if (studentExists(student)) {
        throw new StudentAlreadyFound("Student with matching data already exists!");
    }
    Student student1 = new Student();
    student1.setAdminNo(student.getAdminNo());
    student1.setName(student.getName());
    student1.setStandard(student.getStandard());
    student1.setSection(student.getSection());
    return repo.save(student1);
}

    @Override
    public List<Student> getall() throws StudentListisEmpty {
        List<Student> students = repo.findAll();
        if (students.size()>0) {
            return students;
        }
        throw new StudentListisEmpty("the archive is empty");
    }

    @Override
    public Optional<Student> getById(String adminNo) throws StudentNotFound {
        Optional<Student> std = repo.findById(adminNo);
            if (std.isPresent()) {
                return std;
            }
            throw new StudentNotFound("No student by this ID");
    }

//    @Override
//    public Student updateStudent(String adminNo, Student student) throws StudentNotFound {
//        Optional<Student> std = repo.findById(adminNo);
//        Student student1= std.get();
//
//        student1.setName(student.getName());
//        student1.setSection(student.getSection());
//        student1.setStandard(student.getStandard());
//        repo.save(student1);
//        return student1;
//    }

    @Override
    public Student updateStudent(String adminNo, Student student) throws StudentNotFound {
        Optional<Student> std = repo.findById(adminNo);

        if (std.isEmpty()) {
            throw new StudentNotFound("Student with AdminNo " + adminNo + " not found!");
        }

        Student student1 = std.get();
        student1.setName(student.getName());
        student1.setSection(student.getSection());
        student1.setStandard(student.getStandard());
        return repo.save(student1);
    }


    @Override
    public Student deleteStudent(String adminNo) {
        Optional<Student> std1 = repo.findById(adminNo);
        if (std1.isPresent()) {
            Student student = std1.get();
            repo.delete(student);
            return student;

        }
        throw new StudentNotFound("Student Not Found");
    }
    public boolean studentExists(Student student) {
        // Check based on unique identifier or combination of unique fields
        // Assuming ID is the unique identifier:
        return repo.existsById(student.getAdminNo());
    }
}
