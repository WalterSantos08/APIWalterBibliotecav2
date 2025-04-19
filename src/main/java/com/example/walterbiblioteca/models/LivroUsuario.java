package com.example.walterbiblioteca.models;

import com.example.walterbiblioteca.enums.StatusDeLeitura;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "livro_id", nullable = false)
    private Livro livro;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_leitura", nullable = false)
    private StatusDeLeitura statusLeitura;

    // ✅ Agora com LocalDate (data simples, sem hora/fuso)
    private LocalDate dataInicio;
    private LocalDate dataFim;

    private int nota;

    @Column(columnDefinition = "TEXT")
    private String comentarios;

    @Column(name = "nome_usuario")
    private String nomeUsuario;

    @Column(name = "titulo_livro")
    private String tituloLivro;
}
