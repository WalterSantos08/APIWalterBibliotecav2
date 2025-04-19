package com.example.walterbiblioteca.exception;

public class LivroJaExisteException extends RuntimeException {
    public LivroJaExisteException(String titulo) {
        super("Já existe um livro com o título: " + titulo);
    }
}
