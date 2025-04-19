package com.example.walterbiblioteca.repositories;

import com.example.walterbiblioteca.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByNomeIgnoreCase(String nome); // Agora ignora maiúsculas/minúsculas
}
