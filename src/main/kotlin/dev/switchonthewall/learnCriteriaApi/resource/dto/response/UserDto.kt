package dev.switchonthewall.learnCriteriaApi.resource.dto.response

import dev.switchonthewall.learnCriteriaApi.model.User
import java.time.LocalDateTime

data class UserDto(
    val id: Long,
    val name: String?,
    val status: String?,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
){
    companion object {
        fun new(user: User): UserDto {
            return UserDto(
                id = user.id,
                name = user.name,
                status = user.status,
                createdAt = user.createdAt,
                updatedAt = user.updatedAt
            )
        }
    }
}
