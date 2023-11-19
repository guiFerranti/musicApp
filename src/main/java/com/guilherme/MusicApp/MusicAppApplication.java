package com.guilherme.MusicApp;

import com.guilherme.MusicApp.main.Main;
import com.guilherme.MusicApp.repository.ArtistRepository;
import com.guilherme.MusicApp.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicAppApplication implements CommandLineRunner {
	@Autowired
	private ArtistRepository artistRepository;
	@Autowired
	private MusicRepository musicRepository;

	public static void main(String[] args) {
		SpringApplication.run(MusicAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(artistRepository, musicRepository);
		main.main();
	}
}
