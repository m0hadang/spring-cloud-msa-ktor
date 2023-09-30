package com.example.catalog.vo

import com.fasterxml.jackson.annotation.JsonInclude
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ResponseCatalog(
    var productId: String = "",
    var productName: String = "",
    var unitPrice: Long = 0,
    var stock: Long = 0,
    var createdAt: Date = Date(),
)