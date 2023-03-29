package ru.otus.webservice.edu.demo.dto

import io.swagger.annotations.ApiModel

@ApiModel("User Update Model")
data class UserUpdateDto(
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
)