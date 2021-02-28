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
    fun getUsers(@RequestParam(value = "status") status: Optional<String>): MutableList<User> {
        if (status.isPresent) {
            val criteriaBuilder: CriteriaBuilder = entityManager.criteriaBuilder
            val criteriaQuery: CriteriaQuery<User> = criteriaBuilder.createQuery(User::class.java)
            val root: Root<User> = criteriaQuery.from(User::class.java)
            criteriaQuery.where(root.get<String>("status").`in`(status.get().split(",").map { it.trim() }))
            return entityManager.createQuery(criteriaQuery).resultList
        } else {
            return userRepository.findAll()
        }
    }

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
}
