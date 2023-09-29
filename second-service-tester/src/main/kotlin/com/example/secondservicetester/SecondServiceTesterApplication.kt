package com.example.secondservicetester

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SecondServiceTesterApplication

fun main(args: Array<String>) {
    runApplication<SecondServiceTesterApplication>(*args)
}
