package com.example.catalog.jpa

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.util.*

@Entity
@Table(name = "catalogs")
data class CatalogEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(nullable = false, length = 120, unique = true)
    var productId: String = "",
    @Column(nullable = false)
    var productName: String = "",
    @Column(nullable = false)
    var stock: Long = 0,
    @Column(nullable = false)
    var unitPrice: Long = 0,
    @Column(nullable = false, updatable = false, insertable = false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    var createdAt: Date = Date(),
)