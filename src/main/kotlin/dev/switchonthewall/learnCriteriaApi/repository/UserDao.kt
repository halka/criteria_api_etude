package dev.switchonthewall.learnCriteriaApi.repository

import dev.switchonthewall.learnCriteriaApi.model.User
import javax.persistence.EntityManager
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery

class UserDao(private val entityManager: EntityManager) {
    fun findAll(): MutableList<User>? {
        val criteriaBuilder: CriteriaBuilder = entityManager.criteriaBuilder
        val criteriaQuery: CriteriaQuery<User> = criteriaBuilder.createQuery(User::class.java)
        val root = criteriaQuery.from(User::class.java)
        criteriaQuery.select(root)
        val query = entityManager.createQuery(criteriaQuery)

        return query.resultList
    }
}
