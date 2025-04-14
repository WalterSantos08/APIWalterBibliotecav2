package com.example.walterbiblioteca.services;

import com.example.walterbiblioteca.dtos.LivroDto;
import com.example.walterbiblioteca.mappers.LivroMapper;
import com.example.walterbiblioteca.models.Livro;
import com.example.walterbiblioteca.repositories.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    // LISTAR TODOS OS LIVROS
    public List<LivroDto> listarTodos() {
        return livroRepository.findAll()
                .stream()
                .map(LivroMapper::toDto)
                .toList();
    }

    // BUSCAR UM LIVRO POR ID
    public LivroDto buscarPorId(Integer id) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        return LivroMapper.toDto(livro);
    }

    // SALVAR UM NOVO LIVRO
    public LivroDto salvar(LivroDto dto) {
        Livro livro = LivroMapper.toEntity(dto);
        Livro salvo = livroRepository.save(livro);
        return LivroMapper.toDto(salvo);
    }

    // ATUALIZAR UM LIVRO EXISTENTE
    public LivroDto atualizar(Integer id, LivroDto dto) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        livro.setTitulo(dto.titulo());
        livro.setAutor(dto.autor());
        livro.setAnoPublicacao(dto.anoPublicacao());
        livro.setGenero(dto.genero());
        livro.setDescricao(dto.descricao());

        Livro atualizado = livroRepository.save(livro);
        return LivroMapper.toDto(atualizado);
    }

    // DELETAR UM LIVRO PELO ID
    public void deletar(Integer id) {
        livroRepository.deleteById(id);
    }
}
