package com.javatechie.crud.example.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class JDBCProduct {


    private int id;
    private String name;
    private String fullName;
    private int quantity;
    private double price;
}
