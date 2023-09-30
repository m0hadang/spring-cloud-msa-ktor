package com.example.catalog.service

import com.example.catalog.jpa.CatalogEntity

interface CatalogService {
    fun getAllCatalogs(): Iterable<CatalogEntity>;
}