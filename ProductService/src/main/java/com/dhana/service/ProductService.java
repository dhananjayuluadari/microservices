package com.dhana.service;

import com.dhana.exception.ProductServiceException;
import com.dhana.model.ProductRequest;
import com.dhana.model.ProductResponse;

public interface ProductService {

	Long addProduct(ProductRequest productRequest);

	ProductResponse getProductById(Long productId) throws ProductServiceException;

	void reduceQuantity(Long productId, int quantity) throws ProductServiceException;

}
