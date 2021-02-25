package dev.switchonthewall.learnCriteriaApi.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @field: [NotBlank Size(max = 255)]
    val name: String?,

    @field: [NotBlank Size(max = 255)]
    val status: String?,

    @field: CreationTimestamp
    @Column(updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @field: UpdateTimestamp
    val updatedAt: LocalDateTime = LocalDateTime.now(),

)
