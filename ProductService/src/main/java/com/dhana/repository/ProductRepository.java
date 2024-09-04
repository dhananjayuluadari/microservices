package com.dhana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhana.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
