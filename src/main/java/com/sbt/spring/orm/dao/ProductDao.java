package com.sbt.spring.orm.dao;

import com.sbt.spring.orm.model.Product;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Component
public class ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Product product) {
        entityManager.persist(product);
    }

    public List<Product> findAll() {
        return entityManager.createQuery("SELECT p FROM Product p").getResultList();
    }

    /** Метод возврщает следующее значение идентефикатора из БД
     * @return
     */

    // TODO Сделать вызовом хранимой процедуры!
    public Integer getNextId() {
        return (Integer) entityManager.createQuery("SELECT max(id) FROM Product").getSingleResult() + 1;
    }
}
