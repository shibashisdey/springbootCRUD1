package com.example.pro.service;

import com.example.pro.exception.AdminAlreadyExist;
import com.example.pro.exception.AdminDoNotExist;
import com.example.pro.exception.InvalidPassword;
import com.example.pro.model.Admin;
import com.example.pro.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepo repo1;

    @Override
    public Admin registration(Admin admin) throws AdminAlreadyExist {
         Optional<Admin> adm1 = repo1.findById(admin.getEmail());
        if (adm1.isPresent()) {
            throw new AdminAlreadyExist("This User is already present");
        }
        Admin admin1 = new Admin();
        admin1.setEmail(admin.getEmail());
        admin1.setName(admin.getName());
        admin1.setPhoneNo(admin.getPhoneNo());
        admin1.setPassword(admin.getPassword());
        return repo1.save(admin1);
    }

//    @Override
//    public Admin login(String email, String password) {
//        Optional<Admin> admin = repo1.findById(email);
//        System.out.println(admin);
//        if (admin.isPresent()) {
//            Admin adm = admin.get();
//            if (admin != null && password.matches(adm.getPassword())) {
//                return adm;
//            }
//            throw new invalidpassword("Invalid Email or Password");
//        }
    @Override
    public String login(String email, String password){
        System.out.println("email: "+email);
        Optional<Admin> admin = repo1.findById(email);
        System.out.println("Admin: "+admin);
        if(admin.isPresent()){
            Admin adm1 = admin.get();
            if(adm1.getPassword().matches(password)){
                return "User Login Succesfully";
            }else{
                throw new InvalidPassword("Invalid Password");
            }
        }
        throw new AdminDoNotExist("Email not found. Please Register First!");
//        if (adminExists(email){
//            if (password.matches(.getPassword())){
//                return "User Login Succesfully";
//            }
//            throw new InvalidPassword("Invalid Password.");
//        }
//        throw new AdminDoNotExist("Please register before logging in.");
    }


//    public boolean adminExists(Admin admin) {
//        // Check based on unique identifier or combination of unique fields
//        // Assuming ID is the unique identifier:
//        return repo1.existsById(admin.getEmail());
//    }
}
