package com.example.catalog.controller

import com.example.catalog.service.CatalogService
import com.example.catalog.vo.ResponseCatalog
import org.modelmapper.ModelMapper
import org.springframework.core.env.Environment
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class CatalogController(
    val env: Environment,
    private val catalogService: CatalogService,
) {
    @GetMapping("/catalog-service/health_check")
    fun HealthCheck(): String {
        return "It's working in user service on PORT : " +
                "${env.getProperty("local.server.port")}"
    }
    @GetMapping("/catalog-service/catalogs")
    fun getCatalogs(): ResponseEntity<List<ResponseCatalog>> {
        val catalogList = catalogService.getAllCatalogs()
        val result = catalogList.map { it ->
            ModelMapper().map(it, ResponseCatalog::class.java)
        }
        return ResponseEntity.status(HttpStatus.OK).body(result)
    }
}