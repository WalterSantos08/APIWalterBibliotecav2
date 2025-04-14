package com.example.walterbiblioteca.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroDto(
        Integer id,

        @NotBlank(message = "Título é obrigatório")
        String titulo,

        @NotBlank(message = "Autor é obrigatório")
        String autor,

        @NotNull(message = "Ano de publicação é obrigatório")
        Integer anoPublicacao,

        @NotBlank(message = "Gênero é obrigatório")
        String genero,

        String descricao
) {
}
