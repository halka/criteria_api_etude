package dev.switchonthewall.learnCriteriaApi.resource.dto.response

import dev.switchonthewall.learnCriteriaApi.model.User

data class UserListDto (
    val users: List<UserListItemDto>
){
    companion object {
        fun new(users: List<User>): UserListDto {
            return UserListDto(
                users = users.map { UserListItemDto.new(it) }
            )
        }
    }
}
