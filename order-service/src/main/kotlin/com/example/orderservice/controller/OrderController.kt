package com.example.orderservice.controller

import com.example.catalog.vo.ResponseOrder
import com.example.orderservice.dto.OrderDto
import com.example.orderservice.service.OrderService
import com.example.orderservice.vo.RequestOrder
import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies
import org.springframework.core.env.Environment
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/order-service")
class OrderController(
    val env: Environment,
    private val orderService: OrderService,
) {
    @GetMapping("/health_check")
    fun HealthCheck(): String {
        return "It's working in user service on PORT : " +
                "${env.getProperty("local.server.port")}"
    }
    @PostMapping("/{userId}/order")
    fun createUser(
        @PathVariable("userId") userId: String,
        @RequestBody orderDetails: RequestOrder
    ): ResponseEntity<ResponseOrder> {
        val mapper = ModelMapper();
        mapper.configuration.setMatchingStrategy(MatchingStrategies.STRICT)

        val orderDto = mapper.map(orderDetails, OrderDto::class.java)
        orderDto.userId = userId
        val createOrderDto = orderService.createOrder(orderDto)

        val responseOrder = mapper.map(createOrderDto, ResponseOrder::class.java)
        return ResponseEntity.status(HttpStatus.CREATED).body(responseOrder)
    }

    @GetMapping("/{userId}/orders")
    fun getOrders(
        @PathVariable("userId") userId: String,
    ): ResponseEntity<List<ResponseOrder>> {
        val orderList = orderService.getOrdersByUserId(userId)
        val result = orderList.map { it ->
            ModelMapper().map(it, ResponseOrder::class.java)
        }
        return ResponseEntity.status(HttpStatus.OK).body(result)
    }
}