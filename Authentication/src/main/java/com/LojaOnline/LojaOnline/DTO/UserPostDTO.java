package com.LojaOnline.LojaOnline.DTO;

import com.LojaOnline.LojaOnline.DataBase.Model.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserPostDTO(
        @NotBlank
        @Email
        String email,
        @NotBlank
        String name,
        @NotBlank
        String surname,
        @NotBlank
        String password,
        @NotBlank
        String CPF,
        @NotBlank
        String cellNumber,
        @NotNull
        UserRole role
) {
}
