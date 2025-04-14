package com.example.walterbiblioteca.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private StatusDeLeitura statusLeitura;

    private java.sql.Date dataInicio;
    private java.sql.Date dataFim;
    private int nota;

    @Column(columnDefinition = "TEXT")
    private String comentarios;

}
