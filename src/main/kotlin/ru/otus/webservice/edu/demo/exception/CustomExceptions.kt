package ru.otus.webservice.edu.demo.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NO_CONTENT)
class ResourceNotFoundException(message: String) : RuntimeException(message)

