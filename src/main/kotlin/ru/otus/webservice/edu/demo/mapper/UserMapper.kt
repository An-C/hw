package ru.otus.webservice.edu.demo.mapper

import ru.otus.webservice.edu.demo.dto.UserCreateDto
import ru.otus.webservice.edu.demo.dto.UserDto
import ru.otus.webservice.edu.demo.dto.UserUpdateDto
import ru.otus.webservice.edu.demo.entity.Users

class UserMapper {

    companion object {

        fun Users.toDto() =
            UserDto(
                id = id,
                username = username,
                firstName = firstName,
                lastName = lastName,
                email = email,
                phone = phone,
            )

        fun UserCreateDto.toUser() =
            Users(
                username = username,
                firstName = firstName,
                lastName = lastName,
                email = email,
                phone = phone,
            )

        fun update(dto: UserUpdateDto, user: Users) {
            user.firstName = dto.firstName
            user.lastName = dto.lastName
            user.email = dto.email
            user.phone = dto.phone
        }
    }
}