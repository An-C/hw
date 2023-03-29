package ru.otus.webservice.edu.demo.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.otus.webservice.edu.demo.dto.UserCreateDto
import ru.otus.webservice.edu.demo.dto.UserUpdateDto
import ru.otus.webservice.edu.demo.entity.Users
import ru.otus.webservice.edu.demo.exception.ResourceNotFoundException
import ru.otus.webservice.edu.demo.mapper.UserMapper
import ru.otus.webservice.edu.demo.mapper.UserMapper.Companion.toUser
import ru.otus.webservice.edu.demo.repository.UserRepository


@Service
@Transactional
class UserServiceImpl(val userRepository: UserRepository): UserService {

    @Transactional(readOnly = true)
    override fun get(userId: Long): Users =
        userRepository.findById(userId)
            .orElseThrow { throw ResourceNotFoundException("Пользователь $userId не найден") }

    override fun create(user: UserCreateDto): Users =
        userRepository.save(user.toUser())

    override fun update(userId: Long, dto: UserUpdateDto): Users =
        userRepository.findById(userId)
            .orElseThrow { throw ResourceNotFoundException("Пользователь $userId не найден, а нового создать нельзя, потому что в API не предусмотрен параметр username в PUT-запросе ¯\\_(ツ)_/¯") }
            .also { UserMapper.update(dto, it) }

    override fun delete(userId: Long) {
        userRepository.deleteById(userId)
    }
}