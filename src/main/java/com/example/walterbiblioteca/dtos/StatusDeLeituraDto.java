package com.example.walterbiblioteca.dtos;

import jakarta.validation.constraints.NotBlank;

public record StatusDeLeituraDto(
        Integer id,

        @NotBlank(message = "O nome do status é obrigatório")
        String nome
) {
}
