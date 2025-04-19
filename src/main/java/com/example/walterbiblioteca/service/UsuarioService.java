package com.example.walterbiblioteca.service;

import com.example.walterbiblioteca.dtos.UsuarioDto;
import com.example.walterbiblioteca.exception.UsuarioJaExisteException;
import com.example.walterbiblioteca.exception.UsuarioNaoEncontradoException;
import com.example.walterbiblioteca.mappers.UsuarioMapper;
import com.example.walterbiblioteca.models.Usuario;
import com.example.walterbiblioteca.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public List<UsuarioDto> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper::toDto)
                .toList();
    }

    public UsuarioDto buscarPorId(Integer id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(id));
        return UsuarioMapper.toDto(usuario);
    }

    public UsuarioDto salvar(UsuarioDto dto) {
        if (usuarioRepository.findByNomeIgnoreCase(dto.nome()).isPresent()) {
            throw new UsuarioJaExisteException(dto.nome());
        }

        Usuario usuario = UsuarioMapper.toEntity(dto);
        usuario.setSenha(passwordEncoder.encode(dto.senha()));

        Usuario salvo = usuarioRepository.save(usuario);
        return UsuarioMapper.toDto(salvo);
    }

    public UsuarioDto atualizar(Integer id, UsuarioDto dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(id));

        Optional<Usuario> existente = usuarioRepository.findByNomeIgnoreCase(dto.nome());
        if (existente.isPresent() && existente.get().getId() != id) {
            throw new UsuarioJaExisteException(dto.nome());
        }

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(passwordEncoder.encode(dto.senha()));

        Usuario atualizado = usuarioRepository.save(usuario);
        return UsuarioMapper.toDto(atualizado);
    }

    public void deletar(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
