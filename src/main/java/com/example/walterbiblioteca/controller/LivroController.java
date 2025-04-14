package com.example.walterbiblioteca.controllers;

import com.example.walterbiblioteca.dtos.LivroDto;
import com.example.walterbiblioteca.services.LivroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;

    // 🔍 GET /api/livros
    @GetMapping
    public ResponseEntity<List<LivroDto>> listarTodos() {
        return ResponseEntity.ok(livroService.listarTodos());
    }

    // 🔍 GET /api/livros/{id}
    @GetMapping("/{id}")
    public ResponseEntity<LivroDto> buscarPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(livroService.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // ➕ POST /api/livros
    @PostMapping
    public ResponseEntity<LivroDto> salvar(@Valid @RequestBody LivroDto dto) {
        return ResponseEntity.ok(livroService.salvar(dto));
    }

    // ✏️ PUT /api/livros/{id}
    @PutMapping("/{id}")
    public ResponseEntity<LivroDto> atualizar(@PathVariable Integer id, @Valid @RequestBody LivroDto dto) {
        try {
            return ResponseEntity.ok(livroService.atualizar(id, dto));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 🗑️ DELETE /api/livros/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
