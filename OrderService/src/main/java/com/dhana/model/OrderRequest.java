package com.dhana.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {

	private Long productId;
	private Double amount;
	private int quantity;
	private PaymentMode paymentMode;
}
