package com.dhana.model;

import lombok.Builder;

@Builder
public record ProductResponse(String productName,double price,int quantity) {

}
