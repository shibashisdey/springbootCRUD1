package com.example.pro.exception;

import com.example.pro.model.Admin;

public class AdminAlreadyExist extends RuntimeException{
    public AdminAlreadyExist (String adminalreadyexist){super(adminalreadyexist);}
}
