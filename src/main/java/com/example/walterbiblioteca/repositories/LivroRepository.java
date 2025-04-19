package com.example.walterbiblioteca.repositories;

import com.example.walterbiblioteca.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

    Optional<Livro> findByTituloIgnoreCase(String titulo); // Busca sem diferenciar maiúsculas/minúsculas
}
