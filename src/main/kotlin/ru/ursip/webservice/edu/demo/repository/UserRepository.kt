package ru.ursip.webservice.edu.demo.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.ursip.webservice.edu.demo.entity.Users

interface UserRepository: JpaRepository<Users, Long>