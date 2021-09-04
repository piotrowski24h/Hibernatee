package com.kodilla.hibernatee.invoice.dao;

import com.kodilla.hibernatee.invoice.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {
    List<Product> findByName(String name);
}
