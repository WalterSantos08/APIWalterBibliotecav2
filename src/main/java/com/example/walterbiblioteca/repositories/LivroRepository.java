package com.example.walterbiblioteca.repositories;

import com.example.walterbiblioteca.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
