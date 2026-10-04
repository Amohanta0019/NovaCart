package com.telusko.SpringEcom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.SpringEcom.model.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {
    Optional<Order> findByOrderId(String orderId);
}
