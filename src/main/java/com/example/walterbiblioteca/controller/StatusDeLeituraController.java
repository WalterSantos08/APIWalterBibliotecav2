package com.example.walterbiblioteca.controller;

import com.example.walterbiblioteca.dtos.StatusDeLeituraDto;
import com.example.walterbiblioteca.service.StatusDeLeituraService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status-leitura")
@RequiredArgsConstructor
public class StatusDeLeituraController {

    private final StatusDeLeituraService statusService;

    @GetMapping
    public ResponseEntity<List<StatusDeLeituraDto>> listarTodos() {
        return ResponseEntity.ok(statusService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusDeLeituraDto> buscarPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(statusService.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<StatusDeLeituraDto> salvar(@Valid @RequestBody StatusDeLeituraDto dto) {
        return ResponseEntity.ok(statusService.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusDeLeituraDto> atualizar(@PathVariable Integer id, @Valid @RequestBody StatusDeLeituraDto dto) {
        try {
            return ResponseEntity.ok(statusService.atualizar(id, dto));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        statusService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
