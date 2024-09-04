package com.dhana.service;

import com.dhana.model.OrderRequest;

public interface OrderService {

	Long placeOrder(OrderRequest orderRequest);

}
