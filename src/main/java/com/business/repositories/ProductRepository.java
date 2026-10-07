package com.business.repositories;

import org.springframework.data.repository.CrudRepository;

import com.business.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	Product findByPname(String name);
}
