package com.example.walterbiblioteca.repositories;

import com.example.walterbiblioteca.models.LivroUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroUsuarioRepository extends JpaRepository<LivroUsuario, Integer> {
}
