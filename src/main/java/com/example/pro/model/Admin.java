package com.example.pro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Admin {
    @Id
    public String email;

    public String name;
    public String phoneNo;
    public String password;

}
