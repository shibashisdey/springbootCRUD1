package com.example.pro.controller;

import com.example.pro.exception.AdminAlreadyExist;
import com.example.pro.exception.AdminDoNotExist;
import com.example.pro.exception.InvalidPassword;
import com.example.pro.model.Admin;
import com.example.pro.model.Student;
import com.example.pro.service.AdminService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@Tag(name = "AdminController",description = "Documentation for API")
public class AdminController {
    @Autowired
    AdminService adminService;

    ResponseEntity responseEntity;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Admin admin){
        try {
            Admin admin1 = adminService.registration(admin);
            responseEntity = new ResponseEntity<>(admin, HttpStatus.OK);
        }
        catch (AdminAlreadyExist adminalreadyexist){
            responseEntity =new ResponseEntity<>("Data already exist",HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Admin admin){

        try {
            String email = admin.getEmail();
            String password = admin.getPassword();

            String ad1=adminService.login(email,password);


            responseEntity = new ResponseEntity<>("User Login Succesfully",HttpStatus.OK);
        }catch (AdminDoNotExist e){
            responseEntity= new ResponseEntity<>("Email not found, Register first",HttpStatus.BAD_REQUEST);
        }catch (InvalidPassword e){
            responseEntity= new ResponseEntity<>("invalid password",HttpStatus.BAD_REQUEST);
        }
      return  responseEntity;
    }

}
