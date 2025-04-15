package com.example.walterbiblioteca.dtos;

import com.example.walterbiblioteca.enums.StatusDeLeitura;

import java.sql.Date;

public record LivroUsuarioDto(
        Integer id,
        String nomeUsuario,
        String tituloLivro,
        StatusDeLeitura statusLeitura,
        Date dataInicio,
        Date dataFim,
        Integer nota,
        String comentarios
) {}

