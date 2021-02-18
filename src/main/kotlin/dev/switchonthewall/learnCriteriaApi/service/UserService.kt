package dev.switchonthewall.learnCriteriaApi.service

import dev.switchonthewall.learnCriteriaApi.model.User
import dev.switchonthewall.learnCriteriaApi.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun getUsers(): List<User> =
        userRepository.findAll()

    fun addUser(user: User): User =
        userRepository.save(user)

    fun getUserById(id: Long): User? =
        userRepository.findById(id).orElse(null)

    fun updateUser(id: Long, newUser: User): User?=
        userRepository.findById(id).map { currentUser ->
            currentUser.name = newUser.name
            currentUser.status = newUser.status
            userRepository.save(currentUser)
        }.orElse(null)

    fun deleteUser(id: Long): Boolean =
        userRepository.findById(id).map { user ->
            userRepository.delete(user)
            true
        }.orElse(null)
}
