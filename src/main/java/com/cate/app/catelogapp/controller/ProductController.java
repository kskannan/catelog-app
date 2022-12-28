package com.cate.app.catelogapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/products")
public class ProductController {
	
	@GetMapping
	public ResponseEntity<String> allProducts() {
		
		return ResponseEntity.status(HttpStatus.OK).body("Test API!");
	}

}
