package com.example.orderservice.vo

data class RequestOrder(
    var productId: String = "",
    var qty: Long = 0,
    var unitPrice: Long = 0,
)