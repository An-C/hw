package ru.ursip.webservice.edu.demo.service

import ru.ursip.webservice.edu.demo.dto.UserCreateDto
import ru.ursip.webservice.edu.demo.dto.UserUpdateDto
import ru.ursip.webservice.edu.demo.entity.User

interface UserService {

    fun get(userId: Long): User

    fun create(user: UserCreateDto): User

    fun update(userId: Long, dto: UserUpdateDto): User

    fun delete(userId: Long)

}