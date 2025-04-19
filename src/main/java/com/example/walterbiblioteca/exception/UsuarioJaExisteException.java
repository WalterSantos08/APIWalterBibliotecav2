package com.example.walterbiblioteca.exception;

public class UsuarioJaExisteException extends RuntimeException {

    public UsuarioJaExisteException(String nome) {
        super("Já existe um usuário com o nome " + nome);
    }
}
