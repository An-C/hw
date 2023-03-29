package ru.otus.webservice.edu.demo.service

import ru.otus.webservice.edu.demo.dto.UserCreateDto
import ru.otus.webservice.edu.demo.dto.UserUpdateDto
import ru.otus.webservice.edu.demo.entity.Users

interface UserService {

    fun get(userId: Long): Users

    fun create(user: UserCreateDto): Users

    fun update(userId: Long, dto: UserUpdateDto): Users

    fun delete(userId: Long)

}