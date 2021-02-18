package dev.switchonthewall.learnCriteriaApi.resource

import dev.switchonthewall.learnCriteriaApi.model.User
import dev.switchonthewall.learnCriteriaApi.resource.dto.request.AddUserDto
import dev.switchonthewall.learnCriteriaApi.resource.dto.request.UpdateUserDto
import dev.switchonthewall.learnCriteriaApi.resource.dto.response.UserDto
import dev.switchonthewall.learnCriteriaApi.resource.dto.response.UserListDto
import dev.switchonthewall.learnCriteriaApi.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.HttpClientErrorException
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UserResource(
    private val userService: UserService
){
    @GetMapping
    fun getUsers(): UserListDto =
        UserListDto.new(userService.getUsers())

    @GetMapping("/{id}")
    fun getUserById(@PathVariable(value = "id") id: Long): ResponseEntity<UserDto> {
        val user = userService.getUserById(id) ?: throw HttpClientErrorException(HttpStatus.NOT_FOUND, "not found")
        return ResponseEntity.ok().body(UserDto.new(user))
    }

    @PostMapping
    fun addUser(
        @Valid @RequestBody addUserDto: AddUserDto,
        bindingResult: BindingResult
    ): ResponseEntity<UserDto> {
        if(bindingResult.hasErrors()) {
            throw HttpClientErrorException(HttpStatus.BAD_REQUEST, "failed")
        } else {
            val newUser = User(name = addUserDto.name, status = addUserDto.status)
            return ResponseEntity.ok().body(UserDto.new(userService.addUser(newUser)))
        }
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable(value = "id") id: Long,
                   @Valid @RequestBody updateUserDto: UpdateUserDto,
                   bindingResult: BindingResult):
            ResponseEntity<UserDto> {
        val user = userService.getUserById(id) ?: throw HttpClientErrorException(HttpStatus.NOT_FOUND, "not found")
        val updated = userService.updateUser(id, user.copy(name = updateUserDto.name, status = updateUserDto.status)) ?: throw HttpClientErrorException(HttpStatus.EXPECTATION_FAILED, "failed")
        return ResponseEntity.ok().body(UserDto.new(updated))
    }

    @DeleteMapping("{id}")
    fun deleteUser(@PathVariable(value = "id") id: Long): ResponseEntity<Void> {
        userService.deleteUser(id) || throw HttpClientErrorException(HttpStatus.BAD_REQUEST, "failed")
        return ResponseEntity<Void>(HttpStatus.NO_CONTENT)
    }
}
