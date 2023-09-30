package com.example.userservice.service

import com.example.userservice.dto.UserDto
import com.example.userservice.jpa.UserEntity
import com.example.userservice.jpa.UserRepository
import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies.STRICT
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
) : UserService {
    override fun createUser(userDto: UserDto): UserDto {
        userDto.userId = UUID.randomUUID().toString()

        val mapper = ModelMapper();
        mapper.configuration.setMatchingStrategy(STRICT)
        val userEntity = mapper.map(userDto, UserEntity::class.java)
        userEntity.encryptedPwd = "encryptedPwd"

        userRepository.save(userEntity)

        return userDto
    }
}