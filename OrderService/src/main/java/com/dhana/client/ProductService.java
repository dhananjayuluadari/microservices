package com.dhana.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name="PRODUCTSERVICE")
public interface ProductService {

	@PutMapping("/product/reduceQuantity/{id}")
	public ResponseEntity<Void> reduceQuantity(@PathVariable("id") Long productId, @RequestParam("quantity") int quantity);
}
