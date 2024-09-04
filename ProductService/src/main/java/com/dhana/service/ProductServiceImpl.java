package com.dhana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhana.entity.Product;
import com.dhana.exception.ProductServiceException;
import com.dhana.model.ProductRequest;
import com.dhana.model.ProductResponse;
import com.dhana.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Long addProduct(ProductRequest productRequest) {
		Product product = Product.builder()
				           .productName(productRequest.productName())
				           .price(productRequest.price())
				           .quantity(productRequest.quantity())
				           .build();
		productRepository.save(product);
		return product.getProductId();
	}

	@Override
	public ProductResponse getProductById(Long productId) throws ProductServiceException {
		
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ProductServiceException("Product id Not found", "PRODUCT_NOT_FOUND")); 
		ProductResponse productResponse = ProductResponse.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
		
		return productResponse;
	}

	@Override
	public void reduceQuantity(Long productId, int quantity) throws ProductServiceException {
		log.info("reducing quantity initiated");
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ProductServiceException("Product id Not found", "PRODUCT_NOT_FOUND"));
		
		if(product instanceof Product) {
			log.info("checking product quantity");
			if(product.getQuantity() < quantity) {
				throw new ProductServiceException("not having enough quantity of products", "NOT_ENOUGH_QUANTITY");
			}
			product.setQuantity(product.getQuantity() - quantity);
			productRepository.save(product);
			log.info("product saved in DB");
		}
		
	}

}
