package com.example.walterbiblioteca.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record LivroDto(

        @JsonProperty(access = Access.READ_ONLY) // 👈 não aparece no Swagger POST
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
) {}
