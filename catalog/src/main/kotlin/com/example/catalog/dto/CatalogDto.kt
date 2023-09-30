package com.example.catalog.dto

data class CatalogDto (
    var productId: String = "",
    var qty: Long = 0,
    var unitPrice: Long = 0,
    var totalPrice: Long = 0,

    var orderId: String = "",
    var userId: String = "",
)