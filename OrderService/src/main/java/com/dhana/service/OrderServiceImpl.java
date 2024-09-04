package com.dhana.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhana.client.ProductService;
import com.dhana.entity.Order;
import com.dhana.model.OrderRequest;
import com.dhana.repository.OrderRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductService productService;

	@Override
	public Long placeOrder(OrderRequest orderRequest) {
		log.info("before placing order");
		productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());
		log.info("after checking product availability for product:"+orderRequest.getProductId());
		   Order order = Order.builder()
				   .orderStatus("CREATED")
				   .price(orderRequest.getAmount())
				   .productId(orderRequest.getProductId())
				   .orderDate(Instant.now())
				   .quantity(orderRequest.getQuantity())
				   .build();
		   log.info("Order Placed");
		  order =  orderRepository.save(order);
		  log.info("Product saved Successfully after placing order");
		return order.getOrderId();
	}

}
