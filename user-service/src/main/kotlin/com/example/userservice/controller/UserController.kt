package com.example.userservice.controller

import com.example.userservice.vo.Greeting
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class UserController(
    val env: Environment,
    val greeting: Greeting,
) {
    @GetMapping("/health_check")
    fun HealthCheck() : String {
        return "It's working in user service"
    }
    @GetMapping("/welcome")
    fun Welcome() : String {
//        return env.getProperty("greeting.message").toString()
        return greeting.message
    }
}