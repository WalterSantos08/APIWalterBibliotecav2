package com.example.walterbiblioteca.mappers;

import com.example.walterbiblioteca.dtos.LivroUsuarioDto;
import com.example.walterbiblioteca.models.Livro;
import com.example.walterbiblioteca.models.LivroUsuario;
import com.example.walterbiblioteca.models.Usuario;
import com.example.walterbiblioteca.repositories.LivroRepository;
import com.example.walterbiblioteca.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LivroUsuarioMapper {

    private final UsuarioRepository usuarioRepository;
    private final LivroRepository livroRepository;

    public LivroUsuario toEntity(LivroUsuarioDto dto) {
        Usuario usuario = usuarioRepository.findByNome(dto.nomeUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + dto.nomeUsuario()));

        Livro livro = livroRepository.findByTitulo(dto.tituloLivro())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado: " + dto.tituloLivro()));

        return new LivroUsuario(
                dto.id() != null ? dto.id() : 0,
                usuario,
                livro,
                dto.statusLeitura(),
                dto.dataInicio(),
                dto.dataFim(),
                dto.nota(),
                dto.comentarios(),
                usuario.getNome(),      // salva no banco
                livro.getTitulo()       // salva no banco

        );
    }

    public LivroUsuarioDto toDto(LivroUsuario entity) {
        return new LivroUsuarioDto(
                entity.getId(),
                entity.getUsuario().getNome(),
                entity.getLivro().getTitulo(),
                entity.getStatusLeitura(),
                entity.getDataInicio(),
                entity.getDataFim(),
                entity.getNota(),
                entity.getComentarios()
        );
    }
}
