package dev.switchonthewall.learnCriteriaApi.service

import dev.switchonthewall.learnCriteriaApi.repository.UserRepository

class UserService(private val userRepository: UserRepository) {
    fun getAll(){
        userRepository.findAll()
    }
}
