package com.example.catalog.service

import com.example.catalog.jpa.CatalogEntity
import com.example.catalog.jpa.CatalogRepository
import org.springframework.stereotype.Service

@Service
class CatalogServiceImpl(
    private val catalogRepository: CatalogRepository
) : CatalogService {
    override fun getAllCatalogs(): Iterable<CatalogEntity> {
        return catalogRepository.findAll()
    }
}