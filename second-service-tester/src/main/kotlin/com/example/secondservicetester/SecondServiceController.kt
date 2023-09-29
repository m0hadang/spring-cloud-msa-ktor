package com.example.secondservicetester

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class SecondServiceController {
    @GetMapping("/welcome")
    fun hello() : String {
        return "Welcome to the Second service."
    }
}