package com.dhana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dhana.exception.ProductServiceException;
import com.dhana.model.ProductRequest;
import com.dhana.model.ProductResponse;
import com.dhana.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) {

		Long productId = productService.addProduct(productRequest);

		return new ResponseEntity<Long>(productId, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse> getProduct(@PathVariable("id") Long productId) throws ProductServiceException{
		ProductResponse productResponse =productService.getProductById(productId);
		
		return new ResponseEntity<>(productResponse, HttpStatus.OK);
	}
	
	@PutMapping("/reduceQuantity/{id}")
	public ResponseEntity<Void> reduceQuantity(@PathVariable("id") Long productId, @RequestParam("quantity") int quantity) throws ProductServiceException{
		productService.reduceQuantity(productId,quantity);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
