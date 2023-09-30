package com.example.catalog.vo

import com.fasterxml.jackson.annotation.JsonInclude
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ResponseOrder(
    var productId: String = "",
    var qty: Long = 0,
    var unitPrice: Long = 0,
    var totalPrice: Long = 0,
    var createdAt: Date = Date(),

    var orderId: String = "",
)