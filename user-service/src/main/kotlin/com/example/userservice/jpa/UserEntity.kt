package com.example.userservice.jpa

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(nullable = false, unique = true)
    var userId: String = "",
    @Column(nullable = false, length = 50)
    var name: String = "",
    @Column(nullable = false, length = 50, unique = true)
    var email: String = "",
    @Column(nullable = false)
    var encryptedPwd: String = "",
)