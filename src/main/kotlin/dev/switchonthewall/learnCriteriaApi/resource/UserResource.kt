package dev.switchonthewall.learnCriteriaApi.resource

import dev.switchonthewall.learnCriteriaApi.repository.UserRepository
import dev.switchonthewall.learnCriteriaApi.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.HttpClientErrorException
import javax.persistence.EntityManager
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UserResource(private val userService: UserService){
    @GetMapping
    fun getAll() = userService.getAll()
}
