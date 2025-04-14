package com.example.walterbiblioteca.mappers;

import com.example.walterbiblioteca.dtos.UsuarioDto;
import com.example.walterbiblioteca.models.Usuario;

public class UsuarioMapper {

    // Converte de Usuario para UsuarioDto
    public static UsuarioDto toDto(Usuario usuario) {
        return new UsuarioDto(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha()
        );
    }

    // Converte de UsuarioDto para Usuario
    public static Usuario toEntity(UsuarioDto dto) {
        Usuario usuario = new Usuario();

        // Garante que só define o ID se ele não for nulo
        if (dto.id() != null) {
            usuario.setId(dto.id());
        }

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());

        return usuario;
    }
}
