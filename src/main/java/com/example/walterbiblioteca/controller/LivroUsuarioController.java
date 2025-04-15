package com.example.walterbiblioteca.controller;

import com.example.walterbiblioteca.dtos.LivroUsuarioDto;
import com.example.walterbiblioteca.service.LivroUsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livro-usuario")
@RequiredArgsConstructor
public class LivroUsuarioController {

    private final LivroUsuarioService service;

    @PostMapping
    public ResponseEntity<LivroUsuarioDto> salvar(@Valid @RequestBody LivroUsuarioDto dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<LivroUsuarioDto>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroUsuarioDto> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroUsuarioDto> atualizar(@PathVariable Integer id, @Valid @RequestBody LivroUsuarioDto dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
