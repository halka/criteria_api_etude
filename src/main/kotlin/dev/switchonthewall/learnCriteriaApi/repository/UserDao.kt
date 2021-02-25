package dev.switchonthewall.learnCriteriaApi.repository

import dev.switchonthewall.learnCriteriaApi.model.User
import javax.persistence.EntityManager
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery

class UserDao(private val em:EntityManager) {
    fun findAll(): MutableList<User>? {
        val cb: CriteriaBuilder = em.criteriaBuilder
        val cq: CriteriaQuery<User> = cb.createQuery(User::class.java)
        val root = cq.from(User::class.java)
        cq.select(root)
        val query = em.createQuery(cq)

        return query.resultList
    }
}
