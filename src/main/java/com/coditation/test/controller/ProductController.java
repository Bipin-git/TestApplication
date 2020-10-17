package com.coditation.test.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coditation.test.model.Product;
import com.coditation.test.model.ProductCategory;
import com.coditation.test.repository.ProductRepository;
import com.coditation.test.service.ProductCategoryService;
import com.coditation.test.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	ProductCategoryService productCategoryService;
	@Autowired
	ProductService productService;

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ResponseEntity getAll(@RequestParam(value = "category", required = false) String category) {

		if (category != null) {
			ProductCategory productCategory = productCategoryService.findByCategoryName(category);
			if (productCategory == null) {
				throw new IllegalArgumentException("Invalid category parameter");
			}
			List returnList = productService.findAllByProductCategory(productCategory);
			return new ResponseEntity<List>(returnList, HttpStatus.OK);
		}

		List returnList = productCategoryService.findAll();
		return new ResponseEntity<>(returnList, HttpStatus.OK);
	}
	
	@PostMapping("/new")
	public ResponseEntity<?> create(@Valid @RequestBody Product product ,BindingResult bindingResult) {
		Product productExist = productService.findOne(product.getProductName());
		if(productExist != null)
		{
			bindingResult.rejectValue(productExist.getProductName(), "error.Product", "There is already a product with the name provided");
		}
		if(bindingResult.hasErrors())
		{
			return ResponseEntity.badRequest().body(bindingResult);
		}
		
		return ResponseEntity.ok(productService.save(product));
	}
}
