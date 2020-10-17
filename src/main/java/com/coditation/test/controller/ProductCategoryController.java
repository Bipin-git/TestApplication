package com.coditation.test.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coditation.test.model.ProductCategory;
import com.coditation.test.response.ResponseMessage;
import com.coditation.test.service.ProductCategoryService;


@RestController
@RequestMapping(value = "/api")
public class ProductCategoryController {

	@Autowired
	private ProductCategoryService productCategoryService;
	
	@PostMapping("/category/new")
	public ResponseEntity<?> create(@Valid @RequestBody ProductCategory productCategory)
	{
		
		ProductCategory categoryExist = productCategoryService.findOne(productCategory.getCategoryId());
		if(categoryExist != null)
		{
			return new ResponseEntity<>(new ResponseMessage("Fail -> Category is already in use!"), 
										HttpStatus.BAD_REQUEST);
		}
		productCategoryService.save(productCategory);
		
		return new ResponseEntity<>(new ResponseMessage("Category Added Successfully!"),HttpStatus.OK);
	}
}
