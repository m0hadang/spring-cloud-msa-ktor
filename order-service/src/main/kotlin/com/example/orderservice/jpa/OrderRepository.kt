package com.example.orderservice.jpa

import org.springframework.data.repository.CrudRepository

interface OrderRepository : CrudRepository<OrderEntity, Long> {
    fun findByOrderId(productId: String): OrderEntity;
    fun findByUserId(userId: String): Iterable<OrderEntity>;
}