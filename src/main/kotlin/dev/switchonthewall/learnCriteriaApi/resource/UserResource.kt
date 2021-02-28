package dev.switchonthewall.learnCriteriaApi.resource

import dev.switchonthewall.learnCriteriaApi.model.User
import dev.switchonthewall.learnCriteriaApi.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.criteria.*
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UserResource(private val userRepository: UserRepository, private val entityManager: EntityManager){
    @GetMapping
    fun getAll() = userRepository.findAll()

    @GetMapping("/{id}")
    fun getUserById(@PathVariable(value = "id") id: Long): Optional<User> {
        return userRepository.findById(id)
    }

    @PostMapping
    fun addUser(@Valid @RequestBody user:User): User {
        return userRepository.save(user)
    }

    @PutMapping("/{id}")
    fun updateUser(@Valid @RequestBody user:User,
                   @PathVariable(value = "id") id: Long
    ): Optional<User> {
        userRepository.findByIdOrNull(id)?.apply {
            name = user.name
            status = user.status
            userRepository.save(this)
        }
        return userRepository.findById(id)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable(value = "id") id: Long){
        return userRepository.deleteById(id)
    }

    @GetMapping("/status/{status}")
    fun findByStatus(@PathVariable(value = "status") status: String): List<User> {
        val criteriaBuilder: CriteriaBuilder = entityManager.criteriaBuilder
        val criteriaQuery: CriteriaQuery<User> = criteriaBuilder.createQuery(User::class.java)
        val root: Root<User> = criteriaQuery.from(User::class.java)
        criteriaQuery.where(root.get<String>("status").`in`(status.split(",")))
        return entityManager.createQuery(criteriaQuery).resultList
    }
}
