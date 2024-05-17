package com.LojaOnline.LojaOnline.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginPostDTO(
        @NotBlank
        @Email
        String email,
        @NotBlank
        String password
) {
}
