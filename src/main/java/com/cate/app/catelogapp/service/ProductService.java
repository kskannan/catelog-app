package com.cate.app.catelogapp.service;

import java.util.List;

import com.cate.app.catelogapp.entity.Product;

public interface ProductService {
	
	List<Product> getAllProduct();
	
	List<Product> byBrand(Integer brandId);

}
