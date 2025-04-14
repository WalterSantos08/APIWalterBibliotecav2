package com.example.walterbiblioteca.repositories;

import com.example.walterbiblioteca.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
