package com.cate.app.catelogapp.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cate.app.catelogapp.entity.Product;
import com.cate.app.catelogapp.exception.CateNotFound;
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
		
		Optional.ofNullable(products)
				.orElseThrow(CateNotFound::new)
				.sort(c2);
		Collection<Product> pMap = products
				.stream()
				.collect(Collectors.toMap(Product::getName, p -> p, (p, q) -> p)).values();
		
		System.out.println(pMap);
		
		/*
		 * List<Product> pq = pMap.entrySet() .stream() .map(p -> p.getValue())
		 * .collect(Collectors.toList()); System.out.println(pq);
		 */
		
		
		/*
		 * Optional.ofNullable(products).ifPresent(ps -> { ps.sort(c2); });
		 */
	
		return  new ArrayList<>(pMap);
	
	}
	
	/**
	 *
	 */
	@Override
	public List<Product> byBrand(Integer brandId) {
		return productRepository.searchUsingBrandId(brandId);
	
	}

}
