package com.cate.app.catelogapp.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cate.app.catelogapp.entity.Product;
import com.cate.app.catelogapp.repository.ProductRepository;



@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProduct() {
		Comparator<Product> com = (p1, p2) -> Integer.compare(p2.getId(), p1.getId());
		Comparator<Product> c2 = (p1, p2) -> p2.getName().compareTo(p1.getName());
		Comparator<Product> c4 = Comparator.comparingInt(Product::getId);
		List<Product> products = productRepository.findAll();
		
		Optional.ofNullable(products).ifPresent(ps -> {
			ps.sort(c2);
		});
	
		return products;
	
	}
	
	/**
	 *
	 */
	@Override
	public List<Product> byBrand(Integer brandId) {
		return productRepository.searchUsingBrandId(brandId);
	
	}

}
