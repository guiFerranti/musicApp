package com.guilherme.MusicApp.repository;

import com.guilherme.MusicApp.models.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArtistRepository extends JpaRepository<Artista, Long> {

    @Query("SELECT a FROM Artista a WHERE a.nome ILIKE %:nome%")
    Artista acharArtista(String nome);
    
}
