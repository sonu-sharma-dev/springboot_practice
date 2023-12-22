package com.example.springboot_practice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//annotations
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
}
