package com.example.walterbiblioteca.service;

import com.example.walterbiblioteca.dtos.LivroUsuarioDto;
import com.example.walterbiblioteca.mappers.LivroUsuarioMapper;
import com.example.walterbiblioteca.models.LivroUsuario;
import com.example.walterbiblioteca.repositories.LivroUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LivroUsuarioService {

    private final LivroUsuarioRepository repository;
    private final LivroUsuarioMapper mapper;

    public LivroUsuarioDto salvar(LivroUsuarioDto dto) {
        LivroUsuario entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    public List<LivroUsuarioDto> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public LivroUsuarioDto buscarPorId(Integer id) {
        Optional<LivroUsuario> optional = repository.findById(id);
        return optional.map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Leitura não encontrada com ID: " + id));
    }

    public LivroUsuarioDto atualizar(Integer id, LivroUsuarioDto dto) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Leitura não encontrada para atualizar");
        }
        LivroUsuario atualizado = mapper.toEntity(dto);
        atualizado.setId(id);
        return mapper.toDto(repository.save(atualizado));
    }

    public void deletar(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Leitura não encontrada para exclusão");
        }
        repository.deleteById(id);
    }
}
