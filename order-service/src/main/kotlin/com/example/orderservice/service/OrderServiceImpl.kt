package com.example.orderservice.service

import com.example.orderservice.dto.OrderDto
import com.example.orderservice.jpa.OrderEntity
import com.example.orderservice.jpa.OrderRepository
import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies.STRICT
import org.springframework.stereotype.Service
import java.util.*

@Service
class OrderServiceImpl(
    private val orderRepository: OrderRepository
) : OrderService {
    override fun createOrder(orderDto: OrderDto): OrderDto {
        orderDto.orderId = UUID.randomUUID().toString()
        orderDto.totalPrice = orderDto.qty * orderDto.unitPrice
        val modelMapper = ModelMapper()
        modelMapper.configuration.setMatchingStrategy(STRICT)
        val orderEntity = modelMapper.map(orderDto, OrderEntity::class.java)
        orderRepository.save(orderEntity)
        return modelMapper.map(orderEntity, OrderDto::class.java)
    }
    override fun getOrdersByOrderId(orderId: String): OrderDto {
        val modelMapper = ModelMapper()
        modelMapper.configuration.setMatchingStrategy(STRICT)
        val orderEntity = orderRepository.findByOrderId(orderId)
        return modelMapper.map(orderEntity, OrderDto::class.java)
    }
    override fun getOrdersByUserId(userId: String): Iterable<OrderEntity> {
        return orderRepository.findByUserId(userId)
    }
}