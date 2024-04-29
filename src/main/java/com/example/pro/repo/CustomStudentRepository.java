package com.example.pro.repo;

import com.example.pro.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
//public class CustomStudentRepository {
//@Autowired
//    private JdbcTemplate jdbcTemplate;
//    public List<Student> findBySection(String standard){
//        String sql= "SELECT * FROM STUDENT WHERE SECTION = ?";
//        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Student.class),standard);
//    }
//}

//
//@Component
//public class CustomStudentRepository implements CustomStudentRepo {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Override
//    public List<Student> findBySection(String section) {
//        String sql = "SELECT * FROM Student WHERE section = ?";
//        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class), section);
//    }
//
//    // Implement other methods as needed (findAll, findById, etc.) using JdbcTemplate
//}

//package com.example.pro.repo;

import com.example.pro.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

//@Component
//public class CustomStudentRepository implements CustomStudentRepo {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Override
//    public Optional<Student> findBySection(String section) {
//        String sql = "SELECT * FROM Student WHERE section = ?";
//        List<Student> results = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class), section);
//        return Optional.ofNullable(results.isEmpty() ? null : results.get(0));
//    }

    // Implement other methods as needed (findAll, findById, etc.) using JdbcTemplate
//}
    @Component
    public class CustomStudentRepository implements CustomStudentRepo {

        @Autowired
        private JdbcTemplate jdbcTemplate;

        @Override
        public List<Student> findBySection(String section) {
            String sql = "SELECT * FROM Student WHERE section = ?";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class), section);
        }

        // Implement other methods as needed (findAll, findById, etc.) using JdbcTemplate
    }
