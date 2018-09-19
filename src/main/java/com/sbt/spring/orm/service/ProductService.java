package com.sbt.spring.orm.service;

import com.sbt.spring.orm.dao.ProductDao;
import com.sbt.spring.orm.model.Product;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Component
public class ProductService {

    @Autowired
    ProductDao productDao;

    Logger logger = Logger.getLogger(ProductService.class);

    @Transactional
    public void add(Product product) {
        productDao.persist(product);
        logger.info("Product successful added to DB!");
    }

    @Transactional
    public void addAll(Collection<Product> products) {
        for (Product p : products) {
            productDao.persist(p);
        }
    }

    @Transactional(readOnly = true)
    public List<Product> allProducts() {
        logger.info("Get all products call");
        return productDao.findAll();
    }

    @Transactional(readOnly = true)
    public Integer getNextProductId() {
        return productDao.getNextId();
    }
}
