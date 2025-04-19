package com.example.walterbiblioteca.service;

import com.example.walterbiblioteca.dtos.LivroDto;
import com.example.walterbiblioteca.exception.LivroJaExisteException;
import com.example.walterbiblioteca.exception.LivroNaoEncontradoException;
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
                .orElseThrow(() -> new LivroNaoEncontradoException(id));
        return LivroMapper.toDto(livro);
    }

    // SALVAR UM NOVO LIVRO
    public LivroDto salvar(LivroDto dto) {
        if (livroRepository.findByTituloIgnoreCase(dto.titulo().trim()).isPresent()) {
            throw new LivroJaExisteException(dto.titulo());
        }

        Livro livro = LivroMapper.toEntity(dto);
        Livro salvo = livroRepository.save(livro);
        return LivroMapper.toDto(salvo);
    }

    // ATUALIZAR UM LIVRO EXISTENTE
    public LivroDto atualizar(Integer id, LivroDto dto) {
        // 🔎 Busca o livro pelo ID primeiro
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new LivroNaoEncontradoException(id));

        // 🔐 Normaliza o título (sem espaços e letras minúsculas)
        String tituloNormalizado = dto.titulo().trim().toLowerCase();

        // 🔍 Verifica se o título já pertence a outro livro (exceto ele mesmo)
        livroRepository.findAll().stream()
                .filter(l -> !l.getId().equals(id)) // ignora ele mesmo
                .map(l -> l.getTitulo().trim().toLowerCase())
                .filter(titulo -> titulo.equals(tituloNormalizado))
                .findFirst()
                .ifPresent(t -> {
                    throw new LivroJaExisteException(dto.titulo());
                });

        // Atualiza os campos
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
        if (!livroRepository.existsById(id)) {
            throw new LivroNaoEncontradoException(id);
        }
        livroRepository.deleteById(id);
    }
}
