package dev.switchonthewall.learnCriteriaApi.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

import org.seasar.doma.Column
import org.seasar.doma.Entity
import org.seasar.doma.GeneratedValue
import org.seasar.doma.GenerationType
import org.seasar.doma.Id
import org.seasar.doma.Metamodel
import org.seasar.doma.Table
import org.seasar.doma.jdbc.entity.NamingType

@Entity(immutable = true, metamodel = Metamodel(), naming = NamingType.SNAKE_LOWER_CASE)
@Table(name = "users")
data class AddUser(
    @field: [NotBlank Size(max = 255)]
    val name: String?,

    @field: [NotBlank Size(max = 255)]
    val status: String?

)
