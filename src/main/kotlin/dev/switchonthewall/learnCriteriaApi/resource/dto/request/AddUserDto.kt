package dev.switchonthewall.learnCriteriaApi.resource.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class AddUserDto(
    @field: [NotBlank Size(max = 255)]
    val name: String,

    @field: [NotBlank Size(max = 255)]
    val status: String,

)
