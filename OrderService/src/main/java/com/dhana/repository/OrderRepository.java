package com.dhana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhana.entity.Order;

public interface OrderRepository  extends JpaRepository<Order, Long>{

}
