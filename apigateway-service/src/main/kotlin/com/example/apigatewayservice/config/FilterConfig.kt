package com.example.apigatewayservice.config

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FilterConfig {
    @Bean
    fun gatewayRoutes(builder: RouteLocatorBuilder): RouteLocator {
        return builder.routes()
            .route { r ->
                r.path("/first-service/**").filters { filter ->
                    // 요청 헤더에 first-request 값은 first-request-header로 설정
                    // 응답 헤더에 first-response 값은 first-response-header로 설정
                    filter
                        .addRequestHeader("first-request", "first-request-header")
                        .addResponseHeader("first-response", "first-response-header")

                }
                    .uri("http://localhost:8081")
            }
            .route { r ->
                r.path("/second-service/**").filters { filter ->
                    filter
                        .addRequestHeader("second-request", "second-request-header")
                        .addResponseHeader("second-response", "second-response-header")
                }
                    .uri("http://localhost:8082")
            }
            .build()
    }
}