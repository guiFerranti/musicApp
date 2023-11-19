package com.guilherme.MusicApp;

import com.guilherme.MusicApp.main.Main;
import com.guilherme.MusicApp.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicAppApplication implements CommandLineRunner {
	@Autowired
	private Repository repository;

	public static void main(String[] args) {
		SpringApplication.run(MusicAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(repository);
		main.main();
	}
}
