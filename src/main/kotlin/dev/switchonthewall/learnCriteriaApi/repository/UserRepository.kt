package dev.switchonthewall.learnCriteriaApi.repository

import dev.switchonthewall.learnCriteriaApi.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional
interface UserRepository : JpaRepository<User, Long>{
    @Query("SELECT u FROM User u WHERE u.name = :name")
    fun findByName(name: String): User
}
