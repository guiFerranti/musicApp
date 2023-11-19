package com.guilherme.MusicApp.repository;

import com.guilherme.MusicApp.models.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MusicRepository extends JpaRepository<Musica, Long> {

    @Query("SELECT m from Musica m ORDER BY m.artista.nome")
    List<Musica> todasAsMusicas();

    @Query("SELECT m from Musica m WHERE m.artista.id = :id")
    List<Musica> musicasPorArtista(Long id);

    @Query("SELECT m from Musica m WHERE m.nome ILIKE %:nome% AND m.artista.id = :id")
    Musica musicaPorNomeArtista(String nome, Long id);
}
