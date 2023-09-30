package com.example.orderservice.jpa

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.util.*

@Entity
@Table(name = "orders")
data class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(nullable = false, length = 120)
    var productId: String = "",
    @Column(nullable = false)
    var qty: Long = 0,
    @Column(nullable = false)
    var unitPrice: Long = 0,
    @Column(nullable = false)
    var totalPrice: Long = 0,

    @Column(nullable = false)
    var userId: String = "",
    @Column(nullable = false, unique = true)
    var orderId: String = "",

    @Column(nullable = false, updatable = false, insertable = false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    var createdAt: Date = Date(),
)
