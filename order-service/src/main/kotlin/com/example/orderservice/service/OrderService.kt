package com.example.orderservice.service

import com.example.orderservice.dto.OrderDto
import com.example.orderservice.jpa.OrderEntity


interface OrderService {
    fun createOrder(orderDto: OrderDto): OrderDto;
    fun getOrdersByOrderId(orderId: String): OrderDto;
    fun getOrdersByUserId(userId: String): Iterable<OrderEntity>;
}