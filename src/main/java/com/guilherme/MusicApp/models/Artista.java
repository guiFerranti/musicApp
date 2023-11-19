package com.guilherme.MusicApp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "artistas")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String nome;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    public Artista(){}

    public Artista(String nome, Tipo tipo){
        this.nome = nome;
        this.tipo = tipo;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
