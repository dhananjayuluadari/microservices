package com.dhana.model;

import lombok.Builder;

@Builder
public record ProductRequest(String productName,double price,int quantity) {
	
}
