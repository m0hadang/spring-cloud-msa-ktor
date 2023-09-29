package com.example.firstservicetester

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class FirstServiceController {
    @GetMapping("/welcome")
    fun hello() : String {
        return "Welcome to the First service."
    }
}