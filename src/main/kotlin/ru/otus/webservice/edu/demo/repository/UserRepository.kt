package ru.otus.webservice.edu.demo.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.otus.webservice.edu.demo.entity.Users

interface UserRepository: JpaRepository<Users, Long>