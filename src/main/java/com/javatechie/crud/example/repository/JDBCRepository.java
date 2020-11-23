package com.javatechie.crud.example.repository;

import com.javatechie.crud.example.entity.JDBCProduct;
import com.javatechie.crud.example.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class JDBCRepository  {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

   public int save(JDBCProduct product){
        return jdbcTemplate.update(
                "insert into jdbc_product (id, name,fullName, quantity,price) values(?,?,?,?,?)",
                product.getId(),product.getName(),product.getFullName(), product.getQuantity(), product.getPrice());
    };

    public JDBCProduct findById(int id){
        return null;
    };

    public JDBCProduct findByFullName(String fullName){
        return jdbcTemplate.queryForObject(
                "select * from jdbc_product where fullName=?",
                new Object[]{fullName},
                (rs, rowNum) ->
                        new JDBCProduct(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("fullName"),
                                rs.getInt("quantity"),
                                rs.getDouble("price")
                        )
        );
    };
}
