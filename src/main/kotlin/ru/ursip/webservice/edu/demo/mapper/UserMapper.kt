package ru.ursip.webservice.edu.demo.mapper

import ru.ursip.webservice.edu.demo.dto.UserCreateDto
import ru.ursip.webservice.edu.demo.dto.UserDto
import ru.ursip.webservice.edu.demo.dto.UserUpdateDto
import ru.ursip.webservice.edu.demo.entity.User

class UserMapper {

    companion object {

        fun User.toDto() =
            UserDto(
                id = id,
                username = username,
                firstName = firstName,
                lastName = lastName,
                email = email,
                phone = phone,
            )

        fun UserCreateDto.toUser() =
            User(
                username = username,
                firstName = firstName,
                lastName = lastName,
                email = email,
                phone = phone,
            )

        fun update(dto: UserUpdateDto, user: User) {
            user.firstName = dto.firstName
            user.lastName = dto.lastName
            user.email = dto.email
            user.phone = dto.phone
        }
    }
}