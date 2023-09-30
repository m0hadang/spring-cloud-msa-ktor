package com.example.userservice.controller

import com.example.userservice.dto.UserDto
import com.example.userservice.service.UserService
import com.example.userservice.vo.Greeting
import com.example.userservice.vo.RequestUser
import com.example.userservice.vo.ResponseUser
import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies
import org.springframework.core.env.Environment
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class UserController(
    val env: Environment,
    private val greeting: Greeting,
    private val userService: UserService,
) {
    @GetMapping("/user-service/health_check")
    fun HealthCheck(): String {
        return "It's working in user service on PORT : " +
                "${env.getProperty("local.server.port")}"
    }

    @GetMapping("/user-service/welcome")
    fun Welcome(): String {
//        return env.getProperty("greeting.message").toString()
        return greeting.message
    }

    @PostMapping("/user-service/user")
    fun createUser(@RequestBody user: RequestUser): ResponseEntity<ResponseUser> {
        val mapper = ModelMapper();
        mapper.configuration.setMatchingStrategy(MatchingStrategies.STRICT)

        val userDto = mapper.map(user, UserDto::class.java)
        userService.createUser(userDto)

        val responseUser = mapper.map(userDto, ResponseUser::class.java)
        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser)
    }
}