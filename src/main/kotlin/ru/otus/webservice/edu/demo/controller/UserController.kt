package ru.otus.webservice.edu.demo.controller

import io.swagger.annotations.Api
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.otus.webservice.edu.demo.dto.UserCreateDto
import ru.otus.webservice.edu.demo.dto.UserDto
import ru.otus.webservice.edu.demo.dto.UserUpdateDto
import ru.otus.webservice.edu.demo.mapper.UserMapper.Companion.toDto
import ru.otus.webservice.edu.demo.service.UserService


@RestController
@RequestMapping("/v1/user")
@CrossOrigin
@Api(tags = ["UserController"])
class UserController(val userService: UserService) {


    @GetMapping("/{userId}")
    fun get(@PathVariable userId: Long): UserDto = userService.get(userId).toDto()

    @PostMapping
    fun create(@RequestBody user: UserCreateDto): UserDto = userService.create(user).toDto()

    @PutMapping("/{userId}")
    fun update(
        @PathVariable userId: Long,
        @RequestBody user: UserUpdateDto
    ): UserDto =
        userService.update(userId, user).toDto()


    @DeleteMapping("/{userId}")
    fun delete(@PathVariable userId: Long) {
        userService.delete(userId)
        ResponseEntity.status(HttpStatus.NO_CONTENT)
    }


}
