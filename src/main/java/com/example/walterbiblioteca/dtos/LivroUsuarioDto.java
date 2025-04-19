package com.example.walterbiblioteca.dtos;

import com.example.walterbiblioteca.enums.StatusDeLeitura;

import java.time.LocalDate;

public record LivroUsuarioDto(
        Integer id,
        String nomeUsuario,
        String tituloLivro,
        StatusDeLeitura statusLeitura,
        LocalDate dataInicio,
        LocalDate dataFim,
        Integer nota,
        String comentarios
) {}
