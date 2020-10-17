package com.coditation.test.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coditation.test.model.Product;
import com.coditation.test.model.ProductCategory;
import com.coditation.test.repository.ProductRepository;
import com.coditation.test.service.ProductCategoryService;
import com.coditation.test.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductCategoryService productCategoryService;
	@Autowired
	private ProductRepository productRepository;
	@Override
	public ProductCategory findByName(String category) {
		
		return productCategoryService.findByCategoryName(category);
	}

	@Override
	public List findAllByProductCategory(ProductCategory productCategory) {
		return productCategoryService.findAll();
	}

	@Override
	public Product findOne(String productName) {
		
		return productRepository.findByProductName(productName);
	}

	@Override
	public Object save(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

}
