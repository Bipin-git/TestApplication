package com.coditation.test.service;

import java.util.List;

import com.coditation.test.model.ProductCategory;

public interface ProductCategoryService {
	
	List<ProductCategory> findAll();
	ProductCategory findByCategoryName(String category);
//	ProductCategory findByCategoryNameAndSubCategoryName(String category, String type);
	ProductCategory save(ProductCategory productCategory);
//	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
	ProductCategory findOne(Long categoryId);
}
