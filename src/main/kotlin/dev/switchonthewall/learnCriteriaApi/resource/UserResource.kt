package dev.switchonthewall.learnCriteriaApi.resource

import dev.switchonthewall.learnCriteriaApi.model.AddUser
import dev.switchonthewall.learnCriteriaApi.model.AddUser_
import dev.switchonthewall.learnCriteriaApi.model.User
import dev.switchonthewall.learnCriteriaApi.model.User_
import org.seasar.doma.jdbc.criteria.Entityql
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.HttpClientErrorException
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UserResource(
    private val entityql: Entityql
) {
    @GetMapping
    fun getUsers():List<User> {
        return entityql.from(User_()).fetch()
    }

    @PostMapping
    fun addUser(
        @Valid @RequestBody user: AddUser,
        bindingResult: BindingResult
    ): ResponseEntity<AddUser>{
        if (bindingResult.hasErrors()){
            throw HttpClientErrorException(HttpStatus.BAD_REQUEST, "failed")
        } else {
            var u: AddUser_ = AddUser_()
            val result = entityql.insert(u, user).execute()
            print(result)
            return ResponseEntity.ok().body(result.entity)
        }
    }
}
