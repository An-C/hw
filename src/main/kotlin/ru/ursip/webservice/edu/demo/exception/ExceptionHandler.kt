package ru.ursip.webservice.edu.demo.exception

import org.slf4j.LoggerFactory
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime
import javax.persistence.EntityNotFoundException


@ControllerAdvice(annotations = [(RestController::class)])
class ExceptionHandler : ResponseEntityExceptionHandler() {

    private val log = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundException(ex: ResourceNotFoundException, request: WebRequest): ResponseEntity<Any> {
        return buildResponse("Object not found", ex, HttpStatus.PRECONDITION_FAILED, request)
    }

    @ExceptionHandler(EmptyResultDataAccessException::class)
    fun handleEmptyResultDataAccessException(ex: EmptyResultDataAccessException, request: WebRequest): ResponseEntity<Any> {
        return buildResponse("Object not found", ex, HttpStatus.PRECONDITION_FAILED, request)
    }

    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleResourceNotFoundException(ex: DataIntegrityViolationException, request: WebRequest): ResponseEntity<Any> {
        return buildResponse("Data integrity exception", ex, HttpStatus.UNPROCESSABLE_ENTITY, request)
    }

    @ExceptionHandler(EntityNotFoundException::class)
    fun handleEntityNotFoundException(ex: EntityNotFoundException, request: WebRequest): ResponseEntity<Any> {
        return buildResponse("Object not found", ex, HttpStatus.NO_CONTENT, request)
    }


    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest): ResponseEntity<Any> {
        return buildResponse("Server error", ex, HttpStatus.INTERNAL_SERVER_ERROR, request)
    }

    private fun buildResponse(prefixMsg: String, ex: Exception, status: HttpStatus, request: WebRequest): ResponseEntity<Any> {
        return buildMessage(prefixMsg, ex)
                .also { log.error(it, ex) }
                .let { CustomExceptionResponse(LocalDateTime.now(), status.value(), request.getDescription(false), it) }
                .let { ResponseEntity(it, status) }
    }

    private fun buildMessage(prefix: String, ex: Exception) =
            prefix + (ex.message?.let { ": $it" } ?: CustomExceptionResponse.MESSAGE_UNDEFINED)

    override fun handleMethodArgumentNotValid(ex: MethodArgumentNotValidException, headers: HttpHeaders, status: HttpStatus, request: WebRequest): ResponseEntity<Any> {
        val response = CustomExceptionResponse(LocalDateTime.now(), 400, request.getDescription(false), ex.bindingResult.toString())
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }
}