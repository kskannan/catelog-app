package com.cate.app.catelogapp.service;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cate.app.catelogapp.entity.Product;
import com.cate.app.catelogapp.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
	
	@InjectMocks
	private ProductServiceImpl productServiceImpl;
	
	@Mock
	private ProductRepository productRepository;

	
	@Test
	void findByBrand() {
	
		Product p = new Product();
		p.setId(1);
		p.setName("Test");
		Mockito.when(productRepository.searchUsingBrandId(1)).thenReturn(Collections.singletonList(p));
		List<Product> products = productServiceImpl.byBrand(1);
		Assertions.assertNotNull(products);
		Assertions.assertEquals("Test", products.get(0).getName());
	}

}
