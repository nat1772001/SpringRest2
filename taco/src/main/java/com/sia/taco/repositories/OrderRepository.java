package com.sia.taco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sia.taco.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
