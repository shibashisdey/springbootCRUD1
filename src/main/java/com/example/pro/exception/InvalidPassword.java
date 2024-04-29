package com.example.pro.exception;

public class InvalidPassword extends RuntimeException{
    public InvalidPassword (String invalidpassword){super(invalidpassword);}
}
