package com.example.pro.service;

import com.example.pro.model.Admin;

public interface AdminService {
    public Admin registration(Admin admin);
    public String login(String email, String password);
}
