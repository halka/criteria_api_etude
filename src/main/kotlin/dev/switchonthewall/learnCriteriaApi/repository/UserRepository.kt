package dev.switchonthewall.learnCriteriaApi.repository

import dev.switchonthewall.learnCriteriaApi.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long>, JpaSpecificationExecutor<User>{

}
