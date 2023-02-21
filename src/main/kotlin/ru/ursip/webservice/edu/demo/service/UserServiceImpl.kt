package ru.ursip.webservice.edu.demo.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.ursip.webservice.edu.demo.dto.UserCreateDto
import ru.ursip.webservice.edu.demo.dto.UserUpdateDto
import ru.ursip.webservice.edu.demo.entity.User
import ru.ursip.webservice.edu.demo.exception.ResourceNotFoundException
import ru.ursip.webservice.edu.demo.mapper.UserMapper
import ru.ursip.webservice.edu.demo.mapper.UserMapper.Companion.toUser
import ru.ursip.webservice.edu.demo.repository.UserRepository


@Service
@Transactional
class UserServiceImpl(val userRepository: UserRepository): UserService {

    @Transactional(readOnly = true)
    override fun get(userId: Long): User =
        userRepository.findById(userId)
            .orElseThrow { throw ResourceNotFoundException("Пользователь $userId не найден") }

    override fun create(user: UserCreateDto): User =
        userRepository.save(user.toUser())

    override fun update(userId: Long, dto: UserUpdateDto): User =
        userRepository.findById(userId)
            .orElseThrow { throw ResourceNotFoundException("Пользователь $userId не найден, а нового создать нельзя, потому что в API не предусмотрен параметр username в PUT-запросе ¯\\_(ツ)_/¯") }
            .also { UserMapper.update(dto, it) }

    override fun delete(userId: Long) {
        userRepository.deleteById(userId)
    }
}