package com.guilherme.MusicApp.repository;

import com.guilherme.MusicApp.models.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repository extends JpaRepository<Artista, Long> {

    //List<Artista>

}
