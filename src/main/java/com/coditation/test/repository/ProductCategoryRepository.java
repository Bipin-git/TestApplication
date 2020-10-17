package com.coditation.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coditation.test.model.ProductCategory;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer>{

	List<ProductCategory> findAllByOrderByCategoryId();

	ProductCategory findByCategoryName(String category);

	ProductCategory findByCategoryId(Long categoryId);

}
