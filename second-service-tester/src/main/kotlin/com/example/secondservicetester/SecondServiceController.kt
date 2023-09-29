package com.example.secondservicetester

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/second-service")
class SecondServiceController {
    private val log = LoggerFactory.getLogger(this.javaClass)!!

    @GetMapping("/welcome")
    fun hello(): String {
        return "Welcome to the Second service."
    }

    @GetMapping("/message")
    fun message(@RequestHeader("second-request") header: String): String {
        log.info(header)
        return "This is a message from the Second service."
    }
}