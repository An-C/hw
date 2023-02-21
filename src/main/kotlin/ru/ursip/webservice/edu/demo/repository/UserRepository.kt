package ru.ursip.webservice.edu.demo.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.ursip.webservice.edu.demo.entity.User

interface UserRepository: JpaRepository<User, Long>