package com.javatechie.crud.example.service;

import com.javatechie.crud.example.entity.JDBCProduct;
import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.repository.JDBCRepository;
import com.javatechie.crud.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JDBCService {

    @Autowired
    private JDBCRepository repository;

    // Post Method
    public int saveProduct(JDBCProduct product){
        return repository.save(product);
    }

    // Get only one Product By Id
    public JDBCProduct getProductById(int id){

        return repository.findById(id);
    }

    public JDBCProduct getProductByFullName(String fullName){

        return repository.findByFullName(fullName);
    }

}
