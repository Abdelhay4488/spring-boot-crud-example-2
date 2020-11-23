package com.javatechie.crud.example.controller;

import com.javatechie.crud.example.entity.JDBCProduct;
import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.service.JDBCService;
import com.javatechie.crud.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JDBCController {

    @Autowired
    private JDBCService service;

    @PostMapping("/addjdbcProduct")
    public int addProduct (@RequestBody JDBCProduct product){
        return service.saveProduct(product);
    }



    @GetMapping("/jdbcproduct/{id}")
    public JDBCProduct findProductById(@PathVariable  int id){
        return service.getProductById(id);
    }

    @GetMapping("/jdbcproduct/fullName")
    public JDBCProduct findProductByFullName(@RequestParam(value="fullName")  String fullName){
        return service.getProductByFullName(fullName);
    }


}
