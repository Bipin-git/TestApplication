package com.coditation.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coditation.test.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByProductName(String productName);

}
