package com.example.walterbiblioteca.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException(Integer id) {
        super("Usuário com id " + id + " não encontrado.");
    }
}
