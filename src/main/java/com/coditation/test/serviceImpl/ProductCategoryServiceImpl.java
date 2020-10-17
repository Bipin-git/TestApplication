package com.coditation.test.serviceImpl;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coditation.test.model.ProductCategory;
import com.coditation.test.repository.ProductCategoryRepository;
import com.coditation.test.service.ProductCategoryService;


@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{

	@Autowired
    ProductCategoryRepository productCategoryRepository;



    @Override
    public List<ProductCategory> findAll() {
        List<ProductCategory> res = productCategoryRepository.findAllByOrderByCategoryId();
       res.sort(Comparator.comparing(ProductCategory::getCategoryId));
        return res;
    }

//    @Override
//    public ProductCategory findByCategoryType(Integer categoryType) {
//        ProductCategory res = productCategoryRepository.findByCategoryType(categoryType);
//        if(res == null) throw new MyException(ResultEnum.CATEGORY_NOT_FOUND);
//        return res;
//    }

 

    @Override
    @Transactional
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

	@Override
	public ProductCategory findByCategoryName(String category) {
		
		return productCategoryRepository.findByCategoryName(category);
	}

	@Override
	public ProductCategory findOne(Long categoryId) {
		// TODO Auto-generated method stub
		return productCategoryRepository.findByCategoryId(categoryId);
	}
}
