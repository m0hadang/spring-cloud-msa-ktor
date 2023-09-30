package com.example.catalogservice.jpa

import com.example.catalogservice.jpa.CatalogEntity
import org.springframework.data.repository.CrudRepository

interface CatalogRepository : CrudRepository<CatalogEntity, Long> {
    fun findByProductId(productId: String): CatalogEntity;
}