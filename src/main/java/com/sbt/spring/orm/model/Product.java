package com.sbt.spring.orm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.concurrent.atomic.AtomicInteger;

import com.sbt.spring.orm.dao.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Product {


    @Id
    private Integer id;
    private String productName;


    public Product() {
    }

    public Product(Integer id, String name) {
        this.id = id;
        this.productName = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                '}';
    }
}
