package com.coditation.test.service;

import java.util.List;

import com.coditation.test.model.Product;
import com.coditation.test.model.ProductCategory;

public interface ProductService {

	  ProductCategory findByName(String category);

	List findAllByProductCategory(ProductCategory productCategory);

	Product findOne(String productName);

	Object save(Product product);
}
