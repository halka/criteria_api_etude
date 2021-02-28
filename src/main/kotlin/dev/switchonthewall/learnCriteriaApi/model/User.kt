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
    var id: Long,

    @field: [NotBlank Size(max = 255)]
    var name: String?,

    @field: [NotBlank Size(max = 255)]
    var status: String?,

    @field: CreationTimestamp
    @Column(updatable = false)
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @field: UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now(),

)
