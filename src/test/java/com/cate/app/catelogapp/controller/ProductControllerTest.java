package com.cate.app.catelogapp.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.Collections;
import java.util.List;

import javax.xml.ws.Response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cate.app.catelogapp.entity.Product;
import com.cate.app.catelogapp.service.ProductService;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

	@InjectMocks
	private ProductController controller;

	@Mock
	private ProductService productService;

	@Test
	void test() {
		Product p = new Product();
		p.setId(1);
		p.setName("Test");
		Mockito.when(productService.byBrand(anyInt())).thenReturn(Collections.singletonList(p));
		ResponseEntity<List<Product>> products = controller.findByBrandId(1);
		Assertions.assertEquals(HttpStatus.OK, products.getStatusCode());
		Assertions.assertEquals("Test", products.getBody().get(0).getName());

	}

}
