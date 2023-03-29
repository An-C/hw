package ru.otus.webservice.edu.demo.dto

import io.swagger.annotations.ApiModel

@ApiModel("User Model")
data class UserDto(
    val id: Long,
    val username: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
)