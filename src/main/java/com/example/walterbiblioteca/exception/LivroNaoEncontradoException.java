package com.example.walterbiblioteca.exception;

public class LivroNaoEncontradoException extends RuntimeException {
    public LivroNaoEncontradoException(Integer id) {
        super("Livro com id " + id + " não encontrado.");
    }
}
