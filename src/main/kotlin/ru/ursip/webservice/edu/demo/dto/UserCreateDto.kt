package ru.ursip.webservice.edu.demo.dto

import io.swagger.annotations.ApiModel

@ApiModel("User Creation Model")
data class UserCreateDto(
    val username: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
)