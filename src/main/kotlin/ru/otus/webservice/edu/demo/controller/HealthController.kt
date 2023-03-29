package ru.otus.webservice.edu.demo.controller

import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping
@CrossOrigin
class HealthController() {

    @GetMapping("/health")
    fun checkHealth(): Map<String, String> = mapOf("status" to "OK")

    @GetMapping
    fun sayHello(): String = "¯\\_(ツ)_/¯"

}
