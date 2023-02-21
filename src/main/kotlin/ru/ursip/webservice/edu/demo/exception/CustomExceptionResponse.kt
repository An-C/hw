package ru.ursip.webservice.edu.demo.exception

import java.time.LocalDateTime


class CustomExceptionResponse(
    val timestamp: LocalDateTime,
    val code: Int,
    val description: String,
    val message: String
) {
    companion object {
        const val MESSAGE_UNDEFINED: String = "Cannot define exception message, watch logs on your server"
    }
}