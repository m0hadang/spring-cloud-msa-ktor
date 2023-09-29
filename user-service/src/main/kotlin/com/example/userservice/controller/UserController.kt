package com.example.userservice.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class UserController {
    @GetMapping("/health_check")
    fun status() : String {
        return "It's working in user service"
    }
}