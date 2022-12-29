package com.cate.app.catelogapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cate.app.catelogapp.entity.Product;
import com.cate.app.catelogapp.service.ProductService;

@RestController
@RequestMapping("api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> allProducts() {
		return new ResponseEntity<>(productService.getAllProduct(), new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/{brandId}")
	public ResponseEntity<List<Product>> findByBrandId(@PathVariable Integer brandId) {		
		return new ResponseEntity<>(productService.byBrand(brandId), new HttpHeaders(), HttpStatus.OK);
	}

}
