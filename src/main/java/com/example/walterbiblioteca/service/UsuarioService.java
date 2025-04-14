package com.example.walterbiblioteca.service;

import com.example.walterbiblioteca.dtos.UsuarioDto;
import com.example.walterbiblioteca.mappers.UsuarioMapper;
import com.example.walterbiblioteca.models.Usuario;
import com.example.walterbiblioteca.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public List<UsuarioDto> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper::toDto)
                .toList();
    }

    public UsuarioDto buscarPorId(Integer id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return UsuarioMapper.toDto(usuario);
    }

    public UsuarioDto salvar(UsuarioDto dto) {
        Usuario usuario = UsuarioMapper.toEntity(dto);
        Usuario salvo = usuarioRepository.save(usuario);
        return UsuarioMapper.toDto(salvo);
    }

    public UsuarioDto atualizar(Integer id, UsuarioDto dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());

        Usuario atualizado = usuarioRepository.save(usuario);
        return UsuarioMapper.toDto(atualizado);
    }

    public void deletar(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
