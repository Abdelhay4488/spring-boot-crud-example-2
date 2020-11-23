package com.javatechie.crud.example.service;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    // Post Method

    // if you will save only one Product
    public Product saveProduct(Product product){
        return repository.save(product);
    }

    // if you will save a list of products
    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    // Get Method

    // Get only one Product By Id
    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }
    // Get a list of Products
    public List<Product> getProducts(){
        return repository.findAll();
    }

    // if you want to get by name not Id.
    // Since we do not have a built in function in the JpaRepository class
    // to get by name like with Id , So we need to Create a function
    // in the repository class and call it here

    public Product getProductByname(String name){
        return repository.findByName(name);
    }
    public Product getProductByFullname(String name){
        return repository.findByFullName(name);
    }

    //Delete Method
    public String deleteProduct(int id){
        repository.deleteById(id);
        return "product removed !!" + id;
    }

    // Update Method (Put)
    public Product updateProduct(Product product){
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName((product.getName()));
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return  repository.save(existingProduct);

    }

    public Product getProductBynameAndId(String name, int id) {
        return repository.findByNameAndId(name, id);
    }
}
